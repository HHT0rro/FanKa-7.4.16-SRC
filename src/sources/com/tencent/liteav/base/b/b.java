package com.tencent.liteav.base.b;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final long f42752a = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, a> f42753b = new HashMap();

    public final synchronized a a(String str) {
        a aVar;
        aVar = this.f42753b.get(str);
        if (aVar == null) {
            aVar = new a(f42752a);
            this.f42753b.put(str, aVar);
        }
        return aVar;
    }
}
