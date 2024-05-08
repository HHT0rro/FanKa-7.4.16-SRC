package com.tencent.liteav.videobase.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final h f43260a;

    private i(h hVar) {
        this.f43260a = hVar;
    }

    public static Runnable a(h hVar) {
        return new i(hVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f43260a.initFiltersAndInterceptors();
    }
}
