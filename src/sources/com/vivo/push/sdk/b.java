package com.vivo.push.sdk;

import android.content.Context;
import com.vivo.push.m;
import com.vivo.push.util.u;

/* compiled from: CommandWorker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.restructure.a.a f46370a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f46371b;

    public b(a aVar, com.vivo.push.restructure.a.a aVar2) {
        this.f46371b = aVar;
        this.f46370a = aVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        u.d("CommandWorker", " handleMessage type: ".concat(String.valueOf(this.f46370a.j())));
        m a10 = m.a();
        context = this.f46371b.f46074a;
        a10.a(context);
        com.vivo.push.restructure.a.a().d().a(this.f46370a);
    }
}
