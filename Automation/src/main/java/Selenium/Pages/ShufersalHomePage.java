package Selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShufersalHomePage {

    public static void performSearch(WebDriverWait wait, String productName) {
        WebElement searchWindow = wait.until(ExpectedConditions.elementToBeClickable(By.id("js-site-search-input")));
        searchWindow.click();
        searchWindow.sendKeys(productName);
        WebElement searchIcon = wait.until(ExpectedConditions.elementToBeClickable(By.className("search-icon")));
        searchIcon.click();
    }
    public static void clearSearchWindow(WebDriverWait wait) {
        WebElement clearSearchWindow = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class='close']")));
        clearSearchWindow.click();
    }
}
