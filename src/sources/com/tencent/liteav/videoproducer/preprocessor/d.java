package com.tencent.liteav.videoproducer.preprocessor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final BeautyProcessor f44772a;

    /* renamed from: b, reason: collision with root package name */
    private final float f44773b;

    private d(BeautyProcessor beautyProcessor, float f10) {
        this.f44772a = beautyProcessor;
        this.f44773b = f10;
    }

    public static Runnable a(BeautyProcessor beautyProcessor, float f10) {
        return new d(beautyProcessor, f10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        BeautyProcessor.lambda$setSharpenLevel$3(this.f44772a, this.f44773b);
    }
}
