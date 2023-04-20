package org.bo.webapp.servlet.services;

public class ServiceJDBCException extends RuntimeException {
  public ServiceJDBCException(String message) {
    super(message);
  }

  public ServiceJDBCException(String message, Throwable cause) {
    super(message, cause);
  }
}
