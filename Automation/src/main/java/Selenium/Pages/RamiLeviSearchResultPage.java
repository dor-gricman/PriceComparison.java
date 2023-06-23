package Selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RamiLeviSearchResultPage {

    public static void selectProduct(WebDriverWait wait,String productName) {
        String xpathExpression = String.format("//div[text()='%s']", productName);
        WebElement searchResult = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathExpression)));
        searchResult.click();
    }
}
