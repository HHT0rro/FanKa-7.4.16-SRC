package java.util;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface ListIterator<E> extends Iterator<E> {
    void add(E e2);

    @Override // java.util.Iterator
    boolean hasNext();

    boolean hasPrevious();

    @Override // java.util.Iterator
    E next();

    int nextIndex();

    E previous();

    int previousIndex();

    @Override // java.util.Iterator
    void remove();

    void set(E e2);
}
