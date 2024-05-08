package com.google.android.exoplayer2.extractor.ts;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.h0;
import com.google.android.exoplayer2.util.ParsableByteArray;
import x4.c;

/* compiled from: Ac4Reader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f implements m {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.u f20407a;

    /* renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f20408b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f20409c;

    /* renamed from: d, reason: collision with root package name */
    public String f20410d;

    /* renamed from: e, reason: collision with root package name */
    public TrackOutput f20411e;

    /* renamed from: f, reason: collision with root package name */
    public int f20412f;

    /* renamed from: g, reason: collision with root package name */
    public int f20413g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f20414h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f20415i;

    /* renamed from: j, reason: collision with root package name */
    public long f20416j;

    /* renamed from: k, reason: collision with root package name */
    public Format f20417k;

    /* renamed from: l, reason: collision with root package name */
    public int f20418l;

    /* renamed from: m, reason: collision with root package name */
    public long f20419m;

    public f() {
        this(null);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void a() {
        this.f20412f = 0;
        this.f20413g = 0;
        this.f20414h = false;
        this.f20415i = false;
        this.f20419m = -9223372036854775807L;
    }

    public final boolean b(ParsableByteArray parsableByteArray, byte[] bArr, int i10) {
        int min = Math.min(parsableByteArray.a(), i10 - this.f20413g);
        parsableByteArray.j(bArr, this.f20413g, min);
        int i11 = this.f20413g + min;
        this.f20413g = i11;
        return i11 == i10;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void c(ParsableByteArray parsableByteArray) {
        com.google.android.exoplayer2.util.a.i(this.f20411e);
        while (parsableByteArray.a() > 0) {
            int i10 = this.f20412f;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        int min = Math.min(parsableByteArray.a(), this.f20418l - this.f20413g);
                        this.f20411e.a(parsableByteArray, min);
                        int i11 = this.f20413g + min;
                        this.f20413g = i11;
                        int i12 = this.f20418l;
                        if (i11 == i12) {
                            long j10 = this.f20419m;
                            if (j10 != -9223372036854775807L) {
                                this.f20411e.d(j10, 1, i12, 0, null);
                                this.f20419m += this.f20416j;
                            }
                            this.f20412f = 0;
                        }
                    }
                } else if (b(parsableByteArray, this.f20408b.d(), 16)) {
                    g();
                    this.f20408b.P(0);
                    this.f20411e.a(this.f20408b, 16);
                    this.f20412f = 2;
                }
            } else if (h(parsableByteArray)) {
                this.f20412f = 1;
                this.f20408b.d()[0] = -84;
                this.f20408b.d()[1] = (byte) (this.f20415i ? 65 : 64);
                this.f20413g = 2;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void d() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void e(d5.e eVar, h0.d dVar) {
        dVar.a();
        this.f20410d = dVar.b();
        this.f20411e = eVar.c(dVar.c(), 1);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void f(long j10, int i10) {
        if (j10 != -9223372036854775807L) {
            this.f20419m = j10;
        }
    }

    public final void g() {
        this.f20407a.p(0);
        c.b d10 = x4.c.d(this.f20407a);
        Format format = this.f20417k;
        if (format == null || d10.f54381c != format.f19557z || d10.f54380b != format.A || !"audio/ac4".equals(format.f19544m)) {
            Format E = new Format.b().S(this.f20410d).e0("audio/ac4").H(d10.f54381c).f0(d10.f54380b).V(this.f20409c).E();
            this.f20417k = E;
            this.f20411e.b(E);
        }
        this.f20418l = d10.f54382d;
        this.f20416j = (d10.f54383e * 1000000) / this.f20417k.A;
    }

    public final boolean h(ParsableByteArray parsableByteArray) {
        int D;
        while (true) {
            if (parsableByteArray.a() <= 0) {
                return false;
            }
            if (!this.f20414h) {
                this.f20414h = parsableByteArray.D() == 172;
            } else {
                D = parsableByteArray.D();
                this.f20414h = D == 172;
                if (D == 64 || D == 65) {
                    break;
                }
            }
        }
        this.f20415i = D == 65;
        return true;
    }

    public f(@Nullable String str) {
        com.google.android.exoplayer2.util.u uVar = new com.google.android.exoplayer2.util.u(new byte[16]);
        this.f20407a = uVar;
        this.f20408b = new ParsableByteArray(uVar.f23029a);
        this.f20412f = 0;
        this.f20413g = 0;
        this.f20414h = false;
        this.f20415i = false;
        this.f20419m = -9223372036854775807L;
        this.f20409c = str;
    }
}
