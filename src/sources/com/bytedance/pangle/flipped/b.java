package com.bytedance.pangle.flipped;

import android.util.Log;
import dalvik.system.VMRuntime;
import java.lang.reflect.Method;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b implements c {
    @Override // com.bytedance.pangle.flipped.c
    public final void invokeHiddenApiRestrictions() {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Method method = (Method) declaredMethod.invoke(VMRuntime.class, "getRuntime", new Class[0]);
            method.setAccessible(true);
            Object invoke = method.invoke(null, new Object[0]);
            Method method2 = (Method) declaredMethod.invoke(VMRuntime.class, "setHiddenApiExemptions", new Class[]{String[].class});
            method2.setAccessible(true);
            method2.invoke(invoke, new String[]{"L"});
        } catch (Exception e2) {
            new StringBuilder("V1 invokeHiddenApiRestrictions fail: ").append(Log.getStackTraceString(e2));
        }
    }
}
