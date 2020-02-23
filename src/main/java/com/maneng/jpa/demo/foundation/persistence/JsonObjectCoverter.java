package com.maneng.jpa.demo.foundation.persistence;

import com.alibaba.fastjson.JSONObject;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jiangyu on 2016-08-08 20:40.
 */

@Converter(autoApply = true)
public class JsonObjectCoverter implements AttributeConverter<Object, String> {

  private static final Logger logger = LoggerFactory.getLogger(JsonObjectCoverter.class);

  @Override
  public String convertToDatabaseColumn(Object attribute) {
    if (attribute != null) {
      return JSONObject.toJSONString(attribute);
    }
    return null;
  }

  @Override
  public Object convertToEntityAttribute(String dbData) {
    if (StringUtils.isNotBlank(dbData)) {
      try {
        return JSONObject.parseObject(dbData);
      } catch (Exception e) {
        logger.error("Convert json features failed. Illegal json value: {}", dbData);
      }
    }
    return null;
  }
}
