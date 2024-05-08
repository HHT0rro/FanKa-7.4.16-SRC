package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.Extractor;
import java.io.IOException;

/* compiled from: BundledExtractorsAdapter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b implements c0 {

    /* renamed from: a, reason: collision with root package name */
    public final d5.i f21222a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Extractor f21223b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public d5.d f21224c;

    public b(d5.i iVar) {
        this.f21222a = iVar;
    }

    @Override // com.google.android.exoplayer2.source.c0
    public void a(long j10, long j11) {
        ((Extractor) com.google.android.exoplayer2.util.a.e(this.f21223b)).a(j10, j11);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x003f, code lost:
    
        if (r6.getPosition() != r11) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0065, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0062, code lost:
    
        if (r6.getPosition() != r11) goto L33;
     */
    @Override // com.google.android.exoplayer2.source.c0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(o6.g r8, android.net.Uri r9, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r10, long r11, long r13, d5.e r15) throws java.io.IOException {
        /*
            r7 = this;
            d5.b r6 = new d5.b
            r0 = r6
            r1 = r8
            r2 = r11
            r4 = r13
            r0.<init>(r1, r2, r4)
            r7.f21224c = r6
            com.google.android.exoplayer2.extractor.Extractor r8 = r7.f21223b
            if (r8 == 0) goto L10
            return
        L10:
            d5.i r8 = r7.f21222a
            com.google.android.exoplayer2.extractor.Extractor[] r8 = r8.a(r9, r10)
            int r10 = r8.length
            r13 = 0
            r14 = 1
            if (r10 != r14) goto L20
            r8 = r8[r13]
            r7.f21223b = r8
            goto L75
        L20:
            int r10 = r8.length
            r0 = 0
        L22:
            if (r0 >= r10) goto L71
            r1 = r8[r0]
            boolean r2 = r1.g(r6)     // Catch: java.lang.Throwable -> L42 java.io.EOFException -> L57
            if (r2 == 0) goto L35
            r7.f21223b = r1     // Catch: java.lang.Throwable -> L42 java.io.EOFException -> L57
            com.google.android.exoplayer2.util.a.g(r14)
            r6.m()
            goto L71
        L35:
            com.google.android.exoplayer2.extractor.Extractor r1 = r7.f21223b
            if (r1 != 0) goto L67
            long r1 = r6.getPosition()
            int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r3 != 0) goto L65
            goto L67
        L42:
            r8 = move-exception
            com.google.android.exoplayer2.extractor.Extractor r9 = r7.f21223b
            if (r9 != 0) goto L4f
            long r9 = r6.getPosition()
            int r15 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r15 != 0) goto L50
        L4f:
            r13 = 1
        L50:
            com.google.android.exoplayer2.util.a.g(r13)
            r6.m()
            throw r8
        L57:
            com.google.android.exoplayer2.extractor.Extractor r1 = r7.f21223b
            if (r1 != 0) goto L67
            long r1 = r6.getPosition()
            int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r3 != 0) goto L65
            goto L67
        L65:
            r1 = 0
            goto L68
        L67:
            r1 = 1
        L68:
            com.google.android.exoplayer2.util.a.g(r1)
            r6.m()
            int r0 = r0 + 1
            goto L22
        L71:
            com.google.android.exoplayer2.extractor.Extractor r10 = r7.f21223b
            if (r10 == 0) goto L7b
        L75:
            com.google.android.exoplayer2.extractor.Extractor r8 = r7.f21223b
            r8.b(r15)
            return
        L7b:
            com.google.android.exoplayer2.source.UnrecognizedInputFormatException r10 = new com.google.android.exoplayer2.source.UnrecognizedInputFormatException
            java.lang.String r8 = com.google.android.exoplayer2.util.j0.L(r8)
            java.lang.String r11 = java.lang.String.valueOf(r8)
            int r11 = r11.length()
            int r11 = r11 + 58
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>(r11)
            java.lang.String r11 = "None of the available extractors ("
            r12.append(r11)
            r12.append(r8)
            java.lang.String r8 = ") could read the stream."
            r12.append(r8)
            java.lang.String r8 = r12.toString()
            java.lang.Object r9 = com.google.android.exoplayer2.util.a.e(r9)
            android.net.Uri r9 = (android.net.Uri) r9
            r10.<init>(r8, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.b.b(o6.g, android.net.Uri, java.util.Map, long, long, d5.e):void");
    }

    @Override // com.google.android.exoplayer2.source.c0
    public long c() {
        d5.d dVar = this.f21224c;
        if (dVar != null) {
            return dVar.getPosition();
        }
        return -1L;
    }

    @Override // com.google.android.exoplayer2.source.c0
    public void d() {
        Extractor extractor = this.f21223b;
        if (extractor instanceof j5.f) {
            ((j5.f) extractor).j();
        }
    }

    @Override // com.google.android.exoplayer2.source.c0
    public int e(d5.n nVar) throws IOException {
        return ((Extractor) com.google.android.exoplayer2.util.a.e(this.f21223b)).f((d5.d) com.google.android.exoplayer2.util.a.e(this.f21224c), nVar);
    }

    @Override // com.google.android.exoplayer2.source.c0
    public void release() {
        Extractor extractor = this.f21223b;
        if (extractor != null) {
            extractor.release();
            this.f21223b = null;
        }
        this.f21224c = null;
    }
}
