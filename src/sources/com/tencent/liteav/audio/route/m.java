package com.tencent.liteav.audio.route;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final AudioRouteManager f42701a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f42702b;

    private m(AudioRouteManager audioRouteManager, boolean z10) {
        this.f42701a = audioRouteManager;
        this.f42702b = z10;
    }

    public static Runnable a(AudioRouteManager audioRouteManager, boolean z10) {
        return new m(audioRouteManager, z10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f42701a.handleBluetoothHeadsetChangedInternal(this.f42702b);
    }
}
