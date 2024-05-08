package com.tencent.liteav.audio.route;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final AudioRouteManager f42690a;

    /* renamed from: b, reason: collision with root package name */
    private final String f42691b;

    private g(AudioRouteManager audioRouteManager, String str) {
        this.f42690a = audioRouteManager;
        this.f42691b = str;
    }

    public static Runnable a(AudioRouteManager audioRouteManager, String str) {
        return new g(audioRouteManager, str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f42690a.startInternal(this.f42691b);
    }
}
