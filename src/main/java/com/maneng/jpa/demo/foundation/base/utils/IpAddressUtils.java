package com.maneng.jpa.demo.foundation.base.utils;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by jiangyu on 2016-01-22 23:02.
 */
public class IpAddressUtils {

  public static InetAddress getFirstNonLoopBackAddress() throws UnknownHostException {
    try {
      for (Enumeration<NetworkInterface> enumNic = NetworkInterface.getNetworkInterfaces();
          enumNic.hasMoreElements(); ) {
        NetworkInterface ifc = enumNic.nextElement();
        if (ifc.isUp()) {
          for (Enumeration<InetAddress> enumAddr = ifc.getInetAddresses(); enumAddr.hasMoreElements(); ) {
            InetAddress address = enumAddr.nextElement();
            if (address instanceof Inet4Address && !address.isLoopbackAddress() && StringUtils
                .startsWith(ifc.getName(), "e")) {
              return address;
            }
          }
        }
      }
    } catch (IOException ex) {
    }
    return InetAddress.getLocalHost();
  }
}
