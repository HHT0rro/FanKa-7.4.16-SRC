package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videoproducer.capture.t;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ad implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final t.AnonymousClass1 f44264a;

    /* renamed from: b, reason: collision with root package name */
    private final PixelFrame f44265b;

    private ad(t.AnonymousClass1 anonymousClass1, PixelFrame pixelFrame) {
        this.f44264a = anonymousClass1;
        this.f44265b = pixelFrame;
    }

    public static Runnable a(t.AnonymousClass1 anonymousClass1, PixelFrame pixelFrame) {
        return new ad(anonymousClass1, pixelFrame);
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.AnonymousClass1.a(this.f44264a, this.f44265b);
    }
}
