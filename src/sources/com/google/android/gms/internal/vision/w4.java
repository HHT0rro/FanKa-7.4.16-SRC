package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class w4 extends p3<Float> implements n6, RandomAccess {

    /* renamed from: e, reason: collision with root package name */
    public static final w4 f25668e;

    /* renamed from: c, reason: collision with root package name */
    public float[] f25669c;

    /* renamed from: d, reason: collision with root package name */
    public int f25670d;

    static {
        w4 w4Var = new w4(new float[0], 0);
        f25668e = w4Var;
        w4Var.zzb();
    }

    public w4() {
        this(new float[10], 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i10, Object obj) {
        int i11;
        float floatValue = ((Float) obj).floatValue();
        b();
        if (i10 >= 0 && i10 <= (i11 = this.f25670d)) {
            float[] fArr = this.f25669c;
            if (i11 < fArr.length) {
                System.arraycopy((Object) fArr, i10, (Object) fArr, i10 + 1, i11 - i10);
            } else {
                float[] fArr2 = new float[((i11 * 3) / 2) + 1];
                System.arraycopy((Object) fArr, 0, (Object) fArr2, 0, i10);
                System.arraycopy((Object) this.f25669c, i10, (Object) fArr2, i10 + 1, this.f25670d - i10);
                this.f25669c = fArr2;
            }
            this.f25669c[i10] = floatValue;
            this.f25670d++;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(g(i10));
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection<? extends Float> collection) {
        b();
        b5.d(collection);
        if (!(collection instanceof w4)) {
            return super.addAll(collection);
        }
        w4 w4Var = (w4) collection;
        int i10 = w4Var.f25670d;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f25670d;
        if (Integer.MAX_VALUE - i11 >= i10) {
            int i12 = i11 + i10;
            float[] fArr = this.f25669c;
            if (i12 > fArr.length) {
                this.f25669c = Arrays.copyOf(fArr, i12);
            }
            System.arraycopy((Object) w4Var.f25669c, 0, (Object) this.f25669c, this.f25670d, w4Var.f25670d);
            this.f25670d = i12;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void c(float f10) {
        b();
        int i10 = this.f25670d;
        float[] fArr = this.f25669c;
        if (i10 == fArr.length) {
            float[] fArr2 = new float[((i10 * 3) / 2) + 1];
            System.arraycopy((Object) fArr, 0, (Object) fArr2, 0, i10);
            this.f25669c = fArr2;
        }
        float[] fArr3 = this.f25669c;
        int i11 = this.f25670d;
        this.f25670d = i11 + 1;
        fArr3[i11] = f10;
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
        if (!(obj instanceof w4)) {
            return super.equals(obj);
        }
        w4 w4Var = (w4) obj;
        if (this.f25670d != w4Var.f25670d) {
            return false;
        }
        float[] fArr = w4Var.f25669c;
        for (int i10 = 0; i10 < this.f25670d; i10++) {
            if (Float.floatToIntBits(this.f25669c[i10]) != Float.floatToIntBits(fArr[i10])) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i10) {
        if (i10 < 0 || i10 >= this.f25670d) {
            throw new IndexOutOfBoundsException(g(i10));
        }
    }

    public final String g(int i10) {
        int i11 = this.f25670d;
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
        return Float.valueOf(this.f25669c[i10]);
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractList, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f25670d; i11++) {
            i10 = (i10 * 31) + Float.floatToIntBits(this.f25669c[i11]);
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f25669c[i10] == floatValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i10) {
        b();
        f(i10);
        float[] fArr = this.f25669c;
        float f10 = fArr[i10];
        if (i10 < this.f25670d - 1) {
            System.arraycopy((Object) fArr, i10 + 1, (Object) fArr, i10, (r2 - i10) - 1);
        }
        this.f25670d--;
        this.modCount++;
        return Float.valueOf(f10);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i10, int i11) {
        b();
        if (i11 >= i10) {
            float[] fArr = this.f25669c;
            System.arraycopy((Object) fArr, i11, (Object) fArr, i10, this.f25670d - i11);
            this.f25670d -= i11 - i10;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i10, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        b();
        f(i10);
        float[] fArr = this.f25669c;
        float f10 = fArr[i10];
        fArr[i10] = floatValue;
        return Float.valueOf(f10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f25670d;
    }

    @Override // com.google.android.gms.internal.vision.g5
    public final /* synthetic */ g5 zza(int i10) {
        if (i10 >= this.f25670d) {
            return new w4(Arrays.copyOf(this.f25669c, i10), this.f25670d);
        }
        throw new IllegalArgumentException();
    }

    public w4(float[] fArr, int i10) {
        this.f25669c = fArr;
        this.f25670d = i10;
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* synthetic */ boolean add(Object obj) {
        c(((Float) obj).floatValue());
        return true;
    }
}
