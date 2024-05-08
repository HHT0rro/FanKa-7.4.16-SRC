package com.tencent.liteav.videoproducer.preprocessor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ad implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final VideoPreprocessor f44758a;

    /* renamed from: b, reason: collision with root package name */
    private final String f44759b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f44760c;

    private ad(VideoPreprocessor videoPreprocessor, String str, boolean z10) {
        this.f44758a = videoPreprocessor;
        this.f44759b = str;
        this.f44760c = z10;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, String str, boolean z10) {
        return new ad(videoPreprocessor, str, z10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoPreprocessor.lambda$setGreenScreenFile$5(this.f44758a, this.f44759b, this.f44760c);
    }
}
