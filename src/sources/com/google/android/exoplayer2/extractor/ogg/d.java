package com.google.android.exoplayer2.extractor.ogg;

import android.net.Uri;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import d5.i;
import d5.n;
import java.io.IOException;
import java.util.Map;

/* compiled from: OggExtractor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class d implements Extractor {

    /* renamed from: d, reason: collision with root package name */
    public static final i f20299d = new i() { // from class: com.google.android.exoplayer2.extractor.ogg.c
        @Override // d5.i
        public /* synthetic */ Extractor[] a(Uri uri, Map map) {
            return d5.h.a(this, uri, map);
        }

        @Override // d5.i
        public final Extractor[] b() {
            Extractor[] d10;
            d10 = d.d();
            return d10;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public d5.e f20300a;

    /* renamed from: b, reason: collision with root package name */
    public StreamReader f20301b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f20302c;

    public static /* synthetic */ Extractor[] d() {
        return new Extractor[]{new d()};
    }

    public static ParsableByteArray e(ParsableByteArray parsableByteArray) {
        parsableByteArray.P(0);
        return parsableByteArray;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void a(long j10, long j11) {
        StreamReader streamReader = this.f20301b;
        if (streamReader != null) {
            streamReader.m(j10, j11);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(d5.e eVar) {
        this.f20300a = eVar;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int f(d5.d dVar, n nVar) throws IOException {
        com.google.android.exoplayer2.util.a.i(this.f20300a);
        if (this.f20301b == null) {
            if (h(dVar)) {
                dVar.m();
            } else {
                throw ParserException.createForMalformedContainer("Failed to determine bitstream type", null);
            }
        }
        if (!this.f20302c) {
            TrackOutput c4 = this.f20300a.c(0, 1);
            this.f20300a.l();
            this.f20301b.d(this.f20300a, c4);
            this.f20302c = true;
        }
        return this.f20301b.g(dVar, nVar);
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean g(d5.d dVar) throws IOException {
        try {
            return h(dVar);
        } catch (ParserException unused) {
            return false;
        }
    }

    public final boolean h(d5.d dVar) throws IOException {
        f fVar = new f();
        if (fVar.a(dVar, true) && (fVar.f20309b & 2) == 2) {
            int min = Math.min(fVar.f20316i, 8);
            ParsableByteArray parsableByteArray = new ParsableByteArray(min);
            dVar.j(parsableByteArray.d(), 0, min);
            if (b.p(e(parsableByteArray))) {
                this.f20301b = new b();
            } else if (h.r(e(parsableByteArray))) {
                this.f20301b = new h();
            } else if (g.o(e(parsableByteArray))) {
                this.f20301b = new g();
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }
}
