package com.maneng.jpa.demo.foundation.persistence;

import java.time.Instant;
import javax.persistence.PrePersist;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * Created by jiangyu on 2015-11-09 14:47.
 */
@Configurable
public class LongUtcCreateEntityListener {

  @PrePersist
  public void touchForCreate(LongUtcCreateEntity target) {
    if (target.getUtcCreate() == null) {
      Instant now = Instant.now();
      target.setUtcCreate(now);
    }
  }
}
