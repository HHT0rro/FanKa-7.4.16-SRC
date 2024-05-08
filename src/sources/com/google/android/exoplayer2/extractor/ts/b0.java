package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ts.h0;
import com.google.android.exoplayer2.util.ParsableByteArray;

/* compiled from: SectionReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b0 implements h0 {

    /* renamed from: a, reason: collision with root package name */
    public final a0 f20369a;

    /* renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f20370b = new ParsableByteArray(32);

    /* renamed from: c, reason: collision with root package name */
    public int f20371c;

    /* renamed from: d, reason: collision with root package name */
    public int f20372d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f20373e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f20374f;

    public b0(a0 a0Var) {
        this.f20369a = a0Var;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.h0
    public void a() {
        this.f20374f = true;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.h0
    public void b(com.google.android.exoplayer2.util.f0 f0Var, d5.e eVar, h0.d dVar) {
        this.f20369a.b(f0Var, eVar, dVar);
        this.f20374f = true;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.h0
    public void c(ParsableByteArray parsableByteArray, int i10) {
        boolean z10 = (i10 & 1) != 0;
        int e2 = z10 ? parsableByteArray.e() + parsableByteArray.D() : -1;
        if (this.f20374f) {
            if (!z10) {
                return;
            }
            this.f20374f = false;
            parsableByteArray.P(e2);
            this.f20372d = 0;
        }
        while (parsableByteArray.a() > 0) {
            int i11 = this.f20372d;
            if (i11 < 3) {
                if (i11 == 0) {
                    int D = parsableByteArray.D();
                    parsableByteArray.P(parsableByteArray.e() - 1);
                    if (D == 255) {
                        this.f20374f = true;
                        return;
                    }
                }
                int min = Math.min(parsableByteArray.a(), 3 - this.f20372d);
                parsableByteArray.j(this.f20370b.d(), this.f20372d, min);
                int i12 = this.f20372d + min;
                this.f20372d = i12;
                if (i12 == 3) {
                    this.f20370b.P(0);
                    this.f20370b.O(3);
                    this.f20370b.Q(1);
                    int D2 = this.f20370b.D();
                    int D3 = this.f20370b.D();
                    this.f20373e = (D2 & 128) != 0;
                    this.f20371c = (((D2 & 15) << 8) | D3) + 3;
                    int b4 = this.f20370b.b();
                    int i13 = this.f20371c;
                    if (b4 < i13) {
                        this.f20370b.c(Math.min(4098, Math.max(i13, this.f20370b.b() * 2)));
                    }
                }
            } else {
                int min2 = Math.min(parsableByteArray.a(), this.f20371c - this.f20372d);
                parsableByteArray.j(this.f20370b.d(), this.f20372d, min2);
                int i14 = this.f20372d + min2;
                this.f20372d = i14;
                int i15 = this.f20371c;
                if (i14 != i15) {
                    continue;
                } else {
                    if (this.f20373e) {
                        if (com.google.android.exoplayer2.util.j0.u(this.f20370b.d(), 0, this.f20371c, -1) != 0) {
                            this.f20374f = true;
                            return;
                        }
                        this.f20370b.O(this.f20371c - 4);
                    } else {
                        this.f20370b.O(i15);
                    }
                    this.f20370b.P(0);
                    this.f20369a.c(this.f20370b);
                    this.f20372d = 0;
                }
            }
        }
    }
}
