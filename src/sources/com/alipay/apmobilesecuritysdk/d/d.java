package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class d {
    public static synchronized Map<String, String> a() {
        HashMap hashMap;
        synchronized (d.class) {
            hashMap = new HashMap();
            try {
                new com.alipay.apmobilesecuritysdk.c.b();
                hashMap.put("AE16", "");
            } catch (Throwable unused) {
            }
        }
        return hashMap;
    }

    public static synchronized Map<String, String> a(Context context) {
        HashMap hashMap;
        synchronized (d.class) {
            b0.d.a();
            b0.b.b();
            hashMap = new HashMap();
            hashMap.put("AE1", b0.d.d());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(b0.d.e() ? "1" : "0");
            hashMap.put("AE2", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(b0.d.c(context) ? "1" : "0");
            hashMap.put("AE3", sb3.toString());
            hashMap.put("AE4", b0.d.f());
            hashMap.put("AE5", b0.d.g());
            hashMap.put("AE6", b0.d.h());
            hashMap.put("AE7", b0.d.i());
            hashMap.put("AE8", b0.d.j());
            hashMap.put("AE9", b0.d.k());
            hashMap.put("AE10", b0.d.l());
            hashMap.put("AE11", b0.d.m());
            hashMap.put("AE12", b0.d.n());
            hashMap.put("AE13", b0.d.o());
            hashMap.put("AE14", b0.d.p());
            hashMap.put("AE15", b0.d.q());
            hashMap.put("AE21", b0.b.r());
        }
        return hashMap;
    }
}
