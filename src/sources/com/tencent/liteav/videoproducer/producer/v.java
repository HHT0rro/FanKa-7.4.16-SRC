package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videoproducer.encoder.VideoEncodeParams;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f45047a;

    /* renamed from: b, reason: collision with root package name */
    private final VideoProducerDef.StreamType f45048b;

    /* renamed from: c, reason: collision with root package name */
    private final VideoEncodeParams f45049c;

    /* renamed from: d, reason: collision with root package name */
    private final GLConstants.ResolutionMode f45050d;

    private v(i iVar, VideoProducerDef.StreamType streamType, VideoEncodeParams videoEncodeParams, GLConstants.ResolutionMode resolutionMode) {
        this.f45047a = iVar;
        this.f45048b = streamType;
        this.f45049c = videoEncodeParams;
        this.f45050d = resolutionMode;
    }

    public static Runnable a(i iVar, VideoProducerDef.StreamType streamType, VideoEncodeParams videoEncodeParams, GLConstants.ResolutionMode resolutionMode) {
        return new v(iVar, streamType, videoEncodeParams, resolutionMode);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a(this.f45047a, this.f45048b, this.f45049c, this.f45050d);
    }
}
