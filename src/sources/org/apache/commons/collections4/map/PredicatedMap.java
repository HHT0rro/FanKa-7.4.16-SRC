package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.Predicate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class PredicatedMap<K, V> extends AbstractInputCheckedMapDecorator<K, V> implements Serializable {
    private static final long serialVersionUID = 7412622456128415156L;
    public final Predicate<? super K> keyPredicate;
    public final Predicate<? super V> valuePredicate;

    public PredicatedMap(Map<K, V> map, Predicate<? super K> predicate, Predicate<? super V> predicate2) {
        super(map);
        this.keyPredicate = predicate;
        this.valuePredicate = predicate2;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            validate(entry.getKey(), entry.getValue());
        }
    }

    public static <K, V> PredicatedMap<K, V> predicatedMap(Map<K, V> map, Predicate<? super K> predicate, Predicate<? super V> predicate2) {
        return new PredicatedMap<>(map, predicate, predicate2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }

    @Override // org.apache.commons.collections4.map.AbstractInputCheckedMapDecorator
    public V checkSetValue(V v2) {
        if (this.valuePredicate.evaluate(v2)) {
            return v2;
        }
        throw new IllegalArgumentException("Cannot set value - Predicate rejected it");
    }

    @Override // org.apache.commons.collections4.map.AbstractInputCheckedMapDecorator, org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // org.apache.commons.collections4.map.AbstractInputCheckedMapDecorator
    public boolean isSetValueChecking() {
        return this.valuePredicate != null;
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public V put(K k10, V v2) {
        validate(k10, v2);
        return this.map.put(k10, v2);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            validate(entry.getKey(), entry.getValue());
        }
        super.putAll(map);
    }

    public void validate(K k10, V v2) {
        Predicate<? super K> predicate = this.keyPredicate;
        if (predicate != null && !predicate.evaluate(k10)) {
            throw new IllegalArgumentException("Cannot add key - Predicate rejected it");
        }
        Predicate<? super V> predicate2 = this.valuePredicate;
        if (predicate2 != null && !predicate2.evaluate(v2)) {
            throw new IllegalArgumentException("Cannot add value - Predicate rejected it");
        }
    }
}
