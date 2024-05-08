package com.tencent.liteav.videoconsumer.renderer;

import com.tencent.liteav.videobase.base.TakeSnapshotListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class ae implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final t f44061a;

    /* renamed from: b, reason: collision with root package name */
    private final TakeSnapshotListener f44062b;

    private ae(t tVar, TakeSnapshotListener takeSnapshotListener) {
        this.f44061a = tVar;
        this.f44062b = takeSnapshotListener;
    }

    public static Runnable a(t tVar, TakeSnapshotListener takeSnapshotListener) {
        return new ae(tVar, takeSnapshotListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.a(this.f44061a, this.f44062b);
    }
}
