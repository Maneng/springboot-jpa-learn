package com.maneng.jpa.demo.foundation.base.result;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * Created by jiangyu on 2016-11-09 17:38.
 */
public class PageRequest extends SortsRequest {

  private Integer page;
  private Integer pageSize;
  private String nextCursor; //下一页的游标

  public PageRequest(int page, int pageSize) {
    this.page = page;
    this.pageSize = pageSize;
  }

  public PageRequest() {
  }

  public Integer getPage() {
    return page;
  }

  public Integer getPage(int defaultPage) {

    if(page == null){
      page = getNextCursorAsInteger(defaultPage);
    }
    return page;
  }

  public PageRequest setPage(Integer page) {
    this.page = page;
    return this;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public Integer getPageSize(int defaultSize) {
    return pageSize == null ? defaultSize : pageSize;
  }

  public Integer getPageSize(int defaultSize, int maxSize) {
    return (pageSize == null || pageSize > maxSize) ? defaultSize : pageSize;
  }

  public PageRequest setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

  public String getNextCursor() {
    return nextCursor;
  }

  public String getNextCursor(String defaultCursor) {
    if (StringUtils.isBlank(nextCursor)) {
      return defaultCursor;
    }
    return nextCursor;
  }

  public Long getNextCursorAsLong(Long defaultValue) {
    if (nextCursor == null || !NumberUtils.isParsable(nextCursor)) {
      return defaultValue;
    }
    return getNextCursorAsLong();
  }

  @JSONField(serialize = false, deserialize = false)
  public Long getNextCursorAsLong() {
    if (nextCursor == null) {
      return null;
    }
    if (NumberUtils.isParsable(nextCursor)) {
      return Long.valueOf(nextCursor);
    } else {
      return null;
    }
  }

  public Integer getNextCursorAsInteger(Integer defaultValue) {
    if (nextCursor == null || !NumberUtils.isParsable(nextCursor)) {
      return defaultValue;
    }
    return Integer.valueOf(nextCursor);
  }


  public Double getNextCursorAsDouble(Double defaultValue) {
    if (nextCursor == null || !NumberUtils.isParsable(nextCursor)) {
      return defaultValue;
    }
    return getNextCursorAsDouble();
  }

  @JSONField(serialize = false, deserialize = false)
  public Double getNextCursorAsDouble() {
    if (nextCursor == null) {
      return null;
    }
    if (NumberUtils.isParsable(nextCursor)) {
      return Double.valueOf(nextCursor);
    } else {
      return null;
    }
  }

  public PageRequest setNextCursor(String nextCursor) {
    this.nextCursor = nextCursor;
    return this;
  }
}
