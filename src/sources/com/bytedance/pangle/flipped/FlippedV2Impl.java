package com.bytedance.pangle.flipped;

import android.util.Log;
import androidx.annotation.Keep;
import dalvik.system.VMRuntime;
import java.lang.reflect.Method;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FlippedV2Impl implements c {
    private static final String TAG = "FlippedV2Impl";

    static {
        System.loadLibrary("pangleflipped");
    }

    private native Method getDeclaredMethod(Object obj, String str, Class<?>[] clsArr);

    @Override // com.bytedance.pangle.flipped.c
    public void invokeHiddenApiRestrictions() {
        try {
            Method declaredMethod = getDeclaredMethod(VMRuntime.class, "getRuntime", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Method declaredMethod2 = getDeclaredMethod(VMRuntime.class, "setHiddenApiExemptions", new Class[]{String[].class});
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(invoke, new String[]{"L"});
        } catch (Exception e2) {
            new StringBuilder("V2 invokeHiddenApiRestrictions fail: ").append(Log.getStackTraceString(e2));
        }
    }
}
