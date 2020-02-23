package com.maneng.jpa.demo.foundation.base.utils;

import java.time.ZonedDateTime;
import java.util.Random;
import java.util.UUID;

/**
 * Created by jiangyu on 2019-02-25 18:47.
 */
public class SnowFlake {

  private static final String SYSTEM_UID = System.getenv("POD_UID");
  private static final Random random = new Random();

  /**
   * 起始的时间戳
   */
  private final static long START_STMP = ZonedDateTime.parse("2019-01-01T00:00:00.000+08:00").toInstant()
      .toEpochMilli();

  /**
   * 每一部分占用的位数
   */
  private final static long SEQUENCE_BIT = 12; //序列号占用的位数
  private final static long MACHINE_BIT = 10;   //机器标识占用的位数
  private final static long DATACENTER_BIT = 0;//数据中心占用的位数

  /**
   * 每一部分的最大值
   */
  private final static long MAX_DATACENTER_NUM = -1L ^ (-1L << DATACENTER_BIT);
  private final static long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
  private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);

  /**
   * 每一部分向左的位移
   */
  private final static long MACHINE_LEFT = SEQUENCE_BIT;
  private final static long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
  private final static long TIMESTMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;

  private long datacenterId;  //数据中心
  private long machineId;     //机器标识
  private long sequence = 0L; //序列号
  private long lastStmp = -1L;//上一次时间戳

  public SnowFlake(long machineId) {
    init(machineId);
  }

  public SnowFlake(UUID uuid) {
    init(uuid);
  }

  public SnowFlake() {
    if (SYSTEM_UID != null) {
      try {
        init(UUID.fromString(SYSTEM_UID));
      } catch (Exception e) {
        init(random.nextInt((int) MAX_MACHINE_NUM));
      }
    } else {
      init(random.nextInt((int) MAX_MACHINE_NUM));
    }
  }

  private void init(long machineId) {
    if (machineId > MAX_MACHINE_NUM || machineId < 0) {
      throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0");
    }
    this.machineId = machineId;
  }

  private void init(UUID uuid) {
    init(Math.abs(uuid.getMostSignificantBits()) % (MAX_MACHINE_NUM + 1));
  }

  /**
   * 产生下一个ID
   *
   * @return
   */
  public synchronized long nextId() {
    long currStmp = getNewstmp();
    if (currStmp < lastStmp) {
      throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
    }

    if (currStmp == lastStmp) {
      //相同毫秒内，序列号自增
      sequence = (sequence + 1) & MAX_SEQUENCE;
      //同一毫秒的序列数已经达到最大
      if (sequence == 0L) {
        currStmp = getNextMill();
      }
    } else {
      //不同毫秒内，序列号置为0
      sequence = 0L;
    }

    lastStmp = currStmp;

    return (currStmp - START_STMP) << TIMESTMP_LEFT //时间戳部分
        | datacenterId << DATACENTER_LEFT       //数据中心部分
        | machineId << MACHINE_LEFT             //机器标识部分
        | sequence;                             //序列号部分
  }

  private long getNextMill() {
    long mill = getNewstmp();
    while (mill <= lastStmp) {
      mill = getNewstmp();
    }
    return mill;
  }

  private long getNewstmp() {
    return System.currentTimeMillis();
  }
}
