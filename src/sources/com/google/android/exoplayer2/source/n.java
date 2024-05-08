package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import java.io.IOException;

/* compiled from: MaskingMediaPeriod.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class n implements p, p.a {

    /* renamed from: b, reason: collision with root package name */
    public final s.a f21811b;

    /* renamed from: c, reason: collision with root package name */
    public final long f21812c;

    /* renamed from: d, reason: collision with root package name */
    public final o6.b f21813d;

    /* renamed from: e, reason: collision with root package name */
    public s f21814e;

    /* renamed from: f, reason: collision with root package name */
    public p f21815f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public p.a f21816g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public a f21817h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f21818i;

    /* renamed from: j, reason: collision with root package name */
    public long f21819j = -9223372036854775807L;

    /* compiled from: MaskingMediaPeriod.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void a(s.a aVar, IOException iOException);

        void b(s.a aVar);
    }

    public n(s.a aVar, o6.b bVar, long j10) {
        this.f21811b = aVar;
        this.f21813d = bVar;
        this.f21812c = j10;
    }

    public void a(s.a aVar) {
        long q10 = q(this.f21812c);
        p e2 = ((s) com.google.android.exoplayer2.util.a.e(this.f21814e)).e(aVar, this.f21813d, q10);
        this.f21815f = e2;
        if (this.f21816g != null) {
            e2.p(this, q10);
        }
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public boolean b(long j10) {
        p pVar = this.f21815f;
        return pVar != null && pVar.b(j10);
    }

    public long c() {
        return this.f21819j;
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public long d() {
        return ((p) com.google.android.exoplayer2.util.j0.j(this.f21815f)).d();
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public void e(long j10) {
        ((p) com.google.android.exoplayer2.util.j0.j(this.f21815f)).e(j10);
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public long f() {
        return ((p) com.google.android.exoplayer2.util.j0.j(this.f21815f)).f();
    }

    @Override // com.google.android.exoplayer2.source.p
    public long g(long j10, p1 p1Var) {
        return ((p) com.google.android.exoplayer2.util.j0.j(this.f21815f)).g(j10, p1Var);
    }

    @Override // com.google.android.exoplayer2.source.p
    public long h(long j10) {
        return ((p) com.google.android.exoplayer2.util.j0.j(this.f21815f)).h(j10);
    }

    @Override // com.google.android.exoplayer2.source.p
    public long i() {
        return ((p) com.google.android.exoplayer2.util.j0.j(this.f21815f)).i();
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public boolean isLoading() {
        p pVar = this.f21815f;
        return pVar != null && pVar.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.p
    public long j(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j10) {
        long j11;
        long j12 = this.f21819j;
        if (j12 == -9223372036854775807L || j10 != this.f21812c) {
            j11 = j10;
        } else {
            this.f21819j = -9223372036854775807L;
            j11 = j12;
        }
        return ((p) com.google.android.exoplayer2.util.j0.j(this.f21815f)).j(exoTrackSelectionArr, zArr, sampleStreamArr, zArr2, j11);
    }

    @Override // com.google.android.exoplayer2.source.p
    public TrackGroupArray m() {
        return ((p) com.google.android.exoplayer2.util.j0.j(this.f21815f)).m();
    }

    @Override // com.google.android.exoplayer2.source.p.a
    public void n(p pVar) {
        ((p.a) com.google.android.exoplayer2.util.j0.j(this.f21816g)).n(this);
        a aVar = this.f21817h;
        if (aVar != null) {
            aVar.b(this.f21811b);
        }
    }

    public long o() {
        return this.f21812c;
    }

    @Override // com.google.android.exoplayer2.source.p
    public void p(p.a aVar, long j10) {
        this.f21816g = aVar;
        p pVar = this.f21815f;
        if (pVar != null) {
            pVar.p(this, q(this.f21812c));
        }
    }

    public final long q(long j10) {
        long j11 = this.f21819j;
        return j11 != -9223372036854775807L ? j11 : j10;
    }

    @Override // com.google.android.exoplayer2.source.m0.a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void k(p pVar) {
        ((p.a) com.google.android.exoplayer2.util.j0.j(this.f21816g)).k(this);
    }

    @Override // com.google.android.exoplayer2.source.p
    public void s() throws IOException {
        try {
            p pVar = this.f21815f;
            if (pVar != null) {
                pVar.s();
            } else {
                s sVar = this.f21814e;
                if (sVar != null) {
                    sVar.f();
                }
            }
        } catch (IOException e2) {
            a aVar = this.f21817h;
            if (aVar != null) {
                if (this.f21818i) {
                    return;
                }
                this.f21818i = true;
                aVar.a(this.f21811b, e2);
                return;
            }
            throw e2;
        }
    }

    @Override // com.google.android.exoplayer2.source.p
    public void t(long j10, boolean z10) {
        ((p) com.google.android.exoplayer2.util.j0.j(this.f21815f)).t(j10, z10);
    }

    public void u(long j10) {
        this.f21819j = j10;
    }

    public void v() {
        if (this.f21815f != null) {
            ((s) com.google.android.exoplayer2.util.a.e(this.f21814e)).j(this.f21815f);
        }
    }

    public void w(s sVar) {
        com.google.android.exoplayer2.util.a.g(this.f21814e == null);
        this.f21814e = sVar;
    }

    public void x(a aVar) {
        this.f21817h = aVar;
    }
}
