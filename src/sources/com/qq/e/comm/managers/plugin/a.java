package com.qq.e.comm.managers.plugin;

import com.tencent.bugly.crashreport.CrashReport;
import java.lang.reflect.Method;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Method f38294a;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f38295b;

    public static void a(Throwable th, String str) {
        try {
            Exception exc = new Exception("插件错误：" + str, th);
            if (f38295b) {
                return;
            }
            if (f38294a == null) {
                Method declaredMethod = CrashReport.class.getDeclaredMethod("postCatchedException", Throwable.class);
                f38294a = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            f38294a.invoke(null, exc);
        } catch (Throwable unused) {
            f38295b = true;
        }
    }
}
