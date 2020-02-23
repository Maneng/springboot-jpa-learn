package com.maneng.jpa.demo.foundation.persistence;

import java.time.Instant;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * Created by jiangyu on 2015-11-09 14:47.
 */
@Configurable
public class LongTimestampedEntityListener {

  @PrePersist
  public void touchForCreate(LongTimestampedEntity target) {
    Instant now = Instant.now();
    if (target.getUtcCreate() == null) {
      target.setUtcCreate(now);
    }
    if (target.getUtcModified() == null) {
      target.setUtcModified(now);
    }
  }

  @PreUpdate
  public void touchForUpdate(LongTimestampedEntity target) {
    target.setUtcModified(Instant.now());
  }
}
