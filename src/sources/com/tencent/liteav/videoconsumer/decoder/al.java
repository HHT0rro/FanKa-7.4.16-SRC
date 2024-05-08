package com.tencent.liteav.videoconsumer.decoder;

import android.media.MediaCodec;
import android.os.SystemClock;
import com.tencent.liteav.base.util.LiteavLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class al implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final aj f43865a;

    private al(aj ajVar) {
        this.f43865a = ajVar;
    }

    public static Runnable a(aj ajVar) {
        return new al(ajVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        MediaCodec mediaCodec;
        aj ajVar = this.f43865a;
        synchronized (ajVar) {
            ajVar.f43859b = null;
        }
        ajVar.b();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        synchronized (ajVar) {
            mediaCodec = ajVar.f43860c;
            ajVar.f43860c = null;
        }
        ajVar.a(mediaCodec);
        LiteavLog.i(ajVar.f43858a, "destroy preload MediaCodec success, cost:(%d)ms", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
    }
}
