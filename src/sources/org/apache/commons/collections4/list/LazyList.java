package org.apache.commons.collections4.list;

import java.util.List;
import java.util.Objects;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.Transformer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class LazyList<E> extends AbstractSerializableListDecorator<E> {
    private static final long serialVersionUID = -3677737457567429713L;
    private final Factory<? extends E> factory;
    private final Transformer<Integer, ? extends E> transformer;

    public LazyList(List<E> list, Factory<? extends E> factory) {
        super(list);
        Objects.requireNonNull(factory);
        this.factory = factory;
        this.transformer = null;
    }

    private E element(int i10) {
        Factory<? extends E> factory = this.factory;
        if (factory != null) {
            return factory.create();
        }
        Transformer<Integer, ? extends E> transformer = this.transformer;
        if (transformer != null) {
            return transformer.transform(Integer.valueOf(i10));
        }
        throw new IllegalStateException("Factory and Transformer are both null!");
    }

    public static <E> LazyList<E> lazyList(List<E> list, Factory<? extends E> factory) {
        return new LazyList<>(list, factory);
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public E get(int i10) {
        int size = decorated().size();
        if (i10 < size) {
            E e2 = decorated().get(i10);
            if (e2 != null) {
                return e2;
            }
            E element = element(i10);
            decorated().set(i10, element);
            return element;
        }
        while (size < i10) {
            decorated().add(null);
            size++;
        }
        E element2 = element(i10);
        decorated().add(element2);
        return element2;
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public List<E> subList(int i10, int i11) {
        List<E> subList = decorated().subList(i10, i11);
        Factory<? extends E> factory = this.factory;
        if (factory != null) {
            return new LazyList(subList, factory);
        }
        Transformer<Integer, ? extends E> transformer = this.transformer;
        if (transformer != null) {
            return new LazyList(subList, transformer);
        }
        throw new IllegalStateException("Factory and Transformer are both null!");
    }

    public static <E> LazyList<E> lazyList(List<E> list, Transformer<Integer, ? extends E> transformer) {
        return new LazyList<>(list, transformer);
    }

    public LazyList(List<E> list, Transformer<Integer, ? extends E> transformer) {
        super(list);
        this.factory = null;
        Objects.requireNonNull(transformer);
        this.transformer = transformer;
    }
}
