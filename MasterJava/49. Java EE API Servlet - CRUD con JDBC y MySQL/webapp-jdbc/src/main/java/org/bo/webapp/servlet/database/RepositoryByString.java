package org.bo.webapp.servlet.database;

import java.sql.SQLException;
import java.util.List;

public interface RepositoryByString<T> {
  List<T> byName(String text) throws SQLException;
}
