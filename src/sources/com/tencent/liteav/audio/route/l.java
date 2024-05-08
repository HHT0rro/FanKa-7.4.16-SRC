package com.tencent.liteav.audio.route;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final AudioRouteManager f42699a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f42700b;

    private l(AudioRouteManager audioRouteManager, boolean z10) {
        this.f42699a = audioRouteManager;
        this.f42700b = z10;
    }

    public static Runnable a(AudioRouteManager audioRouteManager, boolean z10) {
        return new l(audioRouteManager, z10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f42699a.handleWiredHeadsetChangedInternal(this.f42700b);
    }
}
