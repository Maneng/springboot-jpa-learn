package com.maneng.jpa.demo.assembler;
import com.maneng.jpa.demo.dto.${modelNameUpperCamel}DTO;
import com.maneng.jpa.demo.entity.${modelNameUpperCamel};
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
* Created by ${author} on ${date}.
*/
@Component
public class ${modelNameUpperCamel}Assembler {

    public ${modelNameUpperCamel}DTO assembler${modelNameUpperCamel}DTO(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        if (null == ${modelNameLowerCamel}) {
            return null;
        }

        ${modelNameUpperCamel}DTO ${modelNameLowerCamel}DTO = new ${modelNameUpperCamel}DTO();
        BeanUtils.copyProperties(${modelNameLowerCamel}, ${modelNameLowerCamel}DTO);
        return ${modelNameLowerCamel}DTO;
    }

    public ${modelNameUpperCamel} assembler${modelNameUpperCamel}(${modelNameUpperCamel}DTO ${modelNameLowerCamel}DTO) {
        if (null == ${modelNameLowerCamel}DTO) {
            return null;
        }

        ${modelNameUpperCamel} ${modelNameLowerCamel} = new ${modelNameUpperCamel}();
        BeanUtils.copyProperties(${modelNameLowerCamel}DTO, ${modelNameLowerCamel});
        return ${modelNameLowerCamel};
    }
}

