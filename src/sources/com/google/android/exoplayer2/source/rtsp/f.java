package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import b6.x;
import b6.y;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.l0;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.rtsp.RtspMediaSource;
import com.google.android.exoplayer2.source.rtsp.a;
import com.google.android.exoplayer2.source.rtsp.b;
import com.google.android.exoplayer2.source.rtsp.d;
import com.google.android.exoplayer2.source.rtsp.f;
import com.google.android.exoplayer2.source.rtsp.g;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.j0;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.net.BindException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: RtspMediaPeriod.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f implements p {

    /* renamed from: b, reason: collision with root package name */
    public final o6.b f21941b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f21942c = j0.x();

    /* renamed from: d, reason: collision with root package name */
    public final b f21943d;

    /* renamed from: e, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.rtsp.d f21944e;

    /* renamed from: f, reason: collision with root package name */
    public final List<e> f21945f;

    /* renamed from: g, reason: collision with root package name */
    public final List<d> f21946g;

    /* renamed from: h, reason: collision with root package name */
    public final c f21947h;

    /* renamed from: i, reason: collision with root package name */
    public final a.InterfaceC0200a f21948i;

    /* renamed from: j, reason: collision with root package name */
    public p.a f21949j;

    /* renamed from: k, reason: collision with root package name */
    public ImmutableList<TrackGroup> f21950k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public IOException f21951l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public RtspMediaSource.RtspPlaybackException f21952m;

    /* renamed from: n, reason: collision with root package name */
    public long f21953n;

    /* renamed from: o, reason: collision with root package name */
    public long f21954o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f21955p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f21956q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f21957r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f21958s;

    /* renamed from: t, reason: collision with root package name */
    public int f21959t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f21960u;

    /* compiled from: RtspMediaPeriod.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class b implements d5.e, Loader.b<com.google.android.exoplayer2.source.rtsp.b>, l0.d, d.f, d.e {
        public b() {
        }

        @Override // com.google.android.exoplayer2.source.l0.d
        public void a(Format format) {
            Handler handler = f.this.f21942c;
            final f fVar = f.this;
            handler.post(new Runnable() { // from class: b6.m
                @Override // java.lang.Runnable
                public final void run() {
                    com.google.android.exoplayer2.source.rtsp.f.w(com.google.android.exoplayer2.source.rtsp.f.this);
                }
            });
        }

        @Override // com.google.android.exoplayer2.source.rtsp.d.f
        public void b(String str, @Nullable Throwable th) {
            f.this.f21951l = th == null ? new IOException(str) : new IOException(str, th);
        }

        @Override // d5.e
        public TrackOutput c(int i10, int i11) {
            return ((e) com.google.android.exoplayer2.util.a.e((e) f.this.f21945f.get(i10))).f21968c;
        }

        @Override // com.google.android.exoplayer2.source.rtsp.d.e
        public void d() {
            f.this.f21944e.Q(0L);
        }

        @Override // com.google.android.exoplayer2.source.rtsp.d.e
        public void e(long j10, ImmutableList<y> immutableList) {
            ArrayList arrayList = new ArrayList(immutableList.size());
            for (int i10 = 0; i10 < immutableList.size(); i10++) {
                arrayList.add((String) com.google.android.exoplayer2.util.a.e(immutableList.get(i10).f1376c.getPath()));
            }
            for (int i11 = 0; i11 < f.this.f21946g.size(); i11++) {
                d dVar = (d) f.this.f21946g.get(i11);
                if (!arrayList.contains(dVar.c().getPath())) {
                    f fVar = f.this;
                    String valueOf = String.valueOf(dVar.c());
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 40);
                    sb2.append("Server did not provide timing for track ");
                    sb2.append(valueOf);
                    fVar.f21952m = new RtspMediaSource.RtspPlaybackException(sb2.toString());
                    return;
                }
            }
            for (int i12 = 0; i12 < immutableList.size(); i12++) {
                y yVar = immutableList.get(i12);
                com.google.android.exoplayer2.source.rtsp.b J = f.this.J(yVar.f1376c);
                if (J != null) {
                    J.g(yVar.f1374a);
                    J.f(yVar.f1375b);
                    if (f.this.L()) {
                        J.e(j10, yVar.f1374a);
                    }
                }
            }
            if (f.this.L()) {
                f.this.f21954o = -9223372036854775807L;
            }
        }

        @Override // com.google.android.exoplayer2.source.rtsp.d.f
        public void f(x xVar, ImmutableList<b6.p> immutableList) {
            for (int i10 = 0; i10 < immutableList.size(); i10++) {
                b6.p pVar = immutableList.get(i10);
                f fVar = f.this;
                e eVar = new e(pVar, i10, fVar.f21948i);
                f.this.f21945f.add(eVar);
                eVar.i();
            }
            f.this.f21947h.a(xVar);
        }

        @Override // com.google.android.exoplayer2.source.rtsp.d.e
        public void g(RtspMediaSource.RtspPlaybackException rtspPlaybackException) {
            f.this.f21952m = rtspPlaybackException;
        }

        @Override // d5.e
        public void l() {
            Handler handler = f.this.f21942c;
            final f fVar = f.this;
            handler.post(new Runnable() { // from class: b6.l
                @Override // java.lang.Runnable
                public final void run() {
                    com.google.android.exoplayer2.source.rtsp.f.w(com.google.android.exoplayer2.source.rtsp.f.this);
                }
            });
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void n(com.google.android.exoplayer2.source.rtsp.b bVar, long j10, long j11, boolean z10) {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public void o(com.google.android.exoplayer2.source.rtsp.b bVar, long j10, long j11) {
            if (f.this.d() == 0) {
                if (f.this.f21960u) {
                    return;
                }
                f.this.Q();
                f.this.f21960u = true;
                return;
            }
            for (int i10 = 0; i10 < f.this.f21945f.size(); i10++) {
                e eVar = (e) f.this.f21945f.get(i10);
                if (eVar.f21966a.f21963b == bVar) {
                    eVar.c();
                    return;
                }
            }
        }

        @Override // d5.e
        public void r(com.google.android.exoplayer2.extractor.i iVar) {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public Loader.c q(com.google.android.exoplayer2.source.rtsp.b bVar, long j10, long j11, IOException iOException, int i10) {
            if (!f.this.f21957r) {
                f.this.f21951l = iOException;
            } else if (iOException.getCause() instanceof BindException) {
                if (f.a(f.this) < 3) {
                    return Loader.f22730d;
                }
            } else {
                f.this.f21952m = new RtspMediaSource.RtspPlaybackException(bVar.f21901b.f1353b.toString(), iOException);
            }
            return Loader.f22732f;
        }
    }

    /* compiled from: RtspMediaPeriod.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface c {
        void a(x xVar);
    }

    /* compiled from: RtspMediaPeriod.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class d {

        /* renamed from: a, reason: collision with root package name */
        public final b6.p f21962a;

        /* renamed from: b, reason: collision with root package name */
        public final com.google.android.exoplayer2.source.rtsp.b f21963b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public String f21964c;

        public d(b6.p pVar, int i10, a.InterfaceC0200a interfaceC0200a) {
            this.f21962a = pVar;
            this.f21963b = new com.google.android.exoplayer2.source.rtsp.b(i10, pVar, new b.a() { // from class: b6.n
                @Override // com.google.android.exoplayer2.source.rtsp.b.a
                public final void a(String str, com.google.android.exoplayer2.source.rtsp.a aVar) {
                    f.d.this.f(str, aVar);
                }
            }, f.this.f21943d, interfaceC0200a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(String str, com.google.android.exoplayer2.source.rtsp.a aVar) {
            this.f21964c = str;
            g.b p10 = aVar.p();
            if (p10 != null) {
                f.this.f21944e.K(aVar.c(), p10);
                f.this.f21960u = true;
            }
            f.this.N();
        }

        public Uri c() {
            return this.f21963b.f21901b.f1353b;
        }

        public String d() {
            com.google.android.exoplayer2.util.a.i(this.f21964c);
            return this.f21964c;
        }

        public boolean e() {
            return this.f21964c != null;
        }
    }

    /* compiled from: RtspMediaPeriod.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class e {

        /* renamed from: a, reason: collision with root package name */
        public final d f21966a;

        /* renamed from: b, reason: collision with root package name */
        public final Loader f21967b;

        /* renamed from: c, reason: collision with root package name */
        public final l0 f21968c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f21969d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f21970e;

        public e(b6.p pVar, int i10, a.InterfaceC0200a interfaceC0200a) {
            this.f21966a = new d(pVar, i10, interfaceC0200a);
            StringBuilder sb2 = new StringBuilder(55);
            sb2.append("ExoPlayer:RtspMediaPeriod:RtspLoaderWrapper ");
            sb2.append(i10);
            this.f21967b = new Loader(sb2.toString());
            l0 l10 = l0.l(f.this.f21941b);
            this.f21968c = l10;
            l10.d0(f.this.f21943d);
        }

        public void c() {
            if (this.f21969d) {
                return;
            }
            this.f21966a.f21963b.b();
            this.f21969d = true;
            f.this.S();
        }

        public long d() {
            return this.f21968c.z();
        }

        public boolean e() {
            return this.f21968c.K(this.f21969d);
        }

        public int f(s0 s0Var, DecoderInputBuffer decoderInputBuffer, int i10) {
            return this.f21968c.S(s0Var, decoderInputBuffer, i10, this.f21969d);
        }

        public void g() {
            if (this.f21970e) {
                return;
            }
            this.f21967b.l();
            this.f21968c.T();
            this.f21970e = true;
        }

        public void h(long j10) {
            if (this.f21969d) {
                return;
            }
            this.f21966a.f21963b.d();
            this.f21968c.V();
            this.f21968c.b0(j10);
        }

        public void i() {
            this.f21967b.n(this.f21966a.f21963b, f.this.f21943d, 0);
        }
    }

    /* compiled from: RtspMediaPeriod.java */
    /* renamed from: com.google.android.exoplayer2.source.rtsp.f$f, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class C0202f implements SampleStream {

        /* renamed from: b, reason: collision with root package name */
        public final int f21972b;

        public C0202f(int i10) {
            this.f21972b = i10;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void a() throws RtspMediaSource.RtspPlaybackException {
            if (f.this.f21952m != null) {
                throw f.this.f21952m;
            }
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int c(s0 s0Var, DecoderInputBuffer decoderInputBuffer, int i10) {
            return f.this.O(this.f21972b, s0Var, decoderInputBuffer, i10);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return f.this.K(this.f21972b);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int l(long j10) {
            return 0;
        }
    }

    public f(o6.b bVar, a.InterfaceC0200a interfaceC0200a, Uri uri, c cVar, String str) {
        this.f21941b = bVar;
        this.f21948i = interfaceC0200a;
        this.f21947h = cVar;
        b bVar2 = new b();
        this.f21943d = bVar2;
        this.f21944e = new com.google.android.exoplayer2.source.rtsp.d(bVar2, bVar2, str, uri);
        this.f21945f = new ArrayList();
        this.f21946g = new ArrayList();
        this.f21954o = -9223372036854775807L;
    }

    public static ImmutableList<TrackGroup> I(ImmutableList<e> immutableList) {
        ImmutableList.a aVar = new ImmutableList.a();
        for (int i10 = 0; i10 < immutableList.size(); i10++) {
            aVar.a(new TrackGroup((Format) com.google.android.exoplayer2.util.a.e(immutableList.get(i10).f21968c.F())));
        }
        return aVar.k();
    }

    public static /* synthetic */ int a(f fVar) {
        int i10 = fVar.f21959t;
        fVar.f21959t = i10 + 1;
        return i10;
    }

    public static /* synthetic */ void w(f fVar) {
        fVar.M();
    }

    @Nullable
    public final com.google.android.exoplayer2.source.rtsp.b J(Uri uri) {
        for (int i10 = 0; i10 < this.f21945f.size(); i10++) {
            if (!this.f21945f.get(i10).f21969d) {
                d dVar = this.f21945f.get(i10).f21966a;
                if (dVar.c().equals(uri)) {
                    return dVar.f21963b;
                }
            }
        }
        return null;
    }

    public boolean K(int i10) {
        return this.f21945f.get(i10).e();
    }

    public final boolean L() {
        return this.f21954o != -9223372036854775807L;
    }

    public final void M() {
        if (this.f21956q || this.f21957r) {
            return;
        }
        for (int i10 = 0; i10 < this.f21945f.size(); i10++) {
            if (this.f21945f.get(i10).f21968c.F() == null) {
                return;
            }
        }
        this.f21957r = true;
        this.f21950k = I(ImmutableList.copyOf((Collection) this.f21945f));
        ((p.a) com.google.android.exoplayer2.util.a.e(this.f21949j)).n(this);
    }

    public final void N() {
        boolean z10 = true;
        for (int i10 = 0; i10 < this.f21946g.size(); i10++) {
            z10 &= this.f21946g.get(i10).e();
        }
        if (z10 && this.f21958s) {
            this.f21944e.O(this.f21946g);
        }
    }

    public int O(int i10, s0 s0Var, DecoderInputBuffer decoderInputBuffer, int i11) {
        return this.f21945f.get(i10).f(s0Var, decoderInputBuffer, i11);
    }

    public void P() {
        for (int i10 = 0; i10 < this.f21945f.size(); i10++) {
            this.f21945f.get(i10).g();
        }
        j0.o(this.f21944e);
        this.f21956q = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Q() {
        this.f21944e.L();
        a.InterfaceC0200a a10 = this.f21948i.a();
        if (a10 == null) {
            this.f21952m = new RtspMediaSource.RtspPlaybackException("No fallback data channel factory for TCP retry");
            return;
        }
        ArrayList arrayList = new ArrayList(this.f21945f.size());
        ArrayList arrayList2 = new ArrayList(this.f21946g.size());
        for (int i10 = 0; i10 < this.f21945f.size(); i10++) {
            e eVar = this.f21945f.get(i10);
            if (!eVar.f21969d) {
                e eVar2 = new e(eVar.f21966a.f21962a, i10, a10);
                arrayList.add(eVar2);
                eVar2.i();
                if (this.f21946g.contains(eVar.f21966a)) {
                    arrayList2.add(eVar2.f21966a);
                }
            } else {
                arrayList.add(eVar);
            }
        }
        ImmutableList copyOf = ImmutableList.copyOf((Collection) this.f21945f);
        this.f21945f.clear();
        this.f21945f.addAll(arrayList);
        this.f21946g.clear();
        this.f21946g.addAll(arrayList2);
        for (int i11 = 0; i11 < copyOf.size(); i11++) {
            ((e) copyOf.get(i11)).c();
        }
    }

    public final boolean R(long j10) {
        for (int i10 = 0; i10 < this.f21945f.size(); i10++) {
            if (!this.f21945f.get(i10).f21968c.Z(j10, false)) {
                return false;
            }
        }
        return true;
    }

    public final void S() {
        this.f21955p = true;
        for (int i10 = 0; i10 < this.f21945f.size(); i10++) {
            this.f21955p &= this.f21945f.get(i10).f21969d;
        }
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public boolean b(long j10) {
        return isLoading();
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public long d() {
        if (this.f21955p || this.f21945f.isEmpty()) {
            return Long.MIN_VALUE;
        }
        if (L()) {
            return this.f21954o;
        }
        long j10 = Long.MAX_VALUE;
        boolean z10 = true;
        for (int i10 = 0; i10 < this.f21945f.size(); i10++) {
            e eVar = this.f21945f.get(i10);
            if (!eVar.f21969d) {
                j10 = Math.min(j10, eVar.d());
                z10 = false;
            }
        }
        return (z10 || j10 == Long.MIN_VALUE) ? this.f21953n : j10;
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public void e(long j10) {
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public long f() {
        return d();
    }

    @Override // com.google.android.exoplayer2.source.p
    public long g(long j10, p1 p1Var) {
        return j10;
    }

    @Override // com.google.android.exoplayer2.source.p
    public long h(long j10) {
        if (L()) {
            return this.f21954o;
        }
        if (R(j10)) {
            return j10;
        }
        this.f21953n = j10;
        this.f21954o = j10;
        this.f21944e.M(j10);
        for (int i10 = 0; i10 < this.f21945f.size(); i10++) {
            this.f21945f.get(i10).h(j10);
        }
        return j10;
    }

    @Override // com.google.android.exoplayer2.source.p
    public long i() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public boolean isLoading() {
        return !this.f21955p;
    }

    @Override // com.google.android.exoplayer2.source.p
    public long j(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j10) {
        for (int i10 = 0; i10 < exoTrackSelectionArr.length; i10++) {
            if (sampleStreamArr[i10] != null && (exoTrackSelectionArr[i10] == null || !zArr[i10])) {
                sampleStreamArr[i10] = null;
            }
        }
        this.f21946g.clear();
        for (int i11 = 0; i11 < exoTrackSelectionArr.length; i11++) {
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i11];
            if (exoTrackSelection != null) {
                TrackGroup g3 = exoTrackSelection.g();
                int indexOf = ((ImmutableList) com.google.android.exoplayer2.util.a.e(this.f21950k)).indexOf(g3);
                this.f21946g.add(((e) com.google.android.exoplayer2.util.a.e(this.f21945f.get(indexOf))).f21966a);
                if (this.f21950k.contains(g3) && sampleStreamArr[i11] == null) {
                    sampleStreamArr[i11] = new C0202f(indexOf);
                    zArr2[i11] = true;
                }
            }
        }
        for (int i12 = 0; i12 < this.f21945f.size(); i12++) {
            e eVar = this.f21945f.get(i12);
            if (!this.f21946g.contains(eVar.f21966a)) {
                eVar.c();
            }
        }
        this.f21958s = true;
        N();
        return j10;
    }

    @Override // com.google.android.exoplayer2.source.p
    public TrackGroupArray m() {
        com.google.android.exoplayer2.util.a.g(this.f21957r);
        return new TrackGroupArray((TrackGroup[]) ((ImmutableList) com.google.android.exoplayer2.util.a.e(this.f21950k)).toArray(new TrackGroup[0]));
    }

    @Override // com.google.android.exoplayer2.source.p
    public void p(p.a aVar, long j10) {
        this.f21949j = aVar;
        try {
            this.f21944e.P();
        } catch (IOException e2) {
            this.f21951l = e2;
            j0.o(this.f21944e);
        }
    }

    @Override // com.google.android.exoplayer2.source.p
    public void s() throws IOException {
        IOException iOException = this.f21951l;
        if (iOException != null) {
            throw iOException;
        }
    }

    @Override // com.google.android.exoplayer2.source.p
    public void t(long j10, boolean z10) {
        if (L()) {
            return;
        }
        for (int i10 = 0; i10 < this.f21945f.size(); i10++) {
            e eVar = this.f21945f.get(i10);
            if (!eVar.f21969d) {
                eVar.f21968c.q(j10, z10, true);
            }
        }
    }
}
