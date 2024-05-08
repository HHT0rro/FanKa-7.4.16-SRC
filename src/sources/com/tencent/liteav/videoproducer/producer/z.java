package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f45060a;

    /* renamed from: b, reason: collision with root package name */
    private final VideoProducerDef.StreamType f45061b;

    /* renamed from: c, reason: collision with root package name */
    private final int f45062c;

    /* renamed from: d, reason: collision with root package name */
    private final int f45063d;

    private z(i iVar, VideoProducerDef.StreamType streamType, int i10, int i11) {
        this.f45060a = iVar;
        this.f45061b = streamType;
        this.f45062c = i10;
        this.f45063d = i11;
    }

    public static Runnable a(i iVar, VideoProducerDef.StreamType streamType, int i10, int i11) {
        return new z(iVar, streamType, i10, i11);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a(this.f45060a, this.f45061b, this.f45062c, this.f45063d);
    }
}
