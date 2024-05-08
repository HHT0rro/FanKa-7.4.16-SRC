package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f extends k0 {

    /* renamed from: d, reason: collision with root package name */
    public final transient Map f24845d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzao f24846e;

    public f(zzao zzaoVar, Map map) {
        this.f24846e = zzaoVar;
        this.f24845d = map;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.k0
    public final Set<Map.Entry> a() {
        return new d(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        Map map;
        Map map2 = this.f24845d;
        map = this.f24846e.zza;
        if (map2 == map) {
            this.f24846e.zze();
        } else {
            e0.a(new e(this));
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return l0.b(this.f24845d, obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(@NullableDecl Object obj) {
        return this == obj || this.f24845d.equals(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        Collection collection = (Collection) l0.a(this.f24845d, obj);
        if (collection == null) {
            return null;
        }
        return this.f24846e.zza(obj, collection);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        return this.f24845d.hashCode();
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: keySet */
    public final Set h() {
        return this.f24846e.zzp();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        Collection collection = (Collection) this.f24845d.remove(obj);
        if (collection == null) {
            return null;
        }
        Collection zzc = this.f24846e.zzc();
        zzc.addAll(collection);
        zzao.zzn(this.f24846e, collection.size());
        collection.clear();
        return zzc;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f24845d.size();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        return this.f24845d.toString();
    }
}
