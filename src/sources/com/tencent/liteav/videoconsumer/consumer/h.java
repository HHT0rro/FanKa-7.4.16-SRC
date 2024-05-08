package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoconsumer.decoder.VideoDecodeController;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f43737a;

    /* renamed from: b, reason: collision with root package name */
    private final VideoDecodeController.DecodeStrategy f43738b;

    private h(b bVar, VideoDecodeController.DecodeStrategy decodeStrategy) {
        this.f43737a = bVar;
        this.f43738b = decodeStrategy;
    }

    public static Runnable a(b bVar, VideoDecodeController.DecodeStrategy decodeStrategy) {
        return new h(bVar, decodeStrategy);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f43737a;
        final VideoDecodeController.DecodeStrategy decodeStrategy = this.f43738b;
        LiteavLog.i(bVar.f43692a, "setDecoderType: ".concat(String.valueOf(decodeStrategy)));
        final VideoDecodeController videoDecodeController = bVar.f43698g;
        videoDecodeController.a(new Runnable(videoDecodeController, decodeStrategy) { // from class: com.tencent.liteav.videoconsumer.decoder.ar

            /* renamed from: a, reason: collision with root package name */
            private final VideoDecodeController f43872a;

            /* renamed from: b, reason: collision with root package name */
            private final VideoDecodeController.DecodeStrategy f43873b;

            {
                this.f43872a = videoDecodeController;
                this.f43873b = decodeStrategy;
            }

            @Override // java.lang.Runnable
            public final void run() {
                VideoDecodeController videoDecodeController2 = this.f43872a;
                VideoDecodeController.DecodeStrategy decodeStrategy2 = this.f43873b;
                e eVar = videoDecodeController2.f43776c;
                if (eVar.f43936c != decodeStrategy2) {
                    eVar.f43936c = decodeStrategy2;
                    eVar.f43937d = null;
                    if (decodeStrategy2 == VideoDecodeController.DecodeStrategy.FORCE_HARDWARE) {
                        eVar.f43957x = 3;
                    } else {
                        eVar.f43957x = 1;
                    }
                    LiteavLog.i(eVar.f43934a, "set decode strategy to %s", decodeStrategy2);
                }
            }
        });
    }
}
