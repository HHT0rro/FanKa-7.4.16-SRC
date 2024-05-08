package com.google.android.gms.internal.clearcut;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class p1 extends t<Long> implements RandomAccess {

    /* renamed from: e, reason: collision with root package name */
    public static final p1 f23977e;

    /* renamed from: c, reason: collision with root package name */
    public long[] f23978c;

    /* renamed from: d, reason: collision with root package name */
    public int f23979d;

    static {
        p1 p1Var = new p1();
        f23977e = p1Var;
        p1Var.k();
    }

    public p1() {
        this(new long[10], 0);
    }

    public p1(long[] jArr, int i10) {
        this.f23978c = jArr;
        this.f23979d = i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i10, Object obj) {
        g(i10, ((Long) obj).longValue());
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection<? extends Long> collection) {
        b();
        z0.a(collection);
        if (!(collection instanceof p1)) {
            return super.addAll(collection);
        }
        p1 p1Var = (p1) collection;
        int i10 = p1Var.f23979d;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f23979d;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        long[] jArr = this.f23978c;
        if (i12 > jArr.length) {
            this.f23978c = Arrays.copyOf(jArr, i12);
        }
        System.arraycopy((Object) p1Var.f23978c, 0, (Object) this.f23978c, this.f23979d, p1Var.f23979d);
        this.f23979d = i12;
        this.modCount++;
        return true;
    }

    public final void c(int i10) {
        if (i10 < 0 || i10 >= this.f23979d) {
            throw new IndexOutOfBoundsException(f(i10));
        }
    }

    @Override // com.google.android.gms.internal.clearcut.c1
    public final /* synthetic */ c1 d(int i10) {
        if (i10 >= this.f23979d) {
            return new p1(Arrays.copyOf(this.f23978c, i10), this.f23979d);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractList, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p1)) {
            return super.equals(obj);
        }
        p1 p1Var = (p1) obj;
        if (this.f23979d != p1Var.f23979d) {
            return false;
        }
        long[] jArr = p1Var.f23978c;
        for (int i10 = 0; i10 < this.f23979d; i10++) {
            if (this.f23978c[i10] != jArr[i10]) {
                return false;
            }
        }
        return true;
    }

    public final String f(int i10) {
        int i11 = this.f23979d;
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append("Index:");
        sb2.append(i10);
        sb2.append(", Size:");
        sb2.append(i11);
        return sb2.toString();
    }

    public final void g(int i10, long j10) {
        int i11;
        b();
        if (i10 < 0 || i10 > (i11 = this.f23979d)) {
            throw new IndexOutOfBoundsException(f(i10));
        }
        long[] jArr = this.f23978c;
        if (i11 < jArr.length) {
            System.arraycopy((Object) jArr, i10, (Object) jArr, i10 + 1, i11 - i10);
        } else {
            long[] jArr2 = new long[((i11 * 3) / 2) + 1];
            System.arraycopy((Object) jArr, 0, (Object) jArr2, 0, i10);
            System.arraycopy((Object) this.f23978c, i10, (Object) jArr2, i10 + 1, this.f23979d - i10);
            this.f23978c = jArr2;
        }
        this.f23978c[i10] = j10;
        this.f23979d++;
        this.modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        return Long.valueOf(getLong(i10));
    }

    public final long getLong(int i10) {
        c(i10);
        return this.f23978c[i10];
    }

    public final void h(long j10) {
        g(this.f23979d, j10);
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractList, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f23979d; i11++) {
            i10 = (i10 * 31) + z0.j(this.f23978c[i11]);
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i10) {
        b();
        c(i10);
        long[] jArr = this.f23978c;
        long j10 = jArr[i10];
        int i11 = this.f23979d;
        if (i10 < i11 - 1) {
            System.arraycopy((Object) jArr, i10 + 1, (Object) jArr, i10, i11 - i10);
        }
        this.f23979d--;
        this.modCount++;
        return Long.valueOf(j10);
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        b();
        for (int i10 = 0; i10 < this.f23979d; i10++) {
            if (obj.equals(Long.valueOf(this.f23978c[i10]))) {
                long[] jArr = this.f23978c;
                System.arraycopy((Object) jArr, i10 + 1, (Object) jArr, i10, this.f23979d - i10);
                this.f23979d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i10, int i11) {
        b();
        if (i11 < i10) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f23978c;
        System.arraycopy((Object) jArr, i11, (Object) jArr, i10, this.f23979d - i11);
        this.f23979d -= i11 - i10;
        this.modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i10, Object obj) {
        long longValue = ((Long) obj).longValue();
        b();
        c(i10);
        long[] jArr = this.f23978c;
        long j10 = jArr[i10];
        jArr[i10] = longValue;
        return Long.valueOf(j10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f23979d;
    }
}
