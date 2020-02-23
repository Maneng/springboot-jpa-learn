package com.maneng.jpa.demo.foundation.persistence;

import java.time.ZoneId;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import static java.time.ZoneOffset.UTC;

/**
 * Created by jiangyu on 2015-12-12 15:54.
 */
@Converter(autoApply = true)
public class ZoneIdConverter implements AttributeConverter<ZoneId, String> {

  @Override
  public String convertToDatabaseColumn(ZoneId attribute) {
    if (attribute != null) {
      return attribute.getId();
    }
    return null;
  }

  @Override
  public ZoneId convertToEntityAttribute(String dbData) {
    if (dbData != null) {
      return ZoneId.of(dbData);
    }
    return UTC;
  }
}
