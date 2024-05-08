package com.google.android.exoplayer2.extractor.ts;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.ts.h0;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import java.io.IOException;
import java.util.Map;

/* compiled from: AdtsExtractor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h implements Extractor {

    /* renamed from: m, reason: collision with root package name */
    public static final d5.i f20449m = new d5.i() { // from class: com.google.android.exoplayer2.extractor.ts.g
        @Override // d5.i
        public /* synthetic */ Extractor[] a(Uri uri, Map map) {
            return d5.h.a(this, uri, map);
        }

        @Override // d5.i
        public final Extractor[] b() {
            Extractor[] i10;
            i10 = h.i();
            return i10;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final int f20450a;

    /* renamed from: b, reason: collision with root package name */
    public final i f20451b;

    /* renamed from: c, reason: collision with root package name */
    public final ParsableByteArray f20452c;

    /* renamed from: d, reason: collision with root package name */
    public final ParsableByteArray f20453d;

    /* renamed from: e, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.u f20454e;

    /* renamed from: f, reason: collision with root package name */
    public d5.e f20455f;

    /* renamed from: g, reason: collision with root package name */
    public long f20456g;

    /* renamed from: h, reason: collision with root package name */
    public long f20457h;

    /* renamed from: i, reason: collision with root package name */
    public int f20458i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f20459j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f20460k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f20461l;

    public h() {
        this(0);
    }

    public static int e(int i10, long j10) {
        return (int) (((i10 * 8) * 1000000) / j10);
    }

    public static /* synthetic */ Extractor[] i() {
        return new Extractor[]{new h()};
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void a(long j10, long j11) {
        this.f20460k = false;
        this.f20451b.a();
        this.f20456g = j11;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(d5.e eVar) {
        this.f20455f = eVar;
        this.f20451b.e(eVar, new h0.d(0, 1));
        eVar.l();
    }

    public final void d(d5.d dVar) throws IOException {
        if (this.f20459j) {
            return;
        }
        this.f20458i = -1;
        dVar.m();
        long j10 = 0;
        if (dVar.getPosition() == 0) {
            k(dVar);
        }
        int i10 = 0;
        int i11 = 0;
        while (dVar.l(this.f20453d.d(), 0, 2, true)) {
            try {
                this.f20453d.P(0);
                if (!i.m(this.f20453d.J())) {
                    break;
                }
                if (!dVar.l(this.f20453d.d(), 0, 4, true)) {
                    break;
                }
                this.f20454e.p(14);
                int h10 = this.f20454e.h(13);
                if (h10 > 6) {
                    j10 += h10;
                    i11++;
                    if (i11 != 1000 && dVar.s(h10 - 6, true)) {
                    }
                    break;
                }
                this.f20459j = true;
                throw ParserException.createForMalformedContainer("Malformed ADTS stream", null);
            } catch (EOFException unused) {
            }
        }
        i10 = i11;
        dVar.m();
        if (i10 > 0) {
            this.f20458i = (int) (j10 / i10);
        } else {
            this.f20458i = -1;
        }
        this.f20459j = true;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int f(d5.d dVar, d5.n nVar) throws IOException {
        com.google.android.exoplayer2.util.a.i(this.f20455f);
        long b4 = dVar.b();
        boolean z10 = ((this.f20450a & 1) == 0 || b4 == -1) ? false : true;
        if (z10) {
            d(dVar);
        }
        int read = dVar.read(this.f20452c.d(), 0, 2048);
        boolean z11 = read == -1;
        j(b4, z10, z11);
        if (z11) {
            return -1;
        }
        this.f20452c.P(0);
        this.f20452c.O(read);
        if (!this.f20460k) {
            this.f20451b.f(this.f20456g, 4);
            this.f20460k = true;
        }
        this.f20451b.c(this.f20452c);
        return 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean g(d5.d dVar) throws IOException {
        int k10 = k(dVar);
        int i10 = k10;
        int i11 = 0;
        int i12 = 0;
        do {
            dVar.j(this.f20453d.d(), 0, 2);
            this.f20453d.P(0);
            if (i.m(this.f20453d.J())) {
                i11++;
                if (i11 >= 4 && i12 > 188) {
                    return true;
                }
                dVar.j(this.f20453d.d(), 0, 4);
                this.f20454e.p(14);
                int h10 = this.f20454e.h(13);
                if (h10 <= 6) {
                    i10++;
                    dVar.m();
                    dVar.q(i10);
                } else {
                    dVar.q(h10 - 6);
                    i12 += h10;
                }
            } else {
                i10++;
                dVar.m();
                dVar.q(i10);
            }
            i11 = 0;
            i12 = 0;
        } while (i10 - k10 < 8192);
        return false;
    }

    public final com.google.android.exoplayer2.extractor.i h(long j10) {
        return new com.google.android.exoplayer2.extractor.c(j10, this.f20457h, e(this.f20458i, this.f20451b.k()), this.f20458i);
    }

    public final void j(long j10, boolean z10, boolean z11) {
        if (this.f20461l) {
            return;
        }
        boolean z12 = z10 && this.f20458i > 0;
        if (z12 && this.f20451b.k() == -9223372036854775807L && !z11) {
            return;
        }
        if (z12 && this.f20451b.k() != -9223372036854775807L) {
            this.f20455f.r(h(j10));
        } else {
            this.f20455f.r(new i.b(-9223372036854775807L));
        }
        this.f20461l = true;
    }

    public final int k(d5.d dVar) throws IOException {
        int i10 = 0;
        while (true) {
            dVar.j(this.f20453d.d(), 0, 10);
            this.f20453d.P(0);
            if (this.f20453d.G() != 4801587) {
                break;
            }
            this.f20453d.Q(3);
            int C = this.f20453d.C();
            i10 += C + 10;
            dVar.q(C);
        }
        dVar.m();
        dVar.q(i10);
        if (this.f20457h == -1) {
            this.f20457h = i10;
        }
        return i10;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    public h(int i10) {
        this.f20450a = i10;
        this.f20451b = new i(true);
        this.f20452c = new ParsableByteArray(2048);
        this.f20458i = -1;
        this.f20457h = -1L;
        ParsableByteArray parsableByteArray = new ParsableByteArray(10);
        this.f20453d = parsableByteArray;
        this.f20454e = new com.google.android.exoplayer2.util.u(parsableByteArray.d());
    }
}
