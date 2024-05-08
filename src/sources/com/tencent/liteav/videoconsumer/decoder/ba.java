package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.base.util.LiteavLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ba implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final VideoDecodeController f43888a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f43889b;

    private ba(VideoDecodeController videoDecodeController, boolean z10) {
        this.f43888a = videoDecodeController;
        this.f43889b = z10;
    }

    public static Runnable a(VideoDecodeController videoDecodeController, boolean z10) {
        return new ba(videoDecodeController, z10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoDecodeController videoDecodeController = this.f43888a;
        boolean z10 = this.f43889b;
        e eVar = videoDecodeController.f43776c;
        eVar.f43951r = z10;
        LiteavLog.i(eVar.f43934a, "setUsingLowLatencyDecoder:" + eVar.f43951r);
    }
}
