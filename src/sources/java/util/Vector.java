package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import jdk.internal.util.ArraysSupport;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Vector<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = -2767605614048989439L;
    protected int capacityIncrement;
    protected int elementCount;
    protected Object[] elementData;

    public Vector(int initialCapacity, int capacityIncrement) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        this.elementData = new Object[initialCapacity];
        this.capacityIncrement = capacityIncrement;
    }

    public Vector(int initialCapacity) {
        this(initialCapacity, 0);
    }

    public Vector() {
        this(10);
    }

    public Vector(Collection<? extends E> c4) {
        Object[] a10 = c4.toArray();
        this.elementCount = a10.length;
        if (c4.getClass() == ArrayList.class) {
            this.elementData = a10;
        } else {
            this.elementData = Arrays.copyOf(a10, this.elementCount, Object[].class);
        }
    }

    public synchronized void copyInto(Object[] anArray) {
        System.arraycopy(this.elementData, 0, anArray, 0, this.elementCount);
    }

    public synchronized void trimToSize() {
        this.modCount++;
        Object[] objArr = this.elementData;
        int oldCapacity = objArr.length;
        int i10 = this.elementCount;
        if (i10 < oldCapacity) {
            this.elementData = Arrays.copyOf(objArr, i10);
        }
    }

    public synchronized void ensureCapacity(int minCapacity) {
        if (minCapacity > 0) {
            this.modCount++;
            if (minCapacity > this.elementData.length) {
                grow(minCapacity);
            }
        }
    }

    private Object[] grow(int minCapacity) {
        int oldCapacity = this.elementData.length;
        int i10 = minCapacity - oldCapacity;
        int i11 = this.capacityIncrement;
        if (i11 <= 0) {
            i11 = oldCapacity;
        }
        int newCapacity = ArraysSupport.newLength(oldCapacity, i10, i11);
        Object[] copyOf = Arrays.copyOf(this.elementData, newCapacity);
        this.elementData = copyOf;
        return copyOf;
    }

    private Object[] grow() {
        return grow(this.elementCount + 1);
    }

    public synchronized void setSize(int newSize) {
        this.modCount++;
        if (newSize > this.elementData.length) {
            grow(newSize);
        }
        Object[] es = this.elementData;
        int to = this.elementCount;
        for (int i10 = newSize; i10 < to; i10++) {
            es[i10] = null;
        }
        this.elementCount = newSize;
    }

    public synchronized int capacity() {
        return this.elementData.length;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public synchronized int size() {
        return this.elementCount;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public synchronized boolean isEmpty() {
        return this.elementCount == 0;
    }

    public Enumeration<E> elements() {
        return new Enumeration<E>() { // from class: java.util.Vector.1
            int count = 0;

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return this.count < Vector.this.elementCount;
            }

            @Override // java.util.Enumeration
            public E nextElement() {
                synchronized (Vector.this) {
                    if (this.count < Vector.this.elementCount) {
                        Vector vector = Vector.this;
                        int i10 = this.count;
                        this.count = i10 + 1;
                        return (E) vector.elementData(i10);
                    }
                    throw new NoSuchElementException("Vector Enumeration");
                }
            }
        };
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object o10) {
        return indexOf(o10, 0) >= 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object o10) {
        return indexOf(o10, 0);
    }

    public synchronized int indexOf(Object o10, int index) {
        if (o10 == null) {
            for (int i10 = index; i10 < this.elementCount; i10++) {
                if (this.elementData[i10] == null) {
                    return i10;
                }
            }
        } else {
            for (int i11 = index; i11 < this.elementCount; i11++) {
                if (o10.equals(this.elementData[i11])) {
                    return i11;
                }
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public synchronized int lastIndexOf(Object o10) {
        return lastIndexOf(o10, this.elementCount - 1);
    }

    public synchronized int lastIndexOf(Object o10, int index) {
        if (index >= this.elementCount) {
            throw new IndexOutOfBoundsException(index + " >= " + this.elementCount);
        }
        if (o10 == null) {
            for (int i10 = index; i10 >= 0; i10--) {
                if (this.elementData[i10] == null) {
                    return i10;
                }
            }
        } else {
            for (int i11 = index; i11 >= 0; i11--) {
                if (o10.equals(this.elementData[i11])) {
                    return i11;
                }
            }
        }
        return -1;
    }

    public synchronized E elementAt(int index) {
        if (index >= this.elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " + this.elementCount);
        }
        return elementData(index);
    }

    public synchronized E firstElement() {
        if (this.elementCount == 0) {
            throw new NoSuchElementException();
        }
        return elementData(0);
    }

    public synchronized E lastElement() {
        int i10;
        i10 = this.elementCount;
        if (i10 == 0) {
            throw new NoSuchElementException();
        }
        return elementData(i10 - 1);
    }

    public synchronized void setElementAt(E obj, int index) {
        if (index >= this.elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " + this.elementCount);
        }
        this.elementData[index] = obj;
    }

    public synchronized void removeElementAt(int index) {
        int i10 = this.elementCount;
        if (index >= i10) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " + this.elementCount);
        }
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int j10 = (i10 - index) - 1;
        if (j10 > 0) {
            Object[] objArr = this.elementData;
            System.arraycopy(objArr, index + 1, objArr, index, j10);
        }
        this.modCount++;
        int i11 = this.elementCount - 1;
        this.elementCount = i11;
        this.elementData[i11] = null;
    }

    public synchronized void insertElementAt(E obj, int index) {
        if (index > this.elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " > " + this.elementCount);
        }
        this.modCount++;
        int s2 = this.elementCount;
        Object[] elementData = this.elementData;
        if (s2 == elementData.length) {
            elementData = grow();
        }
        System.arraycopy(elementData, index, elementData, index + 1, s2 - index);
        elementData[index] = obj;
        this.elementCount = s2 + 1;
    }

    public synchronized void addElement(E obj) {
        this.modCount++;
        add(obj, this.elementData, this.elementCount);
    }

    public synchronized boolean removeElement(Object obj) {
        this.modCount++;
        int i10 = indexOf(obj);
        if (i10 < 0) {
            return false;
        }
        removeElementAt(i10);
        return true;
    }

    public synchronized void removeAllElements() {
        Object[] es = this.elementData;
        int to = this.elementCount;
        this.elementCount = 0;
        for (int i10 = 0; i10 < to; i10++) {
            es[i10] = null;
        }
        int to2 = this.modCount;
        this.modCount = to2 + 1;
    }

    public synchronized Object clone() {
        Vector<E> v2;
        try {
            v2 = (Vector) super.clone();
            v2.elementData = Arrays.copyOf(this.elementData, this.elementCount);
            v2.modCount = 0;
        } catch (CloneNotSupportedException e2) {
            throw new InternalError(e2);
        }
        return v2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public synchronized Object[] toArray() {
        return Arrays.copyOf(this.elementData, this.elementCount);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public synchronized <T> T[] toArray(T[] tArr) {
        int length = tArr.length;
        int i10 = this.elementCount;
        if (length < i10) {
            return (T[]) Arrays.copyOf(this.elementData, i10, tArr.getClass());
        }
        System.arraycopy(this.elementData, 0, tArr, 0, i10);
        int length2 = tArr.length;
        int i11 = this.elementCount;
        if (length2 > i11) {
            tArr[i11] = null;
        }
        return tArr;
    }

    E elementData(int i10) {
        return (E) this.elementData[i10];
    }

    static <E> E elementAt(Object[] objArr, int i10) {
        return (E) objArr[i10];
    }

    @Override // java.util.AbstractList, java.util.List
    public synchronized E get(int index) {
        if (index >= this.elementCount) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return elementData(index);
    }

    @Override // java.util.AbstractList, java.util.List
    public synchronized E set(int index, E element) {
        E oldValue;
        if (index >= this.elementCount) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        oldValue = elementData(index);
        this.elementData[index] = element;
        return oldValue;
    }

    private void add(E e2, Object[] elementData, int s2) {
        if (s2 == elementData.length) {
            elementData = grow();
        }
        elementData[s2] = e2;
        this.elementCount = s2 + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public synchronized boolean add(E e2) {
        this.modCount++;
        add(e2, this.elementData, this.elementCount);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object o10) {
        return removeElement(o10);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int index, E element) {
        insertElementAt(element, index);
    }

    @Override // java.util.AbstractList, java.util.List
    public synchronized E remove(int index) {
        E oldValue;
        this.modCount++;
        if (index >= this.elementCount) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        oldValue = elementData(index);
        int numMoved = (this.elementCount - index) - 1;
        if (numMoved > 0) {
            Object[] objArr = this.elementData;
            System.arraycopy(objArr, index + 1, objArr, index, numMoved);
        }
        Object[] objArr2 = this.elementData;
        int i10 = this.elementCount - 1;
        this.elementCount = i10;
        objArr2[i10] = null;
        return oldValue;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        removeAllElements();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public synchronized boolean containsAll(Collection<?> c4) {
        return super.containsAll(c4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> c4) {
        Object[] a10 = c4.toArray();
        this.modCount++;
        int numNew = a10.length;
        if (numNew == 0) {
            return false;
        }
        synchronized (this) {
            Object[] elementData = this.elementData;
            int s2 = this.elementCount;
            if (numNew > elementData.length - s2) {
                elementData = grow(s2 + numNew);
            }
            System.arraycopy(a10, 0, elementData, s2, numNew);
            this.elementCount = s2 + numNew;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(final Collection<?> c4) {
        Objects.requireNonNull(c4);
        return bulkRemove(new Predicate() { // from class: java.util.Vector$$ExternalSyntheticLambda0
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
        return bulkRemove(new Predicate() { // from class: java.util.Vector$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Vector.lambda$retainAll$1(Collection.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$retainAll$1(Collection c4, Object e2) {
        return !c4.contains(e2);
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super E> filter) {
        Objects.requireNonNull(filter);
        return bulkRemove(filter);
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

    private synchronized boolean bulkRemove(Predicate<? super E> predicate) {
        int i10 = this.modCount;
        Object[] objArr = this.elementData;
        int i11 = this.elementCount;
        int i12 = 0;
        while (i12 < i11 && !predicate.test((Object) elementAt(objArr, i12))) {
            i12++;
        }
        if (i12 < i11) {
            int i13 = i12;
            long[] nBits = nBits(i11 - i13);
            nBits[0] = 1;
            for (int i14 = i13 + 1; i14 < i11; i14++) {
                if (predicate.test((Object) elementAt(objArr, i14))) {
                    setBit(nBits, i14 - i13);
                }
            }
            if (this.modCount != i10) {
                throw new ConcurrentModificationException();
            }
            this.modCount++;
            int i15 = i13;
            for (int i16 = i13; i16 < i11; i16++) {
                if (isClear(nBits, i16 - i13)) {
                    objArr[i15] = objArr[i16];
                    i15++;
                }
            }
            this.elementCount = i15;
            for (int i17 = i15; i17 < i11; i17++) {
                objArr[i17] = null;
            }
            return true;
        }
        if (this.modCount == i10) {
            return false;
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public synchronized boolean addAll(int index, Collection<? extends E> c4) {
        if (index >= 0) {
            if (index <= this.elementCount) {
                Object[] a10 = c4.toArray();
                this.modCount++;
                int numNew = a10.length;
                if (numNew == 0) {
                    return false;
                }
                Object[] elementData = this.elementData;
                int s2 = this.elementCount;
                if (numNew > elementData.length - s2) {
                    elementData = grow(s2 + numNew);
                }
                int numMoved = s2 - index;
                if (numMoved > 0) {
                    System.arraycopy(elementData, index, elementData, index + numNew, numMoved);
                }
                System.arraycopy(a10, 0, elementData, index, numNew);
                this.elementCount = s2 + numNew;
                return true;
            }
        }
        throw new ArrayIndexOutOfBoundsException(index);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.Set
    public synchronized boolean equals(Object o10) {
        return super.equals(o10);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.Set
    public synchronized int hashCode() {
        return super.hashCode();
    }

    @Override // java.util.AbstractCollection
    public synchronized String toString() {
        return super.toString();
    }

    @Override // java.util.AbstractList, java.util.List
    public synchronized List<E> subList(int fromIndex, int toIndex) {
        return Collections.synchronizedList(super.subList(fromIndex, toIndex), this);
    }

    @Override // java.util.AbstractList
    protected synchronized void removeRange(int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("From Index: " + fromIndex + " > To Index: " + toIndex);
        }
        this.modCount++;
        shiftTailOverGap(this.elementData, fromIndex, toIndex);
    }

    private void shiftTailOverGap(Object[] es, int lo, int hi) {
        System.arraycopy(es, hi, es, lo, this.elementCount - hi);
        int to = this.elementCount;
        int i10 = this.elementCount - (hi - lo);
        this.elementCount = i10;
        while (i10 < to) {
            es[i10] = null;
            i10++;
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField gfields = in.readFields();
        int count = gfields.get("elementCount", 0);
        Object[] data = (Object[]) gfields.get("elementData", (Object) null);
        if (data == null && !gfields.defaulted("elementData") && count > 0) {
            throw new ClassNotFoundException("elementData is null");
        }
        if (count < 0 || data == null || count > data.length) {
            throw new StreamCorruptedException("Inconsistent vector internals");
        }
        this.elementCount = count;
        this.elementData = (Object[]) data.clone();
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        Object[] data;
        ObjectOutputStream.PutField fields = s2.putFields();
        synchronized (this) {
            fields.put("capacityIncrement", this.capacityIncrement);
            fields.put("elementCount", this.elementCount);
            data = (Object[]) this.elementData.clone();
        }
        fields.put("elementData", data);
        s2.writeFields();
    }

    @Override // java.util.AbstractList, java.util.List
    public synchronized ListIterator<E> listIterator(int index) {
        if (index >= 0) {
            if (index <= this.elementCount) {
            }
        }
        throw new IndexOutOfBoundsException("Index: " + index);
        return new ListItr(index);
    }

    @Override // java.util.AbstractList, java.util.List
    public synchronized ListIterator<E> listIterator() {
        return new ListItr(0);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public synchronized Iterator<E> iterator2() {
        return new Itr();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class Itr implements Iterator<E> {
        int cursor;
        int expectedModCount;
        int lastRet;
        protected int limit;

        private Itr() {
            this.limit = Vector.this.elementCount;
            this.lastRet = -1;
            this.expectedModCount = Vector.this.modCount;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor < this.limit;
        }

        @Override // java.util.Iterator
        public E next() {
            E e2;
            synchronized (Vector.this) {
                checkForComodification();
                int i10 = this.cursor;
                if (i10 >= this.limit) {
                    throw new NoSuchElementException();
                }
                this.cursor = i10 + 1;
                Vector vector = Vector.this;
                this.lastRet = i10;
                e2 = (E) vector.elementData(i10);
            }
            return e2;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.lastRet == -1) {
                throw new IllegalStateException();
            }
            synchronized (Vector.this) {
                checkForComodification();
                Vector.this.remove(this.lastRet);
                this.expectedModCount = Vector.this.modCount;
                this.limit--;
            }
            this.cursor = this.lastRet;
            this.lastRet = -1;
        }

        @Override // java.util.Iterator
        public void forEachRemaining(Consumer<? super E> consumer) {
            Objects.requireNonNull(consumer);
            synchronized (Vector.this) {
                int i10 = this.limit;
                int i11 = this.cursor;
                if (i11 >= i10) {
                    return;
                }
                Object[] objArr = Vector.this.elementData;
                if (i11 >= objArr.length) {
                    throw new ConcurrentModificationException();
                }
                while (i11 < i10 && Vector.this.modCount == this.expectedModCount) {
                    consumer.accept((Object) Vector.elementAt(objArr, i11));
                    i11++;
                }
                this.cursor = i11;
                this.lastRet = i11 - 1;
                checkForComodification();
            }
        }

        final void checkForComodification() {
            if (Vector.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    final class ListItr extends Vector<E>.Itr implements ListIterator<E> {
        ListItr(int index) {
            super();
            this.cursor = index;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.cursor != 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.cursor;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.cursor - 1;
        }

        @Override // java.util.ListIterator
        public E previous() {
            E e2;
            synchronized (Vector.this) {
                checkForComodification();
                int i10 = this.cursor - 1;
                if (i10 < 0) {
                    throw new NoSuchElementException();
                }
                this.cursor = i10;
                Vector vector = Vector.this;
                this.lastRet = i10;
                e2 = (E) vector.elementData(i10);
            }
            return e2;
        }

        @Override // java.util.ListIterator
        public void set(E e2) {
            if (this.lastRet == -1) {
                throw new IllegalStateException();
            }
            synchronized (Vector.this) {
                checkForComodification();
                Vector.this.set(this.lastRet, e2);
            }
        }

        @Override // java.util.ListIterator
        public void add(E e2) {
            int i10 = this.cursor;
            synchronized (Vector.this) {
                checkForComodification();
                Vector.this.add(i10, e2);
                this.expectedModCount = Vector.this.modCount;
                this.limit++;
            }
            this.cursor = i10 + 1;
            this.lastRet = -1;
        }
    }

    @Override // java.lang.Iterable
    public synchronized void forEach(Consumer<? super E> consumer) {
        Objects.requireNonNull(consumer);
        int i10 = this.modCount;
        Object[] objArr = this.elementData;
        int i11 = this.elementCount;
        for (int i12 = 0; this.modCount == i10 && i12 < i11; i12++) {
            consumer.accept((Object) elementAt(objArr, i12));
        }
        if (this.modCount != i10) {
            throw new ConcurrentModificationException();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.List
    public synchronized void replaceAll(UnaryOperator<E> unaryOperator) {
        Objects.requireNonNull(unaryOperator);
        int expectedModCount = this.modCount;
        Object[] es = this.elementData;
        int size = this.elementCount;
        for (int i10 = 0; this.modCount == expectedModCount && i10 < size; i10++) {
            es[i10] = unaryOperator.apply(elementAt(es, i10));
        }
        int i11 = this.modCount;
        if (i11 != expectedModCount) {
            throw new ConcurrentModificationException();
        }
        this.modCount++;
    }

    @Override // java.util.List
    public synchronized void sort(Comparator<? super E> c4) {
        int expectedModCount = this.modCount;
        Arrays.sort(this.elementData, 0, this.elementCount, c4);
        if (this.modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
        this.modCount++;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return new VectorSpliterator(null, 0, -1, 0);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    final class VectorSpliterator implements Spliterator<E> {
        private Object[] array;
        private int expectedModCount;
        private int fence;
        private int index;

        VectorSpliterator(Object[] array, int origin, int fence, int expectedModCount) {
            this.array = array;
            this.index = origin;
            this.fence = fence;
            this.expectedModCount = expectedModCount;
        }

        private int getFence() {
            int i10 = this.fence;
            int hi = i10;
            if (i10 < 0) {
                synchronized (Vector.this) {
                    this.array = Vector.this.elementData;
                    this.expectedModCount = Vector.this.modCount;
                    int i11 = Vector.this.elementCount;
                    this.fence = i11;
                    hi = i11;
                }
            }
            return hi;
        }

        @Override // java.util.Spliterator
        public Spliterator<E> trySplit() {
            int hi = getFence();
            int lo = this.index;
            int mid = (lo + hi) >>> 1;
            if (lo >= mid) {
                return null;
            }
            Vector vector = Vector.this;
            Object[] objArr = this.array;
            this.index = mid;
            return new VectorSpliterator(objArr, lo, mid, this.expectedModCount);
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super E> action) {
            Objects.requireNonNull(action);
            int fence = getFence();
            int i10 = this.index;
            if (fence > i10) {
                this.index = i10 + 1;
                action.accept(this.array[i10]);
                if (Vector.this.modCount != this.expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return true;
            }
            return false;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super E> action) {
            Objects.requireNonNull(action);
            int hi = getFence();
            Object[] a10 = this.array;
            this.index = hi;
            for (int i10 = this.index; i10 < hi; i10++) {
                action.accept(a10[i10]);
            }
            if (Vector.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return getFence() - this.index;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 16464;
        }
    }

    void checkInvariants() {
    }
}
