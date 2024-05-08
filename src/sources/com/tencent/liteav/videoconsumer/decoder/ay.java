package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.base.util.LiteavLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ay implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final VideoDecodeController f43883a;

    private ay(VideoDecodeController videoDecodeController) {
        this.f43883a = videoDecodeController;
    }

    public static Runnable a(VideoDecodeController videoDecodeController) {
        return new ay(videoDecodeController);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoDecodeController videoDecodeController = this.f43883a;
        LiteavLog.i(videoDecodeController.f43774a, "decoder onAbandonDecodingFramesCompleted");
        videoDecodeController.f43791r.b();
        videoDecodeController.f43790q.set(0);
        bl blVar = videoDecodeController.f43781h;
        if (blVar != null) {
            blVar.j();
        }
    }
}
