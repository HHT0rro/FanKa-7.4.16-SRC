package com.google.android.gms.common.api.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class s0 {

    /* renamed from: a, reason: collision with root package name */
    public final Map<BasePendingResult<?>, Boolean> f23487a = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: b, reason: collision with root package name */
    public final Map<p7.g<?>, Boolean> f23488b = Collections.synchronizedMap(new WeakHashMap());

    public final void b(int i10, @Nullable String str) {
        StringBuilder sb2 = new StringBuilder("The connection to Google Play services was lost");
        if (i10 == 1) {
            sb2.append(" due to service disconnection.");
        } else if (i10 == 3) {
            sb2.append(" due to dead object exception.");
        }
        if (str != null) {
            sb2.append(" Last reason for disconnect: ");
            sb2.append(str);
        }
        d(true, new Status(20, sb2.toString()));
    }

    public final void c(BasePendingResult<? extends Result> basePendingResult, boolean z10) {
        this.f23487a.put(basePendingResult, Boolean.valueOf(z10));
        basePendingResult.addStatusListener(new r0(this, basePendingResult));
    }

    public final void d(boolean z10, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.f23487a) {
            hashMap = new HashMap(this.f23487a);
        }
        synchronized (this.f23488b) {
            hashMap2 = new HashMap(this.f23488b);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z10 || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).forceFailureUnlessReady(status);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z10 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((p7.g) entry2.getKey()).d(new ApiException(status));
            }
        }
    }

    public final boolean e() {
        return (this.f23487a.isEmpty() && this.f23488b.isEmpty()) ? false : true;
    }

    public final void f() {
        d(false, g.f23428o);
    }
}
