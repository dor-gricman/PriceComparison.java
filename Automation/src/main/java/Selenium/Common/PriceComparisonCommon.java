package Selenium.Common;

import Selenium.Utils.Products;
import Selenium.Utils.ComparisonSummary;
import Selenium.Utils.SeleniumDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLException;
import java.util.List;

public class PriceComparisonCommon {

    public static void main(String[] args) throws InterruptedException, SQLException {
        List<Products> shoppingCart = Products.generateShoppingCart();
        ChromeDriver driver = SeleniumDriver.initializeDriver();
        HaziHinamCommon haziHinam = new HaziHinamCommon(driver);
        RamiLeviCommon ramiLevi = new RamiLeviCommon(driver);
        ShufersalCommon shufersal = new ShufersalCommon(driver);
        haziHinam.getProductPrices(shoppingCart);
        ramiLevi.getProductPrices(shoppingCart);
        shufersal.getProductPrices(shoppingCart);
        ComparisonSummary.Sum(shoppingCart);
        SeleniumDriver.quitDriver(driver);
    }
}












