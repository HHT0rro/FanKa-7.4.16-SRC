package com.google.android.exoplayer2.source.dash;

import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.dash.d;
import com.google.android.exoplayer2.source.g;
import com.google.android.exoplayer2.source.m0;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.z;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.h;
import com.google.android.exoplayer2.util.j0;
import com.google.common.primitives.Ints;
import com.huawei.openalliance.ad.constant.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import o6.r;
import o6.v;
import x5.i;
import z5.e;
import z5.f;
import z5.j;

/* compiled from: DashMediaPeriod.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b implements p, m0.a<i<com.google.android.exoplayer2.source.dash.a>>, i.b<com.google.android.exoplayer2.source.dash.a> {

    /* renamed from: y, reason: collision with root package name */
    public static final Pattern f21295y = Pattern.compile("CC([1-4])=(.+)");

    /* renamed from: z, reason: collision with root package name */
    public static final Pattern f21296z = Pattern.compile("([1-4])=lang:(\\w+)(,.+)?");

    /* renamed from: b, reason: collision with root package name */
    public final int f21297b;

    /* renamed from: c, reason: collision with root package name */
    public final a.InterfaceC0194a f21298c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final v f21299d;

    /* renamed from: e, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.c f21300e;

    /* renamed from: f, reason: collision with root package name */
    public final h f21301f;

    /* renamed from: g, reason: collision with root package name */
    public final y5.b f21302g;

    /* renamed from: h, reason: collision with root package name */
    public final long f21303h;

    /* renamed from: i, reason: collision with root package name */
    public final r f21304i;

    /* renamed from: j, reason: collision with root package name */
    public final o6.b f21305j;

    /* renamed from: k, reason: collision with root package name */
    public final TrackGroupArray f21306k;

    /* renamed from: l, reason: collision with root package name */
    public final a[] f21307l;

    /* renamed from: m, reason: collision with root package name */
    public final g f21308m;

    /* renamed from: n, reason: collision with root package name */
    public final d f21309n;

    /* renamed from: p, reason: collision with root package name */
    public final z.a f21311p;

    /* renamed from: q, reason: collision with root package name */
    public final b.a f21312q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public p.a f21313r;

    /* renamed from: u, reason: collision with root package name */
    public m0 f21316u;

    /* renamed from: v, reason: collision with root package name */
    public z5.c f21317v;

    /* renamed from: w, reason: collision with root package name */
    public int f21318w;

    /* renamed from: x, reason: collision with root package name */
    public List<f> f21319x;

    /* renamed from: s, reason: collision with root package name */
    public i<com.google.android.exoplayer2.source.dash.a>[] f21314s = D(0);

    /* renamed from: t, reason: collision with root package name */
    public y5.h[] f21315t = new y5.h[0];

    /* renamed from: o, reason: collision with root package name */
    public final IdentityHashMap<i<com.google.android.exoplayer2.source.dash.a>, d.c> f21310o = new IdentityHashMap<>();

    /* compiled from: DashMediaPeriod.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f21320a;

        /* renamed from: b, reason: collision with root package name */
        public final int f21321b;

        /* renamed from: c, reason: collision with root package name */
        public final int f21322c;

        /* renamed from: d, reason: collision with root package name */
        public final int f21323d;

        /* renamed from: e, reason: collision with root package name */
        public final int f21324e;

        /* renamed from: f, reason: collision with root package name */
        public final int f21325f;

        /* renamed from: g, reason: collision with root package name */
        public final int f21326g;

        public a(int i10, int i11, int[] iArr, int i12, int i13, int i14, int i15) {
            this.f21321b = i10;
            this.f21320a = iArr;
            this.f21322c = i11;
            this.f21324e = i12;
            this.f21325f = i13;
            this.f21326g = i14;
            this.f21323d = i15;
        }

        public static a a(int[] iArr, int i10) {
            return new a(3, 1, iArr, i10, -1, -1, -1);
        }

        public static a b(int[] iArr, int i10) {
            return new a(5, 1, iArr, i10, -1, -1, -1);
        }

        public static a c(int i10) {
            return new a(5, 2, new int[0], -1, -1, -1, i10);
        }

        public static a d(int i10, int[] iArr, int i11, int i12, int i13) {
            return new a(i10, 0, iArr, i11, i12, i13, -1);
        }
    }

    public b(int i10, z5.c cVar, y5.b bVar, int i11, a.InterfaceC0194a interfaceC0194a, @Nullable v vVar, com.google.android.exoplayer2.drm.c cVar2, b.a aVar, h hVar, z.a aVar2, long j10, r rVar, o6.b bVar2, g gVar, d.b bVar3) {
        this.f21297b = i10;
        this.f21317v = cVar;
        this.f21302g = bVar;
        this.f21318w = i11;
        this.f21298c = interfaceC0194a;
        this.f21299d = vVar;
        this.f21300e = cVar2;
        this.f21312q = aVar;
        this.f21301f = hVar;
        this.f21311p = aVar2;
        this.f21303h = j10;
        this.f21304i = rVar;
        this.f21305j = bVar2;
        this.f21308m = gVar;
        this.f21309n = new d(cVar, bVar3, bVar2);
        this.f21316u = gVar.a(this.f21314s);
        z5.g d10 = cVar.d(i11);
        List<f> list = d10.f54925d;
        this.f21319x = list;
        Pair<TrackGroupArray, a[]> r10 = r(cVar2, d10.f54924c, list);
        this.f21306k = (TrackGroupArray) r10.first;
        this.f21307l = (a[]) r10.second;
    }

    public static boolean B(List<z5.a> list, int[] iArr) {
        for (int i10 : iArr) {
            List<j> list2 = list.get(i10).f54881c;
            for (int i11 = 0; i11 < list2.size(); i11++) {
                if (!list2.get(i11).f54940e.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int C(int i10, List<z5.a> list, int[][] iArr, boolean[] zArr, Format[][] formatArr) {
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            if (B(list, iArr[i12])) {
                zArr[i12] = true;
                i11++;
            }
            formatArr[i12] = x(list, iArr[i12]);
            if (formatArr[i12].length != 0) {
                i11++;
            }
        }
        return i11;
    }

    public static i<com.google.android.exoplayer2.source.dash.a>[] D(int i10) {
        return new i[i10];
    }

    public static Format[] F(e eVar, Pattern pattern, Format format) {
        String str = eVar.f54915b;
        if (str == null) {
            return new Format[]{format};
        }
        String[] M0 = j0.M0(str, ";");
        Format[] formatArr = new Format[M0.length];
        for (int i10 = 0; i10 < M0.length; i10++) {
            Matcher matcher = pattern.matcher(M0[i10]);
            if (!matcher.matches()) {
                return new Format[]{format};
            }
            int parseInt = Integer.parseInt(matcher.group(1));
            Format.b a10 = format.a();
            String str2 = format.f19533b;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 12);
            sb2.append(str2);
            sb2.append(u.bD);
            sb2.append(parseInt);
            formatArr[i10] = a10.S(sb2.toString()).F(parseInt).V(matcher.group(2)).E();
        }
        return formatArr;
    }

    public static void c(List<f> list, TrackGroup[] trackGroupArr, a[] aVarArr, int i10) {
        int i11 = 0;
        while (i11 < list.size()) {
            trackGroupArr[i10] = new TrackGroup(new Format.b().S(list.get(i11).a()).e0("application/x-emsg").E());
            aVarArr[i10] = a.c(i11);
            i11++;
            i10++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int o(com.google.android.exoplayer2.drm.c cVar, List<z5.a> list, int[][] iArr, int i10, boolean[] zArr, Format[][] formatArr, TrackGroup[] trackGroupArr, a[] aVarArr) {
        int i11;
        int i12;
        int i13 = 0;
        int i14 = 0;
        while (i13 < i10) {
            int[] iArr2 = iArr[i13];
            ArrayList arrayList = new ArrayList();
            for (int i15 : iArr2) {
                arrayList.addAll(list.get(i15).f54881c);
            }
            int size = arrayList.size();
            Format[] formatArr2 = new Format[size];
            for (int i16 = 0; i16 < size; i16++) {
                Format format = ((j) arrayList.get(i16)).f54937b;
                formatArr2[i16] = format.b(cVar.c(format));
            }
            z5.a aVar = list.get(iArr2[0]);
            int i17 = i14 + 1;
            if (zArr[i13]) {
                i11 = i17 + 1;
            } else {
                i11 = i17;
                i17 = -1;
            }
            if (formatArr[i13].length != 0) {
                i12 = i11 + 1;
            } else {
                i12 = i11;
                i11 = -1;
            }
            trackGroupArr[i14] = new TrackGroup(formatArr2);
            aVarArr[i14] = a.d(aVar.f54880b, iArr2, i14, i17, i11);
            if (i17 != -1) {
                Format.b bVar = new Format.b();
                int i18 = aVar.f54879a;
                StringBuilder sb2 = new StringBuilder(16);
                sb2.append(i18);
                sb2.append(":emsg");
                trackGroupArr[i17] = new TrackGroup(bVar.S(sb2.toString()).e0("application/x-emsg").E());
                aVarArr[i17] = a.b(iArr2, i14);
            }
            if (i11 != -1) {
                trackGroupArr[i11] = new TrackGroup(formatArr[i13]);
                aVarArr[i11] = a.a(iArr2, i14);
            }
            i13++;
            i14 = i12;
        }
        return i14;
    }

    public static Pair<TrackGroupArray, a[]> r(com.google.android.exoplayer2.drm.c cVar, List<z5.a> list, List<f> list2) {
        int[][] y10 = y(list);
        int length = y10.length;
        boolean[] zArr = new boolean[length];
        Format[][] formatArr = new Format[length];
        int C = C(length, list, y10, zArr, formatArr) + length + list2.size();
        TrackGroup[] trackGroupArr = new TrackGroup[C];
        a[] aVarArr = new a[C];
        c(list2, trackGroupArr, aVarArr, o(cVar, list, y10, length, zArr, formatArr, trackGroupArr, aVarArr));
        return Pair.create(new TrackGroupArray(trackGroupArr), aVarArr);
    }

    @Nullable
    public static e u(List<e> list) {
        return v(list, "urn:mpeg:dash:adaptation-set-switching:2016");
    }

    @Nullable
    public static e v(List<e> list, String str) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            e eVar = list.get(i10);
            if (str.equals(eVar.f54914a)) {
                return eVar;
            }
        }
        return null;
    }

    @Nullable
    public static e w(List<e> list) {
        return v(list, "http://dashif.org/guidelines/trickmode");
    }

    public static Format[] x(List<z5.a> list, int[] iArr) {
        for (int i10 : iArr) {
            z5.a aVar = list.get(i10);
            List<e> list2 = list.get(i10).f54882d;
            for (int i11 = 0; i11 < list2.size(); i11++) {
                e eVar = list2.get(i11);
                if ("urn:scte:dash:cc:cea-608:2015".equals(eVar.f54914a)) {
                    Format.b e02 = new Format.b().e0("application/cea-608");
                    int i12 = aVar.f54879a;
                    StringBuilder sb2 = new StringBuilder(18);
                    sb2.append(i12);
                    sb2.append(":cea608");
                    return F(eVar, f21295y, e02.S(sb2.toString()).E());
                }
                if ("urn:scte:dash:cc:cea-708:2015".equals(eVar.f54914a)) {
                    Format.b e03 = new Format.b().e0("application/cea-708");
                    int i13 = aVar.f54879a;
                    StringBuilder sb3 = new StringBuilder(18);
                    sb3.append(i13);
                    sb3.append(":cea708");
                    return F(eVar, f21296z, e03.S(sb3.toString()).E());
                }
            }
        }
        return new Format[0];
    }

    public static int[][] y(List<z5.a> list) {
        int i10;
        e u10;
        int size = list.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        ArrayList arrayList = new ArrayList(size);
        SparseArray sparseArray = new SparseArray(size);
        for (int i11 = 0; i11 < size; i11++) {
            sparseIntArray.put(list.get(i11).f54879a, i11);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Integer.valueOf(i11));
            arrayList.add(arrayList2);
            sparseArray.put(i11, arrayList2);
        }
        for (int i12 = 0; i12 < size; i12++) {
            z5.a aVar = list.get(i12);
            e w3 = w(aVar.f54883e);
            if (w3 == null) {
                w3 = w(aVar.f54884f);
            }
            if (w3 == null || (i10 = sparseIntArray.get(Integer.parseInt(w3.f54915b), -1)) == -1) {
                i10 = i12;
            }
            if (i10 == i12 && (u10 = u(aVar.f54884f)) != null) {
                for (String str : j0.M0(u10.f54915b, ",")) {
                    int i13 = sparseIntArray.get(Integer.parseInt(str), -1);
                    if (i13 != -1) {
                        i10 = Math.min(i10, i13);
                    }
                }
            }
            if (i10 != i12) {
                List list2 = (List) sparseArray.get(i12);
                List list3 = (List) sparseArray.get(i10);
                list3.addAll(list2);
                sparseArray.put(i12, list3);
                arrayList.remove(list2);
            }
        }
        int size2 = arrayList.size();
        int[][] iArr = new int[size2];
        for (int i14 = 0; i14 < size2; i14++) {
            iArr[i14] = Ints.m((Collection) arrayList.get(i14));
            Arrays.sort(iArr[i14]);
        }
        return iArr;
    }

    public final int[] A(ExoTrackSelection[] exoTrackSelectionArr) {
        int[] iArr = new int[exoTrackSelectionArr.length];
        for (int i10 = 0; i10 < exoTrackSelectionArr.length; i10++) {
            if (exoTrackSelectionArr[i10] != null) {
                iArr[i10] = this.f21306k.b(exoTrackSelectionArr[i10].g());
            } else {
                iArr[i10] = -1;
            }
        }
        return iArr;
    }

    @Override // com.google.android.exoplayer2.source.m0.a
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void k(i<com.google.android.exoplayer2.source.dash.a> iVar) {
        this.f21313r.k(this);
    }

    public void G() {
        this.f21309n.o();
        for (i<com.google.android.exoplayer2.source.dash.a> iVar : this.f21314s) {
            iVar.O(this);
        }
        this.f21313r = null;
    }

    public final void H(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr) {
        for (int i10 = 0; i10 < exoTrackSelectionArr.length; i10++) {
            if (exoTrackSelectionArr[i10] == null || !zArr[i10]) {
                if (sampleStreamArr[i10] instanceof i) {
                    ((i) sampleStreamArr[i10]).O(this);
                } else if (sampleStreamArr[i10] instanceof i.a) {
                    ((i.a) sampleStreamArr[i10]).d();
                }
                sampleStreamArr[i10] = null;
            }
        }
    }

    public final void I(ExoTrackSelection[] exoTrackSelectionArr, SampleStream[] sampleStreamArr, int[] iArr) {
        boolean z10;
        for (int i10 = 0; i10 < exoTrackSelectionArr.length; i10++) {
            if ((sampleStreamArr[i10] instanceof com.google.android.exoplayer2.source.j) || (sampleStreamArr[i10] instanceof i.a)) {
                int z11 = z(i10, iArr);
                if (z11 == -1) {
                    z10 = sampleStreamArr[i10] instanceof com.google.android.exoplayer2.source.j;
                } else {
                    z10 = (sampleStreamArr[i10] instanceof i.a) && ((i.a) sampleStreamArr[i10]).f54540b == sampleStreamArr[z11];
                }
                if (!z10) {
                    if (sampleStreamArr[i10] instanceof i.a) {
                        ((i.a) sampleStreamArr[i10]).d();
                    }
                    sampleStreamArr[i10] = null;
                }
            }
        }
    }

    public final void J(ExoTrackSelection[] exoTrackSelectionArr, SampleStream[] sampleStreamArr, boolean[] zArr, long j10, int[] iArr) {
        for (int i10 = 0; i10 < exoTrackSelectionArr.length; i10++) {
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i10];
            if (exoTrackSelection != null) {
                if (sampleStreamArr[i10] == null) {
                    zArr[i10] = true;
                    a aVar = this.f21307l[iArr[i10]];
                    int i11 = aVar.f21322c;
                    if (i11 == 0) {
                        sampleStreamArr[i10] = q(aVar, exoTrackSelection, j10);
                    } else if (i11 == 2) {
                        sampleStreamArr[i10] = new y5.h(this.f21319x.get(aVar.f21323d), exoTrackSelection.g().a(0), this.f21317v.f54892d);
                    }
                } else if (sampleStreamArr[i10] instanceof i) {
                    ((com.google.android.exoplayer2.source.dash.a) ((i) sampleStreamArr[i10]).C()).b(exoTrackSelection);
                }
            }
        }
        for (int i12 = 0; i12 < exoTrackSelectionArr.length; i12++) {
            if (sampleStreamArr[i12] == null && exoTrackSelectionArr[i12] != null) {
                a aVar2 = this.f21307l[iArr[i12]];
                if (aVar2.f21322c == 1) {
                    int z10 = z(i12, iArr);
                    if (z10 == -1) {
                        sampleStreamArr[i12] = new com.google.android.exoplayer2.source.j();
                    } else {
                        sampleStreamArr[i12] = ((i) sampleStreamArr[z10]).R(j10, aVar2.f21321b);
                    }
                }
            }
        }
    }

    public void K(z5.c cVar, int i10) {
        this.f21317v = cVar;
        this.f21318w = i10;
        this.f21309n.q(cVar);
        i<com.google.android.exoplayer2.source.dash.a>[] iVarArr = this.f21314s;
        if (iVarArr != null) {
            for (i<com.google.android.exoplayer2.source.dash.a> iVar : iVarArr) {
                iVar.C().i(cVar, i10);
            }
            this.f21313r.k(this);
        }
        this.f21319x = cVar.d(i10).f54925d;
        for (y5.h hVar : this.f21315t) {
            Iterator<f> iterator2 = this.f21319x.iterator2();
            while (true) {
                if (iterator2.hasNext()) {
                    f next = iterator2.next();
                    if (next.a().equals(hVar.b())) {
                        hVar.e(next, cVar.f54892d && i10 == cVar.e() - 1);
                    }
                }
            }
        }
    }

    @Override // x5.i.b
    public synchronized void a(i<com.google.android.exoplayer2.source.dash.a> iVar) {
        d.c remove = this.f21310o.remove(iVar);
        if (remove != null) {
            remove.n();
        }
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public boolean b(long j10) {
        return this.f21316u.b(j10);
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public long d() {
        return this.f21316u.d();
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public void e(long j10) {
        this.f21316u.e(j10);
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public long f() {
        return this.f21316u.f();
    }

    @Override // com.google.android.exoplayer2.source.p
    public long g(long j10, p1 p1Var) {
        for (i<com.google.android.exoplayer2.source.dash.a> iVar : this.f21314s) {
            if (iVar.f54517b == 2) {
                return iVar.g(j10, p1Var);
            }
        }
        return j10;
    }

    @Override // com.google.android.exoplayer2.source.p
    public long h(long j10) {
        for (i<com.google.android.exoplayer2.source.dash.a> iVar : this.f21314s) {
            iVar.Q(j10);
        }
        for (y5.h hVar : this.f21315t) {
            hVar.d(j10);
        }
        return j10;
    }

    @Override // com.google.android.exoplayer2.source.p
    public long i() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public boolean isLoading() {
        return this.f21316u.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.p
    public long j(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j10) {
        int[] A = A(exoTrackSelectionArr);
        H(exoTrackSelectionArr, zArr, sampleStreamArr);
        I(exoTrackSelectionArr, sampleStreamArr, A);
        J(exoTrackSelectionArr, sampleStreamArr, zArr2, j10, A);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (SampleStream sampleStream : sampleStreamArr) {
            if (sampleStream instanceof i) {
                arrayList.add((i) sampleStream);
            } else if (sampleStream instanceof y5.h) {
                arrayList2.add((y5.h) sampleStream);
            }
        }
        i<com.google.android.exoplayer2.source.dash.a>[] D = D(arrayList.size());
        this.f21314s = D;
        arrayList.toArray(D);
        y5.h[] hVarArr = new y5.h[arrayList2.size()];
        this.f21315t = hVarArr;
        arrayList2.toArray(hVarArr);
        this.f21316u = this.f21308m.a(this.f21314s);
        return j10;
    }

    @Override // com.google.android.exoplayer2.source.p
    public TrackGroupArray m() {
        return this.f21306k;
    }

    @Override // com.google.android.exoplayer2.source.p
    public void p(p.a aVar, long j10) {
        this.f21313r = aVar;
        aVar.n(this);
    }

    public final i<com.google.android.exoplayer2.source.dash.a> q(a aVar, ExoTrackSelection exoTrackSelection, long j10) {
        TrackGroup trackGroup;
        int i10;
        TrackGroup trackGroup2;
        int i11;
        int i12 = aVar.f21325f;
        boolean z10 = i12 != -1;
        d.c cVar = null;
        if (z10) {
            trackGroup = this.f21306k.a(i12);
            i10 = 1;
        } else {
            trackGroup = null;
            i10 = 0;
        }
        int i13 = aVar.f21326g;
        boolean z11 = i13 != -1;
        if (z11) {
            trackGroup2 = this.f21306k.a(i13);
            i10 += trackGroup2.f21168b;
        } else {
            trackGroup2 = null;
        }
        Format[] formatArr = new Format[i10];
        int[] iArr = new int[i10];
        if (z10) {
            formatArr[0] = trackGroup.a(0);
            iArr[0] = 5;
            i11 = 1;
        } else {
            i11 = 0;
        }
        ArrayList arrayList = new ArrayList();
        if (z11) {
            for (int i14 = 0; i14 < trackGroup2.f21168b; i14++) {
                formatArr[i11] = trackGroup2.a(i14);
                iArr[i11] = 3;
                arrayList.add(formatArr[i11]);
                i11++;
            }
        }
        if (this.f21317v.f54892d && z10) {
            cVar = this.f21309n.k();
        }
        d.c cVar2 = cVar;
        i<com.google.android.exoplayer2.source.dash.a> iVar = new i<>(aVar.f21321b, iArr, formatArr, this.f21298c.a(this.f21304i, this.f21317v, this.f21302g, this.f21318w, aVar.f21320a, exoTrackSelection, aVar.f21321b, this.f21303h, z10, arrayList, cVar2, this.f21299d), this, this.f21305j, j10, this.f21300e, this.f21312q, this.f21301f, this.f21311p);
        synchronized (this) {
            this.f21310o.put(iVar, cVar2);
        }
        return iVar;
    }

    @Override // com.google.android.exoplayer2.source.p
    public void s() throws IOException {
        this.f21304i.a();
    }

    @Override // com.google.android.exoplayer2.source.p
    public void t(long j10, boolean z10) {
        for (i<com.google.android.exoplayer2.source.dash.a> iVar : this.f21314s) {
            iVar.t(j10, z10);
        }
    }

    public final int z(int i10, int[] iArr) {
        int i11 = iArr[i10];
        if (i11 == -1) {
            return -1;
        }
        int i12 = this.f21307l[i11].f21324e;
        for (int i13 = 0; i13 < iArr.length; i13++) {
            int i14 = iArr[i13];
            if (i14 == i12 && this.f21307l[i14].f21322c == 0) {
                return i13;
            }
        }
        return -1;
    }
}
