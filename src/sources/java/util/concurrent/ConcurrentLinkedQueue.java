package java.util.concurrent;

import com.android.ims.ImsConfig;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ConcurrentLinkedQueue<E> extends AbstractQueue<E> implements Queue<E>, Serializable {
    private static final VarHandle HEAD;
    static final VarHandle ITEM;
    private static final int MAX_HOPS = 8;
    static final VarHandle NEXT;
    private static final VarHandle TAIL;
    private static final long serialVersionUID = 196745693267521676L;
    volatile transient Node<E> head;
    private volatile transient Node<E> tail;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class Node<E> {
        volatile E item;
        volatile Node<E> next;

        Node(E item) {
            (void) ConcurrentLinkedQueue.ITEM.set(this, item);
        }

        Node() {
        }

        void appendRelaxed(Node<E> next) {
            (void) ConcurrentLinkedQueue.NEXT.set(this, next);
        }

        boolean casItem(E cmp, E val) {
            return (boolean) ConcurrentLinkedQueue.ITEM.compareAndSet(this, cmp, val);
        }
    }

    public ConcurrentLinkedQueue() {
        Node<E> node = new Node<>();
        this.tail = node;
        this.head = node;
    }

    public ConcurrentLinkedQueue(Collection<? extends E> c4) {
        Node<E> h10 = null;
        Node<E> t2 = null;
        for (E e2 : c4) {
            Node<E> newNode = new Node<>(Objects.requireNonNull(e2));
            if (h10 == null) {
                t2 = newNode;
                h10 = newNode;
            } else {
                t2.appendRelaxed(newNode);
                t2 = newNode;
            }
        }
        if (h10 == null) {
            Node<E> node = new Node<>();
            t2 = node;
            h10 = node;
        }
        this.head = h10;
        this.tail = t2;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        return offer(e2);
    }

    final void updateHead(Node<E> h10, Node<E> p10) {
        if (h10 != p10 && (boolean) HEAD.compareAndSet(this, h10, p10)) {
            (void) NEXT.setRelease(h10, h10);
        }
    }

    final Node<E> succ(Node<E> p10) {
        Node<E> p11 = p10.next;
        return p10 == p11 ? this.head : p11;
    }

    private boolean tryCasSuccessor(Node<E> pred, Node<E> c4, Node<E> p10) {
        if (pred != null) {
            return (boolean) NEXT.compareAndSet(pred, c4, p10);
        }
        if ((boolean) HEAD.compareAndSet(this, c4, p10)) {
            (void) NEXT.setRelease(c4, c4);
            return true;
        }
        return false;
    }

    private Node<E> skipDeadNodes(Node<E> pred, Node<E> c4, Node<E> p10, Node<E> q10) {
        if (q10 == null) {
            if (c4 == p10) {
                return pred;
            }
            q10 = p10;
        }
        return (!tryCasSuccessor(pred, c4, q10) || (pred != null && (Object) ITEM.get(pred) == null)) ? p10 : pred;
    }

    public boolean offer(E e2) {
        Node<E> t2;
        Node<E> newNode = new Node<>(Objects.requireNonNull(e2));
        Node<E> t10 = this.tail;
        Node<E> p10 = t10;
        while (true) {
            Node<E> q10 = p10.next;
            if (q10 == null) {
                if ((boolean) NEXT.compareAndSet(p10, null, newNode)) {
                    break;
                }
            } else if (p10 == q10) {
                Node<E> t11 = this.tail;
                p10 = t10 != t11 ? t11 : this.head;
                t10 = t11;
            } else {
                if (p10 != t10) {
                    Node<E> node = this.tail;
                    t2 = node;
                    if (t10 != node) {
                        t10 = t2;
                        p10 = t2;
                    } else {
                        t10 = t2;
                    }
                }
                t2 = q10;
                p10 = t2;
            }
        }
        if (p10 != t10) {
            (boolean) TAIL.weakCompareAndSet(this, t10, newNode);
            return true;
        }
        return true;
    }

    public E poll() {
        while (true) {
            Node<E> h10 = this.head;
            Node<E> p10 = h10;
            while (true) {
                E item = p10.item;
                if (item != null && p10.casItem(item, null)) {
                    if (p10 != h10) {
                        Node<E> q10 = p10.next;
                        updateHead(h10, q10 != null ? q10 : p10);
                    }
                    return item;
                }
                Node<E> q11 = p10.next;
                if (q11 == null) {
                    updateHead(h10, p10);
                    return null;
                }
                if (p10 == q11) {
                    break;
                }
                p10 = q11;
            }
        }
    }

    @Override // java.util.Queue
    public E peek() {
        Node<E> h10;
        Node<E> p10;
        E item;
        Node<E> q10;
        loop0: while (true) {
            h10 = this.head;
            p10 = h10;
            while (true) {
                item = p10.item;
                if (item != null || (q10 = p10.next) == null) {
                    break loop0;
                }
                if (p10 == q10) {
                    break;
                }
                p10 = q10;
            }
        }
        updateHead(h10, p10);
        return item;
    }

    Node<E> first() {
        Node<E> h10;
        Node<E> p10;
        boolean hasItem;
        Node<E> q10;
        loop0: while (true) {
            h10 = this.head;
            p10 = h10;
            while (true) {
                hasItem = p10.item != null;
                if (hasItem || (q10 = p10.next) == null) {
                    break loop0;
                }
                if (p10 == q10) {
                    break;
                }
                p10 = q10;
            }
        }
        updateHead(h10, p10);
        if (hasItem) {
            return p10;
        }
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return first() == null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        int count;
        loop0: while (true) {
            count = 0;
            Node<E> p10 = first();
            while (p10 != null && (p10.item == null || (count = count + 1) != Integer.MAX_VALUE)) {
                Node<E> p11 = p10.next;
                if (p10 == p11) {
                    break;
                }
                p10 = p11;
            }
        }
        return count;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object o10) {
        if (o10 == null) {
            return false;
        }
        while (true) {
            Node<E> p10 = this.head;
            Node<E> pred = null;
            while (p10 != null) {
                Node<E> q10 = p10.next;
                E item = p10.item;
                if (item != null) {
                    if (o10.equals(item)) {
                        return true;
                    }
                    pred = p10;
                    p10 = q10;
                } else {
                    Node<E> c4 = p10;
                    while (q10 != null && q10.item == null) {
                        Node<E> p11 = q10;
                        if (p10 == q10) {
                            break;
                        }
                        q10 = p11.next;
                        p10 = p11;
                    }
                    pred = skipDeadNodes(pred, c4, p10, q10);
                    p10 = q10;
                }
            }
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object o10) {
        if (o10 == null) {
            return false;
        }
        while (true) {
            Node<E> p10 = this.head;
            Node<E> pred = null;
            while (p10 != null) {
                Node<E> q10 = p10.next;
                E item = p10.item;
                if (item != null) {
                    if (o10.equals(item) && p10.casItem(item, null)) {
                        skipDeadNodes(pred, p10, p10, q10);
                        return true;
                    }
                    pred = p10;
                    p10 = q10;
                } else {
                    Node<E> c4 = p10;
                    while (q10 != null && q10.item == null) {
                        Node<E> p11 = q10;
                        if (p10 == q10) {
                            break;
                        }
                        q10 = p11.next;
                        p10 = p11;
                    }
                    pred = skipDeadNodes(pred, c4, p10, q10);
                    p10 = q10;
                }
            }
            return false;
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> c4) {
        Node<E> t2;
        if (c4 == this) {
            throw new IllegalArgumentException();
        }
        Node<E> beginningOfTheEnd = null;
        Node<E> last = null;
        for (E e2 : c4) {
            Node<E> newNode = new Node<>(Objects.requireNonNull(e2));
            if (beginningOfTheEnd == null) {
                last = newNode;
                beginningOfTheEnd = newNode;
            } else {
                last.appendRelaxed(newNode);
                last = newNode;
            }
        }
        if (beginningOfTheEnd == null) {
            return false;
        }
        Node<E> t10 = this.tail;
        Node<E> p10 = t10;
        while (true) {
            Node<E> q10 = p10.next;
            if (q10 == null) {
                if ((boolean) NEXT.compareAndSet(p10, null, beginningOfTheEnd)) {
                    break;
                }
            } else if (p10 == q10) {
                Node<E> t11 = this.tail;
                p10 = t10 != t11 ? t11 : this.head;
                t10 = t11;
            } else {
                if (p10 != t10) {
                    Node<E> node = this.tail;
                    t2 = node;
                    if (t10 != node) {
                        t10 = t2;
                        p10 = t2;
                    } else {
                        t10 = t2;
                    }
                }
                t2 = q10;
                p10 = t2;
            }
        }
        VarHandle varHandle = TAIL;
        if (!(boolean) varHandle.weakCompareAndSet(this, t10, last)) {
            Node<E> t12 = this.tail;
            if (last.next == null) {
                (boolean) varHandle.weakCompareAndSet(this, t12, last);
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        int charLength;
        int size;
        String[] a10 = null;
        loop0: while (true) {
            charLength = 0;
            size = 0;
            Node<E> p10 = first();
            while (p10 != null) {
                E item = p10.item;
                if (item != null) {
                    if (a10 == null) {
                        a10 = new String[4];
                    } else if (size == a10.length) {
                        a10 = (String[]) Arrays.copyOf(a10, size * 2);
                    }
                    String s2 = item.toString();
                    a10[size] = s2;
                    charLength += s2.length();
                    size++;
                }
                Node<E> p11 = p10.next;
                if (p10 == p11) {
                    break;
                }
                p10 = p11;
            }
        }
        if (size == 0) {
            return "[]";
        }
        return Helpers.toString(a10, size, charLength);
    }

    private Object[] toArrayInternal(Object[] a10) {
        int size;
        Object[] x10 = a10;
        loop0: while (true) {
            size = 0;
            Node<E> p10 = first();
            while (p10 != null) {
                E item = p10.item;
                if (item != null) {
                    if (x10 == null) {
                        x10 = new Object[4];
                    } else if (size == x10.length) {
                        x10 = Arrays.copyOf(x10, (size + 4) * 2);
                    }
                    x10[size] = item;
                    size++;
                }
                Node<E> p11 = p10.next;
                if (p10 == p11) {
                    break;
                }
                p10 = p11;
            }
        }
        if (x10 == null) {
            return new Object[0];
        }
        if (a10 == null || size > a10.length) {
            return size == x10.length ? x10 : Arrays.copyOf(x10, size);
        }
        if (a10 != x10) {
            System.arraycopy(x10, 0, a10, 0, size);
        }
        if (size < a10.length) {
            a10[size] = null;
        }
        return a10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return toArrayInternal(null);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        Objects.requireNonNull(tArr);
        return (T[]) toArrayInternal(tArr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return new Itr();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class Itr implements Iterator<E> {
        private Node<E> lastRet;
        private E nextItem;
        private Node<E> nextNode;

        Itr() {
            Node<E> p10;
            loop0: while (true) {
                p10 = ConcurrentLinkedQueue.this.head;
                while (true) {
                    E item = p10.item;
                    if (item != null) {
                        this.nextNode = p10;
                        this.nextItem = item;
                        break loop0;
                    }
                    Node<E> q10 = p10.next;
                    if (q10 == null) {
                        break loop0;
                    } else if (p10 == q10) {
                        break;
                    } else {
                        p10 = q10;
                    }
                }
            }
            ConcurrentLinkedQueue.this.updateHead(p10, p10);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.nextItem != null;
        }

        @Override // java.util.Iterator
        public E next() {
            Node<E> pred = this.nextNode;
            if (pred == null) {
                throw new NoSuchElementException();
            }
            this.lastRet = pred;
            E item = null;
            Node<E> p10 = ConcurrentLinkedQueue.this.succ(pred);
            while (p10 != null) {
                E e2 = p10.item;
                item = e2;
                if (e2 != null) {
                    break;
                }
                Node<E> q10 = ConcurrentLinkedQueue.this.succ(p10);
                if (q10 != null) {
                    (boolean) ConcurrentLinkedQueue.NEXT.compareAndSet(pred, p10, q10);
                }
                p10 = q10;
            }
            this.nextNode = p10;
            E x10 = this.nextItem;
            this.nextItem = item;
            return x10;
        }

        @Override // java.util.Iterator
        public void remove() {
            Node<E> l10 = this.lastRet;
            if (l10 == null) {
                throw new IllegalStateException();
            }
            l10.item = null;
            this.lastRet = null;
        }
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        s2.defaultWriteObject();
        Node<E> p10 = first();
        while (p10 != null) {
            E item = p10.item;
            if (item != null) {
                s2.writeObject(item);
            }
            p10 = succ(p10);
        }
        s2.writeObject(null);
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        s2.defaultReadObject();
        Node<E> h10 = null;
        Node<E> t2 = null;
        while (true) {
            Object item = s2.readObject();
            if (item == null) {
                break;
            }
            Node<E> newNode = new Node<>(item);
            if (h10 == null) {
                t2 = newNode;
                h10 = newNode;
            } else {
                t2.appendRelaxed(newNode);
                t2 = newNode;
            }
        }
        if (h10 == null) {
            Node<E> node = new Node<>();
            t2 = node;
            h10 = node;
        }
        this.head = h10;
        this.tail = t2;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    final class CLQSpliterator implements Spliterator<E> {
        static final int MAX_BATCH = 33554432;
        int batch;
        Node<E> current;
        boolean exhausted;

        CLQSpliterator() {
        }

        @Override // java.util.Spliterator
        public Spliterator<E> trySplit() {
            Node<E> current = current();
            Node<E> p10 = current;
            if (current != null) {
                Node<E> node = p10.next;
                Node<E> q10 = node;
                if (node != null) {
                    int i10 = 0;
                    int n10 = Math.min(this.batch + 1, 33554432);
                    this.batch = n10;
                    Object[] a10 = null;
                    do {
                        E e2 = p10.item;
                        if (e2 != null) {
                            if (a10 == null) {
                                a10 = new Object[n10];
                            }
                            a10[i10] = e2;
                            i10++;
                        }
                        Node<E> p11 = q10;
                        if (p10 != q10) {
                            p10 = p11;
                        } else {
                            p10 = ConcurrentLinkedQueue.this.first();
                        }
                        if (p10 == null) {
                            break;
                        }
                        Node<E> node2 = p10.next;
                        q10 = node2;
                        if (node2 == null) {
                            break;
                        }
                    } while (i10 < n10);
                    setCurrent(p10);
                    if (i10 == 0) {
                        return null;
                    }
                    return Spliterators.spliterator(a10, 0, i10, 4368);
                }
            }
            return null;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super E> action) {
            Objects.requireNonNull(action);
            Node<E> p10 = current();
            if (p10 != null) {
                this.current = null;
                this.exhausted = true;
                ConcurrentLinkedQueue.this.forEachFrom(action, p10);
            }
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super E> consumer) {
            E e2;
            Objects.requireNonNull(consumer);
            Node<E> current = current();
            Node<E> node = current;
            if (current == null) {
                return false;
            }
            do {
                e2 = node.item;
                Node<E> node2 = node.next;
                if (node != node2) {
                    node = node2;
                } else {
                    node = ConcurrentLinkedQueue.this.first();
                }
                if (e2 != null) {
                    break;
                }
            } while (node != null);
            setCurrent(node);
            if (e2 != null) {
                consumer.accept(e2);
                return true;
            }
            return false;
        }

        private void setCurrent(Node<E> p10) {
            this.current = p10;
            if (p10 == null) {
                this.exhausted = true;
            }
        }

        private Node<E> current() {
            Node<E> p10 = this.current;
            if (p10 != null || this.exhausted) {
                return p10;
            }
            Node<E> p11 = ConcurrentLinkedQueue.this.first();
            setCurrent(p11);
            return p11;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return Long.MAX_VALUE;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 4368;
        }
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return new CLQSpliterator();
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super E> filter) {
        Objects.requireNonNull(filter);
        return bulkRemove(filter);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(final Collection<?> c4) {
        Objects.requireNonNull(c4);
        return bulkRemove(new Predicate() { // from class: java.util.concurrent.ConcurrentLinkedQueue$$ExternalSyntheticLambda2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean contains;
                contains = Collection.this.contains(obj);
                return contains;
            }
        });
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(final Collection<?> c4) {
        Objects.requireNonNull(c4);
        return bulkRemove(new Predicate() { // from class: java.util.concurrent.ConcurrentLinkedQueue$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ConcurrentLinkedQueue.lambda$retainAll$1(Collection.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$retainAll$1(Collection c4, Object e2) {
        return !c4.contains(e2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$clear$2(Object e2) {
        return true;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        bulkRemove(new Predicate() { // from class: java.util.concurrent.ConcurrentLinkedQueue$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ConcurrentLinkedQueue.lambda$clear$2(obj);
            }
        });
    }

    private boolean bulkRemove(Predicate<? super E> filter) {
        boolean removed = false;
        while (true) {
            int hops = 8;
            Node<E> p10 = this.head;
            Node<E> c4 = p10;
            Node<E> pred = null;
            while (p10 != null) {
                Node<E> q10 = p10.next;
                E item = p10.item;
                boolean z10 = item != null;
                boolean pAlive = z10;
                if (z10 && filter.test(item)) {
                    if (p10.casItem(item, null)) {
                        removed = true;
                    }
                    pAlive = false;
                }
                if (pAlive || q10 == null || hops - 1 == 0) {
                    if (c4 != p10) {
                        Node<E> c10 = p10;
                        if (tryCasSuccessor(pred, c4, p10)) {
                            c4 = c10;
                        }
                        hops = 8;
                        Node<E> pred2 = p10;
                        pred = pred2;
                        c4 = q10;
                    }
                    if (pAlive) {
                        hops = 8;
                        Node<E> pred22 = p10;
                        pred = pred22;
                        c4 = q10;
                    }
                } else if (p10 == q10) {
                    break;
                }
                p10 = q10;
            }
            return removed;
        }
    }

    void forEachFrom(Consumer<? super E> consumer, Node<E> node) {
        Node<E> node2 = null;
        while (node != null) {
            Node<E> node3 = node.next;
            E e2 = node.item;
            if (e2 != null) {
                consumer.accept(e2);
                node2 = node;
                node = node3;
            } else {
                Node<E> node4 = node;
                while (node3 != null && node3.item == null) {
                    Node<E> node5 = node3;
                    if (node == node3) {
                        node2 = null;
                        node = this.head;
                        break;
                    } else {
                        node3 = node5.next;
                        node = node5;
                    }
                }
                node2 = skipDeadNodes(node2, node4, node, node3);
                node = node3;
            }
        }
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        forEachFrom(action, this.head);
    }

    static {
        try {
            MethodHandles.Lookup l10 = MethodHandles.lookup();
            HEAD = l10.findVarHandle(ConcurrentLinkedQueue.class, "head", Node.class);
            TAIL = l10.findVarHandle(ConcurrentLinkedQueue.class, "tail", Node.class);
            ITEM = l10.findVarHandle(Node.class, ImsConfig.EXTRA_CHANGED_ITEM, Object.class);
            NEXT = l10.findVarHandle(Node.class, "next", Node.class);
        } catch (ReflectiveOperationException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }
}
