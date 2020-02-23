package com.maneng.jpa.demo.foundation.base.enums;

/**
 * Created by jiangyu on 2016-01-15 14:31.
 */
public interface EnumIndex extends EnumCode<Integer> {

  int getIndex();

  default Integer getCode() {
    return getIndex();
  }

  default boolean equalsCode(Integer index) {
    if (index == null) {
      return false;
    }
    return index == getIndex();
  }

  default Long update(boolean option, Long optionValue) {
    if (optionValue == null) {
      //            optionValue = (option ? 1L : 0 << optionKey.getPosition());
      optionValue = 0L;
    }
    if (option) {
      optionValue |= (1 << this.getIndex());
    } else {
      optionValue &= ~(1 << this.getIndex());
    }
    return optionValue;
  }

  default boolean haveOption(Long optionValue) {
    if (optionValue != null) {
      return (optionValue >>> this.getIndex() & 1) == 1;
    }
    return false;
  }

  default boolean haveOption(Long optionValue, boolean defaultVal) {
    if (optionValue != null) {
      return (optionValue >>> this.getIndex() & 1) == 1;
    }
    return defaultVal;
  }
}
