package java.util;

import XI.CA.XI.K0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.function.Consumer;
import java.util.function.Predicate;
import jdk.internal.misc.SharedSecrets;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ArrayDeque<E> extends AbstractCollection<E> implements Deque<E>, Cloneable, Serializable {
    private static final int MAX_ARRAY_SIZE = 2147483639;
    private static final long serialVersionUID = 2340985798034038923L;
    transient Object[] elements;
    transient int head;
    transient int tail;

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0015, code lost:
    
        if ((r2 - 2147483639) > 0) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void grow(int r11) {
        /*
            r10 = this;
            java.lang.Object[] r0 = r10.elements
            int r0 = r0.length
            r1 = 64
            if (r0 >= r1) goto La
            int r1 = r0 + 2
            goto Lc
        La:
            int r1 = r0 >> 1
        Lc:
            if (r1 < r11) goto L17
            int r2 = r0 + r1
            r3 = r2
            r4 = 2147483639(0x7ffffff7, float:NaN)
            int r2 = r2 - r4
            if (r2 <= 0) goto L1b
        L17:
            int r3 = r10.newCapacity(r11, r1)
        L1b:
            java.lang.Object[] r2 = r10.elements
            java.lang.Object[] r4 = r10.elements
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r4, r3)
            r10.elements = r4
            int r5 = r10.tail
            int r6 = r10.head
            r7 = 0
            if (r5 < r6) goto L32
            if (r5 != r6) goto L49
            r5 = r4[r6]
            if (r5 == 0) goto L49
        L32:
            int r5 = r3 - r0
            int r8 = r6 + r5
            int r9 = r0 - r6
            java.lang.System.arraycopy(r4, r6, r4, r8, r9)
            int r6 = r10.head
            int r8 = r10.head
            int r8 = r8 + r5
            r10.head = r8
        L42:
            if (r6 >= r8) goto L49
            r4[r6] = r7
            int r6 = r6 + 1
            goto L42
        L49:
            java.util.Arrays.fill(r2, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.ArrayDeque.grow(int):void");
    }

    private int newCapacity(int needed, int jump) {
        int oldCapacity = this.elements.length;
        int minCapacity = oldCapacity + needed;
        if (minCapacity - 2147483639 > 0) {
            if (minCapacity < 0) {
                throw new IllegalStateException("Sorry, deque too big");
            }
            return Integer.MAX_VALUE;
        }
        if (needed > jump) {
            return minCapacity;
        }
        if ((oldCapacity + jump) - 2147483639 < 0) {
            return oldCapacity + jump;
        }
        return 2147483639;
    }

    public ArrayDeque() {
        this.elements = new Object[17];
    }

    public ArrayDeque(int numElements) {
        int i10 = 1;
        if (numElements >= 1) {
            i10 = Integer.MAX_VALUE;
            if (numElements != Integer.MAX_VALUE) {
                i10 = numElements + 1;
            }
        }
        this.elements = new Object[i10];
    }

    public ArrayDeque(Collection<? extends E> c4) {
        this(c4.size());
        copyElements(c4);
    }

    static final int inc(int i10, int modulus) {
        int i11 = i10 + 1;
        if (i11 >= modulus) {
            return 0;
        }
        return i11;
    }

    static final int dec(int i10, int modulus) {
        int i11 = i10 - 1;
        if (i11 < 0) {
            int i12 = modulus - 1;
            return i12;
        }
        return i11;
    }

    static final int inc(int i10, int distance, int modulus) {
        int i11 = i10 + distance;
        return i11 - modulus >= 0 ? i11 - modulus : i11;
    }

    static final int sub(int i10, int j10, int modulus) {
        int i11 = i10 - j10;
        return i11 < 0 ? i11 + modulus : i11;
    }

    static final <E> E elementAt(Object[] objArr, int i10) {
        return (E) objArr[i10];
    }

    static final <E> E nonNullElementAt(Object[] objArr, int i10) {
        E e2 = (E) objArr[i10];
        if (e2 == null) {
            throw new ConcurrentModificationException();
        }
        return e2;
    }

    @Override // java.util.Deque
    public void addFirst(E e2) {
        if (e2 == null) {
            throw new NullPointerException();
        }
        Object[] es = this.elements;
        int dec = dec(this.head, es.length);
        this.head = dec;
        es[dec] = e2;
        if (dec == this.tail) {
            grow(1);
        }
    }

    @Override // java.util.Deque
    public void addLast(E e2) {
        if (e2 == null) {
            throw new NullPointerException();
        }
        Object[] es = this.elements;
        int i10 = this.tail;
        es[i10] = e2;
        int i11 = this.head;
        int inc = inc(i10, es.length);
        this.tail = inc;
        if (i11 == inc) {
            grow(1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> c4) {
        int s2 = size();
        int needed = ((s2 + c4.size()) + 1) - this.elements.length;
        if (needed > 0) {
            grow(needed);
        }
        copyElements(c4);
        return size() > s2;
    }

    private void copyElements(Collection<? extends E> c4) {
        c4.forEach(new Consumer() { // from class: java.util.ArrayDeque$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ArrayDeque.this.addLast(obj);
            }
        });
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
    public E removeFirst() {
        E e2 = pollFirst();
        if (e2 == null) {
            throw new NoSuchElementException();
        }
        return e2;
    }

    @Override // java.util.Deque
    public E removeLast() {
        E e2 = pollLast();
        if (e2 == null) {
            throw new NoSuchElementException();
        }
        return e2;
    }

    @Override // java.util.Deque
    public E pollFirst() {
        Object[] objArr = this.elements;
        int i10 = this.head;
        E e2 = (E) elementAt(objArr, i10);
        if (e2 != null) {
            objArr[i10] = null;
            this.head = inc(i10, objArr.length);
        }
        return e2;
    }

    @Override // java.util.Deque
    public E pollLast() {
        Object[] objArr = this.elements;
        int dec = dec(this.tail, objArr.length);
        E e2 = (E) elementAt(objArr, dec);
        if (e2 != null) {
            this.tail = dec;
            objArr[dec] = null;
        }
        return e2;
    }

    @Override // java.util.Deque
    public E getFirst() {
        E e2 = (E) elementAt(this.elements, this.head);
        if (e2 == null) {
            throw new NoSuchElementException();
        }
        return e2;
    }

    @Override // java.util.Deque
    public E getLast() {
        Object[] objArr = this.elements;
        E e2 = (E) elementAt(objArr, dec(this.tail, objArr.length));
        if (e2 == null) {
            throw new NoSuchElementException();
        }
        return e2;
    }

    @Override // java.util.Deque
    public E peekFirst() {
        return (E) elementAt(this.elements, this.head);
    }

    @Override // java.util.Deque
    public E peekLast() {
        Object[] objArr = this.elements;
        return (E) elementAt(objArr, dec(this.tail, objArr.length));
    }

    @Override // java.util.Deque
    public boolean removeFirstOccurrence(Object o10) {
        if (o10 != null) {
            Object[] es = this.elements;
            int i10 = this.head;
            int end = this.tail;
            int to = i10 <= end ? end : es.length;
            while (true) {
                if (i10 < to) {
                    if (!o10.equals(es[i10])) {
                        i10++;
                    } else {
                        delete(i10);
                        return true;
                    }
                } else if (to != end) {
                    i10 = 0;
                    to = end;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    @Override // java.util.Deque
    public boolean removeLastOccurrence(Object o10) {
        if (o10 != null) {
            Object[] es = this.elements;
            int i10 = this.tail;
            int end = this.head;
            int to = i10 >= end ? end : 0;
            while (true) {
                i10--;
                if (i10 > to - 1) {
                    if (o10.equals(es[i10])) {
                        delete(i10);
                        return true;
                    }
                } else {
                    if (to == end) {
                        break;
                    }
                    i10 = es.length;
                    to = end;
                }
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        addLast(e2);
        return true;
    }

    @Override // java.util.Deque, java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e2) {
        return offerLast(e2);
    }

    @Override // java.util.Deque, java.util.Queue
    public E remove() {
        return removeFirst();
    }

    @Override // java.util.Deque, java.util.Queue
    public E poll() {
        return pollFirst();
    }

    @Override // java.util.Deque, java.util.Queue
    public E element() {
        return getFirst();
    }

    @Override // java.util.Deque, java.util.Queue
    public E peek() {
        return peekFirst();
    }

    @Override // java.util.Deque
    public void push(E e2) {
        addFirst(e2);
    }

    @Override // java.util.Deque
    public E pop() {
        return removeFirst();
    }

    boolean delete(int i10) {
        Object[] es = this.elements;
        int capacity = es.length;
        int h10 = this.head;
        int front = sub(i10, h10, capacity);
        int t2 = this.tail;
        int back = sub(t2, i10, capacity) - 1;
        if (front < back) {
            if (h10 <= i10) {
                System.arraycopy(es, h10, es, h10 + 1, front);
            } else {
                System.arraycopy(es, 0, es, 1, i10);
                es[0] = es[capacity - 1];
                System.arraycopy(es, h10, es, h10 + 1, front - (i10 + 1));
            }
            es[h10] = null;
            this.head = inc(h10, capacity);
            return false;
        }
        int dec = dec(t2, capacity);
        this.tail = dec;
        if (i10 <= dec) {
            System.arraycopy(es, i10 + 1, es, i10, back);
        } else {
            System.arraycopy(es, i10 + 1, es, i10, capacity - (i10 + 1));
            es[capacity - 1] = es[0];
            System.arraycopy(es, 1, es, 0, t2 - 1);
        }
        es[this.tail] = null;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return sub(this.tail, this.head, this.elements.length);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.head == this.tail;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return new DeqIterator();
    }

    @Override // java.util.Deque
    public Iterator<E> descendingIterator() {
        return new DescendingIterator();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class DeqIterator implements Iterator<E> {
        int cursor;
        int lastRet = -1;
        int remaining;

        DeqIterator() {
            this.remaining = ArrayDeque.this.size();
            this.cursor = ArrayDeque.this.head;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.remaining > 0;
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.remaining <= 0) {
                throw new NoSuchElementException();
            }
            Object[] objArr = ArrayDeque.this.elements;
            E e2 = (E) ArrayDeque.nonNullElementAt(objArr, this.cursor);
            int i10 = this.cursor;
            this.lastRet = i10;
            this.cursor = ArrayDeque.inc(i10, objArr.length);
            this.remaining--;
            return e2;
        }

        void postDelete(boolean leftShifted) {
            if (leftShifted) {
                this.cursor = ArrayDeque.dec(this.cursor, ArrayDeque.this.elements.length);
            }
        }

        @Override // java.util.Iterator
        public final void remove() {
            int i10 = this.lastRet;
            if (i10 < 0) {
                throw new IllegalStateException();
            }
            postDelete(ArrayDeque.this.delete(i10));
            this.lastRet = -1;
        }

        @Override // java.util.Iterator
        public void forEachRemaining(Consumer<? super E> consumer) {
            Objects.requireNonNull(consumer);
            int i10 = this.remaining;
            if (i10 <= 0) {
                return;
            }
            this.remaining = 0;
            Object[] objArr = ArrayDeque.this.elements;
            if (objArr[this.cursor] == null || ArrayDeque.sub(ArrayDeque.this.tail, this.cursor, objArr.length) != i10) {
                throw new ConcurrentModificationException();
            }
            int i11 = this.cursor;
            int i12 = ArrayDeque.this.tail;
            int length = i11 <= i12 ? i12 : objArr.length;
            while (true) {
                if (i11 < length) {
                    consumer.accept((Object) ArrayDeque.elementAt(objArr, i11));
                    i11++;
                } else {
                    if (length == i12) {
                        break;
                    }
                    i11 = 0;
                    length = i12;
                }
            }
            if (i12 != ArrayDeque.this.tail) {
                throw new ConcurrentModificationException();
            }
            this.lastRet = ArrayDeque.dec(i12, objArr.length);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class DescendingIterator extends ArrayDeque<E>.DeqIterator {
        DescendingIterator() {
            super();
            this.cursor = ArrayDeque.dec(ArrayDeque.this.tail, ArrayDeque.this.elements.length);
        }

        @Override // java.util.ArrayDeque.DeqIterator, java.util.Iterator
        public final E next() {
            if (this.remaining <= 0) {
                throw new NoSuchElementException();
            }
            Object[] objArr = ArrayDeque.this.elements;
            E e2 = (E) ArrayDeque.nonNullElementAt(objArr, this.cursor);
            int i10 = this.cursor;
            this.lastRet = i10;
            this.cursor = ArrayDeque.dec(i10, objArr.length);
            this.remaining--;
            return e2;
        }

        @Override // java.util.ArrayDeque.DeqIterator
        void postDelete(boolean leftShifted) {
            if (!leftShifted) {
                this.cursor = ArrayDeque.inc(this.cursor, ArrayDeque.this.elements.length);
            }
        }

        @Override // java.util.ArrayDeque.DeqIterator, java.util.Iterator
        public final void forEachRemaining(Consumer<? super E> consumer) {
            Objects.requireNonNull(consumer);
            int i10 = this.remaining;
            if (i10 <= 0) {
                return;
            }
            this.remaining = 0;
            Object[] objArr = ArrayDeque.this.elements;
            if (objArr[this.cursor] == null || ArrayDeque.sub(this.cursor, ArrayDeque.this.head, objArr.length) + 1 != i10) {
                throw new ConcurrentModificationException();
            }
            int i11 = this.cursor;
            int i12 = ArrayDeque.this.head;
            int i13 = i11 >= i12 ? i12 : 0;
            while (true) {
                if (i11 > i13 - 1) {
                    consumer.accept((Object) ArrayDeque.elementAt(objArr, i11));
                    i11--;
                } else {
                    if (i13 == i12) {
                        break;
                    }
                    i11 = objArr.length - 1;
                    i13 = i12;
                }
            }
            if (i12 != ArrayDeque.this.head) {
                throw new ConcurrentModificationException();
            }
            this.lastRet = i12;
        }
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return new DeqSpliterator();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    final class DeqSpliterator implements Spliterator<E> {
        private int cursor;
        private int fence;

        DeqSpliterator() {
            this.fence = -1;
        }

        DeqSpliterator(int origin, int fence) {
            this.cursor = origin;
            this.fence = fence;
        }

        private int getFence() {
            int t2 = this.fence;
            if (t2 >= 0) {
                return t2;
            }
            int t10 = ArrayDeque.this.tail;
            this.fence = t10;
            this.cursor = ArrayDeque.this.head;
            return t10;
        }

        @Override // java.util.Spliterator
        public ArrayDeque<E>.DeqSpliterator trySplit() {
            Object[] es = ArrayDeque.this.elements;
            int fence = getFence();
            int i10 = this.cursor;
            int n10 = ArrayDeque.sub(fence, i10, es.length) >> 1;
            if (n10 <= 0) {
                return null;
            }
            ArrayDeque arrayDeque = ArrayDeque.this;
            int inc = ArrayDeque.inc(i10, n10, es.length);
            this.cursor = inc;
            return new DeqSpliterator(i10, inc);
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super E> consumer) {
            if (consumer == null) {
                throw new NullPointerException();
            }
            int fence = getFence();
            int i10 = this.cursor;
            Object[] objArr = ArrayDeque.this.elements;
            if (i10 != fence) {
                this.cursor = fence;
                if (objArr[i10] == null || objArr[ArrayDeque.dec(fence, objArr.length)] == null) {
                    throw new ConcurrentModificationException();
                }
                int i11 = i10;
                int length = i11 <= fence ? fence : objArr.length;
                while (true) {
                    if (i11 < length) {
                        consumer.accept((Object) ArrayDeque.elementAt(objArr, i11));
                        i11++;
                    } else if (length != fence) {
                        i11 = 0;
                        length = fence;
                    } else {
                        return;
                    }
                }
            }
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super E> consumer) {
            Objects.requireNonNull(consumer);
            Object[] objArr = ArrayDeque.this.elements;
            if (this.fence < 0) {
                this.fence = ArrayDeque.this.tail;
                this.cursor = ArrayDeque.this.head;
            }
            int i10 = this.cursor;
            if (i10 == this.fence) {
                return false;
            }
            K0 k02 = (Object) ArrayDeque.nonNullElementAt(objArr, i10);
            this.cursor = ArrayDeque.inc(i10, objArr.length);
            consumer.accept(k02);
            return true;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return ArrayDeque.sub(getFence(), this.cursor, ArrayDeque.this.elements.length);
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 16720;
        }
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> consumer) {
        Objects.requireNonNull(consumer);
        Object[] objArr = this.elements;
        int i10 = this.head;
        int i11 = this.tail;
        int length = i10 <= i11 ? i11 : objArr.length;
        while (true) {
            if (i10 < length) {
                consumer.accept((Object) elementAt(objArr, i10));
                i10++;
            } else {
                if (length == i11) {
                    break;
                }
                i10 = 0;
                length = i11;
            }
        }
        if (i11 != this.tail) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super E> filter) {
        Objects.requireNonNull(filter);
        return bulkRemove(filter);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(final Collection<?> c4) {
        Objects.requireNonNull(c4);
        return bulkRemove(new Predicate() { // from class: java.util.ArrayDeque$$ExternalSyntheticLambda2
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
        return bulkRemove(new Predicate() { // from class: java.util.ArrayDeque$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ArrayDeque.lambda$retainAll$1(Collection.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$retainAll$1(Collection c4, Object e2) {
        return !c4.contains(e2);
    }

    private boolean bulkRemove(Predicate<? super E> predicate) {
        Object[] objArr = this.elements;
        int i10 = this.head;
        int i11 = this.tail;
        int length = i10 <= i11 ? i11 : objArr.length;
        while (true) {
            if (i10 < length) {
                if (!predicate.test((Object) elementAt(objArr, i10))) {
                    i10++;
                } else {
                    return bulkRemoveModified(predicate, i10);
                }
            } else if (length != i11) {
                i10 = 0;
                length = i11;
            } else {
                if (i11 != this.tail) {
                    throw new ConcurrentModificationException();
                }
                return false;
            }
        }
    }

    private static long[] nBits(int n10) {
        return new long[((n10 - 1) >> 6) + 1];
    }

    private static void setBit(long[] bits, int i10) {
        int i11 = i10 >> 6;
        bits[i11] = bits[i11] | (1 << i10);
    }

    private static boolean isClear(long[] bits, int i10) {
        return (bits[i10 >> 6] & (1 << i10)) == 0;
    }

    private boolean bulkRemoveModified(Predicate<? super E> predicate, int i10) {
        Object[] objArr = this.elements;
        int length = objArr.length;
        int i11 = this.tail;
        long[] nBits = nBits(sub(i11, i10, length));
        nBits[0] = 1;
        int i12 = i10 + 1;
        int length2 = i12 <= i11 ? i11 : objArr.length;
        int i13 = i10;
        while (true) {
            if (i12 < length2) {
                if (predicate.test((Object) elementAt(objArr, i12))) {
                    setBit(nBits, i12 - i13);
                }
                i12++;
            } else {
                if (length2 == i11) {
                    break;
                }
                i12 = 0;
                length2 = i11;
                i13 -= length;
            }
        }
        int i14 = i10;
        int i15 = i10 + 1;
        int length3 = i15 <= i11 ? i11 : objArr.length;
        int i16 = i10;
        while (true) {
            if (i15 < length3) {
                if (isClear(nBits, i15 - i16)) {
                    objArr[i14] = objArr[i15];
                    i14++;
                }
                i15++;
            } else {
                if (length3 == i11) {
                    break;
                }
                i15 = 0;
                length3 = i11;
                i16 -= length;
                while (i15 < length3 && i14 < length) {
                    if (isClear(nBits, i15 - i16)) {
                        objArr[i14] = objArr[i15];
                        i14++;
                    }
                    i15++;
                }
                if (i15 < length3) {
                    i14 = 0;
                } else if (i14 == length) {
                    i14 = 0;
                }
            }
        }
        if (i11 != this.tail) {
            throw new ConcurrentModificationException();
        }
        this.tail = i14;
        circularClear(objArr, i14, i11);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object o10) {
        if (o10 != null) {
            Object[] es = this.elements;
            int i10 = this.head;
            int end = this.tail;
            int to = i10 <= end ? end : es.length;
            while (true) {
                if (i10 < to) {
                    if (!o10.equals(es[i10])) {
                        i10++;
                    } else {
                        return true;
                    }
                } else if (to != end) {
                    i10 = 0;
                    to = end;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object o10) {
        return removeFirstOccurrence(o10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        circularClear(this.elements, this.head, this.tail);
        this.tail = 0;
        this.head = 0;
    }

    private static void circularClear(Object[] es, int i10, int end) {
        int to = i10 <= end ? end : es.length;
        while (true) {
            if (i10 < to) {
                es[i10] = null;
                i10++;
            } else if (to != end) {
                i10 = 0;
                to = end;
            } else {
                return;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return toArray(Object[].class);
    }

    private <T> T[] toArray(Class<T[]> cls) {
        T[] tArr;
        Object[] objArr = this.elements;
        int i10 = this.head;
        int i11 = this.tail;
        int length = (i10 <= i11 ? 0 : objArr.length) + i11;
        if (length < 0) {
            tArr = (T[]) Arrays.copyOfRange(objArr, 0, length - i10, cls);
            System.arraycopy(objArr, i10, tArr, 0, objArr.length - i10);
        } else {
            tArr = (T[]) Arrays.copyOfRange(objArr, i10, length, cls);
        }
        if (length != i11) {
            System.arraycopy(objArr, 0, tArr, objArr.length - i10, i11);
        }
        return tArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        int size = size();
        if (size > tArr.length) {
            return (T[]) toArray(tArr.getClass());
        }
        Object[] objArr = this.elements;
        int i10 = this.head;
        int i11 = 0;
        int min = Math.min(size, objArr.length - i10);
        while (true) {
            System.arraycopy(objArr, i10, tArr, i11, min);
            int i12 = i11 + min;
            i11 = i12;
            if (i12 == size) {
                break;
            }
            i10 = 0;
            min = this.tail;
        }
        if (size < tArr.length) {
            tArr[size] = null;
        }
        return tArr;
    }

    public ArrayDeque<E> clone() {
        try {
            ArrayDeque<E> result = (ArrayDeque) super.clone();
            Object[] objArr = this.elements;
            result.elements = Arrays.copyOf(objArr, objArr.length);
            return result;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        s2.defaultWriteObject();
        s2.writeInt(size());
        Object[] es = this.elements;
        int i10 = this.head;
        int end = this.tail;
        int to = i10 <= end ? end : es.length;
        while (true) {
            if (i10 < to) {
                s2.writeObject(es[i10]);
                i10++;
            } else if (to != end) {
                i10 = 0;
                to = end;
            } else {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        s2.defaultReadObject();
        int size = s2.readInt();
        SharedSecrets.getJavaObjectInputStreamAccess().checkArray(s2, Object[].class, size + 1);
        this.elements = new Object[size + 1];
        this.tail = size;
        for (int i10 = 0; i10 < size; i10++) {
            this.elements[i10] = s2.readObject();
        }
    }

    void checkInvariants() {
        try {
            int length = this.elements.length;
        } catch (Throwable t2) {
            System.err.printf("head=%d tail=%d capacity=%d%n", Integer.valueOf(this.head), Integer.valueOf(this.tail), Integer.valueOf(this.elements.length));
            System.err.printf("elements=%s%n", Arrays.toString(this.elements));
            throw t2;
        }
    }
}
