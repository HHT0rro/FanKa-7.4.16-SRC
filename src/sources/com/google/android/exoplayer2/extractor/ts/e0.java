package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

/* compiled from: TsDurationReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f20398a;

    /* renamed from: d, reason: collision with root package name */
    public boolean f20401d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f20402e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f20403f;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.f0 f20399b = new com.google.android.exoplayer2.util.f0(0);

    /* renamed from: g, reason: collision with root package name */
    public long f20404g = -9223372036854775807L;

    /* renamed from: h, reason: collision with root package name */
    public long f20405h = -9223372036854775807L;

    /* renamed from: i, reason: collision with root package name */
    public long f20406i = -9223372036854775807L;

    /* renamed from: c, reason: collision with root package name */
    public final ParsableByteArray f20400c = new ParsableByteArray();

    public e0(int i10) {
        this.f20398a = i10;
    }

    public final int a(d5.d dVar) {
        this.f20400c.M(com.google.android.exoplayer2.util.j0.f22995f);
        this.f20401d = true;
        dVar.m();
        return 0;
    }

    public long b() {
        return this.f20406i;
    }

    public com.google.android.exoplayer2.util.f0 c() {
        return this.f20399b;
    }

    public boolean d() {
        return this.f20401d;
    }

    public int e(d5.d dVar, d5.n nVar, int i10) throws IOException {
        if (i10 <= 0) {
            return a(dVar);
        }
        if (!this.f20403f) {
            return h(dVar, nVar, i10);
        }
        if (this.f20405h == -9223372036854775807L) {
            return a(dVar);
        }
        if (!this.f20402e) {
            return f(dVar, nVar, i10);
        }
        long j10 = this.f20404g;
        if (j10 == -9223372036854775807L) {
            return a(dVar);
        }
        long b4 = this.f20399b.b(this.f20405h) - this.f20399b.b(j10);
        this.f20406i = b4;
        if (b4 < 0) {
            StringBuilder sb2 = new StringBuilder(65);
            sb2.append("Invalid duration: ");
            sb2.append(b4);
            sb2.append(". Using TIME_UNSET instead.");
            com.google.android.exoplayer2.util.m.h("TsDurationReader", sb2.toString());
            this.f20406i = -9223372036854775807L;
        }
        return a(dVar);
    }

    public final int f(d5.d dVar, d5.n nVar, int i10) throws IOException {
        int min = (int) Math.min(this.f20398a, dVar.b());
        long j10 = 0;
        if (dVar.getPosition() != j10) {
            nVar.f48642a = j10;
            return 1;
        }
        this.f20400c.L(min);
        dVar.m();
        dVar.j(this.f20400c.d(), 0, min);
        this.f20404g = g(this.f20400c, i10);
        this.f20402e = true;
        return 0;
    }

    public final long g(ParsableByteArray parsableByteArray, int i10) {
        int f10 = parsableByteArray.f();
        for (int e2 = parsableByteArray.e(); e2 < f10; e2++) {
            if (parsableByteArray.d()[e2] == 71) {
                long c4 = i0.c(parsableByteArray, e2, i10);
                if (c4 != -9223372036854775807L) {
                    return c4;
                }
            }
        }
        return -9223372036854775807L;
    }

    public final int h(d5.d dVar, d5.n nVar, int i10) throws IOException {
        long b4 = dVar.b();
        int min = (int) Math.min(this.f20398a, b4);
        long j10 = b4 - min;
        if (dVar.getPosition() != j10) {
            nVar.f48642a = j10;
            return 1;
        }
        this.f20400c.L(min);
        dVar.m();
        dVar.j(this.f20400c.d(), 0, min);
        this.f20405h = i(this.f20400c, i10);
        this.f20403f = true;
        return 0;
    }

    public final long i(ParsableByteArray parsableByteArray, int i10) {
        int e2 = parsableByteArray.e();
        int f10 = parsableByteArray.f();
        for (int i11 = f10 - 188; i11 >= e2; i11--) {
            if (i0.b(parsableByteArray.d(), e2, f10, i11)) {
                long c4 = i0.c(parsableByteArray, i11, i10);
                if (c4 != -9223372036854775807L) {
                    return c4;
                }
            }
        }
        return -9223372036854775807L;
    }
}
