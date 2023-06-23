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

        for (Products product : products) {
            String ramiLeviProductName = product.getRamiLeviProductName();
            String productName;
            if (ramiLeviProductName.length() > 0) {
                productName = ramiLeviProductName;
            } else {
                productName = product.getProductName();
            }

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
