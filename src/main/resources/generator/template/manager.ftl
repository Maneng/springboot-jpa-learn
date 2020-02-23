package com.maneng.jpa.demo.manager;
import com.maneng.jpa.demo.entity.${modelNameUpperCamel};
import com.maneng.jpa.demo.repository.${modelNameUpperCamel}Repository;
import org.springframework.stereotype.Component;

/**
* Created by ${author} on ${date}.
*/
@Component
public class ${modelNameUpperCamel}Manager {

    private final ${modelNameUpperCamel}Repository ${modelNameLowerCamel}Repository;

    public ${modelNameUpperCamel}Manager(${modelNameUpperCamel}Repository ${modelNameLowerCamel}Repository) {
        this.${modelNameLowerCamel}Repository = ${modelNameLowerCamel}Repository;
    }

    public ${modelNameUpperCamel} saveOrUpdate${modelNameUpperCamel}(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        return ${modelNameLowerCamel}Repository.saveAndFlush(${modelNameLowerCamel});
    }

    public ${modelNameUpperCamel} get${modelNameUpperCamel}(Long id) {
        return ${modelNameLowerCamel}Repository.getOne(id);
    }

    public void delete(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Repository.delete(${modelNameLowerCamel});
    }
}

