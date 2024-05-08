package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class EmptyOrderedMapIterator<K, V> extends AbstractEmptyMapIterator<K, V> implements OrderedMapIterator<K, V>, ResettableIterator<K> {
    public static final OrderedMapIterator INSTANCE = new EmptyOrderedMapIterator();

    public static <K, V> OrderedMapIterator<K, V> emptyOrderedMapIterator() {
        return INSTANCE;
    }
}
