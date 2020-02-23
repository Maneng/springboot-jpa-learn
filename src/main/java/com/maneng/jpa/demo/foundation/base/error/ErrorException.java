package com.maneng.jpa.demo.foundation.base.error;

import java.util.Collection;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by jiangyu on 2015-11-03 13:57.
 */
public class ErrorException extends RuntimeException {

  private static final long serialVersionUID = 4245776069338321217L;

  private Errors errors;

  public ErrorException() {
  }

  public ErrorException(Errors errors) {
    super(errors == null ? null : errors.getMessage());
    this.errors = errors;
  }

  public ErrorException(String message) {
    super(message);
  }

  public ErrorException(String format, Object... args) {
    this(String.format(format, args));
  }

  public ErrorException(Throwable cause, String format, Object... args) {
    this(String.format(format, args), cause);
  }

  public ErrorException(String message, Throwable cause) {
    super(message, cause);
  }

  public ErrorException(Throwable cause) {
    super(cause);
  }

  public Errors getErrors() {
    return errors;
  }

  public ErrorException setErrors(Errors errors) {
    this.errors = errors;
    return this;
  }

  public String getLocalizedMessage() {
    return errors == null ? getMessage() : "[" + errors.getCodeString() + "] " + getMessage();
  }

  public String toString() {
    String s = getClass().getName();
    String message = getLocalizedMessage();
    return (message != null) ? (s + ": " + message) : s;
  }

  @Override
  public String getMessage() {
    String message = super.getMessage();
    if (StringUtils.isBlank(message) && errors != null) {
      message = errors.getMessage();
    }
    return message;
  }

}
