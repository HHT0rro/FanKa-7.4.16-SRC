package com.tencent.turingface.sdk.mfa;

import android.os.Build;
import java.lang.reflect.Method;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class QafBz {

    /* renamed from: a, reason: collision with root package name */
    public static Object f45668a;

    /* renamed from: b, reason: collision with root package name */
    public static Method f45669b;

    static {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
                Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                Class cls = (Class) declaredMethod.invoke(null, "dalvik.system.VMRuntime");
                Method method = (Method) declaredMethod2.invoke(cls, "getRuntime", null);
                f45669b = (Method) declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
                f45668a = method.invoke(null, new Object[0]);
            } catch (Throwable unused) {
            }
        }
    }
}
