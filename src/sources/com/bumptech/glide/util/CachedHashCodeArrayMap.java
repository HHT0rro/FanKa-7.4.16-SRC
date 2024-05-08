package com.bumptech.glide.util;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class CachedHashCodeArrayMap<K, V> extends ArrayMap<K, V> {
    private int hashCode;

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public void clear() {
        this.hashCode = 0;
        super.clear();
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = super.hashCode();
        }
        return this.hashCode;
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public V put(K k10, V v2) {
        this.hashCode = 0;
        return (V) super.put(k10, v2);
    }

    @Override // androidx.collection.SimpleArrayMap
    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this.hashCode = 0;
        super.putAll(simpleArrayMap);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V removeAt(int i10) {
        this.hashCode = 0;
        return (V) super.removeAt(i10);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V setValueAt(int i10, V v2) {
        this.hashCode = 0;
        return (V) super.setValueAt(i10, v2);
    }
}
