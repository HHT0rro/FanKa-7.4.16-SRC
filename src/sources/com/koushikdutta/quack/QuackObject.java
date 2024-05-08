package com.koushikdutta.quack;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface QuackObject {
    Object callMethod(Object obj, Object... objArr);

    Object construct(Object... objArr);

    Object get(Object obj);

    boolean has(Object obj);

    boolean set(Object obj, Object obj2);
}
