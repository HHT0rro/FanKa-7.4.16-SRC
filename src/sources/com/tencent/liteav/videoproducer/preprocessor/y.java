package com.tencent.liteav.videoproducer.preprocessor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class y implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final VideoPreprocessor f44862a;

    /* renamed from: b, reason: collision with root package name */
    private final com.tencent.liteav.videobase.a.a f44863b;

    private y(VideoPreprocessor videoPreprocessor, com.tencent.liteav.videobase.a.a aVar) {
        this.f44862a = videoPreprocessor;
        this.f44863b = aVar;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, com.tencent.liteav.videobase.a.a aVar) {
        return new y(videoPreprocessor, aVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoPreprocessor.lambda$setInterceptorBeforeWatermark$14(this.f44862a, this.f44863b);
    }
}
