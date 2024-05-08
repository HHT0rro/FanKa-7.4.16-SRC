package com.tencent.liteav.videoproducer.preprocessor;

import com.tencent.liteav.videobase.base.GLConstants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ae implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final VideoPreprocessor f44761a;

    /* renamed from: b, reason: collision with root package name */
    private final GLConstants.GLScaleType f44762b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f44763c;

    private ae(VideoPreprocessor videoPreprocessor, GLConstants.GLScaleType gLScaleType, boolean z10) {
        this.f44761a = videoPreprocessor;
        this.f44762b = gLScaleType;
        this.f44763c = z10;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, GLConstants.GLScaleType gLScaleType, boolean z10) {
        return new ae(videoPreprocessor, gLScaleType, z10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoPreprocessor.lambda$setGreenScreenParam$6(this.f44761a, this.f44762b, this.f44763c);
    }
}
