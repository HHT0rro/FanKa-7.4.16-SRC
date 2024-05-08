package com.tencent.liteav.audio.route;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final AudioRouteManager f42697a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f42698b;

    private k(AudioRouteManager audioRouteManager, boolean z10) {
        this.f42697a = audioRouteManager;
        this.f42698b = z10;
    }

    public static Runnable a(AudioRouteManager audioRouteManager, boolean z10) {
        return new k(audioRouteManager, z10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f42697a.setHandFreeModeEnabledInternal(this.f42698b);
    }
}
