package Selenium.Supermarkets.RamiLevi.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RamiLeviSearchResultPage {

    public static void selectProduct(WebDriverWait wait,String productName) {
        WebElement searchResult = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("img[alt='" + productName + "']")));
        searchResult.click();
    }
}
