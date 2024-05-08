package com.tencent.liteav.videobase.utils;

import com.tencent.liteav.videobase.base.TakeSnapshotListener;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final n f43543a;

    private o(n nVar) {
        this.f43543a = nVar;
    }

    public static Runnable a(n nVar) {
        return new o(nVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        n nVar = this.f43543a;
        TakeSnapshotListener takeSnapshotListener = nVar.f43537e;
        if (takeSnapshotListener != null) {
            takeSnapshotListener.onComplete(null);
            nVar.f43537e = null;
        }
        nVar.c();
    }
}
