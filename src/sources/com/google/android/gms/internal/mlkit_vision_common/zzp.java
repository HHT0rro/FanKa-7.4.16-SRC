package com.google.android.gms.internal.mlkit_vision_common;

import com.huawei.quickcard.base.Attributes;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class zzp<E> extends zzl<E> implements List<E>, RandomAccess {
    private static final n7<Object> zza = new j7(zzt.zza, 0);

    public static <E> zzp<E> zzg(E e2) {
        Object[] objArr = {e2};
        l7.a(objArr[0], 0);
        return zzh(objArr, 1);
    }

    public static <E> zzp<E> zzh(Object[] objArr, int i10) {
        if (i10 == 0) {
            return (zzp<E>) zzt.zza;
        }
        return new zzt(objArr, i10);
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

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl, java.util.AbstractCollection, java.util.Collection, java.util.Set
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
                        if (a0.a(get(i10), list.get(i10))) {
                        }
                    }
                    return true;
                }
                Iterator<E> iterator2 = iterator2();
                Iterator<E> iterator22 = list.iterator2();
                while (true) {
                    if (iterator2.hasNext()) {
                        if (!iterator22.hasNext() || !a0.a(iterator2.next(), iterator22.next())) {
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

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
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

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl
    /* renamed from: zza */
    public final m7<E> iterator2() {
        return listIterator(0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl
    public int zze(Object[] objArr, int i10) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            objArr[i11] = get(i11);
        }
        return size;
    }

    @Override // java.util.List
    /* renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public zzp<E> subList(int i10, int i11) {
        e4.c(i10, i11, size());
        int i12 = i11 - i10;
        if (i12 == size()) {
            return this;
        }
        if (i12 == 0) {
            return (zzp<E>) zzt.zza;
        }
        return new zzo(this, i10, i12);
    }

    @Override // java.util.List
    /* renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public final n7<E> listIterator(int i10) {
        e4.b(i10, size(), Attributes.Style.INDEX);
        return isEmpty() ? (n7<E>) zza : new j7(this, i10);
    }
}
