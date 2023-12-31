package Selenium.Pages;

import static Selenium.Utils.TextConverter.*;

import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ShufersalProductPage {
    public static double getProductPrice(WebDriverWait wait) throws InterruptedException
    {
        WebElement productPrice = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='actualPrice miglog-light '] span[itemprop='price']"))); //
        Thread.sleep(2000);
        return convertTextToShufersalPrice(productPrice);// Convert the price to double
    }

    public static void closeProductWindow(WebDriver driver)
    {// This method is used to close the product window
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).perform();
    }

    public static String getProductId(WebDriver driver)
    {// This method is used to get the ID of a product in Shufersal
        List<WebElement> tooltipElements = driver.findElements(By.xpath("//div[@class='text tooltip-js']"));
        WebElement productID = tooltipElements.get(2);
        return productID.getAttribute("textContent").trim();
    }
}

