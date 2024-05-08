package org.apache.commons.collections4.list;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractListDecorator<E> extends AbstractCollectionDecorator<E> implements List<E> {
    private static final long serialVersionUID = 4500739654952315623L;

    public AbstractListDecorator() {
    }

    @Override // java.util.List
    public void add(int i10, E e2) {
        decorated().add(i10, e2);
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection<? extends E> collection) {
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
        return decorated().listIterator();
    }

    @Override // java.util.List
    public E remove(int i10) {
        return decorated().remove(i10);
    }

    @Override // java.util.List
    public E set(int i10, E e2) {
        return decorated().set(i10, e2);
    }

    @Override // java.util.List
    public List<E> subList(int i10, int i11) {
        return decorated().subList(i10, i11);
    }

    public AbstractListDecorator(List<E> list) {
        super(list);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public List<E> decorated() {
        return (List) super.decorated();
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i10) {
        return decorated().listIterator(i10);
    }
}
