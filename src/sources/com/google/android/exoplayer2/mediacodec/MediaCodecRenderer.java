package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.CallSuper;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b5.j;
import b5.v;
import b5.w;
import com.android.internal.midi.MidiConstants;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.a;
import com.google.android.exoplayer2.mediacodec.b;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.e0;
import com.google.android.exoplayer2.util.g0;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.m;
import java.io.ObjectStreamConstants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import m5.h;
import m5.i;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class MediaCodecRenderer extends f {
    public static final byte[] O0 = {0, 0, 1, 103, 66, -64, 11, -38, 37, MidiConstants.STATUS_NOTE_ON, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, ObjectStreamConstants.TC_REFERENCE, 24, MidiConstants.STATUS_POLYPHONIC_AFTERTOUCH, 0, 47, -65, 28, 49, -61, 39, 93, ObjectStreamConstants.TC_ENDBLOCKDATA};
    public final long[] A;

    @Nullable
    public Format B;

    @Nullable
    public Format C;

    @Nullable
    public DrmSession D;

    @Nullable
    public DrmSession E;

    @Nullable
    public MediaCrypto F;
    public boolean F0;
    public boolean G;
    public boolean G0;
    public long H;
    public boolean H0;
    public float I;
    public boolean I0;
    public float J;

    @Nullable
    public ExoPlaybackException J0;

    @Nullable
    public b K;
    public z4.d K0;

    @Nullable
    public Format L;
    public long L0;

    @Nullable
    public MediaFormat M;
    public long M0;
    public boolean N;
    public int N0;
    public float O;

    @Nullable
    public ArrayDeque<c> P;

    @Nullable
    public DecoderInitializationException Q;

    @Nullable
    public c R;
    public int S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f20769a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f20770b0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f20771c0;

    /* renamed from: d0, reason: collision with root package name */
    @Nullable
    public i f20772d0;

    /* renamed from: e0, reason: collision with root package name */
    public long f20773e0;

    /* renamed from: f0, reason: collision with root package name */
    public int f20774f0;

    /* renamed from: g0, reason: collision with root package name */
    public int f20775g0;

    /* renamed from: h0, reason: collision with root package name */
    @Nullable
    public ByteBuffer f20776h0;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f20777i0;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f20778j0;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f20779k0;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f20780l0;

    /* renamed from: m0, reason: collision with root package name */
    public boolean f20781m0;

    /* renamed from: n, reason: collision with root package name */
    public final b.InterfaceC0191b f20782n;

    /* renamed from: n0, reason: collision with root package name */
    public boolean f20783n0;

    /* renamed from: o, reason: collision with root package name */
    public final d f20784o;

    /* renamed from: o0, reason: collision with root package name */
    public int f20785o0;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f20786p;

    /* renamed from: p0, reason: collision with root package name */
    public int f20787p0;

    /* renamed from: q, reason: collision with root package name */
    public final float f20788q;

    /* renamed from: q0, reason: collision with root package name */
    public int f20789q0;

    /* renamed from: r, reason: collision with root package name */
    public final DecoderInputBuffer f20790r;

    /* renamed from: r0, reason: collision with root package name */
    public boolean f20791r0;

    /* renamed from: s, reason: collision with root package name */
    public final DecoderInputBuffer f20792s;

    /* renamed from: s0, reason: collision with root package name */
    public boolean f20793s0;

    /* renamed from: t, reason: collision with root package name */
    public final DecoderInputBuffer f20794t;

    /* renamed from: t0, reason: collision with root package name */
    public boolean f20795t0;

    /* renamed from: u, reason: collision with root package name */
    public final h f20796u;

    /* renamed from: u0, reason: collision with root package name */
    public long f20797u0;

    /* renamed from: v, reason: collision with root package name */
    public final e0<Format> f20798v;

    /* renamed from: v0, reason: collision with root package name */
    public long f20799v0;

    /* renamed from: w, reason: collision with root package name */
    public final ArrayList<Long> f20800w;

    /* renamed from: w0, reason: collision with root package name */
    public boolean f20801w0;

    /* renamed from: x, reason: collision with root package name */
    public final MediaCodec.BufferInfo f20802x;

    /* renamed from: x0, reason: collision with root package name */
    public boolean f20803x0;

    /* renamed from: y, reason: collision with root package name */
    public final long[] f20804y;

    /* renamed from: y0, reason: collision with root package name */
    public boolean f20805y0;

    /* renamed from: z, reason: collision with root package name */
    public final long[] f20806z;

    public MediaCodecRenderer(int i10, b.InterfaceC0191b interfaceC0191b, d dVar, boolean z10, float f10) {
        super(i10);
        this.f20782n = interfaceC0191b;
        this.f20784o = (d) com.google.android.exoplayer2.util.a.e(dVar);
        this.f20786p = z10;
        this.f20788q = f10;
        this.f20790r = DecoderInputBuffer.t();
        this.f20792s = new DecoderInputBuffer(0);
        this.f20794t = new DecoderInputBuffer(2);
        h hVar = new h();
        this.f20796u = hVar;
        this.f20798v = new e0<>();
        this.f20800w = new ArrayList<>();
        this.f20802x = new MediaCodec.BufferInfo();
        this.I = 1.0f;
        this.J = 1.0f;
        this.H = -9223372036854775807L;
        this.f20804y = new long[10];
        this.f20806z = new long[10];
        this.A = new long[10];
        this.L0 = -9223372036854775807L;
        this.M0 = -9223372036854775807L;
        hVar.q(0);
        hVar.f19882d.order(ByteOrder.nativeOrder());
        this.O = -1.0f;
        this.S = 0;
        this.f20785o0 = 0;
        this.f20774f0 = -1;
        this.f20775g0 = -1;
        this.f20773e0 = -9223372036854775807L;
        this.f20797u0 = -9223372036854775807L;
        this.f20799v0 = -9223372036854775807L;
        this.f20787p0 = 0;
        this.f20789q0 = 0;
    }

    public static boolean D0(IllegalStateException illegalStateException) {
        if (j0.f22990a >= 21 && E0(illegalStateException)) {
            return true;
        }
        StackTraceElement[] stackTrace = illegalStateException.getStackTrace();
        return stackTrace.length > 0 && stackTrace[0].getClassName().equals("android.media.MediaCodec");
    }

    @RequiresApi(21)
    public static boolean E0(IllegalStateException illegalStateException) {
        return illegalStateException instanceof MediaCodec.CodecException;
    }

    @RequiresApi(21)
    public static boolean F0(IllegalStateException illegalStateException) {
        if (illegalStateException instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) illegalStateException).isRecoverable();
        }
        return false;
    }

    public static boolean R(String str, Format format) {
        return j0.f22990a < 21 && format.f19546o.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    public static boolean S(String str) {
        if (j0.f22990a < 21 && "OMX.SEC.mp3.dec".equals(str) && "samsung".equals(j0.f22992c)) {
            String str2 = j0.f22991b;
            if (str2.startsWith("baffin") || str2.startsWith("grand") || str2.startsWith("fortuna") || str2.startsWith("gprimelte") || str2.startsWith("j2y18lte") || str2.startsWith("ms01")) {
                return true;
            }
        }
        return false;
    }

    public static boolean T(String str) {
        int i10 = j0.f22990a;
        if (i10 > 23 || !"OMX.google.vorbis.decoder".equals(str)) {
            if (i10 <= 19) {
                String str2 = j0.f22991b;
                if (("hb2000".equals(str2) || "stvm8".equals(str2)) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str))) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean U(String str) {
        return j0.f22990a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    public static boolean V(c cVar) {
        String str = cVar.f20832a;
        int i10 = j0.f22990a;
        return (i10 <= 25 && "OMX.rk.video_decoder.avc".equals(str)) || (i10 <= 17 && "OMX.allwinner.video.decoder.avc".equals(str)) || ((i10 <= 29 && ("OMX.broadcom.video_decoder.tunnel".equals(str) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str))) || ("Amazon".equals(j0.f22992c) && "AFTS".equals(j0.f22993d) && cVar.f20838g));
    }

    public static boolean W(String str) {
        int i10 = j0.f22990a;
        return i10 < 18 || (i10 == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (i10 == 19 && j0.f22993d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    public static boolean X(String str, Format format) {
        return j0.f22990a <= 18 && format.f19557z == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }

    public static boolean Y(String str) {
        return j0.f22990a == 29 && "c2.android.aac.decoder".equals(str);
    }

    public static boolean k1(Format format) {
        Class<? extends v> cls = format.F;
        return cls == null || w.class.equals(cls);
    }

    public final void A0(Format format) {
        a0();
        String str = format.f19544m;
        if (!"audio/mp4a-latm".equals(str) && !"audio/mpeg".equals(str) && !"audio/opus".equals(str)) {
            this.f20796u.B(1);
        } else {
            this.f20796u.B(32);
        }
        this.f20779k0 = true;
    }

    public final void B0(c cVar, MediaCrypto mediaCrypto) throws Exception {
        b a10;
        String str = cVar.f20832a;
        int i10 = j0.f22990a;
        float r02 = i10 < 23 ? -1.0f : r0(this.J, this.B, C());
        float f10 = r02 > this.f20788q ? r02 : -1.0f;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String valueOf = String.valueOf(str);
        g0.a(valueOf.length() != 0 ? "createCodec:".concat(valueOf) : new String("createCodec:"));
        b.a v02 = v0(cVar, this.B, mediaCrypto, f10);
        if (this.G0 && i10 >= 23) {
            a10 = new a.b(g(), this.H0, this.I0).a(v02);
        } else {
            a10 = this.f20782n.a(v02);
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        this.K = a10;
        this.R = cVar;
        this.O = f10;
        this.L = this.B;
        this.S = Q(str);
        this.T = R(str, this.L);
        this.U = W(str);
        this.V = Y(str);
        this.W = T(str);
        this.X = U(str);
        this.Y = S(str);
        this.Z = X(str, this.L);
        this.f20771c0 = V(cVar) || q0();
        if (a10.b()) {
            this.f20783n0 = true;
            this.f20785o0 = 1;
            this.f20769a0 = this.S != 0;
        }
        if ("c2.android.mp3.decoder".equals(cVar.f20832a)) {
            this.f20772d0 = new i();
        }
        if (getState() == 2) {
            this.f20773e0 = SystemClock.elapsedRealtime() + 1000;
        }
        this.K0.f54852a++;
        K0(str, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
    }

    public final boolean C0(long j10) {
        int size = this.f20800w.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f20800w.get(i10).longValue() == j10) {
                this.f20800w.remove(i10);
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.f
    public void E() {
        this.B = null;
        this.L0 = -9223372036854775807L;
        this.M0 = -9223372036854775807L;
        this.N0 = 0;
        m0();
    }

    @Override // com.google.android.exoplayer2.f
    public void F(boolean z10, boolean z11) throws ExoPlaybackException {
        this.K0 = new z4.d();
    }

    @Override // com.google.android.exoplayer2.f
    public void G(long j10, boolean z10) throws ExoPlaybackException {
        this.f20801w0 = false;
        this.f20803x0 = false;
        this.F0 = false;
        if (this.f20779k0) {
            this.f20796u.h();
            this.f20794t.h();
            this.f20780l0 = false;
        } else {
            l0();
        }
        if (this.f20798v.l() > 0) {
            this.f20805y0 = true;
        }
        this.f20798v.c();
        int i10 = this.N0;
        if (i10 != 0) {
            this.M0 = this.f20806z[i10 - 1];
            this.L0 = this.f20804y[i10 - 1];
            this.N0 = 0;
        }
    }

    public final void G0() throws ExoPlaybackException {
        Format format;
        if (this.K != null || this.f20779k0 || (format = this.B) == null) {
            return;
        }
        if (this.E == null && i1(format)) {
            A0(this.B);
            return;
        }
        c1(this.E);
        String str = this.B.f19544m;
        DrmSession drmSession = this.D;
        if (drmSession != null) {
            if (this.F == null) {
                w u02 = u0(drmSession);
                if (u02 == null) {
                    if (this.D.getError() == null) {
                        return;
                    }
                } else {
                    try {
                        MediaCrypto mediaCrypto = new MediaCrypto(u02.f1265a, u02.f1266b);
                        this.F = mediaCrypto;
                        this.G = !u02.f1267c && mediaCrypto.requiresSecureDecoderComponent(str);
                    } catch (MediaCryptoException e2) {
                        throw x(e2, this.B, 6006);
                    }
                }
            }
            if (w.f1264d) {
                int state = this.D.getState();
                if (state == 1) {
                    DrmSession.DrmSessionException drmSessionException = (DrmSession.DrmSessionException) com.google.android.exoplayer2.util.a.e(this.D.getError());
                    throw x(drmSessionException, this.B, drmSessionException.errorCode);
                }
                if (state != 4) {
                    return;
                }
            }
        }
        try {
            H0(this.F, this.G);
        } catch (DecoderInitializationException e10) {
            throw x(e10, this.B, 4001);
        }
    }

    @Override // com.google.android.exoplayer2.f
    public void H() {
        try {
            a0();
            W0();
        } finally {
            f1(null);
        }
    }

    public final void H0(MediaCrypto mediaCrypto, boolean z10) throws DecoderInitializationException {
        if (this.P == null) {
            try {
                List<c> n02 = n0(z10);
                ArrayDeque<c> arrayDeque = new ArrayDeque<>();
                this.P = arrayDeque;
                if (this.f20786p) {
                    arrayDeque.addAll(n02);
                } else if (!n02.isEmpty()) {
                    this.P.add(n02.get(0));
                }
                this.Q = null;
            } catch (MediaCodecUtil.DecoderQueryException e2) {
                throw new DecoderInitializationException(this.B, e2, z10, -49998);
            }
        }
        if (!this.P.isEmpty()) {
            while (this.K == null) {
                c peekFirst = this.P.peekFirst();
                if (!h1(peekFirst)) {
                    return;
                }
                try {
                    B0(peekFirst, mediaCrypto);
                } catch (Exception e10) {
                    String valueOf = String.valueOf(peekFirst);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 30);
                    sb2.append("Failed to initialize decoder: ");
                    sb2.append(valueOf);
                    m.i("MediaCodecRenderer", sb2.toString(), e10);
                    this.P.removeFirst();
                    DecoderInitializationException decoderInitializationException = new DecoderInitializationException(this.B, e10, z10, peekFirst);
                    J0(decoderInitializationException);
                    if (this.Q == null) {
                        this.Q = decoderInitializationException;
                    } else {
                        this.Q = this.Q.copyWithFallbackException(decoderInitializationException);
                    }
                    if (this.P.isEmpty()) {
                        throw this.Q;
                    }
                }
            }
            this.P = null;
            return;
        }
        throw new DecoderInitializationException(this.B, (Throwable) null, z10, -49999);
    }

    @Override // com.google.android.exoplayer2.f
    public void I() {
    }

    public final boolean I0(w wVar, Format format) {
        if (wVar.f1267c) {
            return false;
        }
        try {
            MediaCrypto mediaCrypto = new MediaCrypto(wVar.f1265a, wVar.f1266b);
            try {
                return mediaCrypto.requiresSecureDecoderComponent(format.f19544m);
            } finally {
                mediaCrypto.release();
            }
        } catch (MediaCryptoException unused) {
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.f
    public void J() {
    }

    public abstract void J0(Exception exc);

    @Override // com.google.android.exoplayer2.f
    public void K(Format[] formatArr, long j10, long j11) throws ExoPlaybackException {
        if (this.M0 == -9223372036854775807L) {
            com.google.android.exoplayer2.util.a.g(this.L0 == -9223372036854775807L);
            this.L0 = j10;
            this.M0 = j11;
            return;
        }
        int i10 = this.N0;
        long[] jArr = this.f20806z;
        if (i10 == jArr.length) {
            long j12 = jArr[i10 - 1];
            StringBuilder sb2 = new StringBuilder(65);
            sb2.append("Too many stream changes, so dropping offset: ");
            sb2.append(j12);
            m.h("MediaCodecRenderer", sb2.toString());
        } else {
            this.N0 = i10 + 1;
        }
        long[] jArr2 = this.f20804y;
        int i11 = this.N0;
        jArr2[i11 - 1] = j10;
        this.f20806z[i11 - 1] = j11;
        this.A[i11 - 1] = this.f20797u0;
    }

    public abstract void K0(String str, long j10, long j11);

    public abstract void L0(String str);

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0080, code lost:
    
        if (d0() == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00cf, code lost:
    
        r7 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00b2, code lost:
    
        if (d0() == false) goto L68;
     */
    @androidx.annotation.Nullable
    @androidx.annotation.CallSuper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.android.exoplayer2.decoder.DecoderReuseEvaluation M0(com.google.android.exoplayer2.s0 r12) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.M0(com.google.android.exoplayer2.s0):com.google.android.exoplayer2.decoder.DecoderReuseEvaluation");
    }

    public final void N() throws ExoPlaybackException {
        com.google.android.exoplayer2.util.a.g(!this.f20801w0);
        s0 A = A();
        this.f20794t.h();
        do {
            this.f20794t.h();
            int L = L(A, this.f20794t, 0);
            if (L == -5) {
                M0(A);
                return;
            }
            if (L != -4) {
                if (L != -3) {
                    throw new IllegalStateException();
                }
                return;
            } else {
                if (this.f20794t.m()) {
                    this.f20801w0 = true;
                    return;
                }
                if (this.f20805y0) {
                    Format format = (Format) com.google.android.exoplayer2.util.a.e(this.B);
                    this.C = format;
                    N0(format, null);
                    this.f20805y0 = false;
                }
                this.f20794t.r();
            }
        } while (this.f20796u.v(this.f20794t));
        this.f20780l0 = true;
    }

    public abstract void N0(Format format, @Nullable MediaFormat mediaFormat) throws ExoPlaybackException;

    public final boolean O(long j10, long j11) throws ExoPlaybackException {
        com.google.android.exoplayer2.util.a.g(!this.f20803x0);
        if (this.f20796u.A()) {
            h hVar = this.f20796u;
            if (!S0(j10, j11, null, hVar.f19882d, this.f20775g0, 0, hVar.z(), this.f20796u.x(), this.f20796u.l(), this.f20796u.m(), this.C)) {
                return false;
            }
            O0(this.f20796u.y());
            this.f20796u.h();
        }
        if (this.f20801w0) {
            this.f20803x0 = true;
            return false;
        }
        if (this.f20780l0) {
            com.google.android.exoplayer2.util.a.g(this.f20796u.v(this.f20794t));
            this.f20780l0 = false;
        }
        if (this.f20781m0) {
            if (this.f20796u.A()) {
                return true;
            }
            a0();
            this.f20781m0 = false;
            G0();
            if (!this.f20779k0) {
                return false;
            }
        }
        N();
        if (this.f20796u.A()) {
            this.f20796u.r();
        }
        return this.f20796u.A() || this.f20801w0 || this.f20781m0;
    }

    @CallSuper
    public void O0(long j10) {
        while (true) {
            int i10 = this.N0;
            if (i10 == 0 || j10 < this.A[0]) {
                return;
            }
            long[] jArr = this.f20804y;
            this.L0 = jArr[0];
            this.M0 = this.f20806z[0];
            int i11 = i10 - 1;
            this.N0 = i11;
            System.arraycopy((Object) jArr, 1, (Object) jArr, 0, i11);
            long[] jArr2 = this.f20806z;
            System.arraycopy((Object) jArr2, 1, (Object) jArr2, 0, this.N0);
            long[] jArr3 = this.A;
            System.arraycopy((Object) jArr3, 1, (Object) jArr3, 0, this.N0);
            P0();
        }
    }

    public abstract DecoderReuseEvaluation P(c cVar, Format format, Format format2);

    public void P0() {
    }

    public final int Q(String str) {
        int i10 = j0.f22990a;
        if (i10 <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
            String str2 = j0.f22993d;
            if (str2.startsWith("SM-T585") || str2.startsWith("SM-A510") || str2.startsWith("SM-A520") || str2.startsWith("SM-J700")) {
                return 2;
            }
        }
        if (i10 >= 24) {
            return 0;
        }
        if (!"OMX.Nvidia.h264.decode".equals(str) && !"OMX.Nvidia.h264.decode.secure".equals(str)) {
            return 0;
        }
        String str3 = j0.f22991b;
        return ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) ? 1 : 0;
    }

    public abstract void Q0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException;

    public final void R0() throws ExoPlaybackException {
        int i10 = this.f20789q0;
        if (i10 == 1) {
            k0();
            return;
        }
        if (i10 == 2) {
            k0();
            m1();
        } else if (i10 != 3) {
            this.f20803x0 = true;
            X0();
        } else {
            V0();
        }
    }

    public abstract boolean S0(long j10, long j11, @Nullable b bVar, @Nullable ByteBuffer byteBuffer, int i10, int i11, int i12, long j12, boolean z10, boolean z11, Format format) throws ExoPlaybackException;

    public final void T0() {
        this.f20795t0 = true;
        MediaFormat g3 = this.K.g();
        if (this.S != 0 && g3.getInteger("width") == 32 && g3.getInteger("height") == 32) {
            this.f20770b0 = true;
            return;
        }
        if (this.Z) {
            g3.setInteger("channel-count", 1);
        }
        this.M = g3;
        this.N = true;
    }

    public final boolean U0(int i10) throws ExoPlaybackException {
        s0 A = A();
        this.f20790r.h();
        int L = L(A, this.f20790r, i10 | 4);
        if (L == -5) {
            M0(A);
            return true;
        }
        if (L != -4 || !this.f20790r.m()) {
            return false;
        }
        this.f20801w0 = true;
        R0();
        return false;
    }

    public final void V0() throws ExoPlaybackException {
        W0();
        G0();
    }

    public void W0() {
        try {
            b bVar = this.K;
            if (bVar != null) {
                bVar.release();
                this.K0.f54853b++;
                L0(this.R.f20832a);
            }
            this.K = null;
            try {
                MediaCrypto mediaCrypto = this.F;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
            }
        } catch (Throwable th) {
            this.K = null;
            try {
                MediaCrypto mediaCrypto2 = this.F;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th;
            } finally {
            }
        }
    }

    public void X0() throws ExoPlaybackException {
    }

    @CallSuper
    public void Y0() {
        a1();
        b1();
        this.f20773e0 = -9223372036854775807L;
        this.f20793s0 = false;
        this.f20791r0 = false;
        this.f20769a0 = false;
        this.f20770b0 = false;
        this.f20777i0 = false;
        this.f20778j0 = false;
        this.f20800w.clear();
        this.f20797u0 = -9223372036854775807L;
        this.f20799v0 = -9223372036854775807L;
        i iVar = this.f20772d0;
        if (iVar != null) {
            iVar.c();
        }
        this.f20787p0 = 0;
        this.f20789q0 = 0;
        this.f20785o0 = this.f20783n0 ? 1 : 0;
    }

    public MediaCodecDecoderException Z(Throwable th, @Nullable c cVar) {
        return new MediaCodecDecoderException(th, cVar);
    }

    @CallSuper
    public void Z0() {
        Y0();
        this.J0 = null;
        this.f20772d0 = null;
        this.P = null;
        this.R = null;
        this.L = null;
        this.M = null;
        this.N = false;
        this.f20795t0 = false;
        this.O = -1.0f;
        this.S = 0;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.f20771c0 = false;
        this.f20783n0 = false;
        this.f20785o0 = 0;
        this.G = false;
    }

    @Override // com.google.android.exoplayer2.n1
    public final int a(Format format) throws ExoPlaybackException {
        try {
            return j1(this.f20784o, format);
        } catch (MediaCodecUtil.DecoderQueryException e2) {
            throw x(e2, format, 4002);
        }
    }

    public final void a0() {
        this.f20781m0 = false;
        this.f20796u.h();
        this.f20794t.h();
        this.f20780l0 = false;
        this.f20779k0 = false;
    }

    public final void a1() {
        this.f20774f0 = -1;
        this.f20792s.f19882d = null;
    }

    @Override // com.google.android.exoplayer2.l1
    public boolean b() {
        return this.f20803x0;
    }

    public final boolean b0() {
        if (this.f20791r0) {
            this.f20787p0 = 1;
            if (!this.U && !this.W) {
                this.f20789q0 = 1;
            } else {
                this.f20789q0 = 3;
                return false;
            }
        }
        return true;
    }

    public final void b1() {
        this.f20775g0 = -1;
        this.f20776h0 = null;
    }

    public final void c0() throws ExoPlaybackException {
        if (this.f20791r0) {
            this.f20787p0 = 1;
            this.f20789q0 = 3;
        } else {
            V0();
        }
    }

    public final void c1(@Nullable DrmSession drmSession) {
        j.a(this.D, drmSession);
        this.D = drmSession;
    }

    public final boolean d0() throws ExoPlaybackException {
        if (this.f20791r0) {
            this.f20787p0 = 1;
            if (!this.U && !this.W) {
                this.f20789q0 = 2;
            } else {
                this.f20789q0 = 3;
                return false;
            }
        } else {
            m1();
        }
        return true;
    }

    public final void d1() {
        this.F0 = true;
    }

    public final boolean e0(long j10, long j11) throws ExoPlaybackException {
        boolean z10;
        boolean S0;
        b bVar;
        ByteBuffer byteBuffer;
        int i10;
        MediaCodec.BufferInfo bufferInfo;
        int e2;
        if (!z0()) {
            if (this.X && this.f20793s0) {
                try {
                    e2 = this.K.e(this.f20802x);
                } catch (IllegalStateException unused) {
                    R0();
                    if (this.f20803x0) {
                        W0();
                    }
                    return false;
                }
            } else {
                e2 = this.K.e(this.f20802x);
            }
            if (e2 < 0) {
                if (e2 == -2) {
                    T0();
                    return true;
                }
                if (this.f20771c0 && (this.f20801w0 || this.f20787p0 == 2)) {
                    R0();
                }
                return false;
            }
            if (this.f20770b0) {
                this.f20770b0 = false;
                this.K.f(e2, false);
                return true;
            }
            MediaCodec.BufferInfo bufferInfo2 = this.f20802x;
            if (bufferInfo2.size == 0 && (bufferInfo2.flags & 4) != 0) {
                R0();
                return false;
            }
            this.f20775g0 = e2;
            ByteBuffer m10 = this.K.m(e2);
            this.f20776h0 = m10;
            if (m10 != null) {
                m10.position(this.f20802x.offset);
                ByteBuffer byteBuffer2 = this.f20776h0;
                MediaCodec.BufferInfo bufferInfo3 = this.f20802x;
                byteBuffer2.limit(bufferInfo3.offset + bufferInfo3.size);
            }
            if (this.Y) {
                MediaCodec.BufferInfo bufferInfo4 = this.f20802x;
                if (bufferInfo4.presentationTimeUs == 0 && (bufferInfo4.flags & 4) != 0) {
                    long j12 = this.f20797u0;
                    if (j12 != -9223372036854775807L) {
                        bufferInfo4.presentationTimeUs = j12;
                    }
                }
            }
            this.f20777i0 = C0(this.f20802x.presentationTimeUs);
            long j13 = this.f20799v0;
            long j14 = this.f20802x.presentationTimeUs;
            this.f20778j0 = j13 == j14;
            n1(j14);
        }
        if (this.X && this.f20793s0) {
            try {
                bVar = this.K;
                byteBuffer = this.f20776h0;
                i10 = this.f20775g0;
                bufferInfo = this.f20802x;
                z10 = false;
            } catch (IllegalStateException unused2) {
                z10 = false;
            }
            try {
                S0 = S0(j10, j11, bVar, byteBuffer, i10, bufferInfo.flags, 1, bufferInfo.presentationTimeUs, this.f20777i0, this.f20778j0, this.C);
            } catch (IllegalStateException unused3) {
                R0();
                if (this.f20803x0) {
                    W0();
                }
                return z10;
            }
        } else {
            z10 = false;
            b bVar2 = this.K;
            ByteBuffer byteBuffer3 = this.f20776h0;
            int i11 = this.f20775g0;
            MediaCodec.BufferInfo bufferInfo5 = this.f20802x;
            S0 = S0(j10, j11, bVar2, byteBuffer3, i11, bufferInfo5.flags, 1, bufferInfo5.presentationTimeUs, this.f20777i0, this.f20778j0, this.C);
        }
        if (S0) {
            O0(this.f20802x.presentationTimeUs);
            boolean z11 = (this.f20802x.flags & 4) != 0;
            b1();
            if (!z11) {
                return true;
            }
            R0();
        }
        return z10;
    }

    public final void e1(ExoPlaybackException exoPlaybackException) {
        this.J0 = exoPlaybackException;
    }

    public final boolean f0(c cVar, Format format, @Nullable DrmSession drmSession, @Nullable DrmSession drmSession2) throws ExoPlaybackException {
        w u02;
        if (drmSession == drmSession2) {
            return false;
        }
        if (drmSession2 == null || drmSession == null || j0.f22990a < 23) {
            return true;
        }
        UUID uuid = com.google.android.exoplayer2.h.f20708e;
        if (uuid.equals(drmSession.e()) || uuid.equals(drmSession2.e()) || (u02 = u0(drmSession2)) == null) {
            return true;
        }
        return !cVar.f20838g && I0(u02, format);
    }

    public final void f1(@Nullable DrmSession drmSession) {
        j.a(this.E, drmSession);
        this.E = drmSession;
    }

    public void g0(boolean z10) {
        this.G0 = z10;
    }

    public final boolean g1(long j10) {
        return this.H == -9223372036854775807L || SystemClock.elapsedRealtime() - j10 < this.H;
    }

    public void h0(boolean z10) {
        this.H0 = z10;
    }

    public boolean h1(c cVar) {
        return true;
    }

    public void i0(boolean z10) {
        this.I0 = z10;
    }

    public boolean i1(Format format) {
        return false;
    }

    @Override // com.google.android.exoplayer2.l1
    public boolean isReady() {
        return this.B != null && (D() || z0() || (this.f20773e0 != -9223372036854775807L && SystemClock.elapsedRealtime() < this.f20773e0));
    }

    public final boolean j0() throws ExoPlaybackException {
        b bVar = this.K;
        if (bVar == null || this.f20787p0 == 2 || this.f20801w0) {
            return false;
        }
        if (this.f20774f0 < 0) {
            int l10 = bVar.l();
            this.f20774f0 = l10;
            if (l10 < 0) {
                return false;
            }
            this.f20792s.f19882d = this.K.getInputBuffer(l10);
            this.f20792s.h();
        }
        if (this.f20787p0 == 1) {
            if (!this.f20771c0) {
                this.f20793s0 = true;
                this.K.j(this.f20774f0, 0, 0, 0L, 4);
                a1();
            }
            this.f20787p0 = 2;
            return false;
        }
        if (this.f20769a0) {
            this.f20769a0 = false;
            ByteBuffer byteBuffer = this.f20792s.f19882d;
            byte[] bArr = O0;
            byteBuffer.put(bArr);
            this.K.j(this.f20774f0, 0, bArr.length, 0L, 0);
            a1();
            this.f20791r0 = true;
            return true;
        }
        if (this.f20785o0 == 1) {
            for (int i10 = 0; i10 < this.L.f19546o.size(); i10++) {
                this.f20792s.f19882d.put(this.L.f19546o.get(i10));
            }
            this.f20785o0 = 2;
        }
        int position = this.f20792s.f19882d.position();
        s0 A = A();
        try {
            int L = L(A, this.f20792s, 0);
            if (h()) {
                this.f20799v0 = this.f20797u0;
            }
            if (L == -3) {
                return false;
            }
            if (L == -5) {
                if (this.f20785o0 == 2) {
                    this.f20792s.h();
                    this.f20785o0 = 1;
                }
                M0(A);
                return true;
            }
            if (this.f20792s.m()) {
                if (this.f20785o0 == 2) {
                    this.f20792s.h();
                    this.f20785o0 = 1;
                }
                this.f20801w0 = true;
                if (!this.f20791r0) {
                    R0();
                    return false;
                }
                try {
                    if (!this.f20771c0) {
                        this.f20793s0 = true;
                        this.K.j(this.f20774f0, 0, 0, 0L, 4);
                        a1();
                    }
                    return false;
                } catch (MediaCodec.CryptoException e2) {
                    throw x(e2, this.B, com.google.android.exoplayer2.h.b(e2.getErrorCode()));
                }
            }
            if (!this.f20791r0 && !this.f20792s.n()) {
                this.f20792s.h();
                if (this.f20785o0 == 2) {
                    this.f20785o0 = 1;
                }
                return true;
            }
            boolean s2 = this.f20792s.s();
            if (s2) {
                this.f20792s.f19881c.b(position);
            }
            if (this.T && !s2) {
                NalUnitUtil.b(this.f20792s.f19882d);
                if (this.f20792s.f19882d.position() == 0) {
                    return true;
                }
                this.T = false;
            }
            DecoderInputBuffer decoderInputBuffer = this.f20792s;
            long j10 = decoderInputBuffer.f19884f;
            i iVar = this.f20772d0;
            if (iVar != null) {
                j10 = iVar.d(this.B, decoderInputBuffer);
                this.f20797u0 = Math.max(this.f20797u0, this.f20772d0.b(this.B));
            }
            long j11 = j10;
            if (this.f20792s.l()) {
                this.f20800w.add(Long.valueOf(j11));
            }
            if (this.f20805y0) {
                this.f20798v.a(j11, this.B);
                this.f20805y0 = false;
            }
            this.f20797u0 = Math.max(this.f20797u0, j11);
            this.f20792s.r();
            if (this.f20792s.k()) {
                y0(this.f20792s);
            }
            Q0(this.f20792s);
            try {
                if (s2) {
                    this.K.k(this.f20774f0, 0, this.f20792s.f19881c, j11, 0);
                } else {
                    this.K.j(this.f20774f0, 0, this.f20792s.f19882d.limit(), j11, 0);
                }
                a1();
                this.f20791r0 = true;
                this.f20785o0 = 0;
                this.K0.f54854c++;
                return true;
            } catch (MediaCodec.CryptoException e10) {
                throw x(e10, this.B, com.google.android.exoplayer2.h.b(e10.getErrorCode()));
            }
        } catch (DecoderInputBuffer.InsufficientCapacityException e11) {
            J0(e11);
            U0(0);
            k0();
            return true;
        }
    }

    public abstract int j1(d dVar, Format format) throws MediaCodecUtil.DecoderQueryException;

    @Override // com.google.android.exoplayer2.l1
    public void k(long j10, long j11) throws ExoPlaybackException {
        boolean z10 = false;
        if (this.F0) {
            this.F0 = false;
            R0();
        }
        ExoPlaybackException exoPlaybackException = this.J0;
        if (exoPlaybackException == null) {
            try {
                if (this.f20803x0) {
                    X0();
                    return;
                }
                if (this.B != null || U0(2)) {
                    G0();
                    if (this.f20779k0) {
                        g0.a("bypassRender");
                        do {
                        } while (O(j10, j11));
                        g0.c();
                    } else if (this.K != null) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        g0.a("drainAndFeed");
                        while (e0(j10, j11) && g1(elapsedRealtime)) {
                        }
                        while (j0() && g1(elapsedRealtime)) {
                        }
                        g0.c();
                    } else {
                        this.K0.f54855d += M(j10);
                        U0(1);
                    }
                    this.K0.c();
                    return;
                }
                return;
            } catch (IllegalStateException e2) {
                if (D0(e2)) {
                    J0(e2);
                    if (j0.f22990a >= 21 && F0(e2)) {
                        z10 = true;
                    }
                    if (z10) {
                        W0();
                    }
                    throw y(Z(e2, p0()), this.B, z10, 4003);
                }
                throw e2;
            }
        }
        this.J0 = null;
        throw exoPlaybackException;
    }

    public final void k0() {
        try {
            this.K.flush();
        } finally {
            Y0();
        }
    }

    public final boolean l0() throws ExoPlaybackException {
        boolean m02 = m0();
        if (m02) {
            G0();
        }
        return m02;
    }

    public final boolean l1(Format format) throws ExoPlaybackException {
        if (j0.f22990a >= 23 && this.K != null && this.f20789q0 != 3 && getState() != 0) {
            float r02 = r0(this.J, format, C());
            float f10 = this.O;
            if (f10 == r02) {
                return true;
            }
            if (r02 == -1.0f) {
                c0();
                return false;
            }
            if (f10 == -1.0f && r02 <= this.f20788q) {
                return true;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat("operating-rate", r02);
            this.K.c(bundle);
            this.O = r02;
        }
        return true;
    }

    public boolean m0() {
        if (this.K == null) {
            return false;
        }
        if (this.f20789q0 != 3 && !this.U && ((!this.V || this.f20795t0) && (!this.W || !this.f20793s0))) {
            k0();
            return false;
        }
        W0();
        return true;
    }

    @RequiresApi(23)
    public final void m1() throws ExoPlaybackException {
        try {
            this.F.setMediaDrmSession(u0(this.E).f1266b);
            c1(this.E);
            this.f20787p0 = 0;
            this.f20789q0 = 0;
        } catch (MediaCryptoException e2) {
            throw x(e2, this.B, 6006);
        }
    }

    public final List<c> n0(boolean z10) throws MediaCodecUtil.DecoderQueryException {
        List<c> t02 = t0(this.f20784o, this.B, z10);
        if (t02.isEmpty() && z10) {
            t02 = t0(this.f20784o, this.B, false);
            if (!t02.isEmpty()) {
                String str = this.B.f19544m;
                String valueOf = String.valueOf(t02);
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 99 + valueOf.length());
                sb2.append("Drm session requires secure decoder for ");
                sb2.append(str);
                sb2.append(", but no secure decoder available. Trying to proceed with ");
                sb2.append(valueOf);
                sb2.append(".");
                m.h("MediaCodecRenderer", sb2.toString());
            }
        }
        return t02;
    }

    public final void n1(long j10) throws ExoPlaybackException {
        boolean z10;
        Format j11 = this.f20798v.j(j10);
        if (j11 == null && this.N) {
            j11 = this.f20798v.i();
        }
        if (j11 != null) {
            this.C = j11;
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 || (this.N && this.C != null)) {
            N0(this.C, this.M);
            this.N = false;
        }
    }

    @Nullable
    public final b o0() {
        return this.K;
    }

    @Nullable
    public final c p0() {
        return this.R;
    }

    public boolean q0() {
        return false;
    }

    public abstract float r0(float f10, Format format, Format[] formatArr);

    @Nullable
    public final MediaFormat s0() {
        return this.M;
    }

    public abstract List<c> t0(d dVar, Format format, boolean z10) throws MediaCodecUtil.DecoderQueryException;

    @Override // com.google.android.exoplayer2.f, com.google.android.exoplayer2.l1
    public void u(float f10, float f11) throws ExoPlaybackException {
        this.I = f10;
        this.J = f11;
        l1(this.L);
    }

    @Nullable
    public final w u0(DrmSession drmSession) throws ExoPlaybackException {
        v f10 = drmSession.f();
        if (f10 != null && !(f10 instanceof w)) {
            String valueOf = String.valueOf(f10);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 42);
            sb2.append("Expecting FrameworkMediaCrypto but found: ");
            sb2.append(valueOf);
            throw x(new IllegalArgumentException(sb2.toString()), this.B, 6001);
        }
        return (w) f10;
    }

    @Nullable
    public abstract b.a v0(c cVar, Format format, @Nullable MediaCrypto mediaCrypto, float f10);

    @Override // com.google.android.exoplayer2.f, com.google.android.exoplayer2.n1
    public final int w() {
        return 8;
    }

    public final long w0() {
        return this.M0;
    }

    public float x0() {
        return this.I;
    }

    public void y0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
    }

    public final boolean z0() {
        return this.f20775g0 >= 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class DecoderInitializationException extends Exception {
        private static final int CUSTOM_ERROR_CODE_BASE = -50000;
        private static final int DECODER_QUERY_ERROR = -49998;
        private static final int NO_SUITABLE_DECODER_ERROR = -49999;

        @Nullable
        public final c codecInfo;

        @Nullable
        public final String diagnosticInfo;

        @Nullable
        public final DecoderInitializationException fallbackDecoderInitializationException;
        public final String mimeType;
        public final boolean secureDecoderRequired;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public DecoderInitializationException(com.google.android.exoplayer2.Format r12, @androidx.annotation.Nullable java.lang.Throwable r13, boolean r14, int r15) {
            /*
                r11 = this;
                java.lang.String r0 = java.lang.String.valueOf(r12)
                int r1 = r0.length()
                int r1 = r1 + 36
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>(r1)
                java.lang.String r1 = "Decoder init failed: ["
                r2.append(r1)
                r2.append(r15)
                java.lang.String r1 = "], "
                r2.append(r1)
                r2.append(r0)
                java.lang.String r4 = r2.toString()
                java.lang.String r6 = r12.f19544m
                java.lang.String r9 = buildCustomDiagnosticInfo(r15)
                r8 = 0
                r10 = 0
                r3 = r11
                r5 = r13
                r7 = r14
                r3.<init>(r4, r5, r6, r7, r8, r9, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException.<init>(com.google.android.exoplayer2.Format, java.lang.Throwable, boolean, int):void");
        }

        private static String buildCustomDiagnosticInfo(int i10) {
            String str = i10 < 0 ? "neg_" : "";
            int abs = Math.abs(i10);
            StringBuilder sb2 = new StringBuilder(str.length() + 71);
            sb2.append("com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_");
            sb2.append(str);
            sb2.append(abs);
            return sb2.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @CheckResult
        public DecoderInitializationException copyWithFallbackException(DecoderInitializationException decoderInitializationException) {
            return new DecoderInitializationException(getMessage(), getCause(), this.mimeType, this.secureDecoderRequired, this.codecInfo, this.diagnosticInfo, decoderInitializationException);
        }

        @Nullable
        @RequiresApi(21)
        private static String getDiagnosticInfoV21(@Nullable Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public DecoderInitializationException(com.google.android.exoplayer2.Format r9, @androidx.annotation.Nullable java.lang.Throwable r10, boolean r11, com.google.android.exoplayer2.mediacodec.c r12) {
            /*
                r8 = this;
                java.lang.String r0 = r12.f20832a
                java.lang.String r1 = java.lang.String.valueOf(r9)
                java.lang.String r2 = java.lang.String.valueOf(r0)
                int r2 = r2.length()
                int r2 = r2 + 23
                int r3 = r1.length()
                int r2 = r2 + r3
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>(r2)
                java.lang.String r2 = "Decoder init failed: "
                r3.append(r2)
                r3.append(r0)
                java.lang.String r0 = ", "
                r3.append(r0)
                r3.append(r1)
                java.lang.String r1 = r3.toString()
                java.lang.String r3 = r9.f19544m
                int r0 = com.google.android.exoplayer2.util.j0.f22990a
                r2 = 21
                if (r0 < r2) goto L3b
                java.lang.String r0 = getDiagnosticInfoV21(r10)
                goto L3c
            L3b:
                r0 = 0
            L3c:
                r6 = r0
                r7 = 0
                r0 = r8
                r2 = r10
                r4 = r11
                r5 = r12
                r0.<init>(r1, r2, r3, r4, r5, r6, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException.<init>(com.google.android.exoplayer2.Format, java.lang.Throwable, boolean, com.google.android.exoplayer2.mediacodec.c):void");
        }

        private DecoderInitializationException(String str, @Nullable Throwable th, String str2, boolean z10, @Nullable c cVar, @Nullable String str3, @Nullable DecoderInitializationException decoderInitializationException) {
            super(str, th);
            this.mimeType = str2;
            this.secureDecoderRequired = z10;
            this.codecInfo = cVar;
            this.diagnosticInfo = str3;
            this.fallbackDecoderInitializationException = decoderInitializationException;
        }
    }
}
