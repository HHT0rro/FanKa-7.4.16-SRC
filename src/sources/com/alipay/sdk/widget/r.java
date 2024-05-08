package com.alipay.sdk.widget;

import android.view.View;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f4832a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f4833b;

    public r(q qVar, View view) {
        this.f4833b = qVar;
        this.f4832a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4832a.setEnabled(true);
    }
}
