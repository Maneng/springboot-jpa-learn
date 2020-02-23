package com.maneng.jpa.demo.foundation.base.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by jiangyu on 2016-01-15 14:31.
 */
public interface EnumString extends EnumCode<String> {

  String getCode();

  default boolean equalsCode(String code) {
    if (code == null) {
      return false;
    } else {
      return StringUtils.equals(code, getCode());
    }
  }
}
