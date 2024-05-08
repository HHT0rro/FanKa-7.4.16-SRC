package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videobase.base.TakeSnapshotListener;
import com.tencent.liteav.videobase.common.SnapshotSourceType;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ae implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final i f44915a;

    /* renamed from: b, reason: collision with root package name */
    private final SnapshotSourceType f44916b;

    /* renamed from: c, reason: collision with root package name */
    private final TakeSnapshotListener f44917c;

    private ae(i iVar, SnapshotSourceType snapshotSourceType, TakeSnapshotListener takeSnapshotListener) {
        this.f44915a = iVar;
        this.f44916b = snapshotSourceType;
        this.f44917c = takeSnapshotListener;
    }

    public static Runnable a(i iVar, SnapshotSourceType snapshotSourceType, TakeSnapshotListener takeSnapshotListener) {
        return new ae(iVar, snapshotSourceType, takeSnapshotListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        i.a(this.f44915a, this.f44916b, this.f44917c);
    }
}
