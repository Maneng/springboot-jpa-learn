package com.maneng.jpa.demo.foundation.base.utils;


import com.maneng.jpa.demo.foundation.base.enums.EnumIndex;

/**
 * Created by jiangyu on 2016-05-10 14:09.
 */
public class EnumUtils {

  public static <T> T getEnumByOrdinal(Class<T> clazz, Integer ordinal) {
    if (ordinal == null) {
      return null;
    }
    T[] enumArrays = clazz.getEnumConstants();
    if (enumArrays != null && ordinal < enumArrays.length) {
      T e = enumArrays[ordinal];
      if (e instanceof Enum) {
        return e;
      }
    }
    return null;
  }

  public static <T extends EnumIndex> T getEnumByIndex(Class<T> clazz, Integer index) {
    if (index == null) {
      return null;
    }
    if (clazz != null && EnumIndex.class.isAssignableFrom(clazz)) {
      EnumIndex[] enumArrays = clazz.getEnumConstants();
      for (EnumIndex i : enumArrays) {
        if (index == i.getIndex()) {
          return (T) i;
        }
      }
    }
    return null;
  }

  public static <T extends EnumIndex> T getEnumByIndex(Class<T> clazz, Integer index, T defaultType) {
    T type = getEnumByIndex(clazz, index);
    if (type == null) {
      return defaultType;
    }
    return type;
  }

  public static Integer getIndex(EnumIndex enumIndex) {
    if (enumIndex != null) {
      return enumIndex.getIndex();
    } else {
      return null;
    }
  }

  public static Integer getIndex(EnumIndex enumIndex, EnumIndex defaultEnum) {
    if (enumIndex == null) {
      enumIndex = defaultEnum;
    }
    return getIndex(enumIndex);
  }

  public static Integer getIndex(EnumIndex enumIndex, Integer defaultIndex) {
    if (enumIndex == null) {
      return defaultIndex;
    }
    return getIndex(enumIndex);
  }
}
