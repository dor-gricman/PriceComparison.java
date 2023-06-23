package Selenium.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class PriceComparisonDao {

   public static int insertComparison(double ramiLeviTotal, double haziHinamTotal, double shufersalTotal) throws SQLException {
      Connection connection = SQLiteConnection.connectToDatabase();
      int comparisonId = -1;
      String sql = "INSERT INTO PriceComparisonCommon (Rami_Levi_Cart_Price, Hazi_Hinam_Cart_Price, Shufersal_Cart_Price, Date) VALUES (?, ?, ?, ?)";

      try (PreparedStatement statement = connection.prepareStatement(sql)) {
         statement.setDouble(1, ramiLeviTotal);
         statement.setDouble(2, haziHinamTotal);
         statement.setDouble(3, shufersalTotal);

         LocalDate currentDate = LocalDate.now();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy", Locale.ENGLISH);
         String formattedDate = currentDate.format(formatter);

         statement.setString(4, formattedDate);
         statement.executeUpdate();

         ResultSet generatedKeys = statement.getGeneratedKeys();
         if (generatedKeys.next()) {
            comparisonId = generatedKeys.getInt(1);
         }

      } catch (SQLException e) {
         e.printStackTrace();
      }
        return comparisonId;
   }
   public static void insertComparisonDetails(int comparisonId, String productName, int numberOfUnits, double RLProductPrice, double HHProductPrice, double SProductPrice, double RL_Total_Product_Price, double HH_Total_Product_Price, double Shufersal_Total_Product_Price) throws SQLException {
      Connection connection = SQLiteConnection.connectToDatabase();
      String sql = "INSERT INTO Comparison_Details (Comparison_Id, Product_Name, Number_Of_Units, RL_Product_Price_Per_Unit, HH_Product_Price_Per_Unit, Shufersal_Price_Per_Unit, RL_Total_Product_Price, HH_Total_Product_Price, Shufersal_Total_Product_Price, Date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

      try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, comparisonId);
            statement.setString(2, productName);
            statement.setInt(3, numberOfUnits);
            statement.setDouble(4, RLProductPrice);
            statement.setDouble(5, HHProductPrice);
            statement.setDouble(6, SProductPrice);
            statement.setDouble(7, RL_Total_Product_Price);
            statement.setDouble(8, HH_Total_Product_Price);
            statement.setDouble(9, Shufersal_Total_Product_Price);

            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy", Locale.ENGLISH);
            String formattedDate = currentDate.format(formatter);

            statement.setString(10, formattedDate);
            statement.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}