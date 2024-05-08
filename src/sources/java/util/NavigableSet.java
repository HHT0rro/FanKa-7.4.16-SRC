package java.util;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface NavigableSet<E> extends SortedSet<E> {
    E ceiling(E e2);

    Iterator<E> descendingIterator();

    NavigableSet<E> descendingSet();

    E floor(E e2);

    NavigableSet<E> headSet(E e2, boolean z10);

    @Override // 
    SortedSet<E> headSet(E e2);

    E higher(E e2);

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    Iterator<E> iterator2();

    E lower(E e2);

    E pollFirst();

    E pollLast();

    NavigableSet<E> subSet(E e2, boolean z10, E e10, boolean z11);

    @Override // 
    SortedSet<E> subSet(E e2, E e10);

    NavigableSet<E> tailSet(E e2, boolean z10);

    @Override // 
    SortedSet<E> tailSet(E e2);
}
