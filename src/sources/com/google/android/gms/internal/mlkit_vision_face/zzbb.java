package com.google.android.gms.internal.mlkit_vision_face;

import android.view.View;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zzbb<K, V> extends AbstractMap<K, V> implements Serializable {
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

    public zzbb() {
        zza(3);
    }

    public static /* synthetic */ int zzn(zzbb zzbbVar) {
        int i10 = zzbbVar.zzg;
        zzbbVar.zzg = i10 - 1;
        return i10;
    }

    private final void zzo(int i10) {
        this.zzf = ((32 - Integer.numberOfLeadingZeros(i10)) & 31) | (this.zzf & (-32));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zzp() {
        return (1 << (this.zzf & 31)) - 1;
    }

    private final int zzq(int i10, int i11, int i12, int i13) {
        Object a10 = x.a(i11);
        int i14 = i11 - 1;
        if (i13 != 0) {
            x.c(a10, i12 & i14, i13 + 1);
        }
        Object obj = this.zze;
        int[] iArr = this.zza;
        for (int i15 = 0; i15 <= i10; i15++) {
            int b4 = x.b(obj, i15);
            while (b4 != 0) {
                int i16 = b4 - 1;
                int i17 = iArr[i16];
                int i18 = ((~i10) & i17) | i15;
                int i19 = i18 & i14;
                int b10 = x.b(a10, i19);
                x.c(a10, i19, b4);
                iArr[i16] = ((~i14) & i18) | (b10 & i14);
                b4 = i17 & i10;
            }
        }
        this.zze = a10;
        zzo(i14);
        return i14;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zzr(@NullableDecl Object obj) {
        if (zzb()) {
            return -1;
        }
        int b4 = y.b(obj);
        int zzp = zzp();
        int b10 = x.b(this.zze, b4 & zzp);
        if (b10 != 0) {
            int i10 = ~zzp;
            int i11 = b4 & i10;
            do {
                int i12 = b10 - 1;
                int i13 = this.zza[i12];
                if ((i13 & i10) == i11 && w9.a(obj, this.zzb[i12])) {
                    return i12;
                }
                b10 = i13 & zzp;
            } while (b10 != 0);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NullableDecl
    public final Object zzs(@NullableDecl Object obj) {
        if (zzb()) {
            return zzd;
        }
        int zzp = zzp();
        int e2 = x.e(obj, null, zzp, this.zze, this.zza, this.zzb, null);
        if (e2 == -1) {
            return zzd;
        }
        Object obj2 = this.zzc[e2];
        zze(e2, zzp);
        this.zzg--;
        zzd();
        return obj2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (zzb()) {
            return;
        }
        zzd();
        Map<K, V> zzc = zzc();
        if (zzc != null) {
            this.zzf = v0.a(size(), 3, View.LAST_APP_AUTOFILL_ID);
            zzc.clear();
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
        Map<K, V> zzc = zzc();
        if (zzc != null) {
            return zzc.containsKey(obj);
        }
        return zzr(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(@NullableDecl Object obj) {
        Map<K, V> zzc = zzc();
        if (zzc != null) {
            return zzc.containsValue(obj);
        }
        for (int i10 = 0; i10 < this.zzg; i10++) {
            if (w9.a(obj, this.zzc[i10])) {
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
        s sVar = new s(this);
        this.zzi = sVar;
        return sVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(@NullableDecl Object obj) {
        Map<K, V> zzc = zzc();
        if (zzc != null) {
            return zzc.get(obj);
        }
        int zzr = zzr(obj);
        if (zzr == -1) {
            return null;
        }
        return (V) this.zzc[zzr];
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
        u uVar = new u(this);
        this.zzh = uVar;
        return uVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public final V put(@NullableDecl K k10, @NullableDecl V v2) {
        int min;
        if (zzb()) {
            a.a(zzb(), "Arrays already allocated");
            int i10 = this.zzf;
            int max = Math.max(i10 + 1, 2);
            int highestOneBit = Integer.highestOneBit(max);
            if (max > highestOneBit && (highestOneBit = highestOneBit + highestOneBit) <= 0) {
                highestOneBit = 1073741824;
            }
            int max2 = Math.max(4, highestOneBit);
            this.zze = x.a(max2);
            zzo(max2 - 1);
            this.zza = new int[i10];
            this.zzb = new Object[i10];
            this.zzc = new Object[i10];
        }
        Map<K, V> zzc = zzc();
        if (zzc != null) {
            return zzc.put(k10, v2);
        }
        int[] iArr = this.zza;
        Object[] objArr = this.zzb;
        Object[] objArr2 = this.zzc;
        int i11 = this.zzg;
        int i12 = i11 + 1;
        int b4 = y.b(k10);
        int zzp = zzp();
        int i13 = b4 & zzp;
        int b10 = x.b(this.zze, i13);
        if (b10 != 0) {
            int i14 = ~zzp;
            int i15 = b4 & i14;
            int i16 = 0;
            while (true) {
                int i17 = b10 - 1;
                int i18 = iArr[i17];
                int i19 = i18 & i14;
                if (i19 == i15 && w9.a(k10, objArr[i17])) {
                    V v10 = (V) objArr2[i17];
                    objArr2[i17] = v2;
                    return v10;
                }
                int i20 = i18 & zzp;
                i16++;
                if (i20 != 0) {
                    b10 = i20;
                } else {
                    if (i16 >= 9) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(zzp() + 1, 1.0f);
                        int zzf = zzf();
                        while (zzf >= 0) {
                            linkedHashMap.put(this.zzb[zzf], this.zzc[zzf]);
                            zzf = zzg(zzf);
                        }
                        this.zze = linkedHashMap;
                        this.zza = null;
                        this.zzb = null;
                        this.zzc = null;
                        zzd();
                        return (V) linkedHashMap.put(k10, v2);
                    }
                    if (i12 > zzp) {
                        zzp = zzq(zzp, x.d(zzp), b4, i11);
                    } else {
                        iArr[i17] = (i12 & zzp) | i19;
                    }
                }
            }
        } else if (i12 > zzp) {
            zzp = zzq(zzp, x.d(zzp), b4, i11);
        } else {
            x.c(this.zze, i13, i12);
        }
        int length = this.zza.length;
        if (i12 > length && (min = Math.min(View.LAST_APP_AUTOFILL_ID, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            this.zza = Arrays.copyOf(this.zza, min);
            this.zzb = Arrays.copyOf(this.zzb, min);
            this.zzc = Arrays.copyOf(this.zzc, min);
        }
        this.zza[i11] = (~zzp) & b4;
        this.zzb[i11] = k10;
        this.zzc[i11] = v2;
        this.zzg = i12;
        zzd();
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public final V remove(@NullableDecl Object obj) {
        Map<K, V> zzc = zzc();
        if (zzc != null) {
            return zzc.remove(obj);
        }
        V v2 = (V) zzs(obj);
        if (v2 == zzd) {
            return null;
        }
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map<K, V> zzc = zzc();
        return zzc != null ? zzc.size() : this.zzg;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection<V> values() {
        Collection<V> collection = this.zzj;
        if (collection != null) {
            return collection;
        }
        w wVar = new w(this);
        this.zzj = wVar;
        return wVar;
    }

    public final void zza(int i10) {
        this.zzf = v0.a(12, 1, View.LAST_APP_AUTOFILL_ID);
    }

    public final boolean zzb() {
        return this.zze == null;
    }

    @NullableDecl
    public final Map<K, V> zzc() {
        Object obj = this.zze;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final void zzd() {
        this.zzf += 32;
    }

    public final void zze(int i10, int i11) {
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
            int b4 = y.b(obj) & i11;
            int b10 = x.b(this.zze, b4);
            int i12 = size + 1;
            if (b10 == i12) {
                x.c(this.zze, b4, i10 + 1);
                return;
            }
            while (true) {
                int i13 = b10 - 1;
                int[] iArr2 = this.zza;
                int i14 = iArr2[i13];
                int i15 = i14 & i11;
                if (i15 == i12) {
                    iArr2[i13] = ((i10 + 1) & i11) | ((~i11) & i14);
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

    public final int zzf() {
        return isEmpty() ? -1 : 0;
    }

    public final int zzg(int i10) {
        int i11 = i10 + 1;
        if (i11 < this.zzg) {
            return i11;
        }
        return -1;
    }

    public zzbb(int i10) {
        zza(12);
    }
}
