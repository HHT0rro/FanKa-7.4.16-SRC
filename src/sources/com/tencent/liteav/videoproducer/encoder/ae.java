package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.videobase.frame.PixelFrame;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class ae implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final SoftwareEncoderWrapper f44502a;

    /* renamed from: b, reason: collision with root package name */
    private final PixelFrame f44503b;

    private ae(SoftwareEncoderWrapper softwareEncoderWrapper, PixelFrame pixelFrame) {
        this.f44502a = softwareEncoderWrapper;
        this.f44503b = pixelFrame;
    }

    public static Runnable a(SoftwareEncoderWrapper softwareEncoderWrapper, PixelFrame pixelFrame) {
        return new ae(softwareEncoderWrapper, pixelFrame);
    }

    @Override // java.lang.Runnable
    public final void run() {
        SoftwareEncoderWrapper.lambda$encodeFrame$2(this.f44502a, this.f44503b);
    }
}
