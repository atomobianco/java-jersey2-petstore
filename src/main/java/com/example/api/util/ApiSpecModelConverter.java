package com.example.api.util;

import com.example.api.controller.Link;
import com.wordnik.swagger.converter.SwaggerSchemaConverter;
import com.wordnik.swagger.annotations.ApiModelProperty;
import java.lang.reflect.Field;

public class ApiSpecModelConverter extends SwaggerSchemaConverter {

    @Override
    public scala.Option<com.wordnik.swagger.model.Model> read(java.lang.Class<?> cls, scala.collection.immutable.Map<java.lang.String, java.lang.String> typeMap) {
        scala.Option<com.wordnik.swagger.model.Model> ret = super.read(cls, typeMap);
        if ( Link.class.isAssignableFrom( cls ) ) {
            Class<?> clazz = cls;
            while ( clazz.getSuperclass( ) != null ) {
                for (Field f : clazz.getDeclaredFields()) {
                    try {
                        if (f.isAnnotationPresent(ApiModelProperty.class)) {
                            if (f.getAnnotation(ApiModelProperty.class).access().isEmpty() == false) {
                                ret.get().properties().remove(f.getName());
                            }
                        }
                    } catch (SecurityException e) {
                    }
                }
            }
        }
        return ret;
    }

}
