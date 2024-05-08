package com.tencent.liteav.audio.route;

import com.tencent.liteav.audio.route.AudioRouteManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final AudioRouteManager.AnonymousClass3 f42708a;

    private q(AudioRouteManager.AnonymousClass3 anonymousClass3) {
        this.f42708a = anonymousClass3;
    }

    public static Runnable a(AudioRouteManager.AnonymousClass3 anonymousClass3) {
        return new q(anonymousClass3);
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRouteManager.this.onBluetoothConnectionChanged(false);
    }
}
