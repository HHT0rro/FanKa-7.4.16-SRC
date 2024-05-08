package com.tencent.liteav.videoproducer.producer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f45039a;

    /* renamed from: b, reason: collision with root package name */
    private final int f45040b;

    /* renamed from: c, reason: collision with root package name */
    private final int f45041c;

    private r(i iVar, int i10, int i11) {
        this.f45039a = iVar;
        this.f45040b = i10;
        this.f45041c = i11;
    }

    public static Runnable a(i iVar, int i10, int i11) {
        return new r(iVar, i10, i11);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a(this.f45039a, this.f45040b, this.f45041c);
    }
}
