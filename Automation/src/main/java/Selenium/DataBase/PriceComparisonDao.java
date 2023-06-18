package Selenium.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class PriceComparisonDao {

   public static void insertComparison(double ramiLeviTotal, double haziHinamTotal) throws SQLException {
      Connection connection = Connect.connectToDatabase();
      String sql = "INSERT INTO PriceComparison (Rami_Levi_Cart_Price, Hazi_Hinam_Cart_Price, Date) VALUES (?, ?, ?)";

      try (PreparedStatement statement = connection.prepareStatement(sql)) {
         statement.setDouble(1, ramiLeviTotal);
         statement.setDouble(2, haziHinamTotal);

         LocalDate currentDate = LocalDate.now();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy", Locale.ENGLISH);
         String formattedDate = currentDate.format(formatter);

         statement.setString(3, formattedDate);
         statement.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}