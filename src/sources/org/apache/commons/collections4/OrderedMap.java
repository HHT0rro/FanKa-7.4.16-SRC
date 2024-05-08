package org.apache.commons.collections4;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface OrderedMap<K, V> extends IterableMap<K, V> {
    K firstKey();

    K lastKey();

    @Override // org.apache.commons.collections4.IterableGet
    /* bridge */ /* synthetic */ MapIterator mapIterator();

    @Override // org.apache.commons.collections4.IterableGet
    OrderedMapIterator<K, V> mapIterator();

    K nextKey(K k10);

    K previousKey(K k10);
}
