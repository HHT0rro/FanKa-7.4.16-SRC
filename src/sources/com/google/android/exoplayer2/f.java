package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.SampleStream;
import java.io.IOException;

/* compiled from: BaseRenderer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class f implements l1, n1 {

    /* renamed from: b, reason: collision with root package name */
    public final int f20682b;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public RendererConfiguration f20684d;

    /* renamed from: e, reason: collision with root package name */
    public int f20685e;

    /* renamed from: f, reason: collision with root package name */
    public int f20686f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public SampleStream f20687g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public Format[] f20688h;

    /* renamed from: i, reason: collision with root package name */
    public long f20689i;

    /* renamed from: j, reason: collision with root package name */
    public long f20690j;

    /* renamed from: l, reason: collision with root package name */
    public boolean f20692l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f20693m;

    /* renamed from: c, reason: collision with root package name */
    public final s0 f20683c = new s0();

    /* renamed from: k, reason: collision with root package name */
    public long f20691k = Long.MIN_VALUE;

    public f(int i10) {
        this.f20682b = i10;
    }

    public final s0 A() {
        this.f20683c.a();
        return this.f20683c;
    }

    public final int B() {
        return this.f20685e;
    }

    public final Format[] C() {
        return (Format[]) com.google.android.exoplayer2.util.a.e(this.f20688h);
    }

    public final boolean D() {
        return h() ? this.f20692l : ((SampleStream) com.google.android.exoplayer2.util.a.e(this.f20687g)).isReady();
    }

    public abstract void E();

    public void F(boolean z10, boolean z11) throws ExoPlaybackException {
    }

    public abstract void G(long j10, boolean z10) throws ExoPlaybackException;

    public void H() {
    }

    public void I() throws ExoPlaybackException {
    }

    public void J() {
    }

    public abstract void K(Format[] formatArr, long j10, long j11) throws ExoPlaybackException;

    public final int L(s0 s0Var, DecoderInputBuffer decoderInputBuffer, int i10) {
        int c4 = ((SampleStream) com.google.android.exoplayer2.util.a.e(this.f20687g)).c(s0Var, decoderInputBuffer, i10);
        if (c4 == -4) {
            if (decoderInputBuffer.m()) {
                this.f20691k = Long.MIN_VALUE;
                return this.f20692l ? -4 : -3;
            }
            long j10 = decoderInputBuffer.f19884f + this.f20689i;
            decoderInputBuffer.f19884f = j10;
            this.f20691k = Math.max(this.f20691k, j10);
        } else if (c4 == -5) {
            Format format = (Format) com.google.android.exoplayer2.util.a.e(s0Var.f21132b);
            if (format.f19548q != Long.MAX_VALUE) {
                s0Var.f21132b = format.a().i0(format.f19548q + this.f20689i).E();
            }
        }
        return c4;
    }

    public int M(long j10) {
        return ((SampleStream) com.google.android.exoplayer2.util.a.e(this.f20687g)).l(j10 - this.f20689i);
    }

    @Override // com.google.android.exoplayer2.l1
    public final void e() {
        com.google.android.exoplayer2.util.a.g(this.f20686f == 1);
        this.f20683c.a();
        this.f20686f = 0;
        this.f20687g = null;
        this.f20688h = null;
        this.f20692l = false;
        E();
    }

    @Override // com.google.android.exoplayer2.l1
    public final void f(int i10) {
        this.f20685e = i10;
    }

    @Override // com.google.android.exoplayer2.l1, com.google.android.exoplayer2.n1
    public final int g() {
        return this.f20682b;
    }

    @Override // com.google.android.exoplayer2.l1
    public final int getState() {
        return this.f20686f;
    }

    @Override // com.google.android.exoplayer2.l1
    public final boolean h() {
        return this.f20691k == Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.PlayerMessage.Target
    public void i(int i10, @Nullable Object obj) throws ExoPlaybackException {
    }

    @Override // com.google.android.exoplayer2.l1
    public final boolean j() {
        return this.f20692l;
    }

    @Override // com.google.android.exoplayer2.l1
    @Nullable
    public final SampleStream l() {
        return this.f20687g;
    }

    @Override // com.google.android.exoplayer2.l1
    public final long m() {
        return this.f20691k;
    }

    @Override // com.google.android.exoplayer2.l1
    public final void n(long j10) throws ExoPlaybackException {
        this.f20692l = false;
        this.f20690j = j10;
        this.f20691k = j10;
        G(j10, false);
    }

    @Override // com.google.android.exoplayer2.l1
    @Nullable
    public com.google.android.exoplayer2.util.o o() {
        return null;
    }

    @Override // com.google.android.exoplayer2.l1
    public final void p() {
        this.f20692l = true;
    }

    @Override // com.google.android.exoplayer2.l1
    public final void q() throws IOException {
        ((SampleStream) com.google.android.exoplayer2.util.a.e(this.f20687g)).a();
    }

    @Override // com.google.android.exoplayer2.l1
    public final void r(Format[] formatArr, SampleStream sampleStream, long j10, long j11) throws ExoPlaybackException {
        com.google.android.exoplayer2.util.a.g(!this.f20692l);
        this.f20687g = sampleStream;
        if (this.f20691k == Long.MIN_VALUE) {
            this.f20691k = j10;
        }
        this.f20688h = formatArr;
        this.f20689i = j11;
        K(formatArr, j10, j11);
    }

    @Override // com.google.android.exoplayer2.l1
    public final void reset() {
        com.google.android.exoplayer2.util.a.g(this.f20686f == 0);
        this.f20683c.a();
        H();
    }

    @Override // com.google.android.exoplayer2.l1
    public final n1 s() {
        return this;
    }

    @Override // com.google.android.exoplayer2.l1
    public final void start() throws ExoPlaybackException {
        com.google.android.exoplayer2.util.a.g(this.f20686f == 1);
        this.f20686f = 2;
        I();
    }

    @Override // com.google.android.exoplayer2.l1
    public final void stop() {
        com.google.android.exoplayer2.util.a.g(this.f20686f == 2);
        this.f20686f = 1;
        J();
    }

    @Override // com.google.android.exoplayer2.l1
    public /* synthetic */ void u(float f10, float f11) {
        k1.a(this, f10, f11);
    }

    @Override // com.google.android.exoplayer2.l1
    public final void v(RendererConfiguration rendererConfiguration, Format[] formatArr, SampleStream sampleStream, long j10, boolean z10, boolean z11, long j11, long j12) throws ExoPlaybackException {
        com.google.android.exoplayer2.util.a.g(this.f20686f == 0);
        this.f20684d = rendererConfiguration;
        this.f20686f = 1;
        this.f20690j = j10;
        F(z10, z11);
        r(formatArr, sampleStream, j11, j12);
        G(j10, z10);
    }

    @Override // com.google.android.exoplayer2.n1
    public int w() throws ExoPlaybackException {
        return 0;
    }

    public final ExoPlaybackException x(Throwable th, @Nullable Format format, int i10) {
        return y(th, format, false, i10);
    }

    public final ExoPlaybackException y(Throwable th, @Nullable Format format, boolean z10, int i10) {
        int i11;
        if (format != null && !this.f20693m) {
            this.f20693m = true;
            try {
                int d10 = m1.d(a(format));
                this.f20693m = false;
                i11 = d10;
            } catch (ExoPlaybackException unused) {
                this.f20693m = false;
            } catch (Throwable th2) {
                this.f20693m = false;
                throw th2;
            }
            return ExoPlaybackException.createForRenderer(th, getName(), B(), format, i11, z10, i10);
        }
        i11 = 4;
        return ExoPlaybackException.createForRenderer(th, getName(), B(), format, i11, z10, i10);
    }

    public final RendererConfiguration z() {
        return (RendererConfiguration) com.google.android.exoplayer2.util.a.e(this.f20684d);
    }
}
