package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class be implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ax f44608a;

    /* renamed from: b, reason: collision with root package name */
    private final VideoEncodeParams f44609b;

    /* renamed from: c, reason: collision with root package name */
    private final VideoEncoderDef.VideoEncoderDataListener f44610c;

    private be(ax axVar, VideoEncodeParams videoEncodeParams, VideoEncoderDef.VideoEncoderDataListener videoEncoderDataListener) {
        this.f44608a = axVar;
        this.f44609b = videoEncodeParams;
        this.f44610c = videoEncoderDataListener;
    }

    public static Runnable a(ax axVar, VideoEncodeParams videoEncodeParams, VideoEncoderDef.VideoEncoderDataListener videoEncoderDataListener) {
        return new be(axVar, videoEncodeParams, videoEncoderDataListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ax.a(this.f44608a, this.f44609b, this.f44610c);
    }
}
