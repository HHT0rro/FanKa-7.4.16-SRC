package com.google.android.exoplayer2.source.smoothstreaming;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.g;
import com.google.android.exoplayer2.source.m0;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.smoothstreaming.b;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.a;
import com.google.android.exoplayer2.source.z;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.h;
import java.io.IOException;
import java.util.ArrayList;
import o6.r;
import o6.v;
import x5.i;

/* compiled from: SsMediaPeriod.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c implements p, m0.a<i<b>> {

    /* renamed from: b, reason: collision with root package name */
    public final b.a f22055b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final v f22056c;

    /* renamed from: d, reason: collision with root package name */
    public final r f22057d;

    /* renamed from: e, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.c f22058e;

    /* renamed from: f, reason: collision with root package name */
    public final b.a f22059f;

    /* renamed from: g, reason: collision with root package name */
    public final h f22060g;

    /* renamed from: h, reason: collision with root package name */
    public final z.a f22061h;

    /* renamed from: i, reason: collision with root package name */
    public final o6.b f22062i;

    /* renamed from: j, reason: collision with root package name */
    public final TrackGroupArray f22063j;

    /* renamed from: k, reason: collision with root package name */
    public final g f22064k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public p.a f22065l;

    /* renamed from: m, reason: collision with root package name */
    public com.google.android.exoplayer2.source.smoothstreaming.manifest.a f22066m;

    /* renamed from: n, reason: collision with root package name */
    public i<b>[] f22067n;

    /* renamed from: o, reason: collision with root package name */
    public m0 f22068o;

    public c(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, b.a aVar2, @Nullable v vVar, g gVar, com.google.android.exoplayer2.drm.c cVar, b.a aVar3, h hVar, z.a aVar4, r rVar, o6.b bVar) {
        this.f22066m = aVar;
        this.f22055b = aVar2;
        this.f22056c = vVar;
        this.f22057d = rVar;
        this.f22058e = cVar;
        this.f22059f = aVar3;
        this.f22060g = hVar;
        this.f22061h = aVar4;
        this.f22062i = bVar;
        this.f22064k = gVar;
        this.f22063j = c(aVar, cVar);
        i<b>[] o10 = o(0);
        this.f22067n = o10;
        this.f22068o = gVar.a(o10);
    }

    public static TrackGroupArray c(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar, com.google.android.exoplayer2.drm.c cVar) {
        TrackGroup[] trackGroupArr = new TrackGroup[aVar.f22106f.length];
        int i10 = 0;
        while (true) {
            a.b[] bVarArr = aVar.f22106f;
            if (i10 < bVarArr.length) {
                Format[] formatArr = bVarArr[i10].f22121j;
                Format[] formatArr2 = new Format[formatArr.length];
                for (int i11 = 0; i11 < formatArr.length; i11++) {
                    Format format = formatArr[i11];
                    formatArr2[i11] = format.b(cVar.c(format));
                }
                trackGroupArr[i10] = new TrackGroup(formatArr2);
                i10++;
            } else {
                return new TrackGroupArray(trackGroupArr);
            }
        }
    }

    public static i<b>[] o(int i10) {
        return new i[i10];
    }

    public final i<b> a(ExoTrackSelection exoTrackSelection, long j10) {
        int b4 = this.f22063j.b(exoTrackSelection.g());
        return new i<>(this.f22066m.f22106f[b4].f22112a, null, null, this.f22055b.a(this.f22057d, this.f22066m, b4, exoTrackSelection, this.f22056c), this, this.f22062i, j10, this.f22058e, this.f22059f, this.f22060g, this.f22061h);
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public boolean b(long j10) {
        return this.f22068o.b(j10);
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public long d() {
        return this.f22068o.d();
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public void e(long j10) {
        this.f22068o.e(j10);
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public long f() {
        return this.f22068o.f();
    }

    @Override // com.google.android.exoplayer2.source.p
    public long g(long j10, p1 p1Var) {
        for (i<b> iVar : this.f22067n) {
            if (iVar.f54517b == 2) {
                return iVar.g(j10, p1Var);
            }
        }
        return j10;
    }

    @Override // com.google.android.exoplayer2.source.p
    public long h(long j10) {
        for (i<b> iVar : this.f22067n) {
            iVar.Q(j10);
        }
        return j10;
    }

    @Override // com.google.android.exoplayer2.source.p
    public long i() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.p, com.google.android.exoplayer2.source.m0
    public boolean isLoading() {
        return this.f22068o.isLoading();
    }

    @Override // com.google.android.exoplayer2.source.p
    public long j(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j10) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < exoTrackSelectionArr.length; i10++) {
            if (sampleStreamArr[i10] != null) {
                i iVar = (i) sampleStreamArr[i10];
                if (exoTrackSelectionArr[i10] != null && zArr[i10]) {
                    ((b) iVar.C()).b(exoTrackSelectionArr[i10]);
                    arrayList.add(iVar);
                } else {
                    iVar.N();
                    sampleStreamArr[i10] = null;
                }
            }
            if (sampleStreamArr[i10] == null && exoTrackSelectionArr[i10] != null) {
                i<b> a10 = a(exoTrackSelectionArr[i10], j10);
                arrayList.add(a10);
                sampleStreamArr[i10] = a10;
                zArr2[i10] = true;
            }
        }
        i<b>[] o10 = o(arrayList.size());
        this.f22067n = o10;
        arrayList.toArray(o10);
        this.f22068o = this.f22064k.a(this.f22067n);
        return j10;
    }

    @Override // com.google.android.exoplayer2.source.p
    public TrackGroupArray m() {
        return this.f22063j;
    }

    @Override // com.google.android.exoplayer2.source.p
    public void p(p.a aVar, long j10) {
        this.f22065l = aVar;
        aVar.n(this);
    }

    @Override // com.google.android.exoplayer2.source.m0.a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void k(i<b> iVar) {
        this.f22065l.k(this);
    }

    public void r() {
        for (i<b> iVar : this.f22067n) {
            iVar.N();
        }
        this.f22065l = null;
    }

    @Override // com.google.android.exoplayer2.source.p
    public void s() throws IOException {
        this.f22057d.a();
    }

    @Override // com.google.android.exoplayer2.source.p
    public void t(long j10, boolean z10) {
        for (i<b> iVar : this.f22067n) {
            iVar.t(j10, z10);
        }
    }

    public void u(com.google.android.exoplayer2.source.smoothstreaming.manifest.a aVar) {
        this.f22066m = aVar;
        for (i<b> iVar : this.f22067n) {
            iVar.C().e(aVar);
        }
        this.f22065l.k(this);
    }
}
