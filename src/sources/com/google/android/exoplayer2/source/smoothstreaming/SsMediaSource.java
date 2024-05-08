package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import b5.u;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.r0;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.a0;
import com.google.android.exoplayer2.source.g;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.n0;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.a;
import com.google.android.exoplayer2.source.smoothstreaming.b;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.a;
import com.google.android.exoplayer2.source.z;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.upstream.h;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.w0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import o6.r;
import o6.v;
import u5.e;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SsMediaSource extends com.google.android.exoplayer2.source.a implements Loader.b<i<com.google.android.exoplayer2.source.smoothstreaming.manifest.a>> {
    public Handler A;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f22016h;

    /* renamed from: i, reason: collision with root package name */
    public final Uri f22017i;

    /* renamed from: j, reason: collision with root package name */
    public final w0.g f22018j;

    /* renamed from: k, reason: collision with root package name */
    public final w0 f22019k;

    /* renamed from: l, reason: collision with root package name */
    public final a.InterfaceC0208a f22020l;

    /* renamed from: m, reason: collision with root package name */
    public final b.a f22021m;

    /* renamed from: n, reason: collision with root package name */
    public final g f22022n;

    /* renamed from: o, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.c f22023o;

    /* renamed from: p, reason: collision with root package name */
    public final h f22024p;

    /* renamed from: q, reason: collision with root package name */
    public final long f22025q;

    /* renamed from: r, reason: collision with root package name */
    public final z.a f22026r;

    /* renamed from: s, reason: collision with root package name */
    public final i.a<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.a> f22027s;

    /* renamed from: t, reason: collision with root package name */
    public final ArrayList<c> f22028t;

    /* renamed from: u, reason: collision with root package name */
    public com.google.android.exoplayer2.upstream.a f22029u;

    /* renamed from: v, reason: collision with root package name */
    public Loader f22030v;

    /* renamed from: w, reason: collision with root package name */
    public r f22031w;

    /* renamed from: x, reason: collision with root package name */
    @Nullable
    public v f22032x;

    /* renamed from: y, reason: collision with root package name */
    public long f22033y;

    /* renamed from: z, reason: collision with root package name */
    public com.google.android.exoplayer2.source.smoothstreaming.manifest.a f22034z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class Factory implements a0 {

        /* renamed from: a, reason: collision with root package name */
        public final b.a f22035a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final a.InterfaceC0208a f22036b;

        /* renamed from: c, reason: collision with root package name */
        public g f22037c;

        /* renamed from: d, reason: collision with root package name */
        public u f22038d;

        /* renamed from: e, reason: collision with root package name */
        public h f22039e;

        /* renamed from: f, reason: collision with root package name */
        public long f22040f;

        /* renamed from: g, reason: collision with root package name */
        @Nullable
        public i.a<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.a> f22041g;

        /* renamed from: h, reason: collision with root package name */
        public List<StreamKey> f22042h;

        /* renamed from: i, reason: collision with root package name */
        @Nullable
        public Object f22043i;

        public Factory(a.InterfaceC0208a interfaceC0208a) {
            this(new a.C0204a(interfaceC0208a), interfaceC0208a);
        }

        @Override // com.google.android.exoplayer2.source.a0
        public int[] a() {
            return new int[]{1};
        }

        @Override // com.google.android.exoplayer2.source.a0
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public SsMediaSource b(w0 w0Var) {
            List<StreamKey> list;
            w0 w0Var2 = w0Var;
            com.google.android.exoplayer2.util.a.e(w0Var2.f23163b);
            i.a aVar = this.f22041g;
            if (aVar == null) {
                aVar = new SsManifestParser();
            }
            if (!w0Var2.f23163b.f23220e.isEmpty()) {
                list = w0Var2.f23163b.f23220e;
            } else {
                list = this.f22042h;
            }
            i.a eVar = !list.isEmpty() ? new e(aVar, list) : aVar;
            w0.g gVar = w0Var2.f23163b;
            boolean z10 = gVar.f23223h == null && this.f22043i != null;
            boolean z11 = gVar.f23220e.isEmpty() && !list.isEmpty();
            if (z10 && z11) {
                w0Var2 = w0Var.a().s(this.f22043i).q(list).a();
            } else if (z10) {
                w0Var2 = w0Var.a().s(this.f22043i).a();
            } else if (z11) {
                w0Var2 = w0Var.a().q(list).a();
            }
            w0 w0Var3 = w0Var2;
            return new SsMediaSource(w0Var3, null, this.f22036b, eVar, this.f22035a, this.f22037c, this.f22038d.a(w0Var3), this.f22039e, this.f22040f);
        }

        public Factory(b.a aVar, @Nullable a.InterfaceC0208a interfaceC0208a) {
            this.f22035a = (b.a) com.google.android.exoplayer2.util.a.e(aVar);
            this.f22036b = interfaceC0208a;
            this.f22038d = new com.google.android.exoplayer2.drm.a();
            this.f22039e = new f();
            this.f22040f = 30000L;
            this.f22037c = new com.google.android.exoplayer2.source.h();
            this.f22042h = Collections.emptyList();
        }
    }

    static {
        r0.a("goog.exo.smoothstreaming");
    }

    @Override // com.google.android.exoplayer2.source.a
    public void B(@Nullable v vVar) {
        this.f22032x = vVar;
        this.f22023o.prepare();
        if (this.f22016h) {
            this.f22031w = new r.a();
            I();
            return;
        }
        this.f22029u = this.f22020l.a();
        Loader loader = new Loader("SsMediaSource");
        this.f22030v = loader;
        this.f22031w = loader;
        this.A = j0.x();
        K();
    }

    @Override // com.google.android.exoplayer2.source.a
    public void D() {
        this.f22034z = this.f22016h ? this.f22034z : null;
        this.f22029u = null;
        this.f22033y = 0L;
        Loader loader = this.f22030v;
        if (loader != null) {
            loader.l();
            this.f22030v = null;
        }
        Handler handler = this.A;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.A = null;
        }
        this.f22023o.release();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void n(i<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> iVar, long j10, long j11, boolean z10) {
        m mVar = new m(iVar.f22896a, iVar.f22897b, iVar.e(), iVar.c(), j10, j11, iVar.a());
        this.f22024p.c(iVar.f22896a);
        this.f22026r.q(mVar, iVar.f22898c);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void o(i<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> iVar, long j10, long j11) {
        m mVar = new m(iVar.f22896a, iVar.f22897b, iVar.e(), iVar.c(), j10, j11, iVar.a());
        this.f22024p.c(iVar.f22896a);
        this.f22026r.t(mVar, iVar.f22898c);
        this.f22034z = iVar.d();
        this.f22033y = j10 - j11;
        I();
        J();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public Loader.c q(i<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> iVar, long j10, long j11, IOException iOException, int i10) {
        Loader.c h10;
        m mVar = new m(iVar.f22896a, iVar.f22897b, iVar.e(), iVar.c(), j10, j11, iVar.a());
        long a10 = this.f22024p.a(new h.c(mVar, new MediaLoadData(iVar.f22898c), iOException, i10));
        if (a10 == -9223372036854775807L) {
            h10 = Loader.f22733g;
        } else {
            h10 = Loader.h(false, a10);
        }
        boolean z10 = !h10.c();
        this.f22026r.x(mVar, iVar.f22898c, iOException, z10);
        if (z10) {
            this.f22024p.c(iVar.f22896a);
        }
        return h10;
    }

    public final void I() {
        n0 n0Var;
        for (int i10 = 0; i10 < this.f22028t.size(); i10++) {
            this.f22028t.get(i10).u(this.f22034z);
        }
        long j10 = Long.MIN_VALUE;
        long j11 = Long.MAX_VALUE;
        for (a.b bVar : this.f22034z.f22106f) {
            if (bVar.f22122k > 0) {
                j11 = Math.min(j11, bVar.e(0));
                j10 = Math.max(j10, bVar.e(bVar.f22122k - 1) + bVar.c(bVar.f22122k - 1));
            }
        }
        if (j11 == Long.MAX_VALUE) {
            long j12 = this.f22034z.f22104d ? -9223372036854775807L : 0L;
            com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar = this.f22034z;
            boolean z10 = aVar.f22104d;
            n0Var = new n0(j12, 0L, 0L, 0L, true, z10, z10, aVar, this.f22019k);
        } else {
            com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar2 = this.f22034z;
            if (aVar2.f22104d) {
                long j13 = aVar2.f22108h;
                if (j13 != -9223372036854775807L && j13 > 0) {
                    j11 = Math.max(j11, j10 - j13);
                }
                long j14 = j11;
                long j15 = j10 - j14;
                long d10 = j15 - com.google.android.exoplayer2.h.d(this.f22025q);
                if (d10 < 5000000) {
                    d10 = Math.min(5000000L, j15 / 2);
                }
                n0Var = new n0(-9223372036854775807L, j15, j14, d10, true, true, true, this.f22034z, this.f22019k);
            } else {
                long j16 = aVar2.f22107g;
                long j17 = j16 != -9223372036854775807L ? j16 : j10 - j11;
                n0Var = new n0(j11 + j17, j17, j11, 0L, true, false, false, this.f22034z, this.f22019k);
            }
        }
        C(n0Var);
    }

    public final void J() {
        if (this.f22034z.f22104d) {
            this.A.postDelayed(new Runnable() { // from class: d6.a
                @Override // java.lang.Runnable
                public final void run() {
                    SsMediaSource.this.K();
                }
            }, Math.max(0L, (this.f22033y + 5000) - SystemClock.elapsedRealtime()));
        }
    }

    public final void K() {
        if (this.f22030v.i()) {
            return;
        }
        i iVar = new i(this.f22029u, this.f22017i, 4, this.f22027s);
        this.f22026r.z(new m(iVar.f22896a, iVar.f22897b, this.f22030v.n(iVar, this, this.f22024p.d(iVar.f22898c))), iVar.f22898c);
    }

    @Override // com.google.android.exoplayer2.source.s
    public w0 d() {
        return this.f22019k;
    }

    @Override // com.google.android.exoplayer2.source.s
    public p e(s.a aVar, o6.b bVar, long j10) {
        z.a w3 = w(aVar);
        c cVar = new c(this.f22034z, this.f22021m, this.f22032x, this.f22022n, this.f22023o, u(aVar), this.f22024p, w3, this.f22031w, bVar);
        this.f22028t.add(cVar);
        return cVar;
    }

    @Override // com.google.android.exoplayer2.source.s
    public void f() throws IOException {
        this.f22031w.a();
    }

    @Override // com.google.android.exoplayer2.source.s
    public void j(p pVar) {
        ((c) pVar).r();
        this.f22028t.remove(pVar);
    }

    public SsMediaSource(w0 w0Var, @Nullable com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, @Nullable a.InterfaceC0208a interfaceC0208a, @Nullable i.a<? extends com.google.android.exoplayer2.source.smoothstreaming.manifest.a> aVar2, b.a aVar3, g gVar, com.google.android.exoplayer2.drm.c cVar, h hVar, long j10) {
        com.google.android.exoplayer2.util.a.g(aVar == null || !aVar.f22104d);
        this.f22019k = w0Var;
        w0.g gVar2 = (w0.g) com.google.android.exoplayer2.util.a.e(w0Var.f23163b);
        this.f22018j = gVar2;
        this.f22034z = aVar;
        this.f22017i = gVar2.f23216a.equals(Uri.EMPTY) ? null : j0.C(gVar2.f23216a);
        this.f22020l = interfaceC0208a;
        this.f22027s = aVar2;
        this.f22021m = aVar3;
        this.f22022n = gVar;
        this.f22023o = cVar;
        this.f22024p = hVar;
        this.f22025q = j10;
        this.f22026r = w(null);
        this.f22016h = aVar != null;
        this.f22028t = new ArrayList<>();
    }
}
