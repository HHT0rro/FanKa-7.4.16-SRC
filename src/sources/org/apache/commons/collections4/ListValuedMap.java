package org.apache.commons.collections4;

import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface ListValuedMap<K, V> extends MultiValuedMap<K, V> {
    @Override // org.apache.commons.collections4.MultiValuedMap
    /* bridge */ /* synthetic */ Collection get(Object obj);

    @Override // org.apache.commons.collections4.MultiValuedMap
    List<V> get(K k10);

    @Override // org.apache.commons.collections4.MultiValuedMap
    /* bridge */ /* synthetic */ Collection remove(Object obj);

    @Override // org.apache.commons.collections4.MultiValuedMap
    List<V> remove(Object obj);
}
