package com.google.mlkit.common.sdkinternal;

import androidx.annotation.GuardedBy;
import androidx.annotation.RecentlyNonNull;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class e<K, V> {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("instances")
    public final Map<K, V> f27046a = new HashMap();

    @RecentlyNonNull
    public abstract V a(@RecentlyNonNull K k10);

    @RecentlyNonNull
    public V b(@RecentlyNonNull K k10) {
        synchronized (this.f27046a) {
            if (this.f27046a.containsKey(k10)) {
                return this.f27046a.get(k10);
            }
            V a10 = a(k10);
            this.f27046a.put(k10, a10);
            return a10;
        }
    }
}
