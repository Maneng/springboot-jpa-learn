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
public class JsonCoverter implements AttributeConverter<JSONObject, String> {

  private static final Logger logger = LoggerFactory.getLogger(JsonCoverter.class);

  @Override
  public String convertToDatabaseColumn(JSONObject attribute) {
    if (attribute != null) {
      return attribute.toJSONString();
    }
    return null;
  }

  @Override
  public JSONObject convertToEntityAttribute(String dbData) {
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
