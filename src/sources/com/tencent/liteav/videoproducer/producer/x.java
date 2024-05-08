package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f45054a;

    /* renamed from: b, reason: collision with root package name */
    private final int f45055b;

    /* renamed from: c, reason: collision with root package name */
    private final VideoProducerDef.StreamType f45056c;

    private x(i iVar, int i10, VideoProducerDef.StreamType streamType) {
        this.f45054a = iVar;
        this.f45055b = i10;
        this.f45056c = streamType;
    }

    public static Runnable a(i iVar, int i10, VideoProducerDef.StreamType streamType) {
        return new x(iVar, i10, streamType);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.b(this.f45054a, this.f45055b, this.f45056c);
    }
}
