package com.tencent.liteav.videoconsumer.decoder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class w implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final u f44027a;

    private w(u uVar) {
        this.f44027a = uVar;
    }

    public static Runnable a(u uVar) {
        return new w(uVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f44027a.b();
    }
}
