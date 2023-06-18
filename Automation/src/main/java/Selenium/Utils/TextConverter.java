package Selenium.Utils;

import org.openqa.selenium.WebElement;

public class TextConverter {

    public static double convertTextToDouble(WebElement webElement){
        String textPrice = webElement.getText();
        int Index = textPrice.indexOf("₪");
        return Double.parseDouble(textPrice.substring(0, Index).trim());
    }

    public static double convertTextToShufersalPrice(WebElement webElement){
        String textPrice = webElement.getText();
        return Double.parseDouble(textPrice.trim());
    }

    public static String convertTextToRLProductId(WebElement webElement){
        String productIdText = webElement.getText();
        int startingIndex = "ברקוד".length();
        return productIdText.substring(startingIndex).trim();
    }

    public static String convertTextToHHProductId(WebElement webElement){
        String productIdText = webElement.getText();
        int startingIndex = "קוד מוצר".length();
        return productIdText.substring(startingIndex).trim();
    }
}
