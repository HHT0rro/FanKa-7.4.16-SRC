package com.google.common.reflect;

import com.google.common.base.o;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: TypeCapture.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class c<T> {
    public final Type capture() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        o.m(genericSuperclass instanceof ParameterizedType, "%s isn't parameterized", genericSuperclass);
        return ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
    }
}
