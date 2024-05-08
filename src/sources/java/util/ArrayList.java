package java.util;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import jdk.internal.misc.SharedSecrets;
import jdk.internal.util.ArraysSupport;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable {
    private static final int DEFAULT_CAPACITY = 10;
    private static final long serialVersionUID = 8683452581122892189L;
    transient Object[] elementData;
    private int size;
    private static final Object[] EMPTY_ELEMENTDATA = new Object[0];
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = new Object[0];

    public ArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else {
            if (initialCapacity == 0) {
                this.elementData = EMPTY_ELEMENTDATA;
                return;
            }
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    public ArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public ArrayList(Collection<? extends E> c4) {
        Object[] a10 = c4.toArray();
        int length = a10.length;
        this.size = length;
        if (length != 0) {
            if (c4.getClass() == ArrayList.class) {
                this.elementData = a10;
                return;
            } else {
                this.elementData = Arrays.copyOf(a10, this.size, Object[].class);
                return;
            }
        }
        this.elementData = EMPTY_ELEMENTDATA;
    }

    public void trimToSize() {
        Object[] copyOf;
        this.modCount++;
        int i10 = this.size;
        Object[] objArr = this.elementData;
        if (i10 < objArr.length) {
            if (i10 == 0) {
                copyOf = EMPTY_ELEMENTDATA;
            } else {
                copyOf = Arrays.copyOf(objArr, i10);
            }
            this.elementData = copyOf;
        }
    }

    public void ensureCapacity(int minCapacity) {
        Object[] objArr = this.elementData;
        if (minCapacity > objArr.length) {
            if (objArr != DEFAULTCAPACITY_EMPTY_ELEMENTDATA || minCapacity > 10) {
                this.modCount++;
                grow(minCapacity);
            }
        }
    }

    private Object[] grow(int minCapacity) {
        Object[] objArr = this.elementData;
        int oldCapacity = objArr.length;
        if (oldCapacity > 0 || objArr != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            int newCapacity = ArraysSupport.newLength(oldCapacity, minCapacity - oldCapacity, oldCapacity >> 1);
            Object[] copyOf = Arrays.copyOf(this.elementData, newCapacity);
            this.elementData = copyOf;
            return copyOf;
        }
        Object[] objArr2 = new Object[Math.max(10, minCapacity)];
        this.elementData = objArr2;
        return objArr2;
    }

    private Object[] grow() {
        return grow(this.size + 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object o10) {
        return indexOf(o10) >= 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object o10) {
        return indexOfRange(o10, 0, this.size);
    }

    int indexOfRange(Object o10, int start, int end) {
        Object[] es = this.elementData;
        if (o10 == null) {
            for (int i10 = start; i10 < end; i10++) {
                if (es[i10] == null) {
                    return i10;
                }
            }
            return -1;
        }
        for (int i11 = start; i11 < end; i11++) {
            if (o10.equals(es[i11])) {
                return i11;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object o10) {
        return lastIndexOfRange(o10, 0, this.size);
    }

    int lastIndexOfRange(Object o10, int start, int end) {
        Object[] es = this.elementData;
        if (o10 == null) {
            for (int i10 = end - 1; i10 >= start; i10--) {
                if (es[i10] == null) {
                    return i10;
                }
            }
            return -1;
        }
        for (int i11 = end - 1; i11 >= start; i11--) {
            if (o10.equals(es[i11])) {
                return i11;
            }
        }
        return -1;
    }

    public Object clone() {
        try {
            ArrayList<?> v2 = (ArrayList) super.clone();
            v2.elementData = Arrays.copyOf(this.elementData, this.size);
            v2.modCount = 0;
            return v2;
        } catch (CloneNotSupportedException e2) {
            throw new InternalError(e2);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return Arrays.copyOf(this.elementData, this.size);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        int length = tArr.length;
        int i10 = this.size;
        if (length < i10) {
            return (T[]) Arrays.copyOf(this.elementData, i10, tArr.getClass());
        }
        System.arraycopy(this.elementData, 0, tArr, 0, i10);
        int length2 = tArr.length;
        int i11 = this.size;
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
    public E get(int index) {
        Objects.checkIndex(index, this.size);
        return elementData(index);
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int index, E element) {
        Objects.checkIndex(index, this.size);
        E oldValue = elementData(index);
        this.elementData[index] = element;
        return oldValue;
    }

    private void add(E e2, Object[] elementData, int s2) {
        if (s2 == elementData.length) {
            elementData = grow();
        }
        elementData[s2] = e2;
        this.size = s2 + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        this.modCount++;
        add(e2, this.elementData, this.size);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        this.modCount++;
        int s2 = this.size;
        Object[] objArr = this.elementData;
        Object[] elementData = objArr;
        if (s2 == objArr.length) {
            elementData = grow();
        }
        System.arraycopy(elementData, index, elementData, index + 1, s2 - index);
        elementData[index] = element;
        this.size = s2 + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i10) {
        Objects.checkIndex(i10, this.size);
        Object[] objArr = this.elementData;
        E e2 = (E) objArr[i10];
        fastRemove(objArr, i10);
        return e2;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.Set
    public boolean equals(Object o10) {
        boolean equal;
        if (o10 == this) {
            return true;
        }
        if (!(o10 instanceof List)) {
            return false;
        }
        int expectedModCount = this.modCount;
        if (o10.getClass() == ArrayList.class) {
            equal = equalsArrayList((ArrayList) o10);
        } else {
            equal = equalsRange((List) o10, 0, this.size);
        }
        checkForComodification(expectedModCount);
        return equal;
    }

    boolean equalsRange(List<?> other, int from, int to) {
        Object[] es = this.elementData;
        if (to > es.length) {
            throw new ConcurrentModificationException();
        }
        Iterator<?> oit = other.iterator2();
        while (from < to) {
            if (oit.hasNext() && Objects.equals(es[from], oit.next())) {
                from++;
            } else {
                return false;
            }
        }
        return !oit.hasNext();
    }

    private boolean equalsArrayList(ArrayList<?> other) {
        int otherModCount = other.modCount;
        int s2 = this.size;
        boolean z10 = s2 == other.size;
        boolean equal = z10;
        if (z10) {
            Object[] otherEs = other.elementData;
            Object[] es = this.elementData;
            if (s2 > es.length || s2 > otherEs.length) {
                throw new ConcurrentModificationException();
            }
            int i10 = 0;
            while (true) {
                if (i10 >= s2) {
                    break;
                }
                if (Objects.equals(es[i10], otherEs[i10])) {
                    i10++;
                } else {
                    equal = false;
                    break;
                }
            }
        }
        other.checkForComodification(otherModCount);
        return equal;
    }

    private void checkForComodification(int expectedModCount) {
        if (this.modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.Set
    public int hashCode() {
        int expectedModCount = this.modCount;
        int hash = hashCodeRange(0, this.size);
        checkForComodification(expectedModCount);
        return hash;
    }

    int hashCodeRange(int from, int to) {
        Object[] es = this.elementData;
        if (to > es.length) {
            throw new ConcurrentModificationException();
        }
        int hashCode = 1;
        for (int i10 = from; i10 < to; i10++) {
            Object e2 = es[i10];
            hashCode = (hashCode * 31) + (e2 == null ? 0 : e2.hashCode());
        }
        return hashCode;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object o10) {
        Object[] es = this.elementData;
        int size = this.size;
        int i10 = 0;
        if (o10 == null) {
            while (i10 < size) {
                if (es[i10] != null) {
                    i10++;
                }
            }
            return false;
        }
        while (i10 < size) {
            if (!o10.equals(es[i10])) {
                i10++;
            }
        }
        return false;
        fastRemove(es, i10);
        return true;
    }

    private void fastRemove(Object[] es, int i10) {
        this.modCount++;
        int newSize = this.size - 1;
        if (newSize > i10) {
            System.arraycopy(es, i10 + 1, es, i10, newSize - i10);
        }
        this.size = newSize;
        es[newSize] = null;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.modCount++;
        Object[] es = this.elementData;
        int to = this.size;
        this.size = 0;
        for (int i10 = 0; i10 < to; i10++) {
            es[i10] = null;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> c4) {
        Object[] a10 = c4.toArray();
        this.modCount++;
        int numNew = a10.length;
        if (numNew == 0) {
            return false;
        }
        Object[] objArr = this.elementData;
        Object[] elementData = objArr;
        int length = objArr.length;
        int s2 = this.size;
        if (numNew > length - s2) {
            elementData = grow(s2 + numNew);
        }
        System.arraycopy(a10, 0, elementData, s2, numNew);
        this.size = s2 + numNew;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int index, Collection<? extends E> c4) {
        rangeCheckForAdd(index);
        Object[] a10 = c4.toArray();
        this.modCount++;
        int numNew = a10.length;
        if (numNew == 0) {
            return false;
        }
        Object[] objArr = this.elementData;
        Object[] elementData = objArr;
        int length = objArr.length;
        int s2 = this.size;
        if (numNew > length - s2) {
            elementData = grow(s2 + numNew);
        }
        int numMoved = s2 - index;
        if (numMoved > 0) {
            System.arraycopy(elementData, index, elementData, index + numNew, numMoved);
        }
        System.arraycopy(a10, 0, elementData, index, numNew);
        this.size = s2 + numNew;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.util.AbstractList
    public void removeRange(int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(fromIndex, toIndex));
        }
        this.modCount++;
        shiftTailOverGap(this.elementData, fromIndex, toIndex);
    }

    private void shiftTailOverGap(Object[] es, int lo, int hi) {
        System.arraycopy(es, hi, es, lo, this.size - hi);
        int to = this.size;
        int i10 = this.size - (hi - lo);
        this.size = i10;
        while (i10 < to) {
            es[i10] = null;
            i10++;
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + this.size;
    }

    private static String outOfBoundsMsg(int fromIndex, int toIndex) {
        return "From Index: " + fromIndex + " > To Index: " + toIndex;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> c4) {
        return batchRemove(c4, false, 0, this.size);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> c4) {
        return batchRemove(c4, true, 0, this.size);
    }

    boolean batchRemove(Collection<?> c4, boolean complement, int from, int end) {
        int w3;
        Throwable ex;
        Objects.requireNonNull(c4);
        Object[] es = this.elementData;
        int r10 = from;
        while (r10 != end) {
            if (c4.contains(es[r10]) == complement) {
                r10++;
            } else {
                for (int r11 = r10 + 1; r11 < end; r11++) {
                    try {
                        Object e2 = es[r11];
                        if (c4.contains(e2) == complement) {
                            w3 = r10 + 1;
                            try {
                                es[r10] = e2;
                                r10 = w3;
                            } catch (Throwable th) {
                                ex = th;
                                try {
                                    System.arraycopy(es, r11, es, w3, end - r11);
                                    w3 += end - r11;
                                    throw ex;
                                } catch (Throwable ex2) {
                                    this.modCount += end - w3;
                                    shiftTailOverGap(es, w3, end);
                                    throw ex2;
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        w3 = r10;
                        ex = th2;
                    }
                }
                int w10 = this.modCount;
                this.modCount = w10 + (end - r10);
                shiftTailOverGap(es, r10, end);
                return true;
            }
        }
        return false;
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        int expectedModCount = this.modCount;
        s2.defaultWriteObject();
        s2.writeInt(this.size);
        for (int i10 = 0; i10 < this.size; i10++) {
            s2.writeObject(this.elementData[i10]);
        }
        int i11 = this.modCount;
        if (i11 != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        s2.defaultReadObject();
        s2.readInt();
        int i10 = this.size;
        if (i10 <= 0) {
            if (i10 == 0) {
                this.elementData = EMPTY_ELEMENTDATA;
                return;
            }
            throw new InvalidObjectException("Invalid size: " + this.size);
        }
        SharedSecrets.getJavaObjectInputStreamAccess().checkArray(s2, Object[].class, this.size);
        Object[] elements = new Object[this.size];
        for (int i11 = 0; i11 < this.size; i11++) {
            elements[i11] = s2.readObject();
        }
        this.elementData = elements;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int index) {
        rangeCheckForAdd(index);
        return new ListItr(index);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return new ListItr(0);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return new Itr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class Itr implements Iterator<E> {
        int cursor;
        int expectedModCount;
        int lastRet = -1;
        protected int limit;

        Itr() {
            this.limit = ArrayList.this.size;
            this.expectedModCount = ArrayList.this.modCount;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor < this.limit;
        }

        @Override // java.util.Iterator
        public E next() {
            checkForComodification();
            int i10 = this.cursor;
            if (i10 >= this.limit) {
                throw new NoSuchElementException();
            }
            Object[] objArr = ArrayList.this.elementData;
            if (i10 >= objArr.length) {
                throw new ConcurrentModificationException();
            }
            this.cursor = i10 + 1;
            this.lastRet = i10;
            return (E) objArr[i10];
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.lastRet < 0) {
                throw new IllegalStateException();
            }
            checkForComodification();
            try {
                ArrayList.this.remove(this.lastRet);
                this.cursor = this.lastRet;
                this.lastRet = -1;
                this.expectedModCount = ArrayList.this.modCount;
                this.limit--;
            } catch (IndexOutOfBoundsException e2) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public void forEachRemaining(Consumer<? super E> consumer) {
            Objects.requireNonNull(consumer);
            int i10 = ArrayList.this.size;
            int i11 = this.cursor;
            if (i11 < i10) {
                Object[] objArr = ArrayList.this.elementData;
                if (i11 >= objArr.length) {
                    throw new ConcurrentModificationException();
                }
                while (i11 < i10 && ArrayList.this.modCount == this.expectedModCount) {
                    consumer.accept((Object) ArrayList.elementAt(objArr, i11));
                    i11++;
                }
                this.cursor = i11;
                this.lastRet = i11 - 1;
                checkForComodification();
            }
        }

        final void checkForComodification() {
            if (ArrayList.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class ListItr extends ArrayList<E>.Itr implements ListIterator<E> {
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
            checkForComodification();
            int i10 = this.cursor - 1;
            if (i10 < 0) {
                throw new NoSuchElementException();
            }
            Object[] objArr = ArrayList.this.elementData;
            if (i10 >= objArr.length) {
                throw new ConcurrentModificationException();
            }
            this.cursor = i10;
            this.lastRet = i10;
            return (E) objArr[i10];
        }

        @Override // java.util.ListIterator
        public void set(E e2) {
            if (this.lastRet < 0) {
                throw new IllegalStateException();
            }
            checkForComodification();
            try {
                ArrayList.this.set(this.lastRet, e2);
            } catch (IndexOutOfBoundsException e10) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator
        public void add(E e2) {
            checkForComodification();
            try {
                int i10 = this.cursor;
                ArrayList.this.add(i10, e2);
                this.cursor = i10 + 1;
                this.lastRet = -1;
                this.expectedModCount = ArrayList.this.modCount;
                this.limit++;
            } catch (IndexOutOfBoundsException e10) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public List<E> subList(int fromIndex, int toIndex) {
        subListRangeCheck(fromIndex, toIndex, this.size);
        return new SubList(this, fromIndex, toIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class SubList<E> extends AbstractList<E> implements RandomAccess {
        private final int offset;
        private final SubList<E> parent;
        private final ArrayList<E> root;
        private int size;

        public SubList(ArrayList<E> root, int fromIndex, int toIndex) {
            this.root = root;
            this.parent = null;
            this.offset = fromIndex;
            this.size = toIndex - fromIndex;
            this.modCount = root.modCount;
        }

        private SubList(SubList<E> parent, int fromIndex, int toIndex) {
            this.root = parent.root;
            this.parent = parent;
            this.offset = parent.offset + fromIndex;
            this.size = toIndex - fromIndex;
            this.modCount = parent.modCount;
        }

        @Override // java.util.AbstractList, java.util.List
        public E set(int index, E element) {
            Objects.checkIndex(index, this.size);
            checkForComodification();
            E oldValue = this.root.elementData(this.offset + index);
            this.root.elementData[this.offset + index] = element;
            return oldValue;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int index) {
            Objects.checkIndex(index, this.size);
            checkForComodification();
            return this.root.elementData(this.offset + index);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            checkForComodification();
            return this.size;
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int index, E element) {
            rangeCheckForAdd(index);
            checkForComodification();
            this.root.add(this.offset + index, element);
            updateSizeAndModCount(1);
        }

        @Override // java.util.AbstractList, java.util.List
        public E remove(int index) {
            Objects.checkIndex(index, this.size);
            checkForComodification();
            E result = this.root.remove(this.offset + index);
            updateSizeAndModCount(-1);
            return result;
        }

        @Override // java.util.AbstractList
        protected void removeRange(int fromIndex, int toIndex) {
            checkForComodification();
            ArrayList<E> arrayList = this.root;
            int i10 = this.offset;
            arrayList.removeRange(i10 + fromIndex, i10 + toIndex);
            updateSizeAndModCount(fromIndex - toIndex);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends E> c4) {
            return addAll(this.size, c4);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int index, Collection<? extends E> c4) {
            rangeCheckForAdd(index);
            int cSize = c4.size();
            if (cSize == 0) {
                return false;
            }
            checkForComodification();
            this.root.addAll(this.offset + index, c4);
            updateSizeAndModCount(cSize);
            return true;
        }

        @Override // java.util.List
        public void replaceAll(UnaryOperator<E> operator) {
            ArrayList<E> arrayList = this.root;
            int i10 = this.offset;
            arrayList.replaceAllRange(operator, i10, this.size + i10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> c4) {
            return batchRemove(c4, false);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> c4) {
            return batchRemove(c4, true);
        }

        private boolean batchRemove(Collection<?> c4, boolean complement) {
            checkForComodification();
            int oldSize = ((ArrayList) this.root).size;
            ArrayList<E> arrayList = this.root;
            int i10 = this.offset;
            boolean modified = arrayList.batchRemove(c4, complement, i10, this.size + i10);
            if (modified) {
                updateSizeAndModCount(((ArrayList) this.root).size - oldSize);
            }
            return modified;
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super E> filter) {
            checkForComodification();
            int oldSize = ((ArrayList) this.root).size;
            ArrayList<E> arrayList = this.root;
            int i10 = this.offset;
            boolean modified = arrayList.removeIf(filter, i10, this.size + i10);
            if (modified) {
                updateSizeAndModCount(((ArrayList) this.root).size - oldSize);
            }
            return modified;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            checkForComodification();
            Object[] objArr = this.root.elementData;
            int i10 = this.offset;
            return Arrays.copyOfRange(objArr, i10, this.size + i10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            checkForComodification();
            if (tArr.length < this.size) {
                Object[] objArr = this.root.elementData;
                int i10 = this.offset;
                return (T[]) Arrays.copyOfRange(objArr, i10, this.size + i10, tArr.getClass());
            }
            System.arraycopy(this.root.elementData, this.offset, tArr, 0, this.size);
            int length = tArr.length;
            int i11 = this.size;
            if (length > i11) {
                tArr[i11] = null;
            }
            return tArr;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.Set
        public boolean equals(Object o10) {
            if (o10 == this) {
                return true;
            }
            if (!(o10 instanceof List)) {
                return false;
            }
            int i10 = this.offset;
            boolean equal = this.root.equalsRange((List) o10, i10, this.size + i10);
            checkForComodification();
            return equal;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.Set
        public int hashCode() {
            ArrayList<E> arrayList = this.root;
            int i10 = this.offset;
            int hash = arrayList.hashCodeRange(i10, this.size + i10);
            checkForComodification();
            return hash;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object o10) {
            ArrayList<E> arrayList = this.root;
            int i10 = this.offset;
            int index = arrayList.indexOfRange(o10, i10, this.size + i10);
            checkForComodification();
            if (index >= 0) {
                return index - this.offset;
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object o10) {
            ArrayList<E> arrayList = this.root;
            int i10 = this.offset;
            int index = arrayList.lastIndexOfRange(o10, i10, this.size + i10);
            checkForComodification();
            if (index >= 0) {
                return index - this.offset;
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            return indexOf(o10) >= 0;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<E> iterator2() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator(int index) {
            checkForComodification();
            rangeCheckForAdd(index);
            return new ListIterator<E>(index) { // from class: java.util.ArrayList.SubList.1
                int cursor;
                int expectedModCount;
                int lastRet = -1;
                final /* synthetic */ int val$index;

                {
                    this.val$index = index;
                    this.cursor = index;
                    this.expectedModCount = SubList.this.modCount;
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public boolean hasNext() {
                    return this.cursor != SubList.this.size;
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public E next() {
                    checkForComodification();
                    int i10 = this.cursor;
                    if (i10 >= SubList.this.size) {
                        throw new NoSuchElementException();
                    }
                    Object[] objArr = SubList.this.root.elementData;
                    if (SubList.this.offset + i10 >= objArr.length) {
                        throw new ConcurrentModificationException();
                    }
                    this.cursor = i10 + 1;
                    int i11 = SubList.this.offset;
                    this.lastRet = i10;
                    return (E) objArr[i11 + i10];
                }

                @Override // java.util.ListIterator
                public boolean hasPrevious() {
                    return this.cursor != 0;
                }

                @Override // java.util.ListIterator
                public E previous() {
                    checkForComodification();
                    int i10 = this.cursor - 1;
                    if (i10 < 0) {
                        throw new NoSuchElementException();
                    }
                    Object[] objArr = SubList.this.root.elementData;
                    if (SubList.this.offset + i10 >= objArr.length) {
                        throw new ConcurrentModificationException();
                    }
                    this.cursor = i10;
                    int i11 = SubList.this.offset;
                    this.lastRet = i10;
                    return (E) objArr[i11 + i10];
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super E> consumer) {
                    Objects.requireNonNull(consumer);
                    int i10 = SubList.this.size;
                    int i11 = this.cursor;
                    if (i11 < i10) {
                        Object[] objArr = SubList.this.root.elementData;
                        if (SubList.this.offset + i11 >= objArr.length) {
                            throw new ConcurrentModificationException();
                        }
                        while (i11 < i10 && SubList.this.root.modCount == this.expectedModCount) {
                            consumer.accept((Object) ArrayList.elementAt(objArr, SubList.this.offset + i11));
                            i11++;
                        }
                        this.cursor = i11;
                        this.lastRet = i11 - 1;
                        checkForComodification();
                    }
                }

                @Override // java.util.ListIterator
                public int nextIndex() {
                    return this.cursor;
                }

                @Override // java.util.ListIterator
                public int previousIndex() {
                    return this.cursor - 1;
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public void remove() {
                    if (this.lastRet < 0) {
                        throw new IllegalStateException();
                    }
                    checkForComodification();
                    try {
                        SubList.this.remove(this.lastRet);
                        this.cursor = this.lastRet;
                        this.lastRet = -1;
                        this.expectedModCount = SubList.this.modCount;
                    } catch (IndexOutOfBoundsException e2) {
                        throw new ConcurrentModificationException();
                    }
                }

                @Override // java.util.ListIterator
                public void set(E e2) {
                    if (this.lastRet < 0) {
                        throw new IllegalStateException();
                    }
                    checkForComodification();
                    try {
                        SubList.this.root.set(SubList.this.offset + this.lastRet, e2);
                    } catch (IndexOutOfBoundsException e10) {
                        throw new ConcurrentModificationException();
                    }
                }

                @Override // java.util.ListIterator
                public void add(E e2) {
                    checkForComodification();
                    try {
                        int i10 = this.cursor;
                        SubList.this.add(i10, e2);
                        this.cursor = i10 + 1;
                        this.lastRet = -1;
                        this.expectedModCount = SubList.this.modCount;
                    } catch (IndexOutOfBoundsException e10) {
                        throw new ConcurrentModificationException();
                    }
                }

                final void checkForComodification() {
                    if (SubList.this.root.modCount != this.expectedModCount) {
                        throw new ConcurrentModificationException();
                    }
                }
            };
        }

        @Override // java.util.AbstractList, java.util.List
        public List<E> subList(int fromIndex, int toIndex) {
            subListRangeCheck(fromIndex, toIndex, this.size);
            return new SubList(this, fromIndex, toIndex);
        }

        private void rangeCheckForAdd(int index) {
            if (index < 0 || index > this.size) {
                throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
            }
        }

        private String outOfBoundsMsg(int index) {
            return "Index: " + index + ", Size: " + this.size;
        }

        private void checkForComodification() {
            if (this.root.modCount != this.modCount) {
                throw new ConcurrentModificationException();
            }
        }

        private void updateSizeAndModCount(int sizeChange) {
            SubList<E> slist = this;
            do {
                slist.size += sizeChange;
                slist.modCount = this.root.modCount;
                slist = slist.parent;
            } while (slist != null);
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<E> spliterator() {
            checkForComodification();
            return new Spliterator<E>() { // from class: java.util.ArrayList.SubList.2
                private int expectedModCount;
                private int fence = -1;
                private int index;

                {
                    this.index = SubList.this.offset;
                }

                private int getFence() {
                    int hi = this.fence;
                    if (hi >= 0) {
                        return hi;
                    }
                    this.expectedModCount = SubList.this.modCount;
                    int hi2 = SubList.this.offset + SubList.this.size;
                    this.fence = hi2;
                    return hi2;
                }

                @Override // java.util.Spliterator
                public ArrayList<E>.ArrayListSpliterator trySplit() {
                    int hi = getFence();
                    int lo = this.index;
                    int mid = (lo + hi) >>> 1;
                    if (lo >= mid) {
                        return null;
                    }
                    ArrayList arrayList = SubList.this.root;
                    Objects.requireNonNull(arrayList);
                    this.index = mid;
                    return new ArrayListSpliterator(lo, mid, this.expectedModCount);
                }

                @Override // java.util.Spliterator
                public boolean tryAdvance(Consumer<? super E> action) {
                    Objects.requireNonNull(action);
                    int hi = getFence();
                    int i10 = this.index;
                    if (i10 < hi) {
                        this.index = i10 + 1;
                        action.accept(SubList.this.root.elementData[i10]);
                        if (SubList.this.root.modCount != this.expectedModCount) {
                            throw new ConcurrentModificationException();
                        }
                        return true;
                    }
                    return false;
                }

                @Override // java.util.Spliterator
                public void forEachRemaining(Consumer<? super E> action) {
                    int mc2;
                    Objects.requireNonNull(action);
                    ArrayList<E> lst = SubList.this.root;
                    Object[] a10 = lst.elementData;
                    if (a10 != null) {
                        int i10 = this.fence;
                        int hi = i10;
                        if (i10 < 0) {
                            mc2 = SubList.this.modCount;
                            hi = SubList.this.offset + SubList.this.size;
                        } else {
                            mc2 = this.expectedModCount;
                        }
                        int i11 = this.index;
                        if (i11 >= 0) {
                            this.index = hi;
                            if (hi <= a10.length) {
                                for (int i12 = i11; i12 < hi; i12++) {
                                    action.accept(a10[i12]);
                                }
                                if (lst.modCount == mc2) {
                                    return;
                                }
                            }
                        }
                    }
                    throw new ConcurrentModificationException();
                }

                @Override // java.util.Spliterator
                public long estimateSize() {
                    return getFence() - this.index;
                }

                @Override // java.util.Spliterator
                public int characteristics() {
                    return 16464;
                }
            };
        }
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> consumer) {
        Objects.requireNonNull(consumer);
        int i10 = this.modCount;
        Object[] objArr = this.elementData;
        int i11 = this.size;
        for (int i12 = 0; this.modCount == i10 && i12 < i11; i12++) {
            consumer.accept((Object) elementAt(objArr, i12));
        }
        if (this.modCount != i10) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return new ArrayListSpliterator(0, -1, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public final class ArrayListSpliterator implements Spliterator<E> {
        private int expectedModCount;
        private int fence;
        private int index;

        ArrayListSpliterator(int origin, int fence, int expectedModCount) {
            this.index = origin;
            this.fence = fence;
            this.expectedModCount = expectedModCount;
        }

        private int getFence() {
            int hi = this.fence;
            if (hi >= 0) {
                return hi;
            }
            this.expectedModCount = ArrayList.this.modCount;
            int hi2 = ArrayList.this.size;
            this.fence = hi2;
            return hi2;
        }

        @Override // java.util.Spliterator
        public ArrayList<E>.ArrayListSpliterator trySplit() {
            int hi = getFence();
            int lo = this.index;
            int mid = (lo + hi) >>> 1;
            if (lo >= mid) {
                return null;
            }
            ArrayList arrayList = ArrayList.this;
            this.index = mid;
            return new ArrayListSpliterator(lo, mid, this.expectedModCount);
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super E> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            int hi = getFence();
            int i10 = this.index;
            if (i10 < hi) {
                this.index = i10 + 1;
                action.accept(ArrayList.this.elementData[i10]);
                if (ArrayList.this.modCount != this.expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return true;
            }
            return false;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super E> action) {
            int mc2;
            if (action == null) {
                throw new NullPointerException();
            }
            Object[] a10 = ArrayList.this.elementData;
            if (a10 != null) {
                int i10 = this.fence;
                int hi = i10;
                if (i10 < 0) {
                    mc2 = ArrayList.this.modCount;
                    hi = ArrayList.this.size;
                } else {
                    mc2 = this.expectedModCount;
                }
                int i11 = this.index;
                if (i11 >= 0) {
                    this.index = hi;
                    if (hi <= a10.length) {
                        for (int i12 = i11; i12 < hi; i12++) {
                            action.accept(a10[i12]);
                        }
                        if (ArrayList.this.modCount == mc2) {
                            return;
                        }
                    }
                }
            }
            throw new ConcurrentModificationException();
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

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super E> filter) {
        return removeIf(filter, 0, this.size);
    }

    boolean removeIf(Predicate<? super E> predicate, int i10, int i11) {
        Objects.requireNonNull(predicate);
        int i12 = this.modCount;
        Object[] objArr = this.elementData;
        while (i10 < i11 && !predicate.test((Object) elementAt(objArr, i10))) {
            i10++;
        }
        if (i10 < i11) {
            int i13 = i10;
            long[] nBits = nBits(i11 - i13);
            nBits[0] = 1;
            for (int i14 = i13 + 1; i14 < i11; i14++) {
                if (predicate.test((Object) elementAt(objArr, i14))) {
                    setBit(nBits, i14 - i13);
                }
            }
            if (this.modCount != i12) {
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
            shiftTailOverGap(objArr, i15, i11);
            return true;
        }
        if (this.modCount == i12) {
            return false;
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator<E> operator) {
        replaceAllRange(operator, 0, this.size);
        this.modCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void replaceAllRange(UnaryOperator<E> unaryOperator, int i10, int end) {
        Objects.requireNonNull(unaryOperator);
        int expectedModCount = this.modCount;
        Object[] es = this.elementData;
        while (this.modCount == expectedModCount && i10 < end) {
            es[i10] = unaryOperator.apply(elementAt(es, i10));
            i10++;
        }
        if (this.modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.List
    public void sort(Comparator<? super E> c4) {
        int expectedModCount = this.modCount;
        Arrays.sort(this.elementData, 0, this.size, c4);
        if (this.modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
        this.modCount++;
    }

    void checkInvariants() {
    }
}
