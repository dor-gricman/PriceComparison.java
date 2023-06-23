package Selenium.Tests;

import Selenium.Pages.HaziHinamHomePage;
import Selenium.Pages.HaziHinamProductPage;
import Selenium.Utils.SeleniumDriver;
import Selenium.Utils.UrlsManager;
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


        driver.get(UrlsManager.haziHinamUrl);
        String productName = "פלפל אדום";
        HaziHinamHomePage.performSearch(wait, productName);
        String productId = HaziHinamProductPage.getProductId(wait);
        Assertions.assertEquals("12872", productId, "Failed to find the desired product in Hazi Hinam");
        System.out.println("Product found successfully");
        SeleniumDriver.quitDriver(driver);
    }
}
