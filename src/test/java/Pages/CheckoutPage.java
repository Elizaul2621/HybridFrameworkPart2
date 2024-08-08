package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {

    public WebDriver driver;
    public Select dropdown;

    @FindBy(name = "firstname")
    private WebElement firstNameField;
    @FindBy(name = "lastname")
    private WebElement lastNameField;
    @FindBy(name = "address_1")
    private WebElement addressField;
    @FindBy(name = "city")
    private WebElement cityField;
    @FindBy(name = "postcode")
    private WebElement postCodeField;
    @FindBy(name = "country_id")
    private WebElement countryDropDown;
    @FindBy(name = "zone_id")
    private WebElement regionStateDropDown;
    @FindBy(css = "#button-payment-address")
    private WebElement continueBilling;
    @FindBy(css = "#collapse-payment-address > div > form > div:nth-child(3) > label > input[type=radio]")
    private WebElement newAddressRadio;
    @FindBy(css = "#button-shipping-address")
    private WebElement continueDeliveryButton;
    @FindBy(css = "#button-shipping-method")
    private WebElement continueDeliveryMethodButton;
    @FindBy(xpath = "//input[@name = 'agree']")
    private WebElement clickTermsAndCondition;
    @FindBy(id ="button-payment-method")
    private WebElement continuePaymentButton;
    @FindBy(css = "#button-confirm")
    private WebElement clickOnConfirm;
    @FindBy(css = "#content > h1")
    private WebElement orderPlaced;



    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void firstNameFieldInBilling(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void lastNameFieldBilling(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void addressFieldBilling(String addressText) {
        addressField.sendKeys(addressText);
    }

    public void cityFieldBilling(String cityText) {
        cityField.sendKeys(cityText);
    }

    public void postalCodeBilling(String postalCode) {
        postCodeField.sendKeys(postalCode);
    }

    public void selectCountry() {
        countryDropDown.click();
    }

    public void UnitedStatesViaDropdown(String country) {
        dropdown = new Select(countryDropDown);
        dropdown.selectByValue(country);

    }

    public void selectRegion() {
        regionStateDropDown.click();
    }

    public void newYorkViaDropdown(String region) {
        dropdown = new Select(regionStateDropDown);
        dropdown.selectByValue(region);
    }

    public void clickOnContinueButtonBillingDetails() {
        continueBilling.click();
    }

    public void clickOnNewAddressRadioButton() {
        newAddressRadio.click();
    }

    public void clickOnContinueButtonForDeliveryDetails() {
        continueDeliveryButton.click();
    }

    public void clickOnContinueButtonForDeliveryMethod() {
        continueDeliveryMethodButton.click();
    }
    public void acceptTermsAndConditionsInPaymentMethod(){
        clickTermsAndCondition.click();
    }
    public void clickOnContinueButtonInPaymentMethod(){
        continuePaymentButton.click();
    }
    public void clickOnConfirmOrderButton(){
        clickOnConfirm.click();
    }
    public boolean confirmOrderWasPlaced(){
        boolean display = orderPlaced.isDisplayed();
        return display;
    }

}
