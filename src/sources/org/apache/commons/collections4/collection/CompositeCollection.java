package org.apache.commons.collections4.collection;

import androidx.core.util.a;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.list.UnmodifiableList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class CompositeCollection<E> implements Collection<E>, Serializable {
    private static final long serialVersionUID = 8417515734108306801L;
    private final List<Collection<E>> all = new ArrayList();
    private CollectionMutator<E> mutator;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface CollectionMutator<E> extends Serializable {
        boolean add(CompositeCollection<E> compositeCollection, List<Collection<E>> list, E e2);

        boolean addAll(CompositeCollection<E> compositeCollection, List<Collection<E>> list, Collection<? extends E> collection);

        boolean remove(CompositeCollection<E> compositeCollection, List<Collection<E>> list, Object obj);
    }

    public CompositeCollection() {
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e2) {
        CollectionMutator<E> collectionMutator = this.mutator;
        if (collectionMutator != null) {
            return collectionMutator.add(this, this.all, e2);
        }
        throw new UnsupportedOperationException("add() is not supported on CompositeCollection without a CollectionMutator strategy");
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        CollectionMutator<E> collectionMutator = this.mutator;
        if (collectionMutator != null) {
            return collectionMutator.addAll(this, this.all, collection);
        }
        throw new UnsupportedOperationException("addAll() is not supported on CompositeCollection without a CollectionMutator strategy");
    }

    public void addComposited(Collection<E> collection) {
        if (collection != null) {
            this.all.add(collection);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        Iterator<Collection<E>> iterator2 = this.all.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().clear();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        Iterator<Collection<E>> iterator2 = this.all.iterator2();
        while (iterator2.hasNext()) {
            if (iterator2.next().contains(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        if (collection == null) {
            return false;
        }
        Iterator<?> iterator2 = collection.iterator2();
        while (iterator2.hasNext()) {
            if (!contains(iterator2.next())) {
                return false;
            }
        }
        return true;
    }

    public List<Collection<E>> getCollections() {
        return UnmodifiableList.unmodifiableList(this.all);
    }

    public CollectionMutator<E> getMutator() {
        return this.mutator;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        Iterator<Collection<E>> iterator2 = this.all.iterator2();
        while (iterator2.hasNext()) {
            if (!iterator2.next().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        if (this.all.isEmpty()) {
            return EmptyIterator.emptyIterator();
        }
        IteratorChain iteratorChain = new IteratorChain();
        Iterator<Collection<E>> iterator2 = this.all.iterator2();
        while (iterator2.hasNext()) {
            iteratorChain.addIterator(iterator2.next().iterator2());
        }
        return iteratorChain;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        CollectionMutator<E> collectionMutator = this.mutator;
        if (collectionMutator != null) {
            return collectionMutator.remove(this, this.all, obj);
        }
        throw new UnsupportedOperationException("remove() is not supported on CompositeCollection without a CollectionMutator strategy");
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        boolean z10 = false;
        if (CollectionUtils.isEmpty(collection)) {
            return false;
        }
        Iterator<Collection<E>> iterator2 = this.all.iterator2();
        while (iterator2.hasNext()) {
            z10 |= iterator2.next().removeAll(collection);
        }
        return z10;
    }

    public void removeComposited(Collection<E> collection) {
        this.all.remove(collection);
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super E> predicate) {
        boolean z10 = false;
        if (a.a(predicate)) {
            return false;
        }
        Iterator<Collection<E>> iterator2 = this.all.iterator2();
        while (iterator2.hasNext()) {
            z10 |= iterator2.next().removeIf(predicate);
        }
        return z10;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z10 = false;
        if (collection != null) {
            Iterator<Collection<E>> iterator2 = this.all.iterator2();
            while (iterator2.hasNext()) {
                z10 |= iterator2.next().retainAll(collection);
            }
        }
        return z10;
    }

    public void setMutator(CollectionMutator<E> collectionMutator) {
        this.mutator = collectionMutator;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        Iterator<Collection<E>> iterator2 = this.all.iterator2();
        int i10 = 0;
        while (iterator2.hasNext()) {
            i10 += iterator2.next().size();
        }
        return i10;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        Object[] objArr = new Object[size()];
        Iterator<E> iterator2 = iterator2();
        int i10 = 0;
        while (iterator2.hasNext()) {
            objArr[i10] = iterator2.next();
            i10++;
        }
        return objArr;
    }

    public Collection<E> toCollection() {
        return new ArrayList(this);
    }

    public void addComposited(Collection<E> collection, Collection<E> collection2) {
        if (collection != null) {
            this.all.add(collection);
        }
        if (collection2 != null) {
            this.all.add(collection2);
        }
    }

    public CompositeCollection(Collection<E> collection) {
        addComposited(collection);
    }

    public void addComposited(Collection<E>... collectionArr) {
        for (Collection<E> collection : collectionArr) {
            if (collection != null) {
                this.all.add(collection);
            }
        }
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        int size = size();
        if (tArr.length < size) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        }
        int i10 = 0;
        Iterator<Collection<E>> iterator2 = this.all.iterator2();
        while (iterator2.hasNext()) {
            Iterator<E> iterator22 = iterator2.next().iterator2();
            while (iterator22.hasNext()) {
                tArr[i10] = iterator22.next();
                i10++;
            }
        }
        if (tArr.length > size) {
            tArr[size] = null;
        }
        return tArr;
    }

    public CompositeCollection(Collection<E> collection, Collection<E> collection2) {
        addComposited(collection, collection2);
    }

    public CompositeCollection(Collection<E>... collectionArr) {
        addComposited(collectionArr);
    }
}
