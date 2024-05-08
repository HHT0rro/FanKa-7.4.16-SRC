package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.h0;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.List;

/* compiled from: UserDataReader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class j0 {

    /* renamed from: a, reason: collision with root package name */
    public final List<Format> f20498a;

    /* renamed from: b, reason: collision with root package name */
    public final TrackOutput[] f20499b;

    public j0(List<Format> list) {
        this.f20498a = list;
        this.f20499b = new TrackOutput[list.size()];
    }

    public void a(long j10, ParsableByteArray parsableByteArray) {
        if (parsableByteArray.a() < 9) {
            return;
        }
        int n10 = parsableByteArray.n();
        int n11 = parsableByteArray.n();
        int D = parsableByteArray.D();
        if (n10 == 434 && n11 == 1195456820 && D == 3) {
            com.google.android.exoplayer2.extractor.a.b(j10, parsableByteArray, this.f20499b);
        }
    }

    public void b(d5.e eVar, h0.d dVar) {
        for (int i10 = 0; i10 < this.f20499b.length; i10++) {
            dVar.a();
            TrackOutput c4 = eVar.c(dVar.c(), 3);
            Format format = this.f20498a.get(i10);
            String str = format.f19544m;
            boolean z10 = "application/cea-608".equals(str) || "application/cea-708".equals(str);
            String valueOf = String.valueOf(str);
            com.google.android.exoplayer2.util.a.b(z10, valueOf.length() != 0 ? "Invalid closed caption mime type provided: ".concat(valueOf) : new String("Invalid closed caption mime type provided: "));
            c4.b(new Format.b().S(dVar.b()).e0(str).g0(format.f19536e).V(format.f19535d).F(format.E).T(format.f19546o).E());
            this.f20499b[i10] = c4;
        }
    }
}
