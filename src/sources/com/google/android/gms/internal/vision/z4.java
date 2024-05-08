package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class z4 extends p3<Integer> implements n6, RandomAccess {

    /* renamed from: e, reason: collision with root package name */
    public static final z4 f25711e;

    /* renamed from: c, reason: collision with root package name */
    public int[] f25712c;

    /* renamed from: d, reason: collision with root package name */
    public int f25713d;

    static {
        z4 z4Var = new z4(new int[0], 0);
        f25711e = z4Var;
        z4Var.zzb();
    }

    public z4() {
        this(new int[10], 0);
    }

    public static z4 g() {
        return f25711e;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i10, Object obj) {
        int i11;
        int intValue = ((Integer) obj).intValue();
        b();
        if (i10 >= 0 && i10 <= (i11 = this.f25713d)) {
            int[] iArr = this.f25712c;
            if (i11 < iArr.length) {
                System.arraycopy((Object) iArr, i10, (Object) iArr, i10 + 1, i11 - i10);
            } else {
                int[] iArr2 = new int[((i11 * 3) / 2) + 1];
                System.arraycopy((Object) iArr, 0, (Object) iArr2, 0, i10);
                System.arraycopy((Object) this.f25712c, i10, (Object) iArr2, i10 + 1, this.f25713d - i10);
                this.f25712c = iArr2;
            }
            this.f25712c[i10] = intValue;
            this.f25713d++;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(i(i10));
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection<? extends Integer> collection) {
        b();
        b5.d(collection);
        if (!(collection instanceof z4)) {
            return super.addAll(collection);
        }
        z4 z4Var = (z4) collection;
        int i10 = z4Var.f25713d;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f25713d;
        if (Integer.MAX_VALUE - i11 >= i10) {
            int i12 = i11 + i10;
            int[] iArr = this.f25712c;
            if (i12 > iArr.length) {
                this.f25712c = Arrays.copyOf(iArr, i12);
            }
            System.arraycopy((Object) z4Var.f25712c, 0, (Object) this.f25712c, this.f25713d, z4Var.f25713d);
            this.f25713d = i12;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final int c(int i10) {
        h(i10);
        return this.f25712c[i10];
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
        if (!(obj instanceof z4)) {
            return super.equals(obj);
        }
        z4 z4Var = (z4) obj;
        if (this.f25713d != z4Var.f25713d) {
            return false;
        }
        int[] iArr = z4Var.f25712c;
        for (int i10 = 0; i10 < this.f25713d; i10++) {
            if (this.f25712c[i10] != iArr[i10]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i10) {
        b();
        int i11 = this.f25713d;
        int[] iArr = this.f25712c;
        if (i11 == iArr.length) {
            int[] iArr2 = new int[((i11 * 3) / 2) + 1];
            System.arraycopy((Object) iArr, 0, (Object) iArr2, 0, i11);
            this.f25712c = iArr2;
        }
        int[] iArr3 = this.f25712c;
        int i12 = this.f25713d;
        this.f25713d = i12 + 1;
        iArr3[i12] = i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        return Integer.valueOf(c(i10));
    }

    public final void h(int i10) {
        if (i10 < 0 || i10 >= this.f25713d) {
            throw new IndexOutOfBoundsException(i(i10));
        }
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractList, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f25713d; i11++) {
            i10 = (i10 * 31) + this.f25712c[i11];
        }
        return i10;
    }

    public final String i(int i10) {
        int i11 = this.f25713d;
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append("Index:");
        sb2.append(i10);
        sb2.append(", Size:");
        sb2.append(i11);
        return sb2.toString();
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f25712c[i10] == intValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i10) {
        b();
        h(i10);
        int[] iArr = this.f25712c;
        int i11 = iArr[i10];
        if (i10 < this.f25713d - 1) {
            System.arraycopy((Object) iArr, i10 + 1, (Object) iArr, i10, (r2 - i10) - 1);
        }
        this.f25713d--;
        this.modCount++;
        return Integer.valueOf(i11);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i10, int i11) {
        b();
        if (i11 >= i10) {
            int[] iArr = this.f25712c;
            System.arraycopy((Object) iArr, i11, (Object) iArr, i10, this.f25713d - i11);
            this.f25713d -= i11 - i10;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i10, Object obj) {
        int intValue = ((Integer) obj).intValue();
        b();
        h(i10);
        int[] iArr = this.f25712c;
        int i11 = iArr[i10];
        iArr[i10] = intValue;
        return Integer.valueOf(i11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f25713d;
    }

    @Override // com.google.android.gms.internal.vision.g5
    public final /* synthetic */ g5 zza(int i10) {
        if (i10 >= this.f25713d) {
            return new z4(Arrays.copyOf(this.f25712c, i10), this.f25713d);
        }
        throw new IllegalArgumentException();
    }

    public z4(int[] iArr, int i10) {
        this.f25712c = iArr;
        this.f25713d = i10;
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* synthetic */ boolean add(Object obj) {
        f(((Integer) obj).intValue());
        return true;
    }
}
