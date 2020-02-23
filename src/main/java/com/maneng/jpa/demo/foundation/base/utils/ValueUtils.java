package com.maneng.jpa.demo.foundation.base.utils;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by jiangyu on 2019-02-27 11:48.
 */
public class ValueUtils {

  public static void setStringIfNotBlank(Supplier<String> supplier, Consumer<String> consumer) {
    setValue(v -> StringUtils.isNotBlank(v), supplier, consumer, null);
  }

  public static <T> void setValueIfNotNull(Supplier<T> supplier, Consumer<T> consumer) {
    setValueIfNotNull(supplier, consumer, null);
  }

  public static <T> void setValueIfNotNull(Supplier<T> supplier, Consumer<T> consumer, T defaultVal) {
    setValue(v -> v != null, supplier, consumer, defaultVal);
  }

  public static <T> void setValue(Predicate<T> predicate, Supplier<T> supplier, Consumer<T> consumer, T defaultVal) {
    if (supplier == null || consumer == null) {
      return;
    }
    T value = supplier.get();
    if (predicate.test(value)) {
      consumer.accept(value);
      return;
    } else if (defaultVal != null) {
      consumer.accept(defaultVal);
    }
  }
}
