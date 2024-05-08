package com.vivo.push.d;

import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.u;

/* compiled from: SyncProfileInfoImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f46158a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IPushRequestCallback f46159b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f46160c;

    public f(d dVar, String str, IPushRequestCallback iPushRequestCallback) {
        this.f46160c = dVar;
        this.f46158a = str;
        this.f46159b = iPushRequestCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u.b("delete profileId");
        d.a(this.f46160c, this.f46158a, this.f46159b, 2);
    }
}
