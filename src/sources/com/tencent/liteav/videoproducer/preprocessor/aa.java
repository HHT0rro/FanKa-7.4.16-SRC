package com.tencent.liteav.videoproducer.preprocessor;

import com.tencent.liteav.videobase.frame.PixelFrame;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class aa implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final VideoPreprocessor f44745a;

    /* renamed from: b, reason: collision with root package name */
    private final PixelFrame f44746b;

    /* renamed from: c, reason: collision with root package name */
    private final long f44747c;

    private aa(VideoPreprocessor videoPreprocessor, PixelFrame pixelFrame, long j10) {
        this.f44745a = videoPreprocessor;
        this.f44746b = pixelFrame;
        this.f44747c = j10;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, PixelFrame pixelFrame, long j10) {
        return new aa(videoPreprocessor, pixelFrame, j10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoPreprocessor.lambda$processFrame$2(this.f44745a, this.f44746b, this.f44747c);
    }
}
