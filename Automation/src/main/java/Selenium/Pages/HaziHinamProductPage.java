package Selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Selenium.Utils.TextConverter.convertTextToDouble;
import static Selenium.Utils.TextConverter.convertTextToHHProductId;

public class HaziHinamProductPage {// This class is used to perform actions on the Hazi Hinam product page

    public static double getProductPrice(WebDriverWait wait) {// This method is used to get the price of a product in Hazi Hinam
        WebElement productPriceSelector = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p.price-title")));
        return convertTextToDouble(productPriceSelector);// Convert the price to double

    }

    public static String getProductId(WebDriverWait wait) {// This method is used to get the ID of a product in Hazi Hinam
        WebElement productIdSelector = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'קוד מוצר')]")));
        return convertTextToHHProductId(productIdSelector);// Convert the ID to string

    }
}
