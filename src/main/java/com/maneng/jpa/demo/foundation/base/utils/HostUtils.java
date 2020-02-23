package com.maneng.jpa.demo.foundation.base.utils;

import java.net.UnknownHostException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jiangyu on 2016-01-22 22:54.
 */
public class HostUtils {

  private final static Logger logger = LoggerFactory.getLogger(HostUtils.class);
  //docker的宿主机的IP
  private final static String HOST_IP_KEY = "container.host.ip";
  private static String hostAddress;

  static {
    hostAddress = readHostAddress();
  }

  /**
   * 获取宿主机的IP信息,如果没有则返回当前机器的IP
   */
  private static String readHostAddress() {
    String ip = System.getProperty(HOST_IP_KEY);
    if (StringUtils.isEmpty(ip)) {
      try {
        ip = IpAddressUtils.getFirstNonLoopBackAddress().getHostAddress();
      } catch (UnknownHostException e) {
        return null;
      }
    }
    if (StringUtils.isNotBlank(ip)) {
      String[] ips = StringUtils.split(ip, ",");
      if (ips.length > 0) {
        ip = StringUtils.trim(ips[0]);
      }
    }
    logger.debug("Detective container host ip is {}", ip);
    return ip;
  }

  public static String getFirstAddress(String ip) {
    return getFirstAddress(getFirstAddress(ip, ","), " ");
  }

  private static String getFirstAddress(String ip, String splitToken) {
    if (StringUtils.isNotBlank(ip)) {
      String[] ips = StringUtils.split(ip, splitToken);
      if (ips.length > 0) {
        ip = StringUtils.trim(ips[0]);
      }
    }
    return ip;
  }

  public static String getHostAddress() {
    return hostAddress;
  }

  public static Boolean isHostAddress(String address) {
    return StringUtils.equals(address, hostAddress);
  }
}
