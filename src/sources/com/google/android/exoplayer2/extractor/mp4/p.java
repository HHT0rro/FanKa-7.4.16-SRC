package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.j0;

/* compiled from: TrackSampleTable.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final n f20258a;

    /* renamed from: b, reason: collision with root package name */
    public final int f20259b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f20260c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f20261d;

    /* renamed from: e, reason: collision with root package name */
    public final int f20262e;

    /* renamed from: f, reason: collision with root package name */
    public final long[] f20263f;

    /* renamed from: g, reason: collision with root package name */
    public final int[] f20264g;

    /* renamed from: h, reason: collision with root package name */
    public final long f20265h;

    public p(n nVar, long[] jArr, int[] iArr, int i10, long[] jArr2, int[] iArr2, long j10) {
        com.google.android.exoplayer2.util.a.a(iArr.length == jArr2.length);
        com.google.android.exoplayer2.util.a.a(jArr.length == jArr2.length);
        com.google.android.exoplayer2.util.a.a(iArr2.length == jArr2.length);
        this.f20258a = nVar;
        this.f20260c = jArr;
        this.f20261d = iArr;
        this.f20262e = i10;
        this.f20263f = jArr2;
        this.f20264g = iArr2;
        this.f20265h = j10;
        this.f20259b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public int a(long j10) {
        for (int i10 = j0.i(this.f20263f, j10, true, false); i10 >= 0; i10--) {
            if ((this.f20264g[i10] & 1) != 0) {
                return i10;
            }
        }
        return -1;
    }

    public int b(long j10) {
        for (int e2 = j0.e(this.f20263f, j10, true, false); e2 < this.f20263f.length; e2++) {
            if ((this.f20264g[e2] & 1) != 0) {
                return e2;
            }
        }
        return -1;
    }
}
