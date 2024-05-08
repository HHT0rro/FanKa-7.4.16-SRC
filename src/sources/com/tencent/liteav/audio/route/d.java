package com.tencent.liteav.audio.route;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final AudioRouteManager f42686a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f42687b;

    private d(AudioRouteManager audioRouteManager, boolean z10) {
        this.f42686a = audioRouteManager;
        this.f42687b = z10;
    }

    public static Runnable a(AudioRouteManager audioRouteManager, boolean z10) {
        return new d(audioRouteManager, z10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f42686a.handleUsbChangedInternal(this.f42687b);
    }
}
