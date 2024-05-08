package com.tencent.liteav.videobase.utils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final n f43544a;

    /* renamed from: b, reason: collision with root package name */
    private final int f43545b;

    /* renamed from: c, reason: collision with root package name */
    private final int f43546c;

    private p(n nVar, int i10, int i11) {
        this.f43544a = nVar;
        this.f43545b = i10;
        this.f43546c = i11;
    }

    public static Runnable a(n nVar, int i10, int i11) {
        return new p(nVar, i10, i11);
    }

    @Override // java.lang.Runnable
    public final void run() {
        n nVar = this.f43544a;
        int i10 = this.f43545b;
        int i11 = this.f43546c;
        if (i10 <= 0 || i11 <= 0) {
            return;
        }
        nVar.f43538f = i10;
        nVar.f43539g = i11;
    }
}
