package com.google.android.gms.internal.clearcut;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class v0 extends t<Float> implements RandomAccess {

    /* renamed from: e, reason: collision with root package name */
    public static final v0 f24061e;

    /* renamed from: c, reason: collision with root package name */
    public float[] f24062c;

    /* renamed from: d, reason: collision with root package name */
    public int f24063d;

    static {
        v0 v0Var = new v0();
        f24061e = v0Var;
        v0Var.k();
    }

    public v0() {
        this(new float[10], 0);
    }

    public v0(float[] fArr, int i10) {
        this.f24062c = fArr;
        this.f24063d = i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i10, Object obj) {
        f(i10, ((Float) obj).floatValue());
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection<? extends Float> collection) {
        b();
        z0.a(collection);
        if (!(collection instanceof v0)) {
            return super.addAll(collection);
        }
        v0 v0Var = (v0) collection;
        int i10 = v0Var.f24063d;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f24063d;
        if (Integer.MAX_VALUE - i11 < i10) {
            throw new OutOfMemoryError();
        }
        int i12 = i11 + i10;
        float[] fArr = this.f24062c;
        if (i12 > fArr.length) {
            this.f24062c = Arrays.copyOf(fArr, i12);
        }
        System.arraycopy((Object) v0Var.f24062c, 0, (Object) this.f24062c, this.f24063d, v0Var.f24063d);
        this.f24063d = i12;
        this.modCount++;
        return true;
    }

    public final void c(float f10) {
        f(this.f24063d, f10);
    }

    @Override // com.google.android.gms.internal.clearcut.c1
    public final /* synthetic */ c1 d(int i10) {
        if (i10 >= this.f24063d) {
            return new v0(Arrays.copyOf(this.f24062c, i10), this.f24063d);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractList, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v0)) {
            return super.equals(obj);
        }
        v0 v0Var = (v0) obj;
        if (this.f24063d != v0Var.f24063d) {
            return false;
        }
        float[] fArr = v0Var.f24062c;
        for (int i10 = 0; i10 < this.f24063d; i10++) {
            if (this.f24062c[i10] != fArr[i10]) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i10, float f10) {
        int i11;
        b();
        if (i10 < 0 || i10 > (i11 = this.f24063d)) {
            throw new IndexOutOfBoundsException(h(i10));
        }
        float[] fArr = this.f24062c;
        if (i11 < fArr.length) {
            System.arraycopy((Object) fArr, i10, (Object) fArr, i10 + 1, i11 - i10);
        } else {
            float[] fArr2 = new float[((i11 * 3) / 2) + 1];
            System.arraycopy((Object) fArr, 0, (Object) fArr2, 0, i10);
            System.arraycopy((Object) this.f24062c, i10, (Object) fArr2, i10 + 1, this.f24063d - i10);
            this.f24062c = fArr2;
        }
        this.f24062c[i10] = f10;
        this.f24063d++;
        this.modCount++;
    }

    public final void g(int i10) {
        if (i10 < 0 || i10 >= this.f24063d) {
            throw new IndexOutOfBoundsException(h(i10));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        g(i10);
        return Float.valueOf(this.f24062c[i10]);
    }

    public final String h(int i10) {
        int i11 = this.f24063d;
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
        for (int i11 = 0; i11 < this.f24063d; i11++) {
            i10 = (i10 * 31) + Float.floatToIntBits(this.f24062c[i11]);
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i10) {
        b();
        g(i10);
        float[] fArr = this.f24062c;
        float f10 = fArr[i10];
        int i11 = this.f24063d;
        if (i10 < i11 - 1) {
            System.arraycopy((Object) fArr, i10 + 1, (Object) fArr, i10, i11 - i10);
        }
        this.f24063d--;
        this.modCount++;
        return Float.valueOf(f10);
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        b();
        for (int i10 = 0; i10 < this.f24063d; i10++) {
            if (obj.equals(Float.valueOf(this.f24062c[i10]))) {
                float[] fArr = this.f24062c;
                System.arraycopy((Object) fArr, i10 + 1, (Object) fArr, i10, this.f24063d - i10);
                this.f24063d--;
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
        float[] fArr = this.f24062c;
        System.arraycopy((Object) fArr, i11, (Object) fArr, i10, this.f24063d - i11);
        this.f24063d -= i11 - i10;
        this.modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i10, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        b();
        g(i10);
        float[] fArr = this.f24062c;
        float f10 = fArr[i10];
        fArr[i10] = floatValue;
        return Float.valueOf(f10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f24063d;
    }
}
