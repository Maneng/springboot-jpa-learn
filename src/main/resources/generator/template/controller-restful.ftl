package com.maneng.jpa.demo.controller;

import com.maneng.jpa.demo.dto.${modelNameUpperCamel}DTO;
import com.maneng.jpa.demo.foundation.base.result.Result;
import com.maneng.jpa.demo.service.${modelNameUpperCamel}Service;
import org.springframework.web.bind.annotation.*;

/**
* Created by ${author} on ${date}.
*/
@RestController
@RequestMapping("/${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller {

    private final ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    public ${modelNameUpperCamel}Controller(${modelNameUpperCamel}Service ${modelNameLowerCamel}Service) {
        this.${modelNameLowerCamel}Service = ${modelNameLowerCamel}Service;
    }

    @PostMapping
    public Result<${modelNameUpperCamel}DTO> saveOrUpdate${modelNameUpperCamel}(${modelNameUpperCamel}DTO ${modelNameLowerCamel}DTO) {
        return ${modelNameLowerCamel}Service.saveOrUpdate${modelNameUpperCamel}(${modelNameLowerCamel}DTO);
    }

    @GetMapping("/{id}")
    public Result<${modelNameUpperCamel}DTO> get${modelNameUpperCamel}(@PathVariable(name = "id") Long id) {
        return ${modelNameLowerCamel}Service.get${modelNameUpperCamel}(id);
    }

    @DeleteMapping("/{id}")
    public Result<Void> delete${modelNameUpperCamel}(@PathVariable(name = "id") Long id) {
        return ${modelNameLowerCamel}Service.delete${modelNameUpperCamel}(id);
    }
}
