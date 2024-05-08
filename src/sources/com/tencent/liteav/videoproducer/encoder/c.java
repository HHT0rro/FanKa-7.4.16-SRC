package com.tencent.liteav.videoproducer.encoder;

import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.SystemUtil;
import com.tencent.liteav.base.util.w;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import com.tencent.liteav.videoproducer.encoder.c;
import com.tencent.liteav.videoproducer.encoder.y;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c implements w.a, y.a {

    /* renamed from: x, reason: collision with root package name */
    private static final b f44634x = new b(d.CONTINUE_ENCODE, e.NONE);
    private com.tencent.liteav.base.util.w C;
    private boolean D;
    private boolean E;

    /* renamed from: a, reason: collision with root package name */
    public final String f44635a;

    /* renamed from: q, reason: collision with root package name */
    public VideoEncodeParams f44651q;

    /* renamed from: r, reason: collision with root package name */
    public VideoEncodeParams f44652r;

    /* renamed from: s, reason: collision with root package name */
    @NonNull
    public final IVideoReporter f44653s;

    /* renamed from: t, reason: collision with root package name */
    public final VideoProducerDef.StreamType f44654t;

    /* renamed from: w, reason: collision with root package name */
    public final y f44657w;

    /* renamed from: y, reason: collision with root package name */
    private long f44658y = 0;

    /* renamed from: b, reason: collision with root package name */
    public long f44636b = 0;

    /* renamed from: z, reason: collision with root package name */
    private long f44659z = 0;
    private long A = 0;
    private long B = -1;

    /* renamed from: c, reason: collision with root package name */
    public long f44637c = 0;

    /* renamed from: d, reason: collision with root package name */
    public float f44638d = 0.0f;

    /* renamed from: e, reason: collision with root package name */
    public float f44639e = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    public float f44640f = 0.0f;

    /* renamed from: g, reason: collision with root package name */
    public double f44641g = ShadowDrawableWrapper.COS_45;

    /* renamed from: h, reason: collision with root package name */
    public boolean f44642h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f44643i = false;

    /* renamed from: j, reason: collision with root package name */
    public VideoEncoderDef.EncodeStrategy f44644j = VideoEncoderDef.EncodeStrategy.PREFER_HARDWARE;

    /* renamed from: k, reason: collision with root package name */
    public boolean f44645k = false;

    /* renamed from: l, reason: collision with root package name */
    public boolean f44646l = false;

    /* renamed from: m, reason: collision with root package name */
    public VideoEncoderDef.a f44647m = null;

    /* renamed from: n, reason: collision with root package name */
    public e f44648n = e.NONE;

    /* renamed from: o, reason: collision with root package name */
    public int f44649o = 0;

    /* renamed from: p, reason: collision with root package name */
    public int f44650p = 0;

    /* renamed from: u, reason: collision with root package name */
    public boolean f44655u = false;

    /* renamed from: v, reason: collision with root package name */
    public int f44656v = 0;
    private int F = 15;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        b a();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final d f44660a;

        /* renamed from: b, reason: collision with root package name */
        public final e f44661b;

        public b(d dVar, e eVar) {
            this.f44660a = dVar;
            this.f44661b = eVar;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum d {
        CONTINUE_ENCODE(0),
        RESTART_ENCODER(1),
        USE_HARDWARE(2),
        USE_SOFTWARE(3),
        REPORT_ENCODE_FAILED(4);

        private final int mPriority;

        d(int i10) {
            this.mPriority = i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum e {
        NONE(0),
        STRATEGY(1),
        LOW_RESOLUTION_LIMIT(1),
        INPUT_OUTPUT_DIFFERENCE(2),
        NO_OUTPUT(3),
        CPU_USAGE(4),
        SVC_SCENE(5),
        RPS_SCENE(6),
        ENCODER_ERROR(7),
        OTHERS_DO_NOT_SUPPORT_H265(8);

        public final int mPriority;

        e(int i10) {
            this.mPriority = i10;
        }
    }

    public c(boolean z10, boolean z11, @NonNull IVideoReporter iVideoReporter, VideoProducerDef.StreamType streamType) {
        this.f44653s = iVideoReporter;
        this.D = z10;
        this.E = z11;
        this.f44654t = streamType;
        this.f44657w = new y(this, streamType);
        this.f44635a = "EncoderSupervisor_" + ((Object) streamType) + "_" + hashCode();
    }

    private void c() {
        if (this.f44655u) {
            this.f44655u = false;
            this.f44656v = 0;
            VideoEncodeParams videoEncodeParams = this.f44652r;
            if (videoEncodeParams == null) {
                videoEncodeParams = this.f44651q;
            }
            if (videoEncodeParams != null) {
                videoEncodeParams.fps = this.F;
            }
        }
    }

    private void d() {
        EncodeAbilityProvider.getInstance().setHwHevcEncodeSupported(false);
        this.f44653s.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_ENCODER_ABILITY, this.f44654t.mValue, EncodeAbilityProvider.getInstance().getEncodeAbility());
    }

    private boolean e() {
        VideoEncoderDef.EncodeStrategy encodeStrategy = this.f44644j;
        return encodeStrategy == VideoEncoderDef.EncodeStrategy.PREFER_HARDWARE || encodeStrategy == VideoEncoderDef.EncodeStrategy.PREFER_SOFTWARE || encodeStrategy == VideoEncoderDef.EncodeStrategy.USE_HARDWARE_ONLY;
    }

    private boolean f() {
        VideoEncoderDef.EncodeStrategy encodeStrategy = this.f44644j;
        return encodeStrategy == VideoEncoderDef.EncodeStrategy.PREFER_HARDWARE || encodeStrategy == VideoEncoderDef.EncodeStrategy.PREFER_SOFTWARE || encodeStrategy == VideoEncoderDef.EncodeStrategy.USE_SOFTWARE_ONLY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b g() {
        if (!this.f44642h) {
            return null;
        }
        this.f44642h = false;
        if (this.f44647m == VideoEncoderDef.a.HARDWARE) {
            this.f44649o++;
            VideoEncodeParams videoEncodeParams = this.f44651q;
            if (videoEncodeParams == null) {
                return f44634x;
            }
            if (videoEncodeParams.codecType == CodecType.H265) {
                this.D = false;
                this.f44649o = 0;
                CodecType codecType = CodecType.H264;
                videoEncodeParams.setCodecType(codecType);
                VideoEncodeParams videoEncodeParams2 = this.f44652r;
                if (videoEncodeParams2 != null) {
                    videoEncodeParams2.setCodecType(codecType);
                }
                d();
                b i10 = i();
                return i10 == null ? new b(d.RESTART_ENCODER, e.ENCODER_ERROR) : i10;
            }
            if (f() && this.f44650p < 5) {
                return new b(d.USE_SOFTWARE, e.ENCODER_ERROR);
            }
            return new b(d.REPORT_ENCODE_FAILED, e.NONE);
        }
        this.f44650p++;
        VideoEncodeParams videoEncodeParams3 = this.f44651q;
        if (videoEncodeParams3 == null) {
            return f44634x;
        }
        if (videoEncodeParams3.codecType == CodecType.H265) {
            this.E = false;
            if (e() && this.D && this.f44649o <= 0) {
                return new b(d.USE_HARDWARE, e.OTHERS_DO_NOT_SUPPORT_H265);
            }
            this.f44650p = 0;
            VideoEncodeParams videoEncodeParams4 = this.f44651q;
            CodecType codecType2 = CodecType.H264;
            videoEncodeParams4.setCodecType(codecType2);
            VideoEncodeParams videoEncodeParams5 = this.f44652r;
            if (videoEncodeParams5 != null) {
                videoEncodeParams5.setCodecType(codecType2);
            }
            b i11 = i();
            return i11 == null ? new b(d.RESTART_ENCODER, e.ENCODER_ERROR) : i11;
        }
        if (e() && this.f44649o <= 0) {
            return new b(d.USE_HARDWARE, e.ENCODER_ERROR);
        }
        if (this.f44650p >= 5) {
            return new b(d.REPORT_ENCODE_FAILED, e.NONE);
        }
        return new b(d.RESTART_ENCODER, e.ENCODER_ERROR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b h() {
        VideoEncodeParams videoEncodeParams;
        VideoEncodeParams videoEncodeParams2 = this.f44651q;
        boolean z10 = false;
        boolean z11 = videoEncodeParams2 == null || videoEncodeParams2.codecType == CodecType.H264;
        if ((z11 && this.f44652r == null) || ((videoEncodeParams = this.f44652r) != null && videoEncodeParams.codecType == CodecType.H264)) {
            z10 = true;
        }
        if (!z10) {
            return null;
        }
        if (this.f44648n == e.OTHERS_DO_NOT_SUPPORT_H265) {
            this.f44648n = e.NONE;
        }
        b i10 = i();
        return (i10 != null || z11) ? i10 : new b(d.RESTART_ENCODER, e.NONE);
    }

    private b i() {
        if (this.f44645k) {
            return j();
        }
        VideoEncoderDef.EncodeStrategy encodeStrategy = this.f44644j;
        if (encodeStrategy == VideoEncoderDef.EncodeStrategy.USE_SOFTWARE_ONLY && this.f44647m != VideoEncoderDef.a.SOFTWARE) {
            return new b(d.USE_SOFTWARE, e.STRATEGY);
        }
        if ((encodeStrategy == VideoEncoderDef.EncodeStrategy.PREFER_HARDWARE || encodeStrategy == VideoEncoderDef.EncodeStrategy.PREFER_SOFTWARE || encodeStrategy == VideoEncoderDef.EncodeStrategy.USE_HARDWARE_ONLY) && this.f44647m == null) {
            return j();
        }
        return null;
    }

    private b j() {
        VideoEncoderDef.EncodeStrategy encodeStrategy = this.f44644j;
        if (encodeStrategy != VideoEncoderDef.EncodeStrategy.PREFER_HARDWARE && encodeStrategy != VideoEncoderDef.EncodeStrategy.USE_HARDWARE_ONLY) {
            return new b(d.USE_SOFTWARE, e.STRATEGY);
        }
        return new b(d.USE_HARDWARE, e.STRATEGY);
    }

    private boolean k() {
        VideoEncodeParams videoEncodeParams;
        VideoEncodeParams videoEncodeParams2 = this.f44651q;
        return ((videoEncodeParams2 != null && videoEncodeParams2.codecType == CodecType.H265) && this.f44652r == null) || ((videoEncodeParams = this.f44652r) != null && videoEncodeParams.codecType == CodecType.H265);
    }

    public static /* synthetic */ b l(c cVar) {
        if (cVar.f44652r == null) {
            return f44634x;
        }
        if (cVar.k()) {
            return f44634x;
        }
        b bVar = f44634x;
        boolean isEnablesSvc = cVar.f44652r.isEnablesSvc();
        VideoEncodeParams videoEncodeParams = cVar.f44651q;
        if (isEnablesSvc == (videoEncodeParams != null && videoEncodeParams.isEnablesSvc())) {
            return bVar;
        }
        VideoEncoderDef.EncodeStrategy encodeStrategy = cVar.f44644j;
        if (encodeStrategy == VideoEncoderDef.EncodeStrategy.USE_HARDWARE_ONLY) {
            if (!isEnablesSvc) {
                return bVar;
            }
            LiteavLog.e(cVar.f44635a, "Can't use svc mode in use hardware only strategy!");
            b bVar2 = new b(d.CONTINUE_ENCODE, e.SVC_SCENE);
            cVar.f44652r.setReferenceStrategy(VideoEncoderDef.ReferenceStrategy.FIX_GOP);
            return bVar2;
        }
        if (isEnablesSvc && cVar.f44647m != VideoEncoderDef.a.SOFTWARE) {
            return new b(d.USE_SOFTWARE, e.SVC_SCENE);
        }
        if (!isEnablesSvc && encodeStrategy == VideoEncoderDef.EncodeStrategy.PREFER_HARDWARE) {
            return new b(d.USE_HARDWARE, e.SVC_SCENE);
        }
        return new b(d.RESTART_ENCODER, e.SVC_SCENE);
    }

    public final d a(final PixelFrame pixelFrame) {
        if (pixelFrame != null) {
            this.f44658y++;
        }
        List arrayList = new ArrayList(Arrays.asList(new a(this) { // from class: com.tencent.liteav.videoproducer.encoder.d

            /* renamed from: a, reason: collision with root package name */
            private final c f44680a;

            {
                this.f44680a = this;
            }

            @Override // com.tencent.liteav.videoproducer.encoder.c.a
            public final c.b a() {
                return c.a(this.f44680a);
            }
        }, new a(this) { // from class: com.tencent.liteav.videoproducer.encoder.j

            /* renamed from: a, reason: collision with root package name */
            private final c f44687a;

            {
                this.f44687a = this;
            }

            @Override // com.tencent.liteav.videoproducer.encoder.c.a
            public final c.b a() {
                return c.b(this.f44687a);
            }
        }, new a(this) { // from class: com.tencent.liteav.videoproducer.encoder.k

            /* renamed from: a, reason: collision with root package name */
            private final c f44688a;

            {
                this.f44688a = this;
            }

            @Override // com.tencent.liteav.videoproducer.encoder.c.a
            public final c.b a() {
                return c.c(this.f44688a);
            }
        }, new a(this) { // from class: com.tencent.liteav.videoproducer.encoder.l

            /* renamed from: a, reason: collision with root package name */
            private final c f44689a;

            {
                this.f44689a = this;
            }

            @Override // com.tencent.liteav.videoproducer.encoder.c.a
            public final c.b a() {
                return c.d(this.f44689a);
            }
        }, new a(this) { // from class: com.tencent.liteav.videoproducer.encoder.m

            /* renamed from: a, reason: collision with root package name */
            private final c f44690a;

            {
                this.f44690a = this;
            }

            @Override // com.tencent.liteav.videoproducer.encoder.c.a
            public final c.b a() {
                c.b h10;
                h10 = this.f44690a.h();
                return h10;
            }
        }, new a(this) { // from class: com.tencent.liteav.videoproducer.encoder.n

            /* renamed from: a, reason: collision with root package name */
            private final c f44691a;

            {
                this.f44691a = this;
            }

            @Override // com.tencent.liteav.videoproducer.encoder.c.a
            public final c.b a() {
                return c.f(this.f44691a);
            }
        }, new a(this) { // from class: com.tencent.liteav.videoproducer.encoder.o

            /* renamed from: a, reason: collision with root package name */
            private final c f44692a;

            {
                this.f44692a = this;
            }

            @Override // com.tencent.liteav.videoproducer.encoder.c.a
            public final c.b a() {
                c.b g3;
                g3 = this.f44692a.g();
                return g3;
            }
        }, new a(this) { // from class: com.tencent.liteav.videoproducer.encoder.p

            /* renamed from: a, reason: collision with root package name */
            private final c f44693a;

            {
                this.f44693a = this;
            }

            @Override // com.tencent.liteav.videoproducer.encoder.c.a
            public final c.b a() {
                return c.h(this.f44693a);
            }
        }, new a(this) { // from class: com.tencent.liteav.videoproducer.encoder.q

            /* renamed from: a, reason: collision with root package name */
            private final c f44694a;

            {
                this.f44694a = this;
            }

            @Override // com.tencent.liteav.videoproducer.encoder.c.a
            public final c.b a() {
                return c.i(this.f44694a);
            }
        }, new a(this) { // from class: com.tencent.liteav.videoproducer.encoder.e

            /* renamed from: a, reason: collision with root package name */
            private final c f44681a;

            {
                this.f44681a = this;
            }

            @Override // com.tencent.liteav.videoproducer.encoder.c.a
            public final c.b a() {
                return c.j(this.f44681a);
            }
        }, new a(this, pixelFrame) { // from class: com.tencent.liteav.videoproducer.encoder.f

            /* renamed from: a, reason: collision with root package name */
            private final c f44682a;

            /* renamed from: b, reason: collision with root package name */
            private final PixelFrame f44683b;

            {
                this.f44682a = this;
                this.f44683b = pixelFrame;
            }

            @Override // com.tencent.liteav.videoproducer.encoder.c.a
            public final c.b a() {
                return c.a(this.f44682a, this.f44683b);
            }
        }));
        if (this.f44644j != VideoEncoderDef.EncodeStrategy.USE_HARDWARE_ONLY) {
            arrayList.addAll(Arrays.asList(new a(this) { // from class: com.tencent.liteav.videoproducer.encoder.g

                /* renamed from: a, reason: collision with root package name */
                private final c f44684a;

                {
                    this.f44684a = this;
                }

                @Override // com.tencent.liteav.videoproducer.encoder.c.a
                public final c.b a() {
                    return c.k(this.f44684a);
                }
            }, new a(this) { // from class: com.tencent.liteav.videoproducer.encoder.h

                /* renamed from: a, reason: collision with root package name */
                private final c f44685a;

                {
                    this.f44685a = this;
                }

                @Override // com.tencent.liteav.videoproducer.encoder.c.a
                public final c.b a() {
                    return c.l(this.f44685a);
                }
            }));
        }
        VideoEncodeParams videoEncodeParams = this.f44651q;
        if (videoEncodeParams != null && videoEncodeParams.isTranscodingMode()) {
            arrayList = Arrays.asList(new a(this) { // from class: com.tencent.liteav.videoproducer.encoder.i

                /* renamed from: a, reason: collision with root package name */
                private final c f44686a;

                {
                    this.f44686a = this;
                }

                @Override // com.tencent.liteav.videoproducer.encoder.c.a
                public final c.b a() {
                    c.b g3;
                    g3 = this.f44686a.g();
                    return g3;
                }
            });
        }
        Iterator iterator2 = arrayList.iterator2();
        b bVar = null;
        while (iterator2.hasNext()) {
            b a10 = ((a) iterator2.next()).a();
            if (a10 != null) {
                if (bVar != null) {
                    if (a10.f44660a.mPriority > bVar.f44660a.mPriority || (a10.f44660a == bVar.f44660a && a10.f44661b.mPriority > bVar.f44661b.mPriority)) {
                    }
                }
                bVar = a10;
            }
        }
        VideoEncodeParams videoEncodeParams2 = this.f44652r;
        if (videoEncodeParams2 != null && !com.tencent.liteav.base.util.i.a(videoEncodeParams2, this.f44651q)) {
            LiteavLog.i(this.f44635a, "apply pending encoded params: " + ((Object) this.f44652r));
            this.f44651q = this.f44652r;
        }
        this.f44652r = null;
        if (bVar == null) {
            if (this.f44647m == null) {
                bVar = new b(d.USE_HARDWARE, e.NONE);
            } else {
                bVar = new b(d.CONTINUE_ENCODE, e.NONE);
            }
        }
        this.f44645k = false;
        d dVar = bVar.f44660a;
        if (dVar == d.USE_HARDWARE) {
            VideoEncoderDef.a aVar = this.f44647m;
            VideoEncoderDef.a aVar2 = VideoEncoderDef.a.HARDWARE;
            if (aVar != aVar2) {
                int i10 = this.f44648n.mPriority;
                e eVar = bVar.f44661b;
                if (i10 <= eVar.mPriority) {
                    this.f44647m = aVar2;
                    this.f44648n = eVar;
                    if (eVar == e.CPU_USAGE) {
                        this.f44653s.notifyEvent(h.b.EVT_VIDEO_ENCODE_SW_TO_HW_CPU_USAGE, (Object) null, (String) null);
                    }
                    c();
                }
            }
            return d.CONTINUE_ENCODE;
        }
        if (dVar == d.USE_SOFTWARE) {
            VideoEncoderDef.a aVar3 = this.f44647m;
            VideoEncoderDef.a aVar4 = VideoEncoderDef.a.SOFTWARE;
            if (aVar3 != aVar4) {
                int i11 = this.f44648n.mPriority;
                e eVar2 = bVar.f44661b;
                if (i11 <= eVar2.mPriority) {
                    this.f44647m = aVar4;
                    this.f44648n = eVar2;
                    if (eVar2 == e.ENCODER_ERROR) {
                        this.f44653s.notifyEvent(h.b.EVT_VIDEO_ENCODE_HW_TO_SW_MEDIACODEC_NOT_WORK, (Object) null, (String) null);
                    }
                    com.tencent.liteav.base.util.w wVar = new com.tencent.liteav.base.util.w(Looper.myLooper(), this);
                    this.C = wVar;
                    wVar.a(1000, 1000);
                }
            }
            return d.CONTINUE_ENCODE;
        }
        if (bVar.f44660a != d.CONTINUE_ENCODE) {
            LiteavLog.i(this.f44635a, "instruction: " + ((Object) bVar.f44660a) + ", reason: " + ((Object) bVar.f44661b));
        }
        if (bVar.f44660a == d.RESTART_ENCODER) {
            b();
        }
        return bVar.f44660a;
    }

    public final void b() {
        this.f44636b = 0L;
        this.f44658y = 0L;
        this.A = 0L;
        this.f44659z = 0L;
    }

    @Override // com.tencent.liteav.base.util.w.a
    public final void onTimeout() {
        int i10;
        long a10 = com.tencent.liteav.base.a.a.a().a("Video", "SWToHWThreshold_CheckCount");
        if (this.f44637c < a10) {
            int[] processCPURate = SystemUtil.getProcessCPURate();
            this.f44637c++;
            this.f44638d += processCPURate[0] / 10;
            this.f44639e += processCPURate[1] / 10;
            VideoEncodeParams videoEncodeParams = this.f44651q;
            if (videoEncodeParams == null || (i10 = videoEncodeParams.fps) == 0) {
                return;
            }
            this.f44640f = (float) (this.f44640f + ((this.f44641g * 100.0d) / i10));
            return;
        }
        float f10 = (float) a10;
        float f11 = this.f44638d / f10;
        float f12 = this.f44640f / f10;
        float f13 = this.f44639e / f10;
        if (f11 >= ((float) com.tencent.liteav.base.a.a.a().a("Video", "SWToHWThreshold_CPU_MAX")) || f12 <= ((float) com.tencent.liteav.base.a.a.a().a("Video", "SWToHWThreshold_FPS_MIN")) || (f13 >= ((float) com.tencent.liteav.base.a.a.a().a("Video", "SWToHWThreshold_CPU")) && f12 <= ((float) com.tencent.liteav.base.a.a.a().a("Video", "SWToHWThreshold_FPS")))) {
            this.f44643i = true;
        }
        com.tencent.liteav.base.util.w wVar = this.C;
        if (wVar != null) {
            wVar.a();
            this.C = null;
        }
        this.f44637c = 0L;
        this.f44638d = 0.0f;
        this.f44639e = 0.0f;
        this.f44640f = 0.0f;
        this.f44641g = ShadowDrawableWrapper.COS_45;
    }

    /* renamed from: com.tencent.liteav.videoproducer.encoder.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0646c {

        /* renamed from: a, reason: collision with root package name */
        public VideoEncoderDef.EncoderProfile f44662a;

        private C0646c() {
            this.f44662a = VideoEncoderDef.EncoderProfile.PROFILE_BASELINE;
        }

        public /* synthetic */ C0646c(byte b4) {
            this();
        }
    }

    public static /* synthetic */ b f(c cVar) {
        if (cVar.f44647m != VideoEncoderDef.a.SOFTWARE && cVar.f44658y - cVar.f44636b > 30) {
            LiteavLog.i(cVar.f44635a, "checkFrameInOutDifference in frame:" + cVar.f44658y + " out frame " + cVar.f44636b);
            cVar.f44653s.notifyEvent(h.b.EVT_VIDEO_HARDWARE_ENCODER_STUCK, cVar.f44654t.mValue, "");
            int i10 = cVar.f44649o + 1;
            cVar.f44649o = i10;
            return new b(i10 >= 3 ? d.USE_SOFTWARE : d.RESTART_ENCODER, e.INPUT_OUTPUT_DIFFERENCE);
        }
        return f44634x;
    }

    public static /* synthetic */ b k(c cVar) {
        if (cVar.f44652r == null) {
            return f44634x;
        }
        if (cVar.k()) {
            return f44634x;
        }
        b bVar = f44634x;
        boolean isEnablesRps = cVar.f44652r.isEnablesRps();
        VideoEncodeParams videoEncodeParams = cVar.f44651q;
        if (isEnablesRps == (videoEncodeParams != null && videoEncodeParams.isEnablesRps())) {
            return bVar;
        }
        if (!isEnablesRps) {
            cVar.c();
        }
        VideoEncoderDef.EncodeStrategy encodeStrategy = cVar.f44644j;
        if (encodeStrategy != VideoEncoderDef.EncodeStrategy.USE_HARDWARE_ONLY) {
            if (isEnablesRps && cVar.f44647m != VideoEncoderDef.a.SOFTWARE) {
                return new b(d.USE_SOFTWARE, e.RPS_SCENE);
            }
            if (!isEnablesRps && encodeStrategy == VideoEncoderDef.EncodeStrategy.PREFER_HARDWARE) {
                return new b(d.USE_HARDWARE, e.RPS_SCENE);
            }
            return new b(d.RESTART_ENCODER, e.RPS_SCENE);
        }
        if (!isEnablesRps) {
            return bVar;
        }
        LiteavLog.e(cVar.f44635a, "checkRpsStatus, enable rps failed while current encode strategy is " + ((Object) cVar.f44644j));
        b bVar2 = new b(d.REPORT_ENCODE_FAILED, e.RPS_SCENE);
        cVar.f44652r.setReferenceStrategy(VideoEncoderDef.ReferenceStrategy.FIX_GOP);
        return bVar2;
    }

    public static /* synthetic */ b b(c cVar) {
        VideoEncodeParams videoEncodeParams = cVar.f44652r;
        if (videoEncodeParams == null) {
            return f44634x;
        }
        b bVar = f44634x;
        if (cVar.f44651q == null) {
            return bVar;
        }
        VideoEncodeParams videoEncodeParams2 = new VideoEncodeParams(videoEncodeParams);
        videoEncodeParams2.setBaseFrameIndex(cVar.f44651q.baseFrameIndex);
        videoEncodeParams2.setBaseGopIndex(cVar.f44651q.baseGopIndex);
        if (videoEncodeParams2.getReferenceStrategy() == VideoEncoderDef.ReferenceStrategy.RPS) {
            videoEncodeParams2.setEncoderProfile(cVar.f44651q.encoderProfile);
        }
        videoEncodeParams2.setReferenceStrategy(cVar.f44651q.getReferenceStrategy());
        videoEncodeParams2.setFps(cVar.f44651q.fps);
        videoEncodeParams2.setCodecType(cVar.f44651q.codecType);
        videoEncodeParams2.setBitrate(cVar.f44651q.bitrate);
        return !cVar.f44651q.equals(videoEncodeParams2) ? new b(d.RESTART_ENCODER, e.NONE) : bVar;
    }

    public static /* synthetic */ b j(c cVar) {
        VideoEncoderDef.a aVar;
        if (cVar.f() && ((aVar = cVar.f44647m) == VideoEncoderDef.a.HARDWARE || aVar == null)) {
            VideoEncodeParams videoEncodeParams = cVar.f44651q;
            boolean z10 = false;
            int i10 = videoEncodeParams != null ? videoEncodeParams.width * videoEncodeParams.height : 0;
            boolean z11 = i10 != 0 && i10 <= 10000;
            VideoEncodeParams videoEncodeParams2 = cVar.f44652r;
            int i11 = videoEncodeParams2 != null ? videoEncodeParams2.width * videoEncodeParams2.height : 0;
            if (i11 != 0 && i11 <= 10000) {
                z10 = true;
            }
            if (z10 || (videoEncodeParams2 == null && z11)) {
                return new b(d.USE_SOFTWARE, e.LOW_RESOLUTION_LIMIT);
            }
        }
        return f44634x;
    }

    public static /* synthetic */ b c(c cVar) {
        if (!cVar.k()) {
            return null;
        }
        VideoEncodeParams videoEncodeParams = cVar.f44651q;
        boolean z10 = videoEncodeParams != null && videoEncodeParams.codecType == CodecType.H265;
        boolean z11 = cVar.D;
        if (z11 && cVar.E) {
            b i10 = cVar.i();
            return (i10 != null || z10) ? i10 : new b(d.RESTART_ENCODER, e.NONE);
        }
        boolean z12 = cVar.E;
        if (z12 || !z11) {
            if (!z11 && z12) {
                if (cVar.f44647m == VideoEncoderDef.a.SOFTWARE) {
                    if (z10) {
                        return new b(d.CONTINUE_ENCODE, e.NONE);
                    }
                    return new b(d.RESTART_ENCODER, e.NONE);
                }
                if (cVar.f()) {
                    return new b(d.USE_SOFTWARE, e.OTHERS_DO_NOT_SUPPORT_H265);
                }
            }
        } else {
            if (cVar.f44647m == VideoEncoderDef.a.HARDWARE) {
                if (z10) {
                    return new b(d.CONTINUE_ENCODE, e.NONE);
                }
                return new b(d.RESTART_ENCODER, e.NONE);
            }
            if (cVar.e()) {
                return new b(d.USE_HARDWARE, e.OTHERS_DO_NOT_SUPPORT_H265);
            }
        }
        LiteavLog.e(cVar.f44635a, "checkEncodeH265, enable h265 failed because encode strategy conflict, mIsHWSupportH265:" + cVar.D + ", mIsSwSupportH265:" + cVar.E + ", mUsingEncodeType:" + ((Object) cVar.f44647m) + ", mUsingEncodeStrategy:" + ((Object) cVar.f44644j));
        if (cVar.f44647m == VideoEncoderDef.a.HARDWARE) {
            cVar.d();
        }
        cVar.f44652r.setCodecType(CodecType.H264);
        return cVar.h();
    }

    public static /* synthetic */ b d(c cVar) {
        VideoEncodeParams videoEncodeParams = cVar.f44652r;
        if (videoEncodeParams == null) {
            return f44634x;
        }
        b bVar = f44634x;
        VideoEncodeParams videoEncodeParams2 = cVar.f44651q;
        return (videoEncodeParams2 == null || videoEncodeParams2.fps == videoEncodeParams.fps || cVar.f44647m != VideoEncoderDef.a.HARDWARE) ? bVar : new b(d.RESTART_ENCODER, e.NONE);
    }

    public static /* synthetic */ b h(c cVar) {
        if (cVar.f44647m != VideoEncoderDef.a.SOFTWARE && cVar.f44659z + 5000 < SystemClock.elapsedRealtime()) {
            cVar.f44659z = SystemClock.elapsedRealtime();
            long j10 = cVar.A;
            if (j10 != 0 && j10 == cVar.f44636b) {
                cVar.f44653s.notifyEvent(h.b.EVT_VIDEO_HARDWARE_ENCODER_STUCK, cVar.f44654t.mValue, "");
                int i10 = cVar.f44649o + 1;
                cVar.f44649o = i10;
                return new b(i10 >= 3 ? d.USE_SOFTWARE : d.RESTART_ENCODER, e.NO_OUTPUT);
            }
            cVar.A = cVar.f44636b;
        }
        return f44634x;
    }

    public static /* synthetic */ b i(c cVar) {
        if (cVar.f44643i) {
            cVar.f44643i = false;
            if (cVar.f44647m == VideoEncoderDef.a.SOFTWARE && cVar.f44649o <= 0) {
                return new b(d.USE_HARDWARE, e.CPU_USAGE);
            }
        }
        return f44634x;
    }

    public final VideoEncodeParams a() {
        VideoEncodeParams videoEncodeParams = this.f44652r;
        if (videoEncodeParams == null) {
            videoEncodeParams = this.f44651q;
        }
        return new VideoEncodeParams(videoEncodeParams);
    }

    @Override // com.tencent.liteav.videoproducer.encoder.y.a
    public final void a(double d10) {
        this.f44641g = d10;
        this.f44653s.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_ENCODE_REAL_FRAME_RATE, Double.valueOf(d10));
    }

    @Override // com.tencent.liteav.videoproducer.encoder.y.a
    public final void a(long j10) {
        this.f44653s.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_ENCODE_REAL_ENCODE_BITRATE, Long.valueOf(j10));
    }

    public final void a(VideoEncodeParams videoEncodeParams) {
        VideoProducerDef.StreamType streamType;
        VideoEncodeParams videoEncodeParams2 = new VideoEncodeParams(videoEncodeParams);
        C0646c c0646c = new C0646c((byte) 0);
        if (this.f44644j != VideoEncoderDef.EncodeStrategy.USE_HARDWARE_ONLY && videoEncodeParams2.referenceStrategy == VideoEncoderDef.ReferenceStrategy.RPS) {
            VideoProducerDef.StreamType streamType2 = this.f44654t;
            if (streamType2 == VideoProducerDef.StreamType.STREAM_TYPE_BIG_VIDEO || streamType2 == VideoProducerDef.StreamType.STREAM_TYPE_SUB_VIDEO) {
                c0646c.f44662a = VideoEncoderDef.EncoderProfile.PROFILE_HIGHRPS;
            }
        } else if (!videoEncodeParams2.enableBFrame && ((streamType = this.f44654t) == VideoProducerDef.StreamType.STREAM_TYPE_BIG_VIDEO || streamType == VideoProducerDef.StreamType.STREAM_TYPE_SUB_VIDEO)) {
            c0646c.f44662a = VideoEncoderDef.EncoderProfile.PROFILE_HIGH;
        }
        if (videoEncodeParams2.encoderProfile == null) {
            videoEncodeParams2.encoderProfile = c0646c.f44662a;
        }
        if (this.f44655u) {
            videoEncodeParams2.fps = this.f44656v;
        }
        this.F = videoEncodeParams.fps;
        this.f44652r = videoEncodeParams2;
    }

    public static /* synthetic */ b a(c cVar, PixelFrame pixelFrame) {
        if (pixelFrame != null) {
            if (cVar.B == -1) {
                cVar.B = pixelFrame.getTimestamp();
            }
            long j10 = cVar.B;
            cVar.B = pixelFrame.getTimestamp();
            if (j10 > pixelFrame.getTimestamp()) {
                LiteavLog.i(cVar.f44635a, "frame timestamp is rollback, need restart encoder." + j10 + ">" + pixelFrame.getTimestamp());
                cVar.B = -1L;
                return new b(d.RESTART_ENCODER, e.NONE);
            }
        }
        return f44634x;
    }

    public static /* synthetic */ b a(c cVar) {
        if (cVar.f44646l) {
            LiteavLog.i(cVar.f44635a, "prioritize restart encoder on request.");
            cVar.f44646l = false;
            return new b(d.RESTART_ENCODER, e.NONE);
        }
        return f44634x;
    }
}
