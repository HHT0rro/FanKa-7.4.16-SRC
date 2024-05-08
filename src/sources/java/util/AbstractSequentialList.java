package java.util;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AbstractSequentialList<E> extends AbstractList<E> {
    @Override // java.util.AbstractList, java.util.List
    public abstract ListIterator<E> listIterator(int i10);

    @Override // java.util.AbstractList, java.util.List
    public E get(int index) {
        try {
            return listIterator(index).next();
        } catch (NoSuchElementException e2) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int index, E element) {
        try {
            ListIterator<E> e2 = listIterator(index);
            E oldVal = e2.next();
            e2.set(element);
            return oldVal;
        } catch (NoSuchElementException e10) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int index, E element) {
        try {
            listIterator(index).add(element);
        } catch (NoSuchElementException e2) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int index) {
        try {
            ListIterator<E> e2 = listIterator(index);
            E outCast = e2.next();
            e2.remove();
            return outCast;
        } catch (NoSuchElementException e10) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int index, Collection<? extends E> c4) {
        boolean modified = false;
        try {
            ListIterator<E> e12 = listIterator(index);
            for (E e2 : c4) {
                e12.add(e2);
                modified = true;
            }
            return modified;
        } catch (NoSuchElementException e10) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return listIterator();
    }
}
