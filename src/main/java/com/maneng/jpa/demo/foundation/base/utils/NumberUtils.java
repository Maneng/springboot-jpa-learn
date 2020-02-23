package com.maneng.jpa.demo.foundation.base.utils;

/**
 * Created by jiangyu on 2015-12-29 19:43.
 */
public class NumberUtils {

  public static Integer sum(Integer... values) {
    int sum = 0;
    for (int i = 0; i < values.length; i++) {
      sum += getValue(values[i], 0);
    }
    return sum;
  }

  public static Double sum(Double... values) {
    double sum = 0;
    for (int i = 0; i < values.length; i++) {
      sum += getValue(values[i], 0D);
    }
    return sum;
  }

  public static Long sum(Long... values) {
    long sum = 0;
    for (int i = 0; i < values.length; i++) {
      sum += getValue(values[i], 0L);
    }
    return sum;

  }

  private static int getValue(Integer val, int defaultVal) {
    if (val == null) {
      return defaultVal;
    }
    return val;
  }

  private static long getValue(Long val, long defaultVal) {
    if (val == null) {
      return defaultVal;
    }
    return val;
  }

  private static double getValue(Double val, double defaultVal) {
    if (val == null) {
      return defaultVal;
    }
    return val;
  }

  public static Long subtract(Long val1, Long val2) {
    val1 = getValue(val1, 0L);
    val2 = getValue(val2, 0L);
    return val1 - val2;
  }

  public static Long subtract(Long... vals) {
    if (vals == null) {
      return 0L;
    }
    if (vals.length == 0) {
      return 0L;
    }
    long value = getValue(vals[0], 0);
    for (int i = 1; i < vals.length; i++) {
      value -= getValue(vals[i], 0);
    }
    return value;
  }

  public static Integer compare(Number num1, Number num2) {
    if (num1 == null || num2 == null) {
      return null;
    } else {
      return (int) Math.floor(num1.doubleValue() - num2.doubleValue());
    }
  }

  public static Double toDouble(String val) {
    return org.apache.commons.lang3.math.NumberUtils.createDouble(val);
  }

  public static Double toDouble(Number val) {
    return toDouble(val, 0D);
  }

  public static Double toDouble(Number val, Double defaultVal) {
    if (val == null) {
      return defaultVal;
    } else {
      return val.doubleValue();
    }
  }

  public static Integer toInteger(String val) {
    return org.apache.commons.lang3.math.NumberUtils.createInteger(val);
  }

  public static Integer toInteger(Number val) {
    return toInteger(val, 0);
  }

  public static Integer toInteger(Number val, Integer defaultVal) {
    if (val == null) {
      return defaultVal;
    } else {
      return val.intValue();
    }
  }

  public static Long toLong(String val) {
    return org.apache.commons.lang3.math.NumberUtils.createLong(val);
  }

  public static Long toLong(Number val) {
    return toLong(val, 0L);
  }

  public static Long toLong(Number val, Long defaultVal) {
    if (val == null) {
      return defaultVal;
    } else {
      return val.longValue();
    }
  }

  /**
   * 小于
   */
  public static Boolean less(Number x, Number y) {
    return less(x, y, 0);
  }

  public static Boolean less(Number x, Number y, Number defaultVal) {
    return !greatEqual(x, y, defaultVal);
  }

  /**
   * 小于等于
   */
  public static Boolean lessEqual(Number x, Number y) {
    return lessEqual(x, y, 0);
  }

  /**
   * 小于等于
   */
  public static Boolean lessEqual(Number x, Number y, Number defaultVal) {
    return !great(x, y, defaultVal);
  }

  /**
   * 大于
   */
  public static Boolean great(Number x, Number y) {
    return great(x, y, 0);
  }

  /**
   * 大于等于
   */
  public static Boolean greatEqual(Number x, Number y) {
    return greatEqual(x, y, 0);
  }

  /**
   * 大于等于
   */
  public static Boolean greatEqual(Number x, Number y, Number defaultVal) {
    x = getValueWithDefault(x, defaultVal);
    y = getValueWithDefault(y, defaultVal);
    if (x == null || y == null) {
      return null;
    }

    if (isSpecial(x) || isSpecial(y)) {
      return Double.compare(x.doubleValue(), y.doubleValue()) >= 0;
    }

    return (x.longValue() - y.longValue()) >= 0;
  }

  /**
   * 大于
   */
  public static Boolean great(Number x, Number y, Number defaultVal) {
    x = getValueWithDefault(x, defaultVal);
    y = getValueWithDefault(y, defaultVal);
    if (x == null || y == null) {
      return null;
    }
    if (isSpecial(x) || isSpecial(y)) {
      return Double.compare(x.doubleValue(), y.doubleValue()) > 0;
    }

    return (x.longValue() - y.longValue()) > 0;
  }

  private static Number getValueWithDefault(Number x, Number defaultVal) {
    if (x == null) {
      x = defaultVal;
    }
    return x;
  }


  public static boolean eq(Number x, Number y) {
    return eq(x, y, 0);
  }

  public static boolean eq(Number x, Number y, Number defaultVal) {
    if (x == null) {
      x = defaultVal;
    }

    if (y == null) {
      y = defaultVal;
    }

    if (x == null && y == null) {
      return true;
    }

    if (isSpecial(x) || isSpecial(y)) {
      return Double.compare(x.doubleValue(), y.doubleValue()) == 0;
    }
    return (x.longValue() - y.longValue()) == 0;
  }

  private static boolean isSpecial(Number x) {
    boolean specialDouble = x instanceof Double && (Double.isNaN((Double) x) || Double.isInfinite((Double) x));
    boolean specialFloat = x instanceof Float && (Float.isNaN((Float) x) || Float.isInfinite((Float) x));
    return specialDouble || specialFloat;
  }

}
