package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.n;
import com.xiaomi.push.hu;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class v implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ hu f47083b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n.a.C0713a f47084c;

    public v(n.a.C0713a c0713a, hu huVar) {
        this.f47084c = c0713a;
        this.f47083b = huVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f47084c.f47039b.add(this.f47083b);
        this.f47084c.c();
    }
}
