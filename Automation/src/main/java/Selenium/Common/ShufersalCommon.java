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

        for (Products product : products) {// Iterate over the products list
            String shufersalProductName = product.getShufersalProductName();
            String productName;

            if (shufersalProductName.length() > 0) {// If the product has a specific name in Shufersal, use it
                productName = shufersalProductName;
            } else {// Otherwise, use the product name
                productName = product.getProductName();
            }
            try {

                ShufersalHomePage.performSearch(wait, productName);// Search for the product in Shufersal
                ShufersalSearchResultPage.selectProduct(wait, productName);// Select the product from the search results
                double productPrice = ShufersalProductPage.getProductPrice(wait);// Get the product price
                product.setShufersalPrice(productPrice);// Set the product price
                ShufersalProductPage.closeProductWindow(driver);// Close the product window
                ShufersalHomePage.clearSearchWindow(wait);// Clear the search window

            } catch (TimeoutException e) {
                System.out.println("לא נמצא המוצר " + productName + "." +
                        "אנא ודא כי הקלדת את שם המוצר ברשת שופרסל נכון.");
            }

        }
    }
}

