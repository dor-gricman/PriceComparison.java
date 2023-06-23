package Selenium.Common;

import Selenium.Pages.RamiLeviHomePage;
import Selenium.Pages.RamiLeviProductPage;
import Selenium.Pages.RamiLeviSearchResultPage;
import Selenium.Utils.Products;
import Selenium.Utils.UrlsManager;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RamiLeviCommon {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public RamiLeviCommon(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void getProductPrices(List<Products> products) throws InterruptedException {
        driver.get(UrlsManager.ramiLeviUrl);
        // Iterate over the products list
        for (Products product : products) {
            String ramiLeviProductName = product.getRamiLeviProductName();
            String productName;
            if (ramiLeviProductName.length() > 0) {// If the product has a specific name in Rami Levi, use it
                productName = ramiLeviProductName;
            } else {// Otherwise, use the product name
                productName = product.getProductName();
            }

            try {
                RamiLeviHomePage.performSearch(wait, productName);// Search for the product in Rami Levi
                RamiLeviSearchResultPage.selectProduct(wait, productName);// Select the product from the search results
                double productPrice = RamiLeviProductPage.getProductPrice(wait);// Get the product price
                product.setRamiLeviPrice(productPrice);// Set the product price
                RamiLeviProductPage.closeProductWindow(driver);// Close the product window

            } catch (TimeoutException e) {
                System.out.println("לא נמצא המוצר " + productName + "." +
                        "אנא ודא כי הקלדת את שם המוצר ברשת רמי לוי נכון.");
            }
        }
    }
}
