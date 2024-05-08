package com.tencent.turingface.sdk.mfa;

import android.os.Build;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class vqARY {

    /* renamed from: a, reason: collision with root package name */
    public static Map<String, spXPg> f45980a;

    /* renamed from: b, reason: collision with root package name */
    public static OTVRM f45981b;

    /* renamed from: c, reason: collision with root package name */
    public static String f45982c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class spXPg {

        /* renamed from: a, reason: collision with root package name */
        public Xjpd8 f45983a;

        /* renamed from: b, reason: collision with root package name */
        public int f45984b = 0;

        public spXPg(Xjpd8 xjpd8) {
            this.f45983a = xjpd8;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.concurrent.ConcurrentHashMap, java.util.Map<java.lang.String, com.tencent.turingface.sdk.mfa.vqARY$spXPg>] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.concurrent.ConcurrentHashMap, java.util.Map<java.lang.String, com.tencent.turingface.sdk.mfa.vqARY$spXPg>] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.concurrent.ConcurrentHashMap, java.util.Map<java.lang.String, com.tencent.turingface.sdk.mfa.vqARY$spXPg>] */
    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f45980a = concurrentHashMap;
        concurrentHashMap.put("C892BA2", new spXPg(new cPR64()));
        f45980a.put("43780D5", new spXPg(new cPR64()));
        f45980a.put("7CD3AF2", new spXPg(new cPR64()));
        f45980a.put("22792AF", new spXPg(new usfPi()));
        f45982c = "";
        try {
            f45982c = EQsUZ.a(Build.MANUFACTURER.toLowerCase().getBytes()).substring(0, 7);
        } catch (Throwable unused) {
        }
    }
}
