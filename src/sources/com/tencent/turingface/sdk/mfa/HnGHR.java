package com.tencent.turingface.sdk.mfa;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class HnGHR extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ rBDKv f45603a;

    public HnGHR(rBDKv rbdkv) {
        this.f45603a = rbdkv;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            rBDKv.a(this.f45603a);
        } catch (Throwable unused) {
        }
    }
}
