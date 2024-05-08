package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class s6<E> extends p3<E> implements RandomAccess {

    /* renamed from: e, reason: collision with root package name */
    public static final s6<Object> f25635e;

    /* renamed from: c, reason: collision with root package name */
    public E[] f25636c;

    /* renamed from: d, reason: collision with root package name */
    public int f25637d;

    static {
        s6<Object> s6Var = new s6<>(new Object[0], 0);
        f25635e = s6Var;
        s6Var.zzb();
    }

    public s6(E[] eArr, int i10) {
        this.f25636c = eArr;
        this.f25637d = i10;
    }

    public static <E> s6<E> g() {
        return (s6<E>) f25635e;
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(E e2) {
        b();
        int i10 = this.f25637d;
        E[] eArr = this.f25636c;
        if (i10 == eArr.length) {
            this.f25636c = (E[]) Arrays.copyOf(eArr, ((i10 * 3) / 2) + 1);
        }
        E[] eArr2 = this.f25636c;
        int i11 = this.f25637d;
        this.f25637d = i11 + 1;
        eArr2[i11] = e2;
        this.modCount++;
        return true;
    }

    public final void c(int i10) {
        if (i10 < 0 || i10 >= this.f25637d) {
            throw new IndexOutOfBoundsException(f(i10));
        }
    }

    public final String f(int i10) {
        int i11 = this.f25637d;
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append("Index:");
        sb2.append(i10);
        sb2.append(", Size:");
        sb2.append(i11);
        return sb2.toString();
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i10) {
        c(i10);
        return this.f25636c[i10];
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractList, java.util.List
    public final E remove(int i10) {
        b();
        c(i10);
        E[] eArr = this.f25636c;
        E e2 = eArr[i10];
        if (i10 < this.f25637d - 1) {
            System.arraycopy(eArr, i10 + 1, eArr, i10, (r2 - i10) - 1);
        }
        this.f25637d--;
        this.modCount++;
        return e2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E set(int i10, E e2) {
        b();
        c(i10);
        E[] eArr = this.f25636c;
        E e10 = eArr[i10];
        eArr[i10] = e2;
        this.modCount++;
        return e10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f25637d;
    }

    @Override // com.google.android.gms.internal.vision.g5
    public final /* synthetic */ g5 zza(int i10) {
        if (i10 >= this.f25637d) {
            return new s6(Arrays.copyOf(this.f25636c, i10), this.f25637d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i10, E e2) {
        int i11;
        b();
        if (i10 >= 0 && i10 <= (i11 = this.f25637d)) {
            E[] eArr = this.f25636c;
            if (i11 < eArr.length) {
                System.arraycopy(eArr, i10, eArr, i10 + 1, i11 - i10);
            } else {
                E[] eArr2 = (E[]) new Object[((i11 * 3) / 2) + 1];
                System.arraycopy(eArr, 0, eArr2, 0, i10);
                System.arraycopy(this.f25636c, i10, eArr2, i10 + 1, this.f25637d - i10);
                this.f25636c = eArr2;
            }
            this.f25636c[i10] = e2;
            this.f25637d++;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(f(i10));
    }
}
