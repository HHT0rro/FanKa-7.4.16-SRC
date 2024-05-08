package com.tencent.liteav.videoconsumer.decoder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class az implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final VideoDecodeController f43884a;

    private az(VideoDecodeController videoDecodeController) {
        this.f43884a = videoDecodeController;
    }

    public static Runnable a(VideoDecodeController videoDecodeController) {
        return new az(videoDecodeController);
    }

    @Override // java.lang.Runnable
    public final void run() {
        bl blVar = this.f43884a.f43781h;
        if (blVar != null) {
            blVar.k();
        }
    }
}
