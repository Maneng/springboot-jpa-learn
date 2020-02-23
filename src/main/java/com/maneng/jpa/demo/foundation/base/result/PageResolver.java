package com.maneng.jpa.demo.foundation.base.result;


import static java.lang.Math.ceil;

/**
 * Created by jiangyu on 2016-06-03 18:40.
 */
public class PageResolver {

  /**
   * 生成通用的PageDTO
   *
   * @param pageNo 当前的页数
   * @param pageSize 一页的元素个数
   * @param totalCount 元素总数
   */
  public static PageInfo createPageInfo(Integer pageNo, Integer pageSize, Long totalCount) {
    PageInfo pageInfo = new PageInfo();
    if (pageNo == null) {
      pageNo = 0;
    }
    if (totalCount == null) {
      totalCount = 0L;
    }
    if (pageSize == null || pageSize == 0) {
      pageInfo.setNextCursor(null);
      pageInfo.setTotalNum(totalCount);
      pageInfo.setPage(pageNo);
      pageInfo.setPageSize(0);
    }

    int nextPage = pageNo + 1;
    if (nextPage >= ceil((float) totalCount / (float) pageSize)) {
      pageInfo.setNextCursor(null);
    } else {
      pageInfo.setNextCursor(String.valueOf(pageNo + 1));
    }
    pageInfo.setTotalNum(totalCount);
    pageInfo.setPageSize(pageSize);
    pageInfo.setPage(pageNo);
    return pageInfo;
  }

  /**
   * 转换service的页数请求参数 gateway 传来空或者<0 还是会正常请求到第一页数据
   */
  public static Integer getPageNo(Integer pageNo) {
    if (null == pageNo || pageNo < 0) {
      return 0;
    } else {
      return pageNo;
    }
  }

  public static int getStart(Integer pageNo, Integer pageSize) {

    int start = pageNo * pageSize;
    return start;
  }

  public static int getEnd(Integer pageNo, Integer pageSize) {

    int end = pageNo * pageSize + pageSize;
    return end;
  }

  /**
   * 转换service的pageSize参数
   */
  public static Integer getPageSize(Integer pageSize, Integer defaultSize) {
    if (null == pageSize || pageSize <= 0) {
      pageSize = defaultSize;
    }
    return pageSize;
  }

  public static Integer getPageFromCursor(String nextCursor) {
    Integer pageNo;
    try {
      if (null == nextCursor) {
        pageNo = 0;
      } else {
        pageNo = Integer.parseInt(nextCursor);
      }
    } catch (NumberFormatException nfe) {
      return 0;
    }
    return pageNo;
  }
}
