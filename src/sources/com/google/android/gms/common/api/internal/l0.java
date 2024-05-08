package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.internal.g;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class l0<A extends d<? extends Result, a.b>> extends e0 {

    /* renamed from: b, reason: collision with root package name */
    public final A f23473b;

    public l0(int i10, A a10) {
        super(i10);
        this.f23473b = (A) com.google.android.gms.common.internal.h.i(a10, "Null methods are not runnable.");
    }

    @Override // com.google.android.gms.common.api.internal.e0
    public final void b(@NonNull Status status) {
        try {
            this.f23473b.f(status);
        } catch (IllegalStateException unused) {
        }
    }

    @Override // com.google.android.gms.common.api.internal.e0
    public final void c(@NonNull s0 s0Var, boolean z10) {
        s0Var.c(this.f23473b, z10);
    }

    @Override // com.google.android.gms.common.api.internal.e0
    public final void d(@NonNull Exception exc) {
        String simpleName = exc.getClass().getSimpleName();
        String localizedMessage = exc.getLocalizedMessage();
        StringBuilder sb2 = new StringBuilder(simpleName.length() + 2 + String.valueOf(localizedMessage).length());
        sb2.append(simpleName);
        sb2.append(": ");
        sb2.append(localizedMessage);
        try {
            this.f23473b.f(new Status(10, sb2.toString()));
        } catch (IllegalStateException unused) {
        }
    }

    @Override // com.google.android.gms.common.api.internal.e0
    public final void f(g.a<?> aVar) throws DeadObjectException {
        try {
            this.f23473b.d(aVar.q());
        } catch (RuntimeException e2) {
            d(e2);
        }
    }
}
