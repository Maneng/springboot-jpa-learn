package com.maneng.jpa.demo.foundation.base.result;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by jiangyu on 2016-12-30 16:43.
 */
public class PageResult<T> {

  private Collection<? extends T> content;
  private PageInfo page;

  private final static PageResult EMPTY_RESULT = new PageResult();

  public Collection<? extends T> getContent() {
    if (content == null) {
      return Collections.emptyList();
    }
    return content;
  }

  public void setContent(Collection<? extends T> content) {
    this.content = content;
  }

  public PageInfo getPage() {
    if (page == null) {
      return new PageInfo();
    }
    return page;
  }

  public void setPage(PageInfo page) {
    this.page = page;
  }

  public static PageResult emptyResult() {
    EMPTY_RESULT.setContent(Collections.emptyList());
    EMPTY_RESULT.setPage(new PageInfo());
    return EMPTY_RESULT;
  }

  public static <M> PageResult<M> emptyResult(Class<M> clazz) {
    EMPTY_RESULT.setContent(Collections.emptyList());
    EMPTY_RESULT.setPage(new PageInfo());
    return EMPTY_RESULT;
  }
}
