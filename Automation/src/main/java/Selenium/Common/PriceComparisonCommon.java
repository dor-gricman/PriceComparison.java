package Selenium.Common;

import Selenium.Utils.Products;
import Selenium.Utils.ComparisonSummary;
import Selenium.Utils.SeleniumDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLException;
import java.util.List;

public class PriceComparisonCommon {

    public static void main(String[] args) throws InterruptedException, SQLException {// This method is used to compare prices of products in different supermarkets
        List<Products> shoppingCart = Products.generateShoppingCart();// Generate a shopping cart
        ChromeDriver driver = SeleniumDriver.initializeDriver();// Initialize the driver
        HaziHinamCommon haziHinam = new HaziHinamCommon(driver);// Create an instance of the HaziHinamCommon class
        RamiLeviCommon ramiLevi = new RamiLeviCommon(driver);// Create an instance of the RamiLeviCommon class
        ShufersalCommon shufersal = new ShufersalCommon(driver);// Create an instance of the ShufersalCommon class
        haziHinam.getProductPrices(shoppingCart);// Get the prices of the products in Hazi Hinam
        ramiLevi.getProductPrices(shoppingCart);// Get the prices of the products in Rami Levi
        shufersal.getProductPrices(shoppingCart);// Get the prices of the products in Shufersal
        ComparisonSummary.Sum(shoppingCart);// Summarize the comparison results
        SeleniumDriver.quitDriver(driver);
    }
}












