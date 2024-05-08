package org.apache.commons.collections4;

import java.util.Comparator;
import java.util.SortedMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface SortedBidiMap<K, V> extends OrderedBidiMap<K, V>, SortedMap<K, V> {
    @Override // org.apache.commons.collections4.OrderedBidiMap, org.apache.commons.collections4.BidiMap
    /* bridge */ /* synthetic */ BidiMap inverseBidiMap();

    @Override // org.apache.commons.collections4.OrderedBidiMap, org.apache.commons.collections4.BidiMap
    /* bridge */ /* synthetic */ OrderedBidiMap inverseBidiMap();

    @Override // org.apache.commons.collections4.OrderedBidiMap, org.apache.commons.collections4.BidiMap
    SortedBidiMap<V, K> inverseBidiMap();

    Comparator<? super V> valueComparator();
}
