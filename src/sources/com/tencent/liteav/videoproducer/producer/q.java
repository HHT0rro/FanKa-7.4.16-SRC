package com.tencent.liteav.videoproducer.producer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f45037a;

    /* renamed from: b, reason: collision with root package name */
    private final String f45038b;

    private q(i iVar, String str) {
        this.f45037a = iVar;
        this.f45038b = str;
    }

    public static Runnable a(i iVar, String str) {
        return new q(iVar, str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a(this.f45037a, this.f45038b);
    }
}
