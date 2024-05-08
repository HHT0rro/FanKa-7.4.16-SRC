package com.google.android.exoplayer2.util;

import java.util.Arrays;

/* compiled from: LongArray.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public int f23010a;

    /* renamed from: b, reason: collision with root package name */
    public long[] f23011b;

    public n() {
        this(32);
    }

    public void a(long j10) {
        int i10 = this.f23010a;
        long[] jArr = this.f23011b;
        if (i10 == jArr.length) {
            this.f23011b = Arrays.copyOf(jArr, i10 * 2);
        }
        long[] jArr2 = this.f23011b;
        int i11 = this.f23010a;
        this.f23010a = i11 + 1;
        jArr2[i11] = j10;
    }

    public long b(int i10) {
        if (i10 >= 0 && i10 < this.f23010a) {
            return this.f23011b[i10];
        }
        int i11 = this.f23010a;
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append("Invalid index ");
        sb2.append(i10);
        sb2.append(", size is ");
        sb2.append(i11);
        throw new IndexOutOfBoundsException(sb2.toString());
    }

    public int c() {
        return this.f23010a;
    }

    public long[] d() {
        return Arrays.copyOf(this.f23011b, this.f23010a);
    }

    public n(int i10) {
        this.f23011b = new long[i10];
    }
}
