package com.maneng.jpa.demo.foundation.base.enums;

import java.util.Collection;
import java.util.stream.Stream;

/**
 * Created by jiangyu on 2016-01-15 14:31.
 */
public interface EnumCode<T> {

  T getCode();

  boolean equalsCode(T code);

  default boolean equalOther(EnumCode index) {
    if (index == null) {
      return false;
    }
    return equals(index.getCode());
  }

  static <T> boolean in(T code, EnumCode... indexes) {
    if (code == null) {
      return false;
    }
    if (indexes != null) {
      return Stream.of(indexes).filter(i -> i != null).anyMatch(i -> i.equalsCode(code));
    }
    return false;
  }

  static <T> boolean in(T index, Collection<? extends EnumCode> indexes) {
    if (index == null) {
      return false;
    }
    if (indexes != null) {
      return indexes.stream().filter(i -> i != null).anyMatch(i -> i.equalsCode(index));
    }
    return false;
  }

  static boolean in(EnumCode index, EnumCode... indexes) {
    if (index == null) {
      return false;
    }
    if (indexes != null) {
      return Stream.of(indexes).filter(i -> i != null).anyMatch(i -> i.equalsCode(index.getCode()));
    }
    return false;
  }

  static boolean in(EnumCode index, Collection<? extends EnumCode> indexes) {
    if (index == null) {
      return false;
    }
    if (indexes != null) {
      return indexes.stream().filter(i -> i != null).anyMatch(i -> i.equalsCode(index.getCode()));
    }
    return false;
  }

  default boolean in(EnumCode... indexes) {
    return in(this, indexes);
  }

  default boolean in(Collection<? extends EnumCode> indexes) {
    return in(this, indexes);
  }
}
