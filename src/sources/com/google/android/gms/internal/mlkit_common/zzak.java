package com.google.android.gms.internal.mlkit_common;

import com.huawei.quickcard.base.Attributes;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class zzak<E> extends zzag<E> implements List<E>, RandomAccess {
    private static final m<Object> zza = new i(zzao.zza, 0);

    public static <E> zzak<E> zzg(E e2) {
        Object[] objArr = {e2};
        k.a(objArr, 1);
        return zzi(objArr, 1);
    }

    public static <E> zzak<E> zzh(E e2, E e10, E e11, E e12, E e13, E e14, E e15, E e16, E e17) {
        Object[] objArr = {e2, e10, e11, e12, e13, e14, e15, e16, e17};
        k.a(objArr, 9);
        return zzi(objArr, 9);
    }

    public static <E> zzak<E> zzi(Object[] objArr, int i10) {
        if (i10 == 0) {
            return (zzak<E>) zzao.zza;
        }
        return new zzao(objArr, i10);
    }

    public static <E> h<E> zzk() {
        return new h<>(4);
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

    @Override // com.google.android.gms.internal.mlkit_common.zzag, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i10 = 0; i10 < size; i10++) {
                        if (t0.a(get(i10), list.get(i10))) {
                        }
                    }
                    return true;
                }
                Iterator<E> iterator2 = iterator2();
                Iterator<E> iterator22 = list.iterator2();
                while (true) {
                    if (iterator2.hasNext()) {
                        if (!iterator22.hasNext() || !t0.a(iterator2.next(), iterator22.next())) {
                            break;
                        }
                    } else if (!iterator22.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int size = size();
        int i10 = 1;
        for (int i11 = 0; i11 < size; i11++) {
            i10 = (i10 * 31) + get(i11).hashCode();
        }
        return i10;
    }

    @Override // java.util.List
    public final int indexOf(@NullableDecl Object obj) {
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

    @Override // com.google.android.gms.internal.mlkit_common.zzag, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public final /* bridge */ /* synthetic */ Iterator iterator2() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(@NullableDecl Object obj) {
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
    public final /* bridge */ /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
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

    @Override // com.google.android.gms.internal.mlkit_common.zzag
    /* renamed from: zza */
    public final l<E> iterator2() {
        return listIterator(0);
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzag
    public int zze(Object[] objArr, int i10) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            objArr[i11] = get(i11);
        }
        return size;
    }

    @Override // java.util.List
    /* renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public zzak<E> subList(int i10, int i11) {
        u0.c(i10, i11, size());
        int i12 = i11 - i10;
        if (i12 == size()) {
            return this;
        }
        if (i12 == 0) {
            return (zzak<E>) zzao.zza;
        }
        return new zzaj(this, i10, i12);
    }

    @Override // java.util.List
    /* renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public final m<E> listIterator(int i10) {
        u0.b(i10, size(), Attributes.Style.INDEX);
        return isEmpty() ? (m<E>) zza : new i(this, i10);
    }
}
