package com.maneng.jpa.demo.foundation.base.utils;

import java.time.DayOfWeek;
import java.time.ZonedDateTime;

/**
 * Created by jiangyu on 2016-05-09 20:41.
 */
public class TimePeriodUtils {

  public static TimeRange<ZonedDateTime> getTimePeriodScope(ZonedDateTime time, TimePeriod period) {
    if (time != null && period != null) {
      if (TimePeriod.DAILY.equals(period)) {
        ZonedDateTime start = TimeUtils.getStartOfDay(time);
        ZonedDateTime end = TimeUtils.getEndOfDay(time);
        return new TimeRange<>(start, end);
      } else if (TimePeriod.WEEKLY.equals(period)) {
        ZonedDateTime start = TimeUtils.getStartOfWeek(time, DayOfWeek.MONDAY);
        ZonedDateTime end = TimeUtils.getEndOfWeek(time, DayOfWeek.SUNDAY);
        return new TimeRange<>(start, end);
      } else if (TimePeriod.MONTHLY.equals(period)) {
        ZonedDateTime start = TimeUtils.getStartOfMonth(time);
        ZonedDateTime end = TimeUtils.getEndOfMonth(time);
        return new TimeRange<>(start, end);
      }
    }
    return null;
  }
}
