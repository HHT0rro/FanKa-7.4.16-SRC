package com.google.android.gms.internal.mlkit_vision_face;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class k0<K, V> extends AbstractMap<K, V> {

    /* renamed from: b, reason: collision with root package name */
    @NullableDecl
    public transient Set<Map.Entry<K, V>> f24992b;

    /* renamed from: c, reason: collision with root package name */
    @NullableDecl
    public transient Collection<V> f24993c;

    public abstract Set<Map.Entry<K, V>> a();

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f24992b;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> a10 = a();
        this.f24992b = a10;
        return a10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection<V> values() {
        Collection<V> collection = this.f24993c;
        if (collection != null) {
            return collection;
        }
        j0 j0Var = new j0(this);
        this.f24993c = j0Var;
        return j0Var;
    }
}
