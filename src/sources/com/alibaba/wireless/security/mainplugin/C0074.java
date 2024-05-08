package com.alibaba.wireless.security.mainplugin;

import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* renamed from: com.alibaba.wireless.security.mainplugin.а, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class C0074 {

    /* renamed from: а, reason: contains not printable characters */
    private static Object f159;

    /* renamed from: б, reason: contains not printable characters */
    private static Method f160;

    /* renamed from: в, reason: contains not printable characters */
    private static Method f161;

    /* renamed from: а, reason: contains not printable characters */
    public static void m1921() {
        try {
            Class<?> cls = Class.forName("com.alibaba.wireless.security.framework.SGApmMonitorManager");
            if (cls != null) {
                Method method = cls.getMethod("getInstance", new Class[0]);
                f160 = cls.getMethod("monitorStart", String.class);
                f161 = cls.getMethod("monitorEnd", String.class);
                if (method != null) {
                    f159 = method.invoke(cls, new Object[0]);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: а, reason: contains not printable characters */
    public static void m1922(String str) {
        try {
            if (f159 == null || f161 == null) {
                return;
            }
            f161.invoke(f159, str);
        } catch (Exception unused) {
        }
    }

    /* renamed from: б, reason: contains not printable characters */
    public static void m1923(String str) {
        try {
            if (f159 == null || f160 == null) {
                return;
            }
            f160.invoke(f159, str);
        } catch (Exception unused) {
        }
    }
}
