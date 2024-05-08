package com.tencent.liteav.audio.route;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final AudioRouteManager f42692a;

    private h(AudioRouteManager audioRouteManager) {
        this.f42692a = audioRouteManager;
    }

    public static Runnable a(AudioRouteManager audioRouteManager) {
        return new h(audioRouteManager);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f42692a.stopInternal();
    }
}
