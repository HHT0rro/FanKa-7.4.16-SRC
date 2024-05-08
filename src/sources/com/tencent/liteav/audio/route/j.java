package com.tencent.liteav.audio.route;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final AudioRouteManager f42695a;

    /* renamed from: b, reason: collision with root package name */
    private final int f42696b;

    private j(AudioRouteManager audioRouteManager, int i10) {
        this.f42695a = audioRouteManager;
        this.f42696b = i10;
    }

    public static Runnable a(AudioRouteManager audioRouteManager, int i10) {
        return new j(audioRouteManager, i10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRouteManager.lambda$notifyAudioIOSceneChanged$3(this.f42695a, this.f42696b);
    }
}
