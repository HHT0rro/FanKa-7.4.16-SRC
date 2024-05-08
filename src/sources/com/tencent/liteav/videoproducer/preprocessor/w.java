package com.tencent.liteav.videoproducer.preprocessor;

import com.tencent.liteav.base.util.LiteavLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class w implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final h f44860a;

    private w(h hVar) {
        this.f44860a = hVar;
    }

    public static Runnable a(h hVar) {
        return new w(hVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        h hVar = this.f44860a;
        hVar.a();
        LiteavLog.i(hVar.f44781a, "destroy gpu preprocessor");
    }
}
