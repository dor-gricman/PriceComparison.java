package Selenium.Supermarkets.Shufersal;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import Selenium.Supermarkets.Products;
import Selenium.Supermarkets.Shufersal.Pages.ShufersalHomePage;
import Selenium.Supermarkets.Shufersal.Pages.ShufersalProductPage;
import Selenium.Supermarkets.Shufersal.Pages.ShufersalSearchResultPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShufersalMain {
    WebDriverWait wait;
    private final WebDriver driver;

    public ShufersalMain(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void getProductPrices(List<Products> products) throws InterruptedException {
        driver.get("https://www.shufersal.co.il/online/");

        for (Products product : products) {
            String productName = product.getHebrewName();
            try {
                ShufersalHomePage.performSearch(wait, productName);
                ShufersalSearchResultPage.selectProduct(wait, productName);
                double productPrice = ShufersalProductPage.getProductPrice(wait);
                product.setShufersalPrice(productPrice);
                ShufersalProductPage.closeProductWindow(driver);
                ShufersalHomePage.clearSearchWindow(wait);
            } catch (NoSuchElementException e) {
                System.out.println("לא נמצא מוצר.");
            } catch (TimeoutException e) {
                System.out.println("לא נמצא המוצר " + productName + "." +
                        "אנא ודא כי הקלדת את שם המוצר ברשת שופרסל נכון.");
            }

        }
    }
}
