package com.tencent.liteav.videoproducer.preprocessor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final BeautyProcessor f44743a;

    /* renamed from: b, reason: collision with root package name */
    private final int f44744b;

    private a(BeautyProcessor beautyProcessor, int i10) {
        this.f44743a = beautyProcessor;
        this.f44744b = i10;
    }

    public static Runnable a(BeautyProcessor beautyProcessor, int i10) {
        return new a(beautyProcessor, i10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        r0.updateBeautyInternal(this.f44744b, r0.mBeautyLevel, r0.mWhitenessLevel, r0.mRuddyLevel, this.f44743a.mSharpnessLevel);
    }
}
