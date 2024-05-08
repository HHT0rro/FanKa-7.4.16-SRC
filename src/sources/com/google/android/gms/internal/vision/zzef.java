package com.google.android.gms.internal.vision;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class zzef<K, V> implements Serializable, Map<K, V> {
    private static final Map.Entry<?, ?>[] zza = new Map.Entry[0];
    private transient zzej<Map.Entry<K, V>> zzb;
    private transient zzej<K> zzc;
    private transient zzeb<V> zzd;

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        return ((zzeb) values()).contains(obj);
    }

    @Override // java.util.Map
    public /* synthetic */ Set entrySet() {
        zzej<Map.Entry<K, V>> zzejVar = this.zzb;
        if (zzejVar != null) {
            return zzejVar;
        }
        zzej<Map.Entry<K, V>> zza2 = zza();
        this.zzb = zza2;
        return zza2;
    }

    @Override // java.util.Map
    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    public abstract V get(@NullableDecl Object obj);

    @Override // java.util.Map
    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v2) {
        V v10 = get(obj);
        return v10 != null ? v10 : v2;
    }

    @Override // java.util.Map
    public int hashCode() {
        return o1.a((zzej) entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    /* renamed from: keySet */
    public /* synthetic */ Set h() {
        zzej<K> zzejVar = this.zzc;
        if (zzejVar != null) {
            return zzejVar;
        }
        zzej<K> zzb = zzb();
        this.zzc = zzb;
        return zzb;
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K k10, V v2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        int size = size();
        if (size >= 0) {
            StringBuilder sb2 = new StringBuilder((int) Math.min(size << 3, 1073741824L));
            sb2.append('{');
            boolean z10 = true;
            for (Map.Entry<K, V> entry : entrySet()) {
                if (!z10) {
                    sb2.append(", ");
                }
                z10 = false;
                sb2.append((Object) entry.getKey());
                sb2.append('=');
                sb2.append((Object) entry.getValue());
            }
            sb2.append('}');
            return sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder("size".length() + 40);
        sb3.append("size");
        sb3.append(" cannot be negative but was: ");
        sb3.append(size);
        throw new IllegalArgumentException(sb3.toString());
    }

    @Override // java.util.Map
    public /* synthetic */ Collection values() {
        zzeb<V> zzebVar = this.zzd;
        if (zzebVar != null) {
            return zzebVar;
        }
        zzeb<V> zzc = zzc();
        this.zzd = zzc;
        return zzc;
    }

    public abstract zzej<Map.Entry<K, V>> zza();

    public abstract zzej<K> zzb();

    public abstract zzeb<V> zzc();
}
