package java.util;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ImmutableCollections {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object EMPTY;
    static final ListN<?> EMPTY_LIST;
    static final ListN<?> EMPTY_LIST_NULLS;
    static final MapN<?, ?> EMPTY_MAP;
    static final SetN<?> EMPTY_SET;
    static final int EXPAND_FACTOR = 2;
    private static final boolean REVERSE;
    private static final long SALT32L;

    static {
        long seed = System.nanoTime();
        long j10 = ((int) ((2611923443488327891L * seed) >> 16)) & 4294967295L;
        SALT32L = j10;
        boolean z10 = true;
        boolean z11 = false;
        REVERSE = (j10 & 1) == 0;
        EMPTY = new Object();
        EMPTY_LIST = new ListN<>(new Object[0], z11);
        EMPTY_LIST_NULLS = new ListN<>(new Object[0], z10);
        EMPTY_SET = new SetN<>(new Object[0]);
        EMPTY_MAP = new MapN<>(new Object[0]);
    }

    private ImmutableCollections() {
    }

    static UnsupportedOperationException uoe() {
        return new UnsupportedOperationException();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static abstract class AbstractImmutableCollection<E> extends AbstractCollection<E> {
        AbstractImmutableCollection() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e2) {
            throw ImmutableCollections.uoe();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends E> c4) {
            throw ImmutableCollections.uoe();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            throw ImmutableCollections.uoe();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            throw ImmutableCollections.uoe();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> c4) {
            throw ImmutableCollections.uoe();
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super E> filter) {
            throw ImmutableCollections.uoe();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> c4) {
            throw ImmutableCollections.uoe();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> List<E> listCopy(Collection<? extends E> coll) {
        if ((coll instanceof List12) || ((coll instanceof ListN) && !((ListN) coll).allowNulls)) {
            return (List) coll;
        }
        return List.of(coll.toArray());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeVarargs
    public static <E> List<E> listFromArray(E... input) {
        Object[] objArr = new Object[input.length];
        for (int i10 = 0; i10 < input.length; i10++) {
            objArr[i10] = Objects.requireNonNull(input[i10]);
        }
        return new ListN(objArr, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> List<E> listFromTrustedArray(Object... input) {
        boolean z10 = false;
        for (Object o10 : input) {
            Objects.requireNonNull(o10);
        }
        switch (input.length) {
            case 0:
                return EMPTY_LIST;
            case 1:
                return new List12(input[0]);
            case 2:
                return new List12(input[0], input[1]);
            default:
                return new ListN(input, z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> List<E> listFromTrustedArrayNullsAllowed(Object... input) {
        if (input.length == 0) {
            return EMPTY_LIST_NULLS;
        }
        return new ListN(input, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class AbstractImmutableList<E> extends AbstractImmutableCollection<E> implements List<E>, RandomAccess {
        AbstractImmutableList() {
        }

        @Override // java.util.List
        public void add(int index, E element) {
            throw ImmutableCollections.uoe();
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends E> c4) {
            throw ImmutableCollections.uoe();
        }

        @Override // java.util.List
        public E remove(int index) {
            throw ImmutableCollections.uoe();
        }

        @Override // java.util.List
        public void replaceAll(UnaryOperator<E> operator) {
            throw ImmutableCollections.uoe();
        }

        @Override // java.util.List
        public E set(int index, E element) {
            throw ImmutableCollections.uoe();
        }

        @Override // java.util.List
        public void sort(Comparator<? super E> c4) {
            throw ImmutableCollections.uoe();
        }

        @Override // java.util.List
        public List<E> subList(int fromIndex, int toIndex) {
            int size = size();
            subListRangeCheck(fromIndex, toIndex, size);
            return SubList.fromList(this, fromIndex, toIndex);
        }

        static void subListRangeCheck(int fromIndex, int toIndex, int size) {
            if (fromIndex < 0) {
                throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
            }
            if (toIndex > size) {
                throw new IndexOutOfBoundsException("toIndex = " + toIndex);
            }
            if (fromIndex > toIndex) {
                throw new IllegalArgumentException("fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<E> iterator2() {
            return new ListItr(this, size());
        }

        @Override // java.util.List
        public ListIterator<E> listIterator() {
            return listIterator(0);
        }

        @Override // java.util.List
        public ListIterator<E> listIterator(int index) {
            int size = size();
            if (index < 0 || index > size) {
                throw outOfBounds(index);
            }
            return new ListItr(this, size, index);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object o10) {
            if (o10 == this) {
                return true;
            }
            if (!(o10 instanceof List)) {
                return false;
            }
            Iterator<E> iterator2 = ((List) o10).iterator2();
            int s2 = size();
            for (int i10 = 0; i10 < s2; i10++) {
                if (!iterator2.hasNext() || !Objects.equals(get(i10), iterator2.next())) {
                    return false;
                }
            }
            return true ^ iterator2.hasNext();
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int hash = 1;
            int s2 = size();
            for (int i10 = 0; i10 < s2; i10++) {
                hash = (hash * 31) + Objects.hashCode(get(i10));
            }
            return hash;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            return indexOf(o10) >= 0;
        }

        IndexOutOfBoundsException outOfBounds(int index) {
            return new IndexOutOfBoundsException("Index: " + index + " Size: " + size());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class ListItr<E> implements ListIterator<E> {
        private int cursor;
        private final boolean isListIterator;
        private final List<E> list;
        private final int size;

        ListItr(List<E> list, int size) {
            this.list = list;
            this.size = size;
            this.cursor = 0;
            this.isListIterator = false;
        }

        ListItr(List<E> list, int size, int index) {
            this.list = list;
            this.size = size;
            this.cursor = index;
            this.isListIterator = true;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.cursor != this.size;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            try {
                int i10 = this.cursor;
                E next = this.list.get(i10);
                this.cursor = i10 + 1;
                return next;
            } catch (IndexOutOfBoundsException e2) {
                throw new NoSuchElementException();
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw ImmutableCollections.uoe();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            if (this.isListIterator) {
                return this.cursor != 0;
            }
            throw ImmutableCollections.uoe();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (!this.isListIterator) {
                throw ImmutableCollections.uoe();
            }
            try {
                int i10 = this.cursor - 1;
                E previous = this.list.get(i10);
                this.cursor = i10;
                return previous;
            } catch (IndexOutOfBoundsException e2) {
                throw new NoSuchElementException();
            }
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            if (!this.isListIterator) {
                throw ImmutableCollections.uoe();
            }
            return this.cursor;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            if (!this.isListIterator) {
                throw ImmutableCollections.uoe();
            }
            return this.cursor - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e2) {
            throw ImmutableCollections.uoe();
        }

        @Override // java.util.ListIterator
        public void add(E e2) {
            throw ImmutableCollections.uoe();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class SubList<E> extends AbstractImmutableList<E> implements RandomAccess {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final int offset;
        private final AbstractImmutableList<E> root;
        private final int size;

        private SubList(AbstractImmutableList<E> root, int offset, int size) {
            this.root = root;
            this.offset = offset;
            this.size = size;
        }

        static <E> SubList<E> fromSubList(SubList<E> parent, int fromIndex, int toIndex) {
            return new SubList<>(((SubList) parent).root, ((SubList) parent).offset + fromIndex, toIndex - fromIndex);
        }

        static <E> SubList<E> fromList(AbstractImmutableList<E> list, int fromIndex, int toIndex) {
            return new SubList<>(list, fromIndex, toIndex - fromIndex);
        }

        @Override // java.util.List
        public E get(int index) {
            Objects.checkIndex(index, this.size);
            return this.root.get(this.offset + index);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.size;
        }

        @Override // java.util.ImmutableCollections.AbstractImmutableList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<E> iterator2() {
            return new ListItr(this, size());
        }

        @Override // java.util.ImmutableCollections.AbstractImmutableList, java.util.List
        public ListIterator<E> listIterator(int index) {
            rangeCheck(index);
            return new ListItr(this, size(), index);
        }

        @Override // java.util.ImmutableCollections.AbstractImmutableList, java.util.List
        public List<E> subList(int fromIndex, int toIndex) {
            subListRangeCheck(fromIndex, toIndex, this.size);
            return fromSubList(this, fromIndex, toIndex);
        }

        private void rangeCheck(int index) {
            if (index < 0 || index > this.size) {
                throw outOfBounds(index);
            }
        }

        private boolean allowNulls() {
            AbstractImmutableList<E> abstractImmutableList = this.root;
            return (abstractImmutableList instanceof ListN) && ((ListN) abstractImmutableList).allowNulls;
        }

        @Override // java.util.List
        public int indexOf(Object o10) {
            if (!allowNulls() && o10 == null) {
                throw new NullPointerException();
            }
            int s2 = size();
            for (int i10 = 0; i10 < s2; i10++) {
                if (Objects.equals(o10, get(i10))) {
                    return i10;
                }
            }
            return -1;
        }

        @Override // java.util.List
        public int lastIndexOf(Object o10) {
            if (!allowNulls() && o10 == null) {
                throw new NullPointerException();
            }
            for (int i10 = size() - 1; i10 >= 0; i10--) {
                if (Objects.equals(o10, get(i10))) {
                    return i10;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            Object[] array = new Object[this.size];
            for (int i10 = 0; i10 < this.size; i10++) {
                array[i10] = get(i10);
            }
            return array;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            int i10;
            Object[] objArr = tArr.length >= this.size ? tArr : (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.size));
            int i11 = 0;
            while (true) {
                i10 = this.size;
                if (i11 >= i10) {
                    break;
                }
                objArr[i11] = get(i11);
                i11++;
            }
            if (objArr.length > i10) {
                objArr[i10] = null;
            }
            return (T[]) objArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class List12<E> extends AbstractImmutableList<E> implements Serializable {

        /* renamed from: e0, reason: collision with root package name */
        private final E f50474e0;

        /* renamed from: e1, reason: collision with root package name */
        private final Object f50475e1;

        /* JADX INFO: Access modifiers changed from: package-private */
        public List12(E e2) {
            this.f50474e0 = (E) Objects.requireNonNull(e2);
            this.f50475e1 = ImmutableCollections.EMPTY;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public List12(E e2, E e10) {
            this.f50474e0 = (E) Objects.requireNonNull(e2);
            this.f50475e1 = Objects.requireNonNull(e10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f50475e1 != ImmutableCollections.EMPTY ? 2 : 1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.List
        public E get(int i10) {
            if (i10 == 0) {
                return this.f50474e0;
            }
            if (i10 == 1 && this.f50475e1 != ImmutableCollections.EMPTY) {
                return (E) this.f50475e1;
            }
            throw outOfBounds(i10);
        }

        @Override // java.util.List
        public int indexOf(Object o10) {
            Objects.requireNonNull(o10);
            if (o10.equals(this.f50474e0)) {
                return 0;
            }
            if (this.f50475e1 != ImmutableCollections.EMPTY && o10.equals(this.f50475e1)) {
                return 1;
            }
            return -1;
        }

        @Override // java.util.List
        public int lastIndexOf(Object o10) {
            Objects.requireNonNull(o10);
            if (this.f50475e1 != ImmutableCollections.EMPTY && o10.equals(this.f50475e1)) {
                return 1;
            }
            if (o10.equals(this.f50474e0)) {
                return 0;
            }
            return -1;
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            throw new InvalidObjectException("not serial proxy");
        }

        private Object writeReplace() {
            if (this.f50475e1 == ImmutableCollections.EMPTY) {
                return new CollSer(1, this.f50474e0);
            }
            return new CollSer(1, this.f50474e0, this.f50475e1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            if (this.f50475e1 == ImmutableCollections.EMPTY) {
                return new Object[]{this.f50474e0};
            }
            return new Object[]{this.f50474e0, this.f50475e1};
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            int size = size();
            Object[] objArr = tArr.length >= size ? tArr : (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
            objArr[0] = this.f50474e0;
            if (size == 2) {
                objArr[1] = this.f50475e1;
            }
            if (objArr.length > size) {
                objArr[size] = null;
            }
            return (T[]) objArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class ListN<E> extends AbstractImmutableList<E> implements Serializable {
        private final boolean allowNulls;
        private final E[] elements;

        private ListN(E[] elements, boolean allowNulls) {
            this.elements = elements;
            this.allowNulls = allowNulls;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.elements.length == 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.elements.length;
        }

        @Override // java.util.List
        public E get(int index) {
            return this.elements[index];
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            throw new InvalidObjectException("not serial proxy");
        }

        private Object writeReplace() {
            return new CollSer(this.allowNulls ? 4 : 1, this.elements);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            E[] eArr = this.elements;
            return Arrays.copyOf(eArr, eArr.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            E[] eArr = this.elements;
            int length = eArr.length;
            if (tArr.length < length) {
                return (T[]) Arrays.copyOf(eArr, length, tArr.getClass());
            }
            System.arraycopy(eArr, 0, tArr, 0, length);
            if (tArr.length > length) {
                tArr[length] = null;
            }
            return tArr;
        }

        @Override // java.util.List
        public int indexOf(Object o10) {
            if (!this.allowNulls && o10 == null) {
                throw new NullPointerException();
            }
            Object[] es = this.elements;
            for (int i10 = 0; i10 < es.length; i10++) {
                if (Objects.equals(o10, es[i10])) {
                    return i10;
                }
            }
            return -1;
        }

        @Override // java.util.List
        public int lastIndexOf(Object o10) {
            if (!this.allowNulls && o10 == null) {
                throw new NullPointerException();
            }
            Object[] es = this.elements;
            for (int i10 = es.length - 1; i10 >= 0; i10--) {
                if (Objects.equals(o10, es[i10])) {
                    return i10;
                }
            }
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class AbstractImmutableSet<E> extends AbstractImmutableCollection<E> implements Set<E> {
        @Override // java.util.Collection, java.util.Set
        public abstract int hashCode();

        AbstractImmutableSet() {
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object o10) {
            if (o10 == this) {
                return true;
            }
            if (!(o10 instanceof Set)) {
                return false;
            }
            Collection<?> c4 = (Collection) o10;
            if (c4.size() != size()) {
                return false;
            }
            for (Object e2 : c4) {
                if (e2 == null || !contains(e2)) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class Set12<E> extends AbstractImmutableSet<E> implements Serializable {

        /* renamed from: e0, reason: collision with root package name */
        private final E f50478e0;

        /* renamed from: e1, reason: collision with root package name */
        private final Object f50479e1;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Set12(E e2) {
            this.f50478e0 = (E) Objects.requireNonNull(e2);
            this.f50479e1 = ImmutableCollections.EMPTY;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Set12(E e02, E e12) {
            if (e02.equals(Objects.requireNonNull(e12))) {
                throw new IllegalArgumentException("duplicate element: " + ((Object) e02));
            }
            this.f50478e0 = e02;
            this.f50479e1 = e12;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f50479e1 == ImmutableCollections.EMPTY ? 1 : 2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            return o10.equals(this.f50478e0) || this.f50479e1.equals(o10);
        }

        @Override // java.util.ImmutableCollections.AbstractImmutableSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return this.f50478e0.hashCode() + (this.f50479e1 == ImmutableCollections.EMPTY ? 0 : this.f50479e1.hashCode());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<E> iterator2() {
            return new Iterator<E>() { // from class: java.util.ImmutableCollections.Set12.1
                private int idx;

                {
                    this.idx = Set12.this.f50479e1 == ImmutableCollections.EMPTY ? 1 : 2;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.idx > 0;
                }

                @Override // java.util.Iterator
                public E next() {
                    int i10 = this.idx;
                    if (i10 == 1) {
                        this.idx = 0;
                        return (ImmutableCollections.REVERSE || Set12.this.f50479e1 == ImmutableCollections.EMPTY) ? (E) Set12.this.f50478e0 : (E) Set12.this.f50479e1;
                    }
                    if (i10 == 2) {
                        this.idx = 1;
                        return ImmutableCollections.REVERSE ? (E) Set12.this.f50479e1 : (E) Set12.this.f50478e0;
                    }
                    throw new NoSuchElementException();
                }
            };
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            throw new InvalidObjectException("not serial proxy");
        }

        private Object writeReplace() {
            if (this.f50479e1 == ImmutableCollections.EMPTY) {
                return new CollSer(2, this.f50478e0);
            }
            return new CollSer(2, this.f50478e0, this.f50479e1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            if (this.f50479e1 == ImmutableCollections.EMPTY) {
                return new Object[]{this.f50478e0};
            }
            if (ImmutableCollections.REVERSE) {
                return new Object[]{this.f50479e1, this.f50478e0};
            }
            return new Object[]{this.f50478e0, this.f50479e1};
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            int size = size();
            Object[] objArr = tArr.length >= size ? tArr : (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
            if (size == 1) {
                objArr[0] = this.f50478e0;
            } else if (ImmutableCollections.REVERSE) {
                objArr[0] = this.f50479e1;
                objArr[1] = this.f50478e0;
            } else {
                objArr[0] = this.f50478e0;
                objArr[1] = this.f50479e1;
            }
            if (objArr.length > size) {
                objArr[size] = null;
            }
            return (T[]) objArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class SetN<E> extends AbstractImmutableSet<E> implements Serializable {
        final E[] elements;
        final int size;

        /* JADX INFO: Access modifiers changed from: package-private */
        @SafeVarargs
        public SetN(E... eArr) {
            this.size = eArr.length;
            this.elements = (E[]) new Object[eArr.length * 2];
            for (E e2 : eArr) {
                int probe = probe(e2);
                if (probe >= 0) {
                    throw new IllegalArgumentException("duplicate element: " + ((Object) e2));
                }
                this.elements[-(probe + 1)] = e2;
            }
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
            Objects.requireNonNull(o10);
            return this.size > 0 && probe(o10) >= 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public final class SetNIterator implements Iterator<E> {
            private int idx;
            private int remaining;

            SetNIterator() {
                this.remaining = SetN.this.size;
                this.idx = (int) ((ImmutableCollections.SALT32L * SetN.this.elements.length) >>> 32);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.remaining > 0;
            }

            @Override // java.util.Iterator
            public E next() {
                E element;
                if (this.remaining > 0) {
                    int idx = this.idx;
                    int len = SetN.this.elements.length;
                    do {
                        if (ImmutableCollections.REVERSE) {
                            idx++;
                            if (idx >= len) {
                                idx = 0;
                            }
                        } else {
                            idx--;
                            if (idx < 0) {
                                idx = len - 1;
                            }
                        }
                        element = SetN.this.elements[idx];
                    } while (element == null);
                    this.idx = idx;
                    this.remaining--;
                    return element;
                }
                throw new NoSuchElementException();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<E> iterator2() {
            return new SetNIterator();
        }

        @Override // java.util.ImmutableCollections.AbstractImmutableSet, java.util.Collection, java.util.Set
        public int hashCode() {
            int h10 = 0;
            for (E e2 : this.elements) {
                if (e2 != null) {
                    h10 += e2.hashCode();
                }
            }
            return h10;
        }

        private int probe(Object pe) {
            int idx = Math.floorMod(pe.hashCode(), this.elements.length);
            while (true) {
                E ee2 = this.elements[idx];
                if (ee2 == null) {
                    return (-idx) - 1;
                }
                if (pe.equals(ee2)) {
                    return idx;
                }
                idx++;
                if (idx == this.elements.length) {
                    idx = 0;
                }
            }
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            throw new InvalidObjectException("not serial proxy");
        }

        private Object writeReplace() {
            Object[] array = new Object[this.size];
            int dest = 0;
            for (Object o10 : this.elements) {
                if (o10 != null) {
                    array[dest] = o10;
                    dest++;
                }
            }
            return new CollSer(2, array);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            Object[] array = new Object[this.size];
            Iterator<E> it = iterator2();
            for (int i10 = 0; i10 < this.size; i10++) {
                array[i10] = it.next();
            }
            return array;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            int i10;
            Object[] objArr = tArr.length >= this.size ? tArr : (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.size));
            Iterator<E> iterator2 = iterator2();
            int i11 = 0;
            while (true) {
                i10 = this.size;
                if (i11 >= i10) {
                    break;
                }
                objArr[i11] = iterator2.next();
                i11++;
            }
            if (objArr.length > i10) {
                objArr[i10] = null;
            }
            return (T[]) objArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class AbstractImmutableMap<K, V> extends AbstractMap<K, V> implements Serializable {
        AbstractImmutableMap() {
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            throw ImmutableCollections.uoe();
        }

        @Override // java.util.Map
        public V compute(K key, BiFunction<? super K, ? super V, ? extends V> rf) {
            throw ImmutableCollections.uoe();
        }

        @Override // java.util.Map
        public V computeIfAbsent(K key, Function<? super K, ? extends V> mf) {
            throw ImmutableCollections.uoe();
        }

        @Override // java.util.Map
        public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> rf) {
            throw ImmutableCollections.uoe();
        }

        @Override // java.util.Map
        public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> rf) {
            throw ImmutableCollections.uoe();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K key, V value) {
            throw ImmutableCollections.uoe();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void putAll(Map<? extends K, ? extends V> m10) {
            throw ImmutableCollections.uoe();
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public V putIfAbsent(K key, V value) {
            throw ImmutableCollections.uoe();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object key) {
            throw ImmutableCollections.uoe();
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public boolean remove(Object key, Object value) {
            throw ImmutableCollections.uoe();
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public V replace(K key, V value) {
            throw ImmutableCollections.uoe();
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public boolean replace(K key, V oldValue, V newValue) {
            throw ImmutableCollections.uoe();
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super V, ? extends V> f10) {
            throw ImmutableCollections.uoe();
        }

        @Override // java.util.Map
        public V getOrDefault(Object key, V defaultValue) {
            V v2 = get(key);
            if (v2 != null) {
                return v2;
            }
            return defaultValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class Map1<K, V> extends AbstractImmutableMap<K, V> {

        /* renamed from: k0, reason: collision with root package name */
        private final K f50476k0;

        /* renamed from: v0, reason: collision with root package name */
        private final V f50477v0;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Map1(K k10, V v2) {
            this.f50476k0 = (K) Objects.requireNonNull(k10);
            this.f50477v0 = (V) Objects.requireNonNull(v2);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return Set.of(new KeyValueHolder(this.f50476k0, this.f50477v0));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object o10) {
            if (o10.equals(this.f50476k0)) {
                return this.f50477v0;
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object o10) {
            return o10.equals(this.f50476k0);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(Object o10) {
            return o10.equals(this.f50477v0);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return 1;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return false;
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            throw new InvalidObjectException("not serial proxy");
        }

        private Object writeReplace() {
            return new CollSer(3, this.f50476k0, this.f50477v0);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.f50476k0.hashCode() ^ this.f50477v0.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class MapN<K, V> extends AbstractImmutableMap<K, V> {
        final int size;
        final Object[] table;

        /* JADX INFO: Access modifiers changed from: package-private */
        public MapN(Object... input) {
            if ((input.length & 1) != 0) {
                throw new InternalError("length is odd");
            }
            this.size = input.length >> 1;
            int len = input.length * 2;
            this.table = new Object[(len + 1) & (-2)];
            for (int i10 = 0; i10 < input.length; i10 += 2) {
                Object requireNonNull = Objects.requireNonNull(input[i10]);
                Object requireNonNull2 = Objects.requireNonNull(input[i10 + 1]);
                int idx = probe(requireNonNull);
                if (idx >= 0) {
                    throw new IllegalArgumentException("duplicate key: " + requireNonNull);
                }
                int dest = -(idx + 1);
                Object[] objArr = this.table;
                objArr[dest] = requireNonNull;
                objArr[dest + 1] = requireNonNull2;
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object o10) {
            Objects.requireNonNull(o10);
            return this.size > 0 && probe(o10) >= 0;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(Object o10) {
            Objects.requireNonNull(o10);
            int i10 = 1;
            while (true) {
                Object[] objArr = this.table;
                if (i10 < objArr.length) {
                    Object v2 = objArr[i10];
                    if (v2 == null || !o10.equals(v2)) {
                        i10 += 2;
                    } else {
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            int hash = 0;
            int i10 = 0;
            while (true) {
                Object[] objArr = this.table;
                if (i10 < objArr.length) {
                    Object k10 = objArr[i10];
                    if (k10 != null) {
                        hash += k10.hashCode() ^ this.table[i10 + 1].hashCode();
                    }
                    i10 += 2;
                } else {
                    return hash;
                }
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            if (this.size == 0) {
                Objects.requireNonNull(obj);
                return null;
            }
            int probe = probe(obj);
            if (probe >= 0) {
                return (V) this.table[probe + 1];
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.size;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.size == 0;
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        class MapNIterator implements Iterator<Map.Entry<K, V>> {
            private int idx;
            private int remaining;

            MapNIterator() {
                this.remaining = MapN.this.size;
                this.idx = ((int) ((ImmutableCollections.SALT32L * (MapN.this.table.length >> 1)) >>> 32)) << 1;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.remaining > 0;
            }

            private int nextIndex() {
                int idx;
                int idx2 = this.idx;
                if (ImmutableCollections.REVERSE) {
                    idx = idx2 + 2;
                    if (idx >= MapN.this.table.length) {
                        idx = 0;
                    }
                } else {
                    idx = idx2 - 2;
                    if (idx < 0) {
                        idx = MapN.this.table.length - 2;
                    }
                }
                this.idx = idx;
                return idx;
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                Object[] objArr;
                int idx;
                if (this.remaining <= 0) {
                    throw new NoSuchElementException();
                }
                do {
                    objArr = MapN.this.table;
                    idx = nextIndex();
                } while (objArr[idx] == null);
                Map.Entry<K, V> e2 = new KeyValueHolder<>(MapN.this.table[idx], MapN.this.table[idx + 1]);
                this.remaining--;
                return e2;
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new AbstractSet<Map.Entry<K, V>>() { // from class: java.util.ImmutableCollections.MapN.1
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return MapN.this.size;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
                /* renamed from: iterator */
                public Iterator<Map.Entry<K, V>> iterator2() {
                    return new MapNIterator();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public void clear() {
                    throw ImmutableCollections.uoe();
                }
            };
        }

        private int probe(Object pk) {
            int idx = Math.floorMod(pk.hashCode(), this.table.length >> 1) << 1;
            while (true) {
                Object obj = this.table[idx];
                if (obj == null) {
                    return (-idx) - 1;
                }
                if (pk.equals(obj)) {
                    return idx;
                }
                idx += 2;
                if (idx == this.table.length) {
                    idx = 0;
                }
            }
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            throw new InvalidObjectException("not serial proxy");
        }

        private Object writeReplace() {
            Object[] array = new Object[this.size * 2];
            int len = this.table.length;
            int dest = 0;
            for (int i10 = 0; i10 < len; i10 += 2) {
                Object[] objArr = this.table;
                Object obj = objArr[i10];
                if (obj != null) {
                    int dest2 = dest + 1;
                    array[dest] = obj;
                    dest = dest2 + 1;
                    array[dest2] = objArr[i10 + 1];
                }
            }
            return new CollSer(3, array);
        }
    }
}
