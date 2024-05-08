package org.apache.commons.collections4.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.collection.PredicatedCollection;
import org.apache.commons.collections4.iterators.AbstractListIteratorDecorator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class PredicatedList<E> extends PredicatedCollection<E> implements List<E> {
    private static final long serialVersionUID = -5722039223898659102L;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class PredicatedListIterator extends AbstractListIteratorDecorator<E> {
        public PredicatedListIterator(ListIterator<E> listIterator) {
            super(listIterator);
        }

        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void add(E e2) {
            PredicatedList.this.validate(e2);
            getListIterator().add(e2);
        }

        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void set(E e2) {
            PredicatedList.this.validate(e2);
            getListIterator().set(e2);
        }
    }

    public PredicatedList(List<E> list, Predicate<? super E> predicate) {
        super(list, predicate);
    }

    public static <T> PredicatedList<T> predicatedList(List<T> list, Predicate<? super T> predicate) {
        return new PredicatedList<>(list, predicate);
    }

    @Override // java.util.List
    public void add(int i10, E e2) {
        validate(e2);
        decorated().add(i10, e2);
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection<? extends E> collection) {
        Iterator<? extends E> iterator2 = collection.iterator2();
        while (iterator2.hasNext()) {
            validate(iterator2.next());
        }
        return decorated().addAll(i10, collection);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        return obj == this || decorated().equals(obj);
    }

    @Override // java.util.List
    public E get(int i10) {
        return decorated().get(i10);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return decorated().hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return decorated().indexOf(obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return decorated().lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public E remove(int i10) {
        return decorated().remove(i10);
    }

    @Override // java.util.List
    public E set(int i10, E e2) {
        validate(e2);
        return decorated().set(i10, e2);
    }

    @Override // java.util.List
    public List<E> subList(int i10, int i11) {
        return new PredicatedList(decorated().subList(i10, i11), this.predicate);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public List<E> decorated() {
        return (List) super.decorated();
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i10) {
        return new PredicatedListIterator(decorated().listIterator(i10));
    }
}
