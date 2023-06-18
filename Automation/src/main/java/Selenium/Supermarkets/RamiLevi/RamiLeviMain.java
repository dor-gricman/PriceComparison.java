package Selenium.Supermarkets.RamiLevi;

import Selenium.Supermarkets.Products;
import Selenium.Supermarkets.RamiLevi.Pages.RamiLeviHomePage;
import Selenium.Supermarkets.RamiLevi.Pages.RamiLeviProductPage;
import Selenium.Supermarkets.RamiLevi.Pages.RamiLeviSearchResultPage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RamiLeviMain {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public RamiLeviMain(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void getProductPrices(List<Products> products) throws InterruptedException {
        driver.get("https://www.rami-levy.co.il/he");

        for (Products product : products) {
            String productName = product.getHebrewName();
            try {
                RamiLeviHomePage.performSearch(wait, productName);
                RamiLeviSearchResultPage.selectProduct(wait, productName);
                double productPrice = RamiLeviProductPage.getProductPrice(wait);
                product.setRamiLeviPrice(productPrice);
                RamiLeviProductPage.closeProductWindow(driver);
            } catch (TimeoutException e) {
                System.out.println("לא נמצא המוצר " + productName + "." +
                        "אנא ודא כי הקלדת את שם המוצר ברשת רמי לוי נכון.");
            }
        }
    }
}
