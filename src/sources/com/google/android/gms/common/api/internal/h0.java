package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h0 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zacb f23467b;

    public h0(zacb zacbVar) {
        this.f23467b = zacbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i0 i0Var;
        i0Var = this.f23467b.zah;
        i0Var.c(new ConnectionResult(4));
    }
}
