package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class r5 extends p3<Long> implements n6, RandomAccess {

    /* renamed from: e, reason: collision with root package name */
    public static final r5 f25623e;

    /* renamed from: c, reason: collision with root package name */
    public long[] f25624c;

    /* renamed from: d, reason: collision with root package name */
    public int f25625d;

    static {
        r5 r5Var = new r5(new long[0], 0);
        f25623e = r5Var;
        r5Var.zzb();
    }

    public r5() {
        this(new long[10], 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i10, Object obj) {
        int i11;
        long longValue = ((Long) obj).longValue();
        b();
        if (i10 >= 0 && i10 <= (i11 = this.f25625d)) {
            long[] jArr = this.f25624c;
            if (i11 < jArr.length) {
                System.arraycopy((Object) jArr, i10, (Object) jArr, i10 + 1, i11 - i10);
            } else {
                long[] jArr2 = new long[((i11 * 3) / 2) + 1];
                System.arraycopy((Object) jArr, 0, (Object) jArr2, 0, i10);
                System.arraycopy((Object) this.f25624c, i10, (Object) jArr2, i10 + 1, this.f25625d - i10);
                this.f25624c = jArr2;
            }
            this.f25624c[i10] = longValue;
            this.f25625d++;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(h(i10));
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection<? extends Long> collection) {
        b();
        b5.d(collection);
        if (!(collection instanceof r5)) {
            return super.addAll(collection);
        }
        r5 r5Var = (r5) collection;
        int i10 = r5Var.f25625d;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f25625d;
        if (Integer.MAX_VALUE - i11 >= i10) {
            int i12 = i11 + i10;
            long[] jArr = this.f25624c;
            if (i12 > jArr.length) {
                this.f25624c = Arrays.copyOf(jArr, i12);
            }
            System.arraycopy((Object) r5Var.f25624c, 0, (Object) this.f25624c, this.f25625d, r5Var.f25625d);
            this.f25625d = i12;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void c(long j10) {
        b();
        int i10 = this.f25625d;
        long[] jArr = this.f25624c;
        if (i10 == jArr.length) {
            long[] jArr2 = new long[((i10 * 3) / 2) + 1];
            System.arraycopy((Object) jArr, 0, (Object) jArr2, 0, i10);
            this.f25624c = jArr2;
        }
        long[] jArr3 = this.f25624c;
        int i11 = this.f25625d;
        this.f25625d = i11 + 1;
        jArr3[i11] = j10;
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
        if (!(obj instanceof r5)) {
            return super.equals(obj);
        }
        r5 r5Var = (r5) obj;
        if (this.f25625d != r5Var.f25625d) {
            return false;
        }
        long[] jArr = r5Var.f25624c;
        for (int i10 = 0; i10 < this.f25625d; i10++) {
            if (this.f25624c[i10] != jArr[i10]) {
                return false;
            }
        }
        return true;
    }

    public final long f(int i10) {
        g(i10);
        return this.f25624c[i10];
    }

    public final void g(int i10) {
        if (i10 < 0 || i10 >= this.f25625d) {
            throw new IndexOutOfBoundsException(h(i10));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i10) {
        return Long.valueOf(f(i10));
    }

    public final String h(int i10) {
        int i11 = this.f25625d;
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append("Index:");
        sb2.append(i10);
        sb2.append(", Size:");
        sb2.append(i11);
        return sb2.toString();
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractList, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f25625d; i11++) {
            i10 = (i10 * 31) + b5.b(this.f25624c[i11]);
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f25624c[i10] == longValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i10) {
        b();
        g(i10);
        long[] jArr = this.f25624c;
        long j10 = jArr[i10];
        if (i10 < this.f25625d - 1) {
            System.arraycopy((Object) jArr, i10 + 1, (Object) jArr, i10, (r3 - i10) - 1);
        }
        this.f25625d--;
        this.modCount++;
        return Long.valueOf(j10);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i10, int i11) {
        b();
        if (i11 >= i10) {
            long[] jArr = this.f25624c;
            System.arraycopy((Object) jArr, i11, (Object) jArr, i10, this.f25625d - i11);
            this.f25625d -= i11 - i10;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i10, Object obj) {
        long longValue = ((Long) obj).longValue();
        b();
        g(i10);
        long[] jArr = this.f25624c;
        long j10 = jArr[i10];
        jArr[i10] = longValue;
        return Long.valueOf(j10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f25625d;
    }

    @Override // com.google.android.gms.internal.vision.g5
    public final /* synthetic */ g5 zza(int i10) {
        if (i10 >= this.f25625d) {
            return new r5(Arrays.copyOf(this.f25624c, i10), this.f25625d);
        }
        throw new IllegalArgumentException();
    }

    public r5(long[] jArr, int i10) {
        this.f25624c = jArr;
        this.f25625d = i10;
    }

    @Override // com.google.android.gms.internal.vision.p3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* synthetic */ boolean add(Object obj) {
        c(((Long) obj).longValue());
        return true;
    }
}
