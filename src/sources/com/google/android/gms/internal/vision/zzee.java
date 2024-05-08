package com.google.android.gms.internal.vision;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class zzee<E> extends zzeb<E> implements List<E>, RandomAccess {
    private static final p1<Object> zza = new k1(zzep.zza, 0);

    public static <E> zzee<E> zza(E e2) {
        Object[] objArr = {e2};
        for (int i10 = 0; i10 <= 0; i10++) {
            n1.a(objArr[0], 0);
        }
        return zzb(objArr, 1);
    }

    public static <E> zzee<E> zzb(Object[] objArr, int i10) {
        if (i10 == 0) {
            return (zzee<E>) zzep.zza;
        }
        return new zzep(objArr, i10);
    }

    public static <E> zzee<E> zzg() {
        return (zzee<E>) zzep.zza;
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i10, E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i10, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.vision.zzeb, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        if (obj == p0.b(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i10 = 0; i10 < size; i10++) {
                        if (k0.a(get(i10), list.get(i10))) {
                        }
                    }
                    return true;
                }
                int size2 = size();
                Iterator<E> iterator2 = list.iterator2();
                int i11 = 0;
                while (true) {
                    if (i11 < size2) {
                        if (!iterator2.hasNext()) {
                            break;
                        }
                        E e2 = get(i11);
                        i11++;
                        if (!k0.a(e2, iterator2.next())) {
                            break;
                        }
                    } else if (!iterator2.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int size = size();
        int i10 = 1;
        for (int i11 = 0; i11 < size; i11++) {
            i10 = ~(~((i10 * 31) + get(i11).hashCode()));
        }
        return i10;
    }

    @Override // java.util.List
    public int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (obj.equals(get(i10))) {
                return i10;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.vision.zzeb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public /* synthetic */ Iterator iterator2() {
        return iterator2();
    }

    @Override // java.util.List
    public int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator(int i10) {
        p0.g(i10, size());
        if (isEmpty()) {
            return zza;
        }
        return new k1(this, i10);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i10, E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final zzee<E> zze() {
        return this;
    }

    public static <E> zzee<E> zza(Object[] objArr) {
        return zzb(objArr, objArr.length);
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    /* renamed from: zza */
    public final r1<E> iterator2() {
        return (p1) listIterator();
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator() {
        return (p1) listIterator(0);
    }

    @Override // java.util.List
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public zzee<E> subList(int i10, int i11) {
        p0.e(i10, i11, size());
        int i12 = i11 - i10;
        if (i12 == size()) {
            return this;
        }
        if (i12 == 0) {
            return (zzee<E>) zzep.zza;
        }
        return new zzeg(this, i10, i12);
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public int zza(Object[] objArr, int i10) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            objArr[i10 + i11] = get(i11);
        }
        return i10 + size;
    }
}
