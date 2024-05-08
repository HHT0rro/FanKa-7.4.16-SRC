package org.apache.commons.collections4.keyvalue;

import org.apache.commons.collections4.KeyValue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractKeyValue<K, V> implements KeyValue<K, V> {
    private K key;
    private V value;

    public AbstractKeyValue(K k10, V v2) {
        this.key = k10;
        this.value = v2;
    }

    @Override // org.apache.commons.collections4.KeyValue
    public K getKey() {
        return this.key;
    }

    @Override // org.apache.commons.collections4.KeyValue
    public V getValue() {
        return this.value;
    }

    public K setKey(K k10) {
        K k11 = this.key;
        this.key = k10;
        return k11;
    }

    public V setValue(V v2) {
        V v10 = this.value;
        this.value = v2;
        return v10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) getKey());
        sb2.append('=');
        sb2.append((Object) getValue());
        return sb2.toString();
    }
}
