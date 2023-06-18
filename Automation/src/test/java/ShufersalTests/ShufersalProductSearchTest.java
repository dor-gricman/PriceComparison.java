package ShufersalTests;

import Selenium.Supermarkets.Shufersal.Pages.ShufersalHomePage;
import Selenium.Supermarkets.Shufersal.Pages.ShufersalProductPage;
import Selenium.Supermarkets.Shufersal.Pages.ShufersalSearchResultPage;
import Selenium.Utils.SeleniumDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ShufersalProductSearchTest {
    WebDriverWait wait;

    @Test
    public void productSearchTest() throws InterruptedException {
        ChromeDriver driver = SeleniumDriver.initializeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String url = "https://www.shufersal.co.il/online/";
        driver.get(url);
        String productName = "בצל יבש";
        ShufersalHomePage.performSearch(wait, productName);
        ShufersalSearchResultPage.selectProduct(wait, productName);
        Thread.sleep(2000);
        String productId = ShufersalProductPage.getProductId(driver);
        Assertions.assertEquals("480", productId);
        SeleniumDriver.quitDriver(driver);
    }
}

