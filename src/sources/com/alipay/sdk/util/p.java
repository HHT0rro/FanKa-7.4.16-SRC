package com.alipay.sdk.util;

import android.app.Activity;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
final class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f4763a;

    public p(Activity activity) {
        this.f4763a = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4763a.finish();
    }
}
