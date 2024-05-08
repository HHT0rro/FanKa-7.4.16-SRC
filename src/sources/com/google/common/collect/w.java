package com.google.common.collect;

import java.util.Map;

/* compiled from: ForwardingMapEntry.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class w<K, V> extends z implements Map.Entry<K, V> {
    public boolean equals(Object obj) {
        return o().equals(obj);
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return o().getKey();
    }

    public V getValue() {
        return o().getValue();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return o().hashCode();
    }

    public abstract Map.Entry<K, V> o();

    public V setValue(V v2) {
        return o().setValue(v2);
    }

    public boolean standardEquals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return com.google.common.base.l.a(getKey(), entry.getKey()) && com.google.common.base.l.a(getValue(), entry.getValue());
    }
}
