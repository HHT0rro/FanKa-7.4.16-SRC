package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class p2 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f48066b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Intent f48067c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ o2 f48068d;

    public p2(o2 o2Var, Context context, Intent intent) {
        this.f48068d = o2Var;
        this.f48066b = context;
        this.f48067c = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f48068d.d(this.f48066b, this.f48067c);
    }
}
