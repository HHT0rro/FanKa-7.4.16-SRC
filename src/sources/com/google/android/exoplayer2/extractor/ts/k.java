package com.google.android.exoplayer2.extractor.ts;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.h0;
import com.google.android.exoplayer2.util.ParsableByteArray;

/* compiled from: DtsReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class k implements m {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f20501b;

    /* renamed from: c, reason: collision with root package name */
    public String f20502c;

    /* renamed from: d, reason: collision with root package name */
    public TrackOutput f20503d;

    /* renamed from: f, reason: collision with root package name */
    public int f20505f;

    /* renamed from: g, reason: collision with root package name */
    public int f20506g;

    /* renamed from: h, reason: collision with root package name */
    public long f20507h;

    /* renamed from: i, reason: collision with root package name */
    public Format f20508i;

    /* renamed from: j, reason: collision with root package name */
    public int f20509j;

    /* renamed from: a, reason: collision with root package name */
    public final ParsableByteArray f20500a = new ParsableByteArray(new byte[18]);

    /* renamed from: e, reason: collision with root package name */
    public int f20504e = 0;

    /* renamed from: k, reason: collision with root package name */
    public long f20510k = -9223372036854775807L;

    public k(@Nullable String str) {
        this.f20501b = str;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void a() {
        this.f20504e = 0;
        this.f20505f = 0;
        this.f20506g = 0;
        this.f20510k = -9223372036854775807L;
    }

    public final boolean b(ParsableByteArray parsableByteArray, byte[] bArr, int i10) {
        int min = Math.min(parsableByteArray.a(), i10 - this.f20505f);
        parsableByteArray.j(bArr, this.f20505f, min);
        int i11 = this.f20505f + min;
        this.f20505f = i11;
        return i11 == i10;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void c(ParsableByteArray parsableByteArray) {
        com.google.android.exoplayer2.util.a.i(this.f20503d);
        while (parsableByteArray.a() > 0) {
            int i10 = this.f20504e;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        int min = Math.min(parsableByteArray.a(), this.f20509j - this.f20505f);
                        this.f20503d.a(parsableByteArray, min);
                        int i11 = this.f20505f + min;
                        this.f20505f = i11;
                        int i12 = this.f20509j;
                        if (i11 == i12) {
                            long j10 = this.f20510k;
                            if (j10 != -9223372036854775807L) {
                                this.f20503d.d(j10, 1, i12, 0, null);
                                this.f20510k += this.f20507h;
                            }
                            this.f20504e = 0;
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else if (b(parsableByteArray, this.f20500a.d(), 18)) {
                    g();
                    this.f20500a.P(0);
                    this.f20503d.a(this.f20500a, 18);
                    this.f20504e = 2;
                }
            } else if (h(parsableByteArray)) {
                this.f20504e = 1;
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void d() {
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void e(d5.e eVar, h0.d dVar) {
        dVar.a();
        this.f20502c = dVar.b();
        this.f20503d = eVar.c(dVar.c(), 1);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void f(long j10, int i10) {
        if (j10 != -9223372036854775807L) {
            this.f20510k = j10;
        }
    }

    public final void g() {
        byte[] d10 = this.f20500a.d();
        if (this.f20508i == null) {
            Format g3 = x4.u.g(d10, this.f20502c, this.f20501b, null);
            this.f20508i = g3;
            this.f20503d.b(g3);
        }
        this.f20509j = x4.u.a(d10);
        this.f20507h = (int) ((x4.u.f(d10) * 1000000) / this.f20508i.A);
    }

    public final boolean h(ParsableByteArray parsableByteArray) {
        while (parsableByteArray.a() > 0) {
            int i10 = this.f20506g << 8;
            this.f20506g = i10;
            int D = i10 | parsableByteArray.D();
            this.f20506g = D;
            if (x4.u.d(D)) {
                byte[] d10 = this.f20500a.d();
                int i11 = this.f20506g;
                d10[0] = (byte) ((i11 >> 24) & 255);
                d10[1] = (byte) ((i11 >> 16) & 255);
                d10[2] = (byte) ((i11 >> 8) & 255);
                d10[3] = (byte) (i11 & 255);
                this.f20505f = 4;
                this.f20506g = 0;
                return true;
            }
        }
        return false;
    }
}
