package Selenium.Supermarkets.HaziHinam;

import Selenium.Supermarkets.HaziHinam.Pages.HaziHinamProductPage;
import Selenium.Supermarkets.HaziHinam.Pages.HaziHinamHomePage;
import Selenium.Supermarkets.Products;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.TimeoutException;

public class HaziHinamMain {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public HaziHinamMain(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void getProductPrices(List<Products> products) throws InterruptedException {
        driver.get("https://shop.hazi-hinam.co.il/");

        for (Products product : products) {
            String productName = product.getHebrewName();
            try {
                HaziHinamHomePage.performSearch(wait, productName);
                double productPrice = HaziHinamProductPage.getProductPrice(wait);
                product.setHaziHinamPrice(productPrice);
            } catch (TimeoutException e) {
                System.out.println("לא נמצא המוצר " + productName + "." +
                        "אנא ודא כי הקלדת את שם המוצר ברשת חצי חינם נכון.");
            }
        }
    }
}
