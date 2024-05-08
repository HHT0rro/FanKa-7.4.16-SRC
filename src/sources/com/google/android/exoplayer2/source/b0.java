package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;

/* compiled from: MergingMediaPeriod.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b0 implements p, p.a {

    /* renamed from: b, reason: collision with root package name */
    public final p[] f21225b;

    /* renamed from: d, reason: collision with root package name */
    public final g f21227d;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public p.a f21229f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public TrackGroupArray f21230g;

    /* renamed from: i, reason: collision with root package name */
    public m0 f21232i;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList<p> f21228e = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public final IdentityHashMap<SampleStream, Integer> f21226c = new IdentityHashMap<>();

    /* renamed from: h, reason: collision with root package name */
    public p[] f21231h = new p[0];

    /* compiled from: MergingMediaPeriod.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements p, p.a {

        /* renamed from: b, reason: collision with root package name */
        public final p f21233b;

        /* renamed from: c, reason: collision with root package name */
        public final long f21234c;

        /* renamed from: d, reason: collision with root package name */
        public p.a f21235d;

        public a(p pVar, long j10) {
            this.f21233b = pVar;
            this.f21234c = j10;
        }

        @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
        public boolean b(long j10) {
            return this.f21233b.b(j10 - this.f21234c);
        }

        @Override // com.google.android.exoplayer2.source.m0.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void k(p pVar) {
            ((p.a) com.google.android.exoplayer2.util.a.e(this.f21235d)).k(this);
        }

        @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
        public long d() {
            long d10 = this.f21233b.d();
            if (d10 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return this.f21234c + d10;
        }

        @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
        public void e(long j10) {
            this.f21233b.e(j10 - this.f21234c);
        }

        @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
        public long f() {
            long f10 = this.f21233b.f();
            if (f10 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return this.f21234c + f10;
        }

        @Override // com.google.android.exoplayer2.source.p
        public long g(long j10, p1 p1Var) {
            return this.f21233b.g(j10 - this.f21234c, p1Var) + this.f21234c;
        }

        @Override // com.google.android.exoplayer2.source.p
        public long h(long j10) {
            return this.f21233b.h(j10 - this.f21234c) + this.f21234c;
        }

        @Override // com.google.android.exoplayer2.source.p
        public long i() {
            long i10 = this.f21233b.i();
            if (i10 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.f21234c + i10;
        }

        @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
        public boolean isLoading() {
            return this.f21233b.isLoading();
        }

        @Override // com.google.android.exoplayer2.source.p
        public long j(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j10) {
            SampleStream[] sampleStreamArr2 = new SampleStream[sampleStreamArr.length];
            int i10 = 0;
            while (true) {
                SampleStream sampleStream = null;
                if (i10 >= sampleStreamArr.length) {
                    break;
                }
                b bVar = (b) sampleStreamArr[i10];
                if (bVar != null) {
                    sampleStream = bVar.b();
                }
                sampleStreamArr2[i10] = sampleStream;
                i10++;
            }
            long j11 = this.f21233b.j(exoTrackSelectionArr, zArr, sampleStreamArr2, zArr2, j10 - this.f21234c);
            for (int i11 = 0; i11 < sampleStreamArr.length; i11++) {
                SampleStream sampleStream2 = sampleStreamArr2[i11];
                if (sampleStream2 == null) {
                    sampleStreamArr[i11] = null;
                } else if (sampleStreamArr[i11] == null || ((b) sampleStreamArr[i11]).b() != sampleStream2) {
                    sampleStreamArr[i11] = new b(sampleStream2, this.f21234c);
                }
            }
            return j11 + this.f21234c;
        }

        @Override // com.google.android.exoplayer2.source.p
        public TrackGroupArray m() {
            return this.f21233b.m();
        }

        @Override // com.google.android.exoplayer2.source.p.a
        public void n(p pVar) {
            ((p.a) com.google.android.exoplayer2.util.a.e(this.f21235d)).n(this);
        }

        @Override // com.google.android.exoplayer2.source.p
        public void p(p.a aVar, long j10) {
            this.f21235d = aVar;
            this.f21233b.p(this, j10 - this.f21234c);
        }

        @Override // com.google.android.exoplayer2.source.p
        public void s() throws IOException {
            this.f21233b.s();
        }

        @Override // com.google.android.exoplayer2.source.p
        public void t(long j10, boolean z10) {
            this.f21233b.t(j10 - this.f21234c, z10);
        }
    }

    /* compiled from: MergingMediaPeriod.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements SampleStream {

        /* renamed from: b, reason: collision with root package name */
        public final SampleStream f21236b;

        /* renamed from: c, reason: collision with root package name */
        public final long f21237c;

        public b(SampleStream sampleStream, long j10) {
            this.f21236b = sampleStream;
            this.f21237c = j10;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void a() throws IOException {
            this.f21236b.a();
        }

        public SampleStream b() {
            return this.f21236b;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int c(s0 s0Var, DecoderInputBuffer decoderInputBuffer, int i10) {
            int c4 = this.f21236b.c(s0Var, decoderInputBuffer, i10);
            if (c4 == -4) {
                decoderInputBuffer.f19884f = Math.max(0L, decoderInputBuffer.f19884f + this.f21237c);
            }
            return c4;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return this.f21236b.isReady();
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int l(long j10) {
            return this.f21236b.l(j10 - this.f21237c);
        }
    }

    public b0(g gVar, long[] jArr, p... pVarArr) {
        this.f21227d = gVar;
        this.f21225b = pVarArr;
        this.f21232i = gVar.a(new m0[0]);
        for (int i10 = 0; i10 < pVarArr.length; i10++) {
            if (jArr[i10] != 0) {
                this.f21225b[i10] = new a(pVarArr[i10], jArr[i10]);
            }
        }
    }

    public p a(int i10) {
        p[] pVarArr = this.f21225b;
        if (pVarArr[i10] instanceof a) {
            return ((a) pVarArr[i10]).f21233b;
        }
        return pVarArr[i10];
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public boolean b(long j10) {
        if (!this.f21228e.isEmpty()) {
            int size = this.f21228e.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f21228e.get(i10).b(j10);
            }
            return false;
        }
        return this.f21232i.b(j10);
    }

    @Override // com.google.android.exoplayer2.source.m0.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void k(p pVar) {
        ((p.a) com.google.android.exoplayer2.util.a.e(this.f21229f)).k(this);
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public long d() {
        return this.f21232i.d();
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public void e(long j10) {
        this.f21232i.e(j10);
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public long f() {
        return this.f21232i.f();
    }

    @Override // com.google.android.exoplayer2.source.p
    public long g(long j10, p1 p1Var) {
        p[] pVarArr = this.f21231h;
        return (pVarArr.length > 0 ? pVarArr[0] : this.f21225b[0]).g(j10, p1Var);
    }

    @Override // com.google.android.exoplayer2.source.p
    public long h(long j10) {
        long h10 = this.f21231h[0].h(j10);
        int i10 = 1;
        while (true) {
            p[] pVarArr = this.f21231h;
            if (i10 >= pVarArr.length) {
                return h10;
            }
            if (pVarArr[i10].h(h10) != h10) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
            i10++;
        }
    }

    @Override // com.google.android.exoplayer2.source.p
    public long i() {
        long j10 = -9223372036854775807L;
        for (p pVar : this.f21231h) {
            long i10 = pVar.i();
            if (i10 != -9223372036854775807L) {
                if (j10 == -9223372036854775807L) {
                    for (p pVar2 : this.f21231h) {
                        if (pVar2 == pVar) {
                            break;
                        }
                        if (pVar2.h(i10) != i10) {
                            throw new IllegalStateException("Unexpected child seekToUs result.");
                        }
                    }
                    j10 = i10;
                } else if (i10 != j10) {
                    throw new IllegalStateException("Conflicting discontinuities.");
                }
            } else if (j10 != -9223372036854775807L && pVar.h(j10) != j10) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
        return j10;
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public boolean isLoading() {
        return this.f21232i.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.p
    public long j(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j10) {
        int[] iArr = new int[exoTrackSelectionArr.length];
        int[] iArr2 = new int[exoTrackSelectionArr.length];
        for (int i10 = 0; i10 < exoTrackSelectionArr.length; i10++) {
            Integer num = sampleStreamArr[i10] == null ? null : this.f21226c.get(sampleStreamArr[i10]);
            iArr[i10] = num == null ? -1 : num.intValue();
            iArr2[i10] = -1;
            if (exoTrackSelectionArr[i10] != null) {
                TrackGroup g3 = exoTrackSelectionArr[i10].g();
                int i11 = 0;
                while (true) {
                    p[] pVarArr = this.f21225b;
                    if (i11 >= pVarArr.length) {
                        break;
                    }
                    if (pVarArr[i11].m().b(g3) != -1) {
                        iArr2[i10] = i11;
                        break;
                    }
                    i11++;
                }
            }
        }
        this.f21226c.clear();
        int length = exoTrackSelectionArr.length;
        SampleStream[] sampleStreamArr2 = new SampleStream[length];
        SampleStream[] sampleStreamArr3 = new SampleStream[exoTrackSelectionArr.length];
        ExoTrackSelection[] exoTrackSelectionArr2 = new ExoTrackSelection[exoTrackSelectionArr.length];
        ArrayList arrayList = new ArrayList(this.f21225b.length);
        long j11 = j10;
        int i12 = 0;
        while (i12 < this.f21225b.length) {
            for (int i13 = 0; i13 < exoTrackSelectionArr.length; i13++) {
                sampleStreamArr3[i13] = iArr[i13] == i12 ? sampleStreamArr[i13] : null;
                exoTrackSelectionArr2[i13] = iArr2[i13] == i12 ? exoTrackSelectionArr[i13] : null;
            }
            int i14 = i12;
            ArrayList arrayList2 = arrayList;
            ExoTrackSelection[] exoTrackSelectionArr3 = exoTrackSelectionArr2;
            long j12 = this.f21225b[i12].j(exoTrackSelectionArr2, zArr, sampleStreamArr3, zArr2, j11);
            if (i14 == 0) {
                j11 = j12;
            } else if (j12 != j11) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z10 = false;
            for (int i15 = 0; i15 < exoTrackSelectionArr.length; i15++) {
                if (iArr2[i15] == i14) {
                    SampleStream sampleStream = (SampleStream) com.google.android.exoplayer2.util.a.e(sampleStreamArr3[i15]);
                    sampleStreamArr2[i15] = sampleStreamArr3[i15];
                    this.f21226c.put(sampleStream, Integer.valueOf(i14));
                    z10 = true;
                } else if (iArr[i15] == i14) {
                    com.google.android.exoplayer2.util.a.g(sampleStreamArr3[i15] == null);
                }
            }
            if (z10) {
                arrayList2.add(this.f21225b[i14]);
            }
            i12 = i14 + 1;
            arrayList = arrayList2;
            exoTrackSelectionArr2 = exoTrackSelectionArr3;
        }
        System.arraycopy(sampleStreamArr2, 0, sampleStreamArr, 0, length);
        p[] pVarArr2 = (p[]) arrayList.toArray(new p[0]);
        this.f21231h = pVarArr2;
        this.f21232i = this.f21227d.a(pVarArr2);
        return j11;
    }

    @Override // com.google.android.exoplayer2.source.p
    public TrackGroupArray m() {
        return (TrackGroupArray) com.google.android.exoplayer2.util.a.e(this.f21230g);
    }

    @Override // com.google.android.exoplayer2.source.p.a
    public void n(p pVar) {
        this.f21228e.remove(pVar);
        if (this.f21228e.isEmpty()) {
            int i10 = 0;
            for (p pVar2 : this.f21225b) {
                i10 += pVar2.m().f21172b;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[i10];
            int i11 = 0;
            for (p pVar3 : this.f21225b) {
                TrackGroupArray m10 = pVar3.m();
                int i12 = m10.f21172b;
                int i13 = 0;
                while (i13 < i12) {
                    trackGroupArr[i11] = m10.a(i13);
                    i13++;
                    i11++;
                }
            }
            this.f21230g = new TrackGroupArray(trackGroupArr);
            ((p.a) com.google.android.exoplayer2.util.a.e(this.f21229f)).n(this);
        }
    }

    @Override // com.google.android.exoplayer2.source.p
    public void p(p.a aVar, long j10) {
        this.f21229f = aVar;
        Collections.addAll(this.f21228e, this.f21225b);
        for (p pVar : this.f21225b) {
            pVar.p(this, j10);
        }
    }

    @Override // com.google.android.exoplayer2.source.p
    public void s() throws IOException {
        for (p pVar : this.f21225b) {
            pVar.s();
        }
    }

    @Override // com.google.android.exoplayer2.source.p
    public void t(long j10, boolean z10) {
        for (p pVar : this.f21231h) {
            pVar.t(j10, z10);
        }
    }
}
