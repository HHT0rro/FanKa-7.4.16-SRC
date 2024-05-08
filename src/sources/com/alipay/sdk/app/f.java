package com.alipay.sdk.app;

import android.app.Activity;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f4405a;

    public f(Activity activity) {
        this.f4405a = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4405a.finish();
    }
}
