package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videoproducer.encoder.ax;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class bl implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ax.AnonymousClass1 f44618a;

    /* renamed from: b, reason: collision with root package name */
    private final EncodedVideoFrame f44619b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f44620c;

    private bl(ax.AnonymousClass1 anonymousClass1, EncodedVideoFrame encodedVideoFrame, boolean z10) {
        this.f44618a = anonymousClass1;
        this.f44619b = encodedVideoFrame;
        this.f44620c = z10;
    }

    public static Runnable a(ax.AnonymousClass1 anonymousClass1, EncodedVideoFrame encodedVideoFrame, boolean z10) {
        return new bl(anonymousClass1, encodedVideoFrame, z10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ax.AnonymousClass1.a(this.f44618a, this.f44619b, this.f44620c);
    }
}
