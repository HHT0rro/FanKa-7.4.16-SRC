package com.google.android.exoplayer2.extractor.ts;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.h0;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;

/* compiled from: H265Reader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class p implements m {

    /* renamed from: a, reason: collision with root package name */
    public final c0 f20565a;

    /* renamed from: b, reason: collision with root package name */
    public String f20566b;

    /* renamed from: c, reason: collision with root package name */
    public TrackOutput f20567c;

    /* renamed from: d, reason: collision with root package name */
    public a f20568d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f20569e;

    /* renamed from: l, reason: collision with root package name */
    public long f20576l;

    /* renamed from: f, reason: collision with root package name */
    public final boolean[] f20570f = new boolean[3];

    /* renamed from: g, reason: collision with root package name */
    public final t f20571g = new t(32, 128);

    /* renamed from: h, reason: collision with root package name */
    public final t f20572h = new t(33, 128);

    /* renamed from: i, reason: collision with root package name */
    public final t f20573i = new t(34, 128);

    /* renamed from: j, reason: collision with root package name */
    public final t f20574j = new t(39, 128);

    /* renamed from: k, reason: collision with root package name */
    public final t f20575k = new t(40, 128);

    /* renamed from: m, reason: collision with root package name */
    public long f20577m = -9223372036854775807L;

    /* renamed from: n, reason: collision with root package name */
    public final ParsableByteArray f20578n = new ParsableByteArray();

    /* compiled from: H265Reader.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final TrackOutput f20579a;

        /* renamed from: b, reason: collision with root package name */
        public long f20580b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f20581c;

        /* renamed from: d, reason: collision with root package name */
        public int f20582d;

        /* renamed from: e, reason: collision with root package name */
        public long f20583e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f20584f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f20585g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f20586h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f20587i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f20588j;

        /* renamed from: k, reason: collision with root package name */
        public long f20589k;

        /* renamed from: l, reason: collision with root package name */
        public long f20590l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f20591m;

        public a(TrackOutput trackOutput) {
            this.f20579a = trackOutput;
        }

        public static boolean b(int i10) {
            return (32 <= i10 && i10 <= 35) || i10 == 39;
        }

        public static boolean c(int i10) {
            return i10 < 32 || i10 == 40;
        }

        public void a(long j10, int i10, boolean z10) {
            if (this.f20588j && this.f20585g) {
                this.f20591m = this.f20581c;
                this.f20588j = false;
            } else if (this.f20586h || this.f20585g) {
                if (z10 && this.f20587i) {
                    d(i10 + ((int) (j10 - this.f20580b)));
                }
                this.f20589k = this.f20580b;
                this.f20590l = this.f20583e;
                this.f20591m = this.f20581c;
                this.f20587i = true;
            }
        }

        public final void d(int i10) {
            long j10 = this.f20590l;
            if (j10 == -9223372036854775807L) {
                return;
            }
            boolean z10 = this.f20591m;
            this.f20579a.d(j10, z10 ? 1 : 0, (int) (this.f20580b - this.f20589k), i10, null);
        }

        public void e(byte[] bArr, int i10, int i11) {
            if (this.f20584f) {
                int i12 = this.f20582d;
                int i13 = (i10 + 2) - i12;
                if (i13 < i11) {
                    this.f20585g = (bArr[i13] & 128) != 0;
                    this.f20584f = false;
                } else {
                    this.f20582d = i12 + (i11 - i10);
                }
            }
        }

        public void f() {
            this.f20584f = false;
            this.f20585g = false;
            this.f20586h = false;
            this.f20587i = false;
            this.f20588j = false;
        }

        public void g(long j10, int i10, int i11, long j11, boolean z10) {
            this.f20585g = false;
            this.f20586h = false;
            this.f20583e = j11;
            this.f20582d = 0;
            this.f20580b = j10;
            if (!c(i11)) {
                if (this.f20587i && !this.f20588j) {
                    if (z10) {
                        d(i10);
                    }
                    this.f20587i = false;
                }
                if (b(i11)) {
                    this.f20586h = !this.f20588j;
                    this.f20588j = true;
                }
            }
            boolean z11 = i11 >= 16 && i11 <= 21;
            this.f20581c = z11;
            this.f20584f = z11 || i11 <= 9;
        }
    }

    public p(c0 c0Var) {
        this.f20565a = c0Var;
    }

    public static Format i(@Nullable String str, t tVar, t tVar2, t tVar3) {
        int i10 = tVar.f20635e;
        byte[] bArr = new byte[tVar2.f20635e + i10 + tVar3.f20635e];
        System.arraycopy((Object) tVar.f20634d, 0, (Object) bArr, 0, i10);
        System.arraycopy((Object) tVar2.f20634d, 0, (Object) bArr, tVar.f20635e, tVar2.f20635e);
        System.arraycopy((Object) tVar3.f20634d, 0, (Object) bArr, tVar.f20635e + tVar2.f20635e, tVar3.f20635e);
        com.google.android.exoplayer2.util.v vVar = new com.google.android.exoplayer2.util.v(tVar2.f20634d, 0, tVar2.f20635e);
        vVar.l(44);
        int e2 = vVar.e(3);
        vVar.k();
        vVar.l(88);
        vVar.l(8);
        int i11 = 0;
        for (int i12 = 0; i12 < e2; i12++) {
            if (vVar.d()) {
                i11 += 89;
            }
            if (vVar.d()) {
                i11 += 8;
            }
        }
        vVar.l(i11);
        if (e2 > 0) {
            vVar.l((8 - e2) * 2);
        }
        vVar.h();
        int h10 = vVar.h();
        if (h10 == 3) {
            vVar.k();
        }
        int h11 = vVar.h();
        int h12 = vVar.h();
        if (vVar.d()) {
            int h13 = vVar.h();
            int h14 = vVar.h();
            int h15 = vVar.h();
            int h16 = vVar.h();
            h11 -= ((h10 == 1 || h10 == 2) ? 2 : 1) * (h13 + h14);
            h12 -= (h10 == 1 ? 2 : 1) * (h15 + h16);
        }
        vVar.h();
        vVar.h();
        int h17 = vVar.h();
        for (int i13 = vVar.d() ? 0 : e2; i13 <= e2; i13++) {
            vVar.h();
            vVar.h();
            vVar.h();
        }
        vVar.h();
        vVar.h();
        vVar.h();
        vVar.h();
        vVar.h();
        vVar.h();
        if (vVar.d() && vVar.d()) {
            j(vVar);
        }
        vVar.l(2);
        if (vVar.d()) {
            vVar.l(8);
            vVar.h();
            vVar.h();
            vVar.k();
        }
        k(vVar);
        if (vVar.d()) {
            for (int i14 = 0; i14 < vVar.h(); i14++) {
                vVar.l(h17 + 4 + 1);
            }
        }
        vVar.l(2);
        float f10 = 1.0f;
        if (vVar.d()) {
            if (vVar.d()) {
                int e10 = vVar.e(8);
                if (e10 == 255) {
                    int e11 = vVar.e(16);
                    int e12 = vVar.e(16);
                    if (e11 != 0 && e12 != 0) {
                        f10 = e11 / e12;
                    }
                } else {
                    float[] fArr = NalUnitUtil.f22926b;
                    if (e10 < fArr.length) {
                        f10 = fArr[e10];
                    } else {
                        StringBuilder sb2 = new StringBuilder(46);
                        sb2.append("Unexpected aspect_ratio_idc value: ");
                        sb2.append(e10);
                        com.google.android.exoplayer2.util.m.h("H265Reader", sb2.toString());
                    }
                }
            }
            if (vVar.d()) {
                vVar.k();
            }
            if (vVar.d()) {
                vVar.l(4);
                if (vVar.d()) {
                    vVar.l(24);
                }
            }
            if (vVar.d()) {
                vVar.h();
                vVar.h();
            }
            vVar.k();
            if (vVar.d()) {
                h12 *= 2;
            }
        }
        vVar.i(tVar2.f20634d, 0, tVar2.f20635e);
        vVar.l(24);
        return new Format.b().S(str).e0("video/hevc").I(com.google.android.exoplayer2.util.c.c(vVar)).j0(h11).Q(h12).a0(f10).T(Collections.singletonList(bArr)).E();
    }

    public static void j(com.google.android.exoplayer2.util.v vVar) {
        for (int i10 = 0; i10 < 4; i10++) {
            int i11 = 0;
            while (i11 < 6) {
                int i12 = 1;
                if (!vVar.d()) {
                    vVar.h();
                } else {
                    int min = Math.min(64, 1 << ((i10 << 1) + 4));
                    if (i10 > 1) {
                        vVar.g();
                    }
                    for (int i13 = 0; i13 < min; i13++) {
                        vVar.g();
                    }
                }
                if (i10 == 3) {
                    i12 = 3;
                }
                i11 += i12;
            }
        }
    }

    public static void k(com.google.android.exoplayer2.util.v vVar) {
        int h10 = vVar.h();
        boolean z10 = false;
        int i10 = 0;
        for (int i11 = 0; i11 < h10; i11++) {
            if (i11 != 0) {
                z10 = vVar.d();
            }
            if (z10) {
                vVar.k();
                vVar.h();
                for (int i12 = 0; i12 <= i10; i12++) {
                    if (vVar.d()) {
                        vVar.k();
                    }
                }
            } else {
                int h11 = vVar.h();
                int h12 = vVar.h();
                int i13 = h11 + h12;
                for (int i14 = 0; i14 < h11; i14++) {
                    vVar.h();
                    vVar.k();
                }
                for (int i15 = 0; i15 < h12; i15++) {
                    vVar.h();
                    vVar.k();
                }
                i10 = i13;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void a() {
        this.f20576l = 0L;
        this.f20577m = -9223372036854775807L;
        NalUnitUtil.a(this.f20570f);
        this.f20571g.d();
        this.f20572h.d();
        this.f20573i.d();
        this.f20574j.d();
        this.f20575k.d();
        a aVar = this.f20568d;
        if (aVar != null) {
            aVar.f();
        }
    }

    public final void b() {
        com.google.android.exoplayer2.util.a.i(this.f20567c);
        com.google.android.exoplayer2.util.j0.j(this.f20568d);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void c(ParsableByteArray parsableByteArray) {
        b();
        while (parsableByteArray.a() > 0) {
            int e2 = parsableByteArray.e();
            int f10 = parsableByteArray.f();
            byte[] d10 = parsableByteArray.d();
            this.f20576l += parsableByteArray.a();
            this.f20567c.a(parsableByteArray, parsableByteArray.a());
            while (e2 < f10) {
                int c4 = NalUnitUtil.c(d10, e2, f10, this.f20570f);
                if (c4 == f10) {
                    h(d10, e2, f10);
                    return;
                }
                int e10 = NalUnitUtil.e(d10, c4);
                int i10 = c4 - e2;
                if (i10 > 0) {
                    h(d10, e2, c4);
                }
                int i11 = f10 - c4;
                long j10 = this.f20576l - i11;
                g(j10, i11, i10 < 0 ? -i10 : 0, this.f20577m);
                l(j10, i11, e10, this.f20577m);
                e2 = c4 + 3;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void d() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void e(d5.e eVar, h0.d dVar) {
        dVar.a();
        this.f20566b = dVar.b();
        TrackOutput c4 = eVar.c(dVar.c(), 2);
        this.f20567c = c4;
        this.f20568d = new a(c4);
        this.f20565a.b(eVar, dVar);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void f(long j10, int i10) {
        if (j10 != -9223372036854775807L) {
            this.f20577m = j10;
        }
    }

    public final void g(long j10, int i10, int i11, long j11) {
        this.f20568d.a(j10, i10, this.f20569e);
        if (!this.f20569e) {
            this.f20571g.b(i11);
            this.f20572h.b(i11);
            this.f20573i.b(i11);
            if (this.f20571g.c() && this.f20572h.c() && this.f20573i.c()) {
                this.f20567c.b(i(this.f20566b, this.f20571g, this.f20572h, this.f20573i));
                this.f20569e = true;
            }
        }
        if (this.f20574j.b(i11)) {
            t tVar = this.f20574j;
            this.f20578n.N(this.f20574j.f20634d, NalUnitUtil.k(tVar.f20634d, tVar.f20635e));
            this.f20578n.Q(5);
            this.f20565a.a(j11, this.f20578n);
        }
        if (this.f20575k.b(i11)) {
            t tVar2 = this.f20575k;
            this.f20578n.N(this.f20575k.f20634d, NalUnitUtil.k(tVar2.f20634d, tVar2.f20635e));
            this.f20578n.Q(5);
            this.f20565a.a(j11, this.f20578n);
        }
    }

    public final void h(byte[] bArr, int i10, int i11) {
        this.f20568d.e(bArr, i10, i11);
        if (!this.f20569e) {
            this.f20571g.a(bArr, i10, i11);
            this.f20572h.a(bArr, i10, i11);
            this.f20573i.a(bArr, i10, i11);
        }
        this.f20574j.a(bArr, i10, i11);
        this.f20575k.a(bArr, i10, i11);
    }

    public final void l(long j10, int i10, int i11, long j11) {
        this.f20568d.g(j10, i10, i11, j11, this.f20569e);
        if (!this.f20569e) {
            this.f20571g.e(i11);
            this.f20572h.e(i11);
            this.f20573i.e(i11);
        }
        this.f20574j.e(i11);
        this.f20575k.e(i11);
    }
}
