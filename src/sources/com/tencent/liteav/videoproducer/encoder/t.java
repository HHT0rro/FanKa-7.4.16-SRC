package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videoproducer.encoder.s;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final s.AnonymousClass1 f44716a;

    /* renamed from: b, reason: collision with root package name */
    private final EncodedVideoFrame f44717b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f44718c;

    private t(s.AnonymousClass1 anonymousClass1, EncodedVideoFrame encodedVideoFrame, boolean z10) {
        this.f44716a = anonymousClass1;
        this.f44717b = encodedVideoFrame;
        this.f44718c = z10;
    }

    public static Runnable a(s.AnonymousClass1 anonymousClass1, EncodedVideoFrame encodedVideoFrame, boolean z10) {
        return new t(anonymousClass1, encodedVideoFrame, z10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        s.AnonymousClass1.a(this.f44716a, this.f44717b, this.f44718c);
    }
}
