package com.maneng.jpa.demo.foundation.base.error;

/**
 * Created by jiangyu on 2015-10-21 15:20.
 */
public class ErrorType {

  private String code;

  public ErrorType() {
  }

  ErrorType(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public String toString() {
    return code;
  }
}
