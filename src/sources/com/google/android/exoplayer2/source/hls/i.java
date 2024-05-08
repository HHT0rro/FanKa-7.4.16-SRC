package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.hls.e;
import com.google.android.exoplayer2.source.hls.playlist.c;
import com.google.android.exoplayer2.upstream.b;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.f0;
import com.google.android.exoplayer2.util.h0;
import com.google.android.exoplayer2.util.j0;
import com.google.common.collect.ImmutableList;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: HlsMediaChunk.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class i extends x5.n {
    public static final AtomicInteger L = new AtomicInteger();
    public final boolean A;
    public final boolean B;
    public j C;
    public p D;
    public int E;
    public boolean F;
    public volatile boolean G;
    public boolean H;
    public ImmutableList<Integer> I;
    public boolean J;
    public boolean K;

    /* renamed from: k, reason: collision with root package name */
    public final int f21532k;

    /* renamed from: l, reason: collision with root package name */
    public final int f21533l;

    /* renamed from: m, reason: collision with root package name */
    public final Uri f21534m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f21535n;

    /* renamed from: o, reason: collision with root package name */
    public final int f21536o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    public final com.google.android.exoplayer2.upstream.a f21537p;

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public final com.google.android.exoplayer2.upstream.b f21538q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public final j f21539r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f21540s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f21541t;

    /* renamed from: u, reason: collision with root package name */
    public final f0 f21542u;

    /* renamed from: v, reason: collision with root package name */
    public final g f21543v;

    /* renamed from: w, reason: collision with root package name */
    @Nullable
    public final List<Format> f21544w;

    /* renamed from: x, reason: collision with root package name */
    @Nullable
    public final DrmInitData f21545x;

    /* renamed from: y, reason: collision with root package name */
    public final r5.b f21546y;

    /* renamed from: z, reason: collision with root package name */
    public final ParsableByteArray f21547z;

    public i(g gVar, com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, Format format, boolean z10, @Nullable com.google.android.exoplayer2.upstream.a aVar2, @Nullable com.google.android.exoplayer2.upstream.b bVar2, boolean z11, Uri uri, @Nullable List<Format> list, int i10, @Nullable Object obj, long j10, long j11, long j12, int i11, boolean z12, int i12, boolean z13, boolean z14, f0 f0Var, @Nullable DrmInitData drmInitData, @Nullable j jVar, r5.b bVar3, ParsableByteArray parsableByteArray, boolean z15) {
        super(aVar, bVar, format, i10, obj, j10, j11, j12);
        this.A = z10;
        this.f21536o = i11;
        this.K = z12;
        this.f21533l = i12;
        this.f21538q = bVar2;
        this.f21537p = aVar2;
        this.F = bVar2 != null;
        this.B = z11;
        this.f21534m = uri;
        this.f21540s = z14;
        this.f21542u = f0Var;
        this.f21541t = z13;
        this.f21543v = gVar;
        this.f21544w = list;
        this.f21545x = drmInitData;
        this.f21539r = jVar;
        this.f21546y = bVar3;
        this.f21547z = parsableByteArray;
        this.f21535n = z15;
        this.I = ImmutableList.of();
        this.f21532k = L.getAndIncrement();
    }

    public static com.google.android.exoplayer2.upstream.a h(com.google.android.exoplayer2.upstream.a aVar, @Nullable byte[] bArr, @Nullable byte[] bArr2) {
        if (bArr == null) {
            return aVar;
        }
        com.google.android.exoplayer2.util.a.e(bArr2);
        return new a(aVar, bArr, bArr2);
    }

    public static i i(g gVar, com.google.android.exoplayer2.upstream.a aVar, Format format, long j10, com.google.android.exoplayer2.source.hls.playlist.c cVar, e.C0196e c0196e, Uri uri, @Nullable List<Format> list, int i10, @Nullable Object obj, boolean z10, q qVar, @Nullable i iVar, @Nullable byte[] bArr, @Nullable byte[] bArr2, boolean z11) {
        boolean z12;
        com.google.android.exoplayer2.upstream.a aVar2;
        com.google.android.exoplayer2.upstream.b bVar;
        boolean z13;
        r5.b bVar2;
        ParsableByteArray parsableByteArray;
        j jVar;
        c.e eVar = c0196e.f21525a;
        com.google.android.exoplayer2.upstream.b a10 = new b.C0209b().i(h0.e(cVar.f711a, eVar.f21716b)).h(eVar.f21724j).g(eVar.f21725k).b(c0196e.f21528d ? 8 : 0).a();
        boolean z14 = bArr != null;
        com.google.android.exoplayer2.upstream.a h10 = h(aVar, bArr, z14 ? k((String) com.google.android.exoplayer2.util.a.e(eVar.f21723i)) : null);
        c.d dVar = eVar.f21717c;
        if (dVar != null) {
            boolean z15 = bArr2 != null;
            byte[] k10 = z15 ? k((String) com.google.android.exoplayer2.util.a.e(dVar.f21723i)) : null;
            z12 = z14;
            bVar = new com.google.android.exoplayer2.upstream.b(h0.e(cVar.f711a, dVar.f21716b), dVar.f21724j, dVar.f21725k);
            aVar2 = h(aVar, bArr2, k10);
            z13 = z15;
        } else {
            z12 = z14;
            aVar2 = null;
            bVar = null;
            z13 = false;
        }
        long j11 = j10 + eVar.f21720f;
        long j12 = j11 + eVar.f21718d;
        int i11 = cVar.f21696j + eVar.f21719e;
        if (iVar != null) {
            com.google.android.exoplayer2.upstream.b bVar3 = iVar.f21538q;
            boolean z16 = bVar == bVar3 || (bVar != null && bVar3 != null && bVar.f22767a.equals(bVar3.f22767a) && bVar.f22773g == iVar.f21538q.f22773g);
            boolean z17 = uri.equals(iVar.f21534m) && iVar.H;
            bVar2 = iVar.f21546y;
            parsableByteArray = iVar.f21547z;
            jVar = (z16 && z17 && !iVar.J && iVar.f21533l == i11) ? iVar.C : null;
        } else {
            bVar2 = new r5.b();
            parsableByteArray = new ParsableByteArray(10);
            jVar = null;
        }
        return new i(gVar, h10, a10, format, z12, aVar2, bVar, z13, uri, list, i10, obj, j11, j12, c0196e.f21526b, c0196e.f21527c, !c0196e.f21528d, i11, eVar.f21726l, z10, qVar.a(i11), eVar.f21721g, jVar, bVar2, parsableByteArray, z11);
    }

    public static byte[] k(String str) {
        if (com.google.common.base.a.e(str).startsWith("0x")) {
            str = str.substring(2);
        }
        byte[] byteArray = new BigInteger(str, 16).toByteArray();
        byte[] bArr = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy((Object) byteArray, length, (Object) bArr, (16 - byteArray.length) + length, byteArray.length - length);
        return bArr;
    }

    public static boolean o(e.C0196e c0196e, com.google.android.exoplayer2.source.hls.playlist.c cVar) {
        c.e eVar = c0196e.f21525a;
        if (eVar instanceof c.b) {
            return ((c.b) eVar).f21709m || (c0196e.f21527c == 0 && cVar.f713c);
        }
        return cVar.f713c;
    }

    public static boolean v(@Nullable i iVar, Uri uri, com.google.android.exoplayer2.source.hls.playlist.c cVar, e.C0196e c0196e, long j10) {
        if (iVar == null) {
            return false;
        }
        if (uri.equals(iVar.f21534m) && iVar.H) {
            return false;
        }
        return !o(c0196e, cVar) || j10 + c0196e.f21525a.f21720f < iVar.f54513h;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void b() {
        this.G = true;
    }

    @Override // x5.n
    public boolean g() {
        return this.H;
    }

    public final void j(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, boolean z10) throws IOException {
        com.google.android.exoplayer2.upstream.b e2;
        long position;
        long j10;
        if (z10) {
            r0 = this.E != 0;
            e2 = bVar;
        } else {
            e2 = bVar.e(this.E);
        }
        try {
            d5.b t2 = t(aVar, e2);
            if (r0) {
                t2.r(this.E);
            }
            do {
                try {
                    try {
                        if (this.G) {
                            break;
                        }
                    } catch (EOFException e10) {
                        if ((this.f54509d.f19537f & 16384) != 0) {
                            this.C.c();
                            position = t2.getPosition();
                            j10 = bVar.f22773g;
                        } else {
                            throw e10;
                        }
                    }
                } catch (Throwable th) {
                    this.E = (int) (t2.getPosition() - bVar.f22773g);
                    throw th;
                }
            } while (this.C.a(t2));
            position = t2.getPosition();
            j10 = bVar.f22773g;
            this.E = (int) (position - j10);
        } finally {
            j0.n(aVar);
        }
    }

    public int l(int i10) {
        com.google.android.exoplayer2.util.a.g(!this.f21535n);
        if (i10 >= this.I.size()) {
            return 0;
        }
        return this.I.get(i10).intValue();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void load() throws IOException {
        j jVar;
        com.google.android.exoplayer2.util.a.e(this.D);
        if (this.C == null && (jVar = this.f21539r) != null && jVar.d()) {
            this.C = this.f21539r;
            this.F = false;
        }
        r();
        if (this.G) {
            return;
        }
        if (!this.f21541t) {
            q();
        }
        this.H = !this.G;
    }

    public void m(p pVar, ImmutableList<Integer> immutableList) {
        this.D = pVar;
        this.I = immutableList;
    }

    public void n() {
        this.J = true;
    }

    public boolean p() {
        return this.K;
    }

    public final void q() throws IOException {
        try {
            this.f21542u.h(this.f21540s, this.f54512g);
            j(this.f54514i, this.f54507b, this.A);
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    public final void r() throws IOException {
        if (this.F) {
            com.google.android.exoplayer2.util.a.e(this.f21537p);
            com.google.android.exoplayer2.util.a.e(this.f21538q);
            j(this.f21537p, this.f21538q, this.B);
            this.E = 0;
            this.F = false;
        }
    }

    public final long s(d5.d dVar) throws IOException {
        dVar.m();
        try {
            this.f21547z.L(10);
            dVar.j(this.f21547z.d(), 0, 10);
        } catch (EOFException unused) {
        }
        if (this.f21547z.G() != 4801587) {
            return -9223372036854775807L;
        }
        this.f21547z.Q(3);
        int C = this.f21547z.C();
        int i10 = C + 10;
        if (i10 > this.f21547z.b()) {
            byte[] d10 = this.f21547z.d();
            this.f21547z.L(i10);
            System.arraycopy((Object) d10, 0, (Object) this.f21547z.d(), 0, 10);
        }
        dVar.j(this.f21547z.d(), 10, C);
        Metadata e2 = this.f21546y.e(this.f21547z.d(), C);
        if (e2 == null) {
            return -9223372036854775807L;
        }
        int d11 = e2.d();
        for (int i11 = 0; i11 < d11; i11++) {
            Metadata.Entry c4 = e2.c(i11);
            if (c4 instanceof PrivFrame) {
                PrivFrame privFrame = (PrivFrame) c4;
                if ("com.apple.streaming.transportStreamTimestamp".equals(privFrame.f20912c)) {
                    System.arraycopy((Object) privFrame.f20913d, 0, (Object) this.f21547z.d(), 0, 8);
                    this.f21547z.P(0);
                    this.f21547z.O(8);
                    return this.f21547z.w() & 8589934591L;
                }
            }
        }
        return -9223372036854775807L;
    }

    public final d5.b t(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        j a10;
        long j10;
        d5.b bVar2 = new d5.b(aVar, bVar.f22773g, aVar.a(bVar));
        if (this.C == null) {
            long s2 = s(bVar2);
            bVar2.m();
            j jVar = this.f21539r;
            if (jVar != null) {
                a10 = jVar.f();
            } else {
                a10 = this.f21543v.a(bVar.f22767a, this.f54509d, this.f21544w, this.f21542u, aVar.e(), bVar2);
            }
            this.C = a10;
            if (a10.e()) {
                p pVar = this.D;
                if (s2 != -9223372036854775807L) {
                    j10 = this.f21542u.b(s2);
                } else {
                    j10 = this.f54512g;
                }
                pVar.l0(j10);
            } else {
                this.D.l0(0L);
            }
            this.D.X();
            this.C.b(this.D);
        }
        this.D.i0(this.f21545x);
        return bVar2;
    }

    public void u() {
        this.K = true;
    }
}
