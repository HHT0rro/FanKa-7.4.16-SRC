package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.videobase.base.TakeSnapshotListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class ay implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final ax f44594a;

    /* renamed from: b, reason: collision with root package name */
    private final TakeSnapshotListener f44595b;

    private ay(ax axVar, TakeSnapshotListener takeSnapshotListener) {
        this.f44594a = axVar;
        this.f44595b = takeSnapshotListener;
    }

    public static Runnable a(ax axVar, TakeSnapshotListener takeSnapshotListener) {
        return new ay(axVar, takeSnapshotListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ax.a(this.f44594a, this.f44595b);
    }
}
