package org.apache.commons.collections4.set;

import androidx.core.util.a;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.list.UnmodifiableList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class CompositeSet<E> implements Set<E>, Serializable {
    private static final long serialVersionUID = 5185069727540378940L;
    private final List<Set<E>> all = new ArrayList();
    private SetMutator<E> mutator;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface SetMutator<E> extends Serializable {
        boolean add(CompositeSet<E> compositeSet, List<Set<E>> list, E e2);

        boolean addAll(CompositeSet<E> compositeSet, List<Set<E>> list, Collection<? extends E> collection);

        void resolveCollision(CompositeSet<E> compositeSet, Set<E> set, Set<E> set2, Collection<E> collection);
    }

    public CompositeSet() {
    }

    @Override // java.util.Set
    public boolean add(E e2) {
        SetMutator<E> setMutator = this.mutator;
        if (setMutator != null) {
            return setMutator.add(this, this.all, e2);
        }
        throw new UnsupportedOperationException("add() is not supported on CompositeSet without a SetMutator strategy");
    }

    @Override // java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        SetMutator<E> setMutator = this.mutator;
        if (setMutator != null) {
            return setMutator.addAll(this, this.all, collection);
        }
        throw new UnsupportedOperationException("addAll() is not supported on CompositeSet without a SetMutator strategy");
    }

    public synchronized void addComposited(Set<E> set) {
        if (set != null) {
            for (Set<E> set2 : getSets()) {
                Collection<E> intersection = CollectionUtils.intersection(set2, set);
                if (intersection.size() > 0) {
                    if (this.mutator != null) {
                        getMutator().resolveCollision(this, set2, set, intersection);
                        if (CollectionUtils.intersection(set2, set).size() > 0) {
                            throw new IllegalArgumentException("Attempt to add illegal entry unresolved by SetMutator.resolveCollision()");
                        }
                    } else {
                        throw new UnsupportedOperationException("Collision adding composited set with no SetMutator set");
                    }
                }
            }
            this.all.add(set);
        }
    }

    @Override // java.util.Set
    public void clear() {
        Iterator<Set<E>> iterator2 = this.all.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().clear();
        }
    }

    @Override // java.util.Set
    public boolean contains(Object obj) {
        Iterator<Set<E>> iterator2 = this.all.iterator2();
        while (iterator2.hasNext()) {
            if (iterator2.next().contains(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Set
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

    @Override // java.util.Set
    public boolean equals(Object obj) {
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        return set.size() == size() && set.containsAll(this);
    }

    public SetMutator<E> getMutator() {
        return this.mutator;
    }

    public List<Set<E>> getSets() {
        return UnmodifiableList.unmodifiableList(this.all);
    }

    @Override // java.util.Set
    public int hashCode() {
        Iterator<E> iterator2 = iterator2();
        int i10 = 0;
        while (iterator2.hasNext()) {
            E next = iterator2.next();
            i10 += next == null ? 0 : next.hashCode();
        }
        return i10;
    }

    @Override // java.util.Set
    public boolean isEmpty() {
        Iterator<Set<E>> iterator2 = this.all.iterator2();
        while (iterator2.hasNext()) {
            if (!iterator2.next().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        if (this.all.isEmpty()) {
            return EmptyIterator.emptyIterator();
        }
        IteratorChain iteratorChain = new IteratorChain();
        Iterator<Set<E>> iterator2 = this.all.iterator2();
        while (iterator2.hasNext()) {
            iteratorChain.addIterator(iterator2.next().iterator2());
        }
        return iteratorChain;
    }

    @Override // java.util.Set
    public boolean remove(Object obj) {
        for (Set<E> set : getSets()) {
            if (set.contains(obj)) {
                return set.remove(obj);
            }
        }
        return false;
    }

    @Override // java.util.Set
    public boolean removeAll(Collection<?> collection) {
        boolean z10 = false;
        if (CollectionUtils.isEmpty(collection)) {
            return false;
        }
        Iterator<Set<E>> iterator2 = this.all.iterator2();
        while (iterator2.hasNext()) {
            z10 |= iterator2.next().removeAll(collection);
        }
        return z10;
    }

    public void removeComposited(Set<E> set) {
        this.all.remove(set);
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super E> predicate) {
        boolean z10 = false;
        if (a.a(predicate)) {
            return false;
        }
        Iterator<Set<E>> iterator2 = this.all.iterator2();
        while (iterator2.hasNext()) {
            z10 |= iterator2.next().removeIf(predicate);
        }
        return z10;
    }

    @Override // java.util.Set
    public boolean retainAll(Collection<?> collection) {
        Iterator<Set<E>> iterator2 = this.all.iterator2();
        boolean z10 = false;
        while (iterator2.hasNext()) {
            z10 |= iterator2.next().retainAll(collection);
        }
        return z10;
    }

    public void setMutator(SetMutator<E> setMutator) {
        this.mutator = setMutator;
    }

    @Override // java.util.Set
    public int size() {
        Iterator<Set<E>> iterator2 = this.all.iterator2();
        int i10 = 0;
        while (iterator2.hasNext()) {
            i10 += iterator2.next().size();
        }
        return i10;
    }

    @Override // java.util.Set
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

    public Set<E> toSet() {
        return new HashSet(this);
    }

    public CompositeSet(Set<E> set) {
        addComposited(set);
    }

    @Override // java.util.Set
    public <T> T[] toArray(T[] tArr) {
        int size = size();
        if (tArr.length < size) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        }
        int i10 = 0;
        Iterator<Set<E>> iterator2 = this.all.iterator2();
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

    public CompositeSet(Set<E>... setArr) {
        addComposited(setArr);
    }

    public void addComposited(Set<E> set, Set<E> set2) {
        addComposited(set);
        addComposited(set2);
    }

    public void addComposited(Set<E>... setArr) {
        if (setArr != null) {
            for (Set<E> set : setArr) {
                addComposited(set);
            }
        }
    }
}
