package com.tencent.liteav.videoproducer.encoder;

import android.media.MediaCodec;
import android.os.Looper;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.w;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class au implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final am f44564a;

    private au(am amVar) {
        this.f44564a = amVar;
    }

    public static Runnable a(am amVar) {
        return new au(amVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        final am amVar = this.f44564a;
        LiteavLog.i(amVar.f44525a, "signalEndOfStream");
        MediaCodec mediaCodec = amVar.f44528d;
        if (mediaCodec != null) {
            try {
                mediaCodec.signalEndOfInputStream();
            } catch (Throwable th) {
                LiteavLog.e(amVar.f44525a, "signalEndOfStream failed.", th);
            }
        }
        if (amVar.f44532h == null) {
            com.tencent.liteav.base.util.w wVar = new com.tencent.liteav.base.util.w(Looper.myLooper(), new w.a(amVar) { // from class: com.tencent.liteav.videoproducer.encoder.ao

                /* renamed from: a, reason: collision with root package name */
                private final am f44553a;

                {
                    this.f44553a = amVar;
                }

                @Override // com.tencent.liteav.base.util.w.a
                public final void onTimeout() {
                    this.f44553a.h();
                }
            });
            amVar.f44532h = wVar;
            wVar.a(0, 30);
        }
    }
}
