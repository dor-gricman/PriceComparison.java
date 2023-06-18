package Selenium.Supermarkets;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Products {

    private String hebrewName;
    private double shufersalPrice;
    private double totalShufersalProductPrice;
    private double ramiLeviPrice;
    private double haziHinamPrice;
    private int amount;
    private double totalRlProductPrice;
    private double TotalHhProductPrice;

    public Products(String name) {
        this.hebrewName = "";
        this.ramiLeviPrice = 0.0;
        this.haziHinamPrice = 0.0;
        this.shufersalPrice = 0.0;
        this.amount = 0;
        this.totalRlProductPrice = 0;
        this.TotalHhProductPrice = 0;
        this.totalShufersalProductPrice = 0;


    }

    public String getHebrewName() {
        return hebrewName;
    }

    public void setHebrewName(String hebrewName) {
        this.hebrewName = hebrewName;
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

    public double getTotalRlProductPrice() {
        return totalRlProductPrice;
    }

    public void setTotalRlProductPrice(double ramiLeviPrice, int amount) {
        this.totalRlProductPrice = ramiLeviPrice * amount;
    }

    public double getTotalHhProductPrice() {
        return TotalHhProductPrice;
    }

    public void setTotalHhProductPrice(double haziHinamPrice, int amount) {
        this.TotalHhProductPrice = haziHinamPrice * amount;
    }

    public double getTotalShufersalProductPrice() {
        return totalShufersalProductPrice;
    }

    public void setTotalShufersalProductPrice(double totalShufersalProductPrice, int amount) {
        this.totalShufersalProductPrice = shufersalPrice * this.amount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static List<Products> generateShoppingCart() {
        List<Products> shoppingCart = new ArrayList<>();
        System.out.print("How many products would you like to order? ");
        int numberOfProducts = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfProducts; i++) {
            String productName = "product " + (i + 1);
            Products product = new Products(productName);
            System.out.print("What product would you like to order? ");
            String hebrewName = scanner.nextLine();
            product.setHebrewName(hebrewName);
            System.out.print("How many units do you want to order from this product? ");
            int units = scanner.nextInt();
            scanner.nextLine();
            product.setAmount(units);
            shoppingCart.add(product);
        }
        scanner.close();
        return shoppingCart;
    }


}