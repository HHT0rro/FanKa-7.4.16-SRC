package com.tencent.liteav.videoconsumer.decoder;

import android.view.Surface;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class ap implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final VideoDecodeController f43869a;

    /* renamed from: b, reason: collision with root package name */
    private final Surface f43870b;

    private ap(VideoDecodeController videoDecodeController, Surface surface) {
        this.f43869a = videoDecodeController;
        this.f43870b = surface;
    }

    public static Runnable a(VideoDecodeController videoDecodeController, Surface surface) {
        return new ap(videoDecodeController, surface);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoDecodeController videoDecodeController = this.f43869a;
        Surface surface = this.f43870b;
        if (videoDecodeController.f43788o != surface) {
            videoDecodeController.f43788o = surface;
            if (videoDecodeController.f43787n) {
                videoDecodeController.f43776c.f43950q = true;
                bk bkVar = videoDecodeController.f43784k;
                if (bkVar != null) {
                    bkVar.stop();
                }
            }
        }
    }
}
