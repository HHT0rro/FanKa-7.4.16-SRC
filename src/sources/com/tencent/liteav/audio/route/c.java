package com.tencent.liteav.audio.route;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final AudioRouteManager f42685a;

    private c(AudioRouteManager audioRouteManager) {
        this.f42685a = audioRouteManager;
    }

    public static Runnable a(AudioRouteManager audioRouteManager) {
        return new c(audioRouteManager);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f42685a.autoCheckRouteUpdate(true);
    }
}
