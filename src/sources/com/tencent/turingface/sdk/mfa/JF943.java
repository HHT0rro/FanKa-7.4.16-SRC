package com.tencent.turingface.sdk.mfa;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class JF943 {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<Class<?>, HashMap<String, Field>> f45610a;

    /* renamed from: b, reason: collision with root package name */
    public static HashMap<Class<?>, HashMap<String, Method>> f45611b;

    static {
        new HashMap();
        f45610a = new HashMap<>();
        f45611b = new HashMap<>();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0033 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0034 A[Catch: all -> 0x0039, TRY_LEAVE, TryCatch #0 {all -> 0x0039, blocks: (B:15:0x0034, B:24:0x002d, B:3:0x0001, B:5:0x000b, B:6:0x0015, B:8:0x001d, B:18:0x0024), top: B:2:0x0001, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object a(java.lang.Class<?> r3, java.lang.String r4, java.lang.Object r5) {
        /*
            r0 = 0
            java.util.HashMap<java.lang.Class<?>, java.util.HashMap<java.lang.String, java.lang.reflect.Field>> r1 = com.tencent.turingface.sdk.mfa.JF943.f45610a     // Catch: java.lang.Throwable -> L2c
            java.lang.Object r1 = r1.get(r3)     // Catch: java.lang.Throwable -> L2c
            java.util.HashMap r1 = (java.util.HashMap) r1     // Catch: java.lang.Throwable -> L2c
            if (r1 != 0) goto L15
            java.util.HashMap r1 = new java.util.HashMap     // Catch: java.lang.Throwable -> L2c
            r1.<init>()     // Catch: java.lang.Throwable -> L2c
            java.util.HashMap<java.lang.Class<?>, java.util.HashMap<java.lang.String, java.lang.reflect.Field>> r2 = com.tencent.turingface.sdk.mfa.JF943.f45610a     // Catch: java.lang.Throwable -> L2c
            r2.put(r3, r1)     // Catch: java.lang.Throwable -> L2c
        L15:
            java.lang.Object r2 = r1.get(r4)     // Catch: java.lang.Throwable -> L2c
            java.lang.reflect.Field r2 = (java.lang.reflect.Field) r2     // Catch: java.lang.Throwable -> L2c
            if (r2 != 0) goto L21
            java.lang.reflect.Field r2 = r3.getDeclaredField(r4)     // Catch: java.lang.Throwable -> L2c
        L21:
            if (r2 != 0) goto L24
            goto L30
        L24:
            r3 = 1
            r2.setAccessible(r3)     // Catch: java.lang.Throwable -> L2c
            r1.put(r4, r2)     // Catch: java.lang.Throwable -> L2c
            goto L31
        L2c:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L39
        L30:
            r2 = r0
        L31:
            if (r2 != 0) goto L34
            return r0
        L34:
            java.lang.Object r3 = r2.get(r5)     // Catch: java.lang.Throwable -> L39
            return r3
        L39:
            r3 = move-exception
            r3.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingface.sdk.mfa.JF943.a(java.lang.Class, java.lang.String, java.lang.Object):java.lang.Object");
    }

    public static Method a(Class cls) {
        try {
            if (TextUtils.isEmpty("getAccessibilityInteractionController")) {
                return null;
            }
            String stringBuffer = new StringBuffer("getAccessibilityInteractionController").toString();
            HashMap<String, Method> hashMap = f45611b.get(cls);
            if (hashMap == null) {
                hashMap = new HashMap<>();
                f45611b.put(cls, hashMap);
            }
            Method method = hashMap.get(stringBuffer);
            if (method == null) {
                method = cls.getDeclaredMethod("getAccessibilityInteractionController", null);
            }
            if (method == null) {
                return null;
            }
            method.setAccessible(true);
            hashMap.put(stringBuffer, method);
            return method;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
