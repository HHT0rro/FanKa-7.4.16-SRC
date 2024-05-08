package org.apache.commons.collections4.collection;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractCollectionDecorator<E> implements Collection<E>, Serializable {
    private static final long serialVersionUID = 6249888059822088500L;
    private Collection<E> collection;

    public AbstractCollectionDecorator() {
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e2) {
        return decorated().add(e2);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        return decorated().addAll(collection);
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        decorated().clear();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return decorated().contains(obj);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        return decorated().containsAll(collection);
    }

    public Collection<E> decorated() {
        return this.collection;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return decorated().isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return decorated().iterator2();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return decorated().remove(obj);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        return decorated().removeAll(collection);
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super E> predicate) {
        return decorated().removeIf(predicate);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        return decorated().retainAll(collection);
    }

    public void setCollection(Collection<E> collection) {
        this.collection = collection;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return decorated().size();
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        return decorated().toArray();
    }

    public String toString() {
        return decorated().toString();
    }

    public AbstractCollectionDecorator(Collection<E> collection) {
        Objects.requireNonNull(collection, "Collection must not be null.");
        this.collection = collection;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) decorated().toArray(tArr);
    }
}
