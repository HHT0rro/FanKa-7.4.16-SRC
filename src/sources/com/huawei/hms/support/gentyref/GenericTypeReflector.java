package com.huawei.hms.support.gentyref;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class GenericTypeReflector {
    private GenericTypeReflector() {
    }

    public static Class<?> getType(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return (Class) ((ParameterizedType) type).getRawType();
        }
        if (type instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type;
            if (typeVariable.getBounds().length == 0) {
                return Object.class;
            }
            return getType(typeVariable.getBounds()[0]);
        }
        throw new IllegalArgumentException("not supported: " + ((Object) type.getClass()));
    }
}