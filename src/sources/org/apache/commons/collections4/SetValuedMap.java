package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface SetValuedMap<K, V> extends MultiValuedMap<K, V> {
    @Override // org.apache.commons.collections4.MultiValuedMap
    /* bridge */ /* synthetic */ Collection get(Object obj);

    @Override // org.apache.commons.collections4.MultiValuedMap
    Set<V> get(K k10);

    @Override // org.apache.commons.collections4.MultiValuedMap
    /* bridge */ /* synthetic */ Collection remove(Object obj);

    @Override // org.apache.commons.collections4.MultiValuedMap
    Set<V> remove(Object obj);
}
