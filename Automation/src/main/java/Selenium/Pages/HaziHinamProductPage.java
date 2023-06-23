package Selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Selenium.Utils.TextConverter.convertTextToDouble;
import static Selenium.Utils.TextConverter.convertTextToHHProductId;

public class HaziHinamProductPage {

    public static double getProductPrice(WebDriverWait wait) {
        WebElement productPriceSelector = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p.price-title")));
        return convertTextToDouble(productPriceSelector);

    }

    public static String getProductId(WebDriverWait wait) {
        WebElement productIdSelector = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'קוד מוצר')]")));
        return convertTextToHHProductId(productIdSelector);

    }
}
