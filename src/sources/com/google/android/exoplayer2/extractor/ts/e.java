package com.google.android.exoplayer2.extractor.ts;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.ts.h0;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.Map;

/* compiled from: Ac4Extractor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e implements Extractor {

    /* renamed from: d, reason: collision with root package name */
    public static final d5.i f20394d = new d5.i() { // from class: com.google.android.exoplayer2.extractor.ts.d
        @Override // d5.i
        public /* synthetic */ Extractor[] a(Uri uri, Map map) {
            return d5.h.a(this, uri, map);
        }

        @Override // d5.i
        public final Extractor[] b() {
            Extractor[] d10;
            d10 = e.d();
            return d10;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final f f20395a = new f();

    /* renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f20396b = new ParsableByteArray(16384);

    /* renamed from: c, reason: collision with root package name */
    public boolean f20397c;

    public static /* synthetic */ Extractor[] d() {
        return new Extractor[]{new e()};
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void a(long j10, long j11) {
        this.f20397c = false;
        this.f20395a.a();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void b(d5.e eVar) {
        this.f20395a.e(eVar, new h0.d(0, 1));
        eVar.l();
        eVar.r(new i.b(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int f(d5.d dVar, d5.n nVar) throws IOException {
        int read = dVar.read(this.f20396b.d(), 0, 16384);
        if (read == -1) {
            return -1;
        }
        this.f20396b.P(0);
        this.f20396b.O(read);
        if (!this.f20397c) {
            this.f20395a.f(0L, 4);
            this.f20397c = true;
        }
        this.f20395a.c(this.f20396b);
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
    
        r9.m();
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0046, code lost:
    
        if ((r4 - r3) < 8192) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0048, code lost:
    
        return false;
     */
    @Override // com.google.android.exoplayer2.extractor.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean g(d5.d r9) throws java.io.IOException {
        /*
            r8 = this;
            com.google.android.exoplayer2.util.ParsableByteArray r0 = new com.google.android.exoplayer2.util.ParsableByteArray
            r1 = 10
            r0.<init>(r1)
            r2 = 0
            r3 = 0
        L9:
            byte[] r4 = r0.d()
            r9.j(r4, r2, r1)
            r0.P(r2)
            int r4 = r0.G()
            r5 = 4801587(0x494433, float:6.728456E-39)
            if (r4 == r5) goto L65
            r9.m()
            r9.q(r3)
            r4 = r3
        L23:
            r1 = 0
        L24:
            byte[] r5 = r0.d()
            r6 = 7
            r9.j(r5, r2, r6)
            r0.P(r2)
            int r5 = r0.J()
            r6 = 44096(0xac40, float:6.1792E-41)
            if (r5 == r6) goto L4d
            r6 = 44097(0xac41, float:6.1793E-41)
            if (r5 == r6) goto L4d
            r9.m()
            int r4 = r4 + 1
            int r1 = r4 - r3
            r5 = 8192(0x2000, float:1.14794E-41)
            if (r1 < r5) goto L49
            return r2
        L49:
            r9.q(r4)
            goto L23
        L4d:
            r6 = 1
            int r1 = r1 + r6
            r7 = 4
            if (r1 < r7) goto L53
            return r6
        L53:
            byte[] r6 = r0.d()
            int r5 = x4.c.e(r6, r5)
            r6 = -1
            if (r5 != r6) goto L5f
            return r2
        L5f:
            int r5 = r5 + (-7)
            r9.q(r5)
            goto L24
        L65:
            r4 = 3
            r0.Q(r4)
            int r4 = r0.C()
            int r5 = r4 + 10
            int r3 = r3 + r5
            r9.q(r4)
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.e.g(d5.d):boolean");
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }
}
