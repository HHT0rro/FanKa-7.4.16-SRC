package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoconsumer.consumer.VideoConsumerServerConfig;
import com.tencent.liteav.videoconsumer.decoder.VideoDecodeController;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f43760a;

    /* renamed from: b, reason: collision with root package name */
    private final VideoConsumerServerConfig f43761b;

    private s(b bVar, VideoConsumerServerConfig videoConsumerServerConfig) {
        this.f43760a = bVar;
        this.f43761b = videoConsumerServerConfig;
    }

    public static Runnable a(b bVar, VideoConsumerServerConfig videoConsumerServerConfig) {
        return new s(bVar, videoConsumerServerConfig);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f43760a;
        final VideoConsumerServerConfig videoConsumerServerConfig = this.f43761b;
        LiteavLog.i(bVar.f43692a, "setServerConfig=".concat(String.valueOf(videoConsumerServerConfig)));
        final VideoDecodeController videoDecodeController = bVar.f43698g;
        videoDecodeController.a(new Runnable(videoDecodeController, videoConsumerServerConfig) { // from class: com.tencent.liteav.videoconsumer.decoder.bc

            /* renamed from: a, reason: collision with root package name */
            private final VideoDecodeController f43892a;

            /* renamed from: b, reason: collision with root package name */
            private final VideoConsumerServerConfig f43893b;

            {
                this.f43892a = videoDecodeController;
                this.f43893b = videoConsumerServerConfig;
            }

            @Override // java.lang.Runnable
            public final void run() {
                VideoDecodeController videoDecodeController2 = this.f43892a;
                VideoConsumerServerConfig videoConsumerServerConfig2 = this.f43893b;
                videoDecodeController2.f43792s = videoConsumerServerConfig2;
                e eVar = videoDecodeController2.f43776c;
                if (videoConsumerServerConfig2 != null) {
                    int i10 = videoConsumerServerConfig2.hwDecoderMaxCacheForHighRes;
                    eVar.f43942i = i10;
                    eVar.f43943j = videoConsumerServerConfig2.hwDecoderMaxCacheForLowRes;
                    LiteavLog.i(eVar.f43934a, "set hardware decoder max cache to highResolution: %d, lowResolution: %d", Integer.valueOf(i10), Integer.valueOf(eVar.f43943j));
                }
            }
        });
    }
}
