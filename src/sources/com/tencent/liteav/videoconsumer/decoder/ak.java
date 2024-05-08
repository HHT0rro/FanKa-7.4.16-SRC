package com.tencent.liteav.videoconsumer.decoder;

import android.media.MediaFormat;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class ak implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final aj f43863a;

    /* renamed from: b, reason: collision with root package name */
    private final MediaFormat f43864b;

    private ak(aj ajVar, MediaFormat mediaFormat) {
        this.f43863a = ajVar;
        this.f43864b = mediaFormat;
    }

    public static Runnable a(aj ajVar, MediaFormat mediaFormat) {
        return new ak(ajVar, mediaFormat);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r13 = this;
            com.tencent.liteav.videoconsumer.decoder.aj r0 = r13.f43863a
            android.media.MediaFormat r1 = r13.f43864b
            java.lang.String r2 = r0.f43858a
            java.lang.String r3 = "start preload MediaCodec begin"
            com.tencent.liteav.base.util.LiteavLog.i(r2, r3)
            long r2 = android.os.SystemClock.elapsedRealtime()
            r4 = 35
            r5 = 128(0x80, float:1.794E-43)
            r6 = 0
            r7 = 0
            r8 = 1
            android.media.ImageReader r4 = android.media.ImageReader.newInstance(r5, r5, r4, r8)     // Catch: java.lang.Throwable -> L63
            r0.f43861d = r4     // Catch: java.lang.Throwable -> L63
            java.lang.String r4 = "mime"
            java.lang.String r4 = r1.getString(r4)     // Catch: java.lang.Throwable -> L63
            android.media.MediaCodec r4 = android.media.MediaCodec.createDecoderByType(r4)     // Catch: java.lang.Throwable -> L63
            r4.setVideoScalingMode(r8)     // Catch: java.lang.Throwable -> L61
            android.media.ImageReader r5 = r0.f43861d     // Catch: java.lang.Throwable -> L61
            android.view.Surface r5 = r5.getSurface()     // Catch: java.lang.Throwable -> L61
            r4.configure(r1, r5, r7, r6)     // Catch: java.lang.Throwable -> L61
            java.lang.String r5 = r0.f43858a     // Catch: java.lang.Throwable -> L61
            java.lang.String r9 = "configure preload MediaCodec, format: "
            java.lang.String r10 = java.lang.String.valueOf(r1)     // Catch: java.lang.Throwable -> L61
            java.lang.String r9 = r9.concat(r10)     // Catch: java.lang.Throwable -> L61
            com.tencent.liteav.base.util.LiteavLog.i(r5, r9)     // Catch: java.lang.Throwable -> L61
            r4.start()     // Catch: java.lang.Throwable -> L61
            java.lang.String r5 = r0.f43858a     // Catch: java.lang.Throwable -> L61
            java.lang.String r9 = "start preload MediaCodec(%s) success, cost:(%d)ms"
            r10 = 2
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch: java.lang.Throwable -> L61
            java.lang.String r11 = r4.getName()     // Catch: java.lang.Throwable -> L61
            r10[r6] = r11     // Catch: java.lang.Throwable -> L61
            long r11 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L61
            long r11 = r11 - r2
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch: java.lang.Throwable -> L61
            r10[r8] = r11     // Catch: java.lang.Throwable -> L61
            com.tencent.liteav.base.util.LiteavLog.i(r5, r9, r10)     // Catch: java.lang.Throwable -> L61
            r7 = r4
            goto L7a
        L61:
            r5 = move-exception
            goto L65
        L63:
            r5 = move-exception
            r4 = r7
        L65:
            java.lang.String r9 = r0.f43858a
            java.lang.String r10 = "start preload MediaCodec failed"
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r5 = r10.concat(r5)
            com.tencent.liteav.base.util.LiteavLog.e(r9, r5)
            r0.b()
            r0.a(r4)
        L7a:
            monitor-enter(r0)
            r0.f43860c = r7     // Catch: java.lang.Throwable -> L95
            r0.f43859b = r1     // Catch: java.lang.Throwable -> L95
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L95
            java.lang.String r0 = r0.f43858a
            java.lang.String r1 = "start preload MediaCodec end, cost:(%d)ms"
            java.lang.Object[] r4 = new java.lang.Object[r8]
            long r7 = android.os.SystemClock.elapsedRealtime()
            long r7 = r7 - r2
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            r4[r6] = r2
            com.tencent.liteav.base.util.LiteavLog.i(r0, r1, r4)
            return
        L95:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L95
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.videoconsumer.decoder.ak.run():void");
    }
}
