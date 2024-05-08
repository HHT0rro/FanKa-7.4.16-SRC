package com.tencent.liteav.videoconsumer.decoder;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.SystemClock;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.DatabaseSourceInfoStorage;
import com.tencent.liteav.base.storage.PersistStorage;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.TimeUtil;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoconsumer.consumer.VideoConsumerServerConfig;
import com.tencent.liteav.videoconsumer.decoder.VideoDecoderDef;
import com.tencent.liteav.videoconsumer.decoder.b;
import com.tencent.liteav.videoconsumer.decoder.bk;
import com.tencent.liteav.videoconsumer.decoder.e;
import com.tencent.liteav.videoconsumer.decoder.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class VideoDecodeController extends bl {

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final IVideoReporter f43775b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final e f43776c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final bi f43777d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f43778e;

    /* renamed from: f, reason: collision with root package name */
    public final com.tencent.liteav.base.util.l f43779f;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.liteav.base.util.r f43780g;

    /* renamed from: h, reason: collision with root package name */
    public bl f43781h;

    /* renamed from: i, reason: collision with root package name */
    public Object f43782i;

    /* renamed from: k, reason: collision with root package name */
    public bk f43784k;

    /* renamed from: l, reason: collision with root package name */
    public JSONArray f43785l;

    /* renamed from: s, reason: collision with root package name */
    public VideoConsumerServerConfig f43792s;

    /* renamed from: t, reason: collision with root package name */
    public final com.tencent.liteav.videobase.utils.n f43793t;

    /* renamed from: w, reason: collision with root package name */
    public ac f43796w;

    /* renamed from: z, reason: collision with root package name */
    private final e.d f43799z;

    /* renamed from: a, reason: collision with root package name */
    public String f43774a = "VideoDecodeController";

    /* renamed from: x, reason: collision with root package name */
    private final com.tencent.liteav.base.b.a f43797x = new com.tencent.liteav.base.b.a(1000);

    /* renamed from: j, reason: collision with root package name */
    public boolean f43783j = false;

    /* renamed from: m, reason: collision with root package name */
    public boolean f43786m = false;

    /* renamed from: n, reason: collision with root package name */
    public boolean f43787n = false;

    /* renamed from: o, reason: collision with root package name */
    public Surface f43788o = null;

    /* renamed from: y, reason: collision with root package name */
    private VideoDecoderDef.ConsumerScene f43798y = VideoDecoderDef.ConsumerScene.UNKNOWN;

    /* renamed from: p, reason: collision with root package name */
    public final Deque<EncodedVideoFrame> f43789p = new LinkedList();

    /* renamed from: q, reason: collision with root package name */
    public final AtomicInteger f43790q = new AtomicInteger(0);

    /* renamed from: r, reason: collision with root package name */
    public final com.tencent.liteav.videobase.utils.m f43791r = new com.tencent.liteav.videobase.utils.m();

    /* renamed from: u, reason: collision with root package name */
    public final AtomicBoolean f43794u = new AtomicBoolean(false);

    /* renamed from: v, reason: collision with root package name */
    public final d f43795v = new d();

    /* renamed from: com.tencent.liteav.videoconsumer.decoder.VideoDecodeController$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f43800a;

        static {
            int[] iArr = new int[e.c.values().length];
            f43800a = iArr;
            try {
                iArr[e.c.DROP_FRAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43800a[e.c.CONTINUE_DECODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f43800a[e.c.SWITCH_TO_HARDWARE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f43800a[e.c.SWITCH_TO_SOFTWARE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f43800a[e.c.RESTART_DECODER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f43800a[e.c.REQUEST_KEY_FRAME.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f43800a[e.c.REPORT_DECODE_ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum DecodeStrategy {
        PREFER_HARDWARE(0),
        PREFER_SOFTWARE(1),
        FORCE_HARDWARE(2),
        FORCE_SOFTWARE(3);


        /* renamed from: e, reason: collision with root package name */
        private static final DecodeStrategy[] f43805e = values();
        private final int mValue;

        DecodeStrategy(int i10) {
            this.mValue = i10;
        }

        public static DecodeStrategy a(int i10) {
            for (DecodeStrategy decodeStrategy : f43805e) {
                if (decodeStrategy.mValue == i10) {
                    return decodeStrategy;
                }
            }
            return PREFER_HARDWARE;
        }
    }

    public VideoDecodeController(@NonNull IVideoReporter iVideoReporter) {
        Integer num;
        e.d a10 = an.a();
        this.f43799z = a10;
        this.f43775b = iVideoReporter;
        this.f43778e = false;
        b.a.a();
        boolean z10 = true;
        if (!SoftwareVideoDecoder.nativeIsSoftwareHevcDecoderSupport()) {
            b.a.a();
            if (!(VideoConsumerServerConfig.isHWHevcDecodeAllowed() && (num = new PersistStorage(PersistStorage.GLOBAL_DOMAIN).getInt("Liteav.Video.android.local.decoder.enable.sw.mediacodec.hevc")) != null && num.intValue() > 0)) {
                z10 = false;
            }
        }
        b.a.a();
        this.f43776c = new e(a10, iVideoReporter, z10, b.b());
        this.f43777d = new bi(iVideoReporter);
        this.f43774a += "_" + hashCode();
        this.f43793t = new com.tencent.liteav.videobase.utils.n("decoder" + hashCode());
        this.f43779f = new com.tencent.liteav.base.util.l(15, this.f43774a);
        LiteavLog.i(this.f43774a, "mIsTranscodingMode=false");
    }

    public final void a(bl blVar) {
        a(bf.a(this, blVar));
    }

    public final void b() {
        EncodedVideoFrame peekFirst;
        e.c cVar;
        synchronized (this) {
            peekFirst = this.f43789p.peekFirst();
        }
        if (peekFirst == null) {
            return;
        }
        if (peekFirst.isEosFrame) {
            a(peekFirst);
            return;
        }
        peekFirst.updateNALTypeAccordingNALHeader();
        final e eVar = this.f43776c;
        long j10 = eVar.f43940g;
        if (j10 != 0 && peekFirst.pts == j10) {
            cVar = e.c.CONTINUE_DECODE;
        } else {
            if (eVar.f43953t == 0) {
                eVar.f43953t = peekFirst.pts;
                eVar.f43954u.f42750a = SystemClock.elapsedRealtime();
            }
            if (eVar.f43954u.a()) {
                eVar.f43955v = Math.min(((float) (peekFirst.pts - eVar.f43953t)) / 1000.0f, 3.0f);
                eVar.f43953t = peekFirst.pts;
            }
            if (peekFirst.isIDRFrame()) {
                if (!eVar.f43944k) {
                    eVar.f43944k = true;
                }
                ArrayList arrayList = new ArrayList(Arrays.asList(new e.a(eVar) { // from class: com.tencent.liteav.videoconsumer.decoder.f

                    /* renamed from: a, reason: collision with root package name */
                    private final e f43979a;

                    {
                        this.f43979a = eVar;
                    }

                    @Override // com.tencent.liteav.videoconsumer.decoder.e.a
                    public final e.b a(EncodedVideoFrame encodedVideoFrame) {
                        return e.a(this.f43979a);
                    }
                }, new e.a(eVar) { // from class: com.tencent.liteav.videoconsumer.decoder.j

                    /* renamed from: a, reason: collision with root package name */
                    private final e f43983a;

                    {
                        this.f43983a = eVar;
                    }

                    @Override // com.tencent.liteav.videoconsumer.decoder.e.a
                    public final e.b a(EncodedVideoFrame encodedVideoFrame) {
                        return e.a(this.f43983a, encodedVideoFrame);
                    }
                }, new e.a(eVar) { // from class: com.tencent.liteav.videoconsumer.decoder.k

                    /* renamed from: a, reason: collision with root package name */
                    private final e f43984a;

                    {
                        this.f43984a = eVar;
                    }

                    @Override // com.tencent.liteav.videoconsumer.decoder.e.a
                    public final e.b a(EncodedVideoFrame encodedVideoFrame) {
                        return e.b(this.f43984a, encodedVideoFrame);
                    }
                }, new e.a(eVar) { // from class: com.tencent.liteav.videoconsumer.decoder.l

                    /* renamed from: a, reason: collision with root package name */
                    private final e f43985a;

                    {
                        this.f43985a = eVar;
                    }

                    @Override // com.tencent.liteav.videoconsumer.decoder.e.a
                    public final e.b a(EncodedVideoFrame encodedVideoFrame) {
                        return e.c(this.f43985a, encodedVideoFrame);
                    }
                }, new e.a(eVar) { // from class: com.tencent.liteav.videoconsumer.decoder.m

                    /* renamed from: a, reason: collision with root package name */
                    private final e f43986a;

                    {
                        this.f43986a = eVar;
                    }

                    @Override // com.tencent.liteav.videoconsumer.decoder.e.a
                    public final e.b a(EncodedVideoFrame encodedVideoFrame) {
                        return e.d(this.f43986a, encodedVideoFrame);
                    }
                }, new e.a(eVar) { // from class: com.tencent.liteav.videoconsumer.decoder.n

                    /* renamed from: a, reason: collision with root package name */
                    private final e f43987a;

                    {
                        this.f43987a = eVar;
                    }

                    @Override // com.tencent.liteav.videoconsumer.decoder.e.a
                    public final e.b a(EncodedVideoFrame encodedVideoFrame) {
                        return e.e(this.f43987a, encodedVideoFrame);
                    }
                }, new e.a(eVar) { // from class: com.tencent.liteav.videoconsumer.decoder.o

                    /* renamed from: a, reason: collision with root package name */
                    private final e f43988a;

                    {
                        this.f43988a = eVar;
                    }

                    @Override // com.tencent.liteav.videoconsumer.decoder.e.a
                    public final e.b a(EncodedVideoFrame encodedVideoFrame) {
                        return e.b(this.f43988a);
                    }
                }, new e.a(eVar) { // from class: com.tencent.liteav.videoconsumer.decoder.p

                    /* renamed from: a, reason: collision with root package name */
                    private final e f43989a;

                    {
                        this.f43989a = eVar;
                    }

                    @Override // com.tencent.liteav.videoconsumer.decoder.e.a
                    public final e.b a(EncodedVideoFrame encodedVideoFrame) {
                        return e.f(this.f43989a, encodedVideoFrame);
                    }
                }, new e.a(eVar) { // from class: com.tencent.liteav.videoconsumer.decoder.q

                    /* renamed from: a, reason: collision with root package name */
                    private final e f43990a;

                    {
                        this.f43990a = eVar;
                    }

                    @Override // com.tencent.liteav.videoconsumer.decoder.e.a
                    public final e.b a(EncodedVideoFrame encodedVideoFrame) {
                        return e.c(this.f43990a);
                    }
                }, new e.a(eVar) { // from class: com.tencent.liteav.videoconsumer.decoder.g

                    /* renamed from: a, reason: collision with root package name */
                    private final e f43980a;

                    {
                        this.f43980a = eVar;
                    }

                    @Override // com.tencent.liteav.videoconsumer.decoder.e.a
                    public final e.b a(EncodedVideoFrame encodedVideoFrame) {
                        return e.g(this.f43980a, encodedVideoFrame);
                    }
                }, new e.a(eVar) { // from class: com.tencent.liteav.videoconsumer.decoder.h

                    /* renamed from: a, reason: collision with root package name */
                    private final e f43981a;

                    {
                        this.f43981a = eVar;
                    }

                    @Override // com.tencent.liteav.videoconsumer.decoder.e.a
                    public final e.b a(EncodedVideoFrame encodedVideoFrame) {
                        return e.h(this.f43981a, encodedVideoFrame);
                    }
                }));
                if (eVar.f43952s != VideoDecoderDef.ConsumerScene.LIVE && eVar.f43936c != DecodeStrategy.FORCE_HARDWARE) {
                    arrayList.addAll(Arrays.asList(new e.a(eVar) { // from class: com.tencent.liteav.videoconsumer.decoder.i

                        /* renamed from: a, reason: collision with root package name */
                        private final e f43982a;

                        {
                            this.f43982a = eVar;
                        }

                        @Override // com.tencent.liteav.videoconsumer.decoder.e.a
                        public final e.b a(EncodedVideoFrame encodedVideoFrame) {
                            return e.i(this.f43982a, encodedVideoFrame);
                        }
                    }));
                }
                Iterator<E> iterator2 = arrayList.iterator2();
                e.b bVar = null;
                while (iterator2.hasNext()) {
                    e.b a10 = ((e.a) iterator2.next()).a(peekFirst);
                    if (a10 != null) {
                        if (bVar != null) {
                            if (e.c.a(a10.f43960a) > e.c.a(bVar.f43960a) || (e.c.a(a10.f43960a) == e.c.a(bVar.f43960a) && a10.f43961b.mPriority > bVar.f43961b.mPriority)) {
                            }
                        }
                        bVar = a10;
                    }
                }
                if (bVar != null && bVar.f43960a != e.c.CONTINUE_DECODE) {
                    LiteavLog.w(eVar.f43934a, ((Object) bVar) + ", mUsingDecoderType = " + ((Object) eVar.f43937d) + ", mSwitchReason = " + ((Object) eVar.f43939f));
                }
                if (bVar == null) {
                    bVar = new e.b(e.c.CONTINUE_DECODE, e.EnumC0644e.NONE);
                }
                e.c cVar2 = bVar.f43960a;
                if (cVar2 == e.c.SWITCH_TO_HARDWARE) {
                    bk.a aVar = eVar.f43937d;
                    bk.a aVar2 = bk.a.HARDWARE;
                    if (aVar != aVar2) {
                        e.EnumC0644e enumC0644e = bVar.f43961b;
                        if (enumC0644e.mPriority >= eVar.f43939f.mPriority) {
                            eVar.f43939f = enumC0644e;
                            eVar.f43937d = aVar2;
                            eVar.f43935b.notifyEvent(h.b.EVT_VIDEO_DECODE_TYPE_CHANGE, (Object) null, "UsingDecoderType:" + ((Object) eVar.f43937d));
                            cVar = bVar.f43960a;
                        }
                    }
                    cVar = e.c.CONTINUE_DECODE;
                } else {
                    if (cVar2 == e.c.SWITCH_TO_SOFTWARE) {
                        bk.a aVar3 = eVar.f43937d;
                        bk.a aVar4 = bk.a.SOFTWARE;
                        if (aVar3 != aVar4) {
                            e.EnumC0644e enumC0644e2 = bVar.f43961b;
                            if (enumC0644e2.mPriority >= eVar.f43939f.mPriority) {
                                eVar.f43939f = enumC0644e2;
                                eVar.f43937d = aVar4;
                                eVar.f43935b.notifyEvent(h.b.EVT_VIDEO_DECODE_TYPE_CHANGE, (Object) null, "UsingDecoderType:" + ((Object) eVar.f43937d));
                            }
                        }
                        cVar = e.c.CONTINUE_DECODE;
                    }
                    cVar = bVar.f43960a;
                }
            } else if (eVar.f43944k) {
                cVar = e.c.CONTINUE_DECODE;
            } else {
                int i10 = eVar.f43945l + 1;
                eVar.f43945l = i10;
                if (i10 > 40) {
                    LiteavLog.w(eVar.f43934a, "decoding too many frame(>40) without output! request key frame now.");
                    eVar.f43945l = 0;
                    cVar = e.c.REQUEST_KEY_FRAME;
                } else {
                    cVar = e.c.DROP_FRAME;
                }
            }
        }
        e.c cVar3 = e.c.CONTINUE_DECODE;
        if (cVar == cVar3) {
            if ((peekFirst.pts == eVar.f43940g && eVar.f43956w != 0 && TimeUtil.a() - eVar.f43956w >= 1500) || eVar.f43958z) {
                eVar.f43958z = true;
                if (!peekFirst.isIDRFrame()) {
                    cVar = e.c.DROP_FRAME;
                } else {
                    bk.a aVar5 = eVar.f43937d;
                    bk.a aVar6 = bk.a.HARDWARE;
                    if (aVar5 == aVar6) {
                        eVar.f43935b.notifyEvent(h.b.EVT_VIDEO_HARDWARE_DECODER_STUCK, (Object) null, "");
                    }
                    if (eVar.f43937d == aVar6 && eVar.a(peekFirst) && e.f43933y.get() >= 3) {
                        eVar.f43937d = bk.a.SOFTWARE;
                        eVar.f43939f = e.EnumC0644e.DECODE_ERROR;
                        eVar.f43935b.notifyEvent(h.b.EVT_VIDEO_DECODE_TYPE_CHANGE, (Object) null, "UsingDecoderType:" + ((Object) eVar.f43937d));
                        cVar = e.c.SWITCH_TO_SOFTWARE;
                    } else {
                        if (eVar.f43937d == aVar6) {
                            LiteavLog.i(eVar.f43934a, "hardware decoder stuck, count:".concat(String.valueOf(e.f43933y.incrementAndGet())));
                        }
                        cVar = e.c.RESTART_DECODER;
                    }
                    LiteavLog.i(eVar.f43934a, "decoder thread stuck, switch decode type, instruction:".concat(String.valueOf(cVar)));
                }
            } else {
                cVar = cVar3;
            }
        }
        int i11 = e.AnonymousClass1.f43959a[cVar.ordinal()];
        if (i11 == 1 || i11 == 2 || i11 == 3) {
            eVar.f43946m = 1;
            eVar.f43938e = peekFirst.isH265();
            eVar.f43956w = 0L;
            eVar.f43958z = false;
        } else if (i11 == 4) {
            if (eVar.f43940g != peekFirst.pts) {
                eVar.f43946m++;
                eVar.f43956w = 0L;
            } else if (eVar.f43956w == 0) {
                eVar.f43956w = TimeUtil.a();
            }
        }
        eVar.f43940g = peekFirst.pts;
        switch (AnonymousClass1.f43800a[cVar.ordinal()]) {
            case 1:
                b(peekFirst);
                peekFirst.release();
                return;
            case 2:
                a(peekFirst);
                return;
            case 3:
                a(peekFirst, bk.a.HARDWARE);
                a(peekFirst);
                return;
            case 4:
                a(peekFirst, bk.a.SOFTWARE);
                a(peekFirst);
                return;
            case 5:
                bk.a e2 = e();
                if (e2 != null) {
                    a(peekFirst, e2);
                    a(peekFirst);
                    return;
                }
                return;
            case 6:
                b(peekFirst);
                peekFirst.release();
                h();
                return;
            case 7:
                b(peekFirst);
                peekFirst.release();
                bl blVar = this.f43781h;
                if (blVar != null) {
                    blVar.i();
                    this.f43775b.notifyWarning(h.c.WARNING_VIDEO_DECODE_FATAL_ERROR, "decoder error");
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void c() {
        ac acVar = this.f43796w;
        if (acVar != null) {
            acVar.a();
            this.f43796w = null;
        }
    }

    public final int d() {
        int size;
        synchronized (this) {
            size = this.f43789p.size();
        }
        return size;
    }

    public final bk.a e() {
        bk bkVar = this.f43784k;
        if (bkVar == null) {
            return null;
        }
        return bkVar.getDecoderType();
    }

    public final void f() {
        a(aq.a(this));
    }

    public final void g() {
        bk bkVar = this.f43784k;
        if (bkVar != null) {
            bkVar.stop();
            this.f43784k.uninitialize();
            this.f43784k = null;
        }
        this.f43791r.b();
    }

    public final void h() {
        if (this.f43781h == null || !this.f43797x.a()) {
            return;
        }
        this.f43781h.a();
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.bl
    public final void i() {
        a(av.a(this));
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.bl
    public final void j() {
        a(ay.a(this));
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.bl
    public final void k() {
        a(az.a(this));
    }

    public final void a(VideoDecoderDef.ConsumerScene consumerScene) {
        this.f43798y = consumerScene;
        this.f43776c.a(consumerScene);
    }

    private void a(EncodedVideoFrame encodedVideoFrame, bk.a aVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        g();
        SpsInfo a10 = this.f43799z.a(encodedVideoFrame.isH265(), encodedVideoFrame.data);
        boolean z10 = true;
        if (encodedVideoFrame.isH265() && (aVar == bk.a.SOFTWARE || aVar == bk.a.SOFTWARE_DEVICE)) {
            b.a.a();
            if (!SoftwareVideoDecoder.nativeIsSoftwareHevcDecoderSupport()) {
                c();
                u.a aVar2 = new u.a();
                aVar2.f44019d = this.f43776c.b();
                aVar2.f44023h = this.f43785l;
                aVar2.f44016a = encodedVideoFrame.isHDRFrame();
                aVar2.f44018c = a(a10);
                aVar2.f44020e = new Size(a10.width, a10.height);
                aVar2.f44022g = true;
                aVar2.f44017b = true;
                u uVar = new u(aVar2, this.f43775b, null);
                uVar.initialize();
                uVar.a(this.f43788o);
                this.f43784k = uVar;
                this.f43784k.setServerConfig(this.f43792s);
                this.f43784k.setScene(this.f43798y);
                this.f43784k.start(this.f43782i, this);
                e eVar = this.f43776c;
                if (this.f43784k.getDecoderType() != bk.a.HARDWARE && this.f43784k.getDecoderType() != bk.a.SOFTWARE_DEVICE) {
                    z10 = false;
                }
                eVar.A = z10;
                this.f43790q.set(0);
                LiteavLog.i(this.f43774a, "open decoder cost time: " + (SystemClock.elapsedRealtime() - elapsedRealtime) + ",update decoder type to " + ((Object) aVar) + ", video " + ((Object) a10));
                this.f43777d.a(this.f43784k.getDecoderType(), encodedVideoFrame.codecType);
                this.f43787n = encodedVideoFrame.isHDRFrame();
            }
        }
        if (aVar == bk.a.SOFTWARE) {
            c();
            SoftwareVideoDecoder softwareVideoDecoder = new SoftwareVideoDecoder(this.f43775b, encodedVideoFrame.isH265());
            this.f43784k = softwareVideoDecoder;
            softwareVideoDecoder.initialize();
        } else {
            u.a aVar3 = new u.a();
            aVar3.f44019d = this.f43776c.b();
            aVar3.f44023h = this.f43785l;
            aVar3.f44016a = encodedVideoFrame.isHDRFrame();
            aVar3.f44018c = a(a10);
            MediaFormat mediaFormat = encodedVideoFrame.videoFormat;
            if (mediaFormat != null) {
                aVar3.f44021f = mediaFormat;
            } else {
                aVar3.f44017b = encodedVideoFrame.isH265();
                aVar3.f44020e = new Size(a10.width, a10.height);
            }
            u uVar2 = new u(aVar3, this.f43775b, a(encodedVideoFrame, aVar3, a10));
            uVar2.initialize();
            uVar2.a(this.f43788o);
            this.f43784k = uVar2;
        }
        this.f43784k.setServerConfig(this.f43792s);
        this.f43784k.setScene(this.f43798y);
        this.f43784k.start(this.f43782i, this);
        e eVar2 = this.f43776c;
        if (this.f43784k.getDecoderType() != bk.a.HARDWARE) {
            z10 = false;
        }
        eVar2.A = z10;
        this.f43790q.set(0);
        LiteavLog.i(this.f43774a, "open decoder cost time: " + (SystemClock.elapsedRealtime() - elapsedRealtime) + ",update decoder type to " + ((Object) aVar) + ", video " + ((Object) a10));
        this.f43777d.a(this.f43784k.getDecoderType(), encodedVideoFrame.codecType);
        this.f43787n = encodedVideoFrame.isHDRFrame();
    }

    private MediaCodec a(EncodedVideoFrame encodedVideoFrame, u.a aVar, SpsInfo spsInfo) {
        ac acVar;
        MediaCodec b4;
        String str = encodedVideoFrame.isH265() ? "video/hevc" : com.alibaba.security.biometrics.service.build.ah.f2598d;
        b.a.a();
        boolean z10 = aVar.f44018c && ag.a(b.a(str));
        if (!aVar.f44019d && !aVar.f44016a && !z10 && (acVar = this.f43796w) != null) {
            MediaFormat mediaFormat = aVar.f44021f;
            if (mediaFormat != null) {
                b4 = acVar.b(mediaFormat);
            } else {
                MediaFormat mediaFormat2 = new MediaFormat();
                mediaFormat2.setInteger("width", spsInfo.width);
                mediaFormat2.setInteger("height", spsInfo.height);
                mediaFormat2.setString(DatabaseSourceInfoStorage.COLUMN_MIME, encodedVideoFrame.isH265() ? "video/hevc" : com.alibaba.security.biometrics.service.build.ah.f2598d);
                b4 = this.f43796w.b(mediaFormat2);
            }
            LiteavLog.i(this.f43774a, "Preload mediacodec: ".concat(String.valueOf(b4)));
            return b4;
        }
        LiteavLog.i(this.f43774a, "Preload mediacodec fail, is low latency:" + aVar.f44019d + ", is hdr:" + aVar.f44016a + ", is use outputbuffer:" + z10 + ", preload mediacodec:" + ((Object) this.f43796w));
        return null;
    }

    private void a(EncodedVideoFrame encodedVideoFrame) {
        bk bkVar = this.f43784k;
        if (bkVar == null) {
            LiteavLog.e(this.f43774a, "video decoder is null!");
            return;
        }
        if (bkVar.decode(encodedVideoFrame)) {
            b(encodedVideoFrame);
            if (encodedVideoFrame.isEosFrame) {
                return;
            }
            this.f43777d.a(encodedVideoFrame);
            this.f43790q.incrementAndGet();
            this.f43775b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_DECODER_CACHE, Integer.valueOf(this.f43790q.get() + d()));
        }
    }

    public final boolean a(Runnable runnable) {
        boolean z10;
        com.tencent.liteav.base.util.l lVar = this.f43779f;
        if (lVar != null) {
            lVar.a(runnable);
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            LiteavLog.w(this.f43774a, "runnable:" + ((Object) runnable) + " is failed to post, handler:" + ((Object) lVar));
        }
        return z10;
    }

    private boolean a(SpsInfo spsInfo) {
        Integer num;
        Integer num2 = spsInfo.videoFullRangeFlag;
        boolean z10 = num2 != null && num2.intValue() == 1;
        Integer num3 = spsInfo.colourPrimaries;
        return this.f43786m && z10 && (num3 != null && num3.intValue() == 1 && (num = spsInfo.transferCharacteristics) != null && num.intValue() == 1);
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.bl
    public final void a(@NonNull PixelFrame pixelFrame, long j10) {
        long timestamp = pixelFrame.getTimestamp();
        this.f43791r.a(pixelFrame);
        this.f43775b.updateStatus(com.tencent.liteav.videobase.videobase.i.STATUS_VIDEO_DECODER_FRAME, pixelFrame);
        if (a(au.a(this, timestamp, j10))) {
            return;
        }
        this.f43791r.b(pixelFrame);
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.bl
    public final void a() {
        a(ax.a(this));
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.bl
    public final void a(boolean z10) {
        a(ba.a(this, z10));
    }

    private void b(EncodedVideoFrame encodedVideoFrame) {
        synchronized (this) {
            this.f43789p.remove(encodedVideoFrame);
        }
    }
}
