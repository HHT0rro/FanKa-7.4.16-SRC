package com.tencent.liteav.videoproducer.preprocessor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class af implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final VideoPreprocessor f44764a;

    /* renamed from: b, reason: collision with root package name */
    private final float f44765b;

    private af(VideoPreprocessor videoPreprocessor, float f10) {
        this.f44764a = videoPreprocessor;
        this.f44765b = f10;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, float f10) {
        return new af(videoPreprocessor, f10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoPreprocessor.lambda$setFilterMixLevel$7(this.f44764a, this.f44765b);
    }
}
