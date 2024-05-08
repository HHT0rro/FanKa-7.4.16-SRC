package com.tencent.liteav.videoproducer.preprocessor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class u implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final VideoPreprocessor f44856a;

    /* renamed from: b, reason: collision with root package name */
    private final float f44857b;

    private u(VideoPreprocessor videoPreprocessor, float f10) {
        this.f44856a = videoPreprocessor;
        this.f44857b = f10;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, float f10) {
        return new u(videoPreprocessor, f10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoPreprocessor.lambda$setGaussianBlurLevel$12(this.f44856a, this.f44857b);
    }
}
