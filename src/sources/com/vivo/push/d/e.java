package com.vivo.push.d;

import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.u;

/* compiled from: SyncProfileInfoImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f46155a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IPushRequestCallback f46156b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f46157c;

    public e(d dVar, String str, IPushRequestCallback iPushRequestCallback) {
        this.f46157c = dVar;
        this.f46155a = str;
        this.f46156b = iPushRequestCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u.b("add profileId");
        d.a(this.f46157c, this.f46155a, this.f46156b, 1);
    }
}
