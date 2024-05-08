package com.tencent.liteav.videoproducer.preprocessor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final BeautyProcessor f44768a;

    /* renamed from: b, reason: collision with root package name */
    private final float f44769b;

    private b(BeautyProcessor beautyProcessor, float f10) {
        this.f44768a = beautyProcessor;
        this.f44769b = f10;
    }

    public static Runnable a(BeautyProcessor beautyProcessor, float f10) {
        return new b(beautyProcessor, f10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        BeautyProcessor.lambda$setBeautyLevel$1(this.f44768a, this.f44769b);
    }
}
