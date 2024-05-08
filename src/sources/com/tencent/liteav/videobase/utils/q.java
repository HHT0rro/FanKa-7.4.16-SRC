package com.tencent.liteav.videobase.utils;

import com.tencent.liteav.videobase.base.TakeSnapshotListener;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final n f43547a;

    /* renamed from: b, reason: collision with root package name */
    private final TakeSnapshotListener f43548b;

    private q(n nVar, TakeSnapshotListener takeSnapshotListener) {
        this.f43547a = nVar;
        this.f43548b = takeSnapshotListener;
    }

    public static Runnable a(n nVar, TakeSnapshotListener takeSnapshotListener) {
        return new q(nVar, takeSnapshotListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f43547a.f43537e = this.f43548b;
    }
}
