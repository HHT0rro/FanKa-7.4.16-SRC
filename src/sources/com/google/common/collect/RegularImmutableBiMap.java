package com.google.common.collect;

import com.google.common.collect.RegularImmutableMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
final class RegularImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    public static final RegularImmutableBiMap<Object, Object> EMPTY = new RegularImmutableBiMap<>();
    public final transient Object[] alternatingKeysAndValues;
    private final transient RegularImmutableBiMap<V, K> inverse;
    private final transient Object keyHashTable;
    private final transient int keyOffset;
    private final transient int size;

    /* JADX WARN: Multi-variable type inference failed */
    private RegularImmutableBiMap() {
        this.keyHashTable = null;
        this.alternatingKeysAndValues = new Object[0];
        this.keyOffset = 0;
        this.size = 0;
        this.inverse = this;
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new RegularImmutableMap.EntrySet(this, this.alternatingKeysAndValues, this.keyOffset, this.size);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        return new RegularImmutableMap.KeySet(this, new RegularImmutableMap.KeysOrValuesAsList(this.alternatingKeysAndValues, this.keyOffset, this.size));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        V v2 = (V) RegularImmutableMap.get(this.keyHashTable, this.alternatingKeysAndValues, this.size, this.keyOffset, obj);
        if (v2 == null) {
            return null;
        }
        return v2;
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.k
    public ImmutableBiMap<V, K> inverse() {
        return this.inverse;
    }

    public RegularImmutableBiMap(Object[] objArr, int i10) {
        this.alternatingKeysAndValues = objArr;
        this.size = i10;
        this.keyOffset = 0;
        int chooseTableSize = i10 >= 2 ? ImmutableSet.chooseTableSize(i10) : 0;
        this.keyHashTable = RegularImmutableMap.createHashTableOrThrow(objArr, i10, chooseTableSize, 0);
        this.inverse = new RegularImmutableBiMap<>(RegularImmutableMap.createHashTableOrThrow(objArr, i10, chooseTableSize, 1), objArr, i10, this);
    }

    private RegularImmutableBiMap(Object obj, Object[] objArr, int i10, RegularImmutableBiMap<V, K> regularImmutableBiMap) {
        this.keyHashTable = obj;
        this.alternatingKeysAndValues = objArr;
        this.keyOffset = 1;
        this.size = i10;
        this.inverse = regularImmutableBiMap;
    }
}