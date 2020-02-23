package com.maneng.jpa.demo.foundation.base.utils;

import java.text.DecimalFormat;
import java.util.Optional;

/**
 * Created by lijingyao on 15/12/24 21:43.
 */
public class NumberFormatUtils {

  public static final DecimalFormat formatOneDecimal = new DecimalFormat("##0.0");
  public static final DecimalFormat formatTwoDecimal = new DecimalFormat("##0.00");

  public static Optional<String> format(Number number, Boolean decimalTwo) {
    if (null == number) {
      return Optional.empty();
    } else {
      if (null == decimalTwo) {
        decimalTwo = true;
      }
      try {
        if (decimalTwo) {
          return Optional.of(formatTwoDecimal.format(number.floatValue()));
        } else {
          return Optional.of(formatOneDecimal.format(number.floatValue()));
        }
      } catch (ArithmeticException e) {
        throw new ArithmeticException();
      }
    }
  }


}
