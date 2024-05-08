package com.google.android.exoplayer2.extractor.ts;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ts.h0;
import com.google.android.exoplayer2.util.ParsableByteArray;

/* compiled from: PesReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class v implements h0 {

    /* renamed from: a, reason: collision with root package name */
    public final m f20639a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.u f20640b = new com.google.android.exoplayer2.util.u(new byte[10]);

    /* renamed from: c, reason: collision with root package name */
    public int f20641c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f20642d;

    /* renamed from: e, reason: collision with root package name */
    public com.google.android.exoplayer2.util.f0 f20643e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f20644f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f20645g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f20646h;

    /* renamed from: i, reason: collision with root package name */
    public int f20647i;

    /* renamed from: j, reason: collision with root package name */
    public int f20648j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f20649k;

    /* renamed from: l, reason: collision with root package name */
    public long f20650l;

    public v(m mVar) {
        this.f20639a = mVar;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.h0
    public final void a() {
        this.f20641c = 0;
        this.f20642d = 0;
        this.f20646h = false;
        this.f20639a.a();
    }

    @Override // com.google.android.exoplayer2.extractor.ts.h0
    public void b(com.google.android.exoplayer2.util.f0 f0Var, d5.e eVar, h0.d dVar) {
        this.f20643e = f0Var;
        this.f20639a.e(eVar, dVar);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.h0
    public final void c(ParsableByteArray parsableByteArray, int i10) throws ParserException {
        com.google.android.exoplayer2.util.a.i(this.f20643e);
        if ((i10 & 1) != 0) {
            int i11 = this.f20641c;
            if (i11 != 0 && i11 != 1) {
                if (i11 == 2) {
                    com.google.android.exoplayer2.util.m.h("PesReader", "Unexpected start indicator reading extended header");
                } else if (i11 == 3) {
                    int i12 = this.f20648j;
                    if (i12 != -1) {
                        StringBuilder sb2 = new StringBuilder(59);
                        sb2.append("Unexpected start indicator: expected ");
                        sb2.append(i12);
                        sb2.append(" more bytes");
                        com.google.android.exoplayer2.util.m.h("PesReader", sb2.toString());
                    }
                    this.f20639a.d();
                } else {
                    throw new IllegalStateException();
                }
            }
            g(1);
        }
        while (parsableByteArray.a() > 0) {
            int i13 = this.f20641c;
            if (i13 != 0) {
                if (i13 != 1) {
                    if (i13 == 2) {
                        if (d(parsableByteArray, this.f20640b.f23029a, Math.min(10, this.f20647i)) && d(parsableByteArray, null, this.f20647i)) {
                            f();
                            i10 |= this.f20649k ? 4 : 0;
                            this.f20639a.f(this.f20650l, i10);
                            g(3);
                        }
                    } else if (i13 == 3) {
                        int a10 = parsableByteArray.a();
                        int i14 = this.f20648j;
                        int i15 = i14 != -1 ? a10 - i14 : 0;
                        if (i15 > 0) {
                            a10 -= i15;
                            parsableByteArray.O(parsableByteArray.e() + a10);
                        }
                        this.f20639a.c(parsableByteArray);
                        int i16 = this.f20648j;
                        if (i16 != -1) {
                            int i17 = i16 - a10;
                            this.f20648j = i17;
                            if (i17 == 0) {
                                this.f20639a.d();
                                g(1);
                            }
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else if (d(parsableByteArray, this.f20640b.f23029a, 9)) {
                    g(e() ? 2 : 0);
                }
            } else {
                parsableByteArray.Q(parsableByteArray.a());
            }
        }
    }

    public final boolean d(ParsableByteArray parsableByteArray, @Nullable byte[] bArr, int i10) {
        int min = Math.min(parsableByteArray.a(), i10 - this.f20642d);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            parsableByteArray.Q(min);
        } else {
            parsableByteArray.j(bArr, this.f20642d, min);
        }
        int i11 = this.f20642d + min;
        this.f20642d = i11;
        return i11 == i10;
    }

    public final boolean e() {
        this.f20640b.p(0);
        int h10 = this.f20640b.h(24);
        if (h10 != 1) {
            StringBuilder sb2 = new StringBuilder(41);
            sb2.append("Unexpected start code prefix: ");
            sb2.append(h10);
            com.google.android.exoplayer2.util.m.h("PesReader", sb2.toString());
            this.f20648j = -1;
            return false;
        }
        this.f20640b.r(8);
        int h11 = this.f20640b.h(16);
        this.f20640b.r(5);
        this.f20649k = this.f20640b.g();
        this.f20640b.r(2);
        this.f20644f = this.f20640b.g();
        this.f20645g = this.f20640b.g();
        this.f20640b.r(6);
        int h12 = this.f20640b.h(8);
        this.f20647i = h12;
        if (h11 == 0) {
            this.f20648j = -1;
        } else {
            int i10 = ((h11 + 6) - 9) - h12;
            this.f20648j = i10;
            if (i10 < 0) {
                StringBuilder sb3 = new StringBuilder(47);
                sb3.append("Found negative packet payload size: ");
                sb3.append(i10);
                com.google.android.exoplayer2.util.m.h("PesReader", sb3.toString());
                this.f20648j = -1;
            }
        }
        return true;
    }

    public final void f() {
        this.f20640b.p(0);
        this.f20650l = -9223372036854775807L;
        if (this.f20644f) {
            this.f20640b.r(4);
            this.f20640b.r(1);
            this.f20640b.r(1);
            long h10 = (this.f20640b.h(3) << 30) | (this.f20640b.h(15) << 15) | this.f20640b.h(15);
            this.f20640b.r(1);
            if (!this.f20646h && this.f20645g) {
                this.f20640b.r(4);
                this.f20640b.r(1);
                this.f20640b.r(1);
                this.f20640b.r(1);
                this.f20643e.b((this.f20640b.h(3) << 30) | (this.f20640b.h(15) << 15) | this.f20640b.h(15));
                this.f20646h = true;
            }
            this.f20650l = this.f20643e.b(h10);
        }
    }

    public final void g(int i10) {
        this.f20641c = i10;
        this.f20642d = 0;
    }
}
