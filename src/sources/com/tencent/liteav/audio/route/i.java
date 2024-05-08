package com.tencent.liteav.audio.route;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final AudioRouteManager f42693a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f42694b;

    private i(AudioRouteManager audioRouteManager, boolean z10) {
        this.f42693a = audioRouteManager;
        this.f42694b = z10;
    }

    public static Runnable a(AudioRouteManager audioRouteManager, boolean z10) {
        return new i(audioRouteManager, z10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f42693a.enableUsbDeviceInternal(this.f42694b);
    }
}
