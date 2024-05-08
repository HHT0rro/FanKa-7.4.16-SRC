package com.google.android.gms.internal.clearcut;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class j0 extends t<Double> implements RandomAccess {

    /* renamed from: e, reason: collision with root package name */
    public static final j0 f23919e;

    /* renamed from: c, reason: collision with root package name */
    public double[] f23920c;

    /* renamed from: d, reason: collision with root package name */
    public int f23921d;

    static {
        j0 j0Var = new j0();
        f23919e = j0Var;
        j0Var.k();
    }

    public j0() {
        this(new double[10], 0);
    }

    public j0(double[] dArr, int i10) {
        this.f23920c = dArr;
        this.f23921d = i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i10, Object obj) {
        f(i10, ((Double) obj).doubleValue());
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection<? extends Double> collection) {
        b();
        z0.a(collection);
        if (!(collection instanceof j0)) {
            return super.addAll(collection);
        }
        j0 j0Var = (j0) collection;
        int i10 = j0Var.f23921d;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f23921d;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        double[] dArr = this.f23920c;
        if (i12 > dArr.length) {
            this.f23920c = Arrays.copyOf(dArr, i12);
        }
        System.arraycopy((Object) j0Var.f23920c, 0, (Object) this.f23920c, this.f23921d, j0Var.f23921d);
        this.f23921d = i12;
        this.modCount++;
        return true;
    }

    public final void c(double d10) {
        f(this.f23921d, d10);
    }

    @Override // com.google.android.gms.internal.clearcut.c1
    public final /* synthetic */ c1 d(int i10) {
        if (i10 >= this.f23921d) {
            return new j0(Arrays.copyOf(this.f23920c, i10), this.f23921d);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractList, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j0)) {
            return super.equals(obj);
        }
        j0 j0Var = (j0) obj;
        if (this.f23921d != j0Var.f23921d) {
            return false;
        }
        double[] dArr = j0Var.f23920c;
        for (int i10 = 0; i10 < this.f23921d; i10++) {
            if (this.f23920c[i10] != dArr[i10]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i10, double d10) {
        int i11;
        b();
        if (i10 < 0 || i10 > (i11 = this.f23921d)) {
            throw new IndexOutOfBoundsException(h(i10));
        }
        double[] dArr = this.f23920c;
        if (i11 < dArr.length) {
            System.arraycopy((Object) dArr, i10, (Object) dArr, i10 + 1, i11 - i10);
        } else {
            double[] dArr2 = new double[((i11 * 3) / 2) + 1];
            System.arraycopy((Object) dArr, 0, (Object) dArr2, 0, i10);
            System.arraycopy((Object) this.f23920c, i10, (Object) dArr2, i10 + 1, this.f23921d - i10);
            this.f23920c = dArr2;
        }
        this.f23920c[i10] = d10;
        this.f23921d++;
        this.modCount++;
    }

    public final void g(int i10) {
        if (i10 < 0 || i10 >= this.f23921d) {
            throw new IndexOutOfBoundsException(h(i10));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        g(i10);
        return Double.valueOf(this.f23920c[i10]);
    }

    public final String h(int i10) {
        int i11 = this.f23921d;
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append("Index:");
        sb2.append(i10);
        sb2.append(", Size:");
        sb2.append(i11);
        return sb2.toString();
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractList, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f23921d; i11++) {
            i10 = (i10 * 31) + z0.j(Double.doubleToLongBits(this.f23920c[i11]));
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i10) {
        b();
        g(i10);
        double[] dArr = this.f23920c;
        double d10 = dArr[i10];
        int i11 = this.f23921d;
        if (i10 < i11 - 1) {
            System.arraycopy((Object) dArr, i10 + 1, (Object) dArr, i10, i11 - i10);
        }
        this.f23921d--;
        this.modCount++;
        return Double.valueOf(d10);
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        b();
        for (int i10 = 0; i10 < this.f23921d; i10++) {
            if (obj.equals(Double.valueOf(this.f23920c[i10]))) {
                double[] dArr = this.f23920c;
                System.arraycopy((Object) dArr, i10 + 1, (Object) dArr, i10, this.f23921d - i10);
                this.f23921d--;
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
        double[] dArr = this.f23920c;
        System.arraycopy((Object) dArr, i11, (Object) dArr, i10, this.f23921d - i11);
        this.f23921d -= i11 - i10;
        this.modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i10, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        b();
        g(i10);
        double[] dArr = this.f23920c;
        double d10 = dArr[i10];
        dArr[i10] = doubleValue;
        return Double.valueOf(d10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f23921d;
    }
}
