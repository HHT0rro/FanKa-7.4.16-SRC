package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d0 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f46977b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Intent f46978c;

    public d0(Context context, Intent intent) {
        this.f46977b = context;
        this.f46978c = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        PushMessageHandler.p(this.f46977b, this.f46978c);
    }
}
