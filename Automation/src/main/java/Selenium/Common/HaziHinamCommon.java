package Selenium.Common;

import Selenium.Pages.HaziHinamHomePage;
import Selenium.Pages.HaziHinamProductPage;
import Selenium.Utils.Products;
import Selenium.Utils.UrlsManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.TimeoutException;

public class HaziHinamCommon {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public HaziHinamCommon(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void getProductPrices(List<Products> products) throws InterruptedException {
        driver.get(UrlsManager.haziHinamUrl);

        for (Products product : products) {
            String hzaHinamProductName = product.getHaziHinamProductName();
            String productName;
            if (hzaHinamProductName.length() > 0) {
                productName = hzaHinamProductName;
            } else {
                productName = product.getProductName();
            }
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
