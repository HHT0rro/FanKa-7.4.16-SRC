package com.google.android.exoplayer2.trackselection;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.m;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.g0;
import com.google.common.collect.j0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import n6.f;
import o6.e;
import x5.n;
import x5.o;

/* compiled from: AdaptiveTrackSelection.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class a extends n6.b {

    /* renamed from: h, reason: collision with root package name */
    public final e f22318h;

    /* renamed from: i, reason: collision with root package name */
    public final long f22319i;

    /* renamed from: j, reason: collision with root package name */
    public final long f22320j;

    /* renamed from: k, reason: collision with root package name */
    public final long f22321k;

    /* renamed from: l, reason: collision with root package name */
    public final float f22322l;

    /* renamed from: m, reason: collision with root package name */
    public final float f22323m;

    /* renamed from: n, reason: collision with root package name */
    public final ImmutableList<C0207a> f22324n;

    /* renamed from: o, reason: collision with root package name */
    public final Clock f22325o;

    /* renamed from: p, reason: collision with root package name */
    public float f22326p;

    /* renamed from: q, reason: collision with root package name */
    public int f22327q;

    /* renamed from: r, reason: collision with root package name */
    public int f22328r;

    /* renamed from: s, reason: collision with root package name */
    public long f22329s;

    /* renamed from: t, reason: collision with root package name */
    @Nullable
    public n f22330t;

    /* compiled from: AdaptiveTrackSelection.java */
    /* renamed from: com.google.android.exoplayer2.trackselection.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class C0207a {

        /* renamed from: a, reason: collision with root package name */
        public final long f22331a;

        /* renamed from: b, reason: collision with root package name */
        public final long f22332b;

        public C0207a(long j10, long j11) {
            this.f22331a = j10;
            this.f22332b = j11;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0207a)) {
                return false;
            }
            C0207a c0207a = (C0207a) obj;
            return this.f22331a == c0207a.f22331a && this.f22332b == c0207a.f22332b;
        }

        public int hashCode() {
            return (((int) this.f22331a) * 31) + ((int) this.f22332b);
        }
    }

    /* compiled from: AdaptiveTrackSelection.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class b implements ExoTrackSelection.b {

        /* renamed from: a, reason: collision with root package name */
        public final int f22333a;

        /* renamed from: b, reason: collision with root package name */
        public final int f22334b;

        /* renamed from: c, reason: collision with root package name */
        public final int f22335c;

        /* renamed from: d, reason: collision with root package name */
        public final float f22336d;

        /* renamed from: e, reason: collision with root package name */
        public final float f22337e;

        /* renamed from: f, reason: collision with root package name */
        public final Clock f22338f;

        public b() {
            this(10000, 25000, 25000, 0.7f, 0.75f, Clock.f22902a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection.b
        public final ExoTrackSelection[] a(ExoTrackSelection.a[] aVarArr, e eVar, s.a aVar, Timeline timeline) {
            ExoTrackSelection b4;
            ImmutableList B = a.B(aVarArr);
            ExoTrackSelection[] exoTrackSelectionArr = new ExoTrackSelection[aVarArr.length];
            for (int i10 = 0; i10 < aVarArr.length; i10++) {
                ExoTrackSelection.a aVar2 = aVarArr[i10];
                if (aVar2 != null) {
                    int[] iArr = aVar2.f22270b;
                    if (iArr.length != 0) {
                        if (iArr.length == 1) {
                            b4 = new f(aVar2.f22269a, iArr[0], aVar2.f22271c);
                        } else {
                            b4 = b(aVar2.f22269a, iArr, aVar2.f22271c, eVar, (ImmutableList) B.get(i10));
                        }
                        exoTrackSelectionArr[i10] = b4;
                    }
                }
            }
            return exoTrackSelectionArr;
        }

        public a b(TrackGroup trackGroup, int[] iArr, int i10, e eVar, ImmutableList<C0207a> immutableList) {
            return new a(trackGroup, iArr, i10, eVar, this.f22333a, this.f22334b, this.f22335c, this.f22336d, this.f22337e, immutableList, this.f22338f);
        }

        public b(int i10, int i11, int i12, float f10, float f11, Clock clock) {
            this.f22333a = i10;
            this.f22334b = i11;
            this.f22335c = i12;
            this.f22336d = f10;
            this.f22337e = f11;
            this.f22338f = clock;
        }
    }

    public a(TrackGroup trackGroup, int[] iArr, int i10, e eVar, long j10, long j11, long j12, float f10, float f11, List<C0207a> list, Clock clock) {
        super(trackGroup, iArr, i10);
        if (j12 < j10) {
            m.h("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            j12 = j10;
        }
        this.f22318h = eVar;
        this.f22319i = j10 * 1000;
        this.f22320j = j11 * 1000;
        this.f22321k = j12 * 1000;
        this.f22322l = f10;
        this.f22323m = f11;
        this.f22324n = ImmutableList.copyOf((Collection) list);
        this.f22325o = clock;
        this.f22326p = 1.0f;
        this.f22328r = 0;
        this.f22329s = -9223372036854775807L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ImmutableList<ImmutableList<C0207a>> B(ExoTrackSelection.a[] aVarArr) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < aVarArr.length; i10++) {
            if (aVarArr[i10] != null && aVarArr[i10].f22270b.length > 1) {
                ImmutableList.a builder = ImmutableList.builder();
                builder.a(new C0207a(0L, 0L));
                arrayList.add(builder);
            } else {
                arrayList.add(null);
            }
        }
        long[][] G = G(aVarArr);
        int[] iArr = new int[G.length];
        long[] jArr = new long[G.length];
        for (int i11 = 0; i11 < G.length; i11++) {
            jArr[i11] = G[i11].length == 0 ? 0L : G[i11][0];
        }
        y(arrayList, jArr);
        ImmutableList<Integer> H = H(G);
        for (int i12 = 0; i12 < H.size(); i12++) {
            int intValue = H.get(i12).intValue();
            int i13 = iArr[intValue] + 1;
            iArr[intValue] = i13;
            jArr[intValue] = G[intValue][i13];
            y(arrayList, jArr);
        }
        for (int i14 = 0; i14 < aVarArr.length; i14++) {
            if (arrayList.get(i14) != 0) {
                jArr[i14] = jArr[i14] * 2;
            }
        }
        y(arrayList, jArr);
        ImmutableList.a builder2 = ImmutableList.builder();
        for (int i15 = 0; i15 < arrayList.size(); i15++) {
            ImmutableList.a aVar = (ImmutableList.a) arrayList.get(i15);
            builder2.a(aVar == null ? ImmutableList.of() : aVar.k());
        }
        return builder2.k();
    }

    public static long[][] G(ExoTrackSelection.a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length];
        for (int i10 = 0; i10 < aVarArr.length; i10++) {
            ExoTrackSelection.a aVar = aVarArr[i10];
            if (aVar == null) {
                jArr[i10] = new long[0];
            } else {
                jArr[i10] = new long[aVar.f22270b.length];
                int i11 = 0;
                while (true) {
                    if (i11 >= aVar.f22270b.length) {
                        break;
                    }
                    jArr[i10][i11] = aVar.f22269a.a(r5[i11]).f19540i;
                    i11++;
                }
                Arrays.sort(jArr[i10]);
            }
        }
        return jArr;
    }

    public static ImmutableList<Integer> H(long[][] jArr) {
        j0 e2 = MultimapBuilder.c().a().e();
        for (int i10 = 0; i10 < jArr.length; i10++) {
            if (jArr[i10].length > 1) {
                int length = jArr[i10].length;
                double[] dArr = new double[length];
                int i11 = 0;
                while (true) {
                    int length2 = jArr[i10].length;
                    double d10 = ShadowDrawableWrapper.COS_45;
                    if (i11 >= length2) {
                        break;
                    }
                    if (jArr[i10][i11] != -1) {
                        d10 = Math.log(jArr[i10][i11]);
                    }
                    dArr[i11] = d10;
                    i11++;
                }
                int i12 = length - 1;
                double d11 = dArr[i12] - dArr[0];
                int i13 = 0;
                while (i13 < i12) {
                    double d12 = dArr[i13];
                    i13++;
                    e2.put(Double.valueOf(d11 == ShadowDrawableWrapper.COS_45 ? 1.0d : (((d12 + dArr[i13]) * 0.5d) - dArr[0]) / d11), Integer.valueOf(i10));
                }
            }
        }
        return ImmutableList.copyOf(e2.values());
    }

    public static void y(List<ImmutableList.a<C0207a>> list, long[] jArr) {
        long j10 = 0;
        for (long j11 : jArr) {
            j10 += j11;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            ImmutableList.a<C0207a> aVar = list.get(i10);
            if (aVar != null) {
                aVar.a(new C0207a(j10, jArr[i10]));
            }
        }
    }

    public final int A(long j10, long j11) {
        long C = C(j11);
        int i10 = 0;
        for (int i11 = 0; i11 < this.f52131b; i11++) {
            if (j10 == Long.MIN_VALUE || !b(i11, j10)) {
                Format p10 = p(i11);
                if (z(p10, p10.f19540i, C)) {
                    return i11;
                }
                i10 = i11;
            }
        }
        return i10;
    }

    public final long C(long j10) {
        long I = I(j10);
        if (this.f22324n.isEmpty()) {
            return I;
        }
        int i10 = 1;
        while (i10 < this.f22324n.size() - 1 && this.f22324n.get(i10).f22331a < I) {
            i10++;
        }
        C0207a c0207a = this.f22324n.get(i10 - 1);
        C0207a c0207a2 = this.f22324n.get(i10);
        long j11 = c0207a.f22331a;
        float f10 = ((float) (I - j11)) / ((float) (c0207a2.f22331a - j11));
        return c0207a.f22332b + (f10 * ((float) (c0207a2.f22332b - r2)));
    }

    public final long D(List<? extends n> list) {
        if (list.isEmpty()) {
            return -9223372036854775807L;
        }
        n nVar = (n) g0.f(list);
        long j10 = nVar.f54512g;
        if (j10 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j11 = nVar.f54513h;
        if (j11 != -9223372036854775807L) {
            return j11 - j10;
        }
        return -9223372036854775807L;
    }

    public long E() {
        return this.f22321k;
    }

    public final long F(o[] oVarArr, List<? extends n> list) {
        int i10 = this.f22327q;
        if (i10 < oVarArr.length && oVarArr[i10].next()) {
            o oVar = oVarArr[this.f22327q];
            return oVar.a() - oVar.b();
        }
        for (o oVar2 : oVarArr) {
            if (oVar2.next()) {
                return oVar2.a() - oVar2.b();
            }
        }
        return D(list);
    }

    public final long I(long j10) {
        long c4 = ((float) this.f22318h.c()) * this.f22322l;
        if (this.f22318h.f() != -9223372036854775807L && j10 != -9223372036854775807L) {
            float f10 = (float) j10;
            return (((float) c4) * Math.max((f10 / this.f22326p) - ((float) r2), 0.0f)) / f10;
        }
        return ((float) c4) / this.f22326p;
    }

    public final long J(long j10) {
        if (j10 != -9223372036854775807L && j10 <= this.f22319i) {
            return ((float) j10) * this.f22323m;
        }
        return this.f22319i;
    }

    public boolean K(long j10, List<? extends n> list) {
        long j11 = this.f22329s;
        return j11 == -9223372036854775807L || j10 - j11 >= 1000 || !(list.isEmpty() || ((n) g0.f(list)).equals(this.f22330t));
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public int a() {
        return this.f22327q;
    }

    @Override // n6.b, com.google.android.exoplayer2.trackselection.ExoTrackSelection
    @CallSuper
    public void e() {
        this.f22330t = null;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public void i(long j10, long j11, long j12, List<? extends n> list, o[] oVarArr) {
        long a10 = this.f22325o.a();
        long F = F(oVarArr, list);
        int i10 = this.f22328r;
        if (i10 == 0) {
            this.f22328r = 1;
            this.f22327q = A(a10, F);
            return;
        }
        int i11 = this.f22327q;
        int t2 = list.isEmpty() ? -1 : t(((n) g0.f(list)).f54509d);
        if (t2 != -1) {
            i10 = ((n) g0.f(list)).f54510e;
            i11 = t2;
        }
        int A = A(a10, F);
        if (!b(i11, a10)) {
            Format p10 = p(i11);
            Format p11 = p(A);
            if ((p11.f19540i > p10.f19540i && j11 < J(j12)) || (p11.f19540i < p10.f19540i && j11 >= this.f22320j)) {
                A = i11;
            }
        }
        if (A != i11) {
            i10 = 3;
        }
        this.f22328r = i10;
        this.f22327q = A;
    }

    @Override // n6.b, com.google.android.exoplayer2.trackselection.ExoTrackSelection
    @CallSuper
    public void j() {
        this.f22329s = -9223372036854775807L;
        this.f22330t = null;
    }

    @Override // n6.b, com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public int k(long j10, List<? extends n> list) {
        int i10;
        int i11;
        long a10 = this.f22325o.a();
        if (!K(a10, list)) {
            return list.size();
        }
        this.f22329s = a10;
        this.f22330t = list.isEmpty() ? null : (n) g0.f(list);
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long b02 = com.google.android.exoplayer2.util.j0.b0(list.get(size - 1).f54512g - j10, this.f22326p);
        long E = E();
        if (b02 < E) {
            return size;
        }
        Format p10 = p(A(a10, D(list)));
        for (int i12 = 0; i12 < size; i12++) {
            n nVar = list.get(i12);
            Format format = nVar.f54509d;
            if (com.google.android.exoplayer2.util.j0.b0(nVar.f54512g - j10, this.f22326p) >= E && format.f19540i < p10.f19540i && (i10 = format.f19550s) != -1 && i10 < 720 && (i11 = format.f19549r) != -1 && i11 < 1280 && i10 < p10.f19550s) {
                return i12;
            }
        }
        return size;
    }

    @Override // n6.b, com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public void q(float f10) {
        this.f22326p = f10;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    @Nullable
    public Object r() {
        return null;
    }

    @Override // com.google.android.exoplayer2.trackselection.ExoTrackSelection
    public int u() {
        return this.f22328r;
    }

    public boolean z(Format format, int i10, long j10) {
        return ((long) i10) <= j10;
    }
}
