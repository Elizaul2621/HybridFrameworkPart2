package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProductPage {

    public WebDriver driver;

    @FindBy(name = "search")
    private WebElement searchBox;

    @FindBy(css = "#search > span > button")
    private WebElement searchButton;

    @FindBy(xpath = "//button[@type = 'button']/i/following::span[@class = 'hidden-xs hidden-sm hidden-md']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//*[@id= 'content']/div[3]/div/div/div[2]/div[1]/h4/a")
    private WebElement productSearchIsDisplayed;

    @FindBy(xpath = "//*[@id= 'content']/div[3]/div/div/div[2]/div[1]/h4/a")
    private WebElement clickOnProductForDetails;

    public SearchProductPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }
    public void enterToSearchBoxTextField(String product){searchBox.sendKeys(product);}
    public void clickOnSearchButton(){searchButton.click();}
    public void clickOnAddToCart(){addToCartButton.click();}
    public void navigateToProductPage(){clickOnProductForDetails.click();}
    public boolean searchResultsForProductIsDisplayed(){
        boolean display = productSearchIsDisplayed.isDisplayed();
        return display;

    }

}
