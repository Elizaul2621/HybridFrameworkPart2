package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    public WebDriver driver;

    @FindBy(linkText = "Edit your account information")
    private WebElement editAccountInfoLInk;

    public MyAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean editAccountInfoLinkIsDisplayed(){
        boolean display = editAccountInfoLInk.isDisplayed();
        return display;

    }
}
