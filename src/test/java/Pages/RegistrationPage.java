package Pages;

import Utilities.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



    public class RegistrationPage {

        public WebDriver driver;

        @FindBy(name = "firstname")
        private WebElement FirstNameFieldBox;

        @FindBy(name = "lastname")
        private WebElement LastNameFieldBox;

        @FindBy(name = "email")
        private WebElement emailFieldBox;

        @FindBy(name = "telephone")
        private WebElement telephoneFieldBox;

        @FindBy(name = "password")
        private WebElement passwordFieldBox;

        @FindBy(name = "confirm")
        private WebElement confirmPasswordFieldBox;

        @FindBy(name = "agree")
        private WebElement privacyPolicyConfirm;

        @FindBy(css = "input.btn.btn-primary")
        private WebElement clickOnContinue;

        @FindBy(css ="#content > h1")
        private WebElement accountCreated;

        @FindBy(css = "#account > div:nth-child(3) > div > div")
        public WebElement emptyFirstNameField;

        @FindBy(css = "#account > div:nth-child(4) > div > div")
        public WebElement emptyLastNameField;

        @FindBy(css = "#account > div:nth-child(5) > div > div")
        public WebElement emptyEmailField;

        @FindBy(css ="#account > div:nth-child(6) > div > div")
        public WebElement emptyTelephoneField;

        @FindBy(css = "#content > form > fieldset:nth-child(2) > div.form-group.required.has-error > div > div")
        private WebElement emptyPasswordField;

        @FindBy(css = "#content > form > fieldset:nth-child(2) > div.form-group.required.has-error > div > div")
        private WebElement passwordDoesNotMatch;


        public RegistrationPage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        public void enterFirstNameIntoFieldBox(String firstNameText) {
            FirstNameFieldBox.sendKeys(firstNameText);
        }

        public void enterLastNameIntoFieldBox(String lastNameText) {
            LastNameFieldBox.sendKeys(lastNameText);
        }

        public void enterEmailIntoFieldBox() {
            emailFieldBox.sendKeys(Utils.emailWithDateTimeStamp());
        }

        public void enterTelephoneIntoFieldBox(String telephoneText) {
            telephoneFieldBox.sendKeys(telephoneText);
        }

        public void enterPasswordIntoFieldBox(String passwordText) {
            passwordFieldBox.sendKeys(passwordText);
        }

        public void enterConfirmPasswordIntoFieldBox(String confirmPasswordText) {
            confirmPasswordFieldBox.sendKeys(confirmPasswordText);
        }

        public void clickOnPrivacyPolicyCheckBox() {
            privacyPolicyConfirm.click();
        }

        public void clickOnContinueButton() {
            clickOnContinue.click();
        }
        public boolean emptyFirstNameFieldBox(){
            boolean display = emptyFirstNameField.isDisplayed();
            return display;
        }

        public boolean emptyLastNameFieldBox(){
            boolean display = emptyLastNameField.isDisplayed();
            return display;
        }
        public boolean emptyEmailFieldBox(){
            boolean display = emptyEmailField.isDisplayed();
            return display;

        }
        public boolean emptyTelephoneFieldBox(){
            boolean display = emptyTelephoneField.isDisplayed();
            return display;
        }
        public boolean emptyPasswordFieldBox(){
            boolean display = emptyPasswordField.isDisplayed();
            return display;

        }
        public boolean mismatchPasswordWarningMessage(){
            boolean display = passwordDoesNotMatch.isDisplayed();
            return display;

        }

        public boolean accountCreatedIsDisplayed(){
            boolean display = accountCreated.isDisplayed();
            return display;

        }
    }


