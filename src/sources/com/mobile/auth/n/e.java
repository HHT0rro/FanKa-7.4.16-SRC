package com.mobile.auth.n;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, com.mobile.auth.g.b> f37508a = new ConcurrentHashMap<>(16);

    /* renamed from: b, reason: collision with root package name */
    private static ConcurrentHashMap<String, com.cmic.sso.sdk.a> f37509b = new ConcurrentHashMap<>();

    public static void a(String str, com.cmic.sso.sdk.a aVar) {
        if (str == null || aVar == null) {
            return;
        }
        f37509b.put(str, aVar);
    }

    public static void a(String str, com.mobile.auth.g.b bVar) {
        f37508a.put(str, bVar);
    }

    public static boolean a() {
        return f37508a.isEmpty();
    }

    public static boolean a(String str) {
        return !f37508a.containsKey(str);
    }

    public static void b(String str) {
        f37508a.remove(str);
    }

    public static com.mobile.auth.g.b c(String str) {
        return f37508a.get(str);
    }

    public static com.cmic.sso.sdk.a d(String str) {
        return str != null ? f37509b.get(str) : new com.cmic.sso.sdk.a(0);
    }
}
