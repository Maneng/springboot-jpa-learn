package com.maneng.jpa.demo.foundation.base.error;

import java.util.Objects;

/**
 * Created by jiangyu on 2015-10-21 15:34.
 */
public class Code {

  private String code;
  private String comment;

  public Code() {
  }

  public Code(String code) {
    this.code = code;
  }

  public Code(String code, String comment) {
    this.code = code;
    this.comment = comment;
  }

  public Code(int code, String comment) {
    this.code = String.format("%04d", code);
    this.comment = comment;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Code code1 = (Code) o;
    return code == code1.code;
  }

  @Override
  public int hashCode() {
    return Objects.hash(code);
  }

  @Override
  public String toString() {
    return code;
  }
}
