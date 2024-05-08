package java.util;

import java.util.ImmutableCollections;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface Map<K, V> {
    void clear();

    boolean containsKey(Object obj);

    boolean containsValue(Object obj);

    Set<Entry<K, V>> entrySet();

    boolean equals(Object obj);

    V get(Object obj);

    int hashCode();

    boolean isEmpty();

    Set<K> keySet();

    V put(K k10, V v2);

    void putAll(Map<? extends K, ? extends V> map);

    V remove(Object obj);

    int size();

    Collection<V> values();

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface Entry<K, V> {
        boolean equals(Object obj);

        K getKey();

        V getValue();

        int hashCode();

        V setValue(V v2);

        static <K extends Comparable<? super K>, V> Comparator<Entry<K, V>> comparingByKey() {
            return new Map$Entry$$ExternalSyntheticLambda0();
        }

        static <K, V extends Comparable<? super V>> Comparator<Entry<K, V>> comparingByValue() {
            return new Map$Entry$$ExternalSyntheticLambda1();
        }

        static <K, V> Comparator<Entry<K, V>> comparingByKey(Comparator<? super K> cmp) {
            Objects.requireNonNull(cmp);
            return new Map$Entry$$ExternalSyntheticLambda2(cmp);
        }

        static <K, V> Comparator<Entry<K, V>> comparingByValue(Comparator<? super V> cmp) {
            Objects.requireNonNull(cmp);
            return new Map$Entry$$ExternalSyntheticLambda3(cmp);
        }

        /* JADX WARN: Multi-variable type inference failed */
        static <K, V> Entry<K, V> copyOf(Entry<? extends K, ? extends V> entry) {
            Objects.requireNonNull(entry);
            if (entry instanceof KeyValueHolder) {
                return entry;
            }
            return Map.entry(entry.getKey(), entry.getValue());
        }
    }

    default V getOrDefault(Object key, V defaultValue) {
        V v2 = get(key);
        if (v2 != null || containsKey(key)) {
            return v2;
        }
        return defaultValue;
    }

    default void forEach(BiConsumer<? super K, ? super V> action) {
        Objects.requireNonNull(action);
        for (Entry<K, V> entry : entrySet()) {
            try {
                K k10 = entry.getKey();
                V v2 = entry.getValue();
                action.accept(k10, v2);
            } catch (IllegalStateException ise) {
                throw new ConcurrentModificationException(ise);
            }
        }
    }

    default void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
        Objects.requireNonNull(biFunction);
        for (Entry<K, V> entry : entrySet()) {
            try {
                try {
                    entry.setValue(biFunction.apply(entry.getKey(), entry.getValue()));
                } catch (IllegalStateException e2) {
                    throw new ConcurrentModificationException(e2);
                }
            } catch (IllegalStateException e10) {
                throw new ConcurrentModificationException(e10);
            }
        }
    }

    default V putIfAbsent(K key, V value) {
        V v2 = get(key);
        if (v2 == null) {
            return put(key, value);
        }
        return v2;
    }

    default boolean remove(Object key, Object value) {
        Object curValue = get(key);
        if (Objects.equals(curValue, value)) {
            if (curValue == null && !containsKey(key)) {
                return false;
            }
            remove(key);
            return true;
        }
        return false;
    }

    default boolean replace(K key, V oldValue, V newValue) {
        Object curValue = get(key);
        if (Objects.equals(curValue, oldValue)) {
            if (curValue == null && !containsKey(key)) {
                return false;
            }
            put(key, newValue);
            return true;
        }
        return false;
    }

    default V replace(K key, V value) {
        V curValue = get(key);
        return (curValue != null || containsKey(key)) ? put(key, value) : curValue;
    }

    default V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        V newValue;
        Objects.requireNonNull(mappingFunction);
        V v2 = get(key);
        if (v2 != null || (newValue = mappingFunction.apply(key)) == null) {
            return v2;
        }
        put(key, newValue);
        return newValue;
    }

    default V computeIfPresent(K k10, BiFunction<? super K, ? super V, ? extends V> biFunction) {
        Objects.requireNonNull(biFunction);
        V v2 = get(k10);
        if (v2 == null) {
            return null;
        }
        V apply = biFunction.apply(k10, v2);
        if (apply != null) {
            put(k10, apply);
            return apply;
        }
        remove(k10);
        return null;
    }

    default V compute(K k10, BiFunction<? super K, ? super V, ? extends V> biFunction) {
        Objects.requireNonNull(biFunction);
        V v2 = get(k10);
        V apply = biFunction.apply(k10, v2);
        if (apply != null) {
            put(k10, apply);
            return apply;
        }
        if (v2 == null && !containsKey(k10)) {
            return null;
        }
        remove(k10);
        return null;
    }

    default V merge(K k10, V v2, BiFunction<? super V, ? super V, ? extends V> biFunction) {
        Objects.requireNonNull(biFunction);
        Objects.requireNonNull(v2);
        V v10 = get(k10);
        V apply = v10 == null ? v2 : biFunction.apply(v10, v2);
        if (apply == null) {
            remove(k10);
        } else {
            put(k10, apply);
        }
        return apply;
    }

    static <K, V> Map<K, V> of() {
        return ImmutableCollections.EMPTY_MAP;
    }

    static <K, V> Map<K, V> of(K k12, V v12) {
        return new ImmutableCollections.Map1(k12, v12);
    }

    static <K, V> Map<K, V> of(K k12, V v12, K k22, V v2) {
        return new ImmutableCollections.MapN(k12, v12, k22, v2);
    }

    static <K, V> Map<K, V> of(K k12, V v12, K k22, V v2, K k32, V v32) {
        return new ImmutableCollections.MapN(k12, v12, k22, v2, k32, v32);
    }

    static <K, V> Map<K, V> of(K k12, V v12, K k22, V v2, K k32, V v32, K k42, V v42) {
        return new ImmutableCollections.MapN(k12, v12, k22, v2, k32, v32, k42, v42);
    }

    static <K, V> Map<K, V> of(K k12, V v12, K k22, V v2, K k32, V v32, K k42, V v42, K k52, V v52) {
        return new ImmutableCollections.MapN(k12, v12, k22, v2, k32, v32, k42, v42, k52, v52);
    }

    static <K, V> Map<K, V> of(K k12, V v12, K k22, V v2, K k32, V v32, K k42, V v42, K k52, V v52, K k62, V v62) {
        return new ImmutableCollections.MapN(k12, v12, k22, v2, k32, v32, k42, v42, k52, v52, k62, v62);
    }

    static <K, V> Map<K, V> of(K k12, V v12, K k22, V v2, K k32, V v32, K k42, V v42, K k52, V v52, K k62, V v62, K k72, V v72) {
        return new ImmutableCollections.MapN(k12, v12, k22, v2, k32, v32, k42, v42, k52, v52, k62, v62, k72, v72);
    }

    static <K, V> Map<K, V> of(K k12, V v12, K k22, V v2, K k32, V v32, K k42, V v42, K k52, V v52, K k62, V v62, K k72, V v72, K k82, V v82) {
        return new ImmutableCollections.MapN(k12, v12, k22, v2, k32, v32, k42, v42, k52, v52, k62, v62, k72, v72, k82, v82);
    }

    static <K, V> Map<K, V> of(K k12, V v12, K k22, V v2, K k32, V v32, K k42, V v42, K k52, V v52, K k62, V v62, K k72, V v72, K k82, V v82, K k92, V v92) {
        return new ImmutableCollections.MapN(k12, v12, k22, v2, k32, v32, k42, v42, k52, v52, k62, v62, k72, v72, k82, v82, k92, v92);
    }

    static <K, V> Map<K, V> of(K k12, V v12, K k22, V v2, K k32, V v32, K k42, V v42, K k52, V v52, K k62, V v62, K k72, V v72, K k82, V v82, K k92, V v92, K k10, V v10) {
        return new ImmutableCollections.MapN(k12, v12, k22, v2, k32, v32, k42, v42, k52, v52, k62, v62, k72, v72, k82, v82, k92, v92, k10, v10);
    }

    @SafeVarargs
    static <K, V> Map<K, V> ofEntries(Entry<? extends K, ? extends V>... entries) {
        if (entries.length == 0) {
            Map<K, V> map = ImmutableCollections.EMPTY_MAP;
            return map;
        }
        if (entries.length == 1) {
            return new ImmutableCollections.Map1(entries[0].getKey(), entries[0].getValue());
        }
        Object[] kva = new Object[entries.length << 1];
        int a10 = 0;
        for (Entry<? extends K, ? extends V> entry : entries) {
            int a11 = a10 + 1;
            kva[a10] = entry.getKey();
            a10 = a11 + 1;
            kva[a11] = entry.getValue();
        }
        return new ImmutableCollections.MapN(kva);
    }

    static <K, V> Entry<K, V> entry(K k10, V v2) {
        return new KeyValueHolder(k10, v2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <K, V> Map<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if (map instanceof ImmutableCollections.AbstractImmutableMap) {
            return map;
        }
        return ofEntries((Entry[]) map.entrySet().toArray(new Entry[0]));
    }
}
