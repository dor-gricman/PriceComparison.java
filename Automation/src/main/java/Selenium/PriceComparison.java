package Selenium;

import Selenium.Supermarkets.HaziHinam.HaziHinamMain;
import Selenium.Supermarkets.Products;
import Selenium.Supermarkets.RamiLevi.RamiLeviMain;
import Selenium.Supermarkets.Shufersal.ShufersalMain;
import Selenium.Utils.ComparisonSummary;
import Selenium.Utils.SeleniumDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLException;
import java.util.List;

public class PriceComparison {

    public static void main(String[] args) throws InterruptedException, SQLException {
        List<Products> shoppingCart = Products.generateShoppingCart();
        ChromeDriver driver = SeleniumDriver.initializeDriver();
        HaziHinamMain haziHinam = new HaziHinamMain(driver);
        RamiLeviMain ramiLevi = new RamiLeviMain(driver);
        ShufersalMain shufersal = new ShufersalMain(driver);
        haziHinam.getProductPrices(shoppingCart);
        ramiLevi.getProductPrices(shoppingCart);
        shufersal.getProductPrices(shoppingCart);
        ComparisonSummary.Sum(shoppingCart);
        SeleniumDriver.quitDriver(driver);
    }
}












