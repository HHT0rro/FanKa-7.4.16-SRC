package org.apache.commons.collections4.multimap;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.ListValuedMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractListValuedMap<K, V> extends AbstractMultiValuedMap<K, V> implements ListValuedMap<K, V> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class WrappedList extends AbstractMultiValuedMap<K, V>.WrappedCollection implements List<V> {
        public WrappedList(K k10) {
            super(k10);
        }

        @Override // java.util.List
        public void add(int i10, V v2) {
            List<V> mapping = getMapping();
            if (mapping == null) {
                mapping = AbstractListValuedMap.this.createCollection();
                AbstractListValuedMap.this.getMap().put(this.key, mapping);
            }
            mapping.add(i10, v2);
        }

        @Override // java.util.List
        public boolean addAll(int i10, Collection<? extends V> collection) {
            List<V> mapping = getMapping();
            if (mapping == null) {
                List<V> createCollection = AbstractListValuedMap.this.createCollection();
                boolean addAll = createCollection.addAll(i10, collection);
                if (addAll) {
                    AbstractListValuedMap.this.getMap().put(this.key, createCollection);
                }
                return addAll;
            }
            return mapping.addAll(i10, collection);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            List<V> mapping = getMapping();
            if (mapping == null) {
                return Collections.emptyList().equals(obj);
            }
            if (obj instanceof List) {
                return ListUtils.isEqualList(mapping, (List) obj);
            }
            return false;
        }

        @Override // java.util.List
        public V get(int i10) {
            return (V) ListUtils.emptyIfNull(getMapping()).get(i10);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return ListUtils.hashCodeForList(getMapping());
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            return ListUtils.emptyIfNull(getMapping()).indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            return ListUtils.emptyIfNull(getMapping()).lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            return new ValuesListIterator(this.key);
        }

        @Override // java.util.List
        public V remove(int i10) {
            List emptyIfNull = ListUtils.emptyIfNull(getMapping());
            V v2 = (V) emptyIfNull.remove(i10);
            if (emptyIfNull.isEmpty()) {
                AbstractListValuedMap.this.remove((Object) this.key);
            }
            return v2;
        }

        @Override // java.util.List
        public V set(int i10, V v2) {
            return (V) ListUtils.emptyIfNull(getMapping()).set(i10, v2);
        }

        @Override // java.util.List
        public List<V> subList(int i10, int i11) {
            return ListUtils.emptyIfNull(getMapping()).subList(i10, i11);
        }

        @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap.WrappedCollection
        public List<V> getMapping() {
            return AbstractListValuedMap.this.getMap().get(this.key);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int i10) {
            return new ValuesListIterator(this.key, i10);
        }
    }

    public AbstractListValuedMap() {
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    public abstract List<V> createCollection();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap, org.apache.commons.collections4.MultiValuedMap
    public /* bridge */ /* synthetic */ Collection get(Object obj) {
        return get((AbstractListValuedMap<K, V>) obj);
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    public Map<K, List<V>> getMap() {
        return super.getMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    public /* bridge */ /* synthetic */ Collection wrappedCollection(Object obj) {
        return wrappedCollection((AbstractListValuedMap<K, V>) obj);
    }

    public AbstractListValuedMap(Map<K, ? extends List<V>> map) {
        super(map);
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap, org.apache.commons.collections4.MultiValuedMap
    public List<V> get(K k10) {
        return wrappedCollection((AbstractListValuedMap<K, V>) k10);
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap, org.apache.commons.collections4.MultiValuedMap
    public List<V> remove(Object obj) {
        return ListUtils.emptyIfNull(getMap().remove(obj));
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    public List<V> wrappedCollection(K k10) {
        return new WrappedList(k10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class ValuesListIterator implements ListIterator<V> {
        private ListIterator<V> iterator;
        private final K key;
        private List<V> values;

        public ValuesListIterator(K k10) {
            this.key = k10;
            List<V> emptyIfNull = ListUtils.emptyIfNull(AbstractListValuedMap.this.getMap().get(k10));
            this.values = emptyIfNull;
            this.iterator = emptyIfNull.listIterator();
        }

        @Override // java.util.ListIterator
        public void add(V v2) {
            if (AbstractListValuedMap.this.getMap().get(this.key) == null) {
                List<V> createCollection = AbstractListValuedMap.this.createCollection();
                AbstractListValuedMap.this.getMap().put(this.key, createCollection);
                this.values = createCollection;
                this.iterator = createCollection.listIterator();
            }
            this.iterator.add(v2);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.iterator.hasPrevious();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public V next() {
            return this.iterator.next();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.iterator.nextIndex();
        }

        @Override // java.util.ListIterator
        public V previous() {
            return this.iterator.previous();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.iterator.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            this.iterator.remove();
            if (this.values.isEmpty()) {
                AbstractListValuedMap.this.getMap().remove(this.key);
            }
        }

        @Override // java.util.ListIterator
        public void set(V v2) {
            this.iterator.set(v2);
        }

        public ValuesListIterator(K k10, int i10) {
            this.key = k10;
            List<V> emptyIfNull = ListUtils.emptyIfNull(AbstractListValuedMap.this.getMap().get(k10));
            this.values = emptyIfNull;
            this.iterator = emptyIfNull.listIterator(i10);
        }
    }
}
