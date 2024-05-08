package com.google.android.exoplayer2.source.hls;

import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ts.g0;
import com.google.android.exoplayer2.util.f0;
import java.io.IOException;

/* compiled from: BundledHlsMediaChunkExtractor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b implements j {

    /* renamed from: d, reason: collision with root package name */
    public static final d5.n f21491d = new d5.n();

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public final Extractor f21492a;

    /* renamed from: b, reason: collision with root package name */
    public final Format f21493b;

    /* renamed from: c, reason: collision with root package name */
    public final f0 f21494c;

    public b(Extractor extractor, Format format, f0 f0Var) {
        this.f21492a = extractor;
        this.f21493b = format;
        this.f21494c = f0Var;
    }

    @Override // com.google.android.exoplayer2.source.hls.j
    public boolean a(d5.d dVar) throws IOException {
        return this.f21492a.f(dVar, f21491d) == 0;
    }

    @Override // com.google.android.exoplayer2.source.hls.j
    public void b(d5.e eVar) {
        this.f21492a.b(eVar);
    }

    @Override // com.google.android.exoplayer2.source.hls.j
    public void c() {
        this.f21492a.a(0L, 0L);
    }

    @Override // com.google.android.exoplayer2.source.hls.j
    public boolean d() {
        Extractor extractor = this.f21492a;
        return (extractor instanceof g0) || (extractor instanceof com.google.android.exoplayer2.extractor.mp4.f);
    }

    @Override // com.google.android.exoplayer2.source.hls.j
    public boolean e() {
        Extractor extractor = this.f21492a;
        return (extractor instanceof com.google.android.exoplayer2.extractor.ts.h) || (extractor instanceof com.google.android.exoplayer2.extractor.ts.b) || (extractor instanceof com.google.android.exoplayer2.extractor.ts.e) || (extractor instanceof j5.f);
    }

    @Override // com.google.android.exoplayer2.source.hls.j
    public j f() {
        Extractor fVar;
        com.google.android.exoplayer2.util.a.g(!d());
        Extractor extractor = this.f21492a;
        if (extractor instanceof r) {
            fVar = new r(this.f21493b.f19535d, this.f21494c);
        } else if (extractor instanceof com.google.android.exoplayer2.extractor.ts.h) {
            fVar = new com.google.android.exoplayer2.extractor.ts.h();
        } else if (extractor instanceof com.google.android.exoplayer2.extractor.ts.b) {
            fVar = new com.google.android.exoplayer2.extractor.ts.b();
        } else if (extractor instanceof com.google.android.exoplayer2.extractor.ts.e) {
            fVar = new com.google.android.exoplayer2.extractor.ts.e();
        } else if (extractor instanceof j5.f) {
            fVar = new j5.f();
        } else {
            String simpleName = this.f21492a.getClass().getSimpleName();
            throw new IllegalStateException(simpleName.length() != 0 ? "Unexpected extractor type for recreation: ".concat(simpleName) : new String("Unexpected extractor type for recreation: "));
        }
        return new b(fVar, this.f21493b, this.f21494c);
    }
}
