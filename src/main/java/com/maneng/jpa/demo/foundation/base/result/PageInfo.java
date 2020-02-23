package com.maneng.jpa.demo.foundation.base.result;

import java.io.Serializable;

/**
 * Created by lijingyao on 15/11/13 15:45.
 */
public class PageInfo implements Serializable {

  private static final long serialVersionUID = 9083896101356208232L;
  private Integer pageSize = 0; //每页的元素个数
  private Integer page = 0; // 第几页
  private Long totalNum = 0l; //总个数
  private String nextCursor = null;// 游标.标记下一页,0,1,2.  如果是null就代表没有下一页了.
  private String previousCursor = null;

  public PageInfo() {

  }

  public PageInfo(Integer pageSize, Long totalNum, String nextCursor) {
    this.pageSize = pageSize;
    this.totalNum = totalNum;
    this.nextCursor = nextCursor;
  }

  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }


  public Long getTotalNum() {
    return totalNum;
  }

  public void setTotalNum(Long totalNum) {
    this.totalNum = totalNum;
  }

  public String getNextCursor() {
    return nextCursor;
  }

  public void setNextCursor(String nextCursor) {
    this.nextCursor = nextCursor;
  }

  public String getPreviousCursor() {
    return previousCursor;
  }

  public void setPreviousCursor(String previousCursor) {
    this.previousCursor = previousCursor;
  }
}
