package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.function.Consumer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, Serializable {
    private static final long serialVersionUID = 876323262645176354L;
    transient Node<E> first;
    transient Node<E> last;
    transient int size;

    public LinkedList() {
        this.size = 0;
    }

    public LinkedList(Collection<? extends E> c4) {
        this();
        addAll(c4);
    }

    private void linkFirst(E e2) {
        Node<E> f10 = this.first;
        Node<E> newNode = new Node<>(null, e2, f10);
        this.first = newNode;
        if (f10 == null) {
            this.last = newNode;
        } else {
            f10.prev = newNode;
        }
        this.size++;
        this.modCount++;
    }

    void linkLast(E e2) {
        Node<E> l10 = this.last;
        Node<E> newNode = new Node<>(l10, e2, null);
        this.last = newNode;
        if (l10 == null) {
            this.first = newNode;
        } else {
            l10.next = newNode;
        }
        this.size++;
        this.modCount++;
    }

    void linkBefore(E e2, Node<E> succ) {
        Node<E> pred = succ.prev;
        Node<E> newNode = new Node<>(pred, e2, succ);
        succ.prev = newNode;
        if (pred == null) {
            this.first = newNode;
        } else {
            pred.next = newNode;
        }
        this.size++;
        this.modCount++;
    }

    private E unlinkFirst(Node<E> f10) {
        E element = f10.item;
        Node<E> next = f10.next;
        f10.item = null;
        f10.next = null;
        this.first = next;
        if (next == null) {
            this.last = null;
        } else {
            next.prev = null;
        }
        this.size--;
        this.modCount++;
        return element;
    }

    private E unlinkLast(Node<E> l10) {
        E element = l10.item;
        Node<E> prev = l10.prev;
        l10.item = null;
        l10.prev = null;
        this.last = prev;
        if (prev == null) {
            this.first = null;
        } else {
            prev.next = null;
        }
        this.size--;
        this.modCount++;
        return element;
    }

    E unlink(Node<E> x10) {
        E element = x10.item;
        Node<E> next = x10.next;
        Node<E> prev = x10.prev;
        if (prev == null) {
            this.first = next;
        } else {
            prev.next = next;
            x10.prev = null;
        }
        if (next == null) {
            this.last = prev;
        } else {
            next.prev = prev;
            x10.next = null;
        }
        x10.item = null;
        this.size--;
        this.modCount++;
        return element;
    }

    @Override // java.util.Deque
    public E getFirst() {
        Node<E> f10 = this.first;
        if (f10 == null) {
            throw new NoSuchElementException();
        }
        return f10.item;
    }

    @Override // java.util.Deque
    public E getLast() {
        Node<E> l10 = this.last;
        if (l10 == null) {
            throw new NoSuchElementException();
        }
        return l10.item;
    }

    @Override // java.util.Deque
    public E removeFirst() {
        Node<E> f10 = this.first;
        if (f10 == null) {
            throw new NoSuchElementException();
        }
        return unlinkFirst(f10);
    }

    @Override // java.util.Deque
    public E removeLast() {
        Node<E> l10 = this.last;
        if (l10 == null) {
            throw new NoSuchElementException();
        }
        return unlinkLast(l10);
    }

    @Override // java.util.Deque
    public void addFirst(E e2) {
        linkFirst(e2);
    }

    @Override // java.util.Deque
    public void addLast(E e2) {
        linkLast(e2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object o10) {
        return indexOf(o10) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        linkLast(e2);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object o10) {
        if (o10 == null) {
            for (Node<E> x10 = this.first; x10 != null; x10 = x10.next) {
                if (x10.item == null) {
                    unlink(x10);
                    return true;
                }
            }
            return false;
        }
        for (Node<E> x11 = this.first; x11 != null; x11 = x11.next) {
            if (o10.equals(x11.item)) {
                unlink(x11);
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> c4) {
        return addAll(this.size, c4);
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public boolean addAll(int index, Collection<? extends E> c4) {
        Node<E> succ;
        Node<E> pred;
        checkPositionIndex(index);
        Object[] a10 = c4.toArray();
        int numNew = a10.length;
        if (numNew == 0) {
            return false;
        }
        if (index == this.size) {
            succ = null;
            pred = this.last;
        } else {
            succ = node(index);
            pred = succ.prev;
        }
        for (Object o10 : a10) {
            Node<E> newNode = new Node<>(pred, o10, null);
            if (pred == null) {
                this.first = newNode;
            } else {
                pred.next = newNode;
            }
            pred = newNode;
        }
        if (succ == null) {
            this.last = pred;
        } else {
            pred.next = succ;
            succ.prev = pred;
        }
        this.size += numNew;
        this.modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        Node<E> x10 = this.first;
        while (x10 != null) {
            Node<E> next = x10.next;
            x10.item = null;
            x10.next = null;
            x10.prev = null;
            x10 = next;
        }
        this.last = null;
        this.first = null;
        this.size = 0;
        this.modCount++;
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> x10 = node(index);
        E oldVal = x10.item;
        x10.item = element;
        return oldVal;
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public void add(int index, E element) {
        checkPositionIndex(index);
        if (index == this.size) {
            linkLast(element);
        } else {
            linkBefore(element, node(index));
        }
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public E remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < this.size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= this.size;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + this.size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    Node<E> node(int index) {
        int i10 = this.size;
        if (index < (i10 >> 1)) {
            Node<E> x10 = this.first;
            for (int i11 = 0; i11 < index; i11++) {
                x10 = x10.next;
            }
            return x10;
        }
        Node<E> x11 = this.last;
        for (int i12 = i10 - 1; i12 > index; i12--) {
            x11 = x11.prev;
        }
        return x11;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object o10) {
        int index = 0;
        if (o10 == null) {
            for (Node<E> x10 = this.first; x10 != null; x10 = x10.next) {
                if (x10.item == null) {
                    return index;
                }
                index++;
            }
            return -1;
        }
        for (Node<E> x11 = this.first; x11 != null; x11 = x11.next) {
            if (o10.equals(x11.item)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object o10) {
        int index = this.size;
        if (o10 == null) {
            for (Node<E> x10 = this.last; x10 != null; x10 = x10.prev) {
                index--;
                if (x10.item == null) {
                    return index;
                }
            }
            return -1;
        }
        for (Node<E> x11 = this.last; x11 != null; x11 = x11.prev) {
            index--;
            if (o10.equals(x11.item)) {
                return index;
            }
        }
        return -1;
    }

    @Override // java.util.Deque, java.util.Queue
    public E peek() {
        Node<E> f10 = this.first;
        if (f10 == null) {
            return null;
        }
        return f10.item;
    }

    @Override // java.util.Deque, java.util.Queue
    public E element() {
        return getFirst();
    }

    @Override // java.util.Deque, java.util.Queue
    public E poll() {
        Node<E> f10 = this.first;
        if (f10 == null) {
            return null;
        }
        return unlinkFirst(f10);
    }

    @Override // java.util.Deque, java.util.Queue
    public E remove() {
        return removeFirst();
    }

    @Override // java.util.Deque, java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e2) {
        return add(e2);
    }

    @Override // java.util.Deque
    public boolean offerFirst(E e2) {
        addFirst(e2);
        return true;
    }

    @Override // java.util.Deque
    public boolean offerLast(E e2) {
        addLast(e2);
        return true;
    }

    @Override // java.util.Deque
    public E peekFirst() {
        Node<E> f10 = this.first;
        if (f10 == null) {
            return null;
        }
        return f10.item;
    }

    @Override // java.util.Deque
    public E peekLast() {
        Node<E> l10 = this.last;
        if (l10 == null) {
            return null;
        }
        return l10.item;
    }

    @Override // java.util.Deque
    public E pollFirst() {
        Node<E> f10 = this.first;
        if (f10 == null) {
            return null;
        }
        return unlinkFirst(f10);
    }

    @Override // java.util.Deque
    public E pollLast() {
        Node<E> l10 = this.last;
        if (l10 == null) {
            return null;
        }
        return unlinkLast(l10);
    }

    @Override // java.util.Deque
    public void push(E e2) {
        addFirst(e2);
    }

    @Override // java.util.Deque
    public E pop() {
        return removeFirst();
    }

    @Override // java.util.Deque
    public boolean removeFirstOccurrence(Object o10) {
        return remove(o10);
    }

    @Override // java.util.Deque
    public boolean removeLastOccurrence(Object o10) {
        if (o10 == null) {
            for (Node<E> x10 = this.last; x10 != null; x10 = x10.prev) {
                if (x10.item == null) {
                    unlink(x10);
                    return true;
                }
            }
            return false;
        }
        for (Node<E> x11 = this.last; x11 != null; x11 = x11.prev) {
            if (o10.equals(x11.item)) {
                unlink(x11);
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int index) {
        checkPositionIndex(index);
        return new ListItr(index);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class ListItr implements ListIterator<E> {
        private int expectedModCount;
        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;

        ListItr(int index) {
            this.expectedModCount = LinkedList.this.modCount;
            this.next = index == LinkedList.this.size ? null : LinkedList.this.node(index);
            this.nextIndex = index;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.nextIndex < LinkedList.this.size;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            checkForComodification();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node<E> node = this.next;
            this.lastReturned = node;
            this.next = node.next;
            this.nextIndex++;
            return this.lastReturned.item;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.nextIndex > 0;
        }

        @Override // java.util.ListIterator
        public E previous() {
            checkForComodification();
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            Node<E> node = this.next;
            Node<E> node2 = node == null ? LinkedList.this.last : node.prev;
            this.next = node2;
            this.lastReturned = node2;
            this.nextIndex--;
            return node2.item;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.nextIndex;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.nextIndex - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            checkForComodification();
            Node<E> node = this.lastReturned;
            if (node == null) {
                throw new IllegalStateException();
            }
            Node<E> lastNext = node.next;
            LinkedList.this.unlink(this.lastReturned);
            if (this.next == this.lastReturned) {
                this.next = lastNext;
            } else {
                this.nextIndex--;
            }
            this.lastReturned = null;
            this.expectedModCount++;
        }

        @Override // java.util.ListIterator
        public void set(E e2) {
            if (this.lastReturned == null) {
                throw new IllegalStateException();
            }
            checkForComodification();
            this.lastReturned.item = e2;
        }

        @Override // java.util.ListIterator
        public void add(E e2) {
            checkForComodification();
            this.lastReturned = null;
            Node<E> node = this.next;
            if (node == null) {
                LinkedList.this.linkLast(e2);
            } else {
                LinkedList.this.linkBefore(e2, node);
            }
            this.nextIndex++;
            this.expectedModCount++;
        }

        @Override // java.util.Iterator
        public void forEachRemaining(Consumer<? super E> consumer) {
            Objects.requireNonNull(consumer);
            while (LinkedList.this.modCount == this.expectedModCount && this.nextIndex < LinkedList.this.size) {
                consumer.accept(this.next.item);
                Node<E> node = this.next;
                this.lastReturned = node;
                this.next = node.next;
                this.nextIndex++;
            }
            checkForComodification();
        }

        final void checkForComodification() {
            if (LinkedList.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override // java.util.Deque
    public Iterator<E> descendingIterator() {
        return new DescendingIterator();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class DescendingIterator implements Iterator<E> {
        private final LinkedList<E>.ListItr itr;

        private DescendingIterator() {
            this.itr = new ListItr(LinkedList.this.size());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.itr.hasPrevious();
        }

        @Override // java.util.Iterator
        public E next() {
            return this.itr.previous();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.itr.remove();
        }
    }

    private LinkedList<E> superClone() {
        try {
            return (LinkedList) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new InternalError(e2);
        }
    }

    public Object clone() {
        LinkedList<E> clone = superClone();
        clone.last = null;
        clone.first = null;
        clone.size = 0;
        clone.modCount = 0;
        for (Node<E> x10 = this.first; x10 != null; x10 = x10.next) {
            clone.add(x10.item);
        }
        return clone;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        Object[] result = new Object[this.size];
        int i10 = 0;
        Node<E> x10 = this.first;
        while (x10 != null) {
            result[i10] = x10.item;
            x10 = x10.next;
            i10++;
        }
        return result;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v7 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.size) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.size));
        }
        int i10 = 0;
        ?? r12 = tArr;
        Node<E> node = this.first;
        while (node != null) {
            r12[i10] = node.item;
            node = node.next;
            i10++;
        }
        int length = tArr.length;
        int i11 = this.size;
        if (length > i11) {
            tArr[i11] = 0;
        }
        return tArr;
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        s2.defaultWriteObject();
        s2.writeInt(this.size);
        for (Node<E> x10 = this.first; x10 != null; x10 = x10.next) {
            s2.writeObject(x10.item);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        s2.defaultReadObject();
        int size = s2.readInt();
        for (int i10 = 0; i10 < size; i10++) {
            linkLast(s2.readObject());
        }
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return new LLSpliterator(this, -1, 0);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class LLSpliterator<E> implements Spliterator<E> {
        static final int BATCH_UNIT = 1024;
        static final int MAX_BATCH = 33554432;
        int batch;
        Node<E> current;
        int est;
        int expectedModCount;
        final LinkedList<E> list;

        LLSpliterator(LinkedList<E> list, int est, int expectedModCount) {
            this.list = list;
            this.est = est;
            this.expectedModCount = expectedModCount;
        }

        final int getEst() {
            int s2 = this.est;
            if (s2 >= 0) {
                return s2;
            }
            LinkedList<E> lst = this.list;
            if (lst == null) {
                this.est = 0;
                return 0;
            }
            this.expectedModCount = lst.modCount;
            this.current = lst.first;
            int s10 = lst.size;
            this.est = s10;
            return s10;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return getEst();
        }

        @Override // java.util.Spliterator
        public Spliterator<E> trySplit() {
            int j10;
            int s2 = getEst();
            if (s2 <= 1) {
                return null;
            }
            Node<E> node = this.current;
            Node<E> p10 = node;
            if (node != null) {
                int n10 = this.batch + 1024;
                if (n10 > s2) {
                    n10 = s2;
                }
                if (n10 > 33554432) {
                    n10 = 33554432;
                }
                Object[] a10 = new Object[n10];
                int j11 = 0;
                while (true) {
                    j10 = j11 + 1;
                    a10[j11] = p10.item;
                    Node<E> node2 = p10.next;
                    p10 = node2;
                    if (node2 == null || j10 >= n10) {
                        break;
                    }
                    j11 = j10;
                }
                this.current = p10;
                this.batch = j10;
                this.est = s2 - j10;
                return Spliterators.spliterator(a10, 0, j10, 16);
            }
            return null;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super E> consumer) {
            if (consumer == null) {
                throw new NullPointerException();
            }
            int est = getEst();
            int i10 = est;
            if (est > 0) {
                Node<E> node = this.current;
                Node<E> node2 = node;
                if (node != null) {
                    this.current = null;
                    this.est = 0;
                    do {
                        E e2 = node2.item;
                        node2 = node2.next;
                        consumer.accept(e2);
                        if (node2 == null) {
                            break;
                        } else {
                            i10--;
                        }
                    } while (i10 > 0);
                }
            }
            if (this.list.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super E> consumer) {
            Node<E> node;
            if (consumer == null) {
                throw new NullPointerException();
            }
            if (getEst() > 0 && (node = this.current) != null) {
                this.est--;
                E e2 = node.item;
                this.current = node.next;
                consumer.accept(e2);
                if (this.list.modCount == this.expectedModCount) {
                    return true;
                }
                throw new ConcurrentModificationException();
            }
            return false;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 16464;
        }
    }
}
