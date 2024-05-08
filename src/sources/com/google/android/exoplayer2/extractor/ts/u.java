package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.h0;
import com.google.android.exoplayer2.util.ParsableByteArray;

/* compiled from: PassthroughSectionPayloadReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class u implements a0 {

    /* renamed from: a, reason: collision with root package name */
    public Format f20636a;

    /* renamed from: b, reason: collision with root package name */
    public com.google.android.exoplayer2.util.f0 f20637b;

    /* renamed from: c, reason: collision with root package name */
    public TrackOutput f20638c;

    public u(String str) {
        this.f20636a = new Format.b().e0(str).E();
    }

    public final void a() {
        com.google.android.exoplayer2.util.a.i(this.f20637b);
        com.google.android.exoplayer2.util.j0.j(this.f20638c);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.a0
    public void b(com.google.android.exoplayer2.util.f0 f0Var, d5.e eVar, h0.d dVar) {
        this.f20637b = f0Var;
        dVar.a();
        TrackOutput c4 = eVar.c(dVar.c(), 5);
        this.f20638c = c4;
        c4.b(this.f20636a);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.a0
    public void c(ParsableByteArray parsableByteArray) {
        a();
        long d10 = this.f20637b.d();
        long e2 = this.f20637b.e();
        if (d10 == -9223372036854775807L || e2 == -9223372036854775807L) {
            return;
        }
        Format format = this.f20636a;
        if (e2 != format.f19548q) {
            Format E = format.a().i0(e2).E();
            this.f20636a = E;
            this.f20638c.b(E);
        }
        int a10 = parsableByteArray.a();
        this.f20638c.a(parsableByteArray, a10);
        this.f20638c.d(d10, 1, a10, 0, null);
    }
}
