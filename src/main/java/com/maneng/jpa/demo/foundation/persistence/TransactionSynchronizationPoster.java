package com.maneng.jpa.demo.foundation.persistence;

import static org.springframework.transaction.support.TransactionSynchronizationManager.registerSynchronization;

import java.util.function.Consumer;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * 事务提交后处理的工具类 Created by jiangyu on 2017-09-30 13:50.
 */
public class TransactionSynchronizationPoster {

  public static void post(Consumer consumer) {
    if (TransactionSynchronizationManager.isSynchronizationActive()) {
      registerSynchronization(new TransactionSynchronizationAdapter() {
        public void afterCommit() {
          consumer.accept(null);
        }
      });
    } else {
      consumer.accept(null);
    }
  }
}
