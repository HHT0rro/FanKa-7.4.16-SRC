package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.Transformer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class TransformedMap<K, V> extends AbstractInputCheckedMapDecorator<K, V> implements Serializable {
    private static final long serialVersionUID = 7023152376788900464L;
    public final Transformer<? super K, ? extends K> keyTransformer;
    public final Transformer<? super V, ? extends V> valueTransformer;

    public TransformedMap(Map<K, V> map, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        super(map);
        this.keyTransformer = transformer;
        this.valueTransformer = transformer2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    public static <K, V> TransformedMap<K, V> transformedMap(Map<K, V> map, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        TransformedMap<K, V> transformedMap = new TransformedMap<>(map, transformer, transformer2);
        if (map.size() > 0) {
            Map<K, V> transformMap = transformedMap.transformMap(map);
            transformedMap.clear();
            transformedMap.decorated().putAll(transformMap);
        }
        return transformedMap;
    }

    public static <K, V> TransformedMap<K, V> transformingMap(Map<K, V> map, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        return new TransformedMap<>(map, transformer, transformer2);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }

    @Override // org.apache.commons.collections4.map.AbstractInputCheckedMapDecorator
    public V checkSetValue(V v2) {
        return this.valueTransformer.transform(v2);
    }

    @Override // org.apache.commons.collections4.map.AbstractInputCheckedMapDecorator, org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // org.apache.commons.collections4.map.AbstractInputCheckedMapDecorator
    public boolean isSetValueChecking() {
        return this.valueTransformer != null;
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public V put(K k10, V v2) {
        return decorated().put(transformKey(k10), transformValue(v2));
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        decorated().putAll(transformMap(map));
    }

    public K transformKey(K k10) {
        Transformer<? super K, ? extends K> transformer = this.keyTransformer;
        return transformer == null ? k10 : transformer.transform(k10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Map<K, V> transformMap(Map<? extends K, ? extends V> map) {
        if (map.isEmpty()) {
            return map;
        }
        LinkedMap linkedMap = new LinkedMap(map.size());
        for (Map.Entry entry : map.entrySet()) {
            linkedMap.put(transformKey(entry.getKey()), transformValue(entry.getValue()));
        }
        return linkedMap;
    }

    public V transformValue(V v2) {
        Transformer<? super V, ? extends V> transformer = this.valueTransformer;
        return transformer == null ? v2 : transformer.transform(v2);
    }
}
