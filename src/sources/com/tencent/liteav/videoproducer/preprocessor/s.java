package com.tencent.liteav.videoproducer.preprocessor;

import android.graphics.Bitmap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final VideoPreprocessor f44849a;

    /* renamed from: b, reason: collision with root package name */
    private final Bitmap f44850b;

    /* renamed from: c, reason: collision with root package name */
    private final float f44851c;

    /* renamed from: d, reason: collision with root package name */
    private final float f44852d;

    /* renamed from: e, reason: collision with root package name */
    private final float f44853e;

    private s(VideoPreprocessor videoPreprocessor, Bitmap bitmap, float f10, float f11, float f12) {
        this.f44849a = videoPreprocessor;
        this.f44850b = bitmap;
        this.f44851c = f10;
        this.f44852d = f11;
        this.f44853e = f12;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, Bitmap bitmap, float f10, float f11, float f12) {
        return new s(videoPreprocessor, bitmap, f10, f11, f12);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoPreprocessor.lambda$setWatermark$10(this.f44849a, this.f44850b, this.f44851c, this.f44852d, this.f44853e);
    }
}
