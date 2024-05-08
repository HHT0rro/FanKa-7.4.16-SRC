package com.google.android.gms.common.api;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Result;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
    @Override // com.google.android.gms.common.api.ResultCallback
    public final void a(@RecentlyNonNull R r10) {
        Status status = r10.getStatus();
        if (status.isSuccess()) {
            c(r10);
            return;
        }
        b(status);
        if (r10 instanceof u6.c) {
            try {
                ((u6.c) r10).release();
            } catch (RuntimeException unused) {
                String valueOf = String.valueOf(r10);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 18);
                sb2.append("Unable to release ");
                sb2.append(valueOf);
            }
        }
    }

    public abstract void b(@RecentlyNonNull Status status);

    public abstract void c(@RecentlyNonNull R r10);
}
