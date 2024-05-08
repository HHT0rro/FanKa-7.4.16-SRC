package com.tencent.liteav.sdkcommon;

import android.widget.ScrollView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final g f43189a;

    private h(g gVar) {
        this.f43189a = gVar;
    }

    public static Runnable a(g gVar) {
        return new h(gVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScrollView scrollView = this.f43189a.f43178k;
        if (scrollView != null) {
            scrollView.fullScroll(130);
        }
    }
}
