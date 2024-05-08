package com.tencent.liteav.videoconsumer.consumer;

import android.content.IntentFilter;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoconsumer.decoder.VideoDecodeController;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f43753a;

    private o(b bVar) {
        this.f43753a = bVar;
    }

    public static Runnable a(b bVar) {
        return new o(bVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f43753a;
        LiteavLog.i(bVar.f43692a, "initialize mVideoDecodeController");
        bVar.f43698g.a(bVar.f43714w);
        VideoDecodeController videoDecodeController = bVar.f43698g;
        LiteavLog.i(videoDecodeController.f43774a, "initialize");
        final com.tencent.liteav.videobase.utils.n nVar = videoDecodeController.f43793t;
        nVar.getClass();
        videoDecodeController.a(new Runnable(nVar) { // from class: com.tencent.liteav.videoconsumer.decoder.aw

            /* renamed from: a, reason: collision with root package name */
            private final com.tencent.liteav.videobase.utils.n f43881a;

            {
                this.f43881a = nVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f43881a.a();
            }
        });
        if (bVar.f43696e == null) {
            bVar.f43696e = new com.tencent.liteav.videoconsumer.renderer.t(bVar.f43693b, bVar.f43694c);
        }
        com.tencent.liteav.videobase.utils.i.a().a(bVar.f43701j, new IntentFilter("com.tencent.liteav.video.action.OUT_OF_MEMORY"));
    }
}
