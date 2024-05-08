package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f45042a;

    /* renamed from: b, reason: collision with root package name */
    private final VideoProducerDef.GSensorMode f45043b;

    private s(i iVar, VideoProducerDef.GSensorMode gSensorMode) {
        this.f45042a = iVar;
        this.f45043b = gSensorMode;
    }

    public static Runnable a(i iVar, VideoProducerDef.GSensorMode gSensorMode) {
        return new s(iVar, gSensorMode);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a(this.f45042a, this.f45043b);
    }
}
