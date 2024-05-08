package com.tencent.liteav.videoproducer.preprocessor;

import android.graphics.Bitmap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ag implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final VideoPreprocessor f44766a;

    /* renamed from: b, reason: collision with root package name */
    private final Bitmap f44767b;

    private ag(VideoPreprocessor videoPreprocessor, Bitmap bitmap) {
        this.f44766a = videoPreprocessor;
        this.f44767b = bitmap;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, Bitmap bitmap) {
        return new ag(videoPreprocessor, bitmap);
    }

    @Override // java.lang.Runnable
    public final void run() {
        r0.mPreprocessor.a(1.0f, this.f44767b, this.f44766a.mLookupMixLevel, null, 0.0f);
    }
}
