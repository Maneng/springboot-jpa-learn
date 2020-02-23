package com.maneng.jpa.demo.foundation.base.utils;

/**
 * Created by jiangyu on 2015-11-24 11:35.
 */
public class Counter {

  private int counter;

  public final int get() {
    return counter;
  }

  public final void set(int newValue) {
    counter = newValue;
  }

  public final int getAndSet(int newValue) {
    int old = counter;
    counter = newValue;
    return old;
  }

  public final int getAndIncrement() {
    return counter++;
  }

  public final int getAndDecrement() {
    return counter--;
  }

  public final int incrementAndGet() {
    return ++counter;
  }

  public final int incrementAndGet(int value) {
    counter += value;
    return counter;
  }

  public final int decrementAndGet() {
    return --counter;
  }

  public final int decrementAndGet(int value) {
    counter -= value;
    return counter;
  }
}
