package com.maneng.jpa.demo.foundation.base.utils;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by jiangyu on 2015-11-16 20:30.
 */
public class TimeFormatUtils {

  public static ZoneId CHINA = ZoneId.of("Asia/Shanghai");
  public static String DATETIME_FORMAT_PATTERN = "yyyyMMdd HH:mm:ss";

  private static Map<String, DateTimeFormatter> formatterMap = new HashMap<>();

  private static DateTimeFormatter monthFormat = DateTimeFormatter.ofPattern("yyyyMM").withZone(CHINA);
  private static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMdd").withZone(CHINA);
  private static DateTimeFormatter datetimeFormat = DateTimeFormatter.ofPattern(DATETIME_FORMAT_PATTERN)
      .withLocale(Locale.CHINA).withZone(CHINA);
  private static DateTimeFormatter datetimeFormatHours = DateTimeFormatter.ofPattern("yyyyMMddHH")
      .withLocale(Locale.CHINA).withZone(CHINA);

  private static NumberText nt = NumberText.getInstance(NumberText.Lang.ChineseSimplified);

  public static DateTimeFormatter getFormatter(String pattern, ZoneId zone) {
    DateTimeFormatter formatter = formatterMap.get(pattern + zone.getId());
    if (formatter == null) {
      formatter = DateTimeFormatter.ofPattern(pattern).withZone(zone);
      formatterMap.put(pattern + zone.getId(), formatter);
    }
    return formatter;
  }

  public static String convertDuration(Long time) {
    if (null == time) {
      return null;
    }
    Instant now = Instant.now();
    Instant timeInstant = Instant.ofEpochMilli(time);
    Duration times = Duration.between(timeInstant, now);
    Instant startOfDay = TimeUtils.getStartOfDay(now.toEpochMilli());
    Duration todayPassed = Duration.between(startOfDay, now);
    long minutes = times.toMinutes();
    if (minutes < 1) {
      return "刚刚";
    }
    long hours = times.toHours();
    if (hours < 1) {
      return minutes + "分钟前";
    }
    long days = times.toDays();
    if (days < 1) {
      return hours + "小时前";
    }

    if (days < 1 || times.toMinutes() < (todayPassed.toMinutes() + (60 * 24))) {
      return "昨天 " + getFormatter("HH:mm", CHINA).format(Instant.ofEpochMilli(time));
    }
    if (days < 2 || times.toMinutes() < (todayPassed.toMinutes() + (60 * 24 * 2))) {
      return "前天 " + getFormatter("HH:mm", CHINA).format(Instant.ofEpochMilli(time));
    }

    return getFormatter("yyyy-MM-dd HH:mm", CHINA).format(Instant.ofEpochMilli(time));
  }

  public static String convertDurationText(Long time) {
    if (null == time) {
      return null;
    }
    Instant now = Instant.now();
    Instant timeInstant = Instant.ofEpochMilli(time);
    Instant startOfDay = TimeUtils.getStartOfDay(now.toEpochMilli());
    Duration todayPassed = Duration.between(startOfDay, now);
    Duration times = Duration.between(timeInstant, now);
    long minutes = times.toMinutes();
    if (minutes < 1) {
      return "刚刚";
    }
    long hours = times.toHours();
    if (hours < 1) {
      return minutes + "分钟前";
    }
    long days = times.toDays();
    if (days < 1 && times.toMinutes() < todayPassed.toMinutes()) {
      return hours + "小时前";
    }

    if (days < 1 || times.toMinutes() < (todayPassed.toMinutes() + (60 * 24))) {
      return "昨天";
    }
    if (days < 2 || times.toMinutes() < (todayPassed.toMinutes() + (60 * 24 * 2))) {
      return "前天";
    }
    if (days < 7 || times.toMinutes() < (todayPassed.toMinutes() + (60 * 24 * 7))) {
      return nt.getText(days) + "天前";
    }

    if (days < 30) {
      return nt.getText(days / 7) + "周前";
    } else if (days < 365) {
      return nt.getText(days / 30) + "个月前";
    } else {
      return nt.getText(days / 365) + "年前";
    }
  }

  /**
   * 把秒转换成用户友好的格式:  01:23:12
   */
  public static String coverToHumanDisplay(long second, Boolean standard) {
    if (null == standard) {
      standard = false;
    }
    long hours = second / 3600;
    long minutes = (second % 3600) / 60;
    long seconds = second % 60;
    if (hours > 0 || standard) {
      return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    } else {
      return String.format("%02d:%02d", minutes, seconds);
    }
  }

  public static String convertToPaceDisplay(Integer pace, String defaultValue) {
    if (null == pace) {
      if (null != defaultValue) {
        return defaultValue;
      } else {
        return null;
      }
    }
    int minutes = pace / 60;
    int seconds = pace % 60;
    try {
      return String.format("%02d'%02d''", minutes, seconds);
    } catch (IllegalFormatException e) {
      if (null != defaultValue) {
        return defaultValue;
      } else {
        return null;
      }
    }
  }

  public static String convertToPaceDisplay(Integer pace, Integer distance, String minDefaultPace,
      String maxDefaultPace) {
    if (null == pace) {
      if (null != minDefaultPace) {
        return minDefaultPace;
      } else {
        return null;
      }
    }
    int minutes = pace / 60;
    if (minutes > 60 && NumberUtils.compare(distance, 0L) >= 0) {
      return maxDefaultPace;
    }
    return convertToPaceDisplay(pace, minDefaultPace);
  }

  public static String formatDateTime(TemporalAccessor temporal) {
    if (temporal == null) {
      return null;
    }
    return datetimeFormat.format(temporal);
  }

  public static String formatDate(TemporalAccessor temporal) {
    if (temporal == null) {
      return null;
    }
    return dateFormat.format(temporal);
  }

  public static String formatMonth(TemporalAccessor temporal) {
    if (temporal == null) {
      return null;
    }
    return monthFormat.format(temporal);
  }

  public static String formatDate(Long millSecond) {
    if (millSecond == null) {
      return null;
    }
    return dateFormat.format(Instant.ofEpochMilli(millSecond));
  }

  public static String formatDateTime(Long millSecond) {
    if (millSecond == null) {
      return null;
    }
    return datetimeFormat.format(Instant.ofEpochMilli(millSecond));
  }

  public static String formatDateHourTime(Long millSecond) {
    if (millSecond == null) {
      return null;
    }
    return datetimeFormatHours.format(Instant.ofEpochMilli(millSecond));
  }

  public static String formatDateTime(Long millSecond, String format) {
    if (millSecond == null) {
      return null;
    }
    return getFormatter(format, CHINA).format(Instant.ofEpochMilli(millSecond));
  }

  public static String formatMonth(Long millSecond) {
    if (millSecond == null) {
      return null;
    }
    return monthFormat.format(Instant.ofEpochMilli(millSecond));
  }

  public static LocalDate fromDateString(String date) {
    return LocalDate.parse(date, dateFormat);
  }

  /**
   * 计算时间格式01:02:03的秒值
   */
  public static Long getSecondFromString(String time) {
    if (StringUtils.isBlank(time)) {
      return 0L;
    }

    Long second = 0L;
    String[] timeArray = time.split(":");
    if (timeArray.length == 3) {
      second = Long.parseLong(timeArray[0]) * 3600 + Long.parseLong(timeArray[1]) * 60 + Long.parseLong(timeArray[2]);
    } else if (timeArray.length == 2) {
      second = Long.parseLong(timeArray[0]) * 60 + Long.parseLong(timeArray[1]);
    } else if (timeArray.length == 1) {
      second = Long.parseLong(timeArray[0]);
    }
    return second;
  }

  /**
   * 将时间格式由01:02:03转换为01小时02分钟03秒 00:02:03转换为02分钟03秒
   */
  public static String formatTimeDate(String stringTime) {
    if (StringUtils.isBlank(stringTime) || stringTime.split(":").length != 3) {
      return "0秒";
    }

    String[] timeArray = stringTime.split(":");
    StringBuilder sb = new StringBuilder();
    if (!Objects.equals("00", timeArray[0])) {
      sb.append(subZeroString(timeArray[0])).append("小时");
    }
    if (sb.length() > 0 || !Objects.equals("00", timeArray[1])) {
      sb.append(subZeroString(timeArray[1])).append("分钟");
    }
    if (sb.length() > 0 || !Objects.equals("00", timeArray[2])) {
      sb.append(subZeroString(timeArray[2])).append("秒");
    }
    if (sb.length() == 0) {
      return "0秒";
    }
    return sb.toString();
  }

  public static String subZeroString(String str) {
    if (str == null) {
      return null;
    }
    if (!str.startsWith("0")) {
      return str;
    }
    return str.substring(1);
  }
}
