package org.apache.commons.collections4;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface OrderedMapIterator<K, V> extends MapIterator<K, V>, OrderedIterator<K> {
    @Override // org.apache.commons.collections4.OrderedIterator
    boolean hasPrevious();

    @Override // org.apache.commons.collections4.OrderedIterator
    K previous();
}
