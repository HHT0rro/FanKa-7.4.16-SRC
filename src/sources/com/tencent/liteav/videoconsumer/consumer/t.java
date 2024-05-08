package com.tencent.liteav.videoconsumer.consumer;

import android.media.MediaFormat;
import android.os.Build;
import android.os.SystemClock;
import com.android.internal.logging.nano.MetricsProto;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videoconsumer.decoder.VideoDecodeController;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final /* synthetic */ class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final b f43762a;

    /* renamed from: b, reason: collision with root package name */
    private final CodecType f43763b;

    private t(b bVar, CodecType codecType) {
        this.f43762a = bVar;
        this.f43763b = codecType;
    }

    public static Runnable a(b bVar, CodecType codecType) {
        return new t(bVar, codecType);
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar = this.f43762a;
        final CodecType codecType = this.f43763b;
        LiteavLog.i(bVar.f43692a, "preload decoder, codecType:" + ((Object) codecType) + ", [1:H264, 2:H265]");
        final VideoDecodeController videoDecodeController = bVar.f43698g;
        LiteavLog.i(videoDecodeController.f43774a, "preloadDecoder start");
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        videoDecodeController.a(new Runnable(videoDecodeController, codecType, elapsedRealtime) { // from class: com.tencent.liteav.videoconsumer.decoder.bd

            /* renamed from: a, reason: collision with root package name */
            private final VideoDecodeController f43894a;

            /* renamed from: b, reason: collision with root package name */
            private final CodecType f43895b;

            /* renamed from: c, reason: collision with root package name */
            private final long f43896c;

            {
                this.f43894a = videoDecodeController;
                this.f43895b = codecType;
                this.f43896c = elapsedRealtime;
            }

            @Override // java.lang.Runnable
            public final void run() {
                VideoDecodeController videoDecodeController2 = this.f43894a;
                CodecType codecType2 = this.f43895b;
                long j10 = this.f43896c;
                if (Build.VERSION.SDK_INT < 23) {
                    LiteavLog.e(videoDecodeController2.f43774a, "current android version not support preload MediaCodec");
                    return;
                }
                MediaFormat createVideoFormat = MediaFormat.createVideoFormat(codecType2 == CodecType.H265 ? "video/hevc" : com.alibaba.security.biometrics.service.build.ah.f2598d, MetricsProto.MetricsEvent.DATA_PLAN_USAGE_SUMMARY, 1920);
                ac acVar = videoDecodeController2.f43796w;
                if (acVar != null) {
                    acVar.a();
                    videoDecodeController2.f43796w = null;
                }
                aj ajVar = new aj();
                videoDecodeController2.f43796w = ajVar;
                ajVar.a(createVideoFormat);
                LiteavLog.i(videoDecodeController2.f43774a, "preloadDecoder success. cost time:(%d)ms", Long.valueOf(SystemClock.elapsedRealtime() - j10));
            }
        });
    }
}
