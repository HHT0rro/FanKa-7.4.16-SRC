package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class s {

    /* renamed from: b, reason: collision with root package name */
    public static Map<String, l1> f30207b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private static s f30208c;

    /* renamed from: a, reason: collision with root package name */
    private g1 f30209a = new g1();

    private s() {
    }

    public static s c() {
        if (f30208c == null) {
            d();
        }
        return f30208c;
    }

    private static synchronized void d() {
        synchronized (s.class) {
            if (f30208c == null) {
                f30208c = new s();
            }
        }
    }

    public l1 a(String str) {
        return f30207b.get(str);
    }

    public Set<String> a() {
        return f30207b.h();
    }

    public void a(String str, l1 l1Var) {
        f30207b.put(str, l1Var);
    }

    public g1 b() {
        return this.f30209a;
    }
}
