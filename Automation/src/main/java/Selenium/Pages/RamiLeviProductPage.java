package Selenium.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import static Selenium.Utils.TextConverter.*;

public class RamiLeviProductPage {// This class is used to perform actions on the Rami Levi product page

    public static double getProductPrice(WebDriverWait wait) throws InterruptedException {// This method is used to get the price of a product in Rami Levi
        WebElement productPriceSelector = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='xl2-text mr-4 blue line-height-1-2 d-flex align-items-baseline price-text']/span[@class='position-relative currency-wrap overflow-ellipsis']/span")));// Select the price of the product
        Thread.sleep(4000);
        return convertTextToDouble(productPriceSelector);// Convert the price to double
    }

    public static void closeProductWindow(WebDriver driver) {// This method is used to close the product window
        WebElement closeProduct = driver.findElement(By.id("close-popup"));
        closeProduct.click();
    }

    public static String getRLProductId(WebDriverWait wait) throws InterruptedException {// This method is used to get the ID of a product in Rami Levi
        WebElement productId = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("barcode")));
        Thread.sleep(4000);
        return convertTextToRLProductId(productId);// Convert the ID to string
    }
}
