package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import java.io.IOException;

/* compiled from: ClippingMediaPeriod.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c implements p, p.a {

    /* renamed from: b, reason: collision with root package name */
    public final p f21238b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public p.a f21239c;

    /* renamed from: d, reason: collision with root package name */
    public a[] f21240d = new a[0];

    /* renamed from: e, reason: collision with root package name */
    public long f21241e;

    /* renamed from: f, reason: collision with root package name */
    public long f21242f;

    /* renamed from: g, reason: collision with root package name */
    public long f21243g;

    /* compiled from: ClippingMediaPeriod.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class a implements SampleStream {

        /* renamed from: b, reason: collision with root package name */
        public final SampleStream f21244b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f21245c;

        public a(SampleStream sampleStream) {
            this.f21244b = sampleStream;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void a() throws IOException {
            this.f21244b.a();
        }

        public void b() {
            this.f21245c = false;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int c(s0 s0Var, DecoderInputBuffer decoderInputBuffer, int i10) {
            if (c.this.c()) {
                return -3;
            }
            if (this.f21245c) {
                decoderInputBuffer.o(4);
                return -4;
            }
            int c4 = this.f21244b.c(s0Var, decoderInputBuffer, i10);
            if (c4 == -5) {
                Format format = (Format) com.google.android.exoplayer2.util.a.e(s0Var.f21132b);
                int i11 = format.C;
                if (i11 != 0 || format.D != 0) {
                    c cVar = c.this;
                    if (cVar.f21242f != 0) {
                        i11 = 0;
                    }
                    s0Var.f21132b = format.a().M(i11).N(cVar.f21243g == Long.MIN_VALUE ? format.D : 0).E();
                }
                return -5;
            }
            c cVar2 = c.this;
            long j10 = cVar2.f21243g;
            if (j10 == Long.MIN_VALUE || ((c4 != -4 || decoderInputBuffer.f19884f < j10) && !(c4 == -3 && cVar2.d() == Long.MIN_VALUE && !decoderInputBuffer.f19883e))) {
                return c4;
            }
            decoderInputBuffer.h();
            decoderInputBuffer.o(4);
            this.f21245c = true;
            return -4;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return !c.this.c() && this.f21244b.isReady();
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int l(long j10) {
            if (c.this.c()) {
                return -3;
            }
            return this.f21244b.l(j10);
        }
    }

    public c(p pVar, boolean z10, long j10, long j11) {
        this.f21238b = pVar;
        this.f21241e = z10 ? j10 : -9223372036854775807L;
        this.f21242f = j10;
        this.f21243g = j11;
    }

    public static boolean q(long j10, ExoTrackSelection[] exoTrackSelectionArr) {
        if (j10 != 0) {
            for (ExoTrackSelection exoTrackSelection : exoTrackSelectionArr) {
                if (exoTrackSelection != null) {
                    Format m10 = exoTrackSelection.m();
                    if (!com.google.android.exoplayer2.util.q.a(m10.f19544m, m10.f19541j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final p1 a(long j10, p1 p1Var) {
        long s2 = com.google.android.exoplayer2.util.j0.s(p1Var.f21056a, 0L, j10 - this.f21242f);
        long j11 = p1Var.f21057b;
        long j12 = this.f21243g;
        long s10 = com.google.android.exoplayer2.util.j0.s(j11, 0L, j12 == Long.MIN_VALUE ? Long.MAX_VALUE : j12 - j10);
        return (s2 == p1Var.f21056a && s10 == p1Var.f21057b) ? p1Var : new p1(s2, s10);
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public boolean b(long j10) {
        return this.f21238b.b(j10);
    }

    public boolean c() {
        return this.f21241e != -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public long d() {
        long d10 = this.f21238b.d();
        if (d10 != Long.MIN_VALUE) {
            long j10 = this.f21243g;
            if (j10 == Long.MIN_VALUE || d10 < j10) {
                return d10;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public void e(long j10) {
        this.f21238b.e(j10);
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public long f() {
        long f10 = this.f21238b.f();
        if (f10 != Long.MIN_VALUE) {
            long j10 = this.f21243g;
            if (j10 == Long.MIN_VALUE || f10 < j10) {
                return f10;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.p
    public long g(long j10, p1 p1Var) {
        long j11 = this.f21242f;
        if (j10 == j11) {
            return j11;
        }
        return this.f21238b.g(j10, a(j10, p1Var));
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
    
        if (r0 > r7) goto L17;
     */
    @Override // com.google.android.exoplayer2.source.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long h(long r7) {
        /*
            r6 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6.f21241e = r0
            com.google.android.exoplayer2.source.c$a[] r0 = r6.f21240d
            int r1 = r0.length
            r2 = 0
            r3 = 0
        Lc:
            if (r3 >= r1) goto L18
            r4 = r0[r3]
            if (r4 == 0) goto L15
            r4.b()
        L15:
            int r3 = r3 + 1
            goto Lc
        L18:
            com.google.android.exoplayer2.source.p r0 = r6.f21238b
            long r0 = r0.h(r7)
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 == 0) goto L34
            long r7 = r6.f21242f
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 < 0) goto L35
            long r7 = r6.f21243g
            r3 = -9223372036854775808
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L34
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 > 0) goto L35
        L34:
            r2 = 1
        L35:
            com.google.android.exoplayer2.util.a.g(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.c.h(long):long");
    }

    @Override // com.google.android.exoplayer2.source.p
    public long i() {
        if (c()) {
            long j10 = this.f21241e;
            this.f21241e = -9223372036854775807L;
            long i10 = i();
            return i10 != -9223372036854775807L ? i10 : j10;
        }
        long i11 = this.f21238b.i();
        if (i11 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z10 = true;
        com.google.android.exoplayer2.util.a.g(i11 >= this.f21242f);
        long j11 = this.f21243g;
        if (j11 != Long.MIN_VALUE && i11 > j11) {
            z10 = false;
        }
        com.google.android.exoplayer2.util.a.g(z10);
        return i11;
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public boolean isLoading() {
        return this.f21238b.isLoading();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0062, code lost:
    
        if (r2 > r4) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006e  */
    @Override // com.google.android.exoplayer2.source.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long j(com.google.android.exoplayer2.trackselection.ExoTrackSelection[] r13, boolean[] r14, com.google.android.exoplayer2.source.SampleStream[] r15, boolean[] r16, long r17) {
        /*
            r12 = this;
            r0 = r12
            r1 = r15
            int r2 = r1.length
            com.google.android.exoplayer2.source.c$a[] r2 = new com.google.android.exoplayer2.source.c.a[r2]
            r0.f21240d = r2
            int r2 = r1.length
            com.google.android.exoplayer2.source.SampleStream[] r9 = new com.google.android.exoplayer2.source.SampleStream[r2]
            r10 = 0
            r2 = 0
        Lc:
            int r3 = r1.length
            r11 = 0
            if (r2 >= r3) goto L25
            com.google.android.exoplayer2.source.c$a[] r3 = r0.f21240d
            r4 = r1[r2]
            com.google.android.exoplayer2.source.c$a r4 = (com.google.android.exoplayer2.source.c.a) r4
            r3[r2] = r4
            r4 = r3[r2]
            if (r4 == 0) goto L20
            r3 = r3[r2]
            com.google.android.exoplayer2.source.SampleStream r11 = r3.f21244b
        L20:
            r9[r2] = r11
            int r2 = r2 + 1
            goto Lc
        L25:
            com.google.android.exoplayer2.source.p r2 = r0.f21238b
            r3 = r13
            r4 = r14
            r5 = r9
            r6 = r16
            r7 = r17
            long r2 = r2.j(r3, r4, r5, r6, r7)
            boolean r4 = r12.c()
            if (r4 == 0) goto L47
            long r4 = r0.f21242f
            int r6 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r6 != 0) goto L47
            r6 = r13
            boolean r4 = q(r4, r13)
            if (r4 == 0) goto L47
            r4 = r2
            goto L4c
        L47:
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L4c:
            r0.f21241e = r4
            int r4 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r4 == 0) goto L67
            long r4 = r0.f21242f
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 < 0) goto L65
            long r4 = r0.f21243g
            r6 = -9223372036854775808
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L67
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 > 0) goto L65
            goto L67
        L65:
            r4 = 0
            goto L68
        L67:
            r4 = 1
        L68:
            com.google.android.exoplayer2.util.a.g(r4)
        L6b:
            int r4 = r1.length
            if (r10 >= r4) goto L97
            r4 = r9[r10]
            if (r4 != 0) goto L77
            com.google.android.exoplayer2.source.c$a[] r4 = r0.f21240d
            r4[r10] = r11
            goto L8e
        L77:
            com.google.android.exoplayer2.source.c$a[] r4 = r0.f21240d
            r5 = r4[r10]
            if (r5 == 0) goto L85
            r5 = r4[r10]
            com.google.android.exoplayer2.source.SampleStream r5 = r5.f21244b
            r6 = r9[r10]
            if (r5 == r6) goto L8e
        L85:
            com.google.android.exoplayer2.source.c$a r5 = new com.google.android.exoplayer2.source.c$a
            r6 = r9[r10]
            r5.<init>(r6)
            r4[r10] = r5
        L8e:
            com.google.android.exoplayer2.source.c$a[] r4 = r0.f21240d
            r4 = r4[r10]
            r1[r10] = r4
            int r10 = r10 + 1
            goto L6b
        L97:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.c.j(com.google.android.exoplayer2.trackselection.ExoTrackSelection[], boolean[], com.google.android.exoplayer2.source.SampleStream[], boolean[], long):long");
    }

    @Override // com.google.android.exoplayer2.source.p
    public TrackGroupArray m() {
        return this.f21238b.m();
    }

    @Override // com.google.android.exoplayer2.source.p.a
    public void n(p pVar) {
        ((p.a) com.google.android.exoplayer2.util.a.e(this.f21239c)).n(this);
    }

    @Override // com.google.android.exoplayer2.source.m0.a
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void k(p pVar) {
        ((p.a) com.google.android.exoplayer2.util.a.e(this.f21239c)).k(this);
    }

    @Override // com.google.android.exoplayer2.source.p
    public void p(p.a aVar, long j10) {
        this.f21239c = aVar;
        this.f21238b.p(this, j10);
    }

    public void r(long j10, long j11) {
        this.f21242f = j10;
        this.f21243g = j11;
    }

    @Override // com.google.android.exoplayer2.source.p
    public void s() throws IOException {
        this.f21238b.s();
    }

    @Override // com.google.android.exoplayer2.source.p
    public void t(long j10, boolean z10) {
        this.f21238b.t(j10, z10);
    }
}
