package Selenium.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RamiLeviHomePage {// This class is used to perform actions on the Rami Levi home page

    public static void performSearch(WebDriverWait wait, String productName) throws InterruptedException {// This method is used to perform a search for a product in Rami Levi
        WebElement searchIcon = wait.until(ExpectedConditions.elementToBeClickable(By.id("destination")));
        searchIcon.click();
        searchIcon.clear();
        searchIcon.sendKeys(productName);// Enter the product name in the search bar
        searchIcon.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }
}