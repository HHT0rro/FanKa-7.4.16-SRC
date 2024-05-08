package org.apache.commons.collections4.trie;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.Trie;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractBitwiseTrie<K, V> extends AbstractMap<K, V> implements Trie<K, V>, Serializable {
    private static final long serialVersionUID = 5826987063535505652L;
    private final KeyAnalyzer<? super K> keyAnalyzer;

    public AbstractBitwiseTrie(KeyAnalyzer<? super K> keyAnalyzer) {
        Objects.requireNonNull(keyAnalyzer, "keyAnalyzer");
        this.keyAnalyzer = keyAnalyzer;
    }

    public static boolean compare(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public final int bitIndex(K k10, K k11) {
        return this.keyAnalyzer.bitIndex(k10, 0, lengthInBits(k10), k11, 0, lengthInBits(k11));
    }

    public final int bitsPerElement() {
        return this.keyAnalyzer.bitsPerElement();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final K castKey(Object obj) {
        return obj;
    }

    public final boolean compareKeys(K k10, K k11) {
        return k10 == null ? k11 == null : k11 != null && this.keyAnalyzer.compare(k10, k11) == 0;
    }

    public KeyAnalyzer<? super K> getKeyAnalyzer() {
        return this.keyAnalyzer;
    }

    public final boolean isBitSet(K k10, int i10, int i11) {
        if (k10 == null) {
            return false;
        }
        return this.keyAnalyzer.isBitSet(k10, i10, i11);
    }

    public final int lengthInBits(K k10) {
        if (k10 == null) {
            return 0;
        }
        return this.keyAnalyzer.lengthInBits(k10);
    }

    @Override // org.apache.commons.collections4.OrderedMap, org.apache.commons.collections4.IterableGet
    public /* bridge */ /* synthetic */ MapIterator mapIterator() {
        MapIterator mapIterator;
        mapIterator = mapIterator();
        return mapIterator;
    }

    @Override // java.util.AbstractMap
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Trie[");
        sb2.append(size());
        sb2.append("]={\n");
        for (Map.Entry<K, V> entry : entrySet()) {
            sb2.append("  ");
            sb2.append((Object) entry);
            sb2.append("\n");
        }
        sb2.append("}\n");
        return sb2.toString();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class BasicEntry<K, V> implements Map.Entry<K, V>, Serializable {
        private static final long serialVersionUID = -944364551314110330L;
        public K key;
        public V value;

        public BasicEntry(K k10) {
            this.key = k10;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return AbstractBitwiseTrie.compare(this.key, entry.getKey()) && AbstractBitwiseTrie.compare(this.value, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() != null ? getValue().hashCode() : 0);
        }

        public V setKeyValue(K k10, V v2) {
            this.key = k10;
            return setValue(v2);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v2) {
            V v10 = this.value;
            this.value = v2;
            return v10;
        }

        public String toString() {
            return ((Object) this.key) + "=" + ((Object) this.value);
        }

        public BasicEntry(K k10, V v2) {
            this.key = k10;
            this.value = v2;
        }
    }
}
