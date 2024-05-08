package com.google.android.gms.internal.clearcut;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class x extends t<Boolean> implements RandomAccess {

    /* renamed from: e, reason: collision with root package name */
    public static final x f24072e;

    /* renamed from: c, reason: collision with root package name */
    public boolean[] f24073c;

    /* renamed from: d, reason: collision with root package name */
    public int f24074d;

    static {
        x xVar = new x();
        f24072e = xVar;
        xVar.k();
    }

    public x() {
        this(new boolean[10], 0);
    }

    public x(boolean[] zArr, int i10) {
        this.f24073c = zArr;
        this.f24074d = i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i10, Object obj) {
        c(i10, ((Boolean) obj).booleanValue());
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection<? extends Boolean> collection) {
        b();
        z0.a(collection);
        if (!(collection instanceof x)) {
            return super.addAll(collection);
        }
        x xVar = (x) collection;
        int i10 = xVar.f24074d;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f24074d;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        boolean[] zArr = this.f24073c;
        if (i12 > zArr.length) {
            this.f24073c = Arrays.copyOf(zArr, i12);
        }
        System.arraycopy((Object) xVar.f24073c, 0, (Object) this.f24073c, this.f24074d, xVar.f24074d);
        this.f24074d = i12;
        this.modCount++;
        return true;
    }

    public final void addBoolean(boolean z10) {
        c(this.f24074d, z10);
    }

    public final void c(int i10, boolean z10) {
        int i11;
        b();
        if (i10 < 0 || i10 > (i11 = this.f24074d)) {
            throw new IndexOutOfBoundsException(g(i10));
        }
        boolean[] zArr = this.f24073c;
        if (i11 < zArr.length) {
            System.arraycopy((Object) zArr, i10, (Object) zArr, i10 + 1, i11 - i10);
        } else {
            boolean[] zArr2 = new boolean[((i11 * 3) / 2) + 1];
            System.arraycopy((Object) zArr, 0, (Object) zArr2, 0, i10);
            System.arraycopy((Object) this.f24073c, i10, (Object) zArr2, i10 + 1, this.f24074d - i10);
            this.f24073c = zArr2;
        }
        this.f24073c[i10] = z10;
        this.f24074d++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.clearcut.c1
    public final /* synthetic */ c1 d(int i10) {
        if (i10 >= this.f24074d) {
            return new x(Arrays.copyOf(this.f24073c, i10), this.f24074d);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractList, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return super.equals(obj);
        }
        x xVar = (x) obj;
        if (this.f24074d != xVar.f24074d) {
            return false;
        }
        boolean[] zArr = xVar.f24073c;
        for (int i10 = 0; i10 < this.f24074d; i10++) {
            if (this.f24073c[i10] != zArr[i10]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i10) {
        if (i10 < 0 || i10 >= this.f24074d) {
            throw new IndexOutOfBoundsException(g(i10));
        }
    }

    public final String g(int i10) {
        int i11 = this.f24074d;
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
        return Boolean.valueOf(this.f24073c[i10]);
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractList, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f24074d; i11++) {
            i10 = (i10 * 31) + z0.f(this.f24073c[i11]);
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i10) {
        b();
        f(i10);
        boolean[] zArr = this.f24073c;
        boolean z10 = zArr[i10];
        int i11 = this.f24074d;
        if (i10 < i11 - 1) {
            System.arraycopy((Object) zArr, i10 + 1, (Object) zArr, i10, i11 - i10);
        }
        this.f24074d--;
        this.modCount++;
        return Boolean.valueOf(z10);
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        b();
        for (int i10 = 0; i10 < this.f24074d; i10++) {
            if (obj.equals(Boolean.valueOf(this.f24073c[i10]))) {
                boolean[] zArr = this.f24073c;
                System.arraycopy((Object) zArr, i10 + 1, (Object) zArr, i10, this.f24074d - i10);
                this.f24074d--;
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
        boolean[] zArr = this.f24073c;
        System.arraycopy((Object) zArr, i11, (Object) zArr, i10, this.f24074d - i11);
        this.f24074d -= i11 - i10;
        this.modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i10, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        b();
        f(i10);
        boolean[] zArr = this.f24073c;
        boolean z10 = zArr[i10];
        zArr[i10] = booleanValue;
        return Boolean.valueOf(z10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f24074d;
    }
}
