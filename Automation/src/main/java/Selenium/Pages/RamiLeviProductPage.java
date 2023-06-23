package Selenium.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import static Selenium.Utils.TextConverter.*;

public class RamiLeviProductPage {

    public static double getProductPrice(WebDriverWait wait) throws InterruptedException {
        WebElement productPriceSelector = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='xl2-text mr-4 blue line-height-1-2 d-flex align-items-baseline price-text']/span[@class='position-relative currency-wrap overflow-ellipsis']/span")));
        Thread.sleep(4000);
        return convertTextToDouble(productPriceSelector);
    }

    public static void closeProductWindow(WebDriver driver) {
        WebElement closeProduct = driver.findElement(By.id("close-popup"));
        closeProduct.click();
    }

    public static String getRLProductId(WebDriverWait wait) throws InterruptedException {
        WebElement productId = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("barcode")));
        Thread.sleep(4000);
        return convertTextToRLProductId(productId);
    }
}
