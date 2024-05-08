package java.util;

import java.util.AbstractList;
import java.util.ImmutableCollections;
import java.util.function.UnaryOperator;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface List<E> extends Collection<E> {
    void add(int i10, E e2);

    @Override // java.util.Collection, java.util.Set
    boolean add(E e2);

    boolean addAll(int i10, Collection<? extends E> collection);

    @Override // java.util.Collection, java.util.Set
    boolean addAll(Collection<? extends E> collection);

    @Override // java.util.Collection, java.util.Set
    void clear();

    @Override // java.util.Collection, java.util.Set
    boolean contains(Object obj);

    @Override // java.util.Collection, java.util.Set
    boolean containsAll(Collection<?> collection);

    @Override // java.util.Collection, java.util.Set
    boolean equals(Object obj);

    E get(int i10);

    @Override // java.util.Collection, java.util.Set
    int hashCode();

    int indexOf(Object obj);

    @Override // java.util.Collection, java.util.Set
    boolean isEmpty();

    @Override // java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    Iterator<E> iterator2();

    int lastIndexOf(Object obj);

    ListIterator<E> listIterator();

    ListIterator<E> listIterator(int i10);

    E remove(int i10);

    @Override // java.util.Collection, java.util.Set
    boolean remove(Object obj);

    @Override // java.util.Collection, java.util.Set
    boolean removeAll(Collection<?> collection);

    @Override // java.util.Collection, java.util.Set
    boolean retainAll(Collection<?> collection);

    E set(int i10, E e2);

    @Override // java.util.Collection, java.util.Set
    int size();

    List<E> subList(int i10, int i11);

    @Override // java.util.Collection, java.util.Set
    Object[] toArray();

    @Override // java.util.Collection, java.util.Set
    <T> T[] toArray(T[] tArr);

    /* JADX WARN: Multi-variable type inference failed */
    default void replaceAll(UnaryOperator<E> unaryOperator) {
        Objects.requireNonNull(unaryOperator);
        ListIterator<E> listIterator = listIterator();
        while (listIterator.hasNext()) {
            listIterator.set(unaryOperator.apply(listIterator.next()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    default void sort(Comparator<? super E> comparator) {
        Object[] array = toArray();
        Arrays.sort(array, comparator);
        ListIterator<E> listIterator = listIterator();
        for (Object obj : array) {
            listIterator.next();
            listIterator.set(obj);
        }
    }

    @Override // java.util.Collection, java.lang.Iterable
    default Spliterator<E> spliterator() {
        if (this instanceof RandomAccess) {
            return new AbstractList.RandomAccessSpliterator(this);
        }
        return Spliterators.spliterator(this, 16);
    }

    static <E> List<E> of() {
        return ImmutableCollections.EMPTY_LIST;
    }

    static <E> List<E> of(E e12) {
        return new ImmutableCollections.List12(e12);
    }

    static <E> List<E> of(E e12, E e2) {
        return new ImmutableCollections.List12(e12, e2);
    }

    static <E> List<E> of(E e12, E e2, E e32) {
        return ImmutableCollections.listFromTrustedArray(e12, e2, e32);
    }

    static <E> List<E> of(E e12, E e2, E e32, E e42) {
        return ImmutableCollections.listFromTrustedArray(e12, e2, e32, e42);
    }

    static <E> List<E> of(E e12, E e2, E e32, E e42, E e52) {
        return ImmutableCollections.listFromTrustedArray(e12, e2, e32, e42, e52);
    }

    static <E> List<E> of(E e12, E e2, E e32, E e42, E e52, E e62) {
        return ImmutableCollections.listFromTrustedArray(e12, e2, e32, e42, e52, e62);
    }

    static <E> List<E> of(E e12, E e2, E e32, E e42, E e52, E e62, E e72) {
        return ImmutableCollections.listFromTrustedArray(e12, e2, e32, e42, e52, e62, e72);
    }

    static <E> List<E> of(E e12, E e2, E e32, E e42, E e52, E e62, E e72, E e82) {
        return ImmutableCollections.listFromTrustedArray(e12, e2, e32, e42, e52, e62, e72, e82);
    }

    static <E> List<E> of(E e12, E e2, E e32, E e42, E e52, E e62, E e72, E e82, E e92) {
        return ImmutableCollections.listFromTrustedArray(e12, e2, e32, e42, e52, e62, e72, e82, e92);
    }

    static <E> List<E> of(E e12, E e2, E e32, E e42, E e52, E e62, E e72, E e82, E e92, E e10) {
        return ImmutableCollections.listFromTrustedArray(e12, e2, e32, e42, e52, e62, e72, e82, e92, e10);
    }

    @SafeVarargs
    static <E> List<E> of(E... elements) {
        switch (elements.length) {
            case 0:
                List<E> list = ImmutableCollections.EMPTY_LIST;
                return list;
            case 1:
                return new ImmutableCollections.List12(elements[0]);
            case 2:
                return new ImmutableCollections.List12(elements[0], elements[1]);
            default:
                return ImmutableCollections.listFromArray(elements);
        }
    }

    static <E> List<E> copyOf(Collection<? extends E> coll) {
        return ImmutableCollections.listCopy(coll);
    }
}
