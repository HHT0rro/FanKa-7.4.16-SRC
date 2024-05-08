package com.tencent.liteav.audio.route;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final AudioRouteManager f42703a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f42704b;

    private n(AudioRouteManager audioRouteManager, boolean z10) {
        this.f42703a = audioRouteManager;
        this.f42704b = z10;
    }

    public static Runnable a(AudioRouteManager audioRouteManager, boolean z10) {
        return new n(audioRouteManager, z10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f42703a.handleBluetoothSCOChangedInternal(this.f42704b);
    }
}
