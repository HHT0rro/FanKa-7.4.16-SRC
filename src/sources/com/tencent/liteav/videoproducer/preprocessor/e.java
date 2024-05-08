package com.tencent.liteav.videoproducer.preprocessor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final BeautyProcessor f44774a;

    /* renamed from: b, reason: collision with root package name */
    private final float f44775b;

    private e(BeautyProcessor beautyProcessor, float f10) {
        this.f44774a = beautyProcessor;
        this.f44775b = f10;
    }

    public static Runnable a(BeautyProcessor beautyProcessor, float f10) {
        return new e(beautyProcessor, f10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        BeautyProcessor.lambda$setRuddyLevel$4(this.f44774a, this.f44775b);
    }
}
