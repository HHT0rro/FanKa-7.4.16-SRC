package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.h0;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import java.util.List;

/* compiled from: DvbSubtitleReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class l implements m {

    /* renamed from: a, reason: collision with root package name */
    public final List<h0.a> f20511a;

    /* renamed from: b, reason: collision with root package name */
    public final TrackOutput[] f20512b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f20513c;

    /* renamed from: d, reason: collision with root package name */
    public int f20514d;

    /* renamed from: e, reason: collision with root package name */
    public int f20515e;

    /* renamed from: f, reason: collision with root package name */
    public long f20516f = -9223372036854775807L;

    public l(List<h0.a> list) {
        this.f20511a = list;
        this.f20512b = new TrackOutput[list.size()];
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void a() {
        this.f20513c = false;
        this.f20516f = -9223372036854775807L;
    }

    public final boolean b(ParsableByteArray parsableByteArray, int i10) {
        if (parsableByteArray.a() == 0) {
            return false;
        }
        if (parsableByteArray.D() != i10) {
            this.f20513c = false;
        }
        this.f20514d--;
        return this.f20513c;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void c(ParsableByteArray parsableByteArray) {
        if (this.f20513c) {
            if (this.f20514d != 2 || b(parsableByteArray, 32)) {
                if (this.f20514d != 1 || b(parsableByteArray, 0)) {
                    int e2 = parsableByteArray.e();
                    int a10 = parsableByteArray.a();
                    for (TrackOutput trackOutput : this.f20512b) {
                        parsableByteArray.P(e2);
                        trackOutput.a(parsableByteArray, a10);
                    }
                    this.f20515e += a10;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void d() {
        if (this.f20513c) {
            if (this.f20516f != -9223372036854775807L) {
                for (TrackOutput trackOutput : this.f20512b) {
                    trackOutput.d(this.f20516f, 1, this.f20515e, 0, null);
                }
            }
            this.f20513c = false;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void e(d5.e eVar, h0.d dVar) {
        for (int i10 = 0; i10 < this.f20512b.length; i10++) {
            h0.a aVar = this.f20511a.get(i10);
            dVar.a();
            TrackOutput c4 = eVar.c(dVar.c(), 3);
            c4.b(new Format.b().S(dVar.b()).e0("application/dvbsubs").T(Collections.singletonList(aVar.f20464c)).V(aVar.f20462a).E());
            this.f20512b[i10] = c4;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.m
    public void f(long j10, int i10) {
        if ((i10 & 4) == 0) {
            return;
        }
        this.f20513c = true;
        if (j10 != -9223372036854775807L) {
            this.f20516f = j10;
        }
        this.f20515e = 0;
        this.f20514d = 2;
    }
}
