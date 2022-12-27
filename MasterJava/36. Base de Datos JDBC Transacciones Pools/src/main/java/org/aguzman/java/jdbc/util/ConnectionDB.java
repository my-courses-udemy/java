package org.aguzman.java.jdbc.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.SQLException;

public class ConnectionDB {
  private static String url = "jdbc:mysql://localhost:3306/course_java?serverTimezone=America/Caracas";
  private static String username = "root";
  private static String password = "tupassword";
  private static java.sql.Connection connection;
  private static BasicDataSource pool;

  public static BasicDataSource getInstance() throws SQLException {
    if (pool == null) {
      pool = new BasicDataSource();
      pool.setUrl(url);
      pool.setUsername(username);
      pool.setPassword(password);
      pool.setInitialSize(3);
      pool.setMinIdle(3);
      pool.setMaxIdle(8);
      pool.setMaxTotal(8);
    }
    return pool;
  }

  public static java.sql.Connection getConnection() throws SQLException {
    return getInstance().getConnection();
  }
}
