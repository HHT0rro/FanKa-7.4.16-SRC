package org.apache.commons.collections4.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedMapIterator;
import org.apache.commons.collections4.map.AbstractHashedMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractLinkedMap<K, V> extends AbstractHashedMap<K, V> implements OrderedMap<K, V> {
    public transient LinkEntry<K, V> header;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class EntrySetIterator<K, V> extends LinkIterator<K, V> implements OrderedIterator<Map.Entry<K, V>>, ResettableIterator<Map.Entry<K, V>> {
        public EntrySetIterator(AbstractLinkedMap<K, V> abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return super.nextEntry();
        }

        @Override // org.apache.commons.collections4.OrderedIterator
        public Map.Entry<K, V> previous() {
            return super.previousEntry();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class KeySetIterator<K> extends LinkIterator<K, Object> implements OrderedIterator<K>, ResettableIterator<K> {
        public KeySetIterator(AbstractLinkedMap<K, ?> abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        @Override // java.util.Iterator
        public K next() {
            return super.nextEntry().getKey();
        }

        @Override // org.apache.commons.collections4.OrderedIterator
        public K previous() {
            return super.previousEntry().getKey();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class LinkEntry<K, V> extends AbstractHashedMap.HashEntry<K, V> {
        public LinkEntry<K, V> after;
        public LinkEntry<K, V> before;

        public LinkEntry(AbstractHashedMap.HashEntry<K, V> hashEntry, int i10, Object obj, V v2) {
            super(hashEntry, i10, obj, v2);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class LinkIterator<K, V> {
        public int expectedModCount;
        public LinkEntry<K, V> last;
        public LinkEntry<K, V> next;
        public final AbstractLinkedMap<K, V> parent;

        public LinkIterator(AbstractLinkedMap<K, V> abstractLinkedMap) {
            this.parent = abstractLinkedMap;
            this.next = abstractLinkedMap.header.after;
            this.expectedModCount = abstractLinkedMap.modCount;
        }

        public LinkEntry<K, V> currentEntry() {
            return this.last;
        }

        public boolean hasNext() {
            return this.next != this.parent.header;
        }

        public boolean hasPrevious() {
            return this.next.before != this.parent.header;
        }

        public LinkEntry<K, V> nextEntry() {
            AbstractLinkedMap<K, V> abstractLinkedMap = this.parent;
            if (abstractLinkedMap.modCount == this.expectedModCount) {
                LinkEntry<K, V> linkEntry = this.next;
                if (linkEntry != abstractLinkedMap.header) {
                    this.last = linkEntry;
                    this.next = linkEntry.after;
                    return linkEntry;
                }
                throw new NoSuchElementException(AbstractHashedMap.NO_NEXT_ENTRY);
            }
            throw new ConcurrentModificationException();
        }

        public LinkEntry<K, V> previousEntry() {
            AbstractLinkedMap<K, V> abstractLinkedMap = this.parent;
            if (abstractLinkedMap.modCount == this.expectedModCount) {
                LinkEntry<K, V> linkEntry = this.next.before;
                if (linkEntry != abstractLinkedMap.header) {
                    this.next = linkEntry;
                    this.last = linkEntry;
                    return linkEntry;
                }
                throw new NoSuchElementException(AbstractHashedMap.NO_PREVIOUS_ENTRY);
            }
            throw new ConcurrentModificationException();
        }

        public void remove() {
            LinkEntry<K, V> linkEntry = this.last;
            if (linkEntry != null) {
                AbstractLinkedMap<K, V> abstractLinkedMap = this.parent;
                if (abstractLinkedMap.modCount == this.expectedModCount) {
                    abstractLinkedMap.remove(linkEntry.getKey());
                    this.last = null;
                    this.expectedModCount = this.parent.modCount;
                    return;
                }
                throw new ConcurrentModificationException();
            }
            throw new IllegalStateException(AbstractHashedMap.REMOVE_INVALID);
        }

        public void reset() {
            this.last = null;
            this.next = this.parent.header.after;
        }

        public String toString() {
            if (this.last == null) {
                return "Iterator[]";
            }
            return "Iterator[" + ((Object) this.last.getKey()) + "=" + ((Object) this.last.getValue()) + "]";
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class LinkMapIterator<K, V> extends LinkIterator<K, V> implements OrderedMapIterator<K, V>, ResettableIterator<K> {
        public LinkMapIterator(AbstractLinkedMap<K, V> abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        @Override // org.apache.commons.collections4.MapIterator
        public K getKey() {
            LinkEntry<K, V> currentEntry = currentEntry();
            if (currentEntry != null) {
                return currentEntry.getKey();
            }
            throw new IllegalStateException(AbstractHashedMap.GETKEY_INVALID);
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            LinkEntry<K, V> currentEntry = currentEntry();
            if (currentEntry != null) {
                return currentEntry.getValue();
            }
            throw new IllegalStateException(AbstractHashedMap.GETVALUE_INVALID);
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            return super.nextEntry().getKey();
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public K previous() {
            return super.previousEntry().getKey();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V setValue(V v2) {
            LinkEntry<K, V> currentEntry = currentEntry();
            if (currentEntry != null) {
                return currentEntry.setValue(v2);
            }
            throw new IllegalStateException(AbstractHashedMap.SETVALUE_INVALID);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class ValuesIterator<V> extends LinkIterator<Object, V> implements OrderedIterator<V>, ResettableIterator<V> {
        public ValuesIterator(AbstractLinkedMap<?, V> abstractLinkedMap) {
            super(abstractLinkedMap);
        }

        @Override // java.util.Iterator
        public V next() {
            return super.nextEntry().getValue();
        }

        @Override // org.apache.commons.collections4.OrderedIterator
        public V previous() {
            return super.previousEntry().getValue();
        }
    }

    public AbstractLinkedMap() {
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public void addEntry(AbstractHashedMap.HashEntry<K, V> hashEntry, int i10) {
        LinkEntry<K, V> linkEntry = (LinkEntry) hashEntry;
        LinkEntry<K, V> linkEntry2 = this.header;
        linkEntry.after = linkEntry2;
        linkEntry.before = linkEntry2.before;
        linkEntry2.before.after = linkEntry;
        linkEntry2.before = linkEntry;
        this.data[i10] = linkEntry;
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        super.clear();
        LinkEntry<K, V> linkEntry = this.header;
        linkEntry.after = linkEntry;
        linkEntry.before = linkEntry;
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            LinkEntry<K, V> linkEntry = this.header;
            do {
                linkEntry = linkEntry.after;
                if (linkEntry == this.header) {
                    return false;
                }
            } while (linkEntry.getValue() != null);
            return true;
        }
        LinkEntry<K, V> linkEntry2 = this.header;
        do {
            linkEntry2 = linkEntry2.after;
            if (linkEntry2 == this.header) {
                return false;
            }
        } while (!isEqualValue(obj, linkEntry2.getValue()));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public /* bridge */ /* synthetic */ AbstractHashedMap.HashEntry createEntry(AbstractHashedMap.HashEntry hashEntry, int i10, Object obj, Object obj2) {
        return createEntry((AbstractHashedMap.HashEntry<int, Object>) hashEntry, i10, (int) obj, obj2);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public Iterator<Map.Entry<K, V>> createEntrySetIterator() {
        if (size() == 0) {
            return EmptyOrderedIterator.emptyOrderedIterator();
        }
        return new EntrySetIterator(this);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public Iterator<K> createKeySetIterator() {
        if (size() == 0) {
            return EmptyOrderedIterator.emptyOrderedIterator();
        }
        return new KeySetIterator(this);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public Iterator<V> createValuesIterator() {
        if (size() == 0) {
            return EmptyOrderedIterator.emptyOrderedIterator();
        }
        return new ValuesIterator(this);
    }

    public LinkEntry<K, V> entryAfter(LinkEntry<K, V> linkEntry) {
        return linkEntry.after;
    }

    public LinkEntry<K, V> entryBefore(LinkEntry<K, V> linkEntry) {
        return linkEntry.before;
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        if (this.size != 0) {
            return this.header.after.getKey();
        }
        throw new NoSuchElementException("Map is empty");
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public void init() {
        LinkEntry<K, V> createEntry = createEntry((AbstractHashedMap.HashEntry<int, K>) null, -1, (int) null, (K) null);
        this.header = createEntry;
        createEntry.after = createEntry;
        createEntry.before = createEntry;
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        if (this.size != 0) {
            return this.header.before.getKey();
        }
        throw new NoSuchElementException("Map is empty");
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K nextKey(Object obj) {
        LinkEntry<K, V> linkEntry;
        LinkEntry<K, V> entry = getEntry(obj);
        if (entry == null || (linkEntry = entry.after) == this.header) {
            return null;
        }
        return linkEntry.getKey();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K previousKey(Object obj) {
        LinkEntry<K, V> linkEntry;
        LinkEntry<K, V> entry = getEntry(obj);
        if (entry == null || (linkEntry = entry.before) == this.header) {
            return null;
        }
        return linkEntry.getKey();
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public void removeEntry(AbstractHashedMap.HashEntry<K, V> hashEntry, int i10, AbstractHashedMap.HashEntry<K, V> hashEntry2) {
        LinkEntry linkEntry = (LinkEntry) hashEntry;
        LinkEntry<K, V> linkEntry2 = linkEntry.before;
        linkEntry2.after = linkEntry.after;
        linkEntry.after.before = linkEntry2;
        linkEntry.after = null;
        linkEntry.before = null;
        super.removeEntry(hashEntry, i10, hashEntry2);
    }

    public AbstractLinkedMap(int i10, float f10, int i11) {
        super(i10, f10, i11);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public LinkEntry<K, V> createEntry(AbstractHashedMap.HashEntry<K, V> hashEntry, int i10, K k10, V v2) {
        return new LinkEntry<>(hashEntry, i10, convertKey(k10), v2);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public LinkEntry<K, V> getEntry(Object obj) {
        return (LinkEntry) super.getEntry(obj);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        if (this.size == 0) {
            return EmptyOrderedMapIterator.emptyOrderedMapIterator();
        }
        return new LinkMapIterator(this);
    }

    public AbstractLinkedMap(int i10) {
        super(i10);
    }

    public LinkEntry<K, V> getEntry(int i10) {
        LinkEntry<K, V> linkEntry;
        if (i10 >= 0) {
            int i11 = this.size;
            if (i10 < i11) {
                if (i10 < i11 / 2) {
                    linkEntry = this.header.after;
                    for (int i12 = 0; i12 < i10; i12++) {
                        linkEntry = linkEntry.after;
                    }
                } else {
                    linkEntry = this.header;
                    while (i11 > i10) {
                        linkEntry = linkEntry.before;
                        i11--;
                    }
                }
                return linkEntry;
            }
            throw new IndexOutOfBoundsException("Index " + i10 + " is invalid for size " + this.size);
        }
        throw new IndexOutOfBoundsException("Index " + i10 + " is less than zero");
    }

    public AbstractLinkedMap(int i10, float f10) {
        super(i10, f10);
    }

    public AbstractLinkedMap(Map<? extends K, ? extends V> map) {
        super(map);
    }
}
