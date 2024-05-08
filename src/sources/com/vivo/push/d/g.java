package com.vivo.push.d;

import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.u;

/* compiled from: SyncProfileInfoImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IPushRequestCallback f46161a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f46162b;

    public g(d dVar, IPushRequestCallback iPushRequestCallback) {
        this.f46162b = dVar;
        this.f46161a = iPushRequestCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u.b("delete all profileIds");
        d.a(this.f46162b, "", this.f46161a, 3);
    }
}
