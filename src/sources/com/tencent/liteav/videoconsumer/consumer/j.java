package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.TakeSnapshotListener;
import com.tencent.liteav.videobase.common.SnapshotSourceType;
import com.tencent.liteav.videoconsumer.decoder.VideoDecodeController;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f43741a;

    /* renamed from: b, reason: collision with root package name */
    private final SnapshotSourceType f43742b;

    /* renamed from: c, reason: collision with root package name */
    private final TakeSnapshotListener f43743c;

    private j(b bVar, SnapshotSourceType snapshotSourceType, TakeSnapshotListener takeSnapshotListener) {
        this.f43741a = bVar;
        this.f43742b = snapshotSourceType;
        this.f43743c = takeSnapshotListener;
    }

    public static Runnable a(b bVar, SnapshotSourceType snapshotSourceType, TakeSnapshotListener takeSnapshotListener) {
        return new j(bVar, snapshotSourceType, takeSnapshotListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.tencent.liteav.videoconsumer.renderer.t tVar;
        b bVar = this.f43741a;
        SnapshotSourceType snapshotSourceType = this.f43742b;
        final TakeSnapshotListener takeSnapshotListener = this.f43743c;
        LiteavLog.i(bVar.f43692a, "takeSnapshot: sourceType = " + ((Object) snapshotSourceType) + ", listener = " + ((Object) takeSnapshotListener));
        if (snapshotSourceType == SnapshotSourceType.STREAM) {
            final VideoDecodeController videoDecodeController = bVar.f43698g;
            videoDecodeController.a(new Runnable(videoDecodeController, takeSnapshotListener) { // from class: com.tencent.liteav.videoconsumer.decoder.be

                /* renamed from: a, reason: collision with root package name */
                private final VideoDecodeController f43897a;

                /* renamed from: b, reason: collision with root package name */
                private final TakeSnapshotListener f43898b;

                {
                    this.f43897a = videoDecodeController;
                    this.f43898b = takeSnapshotListener;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    VideoDecodeController videoDecodeController2 = this.f43897a;
                    TakeSnapshotListener takeSnapshotListener2 = this.f43898b;
                    LiteavLog.i(videoDecodeController2.f43774a, "takeSnapshot ".concat(String.valueOf(takeSnapshotListener2)));
                    videoDecodeController2.f43793t.a(takeSnapshotListener2);
                }
            });
            return;
        }
        if (snapshotSourceType == SnapshotSourceType.VIEW) {
            if (bVar.f43702k != null && (tVar = bVar.f43696e) != null) {
                tVar.a(takeSnapshotListener);
                return;
            }
            if (bVar.f43699h != null) {
                bVar.f43697f.a(takeSnapshotListener);
                return;
            }
            LiteavLog.w(bVar.f43692a, "takeSnapshot return null, no match render.");
            if (takeSnapshotListener != null) {
                takeSnapshotListener.onComplete(null);
            }
        }
    }
}
