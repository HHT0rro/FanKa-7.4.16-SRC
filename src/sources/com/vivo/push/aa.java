package com.vivo.push;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.ag;

/* compiled from: SubscribeImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class aa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f46072a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z f46073b;

    public aa(z zVar, String str) {
        this.f46073b = zVar;
        this.f46072a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context b4 = com.vivo.push.restructure.a.a().b();
        if (b4 == null) {
            return;
        }
        long j10 = m.a().f() ? 488L : 341L;
        if (TextUtils.isEmpty(this.f46072a) || !ag.a(b4, b4.getPackageName(), this.f46072a, j10)) {
            return;
        }
        com.vivo.push.restructure.a.a().e().e();
        this.f46073b.f46469d = "";
    }
}
