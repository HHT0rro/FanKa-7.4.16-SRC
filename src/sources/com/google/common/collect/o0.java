package com.google.common.collect;

import java.util.Arrays;

/* compiled from: ObjectCountLinkedHashMap.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class o0<K> extends n0<K> {

    /* renamed from: i, reason: collision with root package name */
    public transient long[] f26604i;

    /* renamed from: j, reason: collision with root package name */
    public transient int f26605j;

    /* renamed from: k, reason: collision with root package name */
    public transient int f26606k;

    public o0(int i10) {
        this(i10, 1.0f);
    }

    public final int E(int i10) {
        return (int) (this.f26604i[i10] >>> 32);
    }

    public final int F(int i10) {
        return (int) this.f26604i[i10];
    }

    public final void G(int i10, int i11) {
        long[] jArr = this.f26604i;
        jArr[i10] = (jArr[i10] & 4294967295L) | (i11 << 32);
    }

    public final void H(int i10, int i11) {
        if (i10 == -2) {
            this.f26605j = i11;
        } else {
            I(i10, i11);
        }
        if (i11 == -2) {
            this.f26606k = i10;
        } else {
            G(i11, i10);
        }
    }

    public final void I(int i10, int i11) {
        long[] jArr = this.f26604i;
        jArr[i10] = (jArr[i10] & (-4294967296L)) | (i11 & 4294967295L);
    }

    @Override // com.google.common.collect.n0
    public void a() {
        super.a();
        this.f26605j = -2;
        this.f26606k = -2;
    }

    @Override // com.google.common.collect.n0
    public int e() {
        int i10 = this.f26605j;
        if (i10 == -2) {
            return -1;
        }
        return i10;
    }

    @Override // com.google.common.collect.n0
    public void n(int i10, float f10) {
        super.n(i10, f10);
        this.f26605j = -2;
        this.f26606k = -2;
        long[] jArr = new long[i10];
        this.f26604i = jArr;
        Arrays.fill(jArr, -1L);
    }

    @Override // com.google.common.collect.n0
    public void o(int i10, K k10, int i11, int i12) {
        super.o(i10, k10, i11, i12);
        H(this.f26606k, i10);
        H(i10, -2);
    }

    @Override // com.google.common.collect.n0
    public void p(int i10) {
        int C = C() - 1;
        H(E(i10), F(i10));
        if (i10 < C) {
            H(E(C), i10);
            H(i10, F(C));
        }
        super.p(i10);
    }

    @Override // com.google.common.collect.n0
    public int s(int i10) {
        int F = F(i10);
        if (F == -2) {
            return -1;
        }
        return F;
    }

    @Override // com.google.common.collect.n0
    public int t(int i10, int i11) {
        return i10 == C() ? i11 : i10;
    }

    @Override // com.google.common.collect.n0
    public void y(int i10) {
        super.y(i10);
        long[] jArr = this.f26604i;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i10);
        this.f26604i = copyOf;
        Arrays.fill(copyOf, length, i10, -1L);
    }

    public o0(int i10, float f10) {
        super(i10, f10);
    }
}
