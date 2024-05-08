package com.tencent.liteav.videoproducer.preprocessor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final VideoPreprocessor f44858a;

    /* renamed from: b, reason: collision with root package name */
    private final int f44859b;

    private v(VideoPreprocessor videoPreprocessor, int i10) {
        this.f44858a = videoPreprocessor;
        this.f44859b = i10;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, int i10) {
        return new v(videoPreprocessor, i10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f44858a.mPreprocessor.f44786f.setHomeOrientation(this.f44859b);
    }
}
