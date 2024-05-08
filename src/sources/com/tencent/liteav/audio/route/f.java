package com.tencent.liteav.audio.route;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final AudioRouteManager f42689a;

    private f(AudioRouteManager audioRouteManager) {
        this.f42689a = audioRouteManager;
    }

    public static Runnable a(AudioRouteManager audioRouteManager) {
        return new f(audioRouteManager);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f42689a.notifyAudioIOSceneChangedInternal();
    }
}
