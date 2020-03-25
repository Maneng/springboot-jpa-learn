package com.maneng.jpa.demo.config.enable;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author maneng
 * @date created at 2020/3/25 7:37 下午
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Import(ServerImportSelector.class)
@Import(ServerImportBeanDefinitionRegister.class)
public @interface EnableServer {

    ServerType type();
}
