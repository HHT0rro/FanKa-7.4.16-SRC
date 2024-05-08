package com.google.android.exoplayer2.extractor.ts;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.h0;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;
import java.util.Collections;
import x4.a;

/* compiled from: AdtsReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class i implements m {

    /* renamed from: v, reason: collision with root package name */
    public static final byte[] f20474v = {73, 68, 51};

    /* renamed from: a, reason: collision with root package name */
    public final boolean f20475a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.u f20476b;

    /* renamed from: c, reason: collision with root package name */
    public final ParsableByteArray f20477c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f20478d;

    /* renamed from: e, reason: collision with root package name */
    public String f20479e;

    /* renamed from: f, reason: collision with root package name */
    public TrackOutput f20480f;

    /* renamed from: g, reason: collision with root package name */
    public TrackOutput f20481g;

    /* renamed from: h, reason: collision with root package name */
    public int f20482h;

    /* renamed from: i, reason: collision with root package name */
    public int f20483i;

    /* renamed from: j, reason: collision with root package name */
    public int f20484j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f20485k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f20486l;

    /* renamed from: m, reason: collision with root package name */
    public int f20487m;

    /* renamed from: n, reason: collision with root package name */
    public int f20488n;

    /* renamed from: o, reason: collision with root package name */
    public int f20489o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f20490p;

    /* renamed from: q, reason: collision with root package name */
    public long f20491q;

    /* renamed from: r, reason: collision with root package name */
    public int f20492r;

    /* renamed from: s, reason: collision with root package name */
    public long f20493s;

    /* renamed from: t, reason: collision with root package name */
    public TrackOutput f20494t;

    /* renamed from: u, reason: collision with root package name */
    public long f20495u;

    public i(boolean z10) {
        this(z10, null);
    }

    public static boolean m(int i10) {
        return (i10 & 65526) == 65520;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void a() {
        this.f20493s = -9223372036854775807L;
        q();
    }

    public final void b() {
        com.google.android.exoplayer2.util.a.e(this.f20480f);
        com.google.android.exoplayer2.util.j0.j(this.f20494t);
        com.google.android.exoplayer2.util.j0.j(this.f20481g);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void c(ParsableByteArray parsableByteArray) throws ParserException {
        b();
        while (parsableByteArray.a() > 0) {
            int i10 = this.f20482h;
            if (i10 == 0) {
                j(parsableByteArray);
            } else if (i10 == 1) {
                g(parsableByteArray);
            } else if (i10 != 2) {
                if (i10 == 3) {
                    if (i(parsableByteArray, this.f20476b.f23029a, this.f20485k ? 7 : 5)) {
                        n();
                    }
                } else if (i10 == 4) {
                    p(parsableByteArray);
                } else {
                    throw new IllegalStateException();
                }
            } else if (i(parsableByteArray, this.f20477c.d(), 10)) {
                o();
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void d() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void e(d5.e eVar, h0.d dVar) {
        dVar.a();
        this.f20479e = dVar.b();
        TrackOutput c4 = eVar.c(dVar.c(), 1);
        this.f20480f = c4;
        this.f20494t = c4;
        if (this.f20475a) {
            dVar.a();
            TrackOutput c10 = eVar.c(dVar.c(), 5);
            this.f20481g = c10;
            c10.b(new Format.b().S(dVar.b()).e0("application/id3").E());
            return;
        }
        this.f20481g = new com.google.android.exoplayer2.extractor.d();
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void f(long j10, int i10) {
        if (j10 != -9223372036854775807L) {
            this.f20493s = j10;
        }
    }

    public final void g(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.a() == 0) {
            return;
        }
        this.f20476b.f23029a[0] = parsableByteArray.d()[parsableByteArray.e()];
        this.f20476b.p(2);
        int h10 = this.f20476b.h(4);
        int i10 = this.f20488n;
        if (i10 != -1 && h10 != i10) {
            q();
            return;
        }
        if (!this.f20486l) {
            this.f20486l = true;
            this.f20487m = this.f20489o;
            this.f20488n = h10;
        }
        t();
    }

    public final boolean h(ParsableByteArray parsableByteArray, int i10) {
        parsableByteArray.P(i10 + 1);
        if (!w(parsableByteArray, this.f20476b.f23029a, 1)) {
            return false;
        }
        this.f20476b.p(4);
        int h10 = this.f20476b.h(1);
        int i11 = this.f20487m;
        if (i11 != -1 && h10 != i11) {
            return false;
        }
        if (this.f20488n != -1) {
            if (!w(parsableByteArray, this.f20476b.f23029a, 1)) {
                return true;
            }
            this.f20476b.p(2);
            if (this.f20476b.h(4) != this.f20488n) {
                return false;
            }
            parsableByteArray.P(i10 + 2);
        }
        if (!w(parsableByteArray, this.f20476b.f23029a, 4)) {
            return true;
        }
        this.f20476b.p(14);
        int h11 = this.f20476b.h(13);
        if (h11 < 7) {
            return false;
        }
        byte[] d10 = parsableByteArray.d();
        int f10 = parsableByteArray.f();
        int i12 = i10 + h11;
        if (i12 >= f10) {
            return true;
        }
        if (d10[i12] == -1) {
            int i13 = i12 + 1;
            if (i13 == f10) {
                return true;
            }
            return l((byte) -1, d10[i13]) && ((d10[i13] & 8) >> 3) == h10;
        }
        if (d10[i12] != 73) {
            return false;
        }
        int i14 = i12 + 1;
        if (i14 == f10) {
            return true;
        }
        if (d10[i14] != 68) {
            return false;
        }
        int i15 = i12 + 2;
        return i15 == f10 || d10[i15] == 51;
    }

    public final boolean i(ParsableByteArray parsableByteArray, byte[] bArr, int i10) {
        int min = Math.min(parsableByteArray.a(), i10 - this.f20483i);
        parsableByteArray.j(bArr, this.f20483i, min);
        int i11 = this.f20483i + min;
        this.f20483i = i11;
        return i11 == i10;
    }

    public final void j(ParsableByteArray parsableByteArray) {
        byte[] d10 = parsableByteArray.d();
        int e2 = parsableByteArray.e();
        int f10 = parsableByteArray.f();
        while (e2 < f10) {
            int i10 = e2 + 1;
            int i11 = d10[e2] & 255;
            if (this.f20484j == 512 && l((byte) -1, (byte) i11) && (this.f20486l || h(parsableByteArray, i10 - 2))) {
                this.f20489o = (i11 & 8) >> 3;
                this.f20485k = (i11 & 1) == 0;
                if (!this.f20486l) {
                    r();
                } else {
                    t();
                }
                parsableByteArray.P(i10);
                return;
            }
            int i12 = this.f20484j;
            int i13 = i11 | i12;
            if (i13 == 329) {
                this.f20484j = 768;
            } else if (i13 == 511) {
                this.f20484j = 512;
            } else if (i13 == 836) {
                this.f20484j = 1024;
            } else if (i13 == 1075) {
                u();
                parsableByteArray.P(i10);
                return;
            } else if (i12 != 256) {
                this.f20484j = 256;
                i10--;
            }
            e2 = i10;
        }
        parsableByteArray.P(e2);
    }

    public long k() {
        return this.f20491q;
    }

    public final boolean l(byte b4, byte b10) {
        return m(((b4 & 255) << 8) | (b10 & 255));
    }

    public final void n() throws ParserException {
        this.f20476b.p(0);
        if (!this.f20490p) {
            int h10 = this.f20476b.h(2) + 1;
            if (h10 != 2) {
                StringBuilder sb2 = new StringBuilder(61);
                sb2.append("Detected audio object type: ");
                sb2.append(h10);
                sb2.append(", but assuming AAC LC.");
                com.google.android.exoplayer2.util.m.h("AdtsReader", sb2.toString());
                h10 = 2;
            }
            this.f20476b.r(5);
            byte[] b4 = x4.a.b(h10, this.f20488n, this.f20476b.h(3));
            a.b g3 = x4.a.g(b4);
            Format E = new Format.b().S(this.f20479e).e0("audio/mp4a-latm").I(g3.f54365c).H(g3.f54364b).f0(g3.f54363a).T(Collections.singletonList(b4)).V(this.f20478d).E();
            this.f20491q = 1024000000 / E.A;
            this.f20480f.b(E);
            this.f20490p = true;
        } else {
            this.f20476b.r(10);
        }
        this.f20476b.r(4);
        int h11 = (this.f20476b.h(13) - 2) - 5;
        if (this.f20485k) {
            h11 -= 2;
        }
        v(this.f20480f, this.f20491q, 0, h11);
    }

    public final void o() {
        this.f20481g.a(this.f20477c, 10);
        this.f20477c.P(6);
        v(this.f20481g, 0L, 10, this.f20477c.C() + 10);
    }

    public final void p(ParsableByteArray parsableByteArray) {
        int min = Math.min(parsableByteArray.a(), this.f20492r - this.f20483i);
        this.f20494t.a(parsableByteArray, min);
        int i10 = this.f20483i + min;
        this.f20483i = i10;
        int i11 = this.f20492r;
        if (i10 == i11) {
            long j10 = this.f20493s;
            if (j10 != -9223372036854775807L) {
                this.f20494t.d(j10, 1, i11, 0, null);
                this.f20493s += this.f20495u;
            }
            s();
        }
    }

    public final void q() {
        this.f20486l = false;
        s();
    }

    public final void r() {
        this.f20482h = 1;
        this.f20483i = 0;
    }

    public final void s() {
        this.f20482h = 0;
        this.f20483i = 0;
        this.f20484j = 256;
    }

    public final void t() {
        this.f20482h = 3;
        this.f20483i = 0;
    }

    public final void u() {
        this.f20482h = 2;
        this.f20483i = f20474v.length;
        this.f20492r = 0;
        this.f20477c.P(0);
    }

    public final void v(TrackOutput trackOutput, long j10, int i10, int i11) {
        this.f20482h = 4;
        this.f20483i = i10;
        this.f20494t = trackOutput;
        this.f20495u = j10;
        this.f20492r = i11;
    }

    public final boolean w(ParsableByteArray parsableByteArray, byte[] bArr, int i10) {
        if (parsableByteArray.a() < i10) {
            return false;
        }
        parsableByteArray.j(bArr, 0, i10);
        return true;
    }

    public i(boolean z10, @Nullable String str) {
        this.f20476b = new com.google.android.exoplayer2.util.u(new byte[7]);
        this.f20477c = new ParsableByteArray(Arrays.copyOf(f20474v, 10));
        s();
        this.f20487m = -1;
        this.f20488n = -1;
        this.f20491q = -9223372036854775807L;
        this.f20493s = -9223372036854775807L;
        this.f20475a = z10;
        this.f20478d = str;
    }
}
