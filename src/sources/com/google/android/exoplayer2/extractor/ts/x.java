package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

/* compiled from: PsDurationReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class x {

    /* renamed from: c, reason: collision with root package name */
    public boolean f20655c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f20656d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f20657e;

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.f0 f20653a = new com.google.android.exoplayer2.util.f0(0);

    /* renamed from: f, reason: collision with root package name */
    public long f20658f = -9223372036854775807L;

    /* renamed from: g, reason: collision with root package name */
    public long f20659g = -9223372036854775807L;

    /* renamed from: h, reason: collision with root package name */
    public long f20660h = -9223372036854775807L;

    /* renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f20654b = new ParsableByteArray();

    public static boolean a(byte[] bArr) {
        return (bArr[0] & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3;
    }

    public static long l(ParsableByteArray parsableByteArray) {
        int e2 = parsableByteArray.e();
        if (parsableByteArray.a() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        parsableByteArray.j(bArr, 0, 9);
        parsableByteArray.P(e2);
        if (a(bArr)) {
            return m(bArr);
        }
        return -9223372036854775807L;
    }

    public static long m(byte[] bArr) {
        return (((bArr[0] & 56) >> 3) << 30) | ((bArr[0] & 3) << 28) | ((bArr[1] & 255) << 20) | (((bArr[2] & 248) >> 3) << 15) | ((bArr[2] & 3) << 13) | ((bArr[3] & 255) << 5) | ((bArr[4] & 248) >> 3);
    }

    public final int b(d5.d dVar) {
        this.f20654b.M(com.google.android.exoplayer2.util.j0.f22995f);
        this.f20655c = true;
        dVar.m();
        return 0;
    }

    public long c() {
        return this.f20660h;
    }

    public com.google.android.exoplayer2.util.f0 d() {
        return this.f20653a;
    }

    public boolean e() {
        return this.f20655c;
    }

    public final int f(byte[] bArr, int i10) {
        return (bArr[i10 + 3] & 255) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10 + 2] & 255) << 8);
    }

    public int g(d5.d dVar, d5.n nVar) throws IOException {
        if (!this.f20657e) {
            return j(dVar, nVar);
        }
        if (this.f20659g == -9223372036854775807L) {
            return b(dVar);
        }
        if (!this.f20656d) {
            return h(dVar, nVar);
        }
        long j10 = this.f20658f;
        if (j10 == -9223372036854775807L) {
            return b(dVar);
        }
        long b4 = this.f20653a.b(this.f20659g) - this.f20653a.b(j10);
        this.f20660h = b4;
        if (b4 < 0) {
            StringBuilder sb2 = new StringBuilder(65);
            sb2.append("Invalid duration: ");
            sb2.append(b4);
            sb2.append(". Using TIME_UNSET instead.");
            com.google.android.exoplayer2.util.m.h("PsDurationReader", sb2.toString());
            this.f20660h = -9223372036854775807L;
        }
        return b(dVar);
    }

    public final int h(d5.d dVar, d5.n nVar) throws IOException {
        int min = (int) Math.min(20000L, dVar.b());
        long j10 = 0;
        if (dVar.getPosition() != j10) {
            nVar.f48642a = j10;
            return 1;
        }
        this.f20654b.L(min);
        dVar.m();
        dVar.j(this.f20654b.d(), 0, min);
        this.f20658f = i(this.f20654b);
        this.f20656d = true;
        return 0;
    }

    public final long i(ParsableByteArray parsableByteArray) {
        int f10 = parsableByteArray.f();
        for (int e2 = parsableByteArray.e(); e2 < f10 - 3; e2++) {
            if (f(parsableByteArray.d(), e2) == 442) {
                parsableByteArray.P(e2 + 4);
                long l10 = l(parsableByteArray);
                if (l10 != -9223372036854775807L) {
                    return l10;
                }
            }
        }
        return -9223372036854775807L;
    }

    public final int j(d5.d dVar, d5.n nVar) throws IOException {
        long b4 = dVar.b();
        int min = (int) Math.min(20000L, b4);
        long j10 = b4 - min;
        if (dVar.getPosition() != j10) {
            nVar.f48642a = j10;
            return 1;
        }
        this.f20654b.L(min);
        dVar.m();
        dVar.j(this.f20654b.d(), 0, min);
        this.f20659g = k(this.f20654b);
        this.f20657e = true;
        return 0;
    }

    public final long k(ParsableByteArray parsableByteArray) {
        int e2 = parsableByteArray.e();
        for (int f10 = parsableByteArray.f() - 4; f10 >= e2; f10--) {
            if (f(parsableByteArray.d(), f10) == 442) {
                parsableByteArray.P(f10 + 4);
                long l10 = l(parsableByteArray);
                if (l10 != -9223372036854775807L) {
                    return l10;
                }
            }
        }
        return -9223372036854775807L;
    }
}
