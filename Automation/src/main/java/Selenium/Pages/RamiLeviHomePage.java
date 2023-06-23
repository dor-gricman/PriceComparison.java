package Selenium.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RamiLeviHomePage {

    public static void performSearch(WebDriverWait wait, String productName) throws InterruptedException {
        WebElement searchIcon = wait.until(ExpectedConditions.elementToBeClickable(By.id("destination")));
        searchIcon.click();
        searchIcon.clear();
        searchIcon.sendKeys(productName);
        searchIcon.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }
}