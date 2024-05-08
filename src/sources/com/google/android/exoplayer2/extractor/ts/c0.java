package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.h0;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.List;

/* compiled from: SeiReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public final List<Format> f20387a;

    /* renamed from: b, reason: collision with root package name */
    public final TrackOutput[] f20388b;

    public c0(List<Format> list) {
        this.f20387a = list;
        this.f20388b = new TrackOutput[list.size()];
    }

    public void a(long j10, ParsableByteArray parsableByteArray) {
        com.google.android.exoplayer2.extractor.a.a(j10, parsableByteArray, this.f20388b);
    }

    public void b(d5.e eVar, h0.d dVar) {
        for (int i10 = 0; i10 < this.f20388b.length; i10++) {
            dVar.a();
            TrackOutput c4 = eVar.c(dVar.c(), 3);
            Format format = this.f20387a.get(i10);
            String str = format.f19544m;
            boolean z10 = "application/cea-608".equals(str) || "application/cea-708".equals(str);
            String valueOf = String.valueOf(str);
            com.google.android.exoplayer2.util.a.b(z10, valueOf.length() != 0 ? "Invalid closed caption mime type provided: ".concat(valueOf) : new String("Invalid closed caption mime type provided: "));
            String str2 = format.f19533b;
            if (str2 == null) {
                str2 = dVar.b();
            }
            c4.b(new Format.b().S(str2).e0(str).g0(format.f19536e).V(format.f19535d).F(format.E).T(format.f19546o).E());
            this.f20388b[i10] = c4;
        }
    }
}
