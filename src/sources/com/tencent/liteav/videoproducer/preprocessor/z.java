package com.tencent.liteav.videoproducer.preprocessor;

import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final VideoPreprocessor f44864a;

    /* renamed from: b, reason: collision with root package name */
    private final CaptureSourceInterface.SourceType f44865b;

    private z(VideoPreprocessor videoPreprocessor, CaptureSourceInterface.SourceType sourceType) {
        this.f44864a = videoPreprocessor;
        this.f44865b = sourceType;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, CaptureSourceInterface.SourceType sourceType) {
        return new z(videoPreprocessor, sourceType);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f44864a.mSourceType = this.f44865b;
    }
}
