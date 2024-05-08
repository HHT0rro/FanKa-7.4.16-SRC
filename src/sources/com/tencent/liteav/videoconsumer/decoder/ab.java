package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.videoconsumer.consumer.VideoConsumerServerConfig;
import com.tencent.liteav.videoconsumer.decoder.VideoDecoderDef;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ab implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final u f43827a;

    /* renamed from: b, reason: collision with root package name */
    private final VideoConsumerServerConfig f43828b;

    private ab(u uVar, VideoConsumerServerConfig videoConsumerServerConfig) {
        this.f43827a = uVar;
        this.f43828b = videoConsumerServerConfig;
    }

    public static Runnable a(u uVar, VideoConsumerServerConfig videoConsumerServerConfig) {
        return new ab(uVar, videoConsumerServerConfig);
    }

    @Override // java.lang.Runnable
    public final void run() {
        u uVar = this.f43827a;
        VideoConsumerServerConfig videoConsumerServerConfig = this.f43828b;
        if (videoConsumerServerConfig != null) {
            boolean z10 = videoConsumerServerConfig.enableVui;
            uVar.f44007h = z10;
            ad adVar = uVar.f44003d;
            if (adVar != null) {
                adVar.f43833e = z10 && uVar.f44006g == VideoDecoderDef.ConsumerScene.RTC;
            }
        }
    }
}
