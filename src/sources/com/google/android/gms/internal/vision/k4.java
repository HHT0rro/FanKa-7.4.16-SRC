package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class k4 extends p3<Double> implements n6, RandomAccess {

    /* renamed from: e, reason: collision with root package name */
    public static final k4 f25522e;

    /* renamed from: c, reason: collision with root package name */
    public double[] f25523c;

    /* renamed from: d, reason: collision with root package name */
    public int f25524d;

    static {
        k4 k4Var = new k4(new double[0], 0);
        f25522e = k4Var;
        k4Var.zzb();
    }

    public k4() {
        this(new double[10], 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i10, Object obj) {
        int i11;
        double doubleValue = ((Double) obj).doubleValue();
        b();
        if (i10 >= 0 && i10 <= (i11 = this.f25524d)) {
            double[] dArr = this.f25523c;
            if (i11 < dArr.length) {
                System.arraycopy((Object) dArr, i10, (Object) dArr, i10 + 1, i11 - i10);
            } else {
                double[] dArr2 = new double[((i11 * 3) / 2) + 1];
                System.arraycopy((Object) dArr, 0, (Object) dArr2, 0, i10);
                System.arraycopy((Object) this.f25523c, i10, (Object) dArr2, i10 + 1, this.f25524d - i10);
                this.f25523c = dArr2;
            }
            this.f25523c[i10] = doubleValue;
            this.f25524d++;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(g(i10));
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection<? extends Double> collection) {
        b();
        b5.d(collection);
        if (!(collection instanceof k4)) {
            return super.addAll(collection);
        }
        k4 k4Var = (k4) collection;
        int i10 = k4Var.f25524d;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f25524d;
        if (Integer.MAX_VALUE - i11 >= i10) {
            int i12 = i11 + i10;
            double[] dArr = this.f25523c;
            if (i12 > dArr.length) {
                this.f25523c = Arrays.copyOf(dArr, i12);
            }
            System.arraycopy((Object) k4Var.f25523c, 0, (Object) this.f25523c, this.f25524d, k4Var.f25524d);
            this.f25524d = i12;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void c(double d10) {
        b();
        int i10 = this.f25524d;
        double[] dArr = this.f25523c;
        if (i10 == dArr.length) {
            double[] dArr2 = new double[((i10 * 3) / 2) + 1];
            System.arraycopy((Object) dArr, 0, (Object) dArr2, 0, i10);
            this.f25523c = dArr2;
        }
        double[] dArr3 = this.f25523c;
        int i11 = this.f25524d;
        this.f25524d = i11 + 1;
        dArr3[i11] = d10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractList, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k4)) {
            return super.equals(obj);
        }
        k4 k4Var = (k4) obj;
        if (this.f25524d != k4Var.f25524d) {
            return false;
        }
        double[] dArr = k4Var.f25523c;
        for (int i10 = 0; i10 < this.f25524d; i10++) {
            if (Double.doubleToLongBits(this.f25523c[i10]) != Double.doubleToLongBits(dArr[i10])) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i10) {
        if (i10 < 0 || i10 >= this.f25524d) {
            throw new IndexOutOfBoundsException(g(i10));
        }
    }

    public final String g(int i10) {
        int i11 = this.f25524d;
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append("Index:");
        sb2.append(i10);
        sb2.append(", Size:");
        sb2.append(i11);
        return sb2.toString();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        f(i10);
        return Double.valueOf(this.f25523c[i10]);
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractList, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f25524d; i11++) {
            i10 = (i10 * 31) + b5.b(Double.doubleToLongBits(this.f25523c[i11]));
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f25523c[i10] == doubleValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i10) {
        b();
        f(i10);
        double[] dArr = this.f25523c;
        double d10 = dArr[i10];
        if (i10 < this.f25524d - 1) {
            System.arraycopy((Object) dArr, i10 + 1, (Object) dArr, i10, (r3 - i10) - 1);
        }
        this.f25524d--;
        this.modCount++;
        return Double.valueOf(d10);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i10, int i11) {
        b();
        if (i11 >= i10) {
            double[] dArr = this.f25523c;
            System.arraycopy((Object) dArr, i11, (Object) dArr, i10, this.f25524d - i11);
            this.f25524d -= i11 - i10;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i10, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        b();
        f(i10);
        double[] dArr = this.f25523c;
        double d10 = dArr[i10];
        dArr[i10] = doubleValue;
        return Double.valueOf(d10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f25524d;
    }

    @Override // com.google.android.gms.internal.vision.g5
    public final /* synthetic */ g5 zza(int i10) {
        if (i10 >= this.f25524d) {
            return new k4(Arrays.copyOf(this.f25523c, i10), this.f25524d);
        }
        throw new IllegalArgumentException();
    }

    public k4(double[] dArr, int i10) {
        this.f25523c = dArr;
        this.f25524d = i10;
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* synthetic */ boolean add(Object obj) {
        c(((Double) obj).doubleValue());
        return true;
    }
}
