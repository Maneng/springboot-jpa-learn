package com.maneng.jpa.demo.frank.enable;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.stream.Stream;

/**
 * @author maneng
 * @date created at 2020/3/25 7:49 下午
 */
public class ServerImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        ServerImportSelector serverImportSelector = new ServerImportSelector();
        String[] selectImports = serverImportSelector.selectImports(importingClassMetadata);
        Stream.of(selectImports)
                .map(BeanDefinitionBuilder::genericBeanDefinition)
                .map(BeanDefinitionBuilder::getBeanDefinition)
                .forEach(beanDefinition -> BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, registry));

    }
}
