package com.google.android.exoplayer2.source.hls.playlist;

import a6.e;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.hls.f;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.a;
import com.google.android.exoplayer2.source.hls.playlist.b;
import com.google.android.exoplayer2.source.hls.playlist.c;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.z;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.h;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.util.j0;
import com.google.common.collect.g0;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: DefaultHlsPlaylistTracker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a implements HlsPlaylistTracker, Loader.b<i<e>> {

    /* renamed from: q, reason: collision with root package name */
    public static final HlsPlaylistTracker.a f21641q = new HlsPlaylistTracker.a() { // from class: a6.b
        @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.a
        public final HlsPlaylistTracker a(com.google.android.exoplayer2.source.hls.f fVar, h hVar, f fVar2) {
            return new com.google.android.exoplayer2.source.hls.playlist.a(fVar, hVar, fVar2);
        }
    };

    /* renamed from: b, reason: collision with root package name */
    public final f f21642b;

    /* renamed from: c, reason: collision with root package name */
    public final a6.f f21643c;

    /* renamed from: d, reason: collision with root package name */
    public final h f21644d;

    /* renamed from: e, reason: collision with root package name */
    public final HashMap<Uri, c> f21645e;

    /* renamed from: f, reason: collision with root package name */
    public final CopyOnWriteArrayList<HlsPlaylistTracker.b> f21646f;

    /* renamed from: g, reason: collision with root package name */
    public final double f21647g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public z.a f21648h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public Loader f21649i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public Handler f21650j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public HlsPlaylistTracker.c f21651k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.source.hls.playlist.b f21652l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public Uri f21653m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.source.hls.playlist.c f21654n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f21655o;

    /* renamed from: p, reason: collision with root package name */
    public long f21656p;

    /* compiled from: DefaultHlsPlaylistTracker.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class b implements HlsPlaylistTracker.b {
        public b() {
        }

        @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
        public void a() {
            a.this.f21646f.remove(this);
        }

        @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
        public boolean c(Uri uri, h.c cVar, boolean z10) {
            c cVar2;
            if (a.this.f21654n == null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                List<b.C0198b> list = ((com.google.android.exoplayer2.source.hls.playlist.b) j0.j(a.this.f21652l)).f21671e;
                int i10 = 0;
                for (int i11 = 0; i11 < list.size(); i11++) {
                    c cVar3 = (c) a.this.f21645e.get(list.get(i11).f21684a);
                    if (cVar3 != null && elapsedRealtime < cVar3.f21665i) {
                        i10++;
                    }
                }
                h.b b4 = a.this.f21644d.b(new h.a(1, 0, a.this.f21652l.f21671e.size(), i10), cVar);
                if (b4 != null && b4.f22890a == 2 && (cVar2 = (c) a.this.f21645e.get(uri)) != null) {
                    cVar2.h(b4.f22891b);
                }
            }
            return false;
        }
    }

    /* compiled from: DefaultHlsPlaylistTracker.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class c implements Loader.b<i<e>> {

        /* renamed from: b, reason: collision with root package name */
        public final Uri f21658b;

        /* renamed from: c, reason: collision with root package name */
        public final Loader f21659c = new Loader("DefaultHlsPlaylistTracker:MediaPlaylist");

        /* renamed from: d, reason: collision with root package name */
        public final com.google.android.exoplayer2.upstream.a f21660d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        public com.google.android.exoplayer2.source.hls.playlist.c f21661e;

        /* renamed from: f, reason: collision with root package name */
        public long f21662f;

        /* renamed from: g, reason: collision with root package name */
        public long f21663g;

        /* renamed from: h, reason: collision with root package name */
        public long f21664h;

        /* renamed from: i, reason: collision with root package name */
        public long f21665i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f21666j;

        /* renamed from: k, reason: collision with root package name */
        @Nullable
        public IOException f21667k;

        public c(Uri uri) {
            this.f21658b = uri;
            this.f21660d = a.this.f21642b.a(4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(Uri uri) {
            this.f21666j = false;
            p(uri);
        }

        public final boolean h(long j10) {
            this.f21665i = SystemClock.elapsedRealtime() + j10;
            return this.f21658b.equals(a.this.f21653m) && !a.this.L();
        }

        public final Uri i() {
            com.google.android.exoplayer2.source.hls.playlist.c cVar = this.f21661e;
            if (cVar != null) {
                c.f fVar = cVar.f21708v;
                if (fVar.f21727a != -9223372036854775807L || fVar.f21731e) {
                    Uri.Builder buildUpon = this.f21658b.buildUpon();
                    com.google.android.exoplayer2.source.hls.playlist.c cVar2 = this.f21661e;
                    if (cVar2.f21708v.f21731e) {
                        buildUpon.appendQueryParameter("_HLS_msn", String.valueOf(cVar2.f21697k + cVar2.f21704r.size()));
                        com.google.android.exoplayer2.source.hls.playlist.c cVar3 = this.f21661e;
                        if (cVar3.f21700n != -9223372036854775807L) {
                            List<c.b> list = cVar3.f21705s;
                            int size = list.size();
                            if (!list.isEmpty() && ((c.b) g0.f(list)).f21710n) {
                                size--;
                            }
                            buildUpon.appendQueryParameter("_HLS_part", String.valueOf(size));
                        }
                    }
                    c.f fVar2 = this.f21661e.f21708v;
                    if (fVar2.f21727a != -9223372036854775807L) {
                        buildUpon.appendQueryParameter("_HLS_skip", fVar2.f21728b ? "v2" : "YES");
                    }
                    return buildUpon.build();
                }
            }
            return this.f21658b;
        }

        @Nullable
        public com.google.android.exoplayer2.source.hls.playlist.c j() {
            return this.f21661e;
        }

        public boolean k() {
            int i10;
            if (this.f21661e == null) {
                return false;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long max = Math.max(30000L, com.google.android.exoplayer2.h.e(this.f21661e.f21707u));
            com.google.android.exoplayer2.source.hls.playlist.c cVar = this.f21661e;
            return cVar.f21701o || (i10 = cVar.f21690d) == 2 || i10 == 1 || this.f21662f + max > elapsedRealtime;
        }

        public void m() {
            r(this.f21658b);
        }

        public final void p(Uri uri) {
            i iVar = new i(this.f21660d, uri, 4, a.this.f21643c.a(a.this.f21652l, this.f21661e));
            a.this.f21648h.z(new m(iVar.f22896a, iVar.f22897b, this.f21659c.n(iVar, this, a.this.f21644d.d(iVar.f22898c))), iVar.f22898c);
        }

        public final void r(final Uri uri) {
            this.f21665i = 0L;
            if (this.f21666j || this.f21659c.j() || this.f21659c.i()) {
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime < this.f21664h) {
                this.f21666j = true;
                a.this.f21650j.postDelayed(new Runnable() { // from class: a6.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.c.this.l(uri);
                    }
                }, this.f21664h - elapsedRealtime);
            } else {
                p(uri);
            }
        }

        public void s() throws IOException {
            this.f21659c.a();
            IOException iOException = this.f21667k;
            if (iOException != null) {
                throw iOException;
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public void n(i<e> iVar, long j10, long j11, boolean z10) {
            m mVar = new m(iVar.f22896a, iVar.f22897b, iVar.e(), iVar.c(), j10, j11, iVar.a());
            a.this.f21644d.c(iVar.f22896a);
            a.this.f21648h.q(mVar, 4);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public void o(i<e> iVar, long j10, long j11) {
            e d10 = iVar.d();
            m mVar = new m(iVar.f22896a, iVar.f22897b, iVar.e(), iVar.c(), j10, j11, iVar.a());
            if (d10 instanceof com.google.android.exoplayer2.source.hls.playlist.c) {
                w((com.google.android.exoplayer2.source.hls.playlist.c) d10, mVar);
                a.this.f21648h.t(mVar, 4);
            } else {
                this.f21667k = ParserException.createForMalformedManifest("Loaded playlist has unexpected type.", null);
                a.this.f21648h.x(mVar, 4, this.f21667k, true);
            }
            a.this.f21644d.c(iVar.f22896a);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public Loader.c q(i<e> iVar, long j10, long j11, IOException iOException, int i10) {
            Loader.c cVar;
            m mVar = new m(iVar.f22896a, iVar.f22897b, iVar.e(), iVar.c(), j10, j11, iVar.a());
            boolean z10 = iOException instanceof HlsPlaylistParser.DeltaUpdateException;
            if ((iVar.e().getQueryParameter("_HLS_msn") != null) || z10) {
                int i11 = iOException instanceof HttpDataSource.InvalidResponseCodeException ? ((HttpDataSource.InvalidResponseCodeException) iOException).responseCode : Integer.MAX_VALUE;
                if (z10 || i11 == 400 || i11 == 503) {
                    this.f21664h = SystemClock.elapsedRealtime();
                    m();
                    ((z.a) j0.j(a.this.f21648h)).x(mVar, iVar.f22898c, iOException, true);
                    return Loader.f22732f;
                }
            }
            h.c cVar2 = new h.c(mVar, new MediaLoadData(iVar.f22898c), iOException, i10);
            if (a.this.N(this.f21658b, cVar2, false)) {
                long a10 = a.this.f21644d.a(cVar2);
                if (a10 != -9223372036854775807L) {
                    cVar = Loader.h(false, a10);
                } else {
                    cVar = Loader.f22733g;
                }
            } else {
                cVar = Loader.f22732f;
            }
            boolean c4 = true ^ cVar.c();
            a.this.f21648h.x(mVar, iVar.f22898c, iOException, c4);
            if (c4) {
                a.this.f21644d.c(iVar.f22896a);
            }
            return cVar;
        }

        public final void w(com.google.android.exoplayer2.source.hls.playlist.c cVar, m mVar) {
            IOException playlistStuckException;
            boolean z10;
            com.google.android.exoplayer2.source.hls.playlist.c cVar2 = this.f21661e;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f21662f = elapsedRealtime;
            com.google.android.exoplayer2.source.hls.playlist.c G = a.this.G(cVar2, cVar);
            this.f21661e = G;
            if (G != cVar2) {
                this.f21667k = null;
                this.f21663g = elapsedRealtime;
                a.this.R(this.f21658b, G);
            } else if (!G.f21701o) {
                long size = cVar.f21697k + cVar.f21704r.size();
                com.google.android.exoplayer2.source.hls.playlist.c cVar3 = this.f21661e;
                if (size < cVar3.f21697k) {
                    playlistStuckException = new HlsPlaylistTracker.PlaylistResetException(this.f21658b);
                    z10 = true;
                } else {
                    playlistStuckException = ((double) (elapsedRealtime - this.f21663g)) > ((double) com.google.android.exoplayer2.h.e(cVar3.f21699m)) * a.this.f21647g ? new HlsPlaylistTracker.PlaylistStuckException(this.f21658b) : null;
                    z10 = false;
                }
                if (playlistStuckException != null) {
                    this.f21667k = playlistStuckException;
                    a.this.N(this.f21658b, new h.c(mVar, new MediaLoadData(4), playlistStuckException, 1), z10);
                }
            }
            long j10 = 0;
            com.google.android.exoplayer2.source.hls.playlist.c cVar4 = this.f21661e;
            if (!cVar4.f21708v.f21731e) {
                if (cVar4 != cVar2) {
                    j10 = cVar4.f21699m;
                } else {
                    j10 = cVar4.f21699m / 2;
                }
            }
            this.f21664h = elapsedRealtime + com.google.android.exoplayer2.h.e(j10);
            if (!(this.f21661e.f21700n != -9223372036854775807L || this.f21658b.equals(a.this.f21653m)) || this.f21661e.f21701o) {
                return;
            }
            r(i());
        }

        public void x() {
            this.f21659c.l();
        }
    }

    public a(f fVar, h hVar, a6.f fVar2) {
        this(fVar, hVar, fVar2, 3.5d);
    }

    public static c.d F(com.google.android.exoplayer2.source.hls.playlist.c cVar, com.google.android.exoplayer2.source.hls.playlist.c cVar2) {
        int i10 = (int) (cVar2.f21697k - cVar.f21697k);
        List<c.d> list = cVar.f21704r;
        if (i10 < list.size()) {
            return list.get(i10);
        }
        return null;
    }

    public final void E(List<Uri> list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            Uri uri = list.get(i10);
            this.f21645e.put(uri, new c(uri));
        }
    }

    public final com.google.android.exoplayer2.source.hls.playlist.c G(@Nullable com.google.android.exoplayer2.source.hls.playlist.c cVar, com.google.android.exoplayer2.source.hls.playlist.c cVar2) {
        if (cVar2.f(cVar)) {
            return cVar2.c(I(cVar, cVar2), H(cVar, cVar2));
        }
        return cVar2.f21701o ? cVar.d() : cVar;
    }

    public final int H(@Nullable com.google.android.exoplayer2.source.hls.playlist.c cVar, com.google.android.exoplayer2.source.hls.playlist.c cVar2) {
        c.d F;
        if (cVar2.f21695i) {
            return cVar2.f21696j;
        }
        com.google.android.exoplayer2.source.hls.playlist.c cVar3 = this.f21654n;
        int i10 = cVar3 != null ? cVar3.f21696j : 0;
        return (cVar == null || (F = F(cVar, cVar2)) == null) ? i10 : (cVar.f21696j + F.f21719e) - cVar2.f21704r.get(0).f21719e;
    }

    public final long I(@Nullable com.google.android.exoplayer2.source.hls.playlist.c cVar, com.google.android.exoplayer2.source.hls.playlist.c cVar2) {
        if (cVar2.f21702p) {
            return cVar2.f21694h;
        }
        com.google.android.exoplayer2.source.hls.playlist.c cVar3 = this.f21654n;
        long j10 = cVar3 != null ? cVar3.f21694h : 0L;
        if (cVar == null) {
            return j10;
        }
        int size = cVar.f21704r.size();
        c.d F = F(cVar, cVar2);
        if (F != null) {
            return cVar.f21694h + F.f21720f;
        }
        return ((long) size) == cVar2.f21697k - cVar.f21697k ? cVar.e() : j10;
    }

    public final Uri J(Uri uri) {
        c.C0199c c0199c;
        com.google.android.exoplayer2.source.hls.playlist.c cVar = this.f21654n;
        if (cVar == null || !cVar.f21708v.f21731e || (c0199c = cVar.f21706t.get(uri)) == null) {
            return uri;
        }
        Uri.Builder buildUpon = uri.buildUpon();
        buildUpon.appendQueryParameter("_HLS_msn", String.valueOf(c0199c.f21712b));
        int i10 = c0199c.f21713c;
        if (i10 != -1) {
            buildUpon.appendQueryParameter("_HLS_part", String.valueOf(i10));
        }
        return buildUpon.build();
    }

    public final boolean K(Uri uri) {
        List<b.C0198b> list = this.f21652l.f21671e;
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (uri.equals(list.get(i10).f21684a)) {
                return true;
            }
        }
        return false;
    }

    public final boolean L() {
        List<b.C0198b> list = this.f21652l.f21671e;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i10 = 0; i10 < size; i10++) {
            c cVar = (c) com.google.android.exoplayer2.util.a.e(this.f21645e.get(list.get(i10).f21684a));
            if (elapsedRealtime > cVar.f21665i) {
                Uri uri = cVar.f21658b;
                this.f21653m = uri;
                cVar.r(J(uri));
                return true;
            }
        }
        return false;
    }

    public final void M(Uri uri) {
        if (uri.equals(this.f21653m) || !K(uri)) {
            return;
        }
        com.google.android.exoplayer2.source.hls.playlist.c cVar = this.f21654n;
        if (cVar == null || !cVar.f21701o) {
            this.f21653m = uri;
            c cVar2 = this.f21645e.get(uri);
            com.google.android.exoplayer2.source.hls.playlist.c cVar3 = cVar2.f21661e;
            if (cVar3 != null && cVar3.f21701o) {
                this.f21654n = cVar3;
                this.f21651k.h(cVar3);
            } else {
                cVar2.r(J(uri));
            }
        }
    }

    public final boolean N(Uri uri, h.c cVar, boolean z10) {
        Iterator<HlsPlaylistTracker.b> iterator2 = this.f21646f.iterator2();
        boolean z11 = false;
        while (iterator2.hasNext()) {
            z11 |= !iterator2.next().c(uri, cVar, z10);
        }
        return z11;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void n(i<e> iVar, long j10, long j11, boolean z10) {
        m mVar = new m(iVar.f22896a, iVar.f22897b, iVar.e(), iVar.c(), j10, j11, iVar.a());
        this.f21644d.c(iVar.f22896a);
        this.f21648h.q(mVar, 4);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public void o(i<e> iVar, long j10, long j11) {
        com.google.android.exoplayer2.source.hls.playlist.b bVar;
        e d10 = iVar.d();
        boolean z10 = d10 instanceof com.google.android.exoplayer2.source.hls.playlist.c;
        if (z10) {
            bVar = com.google.android.exoplayer2.source.hls.playlist.b.e(d10.f711a);
        } else {
            bVar = (com.google.android.exoplayer2.source.hls.playlist.b) d10;
        }
        this.f21652l = bVar;
        this.f21653m = bVar.f21671e.get(0).f21684a;
        this.f21646f.add(new b());
        E(bVar.f21670d);
        m mVar = new m(iVar.f22896a, iVar.f22897b, iVar.e(), iVar.c(), j10, j11, iVar.a());
        c cVar = this.f21645e.get(this.f21653m);
        if (z10) {
            cVar.w((com.google.android.exoplayer2.source.hls.playlist.c) d10, mVar);
        } else {
            cVar.m();
        }
        this.f21644d.c(iVar.f22896a);
        this.f21648h.t(mVar, 4);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public Loader.c q(i<e> iVar, long j10, long j11, IOException iOException, int i10) {
        m mVar = new m(iVar.f22896a, iVar.f22897b, iVar.e(), iVar.c(), j10, j11, iVar.a());
        long a10 = this.f21644d.a(new h.c(mVar, new MediaLoadData(iVar.f22898c), iOException, i10));
        boolean z10 = a10 == -9223372036854775807L;
        this.f21648h.x(mVar, iVar.f22898c, iOException, z10);
        if (z10) {
            this.f21644d.c(iVar.f22896a);
        }
        if (z10) {
            return Loader.f22733g;
        }
        return Loader.h(false, a10);
    }

    public final void R(Uri uri, com.google.android.exoplayer2.source.hls.playlist.c cVar) {
        if (uri.equals(this.f21653m)) {
            if (this.f21654n == null) {
                this.f21655o = !cVar.f21701o;
                this.f21656p = cVar.f21694h;
            }
            this.f21654n = cVar;
            this.f21651k.h(cVar);
        }
        Iterator<HlsPlaylistTracker.b> iterator2 = this.f21646f.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().a();
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void a(HlsPlaylistTracker.b bVar) {
        this.f21646f.remove(bVar);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public long b() {
        return this.f21656p;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    @Nullable
    public com.google.android.exoplayer2.source.hls.playlist.b c() {
        return this.f21652l;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void d(Uri uri, z.a aVar, HlsPlaylistTracker.c cVar) {
        this.f21650j = j0.x();
        this.f21648h = aVar;
        this.f21651k = cVar;
        i iVar = new i(this.f21642b.a(4), uri, 4, this.f21643c.b());
        com.google.android.exoplayer2.util.a.g(this.f21649i == null);
        Loader loader = new Loader("DefaultHlsPlaylistTracker:MasterPlaylist");
        this.f21649i = loader;
        aVar.z(new m(iVar.f22896a, iVar.f22897b, loader.n(iVar, this, this.f21644d.d(iVar.f22898c))), iVar.f22898c);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void e(Uri uri) throws IOException {
        this.f21645e.get(uri).s();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void f(Uri uri) {
        this.f21645e.get(uri).m();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void g(HlsPlaylistTracker.b bVar) {
        com.google.android.exoplayer2.util.a.e(bVar);
        this.f21646f.add(bVar);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean h(Uri uri) {
        return this.f21645e.get(uri).k();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean i() {
        return this.f21655o;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean j(Uri uri, long j10) {
        if (this.f21645e.get(uri) != null) {
            return !r2.h(j10);
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void k() throws IOException {
        Loader loader = this.f21649i;
        if (loader != null) {
            loader.a();
        }
        Uri uri = this.f21653m;
        if (uri != null) {
            e(uri);
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    @Nullable
    public com.google.android.exoplayer2.source.hls.playlist.c l(Uri uri, boolean z10) {
        com.google.android.exoplayer2.source.hls.playlist.c j10 = this.f21645e.get(uri).j();
        if (j10 != null && z10) {
            M(uri);
        }
        return j10;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void stop() {
        this.f21653m = null;
        this.f21654n = null;
        this.f21652l = null;
        this.f21656p = -9223372036854775807L;
        this.f21649i.l();
        this.f21649i = null;
        Iterator<c> iterator2 = this.f21645e.values().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().x();
        }
        this.f21650j.removeCallbacksAndMessages(null);
        this.f21650j = null;
        this.f21645e.clear();
    }

    public a(f fVar, h hVar, a6.f fVar2, double d10) {
        this.f21642b = fVar;
        this.f21643c = fVar2;
        this.f21644d = hVar;
        this.f21647g = d10;
        this.f21646f = new CopyOnWriteArrayList<>();
        this.f21645e = new HashMap<>();
        this.f21656p = -9223372036854775807L;
    }
}
