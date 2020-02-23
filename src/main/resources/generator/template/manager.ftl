package com.maneng.jpa.demo.manager;
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


    public ${modelNameUpperCamel}DTO get${modelNameUpperCamel}(Long id) {
        return ${modelNameLowerCamel}Repository.get${modelNameUpperCamel}(id);
    }
}

