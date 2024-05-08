package com.google.android.exoplayer2.audio;

import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.DatabaseSourceInfoStorage;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.a;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.f1;
import com.google.android.exoplayer2.l1;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.b;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.o;
import com.google.android.exoplayer2.util.p;
import com.google.android.exoplayer2.util.q;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import x4.s;

/* compiled from: MediaCodecAudioRenderer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class f extends MediaCodecRenderer implements o {
    public final Context P0;
    public final a.C0185a Q0;
    public final AudioSink R0;
    public int S0;
    public boolean T0;

    @Nullable
    public Format U0;
    public long V0;
    public boolean W0;
    public boolean X0;
    public boolean Y0;
    public boolean Z0;

    /* renamed from: a1, reason: collision with root package name */
    @Nullable
    public l1.a f19799a1;

    /* compiled from: MediaCodecAudioRenderer.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class b implements AudioSink.a {
        public b() {
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void a(long j10) {
            f.this.Q0.B(j10);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void b(Exception exc) {
            m.d("MediaCodecAudioRenderer", "Audio sink error", exc);
            f.this.Q0.l(exc);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void c(int i10, long j10, long j11) {
            f.this.Q0.D(i10, j10, j11);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void d(long j10) {
            if (f.this.f19799a1 != null) {
                f.this.f19799a1.b(j10);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void e() {
            f.this.v1();
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void f() {
            if (f.this.f19799a1 != null) {
                f.this.f19799a1.a();
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void onSkipSilenceEnabledChanged(boolean z10) {
            f.this.Q0.C(z10);
        }
    }

    public f(Context context, com.google.android.exoplayer2.mediacodec.d dVar, boolean z10, @Nullable Handler handler, @Nullable com.google.android.exoplayer2.audio.a aVar, AudioSink audioSink) {
        this(context, b.InterfaceC0191b.f20831a, dVar, z10, handler, aVar, audioSink);
    }

    public static boolean q1(String str) {
        if (j0.f22990a < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(j0.f22992c)) {
            String str2 = j0.f22991b;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                return true;
            }
        }
        return false;
    }

    public static boolean r1() {
        if (j0.f22990a == 23) {
            String str = j0.f22993d;
            if ("ZTE B2017G".equals(str) || "AXON 7 mini".equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.f
    public void E() {
        this.Y0 = true;
        try {
            this.R0.flush();
            try {
                super.E();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.E();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.f
    public void F(boolean z10, boolean z11) throws ExoPlaybackException {
        super.F(z10, z11);
        this.Q0.p(this.K0);
        if (z().f19652a) {
            this.R0.g();
        } else {
            this.R0.e();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.f
    public void G(long j10, boolean z10) throws ExoPlaybackException {
        super.G(j10, z10);
        if (this.Z0) {
            this.R0.f();
        } else {
            this.R0.flush();
        }
        this.V0 = j10;
        this.W0 = true;
        this.X0 = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.f
    public void H() {
        try {
            super.H();
        } finally {
            if (this.Y0) {
                this.Y0 = false;
                this.R0.reset();
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.f
    public void I() {
        super.I();
        this.R0.play();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.f
    public void J() {
        w1();
        this.R0.pause();
        super.J();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void J0(Exception exc) {
        m.d("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.Q0.k(exc);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void K0(String str, long j10, long j11) {
        this.Q0.m(str, j10, j11);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void L0(String str) {
        this.Q0.n(str);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @Nullable
    public DecoderReuseEvaluation M0(s0 s0Var) throws ExoPlaybackException {
        DecoderReuseEvaluation M0 = super.M0(s0Var);
        this.Q0.q(s0Var.f21132b, M0);
        return M0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void N0(Format format, @Nullable MediaFormat mediaFormat) throws ExoPlaybackException {
        int i10;
        int i11;
        Format format2 = this.U0;
        int[] iArr = null;
        if (format2 != null) {
            format = format2;
        } else if (o0() != null) {
            if ("audio/raw".equals(format.f19544m)) {
                i10 = format.B;
            } else if (j0.f22990a >= 24 && mediaFormat.containsKey("pcm-encoding")) {
                i10 = mediaFormat.getInteger("pcm-encoding");
            } else if (mediaFormat.containsKey("v-bits-per-sample")) {
                i10 = j0.Y(mediaFormat.getInteger("v-bits-per-sample"));
            } else {
                i10 = "audio/raw".equals(format.f19544m) ? format.B : 2;
            }
            Format E = new Format.b().e0("audio/raw").Y(i10).M(format.C).N(format.D).H(mediaFormat.getInteger("channel-count")).f0(mediaFormat.getInteger("sample-rate")).E();
            if (this.T0 && E.f19557z == 6 && (i11 = format.f19557z) < 6) {
                iArr = new int[i11];
                for (int i12 = 0; i12 < format.f19557z; i12++) {
                    iArr[i12] = i12;
                }
            }
            format = E;
        }
        try {
            this.R0.r(format, 0, iArr);
        } catch (AudioSink.ConfigurationException e2) {
            throw x(e2, e2.format, 5001);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public DecoderReuseEvaluation P(com.google.android.exoplayer2.mediacodec.c cVar, Format format, Format format2) {
        DecoderReuseEvaluation e2 = cVar.e(format, format2);
        int i10 = e2.f19892e;
        if (s1(cVar, format2) > this.S0) {
            i10 |= 64;
        }
        int i11 = i10;
        return new DecoderReuseEvaluation(cVar.f20832a, format, format2, i11 != 0 ? 0 : e2.f19891d, i11);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void P0() {
        super.P0();
        this.R0.q();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void Q0(DecoderInputBuffer decoderInputBuffer) {
        if (!this.W0 || decoderInputBuffer.l()) {
            return;
        }
        if (Math.abs(decoderInputBuffer.f19884f - this.V0) > 500000) {
            this.V0 = decoderInputBuffer.f19884f;
        }
        this.W0 = false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean S0(long j10, long j11, @Nullable com.google.android.exoplayer2.mediacodec.b bVar, @Nullable ByteBuffer byteBuffer, int i10, int i11, int i12, long j12, boolean z10, boolean z11, Format format) throws ExoPlaybackException {
        com.google.android.exoplayer2.util.a.e(byteBuffer);
        if (this.U0 != null && (i11 & 2) != 0) {
            ((com.google.android.exoplayer2.mediacodec.b) com.google.android.exoplayer2.util.a.e(bVar)).f(i10, false);
            return true;
        }
        if (z10) {
            if (bVar != null) {
                bVar.f(i10, false);
            }
            this.K0.f54857f += i12;
            this.R0.q();
            return true;
        }
        try {
            if (!this.R0.j(byteBuffer, j12, i12)) {
                return false;
            }
            if (bVar != null) {
                bVar.f(i10, false);
            }
            this.K0.f54856e += i12;
            return true;
        } catch (AudioSink.InitializationException e2) {
            throw y(e2, e2.format, e2.isRecoverable, 5001);
        } catch (AudioSink.WriteException e10) {
            throw y(e10, format, e10.isRecoverable, 5002);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void X0() throws ExoPlaybackException {
        try {
            this.R0.n();
        } catch (AudioSink.WriteException e2) {
            throw y(e2, e2.format, e2.isRecoverable, 5002);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.l1
    public boolean b() {
        return super.b() && this.R0.b();
    }

    @Override // com.google.android.exoplayer2.util.o
    public void c(f1 f1Var) {
        this.R0.c(f1Var);
    }

    @Override // com.google.android.exoplayer2.util.o
    public f1 d() {
        return this.R0.d();
    }

    @Override // com.google.android.exoplayer2.l1, com.google.android.exoplayer2.n1
    public String getName() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.google.android.exoplayer2.f, com.google.android.exoplayer2.PlayerMessage.Target
    public void i(int i10, @Nullable Object obj) throws ExoPlaybackException {
        if (i10 == 2) {
            this.R0.setVolume(((Float) obj).floatValue());
            return;
        }
        if (i10 == 3) {
            this.R0.o((x4.d) obj);
            return;
        }
        if (i10 != 5) {
            switch (i10) {
                case 101:
                    this.R0.s(((Boolean) obj).booleanValue());
                    return;
                case 102:
                    this.R0.i(((Integer) obj).intValue());
                    return;
                case 103:
                    this.f19799a1 = (l1.a) obj;
                    return;
                default:
                    super.i(i10, obj);
                    return;
            }
        }
        this.R0.k((s) obj);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean i1(Format format) {
        return this.R0.a(format);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.l1
    public boolean isReady() {
        return this.R0.h() || super.isReady();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int j1(com.google.android.exoplayer2.mediacodec.d dVar, Format format) throws MediaCodecUtil.DecoderQueryException {
        if (!q.p(format.f19544m)) {
            return m1.a(0);
        }
        int i10 = j0.f22990a >= 21 ? 32 : 0;
        boolean z10 = format.F != null;
        boolean k12 = MediaCodecRenderer.k1(format);
        int i11 = 8;
        if (k12 && this.R0.a(format) && (!z10 || MediaCodecUtil.u() != null)) {
            return m1.b(4, 8, i10);
        }
        if ("audio/raw".equals(format.f19544m) && !this.R0.a(format)) {
            return m1.a(1);
        }
        if (!this.R0.a(j0.Z(2, format.f19557z, format.A))) {
            return m1.a(1);
        }
        List<com.google.android.exoplayer2.mediacodec.c> t02 = t0(dVar, format, false);
        if (t02.isEmpty()) {
            return m1.a(1);
        }
        if (!k12) {
            return m1.a(2);
        }
        com.google.android.exoplayer2.mediacodec.c cVar = t02.get(0);
        boolean m10 = cVar.m(format);
        if (m10 && cVar.o(format)) {
            i11 = 16;
        }
        return m1.b(m10 ? 4 : 3, i11, i10);
    }

    @Override // com.google.android.exoplayer2.f, com.google.android.exoplayer2.l1
    @Nullable
    public o o() {
        return this;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public float r0(float f10, Format format, Format[] formatArr) {
        int i10 = -1;
        for (Format format2 : formatArr) {
            int i11 = format2.A;
            if (i11 != -1) {
                i10 = Math.max(i10, i11);
            }
        }
        if (i10 == -1) {
            return -1.0f;
        }
        return f10 * i10;
    }

    public final int s1(com.google.android.exoplayer2.mediacodec.c cVar, Format format) {
        int i10;
        if (!"OMX.google.raw.decoder".equals(cVar.f20832a) || (i10 = j0.f22990a) >= 24 || (i10 == 23 && j0.r0(this.P0))) {
            return format.f19545n;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.util.o
    public long t() {
        if (getState() == 2) {
            w1();
        }
        return this.V0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public List<com.google.android.exoplayer2.mediacodec.c> t0(com.google.android.exoplayer2.mediacodec.d dVar, Format format, boolean z10) throws MediaCodecUtil.DecoderQueryException {
        com.google.android.exoplayer2.mediacodec.c u10;
        String str = format.f19544m;
        if (str == null) {
            return Collections.emptyList();
        }
        if (this.R0.a(format) && (u10 = MediaCodecUtil.u()) != null) {
            return Collections.singletonList(u10);
        }
        List<com.google.android.exoplayer2.mediacodec.c> t2 = MediaCodecUtil.t(dVar.a(str, z10, false), format);
        if ("audio/eac3-joc".equals(str)) {
            ArrayList arrayList = new ArrayList(t2);
            arrayList.addAll(dVar.a("audio/eac3", z10, false));
            t2 = arrayList;
        }
        return Collections.unmodifiableList(t2);
    }

    public int t1(com.google.android.exoplayer2.mediacodec.c cVar, Format format, Format[] formatArr) {
        int s12 = s1(cVar, format);
        if (formatArr.length == 1) {
            return s12;
        }
        for (Format format2 : formatArr) {
            if (cVar.e(format, format2).f19891d != 0) {
                s12 = Math.max(s12, s1(cVar, format2));
            }
        }
        return s12;
    }

    public MediaFormat u1(Format format, String str, int i10, float f10) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(DatabaseSourceInfoStorage.COLUMN_MIME, str);
        mediaFormat.setInteger("channel-count", format.f19557z);
        mediaFormat.setInteger("sample-rate", format.A);
        p.e(mediaFormat, format.f19546o);
        p.d(mediaFormat, "max-input-size", i10);
        int i11 = j0.f22990a;
        if (i11 >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f10 != -1.0f && !r1()) {
                mediaFormat.setFloat("operating-rate", f10);
            }
        }
        if (i11 <= 28 && "audio/ac4".equals(format.f19544m)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (i11 >= 24 && this.R0.m(j0.Z(4, format.f19557z, format.A)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        return mediaFormat;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public b.a v0(com.google.android.exoplayer2.mediacodec.c cVar, Format format, @Nullable MediaCrypto mediaCrypto, float f10) {
        this.S0 = t1(cVar, format, C());
        this.T0 = q1(cVar.f20832a);
        MediaFormat u12 = u1(format, cVar.f20834c, this.S0, f10);
        this.U0 = "audio/raw".equals(cVar.f20833b) && !"audio/raw".equals(format.f19544m) ? format : null;
        return new b.a(cVar, u12, format, null, mediaCrypto, 0);
    }

    @CallSuper
    public void v1() {
        this.X0 = true;
    }

    public final void w1() {
        long p10 = this.R0.p(b());
        if (p10 != Long.MIN_VALUE) {
            if (!this.X0) {
                p10 = Math.max(this.V0, p10);
            }
            this.V0 = p10;
            this.X0 = false;
        }
    }

    public f(Context context, b.InterfaceC0191b interfaceC0191b, com.google.android.exoplayer2.mediacodec.d dVar, boolean z10, @Nullable Handler handler, @Nullable com.google.android.exoplayer2.audio.a aVar, AudioSink audioSink) {
        super(1, interfaceC0191b, dVar, z10, 44100.0f);
        this.P0 = context.getApplicationContext();
        this.R0 = audioSink;
        this.Q0 = new a.C0185a(handler, aVar);
        audioSink.l(new b());
    }
}
