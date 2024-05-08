package com.tencent.liteav.videoconsumer.consumer;

import android.os.SystemClock;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.r;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoconsumer.consumer.a;
import com.tencent.liteav.videoconsumer.consumer.b;
import com.tencent.liteav.videoconsumer.decoder.VideoDecodeController;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class y implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f43769a;

    /* renamed from: b, reason: collision with root package name */
    private final EncodedVideoFrame f43770b;

    private y(b bVar, EncodedVideoFrame encodedVideoFrame) {
        this.f43769a = bVar;
        this.f43770b = encodedVideoFrame;
    }

    public static Runnable a(b bVar, EncodedVideoFrame encodedVideoFrame) {
        return new y(bVar, encodedVideoFrame);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f43769a;
        EncodedVideoFrame encodedVideoFrame = this.f43770b;
        if (bVar.f43710s == b.EnumC0643b.STOPPED) {
            LiteavLog.i(bVar.f43692a, "appendNALPacket ignored packet. status is  stoped.");
            return;
        }
        if (bVar.f43708q != encodedVideoFrame.isHDRFrame()) {
            bVar.f43708q = encodedVideoFrame.isHDRFrame();
            LiteavLog.i(bVar.f43692a, "stream change to hdr: " + bVar.f43708q);
            final com.tencent.liteav.videoconsumer.renderer.t tVar = bVar.f43696e;
            if (tVar != null) {
                final boolean z10 = bVar.f43708q;
                tVar.a(new Runnable(tVar, z10) { // from class: com.tencent.liteav.videoconsumer.renderer.w

                    /* renamed from: a, reason: collision with root package name */
                    private final t f44156a;

                    /* renamed from: b, reason: collision with root package name */
                    private final boolean f44157b;

                    {
                        this.f44156a = tVar;
                        this.f44157b = z10;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f44156a.f44152z = this.f44157b;
                    }
                });
            }
            if (bVar.f43707p) {
                VideoDecodeController videoDecodeController = bVar.f43698g;
                if (videoDecodeController != null) {
                    videoDecodeController.f();
                    bVar.f43698g.a(bVar.C);
                }
                com.tencent.liteav.videoconsumer.renderer.t tVar2 = bVar.f43696e;
                if (tVar2 != null) {
                    tVar2.a(false);
                    bVar.f43696e.a(bVar.f43700i);
                }
            }
        }
        if (!bVar.f43707p) {
            bVar.f43707p = true;
            LiteavLog.i(bVar.f43692a, "video consumer receive first video frame");
            bVar.f43694c.notifyEvent(h.b.EVT_VIDEO_CONSUMER_RECEIVE_FIRST_FRAME, (Object) null, (String) null);
        }
        if (bVar.f43699h != null) {
            a aVar = bVar.f43697f;
            Object obj = bVar.f43715x;
            int i10 = a.EnumC0642a.f43689a;
            if (!CommonUtil.equals(aVar.f43674c, obj)) {
                LiteavLog.i(aVar.f43672a, "set shared EGLContext. sharedContext = ".concat(String.valueOf(obj)));
                aVar.d();
                aVar.f43674c = obj;
                aVar.c();
            }
            a aVar2 = bVar.f43697f;
            if (aVar2.f43673b != a.EnumC0642a.f43690b) {
                aVar2.c();
            }
            final VideoDecodeController videoDecodeController2 = bVar.f43698g;
            final Object b4 = bVar.f43697f.b();
            videoDecodeController2.a(new Runnable(videoDecodeController2, b4) { // from class: com.tencent.liteav.videoconsumer.decoder.bb

                /* renamed from: a, reason: collision with root package name */
                private final VideoDecodeController f43890a;

                /* renamed from: b, reason: collision with root package name */
                private final Object f43891b;

                {
                    this.f43890a = videoDecodeController2;
                    this.f43891b = b4;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    VideoDecodeController videoDecodeController3 = this.f43890a;
                    Object obj2 = this.f43891b;
                    if (CommonUtil.equals(videoDecodeController3.f43782i, obj2)) {
                        return;
                    }
                    LiteavLog.i(videoDecodeController3.f43774a, "setSharedEGLContext(object:" + obj2 + ")");
                    videoDecodeController3.f43782i = obj2;
                    videoDecodeController3.f43776c.f43949p = true;
                }
            });
        }
        bVar.A.add(new b.a(encodedVideoFrame.pts, encodedVideoFrame.rotation));
        bVar.f43709r.a();
        final VideoDecodeController videoDecodeController3 = bVar.f43698g;
        com.tencent.liteav.videoconsumer.decoder.d dVar = videoDecodeController3.f43795v;
        synchronized (dVar.f43932a) {
            dVar.f43932a.put(Long.valueOf(encodedVideoFrame.pts), encodedVideoFrame.consumerChainTimestamp);
        }
        synchronized (videoDecodeController3) {
            videoDecodeController3.f43789p.addLast(encodedVideoFrame);
        }
        videoDecodeController3.a(new Runnable(videoDecodeController3) { // from class: com.tencent.liteav.videoconsumer.decoder.bh

            /* renamed from: a, reason: collision with root package name */
            private final VideoDecodeController f43902a;

            {
                this.f43902a = videoDecodeController3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                VideoDecodeController videoDecodeController4 = this.f43902a;
                if (videoDecodeController4.f43780g == null) {
                    com.tencent.liteav.base.util.r rVar = new com.tencent.liteav.base.util.r(videoDecodeController4.f43779f, new r.a(videoDecodeController4) { // from class: com.tencent.liteav.videoconsumer.decoder.bg

                        /* renamed from: a, reason: collision with root package name */
                        private final VideoDecodeController f43901a;

                        {
                            this.f43901a = videoDecodeController4;
                        }

                        @Override // com.tencent.liteav.base.util.r.a
                        public final void a() {
                            bk bkVar;
                            VideoDecodeController videoDecodeController5 = this.f43901a;
                            if (videoDecodeController5.f43783j) {
                                if (videoDecodeController5.d() > 0) {
                                    videoDecodeController5.b();
                                } else {
                                    if (!videoDecodeController5.f43778e || videoDecodeController5.f43790q.get() <= 0 || (bkVar = videoDecodeController5.f43784k) == null) {
                                        return;
                                    }
                                    bkVar.decode(null);
                                }
                            }
                        }
                    });
                    videoDecodeController4.f43780g = rVar;
                    rVar.a();
                }
                videoDecodeController4.f43777d.f43913k = SystemClock.elapsedRealtime();
                videoDecodeController4.b();
                bi biVar = videoDecodeController4.f43777d;
                if (biVar.f43913k != 0) {
                    biVar.f43904b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_DECODE_TASK_COST, Integer.valueOf((int) (SystemClock.elapsedRealtime() - biVar.f43913k)));
                    biVar.f43913k = 0L;
                }
            }
        });
    }
}
