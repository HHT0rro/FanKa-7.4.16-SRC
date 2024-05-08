package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.videoconsumer.decoder.VideoDecoderDef;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f43729a;

    /* renamed from: b, reason: collision with root package name */
    private final VideoDecoderDef.ConsumerScene f43730b;

    private d(b bVar, VideoDecoderDef.ConsumerScene consumerScene) {
        this.f43729a = bVar;
        this.f43730b = consumerScene;
    }

    public static Runnable a(b bVar, VideoDecoderDef.ConsumerScene consumerScene) {
        return new d(bVar, consumerScene);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f43729a;
        VideoDecoderDef.ConsumerScene consumerScene = this.f43730b;
        bVar.f43714w = consumerScene;
        bVar.f43698g.a(consumerScene);
    }
}
