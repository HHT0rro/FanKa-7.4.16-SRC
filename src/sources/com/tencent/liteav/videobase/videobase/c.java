package com.tencent.liteav.videobase.videobase;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final View f43564a;

    private c(View view) {
        this.f43564a = view;
    }

    public static Runnable a(View view) {
        return new c(view);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f43564a.requestLayout();
    }
}
