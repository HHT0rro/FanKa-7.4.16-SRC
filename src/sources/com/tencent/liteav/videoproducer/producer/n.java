package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f45030a;

    /* renamed from: b, reason: collision with root package name */
    private final VideoProducerDef.StreamType f45031b;

    /* renamed from: c, reason: collision with root package name */
    private final VideoEncoderDef.EncodeStrategy f45032c;

    private n(i iVar, VideoProducerDef.StreamType streamType, VideoEncoderDef.EncodeStrategy encodeStrategy) {
        this.f45030a = iVar;
        this.f45031b = streamType;
        this.f45032c = encodeStrategy;
    }

    public static Runnable a(i iVar, VideoProducerDef.StreamType streamType, VideoEncoderDef.EncodeStrategy encodeStrategy) {
        return new n(iVar, streamType, encodeStrategy);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a(this.f45030a, this.f45031b, this.f45032c);
    }
}
