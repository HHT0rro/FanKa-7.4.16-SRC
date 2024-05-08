package com.tencent.liteav.videoconsumer.decoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class bf implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final VideoDecodeController f43899a;

    /* renamed from: b, reason: collision with root package name */
    private final bl f43900b;

    private bf(VideoDecodeController videoDecodeController, bl blVar) {
        this.f43899a = videoDecodeController;
        this.f43900b = blVar;
    }

    public static Runnable a(VideoDecodeController videoDecodeController, bl blVar) {
        return new bf(videoDecodeController, blVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoDecodeController videoDecodeController = this.f43899a;
        bl blVar = this.f43900b;
        if (videoDecodeController.f43783j) {
            return;
        }
        com.tencent.liteav.base.util.l lVar = videoDecodeController.f43779f;
        if (lVar != null) {
            lVar.a(15);
        }
        videoDecodeController.f43783j = true;
        videoDecodeController.f43781h = blVar;
        videoDecodeController.f43790q.set(0);
        videoDecodeController.f43776c.a();
        videoDecodeController.f43777d.a();
        videoDecodeController.f43794u.set(false);
    }
}
