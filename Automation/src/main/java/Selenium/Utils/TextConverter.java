package Selenium.Utils;

import org.openqa.selenium.WebElement;

public class TextConverter {
    // Convert text to double
    public static double convertTextToDouble(WebElement webElement){
        String textPrice = webElement.getText();
        int Index = textPrice.indexOf("₪");
        return Double.parseDouble(textPrice.substring(0, Index).trim());
    }
    //convert text to int
    public static double convertTextToShufersalPrice(WebElement webElement){
        String textPrice = webElement.getText();
        return Double.parseDouble(textPrice.trim());
    }
    // Convert text to ID
    public static String convertTextToRLProductId(WebElement webElement){
        String productIdText = webElement.getText();
        int startingIndex = "ברקוד".length();
        return productIdText.substring(startingIndex).trim();
    }
    // Convert text to ID
    public static String convertTextToHHProductId(WebElement webElement){
        String productIdText = webElement.getText();
        int startingIndex = "קוד מוצר".length();
        return productIdText.substring(startingIndex).trim();
    }
}
