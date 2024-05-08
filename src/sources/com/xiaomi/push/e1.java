package com.xiaomi.push;

import android.content.Context;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class e1 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public String f47195b;

    /* renamed from: c, reason: collision with root package name */
    public WeakReference<Context> f47196c;

    public e1(String str, WeakReference<Context> weakReference) {
        this.f47195b = str;
        this.f47196c = weakReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        WeakReference<Context> weakReference = this.f47196c;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return;
        }
        if (p1.a(this.f47195b) <= d1.f47169b) {
            fc.c.l("=====> do not need clean db");
            return;
        }
        h1 i10 = h1.i(this.f47195b);
        g1 k10 = g1.k(this.f47195b);
        i10.g(k10);
        k10.g(f1.j(context, this.f47195b, 1000));
        k1.b(context).d(i10);
    }
}
