package java.util;

import java.util.Spliterators;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface SortedSet<E> extends Set<E> {
    Comparator<? super E> comparator();

    E first();

    SortedSet<E> headSet(E e2);

    E last();

    SortedSet<E> subSet(E e2, E e10);

    SortedSet<E> tailSet(E e2);

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    default Spliterator<E> spliterator() {
        return new Spliterators.IteratorSpliterator<E>(this, 21) { // from class: java.util.SortedSet.1
            @Override // java.util.Spliterators.IteratorSpliterator, java.util.Spliterator
            public Comparator<? super E> getComparator() {
                return SortedSet.this.comparator();
            }
        };
    }
}
