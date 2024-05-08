package com.tencent.liteav.videoproducer.preprocessor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final BeautyProcessor f44776a;

    /* renamed from: b, reason: collision with root package name */
    private final String f44777b;

    /* renamed from: c, reason: collision with root package name */
    private final int f44778c;

    private f(BeautyProcessor beautyProcessor, String str, int i10) {
        this.f44776a = beautyProcessor;
        this.f44777b = str;
        this.f44778c = i10;
    }

    public static Runnable a(BeautyProcessor beautyProcessor, String str, int i10) {
        return new f(beautyProcessor, str, i10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f44776a.updateStatsInternal(this.f44777b, this.f44778c);
    }
}
