package com.tencent.liteav.videoproducer.preprocessor;

import android.graphics.Bitmap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final VideoPreprocessor f44843a;

    /* renamed from: b, reason: collision with root package name */
    private final float f44844b;

    /* renamed from: c, reason: collision with root package name */
    private final Bitmap f44845c;

    /* renamed from: d, reason: collision with root package name */
    private final float f44846d;

    /* renamed from: e, reason: collision with root package name */
    private final Bitmap f44847e;

    /* renamed from: f, reason: collision with root package name */
    private final float f44848f;

    private r(VideoPreprocessor videoPreprocessor, float f10, Bitmap bitmap, float f11, Bitmap bitmap2, float f12) {
        this.f44843a = videoPreprocessor;
        this.f44844b = f10;
        this.f44845c = bitmap;
        this.f44846d = f11;
        this.f44847e = bitmap2;
        this.f44848f = f12;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, float f10, Bitmap bitmap, float f11, Bitmap bitmap2, float f12) {
        return new r(videoPreprocessor, f10, bitmap, f11, bitmap2, f12);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f44843a.mPreprocessor.a(this.f44844b, this.f44845c, this.f44846d, this.f44847e, this.f44848f);
    }
}
