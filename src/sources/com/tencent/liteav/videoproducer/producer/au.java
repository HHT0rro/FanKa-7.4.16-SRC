package com.tencent.liteav.videoproducer.producer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class au implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f44962a;

    /* renamed from: b, reason: collision with root package name */
    private final float f44963b;

    private au(i iVar, float f10) {
        this.f44962a = iVar;
        this.f44963b = f10;
    }

    public static Runnable a(i iVar, float f10) {
        return new au(iVar, f10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a(this.f44962a, this.f44963b);
    }
}
