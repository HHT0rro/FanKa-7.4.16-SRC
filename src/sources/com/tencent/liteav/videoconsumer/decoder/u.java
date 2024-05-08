package com.tencent.liteav.videoconsumer.decoder;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.DatabaseSourceInfoStorage;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoconsumer.consumer.VideoConsumerServerConfig;
import com.tencent.liteav.videoconsumer.decoder.VideoDecoderDef;
import com.tencent.liteav.videoconsumer.decoder.ad;
import com.tencent.liteav.videoconsumer.decoder.bk;
import org.json.JSONArray;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class u implements ad.b, bk {

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final IVideoReporter f44001b;

    /* renamed from: i, reason: collision with root package name */
    public final com.tencent.liteav.videobase.utils.h f44008i;

    /* renamed from: j, reason: collision with root package name */
    public final a f44009j;

    /* renamed from: k, reason: collision with root package name */
    public MediaCodec f44010k;

    /* renamed from: a, reason: collision with root package name */
    public String f44000a = "HardwareVideoDecoder";

    /* renamed from: l, reason: collision with root package name */
    private final com.tencent.liteav.base.b.b f44011l = new com.tencent.liteav.base.b.b();

    /* renamed from: c, reason: collision with root package name */
    public Surface f44002c = null;

    /* renamed from: d, reason: collision with root package name */
    public ad f44003d = null;

    /* renamed from: e, reason: collision with root package name */
    public volatile CustomHandler f44004e = null;

    /* renamed from: f, reason: collision with root package name */
    public bl f44005f = null;

    /* renamed from: m, reason: collision with root package name */
    private EncodedVideoFrame f44012m = null;

    /* renamed from: n, reason: collision with root package name */
    private boolean f44013n = true;

    /* renamed from: g, reason: collision with root package name */
    public VideoDecoderDef.ConsumerScene f44006g = VideoDecoderDef.ConsumerScene.UNKNOWN;

    /* renamed from: h, reason: collision with root package name */
    public boolean f44007h = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f44014o = false;

    /* renamed from: p, reason: collision with root package name */
    private long f44015p = 0;

    public u(@NonNull a aVar, @NonNull IVideoReporter iVideoReporter, MediaCodec mediaCodec) {
        this.f44001b = iVideoReporter;
        a aVar2 = new a(aVar);
        this.f44009j = aVar2;
        this.f44010k = mediaCodec;
        String str = aVar2.f44017b ? "video/hevc" : com.alibaba.security.biometrics.service.build.ah.f2598d;
        MediaFormat mediaFormat = aVar.f44021f;
        if (mediaFormat != null) {
            aVar2.f44020e = new Size(mediaFormat.getInteger("width"), aVar.f44021f.getInteger("height"));
            str = aVar.f44021f.getString(DatabaseSourceInfoStorage.COLUMN_MIME);
        }
        com.tencent.liteav.videobase.utils.h hVar = new com.tencent.liteav.videobase.utils.h();
        hVar.f43500a = aVar2.f44021f;
        hVar.f43501b = aVar2.f44023h;
        hVar.f43504e = str;
        hVar.f43502c = aVar2.f44020e.getWidth();
        hVar.f43503d = aVar2.f44020e.getHeight();
        this.f44008i = hVar;
        this.f44000a += "_" + hashCode();
    }

    private void c() {
        EncodedVideoFrame encodedVideoFrame;
        synchronized (this) {
            encodedVideoFrame = this.f44012m;
            this.f44012m = null;
        }
        a(encodedVideoFrame);
    }

    private boolean d() {
        if (this.f44003d.a()) {
            this.f44013n = false;
        }
        return this.f44013n;
    }

    public final void a(Surface surface) {
        a(aa.a(this, surface));
    }

    public final void b() {
        EncodedVideoFrame encodedVideoFrame;
        if (this.f44003d == null) {
            LiteavLog.w(this.f44000a, "MediaCodec is stopped.");
            c();
            return;
        }
        try {
            if (this.f44013n) {
                d();
            }
            synchronized (this) {
                encodedVideoFrame = this.f44012m;
            }
            if (encodedVideoFrame != null && this.f44003d.a(encodedVideoFrame)) {
                synchronized (this) {
                    if (this.f44012m == encodedVideoFrame) {
                        this.f44012m = null;
                    }
                }
                a(encodedVideoFrame);
            }
        } catch (Throwable th) {
            LiteavLog.e(this.f44000a, "decode failed.", th);
            b(h.c.WARNING_VIDEO_DECODE_RESTART_WHEN_DECODE_ERROR, "VideoDecode: decode error, restart decoder message:" + th.getMessage());
        }
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.bk
    public final boolean decode(EncodedVideoFrame encodedVideoFrame) {
        synchronized (this) {
            if (this.f44012m == null && encodedVideoFrame != null) {
                this.f44012m = encodedVideoFrame;
                a(x.a(this));
                return true;
            }
            a(w.a(this));
            return false;
        }
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.bk
    public final bk.a getDecoderType() {
        a aVar = this.f44009j;
        return (aVar == null || !aVar.f44022g) ? bk.a.HARDWARE : bk.a.SOFTWARE_DEVICE;
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.bk
    public final void initialize() {
        HandlerThread handlerThread = new HandlerThread("HardwareVideoDecoder_" + hashCode());
        handlerThread.start();
        this.f44004e = new CustomHandler(handlerThread.getLooper());
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.bk
    public final void setScene(VideoDecoderDef.ConsumerScene consumerScene) {
        a(z.a(this, consumerScene));
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.bk
    public final void setServerConfig(VideoConsumerServerConfig videoConsumerServerConfig) {
        a(ab.a(this, videoConsumerServerConfig));
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.bk
    public final void start(Object obj, bl blVar) {
        a(v.a(this, obj, blVar));
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.bk
    public final void stop() {
        a(y.a(this));
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.bk
    public final void uninitialize() {
        if (this.f44004e != null) {
            LiteavLog.i(this.f44000a, "uninitialize quitLooper");
            this.f44004e.quitLooper();
        }
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ad.b
    public final void a(h.c cVar, String str) {
        b(cVar, str);
    }

    public final void a() {
        LiteavLog.i(this.f44000a, "Stop decoder");
        ad adVar = this.f44003d;
        if (adVar != null) {
            adVar.b();
            this.f44003d = null;
        }
        c();
        this.f44013n = true;
        this.f44015p = 0L;
    }

    private static void a(EncodedVideoFrame encodedVideoFrame) {
        if (encodedVideoFrame == null) {
            return;
        }
        encodedVideoFrame.release();
    }

    private void a(Runnable runnable) {
        if (this.f44004e != null) {
            this.f44004e.runOrPost(runnable);
        }
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ad.b
    public final void a(PixelFrame pixelFrame, boolean z10) {
        boolean z11 = true;
        if (z10) {
            bl blVar = this.f44005f;
            if (blVar != null) {
                blVar.k();
            }
            this.f44013n = true;
            return;
        }
        if (pixelFrame == null) {
            return;
        }
        this.f44015p++;
        this.f44013n = true;
        bl blVar2 = this.f44005f;
        if (blVar2 != null) {
            blVar2.a(pixelFrame, pixelFrame.getTimestamp());
        }
        try {
            if (this.f44015p % 30 != 0) {
                z11 = false;
            }
            if (z11 && d()) {
                LiteavLog.d(this.f44000a, "drain more frame success");
            }
        } catch (Throwable th) {
            LiteavLog.e(this.f44011l.a("drainDecodedFrame"), this.f44000a, "exception from drain decoded frame, message:" + th.getMessage(), new Object[0]);
        }
        if (this.f44014o) {
            bl blVar3 = this.f44005f;
            if (blVar3 != null) {
                blVar3.j();
            }
            this.f44014o = false;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f44016a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f44017b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f44018c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f44019d;

        /* renamed from: e, reason: collision with root package name */
        public Size f44020e;

        /* renamed from: f, reason: collision with root package name */
        public MediaFormat f44021f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f44022g;

        /* renamed from: h, reason: collision with root package name */
        public JSONArray f44023h;

        public a(a aVar) {
            this.f44016a = false;
            this.f44017b = false;
            this.f44018c = false;
            this.f44019d = false;
            this.f44020e = null;
            this.f44021f = null;
            this.f44022g = false;
            this.f44023h = null;
            this.f44016a = aVar.f44016a;
            this.f44017b = aVar.f44017b;
            this.f44018c = aVar.f44018c;
            this.f44019d = aVar.f44019d;
            this.f44020e = aVar.f44020e;
            this.f44021f = aVar.f44021f;
            this.f44023h = aVar.f44023h;
            this.f44022g = aVar.f44022g;
        }

        public a() {
            this.f44016a = false;
            this.f44017b = false;
            this.f44018c = false;
            this.f44019d = false;
            this.f44020e = null;
            this.f44021f = null;
            this.f44022g = false;
            this.f44023h = null;
        }
    }

    public final void b(h.c cVar, String str) {
        c();
        this.f44001b.notifyWarning(cVar, str);
        bl blVar = this.f44005f;
        if (blVar != null) {
            blVar.i();
        }
    }
}
