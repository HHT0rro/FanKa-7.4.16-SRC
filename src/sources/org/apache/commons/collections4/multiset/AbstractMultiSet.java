package org.apache.commons.collections4.multiset;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.Transformer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractMultiSet<E> extends AbstractCollection<E> implements MultiSet<E> {
    private transient Set<MultiSet.Entry<E>> entrySet;
    private transient Set<E> uniqueSet;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class AbstractEntry<E> implements MultiSet.Entry<E> {
        @Override // org.apache.commons.collections4.MultiSet.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof MultiSet.Entry)) {
                return false;
            }
            MultiSet.Entry entry = (MultiSet.Entry) obj;
            E element = getElement();
            Object element2 = entry.getElement();
            if (getCount() == entry.getCount()) {
                return element == element2 || (element != null && element.equals(element2));
            }
            return false;
        }

        @Override // org.apache.commons.collections4.MultiSet.Entry
        public int hashCode() {
            E element = getElement();
            return (element == null ? 0 : element.hashCode()) ^ getCount();
        }

        public String toString() {
            return String.format("%s:%d", getElement(), Integer.valueOf(getCount()));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class EntrySet<E> extends AbstractSet<MultiSet.Entry<E>> {
        private final AbstractMultiSet<E> parent;

        public EntrySet(AbstractMultiSet<E> abstractMultiSet) {
            this.parent = abstractMultiSet;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof MultiSet.Entry)) {
                return false;
            }
            MultiSet.Entry entry = (MultiSet.Entry) obj;
            return this.parent.getCount(entry.getElement()) == entry.getCount();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<MultiSet.Entry<E>> iterator2() {
            return this.parent.createEntrySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int count;
            if (!(obj instanceof MultiSet.Entry)) {
                return false;
            }
            MultiSet.Entry entry = (MultiSet.Entry) obj;
            Object element = entry.getElement();
            if (!this.parent.contains(element) || entry.getCount() != (count = this.parent.getCount(element))) {
                return false;
            }
            this.parent.remove(element, count);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.parent.uniqueElements();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class MultiSetIterator<E> implements Iterator<E> {
        private final Iterator<MultiSet.Entry<E>> entryIterator;
        private int itemCount;
        private final AbstractMultiSet<E> parent;
        private MultiSet.Entry<E> current = null;
        private boolean canRemove = false;

        public MultiSetIterator(AbstractMultiSet<E> abstractMultiSet) {
            this.parent = abstractMultiSet;
            this.entryIterator = abstractMultiSet.entrySet().iterator2();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.itemCount > 0 || this.entryIterator.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.itemCount == 0) {
                MultiSet.Entry<E> next = this.entryIterator.next();
                this.current = next;
                this.itemCount = next.getCount();
            }
            this.canRemove = true;
            this.itemCount--;
            return this.current.getElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.canRemove) {
                if (this.current.getCount() > 1) {
                    this.parent.remove(this.current.getElement());
                } else {
                    this.entryIterator.remove();
                }
                this.canRemove = false;
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class UniqueSet<E> extends AbstractSet<E> {
        public final AbstractMultiSet<E> parent;

        public UniqueSet(AbstractMultiSet<E> abstractMultiSet) {
            this.parent = abstractMultiSet;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.parent.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.parent.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return this.parent.containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<E> iterator2() {
            return this.parent.createUniqueSetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            AbstractMultiSet<E> abstractMultiSet = this.parent;
            return abstractMultiSet.remove(obj, abstractMultiSet.getCount(obj)) != 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.parent.uniqueElements();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        add(e2, 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        Iterator<MultiSet.Entry<E>> iterator2 = entrySet().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next();
            iterator2.remove();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return getCount(obj) > 0;
    }

    public Set<MultiSet.Entry<E>> createEntrySet() {
        return new EntrySet(this);
    }

    public abstract Iterator<MultiSet.Entry<E>> createEntrySetIterator();

    public Set<E> createUniqueSet() {
        return new UniqueSet(this);
    }

    public Iterator<E> createUniqueSetIterator() {
        return IteratorUtils.transformedIterator(entrySet().iterator2(), new Transformer<MultiSet.Entry<E>, E>() { // from class: org.apache.commons.collections4.multiset.AbstractMultiSet.1
            @Override // org.apache.commons.collections4.Transformer
            public E transform(MultiSet.Entry<E> entry) {
                return entry.getElement();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void doReadObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        int readInt = objectInputStream.readInt();
        for (int i10 = 0; i10 < readInt; i10++) {
            setCount(objectInputStream.readObject(), objectInputStream.readInt());
        }
    }

    public void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(entrySet().size());
        for (MultiSet.Entry<E> entry : entrySet()) {
            objectOutputStream.writeObject(entry.getElement());
            objectOutputStream.writeInt(entry.getCount());
        }
    }

    @Override // org.apache.commons.collections4.MultiSet
    public Set<MultiSet.Entry<E>> entrySet() {
        if (this.entrySet == null) {
            this.entrySet = createEntrySet();
        }
        return this.entrySet;
    }

    @Override // java.util.Collection, java.util.Set
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
        for (MultiSet.Entry<E> entry : entrySet()) {
            if (multiSet.getCount(entry.getElement()) != getCount(entry.getElement())) {
                return false;
            }
        }
        return true;
    }

    public int getCount(Object obj) {
        for (MultiSet.Entry<E> entry : entrySet()) {
            E element = entry.getElement();
            if (element == obj || (element != null && element.equals(obj))) {
                return entry.getCount();
            }
        }
        return 0;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return new MultiSetIterator(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return remove(obj, 1) != 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        boolean z10;
        while (true) {
            for (Object obj : collection) {
                z10 = z10 || (remove(obj, getCount(obj)) != 0);
            }
            return z10;
        }
    }

    @Override // org.apache.commons.collections4.MultiSet
    public int setCount(E e2, int i10) {
        if (i10 >= 0) {
            int count = getCount(e2);
            if (count < i10) {
                add(e2, i10 - count);
            } else {
                remove(e2, count - i10);
            }
            return count;
        }
        throw new IllegalArgumentException("Count must not be negative.");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        Iterator<MultiSet.Entry<E>> iterator2 = entrySet().iterator2();
        int i10 = 0;
        while (iterator2.hasNext()) {
            i10 += iterator2.next().getCount();
        }
        return i10;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return entrySet().toString();
    }

    public abstract int uniqueElements();

    @Override // org.apache.commons.collections4.MultiSet
    public Set<E> uniqueSet() {
        if (this.uniqueSet == null) {
            this.uniqueSet = createUniqueSet();
        }
        return this.uniqueSet;
    }

    public int add(E e2, int i10) {
        throw new UnsupportedOperationException();
    }

    public int remove(Object obj, int i10) {
        throw new UnsupportedOperationException();
    }
}
