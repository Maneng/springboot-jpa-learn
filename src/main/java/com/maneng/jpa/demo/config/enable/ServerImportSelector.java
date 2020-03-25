package com.maneng.jpa.demo.config.enable;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * @author maneng
 * @date created at 2020/3/25 7:38 下午
 */
public class ServerImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(EnableServer.class.getName());
        ServerType type = (ServerType) annotationAttributes.get("type");
        String[] importNames = new String[0];
        switch (type) {
            case FTP:
                importNames = new String[]{FtpServer.class.getName()};
                break;
            case HTTP:
                importNames = new String[]{HttpServer.class.getName()};
                break;
        }
        return importNames;
    }
}
