package com.google.android.exoplayer2.extractor.mp4;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.mp4.a;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipUtils;

/* compiled from: Mp4Extractor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class j implements Extractor, com.google.android.exoplayer2.extractor.i {

    /* renamed from: y, reason: collision with root package name */
    public static final d5.i f20187y = new d5.i() { // from class: com.google.android.exoplayer2.extractor.mp4.i
        @Override // d5.i
        public /* synthetic */ Extractor[] a(Uri uri, Map map) {
            return d5.h.a(this, uri, map);
        }

        @Override // d5.i
        public final Extractor[] b() {
            Extractor[] r10;
            r10 = j.r();
            return r10;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final int f20188a;

    /* renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f20189b;

    /* renamed from: c, reason: collision with root package name */
    public final ParsableByteArray f20190c;

    /* renamed from: d, reason: collision with root package name */
    public final ParsableByteArray f20191d;

    /* renamed from: e, reason: collision with root package name */
    public final ParsableByteArray f20192e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayDeque<a.C0188a> f20193f;

    /* renamed from: g, reason: collision with root package name */
    public final l f20194g;

    /* renamed from: h, reason: collision with root package name */
    public final List<Metadata.Entry> f20195h;

    /* renamed from: i, reason: collision with root package name */
    public int f20196i;

    /* renamed from: j, reason: collision with root package name */
    public int f20197j;

    /* renamed from: k, reason: collision with root package name */
    public long f20198k;

    /* renamed from: l, reason: collision with root package name */
    public int f20199l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public ParsableByteArray f20200m;

    /* renamed from: n, reason: collision with root package name */
    public int f20201n;

    /* renamed from: o, reason: collision with root package name */
    public int f20202o;

    /* renamed from: p, reason: collision with root package name */
    public int f20203p;

    /* renamed from: q, reason: collision with root package name */
    public int f20204q;

    /* renamed from: r, reason: collision with root package name */
    public d5.e f20205r;

    /* renamed from: s, reason: collision with root package name */
    public a[] f20206s;

    /* renamed from: t, reason: collision with root package name */
    public long[][] f20207t;

    /* renamed from: u, reason: collision with root package name */
    public int f20208u;

    /* renamed from: v, reason: collision with root package name */
    public long f20209v;

    /* renamed from: w, reason: collision with root package name */
    public int f20210w;

    /* renamed from: x, reason: collision with root package name */
    @Nullable
    public MotionPhotoMetadata f20211x;

    /* compiled from: Mp4Extractor.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final n f20212a;

        /* renamed from: b, reason: collision with root package name */
        public final p f20213b;

        /* renamed from: c, reason: collision with root package name */
        public final TrackOutput f20214c;

        /* renamed from: d, reason: collision with root package name */
        public int f20215d;

        public a(n nVar, p pVar, TrackOutput trackOutput) {
            this.f20212a = nVar;
            this.f20213b = pVar;
            this.f20214c = trackOutput;
        }
    }

    public j() {
        this(0);
    }

    public static boolean D(int i10) {
        return i10 == 1836019574 || i10 == 1953653099 || i10 == 1835297121 || i10 == 1835626086 || i10 == 1937007212 || i10 == 1701082227 || i10 == 1835365473;
    }

    public static boolean E(int i10) {
        return i10 == 1835296868 || i10 == 1836476516 || i10 == 1751411826 || i10 == 1937011556 || i10 == 1937011827 || i10 == 1937011571 || i10 == 1668576371 || i10 == 1701606260 || i10 == 1937011555 || i10 == 1937011578 || i10 == 1937013298 || i10 == 1937007471 || i10 == 1668232756 || i10 == 1953196132 || i10 == 1718909296 || i10 == 1969517665 || i10 == 1801812339 || i10 == 1768715124;
    }

    public static int l(int i10) {
        if (i10 != 1751476579) {
            return i10 != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    public static long[][] m(a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length];
        int[] iArr = new int[aVarArr.length];
        long[] jArr2 = new long[aVarArr.length];
        boolean[] zArr = new boolean[aVarArr.length];
        for (int i10 = 0; i10 < aVarArr.length; i10++) {
            jArr[i10] = new long[aVarArr[i10].f20213b.f20259b];
            jArr2[i10] = aVarArr[i10].f20213b.f20263f[0];
        }
        long j10 = 0;
        int i11 = 0;
        while (i11 < aVarArr.length) {
            long j11 = Long.MAX_VALUE;
            int i12 = -1;
            for (int i13 = 0; i13 < aVarArr.length; i13++) {
                if (!zArr[i13] && jArr2[i13] <= j11) {
                    j11 = jArr2[i13];
                    i12 = i13;
                }
            }
            int i14 = iArr[i12];
            jArr[i12][i14] = j10;
            j10 += aVarArr[i12].f20213b.f20261d[i14];
            int i15 = i14 + 1;
            iArr[i12] = i15;
            if (i15 < jArr[i12].length) {
                jArr2[i12] = aVarArr[i12].f20213b.f20263f[i15];
            } else {
                zArr[i12] = true;
                i11++;
            }
        }
        return jArr;
    }

    public static int o(p pVar, long j10) {
        int a10 = pVar.a(j10);
        return a10 == -1 ? pVar.b(j10) : a10;
    }

    public static /* synthetic */ n q(n nVar) {
        return nVar;
    }

    public static /* synthetic */ Extractor[] r() {
        return new Extractor[]{new j()};
    }

    public static long s(p pVar, long j10, long j11) {
        int o10 = o(pVar, j10);
        return o10 == -1 ? j11 : Math.min(pVar.f20260c[o10], j11);
    }

    public static int w(ParsableByteArray parsableByteArray) {
        parsableByteArray.P(8);
        int l10 = l(parsableByteArray.n());
        if (l10 != 0) {
            return l10;
        }
        parsableByteArray.Q(4);
        while (parsableByteArray.a() > 0) {
            int l11 = l(parsableByteArray.n());
            if (l11 != 0) {
                return l11;
            }
        }
        return 0;
    }

    public final boolean A(d5.d dVar, d5.n nVar) throws IOException {
        boolean z10;
        long j10 = this.f20198k - this.f20199l;
        long position = dVar.getPosition() + j10;
        ParsableByteArray parsableByteArray = this.f20200m;
        if (parsableByteArray != null) {
            dVar.readFully(parsableByteArray.d(), this.f20199l, (int) j10);
            if (this.f20197j == 1718909296) {
                this.f20210w = w(parsableByteArray);
            } else if (!this.f20193f.isEmpty()) {
                this.f20193f.peek().e(new a.b(this.f20197j, parsableByteArray));
            }
        } else if (j10 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            dVar.r((int) j10);
        } else {
            nVar.f48642a = dVar.getPosition() + j10;
            z10 = true;
            u(position);
            return (z10 || this.f20196i == 2) ? false : true;
        }
        z10 = false;
        u(position);
        if (z10) {
        }
    }

    public final int B(d5.d dVar, d5.n nVar) throws IOException {
        long position = dVar.getPosition();
        if (this.f20201n == -1) {
            int p10 = p(position);
            this.f20201n = p10;
            if (p10 == -1) {
                return -1;
            }
        }
        a aVar = ((a[]) j0.j(this.f20206s))[this.f20201n];
        TrackOutput trackOutput = aVar.f20214c;
        int i10 = aVar.f20215d;
        p pVar = aVar.f20213b;
        long j10 = pVar.f20260c[i10];
        int i11 = pVar.f20261d[i10];
        long j11 = (j10 - position) + this.f20202o;
        if (j11 >= 0 && j11 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            if (aVar.f20212a.f20234g == 1) {
                j11 += 8;
                i11 -= 8;
            }
            dVar.r((int) j11);
            n nVar2 = aVar.f20212a;
            if (nVar2.f20237j != 0) {
                byte[] d10 = this.f20190c.d();
                d10[0] = 0;
                d10[1] = 0;
                d10[2] = 0;
                int i12 = aVar.f20212a.f20237j;
                int i13 = 4 - i12;
                while (this.f20203p < i11) {
                    int i14 = this.f20204q;
                    if (i14 == 0) {
                        dVar.readFully(d10, i13, i12);
                        this.f20202o += i12;
                        this.f20190c.P(0);
                        int n10 = this.f20190c.n();
                        if (n10 >= 0) {
                            this.f20204q = n10;
                            this.f20189b.P(0);
                            trackOutput.a(this.f20189b, 4);
                            this.f20203p += 4;
                            i11 += i13;
                        } else {
                            throw ParserException.createForMalformedContainer("Invalid NAL length", null);
                        }
                    } else {
                        int c4 = trackOutput.c(dVar, i14, false);
                        this.f20202o += c4;
                        this.f20203p += c4;
                        this.f20204q -= c4;
                    }
                }
            } else {
                if ("audio/ac4".equals(nVar2.f20233f.f19544m)) {
                    if (this.f20203p == 0) {
                        x4.c.a(i11, this.f20191d);
                        trackOutput.a(this.f20191d, 7);
                        this.f20203p += 7;
                    }
                    i11 += 7;
                }
                while (true) {
                    int i15 = this.f20203p;
                    if (i15 >= i11) {
                        break;
                    }
                    int c10 = trackOutput.c(dVar, i11 - i15, false);
                    this.f20202o += c10;
                    this.f20203p += c10;
                    this.f20204q -= c10;
                }
            }
            p pVar2 = aVar.f20213b;
            trackOutput.d(pVar2.f20263f[i10], pVar2.f20264g[i10], i11, 0, null);
            aVar.f20215d++;
            this.f20201n = -1;
            this.f20202o = 0;
            this.f20203p = 0;
            this.f20204q = 0;
            return 0;
        }
        nVar.f48642a = j10;
        return 1;
    }

    public final int C(d5.d dVar, d5.n nVar) throws IOException {
        int c4 = this.f20194g.c(dVar, nVar, this.f20195h);
        if (c4 == 1 && nVar.f48642a == 0) {
            n();
        }
        return c4;
    }

    public final void F(long j10) {
        for (a aVar : this.f20206s) {
            p pVar = aVar.f20213b;
            int a10 = pVar.a(j10);
            if (a10 == -1) {
                a10 = pVar.b(j10);
            }
            aVar.f20215d = a10;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void a(long j10, long j11) {
        this.f20193f.clear();
        this.f20199l = 0;
        this.f20201n = -1;
        this.f20202o = 0;
        this.f20203p = 0;
        this.f20204q = 0;
        if (j10 == 0) {
            if (this.f20196i != 3) {
                n();
                return;
            } else {
                this.f20194g.g();
                this.f20195h.clear();
                return;
            }
        }
        if (this.f20206s != null) {
            F(j11);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(d5.e eVar) {
        this.f20205r = eVar;
    }

    @Override // com.google.android.exoplayer2.extractor.i
    public i.a d(long j10) {
        long j11;
        long j12;
        long j13;
        long j14;
        int b4;
        if (((a[]) com.google.android.exoplayer2.util.a.e(this.f20206s)).length == 0) {
            return new i.a(d5.o.f48643c);
        }
        int i10 = this.f20208u;
        if (i10 != -1) {
            p pVar = this.f20206s[i10].f20213b;
            int o10 = o(pVar, j10);
            if (o10 == -1) {
                return new i.a(d5.o.f48643c);
            }
            long j15 = pVar.f20263f[o10];
            j11 = pVar.f20260c[o10];
            if (j15 >= j10 || o10 >= pVar.f20259b - 1 || (b4 = pVar.b(j10)) == -1 || b4 == o10) {
                j14 = -1;
                j13 = -9223372036854775807L;
            } else {
                j13 = pVar.f20263f[b4];
                j14 = pVar.f20260c[b4];
            }
            j12 = j14;
            j10 = j15;
        } else {
            j11 = Long.MAX_VALUE;
            j12 = -1;
            j13 = -9223372036854775807L;
        }
        int i11 = 0;
        while (true) {
            a[] aVarArr = this.f20206s;
            if (i11 >= aVarArr.length) {
                break;
            }
            if (i11 != this.f20208u) {
                p pVar2 = aVarArr[i11].f20213b;
                long s2 = s(pVar2, j10, j11);
                if (j13 != -9223372036854775807L) {
                    j12 = s(pVar2, j13, j12);
                }
                j11 = s2;
            }
            i11++;
        }
        d5.o oVar = new d5.o(j10, j11);
        if (j13 == -9223372036854775807L) {
            return new i.a(oVar);
        }
        return new i.a(oVar, new d5.o(j13, j12));
    }

    @Override // com.google.android.exoplayer2.extractor.i
    public boolean e() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int f(d5.d dVar, d5.n nVar) throws IOException {
        while (true) {
            int i10 = this.f20196i;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        return B(dVar, nVar);
                    }
                    if (i10 == 3) {
                        return C(dVar, nVar);
                    }
                    throw new IllegalStateException();
                }
                if (A(dVar, nVar)) {
                    return 1;
                }
            } else if (!z(dVar)) {
                return -1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean g(d5.d dVar) throws IOException {
        return m.d(dVar, (this.f20188a & 2) != 0);
    }

    @Override // com.google.android.exoplayer2.extractor.i
    public long i() {
        return this.f20209v;
    }

    public final void n() {
        this.f20196i = 0;
        this.f20199l = 0;
    }

    public final int p(long j10) {
        int i10 = -1;
        int i11 = -1;
        long j11 = Long.MAX_VALUE;
        boolean z10 = true;
        long j12 = Long.MAX_VALUE;
        boolean z11 = true;
        long j13 = Long.MAX_VALUE;
        for (int i12 = 0; i12 < ((a[]) j0.j(this.f20206s)).length; i12++) {
            a aVar = this.f20206s[i12];
            int i13 = aVar.f20215d;
            p pVar = aVar.f20213b;
            if (i13 != pVar.f20259b) {
                long j14 = pVar.f20260c[i13];
                long j15 = ((long[][]) j0.j(this.f20207t))[i12][i13];
                long j16 = j14 - j10;
                boolean z12 = j16 < 0 || j16 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                if ((!z12 && z11) || (z12 == z11 && j16 < j13)) {
                    z11 = z12;
                    j13 = j16;
                    i11 = i12;
                    j12 = j15;
                }
                if (j15 < j11) {
                    z10 = z12;
                    i10 = i12;
                    j11 = j15;
                }
            }
        }
        return (j11 == Long.MAX_VALUE || !z10 || j12 < j11 + 10485760) ? i11 : i10;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    public final void t(d5.d dVar) throws IOException {
        this.f20191d.L(8);
        dVar.j(this.f20191d.d(), 0, 8);
        AtomParsers.d(this.f20191d);
        dVar.r(this.f20191d.e());
        dVar.m();
    }

    public final void u(long j10) throws ParserException {
        while (!this.f20193f.isEmpty() && this.f20193f.peek().f20128b == j10) {
            a.C0188a pop = this.f20193f.pop();
            if (pop.f20127a == 1836019574) {
                x(pop);
                this.f20193f.clear();
                this.f20196i = 2;
            } else if (!this.f20193f.isEmpty()) {
                this.f20193f.peek().d(pop);
            }
        }
        if (this.f20196i != 2) {
            n();
        }
    }

    public final void v() {
        if (this.f20210w != 2 || (this.f20188a & 2) == 0) {
            return;
        }
        d5.e eVar = (d5.e) com.google.android.exoplayer2.util.a.e(this.f20205r);
        eVar.c(0, 4).b(new Format.b().X(this.f20211x == null ? null : new Metadata(this.f20211x)).E());
        eVar.l();
        eVar.r(new i.b(-9223372036854775807L));
    }

    public final void x(a.C0188a c0188a) throws ParserException {
        Metadata metadata;
        Metadata metadata2;
        ArrayList arrayList;
        List<p> list;
        int i10;
        int i11;
        ArrayList arrayList2 = new ArrayList();
        boolean z10 = this.f20210w == 1;
        d5.l lVar = new d5.l();
        a.b g3 = c0188a.g(1969517665);
        if (g3 != null) {
            Pair<Metadata, Metadata> A = AtomParsers.A(g3);
            Metadata metadata3 = (Metadata) A.first;
            Metadata metadata4 = (Metadata) A.second;
            if (metadata3 != null) {
                lVar.c(metadata3);
            }
            metadata = metadata4;
            metadata2 = metadata3;
        } else {
            metadata = null;
            metadata2 = null;
        }
        a.C0188a f10 = c0188a.f(1835365473);
        Metadata m10 = f10 != null ? AtomParsers.m(f10) : null;
        List<p> z11 = AtomParsers.z(c0188a, lVar, -9223372036854775807L, null, (this.f20188a & 1) != 0, z10, new com.google.common.base.g() { // from class: com.google.android.exoplayer2.extractor.mp4.h
            @Override // com.google.common.base.g
            public final Object apply(Object obj) {
                n q10;
                q10 = j.q((n) obj);
                return q10;
            }
        });
        d5.e eVar = (d5.e) com.google.android.exoplayer2.util.a.e(this.f20205r);
        int size = z11.size();
        int i12 = 0;
        int i13 = -1;
        long j10 = -9223372036854775807L;
        while (i12 < size) {
            p pVar = z11.get(i12);
            if (pVar.f20259b == 0) {
                list = z11;
                i10 = size;
                arrayList = arrayList2;
            } else {
                n nVar = pVar.f20258a;
                int i14 = i13;
                arrayList = arrayList2;
                long j11 = nVar.f20232e;
                if (j11 == -9223372036854775807L) {
                    j11 = pVar.f20265h;
                }
                long max = Math.max(j10, j11);
                list = z11;
                i10 = size;
                a aVar = new a(nVar, pVar, eVar.c(i12, nVar.f20229b));
                int i15 = pVar.f20262e + 30;
                Format.b a10 = nVar.f20233f.a();
                a10.W(i15);
                if (nVar.f20229b == 2 && j11 > 0 && (i11 = pVar.f20259b) > 1) {
                    a10.P(i11 / (((float) j11) / 1000000.0f));
                }
                g.k(nVar.f20229b, lVar, a10);
                int i16 = nVar.f20229b;
                Metadata[] metadataArr = new Metadata[2];
                metadataArr[0] = metadata;
                metadataArr[1] = this.f20195h.isEmpty() ? null : new Metadata(this.f20195h);
                g.l(i16, metadata2, m10, a10, metadataArr);
                aVar.f20214c.b(a10.E());
                if (nVar.f20229b == 2 && i14 == -1) {
                    i13 = arrayList.size();
                    arrayList.add(aVar);
                    j10 = max;
                }
                i13 = i14;
                arrayList.add(aVar);
                j10 = max;
            }
            i12++;
            arrayList2 = arrayList;
            z11 = list;
            size = i10;
        }
        this.f20208u = i13;
        this.f20209v = j10;
        a[] aVarArr = (a[]) arrayList2.toArray(new a[0]);
        this.f20206s = aVarArr;
        this.f20207t = m(aVarArr);
        eVar.l();
        eVar.r(this);
    }

    public final void y(long j10) {
        if (this.f20197j == 1836086884) {
            int i10 = this.f20199l;
            this.f20211x = new MotionPhotoMetadata(0L, j10, -9223372036854775807L, j10 + i10, this.f20198k - i10);
        }
    }

    public final boolean z(d5.d dVar) throws IOException {
        a.C0188a peek;
        if (this.f20199l == 0) {
            if (!dVar.f(this.f20192e.d(), 0, 8, true)) {
                v();
                return false;
            }
            this.f20199l = 8;
            this.f20192e.P(0);
            this.f20198k = this.f20192e.F();
            this.f20197j = this.f20192e.n();
        }
        long j10 = this.f20198k;
        if (j10 == 1) {
            dVar.readFully(this.f20192e.d(), 8, 8);
            this.f20199l += 8;
            this.f20198k = this.f20192e.I();
        } else if (j10 == 0) {
            long b4 = dVar.b();
            if (b4 == -1 && (peek = this.f20193f.peek()) != null) {
                b4 = peek.f20128b;
            }
            if (b4 != -1) {
                this.f20198k = (b4 - dVar.getPosition()) + this.f20199l;
            }
        }
        if (this.f20198k >= this.f20199l) {
            if (D(this.f20197j)) {
                long position = dVar.getPosition();
                long j11 = this.f20198k;
                int i10 = this.f20199l;
                long j12 = (position + j11) - i10;
                if (j11 != i10 && this.f20197j == 1835365473) {
                    t(dVar);
                }
                this.f20193f.push(new a.C0188a(this.f20197j, j12));
                if (this.f20198k == this.f20199l) {
                    u(j12);
                } else {
                    n();
                }
            } else if (E(this.f20197j)) {
                com.google.android.exoplayer2.util.a.g(this.f20199l == 8);
                com.google.android.exoplayer2.util.a.g(this.f20198k <= ZipUtils.UPPER_UNIXTIME_BOUND);
                ParsableByteArray parsableByteArray = new ParsableByteArray((int) this.f20198k);
                System.arraycopy((Object) this.f20192e.d(), 0, (Object) parsableByteArray.d(), 0, 8);
                this.f20200m = parsableByteArray;
                this.f20196i = 1;
            } else {
                y(dVar.getPosition() - this.f20199l);
                this.f20200m = null;
                this.f20196i = 1;
            }
            return true;
        }
        throw ParserException.createForUnsupportedContainerFeature("Atom size less than header length (unsupported).");
    }

    public j(int i10) {
        this.f20188a = i10;
        this.f20196i = (i10 & 4) != 0 ? 3 : 0;
        this.f20194g = new l();
        this.f20195h = new ArrayList();
        this.f20192e = new ParsableByteArray(16);
        this.f20193f = new ArrayDeque<>();
        this.f20189b = new ParsableByteArray(NalUnitUtil.f22925a);
        this.f20190c = new ParsableByteArray(4);
        this.f20191d = new ParsableByteArray();
        this.f20201n = -1;
    }
}
