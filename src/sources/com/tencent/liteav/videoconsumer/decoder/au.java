package com.tencent.liteav.videoconsumer.decoder;

import android.os.SystemClock;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoconsumer.decoder.bi;
import com.tencent.liteav.videoconsumer.decoder.bk;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class au implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final VideoDecodeController f43877a;

    /* renamed from: b, reason: collision with root package name */
    private final long f43878b;

    /* renamed from: c, reason: collision with root package name */
    private final long f43879c;

    private au(VideoDecodeController videoDecodeController, long j10, long j11) {
        this.f43877a = videoDecodeController;
        this.f43878b = j10;
        this.f43879c = j11;
    }

    public static Runnable a(VideoDecodeController videoDecodeController, long j10, long j11) {
        return new au(videoDecodeController, j10, j11);
    }

    @Override // java.lang.Runnable
    public final void run() {
        VideoDecodeController videoDecodeController = this.f43877a;
        long j10 = this.f43878b;
        long j11 = this.f43879c;
        if (videoDecodeController.f43783j) {
            videoDecodeController.f43794u.set(true);
            e eVar = videoDecodeController.f43776c;
            int i10 = eVar.f43946m;
            if (i10 > 0) {
                eVar.f43946m = i10 - 1;
            }
            if (eVar.f43941h == 0) {
                LiteavLog.i(eVar.f43934a, "decode first frame success");
            }
            eVar.f43941h = j10;
            eVar.f43948o = 0;
            videoDecodeController.f43790q.decrementAndGet();
            bi biVar = videoDecodeController.f43777d;
            biVar.f43907e.a();
            bi.a aVar = biVar.f43905c;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j12 = elapsedRealtime - aVar.f43919d;
            aVar.f43921f.add(Long.valueOf(j12));
            aVar.f43919d = elapsedRealtime;
            if (!aVar.f43920e.isEmpty()) {
                aVar.f43920e.removeFirst();
            }
            if (elapsedRealtime - aVar.f43917b >= TimeUnit.SECONDS.toMillis(1L)) {
                aVar.f43917b = elapsedRealtime;
                Iterator<Long> iterator2 = aVar.f43921f.iterator2();
                long j13 = 0;
                while (iterator2.hasNext()) {
                    j13 += iterator2.next().longValue();
                }
                aVar.f43918c = j13 / Math.max(aVar.f43921f.size(), 1);
                aVar.f43921f.clear();
            }
            bi.this.f43904b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_DECODER_COST, Long.valueOf(j12));
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            if (aVar.f43916a == 0) {
                aVar.f43916a = elapsedRealtime2;
            }
            long j14 = aVar.f43916a;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            if (elapsedRealtime2 >= j14 + timeUnit.toMillis(1L)) {
                aVar.f43916a = elapsedRealtime2;
                long j15 = aVar.f43918c;
                bi biVar2 = bi.this;
                if (biVar2.f43908f == bk.a.HARDWARE) {
                    biVar2.f43904b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_HW_DECODE_TASK_COST, Long.valueOf(j15));
                } else {
                    biVar2.f43904b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_SW_DECODE_TASK_COST, Long.valueOf(j15));
                }
            }
            bi.b bVar = biVar.f43906d;
            long elapsedRealtime3 = SystemClock.elapsedRealtime();
            if (bVar.f43924b == 0) {
                bVar.f43924b = elapsedRealtime3;
            }
            if (bVar.f43923a == 0) {
                bVar.f43923a = elapsedRealtime3;
            }
            if (elapsedRealtime3 > bVar.f43923a + timeUnit.toMillis(1L) && elapsedRealtime3 > bVar.f43924b + timeUnit.toMillis(2L)) {
                LiteavLog.e("DecodeSmoothStatistics", "frame interval [%d] > %d", Long.valueOf(elapsedRealtime3 - bVar.f43923a), Long.valueOf(timeUnit.toMillis(1L)));
                bVar.f43924b = elapsedRealtime3;
            }
            bVar.f43923a = elapsedRealtime3;
            biVar.b();
            if (!biVar.f43909g) {
                biVar.f43909g = true;
                biVar.f43904b.notifyEvent(h.b.EVT_VIDEO_DECODE_FIRST_FRAME_DECODED, (Object) null, "first frame decoded");
                LiteavLog.i(biVar.f43903a, "first frame decoded cost time: " + (SystemClock.elapsedRealtime() - biVar.f43910h) + ", before decode first frame received: " + biVar.f43911i);
            }
            PixelFrame a10 = videoDecodeController.f43791r.a();
            if (a10 != null) {
                Object obj = videoDecodeController.f43782i;
                if (obj != null && !OpenGlUtils.isNoGLContext(obj)) {
                    a10.setGLContext(videoDecodeController.f43782i);
                }
                videoDecodeController.f43793t.a(a10.getWidth(), a10.getHeight());
                videoDecodeController.f43793t.a(a10);
                videoDecodeController.f43795v.a(a10);
                bl blVar = videoDecodeController.f43781h;
                if (blVar != null) {
                    blVar.a(a10, j11);
                }
                a10.release();
            }
        }
    }
}
