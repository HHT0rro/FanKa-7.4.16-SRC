package com.koushikdutta.quack;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface QuackMethodCoercion {
    Object invoke(Method method, Object obj, Object... objArr) throws InvocationTargetException, IllegalAccessException;
}
