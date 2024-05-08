package com.tencent.liteav.videobase.egl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final EGLCore f43426a;

    private e(EGLCore eGLCore) {
        this.f43426a = eGLCore;
    }

    public static Runnable a(EGLCore eGLCore) {
        return new e(eGLCore);
    }

    @Override // java.lang.Runnable
    public final void run() {
        EGLCore.lambda$destroy$0(this.f43426a);
    }
}
