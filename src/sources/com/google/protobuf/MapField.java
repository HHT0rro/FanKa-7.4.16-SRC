package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class MapField<K, V> implements MutabilityOracle {
    private final Converter<K, V> converter;
    private volatile boolean isMutable;
    private List<Message> listData;
    private MutabilityAwareMap<K, V> mapData;
    private volatile StorageMode mode;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface Converter<K, V> {
        Message convertKeyAndValueToMessage(K k10, V v2);

        void convertMessageToKeyAndValue(Message message, Map<K, V> map);

        Message getMessageDefaultInstance();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class ImmutableMessageConverter<K, V> implements Converter<K, V> {
        private final MapEntry<K, V> defaultEntry;

        public ImmutableMessageConverter(MapEntry<K, V> mapEntry) {
            this.defaultEntry = mapEntry;
        }

        @Override // com.google.protobuf.MapField.Converter
        public Message convertKeyAndValueToMessage(K k10, V v2) {
            return this.defaultEntry.newBuilderForType().setKey(k10).setValue(v2).buildPartial();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.MapField.Converter
        public void convertMessageToKeyAndValue(Message message, Map<K, V> map) {
            MapEntry mapEntry = (MapEntry) message;
            map.put(mapEntry.getKey(), mapEntry.getValue());
        }

        @Override // com.google.protobuf.MapField.Converter
        public Message getMessageDefaultInstance() {
            return this.defaultEntry;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class MutabilityAwareMap<K, V> implements Map<K, V> {
        private final Map<K, V> delegate;
        private final MutabilityOracle mutabilityOracle;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class MutabilityAwareCollection<E> implements Collection<E> {
            private final Collection<E> delegate;
            private final MutabilityOracle mutabilityOracle;

            public MutabilityAwareCollection(MutabilityOracle mutabilityOracle, Collection<E> collection) {
                this.mutabilityOracle = mutabilityOracle;
                this.delegate = collection;
            }

            @Override // java.util.Collection, java.util.Set
            public boolean add(E e2) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Collection, java.util.Set
            public boolean addAll(Collection<? extends E> collection) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Collection, java.util.Set
            public void clear() {
                this.mutabilityOracle.ensureMutable();
                this.delegate.clear();
            }

            @Override // java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return this.delegate.contains(obj);
            }

            @Override // java.util.Collection, java.util.Set
            public boolean containsAll(Collection<?> collection) {
                return this.delegate.containsAll(collection);
            }

            @Override // java.util.Collection, java.util.Set
            public boolean equals(Object obj) {
                return this.delegate.equals(obj);
            }

            @Override // java.util.Collection, java.util.Set
            public int hashCode() {
                return this.delegate.hashCode();
            }

            @Override // java.util.Collection, java.util.Set
            public boolean isEmpty() {
                return this.delegate.isEmpty();
            }

            @Override // java.util.Collection, java.lang.Iterable
            /* renamed from: iterator */
            public Iterator<E> iterator2() {
                return new MutabilityAwareIterator(this.mutabilityOracle, this.delegate.iterator2());
            }

            @Override // java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.remove(obj);
            }

            @Override // java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.removeAll(collection);
            }

            @Override // java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.retainAll(collection);
            }

            @Override // java.util.Collection, java.util.Set
            public int size() {
                return this.delegate.size();
            }

            @Override // java.util.Collection, java.util.Set
            public Object[] toArray() {
                return this.delegate.toArray();
            }

            public String toString() {
                return this.delegate.toString();
            }

            @Override // java.util.Collection, java.util.Set
            public <T> T[] toArray(T[] tArr) {
                return (T[]) this.delegate.toArray(tArr);
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class MutabilityAwareIterator<E> implements Iterator<E> {
            private final Iterator<E> delegate;
            private final MutabilityOracle mutabilityOracle;

            public MutabilityAwareIterator(MutabilityOracle mutabilityOracle, Iterator<E> it) {
                this.mutabilityOracle = mutabilityOracle;
                this.delegate = it;
            }

            public boolean equals(Object obj) {
                return this.delegate.equals(obj);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.delegate.hasNext();
            }

            public int hashCode() {
                return this.delegate.hashCode();
            }

            @Override // java.util.Iterator
            public E next() {
                return this.delegate.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.mutabilityOracle.ensureMutable();
                this.delegate.remove();
            }

            public String toString() {
                return this.delegate.toString();
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class MutabilityAwareSet<E> implements Set<E> {
            private final Set<E> delegate;
            private final MutabilityOracle mutabilityOracle;

            public MutabilityAwareSet(MutabilityOracle mutabilityOracle, Set<E> set) {
                this.mutabilityOracle = mutabilityOracle;
                this.delegate = set;
            }

            @Override // java.util.Set
            public boolean add(E e2) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.add(e2);
            }

            @Override // java.util.Set
            public boolean addAll(Collection<? extends E> collection) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.addAll(collection);
            }

            @Override // java.util.Set
            public void clear() {
                this.mutabilityOracle.ensureMutable();
                this.delegate.clear();
            }

            @Override // java.util.Set
            public boolean contains(Object obj) {
                return this.delegate.contains(obj);
            }

            @Override // java.util.Set
            public boolean containsAll(Collection<?> collection) {
                return this.delegate.containsAll(collection);
            }

            @Override // java.util.Set
            public boolean equals(Object obj) {
                return this.delegate.equals(obj);
            }

            @Override // java.util.Set
            public int hashCode() {
                return this.delegate.hashCode();
            }

            @Override // java.util.Set
            public boolean isEmpty() {
                return this.delegate.isEmpty();
            }

            @Override // java.util.Set, java.util.Collection, java.lang.Iterable
            /* renamed from: iterator */
            public Iterator<E> iterator2() {
                return new MutabilityAwareIterator(this.mutabilityOracle, this.delegate.iterator2());
            }

            @Override // java.util.Set
            public boolean remove(Object obj) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.remove(obj);
            }

            @Override // java.util.Set
            public boolean removeAll(Collection<?> collection) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.removeAll(collection);
            }

            @Override // java.util.Set
            public boolean retainAll(Collection<?> collection) {
                this.mutabilityOracle.ensureMutable();
                return this.delegate.retainAll(collection);
            }

            @Override // java.util.Set
            public int size() {
                return this.delegate.size();
            }

            @Override // java.util.Set
            public Object[] toArray() {
                return this.delegate.toArray();
            }

            public String toString() {
                return this.delegate.toString();
            }

            @Override // java.util.Set
            public <T> T[] toArray(T[] tArr) {
                return (T[]) this.delegate.toArray(tArr);
            }
        }

        public MutabilityAwareMap(MutabilityOracle mutabilityOracle, Map<K, V> map) {
            this.mutabilityOracle = mutabilityOracle;
            this.delegate = map;
        }

        @Override // java.util.Map
        public void clear() {
            this.mutabilityOracle.ensureMutable();
            this.delegate.clear();
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            return this.delegate.containsKey(obj);
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return this.delegate.containsValue(obj);
        }

        @Override // java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new MutabilityAwareSet(this.mutabilityOracle, this.delegate.entrySet());
        }

        @Override // java.util.Map
        public boolean equals(Object obj) {
            return this.delegate.equals(obj);
        }

        @Override // java.util.Map
        public V get(Object obj) {
            return this.delegate.get(obj);
        }

        @Override // java.util.Map
        public int hashCode() {
            return this.delegate.hashCode();
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.delegate.isEmpty();
        }

        @Override // java.util.Map
        /* renamed from: keySet */
        public Set<K> h() {
            return new MutabilityAwareSet(this.mutabilityOracle, this.delegate.h());
        }

        @Override // java.util.Map
        public V put(K k10, V v2) {
            this.mutabilityOracle.ensureMutable();
            Internal.checkNotNull(k10);
            Internal.checkNotNull(v2);
            return this.delegate.put(k10, v2);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            this.mutabilityOracle.ensureMutable();
            for (K k10 : map.h()) {
                Internal.checkNotNull(k10);
                Internal.checkNotNull(map.get(k10));
            }
            this.delegate.putAll(map);
        }

        @Override // java.util.Map
        public V remove(Object obj) {
            this.mutabilityOracle.ensureMutable();
            return this.delegate.remove(obj);
        }

        @Override // java.util.Map
        public int size() {
            return this.delegate.size();
        }

        public String toString() {
            return this.delegate.toString();
        }

        @Override // java.util.Map
        public Collection<V> values() {
            return new MutabilityAwareCollection(this.mutabilityOracle, this.delegate.values());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum StorageMode {
        MAP,
        LIST,
        BOTH
    }

    private MapField(Converter<K, V> converter, StorageMode storageMode, Map<K, V> map) {
        this.converter = converter;
        this.isMutable = true;
        this.mode = storageMode;
        this.mapData = new MutabilityAwareMap<>(this, map);
        this.listData = null;
    }

    private Message convertKeyAndValueToMessage(K k10, V v2) {
        return this.converter.convertKeyAndValueToMessage(k10, v2);
    }

    private MutabilityAwareMap<K, V> convertListToMap(List<Message> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Message> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            convertMessageToKeyAndValue(iterator2.next(), linkedHashMap);
        }
        return new MutabilityAwareMap<>(this, linkedHashMap);
    }

    private List<Message> convertMapToList(MutabilityAwareMap<K, V> mutabilityAwareMap) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<K, V> entry : mutabilityAwareMap.entrySet()) {
            arrayList.add(convertKeyAndValueToMessage(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    private void convertMessageToKeyAndValue(Message message, Map<K, V> map) {
        this.converter.convertMessageToKeyAndValue(message, map);
    }

    public static <K, V> MapField<K, V> emptyMapField(MapEntry<K, V> mapEntry) {
        return new MapField<>(mapEntry, StorageMode.MAP, Collections.emptyMap());
    }

    public static <K, V> MapField<K, V> newMapField(MapEntry<K, V> mapEntry) {
        return new MapField<>(mapEntry, StorageMode.MAP, new LinkedHashMap());
    }

    public void clear() {
        this.mapData = new MutabilityAwareMap<>(this, new LinkedHashMap());
        this.mode = StorageMode.MAP;
    }

    public MapField<K, V> copy() {
        return new MapField<>(this.converter, StorageMode.MAP, MapFieldLite.copy((Map) getMap()));
    }

    @Override // com.google.protobuf.MutabilityOracle
    public void ensureMutable() {
        if (!isMutable()) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof MapField) {
            return MapFieldLite.equals((Map) getMap(), (Map) ((MapField) obj).getMap());
        }
        return false;
    }

    public List<Message> getList() {
        StorageMode storageMode = this.mode;
        StorageMode storageMode2 = StorageMode.MAP;
        if (storageMode == storageMode2) {
            synchronized (this) {
                if (this.mode == storageMode2) {
                    this.listData = convertMapToList(this.mapData);
                    this.mode = StorageMode.BOTH;
                }
            }
        }
        return Collections.unmodifiableList(this.listData);
    }

    public Map<K, V> getMap() {
        StorageMode storageMode = this.mode;
        StorageMode storageMode2 = StorageMode.LIST;
        if (storageMode == storageMode2) {
            synchronized (this) {
                if (this.mode == storageMode2) {
                    this.mapData = convertListToMap(this.listData);
                    this.mode = StorageMode.BOTH;
                }
            }
        }
        return Collections.unmodifiableMap(this.mapData);
    }

    public Message getMapEntryMessageDefaultInstance() {
        return this.converter.getMessageDefaultInstance();
    }

    public List<Message> getMutableList() {
        StorageMode storageMode = this.mode;
        StorageMode storageMode2 = StorageMode.LIST;
        if (storageMode != storageMode2) {
            if (this.mode == StorageMode.MAP) {
                this.listData = convertMapToList(this.mapData);
            }
            this.mapData = null;
            this.mode = storageMode2;
        }
        return this.listData;
    }

    public Map<K, V> getMutableMap() {
        StorageMode storageMode = this.mode;
        StorageMode storageMode2 = StorageMode.MAP;
        if (storageMode != storageMode2) {
            if (this.mode == StorageMode.LIST) {
                this.mapData = convertListToMap(this.listData);
            }
            this.listData = null;
            this.mode = storageMode2;
        }
        return this.mapData;
    }

    public int hashCode() {
        return MapFieldLite.calculateHashCodeForMap(getMap());
    }

    public boolean isMutable() {
        return this.isMutable;
    }

    public void makeImmutable() {
        this.isMutable = false;
    }

    public void mergeFrom(MapField<K, V> mapField) {
        getMutableMap().putAll(MapFieldLite.copy((Map) mapField.getMap()));
    }

    private MapField(MapEntry<K, V> mapEntry, StorageMode storageMode, Map<K, V> map) {
        this(new ImmutableMessageConverter(mapEntry), storageMode, map);
    }
}
