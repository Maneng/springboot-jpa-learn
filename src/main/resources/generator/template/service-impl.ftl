package ${basePackage}.core.service.impl;

import com.maneng.jpa.demo.dto.${modelNameUpperCamel}DTO;
import com.maneng.jpa.demo.dto.${modelNameUpperCamel}QueryDTO;
import com.maneng.jpa.demo.foundation.base.result.Result;
import com.maneng.jpa.demo.service.${modelNameUpperCamel}Service;
import com.maneng.jpa.demo.manager.${modelNameUpperCamel}Manager;
import com.maneng.jpa.demo.assembler.${modelNameUpperCamel}Assembler;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by ${author} on ${date}.
 */
@Service
public class ${modelNameUpperCamel}ServiceImpl implements ${modelNameUpperCamel}Service {

    @Autowired
    // private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;

    private final ${modelNameUpperCamel}Manager ${modelNameLowerCamel}Manager;
    private final ${modelNameUpperCamel}Assembler ${modelNameLowerCamel}Assembler;

    public ${modelNameUpperCamel}ServiceImpl(${modelNameUpperCamel}Manager ${modelNameLowerCamel}Manager, ${modelNameUpperCamel}Assembler ${modelNameLowerCamel}Assembler) {
        this.${modelNameLowerCamel}Manager = ${modelNameLowerCamel}Manager;
        this.${modelNameLowerCamel}Assembler = ${modelNameLowerCamel}Assembler;
    }


    @Override
    public Result<${modelNameUpperCamel}DTO> saveOrUpdate${modelNameUpperCamel}(${modelNameUpperCamel}DTO ${modelNameLowerCamel}DTO) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Assembler.assembler${modelNameUpperCamel}(${modelNameLowerCamel}DTO);
        return new Result<>(${modelNameLowerCamel}Assembler.assembler${modelNameUpperCamel}DTO(${modelNameLowerCamel}Manager.saveOrUpdate${modelNameUpperCamel}(${modelNameLowerCamel})));
    }

    @Override
    public Result<Void> delete${modelNameUpperCamel}(Long id) {
        Result<Void> result = new Result<>();
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Manager.get${modelNameUpperCamel}(id);
        if (null == ${modelNameLowerCamel}) {
            log.info("entity not exists, ${modelNameLowerCamel} id: {}", id);
        } else {
            ${modelNameLowerCamel}Manager.delete(${modelNameLowerCamel});
        }
        return result;
    }

    @Override
    public Result<${modelNameUpperCamel}DTO> get${modelNameUpperCamel}(Long id) {
        Result<${modelNameUpperCamel}DTO> result = new Result<>();
        ${modelNameUpperCamel}DTO ${modelNameLowerCamel}DTO = ${modelNameLowerCamel}Assembler.assembler${modelNameLowerCamel}DTO(${modelNameLowerCamel}Manager.get${modelNameUpperCamel}(id));
        result.setResult(${modelNameLowerCamel}DTO);
        return result;
    }
}
