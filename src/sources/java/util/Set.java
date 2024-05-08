package java.util;

import java.util.ImmutableCollections;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface Set<E> extends Collection<E> {
    boolean add(E e2);

    boolean addAll(Collection<? extends E> collection);

    void clear();

    boolean contains(Object obj);

    boolean containsAll(Collection<?> collection);

    boolean equals(Object obj);

    int hashCode();

    boolean isEmpty();

    @Override // java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    Iterator<E> iterator2();

    boolean remove(Object obj);

    boolean removeAll(Collection<?> collection);

    boolean retainAll(Collection<?> collection);

    int size();

    Object[] toArray();

    <T> T[] toArray(T[] tArr);

    @Override // java.util.Collection, java.lang.Iterable
    default Spliterator<E> spliterator() {
        return Spliterators.spliterator(this, 1);
    }

    static <E> Set<E> of() {
        return ImmutableCollections.EMPTY_SET;
    }

    static <E> Set<E> of(E e12) {
        return new ImmutableCollections.Set12(e12);
    }

    static <E> Set<E> of(E e12, E e2) {
        return new ImmutableCollections.Set12(e12, e2);
    }

    static <E> Set<E> of(E e12, E e2, E e32) {
        return new ImmutableCollections.SetN(e12, e2, e32);
    }

    static <E> Set<E> of(E e12, E e2, E e32, E e42) {
        return new ImmutableCollections.SetN(e12, e2, e32, e42);
    }

    static <E> Set<E> of(E e12, E e2, E e32, E e42, E e52) {
        return new ImmutableCollections.SetN(e12, e2, e32, e42, e52);
    }

    static <E> Set<E> of(E e12, E e2, E e32, E e42, E e52, E e62) {
        return new ImmutableCollections.SetN(e12, e2, e32, e42, e52, e62);
    }

    static <E> Set<E> of(E e12, E e2, E e32, E e42, E e52, E e62, E e72) {
        return new ImmutableCollections.SetN(e12, e2, e32, e42, e52, e62, e72);
    }

    static <E> Set<E> of(E e12, E e2, E e32, E e42, E e52, E e62, E e72, E e82) {
        return new ImmutableCollections.SetN(e12, e2, e32, e42, e52, e62, e72, e82);
    }

    static <E> Set<E> of(E e12, E e2, E e32, E e42, E e52, E e62, E e72, E e82, E e92) {
        return new ImmutableCollections.SetN(e12, e2, e32, e42, e52, e62, e72, e82, e92);
    }

    static <E> Set<E> of(E e12, E e2, E e32, E e42, E e52, E e62, E e72, E e82, E e92, E e10) {
        return new ImmutableCollections.SetN(e12, e2, e32, e42, e52, e62, e72, e82, e92, e10);
    }

    @SafeVarargs
    static <E> Set<E> of(E... elements) {
        switch (elements.length) {
            case 0:
                Set<E> set = ImmutableCollections.EMPTY_SET;
                return set;
            case 1:
                return new ImmutableCollections.Set12(elements[0]);
            case 2:
                return new ImmutableCollections.Set12(elements[0], elements[1]);
            default:
                return new ImmutableCollections.SetN(elements);
        }
    }

    static <E> Set<E> copyOf(Collection<? extends E> coll) {
        if (coll instanceof ImmutableCollections.AbstractImmutableSet) {
            return (Set) coll;
        }
        return of(new HashSet(coll).toArray());
    }
}
