package java.util;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class KeyValueHolder<K, V> implements Map.Entry<K, V> {
    final K key;
    final V value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KeyValueHolder(K k10, V v2) {
        this.key = (K) Objects.requireNonNull(k10);
        this.value = (V) Objects.requireNonNull(v2);
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
    public V setValue(V value) {
        throw new UnsupportedOperationException("not supported");
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object o10) {
        if (o10 instanceof Map.Entry) {
            Map.Entry<?, ?> e2 = (Map.Entry) o10;
            if (this.key.equals(e2.getKey()) && this.value.equals(e2.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return this.key.hashCode() ^ this.value.hashCode();
    }

    public String toString() {
        return ((Object) this.key) + "=" + ((Object) this.value);
    }
}
