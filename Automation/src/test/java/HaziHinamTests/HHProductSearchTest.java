package HaziHinamTests;

import Selenium.Supermarkets.HaziHinam.Pages.HaziHinamHomePage;
import Selenium.Supermarkets.HaziHinam.Pages.HaziHinamProductPage;
import Selenium.Utils.SeleniumDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HHProductSearchTest {
WebDriverWait wait;

    @Test
    public void productSearchTest() throws InterruptedException {
        ChromeDriver driver = SeleniumDriver.initializeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String url = "https://www.hazi-hinam.co.il/";
        driver.get(url);
        String productName = "פלפל אדום";
        HaziHinamHomePage.performSearch(wait, productName);
        String productId = HaziHinamProductPage.getProductId(wait);
        Assertions.assertEquals("12872", productId);
        SeleniumDriver.quitDriver(driver);
    }
}
