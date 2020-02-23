package com.maneng.jpa.demo.foundation.base.utils;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by jiangyu on 2017-05-02 15:59.
 */
public class ExtendCollectors {

  public static <T, K, U> Collector<T, ?, Map<K, U>> toLinkedMap(Function<? super T, ? extends K> keyMapper,
      Function<? super T, ? extends U> valueMapper) {
    return Collectors.toMap(keyMapper, valueMapper, (u, v) -> {
      throw new IllegalStateException(String.format("Duplicate key %s", u));
    }, LinkedHashMap::new);
  }

  public static <T> Collector<T, ?, Set<T>> toLinkedSet() {
    return Collectors.toCollection(LinkedHashSet::new);
  }

  public static <T> Collector<T, ?, List<T>> toLinkedList() {
    return Collectors.toCollection(LinkedList::new);
  }
}
