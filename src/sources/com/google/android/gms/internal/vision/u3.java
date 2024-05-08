package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class u3 extends p3<Boolean> implements n6, RandomAccess {

    /* renamed from: e, reason: collision with root package name */
    public static final u3 f25647e;

    /* renamed from: c, reason: collision with root package name */
    public boolean[] f25648c;

    /* renamed from: d, reason: collision with root package name */
    public int f25649d;

    static {
        u3 u3Var = new u3(new boolean[0], 0);
        f25647e = u3Var;
        u3Var.zzb();
    }

    public u3() {
        this(new boolean[10], 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i10, Object obj) {
        int i11;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        b();
        if (i10 >= 0 && i10 <= (i11 = this.f25649d)) {
            boolean[] zArr = this.f25648c;
            if (i11 < zArr.length) {
                System.arraycopy((Object) zArr, i10, (Object) zArr, i10 + 1, i11 - i10);
            } else {
                boolean[] zArr2 = new boolean[((i11 * 3) / 2) + 1];
                System.arraycopy((Object) zArr, 0, (Object) zArr2, 0, i10);
                System.arraycopy((Object) this.f25648c, i10, (Object) zArr2, i10 + 1, this.f25649d - i10);
                this.f25648c = zArr2;
            }
            this.f25648c[i10] = booleanValue;
            this.f25649d++;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(g(i10));
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection<? extends Boolean> collection) {
        b();
        b5.d(collection);
        if (!(collection instanceof u3)) {
            return super.addAll(collection);
        }
        u3 u3Var = (u3) collection;
        int i10 = u3Var.f25649d;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f25649d;
        if (Integer.MAX_VALUE - i11 >= i10) {
            int i12 = i11 + i10;
            boolean[] zArr = this.f25648c;
            if (i12 > zArr.length) {
                this.f25648c = Arrays.copyOf(zArr, i12);
            }
            System.arraycopy((Object) u3Var.f25648c, 0, (Object) this.f25648c, this.f25649d, u3Var.f25649d);
            this.f25649d = i12;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void c(boolean z10) {
        b();
        int i10 = this.f25649d;
        boolean[] zArr = this.f25648c;
        if (i10 == zArr.length) {
            boolean[] zArr2 = new boolean[((i10 * 3) / 2) + 1];
            System.arraycopy((Object) zArr, 0, (Object) zArr2, 0, i10);
            this.f25648c = zArr2;
        }
        boolean[] zArr3 = this.f25648c;
        int i11 = this.f25649d;
        this.f25649d = i11 + 1;
        zArr3[i11] = z10;
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
        if (!(obj instanceof u3)) {
            return super.equals(obj);
        }
        u3 u3Var = (u3) obj;
        if (this.f25649d != u3Var.f25649d) {
            return false;
        }
        boolean[] zArr = u3Var.f25648c;
        for (int i10 = 0; i10 < this.f25649d; i10++) {
            if (this.f25648c[i10] != zArr[i10]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i10) {
        if (i10 < 0 || i10 >= this.f25649d) {
            throw new IndexOutOfBoundsException(g(i10));
        }
    }

    public final String g(int i10) {
        int i11 = this.f25649d;
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
        return Boolean.valueOf(this.f25648c[i10]);
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractList, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f25649d; i11++) {
            i10 = (i10 * 31) + b5.c(this.f25648c[i11]);
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f25648c[i10] == booleanValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i10) {
        b();
        f(i10);
        boolean[] zArr = this.f25648c;
        boolean z10 = zArr[i10];
        if (i10 < this.f25649d - 1) {
            System.arraycopy((Object) zArr, i10 + 1, (Object) zArr, i10, (r2 - i10) - 1);
        }
        this.f25649d--;
        this.modCount++;
        return Boolean.valueOf(z10);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i10, int i11) {
        b();
        if (i11 >= i10) {
            boolean[] zArr = this.f25648c;
            System.arraycopy((Object) zArr, i11, (Object) zArr, i10, this.f25649d - i11);
            this.f25649d -= i11 - i10;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i10, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        b();
        f(i10);
        boolean[] zArr = this.f25648c;
        boolean z10 = zArr[i10];
        zArr[i10] = booleanValue;
        return Boolean.valueOf(z10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f25649d;
    }

    @Override // com.google.android.gms.internal.vision.g5
    public final /* synthetic */ g5 zza(int i10) {
        if (i10 >= this.f25649d) {
            return new u3(Arrays.copyOf(this.f25648c, i10), this.f25649d);
        }
        throw new IllegalArgumentException();
    }

    public u3(boolean[] zArr, int i10) {
        this.f25648c = zArr;
        this.f25649d = i10;
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* synthetic */ boolean add(Object obj) {
        c(((Boolean) obj).booleanValue());
        return true;
    }
}
