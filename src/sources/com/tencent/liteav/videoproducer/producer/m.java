package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f45028a;

    /* renamed from: b, reason: collision with root package name */
    private final VideoProducerDef.StreamType f45029b;

    private m(i iVar, VideoProducerDef.StreamType streamType) {
        this.f45028a = iVar;
        this.f45029b = streamType;
    }

    public static Runnable a(i iVar, VideoProducerDef.StreamType streamType) {
        return new m(iVar, streamType);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.b(this.f45028a, this.f45029b);
    }
}
