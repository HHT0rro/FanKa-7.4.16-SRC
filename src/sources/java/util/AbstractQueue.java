package java.util;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AbstractQueue<E> extends AbstractCollection<E> implements Queue<E> {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        if (offer(e2)) {
            return true;
        }
        throw new IllegalStateException("Queue full");
    }

    public E remove() {
        E x10 = poll();
        if (x10 != null) {
            return x10;
        }
        throw new NoSuchElementException();
    }

    public E element() {
        E x10 = peek();
        if (x10 != null) {
            return x10;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        do {
        } while (poll() != null);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> c4) {
        if (c4 == null) {
            throw new NullPointerException();
        }
        if (c4 == this) {
            throw new IllegalArgumentException();
        }
        boolean modified = false;
        for (E e2 : c4) {
            if (add(e2)) {
                modified = true;
            }
        }
        return modified;
    }
}
