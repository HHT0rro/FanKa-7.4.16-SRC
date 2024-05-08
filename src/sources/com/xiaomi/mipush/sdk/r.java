package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class r implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f47074b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Intent f47075c;

    public r(Context context, Intent intent) {
        this.f47074b = context;
        this.f47075c = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f47074b.startService(this.f47075c);
        } catch (Exception e2) {
            fc.c.i(e2.getMessage());
        }
    }
}
