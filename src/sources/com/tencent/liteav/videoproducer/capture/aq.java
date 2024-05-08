package com.tencent.liteav.videoproducer.capture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class aq implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ak f44310a;

    private aq(ak akVar) {
        this.f44310a = akVar;
    }

    public static Runnable a(ak akVar) {
        return new aq(akVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ak.a(this.f44310a);
    }
}
