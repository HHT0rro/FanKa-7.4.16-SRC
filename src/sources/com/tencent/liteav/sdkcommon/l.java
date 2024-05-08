package com.tencent.liteav.sdkcommon;

import android.widget.ScrollView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final g f43194a;

    private l(g gVar) {
        this.f43194a = gVar;
    }

    public static Runnable a(g gVar) {
        return new l(gVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScrollView scrollView = this.f43194a.f43178k;
        if (scrollView != null) {
            scrollView.fullScroll(130);
        }
    }
}
