package org.apache.commons.collections4.set;

import androidx.core.util.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.functors.UniquePredicate;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.list.UnmodifiableList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ListOrderedSet<E> extends AbstractSerializableSetDecorator<E> {
    private static final long serialVersionUID = -228664372470420141L;
    private final List<E> setOrder;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class OrderedSetIterator<E> extends AbstractIteratorDecorator<E> implements OrderedIterator<E> {
        private E last;
        private final Collection<E> set;

        @Override // org.apache.commons.collections4.OrderedIterator
        public boolean hasPrevious() {
            return ((ListIterator) getIterator()).hasPrevious();
        }

        @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
        public E next() {
            E next = getIterator().next();
            this.last = next;
            return next;
        }

        @Override // org.apache.commons.collections4.OrderedIterator
        public E previous() {
            E e2 = (E) ((ListIterator) getIterator()).previous();
            this.last = e2;
            return e2;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator, java.util.Iterator
        public void remove() {
            this.set.remove(this.last);
            getIterator().remove();
            this.last = null;
        }

        private OrderedSetIterator(ListIterator<E> listIterator, Collection<E> collection) {
            super(listIterator);
            this.set = collection;
        }
    }

    public ListOrderedSet() {
        super(new HashSet());
        this.setOrder = new ArrayList();
    }

    public static <E> ListOrderedSet<E> listOrderedSet(Set<E> set, List<E> list) {
        Objects.requireNonNull(set, "Set must not be null");
        Objects.requireNonNull(list, "List must not be null");
        if (set.size() <= 0 && list.size() <= 0) {
            return new ListOrderedSet<>(set, list);
        }
        throw new IllegalArgumentException("Set and List must be empty");
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        if (!decorated().add(e2)) {
            return false;
        }
        this.setOrder.add(e2);
        return true;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        Iterator<? extends E> iterator2 = collection.iterator2();
        boolean z10 = false;
        while (iterator2.hasNext()) {
            z10 |= add(iterator2.next());
        }
        return z10;
    }

    public List<E> asList() {
        return UnmodifiableList.unmodifiableList(this.setOrder);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public void clear() {
        decorated().clear();
        this.setOrder.clear();
    }

    public E get(int i10) {
        return this.setOrder.get(i10);
    }

    public int indexOf(Object obj) {
        return this.setOrder.indexOf(obj);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        boolean remove = decorated().remove(obj);
        if (remove) {
            this.setOrder.remove(obj);
        }
        return remove;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> iterator2 = collection.iterator2();
        boolean z10 = false;
        while (iterator2.hasNext()) {
            z10 |= remove(iterator2.next());
        }
        return z10;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean removeIf(Predicate<? super E> predicate) {
        if (a.a(predicate)) {
            return false;
        }
        boolean removeIf = decorated().removeIf(predicate);
        if (removeIf) {
            this.setOrder.removeIf(predicate);
        }
        return removeIf;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean retainAll = decorated().retainAll(collection);
        if (!retainAll) {
            return false;
        }
        if (decorated().size() == 0) {
            this.setOrder.clear();
        } else {
            Iterator<E> iterator2 = this.setOrder.iterator2();
            while (iterator2.hasNext()) {
                if (!decorated().contains(iterator2.next())) {
                    iterator2.remove();
                }
            }
        }
        return retainAll;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return this.setOrder.toArray();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public String toString() {
        return this.setOrder.toString();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public OrderedIterator<E> iterator2() {
        return new OrderedSetIterator(this.setOrder.listIterator(), decorated());
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.setOrder.toArray(tArr);
    }

    public ListOrderedSet(Set<E> set) {
        super(set);
        this.setOrder = new ArrayList(set);
    }

    public void add(int i10, E e2) {
        if (contains(e2)) {
            return;
        }
        decorated().add(e2);
        this.setOrder.add(i10, e2);
    }

    public boolean addAll(int i10, Collection<? extends E> collection) {
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        for (E e2 : collection) {
            if (!contains(e2)) {
                decorated().add(e2);
                arrayList.add(e2);
                z10 = true;
            }
        }
        if (z10) {
            this.setOrder.addAll(i10, arrayList);
        }
        return z10;
    }

    public E remove(int i10) {
        E remove = this.setOrder.remove(i10);
        remove(remove);
        return remove;
    }

    public ListOrderedSet(Set<E> set, List<E> list) {
        super(set);
        Objects.requireNonNull(list, "List must not be null");
        this.setOrder = list;
    }

    public static <E> ListOrderedSet<E> listOrderedSet(Set<E> set) {
        return new ListOrderedSet<>(set);
    }

    public static <E> ListOrderedSet<E> listOrderedSet(List<E> list) {
        Objects.requireNonNull(list, "List must not be null");
        CollectionUtils.filter(list, UniquePredicate.uniquePredicate());
        return new ListOrderedSet<>(new HashSet(list), list);
    }
}
