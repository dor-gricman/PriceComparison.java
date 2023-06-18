package Selenium.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static Connection connectToDatabase() throws SQLException {
        String url = "jdbc:sqlite:D:\\שולחן עבודה\\automation_framework\\Automation\\data\\supermarkets.db";
        return DriverManager.getConnection(url);
    }
}

