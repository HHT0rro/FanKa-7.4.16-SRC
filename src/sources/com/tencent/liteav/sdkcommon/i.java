package com.tencent.liteav.sdkcommon;

import android.widget.ScrollView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final g f43190a;

    private i(g gVar) {
        this.f43190a = gVar;
    }

    public static Runnable a(g gVar) {
        return new i(gVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScrollView scrollView = this.f43190a.f43178k;
        if (scrollView != null) {
            scrollView.fullScroll(130);
        }
    }
}
