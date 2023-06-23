package Selenium.Tests;

import Selenium.Pages.RamiLeviProductPage;
import Selenium.Pages.RamiLeviSearchResultPage;
import Selenium.Utils.SeleniumDriver;
import Selenium.Utils.UrlsManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import Selenium.Pages.RamiLeviHomePage;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RLProductSearchTest {
WebDriverWait wait;
    @Test
    public void productSearchTest() throws InterruptedException {
        ChromeDriver driver = SeleniumDriver.initializeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get(UrlsManager.ramiLeviUrl);
        String productName = "מלפפון";
        RamiLeviHomePage.performSearch(wait, productName);
        RamiLeviSearchResultPage.selectProduct(wait, productName);
        String productId = RamiLeviProductPage.getRLProductId(wait);
        Assertions.assertEquals("101", productId, "Failed to find the desired product in Rami Levi");
        System.out.println("Product found successfully");
        SeleniumDriver.quitDriver(driver);
    }
}
