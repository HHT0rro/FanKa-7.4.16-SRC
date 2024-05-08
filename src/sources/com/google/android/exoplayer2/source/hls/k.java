package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.p;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.b;
import com.google.android.exoplayer2.source.m0;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.z;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.h;
import com.google.android.exoplayer2.util.j0;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import o6.v;

/* compiled from: HlsMediaPeriod.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class k implements com.google.android.exoplayer2.source.p, p.b, HlsPlaylistTracker.b {

    /* renamed from: b, reason: collision with root package name */
    public final g f21548b;

    /* renamed from: c, reason: collision with root package name */
    public final HlsPlaylistTracker f21549c;

    /* renamed from: d, reason: collision with root package name */
    public final f f21550d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final v f21551e;

    /* renamed from: f, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.c f21552f;

    /* renamed from: g, reason: collision with root package name */
    public final b.a f21553g;

    /* renamed from: h, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.h f21554h;

    /* renamed from: i, reason: collision with root package name */
    public final z.a f21555i;

    /* renamed from: j, reason: collision with root package name */
    public final o6.b f21556j;

    /* renamed from: m, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.g f21559m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f21560n;

    /* renamed from: o, reason: collision with root package name */
    public final int f21561o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f21562p;

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public p.a f21563q;

    /* renamed from: r, reason: collision with root package name */
    public int f21564r;

    /* renamed from: s, reason: collision with root package name */
    public TrackGroupArray f21565s;

    /* renamed from: w, reason: collision with root package name */
    public int f21569w;

    /* renamed from: x, reason: collision with root package name */
    public m0 f21570x;

    /* renamed from: k, reason: collision with root package name */
    public final IdentityHashMap<SampleStream, Integer> f21557k = new IdentityHashMap<>();

    /* renamed from: l, reason: collision with root package name */
    public final q f21558l = new q();

    /* renamed from: t, reason: collision with root package name */
    public p[] f21566t = new p[0];

    /* renamed from: u, reason: collision with root package name */
    public p[] f21567u = new p[0];

    /* renamed from: v, reason: collision with root package name */
    public int[][] f21568v = new int[0];

    public k(g gVar, HlsPlaylistTracker hlsPlaylistTracker, f fVar, @Nullable v vVar, com.google.android.exoplayer2.drm.c cVar, b.a aVar, com.google.android.exoplayer2.upstream.h hVar, z.a aVar2, o6.b bVar, com.google.android.exoplayer2.source.g gVar2, boolean z10, int i10, boolean z11) {
        this.f21548b = gVar;
        this.f21549c = hlsPlaylistTracker;
        this.f21550d = fVar;
        this.f21551e = vVar;
        this.f21552f = cVar;
        this.f21553g = aVar;
        this.f21554h = hVar;
        this.f21555i = aVar2;
        this.f21556j = bVar;
        this.f21559m = gVar2;
        this.f21560n = z10;
        this.f21561o = i10;
        this.f21562p = z11;
        this.f21570x = gVar2.a(new m0[0]);
    }

    public static Format v(Format format, @Nullable Format format2, boolean z10) {
        String str;
        Metadata metadata;
        int i10;
        int i11;
        int i12;
        String str2;
        String str3;
        if (format2 != null) {
            str2 = format2.f19541j;
            metadata = format2.f19542k;
            int i13 = format2.f19557z;
            i11 = format2.f19536e;
            int i14 = format2.f19537f;
            String str4 = format2.f19535d;
            str3 = format2.f19534c;
            i12 = i13;
            i10 = i14;
            str = str4;
        } else {
            String K = j0.K(format.f19541j, 1);
            Metadata metadata2 = format.f19542k;
            if (z10) {
                int i15 = format.f19557z;
                int i16 = format.f19536e;
                int i17 = format.f19537f;
                str = format.f19535d;
                str2 = K;
                str3 = format.f19534c;
                i12 = i15;
                i11 = i16;
                metadata = metadata2;
                i10 = i17;
            } else {
                str = null;
                metadata = metadata2;
                i10 = 0;
                i11 = 0;
                i12 = -1;
                str2 = K;
                str3 = null;
            }
        }
        return new Format.b().S(format.f19533b).U(str3).K(format.f19543l).e0(com.google.android.exoplayer2.util.q.g(str2)).I(str2).X(metadata).G(z10 ? format.f19538g : -1).Z(z10 ? format.f19539h : -1).H(i12).g0(i11).c0(i10).V(str).E();
    }

    public static Map<String, DrmInitData> w(List<DrmInitData> list) {
        ArrayList arrayList = new ArrayList(list);
        HashMap hashMap = new HashMap();
        int i10 = 0;
        while (i10 < arrayList.size()) {
            DrmInitData drmInitData = list.get(i10);
            String str = drmInitData.schemeType;
            i10++;
            int i11 = i10;
            while (i11 < arrayList.size()) {
                DrmInitData drmInitData2 = (DrmInitData) arrayList.get(i11);
                if (TextUtils.equals(drmInitData2.schemeType, str)) {
                    drmInitData = drmInitData.merge(drmInitData2);
                    arrayList.remove(i11);
                } else {
                    i11++;
                }
            }
            hashMap.put(str, drmInitData);
        }
        return hashMap;
    }

    public static Format x(Format format) {
        String K = j0.K(format.f19541j, 2);
        return new Format.b().S(format.f19533b).U(format.f19534c).K(format.f19543l).e0(com.google.android.exoplayer2.util.q.g(K)).I(K).X(format.f19542k).G(format.f19538g).Z(format.f19539h).j0(format.f19549r).Q(format.f19550s).P(format.f19551t).g0(format.f19536e).c0(format.f19537f).E();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
    public void a() {
        for (p pVar : this.f21566t) {
            pVar.Z();
        }
        this.f21563q.k(this);
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public boolean b(long j10) {
        if (this.f21565s == null) {
            for (p pVar : this.f21566t) {
                pVar.A();
            }
            return false;
        }
        return this.f21570x.b(j10);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
    public boolean c(Uri uri, h.c cVar, boolean z10) {
        boolean z11 = true;
        for (p pVar : this.f21566t) {
            z11 &= pVar.Y(uri, cVar, z10);
        }
        this.f21563q.k(this);
        return z11;
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public long d() {
        return this.f21570x.d();
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public void e(long j10) {
        this.f21570x.e(j10);
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public long f() {
        return this.f21570x.f();
    }

    @Override // com.google.android.exoplayer2.source.p
    public long g(long j10, p1 p1Var) {
        return j10;
    }

    @Override // com.google.android.exoplayer2.source.p
    public long h(long j10) {
        p[] pVarArr = this.f21567u;
        if (pVarArr.length > 0) {
            boolean g02 = pVarArr[0].g0(j10, false);
            int i10 = 1;
            while (true) {
                p[] pVarArr2 = this.f21567u;
                if (i10 >= pVarArr2.length) {
                    break;
                }
                pVarArr2[i10].g0(j10, g02);
                i10++;
            }
            if (g02) {
                this.f21558l.b();
            }
        }
        return j10;
    }

    @Override // com.google.android.exoplayer2.source.p
    public long i() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public boolean isLoading() {
        return this.f21570x.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.p
    public long j(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j10) {
        SampleStream[] sampleStreamArr2 = sampleStreamArr;
        int[] iArr = new int[exoTrackSelectionArr.length];
        int[] iArr2 = new int[exoTrackSelectionArr.length];
        for (int i10 = 0; i10 < exoTrackSelectionArr.length; i10++) {
            iArr[i10] = sampleStreamArr2[i10] == null ? -1 : this.f21557k.get(sampleStreamArr2[i10]).intValue();
            iArr2[i10] = -1;
            if (exoTrackSelectionArr[i10] != null) {
                TrackGroup g3 = exoTrackSelectionArr[i10].g();
                int i11 = 0;
                while (true) {
                    p[] pVarArr = this.f21566t;
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
        this.f21557k.clear();
        int length = exoTrackSelectionArr.length;
        SampleStream[] sampleStreamArr3 = new SampleStream[length];
        SampleStream[] sampleStreamArr4 = new SampleStream[exoTrackSelectionArr.length];
        ExoTrackSelection[] exoTrackSelectionArr2 = new ExoTrackSelection[exoTrackSelectionArr.length];
        p[] pVarArr2 = new p[this.f21566t.length];
        int i12 = 0;
        int i13 = 0;
        boolean z10 = false;
        while (i13 < this.f21566t.length) {
            for (int i14 = 0; i14 < exoTrackSelectionArr.length; i14++) {
                ExoTrackSelection exoTrackSelection = null;
                sampleStreamArr4[i14] = iArr[i14] == i13 ? sampleStreamArr2[i14] : null;
                if (iArr2[i14] == i13) {
                    exoTrackSelection = exoTrackSelectionArr[i14];
                }
                exoTrackSelectionArr2[i14] = exoTrackSelection;
            }
            p pVar = this.f21566t[i13];
            int i15 = i12;
            int i16 = length;
            int i17 = i13;
            ExoTrackSelection[] exoTrackSelectionArr3 = exoTrackSelectionArr2;
            p[] pVarArr3 = pVarArr2;
            boolean h02 = pVar.h0(exoTrackSelectionArr2, zArr, sampleStreamArr4, zArr2, j10, z10);
            int i18 = 0;
            boolean z11 = false;
            while (true) {
                if (i18 >= exoTrackSelectionArr.length) {
                    break;
                }
                SampleStream sampleStream = sampleStreamArr4[i18];
                if (iArr2[i18] == i17) {
                    com.google.android.exoplayer2.util.a.e(sampleStream);
                    sampleStreamArr3[i18] = sampleStream;
                    this.f21557k.put(sampleStream, Integer.valueOf(i17));
                    z11 = true;
                } else if (iArr[i18] == i17) {
                    com.google.android.exoplayer2.util.a.g(sampleStream == null);
                }
                i18++;
            }
            if (z11) {
                pVarArr3[i15] = pVar;
                i12 = i15 + 1;
                if (i15 == 0) {
                    pVar.k0(true);
                    if (!h02) {
                        p[] pVarArr4 = this.f21567u;
                        if (pVarArr4.length != 0 && pVar == pVarArr4[0]) {
                        }
                    }
                    this.f21558l.b();
                    z10 = true;
                } else {
                    pVar.k0(i17 < this.f21569w);
                }
            } else {
                i12 = i15;
            }
            i13 = i17 + 1;
            sampleStreamArr2 = sampleStreamArr;
            pVarArr2 = pVarArr3;
            length = i16;
            exoTrackSelectionArr2 = exoTrackSelectionArr3;
        }
        System.arraycopy(sampleStreamArr3, 0, sampleStreamArr2, 0, length);
        p[] pVarArr5 = (p[]) j0.A0(pVarArr2, i12);
        this.f21567u = pVarArr5;
        this.f21570x = this.f21559m.a(pVarArr5);
        return j10;
    }

    @Override // com.google.android.exoplayer2.source.hls.p.b
    public void l(Uri uri) {
        this.f21549c.f(uri);
    }

    @Override // com.google.android.exoplayer2.source.p
    public TrackGroupArray m() {
        return (TrackGroupArray) com.google.android.exoplayer2.util.a.e(this.f21565s);
    }

    public final void o(long j10, List<b.a> list, List<p> list2, List<int[]> list3, Map<String, DrmInitData> map) {
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        ArrayList arrayList3 = new ArrayList(list.size());
        HashSet hashSet = new HashSet();
        for (int i10 = 0; i10 < list.size(); i10++) {
            String str = list.get(i10).f21683d;
            if (hashSet.add(str)) {
                arrayList.clear();
                arrayList2.clear();
                arrayList3.clear();
                boolean z10 = true;
                for (int i11 = 0; i11 < list.size(); i11++) {
                    if (j0.c(str, list.get(i11).f21683d)) {
                        b.a aVar = list.get(i11);
                        arrayList3.add(Integer.valueOf(i11));
                        arrayList.add(aVar.f21680a);
                        arrayList2.add(aVar.f21681b);
                        z10 &= j0.J(aVar.f21681b.f19541j, 1) == 1;
                    }
                }
                p u10 = u(1, (Uri[]) arrayList.toArray((Uri[]) j0.k(new Uri[0])), (Format[]) arrayList2.toArray(new Format[0]), null, Collections.emptyList(), map, j10);
                list3.add(Ints.m(arrayList3));
                list2.add(u10);
                if (this.f21560n && z10) {
                    u10.b0(new TrackGroup[]{new TrackGroup((Format[]) arrayList2.toArray(new Format[0]))}, 0, new int[0]);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.p.b
    public void onPrepared() {
        int i10 = this.f21564r - 1;
        this.f21564r = i10;
        if (i10 > 0) {
            return;
        }
        int i11 = 0;
        for (p pVar : this.f21566t) {
            i11 += pVar.m().f21172b;
        }
        TrackGroup[] trackGroupArr = new TrackGroup[i11];
        int i12 = 0;
        for (p pVar2 : this.f21566t) {
            int i13 = pVar2.m().f21172b;
            int i14 = 0;
            while (i14 < i13) {
                trackGroupArr[i12] = pVar2.m().a(i14);
                i14++;
                i12++;
            }
        }
        this.f21565s = new TrackGroupArray(trackGroupArr);
        this.f21563q.n(this);
    }

    @Override // com.google.android.exoplayer2.source.p
    public void p(p.a aVar, long j10) {
        this.f21563q = aVar;
        this.f21549c.g(this);
        r(j10);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void q(com.google.android.exoplayer2.source.hls.playlist.b r20, long r21, java.util.List<com.google.android.exoplayer2.source.hls.p> r23, java.util.List<int[]> r24, java.util.Map<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData> r25) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.k.q(com.google.android.exoplayer2.source.hls.playlist.b, long, java.util.List, java.util.List, java.util.Map):void");
    }

    public final void r(long j10) {
        Map<String, DrmInitData> emptyMap;
        com.google.android.exoplayer2.source.hls.playlist.b bVar = (com.google.android.exoplayer2.source.hls.playlist.b) com.google.android.exoplayer2.util.a.e(this.f21549c.c());
        if (this.f21562p) {
            emptyMap = w(bVar.f21679m);
        } else {
            emptyMap = Collections.emptyMap();
        }
        Map<String, DrmInitData> map = emptyMap;
        boolean z10 = !bVar.f21671e.isEmpty();
        List<b.a> list = bVar.f21673g;
        List<b.a> list2 = bVar.f21674h;
        this.f21564r = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (z10) {
            q(bVar, j10, arrayList, arrayList2, map);
        }
        o(j10, list, arrayList, arrayList2, map);
        this.f21569w = arrayList.size();
        int i10 = 0;
        while (i10 < list2.size()) {
            b.a aVar = list2.get(i10);
            int i11 = i10;
            p u10 = u(3, new Uri[]{aVar.f21680a}, new Format[]{aVar.f21681b}, null, Collections.emptyList(), map, j10);
            arrayList2.add(new int[]{i11});
            arrayList.add(u10);
            u10.b0(new TrackGroup[]{new TrackGroup(aVar.f21681b)}, 0, new int[0]);
            i10 = i11 + 1;
        }
        this.f21566t = (p[]) arrayList.toArray(new p[0]);
        this.f21568v = (int[][]) arrayList2.toArray(new int[0]);
        p[] pVarArr = this.f21566t;
        this.f21564r = pVarArr.length;
        pVarArr[0].k0(true);
        for (p pVar : this.f21566t) {
            pVar.A();
        }
        this.f21567u = this.f21566t;
    }

    @Override // com.google.android.exoplayer2.source.p
    public void s() throws IOException {
        for (p pVar : this.f21566t) {
            pVar.s();
        }
    }

    @Override // com.google.android.exoplayer2.source.p
    public void t(long j10, boolean z10) {
        for (p pVar : this.f21567u) {
            pVar.t(j10, z10);
        }
    }

    public final p u(int i10, Uri[] uriArr, Format[] formatArr, @Nullable Format format, @Nullable List<Format> list, Map<String, DrmInitData> map, long j10) {
        return new p(i10, this, new e(this.f21548b, this.f21549c, uriArr, formatArr, this.f21550d, this.f21551e, this.f21558l, list), map, this.f21556j, j10, format, this.f21552f, this.f21553g, this.f21554h, this.f21555i, this.f21561o);
    }

    @Override // com.google.android.exoplayer2.source.m0.a
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void k(p pVar) {
        this.f21563q.k(this);
    }

    public void z() {
        this.f21549c.a(this);
        for (p pVar : this.f21566t) {
            pVar.d0();
        }
        this.f21563q = null;
    }
}
