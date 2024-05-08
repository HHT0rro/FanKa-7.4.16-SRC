package com.tencent.liteav.videobase.videobase;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final View f43562a;

    /* renamed from: b, reason: collision with root package name */
    private final int f43563b;

    private b(View view, int i10) {
        this.f43562a = view;
        this.f43563b = i10;
    }

    public static Runnable a(View view, int i10) {
        return new b(view, i10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f43562a.setVisibility(this.f43563b);
    }
}
