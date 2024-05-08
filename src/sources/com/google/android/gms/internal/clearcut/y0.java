package com.google.android.gms.internal.clearcut;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class y0 extends t<Integer> implements RandomAccess {

    /* renamed from: e, reason: collision with root package name */
    public static final y0 f24106e;

    /* renamed from: c, reason: collision with root package name */
    public int[] f24107c;

    /* renamed from: d, reason: collision with root package name */
    public int f24108d;

    static {
        y0 y0Var = new y0();
        f24106e = y0Var;
        y0Var.k();
    }

    public y0() {
        this(new int[10], 0);
    }

    public y0(int[] iArr, int i10) {
        this.f24107c = iArr;
        this.f24108d = i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i10, Object obj) {
        h(i10, ((Integer) obj).intValue());
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection<? extends Integer> collection) {
        b();
        z0.a(collection);
        if (!(collection instanceof y0)) {
            return super.addAll(collection);
        }
        y0 y0Var = (y0) collection;
        int i10 = y0Var.f24108d;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f24108d;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        int[] iArr = this.f24107c;
        if (i12 > iArr.length) {
            this.f24107c = Arrays.copyOf(iArr, i12);
        }
        System.arraycopy((Object) y0Var.f24107c, 0, (Object) this.f24107c, this.f24108d, y0Var.f24108d);
        this.f24108d = i12;
        this.modCount++;
        return true;
    }

    public final void c(int i10) {
        h(this.f24108d, i10);
    }

    @Override // com.google.android.gms.internal.clearcut.c1
    public final /* synthetic */ c1 d(int i10) {
        if (i10 >= this.f24108d) {
            return new y0(Arrays.copyOf(this.f24107c, i10), this.f24108d);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractList, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y0)) {
            return super.equals(obj);
        }
        y0 y0Var = (y0) obj;
        if (this.f24108d != y0Var.f24108d) {
            return false;
        }
        int[] iArr = y0Var.f24107c;
        for (int i10 = 0; i10 < this.f24108d; i10++) {
            if (this.f24107c[i10] != iArr[i10]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i10) {
        if (i10 < 0 || i10 >= this.f24108d) {
            throw new IndexOutOfBoundsException(g(i10));
        }
    }

    public final String g(int i10) {
        int i11 = this.f24108d;
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append("Index:");
        sb2.append(i10);
        sb2.append(", Size:");
        sb2.append(i11);
        return sb2.toString();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        return Integer.valueOf(getInt(i10));
    }

    public final int getInt(int i10) {
        f(i10);
        return this.f24107c[i10];
    }

    public final void h(int i10, int i11) {
        int i12;
        b();
        if (i10 < 0 || i10 > (i12 = this.f24108d)) {
            throw new IndexOutOfBoundsException(g(i10));
        }
        int[] iArr = this.f24107c;
        if (i12 < iArr.length) {
            System.arraycopy((Object) iArr, i10, (Object) iArr, i10 + 1, i12 - i10);
        } else {
            int[] iArr2 = new int[((i12 * 3) / 2) + 1];
            System.arraycopy((Object) iArr, 0, (Object) iArr2, 0, i10);
            System.arraycopy((Object) this.f24107c, i10, (Object) iArr2, i10 + 1, this.f24108d - i10);
            this.f24107c = iArr2;
        }
        this.f24107c[i10] = i11;
        this.f24108d++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractList, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f24108d; i11++) {
            i10 = (i10 * 31) + this.f24107c[i11];
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i10) {
        b();
        f(i10);
        int[] iArr = this.f24107c;
        int i11 = iArr[i10];
        int i12 = this.f24108d;
        if (i10 < i12 - 1) {
            System.arraycopy((Object) iArr, i10 + 1, (Object) iArr, i10, i12 - i10);
        }
        this.f24108d--;
        this.modCount++;
        return Integer.valueOf(i11);
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        b();
        for (int i10 = 0; i10 < this.f24108d; i10++) {
            if (obj.equals(Integer.valueOf(this.f24107c[i10]))) {
                int[] iArr = this.f24107c;
                System.arraycopy((Object) iArr, i10 + 1, (Object) iArr, i10, this.f24108d - i10);
                this.f24108d--;
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
        int[] iArr = this.f24107c;
        System.arraycopy((Object) iArr, i11, (Object) iArr, i10, this.f24108d - i11);
        this.f24108d -= i11 - i10;
        this.modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i10, Object obj) {
        int intValue = ((Integer) obj).intValue();
        b();
        f(i10);
        int[] iArr = this.f24107c;
        int i11 = iArr[i10];
        iArr[i10] = intValue;
        return Integer.valueOf(i11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f24108d;
    }
}
