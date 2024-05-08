package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.g;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class n0 extends m0<Boolean> {

    /* renamed from: c, reason: collision with root package name */
    public final j<?> f23477c;

    public n0(j<?> jVar, p7.g<Boolean> gVar) {
        super(4, gVar);
        this.f23477c = jVar;
    }

    @Override // com.google.android.gms.common.api.internal.m0, com.google.android.gms.common.api.internal.e0
    public final /* bridge */ /* synthetic */ void b(@NonNull Status status) {
        super.b(status);
    }

    @Override // com.google.android.gms.common.api.internal.e0
    public final /* bridge */ /* synthetic */ void c(@NonNull s0 s0Var, boolean z10) {
    }

    @Override // com.google.android.gms.common.api.internal.m0, com.google.android.gms.common.api.internal.e0
    public final /* bridge */ /* synthetic */ void d(@NonNull Exception exc) {
        super.d(exc);
    }

    @Override // com.google.android.gms.common.api.internal.s
    @Nullable
    public final Feature[] g(g.a<?> aVar) {
        if (aVar.x().get(this.f23477c) == null) {
            return null;
        }
        throw null;
    }

    @Override // com.google.android.gms.common.api.internal.s
    public final boolean h(g.a<?> aVar) {
        if (aVar.x().get(this.f23477c) == null) {
            return false;
        }
        throw null;
    }

    @Override // com.google.android.gms.common.api.internal.m0
    public final void i(g.a<?> aVar) throws RemoteException {
        if (aVar.x().remove(this.f23477c) == null) {
            this.f23474b.e(Boolean.FALSE);
        } else {
            aVar.q();
            throw null;
        }
    }
}
