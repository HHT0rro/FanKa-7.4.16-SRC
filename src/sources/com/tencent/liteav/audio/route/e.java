package com.tencent.liteav.audio.route;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final AudioRouteManager f42688a;

    private e(AudioRouteManager audioRouteManager) {
        this.f42688a = audioRouteManager;
    }

    public static Runnable a(AudioRouteManager audioRouteManager) {
        return new e(audioRouteManager);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f42688a.handleSystemVolumeChangedInternal();
    }
}
