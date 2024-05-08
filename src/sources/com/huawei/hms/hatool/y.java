package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class y {

    /* renamed from: b, reason: collision with root package name */
    private static y f30243b;

    /* renamed from: a, reason: collision with root package name */
    private volatile Map<String, p0> f30244a = new HashMap();

    private y() {
    }

    private p0 a(String str) {
        if (!this.f30244a.containsKey(str)) {
            this.f30244a.put(str, new p0());
        }
        return this.f30244a.get(str);
    }

    public static y a() {
        if (f30243b == null) {
            b();
        }
        return f30243b;
    }

    private static synchronized void b() {
        synchronized (y.class) {
            if (f30243b == null) {
                f30243b = new y();
            }
        }
    }

    public p0 a(String str, long j10) {
        p0 a10 = a(str);
        a10.a(j10);
        return a10;
    }
}
