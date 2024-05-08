package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;

/* compiled from: MediaPeriodHolder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class x0 {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.p f23232a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f23233b;

    /* renamed from: c, reason: collision with root package name */
    public final SampleStream[] f23234c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f23235d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f23236e;

    /* renamed from: f, reason: collision with root package name */
    public y0 f23237f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f23238g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean[] f23239h;

    /* renamed from: i, reason: collision with root package name */
    public final n1[] f23240i;

    /* renamed from: j, reason: collision with root package name */
    public final n6.i f23241j;

    /* renamed from: k, reason: collision with root package name */
    public final d1 f23242k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public x0 f23243l;

    /* renamed from: m, reason: collision with root package name */
    public TrackGroupArray f23244m;

    /* renamed from: n, reason: collision with root package name */
    public TrackSelectorResult f23245n;

    /* renamed from: o, reason: collision with root package name */
    public long f23246o;

    public x0(n1[] n1VarArr, long j10, n6.i iVar, o6.b bVar, d1 d1Var, y0 y0Var, TrackSelectorResult trackSelectorResult) {
        this.f23240i = n1VarArr;
        this.f23246o = j10;
        this.f23241j = iVar;
        this.f23242k = d1Var;
        s.a aVar = y0Var.f23249a;
        this.f23233b = aVar.f21883a;
        this.f23237f = y0Var;
        this.f23244m = TrackGroupArray.f21171e;
        this.f23245n = trackSelectorResult;
        this.f23234c = new SampleStream[n1VarArr.length];
        this.f23239h = new boolean[n1VarArr.length];
        this.f23232a = e(aVar, d1Var, bVar, y0Var.f23250b, y0Var.f23252d);
    }

    public static com.google.android.exoplayer2.source.p e(s.a aVar, d1 d1Var, o6.b bVar, long j10, long j11) {
        com.google.android.exoplayer2.source.p h10 = d1Var.h(aVar, bVar, j10);
        return j11 != -9223372036854775807L ? new com.google.android.exoplayer2.source.c(h10, true, 0L, j11) : h10;
    }

    public static void u(d1 d1Var, com.google.android.exoplayer2.source.p pVar) {
        try {
            if (pVar instanceof com.google.android.exoplayer2.source.c) {
                d1Var.z(((com.google.android.exoplayer2.source.c) pVar).f21238b);
            } else {
                d1Var.z(pVar);
            }
        } catch (RuntimeException e2) {
            com.google.android.exoplayer2.util.m.d("MediaPeriodHolder", "Period release failed.", e2);
        }
    }

    public void A() {
        com.google.android.exoplayer2.source.p pVar = this.f23232a;
        if (pVar instanceof com.google.android.exoplayer2.source.c) {
            long j10 = this.f23237f.f23252d;
            if (j10 == -9223372036854775807L) {
                j10 = Long.MIN_VALUE;
            }
            ((com.google.android.exoplayer2.source.c) pVar).r(0L, j10);
        }
    }

    public long a(TrackSelectorResult trackSelectorResult, long j10, boolean z10) {
        return b(trackSelectorResult, j10, z10, new boolean[this.f23240i.length]);
    }

    public long b(TrackSelectorResult trackSelectorResult, long j10, boolean z10, boolean[] zArr) {
        int i10 = 0;
        while (true) {
            boolean z11 = true;
            if (i10 >= trackSelectorResult.length) {
                break;
            }
            boolean[] zArr2 = this.f23239h;
            if (z10 || !trackSelectorResult.isEquivalent(this.f23245n, i10)) {
                z11 = false;
            }
            zArr2[i10] = z11;
            i10++;
        }
        g(this.f23234c);
        f();
        this.f23245n = trackSelectorResult;
        h();
        long j11 = this.f23232a.j(trackSelectorResult.selections, this.f23239h, this.f23234c, zArr, j10);
        c(this.f23234c);
        this.f23236e = false;
        int i11 = 0;
        while (true) {
            SampleStream[] sampleStreamArr = this.f23234c;
            if (i11 >= sampleStreamArr.length) {
                return j11;
            }
            if (sampleStreamArr[i11] != null) {
                com.google.android.exoplayer2.util.a.g(trackSelectorResult.isRendererEnabled(i11));
                if (this.f23240i[i11].g() != 7) {
                    this.f23236e = true;
                }
            } else {
                com.google.android.exoplayer2.util.a.g(trackSelectorResult.selections[i11] == null);
            }
            i11++;
        }
    }

    public final void c(SampleStream[] sampleStreamArr) {
        int i10 = 0;
        while (true) {
            n1[] n1VarArr = this.f23240i;
            if (i10 >= n1VarArr.length) {
                return;
            }
            if (n1VarArr[i10].g() == 7 && this.f23245n.isRendererEnabled(i10)) {
                sampleStreamArr[i10] = new com.google.android.exoplayer2.source.j();
            }
            i10++;
        }
    }

    public void d(long j10) {
        com.google.android.exoplayer2.util.a.g(r());
        this.f23232a.b(y(j10));
    }

    public final void f() {
        if (!r()) {
            return;
        }
        int i10 = 0;
        while (true) {
            TrackSelectorResult trackSelectorResult = this.f23245n;
            if (i10 >= trackSelectorResult.length) {
                return;
            }
            boolean isRendererEnabled = trackSelectorResult.isRendererEnabled(i10);
            ExoTrackSelection exoTrackSelection = this.f23245n.selections[i10];
            if (isRendererEnabled && exoTrackSelection != null) {
                exoTrackSelection.e();
            }
            i10++;
        }
    }

    public final void g(SampleStream[] sampleStreamArr) {
        int i10 = 0;
        while (true) {
            n1[] n1VarArr = this.f23240i;
            if (i10 >= n1VarArr.length) {
                return;
            }
            if (n1VarArr[i10].g() == 7) {
                sampleStreamArr[i10] = null;
            }
            i10++;
        }
    }

    public final void h() {
        if (!r()) {
            return;
        }
        int i10 = 0;
        while (true) {
            TrackSelectorResult trackSelectorResult = this.f23245n;
            if (i10 >= trackSelectorResult.length) {
                return;
            }
            boolean isRendererEnabled = trackSelectorResult.isRendererEnabled(i10);
            ExoTrackSelection exoTrackSelection = this.f23245n.selections[i10];
            if (isRendererEnabled && exoTrackSelection != null) {
                exoTrackSelection.j();
            }
            i10++;
        }
    }

    public long i() {
        if (!this.f23235d) {
            return this.f23237f.f23250b;
        }
        long d10 = this.f23236e ? this.f23232a.d() : Long.MIN_VALUE;
        return d10 == Long.MIN_VALUE ? this.f23237f.f23253e : d10;
    }

    @Nullable
    public x0 j() {
        return this.f23243l;
    }

    public long k() {
        if (this.f23235d) {
            return this.f23232a.f();
        }
        return 0L;
    }

    public long l() {
        return this.f23246o;
    }

    public long m() {
        return this.f23237f.f23250b + this.f23246o;
    }

    public TrackGroupArray n() {
        return this.f23244m;
    }

    public TrackSelectorResult o() {
        return this.f23245n;
    }

    public void p(float f10, Timeline timeline) throws ExoPlaybackException {
        this.f23235d = true;
        this.f23244m = this.f23232a.m();
        TrackSelectorResult v2 = v(f10, timeline);
        y0 y0Var = this.f23237f;
        long j10 = y0Var.f23250b;
        long j11 = y0Var.f23253e;
        if (j11 != -9223372036854775807L && j10 >= j11) {
            j10 = Math.max(0L, j11 - 1);
        }
        long a10 = a(v2, j10, false);
        long j12 = this.f23246o;
        y0 y0Var2 = this.f23237f;
        this.f23246o = j12 + (y0Var2.f23250b - a10);
        this.f23237f = y0Var2.b(a10);
    }

    public boolean q() {
        return this.f23235d && (!this.f23236e || this.f23232a.d() == Long.MIN_VALUE);
    }

    public final boolean r() {
        return this.f23243l == null;
    }

    public void s(long j10) {
        com.google.android.exoplayer2.util.a.g(r());
        if (this.f23235d) {
            this.f23232a.e(y(j10));
        }
    }

    public void t() {
        f();
        u(this.f23242k, this.f23232a);
    }

    public TrackSelectorResult v(float f10, Timeline timeline) throws ExoPlaybackException {
        TrackSelectorResult e2 = this.f23241j.e(this.f23240i, n(), this.f23237f.f23249a, timeline);
        for (ExoTrackSelection exoTrackSelection : e2.selections) {
            if (exoTrackSelection != null) {
                exoTrackSelection.q(f10);
            }
        }
        return e2;
    }

    public void w(@Nullable x0 x0Var) {
        if (x0Var == this.f23243l) {
            return;
        }
        f();
        this.f23243l = x0Var;
        h();
    }

    public void x(long j10) {
        this.f23246o = j10;
    }

    public long y(long j10) {
        return j10 - l();
    }

    public long z(long j10) {
        return j10 + l();
    }
}
