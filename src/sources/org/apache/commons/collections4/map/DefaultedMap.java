package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.ConstantTransformer;
import org.apache.commons.collections4.functors.FactoryTransformer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class DefaultedMap<K, V> extends AbstractMapDecorator<K, V> implements Serializable {
    private static final long serialVersionUID = 19698628745827L;
    private final Transformer<? super K, ? extends V> value;

    public DefaultedMap(V v2) {
        this(ConstantTransformer.constantTransformer(v2));
    }

    public static <K, V> DefaultedMap<K, V> defaultedMap(Map<K, V> map, V v2) {
        return new DefaultedMap<>(map, ConstantTransformer.constantTransformer(v2));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public V get(Object obj) {
        V v2 = this.map.get(obj);
        return (v2 != null || this.map.containsKey(obj)) ? v2 : this.value.transform(obj);
    }

    public DefaultedMap(Transformer<? super K, ? extends V> transformer) {
        this(new HashMap(), transformer);
    }

    public static <K, V> DefaultedMap<K, V> defaultedMap(Map<K, V> map, Factory<? extends V> factory) {
        if (factory != null) {
            return new DefaultedMap<>(map, FactoryTransformer.factoryTransformer(factory));
        }
        throw new IllegalArgumentException("Factory must not be null");
    }

    public DefaultedMap(Map<K, V> map, Transformer<? super K, ? extends V> transformer) {
        super(map);
        Objects.requireNonNull(transformer, "Transformer must not be null.");
        this.value = transformer;
    }

    public static <K, V> Map<K, V> defaultedMap(Map<K, V> map, Transformer<? super K, ? extends V> transformer) {
        if (transformer != null) {
            return new DefaultedMap(map, transformer);
        }
        throw new IllegalArgumentException("Transformer must not be null");
    }
}
