package org.apache.commons.collections4;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface OrderedBidiMap<K, V> extends BidiMap<K, V>, OrderedMap<K, V> {
    @Override // org.apache.commons.collections4.BidiMap
    /* bridge */ /* synthetic */ BidiMap inverseBidiMap();

    @Override // org.apache.commons.collections4.BidiMap
    OrderedBidiMap<V, K> inverseBidiMap();
}
