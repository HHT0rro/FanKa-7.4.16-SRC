package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.base.util.LiteavLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class bo implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final c f44625a;

    private bo(c cVar) {
        this.f44625a = cVar;
    }

    public static Runnable a(c cVar) {
        return new bo(cVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        c cVar = this.f44625a;
        LiteavLog.i(cVar.f44635a, "request restart encoder.");
        cVar.f44646l = true;
    }
}
