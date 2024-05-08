package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class bj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ax f44615a;

    /* renamed from: b, reason: collision with root package name */
    private final VideoEncoderDef.EncodeStrategy f44616b;

    private bj(ax axVar, VideoEncoderDef.EncodeStrategy encodeStrategy) {
        this.f44615a = axVar;
        this.f44616b = encodeStrategy;
    }

    public static Runnable a(ax axVar, VideoEncoderDef.EncodeStrategy encodeStrategy) {
        return new bj(axVar, encodeStrategy);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ax.a(this.f44615a, this.f44616b);
    }
}
