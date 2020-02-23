package com.maneng.jpa.demo.foundation.base.error;

/**
 * Created by jiangyu on 2019-01-22 15:30.
 */
public class ServiceException extends RuntimeException {

  private Errors errors;

  public ServiceException(String message, Errors errors) {
    super(message);
    this.errors = errors;
  }

  public ServiceException(Errors errors) {
    super(errors.getMessage());
    this.errors = errors;
  }
}
