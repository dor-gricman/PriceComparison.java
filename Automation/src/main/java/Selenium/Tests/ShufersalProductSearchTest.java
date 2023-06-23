package Selenium.Tests;

import Selenium.Pages.ShufersalHomePage;
import Selenium.Pages.ShufersalProductPage;
import Selenium.Pages.ShufersalSearchResultPage;
import Selenium.Utils.SeleniumDriver;
import Selenium.Utils.UrlsManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ShufersalProductSearchTest {// This class is used to test the product search functionality in Shufersal
    WebDriverWait wait;

    @Test
    public void productSearchTest() throws InterruptedException {
        ChromeDriver driver = SeleniumDriver.initializeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get(UrlsManager.shufersalUrl);
        String productName = "בצל יבש";
        ShufersalHomePage.performSearch(wait, productName);
        ShufersalSearchResultPage.selectProduct(wait, productName);
        Thread.sleep(2000);
        String productId = ShufersalProductPage.getProductId(driver);
        Assertions.assertEquals("480", productId, "Failed to find the desired product in Shufersal");// Assert that the product ID is the desired one
        System.out.println("Product found successfully");

        SeleniumDriver.quitDriver(driver);
    }
}