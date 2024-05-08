package com.tencent.liteav.videoconsumer.renderer;

import android.view.SurfaceView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final f f44092a;

    /* renamed from: b, reason: collision with root package name */
    private final SurfaceView f44093b;

    private g(f fVar, SurfaceView surfaceView) {
        this.f44092a = fVar;
        this.f44093b = surfaceView;
    }

    public static Runnable a(f fVar, SurfaceView surfaceView) {
        return new g(fVar, surfaceView);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f44092a, this.f44093b);
    }
}
