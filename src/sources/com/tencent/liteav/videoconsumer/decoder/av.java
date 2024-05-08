package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.videobase.h;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class av implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final VideoDecodeController f43880a;

    private av(VideoDecodeController videoDecodeController) {
        this.f43880a = videoDecodeController;
    }

    public static Runnable a(VideoDecodeController videoDecodeController) {
        return new av(videoDecodeController);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoDecodeController videoDecodeController = this.f43880a;
        LiteavLog.i(videoDecodeController.f43774a, "on decode failed, type: %s", videoDecodeController.e());
        videoDecodeController.f43776c.f43947n = true;
        bi biVar = videoDecodeController.f43777d;
        biVar.f43912j++;
        biVar.b();
        videoDecodeController.h();
        videoDecodeController.f43775b.notifyWarning(h.c.WARNING_VIDEO_DECODE_ABNORMAL, "decode error try restart");
    }
}
