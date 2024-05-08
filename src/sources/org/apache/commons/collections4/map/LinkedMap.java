package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.function.Predicate;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;
import org.apache.commons.collections4.iterators.UnmodifiableListIterator;
import org.apache.commons.collections4.list.UnmodifiableList;
import org.apache.commons.collections4.map.AbstractLinkedMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class LinkedMap<K, V> extends AbstractLinkedMap<K, V> implements Serializable, Cloneable {
    private static final long serialVersionUID = 9077234323521161066L;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class LinkedMapList<K> extends AbstractList<K> {
        private final LinkedMap<K, ?> parent;

        public LinkedMapList(LinkedMap<K, ?> linkedMap) {
            this.parent = linkedMap;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.parent.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return this.parent.h().containsAll(collection);
        }

        @Override // java.util.AbstractList, java.util.List
        public K get(int i10) {
            return this.parent.get(i10);
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            return this.parent.indexOf(obj);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<K> iterator2() {
            return UnmodifiableIterator.unmodifiableIterator(this.parent.h().iterator2());
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            return this.parent.indexOf(obj);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<K> listIterator() {
            return UnmodifiableListIterator.umodifiableListIterator(super.listIterator());
        }

        @Override // java.util.AbstractList, java.util.List
        public K remove(int i10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super K> predicate) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.parent.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<K> subList(int i10, int i11) {
            return UnmodifiableList.unmodifiableList(super.subList(i10, i11));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return this.parent.h().toArray();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<K> listIterator(int i10) {
            return UnmodifiableListIterator.umodifiableListIterator(super.listIterator(i10));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) this.parent.h().toArray(tArr);
        }
    }

    public LinkedMap() {
        super(16, 0.75f, 12);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        doReadObject(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    public List<K> asList() {
        return new LinkedMapList(this);
    }

    public K get(int i10) {
        return getEntry(i10).getKey();
    }

    public V getValue(int i10) {
        return getEntry(i10).getValue();
    }

    public int indexOf(Object obj) {
        Object convertKey = convertKey(obj);
        AbstractLinkedMap.LinkEntry<K, V> linkEntry = this.header.after;
        int i10 = 0;
        while (linkEntry != this.header) {
            if (isEqualKey(convertKey, linkEntry.key)) {
                return i10;
            }
            linkEntry = linkEntry.after;
            i10++;
        }
        return -1;
    }

    public V remove(int i10) {
        return remove(get(i10));
    }

    public LinkedMap(int i10) {
        super(i10);
    }

    public LinkedMap(int i10, float f10) {
        super(i10, f10);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap
    public LinkedMap<K, V> clone() {
        return (LinkedMap) super.clone();
    }

    public LinkedMap(Map<? extends K, ? extends V> map) {
        super(map);
    }
}
