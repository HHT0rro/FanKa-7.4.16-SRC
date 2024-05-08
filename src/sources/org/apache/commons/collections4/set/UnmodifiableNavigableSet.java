package org.apache.commons.collections4.set;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.function.Predicate;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class UnmodifiableNavigableSet<E> extends AbstractNavigableSetDecorator<E> implements Unmodifiable {
    private static final long serialVersionUID = 20150528;

    private UnmodifiableNavigableSet(NavigableSet<E> navigableSet) {
        super(navigableSet);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        setCollection((Collection) objectInputStream.readObject());
    }

    public static <E> NavigableSet<E> unmodifiableNavigableSet(NavigableSet<E> navigableSet) {
        return navigableSet instanceof Unmodifiable ? navigableSet : new UnmodifiableNavigableSet(navigableSet);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(decorated());
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.set.AbstractNavigableSetDecorator, java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return UnmodifiableIterator.unmodifiableIterator(decorated().descendingIterator());
    }

    @Override // org.apache.commons.collections4.set.AbstractNavigableSetDecorator, java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        return unmodifiableNavigableSet(decorated().descendingSet());
    }

    @Override // org.apache.commons.collections4.set.AbstractSortedSetDecorator, java.util.SortedSet, java.util.NavigableSet
    public SortedSet<E> headSet(E e2) {
        return UnmodifiableSortedSet.unmodifiableSortedSet(decorated().headSet(e2));
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return UnmodifiableIterator.unmodifiableIterator(decorated().iterator2());
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean removeIf(Predicate<? super E> predicate) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections4.set.AbstractSortedSetDecorator, java.util.SortedSet, java.util.NavigableSet
    public SortedSet<E> subSet(E e2, E e10) {
        return UnmodifiableSortedSet.unmodifiableSortedSet(decorated().subSet(e2, e10));
    }

    @Override // org.apache.commons.collections4.set.AbstractSortedSetDecorator, java.util.SortedSet, java.util.NavigableSet
    public SortedSet<E> tailSet(E e2) {
        return UnmodifiableSortedSet.unmodifiableSortedSet(decorated().tailSet(e2));
    }

    @Override // org.apache.commons.collections4.set.AbstractNavigableSetDecorator, java.util.NavigableSet
    public NavigableSet<E> headSet(E e2, boolean z10) {
        return unmodifiableNavigableSet(decorated().headSet(e2, z10));
    }

    @Override // org.apache.commons.collections4.set.AbstractNavigableSetDecorator, java.util.NavigableSet
    public NavigableSet<E> subSet(E e2, boolean z10, E e10, boolean z11) {
        return unmodifiableNavigableSet(decorated().subSet(e2, z10, e10, z11));
    }

    @Override // org.apache.commons.collections4.set.AbstractNavigableSetDecorator, java.util.NavigableSet
    public NavigableSet<E> tailSet(E e2, boolean z10) {
        return unmodifiableNavigableSet(decorated().tailSet(e2, z10));
    }
}
