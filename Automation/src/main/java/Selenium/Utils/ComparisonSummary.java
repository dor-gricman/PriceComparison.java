package Selenium.Utils;

import java.sql.SQLException;
import java.text.DecimalFormat;

import java.util.List;

import static Selenium.DataBase.PriceComparisonDao.insertComparison;
import static Selenium.DataBase.PriceComparisonDao.insertComparisonDetails;

public class ComparisonSummary {
    // Print the summary of the comparison
    public static void Sum(List<Products> productsList) throws SQLException {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        double ramiLeviTotal = SumCart.sumRLCart(productsList);
        double haziHinamTotal = SumCart.sumHHCart(productsList);
        double shufersalTotal = SumCart.sumShufersalCart(productsList);
        int comparisonId = insertComparison(ramiLeviTotal, haziHinamTotal, shufersalTotal); //insert comparison to DB and returns comparison id

        // Iterate over each product in the list
        for (Products product : productsList) {
            product.setTotalHHProductPrice(product.getHaziHinamPrice(), product.getAmount());
            product.setTotalRLProductPrice(product.getRamiLeviPrice(), product.getAmount());
            product.setTotalShufersalProductPrice(product.getShufersalPrice(), product.getAmount());
            insertComparisonDetails(comparisonId, product.getProductName(), product.getAmount(), //insert comparison details to DB
                    product.getRamiLeviPrice(), product.getHaziHinamPrice(), product.getShufersalPrice(),
                    product.getTotalRLProductPrice(), product.getTotalHHProductPrice(),
                    product.getTotalShufersalProductPrice());
            // Check if a specific supermarket product name is provided
            if (product.getRamiLeviProductName().length() > 0) {
                // Print the product name and price
                System.out.println("מחיר ליחידה ברמי לוי עבור " + product.getRamiLeviProductName() + ":");
                System.out.println(decimalFormat.format(product.getRamiLeviPrice()));
                System.out.println("סכום כולל ברמי לוי עבור " + product.getRamiLeviProductName() + ":");
                System.out.println(decimalFormat.format(product.getTotalRLProductPrice()));
                System.out.println("מחיר ליחידה בחצי חינם עבור " + product.getHaziHinamProductName() + ":");
                System.out.println(decimalFormat.format(product.getHaziHinamPrice()));
                System.out.println("סכום כולל בחצי חינם עבור " + product.getHaziHinamProductName() + ":");
                System.out.println(decimalFormat.format(product.getTotalHHProductPrice()));
                System.out.println("מחיר ליחידה בשופרסל עבור " + product.getShufersalProductName() + ":");
                System.out.println(decimalFormat.format(product.getShufersalPrice()));
                System.out.println("סכום כולל בשופרסל עבור " + product.getShufersalProductName() + ":");
                System.out.println(decimalFormat.format(product.getTotalShufersalProductPrice()));
            } else {
                System.out.println("מחיר ליחידה ברמי לוי עבור " + product.getProductName() + ":");
                System.out.println(decimalFormat.format(product.getRamiLeviPrice()));
                System.out.println("מחיר ליחידה בחצי חינם עבור " + product.getProductName() + ":");
                System.out.println(decimalFormat.format(product.getHaziHinamPrice()));
                System.out.println("סכום כולל בחצי חינם עבור " + product.getProductName() + ":");
                System.out.println(decimalFormat.format(product.getTotalHHProductPrice()));
                System.out.println("מחיר ליחידה בשופרסל עבור " + product.getProductName() + ":");
                System.out.println(decimalFormat.format(product.getShufersalPrice()));
                System.out.println("סכום כולל בשופרסל עבור " + product.getProductName() + ":");
                System.out.println(decimalFormat.format(product.getTotalShufersalProductPrice()));
            }
        }
        // Print the total cart price for each supermarket
        System.out.println("סכום עגלה כולל ברמי לוי:");
        System.out.println(decimalFormat.format(ramiLeviTotal));
        System.out.println("סכום עגלה כולל בחצי חינם:");
        System.out.println(decimalFormat.format(haziHinamTotal));
        System.out.println("סכום עגלה כולל בשופרסל:");
        System.out.println(decimalFormat.format(shufersalTotal));
    }
}
