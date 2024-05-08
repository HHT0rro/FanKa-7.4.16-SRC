package com.tencent.liteav.videoproducer.preprocessor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final h f44817a;

    /* renamed from: b, reason: collision with root package name */
    private final com.tencent.liteav.videobase.a.a f44818b;

    private i(h hVar, com.tencent.liteav.videobase.a.a aVar) {
        this.f44817a = hVar;
        this.f44818b = aVar;
    }

    public static Runnable a(h hVar, com.tencent.liteav.videobase.a.a aVar) {
        return new i(hVar, aVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        h hVar = this.f44817a;
        hVar.f44795o = this.f44818b;
        hVar.b();
    }
}
