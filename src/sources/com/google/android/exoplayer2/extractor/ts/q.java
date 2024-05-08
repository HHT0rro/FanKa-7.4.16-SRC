package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.h0;
import com.google.android.exoplayer2.util.ParsableByteArray;

/* compiled from: Id3Reader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class q implements m {

    /* renamed from: b, reason: collision with root package name */
    public TrackOutput f20593b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f20594c;

    /* renamed from: e, reason: collision with root package name */
    public int f20596e;

    /* renamed from: f, reason: collision with root package name */
    public int f20597f;

    /* renamed from: a, reason: collision with root package name */
    public final ParsableByteArray f20592a = new ParsableByteArray(10);

    /* renamed from: d, reason: collision with root package name */
    public long f20595d = -9223372036854775807L;

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void a() {
        this.f20594c = false;
        this.f20595d = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void c(ParsableByteArray parsableByteArray) {
        com.google.android.exoplayer2.util.a.i(this.f20593b);
        if (this.f20594c) {
            int a10 = parsableByteArray.a();
            int i10 = this.f20597f;
            if (i10 < 10) {
                int min = Math.min(a10, 10 - i10);
                System.arraycopy((Object) parsableByteArray.d(), parsableByteArray.e(), (Object) this.f20592a.d(), this.f20597f, min);
                if (this.f20597f + min == 10) {
                    this.f20592a.P(0);
                    if (73 == this.f20592a.D() && 68 == this.f20592a.D() && 51 == this.f20592a.D()) {
                        this.f20592a.Q(3);
                        this.f20596e = this.f20592a.C() + 10;
                    } else {
                        com.google.android.exoplayer2.util.m.h("Id3Reader", "Discarding invalid ID3 tag");
                        this.f20594c = false;
                        return;
                    }
                }
            }
            int min2 = Math.min(a10, this.f20596e - this.f20597f);
            this.f20593b.a(parsableByteArray, min2);
            this.f20597f += min2;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void d() {
        int i10;
        com.google.android.exoplayer2.util.a.i(this.f20593b);
        if (this.f20594c && (i10 = this.f20596e) != 0 && this.f20597f == i10) {
            long j10 = this.f20595d;
            if (j10 != -9223372036854775807L) {
                this.f20593b.d(j10, 1, i10, 0, null);
            }
            this.f20594c = false;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void e(d5.e eVar, h0.d dVar) {
        dVar.a();
        TrackOutput c4 = eVar.c(dVar.c(), 5);
        this.f20593b = c4;
        c4.b(new Format.b().S(dVar.b()).e0("application/id3").E());
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void f(long j10, int i10) {
        if ((i10 & 4) == 0) {
            return;
        }
        this.f20594c = true;
        if (j10 != -9223372036854775807L) {
            this.f20595d = j10;
        }
        this.f20596e = 0;
        this.f20597f = 0;
    }
}
