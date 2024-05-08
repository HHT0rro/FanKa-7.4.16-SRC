package org.apache.commons.collections4.list;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.iterators.AbstractListIteratorDecorator;
import org.apache.commons.collections4.set.UnmodifiableSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class SetUniqueList<E> extends AbstractSerializableListDecorator<E> {
    private static final long serialVersionUID = 7196982186153478694L;
    private final Set<E> set;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class SetListIterator<E> extends AbstractIteratorDecorator<E> {
        private E last;
        private final Set<E> set;

        public SetListIterator(Iterator<E> it, Set<E> set) {
            super(it);
            this.last = null;
            this.set = set;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
        public E next() {
            E e2 = (E) super.next();
            this.last = e2;
            return e2;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator, java.util.Iterator
        public void remove() {
            super.remove();
            this.set.remove(this.last);
            this.last = null;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class SetListListIterator<E> extends AbstractListIteratorDecorator<E> {
        private E last;
        private final Set<E> set;

        public SetListListIterator(ListIterator<E> listIterator, Set<E> set) {
            super(listIterator);
            this.last = null;
            this.set = set;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void add(E e2) {
            if (this.set.contains(e2)) {
                return;
            }
            super.add(e2);
            this.set.add(e2);
        }

        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator, java.util.Iterator
        public E next() {
            E e2 = (E) super.next();
            this.last = e2;
            return e2;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public E previous() {
            E e2 = (E) super.previous();
            this.last = e2;
            return e2;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator, java.util.Iterator
        public void remove() {
            super.remove();
            this.set.remove(this.last);
            this.last = null;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void set(E e2) {
            throw new UnsupportedOperationException("ListIterator does not support set");
        }
    }

    public SetUniqueList(List<E> list, Set<E> set) {
        super(list);
        Objects.requireNonNull(set, "Set must not be null");
        this.set = set;
    }

    public static <E> SetUniqueList<E> setUniqueList(List<E> list) {
        Objects.requireNonNull(list, "List must not be null");
        if (list.isEmpty()) {
            return new SetUniqueList<>(list, new HashSet());
        }
        ArrayList arrayList = new ArrayList(list);
        list.clear();
        SetUniqueList<E> setUniqueList = new SetUniqueList<>(list, new HashSet());
        setUniqueList.addAll(arrayList);
        return setUniqueList;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        int size = size();
        add(size(), e2);
        return size != size();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        return addAll(size(), collection);
    }

    public Set<E> asSet() {
        return UnmodifiableSet.unmodifiableSet(this.set);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public void clear() {
        super.clear();
        this.set.clear();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.set.contains(obj);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        return this.set.containsAll(collection);
    }

    public Set<E> createSetBasedOnList(Set<E> set, List<E> list) {
        if (set.getClass().equals(HashSet.class)) {
            return new HashSet(list.size());
        }
        try {
            return (Set) set.getClass().getDeclaredConstructor(set.getClass()).newInstance(set);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            return new HashSet();
        }
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return new SetListIterator(super.iterator2(), this.set);
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public ListIterator<E> listIterator() {
        return new SetListListIterator(super.listIterator(), this.set);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        boolean remove = this.set.remove(obj);
        if (remove) {
            super.remove(obj);
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
        boolean removeIf = super.removeIf(predicate);
        this.set.removeIf(predicate);
        return removeIf;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean retainAll = this.set.retainAll(collection);
        if (!retainAll) {
            return false;
        }
        if (this.set.size() == 0) {
            super.clear();
        } else {
            super.retainAll(this.set);
        }
        return retainAll;
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public E set(int i10, E e2) {
        int indexOf = indexOf(e2);
        E e10 = (E) super.set(i10, e2);
        if (indexOf != -1 && indexOf != i10) {
            super.remove(indexOf);
        }
        this.set.remove(e10);
        this.set.add(e2);
        return e10;
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public List<E> subList(int i10, int i11) {
        List<E> subList = super.subList(i10, i11);
        return ListUtils.unmodifiableList(new SetUniqueList(subList, createSetBasedOnList(this.set, subList)));
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public boolean addAll(int i10, Collection<? extends E> collection) {
        ArrayList arrayList = new ArrayList();
        for (E e2 : collection) {
            if (this.set.add(e2)) {
                arrayList.add(e2);
            }
        }
        return super.addAll(i10, arrayList);
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public ListIterator<E> listIterator(int i10) {
        return new SetListListIterator(super.listIterator(i10), this.set);
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public E remove(int i10) {
        E e2 = (E) super.remove(i10);
        this.set.remove(e2);
        return e2;
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public void add(int i10, E e2) {
        if (this.set.contains(e2)) {
            return;
        }
        this.set.add(e2);
        super.add(i10, e2);
    }
}
