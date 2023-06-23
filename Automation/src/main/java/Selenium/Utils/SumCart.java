package Selenium.Utils;

import java.util.List;

public class SumCart {
    // Sum the total price of the cart
    public static double sumRLCart(List<Products> products) {
        double cartTotal = 0;
        for (Products product : products) {
            double price = product.getRamiLeviPrice() * product.getAmount();
            cartTotal += price;
        }
        return cartTotal;
    }

    public static double sumHHCart(List<Products> products) {
        double cartTotal = 0;
        for (Products product : products) {
            double price = product.getHaziHinamPrice() * product.getAmount();
            cartTotal += price;
        }
        return cartTotal;
    }

    public static double sumShufersalCart(List<Products> products) {
        double cartTotal = 0;
        for (Products product : products) {
            double price = product.getShufersalPrice() * product.getAmount();
            cartTotal += price;
        }
        return cartTotal;
    }
}
