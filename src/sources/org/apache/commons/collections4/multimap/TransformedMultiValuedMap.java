package org.apache.commons.collections4.multimap;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.FluentIterable;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.Transformer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class TransformedMultiValuedMap<K, V> extends AbstractMultiValuedMapDecorator<K, V> {
    private static final long serialVersionUID = 20150612;
    private final Transformer<? super K, ? extends K> keyTransformer;
    private final Transformer<? super V, ? extends V> valueTransformer;

    public TransformedMultiValuedMap(MultiValuedMap<K, V> multiValuedMap, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        super(multiValuedMap);
        this.keyTransformer = transformer;
        this.valueTransformer = transformer2;
    }

    public static <K, V> TransformedMultiValuedMap<K, V> transformedMap(MultiValuedMap<K, V> multiValuedMap, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        TransformedMultiValuedMap<K, V> transformedMultiValuedMap = new TransformedMultiValuedMap<>(multiValuedMap, transformer, transformer2);
        if (!multiValuedMap.isEmpty()) {
            ArrayListValuedHashMap arrayListValuedHashMap = new ArrayListValuedHashMap(multiValuedMap);
            transformedMultiValuedMap.clear();
            transformedMultiValuedMap.putAll(arrayListValuedHashMap);
        }
        return transformedMultiValuedMap;
    }

    public static <K, V> TransformedMultiValuedMap<K, V> transformingMap(MultiValuedMap<K, V> multiValuedMap, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        return new TransformedMultiValuedMap<>(multiValuedMap, transformer, transformer2);
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public boolean put(K k10, V v2) {
        return decorated().put(transformKey(k10), transformValue(v2));
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(K k10, Iterable<? extends V> iterable) {
        Objects.requireNonNull(iterable, "Values must not be null.");
        Iterator<E> iterator2 = FluentIterable.of((Iterable) iterable).transform(this.valueTransformer).iterator2();
        return iterator2.hasNext() && CollectionUtils.addAll(decorated().get(transformKey(k10)), iterator2);
    }

    public K transformKey(K k10) {
        Transformer<? super K, ? extends K> transformer = this.keyTransformer;
        return transformer == null ? k10 : transformer.transform(k10);
    }

    public V transformValue(V v2) {
        Transformer<? super V, ? extends V> transformer = this.valueTransformer;
        return transformer == null ? v2 : transformer.transform(v2);
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(Map<? extends K, ? extends V> map) {
        Objects.requireNonNull(map, "Map must not be null.");
        boolean z10 = false;
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            z10 |= put(entry.getKey(), entry.getValue());
        }
        return z10;
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMapDecorator, org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(MultiValuedMap<? extends K, ? extends V> multiValuedMap) {
        Objects.requireNonNull(multiValuedMap, "Map must not be null.");
        boolean z10 = false;
        for (Map.Entry<? extends K, ? extends V> entry : multiValuedMap.entries()) {
            z10 |= put(entry.getKey(), entry.getValue());
        }
        return z10;
    }
}
