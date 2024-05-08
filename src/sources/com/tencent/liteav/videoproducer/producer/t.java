package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f45044a;

    /* renamed from: b, reason: collision with root package name */
    private final VideoProducerDef.HomeOrientation f45045b;

    private t(i iVar, VideoProducerDef.HomeOrientation homeOrientation) {
        this.f45044a = iVar;
        this.f45045b = homeOrientation;
    }

    public static Runnable a(i iVar, VideoProducerDef.HomeOrientation homeOrientation) {
        return new t(iVar, homeOrientation);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a(this.f45044a, this.f45045b);
    }
}
