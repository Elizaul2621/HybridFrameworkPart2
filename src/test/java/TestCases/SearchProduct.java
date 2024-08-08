package TestCases;


import ExtentReport.ExtentReporters;
import Pages.SearchProductPage;
import TestBase.TestBase;
import com.aventstack.extentreports.ExtentTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchProduct extends TestBase {
        public SearchProduct() throws Exception {
            super();
        }
        ExtentReporters extent;
        ExtentTest test;
        public WebDriver driver;
        public SearchProductPage searchProductPage;

        @BeforeMethod
        public void searchProductPage(){
            driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
        }
        @Test(priority = 1)
        public void verifySearchBoxFieldBoxIsPresentInSearchPage(){
            searchProductPage = new SearchProductPage(driver);
            Assert.assertTrue(searchProductPage.searchResultsForProductIsDisplayed());
        }
        @Test(priority = 2)
        public void verifySearchButtonIsClickable(){
            searchProductPage= new SearchProductPage(driver);
            searchProductPage.enterToSearchBoxTextField(dataProp.getProperty("product1"));
            searchProductPage.clickOnSearchButton();
        }
        @Test(priority= 3)
        public void verifySearchMatchesItemDisplayed(){
            searchProductPage= new SearchProductPage(driver);
            searchProductPage.enterToSearchBoxTextField(dataProp.getProperty("product1"));
            searchProductPage.clickOnSearchButton();
            Assert.assertTrue(searchProductPage.searchResultsForProductIsDisplayed());
        }
        @AfterMethod
        public void tearDown() {
            driver.quit();
        }
    }

