package com.tencent.liteav.videoproducer.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class at implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final am f44563a;

    private at(am amVar) {
        this.f44563a = amVar;
    }

    public static Runnable a(am amVar) {
        return new at(amVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f44563a.g();
    }
}
