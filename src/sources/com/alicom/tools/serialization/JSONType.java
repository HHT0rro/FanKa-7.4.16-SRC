package com.alicom.tools.serialization;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class JSONType<T> {
    private Constructor mConstructor;
    private Class<? super T> mGenericsClz;

    public static Type getSuperclassTypeParameter(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return JSONHelper.canonicalize(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    private void setup() {
        Class<? super T> cls = (Class<? super T>) JSONHelper.getRawType(getSuperclassTypeParameter(getClass()));
        this.mGenericsClz = cls;
        if (cls == null) {
            throw new IllegalArgumentException("JsonType's generics is not recognizable!");
        }
        try {
            this.mConstructor = cls.getDeclaredConstructor(new Class[0]);
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        }
    }

    public T newInstance() {
        if (this.mConstructor == null) {
            setup();
        }
        Constructor constructor = this.mConstructor;
        if (constructor == null) {
            return null;
        }
        try {
            constructor.setAccessible(true);
            return (T) this.mConstructor.newInstance(new Object[0]);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (InstantiationException e10) {
            e10.printStackTrace();
            return null;
        } catch (InvocationTargetException e11) {
            e11.printStackTrace();
            return null;
        }
    }
}
