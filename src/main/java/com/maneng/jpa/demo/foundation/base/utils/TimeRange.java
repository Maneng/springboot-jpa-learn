package com.maneng.jpa.demo.foundation.base.utils;

/**
 * Created by jiangyu on 2016-05-09 20:41.
 */
public class TimeRange<T> {

  private T from;
  private T to;

  public TimeRange() {
  }

  public TimeRange(T from, T to) {
    this.from = from;
    this.to = to;
  }

  public T getFrom() {
    return from;
  }

  public void setFrom(T from) {
    this.from = from;
  }

  public T getTo() {
    return to;
  }

  public void setTo(T to) {
    this.to = to;
  }
}
