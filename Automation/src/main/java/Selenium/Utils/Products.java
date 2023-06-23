package Selenium.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Products {

    private String productName;
    private String ramiLeviProductName;
    private String haziHinamProductName;
    private String shufersalProductName;
    private double shufersalPrice;
    private double ramiLeviPrice;
    private double haziHinamPrice;
    private int amount;
    private double totalRLProductPrice;
    private double totalHHProductPrice;
    private double totalShufersalProductPrice;

    public Products() {
        this.productName = "";
        this.ramiLeviProductName = "";
        this.haziHinamProductName = "";
        this.shufersalProductName = "";
        this.ramiLeviPrice = 0.0;
        this.haziHinamPrice = 0.0;
        this.shufersalPrice = 0.0;
        this.amount = 0;
        this.totalRLProductPrice = 0;
        this.totalHHProductPrice = 0;
        this.totalShufersalProductPrice = 0;

    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getRamiLeviPrice() {
        return ramiLeviPrice;
    }

    public void setRamiLeviPrice(double ramiLeviPrice) {
        this.ramiLeviPrice = ramiLeviPrice;
    }

    public double getHaziHinamPrice() {
        return haziHinamPrice;
    }

    public void setHaziHinamPrice(double haziHinamPrice) {
        this.haziHinamPrice = haziHinamPrice;
    }

    public double getShufersalPrice() {
        return shufersalPrice;
    }

    public void setShufersalPrice(double productPrice) {
        this.shufersalPrice = productPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getTotalRLProductPrice() {
        return totalRLProductPrice;
    }

    public void setTotalRLProductPrice(double ramiLeviPrice, int amount) {
        this.totalRLProductPrice = ramiLeviPrice * amount;
    }

    public double getTotalHHProductPrice() {
        return totalHHProductPrice;
    }

    public void setTotalHHProductPrice(double haziHinamPrice, int amount) {
        this.totalHHProductPrice = haziHinamPrice * amount;
    }

    public double getTotalShufersalProductPrice() {
        return totalShufersalProductPrice;
    }

    public void setTotalShufersalProductPrice(double shufersalPrice, int amount) {
        this.totalShufersalProductPrice = shufersalPrice * amount;
    }

    public String getRamiLeviProductName() {
        return ramiLeviProductName;
    }

    public void setRamiLeviProductName(String ramiLeviProductName) {
        this.ramiLeviProductName = ramiLeviProductName;
    }

    public String getHaziHinamProductName() {
        return haziHinamProductName;
    }

    public void setHaziHinamProductName(String haziHinamProductName) {
        this.haziHinamProductName = haziHinamProductName;
    }

    public String getShufersalProductName() {
        return shufersalProductName;
    }

    public void setShufersalProductName(String shufersalProductName) {
        this.shufersalProductName = shufersalProductName;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static List<Products> generateShoppingCart() {
        List<Products> shoppingCart = new ArrayList<>();
        System.out.print("How many products would you like to order? ");
        int numberOfProducts = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfProducts; i++) {
            Products product = new Products();
            System.out.println("Would you like to search for the same product name in all supermarkets? (Y/N)");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("Y")) {
                System.out.print("What product would you like to order? ");
                String productName = scanner.nextLine();
                product.setProductName(productName);
                System.out.print("How many units do you want to order from this product? ");
                int units = scanner.nextInt();
                scanner.nextLine();
                product.setAmount(units);
                shoppingCart.add(product);
            } else {
                System.out.print("What is the name of the product at Rami Levi? ");
                String ramiLeviProductName = scanner.nextLine();
                product.setRamiLeviProductName(ramiLeviProductName);
                System.out.print("What is the name of the product at Hazi Hinam? ");
                String haziHinamProductName = scanner.nextLine();
                product.setHaziHinamProductName(haziHinamProductName);
                System.out.print("What is the name of the product at Shufersal? ");
                String shufersalProductName = scanner.nextLine();
                product.setShufersalProductName(shufersalProductName);
                System.out.print("How many units do you want to order from this product? ");
                int units = scanner.nextInt();
                scanner.nextLine();
                product.setAmount(units);
                shoppingCart.add(product);
            }
        }
        scanner.close();
        return shoppingCart;
    }
}