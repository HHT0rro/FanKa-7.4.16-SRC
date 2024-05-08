package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.l0;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.z;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.b;
import com.google.android.exoplayer2.upstream.h;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProgressiveMediaPeriod.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g0 implements p, d5.e, Loader.b<a>, Loader.f, l0.d {
    public static final Map<String, String> N = J();
    public static final Format O = new Format.b().S("icy").e0("application/x-icy").E();
    public boolean B;
    public boolean D;
    public boolean E;
    public int F;
    public long H;
    public boolean J;
    public int K;
    public boolean L;
    public boolean M;

    /* renamed from: b, reason: collision with root package name */
    public final Uri f21383b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.a f21384c;

    /* renamed from: d, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.c f21385d;

    /* renamed from: e, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.h f21386e;

    /* renamed from: f, reason: collision with root package name */
    public final z.a f21387f;

    /* renamed from: g, reason: collision with root package name */
    public final b.a f21388g;

    /* renamed from: h, reason: collision with root package name */
    public final b f21389h;

    /* renamed from: i, reason: collision with root package name */
    public final o6.b f21390i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public final String f21391j;

    /* renamed from: k, reason: collision with root package name */
    public final long f21392k;

    /* renamed from: m, reason: collision with root package name */
    public final c0 f21394m;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public p.a f21399r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public IcyHeaders f21400s;

    /* renamed from: v, reason: collision with root package name */
    public boolean f21403v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f21404w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f21405x;

    /* renamed from: y, reason: collision with root package name */
    public e f21406y;

    /* renamed from: z, reason: collision with root package name */
    public com.google.android.exoplayer2.extractor.i f21407z;

    /* renamed from: l, reason: collision with root package name */
    public final Loader f21393l = new Loader("ProgressiveMediaPeriod");

    /* renamed from: n, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.e f21395n = new com.google.android.exoplayer2.util.e();

    /* renamed from: o, reason: collision with root package name */
    public final Runnable f21396o = new Runnable() { // from class: com.google.android.exoplayer2.source.d0
        @Override // java.lang.Runnable
        public final void run() {
            g0.this.R();
        }
    };

    /* renamed from: p, reason: collision with root package name */
    public final Runnable f21397p = new Runnable() { // from class: com.google.android.exoplayer2.source.e0
        @Override // java.lang.Runnable
        public final void run() {
            g0.this.P();
        }
    };

    /* renamed from: q, reason: collision with root package name */
    public final Handler f21398q = com.google.android.exoplayer2.util.j0.x();

    /* renamed from: u, reason: collision with root package name */
    public d[] f21402u = new d[0];

    /* renamed from: t, reason: collision with root package name */
    public l0[] f21401t = new l0[0];
    public long I = -9223372036854775807L;
    public long G = -1;
    public long A = -9223372036854775807L;
    public int C = 1;

    /* compiled from: ProgressiveMediaPeriod.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class a implements Loader.e, l.a {

        /* renamed from: b, reason: collision with root package name */
        public final Uri f21409b;

        /* renamed from: c, reason: collision with root package name */
        public final o6.t f21410c;

        /* renamed from: d, reason: collision with root package name */
        public final c0 f21411d;

        /* renamed from: e, reason: collision with root package name */
        public final d5.e f21412e;

        /* renamed from: f, reason: collision with root package name */
        public final com.google.android.exoplayer2.util.e f21413f;

        /* renamed from: h, reason: collision with root package name */
        public volatile boolean f21415h;

        /* renamed from: j, reason: collision with root package name */
        public long f21417j;

        /* renamed from: m, reason: collision with root package name */
        @Nullable
        public TrackOutput f21420m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f21421n;

        /* renamed from: g, reason: collision with root package name */
        public final d5.n f21414g = new d5.n();

        /* renamed from: i, reason: collision with root package name */
        public boolean f21416i = true;

        /* renamed from: l, reason: collision with root package name */
        public long f21419l = -1;

        /* renamed from: a, reason: collision with root package name */
        public final long f21408a = m.a();

        /* renamed from: k, reason: collision with root package name */
        public com.google.android.exoplayer2.upstream.b f21418k = i(0);

        public a(Uri uri, com.google.android.exoplayer2.upstream.a aVar, c0 c0Var, d5.e eVar, com.google.android.exoplayer2.util.e eVar2) {
            this.f21409b = uri;
            this.f21410c = new o6.t(aVar);
            this.f21411d = c0Var;
            this.f21412e = eVar;
            this.f21413f = eVar2;
        }

        @Override // com.google.android.exoplayer2.source.l.a
        public void a(ParsableByteArray parsableByteArray) {
            long max = !this.f21421n ? this.f21417j : Math.max(g0.this.L(), this.f21417j);
            int a10 = parsableByteArray.a();
            TrackOutput trackOutput = (TrackOutput) com.google.android.exoplayer2.util.a.e(this.f21420m);
            trackOutput.a(parsableByteArray, a10);
            trackOutput.d(max, 1, a10, 0, null);
            this.f21421n = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.e
        public void b() {
            this.f21415h = true;
        }

        public final com.google.android.exoplayer2.upstream.b i(long j10) {
            return new b.C0209b().i(this.f21409b).h(j10).f(g0.this.f21391j).b(6).e(g0.N).a();
        }

        public final void j(long j10, long j11) {
            this.f21414g.f48642a = j10;
            this.f21417j = j11;
            this.f21416i = true;
            this.f21421n = false;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.e
        public void load() throws IOException {
            int i10 = 0;
            while (i10 == 0 && !this.f21415h) {
                try {
                    long j10 = this.f21414g.f48642a;
                    com.google.android.exoplayer2.upstream.b i11 = i(j10);
                    this.f21418k = i11;
                    long a10 = this.f21410c.a(i11);
                    this.f21419l = a10;
                    if (a10 != -1) {
                        this.f21419l = a10 + j10;
                    }
                    g0.this.f21400s = IcyHeaders.a(this.f21410c.e());
                    o6.g gVar = this.f21410c;
                    if (g0.this.f21400s != null && g0.this.f21400s.f20876g != -1) {
                        gVar = new l(this.f21410c, g0.this.f21400s.f20876g, this);
                        TrackOutput M = g0.this.M();
                        this.f21420m = M;
                        M.b(g0.O);
                    }
                    long j11 = j10;
                    this.f21411d.b(gVar, this.f21409b, this.f21410c.e(), j10, this.f21419l, this.f21412e);
                    if (g0.this.f21400s != null) {
                        this.f21411d.d();
                    }
                    if (this.f21416i) {
                        this.f21411d.a(j11, this.f21417j);
                        this.f21416i = false;
                    }
                    while (true) {
                        long j12 = j11;
                        while (i10 == 0 && !this.f21415h) {
                            try {
                                this.f21413f.a();
                                i10 = this.f21411d.e(this.f21414g);
                                j11 = this.f21411d.c();
                                if (j11 > g0.this.f21392k + j12) {
                                    break;
                                }
                            } catch (InterruptedException unused) {
                                throw new InterruptedIOException();
                            }
                        }
                        this.f21413f.c();
                        g0.this.f21398q.post(g0.this.f21397p);
                    }
                    if (i10 == 1) {
                        i10 = 0;
                    } else if (this.f21411d.c() != -1) {
                        this.f21414g.f48642a = this.f21411d.c();
                    }
                    com.google.android.exoplayer2.util.j0.n(this.f21410c);
                } catch (Throwable th) {
                    if (i10 != 1 && this.f21411d.c() != -1) {
                        this.f21414g.f48642a = this.f21411d.c();
                    }
                    com.google.android.exoplayer2.util.j0.n(this.f21410c);
                    throw th;
                }
            }
        }
    }

    /* compiled from: ProgressiveMediaPeriod.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b {
        void m(long j10, boolean z10, boolean z11);
    }

    /* compiled from: ProgressiveMediaPeriod.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class c implements SampleStream {

        /* renamed from: b, reason: collision with root package name */
        public final int f21423b;

        public c(int i10) {
            this.f21423b = i10;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void a() throws IOException {
            g0.this.V(this.f21423b);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int c(s0 s0Var, DecoderInputBuffer decoderInputBuffer, int i10) {
            return g0.this.a0(this.f21423b, s0Var, decoderInputBuffer, i10);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return g0.this.O(this.f21423b);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int l(long j10) {
            return g0.this.e0(this.f21423b, j10);
        }
    }

    /* compiled from: ProgressiveMediaPeriod.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f21425a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f21426b;

        public d(int i10, boolean z10) {
            this.f21425a = i10;
            this.f21426b = z10;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f21425a == dVar.f21425a && this.f21426b == dVar.f21426b;
        }

        public int hashCode() {
            return (this.f21425a * 31) + (this.f21426b ? 1 : 0);
        }
    }

    /* compiled from: ProgressiveMediaPeriod.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public final TrackGroupArray f21427a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean[] f21428b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean[] f21429c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean[] f21430d;

        public e(TrackGroupArray trackGroupArray, boolean[] zArr) {
            this.f21427a = trackGroupArray;
            this.f21428b = zArr;
            int i10 = trackGroupArray.f21172b;
            this.f21429c = new boolean[i10];
            this.f21430d = new boolean[i10];
        }
    }

    public g0(Uri uri, com.google.android.exoplayer2.upstream.a aVar, c0 c0Var, com.google.android.exoplayer2.drm.c cVar, b.a aVar2, com.google.android.exoplayer2.upstream.h hVar, z.a aVar3, b bVar, o6.b bVar2, @Nullable String str, int i10) {
        this.f21383b = uri;
        this.f21384c = aVar;
        this.f21385d = cVar;
        this.f21388g = aVar2;
        this.f21386e = hVar;
        this.f21387f = aVar3;
        this.f21389h = bVar;
        this.f21390i = bVar2;
        this.f21391j = str;
        this.f21392k = i10;
        this.f21394m = c0Var;
    }

    public static Map<String, String> J() {
        HashMap hashMap = new HashMap();
        hashMap.put("Icy-MetaData", "1");
        return Collections.unmodifiableMap(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P() {
        if (this.M) {
            return;
        }
        ((p.a) com.google.android.exoplayer2.util.a.e(this.f21399r)).k(this);
    }

    public final void G() {
        com.google.android.exoplayer2.util.a.g(this.f21404w);
        com.google.android.exoplayer2.util.a.e(this.f21406y);
        com.google.android.exoplayer2.util.a.e(this.f21407z);
    }

    public final boolean H(a aVar, int i10) {
        com.google.android.exoplayer2.extractor.i iVar;
        if (this.G == -1 && ((iVar = this.f21407z) == null || iVar.i() == -9223372036854775807L)) {
            if (this.f21404w && !g0()) {
                this.J = true;
                return false;
            }
            this.E = this.f21404w;
            this.H = 0L;
            this.K = 0;
            for (l0 l0Var : this.f21401t) {
                l0Var.V();
            }
            aVar.j(0L, 0L);
            return true;
        }
        this.K = i10;
        return true;
    }

    public final void I(a aVar) {
        if (this.G == -1) {
            this.G = aVar.f21419l;
        }
    }

    public final int K() {
        int i10 = 0;
        for (l0 l0Var : this.f21401t) {
            i10 += l0Var.G();
        }
        return i10;
    }

    public final long L() {
        long j10 = Long.MIN_VALUE;
        for (l0 l0Var : this.f21401t) {
            j10 = Math.max(j10, l0Var.z());
        }
        return j10;
    }

    public TrackOutput M() {
        return Z(new d(0, true));
    }

    public final boolean N() {
        return this.I != -9223372036854775807L;
    }

    public boolean O(int i10) {
        return !g0() && this.f21401t[i10].K(this.L);
    }

    public final void R() {
        Metadata a10;
        if (this.M || this.f21404w || !this.f21403v || this.f21407z == null) {
            return;
        }
        for (l0 l0Var : this.f21401t) {
            if (l0Var.F() == null) {
                return;
            }
        }
        this.f21395n.c();
        int length = this.f21401t.length;
        TrackGroup[] trackGroupArr = new TrackGroup[length];
        boolean[] zArr = new boolean[length];
        for (int i10 = 0; i10 < length; i10++) {
            Format format = (Format) com.google.android.exoplayer2.util.a.e(this.f21401t[i10].F());
            String str = format.f19544m;
            boolean p10 = com.google.android.exoplayer2.util.q.p(str);
            boolean z10 = p10 || com.google.android.exoplayer2.util.q.s(str);
            zArr[i10] = z10;
            this.f21405x = z10 | this.f21405x;
            IcyHeaders icyHeaders = this.f21400s;
            if (icyHeaders != null) {
                if (p10 || this.f21402u[i10].f21426b) {
                    Metadata metadata = format.f19542k;
                    if (metadata == null) {
                        a10 = new Metadata(icyHeaders);
                    } else {
                        a10 = metadata.a(icyHeaders);
                    }
                    format = format.a().X(a10).E();
                }
                if (p10 && format.f19538g == -1 && format.f19539h == -1 && icyHeaders.f20871b != -1) {
                    format = format.a().G(icyHeaders.f20871b).E();
                }
            }
            trackGroupArr[i10] = new TrackGroup(format.b(this.f21385d.c(format)));
        }
        this.f21406y = new e(new TrackGroupArray(trackGroupArr), zArr);
        this.f21404w = true;
        ((p.a) com.google.android.exoplayer2.util.a.e(this.f21399r)).n(this);
    }

    public final void S(int i10) {
        G();
        e eVar = this.f21406y;
        boolean[] zArr = eVar.f21430d;
        if (zArr[i10]) {
            return;
        }
        Format a10 = eVar.f21427a.a(i10).a(0);
        this.f21387f.i(com.google.android.exoplayer2.util.q.l(a10.f19544m), a10, 0, null, this.H);
        zArr[i10] = true;
    }

    public final void T(int i10) {
        G();
        boolean[] zArr = this.f21406y.f21428b;
        if (this.J && zArr[i10]) {
            if (this.f21401t[i10].K(false)) {
                return;
            }
            this.I = 0L;
            this.J = false;
            this.E = true;
            this.H = 0L;
            this.K = 0;
            for (l0 l0Var : this.f21401t) {
                l0Var.V();
            }
            ((p.a) com.google.android.exoplayer2.util.a.e(this.f21399r)).k(this);
        }
    }

    public void U() throws IOException {
        this.f21393l.k(this.f21386e.d(this.C));
    }

    public void V(int i10) throws IOException {
        this.f21401t[i10].N();
        U();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public void n(a aVar, long j10, long j11, boolean z10) {
        o6.t tVar = aVar.f21410c;
        m mVar = new m(aVar.f21408a, aVar.f21418k, tVar.t(), tVar.u(), j10, j11, tVar.n());
        this.f21386e.c(aVar.f21408a);
        this.f21387f.r(mVar, 1, -1, null, 0, null, aVar.f21417j, this.A);
        if (z10) {
            return;
        }
        I(aVar);
        for (l0 l0Var : this.f21401t) {
            l0Var.V();
        }
        if (this.F > 0) {
            ((p.a) com.google.android.exoplayer2.util.a.e(this.f21399r)).k(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public void o(a aVar, long j10, long j11) {
        com.google.android.exoplayer2.extractor.i iVar;
        if (this.A == -9223372036854775807L && (iVar = this.f21407z) != null) {
            boolean e2 = iVar.e();
            long L = L();
            long j12 = L == Long.MIN_VALUE ? 0L : L + 10000;
            this.A = j12;
            this.f21389h.m(j12, e2, this.B);
        }
        o6.t tVar = aVar.f21410c;
        m mVar = new m(aVar.f21408a, aVar.f21418k, tVar.t(), tVar.u(), j10, j11, tVar.n());
        this.f21386e.c(aVar.f21408a);
        this.f21387f.u(mVar, 1, -1, null, 0, null, aVar.f21417j, this.A);
        I(aVar);
        this.L = true;
        ((p.a) com.google.android.exoplayer2.util.a.e(this.f21399r)).k(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public Loader.c q(a aVar, long j10, long j11, IOException iOException, int i10) {
        boolean z10;
        a aVar2;
        Loader.c cVar;
        I(aVar);
        o6.t tVar = aVar.f21410c;
        m mVar = new m(aVar.f21408a, aVar.f21418k, tVar.t(), tVar.u(), j10, j11, tVar.n());
        long a10 = this.f21386e.a(new h.c(mVar, new MediaLoadData(1, -1, null, 0, null, com.google.android.exoplayer2.h.e(aVar.f21417j), com.google.android.exoplayer2.h.e(this.A)), iOException, i10));
        if (a10 == -9223372036854775807L) {
            cVar = Loader.f22733g;
        } else {
            int K = K();
            if (K > this.K) {
                aVar2 = aVar;
                z10 = true;
            } else {
                z10 = false;
                aVar2 = aVar;
            }
            if (H(aVar2, K)) {
                cVar = Loader.h(z10, a10);
            } else {
                cVar = Loader.f22732f;
            }
        }
        boolean z11 = !cVar.c();
        this.f21387f.w(mVar, 1, -1, null, 0, null, aVar.f21417j, this.A, iOException, z11);
        if (z11) {
            this.f21386e.c(aVar.f21408a);
        }
        return cVar;
    }

    public final TrackOutput Z(d dVar) {
        int length = this.f21401t.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (dVar.equals(this.f21402u[i10])) {
                return this.f21401t[i10];
            }
        }
        l0 k10 = l0.k(this.f21390i, this.f21398q.getLooper(), this.f21385d, this.f21388g);
        k10.d0(this);
        int i11 = length + 1;
        d[] dVarArr = (d[]) Arrays.copyOf(this.f21402u, i11);
        dVarArr[length] = dVar;
        this.f21402u = (d[]) com.google.android.exoplayer2.util.j0.k(dVarArr);
        l0[] l0VarArr = (l0[]) Arrays.copyOf(this.f21401t, i11);
        l0VarArr[length] = k10;
        this.f21401t = (l0[]) com.google.android.exoplayer2.util.j0.k(l0VarArr);
        return k10;
    }

    @Override // com.google.android.exoplayer2.source.l0.d
    public void a(Format format) {
        this.f21398q.post(this.f21396o);
    }

    public int a0(int i10, s0 s0Var, DecoderInputBuffer decoderInputBuffer, int i11) {
        if (g0()) {
            return -3;
        }
        S(i10);
        int S = this.f21401t[i10].S(s0Var, decoderInputBuffer, i11, this.L);
        if (S == -3) {
            T(i10);
        }
        return S;
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public boolean b(long j10) {
        if (this.L || this.f21393l.i() || this.J) {
            return false;
        }
        if (this.f21404w && this.F == 0) {
            return false;
        }
        boolean e2 = this.f21395n.e();
        if (this.f21393l.j()) {
            return e2;
        }
        f0();
        return true;
    }

    public void b0() {
        if (this.f21404w) {
            for (l0 l0Var : this.f21401t) {
                l0Var.R();
            }
        }
        this.f21393l.m(this);
        this.f21398q.removeCallbacksAndMessages(null);
        this.f21399r = null;
        this.M = true;
    }

    @Override // d5.e
    public TrackOutput c(int i10, int i11) {
        return Z(new d(i10, false));
    }

    public final boolean c0(boolean[] zArr, long j10) {
        int length = this.f21401t.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (!this.f21401t[i10].Z(j10, false) && (zArr[i10] || !this.f21405x)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public long d() {
        long j10;
        G();
        boolean[] zArr = this.f21406y.f21428b;
        if (this.L) {
            return Long.MIN_VALUE;
        }
        if (N()) {
            return this.I;
        }
        if (this.f21405x) {
            int length = this.f21401t.length;
            j10 = Long.MAX_VALUE;
            for (int i10 = 0; i10 < length; i10++) {
                if (zArr[i10] && !this.f21401t[i10].J()) {
                    j10 = Math.min(j10, this.f21401t[i10].z());
                }
            }
        } else {
            j10 = Long.MAX_VALUE;
        }
        if (j10 == Long.MAX_VALUE) {
            j10 = L();
        }
        return j10 == Long.MIN_VALUE ? this.H : j10;
    }

    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public final void Q(com.google.android.exoplayer2.extractor.i iVar) {
        this.f21407z = this.f21400s == null ? iVar : new i.b(-9223372036854775807L);
        this.A = iVar.i();
        boolean z10 = this.G == -1 && iVar.i() == -9223372036854775807L;
        this.B = z10;
        this.C = z10 ? 7 : 1;
        this.f21389h.m(this.A, iVar.e(), this.B);
        if (this.f21404w) {
            return;
        }
        R();
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public void e(long j10) {
    }

    public int e0(int i10, long j10) {
        if (g0()) {
            return 0;
        }
        S(i10);
        l0 l0Var = this.f21401t[i10];
        int E = l0Var.E(j10, this.L);
        l0Var.e0(E);
        if (E == 0) {
            T(i10);
        }
        return E;
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public long f() {
        if (this.F == 0) {
            return Long.MIN_VALUE;
        }
        return d();
    }

    public final void f0() {
        a aVar = new a(this.f21383b, this.f21384c, this.f21394m, this, this.f21395n);
        if (this.f21404w) {
            com.google.android.exoplayer2.util.a.g(N());
            long j10 = this.A;
            if (j10 != -9223372036854775807L && this.I > j10) {
                this.L = true;
                this.I = -9223372036854775807L;
                return;
            }
            aVar.j(((com.google.android.exoplayer2.extractor.i) com.google.android.exoplayer2.util.a.e(this.f21407z)).d(this.I).f20077a.f48645b, this.I);
            for (l0 l0Var : this.f21401t) {
                l0Var.b0(this.I);
            }
            this.I = -9223372036854775807L;
        }
        this.K = K();
        this.f21387f.A(new m(aVar.f21408a, aVar.f21418k, this.f21393l.n(aVar, this, this.f21386e.d(this.C))), 1, -1, null, 0, null, aVar.f21417j, this.A);
    }

    @Override // com.google.android.exoplayer2.source.p
    public long g(long j10, p1 p1Var) {
        G();
        if (!this.f21407z.e()) {
            return 0L;
        }
        i.a d10 = this.f21407z.d(j10);
        return p1Var.a(j10, d10.f20077a.f48644a, d10.f20078b.f48644a);
    }

    public final boolean g0() {
        return this.E || N();
    }

    @Override // com.google.android.exoplayer2.source.p
    public long h(long j10) {
        G();
        boolean[] zArr = this.f21406y.f21428b;
        if (!this.f21407z.e()) {
            j10 = 0;
        }
        int i10 = 0;
        this.E = false;
        this.H = j10;
        if (N()) {
            this.I = j10;
            return j10;
        }
        if (this.C != 7 && c0(zArr, j10)) {
            return j10;
        }
        this.J = false;
        this.I = j10;
        this.L = false;
        if (this.f21393l.j()) {
            l0[] l0VarArr = this.f21401t;
            int length = l0VarArr.length;
            while (i10 < length) {
                l0VarArr[i10].r();
                i10++;
            }
            this.f21393l.f();
        } else {
            this.f21393l.g();
            l0[] l0VarArr2 = this.f21401t;
            int length2 = l0VarArr2.length;
            while (i10 < length2) {
                l0VarArr2[i10].V();
                i10++;
            }
        }
        return j10;
    }

    @Override // com.google.android.exoplayer2.source.p
    public long i() {
        if (!this.E) {
            return -9223372036854775807L;
        }
        if (!this.L && K() <= this.K) {
            return -9223372036854775807L;
        }
        this.E = false;
        return this.H;
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public boolean isLoading() {
        return this.f21393l.j() && this.f21395n.d();
    }

    @Override // com.google.android.exoplayer2.source.p
    public long j(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j10) {
        G();
        e eVar = this.f21406y;
        TrackGroupArray trackGroupArray = eVar.f21427a;
        boolean[] zArr3 = eVar.f21429c;
        int i10 = this.F;
        int i11 = 0;
        for (int i12 = 0; i12 < exoTrackSelectionArr.length; i12++) {
            if (sampleStreamArr[i12] != null && (exoTrackSelectionArr[i12] == null || !zArr[i12])) {
                int i13 = ((c) sampleStreamArr[i12]).f21423b;
                com.google.android.exoplayer2.util.a.g(zArr3[i13]);
                this.F--;
                zArr3[i13] = false;
                sampleStreamArr[i12] = null;
            }
        }
        boolean z10 = !this.D ? j10 == 0 : i10 != 0;
        for (int i14 = 0; i14 < exoTrackSelectionArr.length; i14++) {
            if (sampleStreamArr[i14] == null && exoTrackSelectionArr[i14] != null) {
                ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i14];
                com.google.android.exoplayer2.util.a.g(exoTrackSelection.length() == 1);
                com.google.android.exoplayer2.util.a.g(exoTrackSelection.c(0) == 0);
                int b4 = trackGroupArray.b(exoTrackSelection.g());
                com.google.android.exoplayer2.util.a.g(!zArr3[b4]);
                this.F++;
                zArr3[b4] = true;
                sampleStreamArr[i14] = new c(b4);
                zArr2[i14] = true;
                if (!z10) {
                    l0 l0Var = this.f21401t[b4];
                    z10 = (l0Var.Z(j10, true) || l0Var.C() == 0) ? false : true;
                }
            }
        }
        if (this.F == 0) {
            this.J = false;
            this.E = false;
            if (this.f21393l.j()) {
                l0[] l0VarArr = this.f21401t;
                int length = l0VarArr.length;
                while (i11 < length) {
                    l0VarArr[i11].r();
                    i11++;
                }
                this.f21393l.f();
            } else {
                l0[] l0VarArr2 = this.f21401t;
                int length2 = l0VarArr2.length;
                while (i11 < length2) {
                    l0VarArr2[i11].V();
                    i11++;
                }
            }
        } else if (z10) {
            j10 = h(j10);
            while (i11 < sampleStreamArr.length) {
                if (sampleStreamArr[i11] != null) {
                    zArr2[i11] = true;
                }
                i11++;
            }
        }
        this.D = true;
        return j10;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.f
    public void k() {
        for (l0 l0Var : this.f21401t) {
            l0Var.T();
        }
        this.f21394m.release();
    }

    @Override // d5.e
    public void l() {
        this.f21403v = true;
        this.f21398q.post(this.f21396o);
    }

    @Override // com.google.android.exoplayer2.source.p
    public TrackGroupArray m() {
        G();
        return this.f21406y.f21427a;
    }

    @Override // com.google.android.exoplayer2.source.p
    public void p(p.a aVar, long j10) {
        this.f21399r = aVar;
        this.f21395n.e();
        f0();
    }

    @Override // d5.e
    public void r(final com.google.android.exoplayer2.extractor.i iVar) {
        this.f21398q.post(new Runnable() { // from class: com.google.android.exoplayer2.source.f0
            @Override // java.lang.Runnable
            public final void run() {
                g0.this.Q(iVar);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.p
    public void s() throws IOException {
        U();
        if (this.L && !this.f21404w) {
            throw ParserException.createForMalformedContainer("Loading finished before preparation is complete.", null);
        }
    }

    @Override // com.google.android.exoplayer2.source.p
    public void t(long j10, boolean z10) {
        G();
        if (N()) {
            return;
        }
        boolean[] zArr = this.f21406y.f21429c;
        int length = this.f21401t.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.f21401t[i10].q(j10, z10, zArr[i10]);
        }
    }
}
