package Selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HaziHinamHomePage {// This class is used to perform actions on the Hazi Hinam home page

    public static void performSearch(WebDriverWait wait, String productName) throws InterruptedException {// This method is used to perform a search for a product in Hazi Hinam
        WebElement searchIcon = wait.until(ExpectedConditions.elementToBeClickable(By.id("searchDropdown-desktop")));
        searchIcon.click();
        WebElement searchWindow = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("headerSearchInput")));
        searchWindow.sendKeys(productName);
        Thread.sleep(8000);
        WebElement firstSearchResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[contains(text(),'" + productName + "')]")));// Select the first search result
        firstSearchResult.click();
    }
}
