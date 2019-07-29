package com.lhx.spring.step1.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by lihuaixin on 2019/7/15 14:42
 */
public class DogImportSelector implements ImportSelector {
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.lhx.spring.step1.bean.Dog"};
    }
}
