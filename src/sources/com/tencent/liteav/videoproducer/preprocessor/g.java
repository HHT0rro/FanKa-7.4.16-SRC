package com.tencent.liteav.videoproducer.preprocessor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final BeautyProcessor f44779a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f44780b;

    private g(BeautyProcessor beautyProcessor, boolean z10) {
        this.f44779a = beautyProcessor;
        this.f44780b = z10;
    }

    public static Runnable a(BeautyProcessor beautyProcessor, boolean z10) {
        return new g(beautyProcessor, z10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        BeautyProcessor.lambda$setPerformanceMode$6(this.f44779a, this.f44780b);
    }
}
