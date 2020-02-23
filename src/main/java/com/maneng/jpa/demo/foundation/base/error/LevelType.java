package com.maneng.jpa.demo.foundation.base.error;


import com.maneng.jpa.demo.foundation.base.enums.EnumIndex;
import com.maneng.jpa.demo.foundation.base.utils.EnumUtils;

/**
 * 错误的等级,部分错误只是警告,可以作为判断是否失败的依据 Created by jiangyu on 2015-10-21 16:22.
 */
public enum LevelType implements EnumIndex {
  INFO(2), WARNING(1), ERROR(0);
  private int level;

  LevelType(int level) {
    this.level = level;
  }

  public int getLevel() {
    return level;
  }

  public static LevelType getLevel(int index) {
    return EnumUtils.getEnumByIndex(LevelType.class, index);
  }

  @Override
  public String toString() {
    return String.valueOf(level);
  }

  @Override
  public int getIndex() {
    return getLevel();
  }
}
