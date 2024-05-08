package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class aa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f44907a;

    /* renamed from: b, reason: collision with root package name */
    private final VideoProducerDef.StreamType f44908b;

    private aa(i iVar, VideoProducerDef.StreamType streamType) {
        this.f44907a = iVar;
        this.f44908b = streamType;
    }

    public static Runnable a(i iVar, VideoProducerDef.StreamType streamType) {
        return new aa(iVar, streamType);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a(this.f44907a, this.f44908b);
    }
}
