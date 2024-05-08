package com.cupidapp.live.base.utils;

import android.app.Application;
import java.lang.reflect.Method;

/* compiled from: AppApplicationUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class b {
    public static String a() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
