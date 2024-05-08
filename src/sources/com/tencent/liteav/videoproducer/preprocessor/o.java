package com.tencent.liteav.videoproducer.preprocessor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final h f44836a;

    /* renamed from: b, reason: collision with root package name */
    private final String f44837b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f44838c;

    private o(h hVar, String str, boolean z10) {
        this.f44836a = hVar;
        this.f44837b = str;
        this.f44838c = z10;
    }

    public static Runnable a(h hVar, String str, boolean z10) {
        return new o(hVar, str, z10);
    }

    @Override // java.lang.Runnable
    public final void run() {
    }
}
