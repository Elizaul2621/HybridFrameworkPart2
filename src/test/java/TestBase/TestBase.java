package TestBase;

import Utilities.Utils;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class TestBase {

    public WebDriver driver;
    public Properties prop;

    public Properties dataProp;

    public FileInputStream ip1;
    public FileInputStream ip;
    public ChromeOptions options;

    public TestBase() throws Exception {
        prop = new Properties();
        ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\Config\\config.properties");
        prop.load(ip);
        dataProp = new Properties();
        ip1 = new FileInputStream(System.getProperty("user.dir")+ "");
        dataProp.load(ip1);
    }

    public org.openqa.selenium.WebDriver initializeBrowserAndOpenApplication(String browser) {
        if (browser.equals("Chrome")) {
            options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
            options.addArguments("--start-maximized");
            options.addArguments("--incognito");
            options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "disable-infobars"));
            driver = new ChromeDriver(options);

        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else if (browser.equals("Edge")) {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        } else if (browser.equals("Safari")) {
            driver = new SafariDriver();
            driver.manage().window().maximize();
        } else {
            System.out.println("Browser Not matching");

        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utils.IMPLICIT_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utils.PAGELOAD_TIMEOUT));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Utils.SCRIPT_TIMEOUT));
        driver.get(prop.getProperty("url"));
        return driver;

    }

}

