package com.maneng.jpa.demo.foundation.base.error;

/**
 * Created by jiangyu on 2015-10-21 15:12.
 */
public class SeriesType {

  private String number;
  private String comment;

  public SeriesType() {
  }

  public SeriesType(String number) {
    this.number = number;
  }

  public SeriesType(String number, String comment) {
    this.number = number;
    this.comment = comment;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  @Override
  public String toString() {
    return String.valueOf(number);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    SeriesType that = (SeriesType) o;

    return !(number != null ? !number.equals(that.number) : that.number != null);

  }

  @Override
  public int hashCode() {
    int result = number != null ? number.hashCode() : 0;
    result = 31 * result + (comment != null ? comment.hashCode() : 0);
    return result;
  }
}
