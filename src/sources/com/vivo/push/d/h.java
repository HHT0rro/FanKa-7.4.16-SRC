package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.u;
import java.util.ArrayList;

/* compiled from: SyncProfileInfoImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IPushRequestCallback f46163a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f46164b;

    public h(d dVar, IPushRequestCallback iPushRequestCallback) {
        this.f46164b = dVar;
        this.f46163a = iPushRequestCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        u.b("query all profileIds");
        if (com.vivo.push.restructure.a.a().g().b() != 0) {
            u.b("core not support sync profileInfo");
            IPushRequestCallback iPushRequestCallback = this.f46163a;
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(8102);
                return;
            }
        }
        Context b4 = com.vivo.push.restructure.a.a().b();
        com.vivo.push.restructure.request.d.a().a(new com.vivo.push.restructure.request.b(new com.vivo.push.d.a.a(new com.vivo.push.d.a.b(b4.getPackageName(), new ArrayList(), 4)), new i(this), (byte) 0));
    }
}
