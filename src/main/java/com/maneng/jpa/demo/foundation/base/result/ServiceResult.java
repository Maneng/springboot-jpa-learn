package com.maneng.jpa.demo.foundation.base.result;

import com.maneng.jpa.demo.foundation.base.error.ErrorException;
import com.maneng.jpa.demo.foundation.base.error.Errors;

/**
 * Created by jiangyu on 2015-11-18 21:24.
 */
public interface ServiceResult<T> {

  String getCode();

  String getMessage();

  /**
   * 返回结果，如果有异常则抛出异常
   */
  T getResult() throws ErrorException;

  /**
   * 返回结果，如果存在异常或者数据为空，则返回设置的默认数据
   */
  T get(T defaultValue);

  boolean isSuccess();

  boolean isError();

  Errors getErrors();

  Exception getException();

  String getMethod();

  String getUrl();
}
