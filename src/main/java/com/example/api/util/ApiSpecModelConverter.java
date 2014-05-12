package com.example.api.util;

import com.example.api.controller.CollectionResource;
import com.wordnik.swagger.converter.SwaggerSchemaConverter;
import com.wordnik.swagger.annotations.ApiModelProperty;
import java.lang.reflect.Method;

public class ApiSpecModelConverter extends SwaggerSchemaConverter {

    @Override
    public scala.Option<com.wordnik.swagger.model.Model> read(java.lang.Class<?> cls, scala.collection.immutable.Map<java.lang.String, java.lang.String> typeMap) {
        scala.Option<com.wordnik.swagger.model.Model> ret = super.read(cls, typeMap);
        if ( CollectionResource.class.isAssignableFrom( cls ) ) {
            Class<?> clazz = cls;
            if ( clazz.getSuperclass( ) != null ) {
                for (Method m : clazz.getDeclaredMethods()) {
                    try {
                        if (m.isAnnotationPresent(ApiModelProperty.class)) {
                            if (m.getAnnotation(ApiModelProperty.class).access().isEmpty() == false) {
                                ret.get().properties().remove(m.getName().substring(3).toLowerCase()); // presence of 'field' is based on the presence of a 'getField' method
                            }
                        }
                    } catch (SecurityException e) { }
                }
            }
        }
        return ret;
    }

}
