package com.maneng.jpa.demo.foundation.base.utils;

import java.text.DecimalFormat;

/**
 * Created by lijingyao on 16/6/6 13:57.
 */
public class LocationUtils {

  public static final DecimalFormat formatTwoDecimal = new DecimalFormat("##0.00");

  private static double EARTH_RADIUS = 6378.137;

  private static double rad(double d) {
    return d * Math.PI / 180.0;
  }

  /**
   * 获取两个经纬度之间的距离(km)
   */
  public static double getDistance(double lng1, double lat1, double lng2, double lat2) {
    double radLat1 = rad(lat1);
    double radLat2 = rad(lat2);
    double a = radLat1 - radLat2;
    double b = rad(lng1) - rad(lng2);
    double s = 2 * Math.asin((Math
        .sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2))));
    s = s * EARTH_RADIUS;
    s = Math.round(s * 10000) / (double) 10000;
    return s;
  }

  public static String praseDistance(double lng1, double lat1, double lng2, double lat2) {
    double dis = getDistance(lng1, lat1, lng2, lat2);
    if (dis <= 1.0) {
      return "<1km";
    } else if (dis > 1000) {
      return ">1000km";
    } else {
      return formatTwoDecimal.format(dis) + "km";
    }
  }
}
