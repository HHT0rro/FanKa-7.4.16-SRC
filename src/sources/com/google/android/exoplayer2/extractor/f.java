package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.util.j0;
import d5.o;

/* compiled from: FlacSeekTableSeekMap.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f implements i {

    /* renamed from: a, reason: collision with root package name */
    public final g f20046a;

    /* renamed from: b, reason: collision with root package name */
    public final long f20047b;

    public f(g gVar, long j10) {
        this.f20046a = gVar;
        this.f20047b = j10;
    }

    public final o a(long j10, long j11) {
        return new o((j10 * 1000000) / this.f20046a.f20063e, this.f20047b + j11);
    }

    @Override // com.google.android.exoplayer2.extractor.i
    public i.a d(long j10) {
        com.google.android.exoplayer2.util.a.i(this.f20046a.f20069k);
        g gVar = this.f20046a;
        g.a aVar = gVar.f20069k;
        long[] jArr = aVar.f20071a;
        long[] jArr2 = aVar.f20072b;
        int i10 = j0.i(jArr, gVar.j(j10), true, false);
        o a10 = a(i10 == -1 ? 0L : jArr[i10], i10 != -1 ? jArr2[i10] : 0L);
        if (a10.f48644a != j10 && i10 != jArr.length - 1) {
            int i11 = i10 + 1;
            return new i.a(a10, a(jArr[i11], jArr2[i11]));
        }
        return new i.a(a10);
    }

    @Override // com.google.android.exoplayer2.extractor.i
    public boolean e() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.i
    public long i() {
        return this.f20046a.g();
    }
}
