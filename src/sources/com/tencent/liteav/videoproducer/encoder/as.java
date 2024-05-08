package com.tencent.liteav.videoproducer.encoder;

import android.media.MediaCodec;
import android.os.SystemClock;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class as implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final am f44561a;

    /* renamed from: b, reason: collision with root package name */
    private final int f44562b;

    private as(am amVar, int i10) {
        this.f44561a = amVar;
        this.f44562b = i10;
    }

    public static Runnable a(am amVar, int i10) {
        return new as(amVar, i10);
    }

    @Override // java.lang.Runnable
    public final void run() {
        MediaCodec mediaCodec;
        am amVar = this.f44561a;
        int i10 = this.f44562b;
        VideoEncodeParams videoEncodeParams = amVar.f44530f;
        if (videoEncodeParams == null) {
            LiteavLog.w(amVar.f44525a, "encoder not started yet. set bitrate to " + i10 + " kbps will not take effect.");
            return;
        }
        if (videoEncodeParams.bitrate != i10) {
            LiteavLog.i(amVar.f44525a, "set bitrate to " + i10 + " kbps");
            boolean z10 = false;
            if (i10 < amVar.f44530f.bitrate) {
                if (amVar.f44526b.getBoolean("need_restart_when_down_bitrate", false)) {
                    z10 = true;
                } else {
                    amVar.b(i10);
                }
            }
            amVar.f44530f.bitrate = i10;
            if (LiteavSystemInfo.getSystemOSVersionInt() < 19 || (mediaCodec = amVar.f44528d) == null) {
                return;
            }
            if (z10) {
                amVar.f44527c.removeCallbacks(amVar.f44534j);
                long elapsedRealtime = SystemClock.elapsedRealtime() - amVar.f44531g;
                if (elapsedRealtime >= TimeUnit.SECONDS.toMillis(2L)) {
                    amVar.f44534j.run();
                    return;
                } else {
                    amVar.f44527c.postDelayed(amVar.f44534j, 2000 - elapsedRealtime);
                    return;
                }
            }
            amVar.a(mediaCodec, i10);
        }
    }
}
