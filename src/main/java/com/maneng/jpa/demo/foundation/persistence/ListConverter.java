package com.maneng.jpa.demo.foundation.persistence;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

@Converter(autoApply = true)
public class ListConverter implements AttributeConverter<List<String>, String> {

  @Override
  public String convertToDatabaseColumn(List attribute) {
    return CollectionUtils.isEmpty(attribute) ? null : StringUtils.join(attribute, ",");
  }

  @Override
  public List<String> convertToEntityAttribute(String dbData) {
    return StringUtils.isBlank(dbData) ? Collections.emptyList() : Arrays.asList(StringUtils.split(dbData, ","));
  }
}
