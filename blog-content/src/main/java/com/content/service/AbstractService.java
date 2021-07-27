package com.content.service;

import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.reflect.ParameterizedType;

/**
 * @ClassName : AbstractService
 * @Author : yq
 * @Date: 2021-07-27
 * @Description :
 */
public abstract class AbstractService<T> {

    private Class<T> clazz = (Class<T>) (((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);

    public String getCollectionName() {
        Document document = clazz.getAnnotation(Document.class);
        return document.collation();
    }

}
