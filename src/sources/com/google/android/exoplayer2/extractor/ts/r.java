package com.google.android.exoplayer2.extractor.ts;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.h0;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import x4.a;

/* compiled from: LatmReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class r implements m {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f20598a;

    /* renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f20599b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.u f20600c;

    /* renamed from: d, reason: collision with root package name */
    public TrackOutput f20601d;

    /* renamed from: e, reason: collision with root package name */
    public String f20602e;

    /* renamed from: f, reason: collision with root package name */
    public Format f20603f;

    /* renamed from: g, reason: collision with root package name */
    public int f20604g;

    /* renamed from: h, reason: collision with root package name */
    public int f20605h;

    /* renamed from: i, reason: collision with root package name */
    public int f20606i;

    /* renamed from: j, reason: collision with root package name */
    public int f20607j;

    /* renamed from: k, reason: collision with root package name */
    public long f20608k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f20609l;

    /* renamed from: m, reason: collision with root package name */
    public int f20610m;

    /* renamed from: n, reason: collision with root package name */
    public int f20611n;

    /* renamed from: o, reason: collision with root package name */
    public int f20612o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f20613p;

    /* renamed from: q, reason: collision with root package name */
    public long f20614q;

    /* renamed from: r, reason: collision with root package name */
    public int f20615r;

    /* renamed from: s, reason: collision with root package name */
    public long f20616s;

    /* renamed from: t, reason: collision with root package name */
    public int f20617t;

    /* renamed from: u, reason: collision with root package name */
    @Nullable
    public String f20618u;

    public r(@Nullable String str) {
        this.f20598a = str;
        ParsableByteArray parsableByteArray = new ParsableByteArray(1024);
        this.f20599b = parsableByteArray;
        this.f20600c = new com.google.android.exoplayer2.util.u(parsableByteArray.d());
        this.f20608k = -9223372036854775807L;
    }

    public static long b(com.google.android.exoplayer2.util.u uVar) {
        return uVar.h((uVar.h(2) + 1) * 8);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void a() {
        this.f20604g = 0;
        this.f20608k = -9223372036854775807L;
        this.f20609l = false;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void c(ParsableByteArray parsableByteArray) throws ParserException {
        com.google.android.exoplayer2.util.a.i(this.f20601d);
        while (parsableByteArray.a() > 0) {
            int i10 = this.f20604g;
            if (i10 != 0) {
                if (i10 == 1) {
                    int D = parsableByteArray.D();
                    if ((D & 224) == 224) {
                        this.f20607j = D;
                        this.f20604g = 2;
                    } else if (D != 86) {
                        this.f20604g = 0;
                    }
                } else if (i10 == 2) {
                    int D2 = ((this.f20607j & (-225)) << 8) | parsableByteArray.D();
                    this.f20606i = D2;
                    if (D2 > this.f20599b.d().length) {
                        m(this.f20606i);
                    }
                    this.f20605h = 0;
                    this.f20604g = 3;
                } else if (i10 == 3) {
                    int min = Math.min(parsableByteArray.a(), this.f20606i - this.f20605h);
                    parsableByteArray.j(this.f20600c.f23029a, this.f20605h, min);
                    int i11 = this.f20605h + min;
                    this.f20605h = i11;
                    if (i11 == this.f20606i) {
                        this.f20600c.p(0);
                        g(this.f20600c);
                        this.f20604g = 0;
                    }
                } else {
                    throw new IllegalStateException();
                }
            } else if (parsableByteArray.D() == 86) {
                this.f20604g = 1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void d() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void e(d5.e eVar, h0.d dVar) {
        dVar.a();
        this.f20601d = eVar.c(dVar.c(), 1);
        this.f20602e = dVar.b();
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void f(long j10, int i10) {
        if (j10 != -9223372036854775807L) {
            this.f20608k = j10;
        }
    }

    public final void g(com.google.android.exoplayer2.util.u uVar) throws ParserException {
        if (!uVar.g()) {
            this.f20609l = true;
            l(uVar);
        } else if (!this.f20609l) {
            return;
        }
        if (this.f20610m == 0) {
            if (this.f20611n == 0) {
                k(uVar, j(uVar));
                if (this.f20613p) {
                    uVar.r((int) this.f20614q);
                    return;
                }
                return;
            }
            throw ParserException.createForMalformedContainer(null, null);
        }
        throw ParserException.createForMalformedContainer(null, null);
    }

    public final int h(com.google.android.exoplayer2.util.u uVar) throws ParserException {
        int b4 = uVar.b();
        a.b f10 = x4.a.f(uVar, true);
        this.f20618u = f10.f54365c;
        this.f20615r = f10.f54363a;
        this.f20617t = f10.f54364b;
        return b4 - uVar.b();
    }

    public final void i(com.google.android.exoplayer2.util.u uVar) {
        int h10 = uVar.h(3);
        this.f20612o = h10;
        if (h10 == 0) {
            uVar.r(8);
            return;
        }
        if (h10 == 1) {
            uVar.r(9);
            return;
        }
        if (h10 == 3 || h10 == 4 || h10 == 5) {
            uVar.r(6);
        } else {
            if (h10 != 6 && h10 != 7) {
                throw new IllegalStateException();
            }
            uVar.r(1);
        }
    }

    public final int j(com.google.android.exoplayer2.util.u uVar) throws ParserException {
        int h10;
        if (this.f20612o != 0) {
            throw ParserException.createForMalformedContainer(null, null);
        }
        int i10 = 0;
        do {
            h10 = uVar.h(8);
            i10 += h10;
        } while (h10 == 255);
        return i10;
    }

    public final void k(com.google.android.exoplayer2.util.u uVar, int i10) {
        int e2 = uVar.e();
        if ((e2 & 7) == 0) {
            this.f20599b.P(e2 >> 3);
        } else {
            uVar.i(this.f20599b.d(), 0, i10 * 8);
            this.f20599b.P(0);
        }
        this.f20601d.a(this.f20599b, i10);
        long j10 = this.f20608k;
        if (j10 != -9223372036854775807L) {
            this.f20601d.d(j10, 1, i10, 0, null);
            this.f20608k += this.f20616s;
        }
    }

    public final void l(com.google.android.exoplayer2.util.u uVar) throws ParserException {
        boolean g3;
        int h10 = uVar.h(1);
        int h11 = h10 == 1 ? uVar.h(1) : 0;
        this.f20610m = h11;
        if (h11 == 0) {
            if (h10 == 1) {
                b(uVar);
            }
            if (uVar.g()) {
                this.f20611n = uVar.h(6);
                int h12 = uVar.h(4);
                int h13 = uVar.h(3);
                if (h12 == 0 && h13 == 0) {
                    if (h10 == 0) {
                        int e2 = uVar.e();
                        int h14 = h(uVar);
                        uVar.p(e2);
                        byte[] bArr = new byte[(h14 + 7) / 8];
                        uVar.i(bArr, 0, h14);
                        Format E = new Format.b().S(this.f20602e).e0("audio/mp4a-latm").I(this.f20618u).H(this.f20617t).f0(this.f20615r).T(Collections.singletonList(bArr)).V(this.f20598a).E();
                        if (!E.equals(this.f20603f)) {
                            this.f20603f = E;
                            this.f20616s = 1024000000 / E.A;
                            this.f20601d.b(E);
                        }
                    } else {
                        uVar.r(((int) b(uVar)) - h(uVar));
                    }
                    i(uVar);
                    boolean g10 = uVar.g();
                    this.f20613p = g10;
                    this.f20614q = 0L;
                    if (g10) {
                        if (h10 == 1) {
                            this.f20614q = b(uVar);
                        }
                        do {
                            g3 = uVar.g();
                            this.f20614q = (this.f20614q << 8) + uVar.h(8);
                        } while (g3);
                    }
                    if (uVar.g()) {
                        uVar.r(8);
                        return;
                    }
                    return;
                }
                throw ParserException.createForMalformedContainer(null, null);
            }
            throw ParserException.createForMalformedContainer(null, null);
        }
        throw ParserException.createForMalformedContainer(null, null);
    }

    public final void m(int i10) {
        this.f20599b.L(i10);
        this.f20600c.n(this.f20599b.d());
    }
}
