package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hq;
import com.xiaomi.push.ip;
import com.xiaomi.push.n;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a1 extends n.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ip f46953b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f46954c;

    public a1(ip ipVar, Context context) {
        this.f46953b = ipVar;
        this.f46954c = context;
    }

    @Override // com.xiaomi.push.n.a
    public int a() {
        return 22;
    }

    @Override // java.lang.Runnable
    public void run() {
        ip ipVar = this.f46953b;
        if (ipVar != null) {
            ipVar.a(kc.m.a());
            h0.g(this.f46954c.getApplicationContext()).w(this.f46953b, hq.Notification, true, null, true);
        }
    }
}
