package RamiLeviTests;

import Selenium.Supermarkets.RamiLevi.Pages.RamiLeviProductPage;
import Selenium.Supermarkets.RamiLevi.Pages.RamiLeviSearchResultPage;
import Selenium.Utils.SeleniumDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import Selenium.Supermarkets.RamiLevi.Pages.RamiLeviHomePage;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RLProductSearchTest {
WebDriverWait wait;
    @Test
    public void productSearchTest() throws InterruptedException {
        ChromeDriver driver = SeleniumDriver.initializeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String url = "https://www.rami-levy.co.il/he";
        driver.get(url);
        String productName = "מלפפון";
        RamiLeviHomePage.performSearch(wait, productName);
        RamiLeviSearchResultPage.selectProduct(wait, productName);
        String productId = RamiLeviProductPage.getRLProductId(wait);
        Assertions.assertEquals("101", productId);
        SeleniumDriver.quitDriver(driver);
    }
}
