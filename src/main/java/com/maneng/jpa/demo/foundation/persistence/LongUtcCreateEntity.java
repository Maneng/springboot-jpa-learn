package com.maneng.jpa.demo.foundation.persistence;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

/**
 * Created by jiangyu on 2015-11-09 14:48.
 */
@MappedSuperclass
@EntityListeners({LongUtcCreateEntityListener.class})
public abstract class LongUtcCreateEntity extends LongIdentityEntity {

  @Column(name = "utc_create")
  private Instant utcCreate; // 创建时间

  public void setUtcCreate(Instant utcCreate) {
    this.utcCreate = utcCreate;
  }

  public Instant getUtcCreate() {
    return utcCreate;
  }
}
