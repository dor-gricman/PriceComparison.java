package Selenium.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RamiLeviSearchResultPage {// This class is used to perform actions on the Rami Levi search result page

    public static void selectProduct(WebDriverWait wait,String productName) {
        String xpathExpression = String.format("//div[text()='%s']", productName);//create an xpath expression product that matches the exact product name
        WebElement searchResult = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathExpression)));//
        searchResult.click();
    }
}
