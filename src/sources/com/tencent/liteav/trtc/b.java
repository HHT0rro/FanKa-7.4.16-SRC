package com.tencent.liteav.trtc;

import android.graphics.Bitmap;
import com.tencent.trtc.TRTCCloudListener;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final TRTCCloudListener.TRTCSnapshotListener f43243a;

    /* renamed from: b, reason: collision with root package name */
    private final Bitmap f43244b;

    private b(TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener, Bitmap bitmap) {
        this.f43243a = tRTCSnapshotListener;
        this.f43244b = bitmap;
    }

    public static Runnable a(TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener, Bitmap bitmap) {
        return new b(tRTCSnapshotListener, bitmap);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TrtcCloudJni.lambda$onSnapshotComplete$1(this.f43243a, this.f43244b);
    }
}
