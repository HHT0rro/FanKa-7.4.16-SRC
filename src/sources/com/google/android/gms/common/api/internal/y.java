package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class y implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x f23496b;

    public y(x xVar) {
        this.f23496b = xVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.f fVar;
        a.f fVar2;
        fVar = this.f23496b.f23495a.f23446c;
        fVar2 = this.f23496b.f23495a.f23446c;
        fVar.a(fVar2.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
