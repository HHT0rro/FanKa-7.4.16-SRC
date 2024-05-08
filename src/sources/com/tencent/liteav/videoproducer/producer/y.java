package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class y implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f45057a;

    /* renamed from: b, reason: collision with root package name */
    private final int f45058b;

    /* renamed from: c, reason: collision with root package name */
    private final VideoProducerDef.StreamType f45059c;

    private y(i iVar, int i10, VideoProducerDef.StreamType streamType) {
        this.f45057a = iVar;
        this.f45058b = i10;
        this.f45059c = streamType;
    }

    public static Runnable a(i iVar, int i10, VideoProducerDef.StreamType streamType) {
        return new y(iVar, i10, streamType);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a(this.f45057a, this.f45058b, this.f45059c);
    }
}
