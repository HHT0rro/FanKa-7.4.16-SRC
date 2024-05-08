package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.videoproducer.encoder.bq;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class ad implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final SoftwareEncoderWrapper f44499a;

    /* renamed from: b, reason: collision with root package name */
    private final bq.a f44500b;

    /* renamed from: c, reason: collision with root package name */
    private final VideoEncodeParams f44501c;

    private ad(SoftwareEncoderWrapper softwareEncoderWrapper, bq.a aVar, VideoEncodeParams videoEncodeParams) {
        this.f44499a = softwareEncoderWrapper;
        this.f44500b = aVar;
        this.f44501c = videoEncodeParams;
    }

    public static Runnable a(SoftwareEncoderWrapper softwareEncoderWrapper, bq.a aVar, VideoEncodeParams videoEncodeParams) {
        return new ad(softwareEncoderWrapper, aVar, videoEncodeParams);
    }

    @Override // java.lang.Runnable
    public final void run() {
        SoftwareEncoderWrapper.lambda$start$1(this.f44499a, this.f44500b, this.f44501c);
    }
}
