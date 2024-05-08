package q6;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.alibaba.security.biometrics.service.build.ah;
import com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.DatabaseSourceInfoStorage;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.b;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.g0;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.video.DummySurface;
import com.google.android.exoplayer2.video.MediaCodecVideoDecoderException;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import q6.x;
import sun.util.locale.LanguageTag;

/* compiled from: MediaCodecVideoRenderer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class e extends MediaCodecRenderer {
    public static boolean A1;
    public static final int[] y1 = {1920, 1600, MetricsProto.MetricsEvent.ACTION_HUSH_GESTURE, 1280, 960, MetricsProto.MetricsEvent.FIELD_SETTINGS_PREFERENCE_CHANGE_NAME, 640, 540, 480};
    public static boolean z1;
    public final Context P0;
    public final j Q0;
    public final x.a R0;
    public final long S0;
    public final int T0;
    public final boolean U0;
    public a V0;
    public boolean W0;
    public boolean X0;

    @Nullable
    public Surface Y0;

    @Nullable
    public DummySurface Z0;

    /* renamed from: a1, reason: collision with root package name */
    public boolean f53057a1;

    /* renamed from: b1, reason: collision with root package name */
    public int f53058b1;

    /* renamed from: c1, reason: collision with root package name */
    public boolean f53059c1;

    /* renamed from: d1, reason: collision with root package name */
    public boolean f53060d1;

    /* renamed from: e1, reason: collision with root package name */
    public boolean f53061e1;

    /* renamed from: f1, reason: collision with root package name */
    public long f53062f1;

    /* renamed from: g1, reason: collision with root package name */
    public long f53063g1;

    /* renamed from: h1, reason: collision with root package name */
    public long f53064h1;

    /* renamed from: i1, reason: collision with root package name */
    public int f53065i1;

    /* renamed from: j1, reason: collision with root package name */
    public int f53066j1;

    /* renamed from: k1, reason: collision with root package name */
    public int f53067k1;

    /* renamed from: l1, reason: collision with root package name */
    public long f53068l1;

    /* renamed from: m1, reason: collision with root package name */
    public long f53069m1;

    /* renamed from: n1, reason: collision with root package name */
    public long f53070n1;

    /* renamed from: o1, reason: collision with root package name */
    public int f53071o1;

    /* renamed from: p1, reason: collision with root package name */
    public int f53072p1;

    /* renamed from: q1, reason: collision with root package name */
    public int f53073q1;

    /* renamed from: r1, reason: collision with root package name */
    public int f53074r1;

    /* renamed from: s1, reason: collision with root package name */
    public float f53075s1;

    /* renamed from: t1, reason: collision with root package name */
    @Nullable
    public y f53076t1;

    /* renamed from: u1, reason: collision with root package name */
    public boolean f53077u1;

    /* renamed from: v1, reason: collision with root package name */
    public int f53078v1;

    /* renamed from: w1, reason: collision with root package name */
    @Nullable
    public b f53079w1;

    /* renamed from: x1, reason: collision with root package name */
    @Nullable
    public h f53080x1;

    /* compiled from: MediaCodecVideoRenderer.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f53081a;

        /* renamed from: b, reason: collision with root package name */
        public final int f53082b;

        /* renamed from: c, reason: collision with root package name */
        public final int f53083c;

        public a(int i10, int i11, int i12) {
            this.f53081a = i10;
            this.f53082b = i11;
            this.f53083c = i12;
        }
    }

    /* compiled from: MediaCodecVideoRenderer.java */
    @RequiresApi(23)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class b implements b.c, Handler.Callback {

        /* renamed from: b, reason: collision with root package name */
        public final Handler f53084b;

        public b(com.google.android.exoplayer2.mediacodec.b bVar) {
            Handler y10 = j0.y(this);
            this.f53084b = y10;
            bVar.h(this, y10);
        }

        @Override // com.google.android.exoplayer2.mediacodec.b.c
        public void a(com.google.android.exoplayer2.mediacodec.b bVar, long j10, long j11) {
            if (j0.f22990a < 30) {
                this.f53084b.sendMessageAtFrontOfQueue(Message.obtain(this.f53084b, 0, (int) (j10 >> 32), (int) j10));
            } else {
                b(j10);
            }
        }

        public final void b(long j10) {
            e eVar = e.this;
            if (this != eVar.f53079w1) {
                return;
            }
            if (j10 == Long.MAX_VALUE) {
                eVar.O1();
                return;
            }
            try {
                eVar.N1(j10);
            } catch (ExoPlaybackException e2) {
                e.this.e1(e2);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b(j0.U0(message.arg1, message.arg2));
            return true;
        }
    }

    public e(Context context, com.google.android.exoplayer2.mediacodec.d dVar, long j10, boolean z10, @Nullable Handler handler, @Nullable x xVar, int i10) {
        this(context, b.InterfaceC0191b.f20831a, dVar, j10, z10, handler, xVar, i10);
    }

    public static List<com.google.android.exoplayer2.mediacodec.c> A1(com.google.android.exoplayer2.mediacodec.d dVar, Format format, boolean z10, boolean z11) throws MediaCodecUtil.DecoderQueryException {
        Pair<Integer, Integer> p10;
        String str = format.f19544m;
        if (str == null) {
            return Collections.emptyList();
        }
        List<com.google.android.exoplayer2.mediacodec.c> t2 = MediaCodecUtil.t(dVar.a(str, z10, z11), format);
        if ("video/dolby-vision".equals(str) && (p10 = MediaCodecUtil.p(format)) != null) {
            int intValue = ((Integer) p10.first).intValue();
            if (intValue == 16 || intValue == 256) {
                t2.addAll(dVar.a("video/hevc", z10, z11));
            } else if (intValue == 512) {
                t2.addAll(dVar.a(ah.f2598d, z10, z11));
            }
        }
        return Collections.unmodifiableList(t2);
    }

    public static int B1(com.google.android.exoplayer2.mediacodec.c cVar, Format format) {
        if (format.f19545n != -1) {
            int size = format.f19546o.size();
            int i10 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                i10 += format.f19546o.get(i11).length;
            }
            return format.f19545n + i10;
        }
        return x1(cVar, format);
    }

    public static boolean D1(long j10) {
        return j10 < -30000;
    }

    public static boolean E1(long j10) {
        return j10 < -500000;
    }

    @RequiresApi(29)
    public static void R1(com.google.android.exoplayer2.mediacodec.b bVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        bVar.c(bundle);
    }

    @RequiresApi(21)
    public static void t1(MediaFormat mediaFormat, int i10) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i10);
    }

    public static boolean u1() {
        return "NVIDIA".equals(j0.f22992c);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:454:0x07cf, code lost:
    
        if (r0.equals("NX573J") == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0831, code lost:
    
        if (r0.equals("AFTN") == false) goto L610;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:40:0x081a. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean w1() {
        /*
            Method dump skipped, instructions count: 3046
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q6.e.w1():boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0070, code lost:
    
        if (r3.equals("video/hevc") == false) goto L18;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x007d. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int x1(com.google.android.exoplayer2.mediacodec.c r10, com.google.android.exoplayer2.Format r11) {
        /*
            int r0 = r11.f19549r
            int r1 = r11.f19550s
            r2 = -1
            if (r0 == r2) goto Lc8
            if (r1 != r2) goto Lb
            goto Lc8
        Lb:
            java.lang.String r3 = r11.f19544m
            java.lang.String r4 = "video/dolby-vision"
            boolean r4 = r4.equals(r3)
            java.lang.String r5 = "video/avc"
            r6 = 1
            java.lang.String r7 = "video/hevc"
            r8 = 2
            if (r4 == 0) goto L34
            android.util.Pair r11 = com.google.android.exoplayer2.mediacodec.MediaCodecUtil.p(r11)
            if (r11 == 0) goto L33
            java.lang.Object r11 = r11.first
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            r3 = 512(0x200, float:7.175E-43)
            if (r11 == r3) goto L31
            if (r11 == r6) goto L31
            if (r11 != r8) goto L33
        L31:
            r3 = r5
            goto L34
        L33:
            r3 = r7
        L34:
            r3.hashCode()
            int r11 = r3.hashCode()
            r4 = 4
            r9 = 3
            switch(r11) {
                case -1664118616: goto L73;
                case -1662541442: goto L6c;
                case 1187890754: goto L61;
                case 1331836730: goto L58;
                case 1599127256: goto L4d;
                case 1599127257: goto L42;
                default: goto L40;
            }
        L40:
            r6 = -1
            goto L7d
        L42:
            java.lang.String r11 = "video/x-vnd.on2.vp9"
            boolean r11 = r3.equals(r11)
            if (r11 != 0) goto L4b
            goto L40
        L4b:
            r6 = 5
            goto L7d
        L4d:
            java.lang.String r11 = "video/x-vnd.on2.vp8"
            boolean r11 = r3.equals(r11)
            if (r11 != 0) goto L56
            goto L40
        L56:
            r6 = 4
            goto L7d
        L58:
            boolean r11 = r3.equals(r5)
            if (r11 != 0) goto L5f
            goto L40
        L5f:
            r6 = 3
            goto L7d
        L61:
            java.lang.String r11 = "video/mp4v-es"
            boolean r11 = r3.equals(r11)
            if (r11 != 0) goto L6a
            goto L40
        L6a:
            r6 = 2
            goto L7d
        L6c:
            boolean r11 = r3.equals(r7)
            if (r11 != 0) goto L7d
            goto L40
        L73:
            java.lang.String r11 = "video/3gpp"
            boolean r11 = r3.equals(r11)
            if (r11 != 0) goto L7c
            goto L40
        L7c:
            r6 = 0
        L7d:
            switch(r6) {
                case 0: goto Lbf;
                case 1: goto Lbc;
                case 2: goto Lbf;
                case 3: goto L81;
                case 4: goto Lbf;
                case 5: goto Lbc;
                default: goto L80;
            }
        L80:
            return r2
        L81:
            java.lang.String r11 = com.google.android.exoplayer2.util.j0.f22993d
            java.lang.String r3 = "BRAVIA 4K 2015"
            boolean r3 = r3.equals(r11)
            if (r3 != 0) goto Lbb
            java.lang.String r3 = com.google.android.exoplayer2.util.j0.f22992c
            java.lang.String r4 = "Amazon"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto Laa
            java.lang.String r3 = "KFSOWI"
            boolean r3 = r3.equals(r11)
            if (r3 != 0) goto Lbb
            java.lang.String r3 = "AFTS"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto Laa
            boolean r10 = r10.f20838g
            if (r10 == 0) goto Laa
            goto Lbb
        Laa:
            r10 = 16
            int r11 = com.google.android.exoplayer2.util.j0.l(r0, r10)
            int r0 = com.google.android.exoplayer2.util.j0.l(r1, r10)
            int r11 = r11 * r0
            int r11 = r11 * 16
            int r0 = r11 * 16
            goto Lc1
        Lbb:
            return r2
        Lbc:
            int r0 = r0 * r1
            goto Lc2
        Lbf:
            int r0 = r0 * r1
        Lc1:
            r4 = 2
        Lc2:
            int r0 = r0 * 3
            int r4 = r4 * 2
            int r0 = r0 / r4
            return r0
        Lc8:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: q6.e.x1(com.google.android.exoplayer2.mediacodec.c, com.google.android.exoplayer2.Format):int");
    }

    public static Point y1(com.google.android.exoplayer2.mediacodec.c cVar, Format format) {
        int i10 = format.f19550s;
        int i11 = format.f19549r;
        boolean z10 = i10 > i11;
        int i12 = z10 ? i10 : i11;
        if (z10) {
            i10 = i11;
        }
        float f10 = i10 / i12;
        for (int i13 : y1) {
            int i14 = (int) (i13 * f10);
            if (i13 <= i12 || i14 <= i10) {
                break;
            }
            if (j0.f22990a >= 21) {
                int i15 = z10 ? i14 : i13;
                if (!z10) {
                    i13 = i14;
                }
                Point b4 = cVar.b(i15, i13);
                if (cVar.t(b4.x, b4.y, format.f19551t)) {
                    return b4;
                }
            } else {
                try {
                    int l10 = j0.l(i13, 16) * 16;
                    int l11 = j0.l(i14, 16) * 16;
                    if (l10 * l11 <= MediaCodecUtil.M()) {
                        int i16 = z10 ? l11 : l10;
                        if (!z10) {
                            l10 = l11;
                        }
                        return new Point(i16, l10);
                    }
                } catch (MediaCodecUtil.DecoderQueryException unused) {
                }
            }
        }
        return null;
    }

    public MediaFormat C1(Format format, String str, a aVar, float f10, boolean z10, int i10) {
        Pair<Integer, Integer> p10;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(DatabaseSourceInfoStorage.COLUMN_MIME, str);
        mediaFormat.setInteger("width", format.f19549r);
        mediaFormat.setInteger("height", format.f19550s);
        com.google.android.exoplayer2.util.p.e(mediaFormat, format.f19546o);
        com.google.android.exoplayer2.util.p.c(mediaFormat, "frame-rate", format.f19551t);
        com.google.android.exoplayer2.util.p.d(mediaFormat, "rotation-degrees", format.f19552u);
        com.google.android.exoplayer2.util.p.b(mediaFormat, format.f19556y);
        if ("video/dolby-vision".equals(format.f19544m) && (p10 = MediaCodecUtil.p(format)) != null) {
            com.google.android.exoplayer2.util.p.d(mediaFormat, "profile", ((Integer) p10.first).intValue());
        }
        mediaFormat.setInteger("max-width", aVar.f53081a);
        mediaFormat.setInteger("max-height", aVar.f53082b);
        com.google.android.exoplayer2.util.p.d(mediaFormat, "max-input-size", aVar.f53083c);
        if (j0.f22990a >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f10 != -1.0f) {
                mediaFormat.setFloat("operating-rate", f10);
            }
        }
        if (z10) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i10 != 0) {
            t1(mediaFormat, i10);
        }
        return mediaFormat;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.f
    public void E() {
        r1();
        q1();
        this.f53057a1 = false;
        this.Q0.g();
        this.f53079w1 = null;
        try {
            super.E();
        } finally {
            this.R0.m(this.K0);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.f
    public void F(boolean z10, boolean z11) throws ExoPlaybackException {
        super.F(z10, z11);
        boolean z12 = z().f19652a;
        com.google.android.exoplayer2.util.a.g((z12 && this.f53078v1 == 0) ? false : true);
        if (this.f53077u1 != z12) {
            this.f53077u1 = z12;
            W0();
        }
        this.R0.o(this.K0);
        this.Q0.h();
        this.f53060d1 = z11;
        this.f53061e1 = false;
    }

    public boolean F1(long j10, boolean z10) throws ExoPlaybackException {
        int M = M(j10);
        if (M == 0) {
            return false;
        }
        z4.d dVar = this.K0;
        dVar.f54860i++;
        int i10 = this.f53067k1 + M;
        if (z10) {
            dVar.f54857f += i10;
        } else {
            a2(i10);
        }
        l0();
        return true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.f
    public void G(long j10, boolean z10) throws ExoPlaybackException {
        super.G(j10, z10);
        q1();
        this.Q0.l();
        this.f53068l1 = -9223372036854775807L;
        this.f53062f1 = -9223372036854775807L;
        this.f53066j1 = 0;
        if (z10) {
            S1();
        } else {
            this.f53063g1 = -9223372036854775807L;
        }
    }

    public final void G1() {
        if (this.f53065i1 > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.R0.n(this.f53065i1, elapsedRealtime - this.f53064h1);
            this.f53065i1 = 0;
            this.f53064h1 = elapsedRealtime;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.f
    public void H() {
        try {
            super.H();
            DummySurface dummySurface = this.Z0;
            if (dummySurface != null) {
                if (this.Y0 == dummySurface) {
                    this.Y0 = null;
                }
                dummySurface.release();
                this.Z0 = null;
            }
        } catch (Throwable th) {
            if (this.Z0 != null) {
                Surface surface = this.Y0;
                DummySurface dummySurface2 = this.Z0;
                if (surface == dummySurface2) {
                    this.Y0 = null;
                }
                dummySurface2.release();
                this.Z0 = null;
            }
            throw th;
        }
    }

    public void H1() {
        this.f53061e1 = true;
        if (this.f53059c1) {
            return;
        }
        this.f53059c1 = true;
        this.R0.A(this.Y0);
        this.f53057a1 = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.f
    public void I() {
        super.I();
        this.f53065i1 = 0;
        this.f53064h1 = SystemClock.elapsedRealtime();
        this.f53069m1 = SystemClock.elapsedRealtime() * 1000;
        this.f53070n1 = 0L;
        this.f53071o1 = 0;
        this.Q0.m();
    }

    public final void I1() {
        int i10 = this.f53071o1;
        if (i10 != 0) {
            this.R0.B(this.f53070n1, i10);
            this.f53070n1 = 0L;
            this.f53071o1 = 0;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.f
    public void J() {
        this.f53063g1 = -9223372036854775807L;
        G1();
        I1();
        this.Q0.n();
        super.J();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void J0(Exception exc) {
        com.google.android.exoplayer2.util.m.d("MediaCodecVideoRenderer", "Video codec error", exc);
        this.R0.C(exc);
    }

    public final void J1() {
        int i10 = this.f53072p1;
        if (i10 == -1 && this.f53073q1 == -1) {
            return;
        }
        y yVar = this.f53076t1;
        if (yVar != null && yVar.f53148a == i10 && yVar.f53149b == this.f53073q1 && yVar.f53150c == this.f53074r1 && yVar.f53151d == this.f53075s1) {
            return;
        }
        y yVar2 = new y(this.f53072p1, this.f53073q1, this.f53074r1, this.f53075s1);
        this.f53076t1 = yVar2;
        this.R0.D(yVar2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void K0(String str, long j10, long j11) {
        this.R0.k(str, j10, j11);
        this.W0 = s1(str);
        this.X0 = ((com.google.android.exoplayer2.mediacodec.c) com.google.android.exoplayer2.util.a.e(p0())).n();
        if (j0.f22990a < 23 || !this.f53077u1) {
            return;
        }
        this.f53079w1 = new b((com.google.android.exoplayer2.mediacodec.b) com.google.android.exoplayer2.util.a.e(o0()));
    }

    public final void K1() {
        if (this.f53057a1) {
            this.R0.A(this.Y0);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void L0(String str) {
        this.R0.l(str);
    }

    public final void L1() {
        y yVar = this.f53076t1;
        if (yVar != null) {
            this.R0.D(yVar);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @Nullable
    public DecoderReuseEvaluation M0(s0 s0Var) throws ExoPlaybackException {
        DecoderReuseEvaluation M0 = super.M0(s0Var);
        this.R0.p(s0Var.f21132b, M0);
        return M0;
    }

    public final void M1(long j10, long j11, Format format) {
        h hVar = this.f53080x1;
        if (hVar != null) {
            hVar.a(j10, j11, format, s0());
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void N0(Format format, @Nullable MediaFormat mediaFormat) {
        int integer;
        int integer2;
        com.google.android.exoplayer2.mediacodec.b o02 = o0();
        if (o02 != null) {
            o02.a(this.f53058b1);
        }
        if (this.f53077u1) {
            this.f53072p1 = format.f19549r;
            this.f53073q1 = format.f19550s;
        } else {
            com.google.android.exoplayer2.util.a.e(mediaFormat);
            boolean z10 = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            if (z10) {
                integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
            } else {
                integer = mediaFormat.getInteger("width");
            }
            this.f53072p1 = integer;
            if (z10) {
                integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
            } else {
                integer2 = mediaFormat.getInteger("height");
            }
            this.f53073q1 = integer2;
        }
        float f10 = format.f19553v;
        this.f53075s1 = f10;
        if (j0.f22990a >= 21) {
            int i10 = format.f19552u;
            if (i10 == 90 || i10 == 270) {
                int i11 = this.f53072p1;
                this.f53072p1 = this.f53073q1;
                this.f53073q1 = i11;
                this.f53075s1 = 1.0f / f10;
            }
        } else {
            this.f53074r1 = format.f19552u;
        }
        this.Q0.i(format.f19551t);
    }

    public void N1(long j10) throws ExoPlaybackException {
        n1(j10);
        J1();
        this.K0.f54856e++;
        H1();
        O0(j10);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void O0(long j10) {
        super.O0(j10);
        if (this.f53077u1) {
            return;
        }
        this.f53067k1--;
    }

    public final void O1() {
        d1();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public DecoderReuseEvaluation P(com.google.android.exoplayer2.mediacodec.c cVar, Format format, Format format2) {
        DecoderReuseEvaluation e2 = cVar.e(format, format2);
        int i10 = e2.f19892e;
        int i11 = format2.f19549r;
        a aVar = this.V0;
        if (i11 > aVar.f53081a || format2.f19550s > aVar.f53082b) {
            i10 |= 256;
        }
        if (B1(cVar, format2) > this.V0.f53083c) {
            i10 |= 64;
        }
        int i12 = i10;
        return new DecoderReuseEvaluation(cVar.f20832a, format, format2, i12 != 0 ? 0 : e2.f19891d, i12);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void P0() {
        super.P0();
        q1();
    }

    public void P1(com.google.android.exoplayer2.mediacodec.b bVar, int i10, long j10) {
        J1();
        g0.a("releaseOutputBuffer");
        bVar.f(i10, true);
        g0.c();
        this.f53069m1 = SystemClock.elapsedRealtime() * 1000;
        this.K0.f54856e++;
        this.f53066j1 = 0;
        H1();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void Q0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        boolean z10 = this.f53077u1;
        if (!z10) {
            this.f53067k1++;
        }
        if (j0.f22990a >= 23 || !z10) {
            return;
        }
        N1(decoderInputBuffer.f19884f);
    }

    @RequiresApi(21)
    public void Q1(com.google.android.exoplayer2.mediacodec.b bVar, int i10, long j10, long j11) {
        J1();
        g0.a("releaseOutputBuffer");
        bVar.d(i10, j11);
        g0.c();
        this.f53069m1 = SystemClock.elapsedRealtime() * 1000;
        this.K0.f54856e++;
        this.f53066j1 = 0;
        H1();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean S0(long j10, long j11, @Nullable com.google.android.exoplayer2.mediacodec.b bVar, @Nullable ByteBuffer byteBuffer, int i10, int i11, int i12, long j12, boolean z10, boolean z11, Format format) throws ExoPlaybackException {
        long j13;
        boolean z12;
        com.google.android.exoplayer2.util.a.e(bVar);
        if (this.f53062f1 == -9223372036854775807L) {
            this.f53062f1 = j10;
        }
        if (j12 != this.f53068l1) {
            this.Q0.j(j12);
            this.f53068l1 = j12;
        }
        long w02 = w0();
        long j14 = j12 - w02;
        if (z10 && !z11) {
            Z1(bVar, i10, j14);
            return true;
        }
        double x02 = x0();
        boolean z13 = getState() == 2;
        long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        long j15 = (long) ((j12 - j10) / x02);
        if (z13) {
            j15 -= elapsedRealtime - j11;
        }
        if (this.Y0 == this.Z0) {
            if (!D1(j15)) {
                return false;
            }
            Z1(bVar, i10, j14);
            b2(j15);
            return true;
        }
        long j16 = elapsedRealtime - this.f53069m1;
        if (this.f53061e1 ? this.f53059c1 : !(z13 || this.f53060d1)) {
            j13 = j16;
            z12 = false;
        } else {
            j13 = j16;
            z12 = true;
        }
        if (this.f53063g1 == -9223372036854775807L && j10 >= w02 && (z12 || (z13 && X1(j15, j13)))) {
            long nanoTime = System.nanoTime();
            M1(j14, nanoTime, format);
            if (j0.f22990a >= 21) {
                Q1(bVar, i10, j14, nanoTime);
            } else {
                P1(bVar, i10, j14);
            }
            b2(j15);
            return true;
        }
        if (z13 && j10 != this.f53062f1) {
            long nanoTime2 = System.nanoTime();
            long b4 = this.Q0.b((j15 * 1000) + nanoTime2);
            long j17 = (b4 - nanoTime2) / 1000;
            boolean z14 = this.f53063g1 != -9223372036854775807L;
            if (V1(j17, j11, z11) && F1(j10, z14)) {
                return false;
            }
            if (W1(j17, j11, z11)) {
                if (z14) {
                    Z1(bVar, i10, j14);
                } else {
                    v1(bVar, i10, j14);
                }
                b2(j17);
                return true;
            }
            if (j0.f22990a >= 21) {
                if (j17 < 50000) {
                    M1(j14, b4, format);
                    Q1(bVar, i10, j14, b4);
                    b2(j17);
                    return true;
                }
            } else if (j17 < 30000) {
                if (j17 > 11000) {
                    try {
                        Thread.sleep((j17 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        return false;
                    }
                }
                M1(j14, b4, format);
                P1(bVar, i10, j14);
                b2(j17);
                return true;
            }
        }
        return false;
    }

    public final void S1() {
        this.f53063g1 = this.S0 > 0 ? SystemClock.elapsedRealtime() + this.S0 : -9223372036854775807L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, q6.e, com.google.android.exoplayer2.f] */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.view.Surface] */
    public final void T1(@Nullable Object obj) throws ExoPlaybackException {
        DummySurface dummySurface = obj instanceof Surface ? (Surface) obj : null;
        if (dummySurface == null) {
            DummySurface dummySurface2 = this.Z0;
            if (dummySurface2 != null) {
                dummySurface = dummySurface2;
            } else {
                com.google.android.exoplayer2.mediacodec.c p02 = p0();
                if (p02 != null && Y1(p02)) {
                    dummySurface = DummySurface.c(this.P0, p02.f20838g);
                    this.Z0 = dummySurface;
                }
            }
        }
        if (this.Y0 != dummySurface) {
            this.Y0 = dummySurface;
            this.Q0.o(dummySurface);
            this.f53057a1 = false;
            int state = getState();
            com.google.android.exoplayer2.mediacodec.b o02 = o0();
            if (o02 != null) {
                if (j0.f22990a >= 23 && dummySurface != null && !this.W0) {
                    U1(o02, dummySurface);
                } else {
                    W0();
                    G0();
                }
            }
            if (dummySurface != null && dummySurface != this.Z0) {
                L1();
                q1();
                if (state == 2) {
                    S1();
                    return;
                }
                return;
            }
            r1();
            q1();
            return;
        }
        if (dummySurface == null || dummySurface == this.Z0) {
            return;
        }
        L1();
        K1();
    }

    @RequiresApi(23)
    public void U1(com.google.android.exoplayer2.mediacodec.b bVar, Surface surface) {
        bVar.i(surface);
    }

    public boolean V1(long j10, long j11, boolean z10) {
        return E1(j10) && !z10;
    }

    public boolean W1(long j10, long j11, boolean z10) {
        return D1(j10) && !z10;
    }

    public boolean X1(long j10, long j11) {
        return D1(j10) && j11 > 100000;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void Y0() {
        super.Y0();
        this.f53067k1 = 0;
    }

    public final boolean Y1(com.google.android.exoplayer2.mediacodec.c cVar) {
        return j0.f22990a >= 23 && !this.f53077u1 && !s1(cVar.f20832a) && (!cVar.f20838g || DummySurface.b(this.P0));
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public MediaCodecDecoderException Z(Throwable th, @Nullable com.google.android.exoplayer2.mediacodec.c cVar) {
        return new MediaCodecVideoDecoderException(th, cVar, this.Y0);
    }

    public void Z1(com.google.android.exoplayer2.mediacodec.b bVar, int i10, long j10) {
        g0.a("skipVideoBuffer");
        bVar.f(i10, false);
        g0.c();
        this.K0.f54857f++;
    }

    public void a2(int i10) {
        z4.d dVar = this.K0;
        dVar.f54858g += i10;
        this.f53065i1 += i10;
        int i11 = this.f53066j1 + i10;
        this.f53066j1 = i11;
        dVar.f54859h = Math.max(i11, dVar.f54859h);
        int i12 = this.T0;
        if (i12 <= 0 || this.f53065i1 < i12) {
            return;
        }
        G1();
    }

    public void b2(long j10) {
        this.K0.a(j10);
        this.f53070n1 += j10;
        this.f53071o1++;
    }

    @Override // com.google.android.exoplayer2.l1, com.google.android.exoplayer2.n1
    public String getName() {
        return "MediaCodecVideoRenderer";
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean h1(com.google.android.exoplayer2.mediacodec.c cVar) {
        return this.Y0 != null || Y1(cVar);
    }

    @Override // com.google.android.exoplayer2.f, com.google.android.exoplayer2.PlayerMessage.Target
    public void i(int i10, @Nullable Object obj) throws ExoPlaybackException {
        if (i10 == 1) {
            T1(obj);
            return;
        }
        if (i10 == 4) {
            this.f53058b1 = ((Integer) obj).intValue();
            com.google.android.exoplayer2.mediacodec.b o02 = o0();
            if (o02 != null) {
                o02.a(this.f53058b1);
                return;
            }
            return;
        }
        if (i10 == 6) {
            this.f53080x1 = (h) obj;
            return;
        }
        if (i10 != 102) {
            super.i(i10, obj);
            return;
        }
        int intValue = ((Integer) obj).intValue();
        if (this.f53078v1 != intValue) {
            this.f53078v1 = intValue;
            if (this.f53077u1) {
                W0();
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.l1
    public boolean isReady() {
        DummySurface dummySurface;
        if (super.isReady() && (this.f53059c1 || (((dummySurface = this.Z0) != null && this.Y0 == dummySurface) || o0() == null || this.f53077u1))) {
            this.f53063g1 = -9223372036854775807L;
            return true;
        }
        if (this.f53063g1 == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.f53063g1) {
            return true;
        }
        this.f53063g1 = -9223372036854775807L;
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int j1(com.google.android.exoplayer2.mediacodec.d dVar, Format format) throws MediaCodecUtil.DecoderQueryException {
        int i10 = 0;
        if (!com.google.android.exoplayer2.util.q.s(format.f19544m)) {
            return m1.a(0);
        }
        boolean z10 = format.f19547p != null;
        List<com.google.android.exoplayer2.mediacodec.c> A12 = A1(dVar, format, z10, false);
        if (z10 && A12.isEmpty()) {
            A12 = A1(dVar, format, false, false);
        }
        if (A12.isEmpty()) {
            return m1.a(1);
        }
        if (!MediaCodecRenderer.k1(format)) {
            return m1.a(2);
        }
        com.google.android.exoplayer2.mediacodec.c cVar = A12.get(0);
        boolean m10 = cVar.m(format);
        int i11 = cVar.o(format) ? 16 : 8;
        if (m10) {
            List<com.google.android.exoplayer2.mediacodec.c> A13 = A1(dVar, format, z10, true);
            if (!A13.isEmpty()) {
                com.google.android.exoplayer2.mediacodec.c cVar2 = A13.get(0);
                if (cVar2.m(format) && cVar2.o(format)) {
                    i10 = 32;
                }
            }
        }
        return m1.b(m10 ? 4 : 3, i11, i10);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean q0() {
        return this.f53077u1 && j0.f22990a < 23;
    }

    public final void q1() {
        com.google.android.exoplayer2.mediacodec.b o02;
        this.f53059c1 = false;
        if (j0.f22990a < 23 || !this.f53077u1 || (o02 = o0()) == null) {
            return;
        }
        this.f53079w1 = new b(o02);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public float r0(float f10, Format format, Format[] formatArr) {
        float f11 = -1.0f;
        for (Format format2 : formatArr) {
            float f12 = format2.f19551t;
            if (f12 != -1.0f) {
                f11 = Math.max(f11, f12);
            }
        }
        if (f11 == -1.0f) {
            return -1.0f;
        }
        return f11 * f10;
    }

    public final void r1() {
        this.f53076t1 = null;
    }

    public boolean s1(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (e.class) {
            if (!z1) {
                A1 = w1();
                z1 = true;
            }
        }
        return A1;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public List<com.google.android.exoplayer2.mediacodec.c> t0(com.google.android.exoplayer2.mediacodec.d dVar, Format format, boolean z10) throws MediaCodecUtil.DecoderQueryException {
        return A1(dVar, format, z10, this.f53077u1);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.f, com.google.android.exoplayer2.l1
    public void u(float f10, float f11) throws ExoPlaybackException {
        super.u(f10, f11);
        this.Q0.k(f10);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public b.a v0(com.google.android.exoplayer2.mediacodec.c cVar, Format format, @Nullable MediaCrypto mediaCrypto, float f10) {
        DummySurface dummySurface = this.Z0;
        if (dummySurface != null && dummySurface.f23048b != cVar.f20838g) {
            dummySurface.release();
            this.Z0 = null;
        }
        String str = cVar.f20834c;
        a z12 = z1(cVar, format, C());
        this.V0 = z12;
        MediaFormat C1 = C1(format, str, z12, f10, this.U0, this.f53077u1 ? this.f53078v1 : 0);
        if (this.Y0 == null) {
            if (Y1(cVar)) {
                if (this.Z0 == null) {
                    this.Z0 = DummySurface.c(this.P0, cVar.f20838g);
                }
                this.Y0 = this.Z0;
            } else {
                throw new IllegalStateException();
            }
        }
        return new b.a(cVar, C1, format, this.Y0, mediaCrypto, 0);
    }

    public void v1(com.google.android.exoplayer2.mediacodec.b bVar, int i10, long j10) {
        g0.a("dropVideoBuffer");
        bVar.f(i10, false);
        g0.c();
        a2(1);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void y0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (this.X0) {
            ByteBuffer byteBuffer = (ByteBuffer) com.google.android.exoplayer2.util.a.e(decoderInputBuffer.f19885g);
            if (byteBuffer.remaining() >= 7) {
                byte b4 = byteBuffer.get();
                short s2 = byteBuffer.getShort();
                short s10 = byteBuffer.getShort();
                byte b10 = byteBuffer.get();
                byte b11 = byteBuffer.get();
                byteBuffer.position(0);
                if (b4 == -75 && s2 == 60 && s10 == 1 && b10 == 4 && b11 == 0) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    R1(o0(), bArr);
                }
            }
        }
    }

    public a z1(com.google.android.exoplayer2.mediacodec.c cVar, Format format, Format[] formatArr) {
        int x12;
        int i10 = format.f19549r;
        int i11 = format.f19550s;
        int B1 = B1(cVar, format);
        if (formatArr.length == 1) {
            if (B1 != -1 && (x12 = x1(cVar, format)) != -1) {
                B1 = Math.min((int) (B1 * 1.5f), x12);
            }
            return new a(i10, i11, B1);
        }
        int length = formatArr.length;
        boolean z10 = false;
        for (int i12 = 0; i12 < length; i12++) {
            Format format2 = formatArr[i12];
            if (format.f19556y != null && format2.f19556y == null) {
                format2 = format2.a().J(format.f19556y).E();
            }
            if (cVar.e(format, format2).f19891d != 0) {
                int i13 = format2.f19549r;
                z10 |= i13 == -1 || format2.f19550s == -1;
                i10 = Math.max(i10, i13);
                i11 = Math.max(i11, format2.f19550s);
                B1 = Math.max(B1, B1(cVar, format2));
            }
        }
        if (z10) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Resolutions unknown. Codec max resolution: ");
            sb2.append(i10);
            sb2.append(LanguageTag.PRIVATEUSE);
            sb2.append(i11);
            com.google.android.exoplayer2.util.m.h("MediaCodecVideoRenderer", sb2.toString());
            Point y12 = y1(cVar, format);
            if (y12 != null) {
                i10 = Math.max(i10, y12.x);
                i11 = Math.max(i11, y12.y);
                B1 = Math.max(B1, x1(cVar, format.a().j0(i10).Q(i11).E()));
                StringBuilder sb3 = new StringBuilder(57);
                sb3.append("Codec max resolution adjusted to: ");
                sb3.append(i10);
                sb3.append(LanguageTag.PRIVATEUSE);
                sb3.append(i11);
                com.google.android.exoplayer2.util.m.h("MediaCodecVideoRenderer", sb3.toString());
            }
        }
        return new a(i10, i11, B1);
    }

    public e(Context context, b.InterfaceC0191b interfaceC0191b, com.google.android.exoplayer2.mediacodec.d dVar, long j10, boolean z10, @Nullable Handler handler, @Nullable x xVar, int i10) {
        super(2, interfaceC0191b, dVar, z10, 30.0f);
        this.S0 = j10;
        this.T0 = i10;
        Context applicationContext = context.getApplicationContext();
        this.P0 = applicationContext;
        this.Q0 = new j(applicationContext);
        this.R0 = new x.a(handler, xVar);
        this.U0 = u1();
        this.f53063g1 = -9223372036854775807L;
        this.f53072p1 = -1;
        this.f53073q1 = -1;
        this.f53075s1 = -1.0f;
        this.f53058b1 = 1;
        this.f53078v1 = 0;
        r1();
    }
}
