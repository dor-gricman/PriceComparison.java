package Selenium.Utils;

import java.sql.SQLException;
import java.text.DecimalFormat;
import Selenium.Supermarkets.Products;
import java.util.List;
import static Selenium.DataBase.PriceComparisonDao.insertComparison;

public class ComparisonSummary {

    public static void Sum(List<Products> productsList) throws SQLException {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        double ramiLeviTotal = SumCart.sumRLCart(productsList);
        double haziHinamTotal = SumCart.sumHHCart(productsList);
        double shufersalTotal = SumCart.sumShufersalCart(productsList);
        insertComparison(ramiLeviTotal, haziHinamTotal);

        for (Products product : productsList) {
            product.setTotalHhProductPrice(product.getHaziHinamPrice(), product.getAmount());
            product.setTotalRlProductPrice(product.getRamiLeviPrice(), product.getAmount());
            product.setTotalShufersalProductPrice(product.getShufersalPrice(), product.getAmount());
            System.out.println("מחיר ליחידה ברמי לוי עבור " + product.getHebrewName() + ":");
            System.out.println(decimalFormat.format(product.getRamiLeviPrice()));
            System.out.println("סכום כולל ברמי לוי עבור " + product.getHebrewName() + ":");
            System.out.println(decimalFormat.format(product.getTotalRlProductPrice()));
            System.out.println("מחיר ליחידה בחצי חינם עבור " + product.getHebrewName() + ":");
            System.out.println(decimalFormat.format(product.getHaziHinamPrice()));
            System.out.println("סכום כולל בחצי חינם עבור " + product.getHebrewName() + ":");
            System.out.println(decimalFormat.format(product.getTotalHhProductPrice()));
            System.out.println("מחיר ליחידה בשופרסל עבור " + product.getHebrewName() + ":");
            System.out.println(decimalFormat.format(product.getShufersalPrice()));
            System.out.println("סכום כולל בשופרסל עבור " + product.getHebrewName() + ":");
            System.out.println(decimalFormat.format(product.getTotalShufersalProductPrice()));
        }
        System.out.println("סכום עגלה כולל ברמי לוי:");
        System.out.println( decimalFormat.format(ramiLeviTotal));
        System.out.println("סכום עגלה כולל בחצי חינם:");
        System.out.println(decimalFormat.format(haziHinamTotal));
        System.out.println("סכום עגלה כולל בשופרסל:");
        System.out.println(decimalFormat.format(shufersalTotal));
    }
}
