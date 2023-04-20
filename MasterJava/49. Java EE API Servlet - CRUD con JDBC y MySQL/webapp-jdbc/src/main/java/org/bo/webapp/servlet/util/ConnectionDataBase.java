package org.bo.webapp.servlet.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDataBase {
  private static String url = "jdbc:mysql://localhost:3306/course_java?serverTimezone=America/Caracas";
  private static String username = "root";
  private static String password = "tupassword";

  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(url,username, password);
  }
}
