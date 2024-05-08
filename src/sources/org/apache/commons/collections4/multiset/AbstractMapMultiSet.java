package org.apache.commons.collections4.multiset;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.multiset.AbstractMultiSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractMapMultiSet<E> extends AbstractMultiSet<E> {
    private transient Map<E, MutableInteger> map;
    private transient int modCount;
    private transient int size;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class EntrySetIterator<E> implements Iterator<MultiSet.Entry<E>> {
        public final Iterator<Map.Entry<E, MutableInteger>> decorated;
        public final AbstractMapMultiSet<E> parent;
        public MultiSet.Entry<E> last = null;
        public boolean canRemove = false;

        public EntrySetIterator(Iterator<Map.Entry<E, MutableInteger>> it, AbstractMapMultiSet<E> abstractMapMultiSet) {
            this.decorated = it;
            this.parent = abstractMapMultiSet;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.decorated.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.canRemove) {
                this.decorated.remove();
                this.last = null;
                this.canRemove = false;
                return;
            }
            throw new IllegalStateException("Iterator remove() can only be called once after next()");
        }

        @Override // java.util.Iterator
        public MultiSet.Entry<E> next() {
            MultiSetEntry multiSetEntry = new MultiSetEntry(this.decorated.next());
            this.last = multiSetEntry;
            this.canRemove = true;
            return multiSetEntry;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class MapBasedMultiSetIterator<E> implements Iterator<E> {
        private final Iterator<Map.Entry<E, MutableInteger>> entryIterator;
        private int itemCount;
        private final int mods;
        private final AbstractMapMultiSet<E> parent;
        private Map.Entry<E, MutableInteger> current = null;
        private boolean canRemove = false;

        public MapBasedMultiSetIterator(AbstractMapMultiSet<E> abstractMapMultiSet) {
            this.parent = abstractMapMultiSet;
            this.entryIterator = ((AbstractMapMultiSet) abstractMapMultiSet).map.entrySet().iterator2();
            this.mods = ((AbstractMapMultiSet) abstractMapMultiSet).modCount;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.itemCount > 0 || this.entryIterator.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (((AbstractMapMultiSet) this.parent).modCount == this.mods) {
                if (this.itemCount == 0) {
                    Map.Entry<E, MutableInteger> next = this.entryIterator.next();
                    this.current = next;
                    this.itemCount = next.getValue().value;
                }
                this.canRemove = true;
                this.itemCount--;
                return this.current.getKey();
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (((AbstractMapMultiSet) this.parent).modCount == this.mods) {
                if (this.canRemove) {
                    MutableInteger value = this.current.getValue();
                    int i10 = value.value;
                    if (i10 > 1) {
                        value.value = i10 - 1;
                    } else {
                        this.entryIterator.remove();
                    }
                    AbstractMapMultiSet.access$210(this.parent);
                    this.canRemove = false;
                    return;
                }
                throw new IllegalStateException();
            }
            throw new ConcurrentModificationException();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class MultiSetEntry<E> extends AbstractMultiSet.AbstractEntry<E> {
        public final Map.Entry<E, MutableInteger> parentEntry;

        public MultiSetEntry(Map.Entry<E, MutableInteger> entry) {
            this.parentEntry = entry;
        }

        @Override // org.apache.commons.collections4.MultiSet.Entry
        public int getCount() {
            return this.parentEntry.getValue().value;
        }

        @Override // org.apache.commons.collections4.MultiSet.Entry
        public E getElement() {
            return this.parentEntry.getKey();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class MutableInteger {
        public int value;

        public MutableInteger(int i10) {
            this.value = i10;
        }

        public boolean equals(Object obj) {
            return (obj instanceof MutableInteger) && ((MutableInteger) obj).value == this.value;
        }

        public int hashCode() {
            return this.value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class UniqueSetIterator<E> extends AbstractIteratorDecorator<E> {
        public boolean canRemove;
        public E lastElement;
        public final AbstractMapMultiSet<E> parent;

        public UniqueSetIterator(Iterator<E> it, AbstractMapMultiSet<E> abstractMapMultiSet) {
            super(it);
            this.lastElement = null;
            this.canRemove = false;
            this.parent = abstractMapMultiSet;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
        public E next() {
            E e2 = (E) super.next();
            this.lastElement = e2;
            this.canRemove = true;
            return e2;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator, java.util.Iterator
        public void remove() {
            if (this.canRemove) {
                int count = this.parent.getCount(this.lastElement);
                super.remove();
                this.parent.remove(this.lastElement, count);
                this.lastElement = null;
                this.canRemove = false;
                return;
            }
            throw new IllegalStateException("Iterator remove() can only be called once after next()");
        }
    }

    public AbstractMapMultiSet() {
    }

    public static /* synthetic */ int access$210(AbstractMapMultiSet abstractMapMultiSet) {
        int i10 = abstractMapMultiSet.size;
        abstractMapMultiSet.size = i10 - 1;
        return i10;
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, org.apache.commons.collections4.MultiSet
    public int add(E e2, int i10) {
        if (i10 >= 0) {
            MutableInteger mutableInteger = this.map.get(e2);
            int i11 = mutableInteger != null ? mutableInteger.value : 0;
            if (i10 > 0) {
                this.modCount++;
                this.size += i10;
                if (mutableInteger == null) {
                    this.map.put(e2, new MutableInteger(i10));
                } else {
                    mutableInteger.value += i10;
                }
            }
            return i11;
        }
        throw new IllegalArgumentException("Occurrences must not be negative.");
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.modCount++;
        this.map.clear();
        this.size = 0;
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet
    public Iterator<MultiSet.Entry<E>> createEntrySetIterator() {
        return new EntrySetIterator(this.map.entrySet().iterator2(), this);
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet
    public Iterator<E> createUniqueSetIterator() {
        return new UniqueSetIterator(getMap().h().iterator2(), this);
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet
    public void doReadObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        int readInt = objectInputStream.readInt();
        for (int i10 = 0; i10 < readInt; i10++) {
            Object readObject = objectInputStream.readObject();
            int readInt2 = objectInputStream.readInt();
            this.map.put(readObject, new MutableInteger(readInt2));
            this.size += readInt2;
        }
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet
    public void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.map.size());
        for (Map.Entry<E, MutableInteger> entry : this.map.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(entry.getValue().value);
        }
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MultiSet)) {
            return false;
        }
        MultiSet multiSet = (MultiSet) obj;
        if (multiSet.size() != size()) {
            return false;
        }
        for (E e2 : this.map.h()) {
            if (multiSet.getCount(e2) != getCount(e2)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, org.apache.commons.collections4.MultiSet
    public int getCount(Object obj) {
        MutableInteger mutableInteger = this.map.get(obj);
        if (mutableInteger != null) {
            return mutableInteger.value;
        }
        return 0;
    }

    public Map<E, MutableInteger> getMap() {
        return this.map;
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, java.util.Collection, java.util.Set
    public int hashCode() {
        int i10 = 0;
        for (Map.Entry<E, MutableInteger> entry : this.map.entrySet()) {
            E key = entry.getKey();
            i10 += entry.getValue().value ^ (key == null ? 0 : key.hashCode());
        }
        return i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return new MapBasedMultiSetIterator(this);
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, org.apache.commons.collections4.MultiSet
    public int remove(Object obj, int i10) {
        if (i10 >= 0) {
            MutableInteger mutableInteger = this.map.get(obj);
            if (mutableInteger == null) {
                return 0;
            }
            int i11 = mutableInteger.value;
            if (i10 > 0) {
                this.modCount++;
                if (i10 < i11) {
                    mutableInteger.value = i11 - i10;
                    this.size -= i10;
                } else {
                    this.map.remove(obj);
                    this.size -= mutableInteger.value;
                    mutableInteger.value = 0;
                }
            }
            return i11;
        }
        throw new IllegalArgumentException("Occurrences must not be negative.");
    }

    public void setMap(Map<E, MutableInteger> map) {
        this.map = map;
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        Object[] objArr = new Object[size()];
        int i10 = 0;
        for (Map.Entry<E, MutableInteger> entry : this.map.entrySet()) {
            E key = entry.getKey();
            int i11 = entry.getValue().value;
            while (i11 > 0) {
                objArr[i10] = key;
                i11--;
                i10++;
            }
        }
        return objArr;
    }

    @Override // org.apache.commons.collections4.multiset.AbstractMultiSet
    public int uniqueElements() {
        return this.map.size();
    }

    public AbstractMapMultiSet(Map<E, MutableInteger> map) {
        this.map = map;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        int size = size();
        if (tArr.length < size) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        }
        int i10 = 0;
        for (Map.Entry<E, MutableInteger> entry : this.map.entrySet()) {
            E key = entry.getKey();
            int i11 = entry.getValue().value;
            while (i11 > 0) {
                tArr[i10] = key;
                i11--;
                i10++;
            }
        }
        while (i10 < tArr.length) {
            tArr[i10] = null;
            i10++;
        }
        return tArr;
    }
}
