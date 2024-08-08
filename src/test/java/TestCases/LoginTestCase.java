package TestCases;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import TestBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestCase extends TestBase {

    public LoginTestCase() throws Exception {
        super();
    }
    public WebDriver driver;
    public HomePage homepage;
   public LoginPage loginPage;
    public MyAccountPage myAccountPage;




    @BeforeMethod
    public void loginSetup(){

        driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
        homepage = new HomePage(driver);
        homepage.clickMyAccountDropDown();
        homepage.clickloginLink();
    }
    @Test(priority = 1)
    public void verifyLoginWithValidCredentials(){
       loginPage   = new LoginPage(driver);
        loginPage.enterEmail(prop.getProperty("validEmail"));
        loginPage.enterPassword(prop.getProperty("validPassword"));
        loginPage.clickOnLoginButton();
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.editAccountInfoLinkIsDisplayed();

    }


    @Test(priority = 3)
    public void loginWithInvalidEmailValidPassword(){
        loginPage = new LoginPage(driver);
        loginPage.enterEmail(dataProp.getProperty("invalidEmail"));
        loginPage.enterPassword(prop.getProperty("validPassword"));
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.retrieveWarningEmailPasswordMismatchText());

    }
    @Test(priority = 4)
    public void loginWithValidEmailInvalidPassword() {
        loginPage = new LoginPage(driver);
        loginPage.enterEmail(prop.getProperty("validEmail"));
        loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.retrieveWarningEmailPasswordMismatchText());
    }
    @Test(priority = 5)
    public void loginWithInvalidEmailInvalidPassword(){
        loginPage = new LoginPage(driver);
        loginPage.enterEmail(dataProp.getProperty("invalidEmail"));
        loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.retrieveWarningEmailPasswordMismatchText());
    }


    @Test
    @AfterMethod
    public void tearDOwn(){
        driver.quit();
    }
}
