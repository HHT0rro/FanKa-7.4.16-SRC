package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.util.j0;
import d5.o;
import java.util.Arrays;

/* compiled from: ChunkIndex.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b implements i {

    /* renamed from: a, reason: collision with root package name */
    public final int f20032a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f20033b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f20034c;

    /* renamed from: d, reason: collision with root package name */
    public final long[] f20035d;

    /* renamed from: e, reason: collision with root package name */
    public final long[] f20036e;

    /* renamed from: f, reason: collision with root package name */
    public final long f20037f;

    public b(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f20033b = iArr;
        this.f20034c = jArr;
        this.f20035d = jArr2;
        this.f20036e = jArr3;
        int length = iArr.length;
        this.f20032a = length;
        if (length > 0) {
            this.f20037f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f20037f = 0L;
        }
    }

    public int a(long j10) {
        return j0.i(this.f20036e, j10, true, true);
    }

    @Override // com.google.android.exoplayer2.extractor.i
    public i.a d(long j10) {
        int a10 = a(j10);
        o oVar = new o(this.f20036e[a10], this.f20034c[a10]);
        if (oVar.f48644a < j10 && a10 != this.f20032a - 1) {
            int i10 = a10 + 1;
            return new i.a(oVar, new o(this.f20036e[i10], this.f20034c[i10]));
        }
        return new i.a(oVar);
    }

    @Override // com.google.android.exoplayer2.extractor.i
    public boolean e() {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.i
    public long i() {
        return this.f20037f;
    }

    public String toString() {
        int i10 = this.f20032a;
        String arrays = Arrays.toString(this.f20033b);
        String arrays2 = Arrays.toString(this.f20034c);
        String arrays3 = Arrays.toString(this.f20036e);
        String arrays4 = Arrays.toString(this.f20035d);
        StringBuilder sb2 = new StringBuilder(String.valueOf(arrays).length() + 71 + String.valueOf(arrays2).length() + String.valueOf(arrays3).length() + String.valueOf(arrays4).length());
        sb2.append("ChunkIndex(length=");
        sb2.append(i10);
        sb2.append(", sizes=");
        sb2.append(arrays);
        sb2.append(", offsets=");
        sb2.append(arrays2);
        sb2.append(", timeUs=");
        sb2.append(arrays3);
        sb2.append(", durationsUs=");
        sb2.append(arrays4);
        sb2.append(")");
        return sb2.toString();
    }
}
