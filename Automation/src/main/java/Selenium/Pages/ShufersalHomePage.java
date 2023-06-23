package Selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShufersalHomePage {// This class is used to perform actions on the Shufersal home page

    public static void performSearch(WebDriverWait wait, String productName) {// This method is used to perform a search for a product in Shufersal
        WebElement searchWindow = wait.until(ExpectedConditions.elementToBeClickable(By.id("js-site-search-input")));// Find the search window
        searchWindow.click();
        searchWindow.sendKeys(productName);// Enter the product name in the search bar
        WebElement searchIcon = wait.until(ExpectedConditions.elementToBeClickable(By.className("search-icon")));// Find the search icon
        searchIcon.click();
    }
    public static void clearSearchWindow(WebDriverWait wait) {
        WebElement clearSearchWindow = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class='close']")));// Clear the search window
        clearSearchWindow.click();
    }
}
