package com.huawei.flexiblelayout.css.util;

import android.graphics.Rect;
import com.huawei.flexiblelayout.log.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExtDisplaySizeUtilEx.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f28016a = "ExtDisplaySizeUtilEx";

    public static Rect a(String str, String str2) {
        Object invoke;
        try {
            invoke = Class.forName(str).getMethod(str2, new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
        }
        if (invoke instanceof Rect) {
            return (Rect) invoke;
        }
        Log.w(f28016a, "getSafeAreaRect: object is not Rect");
        return null;
    }
}
