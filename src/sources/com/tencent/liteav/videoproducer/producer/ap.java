package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ap implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f44943a;

    /* renamed from: b, reason: collision with root package name */
    private final PixelFrame f44944b;

    /* renamed from: c, reason: collision with root package name */
    private final CaptureSourceInterface f44945c;

    private ap(i iVar, PixelFrame pixelFrame, CaptureSourceInterface captureSourceInterface) {
        this.f44943a = iVar;
        this.f44944b = pixelFrame;
        this.f44945c = captureSourceInterface;
    }

    public static Runnable a(i iVar, PixelFrame pixelFrame, CaptureSourceInterface captureSourceInterface) {
        return new ap(iVar, pixelFrame, captureSourceInterface);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a(this.f44943a, this.f44944b, this.f44945c);
    }
}
