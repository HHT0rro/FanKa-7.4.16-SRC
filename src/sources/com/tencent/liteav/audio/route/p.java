package com.tencent.liteav.audio.route;

import com.tencent.liteav.audio.route.AudioRouteManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final AudioRouteManager.AnonymousClass3 f42707a;

    private p(AudioRouteManager.AnonymousClass3 anonymousClass3) {
        this.f42707a = anonymousClass3;
    }

    public static Runnable a(AudioRouteManager.AnonymousClass3 anonymousClass3) {
        return new p(anonymousClass3);
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRouteManager.this.onBluetoothConnectionChanged(true);
    }
}
