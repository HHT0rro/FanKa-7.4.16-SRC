package com.google.android.exoplayer2.extractor.ts;

import android.net.Uri;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.android.internal.logging.nano.MetricsProto;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.ts.h0;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: TsExtractor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g0 implements Extractor {

    /* renamed from: t, reason: collision with root package name */
    public static final d5.i f20422t = new d5.i() { // from class: com.google.android.exoplayer2.extractor.ts.f0
        @Override // d5.i
        public /* synthetic */ Extractor[] a(Uri uri, Map map) {
            return d5.h.a(this, uri, map);
        }

        @Override // d5.i
        public final Extractor[] b() {
            Extractor[] w3;
            w3 = g0.w();
            return w3;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final int f20423a;

    /* renamed from: b, reason: collision with root package name */
    public final int f20424b;

    /* renamed from: c, reason: collision with root package name */
    public final List<com.google.android.exoplayer2.util.f0> f20425c;

    /* renamed from: d, reason: collision with root package name */
    public final ParsableByteArray f20426d;

    /* renamed from: e, reason: collision with root package name */
    public final SparseIntArray f20427e;

    /* renamed from: f, reason: collision with root package name */
    public final h0.c f20428f;

    /* renamed from: g, reason: collision with root package name */
    public final SparseArray<h0> f20429g;

    /* renamed from: h, reason: collision with root package name */
    public final SparseBooleanArray f20430h;

    /* renamed from: i, reason: collision with root package name */
    public final SparseBooleanArray f20431i;

    /* renamed from: j, reason: collision with root package name */
    public final e0 f20432j;

    /* renamed from: k, reason: collision with root package name */
    public d0 f20433k;

    /* renamed from: l, reason: collision with root package name */
    public d5.e f20434l;

    /* renamed from: m, reason: collision with root package name */
    public int f20435m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f20436n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f20437o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f20438p;

    /* renamed from: q, reason: collision with root package name */
    public h0 f20439q;

    /* renamed from: r, reason: collision with root package name */
    public int f20440r;

    /* renamed from: s, reason: collision with root package name */
    public int f20441s;

    /* compiled from: TsExtractor.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements a0 {

        /* renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.util.u f20442a = new com.google.android.exoplayer2.util.u(new byte[4]);

        public a() {
        }

        @Override // com.google.android.exoplayer2.extractor.ts.a0
        public void b(com.google.android.exoplayer2.util.f0 f0Var, d5.e eVar, h0.d dVar) {
        }

        @Override // com.google.android.exoplayer2.extractor.ts.a0
        public void c(ParsableByteArray parsableByteArray) {
            if (parsableByteArray.D() == 0 && (parsableByteArray.D() & 128) != 0) {
                parsableByteArray.Q(6);
                int a10 = parsableByteArray.a() / 4;
                for (int i10 = 0; i10 < a10; i10++) {
                    parsableByteArray.i(this.f20442a, 4);
                    int h10 = this.f20442a.h(16);
                    this.f20442a.r(3);
                    if (h10 == 0) {
                        this.f20442a.r(13);
                    } else {
                        int h11 = this.f20442a.h(13);
                        if (g0.this.f20429g.get(h11) == null) {
                            g0.this.f20429g.put(h11, new b0(new b(h11)));
                            g0.k(g0.this);
                        }
                    }
                }
                if (g0.this.f20423a != 2) {
                    g0.this.f20429g.remove(0);
                }
            }
        }
    }

    /* compiled from: TsExtractor.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class b implements a0 {

        /* renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.util.u f20444a = new com.google.android.exoplayer2.util.u(new byte[5]);

        /* renamed from: b, reason: collision with root package name */
        public final SparseArray<h0> f20445b = new SparseArray<>();

        /* renamed from: c, reason: collision with root package name */
        public final SparseIntArray f20446c = new SparseIntArray();

        /* renamed from: d, reason: collision with root package name */
        public final int f20447d;

        public b(int i10) {
            this.f20447d = i10;
        }

        public final h0.b a(ParsableByteArray parsableByteArray, int i10) {
            int e2 = parsableByteArray.e();
            int i11 = i10 + e2;
            String str = null;
            ArrayList arrayList = null;
            int i12 = -1;
            while (parsableByteArray.e() < i11) {
                int D = parsableByteArray.D();
                int e10 = parsableByteArray.e() + parsableByteArray.D();
                if (e10 > i11) {
                    break;
                }
                if (D == 5) {
                    long F = parsableByteArray.F();
                    if (F != 1094921523) {
                        if (F != 1161904947) {
                            if (F != 1094921524) {
                                if (F == 1212503619) {
                                    i12 = 36;
                                }
                            }
                            i12 = 172;
                        }
                        i12 = 135;
                    }
                    i12 = 129;
                } else {
                    if (D != 106) {
                        if (D != 122) {
                            if (D == 127) {
                                if (parsableByteArray.D() != 21) {
                                }
                                i12 = 172;
                            } else if (D == 123) {
                                i12 = 138;
                            } else if (D == 10) {
                                str = parsableByteArray.A(3).trim();
                            } else if (D == 89) {
                                arrayList = new ArrayList();
                                while (parsableByteArray.e() < e10) {
                                    String trim = parsableByteArray.A(3).trim();
                                    int D2 = parsableByteArray.D();
                                    byte[] bArr = new byte[4];
                                    parsableByteArray.j(bArr, 0, 4);
                                    arrayList.add(new h0.a(trim, D2, bArr));
                                }
                                i12 = 89;
                            } else if (D == 111) {
                                i12 = 257;
                            }
                        }
                        i12 = 135;
                    }
                    i12 = 129;
                }
                parsableByteArray.Q(e10 - parsableByteArray.e());
            }
            parsableByteArray.P(i11);
            return new h0.b(i12, str, arrayList, Arrays.copyOfRange(parsableByteArray.d(), e2, i11));
        }

        @Override // com.google.android.exoplayer2.extractor.ts.a0
        public void b(com.google.android.exoplayer2.util.f0 f0Var, d5.e eVar, h0.d dVar) {
        }

        @Override // com.google.android.exoplayer2.extractor.ts.a0
        public void c(ParsableByteArray parsableByteArray) {
            com.google.android.exoplayer2.util.f0 f0Var;
            h0 a10;
            if (parsableByteArray.D() != 2) {
                return;
            }
            if (g0.this.f20423a != 1 && g0.this.f20423a != 2 && g0.this.f20435m != 1) {
                f0Var = new com.google.android.exoplayer2.util.f0(((com.google.android.exoplayer2.util.f0) g0.this.f20425c.get(0)).c());
                g0.this.f20425c.add(f0Var);
            } else {
                f0Var = (com.google.android.exoplayer2.util.f0) g0.this.f20425c.get(0);
            }
            if ((parsableByteArray.D() & 128) == 0) {
                return;
            }
            parsableByteArray.Q(1);
            int J = parsableByteArray.J();
            int i10 = 3;
            parsableByteArray.Q(3);
            parsableByteArray.i(this.f20444a, 2);
            this.f20444a.r(3);
            int i11 = 13;
            g0.this.f20441s = this.f20444a.h(13);
            parsableByteArray.i(this.f20444a, 2);
            int i12 = 4;
            this.f20444a.r(4);
            parsableByteArray.Q(this.f20444a.h(12));
            if (g0.this.f20423a == 2 && g0.this.f20439q == null) {
                h0.b bVar = new h0.b(21, null, null, com.google.android.exoplayer2.util.j0.f22995f);
                g0 g0Var = g0.this;
                g0Var.f20439q = g0Var.f20428f.a(21, bVar);
                g0.this.f20439q.b(f0Var, g0.this.f20434l, new h0.d(J, 21, 8192));
            }
            this.f20445b.clear();
            this.f20446c.clear();
            int a11 = parsableByteArray.a();
            while (a11 > 0) {
                parsableByteArray.i(this.f20444a, 5);
                int h10 = this.f20444a.h(8);
                this.f20444a.r(i10);
                int h11 = this.f20444a.h(i11);
                this.f20444a.r(i12);
                int h12 = this.f20444a.h(12);
                h0.b a12 = a(parsableByteArray, h12);
                if (h10 == 6 || h10 == 5) {
                    h10 = a12.f20465a;
                }
                a11 -= h12 + 5;
                int i13 = g0.this.f20423a == 2 ? h10 : h11;
                if (!g0.this.f20430h.get(i13)) {
                    if (g0.this.f20423a == 2 && h10 == 21) {
                        a10 = g0.this.f20439q;
                    } else {
                        a10 = g0.this.f20428f.a(h10, a12);
                    }
                    if (g0.this.f20423a != 2 || h11 < this.f20446c.get(i13, 8192)) {
                        this.f20446c.put(i13, h11);
                        this.f20445b.put(i13, a10);
                    }
                }
                i10 = 3;
                i12 = 4;
                i11 = 13;
            }
            int size = this.f20446c.size();
            for (int i14 = 0; i14 < size; i14++) {
                int keyAt = this.f20446c.keyAt(i14);
                int valueAt = this.f20446c.valueAt(i14);
                g0.this.f20430h.put(keyAt, true);
                g0.this.f20431i.put(valueAt, true);
                h0 valueAt2 = this.f20445b.valueAt(i14);
                if (valueAt2 != null) {
                    if (valueAt2 != g0.this.f20439q) {
                        valueAt2.b(f0Var, g0.this.f20434l, new h0.d(J, keyAt, 8192));
                    }
                    g0.this.f20429g.put(valueAt, valueAt2);
                }
            }
            if (g0.this.f20423a == 2) {
                if (g0.this.f20436n) {
                    return;
                }
                g0.this.f20434l.l();
                g0.this.f20435m = 0;
                g0.this.f20436n = true;
                return;
            }
            g0.this.f20429g.remove(this.f20447d);
            g0 g0Var2 = g0.this;
            g0Var2.f20435m = g0Var2.f20423a == 1 ? 0 : g0.this.f20435m - 1;
            if (g0.this.f20435m == 0) {
                g0.this.f20434l.l();
                g0.this.f20436n = true;
            }
        }
    }

    public g0() {
        this(0);
    }

    public static /* synthetic */ int k(g0 g0Var) {
        int i10 = g0Var.f20435m;
        g0Var.f20435m = i10 + 1;
        return i10;
    }

    public static /* synthetic */ Extractor[] w() {
        return new Extractor[]{new g0()};
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void a(long j10, long j11) {
        d0 d0Var;
        com.google.android.exoplayer2.util.a.g(this.f20423a != 2);
        int size = this.f20425c.size();
        for (int i10 = 0; i10 < size; i10++) {
            com.google.android.exoplayer2.util.f0 f0Var = this.f20425c.get(i10);
            boolean z10 = f0Var.e() == -9223372036854775807L;
            if (!z10) {
                long c4 = f0Var.c();
                z10 = (c4 == -9223372036854775807L || c4 == 0 || c4 == j11) ? false : true;
            }
            if (z10) {
                f0Var.g(j11);
            }
        }
        if (j11 != 0 && (d0Var = this.f20433k) != null) {
            d0Var.h(j11);
        }
        this.f20426d.L(0);
        this.f20427e.clear();
        for (int i11 = 0; i11 < this.f20429g.size(); i11++) {
            this.f20429g.valueAt(i11).a();
        }
        this.f20440r = 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(d5.e eVar) {
        this.f20434l = eVar;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int f(d5.d dVar, d5.n nVar) throws IOException {
        long b4 = dVar.b();
        if (this.f20436n) {
            if (((b4 == -1 || this.f20423a == 2) ? false : true) && !this.f20432j.d()) {
                return this.f20432j.e(dVar, nVar, this.f20441s);
            }
            x(b4);
            if (this.f20438p) {
                this.f20438p = false;
                a(0L, 0L);
                if (dVar.getPosition() != 0) {
                    nVar.f48642a = 0L;
                    return 1;
                }
            }
            d0 d0Var = this.f20433k;
            if (d0Var != null && d0Var.d()) {
                return this.f20433k.c(dVar, nVar);
            }
        }
        if (!u(dVar)) {
            return -1;
        }
        int v2 = v();
        int f10 = this.f20426d.f();
        if (v2 > f10) {
            return 0;
        }
        int n10 = this.f20426d.n();
        if ((8388608 & n10) != 0) {
            this.f20426d.P(v2);
            return 0;
        }
        int i10 = ((4194304 & n10) != 0 ? 1 : 0) | 0;
        int i11 = (2096896 & n10) >> 8;
        boolean z10 = (n10 & 32) != 0;
        h0 h0Var = (n10 & 16) != 0 ? this.f20429g.get(i11) : null;
        if (h0Var == null) {
            this.f20426d.P(v2);
            return 0;
        }
        if (this.f20423a != 2) {
            int i12 = n10 & 15;
            int i13 = this.f20427e.get(i11, i12 - 1);
            this.f20427e.put(i11, i12);
            if (i13 == i12) {
                this.f20426d.P(v2);
                return 0;
            }
            if (i12 != ((i13 + 1) & 15)) {
                h0Var.a();
            }
        }
        if (z10) {
            int D = this.f20426d.D();
            i10 |= (this.f20426d.D() & 64) != 0 ? 2 : 0;
            this.f20426d.Q(D - 1);
        }
        boolean z11 = this.f20436n;
        if (z(i11)) {
            this.f20426d.O(v2);
            h0Var.c(this.f20426d, i10);
            this.f20426d.O(f10);
        }
        if (this.f20423a != 2 && !z11 && this.f20436n && b4 != -1) {
            this.f20438p = true;
        }
        this.f20426d.P(v2);
        return 0;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean g(d5.d dVar) throws IOException {
        boolean z10;
        byte[] d10 = this.f20426d.d();
        dVar.j(d10, 0, MetricsProto.MetricsEvent.ENTERPRISE_PRIVACY_DEFAULT_APPS);
        for (int i10 = 0; i10 < 188; i10++) {
            int i11 = 0;
            while (true) {
                if (i11 >= 5) {
                    z10 = true;
                    break;
                }
                if (d10[(i11 * 188) + i10] != 71) {
                    z10 = false;
                    break;
                }
                i11++;
            }
            if (z10) {
                dVar.r(i10);
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    public final boolean u(d5.d dVar) throws IOException {
        byte[] d10 = this.f20426d.d();
        if (9400 - this.f20426d.e() < 188) {
            int a10 = this.f20426d.a();
            if (a10 > 0) {
                System.arraycopy((Object) d10, this.f20426d.e(), (Object) d10, 0, a10);
            }
            this.f20426d.N(d10, a10);
        }
        while (this.f20426d.a() < 188) {
            int f10 = this.f20426d.f();
            int read = dVar.read(d10, f10, 9400 - f10);
            if (read == -1) {
                return false;
            }
            this.f20426d.O(f10 + read);
        }
        return true;
    }

    public final int v() throws ParserException {
        int e2 = this.f20426d.e();
        int f10 = this.f20426d.f();
        int a10 = i0.a(this.f20426d.d(), e2, f10);
        this.f20426d.P(a10);
        int i10 = a10 + 188;
        if (i10 > f10) {
            int i11 = this.f20440r + (a10 - e2);
            this.f20440r = i11;
            if (this.f20423a == 2 && i11 > 376) {
                throw ParserException.createForMalformedContainer("Cannot find sync byte. Most likely not a Transport Stream.", null);
            }
        } else {
            this.f20440r = 0;
        }
        return i10;
    }

    public final void x(long j10) {
        if (this.f20437o) {
            return;
        }
        this.f20437o = true;
        if (this.f20432j.b() != -9223372036854775807L) {
            d0 d0Var = new d0(this.f20432j.c(), this.f20432j.b(), j10, this.f20441s, this.f20424b);
            this.f20433k = d0Var;
            this.f20434l.r(d0Var.b());
            return;
        }
        this.f20434l.r(new i.b(this.f20432j.b()));
    }

    public final void y() {
        this.f20430h.clear();
        this.f20429g.clear();
        SparseArray<h0> b4 = this.f20428f.b();
        int size = b4.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f20429g.put(b4.keyAt(i10), b4.valueAt(i10));
        }
        this.f20429g.put(0, new b0(new a()));
        this.f20439q = null;
    }

    public final boolean z(int i10) {
        return this.f20423a == 2 || this.f20436n || !this.f20431i.get(i10, false);
    }

    public g0(int i10) {
        this(1, i10, 112800);
    }

    public g0(int i10, int i11, int i12) {
        this(i10, new com.google.android.exoplayer2.util.f0(0L), new j(i11), i12);
    }

    public g0(int i10, com.google.android.exoplayer2.util.f0 f0Var, h0.c cVar) {
        this(i10, f0Var, cVar, 112800);
    }

    public g0(int i10, com.google.android.exoplayer2.util.f0 f0Var, h0.c cVar, int i11) {
        this.f20428f = (h0.c) com.google.android.exoplayer2.util.a.e(cVar);
        this.f20424b = i11;
        this.f20423a = i10;
        if (i10 != 1 && i10 != 2) {
            ArrayList arrayList = new ArrayList();
            this.f20425c = arrayList;
            arrayList.add(f0Var);
        } else {
            this.f20425c = Collections.singletonList(f0Var);
        }
        this.f20426d = new ParsableByteArray(new byte[9400], 0);
        this.f20430h = new SparseBooleanArray();
        this.f20431i = new SparseBooleanArray();
        this.f20429g = new SparseArray<>();
        this.f20427e = new SparseIntArray();
        this.f20432j = new e0(i11);
        this.f20441s = -1;
        y();
    }
}
