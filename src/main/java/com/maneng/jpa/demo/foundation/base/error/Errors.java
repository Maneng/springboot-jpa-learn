package com.maneng.jpa.demo.foundation.base.error;

import com.google.common.collect.Lists;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.helpers.MessageFormatter;

/**
 * 类型(系统|业务) 等级 - 系列 - 来源 优先级 - 错误码 S0-0001-13-101 Created by jiangyu on 2015-10-20 14:21.
 */
public class Errors implements Cloneable {

  private static final long serialVersionUID = 95989539144701450L;
  private SeriesType seriesType;
  private LevelType levelType;
  private Code code;
  private StringBuilder message = new StringBuilder();

  private List<Errors> details;

  private boolean readOnly;

  Errors copy() {
    Errors newErrors = new Errors().setCode(this.getCode()).setLevelType(this.getLevelType())
        .setMessage(this.message.toString()).setSeriesType(getSeriesType());

    return newErrors;
  }

  private Errors getWritableErrors(Object value) {
    if (value != null && readOnly) {
      return this.copy();
    } else {
      return this;
    }
  }

  public Errors addErrors(Errors... errors) {
    return addErrors(Lists.newArrayList(errors));
  }

  public Errors addErrors(List<Errors> errors) {
    if (errors != null) {
      Errors error = this;
      if (readOnly) {
        error = copy();
      }
      if (error.details == null) {
        error.details = new LinkedList<>();
      }
      Errors finalError = error;
      errors.stream().filter(e -> e != null).forEach(e -> finalError.details.add(e));
      return error;
    }
    return this;
  }

  public List<Errors> getDetails() {
    return details;
  }

  private Errors getWritableErrors() {
    return getWritableErrors(this);
  }

  public boolean isWarning() {
    if (levelType != null) {
      return levelType.getLevel() == LevelType.WARNING.getLevel();
    }
    return false;
  }

  public boolean isError() {
    if (levelType != null) {
      return levelType.getLevel() == LevelType.ERROR.getLevel();
    }
    return false;
  }


  public SeriesType getSeriesType() {
    if (seriesType == null) {
      return SeriesTypes.DEFAULT;
    }
    return seriesType;
  }

  public Errors setSeriesType(SeriesType seriesType) {
    if (seriesType == null) {
      return this;
    }
    Errors errors = getWritableErrors(seriesType);
    errors.seriesType = seriesType;
    return errors;
  }

  public Errors appendMsg(String format, Object... args) {
    if (format == null) {
      return this;
    }
    Errors errors = getWritableErrors(format);
    if (args == null || args.length == 0) {
      errors.setMessage(errors.getMessage().concat(format));
    } else {
      errors.setMessage(errors.getMessage().concat(MessageFormatter.arrayFormat(format, args).getMessage()));
    }
    return errors;
  }

  public Code getCode() {
    return code;
  }

  public Errors setCode(Code code) {
    if (code == null) {
      return this;
    }
    Errors errors = getWritableErrors(code);
    errors.code = code;
    return errors;
  }

  public Errors setCode(Integer codeId, String msg) {
    Code code = new Code(codeId, msg);
    Errors errors = getWritableErrors(code);
    errors.code = code;
    return errors;
  }

  public LevelType getLevelType() {
    return levelType;
  }

  public Errors setLevelType(LevelType levelType) {
    if (levelType == null) {
      return this;
    }
    Errors errors = getWritableErrors(levelType);
    errors.levelType = levelType;
    return errors;
  }

  public String getMessage() {
    if (StringUtils.isEmpty(message) && code != null) {
      return code.getComment();
    }
    return message.toString();
  }

  /**
   * 使用Format设置错误的Message，Format的格式参考Slf4j的方式，使用{}作为占位符
   *
   * @param format
   * @param args
   * @return
   */
  public Errors setMessage(String format, Object... args) {
    if (format == null) {
      return this;
    }
    Errors errors = getWritableErrors(format);
    if (args == null || args.length == 0) {
      errors.message = new StringBuilder(format);
    } else {
      errors.message = new StringBuilder(MessageFormatter.arrayFormat(format, args).getMessage());
    }
    return errors;
  }

  public String getCodeString() {
    return levelType.toString() + "-" + getSeriesType() + "-" + code;
  }

  public String getCodeStringWithMsg() {
    if (getMessage() != null) {
      return getCodeString() + " " + getMessage();
    } else {
      return getCodeString();
    }
  }

  public Errors readOnly() {
    return setReadOnly(true);
  }

  Errors setReadOnly(boolean readOnly) {
    this.readOnly = readOnly;
    return this;
  }

  @Override
  public String toString() {
    return getCodeStringWithMsg();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Errors errors = (Errors) o;

    if (readOnly != errors.readOnly) {
      return false;
    }
    if (seriesType != null ? !seriesType.equals(errors.seriesType) : errors.seriesType != null) {
      return false;
    }
    if (levelType != errors.levelType) {
      return false;
    }
    if (code != null ? !code.equals(errors.code) : errors.code != null) {
      return false;
    }
    if (message != null ? !message.equals(errors.message) : errors.message != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(seriesType, levelType, code, message);
  }
}