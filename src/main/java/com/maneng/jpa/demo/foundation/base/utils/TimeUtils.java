package com.maneng.jpa.demo.foundation.base.utils;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by jiangyu on 2015-12-03 11:52.
 */
public class TimeUtils {

  public static TimeZone UTC_TIME_ZONE = TimeZone.getTimeZone("UTC");
  public static ZoneId UTC = ZoneId.of("UTC");
  public static ZoneId CHINA = ZoneId.of("Asia/Shanghai");

  public final static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd");
  public final static DateTimeFormatter DATETIME_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss")
      .ofLocalizedDate(FormatStyle.SHORT).withZone(CHINA);

  public static Long getSecondTime(Long milli) {
    if (milli != null) {
      return Instant.ofEpochMilli(milli).getEpochSecond();
    }
    return null;
  }

  public static Double getIOSSecondTime(Long time) {
    if (time == null) {
      return null;
    }
    return (double) time / (double) 1000;
  }

  public static Long getTimeFromIOS(Double time) {
    if (time != null) {
      return (long) (time * 1000);
    }
    return null;
  }


  public static Instant defaultIfNull(Instant time, Instant defaultInstant) {
    if (time == null) {
      return defaultInstant;
    } else {
      return time;
    }
  }

  public static ZonedDateTime defaultIfNull(ZonedDateTime time, ZonedDateTime defaultTime) {
    if (time == null) {
      return defaultTime;
    } else {
      return time;
    }
  }

  public static LocalDate getStartOfWeek() {
    return getStartOfWeek(LocalDate.now(), Locale.CHINA);
  }

  public static LocalDate getStartOfWeek(LocalDate date, DayOfWeek dayOfWeek) {
    LocalDate start = LocalDate.from(date);
    return start.with(dayOfWeek);
  }

  public static LocalDate getStartOfWeek(LocalDate date) {
    return getStartOfWeek(date, DayOfWeek.MONDAY);
  }

  public static LocalDate getEndOfWeek(LocalDate date, DayOfWeek dayOfWeek) {
    LocalDate start = LocalDate.from(date);
    return start.with(dayOfWeek);
  }

  public static LocalDate getEndOfWeek(LocalDate date) {
    return getEndOfWeek(date, DayOfWeek.MONDAY);
  }

  public static ZonedDateTime getStartOfWeek(ZonedDateTime time, DayOfWeek dayOfWeek) {
    LocalDate start = LocalDate.from(time);
    return ZonedDateTime.of(start.with(dayOfWeek), getStartOfDay(), time.getZone());
  }

  public static ZonedDateTime getStartOfWeek(ZonedDateTime time) {
    LocalDate start = LocalDate.from(time);
    return getStartOfWeek(time, DayOfWeek.MONDAY);
  }

  public static ZonedDateTime getEndOfWeek(ZonedDateTime time, DayOfWeek endOfWeek) {
    LocalDate start = LocalDate.from(time);
    return ZonedDateTime.of(start.with(endOfWeek), getEndOfDay(), time.getZone());
  }

  public static ZonedDateTime getEndOfWeek(ZonedDateTime time) {
    return getEndOfWeek(time, DayOfWeek.SUNDAY);
  }


  public static LocalDate getEndOfWeek() {
    return getEndOfWeek(LocalDate.now(), Locale.CHINA);
  }

  public static LocalDate getStartOfWeek(LocalDate date, Locale locale) {
    TemporalField week = WeekFields.of(locale).dayOfWeek();
    LocalDate start = LocalDate.from(date);
    return start.with(week, 1);
  }

  public static ZonedDateTime getStartOfWeek(ZonedDateTime time, Locale locale) {
    TemporalField week = WeekFields.of(locale).dayOfWeek();
    LocalDate start = LocalDate.from(time);
    return ZonedDateTime.of(start.with(week, 1), getStartOfDay(), time.getZone());
  }

  public static LocalDate getEndOfWeek(LocalDate date, Locale locale) {
    TemporalField week = WeekFields.of(locale).dayOfWeek();
    LocalDate start = LocalDate.from(date);
    return start.with(week, 7);
  }

  public static ZonedDateTime getEndOfWeek(ZonedDateTime time, Locale locale) {
    TemporalField week = WeekFields.of(locale).dayOfWeek();
    LocalDate start = LocalDate.from(time);
    return ZonedDateTime.of(start.with(week, 7), getEndOfDay(), time.getZone());
  }

  /**
   * 获取一天的开始一刻
   */
  public static LocalTime getStartOfDay() {
    return LocalTime.of(0, 0, 0, 0);
  }

  /**
   * @param zoneId
   * @return
   */
  public static Instant getStartInstantOfDay(ZoneId zoneId) {
    return getStartOfDay(LocalDate.now(), zoneId).toInstant();
  }

  public static Instant getStartInstantOfDay() {
    return getStartInstantOfDay(CHINA);
  }

  /**
   * 获取当天的开始一刻
   */
  public static ZonedDateTime getStartOfDay(LocalDate date, ZoneId zoneId) {
    return date.atStartOfDay(zoneId);
  }

  /**
   * 获取当天的开始一刻
   */
  public static LocalDateTime getStartOfDay(LocalDate dateTime) {
    return LocalDateTime.of(dateTime, getStartOfDay());
  }

  /**
   * 获取当天的开始一刻
   */
  public static ZonedDateTime getStartOfDay(ZonedDateTime dateTime) {
    return ZonedDateTime.of(dateTime.toLocalDate(), getStartOfDay(), dateTime.getZone());
  }

  /**
   * 获取当天的开始一刻
   */
  public static Instant getStartOfDay(Long milliTime) {
    ZonedDateTime zdt = ZonedDateTime.ofInstant(Instant.ofEpochMilli(milliTime), CHINA);
    return (getStartOfDay(zdt)).toInstant();
  }


  /**
   * 获取当月的开始一刻
   */
  public static ZonedDateTime getStartOfMonth(ZonedDateTime dateTime) {
    return ZonedDateTime
        .of(LocalDate.of(dateTime.getYear(), dateTime.getMonth(), 1), getStartOfDay(), dateTime.getZone());
  }

  /**
   * 获取一天的最后一刻
   */
  public static LocalTime getEndOfDay() {
    return LocalTime.of(23, 59, 59, 999_999_999);
  }

  /**
   * @param zoneId
   * @return
   */
  public static Instant getEndInstantOfDay(ZoneId zoneId) {
    return getEndOfDay(LocalDate.now(), zoneId).toInstant();
  }

  public static Instant getEndInstantOfDay() {
    return getEndInstantOfDay(CHINA);
  }

  /**
   * 获取当天的最后一刻
   */
  public static LocalDateTime getEndOfDay(LocalDate dateTime) {
    return LocalDateTime.of(dateTime, getEndOfDay());
  }

  /**
   * 获取指定时区一天的最后一刻
   */
  public static ZonedDateTime getEndOfDay(LocalDate date, ZoneId zoneId) {
    return ZonedDateTime.of(date, getEndOfDay(), zoneId);
  }

  /**
   * 获取当天的最后一刻
   */
  public static Instant getEndOfDay(Long milliTime) {
    ZonedDateTime zdt = ZonedDateTime.ofInstant(Instant.ofEpochMilli(milliTime), CHINA);
    return (getEndOfDay(zdt)).toInstant();
  }

  /**
   * 获取当天的最后一刻
   */
  public static ZonedDateTime getEndOfDay(ZonedDateTime dateTime) {
    return ZonedDateTime.of(dateTime.toLocalDate(), getEndOfDay(), dateTime.getZone());
  }

  /**
   * 获取当月的最后一天
   *
   * @param year 年
   * @param month 月
   */
  public static LocalDate getEndOfMonth(int year, int month) {
    return getEndOfMonth(LocalDate.of(year, month, 1));
  }

  /**
   * 获取当月的最后一天
   *
   * @param date 日期
   */
  public static LocalDate getEndOfMonth(LocalDate date) {
    return LocalDate.of(date.getYear(), date.getMonth(), date.lengthOfMonth());
  }

  public static ZonedDateTime getEndOfMonth(ZonedDateTime dateTime) {
    return ZonedDateTime
        .of(LocalDate.of(dateTime.getYear(), dateTime.getMonth(), dateTime.toLocalDate().lengthOfMonth()),
            getEndOfDay(), dateTime.getZone());
  }

  public static Instant defaultIfNull(Instant time) {
    if (time == null) {
      return Instant.now();
    } else {
      return time;
    }
  }

  public static long compare(Calendar time1, Calendar time2) {
    if (time1 == null && time2 != null) {
      return -time2.getTimeInMillis();
    } else if (time1 != null && time2 == null) {
      return time1.getTimeInMillis();
    } else {
      return time1.getTimeInMillis() - time2.getTimeInMillis();
    }
  }

  public static Calendar getUTCCalendar(Instant instant) {
    return getCalendar(instant, UTC);
  }

  public static Calendar getCalendar(Instant instant) {
    return getCalendar(instant, ZoneId.systemDefault());
  }

  public static Calendar getCalendar(Instant instant, ZoneId zoneId) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(instant.toEpochMilli());
    calendar.setTimeZone(TimeZone.getTimeZone(zoneId));
    return calendar;
  }

  public static String getToday() {
    return getToday(CHINA);
  }

  public static String getToday(ZoneId zone) {
    return DATE_FORMAT.format(ZonedDateTime.now(zone));
  }

  public static String formatDate(TemporalAccessor temporal) {
    if (temporal == null) {
      return null;
    }
    return DATE_FORMAT.format(temporal);
  }

  public static String formatDateTime(TemporalAccessor temporal) {
    if (temporal == null) {
      return null;
    }
    return DATETIME_FORMAT.format(temporal);
  }

  public static Long getMilliSecond(Instant instant) {
    if (null == instant) {
      return null;
    } else {
      return instant.toEpochMilli();
    }
  }

  public static Long getMilliSecond(ZonedDateTime time) {
    if (null == time) {
      return null;
    } else {
      return time.toInstant().toEpochMilli();
    }
  }

  public static Instant getInstant(Long milliSecond) {
    if (milliSecond == null) {
      return null;
    } else {
      return Instant.ofEpochMilli(milliSecond);
    }
  }

  /**
   * 返回是否 source >=start & source < end
   */
  public static boolean between(Instant source, Instant start, Instant end) {
    if (null == source || null == start || null == end) {
      throw new IllegalArgumentException("Compare instant may not be null.");
    }
    return source.compareTo(start) >= 0 && source.compareTo(end) < 0;
  }

  /**
   * 返回当前时间减去<code>day</>天的起始时间 昨天就传1
   */
  public static Instant getMinusDayStart(int day) {
    LocalDate nowDate = LocalDate.now();
    LocalDate yesterday = nowDate.minus(day, ChronoUnit.DAYS);
    return getStartInstant(yesterday);
  }

  /**
   * 返回当前时间减去<code>day</>天的结束时间, 如果是day = 1,昨天的23:59:59
   */
  public static Instant getMinusDayEnd(int day) {
    LocalDate nowDate = LocalDate.now();
    LocalDate yesterday = nowDate.minus(day, ChronoUnit.DAYS);
    return getEndInstant(yesterday);
  }

  /**
   * 返回当前时间加上<code>day</>天的起始时间 明天就传1
   */
  public static Instant getPlusDayStart(int day) {
    LocalDate nowDate = LocalDate.now();
    LocalDate tomorrow = nowDate.plus(day, ChronoUnit.DAYS);
    return getStartInstant(tomorrow);
  }

  /**
   * 返回当前时间加上<code>day</>天的结束时间 明天就传1
   */
  public static Instant getPlusDayEnd(int day) {
    LocalDate nowDate = LocalDate.now();
    LocalDate tomorrow = nowDate.plus(day, ChronoUnit.DAYS);
    return getEndInstant(tomorrow);
  }

  public static Instant getEndInstant(LocalDate date) {
    ZonedDateTime dateTime = date.atTime(23, 59, 59).atZone(CHINA);
    return dateTime.toInstant();
  }

  public static Instant getStartInstant(LocalDate date) {
    ZonedDateTime dateTime = date.atTime(0, 0, 0).atZone(CHINA);
    return dateTime.toInstant();
  }


}
