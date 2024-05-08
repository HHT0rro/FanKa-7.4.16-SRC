package com.mobile.auth.gatewayauth;

import android.content.res.Configuration;
import java.lang.reflect.InvocationTargetException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {
    public static float a() {
        try {
            try {
                try {
                    try {
                        Configuration configuration = new Configuration();
                        Class<?> cls = Class.forName("android.app.ActivityManagerNative");
                        Object invoke = cls.getMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
                        configuration.updateFrom((Configuration) invoke.getClass().getMethod("getConfiguration", new Class[0]).invoke(invoke, new Object[0]));
                        return configuration.fontScale;
                    } catch (ClassNotFoundException e2) {
                        e2.printStackTrace();
                        return 1.0f;
                    } catch (IllegalAccessException e10) {
                        e10.printStackTrace();
                        return 1.0f;
                    }
                } catch (NoSuchMethodException e11) {
                    e11.printStackTrace();
                    return 1.0f;
                }
            } catch (InvocationTargetException e12) {
                e12.printStackTrace();
                return 1.0f;
            }
        } catch (Throwable th) {
            ExceptionProcessor.processException(th);
            return -1.0f;
        }
    }
}
