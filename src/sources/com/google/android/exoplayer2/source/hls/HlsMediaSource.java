package com.google.android.exoplayer2.source.hls;

import androidx.annotation.Nullable;
import b5.u;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.r0;
import com.google.android.exoplayer2.source.a0;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.c;
import com.google.android.exoplayer2.source.n0;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.source.z;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.w0;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import o6.v;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class HlsMediaSource extends com.google.android.exoplayer2.source.a implements HlsPlaylistTracker.c {

    /* renamed from: h, reason: collision with root package name */
    public final g f21451h;

    /* renamed from: i, reason: collision with root package name */
    public final w0.g f21452i;

    /* renamed from: j, reason: collision with root package name */
    public final f f21453j;

    /* renamed from: k, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.g f21454k;

    /* renamed from: l, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.c f21455l;

    /* renamed from: m, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.h f21456m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f21457n;

    /* renamed from: o, reason: collision with root package name */
    public final int f21458o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f21459p;

    /* renamed from: q, reason: collision with root package name */
    public final HlsPlaylistTracker f21460q;

    /* renamed from: r, reason: collision with root package name */
    public final long f21461r;

    /* renamed from: s, reason: collision with root package name */
    public final w0 f21462s;

    /* renamed from: t, reason: collision with root package name */
    public w0.f f21463t;

    /* renamed from: u, reason: collision with root package name */
    @Nullable
    public v f21464u;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class Factory implements a0 {

        /* renamed from: a, reason: collision with root package name */
        public final f f21465a;

        /* renamed from: b, reason: collision with root package name */
        public g f21466b;

        /* renamed from: c, reason: collision with root package name */
        public a6.f f21467c;

        /* renamed from: d, reason: collision with root package name */
        public HlsPlaylistTracker.a f21468d;

        /* renamed from: e, reason: collision with root package name */
        public com.google.android.exoplayer2.source.g f21469e;

        /* renamed from: f, reason: collision with root package name */
        public u f21470f;

        /* renamed from: g, reason: collision with root package name */
        public com.google.android.exoplayer2.upstream.h f21471g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f21472h;

        /* renamed from: i, reason: collision with root package name */
        public int f21473i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f21474j;

        /* renamed from: k, reason: collision with root package name */
        public List<StreamKey> f21475k;

        /* renamed from: l, reason: collision with root package name */
        @Nullable
        public Object f21476l;

        /* renamed from: m, reason: collision with root package name */
        public long f21477m;

        public Factory(a.InterfaceC0208a interfaceC0208a) {
            this(new c(interfaceC0208a));
        }

        @Override // com.google.android.exoplayer2.source.a0
        public int[] a() {
            return new int[]{2};
        }

        @Override // com.google.android.exoplayer2.source.a0
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public HlsMediaSource b(w0 w0Var) {
            List<StreamKey> list;
            w0 w0Var2 = w0Var;
            com.google.android.exoplayer2.util.a.e(w0Var2.f23163b);
            a6.f fVar = this.f21467c;
            if (w0Var2.f23163b.f23220e.isEmpty()) {
                list = this.f21475k;
            } else {
                list = w0Var2.f23163b.f23220e;
            }
            if (!list.isEmpty()) {
                fVar = new a6.d(fVar, list);
            }
            w0.g gVar = w0Var2.f23163b;
            boolean z10 = gVar.f23223h == null && this.f21476l != null;
            boolean z11 = gVar.f23220e.isEmpty() && !list.isEmpty();
            if (z10 && z11) {
                w0Var2 = w0Var.a().s(this.f21476l).q(list).a();
            } else if (z10) {
                w0Var2 = w0Var.a().s(this.f21476l).a();
            } else if (z11) {
                w0Var2 = w0Var.a().q(list).a();
            }
            w0 w0Var3 = w0Var2;
            f fVar2 = this.f21465a;
            g gVar2 = this.f21466b;
            com.google.android.exoplayer2.source.g gVar3 = this.f21469e;
            com.google.android.exoplayer2.drm.c a10 = this.f21470f.a(w0Var3);
            com.google.android.exoplayer2.upstream.h hVar = this.f21471g;
            return new HlsMediaSource(w0Var3, fVar2, gVar2, gVar3, a10, hVar, this.f21468d.a(this.f21465a, hVar, fVar), this.f21477m, this.f21472h, this.f21473i, this.f21474j);
        }

        public Factory(f fVar) {
            this.f21465a = (f) com.google.android.exoplayer2.util.a.e(fVar);
            this.f21470f = new com.google.android.exoplayer2.drm.a();
            this.f21467c = new a6.a();
            this.f21468d = com.google.android.exoplayer2.source.hls.playlist.a.f21641q;
            this.f21466b = g.f21529a;
            this.f21471g = new com.google.android.exoplayer2.upstream.f();
            this.f21469e = new com.google.android.exoplayer2.source.h();
            this.f21473i = 1;
            this.f21475k = Collections.emptyList();
            this.f21477m = -9223372036854775807L;
        }
    }

    static {
        r0.a("goog.exo.hls");
    }

    @Nullable
    public static c.b G(List<c.b> list, long j10) {
        c.b bVar = null;
        for (int i10 = 0; i10 < list.size(); i10++) {
            c.b bVar2 = list.get(i10);
            long j11 = bVar2.f21720f;
            if (j11 > j10 || !bVar2.f21709m) {
                if (j11 > j10) {
                    break;
                }
            } else {
                bVar = bVar2;
            }
        }
        return bVar;
    }

    public static c.d H(List<c.d> list, long j10) {
        return list.get(j0.g(list, Long.valueOf(j10), true, true));
    }

    public static long K(com.google.android.exoplayer2.source.hls.playlist.c cVar, long j10) {
        long j11;
        c.f fVar = cVar.f21708v;
        long j12 = cVar.f21691e;
        if (j12 != -9223372036854775807L) {
            j11 = cVar.f21707u - j12;
        } else {
            long j13 = fVar.f21730d;
            if (j13 == -9223372036854775807L || cVar.f21700n == -9223372036854775807L) {
                long j14 = fVar.f21729c;
                j11 = j14 != -9223372036854775807L ? j14 : cVar.f21699m * 3;
            } else {
                j11 = j13;
            }
        }
        return j11 + j10;
    }

    @Override // com.google.android.exoplayer2.source.a
    public void B(@Nullable v vVar) {
        this.f21464u = vVar;
        this.f21455l.prepare();
        this.f21460q.d(this.f21452i.f23216a, w(null), this);
    }

    @Override // com.google.android.exoplayer2.source.a
    public void D() {
        this.f21460q.stop();
        this.f21455l.release();
    }

    public final n0 E(com.google.android.exoplayer2.source.hls.playlist.c cVar, long j10, long j11, h hVar) {
        long K;
        long b4 = cVar.f21694h - this.f21460q.b();
        long j12 = cVar.f21701o ? b4 + cVar.f21707u : -9223372036854775807L;
        long I = I(cVar);
        long j13 = this.f21463t.f23211a;
        if (j13 != -9223372036854775807L) {
            K = com.google.android.exoplayer2.h.d(j13);
        } else {
            K = K(cVar, I);
        }
        L(j0.s(K, I, cVar.f21707u + I));
        return new n0(j10, j11, -9223372036854775807L, j12, cVar.f21707u, b4, J(cVar, I), true, !cVar.f21701o, cVar.f21690d == 2 && cVar.f21692f, hVar, this.f21462s, this.f21463t);
    }

    public final n0 F(com.google.android.exoplayer2.source.hls.playlist.c cVar, long j10, long j11, h hVar) {
        long j12;
        if (cVar.f21691e == -9223372036854775807L || cVar.f21704r.isEmpty()) {
            j12 = 0;
        } else {
            if (!cVar.f21693g) {
                long j13 = cVar.f21691e;
                if (j13 != cVar.f21707u) {
                    j12 = H(cVar.f21704r, j13).f21720f;
                }
            }
            j12 = cVar.f21691e;
        }
        long j14 = cVar.f21707u;
        return new n0(j10, j11, -9223372036854775807L, j14, j14, 0L, j12, true, false, true, hVar, this.f21462s, null);
    }

    public final long I(com.google.android.exoplayer2.source.hls.playlist.c cVar) {
        if (cVar.f21702p) {
            return com.google.android.exoplayer2.h.d(j0.X(this.f21461r)) - cVar.e();
        }
        return 0L;
    }

    public final long J(com.google.android.exoplayer2.source.hls.playlist.c cVar, long j10) {
        long j11 = cVar.f21691e;
        if (j11 == -9223372036854775807L) {
            j11 = (cVar.f21707u + j10) - com.google.android.exoplayer2.h.d(this.f21463t.f23211a);
        }
        if (cVar.f21693g) {
            return j11;
        }
        c.b G = G(cVar.f21705s, j11);
        if (G != null) {
            return G.f21720f;
        }
        if (cVar.f21704r.isEmpty()) {
            return 0L;
        }
        c.d H = H(cVar.f21704r, j11);
        c.b G2 = G(H.f21715n, j11);
        if (G2 != null) {
            return G2.f21720f;
        }
        return H.f21720f;
    }

    public final void L(long j10) {
        long e2 = com.google.android.exoplayer2.h.e(j10);
        if (e2 != this.f21463t.f23211a) {
            this.f21463t = this.f21462s.a().o(e2).a().f23164c;
        }
    }

    @Override // com.google.android.exoplayer2.source.s
    public w0 d() {
        return this.f21462s;
    }

    @Override // com.google.android.exoplayer2.source.s
    public com.google.android.exoplayer2.source.p e(s.a aVar, o6.b bVar, long j10) {
        z.a w3 = w(aVar);
        return new k(this.f21451h, this.f21460q, this.f21453j, this.f21464u, this.f21455l, u(aVar), this.f21456m, w3, bVar, this.f21454k, this.f21457n, this.f21458o, this.f21459p);
    }

    @Override // com.google.android.exoplayer2.source.s
    public void f() throws IOException {
        this.f21460q.k();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.c
    public void h(com.google.android.exoplayer2.source.hls.playlist.c cVar) {
        n0 F;
        long e2 = cVar.f21702p ? com.google.android.exoplayer2.h.e(cVar.f21694h) : -9223372036854775807L;
        int i10 = cVar.f21690d;
        long j10 = (i10 == 2 || i10 == 1) ? e2 : -9223372036854775807L;
        h hVar = new h((com.google.android.exoplayer2.source.hls.playlist.b) com.google.android.exoplayer2.util.a.e(this.f21460q.c()), cVar);
        if (this.f21460q.i()) {
            F = E(cVar, j10, e2, hVar);
        } else {
            F = F(cVar, j10, e2, hVar);
        }
        C(F);
    }

    @Override // com.google.android.exoplayer2.source.s
    public void j(com.google.android.exoplayer2.source.p pVar) {
        ((k) pVar).z();
    }

    public HlsMediaSource(w0 w0Var, f fVar, g gVar, com.google.android.exoplayer2.source.g gVar2, com.google.android.exoplayer2.drm.c cVar, com.google.android.exoplayer2.upstream.h hVar, HlsPlaylistTracker hlsPlaylistTracker, long j10, boolean z10, int i10, boolean z11) {
        this.f21452i = (w0.g) com.google.android.exoplayer2.util.a.e(w0Var.f23163b);
        this.f21462s = w0Var;
        this.f21463t = w0Var.f23164c;
        this.f21453j = fVar;
        this.f21451h = gVar;
        this.f21454k = gVar2;
        this.f21455l = cVar;
        this.f21456m = hVar;
        this.f21460q = hlsPlaylistTracker;
        this.f21461r = j10;
        this.f21457n = z10;
        this.f21458o = i10;
        this.f21459p = z11;
    }
}
