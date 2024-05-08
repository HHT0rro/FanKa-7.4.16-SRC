package java.util.concurrent;

import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import jdk.internal.misc.SharedSecrets;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CopyOnWriteArrayList<E> implements List<E>, RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = 8673264195747942595L;
    private volatile transient Object[] array;
    final transient Object lock = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object[] getArray() {
        return this.array;
    }

    final void setArray(Object[] a10) {
        this.array = a10;
    }

    public CopyOnWriteArrayList() {
        setArray(new Object[0]);
    }

    public CopyOnWriteArrayList(Collection<? extends E> c4) {
        Object[] es;
        if (c4.getClass() == CopyOnWriteArrayList.class) {
            es = ((CopyOnWriteArrayList) c4).getArray();
        } else {
            es = c4.toArray();
            if (es.getClass() != Object[].class) {
                es = Arrays.copyOf(es, es.length, Object[].class);
            }
        }
        setArray(es);
    }

    public CopyOnWriteArrayList(E[] toCopyIn) {
        setArray(Arrays.copyOf(toCopyIn, toCopyIn.length, Object[].class));
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public int size() {
        return getArray().length;
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return size() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int indexOfRange(Object o10, Object[] es, int from, int to) {
        if (o10 == null) {
            for (int i10 = from; i10 < to; i10++) {
                if (es[i10] == null) {
                    return i10;
                }
            }
            return -1;
        }
        for (int i11 = from; i11 < to; i11++) {
            if (o10.equals(es[i11])) {
                return i11;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int lastIndexOfRange(Object o10, Object[] es, int from, int to) {
        if (o10 == null) {
            for (int i10 = to - 1; i10 >= from; i10--) {
                if (es[i10] == null) {
                    return i10;
                }
            }
            return -1;
        }
        for (int i11 = to - 1; i11 >= from; i11--) {
            if (o10.equals(es[i11])) {
                return i11;
            }
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean contains(Object o10) {
        return indexOf(o10) >= 0;
    }

    @Override // java.util.List
    public int indexOf(Object o10) {
        Object[] es = getArray();
        return indexOfRange(o10, es, 0, es.length);
    }

    public int indexOf(E e2, int index) {
        Object[] es = getArray();
        return indexOfRange(e2, es, index, es.length);
    }

    @Override // java.util.List
    public int lastIndexOf(Object o10) {
        Object[] es = getArray();
        return lastIndexOfRange(o10, es, 0, es.length);
    }

    public int lastIndexOf(E e2, int index) {
        Object[] es = getArray();
        return lastIndexOfRange(e2, es, 0, index + 1);
    }

    public Object clone() {
        try {
            CopyOnWriteArrayList<E> clone = (CopyOnWriteArrayList) super.clone();
            clone.resetLock();
            VarHandle.releaseFence();
            return clone;
        } catch (CloneNotSupportedException e2) {
            throw new InternalError();
        }
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return (Object[]) getArray().clone();
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        Object[] array = getArray();
        int length = array.length;
        if (tArr.length < length) {
            return (T[]) Arrays.copyOf(array, length, tArr.getClass());
        }
        System.arraycopy(array, 0, tArr, 0, length);
        if (tArr.length > length) {
            tArr[length] = null;
        }
        return tArr;
    }

    static <E> E elementAt(Object[] objArr, int i10) {
        return (E) objArr[i10];
    }

    static String outOfBounds(int index, int size) {
        return "Index: " + index + ", Size: " + size;
    }

    @Override // java.util.List
    public E get(int i10) {
        return (E) elementAt(getArray(), i10);
    }

    @Override // java.util.List
    public E set(int i10, E e2) {
        E e10;
        synchronized (this.lock) {
            Object[] array = getArray();
            e10 = (E) elementAt(array, i10);
            if (e10 != e2) {
                array = (Object[]) array.clone();
                array[i10] = e2;
            }
            setArray(array);
        }
        return e10;
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        synchronized (this.lock) {
            Object[] es = getArray();
            int len = es.length;
            Object[] es2 = Arrays.copyOf(es, len + 1);
            es2[len] = e2;
            setArray(es2);
        }
        return true;
    }

    @Override // java.util.List
    public void add(int index, E element) {
        Object[] newElements;
        synchronized (this.lock) {
            Object[] es = getArray();
            int len = es.length;
            if (index > len || index < 0) {
                throw new IndexOutOfBoundsException(outOfBounds(index, len));
            }
            int numMoved = len - index;
            if (numMoved == 0) {
                newElements = Arrays.copyOf(es, len + 1);
            } else {
                newElements = new Object[len + 1];
                System.arraycopy(es, 0, newElements, 0, index);
                System.arraycopy(es, index, newElements, index + 1, numMoved);
            }
            newElements[index] = element;
            setArray(newElements);
        }
    }

    @Override // java.util.List
    public E remove(int i10) {
        E e2;
        Object[] objArr;
        synchronized (this.lock) {
            Object[] array = getArray();
            int length = array.length;
            e2 = (E) elementAt(array, i10);
            int i11 = (length - i10) - 1;
            if (i11 == 0) {
                objArr = Arrays.copyOf(array, length - 1);
            } else {
                objArr = new Object[length - 1];
                System.arraycopy(array, 0, objArr, 0, i10);
                System.arraycopy(array, i10 + 1, objArr, i10, i11);
            }
            setArray(objArr);
        }
        return e2;
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean remove(Object o10) {
        Object[] snapshot = getArray();
        int index = indexOfRange(o10, snapshot, 0, snapshot.length);
        return index >= 0 && remove(o10, snapshot, index);
    }

    private boolean remove(Object o10, Object[] snapshot, int index) {
        synchronized (this.lock) {
            Object[] current = getArray();
            int len = current.length;
            if (snapshot != current) {
                int prefix = Math.min(index, len);
                int i10 = 0;
                while (true) {
                    if (i10 < prefix) {
                        if (current[i10] == snapshot[i10] || !Objects.equals(o10, current[i10])) {
                            i10++;
                        } else {
                            index = i10;
                            break;
                        }
                    } else {
                        if (index >= len) {
                            return false;
                        }
                        if (current[index] != o10 && (index = indexOfRange(o10, current, index, len)) < 0) {
                            return false;
                        }
                    }
                }
            }
            int prefix2 = len - 1;
            Object[] newElements = new Object[prefix2];
            System.arraycopy(current, 0, newElements, 0, index);
            System.arraycopy(current, index + 1, newElements, index, (len - index) - 1);
            setArray(newElements);
            return true;
        }
    }

    void removeRange(int fromIndex, int toIndex) {
        synchronized (this.lock) {
            Object[] es = getArray();
            int len = es.length;
            if (fromIndex < 0 || toIndex > len || toIndex < fromIndex) {
                throw new IndexOutOfBoundsException();
            }
            int newlen = len - (toIndex - fromIndex);
            int numMoved = len - toIndex;
            if (numMoved == 0) {
                setArray(Arrays.copyOf(es, newlen));
            } else {
                Object[] newElements = new Object[newlen];
                System.arraycopy(es, 0, newElements, 0, fromIndex);
                System.arraycopy(es, toIndex, newElements, fromIndex, numMoved);
                setArray(newElements);
            }
        }
    }

    public boolean addIfAbsent(E e2) {
        Object[] snapshot = getArray();
        return indexOfRange(e2, snapshot, 0, snapshot.length) < 0 && addIfAbsent(e2, snapshot);
    }

    private boolean addIfAbsent(E e2, Object[] snapshot) {
        synchronized (this.lock) {
            Object[] current = getArray();
            int len = current.length;
            if (snapshot != current) {
                int common = Math.min(snapshot.length, len);
                for (int i10 = 0; i10 < common; i10++) {
                    if (current[i10] != snapshot[i10] && Objects.equals(e2, current[i10])) {
                        return false;
                    }
                }
                int i11 = indexOfRange(e2, current, common, len);
                if (i11 >= 0) {
                    return false;
                }
            }
            Object[] newElements = Arrays.copyOf(current, len + 1);
            newElements[len] = e2;
            setArray(newElements);
            return true;
        }
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> c4) {
        Object[] es = getArray();
        int len = es.length;
        for (Object e2 : c4) {
            if (indexOfRange(e2, es, 0, len) < 0) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean removeAll(final Collection<?> c4) {
        Objects.requireNonNull(c4);
        return bulkRemove(new Predicate() { // from class: java.util.concurrent.CopyOnWriteArrayList$$ExternalSyntheticLambda2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean contains;
                contains = Collection.this.contains(obj);
                return contains;
            }
        });
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean retainAll(final Collection<?> c4) {
        Objects.requireNonNull(c4);
        return bulkRemove(new Predicate() { // from class: java.util.concurrent.CopyOnWriteArrayList$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return CopyOnWriteArrayList.lambda$retainAll$1(Collection.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$retainAll$1(Collection c4, Object e2) {
        return !c4.contains(e2);
    }

    public int addAllAbsent(Collection<? extends E> c4) {
        int added;
        Object[] cs = c4.toArray();
        if (c4.getClass() != ArrayList.class) {
            cs = (Object[]) cs.clone();
        }
        if (cs.length == 0) {
            return 0;
        }
        synchronized (this.lock) {
            Object[] es = getArray();
            int len = es.length;
            added = 0;
            for (Object e2 : cs) {
                if (indexOfRange(e2, es, 0, len) < 0 && indexOfRange(e2, cs, 0, added) < 0) {
                    cs[added] = e2;
                    added++;
                }
            }
            if (added > 0) {
                Object[] newElements = Arrays.copyOf(es, len + added);
                System.arraycopy(cs, 0, newElements, len, added);
                setArray(newElements);
            }
        }
        return added;
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public void clear() {
        synchronized (this.lock) {
            setArray(new Object[0]);
        }
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> c4) {
        Object[] newElements;
        Object[] cs = c4.getClass() == CopyOnWriteArrayList.class ? ((CopyOnWriteArrayList) c4).getArray() : c4.toArray();
        if (cs.length == 0) {
            return false;
        }
        synchronized (this.lock) {
            Object[] es = getArray();
            int len = es.length;
            if (len == 0 && (c4.getClass() == CopyOnWriteArrayList.class || c4.getClass() == ArrayList.class)) {
                newElements = cs;
            } else {
                Object[] newElements2 = Arrays.copyOf(es, cs.length + len);
                System.arraycopy(cs, 0, newElements2, len, cs.length);
                newElements = newElements2;
            }
            setArray(newElements);
        }
        return true;
    }

    @Override // java.util.List
    public boolean addAll(int index, Collection<? extends E> c4) {
        Object[] newElements;
        Object[] cs = c4.toArray();
        synchronized (this.lock) {
            Object[] es = getArray();
            int len = es.length;
            if (index > len || index < 0) {
                throw new IndexOutOfBoundsException(outOfBounds(index, len));
            }
            if (cs.length == 0) {
                return false;
            }
            int numMoved = len - index;
            if (numMoved == 0) {
                newElements = Arrays.copyOf(es, cs.length + len);
            } else {
                newElements = new Object[cs.length + len];
                System.arraycopy(es, 0, newElements, 0, index);
                System.arraycopy(es, index, newElements, cs.length + index, numMoved);
            }
            System.arraycopy(cs, 0, newElements, index, cs.length);
            setArray(newElements);
            return true;
        }
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        for (Object x10 : getArray()) {
            action.accept(x10);
        }
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

    private boolean bulkRemove(Predicate<? super E> filter) {
        boolean bulkRemove;
        synchronized (this.lock) {
            bulkRemove = bulkRemove(filter, 0, getArray().length);
        }
        return bulkRemove;
    }

    boolean bulkRemove(Predicate<? super E> predicate, int i10, int i11) {
        Object[] array = getArray();
        while (i10 < i11 && !predicate.test((Object) elementAt(array, i10))) {
            i10++;
        }
        if (i10 < i11) {
            int i12 = i10;
            long[] nBits = nBits(i11 - i12);
            int i13 = 1;
            nBits[0] = 1;
            for (int i14 = i12 + 1; i14 < i11; i14++) {
                if (predicate.test((Object) elementAt(array, i14))) {
                    setBit(nBits, i14 - i12);
                    i13++;
                }
            }
            if (array != getArray()) {
                throw new ConcurrentModificationException();
            }
            Object[] copyOf = Arrays.copyOf(array, array.length - i13);
            int i15 = i12;
            int i16 = i12;
            while (i16 < i11) {
                if (isClear(nBits, i16 - i12)) {
                    copyOf[i15] = array[i16];
                    i15++;
                }
                i16++;
            }
            System.arraycopy(array, i16, copyOf, i15, array.length - i16);
            setArray(copyOf);
            return true;
        }
        if (array == getArray()) {
            return false;
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator<E> operator) {
        synchronized (this.lock) {
            replaceAllRange(operator, 0, getArray().length);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    void replaceAllRange(UnaryOperator<E> unaryOperator, int i10, int end) {
        Objects.requireNonNull(unaryOperator);
        Object[] es = (Object[]) getArray().clone();
        while (i10 < end) {
            es[i10] = unaryOperator.apply(elementAt(es, i10));
            i10++;
        }
        setArray(es);
    }

    @Override // java.util.List
    public void sort(Comparator<? super E> c4) {
        synchronized (this.lock) {
            sortRange(c4, 0, getArray().length);
        }
    }

    void sortRange(Comparator<? super E> c4, int i10, int end) {
        Object[] es = (Object[]) getArray().clone();
        Arrays.sort(es, i10, end, c4);
        setArray(es);
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        s2.defaultWriteObject();
        Object[] es = getArray();
        s2.writeInt(es.length);
        for (Object element : es) {
            s2.writeObject(element);
        }
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        s2.defaultReadObject();
        resetLock();
        int len = s2.readInt();
        SharedSecrets.getJavaObjectInputStreamAccess().checkArray(s2, Object[].class, len);
        Object[] es = new Object[len];
        for (int i10 = 0; i10 < len; i10++) {
            es[i10] = s2.readObject();
        }
        setArray(es);
    }

    public String toString() {
        return Arrays.toString(getArray());
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean equals(Object o10) {
        if (o10 == this) {
            return true;
        }
        if (!(o10 instanceof List)) {
            return false;
        }
        List<?> list = (List) o10;
        Iterator<E> iterator2 = list.iterator2();
        for (Object element : getArray()) {
            if (!iterator2.hasNext() || !Objects.equals(element, iterator2.next())) {
                return false;
            }
        }
        return true ^ iterator2.hasNext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int hashCodeOfRange(Object[] es, int from, int to) {
        int hashCode = 1;
        for (int i10 = from; i10 < to; i10++) {
            Object x10 = es[i10];
            hashCode = (hashCode * 31) + (x10 == null ? 0 : x10.hashCode());
        }
        return hashCode;
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public int hashCode() {
        Object[] es = getArray();
        return hashCodeOfRange(es, 0, es.length);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return new COWIterator(getArray(), 0);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new COWIterator(getArray(), 0);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int index) {
        Object[] es = getArray();
        int len = es.length;
        if (index < 0 || index > len) {
            throw new IndexOutOfBoundsException(outOfBounds(index, len));
        }
        return new COWIterator(es, index);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(getArray(), DownloadErrorCode.ERROR_OUTPUT_STREAM_SET_LENGTH_IO);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class COWIterator<E> implements ListIterator<E> {
        private int cursor;
        private final Object[] snapshot;

        COWIterator(Object[] es, int initialCursor) {
            this.cursor = initialCursor;
            this.snapshot = es;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.cursor < this.snapshot.length;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.cursor > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object[] objArr = this.snapshot;
            int i10 = this.cursor;
            this.cursor = i10 + 1;
            return (E) objArr[i10];
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            Object[] objArr = this.snapshot;
            int i10 = this.cursor - 1;
            this.cursor = i10;
            return (E) objArr[i10];
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
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator
        public void set(E e2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator
        public void add(E e2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public void forEachRemaining(Consumer<? super E> consumer) {
            Objects.requireNonNull(consumer);
            int length = this.snapshot.length;
            this.cursor = length;
            for (int i10 = this.cursor; i10 < length; i10++) {
                consumer.accept((Object) CopyOnWriteArrayList.elementAt(this.snapshot, i10));
            }
        }
    }

    @Override // java.util.List
    public List<E> subList(int fromIndex, int toIndex) {
        COWSubList cOWSubList;
        synchronized (this.lock) {
            Object[] es = getArray();
            int len = es.length;
            int size = toIndex - fromIndex;
            if (fromIndex < 0 || toIndex > len || size < 0) {
                throw new IndexOutOfBoundsException();
            }
            cOWSubList = new COWSubList(es, fromIndex, size);
        }
        return cOWSubList;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class COWSubList implements List<E>, RandomAccess {
        private Object[] expectedArray;
        private final int offset;
        private int size;

        COWSubList(Object[] es, int offset, int size) {
            this.expectedArray = es;
            this.offset = offset;
            this.size = size;
        }

        private void checkForComodification() {
            if (CopyOnWriteArrayList.this.getArray() != this.expectedArray) {
                throw new ConcurrentModificationException();
            }
        }

        private Object[] getArrayChecked() {
            Object[] a10 = CopyOnWriteArrayList.this.getArray();
            if (a10 != this.expectedArray) {
                throw new ConcurrentModificationException();
            }
            return a10;
        }

        private void rangeCheck(int index) {
            if (index < 0 || index >= this.size) {
                throw new IndexOutOfBoundsException(CopyOnWriteArrayList.outOfBounds(index, this.size));
            }
        }

        private void rangeCheckForAdd(int index) {
            if (index < 0 || index > this.size) {
                throw new IndexOutOfBoundsException(CopyOnWriteArrayList.outOfBounds(index, this.size));
            }
        }

        @Override // java.util.List, java.util.Collection, java.util.Set
        public Object[] toArray() {
            Object[] es;
            int offset;
            int size;
            synchronized (CopyOnWriteArrayList.this.lock) {
                es = getArrayChecked();
                offset = this.offset;
                size = this.size;
            }
            return Arrays.copyOfRange(es, offset, offset + size);
        }

        @Override // java.util.List, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            Object[] arrayChecked;
            int i10;
            int i11;
            synchronized (CopyOnWriteArrayList.this.lock) {
                arrayChecked = getArrayChecked();
                i10 = this.offset;
                i11 = this.size;
            }
            if (tArr.length < i11) {
                return (T[]) Arrays.copyOfRange(arrayChecked, i10, i10 + i11, tArr.getClass());
            }
            System.arraycopy(arrayChecked, i10, tArr, 0, i11);
            if (tArr.length > i11) {
                tArr[i11] = null;
            }
            return tArr;
        }

        @Override // java.util.List
        public int indexOf(Object o10) {
            Object[] es;
            int offset;
            int size;
            synchronized (CopyOnWriteArrayList.this.lock) {
                es = getArrayChecked();
                offset = this.offset;
                size = this.size;
            }
            int i10 = CopyOnWriteArrayList.indexOfRange(o10, es, offset, offset + size);
            if (i10 == -1) {
                return -1;
            }
            return i10 - offset;
        }

        @Override // java.util.List
        public int lastIndexOf(Object o10) {
            Object[] es;
            int offset;
            int size;
            synchronized (CopyOnWriteArrayList.this.lock) {
                es = getArrayChecked();
                offset = this.offset;
                size = this.size;
            }
            int i10 = CopyOnWriteArrayList.lastIndexOfRange(o10, es, offset, offset + size);
            if (i10 == -1) {
                return -1;
            }
            return i10 - offset;
        }

        @Override // java.util.List, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            return indexOf(o10) >= 0;
        }

        @Override // java.util.List, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> c4) {
            Object[] es;
            int offset;
            int size;
            synchronized (CopyOnWriteArrayList.this.lock) {
                es = getArrayChecked();
                offset = this.offset;
                size = this.size;
            }
            for (Object o10 : c4) {
                if (CopyOnWriteArrayList.indexOfRange(o10, es, offset, offset + size) < 0) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.List, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return size() == 0;
        }

        public String toString() {
            return Arrays.toString(toArray());
        }

        @Override // java.util.List, java.util.Collection, java.util.Set
        public int hashCode() {
            Object[] es;
            int offset;
            int size;
            synchronized (CopyOnWriteArrayList.this.lock) {
                es = getArrayChecked();
                offset = this.offset;
                size = this.size;
            }
            return CopyOnWriteArrayList.hashCodeOfRange(es, offset, offset + size);
        }

        @Override // java.util.List, java.util.Collection, java.util.Set
        public boolean equals(Object o10) {
            Object[] es;
            int offset;
            int size;
            if (o10 == this) {
                return true;
            }
            if (!(o10 instanceof List)) {
                return false;
            }
            Iterator<E> iterator2 = ((List) o10).iterator2();
            synchronized (CopyOnWriteArrayList.this.lock) {
                es = getArrayChecked();
                offset = this.offset;
                size = this.size;
            }
            int end = offset + size;
            for (int i10 = offset; i10 < end; i10++) {
                if (!iterator2.hasNext() || !Objects.equals(es[i10], iterator2.next())) {
                    return false;
                }
            }
            return true ^ iterator2.hasNext();
        }

        @Override // java.util.List
        public E set(int i10, E e2) {
            E e10;
            synchronized (CopyOnWriteArrayList.this.lock) {
                rangeCheck(i10);
                checkForComodification();
                e10 = (E) CopyOnWriteArrayList.this.set(this.offset + i10, e2);
                this.expectedArray = CopyOnWriteArrayList.this.getArray();
            }
            return e10;
        }

        @Override // java.util.List
        public E get(int i10) {
            E e2;
            synchronized (CopyOnWriteArrayList.this.lock) {
                rangeCheck(i10);
                checkForComodification();
                e2 = (E) CopyOnWriteArrayList.this.get(this.offset + i10);
            }
            return e2;
        }

        @Override // java.util.List, java.util.Collection, java.util.Set
        public int size() {
            int i10;
            synchronized (CopyOnWriteArrayList.this.lock) {
                checkForComodification();
                i10 = this.size;
            }
            return i10;
        }

        @Override // java.util.List, java.util.Collection, java.util.Set
        public boolean add(E element) {
            synchronized (CopyOnWriteArrayList.this.lock) {
                checkForComodification();
                CopyOnWriteArrayList.this.add(this.offset + this.size, element);
                this.expectedArray = CopyOnWriteArrayList.this.getArray();
                this.size++;
            }
            return true;
        }

        @Override // java.util.List
        public void add(int index, E element) {
            synchronized (CopyOnWriteArrayList.this.lock) {
                checkForComodification();
                rangeCheckForAdd(index);
                CopyOnWriteArrayList.this.add(this.offset + index, element);
                this.expectedArray = CopyOnWriteArrayList.this.getArray();
                this.size++;
            }
        }

        @Override // java.util.List, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends E> c4) {
            boolean modified;
            synchronized (CopyOnWriteArrayList.this.lock) {
                Object[] oldArray = getArrayChecked();
                modified = CopyOnWriteArrayList.this.addAll(this.offset + this.size, c4);
                int i10 = this.size;
                Object[] array = CopyOnWriteArrayList.this.getArray();
                this.expectedArray = array;
                this.size = i10 + (array.length - oldArray.length);
            }
            return modified;
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends E> c4) {
            boolean modified;
            synchronized (CopyOnWriteArrayList.this.lock) {
                rangeCheckForAdd(index);
                Object[] oldArray = getArrayChecked();
                modified = CopyOnWriteArrayList.this.addAll(this.offset + index, c4);
                int i10 = this.size;
                Object[] array = CopyOnWriteArrayList.this.getArray();
                this.expectedArray = array;
                this.size = i10 + (array.length - oldArray.length);
            }
            return modified;
        }

        @Override // java.util.List, java.util.Collection, java.util.Set
        public void clear() {
            synchronized (CopyOnWriteArrayList.this.lock) {
                checkForComodification();
                CopyOnWriteArrayList copyOnWriteArrayList = CopyOnWriteArrayList.this;
                int i10 = this.offset;
                copyOnWriteArrayList.removeRange(i10, this.size + i10);
                this.expectedArray = CopyOnWriteArrayList.this.getArray();
                this.size = 0;
            }
        }

        @Override // java.util.List
        public E remove(int i10) {
            E e2;
            synchronized (CopyOnWriteArrayList.this.lock) {
                rangeCheck(i10);
                checkForComodification();
                e2 = (E) CopyOnWriteArrayList.this.remove(this.offset + i10);
                this.expectedArray = CopyOnWriteArrayList.this.getArray();
                this.size--;
            }
            return e2;
        }

        @Override // java.util.List, java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            synchronized (CopyOnWriteArrayList.this.lock) {
                checkForComodification();
                int index = indexOf(o10);
                if (index == -1) {
                    return false;
                }
                remove(index);
                return true;
            }
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<E> iterator2() {
            return listIterator(0);
        }

        @Override // java.util.List
        public ListIterator<E> listIterator() {
            return listIterator(0);
        }

        @Override // java.util.List
        public ListIterator<E> listIterator(int index) {
            COWSubListIterator cOWSubListIterator;
            synchronized (CopyOnWriteArrayList.this.lock) {
                checkForComodification();
                rangeCheckForAdd(index);
                cOWSubListIterator = new COWSubListIterator(CopyOnWriteArrayList.this, index, this.offset, this.size);
            }
            return cOWSubListIterator;
        }

        @Override // java.util.List
        public List<E> subList(int fromIndex, int toIndex) {
            COWSubList cOWSubList;
            synchronized (CopyOnWriteArrayList.this.lock) {
                checkForComodification();
                if (fromIndex < 0 || toIndex > this.size || fromIndex > toIndex) {
                    throw new IndexOutOfBoundsException();
                }
                cOWSubList = new COWSubList(this.expectedArray, this.offset + fromIndex, toIndex - fromIndex);
            }
            return cOWSubList;
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super E> consumer) {
            Object[] arrayChecked;
            int i10;
            int i11;
            Objects.requireNonNull(consumer);
            synchronized (CopyOnWriteArrayList.this.lock) {
                arrayChecked = getArrayChecked();
                i10 = this.offset;
                i11 = this.size + i10;
            }
            while (i10 < i11) {
                consumer.accept((Object) CopyOnWriteArrayList.elementAt(arrayChecked, i10));
                i10++;
            }
        }

        @Override // java.util.List
        public void replaceAll(UnaryOperator<E> operator) {
            synchronized (CopyOnWriteArrayList.this.lock) {
                checkForComodification();
                CopyOnWriteArrayList copyOnWriteArrayList = CopyOnWriteArrayList.this;
                int i10 = this.offset;
                copyOnWriteArrayList.replaceAllRange(operator, i10, this.size + i10);
                this.expectedArray = CopyOnWriteArrayList.this.getArray();
            }
        }

        @Override // java.util.List
        public void sort(Comparator<? super E> c4) {
            synchronized (CopyOnWriteArrayList.this.lock) {
                checkForComodification();
                CopyOnWriteArrayList copyOnWriteArrayList = CopyOnWriteArrayList.this;
                int i10 = this.offset;
                copyOnWriteArrayList.sortRange(c4, i10, this.size + i10);
                this.expectedArray = CopyOnWriteArrayList.this.getArray();
            }
        }

        @Override // java.util.List, java.util.Collection, java.util.Set
        public boolean removeAll(final Collection<?> c4) {
            Objects.requireNonNull(c4);
            return bulkRemove(new Predicate() { // from class: java.util.concurrent.CopyOnWriteArrayList$COWSubList$$ExternalSyntheticLambda1
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean contains;
                    contains = Collection.this.contains(obj);
                    return contains;
                }
            });
        }

        @Override // java.util.List, java.util.Collection, java.util.Set
        public boolean retainAll(final Collection<?> c4) {
            Objects.requireNonNull(c4);
            return bulkRemove(new Predicate() { // from class: java.util.concurrent.CopyOnWriteArrayList$COWSubList$$ExternalSyntheticLambda0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return CopyOnWriteArrayList.COWSubList.lambda$retainAll$1(Collection.this, obj);
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

        private boolean bulkRemove(Predicate<? super E> filter) {
            boolean modified;
            synchronized (CopyOnWriteArrayList.this.lock) {
                Object[] oldArray = getArrayChecked();
                CopyOnWriteArrayList copyOnWriteArrayList = CopyOnWriteArrayList.this;
                int i10 = this.offset;
                modified = copyOnWriteArrayList.bulkRemove(filter, i10, this.size + i10);
                int i11 = this.size;
                Object[] array = CopyOnWriteArrayList.this.getArray();
                this.expectedArray = array;
                this.size = i11 + (array.length - oldArray.length);
            }
            return modified;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Spliterator<E> spliterator() {
            Spliterator<E> spliterator;
            synchronized (CopyOnWriteArrayList.this.lock) {
                Object[] arrayChecked = getArrayChecked();
                int i10 = this.offset;
                spliterator = Spliterators.spliterator(arrayChecked, i10, this.size + i10, DownloadErrorCode.ERROR_OUTPUT_STREAM_SET_LENGTH_IO);
            }
            return spliterator;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class COWSubListIterator<E> implements ListIterator<E> {
        private final ListIterator<E> it;
        private final int offset;
        private final int size;

        COWSubListIterator(List<E> l10, int index, int offset, int size) {
            this.offset = offset;
            this.size = size;
            this.it = l10.listIterator(index + offset);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return nextIndex() < this.size;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            if (hasNext()) {
                return this.it.next();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return previousIndex() >= 0;
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (hasPrevious()) {
                return this.it.previous();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.it.nextIndex() - this.offset;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.it.previousIndex() - this.offset;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator
        public void set(E e2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator
        public void add(E e2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public void forEachRemaining(Consumer<? super E> consumer) {
            Objects.requireNonNull(consumer);
            while (hasNext()) {
                consumer.accept(this.it.next());
            }
        }
    }

    private void resetLock() {
        Field lockField = (Field) AccessController.doPrivileged(new PrivilegedAction() { // from class: java.util.concurrent.CopyOnWriteArrayList$$ExternalSyntheticLambda0
            @Override // java.security.PrivilegedAction
            public final Object run() {
                return CopyOnWriteArrayList.lambda$resetLock$2();
            }
        });
        try {
            lockField.set(this, new Object());
        } catch (IllegalAccessException e2) {
            throw new Error(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Field lambda$resetLock$2() {
        try {
            Field f10 = CopyOnWriteArrayList.class.getDeclaredField("lock");
            f10.setAccessible(true);
            return f10;
        } catch (ReflectiveOperationException e2) {
            throw new Error(e2);
        }
    }
}
