package Selenium.Common;

import java.time.Duration;
import java.util.List;


import Selenium.Pages.ShufersalHomePage;
import Selenium.Pages.ShufersalProductPage;
import Selenium.Pages.ShufersalSearchResultPage;
import Selenium.Utils.Products;
import Selenium.Utils.UrlsManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShufersalCommon {
    WebDriverWait wait;
    private final WebDriver driver;

    public ShufersalCommon(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void getProductPrices(List<Products> products) throws InterruptedException {
        driver.get(UrlsManager.shufersalUrl);

        for (Products product : products) {
            String shufersalProductName = product.getShufersalProductName();
            String productName;

            if (shufersalProductName.length() > 0) {
                productName = shufersalProductName;
            } else {
                productName = product.getProductName();
            }
            try {

                ShufersalHomePage.performSearch(wait, productName);
                ShufersalSearchResultPage.selectProduct(wait, productName);
                double productPrice = ShufersalProductPage.getProductPrice(wait);
                product.setShufersalPrice(productPrice);
                ShufersalProductPage.closeProductWindow(driver);
                ShufersalHomePage.clearSearchWindow(wait);

            } catch (TimeoutException e) {
                System.out.println("לא נמצא המוצר " + productName + "." +
                        "אנא ודא כי הקלדת את שם המוצר ברשת שופרסל נכון.");
            }

        }
    }
}

