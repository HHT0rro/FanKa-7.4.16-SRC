package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videoproducer.encoder.VideoEncodeParams;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f45024a;

    /* renamed from: b, reason: collision with root package name */
    private final VideoProducerDef.StreamType f45025b;

    /* renamed from: c, reason: collision with root package name */
    private final VideoEncodeParams f45026c;

    /* renamed from: d, reason: collision with root package name */
    private final VideoEncoderDef.VideoEncoderDataListener f45027d;

    private l(i iVar, VideoProducerDef.StreamType streamType, VideoEncodeParams videoEncodeParams, VideoEncoderDef.VideoEncoderDataListener videoEncoderDataListener) {
        this.f45024a = iVar;
        this.f45025b = streamType;
        this.f45026c = videoEncodeParams;
        this.f45027d = videoEncoderDataListener;
    }

    public static Runnable a(i iVar, VideoProducerDef.StreamType streamType, VideoEncodeParams videoEncodeParams, VideoEncoderDef.VideoEncoderDataListener videoEncoderDataListener) {
        return new l(iVar, streamType, videoEncodeParams, videoEncoderDataListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a(this.f45024a, this.f45025b, this.f45026c, this.f45027d);
    }
}
