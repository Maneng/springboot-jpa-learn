package com.maneng.jpa.demo.foundation.base.result;

import java.io.Serializable;

import com.maneng.jpa.demo.foundation.base.error.ErrorException;
import com.maneng.jpa.demo.foundation.base.error.Errors;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by jiangyu on 2015-10-20 13:53.
 */
public class Result<T> implements ServiceResult<T>, Serializable {

  private static final long serialVersionUID = -7894540986403115525L;
  private Errors errors = null;
  private T result;
  private String message;
  private boolean dataOnly;
  private String code;
  private String method;
  private String url;
  public Result() {
    this(null);
  }

  public Result(T result) {
    this.result = result;
  }

  public Result(T result, String corpId) {
    setResult(result);
  }

  @Override
  public T getResult() throws ErrorException {
    if (errors != null) {
      throw new ErrorException(errors);
    }
    return result;
  }

  @Override
  public T get(T defaultValue) {
    if (result == null) {
      return defaultValue;
    }
    return result;
  }

  public Result<T> setResult(T result) {
    this.result = result;
    return setResult(result);
  }

  public Errors getErrors() {
    return errors;
  }

  @Override
  public Exception getException() {
    if (errors != null) {
      return new ErrorException(errors);
    }
    return null;
  }

  @Override
  public String getMethod() {
    return method;
  }

  @Override
  public String getUrl() {
    return url;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Result<T> setErrors(Errors errors) {
    this.errors = errors;
    return this;
  }

  public Result<T> mergeResult(Result result) {
    if (result != null) {
      setErrors(result.getErrors());
      setMessage(result.getMessage());
    }
    return this;
  }

  /**
   * 设置错误,如果第一个错误不存在,则设置第二个错误
   */
  public Result<T> setErrors(Errors errors, Errors defaultErrors) {
    if (errors == null) {
      this.errors = defaultErrors;
    } else {
      this.errors = errors;
    }
    return this;
  }

  public boolean isSuccess() {
    if (errors != null) {
      return !errors.isError() && !errors.isWarning();
    } else {
      return true;
    }
  }

  public boolean isError() {
    if (errors != null) {
      return errors.isError();
    } else {
      return false;
    }
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public String getCode() {
    if (errors != null) {
      return errors.getCodeString();
    }
    if (StringUtils.isEmpty(code) && errors == null) {
      return "200";
    }
    return code;
  }

  public String getMessage() {
    if (StringUtils.isEmpty(message) && errors != null) {
      return errors.getMessage();
    }
    if (StringUtils.isEmpty(message) && errors == null) {
      return "OK";
    }
    return message;
  }

  public Result<T> setMessage(String message) {
    this.message = message;
    return this;
  }

  @Override
  public String toString() {
    if (result == null) {
      if (errors == null) {
        return "no result.";
      } else {
        return errors.toString();
      }
    } else {
      if (errors == null) {
        return result.toString();
      } else {
        StringBuilder sb = new StringBuilder();
        sb.append(result.getClass());
        sb.append("\n");
        sb.append(errors.toString());
        return sb.toString();
      }
    }
  }

  public boolean isDataOnly() {
    return dataOnly;
  }

  public Result<T> setDataOnly(boolean dataOnly) {
    this.dataOnly = dataOnly;
    return this;
  }

}
