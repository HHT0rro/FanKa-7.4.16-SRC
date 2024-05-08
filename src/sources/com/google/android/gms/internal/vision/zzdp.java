package com.google.android.gms.internal.vision;

import android.view.View;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzdp<K, V> extends AbstractMap<K, V> implements Serializable {
    private static final Object zzd = new Object();

    @NullableDecl
    public transient int[] zza;

    @NullableDecl
    public transient Object[] zzb;

    @NullableDecl
    public transient Object[] zzc;

    @NullableDecl
    private transient Object zze;
    private transient int zzf;
    private transient int zzg;

    @NullableDecl
    private transient Set<K> zzh;

    @NullableDecl
    private transient Set<Map.Entry<K, V>> zzi;

    @NullableDecl
    private transient Collection<V> zzj;

    public zzdp() {
        p0.f(true, "Expected size must be >= 0");
        this.zzf = t1.a(3, 1, View.LAST_APP_AUTOFILL_ID);
    }

    public static int zzb(int i10, int i11) {
        return i10 - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zzi() {
        return (1 << (this.zzf & 31)) - 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (zza()) {
            return;
        }
        zzc();
        Map<K, V> zzb = zzb();
        if (zzb != null) {
            this.zzf = t1.a(size(), 3, View.LAST_APP_AUTOFILL_ID);
            zzb.clear();
            this.zze = null;
            this.zzg = 0;
            return;
        }
        Arrays.fill(this.zzb, 0, this.zzg, (Object) null);
        Arrays.fill(this.zzc, 0, this.zzg, (Object) null);
        Object obj = this.zze;
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(this.zza, 0, this.zzg, 0);
        this.zzg = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(@NullableDecl Object obj) {
        Map<K, V> zzb = zzb();
        if (zzb != null) {
            return zzb.containsKey(obj);
        }
        return zza(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(@NullableDecl Object obj) {
        Map<K, V> zzb = zzb();
        if (zzb != null) {
            return zzb.containsValue(obj);
        }
        for (int i10 = 0; i10 < this.zzg; i10++) {
            if (k0.a(obj, this.zzc[i10])) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.zzi;
        if (set != null) {
            return set;
        }
        b1 b1Var = new b1(this);
        this.zzi = b1Var;
        return b1Var;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(@NullableDecl Object obj) {
        Map<K, V> zzb = zzb();
        if (zzb != null) {
            return zzb.get(obj);
        }
        int zza = zza(obj);
        if (zza == -1) {
            return null;
        }
        return (V) this.zzc[zza];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: keySet */
    public final Set<K> h() {
        Set<K> set = this.zzh;
        if (set != null) {
            return set;
        }
        d1 d1Var = new d1(this);
        this.zzh = d1Var;
        return d1Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public final V put(@NullableDecl K k10, @NullableDecl V v2) {
        int min;
        if (zza()) {
            p0.h(zza(), "Arrays already allocated");
            int i10 = this.zzf;
            int max = Math.max(i10 + 1, 2);
            int highestOneBit = Integer.highestOneBit(max);
            int max2 = Math.max(4, (max <= ((int) (((double) highestOneBit) * 1.0d)) || (highestOneBit = highestOneBit << 1) > 0) ? highestOneBit : 1073741824);
            this.zze = i1.d(max2);
            zzb(max2 - 1);
            this.zza = new int[i10];
            this.zzb = new Object[i10];
            this.zzc = new Object[i10];
        }
        Map<K, V> zzb = zzb();
        if (zzb != null) {
            return zzb.put(k10, v2);
        }
        int[] iArr = this.zza;
        Object[] objArr = this.zzb;
        Object[] objArr2 = this.zzc;
        int i11 = this.zzg;
        int i12 = i11 + 1;
        int b4 = j1.b(k10);
        int zzi = zzi();
        int i13 = b4 & zzi;
        int b10 = i1.b(this.zze, i13);
        if (b10 != 0) {
            int i14 = ~zzi;
            int i15 = b4 & i14;
            int i16 = 0;
            while (true) {
                int i17 = b10 - 1;
                int i18 = iArr[i17];
                if ((i18 & i14) == i15 && k0.a(k10, objArr[i17])) {
                    V v10 = (V) objArr2[i17];
                    objArr2[i17] = v2;
                    return v10;
                }
                int i19 = i18 & zzi;
                Object[] objArr3 = objArr;
                int i20 = i16 + 1;
                if (i19 != 0) {
                    i16 = i20;
                    b10 = i19;
                    objArr = objArr3;
                } else {
                    if (i20 >= 9) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(zzi() + 1, 1.0f);
                        int zzd2 = zzd();
                        while (zzd2 >= 0) {
                            linkedHashMap.put(this.zzb[zzd2], this.zzc[zzd2]);
                            zzd2 = zza(zzd2);
                        }
                        this.zze = linkedHashMap;
                        this.zza = null;
                        this.zzb = null;
                        this.zzc = null;
                        zzc();
                        return (V) linkedHashMap.put(k10, v2);
                    }
                    if (i12 > zzi) {
                        zzi = zza(zzi, i1.f(zzi), b4, i11);
                    } else {
                        iArr[i17] = i1.a(i18, i12, zzi);
                    }
                }
            }
        } else if (i12 > zzi) {
            zzi = zza(zzi, i1.f(zzi), b4, i11);
        } else {
            i1.e(this.zze, i13, i12);
        }
        int length = this.zza.length;
        if (i12 > length && (min = Math.min(View.LAST_APP_AUTOFILL_ID, 1 | (Math.max(1, length >>> 1) + length))) != length) {
            this.zza = Arrays.copyOf(this.zza, min);
            this.zzb = Arrays.copyOf(this.zzb, min);
            this.zzc = Arrays.copyOf(this.zzc, min);
        }
        this.zza[i11] = i1.a(b4, 0, zzi);
        this.zzb[i11] = k10;
        this.zzc[i11] = v2;
        this.zzg = i12;
        zzc();
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public final V remove(@NullableDecl Object obj) {
        Map<K, V> zzb = zzb();
        if (zzb != null) {
            return zzb.remove(obj);
        }
        V v2 = (V) zzb(obj);
        if (v2 == zzd) {
            return null;
        }
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map<K, V> zzb = zzb();
        return zzb != null ? zzb.size() : this.zzg;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection<V> values() {
        Collection<V> collection = this.zzj;
        if (collection != null) {
            return collection;
        }
        f1 f1Var = new f1(this);
        this.zzj = f1Var;
        return f1Var;
    }

    public final boolean zza() {
        return this.zze == null;
    }

    @NullableDecl
    public final Map<K, V> zzb() {
        Object obj = this.zze;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final void zzc() {
        this.zzf += 32;
    }

    public final int zzd() {
        return isEmpty() ? -1 : 0;
    }

    public final Iterator<K> zze() {
        Map<K, V> zzb = zzb();
        if (zzb != null) {
            return zzb.h().iterator2();
        }
        return new a1(this);
    }

    public final Iterator<Map.Entry<K, V>> zzf() {
        Map<K, V> zzb = zzb();
        if (zzb != null) {
            return zzb.entrySet().iterator2();
        }
        return new z0(this);
    }

    public final Iterator<V> zzg() {
        Map<K, V> zzb = zzb();
        if (zzb != null) {
            return zzb.values().iterator2();
        }
        return new c1(this);
    }

    private final int zza(int i10, int i11, int i12, int i13) {
        Object d10 = i1.d(i11);
        int i14 = i11 - 1;
        if (i13 != 0) {
            i1.e(d10, i12 & i14, i13 + 1);
        }
        Object obj = this.zze;
        int[] iArr = this.zza;
        for (int i15 = 0; i15 <= i10; i15++) {
            int b4 = i1.b(obj, i15);
            while (b4 != 0) {
                int i16 = b4 - 1;
                int i17 = iArr[i16];
                int i18 = ((~i10) & i17) | i15;
                int i19 = i18 & i14;
                int b10 = i1.b(d10, i19);
                i1.e(d10, i19, b4);
                iArr[i16] = i1.a(i18, b10, i14);
                b4 = i17 & i10;
            }
        }
        this.zze = d10;
        zzb(i14);
        return i14;
    }

    public static /* synthetic */ int zzd(zzdp zzdpVar) {
        int i10 = zzdpVar.zzg;
        zzdpVar.zzg = i10 - 1;
        return i10;
    }

    private final void zzb(int i10) {
        this.zzf = i1.a(this.zzf, 32 - Integer.numberOfLeadingZeros(i10), 31);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NullableDecl
    public final Object zzb(@NullableDecl Object obj) {
        if (zza()) {
            return zzd;
        }
        int zzi = zzi();
        int c4 = i1.c(obj, null, zzi, this.zze, this.zza, this.zzb, null);
        if (c4 == -1) {
            return zzd;
        }
        Object obj2 = this.zzc[c4];
        zza(c4, zzi);
        this.zzg--;
        zzc();
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zza(@NullableDecl Object obj) {
        if (zza()) {
            return -1;
        }
        int b4 = j1.b(obj);
        int zzi = zzi();
        int b10 = i1.b(this.zze, b4 & zzi);
        if (b10 == 0) {
            return -1;
        }
        int i10 = ~zzi;
        int i11 = b4 & i10;
        do {
            int i12 = b10 - 1;
            int i13 = this.zza[i12];
            if ((i13 & i10) == i11 && k0.a(obj, this.zzb[i12])) {
                return i12;
            }
            b10 = i13 & zzi;
        } while (b10 != 0);
        return -1;
    }

    public final void zza(int i10, int i11) {
        int size = size() - 1;
        if (i10 < size) {
            Object[] objArr = this.zzb;
            Object obj = objArr[size];
            objArr[i10] = obj;
            Object[] objArr2 = this.zzc;
            objArr2[i10] = objArr2[size];
            objArr[size] = null;
            objArr2[size] = null;
            int[] iArr = this.zza;
            iArr[i10] = iArr[size];
            iArr[size] = 0;
            int b4 = j1.b(obj) & i11;
            int b10 = i1.b(this.zze, b4);
            int i12 = size + 1;
            if (b10 == i12) {
                i1.e(this.zze, b4, i10 + 1);
                return;
            }
            while (true) {
                int i13 = b10 - 1;
                int[] iArr2 = this.zza;
                int i14 = iArr2[i13];
                int i15 = i14 & i11;
                if (i15 == i12) {
                    iArr2[i13] = i1.a(i14, i10 + 1, i11);
                    return;
                }
                b10 = i15;
            }
        } else {
            this.zzb[i10] = null;
            this.zzc[i10] = null;
            this.zza[i10] = 0;
        }
    }

    public final int zza(int i10) {
        int i11 = i10 + 1;
        if (i11 < this.zzg) {
            return i11;
        }
        return -1;
    }
}
