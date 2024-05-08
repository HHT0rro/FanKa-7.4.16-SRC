package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.videoconsumer.decoder.VideoDecoderDef;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final u f44030a;

    /* renamed from: b, reason: collision with root package name */
    private final VideoDecoderDef.ConsumerScene f44031b;

    private z(u uVar, VideoDecoderDef.ConsumerScene consumerScene) {
        this.f44030a = uVar;
        this.f44031b = consumerScene;
    }

    public static Runnable a(u uVar, VideoDecoderDef.ConsumerScene consumerScene) {
        return new z(uVar, consumerScene);
    }

    @Override // java.lang.Runnable
    public final void run() {
        u uVar = this.f44030a;
        VideoDecoderDef.ConsumerScene consumerScene = this.f44031b;
        uVar.f44006g = consumerScene;
        ad adVar = uVar.f44003d;
        if (adVar != null) {
            adVar.f43833e = uVar.f44007h && consumerScene == VideoDecoderDef.ConsumerScene.RTC;
        }
    }
}
