package org.apache.commons.collections4;

import java.util.Collection;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface MultiMap<K, V> extends IterableMap<K, Object> {
    @Override // java.util.Map
    boolean containsValue(Object obj);

    @Override // java.util.Map
    Object get(Object obj);

    @Override // java.util.Map
    Object put(K k10, Object obj);

    @Override // java.util.Map
    Object remove(Object obj);

    boolean removeMapping(K k10, V v2);

    @Override // java.util.Map
    int size();

    @Override // java.util.Map
    Collection<Object> values();
}
