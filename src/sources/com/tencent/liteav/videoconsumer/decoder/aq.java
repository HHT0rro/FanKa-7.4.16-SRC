package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.videobase.common.EncodedVideoFrame;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class aq implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final VideoDecodeController f43871a;

    private aq(VideoDecodeController videoDecodeController) {
        this.f43871a = videoDecodeController;
    }

    public static Runnable a(VideoDecodeController videoDecodeController) {
        return new aq(videoDecodeController);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoDecodeController videoDecodeController = this.f43871a;
        videoDecodeController.f43783j = false;
        com.tencent.liteav.base.util.l lVar = videoDecodeController.f43779f;
        if (lVar != null) {
            lVar.a(1);
        }
        videoDecodeController.c();
        videoDecodeController.f43781h = null;
        com.tencent.liteav.base.util.r rVar = videoDecodeController.f43780g;
        if (rVar != null) {
            rVar.b();
            videoDecodeController.f43780g = null;
        }
        videoDecodeController.f43777d.a();
        videoDecodeController.g();
        synchronized (videoDecodeController) {
            for (EncodedVideoFrame encodedVideoFrame : videoDecodeController.f43789p) {
                if (encodedVideoFrame != null) {
                    encodedVideoFrame.release();
                }
            }
            videoDecodeController.f43789p.clear();
        }
        videoDecodeController.f43793t.b();
        videoDecodeController.f43794u.set(false);
        d dVar = videoDecodeController.f43795v;
        synchronized (dVar.f43932a) {
            dVar.f43932a.clear();
        }
    }
}
