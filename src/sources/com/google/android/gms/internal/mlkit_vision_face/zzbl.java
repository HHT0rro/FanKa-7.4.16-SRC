package com.google.android.gms.internal.mlkit_vision_face;

import com.huawei.quickcard.base.Attributes;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class zzbl<E> extends zzbg<E> implements List<E>, RandomAccess {
    private static final u0<Object> zza = new c0(zzca.zza, 0);

    public static <E> zzbl<E> zzg(E e2) {
        Object[] objArr = {e2};
        o0.a(objArr, 1);
        return zzi(objArr, 1);
    }

    public static <E> zzbl<E> zzh(E e2, E e10) {
        Object[] objArr = {e2, e10};
        o0.a(objArr, 2);
        return zzi(objArr, 2);
    }

    public static <E> zzbl<E> zzi(Object[] objArr, int i10) {
        if (i10 == 0) {
            return (zzbl<E>) zzca.zza;
        }
        return new zzca(objArr, i10);
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

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbg, java.util.AbstractCollection, java.util.Collection, java.util.Set
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
                        if (w9.a(get(i10), list.get(i10))) {
                        }
                    }
                    return true;
                }
                Iterator<E> iterator2 = iterator2();
                Iterator<E> iterator22 = list.iterator2();
                while (true) {
                    if (iterator2.hasNext()) {
                        if (!iterator22.hasNext() || !w9.a(iterator2.next(), iterator22.next())) {
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

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbg, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
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

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbg
    /* renamed from: zza */
    public final t0<E> iterator2() {
        return listIterator(0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzbg
    public int zze(Object[] objArr, int i10) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            objArr[i11] = get(i11);
        }
        return size;
    }

    @Override // java.util.List
    /* renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public zzbl<E> subList(int i10, int i11) {
        a.d(i10, i11, size());
        int i12 = i11 - i10;
        if (i12 == size()) {
            return this;
        }
        if (i12 == 0) {
            return (zzbl<E>) zzca.zza;
        }
        return new zzbk(this, i10, i12);
    }

    @Override // java.util.List
    /* renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public final u0<E> listIterator(int i10) {
        a.c(i10, size(), Attributes.Style.INDEX);
        return isEmpty() ? (u0<E>) zza : new c0(this, i10);
    }
}
