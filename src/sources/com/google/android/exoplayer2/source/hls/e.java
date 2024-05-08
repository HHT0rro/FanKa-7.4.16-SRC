package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.c;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.b;
import com.google.android.exoplayer2.util.h0;
import com.google.android.exoplayer2.util.j0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.g0;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import o6.v;

/* compiled from: HlsChunkSource.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final g f21499a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.a f21500b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.a f21501c;

    /* renamed from: d, reason: collision with root package name */
    public final q f21502d;

    /* renamed from: e, reason: collision with root package name */
    public final Uri[] f21503e;

    /* renamed from: f, reason: collision with root package name */
    public final Format[] f21504f;

    /* renamed from: g, reason: collision with root package name */
    public final HlsPlaylistTracker f21505g;

    /* renamed from: h, reason: collision with root package name */
    public final TrackGroup f21506h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public final List<Format> f21507i;

    /* renamed from: k, reason: collision with root package name */
    public boolean f21509k;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public IOException f21511m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public Uri f21512n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f21513o;

    /* renamed from: p, reason: collision with root package name */
    public ExoTrackSelection f21514p;

    /* renamed from: r, reason: collision with root package name */
    public boolean f21516r;

    /* renamed from: j, reason: collision with root package name */
    public final FullSegmentEncryptionKeyCache f21508j = new FullSegmentEncryptionKeyCache(4);

    /* renamed from: l, reason: collision with root package name */
    public byte[] f21510l = j0.f22995f;

    /* renamed from: q, reason: collision with root package name */
    public long f21515q = -9223372036854775807L;

    /* compiled from: HlsChunkSource.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends x5.l {

        /* renamed from: l, reason: collision with root package name */
        public byte[] f21517l;

        public a(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, Format format, int i10, @Nullable Object obj, byte[] bArr) {
            super(aVar, bVar, 3, format, i10, obj, bArr);
        }

        @Override // x5.l
        public void f(byte[] bArr, int i10) {
            this.f21517l = Arrays.copyOf(bArr, i10);
        }

        @Nullable
        public byte[] i() {
            return this.f21517l;
        }
    }

    /* compiled from: HlsChunkSource.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        public x5.f f21518a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f21519b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public Uri f21520c;

        public b() {
            a();
        }

        public void a() {
            this.f21518a = null;
            this.f21519b = false;
            this.f21520c = null;
        }
    }

    /* compiled from: HlsChunkSource.java */
    @VisibleForTesting
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c extends x5.b {

        /* renamed from: e, reason: collision with root package name */
        public final List<c.e> f21521e;

        /* renamed from: f, reason: collision with root package name */
        public final long f21522f;

        /* renamed from: g, reason: collision with root package name */
        public final String f21523g;

        public c(String str, long j10, List<c.e> list) {
            super(0L, list.size() - 1);
            this.f21523g = str;
            this.f21522f = j10;
            this.f21521e = list;
        }

        @Override // x5.o
        public long a() {
            c();
            c.e eVar = this.f21521e.get((int) d());
            return this.f21522f + eVar.f21720f + eVar.f21718d;
        }

        @Override // x5.o
        public long b() {
            c();
            return this.f21522f + this.f21521e.get((int) d()).f21720f;
        }
    }

    /* compiled from: HlsChunkSource.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d extends n6.b {

        /* renamed from: h, reason: collision with root package name */
        public int f21524h;

        public d(TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
            this.f21524h = t(trackGroup.a(iArr[0]));
        }

        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
        public int a() {
            return this.f21524h;
        }

        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
        public void i(long j10, long j11, long j12, List<? extends x5.n> list, x5.o[] oVarArr) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (b(this.f21524h, elapsedRealtime)) {
                for (int i10 = this.f52131b - 1; i10 >= 0; i10--) {
                    if (!b(i10, elapsedRealtime)) {
                        this.f21524h = i10;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
        @Nullable
        public Object r() {
            return null;
        }

        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
        public int u() {
            return 0;
        }
    }

    /* compiled from: HlsChunkSource.java */
    /* renamed from: com.google.android.exoplayer2.source.hls.e$e, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class C0196e {

        /* renamed from: a, reason: collision with root package name */
        public final c.e f21525a;

        /* renamed from: b, reason: collision with root package name */
        public final long f21526b;

        /* renamed from: c, reason: collision with root package name */
        public final int f21527c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f21528d;

        public C0196e(c.e eVar, long j10, int i10) {
            this.f21525a = eVar;
            this.f21526b = j10;
            this.f21527c = i10;
            this.f21528d = (eVar instanceof c.b) && ((c.b) eVar).f21710n;
        }
    }

    public e(g gVar, HlsPlaylistTracker hlsPlaylistTracker, Uri[] uriArr, Format[] formatArr, f fVar, @Nullable v vVar, q qVar, @Nullable List<Format> list) {
        this.f21499a = gVar;
        this.f21505g = hlsPlaylistTracker;
        this.f21503e = uriArr;
        this.f21504f = formatArr;
        this.f21502d = qVar;
        this.f21507i = list;
        com.google.android.exoplayer2.upstream.a a10 = fVar.a(1);
        this.f21500b = a10;
        if (vVar != null) {
            a10.d(vVar);
        }
        this.f21501c = fVar.a(3);
        this.f21506h = new TrackGroup(formatArr);
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < uriArr.length; i10++) {
            if ((formatArr[i10].f19537f & 16384) == 0) {
                arrayList.add(Integer.valueOf(i10));
            }
        }
        this.f21514p = new d(this.f21506h, Ints.m(arrayList));
    }

    @Nullable
    public static Uri c(com.google.android.exoplayer2.source.hls.playlist.c cVar, @Nullable c.e eVar) {
        String str;
        if (eVar == null || (str = eVar.f21722h) == null) {
            return null;
        }
        return h0.e(cVar.f711a, str);
    }

    @Nullable
    public static C0196e f(com.google.android.exoplayer2.source.hls.playlist.c cVar, long j10, int i10) {
        int i11 = (int) (j10 - cVar.f21697k);
        if (i11 == cVar.f21704r.size()) {
            if (i10 == -1) {
                i10 = 0;
            }
            if (i10 < cVar.f21705s.size()) {
                return new C0196e(cVar.f21705s.get(i10), j10, i10);
            }
            return null;
        }
        c.d dVar = cVar.f21704r.get(i11);
        if (i10 == -1) {
            return new C0196e(dVar, j10, -1);
        }
        if (i10 < dVar.f21715n.size()) {
            return new C0196e(dVar.f21715n.get(i10), j10, i10);
        }
        int i12 = i11 + 1;
        if (i12 < cVar.f21704r.size()) {
            return new C0196e(cVar.f21704r.get(i12), j10 + 1, -1);
        }
        if (cVar.f21705s.isEmpty()) {
            return null;
        }
        return new C0196e(cVar.f21705s.get(0), j10 + 1, 0);
    }

    @VisibleForTesting
    public static List<c.e> h(com.google.android.exoplayer2.source.hls.playlist.c cVar, long j10, int i10) {
        int i11 = (int) (j10 - cVar.f21697k);
        if (i11 >= 0 && cVar.f21704r.size() >= i11) {
            ArrayList arrayList = new ArrayList();
            if (i11 < cVar.f21704r.size()) {
                if (i10 != -1) {
                    c.d dVar = cVar.f21704r.get(i11);
                    if (i10 == 0) {
                        arrayList.add(dVar);
                    } else if (i10 < dVar.f21715n.size()) {
                        List<c.b> list = dVar.f21715n;
                        arrayList.addAll(list.subList(i10, list.size()));
                    }
                    i11++;
                }
                List<c.d> list2 = cVar.f21704r;
                arrayList.addAll(list2.subList(i11, list2.size()));
                i10 = 0;
            }
            if (cVar.f21700n != -9223372036854775807L) {
                int i12 = i10 != -1 ? i10 : 0;
                if (i12 < cVar.f21705s.size()) {
                    List<c.b> list3 = cVar.f21705s;
                    arrayList.addAll(list3.subList(i12, list3.size()));
                }
            }
            return Collections.unmodifiableList(arrayList);
        }
        return ImmutableList.of();
    }

    public x5.o[] a(@Nullable i iVar, long j10) {
        int i10;
        int b4 = iVar == null ? -1 : this.f21506h.b(iVar.f54509d);
        int length = this.f21514p.length();
        x5.o[] oVarArr = new x5.o[length];
        boolean z10 = false;
        int i11 = 0;
        while (i11 < length) {
            int c4 = this.f21514p.c(i11);
            Uri uri = this.f21503e[c4];
            if (!this.f21505g.h(uri)) {
                oVarArr[i11] = x5.o.f54558a;
                i10 = i11;
            } else {
                com.google.android.exoplayer2.source.hls.playlist.c l10 = this.f21505g.l(uri, z10);
                com.google.android.exoplayer2.util.a.e(l10);
                long b10 = l10.f21694h - this.f21505g.b();
                i10 = i11;
                Pair<Long, Integer> e2 = e(iVar, c4 != b4, l10, b10, j10);
                oVarArr[i10] = new c(l10.f711a, b10, h(l10, ((Long) e2.first).longValue(), ((Integer) e2.second).intValue()));
            }
            i11 = i10 + 1;
            z10 = false;
        }
        return oVarArr;
    }

    public int b(i iVar) {
        List<c.b> list;
        if (iVar.f21536o == -1) {
            return 1;
        }
        com.google.android.exoplayer2.source.hls.playlist.c cVar = (com.google.android.exoplayer2.source.hls.playlist.c) com.google.android.exoplayer2.util.a.e(this.f21505g.l(this.f21503e[this.f21506h.b(iVar.f54509d)], false));
        int i10 = (int) (iVar.f54557j - cVar.f21697k);
        if (i10 < 0) {
            return 1;
        }
        if (i10 < cVar.f21704r.size()) {
            list = cVar.f21704r.get(i10).f21715n;
        } else {
            list = cVar.f21705s;
        }
        if (iVar.f21536o >= list.size()) {
            return 2;
        }
        c.b bVar = list.get(iVar.f21536o);
        if (bVar.f21710n) {
            return 0;
        }
        return j0.c(Uri.parse(h0.d(cVar.f711a, bVar.f21716b)), iVar.f54507b.f22767a) ? 1 : 2;
    }

    public void d(long j10, long j11, List<i> list, boolean z10, b bVar) {
        com.google.android.exoplayer2.source.hls.playlist.c cVar;
        long j12;
        Uri uri;
        int i10;
        i iVar = list.isEmpty() ? null : (i) g0.f(list);
        int b4 = iVar == null ? -1 : this.f21506h.b(iVar.f54509d);
        long j13 = j11 - j10;
        long r10 = r(j10);
        if (iVar != null && !this.f21513o) {
            long c4 = iVar.c();
            j13 = Math.max(0L, j13 - c4);
            if (r10 != -9223372036854775807L) {
                r10 = Math.max(0L, r10 - c4);
            }
        }
        this.f21514p.i(j10, j13, r10, list, a(iVar, j11));
        int l10 = this.f21514p.l();
        boolean z11 = b4 != l10;
        Uri uri2 = this.f21503e[l10];
        if (!this.f21505g.h(uri2)) {
            bVar.f21520c = uri2;
            this.f21516r &= uri2.equals(this.f21512n);
            this.f21512n = uri2;
            return;
        }
        com.google.android.exoplayer2.source.hls.playlist.c l11 = this.f21505g.l(uri2, true);
        com.google.android.exoplayer2.util.a.e(l11);
        this.f21513o = l11.f713c;
        v(l11);
        long b10 = l11.f21694h - this.f21505g.b();
        Pair<Long, Integer> e2 = e(iVar, z11, l11, b10, j11);
        long longValue = ((Long) e2.first).longValue();
        int intValue = ((Integer) e2.second).intValue();
        if (longValue >= l11.f21697k || iVar == null || !z11) {
            cVar = l11;
            j12 = b10;
            uri = uri2;
            i10 = l10;
        } else {
            Uri uri3 = this.f21503e[b4];
            com.google.android.exoplayer2.source.hls.playlist.c l12 = this.f21505g.l(uri3, true);
            com.google.android.exoplayer2.util.a.e(l12);
            j12 = l12.f21694h - this.f21505g.b();
            Pair<Long, Integer> e10 = e(iVar, false, l12, j12, j11);
            longValue = ((Long) e10.first).longValue();
            intValue = ((Integer) e10.second).intValue();
            i10 = b4;
            uri = uri3;
            cVar = l12;
        }
        if (longValue < cVar.f21697k) {
            this.f21511m = new BehindLiveWindowException();
            return;
        }
        C0196e f10 = f(cVar, longValue, intValue);
        if (f10 == null) {
            if (!cVar.f21701o) {
                bVar.f21520c = uri;
                this.f21516r &= uri.equals(this.f21512n);
                this.f21512n = uri;
                return;
            } else if (!z10 && !cVar.f21704r.isEmpty()) {
                f10 = new C0196e((c.e) g0.f(cVar.f21704r), (cVar.f21697k + cVar.f21704r.size()) - 1, -1);
            } else {
                bVar.f21519b = true;
                return;
            }
        }
        this.f21516r = false;
        this.f21512n = null;
        Uri c10 = c(cVar, f10.f21525a.f21717c);
        x5.f k10 = k(c10, i10);
        bVar.f21518a = k10;
        if (k10 != null) {
            return;
        }
        Uri c11 = c(cVar, f10.f21525a);
        x5.f k11 = k(c11, i10);
        bVar.f21518a = k11;
        if (k11 != null) {
            return;
        }
        boolean v2 = i.v(iVar, uri, cVar, f10, j12);
        if (v2 && f10.f21528d) {
            return;
        }
        bVar.f21518a = i.i(this.f21499a, this.f21500b, this.f21504f[i10], j12, cVar, f10, uri, this.f21507i, this.f21514p.u(), this.f21514p.r(), this.f21509k, this.f21502d, iVar, this.f21508j.a(c11), this.f21508j.a(c10), v2);
    }

    public final Pair<Long, Integer> e(@Nullable i iVar, boolean z10, com.google.android.exoplayer2.source.hls.playlist.c cVar, long j10, long j11) {
        List<c.b> list;
        long j12;
        if (iVar != null && !z10) {
            if (iVar.g()) {
                if (iVar.f21536o == -1) {
                    j12 = iVar.f();
                } else {
                    j12 = iVar.f54557j;
                }
                Long valueOf = Long.valueOf(j12);
                int i10 = iVar.f21536o;
                return new Pair<>(valueOf, Integer.valueOf(i10 != -1 ? i10 + 1 : -1));
            }
            return new Pair<>(Long.valueOf(iVar.f54557j), Integer.valueOf(iVar.f21536o));
        }
        long j13 = cVar.f21707u + j10;
        if (iVar != null && !this.f21513o) {
            j11 = iVar.f54512g;
        }
        if (!cVar.f21701o && j11 >= j13) {
            return new Pair<>(Long.valueOf(cVar.f21697k + cVar.f21704r.size()), -1);
        }
        long j14 = j11 - j10;
        int i11 = 0;
        int g3 = j0.g(cVar.f21704r, Long.valueOf(j14), true, !this.f21505g.i() || iVar == null);
        long j15 = g3 + cVar.f21697k;
        if (g3 >= 0) {
            c.d dVar = cVar.f21704r.get(g3);
            if (j14 < dVar.f21720f + dVar.f21718d) {
                list = dVar.f21715n;
            } else {
                list = cVar.f21705s;
            }
            while (true) {
                if (i11 >= list.size()) {
                    break;
                }
                c.b bVar = list.get(i11);
                if (j14 >= bVar.f21720f + bVar.f21718d) {
                    i11++;
                } else if (bVar.f21709m) {
                    j15 += list == cVar.f21705s ? 1L : 0L;
                    r1 = i11;
                }
            }
        }
        return new Pair<>(Long.valueOf(j15), Integer.valueOf(r1));
    }

    public int g(long j10, List<? extends x5.n> list) {
        if (this.f21511m == null && this.f21514p.length() >= 2) {
            return this.f21514p.k(j10, list);
        }
        return list.size();
    }

    public TrackGroup i() {
        return this.f21506h;
    }

    public ExoTrackSelection j() {
        return this.f21514p;
    }

    @Nullable
    public final x5.f k(@Nullable Uri uri, int i10) {
        if (uri == null) {
            return null;
        }
        byte[] c4 = this.f21508j.c(uri);
        if (c4 != null) {
            this.f21508j.b(uri, c4);
            return null;
        }
        return new a(this.f21501c, new b.C0209b().i(uri).b(1).a(), this.f21504f[i10], this.f21514p.u(), this.f21514p.r(), this.f21510l);
    }

    public boolean l(x5.f fVar, long j10) {
        ExoTrackSelection exoTrackSelection = this.f21514p;
        return exoTrackSelection.o(exoTrackSelection.f(this.f21506h.b(fVar.f54509d)), j10);
    }

    public void m() throws IOException {
        IOException iOException = this.f21511m;
        if (iOException == null) {
            Uri uri = this.f21512n;
            if (uri == null || !this.f21516r) {
                return;
            }
            this.f21505g.e(uri);
            return;
        }
        throw iOException;
    }

    public boolean n(Uri uri) {
        return j0.t(this.f21503e, uri);
    }

    public void o(x5.f fVar) {
        if (fVar instanceof a) {
            a aVar = (a) fVar;
            this.f21510l = aVar.g();
            this.f21508j.b(aVar.f54507b.f22767a, (byte[]) com.google.android.exoplayer2.util.a.e(aVar.i()));
        }
    }

    public boolean p(Uri uri, long j10) {
        int f10;
        int i10 = 0;
        while (true) {
            Uri[] uriArr = this.f21503e;
            if (i10 >= uriArr.length) {
                i10 = -1;
                break;
            }
            if (uriArr[i10].equals(uri)) {
                break;
            }
            i10++;
        }
        if (i10 == -1 || (f10 = this.f21514p.f(i10)) == -1) {
            return true;
        }
        this.f21516r |= uri.equals(this.f21512n);
        return j10 == -9223372036854775807L || (this.f21514p.o(f10, j10) && this.f21505g.j(uri, j10));
    }

    public void q() {
        this.f21511m = null;
    }

    public final long r(long j10) {
        long j11 = this.f21515q;
        if (j11 != -9223372036854775807L) {
            return j11 - j10;
        }
        return -9223372036854775807L;
    }

    public void s(boolean z10) {
        this.f21509k = z10;
    }

    public void t(ExoTrackSelection exoTrackSelection) {
        this.f21514p = exoTrackSelection;
    }

    public boolean u(long j10, x5.f fVar, List<? extends x5.n> list) {
        if (this.f21511m != null) {
            return false;
        }
        return this.f21514p.h(j10, fVar, list);
    }

    public final void v(com.google.android.exoplayer2.source.hls.playlist.c cVar) {
        this.f21515q = cVar.f21701o ? -9223372036854775807L : cVar.e() - this.f21505g.b();
    }
}
