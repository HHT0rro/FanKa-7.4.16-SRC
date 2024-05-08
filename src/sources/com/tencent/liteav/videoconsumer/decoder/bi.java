package com.tencent.liteav.videoconsumer.decoder;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.utils.f;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoconsumer.decoder.VideoDecoderDef;
import com.tencent.liteav.videoconsumer.decoder.bk;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bi {

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final IVideoReporter f43904b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final a f43905c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final b f43906d;

    /* renamed from: f, reason: collision with root package name */
    public bk.a f43908f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f43909g;

    /* renamed from: a, reason: collision with root package name */
    public String f43903a = "VideoDecodeControllerStatistics";

    /* renamed from: h, reason: collision with root package name */
    public long f43910h = 0;

    /* renamed from: i, reason: collision with root package name */
    public long f43911i = 0;

    /* renamed from: l, reason: collision with root package name */
    private boolean f43914l = false;

    /* renamed from: j, reason: collision with root package name */
    public long f43912j = 0;

    /* renamed from: m, reason: collision with root package name */
    private long f43915m = 0;

    /* renamed from: k, reason: collision with root package name */
    public long f43913k = 0;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final com.tencent.liteav.videobase.utils.f f43907e = new com.tencent.liteav.videobase.utils.f("videoDecoder", new f.a(this) { // from class: com.tencent.liteav.videoconsumer.decoder.bj

        /* renamed from: a, reason: collision with root package name */
        private final bi f43925a;

        {
            this.f43925a = this;
        }

        @Override // com.tencent.liteav.videobase.utils.f.a
        public final void a(double d10) {
            this.f43925a.f43904b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_DECODER_FRAMERATE, Double.valueOf(d10));
        }
    });

    public bi(@NonNull IVideoReporter iVideoReporter) {
        byte b4 = 0;
        this.f43904b = iVideoReporter;
        this.f43905c = new a(this, b4);
        this.f43906d = new b(b4);
        this.f43903a += "_" + hashCode();
        a();
    }

    public final void a() {
        this.f43905c.a();
        this.f43906d.a();
        this.f43907e.b();
        this.f43908f = null;
        this.f43909g = false;
        this.f43914l = false;
        this.f43911i = 0L;
    }

    public final void b() {
        if (this.f43915m == 0) {
            this.f43915m = SystemClock.elapsedRealtime();
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f43915m + TimeUnit.SECONDS.toMillis(1L) < elapsedRealtime) {
            this.f43915m = elapsedRealtime;
            this.f43904b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_DECODER_ERROR, Long.valueOf(this.f43912j));
            this.f43912j = 0L;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public long f43923a;

        /* renamed from: b, reason: collision with root package name */
        public long f43924b;

        private b() {
            this.f43923a = 0L;
            this.f43924b = 0L;
        }

        public final void a() {
            this.f43924b = 0L;
            this.f43923a = 0L;
        }

        public /* synthetic */ b(byte b4) {
            this();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public long f43916a;

        /* renamed from: b, reason: collision with root package name */
        public long f43917b;

        /* renamed from: c, reason: collision with root package name */
        public long f43918c;

        /* renamed from: d, reason: collision with root package name */
        public long f43919d;

        /* renamed from: e, reason: collision with root package name */
        public final Deque<Long> f43920e;

        /* renamed from: f, reason: collision with root package name */
        public final List<Long> f43921f;

        private a() {
            this.f43916a = 0L;
            this.f43917b = 0L;
            this.f43918c = 0L;
            this.f43919d = 0L;
            this.f43920e = new LinkedList();
            this.f43921f = new ArrayList();
        }

        public final void a() {
            this.f43916a = 0L;
            this.f43917b = 0L;
            this.f43918c = 0L;
            this.f43919d = 0L;
            this.f43920e.clear();
            this.f43921f.clear();
        }

        public final void a(long j10) {
            if (this.f43920e.isEmpty()) {
                this.f43919d = SystemClock.elapsedRealtime();
            }
            this.f43920e.addLast(Long.valueOf(j10));
        }

        public /* synthetic */ a(bi biVar, byte b4) {
            this();
        }
    }

    public final void a(EncodedVideoFrame encodedVideoFrame) {
        if (!this.f43914l && encodedVideoFrame.isIDRFrame()) {
            this.f43910h = SystemClock.elapsedRealtime();
            this.f43914l = true;
            this.f43904b.notifyEvent(h.b.EVT_VIDEO_DECODE_START_DECODE_FIRST_FRAME, (Object) null, "Start decode first frame");
            LiteavLog.i(this.f43903a, "received first I frame.");
        }
        if (!this.f43909g) {
            this.f43911i++;
        }
        this.f43905c.a(encodedVideoFrame.pts);
    }

    public final void a(bk.a aVar, CodecType codecType) {
        this.f43908f = aVar;
        if (codecType == CodecType.H265 && aVar == bk.a.SOFTWARE) {
            aVar = bk.a.CUSTOM;
        }
        this.f43904b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_DECODER_TYPE, new VideoDecoderDef.DecoderProperty(aVar, codecType));
    }
}
