package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver driver;


    @FindBy(linkText = "My Account")
    private WebElement myAccountDropDown;

    @FindBy(linkText = "Login")
    private WebElement loginLink;

    @FindBy(linkText = "Register")
    private WebElement registerLink;

    @FindBy(linkText = "Desktops")
    private WebElement homePageElement;

    @FindBy(linkText = "Laptops & Notebooks")
    private WebElement linkOnHomePage;





    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickMyAccountDropDown(){myAccountDropDown.click();}
    public void clickloginLink(){loginLink.click();}
    public void clickOnRegisterLink(){registerLink.click();}
    public void clickOnLinkOnHomepage(){linkOnHomePage.click();}
    public boolean elementPresentOnHomePage(){
        boolean display = homePageElement.isDisplayed();
        return display;

    }


}
