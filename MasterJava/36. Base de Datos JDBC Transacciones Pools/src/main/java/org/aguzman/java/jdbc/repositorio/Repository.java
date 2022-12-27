package org.aguzman.java.jdbc.repositorio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {
  void setConn(Connection conn);
  List<T> list() throws SQLException;

  T byId(Long id) throws SQLException;

  T store(T t) throws SQLException;

  void delete(Long id) throws SQLException;
}
