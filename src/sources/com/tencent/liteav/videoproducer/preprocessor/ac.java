package com.tencent.liteav.videoproducer.preprocessor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class ac implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final VideoPreprocessor f44755a;

    /* renamed from: b, reason: collision with root package name */
    private final int f44756b;

    /* renamed from: c, reason: collision with root package name */
    private final ah f44757c;

    private ac(VideoPreprocessor videoPreprocessor, int i10, ah ahVar) {
        this.f44755a = videoPreprocessor;
        this.f44756b = i10;
        this.f44757c = ahVar;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, int i10, ah ahVar) {
        return new ac(videoPreprocessor, i10, ahVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoPreprocessor.lambda$unregisterVideoProcessedListener$4(this.f44755a, this.f44756b, this.f44757c);
    }
}
