package com.xiaomi.mipush.sdk;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class s implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f47077b;

    public s(Context context) {
        this.f47077b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        MessageHandleService.f(this.f47077b);
    }
}
