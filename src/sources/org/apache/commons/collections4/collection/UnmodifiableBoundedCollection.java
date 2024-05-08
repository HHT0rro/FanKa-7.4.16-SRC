package org.apache.commons.collections4.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;
import org.apache.commons.collections4.BoundedCollection;
import org.apache.commons.collections4.Unmodifiable;
import org.apache.commons.collections4.iterators.UnmodifiableIterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class UnmodifiableBoundedCollection<E> extends AbstractCollectionDecorator<E> implements BoundedCollection<E>, Unmodifiable {
    private static final long serialVersionUID = -7112672385450340330L;

    private UnmodifiableBoundedCollection(BoundedCollection<? extends E> boundedCollection) {
        super(boundedCollection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> BoundedCollection<E> unmodifiableBoundedCollection(BoundedCollection<? extends E> boundedCollection) {
        return boundedCollection instanceof Unmodifiable ? boundedCollection : new UnmodifiableBoundedCollection(boundedCollection);
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

    @Override // org.apache.commons.collections4.BoundedCollection
    public boolean isFull() {
        return decorated().isFull();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return UnmodifiableIterator.unmodifiableIterator(decorated().iterator2());
    }

    @Override // org.apache.commons.collections4.BoundedCollection
    public int maxSize() {
        return decorated().maxSize();
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

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public BoundedCollection<E> decorated() {
        return (BoundedCollection) super.decorated();
    }

    public static <E> BoundedCollection<E> unmodifiableBoundedCollection(Collection<? extends E> collection) {
        Objects.requireNonNull(collection, "Collection must not be null.");
        for (int i10 = 0; i10 < 1000 && !(collection instanceof BoundedCollection); i10++) {
            if (collection instanceof AbstractCollectionDecorator) {
                collection = ((AbstractCollectionDecorator) collection).decorated();
            } else if (collection instanceof SynchronizedCollection) {
                collection = ((SynchronizedCollection) collection).decorated();
            }
        }
        if (collection instanceof BoundedCollection) {
            return new UnmodifiableBoundedCollection((BoundedCollection) collection);
        }
        throw new IllegalArgumentException("Collection is not a bounded collection.");
    }
}
