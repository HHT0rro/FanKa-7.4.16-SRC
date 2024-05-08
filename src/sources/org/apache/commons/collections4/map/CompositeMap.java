package org.apache.commons.collections4.map;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.collection.CompositeCollection;
import org.apache.commons.collections4.set.CompositeSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class CompositeMap<K, V> extends AbstractIterableMap<K, V> implements Serializable {
    private static final long serialVersionUID = -6096931280583808322L;
    private Map<K, V>[] composite;
    private MapMutator<K, V> mutator;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface MapMutator<K, V> extends Serializable {
        V put(CompositeMap<K, V> compositeMap, Map<K, V>[] mapArr, K k10, V v2);

        void putAll(CompositeMap<K, V> compositeMap, Map<K, V>[] mapArr, Map<? extends K, ? extends V> map);

        void resolveCollision(CompositeMap<K, V> compositeMap, Map<K, V> map, Map<K, V> map2, Collection<K> collection);
    }

    public CompositeMap() {
        this(new Map[0], (MapMutator) null);
    }

    public synchronized void addComposited(Map<K, V> map) throws IllegalArgumentException {
        if (map != null) {
            for (int length = this.composite.length - 1; length >= 0; length--) {
                Collection<K> intersection = CollectionUtils.intersection(this.composite[length].h(), map.h());
                if (intersection.size() != 0) {
                    MapMutator<K, V> mapMutator = this.mutator;
                    if (mapMutator != null) {
                        mapMutator.resolveCollision(this, this.composite[length], map, intersection);
                    } else {
                        throw new IllegalArgumentException("Key collision adding Map to CompositeMap");
                    }
                }
            }
            Map<K, V>[] mapArr = this.composite;
            int length2 = mapArr.length + 1;
            Map<K, V>[] mapArr2 = new Map[length2];
            System.arraycopy(mapArr, 0, mapArr2, 0, mapArr.length);
            mapArr2[length2 - 1] = map;
            this.composite = mapArr2;
        }
    }

    @Override // java.util.Map
    public void clear() {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            this.composite[length].clear();
        }
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            if (this.composite[length].containsKey(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            if (this.composite[length].containsValue(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        CompositeSet compositeSet = new CompositeSet();
        for (int length = this.composite.length - 1; length >= 0; length--) {
            compositeSet.addComposited(this.composite[length].entrySet());
        }
        return compositeSet;
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    public V get(Object obj) {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            if (this.composite[length].containsKey(obj)) {
                return this.composite[length].get(obj);
            }
        }
        return null;
    }

    @Override // java.util.Map
    public int hashCode() {
        Iterator<Map.Entry<K, V>> iterator2 = entrySet().iterator2();
        int i10 = 0;
        while (iterator2.hasNext()) {
            i10 += iterator2.next().hashCode();
        }
        return i10;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            if (!this.composite[length].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Map
    /* renamed from: keySet */
    public Set<K> h() {
        CompositeSet compositeSet = new CompositeSet();
        for (int length = this.composite.length - 1; length >= 0; length--) {
            compositeSet.addComposited(this.composite[length].h());
        }
        return compositeSet;
    }

    @Override // java.util.Map
    public V put(K k10, V v2) {
        MapMutator<K, V> mapMutator = this.mutator;
        if (mapMutator != null) {
            return mapMutator.put(this, this.composite, k10, v2);
        }
        throw new UnsupportedOperationException("No mutator specified");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        MapMutator<K, V> mapMutator = this.mutator;
        if (mapMutator != null) {
            mapMutator.putAll(this, this.composite, map);
            return;
        }
        throw new UnsupportedOperationException("No mutator specified");
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        for (int length = this.composite.length - 1; length >= 0; length--) {
            if (this.composite[length].containsKey(obj)) {
                return this.composite[length].remove(obj);
            }
        }
        return null;
    }

    public synchronized Map<K, V> removeComposited(Map<K, V> map) {
        int length = this.composite.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (this.composite[i10].equals(map)) {
                Map<K, V>[] mapArr = new Map[length - 1];
                System.arraycopy(this.composite, 0, mapArr, 0, i10);
                System.arraycopy(this.composite, i10 + 1, mapArr, i10, (length - i10) - 1);
                this.composite = mapArr;
                return map;
            }
        }
        return null;
    }

    public void setMutator(MapMutator<K, V> mapMutator) {
        this.mutator = mapMutator;
    }

    @Override // java.util.Map
    public int size() {
        int i10 = 0;
        for (int length = this.composite.length - 1; length >= 0; length--) {
            i10 += this.composite[length].size();
        }
        return i10;
    }

    @Override // java.util.Map
    public Collection<V> values() {
        CompositeCollection compositeCollection = new CompositeCollection();
        for (int length = this.composite.length - 1; length >= 0; length--) {
            compositeCollection.addComposited(this.composite[length].values());
        }
        return compositeCollection;
    }

    public CompositeMap(Map<K, V> map, Map<K, V> map2) {
        this(new Map[]{map, map2}, (MapMutator) null);
    }

    public CompositeMap(Map<K, V> map, Map<K, V> map2, MapMutator<K, V> mapMutator) {
        this(new Map[]{map, map2}, mapMutator);
    }

    public CompositeMap(Map<K, V>... mapArr) {
        this(mapArr, (MapMutator) null);
    }

    public CompositeMap(Map<K, V>[] mapArr, MapMutator<K, V> mapMutator) {
        this.mutator = mapMutator;
        this.composite = new Map[0];
        for (int length = mapArr.length - 1; length >= 0; length--) {
            addComposited(mapArr[length]);
        }
    }
}
