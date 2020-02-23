package com.maneng.jpa.demo.foundation.persistence;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

/**
 * Created by jiangyu on 2015-11-09 14:48.
 */
@MappedSuperclass
@EntityListeners({LongTimestampedEntityListener.class})
public abstract class LongTimestampedEntity extends LongIdentityEntity {

  @Column(name = "utc_create")
  private Instant utcCreate; // 创建时间
  @Column(name = "utc_modified")
  private Instant utcModified; // 修改时间

  public void setUtcCreate(Instant utcCreate) {
    this.utcCreate = utcCreate;
  }

  public void setUtcModified(Instant utcModified) {
    this.utcModified = utcModified;
  }

  public Instant getUtcCreate() {
    return utcCreate;
  }

  public Instant getUtcModified() {
    return utcModified;
  }

  public Long getUtcCreateMilli() {
    if (utcCreate != null) {
      return utcCreate.toEpochMilli();
    }
    return null;
  }

  public Long getUtcModifiedMilli() {
    if (utcModified != null) {
      return utcModified.toEpochMilli();
    }
    return null;
  }
}
