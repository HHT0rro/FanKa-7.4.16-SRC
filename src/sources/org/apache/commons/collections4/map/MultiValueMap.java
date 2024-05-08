package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.iterators.LazyIteratorChain;
import org.apache.commons.collections4.iterators.TransformIterator;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class MultiValueMap<K, V> extends AbstractMapDecorator<K, Object> implements MultiMap<K, V>, Serializable {
    private static final long serialVersionUID = -2214159910087182007L;
    private final Factory<? extends Collection<V>> collectionFactory;
    private transient Collection<V> valuesView;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class ReflectionFactory<T extends Collection<?>> implements Factory<T>, Serializable {
        private static final long serialVersionUID = 2986114157496788874L;
        private final Class<T> clazz;

        public ReflectionFactory(Class<T> cls) {
            this.clazz = cls;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            Class<T> cls = this.clazz;
            if (cls != null && !Collection.class.isAssignableFrom(cls)) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // org.apache.commons.collections4.Factory
        public T create() {
            try {
                return this.clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e2) {
                throw new FunctorException("Cannot instantiate class: " + ((Object) this.clazz), e2);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class Values extends AbstractCollection<V> {
        private Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MultiValueMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<V> iterator2() {
            IteratorChain iteratorChain = new IteratorChain();
            Iterator<K> iterator2 = MultiValueMap.this.h().iterator2();
            while (iterator2.hasNext()) {
                iteratorChain.addIterator(new ValuesIterator(iterator2.next()));
            }
            return iteratorChain;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MultiValueMap.this.totalSize();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class ValuesIterator implements Iterator<V> {
        private final Iterator<V> iterator;
        private final Object key;
        private final Collection<V> values;

        public ValuesIterator(Object obj) {
            this.key = obj;
            Collection<V> collection = MultiValueMap.this.getCollection(obj);
            this.values = collection;
            this.iterator = collection.iterator2();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            return this.iterator.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iterator.remove();
            if (this.values.isEmpty()) {
                MultiValueMap.this.remove(this.key);
            }
        }
    }

    public MultiValueMap() {
        this(new HashMap(), new ReflectionFactory(ArrayList.class));
    }

    public static <K, V> MultiValueMap<K, V> multiValueMap(Map<K, ? super Collection<V>> map) {
        return multiValueMap(map, ArrayList.class);
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
    public void clear() {
        decorated().clear();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public boolean containsValue(Object obj) {
        Set<Map.Entry<K, V>> entrySet = decorated().entrySet();
        if (entrySet == null) {
            return false;
        }
        Iterator<Map.Entry<K, V>> iterator2 = entrySet.iterator2();
        while (iterator2.hasNext()) {
            if (((Collection) iterator2.next().getValue()).contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public Collection<V> createCollection(int i10) {
        return this.collectionFactory.create();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public Set<Map.Entry<K, Object>> entrySet() {
        return super.entrySet();
    }

    public Collection<V> getCollection(Object obj) {
        return (Collection) decorated().get(obj);
    }

    public Iterator<V> iterator(Object obj) {
        if (!containsKey(obj)) {
            return EmptyIterator.emptyIterator();
        }
        return new ValuesIterator(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public Object put(K k10, Object obj) {
        Collection<V> collection = getCollection(k10);
        boolean z10 = true;
        if (collection == null) {
            Collection<V> createCollection = createCollection(1);
            createCollection.add(obj);
            if (createCollection.size() > 0) {
                decorated().put(k10, createCollection);
            } else {
                z10 = false;
            }
        } else {
            z10 = collection.add(obj);
        }
        if (z10) {
            return obj;
        }
        return null;
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public void putAll(Map<? extends K, ?> map) {
        if (map instanceof MultiMap) {
            for (Map.Entry<K, Object> entry : ((MultiMap) map).entrySet()) {
                putAll(entry.getKey(), (Collection) entry.getValue());
            }
            return;
        }
        for (Map.Entry<? extends K, ?> entry2 : map.entrySet()) {
            put(entry2.getKey(), entry2.getValue());
        }
    }

    @Override // org.apache.commons.collections4.MultiMap
    public boolean removeMapping(Object obj, Object obj2) {
        Collection<V> collection = getCollection(obj);
        if (collection == null || !collection.remove(obj2)) {
            return false;
        }
        if (!collection.isEmpty()) {
            return true;
        }
        remove(obj);
        return true;
    }

    public int size(Object obj) {
        Collection<V> collection = getCollection(obj);
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    public int totalSize() {
        Iterator<V> iterator2 = decorated().values().iterator2();
        int i10 = 0;
        while (iterator2.hasNext()) {
            i10 += CollectionUtils.size(iterator2.next());
        }
        return i10;
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public Collection<Object> values() {
        Collection<V> collection = this.valuesView;
        if (collection != null) {
            return collection;
        }
        Values values = new Values();
        this.valuesView = values;
        return values;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C extends Collection<V>> MultiValueMap(Map<K, ? super C> map, Factory<C> factory) {
        super(map);
        if (factory != 0) {
            this.collectionFactory = factory;
            return;
        }
        throw new IllegalArgumentException("The factory must not be null");
    }

    public static <K, V, C extends Collection<V>> MultiValueMap<K, V> multiValueMap(Map<K, ? super C> map, Class<C> cls) {
        return new MultiValueMap<>(map, new ReflectionFactory(cls));
    }

    public static <K, V, C extends Collection<V>> MultiValueMap<K, V> multiValueMap(Map<K, ? super C> map, Factory<C> factory) {
        return new MultiValueMap<>(map, factory);
    }

    public boolean containsValue(Object obj, Object obj2) {
        Collection<V> collection = getCollection(obj);
        if (collection == null) {
            return false;
        }
        return collection.contains(obj2);
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        final Iterator<E> iterator2 = new ArrayList(h()).iterator2();
        return new LazyIteratorChain<Map.Entry<K, V>>() { // from class: org.apache.commons.collections4.map.MultiValueMap.1
            @Override // org.apache.commons.collections4.iterators.LazyIteratorChain
            public Iterator<? extends Map.Entry<K, V>> nextIterator(int i10) {
                if (!iterator2.hasNext()) {
                    return null;
                }
                final Object next = iterator2.next();
                return new TransformIterator(new ValuesIterator(next), new Transformer<V, Map.Entry<K, V>>() { // from class: org.apache.commons.collections4.map.MultiValueMap.1.1
                    @Override // org.apache.commons.collections4.Transformer
                    public /* bridge */ /* synthetic */ Object transform(Object obj) {
                        return transform((C08021) obj);
                    }

                    @Override // org.apache.commons.collections4.Transformer
                    public Map.Entry<K, V> transform(final V v2) {
                        return new Map.Entry<K, V>() { // from class: org.apache.commons.collections4.map.MultiValueMap.1.1.1
                            @Override // java.util.Map.Entry
                            public K getKey() {
                                return (K) next;
                            }

                            @Override // java.util.Map.Entry
                            public V getValue() {
                                return (V) v2;
                            }

                            @Override // java.util.Map.Entry
                            public V setValue(V v10) {
                                throw new UnsupportedOperationException();
                            }
                        };
                    }
                });
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean putAll(K k10, Collection<V> collection) {
        if (collection == 0 || collection.size() == 0) {
            return false;
        }
        Collection<V> collection2 = getCollection(k10);
        if (collection2 == null) {
            Collection<V> createCollection = createCollection(collection.size());
            createCollection.addAll(collection);
            if (createCollection.size() <= 0) {
                return false;
            }
            decorated().put(k10, createCollection);
            return true;
        }
        return collection2.addAll(collection);
    }
}
