package com.tencent.liteav.videoconsumer.decoder;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoconsumer.decoder.VideoDecodeController;
import com.tencent.liteav.videoconsumer.decoder.VideoDecoderDef;
import com.tencent.liteav.videoconsumer.decoder.bk;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e {

    /* renamed from: y, reason: collision with root package name */
    public static final AtomicInteger f43933y = new AtomicInteger(0);

    @NonNull
    private final d B;
    private boolean D;
    private boolean E;

    /* renamed from: a, reason: collision with root package name */
    public String f43934a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final IVideoReporter f43935b;

    /* renamed from: d, reason: collision with root package name */
    public bk.a f43937d;

    /* renamed from: f, reason: collision with root package name */
    public EnumC0644e f43939f;

    /* renamed from: g, reason: collision with root package name */
    public long f43940g;

    /* renamed from: h, reason: collision with root package name */
    public long f43941h;

    /* renamed from: k, reason: collision with root package name */
    public boolean f43944k;

    /* renamed from: l, reason: collision with root package name */
    public int f43945l;

    /* renamed from: m, reason: collision with root package name */
    public int f43946m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f43947n;

    /* renamed from: o, reason: collision with root package name */
    public int f43948o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f43949p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f43950q;

    /* renamed from: t, reason: collision with root package name */
    public long f43953t;

    /* renamed from: v, reason: collision with root package name */
    public float f43955v;

    @NonNull
    private final SpsInfo C = new SpsInfo();

    /* renamed from: c, reason: collision with root package name */
    public VideoDecodeController.DecodeStrategy f43936c = VideoDecodeController.DecodeStrategy.PREFER_HARDWARE;

    /* renamed from: e, reason: collision with root package name */
    public boolean f43938e = false;

    /* renamed from: i, reason: collision with root package name */
    public int f43942i = 8;

    /* renamed from: j, reason: collision with root package name */
    public int f43943j = 6;
    private int F = 0;

    /* renamed from: r, reason: collision with root package name */
    public boolean f43951r = false;
    private boolean G = false;

    /* renamed from: s, reason: collision with root package name */
    public VideoDecoderDef.ConsumerScene f43952s = VideoDecoderDef.ConsumerScene.UNKNOWN;
    private boolean H = false;

    /* renamed from: u, reason: collision with root package name */
    public final com.tencent.liteav.base.b.a f43954u = new com.tencent.liteav.base.b.a(1000);

    /* renamed from: w, reason: collision with root package name */
    public long f43956w = 0;

    /* renamed from: x, reason: collision with root package name */
    public int f43957x = 1;

    /* renamed from: z, reason: collision with root package name */
    public boolean f43958z = false;
    public boolean A = false;

    /* renamed from: com.tencent.liteav.videoconsumer.decoder.e$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f43959a;

        static {
            int[] iArr = new int[c.values().length];
            f43959a = iArr;
            try {
                iArr[c.SWITCH_TO_SOFTWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43959a[c.SWITCH_TO_HARDWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f43959a[c.RESTART_DECODER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f43959a[c.CONTINUE_DECODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        b a(EncodedVideoFrame encodedVideoFrame);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final c f43960a;

        /* renamed from: b, reason: collision with root package name */
        public final EnumC0644e f43961b;

        public b(c cVar, EnumC0644e enumC0644e) {
            this.f43960a = cVar;
            this.f43961b = enumC0644e;
            if (cVar != c.SWITCH_TO_HARDWARE && cVar != c.SWITCH_TO_SOFTWARE && enumC0644e != EnumC0644e.NONE) {
                throw new RuntimeException("SwitchReason must be NONE.)");
            }
        }

        public final String toString() {
            return "CheckResult{instruction=" + ((Object) this.f43960a) + ", reason=" + ((Object) this.f43961b) + '}';
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum c {
        CONTINUE_DECODE(0),
        DROP_FRAME(1),
        RESTART_DECODER(2),
        SWITCH_TO_HARDWARE(3),
        SWITCH_TO_SOFTWARE(3),
        REQUEST_KEY_FRAME(4),
        REPORT_DECODE_ERROR(5);

        private final int mPriority;

        c(int i10) {
            this.mPriority = i10;
        }

        public static /* synthetic */ int a(c cVar) {
            return cVar.mPriority;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface d {
        SpsInfo a(boolean z10, ByteBuffer byteBuffer);
    }

    /* renamed from: com.tencent.liteav.videoconsumer.decoder.e$e, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum EnumC0644e {
        NONE(0),
        RPS_MODE_UPDATED(1),
        SVC_MODE_UPDATED(2),
        HARDWARE_DECODER_ABNORMAL(3),
        LOW_RESOLUTION(4),
        DECODE_ERROR(5),
        OTHERS_DO_NOT_SUPPORT_H265(6),
        AV1_SUPPORT(7);

        public final int mPriority;

        EnumC0644e(int i10) {
            this.mPriority = i10;
        }
    }

    public e(@NonNull d dVar, @NonNull IVideoReporter iVideoReporter, boolean z10, boolean z11) {
        this.f43934a = "DecoderSupervisor";
        this.B = dVar;
        this.f43935b = iVideoReporter;
        this.D = z10;
        this.E = z11;
        String str = this.f43934a + "_" + hashCode();
        this.f43934a = str;
        LiteavLog.i(str, "mIsSW265Supported:" + z10 + ",mIsHW265Supported:" + z11);
        a();
    }

    private boolean b(EncodedVideoFrame encodedVideoFrame) {
        if ((encodedVideoFrame.isH265() && !this.E) || f43933y.get() >= 3) {
            return false;
        }
        VideoDecodeController.DecodeStrategy decodeStrategy = this.f43936c;
        return decodeStrategy == VideoDecodeController.DecodeStrategy.FORCE_HARDWARE || decodeStrategy == VideoDecodeController.DecodeStrategy.PREFER_HARDWARE || decodeStrategy == VideoDecodeController.DecodeStrategy.PREFER_SOFTWARE;
    }

    private void c() {
        this.f43935b.notifyError(h.a.ERR_VIDEO_NO_AVAILABLE_HEVC_DECODERS, "no available hevc decoders");
    }

    private boolean d() {
        return this.f43937d == bk.a.HARDWARE || this.A;
    }

    public static /* synthetic */ b e(e eVar, EncodedVideoFrame encodedVideoFrame) {
        boolean z10 = eVar.G;
        eVar.G = encodedVideoFrame.isSVCEnable();
        if (!eVar.d()) {
            return new b(c.CONTINUE_DECODE, EnumC0644e.NONE);
        }
        boolean b4 = eVar.b();
        if (z10 != encodedVideoFrame.isSVCEnable() && eVar.f43951r != b4) {
            LiteavLog.i(eVar.f43934a, "checkSVCStatus expect low latency:" + b4 + ", Using low latency:" + eVar.f43951r);
            return new b(c.RESTART_DECODER, EnumC0644e.NONE);
        }
        return new b(c.CONTINUE_DECODE, EnumC0644e.NONE);
    }

    public static /* synthetic */ b f(e eVar, EncodedVideoFrame encodedVideoFrame) {
        CodecType codecType;
        if (eVar.f43937d == bk.a.SOFTWARE || encodedVideoFrame == null || (codecType = encodedVideoFrame.codecType) == null || codecType != CodecType.KAV1) {
            return null;
        }
        return new b(c.SWITCH_TO_SOFTWARE, EnumC0644e.AV1_SUPPORT);
    }

    public static /* synthetic */ b g(e eVar, EncodedVideoFrame encodedVideoFrame) {
        if (eVar.f43937d == bk.a.SOFTWARE || encodedVideoFrame == null) {
            return null;
        }
        SpsInfo spsInfo = eVar.C;
        if (spsInfo.width * spsInfo.height > 40000 || !eVar.a(encodedVideoFrame)) {
            return null;
        }
        return new b(c.SWITCH_TO_SOFTWARE, EnumC0644e.LOW_RESOLUTION);
    }

    public static /* synthetic */ b h(e eVar, EncodedVideoFrame encodedVideoFrame) {
        if (!eVar.d() || !encodedVideoFrame.isHDRFrame() || !eVar.f43950q) {
            return null;
        }
        eVar.f43950q = false;
        return new b(c.RESTART_DECODER, EnumC0644e.NONE);
    }

    public static /* synthetic */ b i(e eVar, EncodedVideoFrame encodedVideoFrame) {
        SpsInfo spsInfo = eVar.C;
        Size size = new Size(spsInfo.width, spsInfo.height);
        if (eVar.f43937d == bk.a.HARDWARE && size.getArea() > 0) {
            if (eVar.f43955v > 1.2f) {
                LiteavLog.i(eVar.f43934a, "Received frame too fast, skip check hardware decoder");
            } else {
                boolean z10 = true;
                int i10 = size.getArea() >= 480000 ? eVar.f43942i : eVar.f43943j;
                int i11 = eVar.f43946m;
                boolean z11 = i11 >= i10;
                long j10 = eVar.f43941h;
                boolean z12 = j10 != 0 && encodedVideoFrame.pts - j10 >= ((long) (i10 * 66)) && i11 >= i10 + (-2);
                if (!z11 && !z12) {
                    z10 = false;
                }
                if (z10 && eVar.a(encodedVideoFrame)) {
                    String str = "Remote-VideoDecoder[" + ((Object) eVar) + "]: " + (z11 ? "Too many hard decoder buffers, switch to soft decoder" : "Hard decoding takes too long, switch to soft decoder") + "[videoSize: " + ((Object) size) + "][decCacheNum:" + eVar.f43946m + "][decPts:" + encodedVideoFrame.pts + "][renderPts:" + eVar.f43941h + "][cacheHigh:" + eVar.f43942i + "][cacheLow:" + eVar.f43943j + "]";
                    if (z11) {
                        eVar.f43935b.notifyWarning(h.c.WARNING_VIDEO_DECODE_CACHE_EXCEEDED, "cache to much deviceName:" + LiteavSystemInfo.getModel());
                    }
                    if (z12) {
                        eVar.f43935b.notifyEvent(h.b.EVT_VIDEO_DECODE_HW_TO_SW_DECODE_COST_TOO_HIGH, (Object) null, "decode cost too high, switch HW to SW, deviceName:" + LiteavSystemInfo.getModel());
                    }
                    LiteavLog.i(eVar.f43934a, str);
                    return new b(c.SWITCH_TO_SOFTWARE, EnumC0644e.HARDWARE_DECODER_ABNORMAL);
                }
            }
        }
        return null;
    }

    public final boolean a(EncodedVideoFrame encodedVideoFrame) {
        if (encodedVideoFrame.isHDRFrame()) {
            return false;
        }
        return !encodedVideoFrame.isH265() || this.D;
    }

    public static /* synthetic */ b c(e eVar, EncodedVideoFrame encodedVideoFrame) {
        if (eVar.f43947n) {
            eVar.f43947n = false;
            bk.a aVar = eVar.f43937d;
            if (aVar == bk.a.HARDWARE) {
                eVar.F++;
                if (encodedVideoFrame.isH265() && !encodedVideoFrame.isHDRFrame()) {
                    eVar.E = false;
                }
                int i10 = eVar.f43948o;
                if (i10 < eVar.f43957x) {
                    eVar.f43948o = i10 + 1;
                    LiteavLog.i(eVar.f43934a, "checkPendingDecodeError restart. index:" + eVar.f43948o + " max:" + eVar.f43957x);
                    return new b(c.RESTART_DECODER, EnumC0644e.NONE);
                }
                if (eVar.a(encodedVideoFrame)) {
                    eVar.f43935b.notifyEvent(h.b.EVT_VIDEO_DECODE_HW_TO_SW_MEDIACODEC_NOT_WORK, (Object) null, "MediaCodec doesn't work, switch HW to SW decode");
                    LiteavLog.i(eVar.f43934a, "checkPendingDecodeError switch HW to SW decode");
                    return new b(c.SWITCH_TO_SOFTWARE, EnumC0644e.DECODE_ERROR);
                }
                if (encodedVideoFrame.isH265()) {
                    eVar.c();
                }
                return new b(c.REPORT_DECODE_ERROR, EnumC0644e.NONE);
            }
            if (aVar == bk.a.SOFTWARE) {
                int i11 = eVar.f43948o + 1;
                eVar.f43948o = i11;
                if (i11 < 3) {
                    LiteavLog.i(eVar.f43934a, "checkPendingDecodeError failed decoder count is less max count.");
                    return new b(c.RESTART_DECODER, EnumC0644e.NONE);
                }
                if (encodedVideoFrame.isH265()) {
                    eVar.D = false;
                }
                if (eVar.b(encodedVideoFrame) && eVar.F <= 0 && !encodedVideoFrame.isRPSEnable()) {
                    LiteavLog.i(eVar.f43934a, "checkPendingDecodeError switch SW to HW decode");
                    return new b(c.SWITCH_TO_HARDWARE, EnumC0644e.DECODE_ERROR);
                }
                if (encodedVideoFrame.isH265()) {
                    eVar.c();
                }
                return new b(c.REPORT_DECODE_ERROR, EnumC0644e.NONE);
            }
        }
        return null;
    }

    public static /* synthetic */ b d(e eVar, EncodedVideoFrame encodedVideoFrame) {
        boolean isRPSEnable = encodedVideoFrame.isRPSEnable();
        if (!isRPSEnable && eVar.f43937d == bk.a.SOFTWARE && eVar.b(encodedVideoFrame)) {
            EnumC0644e enumC0644e = eVar.f43939f;
            if (enumC0644e != null && enumC0644e.mPriority > EnumC0644e.RPS_MODE_UPDATED.mPriority) {
                return new b(c.CONTINUE_DECODE, EnumC0644e.NONE);
            }
            eVar.f43935b.notifyEvent(h.b.EVT_VIDEO_DECODE_SW_TO_HW_REMOTE_VIDEO_DISABLE_RPS, (Object) null, "remote video disable RPS, switch SW to HW decode");
            if (VideoDecodeController.DecodeStrategy.PREFER_SOFTWARE == eVar.f43936c) {
                return new b(c.CONTINUE_DECODE, EnumC0644e.NONE);
            }
            return new b(c.SWITCH_TO_HARDWARE, EnumC0644e.RPS_MODE_UPDATED);
        }
        if (!isRPSEnable || eVar.f43937d == bk.a.SOFTWARE) {
            return null;
        }
        if (eVar.a(encodedVideoFrame)) {
            eVar.f43935b.notifyEvent(h.b.EVT_VIDEO_DECODE_HW_TO_SW_REMOTE_VIDEO_ENABLE_RPS, (Object) null, "remote video enable RPS, switch HW to SW decode");
            return new b(c.SWITCH_TO_SOFTWARE, EnumC0644e.RPS_MODE_UPDATED);
        }
        return new b(c.REPORT_DECODE_ERROR, EnumC0644e.NONE);
    }

    public final void a() {
        this.f43948o = 0;
        this.f43949p = false;
        this.f43944k = false;
        this.f43946m = 0;
        this.f43956w = 0L;
        this.f43947n = false;
        this.C.set(new SpsInfo());
        this.f43941h = 0L;
        this.f43940g = 0L;
        this.f43945l = 0;
        this.f43937d = null;
        this.f43939f = EnumC0644e.NONE;
        this.F = 0;
        this.f43955v = 0.0f;
        this.f43953t = 0L;
        this.f43954u.f42750a = SystemClock.elapsedRealtime();
        this.f43957x = 1;
        this.f43958z = false;
    }

    public final boolean b() {
        if (this.f43952s != VideoDecoderDef.ConsumerScene.RTC || this.G) {
            return false;
        }
        Integer num = this.C.maxNumRefFrames;
        return num == null || num.intValue() <= 1;
    }

    public static /* synthetic */ b b(e eVar, EncodedVideoFrame encodedVideoFrame) {
        b bVar;
        boolean isH265 = encodedVideoFrame.isH265();
        if (isH265 != eVar.f43938e) {
            EnumC0644e enumC0644e = EnumC0644e.NONE;
            eVar.f43939f = enumC0644e;
            eVar.F = 0;
            eVar.f43948o = 0;
            LiteavLog.i(eVar.f43934a, "checkH265Frame find h265 frame.");
            bVar = new b(c.RESTART_DECODER, enumC0644e);
        } else {
            bVar = null;
        }
        if (isH265 && !eVar.E && !eVar.D) {
            eVar.c();
            return new b(c.REPORT_DECODE_ERROR, EnumC0644e.NONE);
        }
        if (isH265 && !eVar.D && eVar.f43937d != bk.a.HARDWARE) {
            if (eVar.b(encodedVideoFrame)) {
                return new b(c.SWITCH_TO_HARDWARE, EnumC0644e.OTHERS_DO_NOT_SUPPORT_H265);
            }
            eVar.c();
            return new b(c.REPORT_DECODE_ERROR, EnumC0644e.NONE);
        }
        if (!isH265 || eVar.E || eVar.f43937d == bk.a.SOFTWARE) {
            return bVar;
        }
        if (eVar.a(encodedVideoFrame)) {
            return new b(c.SWITCH_TO_SOFTWARE, EnumC0644e.OTHERS_DO_NOT_SUPPORT_H265);
        }
        eVar.c();
        return new b(c.REPORT_DECODE_ERROR, EnumC0644e.NONE);
    }

    public final void a(VideoDecoderDef.ConsumerScene consumerScene) {
        VideoDecoderDef.ConsumerScene consumerScene2 = this.f43952s;
        if (consumerScene2 != VideoDecoderDef.ConsumerScene.UNKNOWN && consumerScene2 != consumerScene) {
            this.H = true;
        }
        this.f43952s = consumerScene;
    }

    public static /* synthetic */ b a(e eVar) {
        VideoDecodeController.DecodeStrategy decodeStrategy = eVar.f43936c;
        if (decodeStrategy == VideoDecodeController.DecodeStrategy.FORCE_SOFTWARE && eVar.f43937d != bk.a.SOFTWARE) {
            return new b(c.SWITCH_TO_SOFTWARE, EnumC0644e.NONE);
        }
        if ((decodeStrategy == VideoDecodeController.DecodeStrategy.PREFER_HARDWARE || decodeStrategy == VideoDecodeController.DecodeStrategy.FORCE_HARDWARE) && eVar.f43937d == null && f43933y.get() < 3) {
            return new b(c.SWITCH_TO_HARDWARE, EnumC0644e.NONE);
        }
        if (eVar.f43936c == VideoDecodeController.DecodeStrategy.PREFER_SOFTWARE && eVar.f43937d == null) {
            return new b(c.SWITCH_TO_SOFTWARE, EnumC0644e.NONE);
        }
        if (eVar.f43937d != null) {
            return null;
        }
        if (f43933y.get() >= 3) {
            LiteavLog.i(eVar.f43934a, "Use software decoder because of hardware stuck too much");
            return new b(c.SWITCH_TO_SOFTWARE, EnumC0644e.NONE);
        }
        return new b(c.SWITCH_TO_HARDWARE, EnumC0644e.NONE);
    }

    public static /* synthetic */ b b(e eVar) {
        if (eVar.f43949p) {
            eVar.f43949p = false;
            LiteavLog.i(eVar.f43934a, "EGLContext changed.");
            if (eVar.d()) {
                return new b(c.RESTART_DECODER, EnumC0644e.NONE);
            }
        }
        return null;
    }

    public static /* synthetic */ b c(e eVar) {
        if (!eVar.H || !eVar.d()) {
            return null;
        }
        LiteavLog.i(eVar.f43934a, "scene changed, restart decoder");
        eVar.H = false;
        return new b(c.RESTART_DECODER, EnumC0644e.NONE);
    }

    public static /* synthetic */ b a(e eVar, EncodedVideoFrame encodedVideoFrame) {
        boolean z10;
        SpsInfo a10 = eVar.B.a(encodedVideoFrame.isH265(), encodedVideoFrame.data);
        if (eVar.C.equals(a10)) {
            z10 = false;
        } else {
            eVar.C.set(a10);
            z10 = true;
        }
        if (eVar.d() && z10) {
            return new b(c.RESTART_DECODER, EnumC0644e.NONE);
        }
        return null;
    }
}
