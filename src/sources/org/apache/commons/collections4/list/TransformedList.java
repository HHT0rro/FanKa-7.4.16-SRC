package org.apache.commons.collections4.list;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.collection.TransformedCollection;
import org.apache.commons.collections4.iterators.AbstractListIteratorDecorator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class TransformedList<E> extends TransformedCollection<E> implements List<E> {
    private static final long serialVersionUID = 1077193035000013141L;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class TransformedListIterator extends AbstractListIteratorDecorator<E> {
        public TransformedListIterator(ListIterator<E> listIterator) {
            super(listIterator);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void add(E e2) {
            getListIterator().add(TransformedList.this.transform((TransformedList) e2));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void set(E e2) {
            getListIterator().set(TransformedList.this.transform((TransformedList) e2));
        }
    }

    public TransformedList(List<E> list, Transformer<? super E, ? extends E> transformer) {
        super(list, transformer);
    }

    public static <E> TransformedList<E> transformedList(List<E> list, Transformer<? super E, ? extends E> transformer) {
        TransformedList<E> transformedList = new TransformedList<>(list, transformer);
        if (list.size() > 0) {
            Object[] array = list.toArray();
            list.clear();
            for (Object obj : array) {
                transformedList.decorated().add(transformer.transform(obj));
            }
        }
        return transformedList;
    }

    public static <E> TransformedList<E> transformingList(List<E> list, Transformer<? super E, ? extends E> transformer) {
        return new TransformedList<>(list, transformer);
    }

    @Override // java.util.List
    public void add(int i10, E e2) {
        getList().add(i10, transform((TransformedList<E>) e2));
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection<? extends E> collection) {
        return getList().addAll(i10, transform((Collection) collection));
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        return obj == this || decorated().equals(obj);
    }

    @Override // java.util.List
    public E get(int i10) {
        return getList().get(i10);
    }

    public List<E> getList() {
        return (List) decorated();
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return decorated().hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return getList().indexOf(obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return getList().lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public E remove(int i10) {
        return getList().remove(i10);
    }

    @Override // java.util.List
    public E set(int i10, E e2) {
        return getList().set(i10, transform((TransformedList<E>) e2));
    }

    @Override // java.util.List
    public List<E> subList(int i10, int i11) {
        return new TransformedList(getList().subList(i10, i11), this.transformer);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i10) {
        return new TransformedListIterator(getList().listIterator(i10));
    }
}
