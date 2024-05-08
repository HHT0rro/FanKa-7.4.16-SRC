package com.google.android.gms.common.api.internal;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class o0 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayMap<b<?>, ConnectionResult> f23478a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayMap<b<?>, String> f23479b;

    /* renamed from: c, reason: collision with root package name */
    public final p7.g<Map<b<?>, String>> f23480c;

    /* renamed from: d, reason: collision with root package name */
    public int f23481d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f23482e;

    public final Set<b<?>> a() {
        return this.f23478a.h();
    }

    public final void b(b<?> bVar, ConnectionResult connectionResult, @Nullable String str) {
        this.f23478a.put(bVar, connectionResult);
        this.f23479b.put(bVar, str);
        this.f23481d--;
        if (!connectionResult.isSuccess()) {
            this.f23482e = true;
        }
        if (this.f23481d == 0) {
            if (this.f23482e) {
                this.f23480c.b(new AvailabilityException(this.f23478a));
            } else {
                this.f23480c.c(this.f23479b);
            }
        }
    }
}
