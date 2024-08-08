package ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ExtentReporters {

    public static ExtentReports generateExtentReporter() throws Exception {

        ExtentReports extentReport = new ExtentReports();
        File extentReportFile = new File(System.getProperty("user.dir") + "\\TestOutput\\ExtentReport\\extentReporterTutorialsNinja.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);

        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("TutrialsNinja REGRESSION Test");
        sparkReporter.config().setDocumentTitle("BootCamp Part2 Hybrid Framework");
        sparkReporter.config().setTimeStampFormat("MM/dd/yyyy hh:mm:ss");

        extentReport.attachReporter(sparkReporter);

        Properties prop = new Properties();
        FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\java\\Configuration\\config.properties");
        prop.load(ip);

        extentReport.setSystemInfo("application url", prop.getProperty("url"));
        extentReport.setSystemInfo("browser name ", prop.getProperty("browser"));
        extentReport.setSystemInfo("email", prop.getProperty("validEmail"));
        extentReport.setSystemInfo("password", prop.getProperty("validPassword"));
        extentReport.setSystemInfo("Operating System", prop.getProperty("os.name"));
        extentReport.setSystemInfo("java version", prop.getProperty("java.version"));
        extentReport.setSystemInfo("SDET Name", prop.getProperty("user.name"));
        extentReport.setSystemInfo("SDET CountryName", prop.getProperty("user.country"));

        return extentReport;
    }


}

