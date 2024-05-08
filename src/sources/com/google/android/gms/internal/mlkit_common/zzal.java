package com.google.android.gms.internal.mlkit_common;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class zzal<E> extends zzag<E> implements Set<E> {

    @NullableDecl
    private transient zzak<E> zza;

    @SafeVarargs
    public static <E> zzal<E> zzf(E e2, E e10, E e11, E e12, E e13, E e14, E... eArr) {
        Object[] objArr = new Object[8];
        objArr[0] = "common";
        objArr[1] = "vision-common";
        objArr[2] = "play-services-mlkit-barcode-scanning";
        objArr[3] = "barcode-scanning";
        objArr[4] = "play-services-mlkit-face-detection";
        objArr[5] = "face-detection";
        System.arraycopy(eArr, 0, objArr, 6, 2);
        return zzk(8, objArr);
    }

    public static int zzg(int i10) {
        int max = Math.max(i10, 2);
        if (max >= 751619276) {
            if (max < 1073741824) {
                return 1073741824;
            }
            throw new IllegalArgumentException("collection too large");
        }
        int highestOneBit = Integer.highestOneBit(max - 1);
        do {
            highestOneBit += highestOneBit;
        } while (highestOneBit * 0.7d < max);
        return highestOneBit;
    }

    private static <E> zzal<E> zzk(int i10, Object... objArr) {
        if (i10 == 0) {
            return zzap.zza;
        }
        if (i10 != 1) {
            int zzg = zzg(i10);
            Object[] objArr2 = new Object[zzg];
            int i11 = zzg - 1;
            int i12 = 0;
            int i13 = 0;
            for (int i14 = 0; i14 < i10; i14++) {
                Object obj = objArr[i14];
                k.b(obj, i14);
                int hashCode = obj.hashCode();
                int a10 = e.a(hashCode);
                while (true) {
                    int i15 = a10 & i11;
                    Object obj2 = objArr2[i15];
                    if (obj2 == null) {
                        objArr[i13] = obj;
                        objArr2[i15] = obj;
                        i12 += hashCode;
                        i13++;
                        break;
                    }
                    if (obj2.equals(obj)) {
                        break;
                    }
                    a10++;
                }
            }
            Arrays.fill(objArr, i13, i10, (Object) null);
            if (i13 == 1) {
                return new zzaq(objArr[0], i12);
            }
            if (zzg(i13) >= zzg / 2) {
                if (i13 < 6) {
                    objArr = Arrays.copyOf(objArr, i13);
                }
                return new zzap(objArr, i12, objArr2, i11, i13);
            }
            return zzk(i13, objArr);
        }
        return new zzaq(objArr[0]);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzal) && zzh() && ((zzal) obj).zzh() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        Iterator<E> iterator2 = iterator2();
        int i10 = 0;
        while (iterator2.hasNext()) {
            E next = iterator2.next();
            i10 += next != null ? next.hashCode() : 0;
        }
        return i10;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzag, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zza */
    public abstract l<E> iterator2();

    public boolean zzh() {
        throw null;
    }

    public final zzak<E> zzi() {
        zzak<E> zzakVar = this.zza;
        if (zzakVar != null) {
            return zzakVar;
        }
        zzak<E> zzj = zzj();
        this.zza = zzj;
        return zzj;
    }

    public zzak<E> zzj() {
        throw null;
    }
}
