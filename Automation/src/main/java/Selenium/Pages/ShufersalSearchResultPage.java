package Selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShufersalSearchResultPage {
    public static void selectProduct(WebDriverWait wait, String productName) {
        String xpathExpression = String.format("//strong[text()='%s']", productName);
        WebElement searchResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
        searchResult.click();
    }
}
