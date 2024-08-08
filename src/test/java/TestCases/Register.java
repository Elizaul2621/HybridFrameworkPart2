package TestCases;


import Pages.HomePage;
import Pages.RegistrationPage;
import TestBase.TestBase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Register extends TestBase {
        public Register() throws Exception {
            super();
        }

        public WebDriver driver;
        public HomePage homepage;
        public RegistrationPage registrationPage;

        @BeforeMethod
        public void startUp() {
            driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
            homepage = new HomePage(driver);
            homepage.clickMyAccountDropDown();
            homepage.clickOnRegisterLink();
        }

        @Test(priority = 1)
        public void verifySuccessfulLoginWithValidCredentials() {
            registrationPage = new RegistrationPage(driver);
            registrationPage.enterFirstNameIntoFieldBox(dataProp.getProperty("firstName"));
            registrationPage.enterLastNameIntoFieldBox(dataProp.getProperty("lastName"));
            registrationPage.enterEmailIntoFieldBox();
            registrationPage.enterTelephoneIntoFieldBox(dataProp.getProperty("telephone"));
            registrationPage.enterPasswordIntoFieldBox(dataProp.getProperty("password"));
            registrationPage.enterConfirmPasswordIntoFieldBox(dataProp.getProperty("confirmPassword"));
            registrationPage.clickOnPrivacyPolicyCheckBox();
            registrationPage.clickOnContinueButton();
            Assert.assertTrue(registrationPage.accountCreatedIsDisplayed());
        }
        @Test(priority = 2)
        public void veryWarningMessageForEmptyFirstNameCredential(){
            registrationPage = new RegistrationPage(driver);
            registrationPage.enterLastNameIntoFieldBox(dataProp.getProperty("lastName"));
            registrationPage.enterEmailIntoFieldBox();
            registrationPage.enterTelephoneIntoFieldBox(dataProp.getProperty("telephone"));
            registrationPage.enterPasswordIntoFieldBox(dataProp.getProperty("password"));
            registrationPage.enterConfirmPasswordIntoFieldBox(dataProp.getProperty("confirmPassword"));
            registrationPage.clickOnPrivacyPolicyCheckBox();
            registrationPage.clickOnContinueButton();
           Assert.assertTrue(registrationPage.emptyFirstNameFieldBox());
        }
        @Test(priority = 3)
        public void verifyWarningMessageForLastNameCredential(){
            registrationPage = new RegistrationPage(driver);
            registrationPage.enterFirstNameIntoFieldBox(dataProp.getProperty("firstName"));
            registrationPage.enterEmailIntoFieldBox();
            registrationPage.enterTelephoneIntoFieldBox(dataProp.getProperty("telephone"));
            registrationPage.enterPasswordIntoFieldBox(dataProp.getProperty("password"));
            registrationPage.enterConfirmPasswordIntoFieldBox(dataProp.getProperty("confirmPassword"));
            registrationPage.clickOnPrivacyPolicyCheckBox();
            registrationPage.clickOnContinueButton();
            Assert.assertTrue(registrationPage.emptyLastNameFieldBox());
        }
        @Test(priority = 4)
        public void verifyWarningMessageForEmptyEmailCredential(){
            registrationPage = new RegistrationPage(driver);
            registrationPage.enterFirstNameIntoFieldBox(dataProp.getProperty("firstName"));
            registrationPage.enterLastNameIntoFieldBox(dataProp.getProperty("lastName"));
            registrationPage.enterTelephoneIntoFieldBox(dataProp.getProperty("telephone"));
            registrationPage.enterPasswordIntoFieldBox(dataProp.getProperty("password"));
            registrationPage.enterConfirmPasswordIntoFieldBox(dataProp.getProperty("confirmPassword"));
            registrationPage.clickOnPrivacyPolicyCheckBox();
            registrationPage.clickOnContinueButton();
            Assert.assertTrue(registrationPage.emptyEmailFieldBox());
        }
        @Test(priority = 5)
        public void verifyWarningMessageForEmptyTelephoneCredential(){
            registrationPage = new RegistrationPage(driver);
            registrationPage.enterFirstNameIntoFieldBox(dataProp.getProperty("firstName"));
            registrationPage.enterLastNameIntoFieldBox(dataProp.getProperty("lastName"));
            registrationPage.enterEmailIntoFieldBox();
            registrationPage.enterPasswordIntoFieldBox(dataProp.getProperty("password"));
            registrationPage.enterConfirmPasswordIntoFieldBox(dataProp.getProperty("confirmPassword"));
            registrationPage.clickOnPrivacyPolicyCheckBox();
            registrationPage.clickOnContinueButton();
            Assert.assertTrue(registrationPage.emptyTelephoneFieldBox());
        }
        @Test(priority = 6)
        public void verifyErrorMessageForEmptyPasswordField(){
            registrationPage = new RegistrationPage(driver);
            registrationPage.enterFirstNameIntoFieldBox(dataProp.getProperty("firstName"));
            registrationPage.enterLastNameIntoFieldBox(dataProp.getProperty("lastName"));
            registrationPage.enterEmailIntoFieldBox();
            registrationPage.enterTelephoneIntoFieldBox(dataProp.getProperty("telephone"));
            registrationPage.enterConfirmPasswordIntoFieldBox(dataProp.getProperty("confirmPassword"));
            registrationPage.clickOnPrivacyPolicyCheckBox();
            registrationPage.clickOnContinueButton();
            Assert.assertTrue(registrationPage.emptyPasswordFieldBox());
        }
        @Test(priority = 7)
        public void verifyWarningForPasswordsNotMatching(){
            registrationPage = new RegistrationPage(driver);
            registrationPage.enterFirstNameIntoFieldBox(dataProp.getProperty("firstName"));
            registrationPage.enterLastNameIntoFieldBox(dataProp.getProperty("lastName"));
            registrationPage.enterEmailIntoFieldBox();
            registrationPage.enterTelephoneIntoFieldBox(dataProp.getProperty("telephone"));
            registrationPage.enterPasswordIntoFieldBox(dataProp.getProperty("password"));
            registrationPage.enterConfirmPasswordIntoFieldBox(dataProp.getProperty("invalidPassword"));
            registrationPage.clickOnPrivacyPolicyCheckBox();
            registrationPage.clickOnContinueButton();
            Assert.assertTrue(registrationPage.mismatchPasswordWarningMessage());

        }
        @AfterMethod
        public void tearDown(){
            driver.quit();
        }
}
