package com.maneng.jpa.demo.foundation.base.utils;


import com.maneng.jpa.demo.foundation.base.enums.EnumIndex;

/**
 * Created by jiangyu on 2016-05-09 20:34.
 */
public enum TimePeriod implements EnumIndex {
  HOURLY("h", 0), DAILY("d", 1), WEEKLY("w", 2), MONTHLY("m", 3), SEASONLY("s", 4), YEARLY("y", 5);


  private String shortName;
  private int index;

  TimePeriod(String shortName, int index) {
    this.shortName = shortName;
    this.index = index;
  }

  public int getIndex() {
    return index;
  }

  public static TimePeriod getByIndex(int index) {
    return EnumUtils.getEnumByIndex(TimePeriod.class, index);
  }

  public String getShortName() {
    return shortName;
  }

  public static TimePeriod[] getDailyWeeklyMonthly() {
    return new TimePeriod[]{TimePeriod.DAILY, TimePeriod.WEEKLY, TimePeriod.MONTHLY};
  }
}
