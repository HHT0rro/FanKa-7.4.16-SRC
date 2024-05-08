package com.tencent.liteav.videoproducer.preprocessor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final BeautyProcessor f44770a;

    /* renamed from: b, reason: collision with root package name */
    private final float f44771b;

    private c(BeautyProcessor beautyProcessor, float f10) {
        this.f44770a = beautyProcessor;
        this.f44771b = f10;
    }

    public static Runnable a(BeautyProcessor beautyProcessor, float f10) {
        return new c(beautyProcessor, f10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        BeautyProcessor.lambda$setWhitenessLevel$2(this.f44770a, this.f44771b);
    }
}
