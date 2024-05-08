package com.google.android.gms.internal.mlkit_vision_face;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class zzao<K, V> extends o<K, V> implements Serializable {
    private transient Map<K, Collection<V>> zza;
    private transient int zzb;

    public zzao(Map<K, Collection<V>> map) {
        if (map.isEmpty()) {
            this.zza = map;
            return;
        }
        throw new IllegalArgumentException();
    }

    public static /* synthetic */ Map zzj(zzao zzaoVar) {
        return zzaoVar.zza;
    }

    public static /* synthetic */ int zzk(zzao zzaoVar) {
        int i10 = zzaoVar.zzb;
        zzaoVar.zzb = i10 - 1;
        return i10;
    }

    public static /* synthetic */ int zzl(zzao zzaoVar) {
        int i10 = zzaoVar.zzb;
        zzaoVar.zzb = i10 + 1;
        return i10;
    }

    public static /* synthetic */ int zzm(zzao zzaoVar, int i10) {
        int i11 = zzaoVar.zzb + i10;
        zzaoVar.zzb = i11;
        return i11;
    }

    public static /* synthetic */ int zzn(zzao zzaoVar, int i10) {
        int i11 = zzaoVar.zzb - i10;
        zzaoVar.zzb = i11;
        return i11;
    }

    public static /* synthetic */ void zzo(zzao zzaoVar, Object obj) {
        Collection<V> collection;
        Map<K, Collection<V>> map = zzaoVar.zza;
        Objects.requireNonNull(map);
        try {
            collection = map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            collection = null;
        }
        Collection<V> collection2 = collection;
        if (collection2 != null) {
            int size = collection2.size();
            collection2.clear();
            zzaoVar.zzb -= size;
        }
    }

    public Collection<V> zza(@NullableDecl K k10, Collection<V> collection) {
        throw null;
    }

    public abstract Collection<V> zzc();

    @Override // com.google.android.gms.internal.mlkit_vision_face.o, com.google.android.gms.internal.mlkit_vision_face.m0
    public final boolean zzd(@NullableDecl K k10, @NullableDecl V v2) {
        Collection<V> collection = this.zza.get(k10);
        if (collection == null) {
            Collection<V> zzc = zzc();
            if (zzc.add(v2)) {
                this.zzb++;
                this.zza.put(k10, zzc);
                return true;
            }
            throw new AssertionError((Object) "New Collection violated the Collection spec");
        }
        if (!collection.add(v2)) {
            return false;
        }
        this.zzb++;
        return true;
    }

    public final void zze() {
        Iterator<Collection<V>> iterator2 = this.zza.values().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().clear();
        }
        this.zza.clear();
        this.zzb = 0;
    }

    public final Collection<V> zzf(@NullableDecl K k10) {
        Collection<V> collection = this.zza.get(k10);
        if (collection == null) {
            collection = zzc();
        }
        return zza(k10, collection);
    }

    public final List<V> zzg(@NullableDecl K k10, List<V> list, @NullableDecl k kVar) {
        if (list instanceof RandomAccess) {
            return new i(this, k10, list, kVar);
        }
        return new m(this, k10, list, kVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.o
    public final Set<K> zzh() {
        return new h(this, this.zza);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.o
    public final Map<K, Collection<V>> zzi() {
        return new f(this, this.zza);
    }
}
