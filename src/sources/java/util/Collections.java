package java.util;

import dalvik.system.VMRuntime;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Comparators;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import jdk.internal.misc.SharedSecrets;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Collections {
    private static final int BINARYSEARCH_THRESHOLD = 5000;
    private static final int COPY_THRESHOLD = 10;
    private static final int FILL_THRESHOLD = 25;
    private static final int INDEXOFSUBLIST_THRESHOLD = 35;
    private static final int REPLACEALL_THRESHOLD = 11;
    private static final int REVERSE_THRESHOLD = 18;
    private static final int ROTATE_THRESHOLD = 100;
    private static final int SHUFFLE_THRESHOLD = 5;

    /* renamed from: r, reason: collision with root package name */
    private static Random f50434r;
    public static final Set EMPTY_SET = new EmptySet();
    public static final List EMPTY_LIST = new EmptyList();
    public static final Map EMPTY_MAP = new EmptyMap();

    private Collections() {
    }

    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        sort(list, null);
    }

    public static <T> void sort(List<T> list, Comparator<? super T> comparator) {
        if (VMRuntime.getRuntime().getTargetSdkVersion() > 25) {
            list.sort(comparator);
            return;
        }
        if (list.getClass() == ArrayList.class) {
            Arrays.sort(((ArrayList) list).elementData, 0, list.size(), comparator);
            return;
        }
        Object[] array = list.toArray();
        Arrays.sort(array, comparator);
        ListIterator<T> listIterator = list.listIterator();
        for (Object obj : array) {
            listIterator.next();
            listIterator.set(obj);
        }
    }

    public static <T> int binarySearch(List<? extends Comparable<? super T>> list, T key) {
        if ((list instanceof RandomAccess) || list.size() < 5000) {
            return indexedBinarySearch(list, key);
        }
        return iteratorBinarySearch(list, key);
    }

    private static <T> int indexedBinarySearch(List<? extends Comparable<? super T>> list, T key) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            Comparable<? super T> midVal = list.get(mid);
            int cmp = midVal.compareTo(key);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    private static <T> int iteratorBinarySearch(List<? extends Comparable<? super T>> list, T key) {
        int low = 0;
        int high = list.size() - 1;
        ListIterator<? extends Comparable<? super T>> i10 = list.listIterator();
        while (low <= high) {
            int mid = (low + high) >>> 1;
            Comparable<? super T> midVal = (Comparable) get(i10, mid);
            int cmp = midVal.compareTo(key);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    private static <T> T get(ListIterator<? extends T> i10, int index) {
        T obj;
        int pos = i10.nextIndex();
        if (pos <= index) {
            while (true) {
                obj = i10.next();
                int pos2 = pos + 1;
                if (pos >= index) {
                    break;
                }
                pos = pos2;
            }
            return obj;
        }
        do {
            obj = i10.previous();
            pos--;
        } while (pos > index);
        return obj;
    }

    public static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c4) {
        if (c4 == null) {
            return binarySearch(list, key);
        }
        if ((list instanceof RandomAccess) || list.size() < 5000) {
            return indexedBinarySearch(list, key, c4);
        }
        return iteratorBinarySearch(list, key, c4);
    }

    private static <T> int indexedBinarySearch(List<? extends T> list, T t2, Comparator<? super T> comparator) {
        int i10 = 0;
        int size = list.size() - 1;
        while (i10 <= size) {
            int i11 = (i10 + size) >>> 1;
            int compare = comparator.compare(list.get(i11), t2);
            if (compare < 0) {
                i10 = i11 + 1;
            } else if (compare > 0) {
                size = i11 - 1;
            } else {
                return i11;
            }
        }
        return -(i10 + 1);
    }

    private static <T> int iteratorBinarySearch(List<? extends T> list, T t2, Comparator<? super T> comparator) {
        int i10 = 0;
        int size = list.size() - 1;
        ListIterator<? extends T> listIterator = list.listIterator();
        while (i10 <= size) {
            int i11 = (i10 + size) >>> 1;
            int compare = comparator.compare((Object) get(listIterator, i11), t2);
            if (compare < 0) {
                i10 = i11 + 1;
            } else if (compare > 0) {
                size = i11 - 1;
            } else {
                return i11;
            }
        }
        return -(i10 + 1);
    }

    public static void reverse(List<?> list) {
        int size = list.size();
        if (size < 18 || (list instanceof RandomAccess)) {
            int i10 = 0;
            int mid = size >> 1;
            int j10 = size - 1;
            while (i10 < mid) {
                swap(list, i10, j10);
                i10++;
                j10--;
            }
            return;
        }
        ListIterator fwd = list.listIterator();
        ListIterator rev = list.listIterator(size);
        int mid2 = list.size() >> 1;
        for (int i11 = 0; i11 < mid2; i11++) {
            Object tmp = fwd.next();
            fwd.set(rev.previous());
            rev.set(tmp);
        }
    }

    public static void shuffle(List<?> list) {
        Random rnd = f50434r;
        if (rnd == null) {
            Random random = new Random();
            rnd = random;
            f50434r = random;
        }
        shuffle(list, rnd);
    }

    public static void shuffle(List<?> list, Random rnd) {
        int size = list.size();
        if (size < 5 || (list instanceof RandomAccess)) {
            for (int i10 = size; i10 > 1; i10--) {
                swap(list, i10 - 1, rnd.nextInt(i10));
            }
            return;
        }
        Object[] arr = list.toArray();
        for (int i11 = size; i11 > 1; i11--) {
            swap(arr, i11 - 1, rnd.nextInt(i11));
        }
        ListIterator it = list.listIterator();
        for (Object e2 : arr) {
            it.next();
            it.set(e2);
        }
    }

    public static void swap(List<?> list, int i10, int j10) {
        list.set(i10, list.set(j10, list.get(i10)));
    }

    private static void swap(Object[] arr, int i10, int j10) {
        Object tmp = arr[i10];
        arr[i10] = arr[j10];
        arr[j10] = tmp;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void fill(List<? super T> list, T t2) {
        int size = list.size();
        if (size < 25 || (list instanceof RandomAccess)) {
            for (int i10 = 0; i10 < size; i10++) {
                list.set(i10, t2);
            }
            return;
        }
        ListIterator<? super T> itr = list.listIterator();
        for (int i11 = 0; i11 < size; i11++) {
            itr.next();
            itr.set(t2);
        }
    }

    public static <T> void copy(List<? super T> list, List<? extends T> list2) {
        int size = list2.size();
        if (size > list.size()) {
            throw new IndexOutOfBoundsException("Source does not fit in dest");
        }
        if (size < 10 || ((list2 instanceof RandomAccess) && (list instanceof RandomAccess))) {
            for (int i10 = 0; i10 < size; i10++) {
                list.set(i10, list2.get(i10));
            }
            return;
        }
        ListIterator<? super T> listIterator = list.listIterator();
        ListIterator<? extends T> listIterator2 = list2.listIterator();
        for (int i11 = 0; i11 < size; i11++) {
            listIterator.next();
            listIterator.set(listIterator2.next());
        }
    }

    public static <T extends Comparable<? super T>> T min(Collection<? extends T> coll) {
        Iterator<? extends T> i10 = coll.iterator2();
        T candidate = i10.next();
        while (i10.hasNext()) {
            T next = i10.next();
            if (next.compareTo(candidate) < 0) {
                candidate = next;
            }
        }
        return candidate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T min(Collection<? extends T> collection, Comparator<? super T> comparator) {
        if (comparator == null) {
            return (T) min(collection);
        }
        Iterator<? extends T> iterator2 = collection.iterator2();
        Object obj = (T) iterator2.next();
        while (iterator2.hasNext()) {
            Object obj2 = (T) iterator2.next();
            if (comparator.compare(obj2, obj) < 0) {
                obj = (T) obj2;
            }
        }
        return (T) obj;
    }

    public static <T extends Comparable<? super T>> T max(Collection<? extends T> coll) {
        Iterator<? extends T> i10 = coll.iterator2();
        T candidate = i10.next();
        while (i10.hasNext()) {
            T next = i10.next();
            if (next.compareTo(candidate) > 0) {
                candidate = next;
            }
        }
        return candidate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T max(Collection<? extends T> collection, Comparator<? super T> comparator) {
        if (comparator == null) {
            return (T) max(collection);
        }
        Iterator<? extends T> iterator2 = collection.iterator2();
        Object obj = (T) iterator2.next();
        while (iterator2.hasNext()) {
            Object obj2 = (T) iterator2.next();
            if (comparator.compare(obj2, obj) > 0) {
                obj = (T) obj2;
            }
        }
        return (T) obj;
    }

    public static void rotate(List<?> list, int distance) {
        if ((list instanceof RandomAccess) || list.size() < 100) {
            rotate1(list, distance);
        } else {
            rotate2(list, distance);
        }
    }

    private static <T> void rotate1(List<T> list, int distance) {
        int size = list.size();
        if (size == 0) {
            return;
        }
        int distance2 = distance % size;
        if (distance2 < 0) {
            distance2 += size;
        }
        if (distance2 == 0) {
            return;
        }
        int cycleStart = 0;
        int nMoved = 0;
        while (nMoved != size) {
            T displaced = list.get(cycleStart);
            int i10 = cycleStart;
            do {
                i10 += distance2;
                if (i10 >= size) {
                    i10 -= size;
                }
                displaced = list.set(i10, displaced);
                nMoved++;
            } while (i10 != cycleStart);
            cycleStart++;
        }
    }

    private static void rotate2(List<?> list, int distance) {
        int size = list.size();
        if (size == 0) {
            return;
        }
        int mid = (-distance) % size;
        if (mid < 0) {
            mid += size;
        }
        if (mid == 0) {
            return;
        }
        reverse(list.subList(0, mid));
        reverse(list.subList(mid, size));
        reverse(list);
    }

    public static <T> boolean replaceAll(List<T> list, T oldVal, T newVal) {
        boolean result = false;
        int size = list.size();
        if (size < 11 || (list instanceof RandomAccess)) {
            if (oldVal == null) {
                for (int i10 = 0; i10 < size; i10++) {
                    if (list.get(i10) == null) {
                        list.set(i10, newVal);
                        result = true;
                    }
                }
            } else {
                for (int i11 = 0; i11 < size; i11++) {
                    if (oldVal.equals(list.get(i11))) {
                        list.set(i11, newVal);
                        result = true;
                    }
                }
            }
        } else {
            ListIterator<T> itr = list.listIterator();
            if (oldVal == null) {
                for (int i12 = 0; i12 < size; i12++) {
                    if (itr.next() == null) {
                        itr.set(newVal);
                        result = true;
                    }
                }
            } else {
                for (int i13 = 0; i13 < size; i13++) {
                    if (oldVal.equals(itr.next())) {
                        itr.set(newVal);
                        result = true;
                    }
                }
            }
        }
        return result;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x005a, code lost:
    
        r3 = r3 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int indexOfSubList(java.util.List<?> r9, java.util.List<?> r10) {
        /*
            int r0 = r9.size()
            int r1 = r10.size()
            int r2 = r0 - r1
            r3 = 35
            if (r0 < r3) goto L44
            boolean r3 = r9 instanceof java.util.RandomAccess
            if (r3 == 0) goto L17
            boolean r3 = r10 instanceof java.util.RandomAccess
            if (r3 == 0) goto L17
            goto L44
        L17:
            java.util.ListIterator r3 = r9.listIterator()
            r4 = 0
        L1c:
            if (r4 > r2) goto L63
            java.util.ListIterator r5 = r10.listIterator()
            r6 = 0
        L23:
            if (r6 >= r1) goto L43
            java.lang.Object r7 = r5.next()
            java.lang.Object r8 = r3.next()
            boolean r7 = eq(r7, r8)
            if (r7 != 0) goto L40
            r7 = 0
        L34:
            if (r7 >= r6) goto L3c
            r3.previous()
            int r7 = r7 + 1
            goto L34
        L3c:
            int r4 = r4 + 1
            goto L1c
        L40:
            int r6 = r6 + 1
            goto L23
        L43:
            return r4
        L44:
            r3 = 0
        L45:
            if (r3 > r2) goto L63
            r4 = 0
            r5 = r3
        L49:
            if (r4 >= r1) goto L62
            java.lang.Object r6 = r10.get(r4)
            java.lang.Object r7 = r9.get(r5)
            boolean r6 = eq(r6, r7)
            if (r6 != 0) goto L5d
        L5a:
            int r3 = r3 + 1
            goto L45
        L5d:
            int r4 = r4 + 1
            int r5 = r5 + 1
            goto L49
        L62:
            return r3
        L63:
            r3 = -1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.indexOfSubList(java.util.List, java.util.List):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x005d, code lost:
    
        r3 = r3 - 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int lastIndexOfSubList(java.util.List<?> r10, java.util.List<?> r11) {
        /*
            int r0 = r10.size()
            int r1 = r11.size()
            int r2 = r0 - r1
            r3 = 35
            r4 = -1
            if (r0 < r3) goto L47
            boolean r3 = r10 instanceof java.util.RandomAccess
            if (r3 == 0) goto L14
            goto L47
        L14:
            if (r2 >= 0) goto L17
            return r4
        L17:
            java.util.ListIterator r3 = r10.listIterator(r2)
            r5 = r2
        L1c:
            if (r5 < 0) goto L66
            java.util.ListIterator r6 = r11.listIterator()
            r7 = 0
        L23:
            if (r7 >= r1) goto L46
            java.lang.Object r8 = r6.next()
            java.lang.Object r9 = r3.next()
            boolean r8 = eq(r8, r9)
            if (r8 != 0) goto L43
            if (r5 == 0) goto L40
            r8 = 0
        L36:
            int r9 = r7 + 1
            if (r8 > r9) goto L40
            r3.previous()
            int r8 = r8 + 1
            goto L36
        L40:
            int r5 = r5 + (-1)
            goto L1c
        L43:
            int r7 = r7 + 1
            goto L23
        L46:
            return r5
        L47:
            r3 = r2
        L48:
            if (r3 < 0) goto L66
            r5 = 0
            r6 = r3
        L4c:
            if (r5 >= r1) goto L65
            java.lang.Object r7 = r11.get(r5)
            java.lang.Object r8 = r10.get(r6)
            boolean r7 = eq(r7, r8)
            if (r7 != 0) goto L60
        L5d:
            int r3 = r3 + (-1)
            goto L48
        L60:
            int r5 = r5 + 1
            int r6 = r6 + 1
            goto L4c
        L65:
            return r3
        L66:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.Collections.lastIndexOfSubList(java.util.List, java.util.List):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Collection<T> unmodifiableCollection(Collection<? extends T> collection) {
        if (collection.getClass() == UnmodifiableCollection.class) {
            return collection;
        }
        return new UnmodifiableCollection(collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class UnmodifiableCollection<E> implements Collection<E>, Serializable {
        private static final long serialVersionUID = 1820017752578914078L;

        /* renamed from: c, reason: collision with root package name */
        final Collection<? extends E> f50448c;

        UnmodifiableCollection(Collection<? extends E> c4) {
            if (c4 == null) {
                throw new NullPointerException();
            }
            this.f50448c = c4;
        }

        @Override // java.util.Collection, java.util.Set
        public int size() {
            return this.f50448c.size();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f50448c.isEmpty();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            return this.f50448c.contains(o10);
        }

        @Override // java.util.Collection, java.util.Set
        public Object[] toArray() {
            return this.f50448c.toArray();
        }

        @Override // java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) this.f50448c.toArray(tArr);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(IntFunction<T[]> intFunction) {
            return (T[]) this.f50448c.toArray(intFunction);
        }

        public String toString() {
            return this.f50448c.toString();
        }

        @Override // java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<E> iterator2() {
            return new Iterator<E>() { // from class: java.util.Collections.UnmodifiableCollection.1

                /* renamed from: i, reason: collision with root package name */
                private final Iterator<? extends E> f50449i;

                {
                    this.f50449i = UnmodifiableCollection.this.f50448c.iterator2();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.f50449i.hasNext();
                }

                @Override // java.util.Iterator
                public E next() {
                    return this.f50449i.next();
                }

                @Override // java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super E> action) {
                    this.f50449i.forEachRemaining(action);
                }
            };
        }

        @Override // java.util.Collection, java.util.Set
        public boolean add(E e2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> coll) {
            return this.f50448c.containsAll(coll);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends E> coll) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> coll) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> coll) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super E> action) {
            this.f50448c.forEach(action);
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super E> filter) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<E> spliterator() {
            return this.f50448c.spliterator();
        }

        @Override // java.util.Collection
        public Stream<E> stream() {
            return this.f50448c.stream();
        }

        @Override // java.util.Collection
        public Stream<E> parallelStream() {
            return this.f50448c.parallelStream();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Set<T> unmodifiableSet(Set<? extends T> set) {
        if (set.getClass() == UnmodifiableSet.class) {
            return set;
        }
        return new UnmodifiableSet(set);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class UnmodifiableSet<E> extends UnmodifiableCollection<E> implements Set<E>, Serializable {
        private static final long serialVersionUID = -9215047833775013803L;

        UnmodifiableSet(Set<? extends E> s2) {
            super(s2);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object o10) {
            return o10 == this || this.f50448c.equals(o10);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return this.f50448c.hashCode();
        }
    }

    public static <T> SortedSet<T> unmodifiableSortedSet(SortedSet<T> s2) {
        if (s2.getClass() == UnmodifiableSortedSet.class) {
            return s2;
        }
        return new UnmodifiableSortedSet(s2);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class UnmodifiableSortedSet<E> extends UnmodifiableSet<E> implements SortedSet<E>, Serializable {
        private static final long serialVersionUID = -4929149591599911165L;
        private final SortedSet<E> ss;

        UnmodifiableSortedSet(SortedSet<E> s2) {
            super(s2);
            this.ss = s2;
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            return this.ss.comparator();
        }

        @Override // java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> subSet(E fromElement, E toElement) {
            return new UnmodifiableSortedSet(this.ss.subSet(fromElement, toElement));
        }

        @Override // java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> headSet(E toElement) {
            return new UnmodifiableSortedSet(this.ss.headSet(toElement));
        }

        @Override // java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> tailSet(E fromElement) {
            return new UnmodifiableSortedSet(this.ss.tailSet(fromElement));
        }

        @Override // java.util.SortedSet
        public E first() {
            return this.ss.first();
        }

        @Override // java.util.SortedSet
        public E last() {
            return this.ss.last();
        }
    }

    public static <T> NavigableSet<T> unmodifiableNavigableSet(NavigableSet<T> s2) {
        if (s2.getClass() == UnmodifiableNavigableSet.class) {
            return s2;
        }
        return new UnmodifiableNavigableSet(s2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class UnmodifiableNavigableSet<E> extends UnmodifiableSortedSet<E> implements NavigableSet<E>, Serializable {
        private static final NavigableSet<?> EMPTY_NAVIGABLE_SET = new EmptyNavigableSet();
        private static final long serialVersionUID = -6027448201786391929L;
        private final NavigableSet<E> ns;

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        private static class EmptyNavigableSet<E> extends UnmodifiableNavigableSet<E> implements Serializable {
            private static final long serialVersionUID = -6291252904449939134L;

            public EmptyNavigableSet() {
                super(new TreeSet());
            }

            private Object readResolve() {
                return UnmodifiableNavigableSet.EMPTY_NAVIGABLE_SET;
            }
        }

        UnmodifiableNavigableSet(NavigableSet<E> s2) {
            super(s2);
            this.ns = s2;
        }

        @Override // java.util.NavigableSet
        public E lower(E e2) {
            return this.ns.lower(e2);
        }

        @Override // java.util.NavigableSet
        public E floor(E e2) {
            return this.ns.floor(e2);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e2) {
            return this.ns.ceiling(e2);
        }

        @Override // java.util.NavigableSet
        public E higher(E e2) {
            return this.ns.higher(e2);
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return new UnmodifiableNavigableSet(this.ns.descendingSet());
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return descendingSet().iterator2();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
            return new UnmodifiableNavigableSet(this.ns.subSet(fromElement, fromInclusive, toElement, toInclusive));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E toElement, boolean inclusive) {
            return new UnmodifiableNavigableSet(this.ns.headSet(toElement, inclusive));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
            return new UnmodifiableNavigableSet(this.ns.tailSet(fromElement, inclusive));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> unmodifiableList(List<? extends T> list) {
        if (list.getClass() == UnmodifiableList.class || list.getClass() == UnmodifiableRandomAccessList.class) {
            return list;
        }
        if (list instanceof RandomAccess) {
            return new UnmodifiableRandomAccessList(list);
        }
        return new UnmodifiableList(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class UnmodifiableList<E> extends UnmodifiableCollection<E> implements List<E> {
        private static final long serialVersionUID = -283967356065247728L;
        final List<? extends E> list;

        UnmodifiableList(List<? extends E> list) {
            super(list);
            this.list = list;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object o10) {
            return o10 == this || this.list.equals(o10);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return this.list.hashCode();
        }

        @Override // java.util.List
        public E get(int index) {
            return this.list.get(index);
        }

        @Override // java.util.List
        public E set(int index, E element) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.List
        public void add(int index, E element) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.List
        public E remove(int index) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.List
        public int indexOf(Object o10) {
            return this.list.indexOf(o10);
        }

        @Override // java.util.List
        public int lastIndexOf(Object o10) {
            return this.list.lastIndexOf(o10);
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends E> c4) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.List
        public void replaceAll(UnaryOperator<E> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.List
        public void sort(Comparator<? super E> c4) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.List
        public ListIterator<E> listIterator() {
            return listIterator(0);
        }

        @Override // java.util.List
        public ListIterator<E> listIterator(int index) {
            return new ListIterator<E>(index) { // from class: java.util.Collections.UnmodifiableList.1

                /* renamed from: i, reason: collision with root package name */
                private final ListIterator<? extends E> f50450i;
                final /* synthetic */ int val$index;

                {
                    this.val$index = index;
                    this.f50450i = UnmodifiableList.this.list.listIterator(index);
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public boolean hasNext() {
                    return this.f50450i.hasNext();
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public E next() {
                    return this.f50450i.next();
                }

                @Override // java.util.ListIterator
                public boolean hasPrevious() {
                    return this.f50450i.hasPrevious();
                }

                @Override // java.util.ListIterator
                public E previous() {
                    return this.f50450i.previous();
                }

                @Override // java.util.ListIterator
                public int nextIndex() {
                    return this.f50450i.nextIndex();
                }

                @Override // java.util.ListIterator
                public int previousIndex() {
                    return this.f50450i.previousIndex();
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
                public void forEachRemaining(Consumer<? super E> action) {
                    this.f50450i.forEachRemaining(action);
                }
            };
        }

        @Override // java.util.List
        public List<E> subList(int fromIndex, int toIndex) {
            return new UnmodifiableList(this.list.subList(fromIndex, toIndex));
        }

        private Object readResolve() {
            List<? extends E> list = this.list;
            if (list instanceof RandomAccess) {
                return new UnmodifiableRandomAccessList(list);
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class UnmodifiableRandomAccessList<E> extends UnmodifiableList<E> implements RandomAccess {
        private static final long serialVersionUID = -2542308836966382001L;

        UnmodifiableRandomAccessList(List<? extends E> list) {
            super(list);
        }

        @Override // java.util.Collections.UnmodifiableList, java.util.List
        public List<E> subList(int fromIndex, int toIndex) {
            return new UnmodifiableRandomAccessList(this.list.subList(fromIndex, toIndex));
        }

        private Object writeReplace() {
            return new UnmodifiableList(this.list);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> Map<K, V> unmodifiableMap(Map<? extends K, ? extends V> map) {
        if (map.getClass() == UnmodifiableMap.class) {
            return map;
        }
        return new UnmodifiableMap(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class UnmodifiableMap<K, V> implements Map<K, V>, Serializable {
        private static final long serialVersionUID = -1034234728574286014L;
        private transient Set<Map.Entry<K, V>> entrySet;
        private transient Set<K> keySet;

        /* renamed from: m, reason: collision with root package name */
        private final Map<? extends K, ? extends V> f50451m;
        private transient Collection<V> values;

        UnmodifiableMap(Map<? extends K, ? extends V> m10) {
            if (m10 == null) {
                throw new NullPointerException();
            }
            this.f50451m = m10;
        }

        @Override // java.util.Map
        public int size() {
            return this.f50451m.size();
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.f50451m.isEmpty();
        }

        @Override // java.util.Map
        public boolean containsKey(Object key) {
            return this.f50451m.containsKey(key);
        }

        @Override // java.util.Map
        public boolean containsValue(Object val) {
            return this.f50451m.containsValue(val);
        }

        @Override // java.util.Map
        public V get(Object key) {
            return this.f50451m.get(key);
        }

        @Override // java.util.Map
        public V put(K key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public V remove(Object key) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> m10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        /* renamed from: keySet */
        public Set<K> h() {
            if (this.keySet == null) {
                this.keySet = Collections.unmodifiableSet(this.f50451m.h());
            }
            return this.keySet;
        }

        @Override // java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            if (this.entrySet == null) {
                this.entrySet = new UnmodifiableEntrySet(this.f50451m.entrySet());
            }
            return this.entrySet;
        }

        @Override // java.util.Map
        public Collection<V> values() {
            if (this.values == null) {
                this.values = Collections.unmodifiableCollection(this.f50451m.values());
            }
            return this.values;
        }

        @Override // java.util.Map
        public boolean equals(Object o10) {
            return o10 == this || this.f50451m.equals(o10);
        }

        @Override // java.util.Map
        public int hashCode() {
            return this.f50451m.hashCode();
        }

        public String toString() {
            return this.f50451m.toString();
        }

        @Override // java.util.Map
        public V getOrDefault(Object k10, V defaultValue) {
            return this.f50451m.getOrDefault(k10, defaultValue);
        }

        @Override // java.util.Map
        public void forEach(BiConsumer<? super K, ? super V> action) {
            this.f50451m.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public V putIfAbsent(K key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public boolean replace(K key, V oldValue, V newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public V replace(K key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static class UnmodifiableEntrySet<K, V> extends UnmodifiableSet<Map.Entry<K, V>> {
            private static final long serialVersionUID = 7854390611657943733L;

            UnmodifiableEntrySet(Set<? extends Map.Entry<? extends K, ? extends V>> s2) {
                super(s2);
            }

            static <K, V> Consumer<Map.Entry<? extends K, ? extends V>> entryConsumer(final Consumer<? super Map.Entry<K, V>> action) {
                return new Consumer() { // from class: java.util.Collections$UnmodifiableMap$UnmodifiableEntrySet$$ExternalSyntheticLambda0
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        Consumer.this.accept(new Collections.UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntry((Map.Entry) obj));
                    }
                };
            }

            @Override // java.util.Collections.UnmodifiableCollection, java.lang.Iterable
            public void forEach(Consumer<? super Map.Entry<K, V>> action) {
                Objects.requireNonNull(action);
                this.f50448c.forEach(entryConsumer(action));
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
            public static final class UnmodifiableEntrySetSpliterator<K, V> implements Spliterator<Map.Entry<K, V>> {

                /* renamed from: s, reason: collision with root package name */
                final Spliterator<Map.Entry<K, V>> f50454s;

                UnmodifiableEntrySetSpliterator(Spliterator<Map.Entry<K, V>> s2) {
                    this.f50454s = s2;
                }

                @Override // java.util.Spliterator
                public boolean tryAdvance(Consumer<? super Map.Entry<K, V>> action) {
                    Objects.requireNonNull(action);
                    return this.f50454s.tryAdvance(UnmodifiableEntrySet.entryConsumer(action));
                }

                @Override // java.util.Spliterator
                public void forEachRemaining(Consumer<? super Map.Entry<K, V>> action) {
                    Objects.requireNonNull(action);
                    this.f50454s.forEachRemaining(UnmodifiableEntrySet.entryConsumer(action));
                }

                @Override // java.util.Spliterator
                public Spliterator<Map.Entry<K, V>> trySplit() {
                    Spliterator<Map.Entry<K, V>> split = this.f50454s.trySplit();
                    if (split == null) {
                        return null;
                    }
                    return new UnmodifiableEntrySetSpliterator(split);
                }

                @Override // java.util.Spliterator
                public long estimateSize() {
                    return this.f50454s.estimateSize();
                }

                @Override // java.util.Spliterator
                public long getExactSizeIfKnown() {
                    return this.f50454s.getExactSizeIfKnown();
                }

                @Override // java.util.Spliterator
                public int characteristics() {
                    return this.f50454s.characteristics();
                }

                @Override // java.util.Spliterator
                public boolean hasCharacteristics(int characteristics) {
                    return this.f50454s.hasCharacteristics(characteristics);
                }

                @Override // java.util.Spliterator
                public Comparator<? super Map.Entry<K, V>> getComparator() {
                    return this.f50454s.getComparator();
                }
            }

            @Override // java.util.Collections.UnmodifiableCollection, java.util.Collection, java.lang.Iterable
            public Spliterator<Map.Entry<K, V>> spliterator() {
                return new UnmodifiableEntrySetSpliterator(this.f50448c.spliterator());
            }

            @Override // java.util.Collections.UnmodifiableCollection, java.util.Collection
            public Stream<Map.Entry<K, V>> stream() {
                return StreamSupport.stream(spliterator(), false);
            }

            @Override // java.util.Collections.UnmodifiableCollection, java.util.Collection
            public Stream<Map.Entry<K, V>> parallelStream() {
                return StreamSupport.stream(spliterator(), true);
            }

            @Override // java.util.Collections.UnmodifiableCollection, java.util.Collection, java.lang.Iterable
            /* renamed from: iterator */
            public Iterator<Map.Entry<K, V>> iterator2() {
                return new Iterator<Map.Entry<K, V>>() { // from class: java.util.Collections.UnmodifiableMap.UnmodifiableEntrySet.1

                    /* renamed from: i, reason: collision with root package name */
                    private final Iterator<? extends Map.Entry<? extends K, ? extends V>> f50452i;

                    {
                        this.f50452i = UnmodifiableEntrySet.this.f50448c.iterator2();
                    }

                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return this.f50452i.hasNext();
                    }

                    @Override // java.util.Iterator
                    public Map.Entry<K, V> next() {
                        return new UnmodifiableEntry(this.f50452i.next());
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }

                    @Override // java.util.Iterator
                    public void forEachRemaining(Consumer<? super Map.Entry<K, V>> action) {
                        this.f50452i.forEachRemaining(UnmodifiableEntrySet.entryConsumer(action));
                    }
                };
            }

            @Override // java.util.Collections.UnmodifiableCollection, java.util.Collection, java.util.Set
            public Object[] toArray() {
                Object[] a10 = this.f50448c.toArray();
                for (int i10 = 0; i10 < a10.length; i10++) {
                    a10[i10] = new UnmodifiableEntry((Map.Entry) a10[i10]);
                }
                return a10;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Collections.UnmodifiableCollection, java.util.Collection, java.util.Set
            public <T> T[] toArray(T[] tArr) {
                T[] tArr2 = (T[]) this.f50448c.toArray(tArr.length == 0 ? tArr : Arrays.copyOf(tArr, 0));
                for (int i10 = 0; i10 < tArr2.length; i10++) {
                    tArr2[i10] = new UnmodifiableEntry((Map.Entry) tArr2[i10]);
                }
                if (tArr2.length > tArr.length) {
                    return tArr2;
                }
                System.arraycopy(tArr2, 0, tArr, 0, tArr2.length);
                if (tArr.length > tArr2.length) {
                    tArr[tArr2.length] = null;
                }
                return tArr;
            }

            @Override // java.util.Collections.UnmodifiableCollection, java.util.Collection, java.util.Set
            public boolean contains(Object o10) {
                if (!(o10 instanceof Map.Entry)) {
                    return false;
                }
                return this.f50448c.contains(new UnmodifiableEntry((Map.Entry) o10));
            }

            @Override // java.util.Collections.UnmodifiableCollection, java.util.Collection, java.util.Set
            public boolean containsAll(Collection<?> coll) {
                for (Object e2 : coll) {
                    if (!contains(e2)) {
                        return false;
                    }
                }
                return true;
            }

            @Override // java.util.Collections.UnmodifiableSet, java.util.Collection, java.util.Set
            public boolean equals(Object o10) {
                if (o10 == this) {
                    return true;
                }
                if (!(o10 instanceof Set)) {
                    return false;
                }
                Set<?> s2 = (Set) o10;
                if (s2.size() != this.f50448c.size()) {
                    return false;
                }
                return containsAll(s2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
            public static class UnmodifiableEntry<K, V> implements Map.Entry<K, V> {

                /* renamed from: e, reason: collision with root package name */
                private Map.Entry<? extends K, ? extends V> f50453e;

                UnmodifiableEntry(Map.Entry<? extends K, ? extends V> e2) {
                    this.f50453e = (Map.Entry) Objects.requireNonNull(e2);
                }

                @Override // java.util.Map.Entry
                public K getKey() {
                    return this.f50453e.getKey();
                }

                @Override // java.util.Map.Entry
                public V getValue() {
                    return this.f50453e.getValue();
                }

                @Override // java.util.Map.Entry
                public V setValue(V value) {
                    throw new UnsupportedOperationException();
                }

                @Override // java.util.Map.Entry
                public int hashCode() {
                    return this.f50453e.hashCode();
                }

                @Override // java.util.Map.Entry
                public boolean equals(Object o10) {
                    if (this == o10) {
                        return true;
                    }
                    if (!(o10 instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry<?, ?> t2 = (Map.Entry) o10;
                    return Collections.eq(this.f50453e.getKey(), t2.getKey()) && Collections.eq(this.f50453e.getValue(), t2.getValue());
                }

                public String toString() {
                    return this.f50453e.toString();
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> SortedMap<K, V> unmodifiableSortedMap(SortedMap<K, ? extends V> sortedMap) {
        if (sortedMap.getClass() == UnmodifiableSortedMap.class) {
            return sortedMap;
        }
        return new UnmodifiableSortedMap(sortedMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class UnmodifiableSortedMap<K, V> extends UnmodifiableMap<K, V> implements SortedMap<K, V>, Serializable {
        private static final long serialVersionUID = -8806743815996713206L;
        private final SortedMap<K, ? extends V> sm;

        UnmodifiableSortedMap(SortedMap<K, ? extends V> m10) {
            super(m10);
            this.sm = m10;
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.sm.comparator();
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            return new UnmodifiableSortedMap(this.sm.subMap(fromKey, toKey));
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> headMap(K toKey) {
            return new UnmodifiableSortedMap(this.sm.headMap(toKey));
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> tailMap(K fromKey) {
            return new UnmodifiableSortedMap(this.sm.tailMap(fromKey));
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return this.sm.firstKey();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return this.sm.lastKey();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> NavigableMap<K, V> unmodifiableNavigableMap(NavigableMap<K, ? extends V> navigableMap) {
        if (navigableMap.getClass() == UnmodifiableNavigableMap.class) {
            return navigableMap;
        }
        return new UnmodifiableNavigableMap(navigableMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class UnmodifiableNavigableMap<K, V> extends UnmodifiableSortedMap<K, V> implements NavigableMap<K, V>, Serializable {
        private static final EmptyNavigableMap<?, ?> EMPTY_NAVIGABLE_MAP = new EmptyNavigableMap<>();
        private static final long serialVersionUID = -4858195264774772197L;
        private final NavigableMap<K, ? extends V> nm;

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        private static class EmptyNavigableMap<K, V> extends UnmodifiableNavigableMap<K, V> implements Serializable {
            private static final long serialVersionUID = -2239321462712562324L;

            EmptyNavigableMap() {
                super(new TreeMap());
            }

            @Override // java.util.Collections.UnmodifiableNavigableMap, java.util.NavigableMap
            public NavigableSet<K> navigableKeySet() {
                return Collections.emptyNavigableSet();
            }

            private Object readResolve() {
                return UnmodifiableNavigableMap.EMPTY_NAVIGABLE_MAP;
            }
        }

        UnmodifiableNavigableMap(NavigableMap<K, ? extends V> m10) {
            super(m10);
            this.nm = m10;
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K key) {
            return this.nm.lowerKey(key);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K key) {
            return this.nm.floorKey(key);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K key) {
            return this.nm.ceilingKey(key);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K key) {
            return this.nm.higherKey(key);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K key) {
            Map.Entry<K, ? extends V> lowerEntry = this.nm.lowerEntry(key);
            if (lowerEntry != null) {
                return new UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntry(lowerEntry);
            }
            return null;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K key) {
            Map.Entry<K, ? extends V> floorEntry = this.nm.floorEntry(key);
            if (floorEntry != null) {
                return new UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntry(floorEntry);
            }
            return null;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K key) {
            Map.Entry<K, ? extends V> ceilingEntry = this.nm.ceilingEntry(key);
            if (ceilingEntry != null) {
                return new UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntry(ceilingEntry);
            }
            return null;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K key) {
            Map.Entry<K, ? extends V> higherEntry = this.nm.higherEntry(key);
            if (higherEntry != null) {
                return new UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntry(higherEntry);
            }
            return null;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            Map.Entry<K, ? extends V> firstEntry = this.nm.firstEntry();
            if (firstEntry != null) {
                return new UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntry(firstEntry);
            }
            return null;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            Map.Entry<K, ? extends V> lastEntry = this.nm.lastEntry();
            if (lastEntry != null) {
                return new UnmodifiableMap.UnmodifiableEntrySet.UnmodifiableEntry(lastEntry);
            }
            return null;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return Collections.unmodifiableNavigableMap(this.nm.descendingMap());
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return Collections.unmodifiableNavigableSet(this.nm.navigableKeySet());
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return Collections.unmodifiableNavigableSet(this.nm.descendingKeySet());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
            return Collections.unmodifiableNavigableMap(this.nm.subMap(fromKey, fromInclusive, toKey, toInclusive));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {
            return Collections.unmodifiableNavigableMap(this.nm.headMap(toKey, inclusive));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
            return Collections.unmodifiableNavigableMap(this.nm.tailMap(fromKey, inclusive));
        }
    }

    public static <T> Collection<T> synchronizedCollection(Collection<T> c4) {
        return new SynchronizedCollection(c4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Collection<T> synchronizedCollection(Collection<T> c4, Object mutex) {
        return new SynchronizedCollection(c4, mutex);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class SynchronizedCollection<E> implements Collection<E>, Serializable {
        private static final long serialVersionUID = 3053995032091335093L;

        /* renamed from: c, reason: collision with root package name */
        final Collection<E> f50446c;
        final Object mutex;

        SynchronizedCollection(Collection<E> c4) {
            this.f50446c = (Collection) Objects.requireNonNull(c4);
            this.mutex = this;
        }

        SynchronizedCollection(Collection<E> c4, Object mutex) {
            this.f50446c = (Collection) Objects.requireNonNull(c4);
            this.mutex = Objects.requireNonNull(mutex);
        }

        @Override // java.util.Collection, java.util.Set
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = this.f50446c.size();
            }
            return size;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = this.f50446c.isEmpty();
            }
            return isEmpty;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            boolean contains;
            synchronized (this.mutex) {
                contains = this.f50446c.contains(o10);
            }
            return contains;
        }

        @Override // java.util.Collection, java.util.Set
        public Object[] toArray() {
            Object[] array;
            synchronized (this.mutex) {
                array = this.f50446c.toArray();
            }
            return array;
        }

        @Override // java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            T[] tArr2;
            synchronized (this.mutex) {
                tArr2 = (T[]) this.f50446c.toArray(tArr);
            }
            return tArr2;
        }

        @Override // java.util.Collection
        public <T> T[] toArray(IntFunction<T[]> intFunction) {
            T[] tArr;
            synchronized (this.mutex) {
                tArr = (T[]) this.f50446c.toArray(intFunction);
            }
            return tArr;
        }

        @Override // java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<E> iterator2() {
            return this.f50446c.iterator2();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean add(E e2) {
            boolean add;
            synchronized (this.mutex) {
                add = this.f50446c.add(e2);
            }
            return add;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            boolean remove;
            synchronized (this.mutex) {
                remove = this.f50446c.remove(o10);
            }
            return remove;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> coll) {
            boolean containsAll;
            synchronized (this.mutex) {
                containsAll = this.f50446c.containsAll(coll);
            }
            return containsAll;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends E> coll) {
            boolean addAll;
            synchronized (this.mutex) {
                addAll = this.f50446c.addAll(coll);
            }
            return addAll;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> coll) {
            boolean removeAll;
            synchronized (this.mutex) {
                removeAll = this.f50446c.removeAll(coll);
            }
            return removeAll;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> coll) {
            boolean retainAll;
            synchronized (this.mutex) {
                retainAll = this.f50446c.retainAll(coll);
            }
            return retainAll;
        }

        @Override // java.util.Collection, java.util.Set
        public void clear() {
            synchronized (this.mutex) {
                this.f50446c.clear();
            }
        }

        public String toString() {
            String obj;
            synchronized (this.mutex) {
                obj = this.f50446c.toString();
            }
            return obj;
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super E> consumer) {
            synchronized (this.mutex) {
                this.f50446c.forEach(consumer);
            }
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super E> filter) {
            boolean removeIf;
            synchronized (this.mutex) {
                removeIf = this.f50446c.removeIf(filter);
            }
            return removeIf;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<E> spliterator() {
            return this.f50446c.spliterator();
        }

        @Override // java.util.Collection
        public Stream<E> stream() {
            return this.f50446c.stream();
        }

        @Override // java.util.Collection
        public Stream<E> parallelStream() {
            return this.f50446c.parallelStream();
        }

        private void writeObject(ObjectOutputStream s2) throws IOException {
            synchronized (this.mutex) {
                s2.defaultWriteObject();
            }
        }
    }

    public static <T> Set<T> synchronizedSet(Set<T> s2) {
        return new SynchronizedSet(s2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Set<T> synchronizedSet(Set<T> s2, Object mutex) {
        return new SynchronizedSet(s2, mutex);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
        private static final long serialVersionUID = 487447009682186044L;

        SynchronizedSet(Set<E> s2) {
            super(s2);
        }

        SynchronizedSet(Set<E> s2, Object mutex) {
            super(s2, mutex);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object o10) {
            boolean equals;
            if (this == o10) {
                return true;
            }
            synchronized (this.mutex) {
                equals = this.f50446c.equals(o10);
            }
            return equals;
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = this.f50446c.hashCode();
            }
            return hashCode;
        }
    }

    public static <T> SortedSet<T> synchronizedSortedSet(SortedSet<T> s2) {
        return new SynchronizedSortedSet(s2);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
        private static final long serialVersionUID = 8695801310862127406L;
        private final SortedSet<E> ss;

        SynchronizedSortedSet(SortedSet<E> s2) {
            super(s2);
            this.ss = s2;
        }

        SynchronizedSortedSet(SortedSet<E> s2, Object mutex) {
            super(s2, mutex);
            this.ss = s2;
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            Comparator<? super E> comparator;
            synchronized (this.mutex) {
                comparator = this.ss.comparator();
            }
            return comparator;
        }

        public SortedSet<E> subSet(E fromElement, E toElement) {
            SynchronizedSortedSet synchronizedSortedSet;
            synchronized (this.mutex) {
                synchronizedSortedSet = new SynchronizedSortedSet(this.ss.subSet(fromElement, toElement), this.mutex);
            }
            return synchronizedSortedSet;
        }

        public SortedSet<E> headSet(E toElement) {
            SynchronizedSortedSet synchronizedSortedSet;
            synchronized (this.mutex) {
                synchronizedSortedSet = new SynchronizedSortedSet(this.ss.headSet(toElement), this.mutex);
            }
            return synchronizedSortedSet;
        }

        public SortedSet<E> tailSet(E fromElement) {
            SynchronizedSortedSet synchronizedSortedSet;
            synchronized (this.mutex) {
                synchronizedSortedSet = new SynchronizedSortedSet(this.ss.tailSet(fromElement), this.mutex);
            }
            return synchronizedSortedSet;
        }

        @Override // java.util.SortedSet
        public E first() {
            E first;
            synchronized (this.mutex) {
                first = this.ss.first();
            }
            return first;
        }

        @Override // java.util.SortedSet
        public E last() {
            E last;
            synchronized (this.mutex) {
                last = this.ss.last();
            }
            return last;
        }
    }

    public static <T> NavigableSet<T> synchronizedNavigableSet(NavigableSet<T> s2) {
        return new SynchronizedNavigableSet(s2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class SynchronizedNavigableSet<E> extends SynchronizedSortedSet<E> implements NavigableSet<E> {
        private static final long serialVersionUID = -5505529816273629798L;
        private final NavigableSet<E> ns;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Collections.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public /* bridge */ /* synthetic */ SortedSet headSet(Object obj) {
            return headSet((SynchronizedNavigableSet<E>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Collections.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public /* bridge */ /* synthetic */ SortedSet tailSet(Object obj) {
            return tailSet((SynchronizedNavigableSet<E>) obj);
        }

        SynchronizedNavigableSet(NavigableSet<E> s2) {
            super(s2);
            this.ns = s2;
        }

        SynchronizedNavigableSet(NavigableSet<E> s2, Object mutex) {
            super(s2, mutex);
            this.ns = s2;
        }

        @Override // java.util.NavigableSet
        public E lower(E e2) {
            E lower;
            synchronized (this.mutex) {
                lower = this.ns.lower(e2);
            }
            return lower;
        }

        @Override // java.util.NavigableSet
        public E floor(E e2) {
            E floor;
            synchronized (this.mutex) {
                floor = this.ns.floor(e2);
            }
            return floor;
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e2) {
            E ceiling;
            synchronized (this.mutex) {
                ceiling = this.ns.ceiling(e2);
            }
            return ceiling;
        }

        @Override // java.util.NavigableSet
        public E higher(E e2) {
            E higher;
            synchronized (this.mutex) {
                higher = this.ns.higher(e2);
            }
            return higher;
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            E pollFirst;
            synchronized (this.mutex) {
                pollFirst = this.ns.pollFirst();
            }
            return pollFirst;
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            E pollLast;
            synchronized (this.mutex) {
                pollLast = this.ns.pollLast();
            }
            return pollLast;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            SynchronizedNavigableSet synchronizedNavigableSet;
            synchronized (this.mutex) {
                synchronizedNavigableSet = new SynchronizedNavigableSet(this.ns.descendingSet(), this.mutex);
            }
            return synchronizedNavigableSet;
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            Iterator<E> iterator2;
            synchronized (this.mutex) {
                iterator2 = descendingSet().iterator2();
            }
            return iterator2;
        }

        @Override // java.util.Collections.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public NavigableSet<E> subSet(E fromElement, E toElement) {
            SynchronizedNavigableSet synchronizedNavigableSet;
            synchronized (this.mutex) {
                synchronizedNavigableSet = new SynchronizedNavigableSet(this.ns.subSet(fromElement, true, toElement, false), this.mutex);
            }
            return synchronizedNavigableSet;
        }

        @Override // java.util.Collections.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public NavigableSet<E> headSet(E toElement) {
            SynchronizedNavigableSet synchronizedNavigableSet;
            synchronized (this.mutex) {
                synchronizedNavigableSet = new SynchronizedNavigableSet(this.ns.headSet(toElement, false), this.mutex);
            }
            return synchronizedNavigableSet;
        }

        @Override // java.util.Collections.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public NavigableSet<E> tailSet(E fromElement) {
            SynchronizedNavigableSet synchronizedNavigableSet;
            synchronized (this.mutex) {
                synchronizedNavigableSet = new SynchronizedNavigableSet(this.ns.tailSet(fromElement, true), this.mutex);
            }
            return synchronizedNavigableSet;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
            SynchronizedNavigableSet synchronizedNavigableSet;
            synchronized (this.mutex) {
                synchronizedNavigableSet = new SynchronizedNavigableSet(this.ns.subSet(fromElement, fromInclusive, toElement, toInclusive), this.mutex);
            }
            return synchronizedNavigableSet;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E toElement, boolean inclusive) {
            SynchronizedNavigableSet synchronizedNavigableSet;
            synchronized (this.mutex) {
                synchronizedNavigableSet = new SynchronizedNavigableSet(this.ns.headSet(toElement, inclusive), this.mutex);
            }
            return synchronizedNavigableSet;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
            SynchronizedNavigableSet synchronizedNavigableSet;
            synchronized (this.mutex) {
                synchronizedNavigableSet = new SynchronizedNavigableSet(this.ns.tailSet(fromElement, inclusive), this.mutex);
            }
            return synchronizedNavigableSet;
        }
    }

    public static <T> List<T> synchronizedList(List<T> list) {
        if (list instanceof RandomAccess) {
            return new SynchronizedRandomAccessList(list);
        }
        return new SynchronizedList(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> List<T> synchronizedList(List<T> list, Object mutex) {
        if (list instanceof RandomAccess) {
            return new SynchronizedRandomAccessList(list, mutex);
        }
        return new SynchronizedList(list, mutex);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
        private static final long serialVersionUID = -7754090372962971524L;
        final List<E> list;

        SynchronizedList(List<E> list) {
            super(list);
            this.list = list;
        }

        SynchronizedList(List<E> list, Object mutex) {
            super(list, mutex);
            this.list = list;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object o10) {
            boolean equals;
            if (this == o10) {
                return true;
            }
            synchronized (this.mutex) {
                equals = this.list.equals(o10);
            }
            return equals;
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = this.list.hashCode();
            }
            return hashCode;
        }

        @Override // java.util.List
        public E get(int index) {
            E e2;
            synchronized (this.mutex) {
                e2 = this.list.get(index);
            }
            return e2;
        }

        @Override // java.util.List
        public E set(int index, E element) {
            E e2;
            synchronized (this.mutex) {
                e2 = this.list.set(index, element);
            }
            return e2;
        }

        @Override // java.util.List
        public void add(int index, E element) {
            synchronized (this.mutex) {
                this.list.add(index, element);
            }
        }

        @Override // java.util.List
        public E remove(int index) {
            E remove;
            synchronized (this.mutex) {
                remove = this.list.remove(index);
            }
            return remove;
        }

        @Override // java.util.List
        public int indexOf(Object o10) {
            int indexOf;
            synchronized (this.mutex) {
                indexOf = this.list.indexOf(o10);
            }
            return indexOf;
        }

        @Override // java.util.List
        public int lastIndexOf(Object o10) {
            int lastIndexOf;
            synchronized (this.mutex) {
                lastIndexOf = this.list.lastIndexOf(o10);
            }
            return lastIndexOf;
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends E> c4) {
            boolean addAll;
            synchronized (this.mutex) {
                addAll = this.list.addAll(index, c4);
            }
            return addAll;
        }

        @Override // java.util.List
        public ListIterator<E> listIterator() {
            return this.list.listIterator();
        }

        @Override // java.util.List
        public ListIterator<E> listIterator(int index) {
            return this.list.listIterator(index);
        }

        @Override // java.util.List
        public List<E> subList(int fromIndex, int toIndex) {
            SynchronizedList synchronizedList;
            synchronized (this.mutex) {
                synchronizedList = new SynchronizedList(this.list.subList(fromIndex, toIndex), this.mutex);
            }
            return synchronizedList;
        }

        @Override // java.util.List
        public void replaceAll(UnaryOperator<E> operator) {
            synchronized (this.mutex) {
                this.list.replaceAll(operator);
            }
        }

        @Override // java.util.List
        public void sort(Comparator<? super E> c4) {
            synchronized (this.mutex) {
                this.list.sort(c4);
            }
        }

        private Object readResolve() {
            List<E> list = this.list;
            if (list instanceof RandomAccess) {
                return new SynchronizedRandomAccessList(list);
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
        private static final long serialVersionUID = 1530674583602358482L;

        SynchronizedRandomAccessList(List<E> list) {
            super(list);
        }

        SynchronizedRandomAccessList(List<E> list, Object mutex) {
            super(list, mutex);
        }

        @Override // java.util.Collections.SynchronizedList, java.util.List
        public List<E> subList(int fromIndex, int toIndex) {
            SynchronizedRandomAccessList synchronizedRandomAccessList;
            synchronized (this.mutex) {
                synchronizedRandomAccessList = new SynchronizedRandomAccessList(this.list.subList(fromIndex, toIndex), this.mutex);
            }
            return synchronizedRandomAccessList;
        }

        private Object writeReplace() {
            return new SynchronizedList(this.list);
        }
    }

    public static <K, V> Map<K, V> synchronizedMap(Map<K, V> m10) {
        return new SynchronizedMap(m10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class SynchronizedMap<K, V> implements Map<K, V>, Serializable {
        private static final long serialVersionUID = 1978198479659022715L;
        private transient Set<Map.Entry<K, V>> entrySet;
        private transient Set<K> keySet;

        /* renamed from: m, reason: collision with root package name */
        private final Map<K, V> f50447m;
        final Object mutex;
        private transient Collection<V> values;

        SynchronizedMap(Map<K, V> m10) {
            this.f50447m = (Map) Objects.requireNonNull(m10);
            this.mutex = this;
        }

        SynchronizedMap(Map<K, V> m10, Object mutex) {
            this.f50447m = m10;
            this.mutex = mutex;
        }

        @Override // java.util.Map
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = this.f50447m.size();
            }
            return size;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = this.f50447m.isEmpty();
            }
            return isEmpty;
        }

        @Override // java.util.Map
        public boolean containsKey(Object key) {
            boolean containsKey;
            synchronized (this.mutex) {
                containsKey = this.f50447m.containsKey(key);
            }
            return containsKey;
        }

        @Override // java.util.Map
        public boolean containsValue(Object value) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = this.f50447m.containsValue(value);
            }
            return containsValue;
        }

        @Override // java.util.Map
        public V get(Object key) {
            V v2;
            synchronized (this.mutex) {
                v2 = this.f50447m.get(key);
            }
            return v2;
        }

        @Override // java.util.Map
        public V put(K key, V value) {
            V put;
            synchronized (this.mutex) {
                put = this.f50447m.put(key, value);
            }
            return put;
        }

        @Override // java.util.Map
        public V remove(Object key) {
            V remove;
            synchronized (this.mutex) {
                remove = this.f50447m.remove(key);
            }
            return remove;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            synchronized (this.mutex) {
                this.f50447m.putAll(map);
            }
        }

        @Override // java.util.Map
        public void clear() {
            synchronized (this.mutex) {
                this.f50447m.clear();
            }
        }

        @Override // java.util.Map
        /* renamed from: keySet */
        public Set<K> h() {
            Set<K> set;
            synchronized (this.mutex) {
                if (this.keySet == null) {
                    this.keySet = new SynchronizedSet(this.f50447m.h(), this.mutex);
                }
                set = this.keySet;
            }
            return set;
        }

        @Override // java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set;
            synchronized (this.mutex) {
                if (this.entrySet == null) {
                    this.entrySet = new SynchronizedSet(this.f50447m.entrySet(), this.mutex);
                }
                set = this.entrySet;
            }
            return set;
        }

        @Override // java.util.Map
        public Collection<V> values() {
            Collection<V> collection;
            synchronized (this.mutex) {
                if (this.values == null) {
                    this.values = new SynchronizedCollection(this.f50447m.values(), this.mutex);
                }
                collection = this.values;
            }
            return collection;
        }

        @Override // java.util.Map
        public boolean equals(Object o10) {
            boolean equals;
            if (this == o10) {
                return true;
            }
            synchronized (this.mutex) {
                equals = this.f50447m.equals(o10);
            }
            return equals;
        }

        @Override // java.util.Map
        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = this.f50447m.hashCode();
            }
            return hashCode;
        }

        public String toString() {
            String obj;
            synchronized (this.mutex) {
                obj = this.f50447m.toString();
            }
            return obj;
        }

        @Override // java.util.Map
        public V getOrDefault(Object k10, V defaultValue) {
            V orDefault;
            synchronized (this.mutex) {
                orDefault = this.f50447m.getOrDefault(k10, defaultValue);
            }
            return orDefault;
        }

        @Override // java.util.Map
        public void forEach(BiConsumer<? super K, ? super V> action) {
            synchronized (this.mutex) {
                this.f50447m.forEach(action);
            }
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
            synchronized (this.mutex) {
                this.f50447m.replaceAll(function);
            }
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public V putIfAbsent(K key, V value) {
            V putIfAbsent;
            synchronized (this.mutex) {
                putIfAbsent = this.f50447m.putIfAbsent(key, value);
            }
            return putIfAbsent;
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public boolean remove(Object key, Object value) {
            boolean remove;
            synchronized (this.mutex) {
                remove = this.f50447m.remove(key, value);
            }
            return remove;
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public boolean replace(K key, V oldValue, V newValue) {
            boolean replace;
            synchronized (this.mutex) {
                replace = this.f50447m.replace(key, oldValue, newValue);
            }
            return replace;
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public V replace(K key, V value) {
            V replace;
            synchronized (this.mutex) {
                replace = this.f50447m.replace(key, value);
            }
            return replace;
        }

        @Override // java.util.Map
        public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
            V computeIfAbsent;
            synchronized (this.mutex) {
                computeIfAbsent = this.f50447m.computeIfAbsent(key, mappingFunction);
            }
            return computeIfAbsent;
        }

        @Override // java.util.Map
        public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
            V computeIfPresent;
            synchronized (this.mutex) {
                computeIfPresent = this.f50447m.computeIfPresent(key, remappingFunction);
            }
            return computeIfPresent;
        }

        @Override // java.util.Map
        public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
            V compute;
            synchronized (this.mutex) {
                compute = this.f50447m.compute(key, remappingFunction);
            }
            return compute;
        }

        @Override // java.util.Map
        public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            V merge;
            synchronized (this.mutex) {
                merge = this.f50447m.merge(key, value, remappingFunction);
            }
            return merge;
        }

        private void writeObject(ObjectOutputStream s2) throws IOException {
            synchronized (this.mutex) {
                s2.defaultWriteObject();
            }
        }
    }

    public static <K, V> SortedMap<K, V> synchronizedSortedMap(SortedMap<K, V> m10) {
        return new SynchronizedSortedMap(m10);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V> {
        private static final long serialVersionUID = -8798146769416483793L;
        private final SortedMap<K, V> sm;

        SynchronizedSortedMap(SortedMap<K, V> m10) {
            super(m10);
            this.sm = m10;
        }

        SynchronizedSortedMap(SortedMap<K, V> m10, Object mutex) {
            super(m10, mutex);
            this.sm = m10;
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.mutex) {
                comparator = this.sm.comparator();
            }
            return comparator;
        }

        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            SynchronizedSortedMap synchronizedSortedMap;
            synchronized (this.mutex) {
                synchronizedSortedMap = new SynchronizedSortedMap(this.sm.subMap(fromKey, toKey), this.mutex);
            }
            return synchronizedSortedMap;
        }

        public SortedMap<K, V> headMap(K toKey) {
            SynchronizedSortedMap synchronizedSortedMap;
            synchronized (this.mutex) {
                synchronizedSortedMap = new SynchronizedSortedMap(this.sm.headMap(toKey), this.mutex);
            }
            return synchronizedSortedMap;
        }

        public SortedMap<K, V> tailMap(K fromKey) {
            SynchronizedSortedMap synchronizedSortedMap;
            synchronized (this.mutex) {
                synchronizedSortedMap = new SynchronizedSortedMap(this.sm.tailMap(fromKey), this.mutex);
            }
            return synchronizedSortedMap;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            K firstKey;
            synchronized (this.mutex) {
                firstKey = this.sm.firstKey();
            }
            return firstKey;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            K lastKey;
            synchronized (this.mutex) {
                lastKey = this.sm.lastKey();
            }
            return lastKey;
        }
    }

    public static <K, V> NavigableMap<K, V> synchronizedNavigableMap(NavigableMap<K, V> m10) {
        return new SynchronizedNavigableMap(m10);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class SynchronizedNavigableMap<K, V> extends SynchronizedSortedMap<K, V> implements NavigableMap<K, V> {
        private static final long serialVersionUID = 699392247599746807L;
        private final NavigableMap<K, V> nm;

        SynchronizedNavigableMap(NavigableMap<K, V> m10) {
            super(m10);
            this.nm = m10;
        }

        SynchronizedNavigableMap(NavigableMap<K, V> m10, Object mutex) {
            super(m10, mutex);
            this.nm = m10;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K key) {
            Map.Entry<K, V> lowerEntry;
            synchronized (this.mutex) {
                lowerEntry = this.nm.lowerEntry(key);
            }
            return lowerEntry;
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K key) {
            K lowerKey;
            synchronized (this.mutex) {
                lowerKey = this.nm.lowerKey(key);
            }
            return lowerKey;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K key) {
            Map.Entry<K, V> floorEntry;
            synchronized (this.mutex) {
                floorEntry = this.nm.floorEntry(key);
            }
            return floorEntry;
        }

        @Override // java.util.NavigableMap
        public K floorKey(K key) {
            K floorKey;
            synchronized (this.mutex) {
                floorKey = this.nm.floorKey(key);
            }
            return floorKey;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K key) {
            Map.Entry<K, V> ceilingEntry;
            synchronized (this.mutex) {
                ceilingEntry = this.nm.ceilingEntry(key);
            }
            return ceilingEntry;
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K key) {
            K ceilingKey;
            synchronized (this.mutex) {
                ceilingKey = this.nm.ceilingKey(key);
            }
            return ceilingKey;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K key) {
            Map.Entry<K, V> higherEntry;
            synchronized (this.mutex) {
                higherEntry = this.nm.higherEntry(key);
            }
            return higherEntry;
        }

        @Override // java.util.NavigableMap
        public K higherKey(K key) {
            K higherKey;
            synchronized (this.mutex) {
                higherKey = this.nm.higherKey(key);
            }
            return higherKey;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            Map.Entry<K, V> firstEntry;
            synchronized (this.mutex) {
                firstEntry = this.nm.firstEntry();
            }
            return firstEntry;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            Map.Entry<K, V> lastEntry;
            synchronized (this.mutex) {
                lastEntry = this.nm.lastEntry();
            }
            return lastEntry;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            Map.Entry<K, V> pollFirstEntry;
            synchronized (this.mutex) {
                pollFirstEntry = this.nm.pollFirstEntry();
            }
            return pollFirstEntry;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            Map.Entry<K, V> pollLastEntry;
            synchronized (this.mutex) {
                pollLastEntry = this.nm.pollLastEntry();
            }
            return pollLastEntry;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            SynchronizedNavigableMap synchronizedNavigableMap;
            synchronized (this.mutex) {
                synchronizedNavigableMap = new SynchronizedNavigableMap(this.nm.descendingMap(), this.mutex);
            }
            return synchronizedNavigableMap;
        }

        @Override // java.util.Collections.SynchronizedMap, java.util.Map
        /* renamed from: keySet */
        public NavigableSet<K> h() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            SynchronizedNavigableSet synchronizedNavigableSet;
            synchronized (this.mutex) {
                synchronizedNavigableSet = new SynchronizedNavigableSet(this.nm.navigableKeySet(), this.mutex);
            }
            return synchronizedNavigableSet;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            SynchronizedNavigableSet synchronizedNavigableSet;
            synchronized (this.mutex) {
                synchronizedNavigableSet = new SynchronizedNavigableSet(this.nm.descendingKeySet(), this.mutex);
            }
            return synchronizedNavigableSet;
        }

        @Override // java.util.Collections.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            SynchronizedNavigableMap synchronizedNavigableMap;
            synchronized (this.mutex) {
                synchronizedNavigableMap = new SynchronizedNavigableMap(this.nm.subMap(fromKey, true, toKey, false), this.mutex);
            }
            return synchronizedNavigableMap;
        }

        @Override // java.util.Collections.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> headMap(K toKey) {
            SynchronizedNavigableMap synchronizedNavigableMap;
            synchronized (this.mutex) {
                synchronizedNavigableMap = new SynchronizedNavigableMap(this.nm.headMap(toKey, false), this.mutex);
            }
            return synchronizedNavigableMap;
        }

        @Override // java.util.Collections.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> tailMap(K fromKey) {
            SynchronizedNavigableMap synchronizedNavigableMap;
            synchronized (this.mutex) {
                synchronizedNavigableMap = new SynchronizedNavigableMap(this.nm.tailMap(fromKey, true), this.mutex);
            }
            return synchronizedNavigableMap;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
            SynchronizedNavigableMap synchronizedNavigableMap;
            synchronized (this.mutex) {
                synchronizedNavigableMap = new SynchronizedNavigableMap(this.nm.subMap(fromKey, fromInclusive, toKey, toInclusive), this.mutex);
            }
            return synchronizedNavigableMap;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {
            SynchronizedNavigableMap synchronizedNavigableMap;
            synchronized (this.mutex) {
                synchronizedNavigableMap = new SynchronizedNavigableMap(this.nm.headMap(toKey, inclusive), this.mutex);
            }
            return synchronizedNavigableMap;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
            SynchronizedNavigableMap synchronizedNavigableMap;
            synchronized (this.mutex) {
                synchronizedNavigableMap = new SynchronizedNavigableMap(this.nm.tailMap(fromKey, inclusive), this.mutex);
            }
            return synchronizedNavigableMap;
        }
    }

    public static <E> Collection<E> checkedCollection(Collection<E> c4, Class<E> type) {
        return new CheckedCollection(c4, type);
    }

    static <T> T[] zeroLengthArray(Class<T> cls) {
        return (T[]) ((Object[]) Array.newInstance((Class<?>) cls, 0));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class CheckedCollection<E> implements Collection<E>, Serializable {
        private static final long serialVersionUID = 1578914078182001775L;

        /* renamed from: c, reason: collision with root package name */
        final Collection<E> f50437c;
        final Class<E> type;
        private E[] zeroLengthElementArray;

        /* JADX WARN: Multi-variable type inference failed */
        E typeCheck(Object obj) {
            if (obj != 0 && !this.type.isInstance(obj)) {
                throw new ClassCastException(badElementMsg(obj));
            }
            return obj;
        }

        private String badElementMsg(Object o10) {
            return "Attempt to insert " + ((Object) o10.getClass()) + " element into collection with element type " + ((Object) this.type);
        }

        CheckedCollection(Collection<E> c4, Class<E> type) {
            this.f50437c = (Collection) Objects.requireNonNull(c4, "c");
            this.type = (Class) Objects.requireNonNull(type, "type");
        }

        @Override // java.util.Collection, java.util.Set
        public int size() {
            return this.f50437c.size();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f50437c.isEmpty();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            return this.f50437c.contains(o10);
        }

        @Override // java.util.Collection, java.util.Set
        public Object[] toArray() {
            return this.f50437c.toArray();
        }

        @Override // java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) this.f50437c.toArray(tArr);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(IntFunction<T[]> intFunction) {
            return (T[]) this.f50437c.toArray(intFunction);
        }

        public String toString() {
            return this.f50437c.toString();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            return this.f50437c.remove(o10);
        }

        @Override // java.util.Collection, java.util.Set
        public void clear() {
            this.f50437c.clear();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> coll) {
            return this.f50437c.containsAll(coll);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> coll) {
            return this.f50437c.removeAll(coll);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> coll) {
            return this.f50437c.retainAll(coll);
        }

        @Override // java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<E> iterator2() {
            final Iterator<E> it = this.f50437c.iterator2();
            return new Iterator<E>() { // from class: java.util.Collections.CheckedCollection.1
                @Override // java.util.Iterator
                public boolean hasNext() {
                    return it.hasNext();
                }

                @Override // java.util.Iterator
                public E next() {
                    return (E) it.next();
                }

                @Override // java.util.Iterator
                public void remove() {
                    it.remove();
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super E> action) {
                    it.forEachRemaining(action);
                }
            };
        }

        @Override // java.util.Collection, java.util.Set
        public boolean add(E e2) {
            return this.f50437c.add(typeCheck(e2));
        }

        private E[] zeroLengthElementArray() {
            E[] eArr = this.zeroLengthElementArray;
            if (eArr != null) {
                return eArr;
            }
            E[] eArr2 = (E[]) Collections.zeroLengthArray(this.type);
            this.zeroLengthElementArray = eArr2;
            return eArr2;
        }

        Collection<E> checkedCopyOf(Collection<? extends E> coll) {
            Object[] a10;
            try {
                E[] z10 = zeroLengthElementArray();
                a10 = coll.toArray(z10);
                if (a10.getClass() != z10.getClass()) {
                    a10 = Arrays.copyOf(a10, a10.length, z10.getClass());
                }
            } catch (ArrayStoreException e2) {
                a10 = (Object[]) coll.toArray().clone();
                for (Object o10 : a10) {
                    typeCheck(o10);
                }
            }
            return Arrays.asList(a10);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends E> coll) {
            return this.f50437c.addAll(checkedCopyOf(coll));
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super E> action) {
            this.f50437c.forEach(action);
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super E> filter) {
            return this.f50437c.removeIf(filter);
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<E> spliterator() {
            return this.f50437c.spliterator();
        }

        @Override // java.util.Collection
        public Stream<E> stream() {
            return this.f50437c.stream();
        }

        @Override // java.util.Collection
        public Stream<E> parallelStream() {
            return this.f50437c.parallelStream();
        }
    }

    public static <E> Queue<E> checkedQueue(Queue<E> queue, Class<E> type) {
        return new CheckedQueue(queue, type);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class CheckedQueue<E> extends CheckedCollection<E> implements Queue<E>, Serializable {
        private static final long serialVersionUID = 1433151992604707767L;
        final Queue<E> queue;

        CheckedQueue(Queue<E> queue, Class<E> elementType) {
            super(queue, elementType);
            this.queue = queue;
        }

        @Override // java.util.Queue
        public E element() {
            return this.queue.element();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object o10) {
            return o10 == this || this.f50437c.equals(o10);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return this.f50437c.hashCode();
        }

        @Override // java.util.Queue
        public E peek() {
            return this.queue.peek();
        }

        @Override // java.util.Queue
        public E poll() {
            return this.queue.poll();
        }

        @Override // java.util.Queue
        public E remove() {
            return this.queue.remove();
        }

        @Override // java.util.Queue, java.util.concurrent.BlockingQueue
        public boolean offer(E e2) {
            return this.queue.offer(typeCheck(e2));
        }
    }

    public static <E> Set<E> checkedSet(Set<E> s2, Class<E> type) {
        return new CheckedSet(s2, type);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class CheckedSet<E> extends CheckedCollection<E> implements Set<E>, Serializable {
        private static final long serialVersionUID = 4694047833775013803L;

        CheckedSet(Set<E> s2, Class<E> elementType) {
            super(s2, elementType);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object o10) {
            return o10 == this || this.f50437c.equals(o10);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return this.f50437c.hashCode();
        }
    }

    public static <E> SortedSet<E> checkedSortedSet(SortedSet<E> s2, Class<E> type) {
        return new CheckedSortedSet(s2, type);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class CheckedSortedSet<E> extends CheckedSet<E> implements SortedSet<E>, Serializable {
        private static final long serialVersionUID = 1599911165492914959L;
        private final SortedSet<E> ss;

        CheckedSortedSet(SortedSet<E> s2, Class<E> type) {
            super(s2, type);
            this.ss = s2;
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            return this.ss.comparator();
        }

        @Override // java.util.SortedSet
        public E first() {
            return this.ss.first();
        }

        @Override // java.util.SortedSet
        public E last() {
            return this.ss.last();
        }

        public SortedSet<E> subSet(E fromElement, E toElement) {
            return Collections.checkedSortedSet(this.ss.subSet(fromElement, toElement), this.type);
        }

        public SortedSet<E> headSet(E toElement) {
            return Collections.checkedSortedSet(this.ss.headSet(toElement), this.type);
        }

        public SortedSet<E> tailSet(E fromElement) {
            return Collections.checkedSortedSet(this.ss.tailSet(fromElement), this.type);
        }
    }

    public static <E> NavigableSet<E> checkedNavigableSet(NavigableSet<E> s2, Class<E> type) {
        return new CheckedNavigableSet(s2, type);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class CheckedNavigableSet<E> extends CheckedSortedSet<E> implements NavigableSet<E>, Serializable {
        private static final long serialVersionUID = -5429120189805438922L;
        private final NavigableSet<E> ns;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Collections.CheckedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public /* bridge */ /* synthetic */ SortedSet headSet(Object obj) {
            return headSet((CheckedNavigableSet<E>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Collections.CheckedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public /* bridge */ /* synthetic */ SortedSet tailSet(Object obj) {
            return tailSet((CheckedNavigableSet<E>) obj);
        }

        CheckedNavigableSet(NavigableSet<E> s2, Class<E> type) {
            super(s2, type);
            this.ns = s2;
        }

        @Override // java.util.NavigableSet
        public E lower(E e2) {
            return this.ns.lower(e2);
        }

        @Override // java.util.NavigableSet
        public E floor(E e2) {
            return this.ns.floor(e2);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e2) {
            return this.ns.ceiling(e2);
        }

        @Override // java.util.NavigableSet
        public E higher(E e2) {
            return this.ns.higher(e2);
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            return this.ns.pollFirst();
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            return this.ns.pollLast();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return Collections.checkedNavigableSet(this.ns.descendingSet(), this.type);
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return Collections.checkedNavigableSet(this.ns.descendingSet(), this.type).iterator2();
        }

        @Override // java.util.Collections.CheckedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public NavigableSet<E> subSet(E fromElement, E toElement) {
            return Collections.checkedNavigableSet(this.ns.subSet(fromElement, true, toElement, false), this.type);
        }

        @Override // java.util.Collections.CheckedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public NavigableSet<E> headSet(E toElement) {
            return Collections.checkedNavigableSet(this.ns.headSet(toElement, false), this.type);
        }

        @Override // java.util.Collections.CheckedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public NavigableSet<E> tailSet(E fromElement) {
            return Collections.checkedNavigableSet(this.ns.tailSet(fromElement, true), this.type);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
            return Collections.checkedNavigableSet(this.ns.subSet(fromElement, fromInclusive, toElement, toInclusive), this.type);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E toElement, boolean inclusive) {
            return Collections.checkedNavigableSet(this.ns.headSet(toElement, inclusive), this.type);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
            return Collections.checkedNavigableSet(this.ns.tailSet(fromElement, inclusive), this.type);
        }
    }

    public static <E> List<E> checkedList(List<E> list, Class<E> type) {
        if (list instanceof RandomAccess) {
            return new CheckedRandomAccessList(list, type);
        }
        return new CheckedList(list, type);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class CheckedList<E> extends CheckedCollection<E> implements List<E> {
        private static final long serialVersionUID = 65247728283967356L;
        final List<E> list;

        CheckedList(List<E> list, Class<E> type) {
            super(list, type);
            this.list = list;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object o10) {
            return o10 == this || this.list.equals(o10);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return this.list.hashCode();
        }

        @Override // java.util.List
        public E get(int index) {
            return this.list.get(index);
        }

        @Override // java.util.List
        public E remove(int index) {
            return this.list.remove(index);
        }

        @Override // java.util.List
        public int indexOf(Object o10) {
            return this.list.indexOf(o10);
        }

        @Override // java.util.List
        public int lastIndexOf(Object o10) {
            return this.list.lastIndexOf(o10);
        }

        @Override // java.util.List
        public E set(int index, E element) {
            return this.list.set(index, typeCheck(element));
        }

        @Override // java.util.List
        public void add(int index, E element) {
            this.list.add(index, typeCheck(element));
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends E> c4) {
            return this.list.addAll(index, checkedCopyOf(c4));
        }

        @Override // java.util.List
        public ListIterator<E> listIterator() {
            return listIterator(0);
        }

        @Override // java.util.List
        public ListIterator<E> listIterator(int index) {
            final ListIterator<E> i10 = this.list.listIterator(index);
            return new ListIterator<E>() { // from class: java.util.Collections.CheckedList.1
                @Override // java.util.ListIterator, java.util.Iterator
                public boolean hasNext() {
                    return i10.hasNext();
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public E next() {
                    return (E) i10.next();
                }

                @Override // java.util.ListIterator
                public boolean hasPrevious() {
                    return i10.hasPrevious();
                }

                @Override // java.util.ListIterator
                public E previous() {
                    return (E) i10.previous();
                }

                @Override // java.util.ListIterator
                public int nextIndex() {
                    return i10.nextIndex();
                }

                @Override // java.util.ListIterator
                public int previousIndex() {
                    return i10.previousIndex();
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public void remove() {
                    i10.remove();
                }

                @Override // java.util.ListIterator
                public void set(E e2) {
                    i10.set(CheckedList.this.typeCheck(e2));
                }

                @Override // java.util.ListIterator
                public void add(E e2) {
                    i10.add(CheckedList.this.typeCheck(e2));
                }

                @Override // java.util.Iterator
                public void forEachRemaining(Consumer<? super E> action) {
                    i10.forEachRemaining(action);
                }
            };
        }

        @Override // java.util.List
        public List<E> subList(int fromIndex, int toIndex) {
            return new CheckedList(this.list.subList(fromIndex, toIndex), this.type);
        }

        @Override // java.util.List
        public void replaceAll(final UnaryOperator<E> operator) {
            Objects.requireNonNull(operator);
            this.list.replaceAll(new UnaryOperator() { // from class: java.util.Collections$CheckedList$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Object lambda$replaceAll$0;
                    lambda$replaceAll$0 = Collections.CheckedList.this.lambda$replaceAll$0(operator, obj);
                    return lambda$replaceAll$0;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$replaceAll$0(UnaryOperator operator, Object e2) {
            return typeCheck(operator.apply(e2));
        }

        @Override // java.util.List
        public void sort(Comparator<? super E> c4) {
            this.list.sort(c4);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class CheckedRandomAccessList<E> extends CheckedList<E> implements RandomAccess {
        private static final long serialVersionUID = 1638200125423088369L;

        CheckedRandomAccessList(List<E> list, Class<E> type) {
            super(list, type);
        }

        @Override // java.util.Collections.CheckedList, java.util.List
        public List<E> subList(int fromIndex, int toIndex) {
            return new CheckedRandomAccessList(this.list.subList(fromIndex, toIndex), this.type);
        }
    }

    public static <K, V> Map<K, V> checkedMap(Map<K, V> m10, Class<K> keyType, Class<V> valueType) {
        return new CheckedMap(m10, keyType, valueType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class CheckedMap<K, V> implements Map<K, V>, Serializable {
        private static final long serialVersionUID = 5742860141034234728L;
        private transient Set<Map.Entry<K, V>> entrySet;
        final Class<K> keyType;

        /* renamed from: m, reason: collision with root package name */
        private final Map<K, V> f50438m;
        final Class<V> valueType;

        private void typeCheck(Object key, Object value) {
            if (key != null && !this.keyType.isInstance(key)) {
                throw new ClassCastException(badKeyMsg(key));
            }
            if (value != null && !this.valueType.isInstance(value)) {
                throw new ClassCastException(badValueMsg(value));
            }
        }

        private BiFunction<? super K, ? super V, ? extends V> typeCheck(final BiFunction<? super K, ? super V, ? extends V> func) {
            Objects.requireNonNull(func);
            return new BiFunction() { // from class: java.util.Collections$CheckedMap$$ExternalSyntheticLambda2
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    Object lambda$typeCheck$0;
                    lambda$typeCheck$0 = Collections.CheckedMap.this.lambda$typeCheck$0(func, obj, obj2);
                    return lambda$typeCheck$0;
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$typeCheck$0(BiFunction func, Object k10, Object v2) {
            Object apply = func.apply(k10, v2);
            typeCheck(k10, apply);
            return apply;
        }

        private String badKeyMsg(Object key) {
            return "Attempt to insert " + ((Object) key.getClass()) + " key into map with key type " + ((Object) this.keyType);
        }

        private String badValueMsg(Object value) {
            return "Attempt to insert " + ((Object) value.getClass()) + " value into map with value type " + ((Object) this.valueType);
        }

        CheckedMap(Map<K, V> m10, Class<K> keyType, Class<V> valueType) {
            this.f50438m = (Map) Objects.requireNonNull(m10);
            this.keyType = (Class) Objects.requireNonNull(keyType);
            this.valueType = (Class) Objects.requireNonNull(valueType);
        }

        @Override // java.util.Map
        public int size() {
            return this.f50438m.size();
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.f50438m.isEmpty();
        }

        @Override // java.util.Map
        public boolean containsKey(Object key) {
            return this.f50438m.containsKey(key);
        }

        @Override // java.util.Map
        public boolean containsValue(Object v2) {
            return this.f50438m.containsValue(v2);
        }

        @Override // java.util.Map
        public V get(Object key) {
            return this.f50438m.get(key);
        }

        @Override // java.util.Map
        public V remove(Object key) {
            return this.f50438m.remove(key);
        }

        @Override // java.util.Map
        public void clear() {
            this.f50438m.clear();
        }

        @Override // java.util.Map
        /* renamed from: keySet */
        public Set<K> h() {
            return this.f50438m.h();
        }

        @Override // java.util.Map
        public Collection<V> values() {
            return this.f50438m.values();
        }

        @Override // java.util.Map
        public boolean equals(Object o10) {
            return o10 == this || this.f50438m.equals(o10);
        }

        @Override // java.util.Map
        public int hashCode() {
            return this.f50438m.hashCode();
        }

        public String toString() {
            return this.f50438m.toString();
        }

        @Override // java.util.Map
        public V put(K key, V value) {
            typeCheck(key, value);
            return this.f50438m.put(key, value);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            Object[] array = map.entrySet().toArray();
            ArrayList<Map.Entry> arrayList = new ArrayList(array.length);
            for (Object obj : array) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                typeCheck(key, value);
                arrayList.add(new AbstractMap.SimpleImmutableEntry(key, value));
            }
            for (Map.Entry entry2 : arrayList) {
                this.f50438m.put(entry2.getKey(), entry2.getValue());
            }
        }

        @Override // java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            if (this.entrySet == null) {
                this.entrySet = new CheckedEntrySet(this.f50438m.entrySet(), this.valueType);
            }
            return this.entrySet;
        }

        @Override // java.util.Map
        public void forEach(BiConsumer<? super K, ? super V> action) {
            this.f50438m.forEach(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
            this.f50438m.replaceAll(typeCheck(function));
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public V putIfAbsent(K key, V value) {
            typeCheck(key, value);
            return this.f50438m.putIfAbsent(key, value);
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public boolean remove(Object key, Object value) {
            return this.f50438m.remove(key, value);
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public boolean replace(K key, V oldValue, V newValue) {
            typeCheck(key, newValue);
            return this.f50438m.replace(key, oldValue, newValue);
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public V replace(K key, V value) {
            typeCheck(key, value);
            return this.f50438m.replace(key, value);
        }

        @Override // java.util.Map
        public V computeIfAbsent(K key, final Function<? super K, ? extends V> mappingFunction) {
            Objects.requireNonNull(mappingFunction);
            return this.f50438m.computeIfAbsent(key, new Function() { // from class: java.util.Collections$CheckedMap$$ExternalSyntheticLambda1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Object lambda$computeIfAbsent$1;
                    lambda$computeIfAbsent$1 = Collections.CheckedMap.this.lambda$computeIfAbsent$1(mappingFunction, obj);
                    return lambda$computeIfAbsent$1;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$computeIfAbsent$1(Function mappingFunction, Object k10) {
            Object apply = mappingFunction.apply(k10);
            typeCheck(k10, apply);
            return apply;
        }

        @Override // java.util.Map
        public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
            return this.f50438m.computeIfPresent(key, typeCheck(remappingFunction));
        }

        @Override // java.util.Map
        public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
            return this.f50438m.compute(key, typeCheck(remappingFunction));
        }

        @Override // java.util.Map
        public V merge(K key, V value, final BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            Objects.requireNonNull(remappingFunction);
            return this.f50438m.merge(key, value, new BiFunction() { // from class: java.util.Collections$CheckedMap$$ExternalSyntheticLambda0
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    Object lambda$merge$2;
                    lambda$merge$2 = Collections.CheckedMap.this.lambda$merge$2(remappingFunction, obj, obj2);
                    return lambda$merge$2;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$merge$2(BiFunction remappingFunction, Object v12, Object v2) {
            Object apply = remappingFunction.apply(v12, v2);
            typeCheck(null, apply);
            return apply;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static class CheckedEntrySet<K, V> implements Set<Map.Entry<K, V>> {

            /* renamed from: s, reason: collision with root package name */
            private final Set<Map.Entry<K, V>> f50439s;
            private final Class<V> valueType;

            CheckedEntrySet(Set<Map.Entry<K, V>> s2, Class<V> valueType) {
                this.f50439s = s2;
                this.valueType = valueType;
            }

            @Override // java.util.Set
            public int size() {
                return this.f50439s.size();
            }

            @Override // java.util.Set
            public boolean isEmpty() {
                return this.f50439s.isEmpty();
            }

            public String toString() {
                return this.f50439s.toString();
            }

            @Override // java.util.Set
            public int hashCode() {
                return this.f50439s.hashCode();
            }

            @Override // java.util.Set
            public void clear() {
                this.f50439s.clear();
            }

            @Override // java.util.Set
            public boolean add(Map.Entry<K, V> e2) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Set
            public boolean addAll(Collection<? extends Map.Entry<K, V>> coll) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Set, java.util.Collection, java.lang.Iterable
            /* renamed from: iterator */
            public Iterator<Map.Entry<K, V>> iterator2() {
                Iterator<Map.Entry<K, V>> i10 = this.f50439s.iterator2();
                return new AnonymousClass1(i10);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
            /* renamed from: java.util.Collections$CheckedMap$CheckedEntrySet$1, reason: invalid class name */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
            public class AnonymousClass1 implements Iterator<Map.Entry<K, V>> {
                final /* synthetic */ Iterator val$i;

                AnonymousClass1(Iterator it) {
                    this.val$i = it;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.val$i.hasNext();
                }

                @Override // java.util.Iterator
                public void remove() {
                    this.val$i.remove();
                }

                @Override // java.util.Iterator
                public Map.Entry<K, V> next() {
                    return CheckedEntrySet.checkedEntry((Map.Entry) this.val$i.next(), CheckedEntrySet.this.valueType);
                }

                @Override // java.util.Iterator
                public void forEachRemaining(final Consumer<? super Map.Entry<K, V>> action) {
                    this.val$i.forEachRemaining(new Consumer() { // from class: java.util.Collections$CheckedMap$CheckedEntrySet$1$$ExternalSyntheticLambda0
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            Collections.CheckedMap.CheckedEntrySet.AnonymousClass1.this.lambda$forEachRemaining$0(action, (Map.Entry) obj);
                        }
                    });
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$forEachRemaining$0(Consumer action, Map.Entry e2) {
                    action.accept(CheckedEntrySet.checkedEntry(e2, CheckedEntrySet.this.valueType));
                }
            }

            @Override // java.util.Set
            public Object[] toArray() {
                Object[] dest;
                Object[] source = this.f50439s.toArray();
                if (source.getClass() == Object[].class) {
                    dest = source;
                } else {
                    dest = new Object[source.length];
                }
                for (int i10 = 0; i10 < source.length; i10++) {
                    dest[i10] = checkedEntry((Map.Entry) source[i10], this.valueType);
                }
                return dest;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Set
            public <T> T[] toArray(T[] tArr) {
                T[] tArr2 = (T[]) this.f50439s.toArray(tArr.length == 0 ? tArr : Arrays.copyOf(tArr, 0));
                for (int i10 = 0; i10 < tArr2.length; i10++) {
                    tArr2[i10] = checkedEntry((Map.Entry) tArr2[i10], this.valueType);
                }
                if (tArr2.length > tArr.length) {
                    return tArr2;
                }
                System.arraycopy(tArr2, 0, tArr, 0, tArr2.length);
                if (tArr.length > tArr2.length) {
                    tArr[tArr2.length] = null;
                }
                return tArr;
            }

            @Override // java.util.Set
            public boolean contains(Object o10) {
                if (!(o10 instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry<?, ?> e2 = (Map.Entry) o10;
                return this.f50439s.contains(e2 instanceof CheckedEntry ? e2 : checkedEntry(e2, this.valueType));
            }

            @Override // java.util.Set
            public boolean containsAll(Collection<?> c4) {
                for (Object o10 : c4) {
                    if (!contains(o10)) {
                        return false;
                    }
                }
                return true;
            }

            @Override // java.util.Set
            public boolean remove(Object o10) {
                if (!(o10 instanceof Map.Entry)) {
                    return false;
                }
                return this.f50439s.remove(new AbstractMap.SimpleImmutableEntry((Map.Entry) o10));
            }

            @Override // java.util.Set
            public boolean removeAll(Collection<?> c4) {
                return batchRemove(c4, false);
            }

            @Override // java.util.Set
            public boolean retainAll(Collection<?> c4) {
                return batchRemove(c4, true);
            }

            private boolean batchRemove(Collection<?> c4, boolean complement) {
                Objects.requireNonNull(c4);
                boolean modified = false;
                Iterator<Map.Entry<K, V>> it = iterator2();
                while (it.hasNext()) {
                    if (c4.contains(it.next()) != complement) {
                        it.remove();
                        modified = true;
                    }
                }
                return modified;
            }

            @Override // java.util.Set
            public boolean equals(Object o10) {
                if (o10 == this) {
                    return true;
                }
                if (!(o10 instanceof Set)) {
                    return false;
                }
                Set<?> that = (Set) o10;
                return that.size() == this.f50439s.size() && containsAll(that);
            }

            static <K, V, T> CheckedEntry<K, V, T> checkedEntry(Map.Entry<K, V> e2, Class<T> valueType) {
                return new CheckedEntry<>(e2, valueType);
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
            public static class CheckedEntry<K, V, T> implements Map.Entry<K, V> {

                /* renamed from: e, reason: collision with root package name */
                private final Map.Entry<K, V> f50440e;
                private final Class<T> valueType;

                CheckedEntry(Map.Entry<K, V> e2, Class<T> valueType) {
                    this.f50440e = (Map.Entry) Objects.requireNonNull(e2);
                    this.valueType = (Class) Objects.requireNonNull(valueType);
                }

                @Override // java.util.Map.Entry
                public K getKey() {
                    return this.f50440e.getKey();
                }

                @Override // java.util.Map.Entry
                public V getValue() {
                    return this.f50440e.getValue();
                }

                @Override // java.util.Map.Entry
                public int hashCode() {
                    return this.f50440e.hashCode();
                }

                public String toString() {
                    return this.f50440e.toString();
                }

                @Override // java.util.Map.Entry
                public V setValue(V value) {
                    if (value != null && !this.valueType.isInstance(value)) {
                        throw new ClassCastException(badValueMsg(value));
                    }
                    return this.f50440e.setValue(value);
                }

                private String badValueMsg(Object value) {
                    return "Attempt to insert " + ((Object) value.getClass()) + " value into map with value type " + ((Object) this.valueType);
                }

                @Override // java.util.Map.Entry
                public boolean equals(Object o10) {
                    if (o10 == this) {
                        return true;
                    }
                    if (!(o10 instanceof Map.Entry)) {
                        return false;
                    }
                    return this.f50440e.equals(new AbstractMap.SimpleImmutableEntry((Map.Entry) o10));
                }
            }
        }
    }

    public static <K, V> SortedMap<K, V> checkedSortedMap(SortedMap<K, V> m10, Class<K> keyType, Class<V> valueType) {
        return new CheckedSortedMap(m10, keyType, valueType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class CheckedSortedMap<K, V> extends CheckedMap<K, V> implements SortedMap<K, V>, Serializable {
        private static final long serialVersionUID = 1599671320688067438L;
        private final SortedMap<K, V> sm;

        CheckedSortedMap(SortedMap<K, V> m10, Class<K> keyType, Class<V> valueType) {
            super(m10, keyType, valueType);
            this.sm = m10;
        }

        public Comparator<? super K> comparator() {
            return this.sm.comparator();
        }

        public K firstKey() {
            return this.sm.firstKey();
        }

        public K lastKey() {
            return this.sm.lastKey();
        }

        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            return Collections.checkedSortedMap(this.sm.subMap(fromKey, toKey), this.keyType, this.valueType);
        }

        public SortedMap<K, V> headMap(K toKey) {
            return Collections.checkedSortedMap(this.sm.headMap(toKey), this.keyType, this.valueType);
        }

        public SortedMap<K, V> tailMap(K fromKey) {
            return Collections.checkedSortedMap(this.sm.tailMap(fromKey), this.keyType, this.valueType);
        }
    }

    public static <K, V> NavigableMap<K, V> checkedNavigableMap(NavigableMap<K, V> m10, Class<K> keyType, Class<V> valueType) {
        return new CheckedNavigableMap(m10, keyType, valueType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class CheckedNavigableMap<K, V> extends CheckedSortedMap<K, V> implements NavigableMap<K, V>, Serializable {
        private static final long serialVersionUID = -4852462692372534096L;
        private final NavigableMap<K, V> nm;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Collections.CheckedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public /* bridge */ /* synthetic */ SortedMap headMap(Object obj) {
            return headMap((CheckedNavigableMap<K, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Collections.CheckedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public /* bridge */ /* synthetic */ SortedMap tailMap(Object obj) {
            return tailMap((CheckedNavigableMap<K, V>) obj);
        }

        CheckedNavigableMap(NavigableMap<K, V> m10, Class<K> keyType, Class<V> valueType) {
            super(m10, keyType, valueType);
            this.nm = m10;
        }

        @Override // java.util.Collections.CheckedSortedMap, java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.nm.comparator();
        }

        @Override // java.util.Collections.CheckedSortedMap, java.util.SortedMap
        public K firstKey() {
            return this.nm.firstKey();
        }

        @Override // java.util.Collections.CheckedSortedMap, java.util.SortedMap
        public K lastKey() {
            return this.nm.lastKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K key) {
            Map.Entry<K, V> lower = this.nm.lowerEntry(key);
            if (lower != null) {
                return new CheckedMap.CheckedEntrySet.CheckedEntry(lower, this.valueType);
            }
            return null;
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K key) {
            return this.nm.lowerKey(key);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K key) {
            Map.Entry<K, V> floor = this.nm.floorEntry(key);
            if (floor != null) {
                return new CheckedMap.CheckedEntrySet.CheckedEntry(floor, this.valueType);
            }
            return null;
        }

        @Override // java.util.NavigableMap
        public K floorKey(K key) {
            return this.nm.floorKey(key);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K key) {
            Map.Entry<K, V> ceiling = this.nm.ceilingEntry(key);
            if (ceiling != null) {
                return new CheckedMap.CheckedEntrySet.CheckedEntry(ceiling, this.valueType);
            }
            return null;
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K key) {
            return this.nm.ceilingKey(key);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K key) {
            Map.Entry<K, V> higher = this.nm.higherEntry(key);
            if (higher != null) {
                return new CheckedMap.CheckedEntrySet.CheckedEntry(higher, this.valueType);
            }
            return null;
        }

        @Override // java.util.NavigableMap
        public K higherKey(K key) {
            return this.nm.higherKey(key);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            Map.Entry<K, V> first = this.nm.firstEntry();
            if (first != null) {
                return new CheckedMap.CheckedEntrySet.CheckedEntry(first, this.valueType);
            }
            return null;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            Map.Entry<K, V> last = this.nm.lastEntry();
            if (last != null) {
                return new CheckedMap.CheckedEntrySet.CheckedEntry(last, this.valueType);
            }
            return null;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            Map.Entry<K, V> entry = this.nm.pollFirstEntry();
            if (entry == null) {
                return null;
            }
            return new CheckedMap.CheckedEntrySet.CheckedEntry(entry, this.valueType);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            Map.Entry<K, V> entry = this.nm.pollLastEntry();
            if (entry == null) {
                return null;
            }
            return new CheckedMap.CheckedEntrySet.CheckedEntry(entry, this.valueType);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return Collections.checkedNavigableMap(this.nm.descendingMap(), this.keyType, this.valueType);
        }

        @Override // java.util.Collections.CheckedMap, java.util.Map
        /* renamed from: keySet */
        public NavigableSet<K> h() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return Collections.checkedNavigableSet(this.nm.navigableKeySet(), this.keyType);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return Collections.checkedNavigableSet(this.nm.descendingKeySet(), this.keyType);
        }

        @Override // java.util.Collections.CheckedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public NavigableMap<K, V> subMap(K fromKey, K toKey) {
            return Collections.checkedNavigableMap(this.nm.subMap(fromKey, true, toKey, false), this.keyType, this.valueType);
        }

        @Override // java.util.Collections.CheckedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public NavigableMap<K, V> headMap(K toKey) {
            return Collections.checkedNavigableMap(this.nm.headMap(toKey, false), this.keyType, this.valueType);
        }

        @Override // java.util.Collections.CheckedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K fromKey) {
            return Collections.checkedNavigableMap(this.nm.tailMap(fromKey, true), this.keyType, this.valueType);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
            return Collections.checkedNavigableMap(this.nm.subMap(fromKey, fromInclusive, toKey, toInclusive), this.keyType, this.valueType);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {
            return Collections.checkedNavigableMap(this.nm.headMap(toKey, inclusive), this.keyType, this.valueType);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
            return Collections.checkedNavigableMap(this.nm.tailMap(fromKey, inclusive), this.keyType, this.valueType);
        }
    }

    public static <T> Iterator<T> emptyIterator() {
        return EmptyIterator.EMPTY_ITERATOR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class EmptyIterator<E> implements Iterator<E> {
        static final EmptyIterator<Object> EMPTY_ITERATOR = new EmptyIterator<>();

        private EmptyIterator() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException();
        }

        @Override // java.util.Iterator
        public void forEachRemaining(Consumer<? super E> action) {
            Objects.requireNonNull(action);
        }
    }

    public static <T> ListIterator<T> emptyListIterator() {
        return EmptyListIterator.EMPTY_ITERATOR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class EmptyListIterator<E> extends EmptyIterator<E> implements ListIterator<E> {
        static final EmptyListIterator<Object> EMPTY_ITERATOR = new EmptyListIterator<>();

        private EmptyListIterator() {
            super();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return false;
        }

        @Override // java.util.ListIterator
        public E previous() {
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return 0;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return -1;
        }

        @Override // java.util.ListIterator
        public void set(E e2) {
            throw new IllegalStateException();
        }

        @Override // java.util.ListIterator
        public void add(E e2) {
            throw new UnsupportedOperationException();
        }
    }

    public static <T> Enumeration<T> emptyEnumeration() {
        return EmptyEnumeration.EMPTY_ENUMERATION;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class EmptyEnumeration<E> implements Enumeration<E> {
        static final EmptyEnumeration<Object> EMPTY_ENUMERATION = new EmptyEnumeration<>();

        private EmptyEnumeration() {
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return false;
        }

        @Override // java.util.Enumeration
        public E nextElement() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Enumeration
        public Iterator<E> asIterator() {
            return Collections.emptyIterator();
        }
    }

    public static final <T> Set<T> emptySet() {
        return EMPTY_SET;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class EmptySet<E> extends AbstractSet<E> implements Serializable {
        private static final long serialVersionUID = 1582296315990362920L;

        private EmptySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<E> iterator2() {
            return Collections.emptyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> c4) {
            return c4.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return new Object[0];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] a10) {
            if (a10.length > 0) {
                a10[0] = null;
            }
            return a10;
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super E> action) {
            Objects.requireNonNull(action);
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super E> filter) {
            Objects.requireNonNull(filter);
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<E> spliterator() {
            return Spliterators.emptySpliterator();
        }

        private Object readResolve() {
            return Collections.EMPTY_SET;
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return 0;
        }
    }

    public static <E> SortedSet<E> emptySortedSet() {
        return UnmodifiableNavigableSet.EMPTY_NAVIGABLE_SET;
    }

    public static <E> NavigableSet<E> emptyNavigableSet() {
        return UnmodifiableNavigableSet.EMPTY_NAVIGABLE_SET;
    }

    public static final <T> List<T> emptyList() {
        return EMPTY_LIST;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class EmptyList<E> extends AbstractList<E> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 8842843931221139166L;

        private EmptyList() {
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<E> iterator2() {
            return Collections.emptyIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator() {
            return Collections.emptyListIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return true;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> c4) {
            return c4.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return new Object[0];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] a10) {
            if (a10.length > 0) {
                a10[0] = null;
            }
            return a10;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int index) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.Set
        public boolean equals(Object o10) {
            return (o10 instanceof List) && ((List) o10).isEmpty();
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.Set
        public int hashCode() {
            return 1;
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super E> filter) {
            Objects.requireNonNull(filter);
            return false;
        }

        @Override // java.util.List
        public void replaceAll(UnaryOperator<E> operator) {
            Objects.requireNonNull(operator);
        }

        @Override // java.util.List
        public void sort(Comparator<? super E> c4) {
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super E> action) {
            Objects.requireNonNull(action);
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<E> spliterator() {
            return Spliterators.emptySpliterator();
        }

        private Object readResolve() {
            return Collections.EMPTY_LIST;
        }
    }

    public static final <K, V> Map<K, V> emptyMap() {
        return EMPTY_MAP;
    }

    public static final <K, V> SortedMap<K, V> emptySortedMap() {
        return UnmodifiableNavigableMap.EMPTY_NAVIGABLE_MAP;
    }

    public static final <K, V> NavigableMap<K, V> emptyNavigableMap() {
        return UnmodifiableNavigableMap.EMPTY_NAVIGABLE_MAP;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class EmptyMap<K, V> extends AbstractMap<K, V> implements Serializable {
        private static final long serialVersionUID = 6428348081105594320L;

        private EmptyMap() {
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return 0;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return true;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object key) {
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(Object value) {
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object key) {
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: keySet */
        public Set<K> h() {
            return Collections.emptySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            return Collections.emptySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return Collections.emptySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(Object o10) {
            return (o10 instanceof Map) && ((Map) o10).isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return 0;
        }

        @Override // java.util.Map
        public V getOrDefault(Object k10, V defaultValue) {
            return defaultValue;
        }

        @Override // java.util.Map
        public void forEach(BiConsumer<? super K, ? super V> action) {
            Objects.requireNonNull(action);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
            Objects.requireNonNull(function);
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public V putIfAbsent(K key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public boolean replace(K key, V oldValue, V newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public V replace(K key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        private Object readResolve() {
            return Collections.EMPTY_MAP;
        }
    }

    public static <T> Set<T> singleton(T o10) {
        return new SingletonSet(o10);
    }

    static <E> Iterator<E> singletonIterator(final E e2) {
        return new Iterator<E>() { // from class: java.util.Collections.1
            private boolean hasNext = true;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.hasNext;
            }

            @Override // java.util.Iterator
            public E next() {
                if (this.hasNext) {
                    this.hasNext = false;
                    return (E) Object.this;
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Iterator
            public void forEachRemaining(Consumer<? super E> consumer) {
                Objects.requireNonNull(consumer);
                if (this.hasNext) {
                    this.hasNext = false;
                    consumer.accept((Object) Object.this);
                }
            }
        };
    }

    static <T> Spliterator<T> singletonSpliterator(final T element) {
        return new Spliterator<T>() { // from class: java.util.Collections.2
            long est = 1;

            @Override // java.util.Spliterator
            public Spliterator<T> trySplit() {
                return null;
            }

            @Override // java.util.Spliterator
            public boolean tryAdvance(Consumer<? super T> consumer) {
                Objects.requireNonNull(consumer);
                long j10 = this.est;
                if (j10 > 0) {
                    this.est = j10 - 1;
                    consumer.accept((Object) Object.this);
                    return true;
                }
                return false;
            }

            @Override // java.util.Spliterator
            public void forEachRemaining(Consumer<? super T> consumer) {
                tryAdvance(consumer);
            }

            @Override // java.util.Spliterator
            public long estimateSize() {
                return this.est;
            }

            @Override // java.util.Spliterator
            public int characteristics() {
                int value = Object.this != null ? 256 : 0;
                return value | 64 | 16384 | 1024 | 1 | 16;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class SingletonSet<E> extends AbstractSet<E> implements Serializable {
        private static final long serialVersionUID = 3193687207550431679L;
        private final E element;

        SingletonSet(E e2) {
            this.element = e2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<E> iterator2() {
            return Collections.singletonIterator(this.element);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return 1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            return Collections.eq(o10, this.element);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super E> consumer) {
            consumer.accept(this.element);
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<E> spliterator() {
            return Collections.singletonSpliterator(this.element);
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super E> filter) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return Objects.hashCode(this.element);
        }
    }

    public static <T> List<T> singletonList(T o10) {
        return new SingletonList(o10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class SingletonList<E> extends AbstractList<E> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 3093736618740652951L;
        private final E element;

        SingletonList(E obj) {
            this.element = obj;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<E> iterator2() {
            return Collections.singletonIterator(this.element);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return 1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return Collections.eq(obj, this.element);
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int index) {
            if (index != 0) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: 1");
            }
            return this.element;
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super E> consumer) {
            consumer.accept(this.element);
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super E> filter) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.List
        public void replaceAll(UnaryOperator<E> operator) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.List
        public void sort(Comparator<? super E> c4) {
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<E> spliterator() {
            return Collections.singletonSpliterator(this.element);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.Set
        public int hashCode() {
            return Objects.hashCode(this.element) + 31;
        }
    }

    public static <K, V> Map<K, V> singletonMap(K key, V value) {
        return new SingletonMap(key, value);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class SingletonMap<K, V> extends AbstractMap<K, V> implements Serializable {
        private static final long serialVersionUID = -6979724477215052911L;
        private transient Set<Map.Entry<K, V>> entrySet;

        /* renamed from: k, reason: collision with root package name */
        private final K f50444k;
        private transient Set<K> keySet;

        /* renamed from: v, reason: collision with root package name */
        private final V f50445v;
        private transient Collection<V> values;

        SingletonMap(K key, V value) {
            this.f50444k = key;
            this.f50445v = value;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return 1;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object key) {
            return Collections.eq(key, this.f50444k);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(Object value) {
            return Collections.eq(value, this.f50445v);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object key) {
            if (Collections.eq(key, this.f50444k)) {
                return this.f50445v;
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: keySet */
        public Set<K> h() {
            if (this.keySet == null) {
                this.keySet = Collections.singleton(this.f50444k);
            }
            return this.keySet;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            if (this.entrySet == null) {
                this.entrySet = Collections.singleton(new AbstractMap.SimpleImmutableEntry(this.f50444k, this.f50445v));
            }
            return this.entrySet;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            if (this.values == null) {
                this.values = Collections.singleton(this.f50445v);
            }
            return this.values;
        }

        @Override // java.util.Map
        public V getOrDefault(Object key, V defaultValue) {
            return Collections.eq(key, this.f50444k) ? this.f50445v : defaultValue;
        }

        @Override // java.util.Map
        public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
            biConsumer.accept(this.f50444k, this.f50445v);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public V putIfAbsent(K key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public boolean replace(K key, V oldValue, V newValue) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public V replace(K key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return Objects.hashCode(this.f50444k) ^ Objects.hashCode(this.f50445v);
        }
    }

    public static <T> List<T> nCopies(int n10, T o10) {
        if (n10 < 0) {
            throw new IllegalArgumentException("List length = " + n10);
        }
        return new CopiesList(n10, o10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class CopiesList<E> extends AbstractList<E> implements RandomAccess, Serializable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long serialVersionUID = 2739099268398711800L;
        final E element;

        /* renamed from: n, reason: collision with root package name */
        final int f50441n;

        CopiesList(int n10, E e2) {
            this.f50441n = n10;
            this.element = e2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f50441n;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f50441n != 0 && Collections.eq(obj, this.element);
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object o10) {
            return contains(o10) ? 0 : -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object o10) {
            if (contains(o10)) {
                return this.f50441n - 1;
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int index) {
            if (index < 0 || index >= this.f50441n) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.f50441n);
            }
            return this.element;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            int i10 = this.f50441n;
            Object[] a10 = new Object[i10];
            E e2 = this.element;
            if (e2 != null) {
                Arrays.fill(a10, 0, i10, e2);
            }
            return a10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            int i10 = this.f50441n;
            if (tArr.length < i10) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i10));
                E e2 = this.element;
                if (e2 != null) {
                    Arrays.fill(tArr, 0, i10, e2);
                }
            } else {
                Arrays.fill(tArr, 0, i10, this.element);
                if (tArr.length > i10) {
                    tArr[i10] = null;
                }
            }
            return tArr;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<E> subList(int fromIndex, int toIndex) {
            if (fromIndex < 0) {
                throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
            }
            if (toIndex > this.f50441n) {
                throw new IndexOutOfBoundsException("toIndex = " + toIndex);
            }
            if (fromIndex > toIndex) {
                throw new IllegalArgumentException("fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
            }
            return new CopiesList(toIndex - fromIndex, this.element);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.Set
        public int hashCode() {
            int i10 = this.f50441n;
            if (i10 == 0) {
                return 1;
            }
            int pow = 31;
            int sum = 1;
            for (int i11 = Integer.numberOfLeadingZeros(i10) + 1; i11 < 32; i11++) {
                sum *= pow + 1;
                pow *= pow;
                if ((this.f50441n << i11) < 0) {
                    pow *= 31;
                    sum = (sum * 31) + 1;
                }
            }
            E e2 = this.element;
            return ((e2 == null ? 0 : e2.hashCode()) * sum) + pow;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.Set
        public boolean equals(Object o10) {
            if (o10 == this) {
                return true;
            }
            if (o10 instanceof CopiesList) {
                CopiesList<?> other = (CopiesList) o10;
                int i10 = this.f50441n;
                return i10 == other.f50441n && (i10 == 0 || Collections.eq(this.element, other.element));
            }
            if (!(o10 instanceof List)) {
                return false;
            }
            int remaining = this.f50441n;
            E e2 = this.element;
            Iterator<E> iterator2 = ((List) o10).iterator2();
            if (e2 != null) {
                while (true) {
                    if (!iterator2.hasNext()) {
                        break;
                    }
                    int remaining2 = remaining - 1;
                    if (remaining <= 0) {
                        remaining = remaining2;
                        break;
                    }
                    if (!e2.equals(iterator2.next())) {
                        return false;
                    }
                    remaining = remaining2;
                }
            } else {
                while (true) {
                    if (!iterator2.hasNext()) {
                        break;
                    }
                    int remaining3 = remaining - 1;
                    if (remaining <= 0) {
                        remaining = remaining3;
                        break;
                    }
                    if (iterator2.next() != null) {
                        return false;
                    }
                    remaining = remaining3;
                }
            }
            return remaining == 0 && !iterator2.hasNext();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$stream$0(int i10) {
            return this.element;
        }

        @Override // java.util.Collection
        public Stream<E> stream() {
            return IntStream.range(0, this.f50441n).mapToObj(new IntFunction() { // from class: java.util.Collections$CopiesList$$ExternalSyntheticLambda1
                @Override // java.util.function.IntFunction
                public final Object apply(int i10) {
                    Object lambda$stream$0;
                    lambda$stream$0 = Collections.CopiesList.this.lambda$stream$0(i10);
                    return lambda$stream$0;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$parallelStream$1(int i10) {
            return this.element;
        }

        @Override // java.util.Collection
        public Stream<E> parallelStream() {
            return IntStream.range(0, this.f50441n).parallel().mapToObj(new IntFunction() { // from class: java.util.Collections$CopiesList$$ExternalSyntheticLambda0
                @Override // java.util.function.IntFunction
                public final Object apply(int i10) {
                    Object lambda$parallelStream$1;
                    lambda$parallelStream$1 = Collections.CopiesList.this.lambda$parallelStream$1(i10);
                    return lambda$parallelStream$1;
                }
            });
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<E> spliterator() {
            return stream().spliterator2();
        }

        private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
            ois.defaultReadObject();
            SharedSecrets.getJavaObjectInputStreamAccess().checkArray(ois, Object[].class, this.f50441n);
        }
    }

    public static <T> Comparator<T> reverseOrder() {
        return ReverseComparator.REVERSE_ORDER;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class ReverseComparator implements Comparator<Comparable<Object>>, Serializable {
        static final ReverseComparator REVERSE_ORDER = new ReverseComparator();
        private static final long serialVersionUID = 7207038068494060240L;

        private ReverseComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Comparable<Object> c12, Comparable<Object> c22) {
            return c22.compareTo(c12);
        }

        private Object readResolve() {
            return Collections.reverseOrder();
        }

        @Override // java.util.Comparator
        public Comparator<Comparable<Object>> reversed() {
            return Comparator.naturalOrder();
        }
    }

    public static <T> Comparator<T> reverseOrder(Comparator<T> cmp) {
        if (cmp == null) {
            return ReverseComparator.REVERSE_ORDER;
        }
        if (cmp == ReverseComparator.REVERSE_ORDER) {
            return Comparators.NaturalOrderComparator.INSTANCE;
        }
        if (cmp == Comparators.NaturalOrderComparator.INSTANCE) {
            return ReverseComparator.REVERSE_ORDER;
        }
        if (cmp instanceof ReverseComparator2) {
            return ((ReverseComparator2) cmp).cmp;
        }
        return new ReverseComparator2(cmp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class ReverseComparator2<T> implements Comparator<T>, Serializable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long serialVersionUID = 4374092139857L;
        final Comparator<T> cmp;

        ReverseComparator2(Comparator<T> cmp) {
            this.cmp = cmp;
        }

        @Override // java.util.Comparator
        public int compare(T t12, T t2) {
            return this.cmp.compare(t2, t12);
        }

        @Override // java.util.Comparator
        public boolean equals(Object o10) {
            return o10 == this || ((o10 instanceof ReverseComparator2) && this.cmp.equals(((ReverseComparator2) o10).cmp));
        }

        public int hashCode() {
            return this.cmp.hashCode() ^ Integer.MIN_VALUE;
        }

        @Override // java.util.Comparator
        public Comparator<T> reversed() {
            return this.cmp;
        }
    }

    public static <T> Enumeration<T> enumeration(Collection<T> c4) {
        return new Enumeration<T>() { // from class: java.util.Collections.3

            /* renamed from: i, reason: collision with root package name */
            private final Iterator<T> f50435i;

            {
                this.f50435i = Collection.this.iterator2();
            }

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return this.f50435i.hasNext();
            }

            @Override // java.util.Enumeration
            public T nextElement() {
                return this.f50435i.next();
            }
        };
    }

    public static <T> ArrayList<T> list(Enumeration<T> e2) {
        ArrayList<T> l10 = new ArrayList<>();
        while (e2.hasMoreElements()) {
            l10.add(e2.nextElement());
        }
        return l10;
    }

    static boolean eq(Object o12, Object o22) {
        return o12 == null ? o22 == null : o12.equals(o22);
    }

    public static int frequency(Collection<?> c4, Object o10) {
        int result = 0;
        if (o10 == null) {
            for (Object e2 : c4) {
                if (e2 == null) {
                    result++;
                }
            }
        } else {
            for (Object e10 : c4) {
                if (o10.equals(e10)) {
                    result++;
                }
            }
        }
        return result;
    }

    public static boolean disjoint(Collection<?> c12, Collection<?> c22) {
        Collection<?> contains = c22;
        Collection<?> iterate = c12;
        if (c12 instanceof Set) {
            iterate = c22;
            contains = c12;
        } else if (!(c22 instanceof Set)) {
            int c1size = c12.size();
            int c2size = c22.size();
            if (c1size == 0 || c2size == 0) {
                return true;
            }
            if (c1size > c2size) {
                iterate = c22;
                contains = c12;
            }
        }
        for (Object e2 : iterate) {
            if (contains.contains(e2)) {
                return false;
            }
        }
        return true;
    }

    @SafeVarargs
    public static <T> boolean addAll(Collection<? super T> collection, T... tArr) {
        boolean z10 = false;
        for (T t2 : tArr) {
            z10 |= collection.add((Object) t2);
        }
        return z10;
    }

    public static <E> Set<E> newSetFromMap(Map<E, Boolean> map) {
        return new SetFromMap(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class SetFromMap<E> extends AbstractSet<E> implements Set<E>, Serializable {
        private static final long serialVersionUID = 2454657854757543876L;

        /* renamed from: m, reason: collision with root package name */
        private final Map<E, Boolean> f50442m;

        /* renamed from: s, reason: collision with root package name */
        private transient Set<E> f50443s;

        SetFromMap(Map<E, Boolean> map) {
            if (!map.isEmpty()) {
                throw new IllegalArgumentException("Map is non-empty");
            }
            this.f50442m = map;
            this.f50443s = map.h();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f50442m.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f50442m.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f50442m.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            return this.f50442m.containsKey(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            return this.f50442m.remove(o10) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e2) {
            return this.f50442m.put(e2, Boolean.TRUE) == null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<E> iterator2() {
            return this.f50443s.iterator2();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return this.f50443s.toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) this.f50443s.toArray(tArr);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.f50443s.toString();
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return this.f50443s.hashCode();
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object o10) {
            return o10 == this || this.f50443s.equals(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> c4) {
            return this.f50443s.containsAll(c4);
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> c4) {
            return this.f50443s.removeAll(c4);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> c4) {
            return this.f50443s.retainAll(c4);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super E> action) {
            this.f50443s.forEach(action);
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super E> filter) {
            return this.f50443s.removeIf(filter);
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<E> spliterator() {
            return this.f50443s.spliterator();
        }

        @Override // java.util.Collection
        public Stream<E> stream() {
            return this.f50443s.stream();
        }

        @Override // java.util.Collection
        public Stream<E> parallelStream() {
            return this.f50443s.parallelStream();
        }

        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
            stream.defaultReadObject();
            this.f50443s = this.f50442m.h();
        }
    }

    public static <T> Queue<T> asLifoQueue(Deque<T> deque) {
        return new AsLIFOQueue((Deque) Objects.requireNonNull(deque));
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class AsLIFOQueue<E> extends AbstractQueue<E> implements Queue<E>, Serializable {
        private static final long serialVersionUID = 1802017725587941708L;

        /* renamed from: q, reason: collision with root package name */
        private final Deque<E> f50436q;

        AsLIFOQueue(Deque<E> q10) {
            this.f50436q = q10;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e2) {
            this.f50436q.addFirst(e2);
            return true;
        }

        @Override // java.util.Queue, java.util.concurrent.BlockingQueue
        public boolean offer(E e2) {
            return this.f50436q.offerFirst(e2);
        }

        @Override // java.util.Queue
        public E poll() {
            return this.f50436q.pollFirst();
        }

        @Override // java.util.AbstractQueue, java.util.Queue
        public E remove() {
            return this.f50436q.removeFirst();
        }

        @Override // java.util.Queue
        public E peek() {
            return this.f50436q.peekFirst();
        }

        @Override // java.util.AbstractQueue, java.util.Queue
        public E element() {
            return this.f50436q.getFirst();
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f50436q.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f50436q.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f50436q.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            return this.f50436q.contains(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            return this.f50436q.remove(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<E> iterator2() {
            return this.f50436q.iterator2();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return this.f50436q.toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) this.f50436q.toArray(tArr);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(IntFunction<T[]> intFunction) {
            return (T[]) this.f50436q.toArray(intFunction);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.f50436q.toString();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> c4) {
            return this.f50436q.containsAll(c4);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> c4) {
            return this.f50436q.removeAll(c4);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> c4) {
            return this.f50436q.retainAll(c4);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super E> action) {
            this.f50436q.forEach(action);
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super E> filter) {
            return this.f50436q.removeIf(filter);
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<E> spliterator() {
            return this.f50436q.spliterator();
        }

        @Override // java.util.Collection
        public Stream<E> stream() {
            return this.f50436q.stream();
        }

        @Override // java.util.Collection
        public Stream<E> parallelStream() {
            return this.f50436q.parallelStream();
        }
    }
}
