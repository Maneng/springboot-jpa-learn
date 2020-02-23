package ${basePackage}.core.service;

import com.maneng.jpa.demo.dto.${modelNameUpperCamel}DTO;
import com.maneng.jpa.demo.dto.${modelNameUpperCamel}QueryDTO;
import com.maneng.jpa.demo.foundation.base.result.Result;
import java.util.List;

/**
 * Created by ${author} on ${date}.
 */
public interface ${modelNameUpperCamel}Service{

    Result<${modelNameUpperCamel}DTO> saveOrUpdate(${modelNameUpperCamel}DTO ${modelNameLowerCamel}DTO);

    Result<Void> delete${modelNameUpperCamel}(Long id);

    Result<${modelNameUpperCamel}DTO> get${modelNameUpperCamel}(Long id);
}