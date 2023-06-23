package Selenium.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:D:\\שולחן עבודה\\automation_framework\\Automation\\data\\supermarkets.db"; // Replace with your database file location
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM PriceComparisonCommon";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int comparisonId = resultSet.getInt("ComparisonId");
                double ramiLeviPrice = resultSet.getDouble("Rami_Levi_Cart_Price");
                double haziHinamPrice = resultSet.getDouble("Hazi_Hinam_Cart_Price");
                double shufersalPrice = resultSet.getDouble("Shufersal_Cart_Price");
                String date = resultSet.getString("Date");

                System.out.println("Comparison ID: " + comparisonId);
                System.out.println("Rami Levi Cart Price: " + ramiLeviPrice);
                System.out.println("Hazi Hinam Cart Price: " + haziHinamPrice);
                System.out.println("Shufersal Cart Price: " + shufersalPrice);
                System.out.println("Date: " + date);
                System.out.println("-------------------------");
            }

            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}