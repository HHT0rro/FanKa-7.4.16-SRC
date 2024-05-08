package com.tencent.liteav.videoconsumer.decoder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ax implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final VideoDecodeController f43882a;

    private ax(VideoDecodeController videoDecodeController) {
        this.f43882a = videoDecodeController;
    }

    public static Runnable a(VideoDecodeController videoDecodeController) {
        return new ax(videoDecodeController);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f43882a.h();
    }
}
