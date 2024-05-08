package org.apache.commons.collections4.set;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class MapBackedSet<E, V> implements Set<E>, Serializable {
    private static final long serialVersionUID = 6723912213766056587L;
    private final V dummyValue;
    private final Map<E, ? super V> map;

    private MapBackedSet(Map<E, ? super V> map, V v2) {
        Objects.requireNonNull(map, "The map must not be null");
        this.map = map;
        this.dummyValue = v2;
    }

    public static <E, V> MapBackedSet<E, V> mapBackedSet(Map<E, ? super V> map) {
        return mapBackedSet(map, null);
    }

    @Override // java.util.Set
    public boolean add(E e2) {
        int size = this.map.size();
        this.map.put(e2, this.dummyValue);
        return this.map.size() != size;
    }

    @Override // java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        int size = this.map.size();
        Iterator<? extends E> iterator2 = collection.iterator2();
        while (iterator2.hasNext()) {
            this.map.put(iterator2.next(), this.dummyValue);
        }
        return this.map.size() != size;
    }

    @Override // java.util.Set
    public void clear() {
        this.map.clear();
    }

    @Override // java.util.Set
    public boolean contains(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // java.util.Set
    public boolean containsAll(Collection<?> collection) {
        return this.map.h().containsAll(collection);
    }

    @Override // java.util.Set
    public boolean equals(Object obj) {
        return this.map.h().equals(obj);
    }

    @Override // java.util.Set
    public int hashCode() {
        return this.map.h().hashCode();
    }

    @Override // java.util.Set
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return this.map.h().iterator2();
    }

    @Override // java.util.Set
    public boolean remove(Object obj) {
        int size = this.map.size();
        this.map.remove(obj);
        return this.map.size() != size;
    }

    @Override // java.util.Set
    public boolean removeAll(Collection<?> collection) {
        return this.map.h().removeAll(collection);
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super E> predicate) {
        return this.map.h().removeIf(predicate);
    }

    @Override // java.util.Set
    public boolean retainAll(Collection<?> collection) {
        return this.map.h().retainAll(collection);
    }

    @Override // java.util.Set
    public int size() {
        return this.map.size();
    }

    @Override // java.util.Set
    public Object[] toArray() {
        return this.map.h().toArray();
    }

    public static <E, V> MapBackedSet<E, V> mapBackedSet(Map<E, ? super V> map, V v2) {
        return new MapBackedSet<>(map, v2);
    }

    @Override // java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.map.h().toArray(tArr);
    }
}
