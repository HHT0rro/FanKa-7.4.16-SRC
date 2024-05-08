package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.util.j0;
import d5.o;

/* compiled from: IndexSeekMap.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h implements i {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f20073a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f20074b;

    /* renamed from: c, reason: collision with root package name */
    public final long f20075c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f20076d;

    public h(long[] jArr, long[] jArr2, long j10) {
        com.google.android.exoplayer2.util.a.a(jArr.length == jArr2.length);
        int length = jArr2.length;
        boolean z10 = length > 0;
        this.f20076d = z10;
        if (z10 && jArr2[0] > 0) {
            int i10 = length + 1;
            long[] jArr3 = new long[i10];
            this.f20073a = jArr3;
            long[] jArr4 = new long[i10];
            this.f20074b = jArr4;
            System.arraycopy((Object) jArr, 0, (Object) jArr3, 1, length);
            System.arraycopy((Object) jArr2, 0, (Object) jArr4, 1, length);
        } else {
            this.f20073a = jArr;
            this.f20074b = jArr2;
        }
        this.f20075c = j10;
    }

    @Override // com.google.android.exoplayer2.extractor.i
    public i.a d(long j10) {
        if (!this.f20076d) {
            return new i.a(o.f48643c);
        }
        int i10 = j0.i(this.f20074b, j10, true, true);
        o oVar = new o(this.f20074b[i10], this.f20073a[i10]);
        if (oVar.f48644a != j10 && i10 != this.f20074b.length - 1) {
            int i11 = i10 + 1;
            return new i.a(oVar, new o(this.f20074b[i11], this.f20073a[i11]));
        }
        return new i.a(oVar);
    }

    @Override // com.google.android.exoplayer2.extractor.i
    public boolean e() {
        return this.f20076d;
    }

    @Override // com.google.android.exoplayer2.extractor.i
    public long i() {
        return this.f20075c;
    }
}
