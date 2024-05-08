package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zam;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g0 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zam f23465b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zacb f23466c;

    public g0(zacb zacbVar, zam zamVar) {
        this.f23466c = zacbVar;
        this.f23465b = zamVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f23466c.zab(this.f23465b);
    }
}
