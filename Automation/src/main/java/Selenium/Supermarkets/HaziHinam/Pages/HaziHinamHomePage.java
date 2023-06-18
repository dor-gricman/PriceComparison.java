package Selenium.Supermarkets.HaziHinam.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HaziHinamHomePage {

    public static void performSearch(WebDriverWait wait, String productName) throws InterruptedException {
        WebElement searchIcon = wait.until(ExpectedConditions.elementToBeClickable(By.id("searchDropdown-desktop")));
        searchIcon.click();
        WebElement searchWindow = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("headerSearchInput")));
        searchWindow.sendKeys(productName);
        Thread.sleep(8000);
        WebElement firstSearchResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[contains(text(),'" + productName + "')]")));
        firstSearchResult.click();
    }
}
