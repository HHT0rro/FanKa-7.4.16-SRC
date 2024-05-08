package java.util;

import java.util.function.Consumer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {
    protected transient int modCount = 0;

    public abstract E get(int i10);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        add(size(), e2);
        return true;
    }

    public E set(int index, E element) {
        throw new UnsupportedOperationException();
    }

    public void add(int index, E element) {
        throw new UnsupportedOperationException();
    }

    public E remove(int index) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001b, code lost:
    
        if (r0.hasNext() == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0025, code lost:
    
        if (r3.equals(r0.next()) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002b, code lost:
    
        return r0.previousIndex();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:?, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0004, code lost:
    
        if (r3 == null) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        if (r0.hasNext() == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0010, code lost:
    
        if (r0.next() != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
    
        return r0.previousIndex();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int indexOf(java.lang.Object r3) {
        /*
            r2 = this;
            java.util.ListIterator r0 = r2.listIterator()
            if (r3 != 0) goto L17
        L6:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L2c
            java.lang.Object r1 = r0.next()
            if (r1 != 0) goto L6
            int r1 = r0.previousIndex()
            return r1
        L17:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L2c
            java.lang.Object r1 = r0.next()
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L17
            int r1 = r0.previousIndex()
            return r1
        L2c:
            r1 = -1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.AbstractList.indexOf(java.lang.Object):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0030, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001f, code lost:
    
        if (r0.hasPrevious() == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0029, code lost:
    
        if (r3.equals(r0.previous()) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002f, code lost:
    
        return r0.nextIndex();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:?, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0008, code lost:
    
        if (r3 == null) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
    
        if (r0.hasPrevious() == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0014, code lost:
    
        if (r0.previous() != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
    
        return r0.nextIndex();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int lastIndexOf(java.lang.Object r3) {
        /*
            r2 = this;
            int r0 = r2.size()
            java.util.ListIterator r0 = r2.listIterator(r0)
            if (r3 != 0) goto L1b
        La:
            boolean r1 = r0.hasPrevious()
            if (r1 == 0) goto L30
            java.lang.Object r1 = r0.previous()
            if (r1 != 0) goto La
            int r1 = r0.nextIndex()
            return r1
        L1b:
            boolean r1 = r0.hasPrevious()
            if (r1 == 0) goto L30
            java.lang.Object r1 = r0.previous()
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L1b
            int r1 = r0.nextIndex()
            return r1
        L30:
            r1 = -1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.AbstractList.lastIndexOf(java.lang.Object):int");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        removeRange(0, size());
    }

    public boolean addAll(int index, Collection<? extends E> c4) {
        rangeCheckForAdd(index);
        boolean modified = false;
        for (E e2 : c4) {
            add(index, e2);
            modified = true;
            index++;
        }
        return modified;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return new Itr();
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    public ListIterator<E> listIterator(int index) {
        rangeCheckForAdd(index);
        return new ListItr(index);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class Itr implements Iterator<E> {
        int cursor;
        int expectedModCount;
        int lastRet;

        private Itr() {
            this.cursor = 0;
            this.lastRet = -1;
            this.expectedModCount = AbstractList.this.modCount;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != AbstractList.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            checkForComodification();
            try {
                int i10 = this.cursor;
                E e2 = (E) AbstractList.this.get(i10);
                this.lastRet = i10;
                this.cursor = i10 + 1;
                return e2;
            } catch (IndexOutOfBoundsException e10) {
                checkForComodification();
                throw new NoSuchElementException(e10);
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.lastRet < 0) {
                throw new IllegalStateException();
            }
            checkForComodification();
            try {
                AbstractList.this.remove(this.lastRet);
                int i10 = this.lastRet;
                int i11 = this.cursor;
                if (i10 < i11) {
                    this.cursor = i11 - 1;
                }
                this.lastRet = -1;
                this.expectedModCount = AbstractList.this.modCount;
            } catch (IndexOutOfBoundsException e2) {
                throw new ConcurrentModificationException();
            }
        }

        final void checkForComodification() {
            if (AbstractList.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class ListItr extends AbstractList<E>.Itr implements ListIterator<E> {
        ListItr(int index) {
            super();
            this.cursor = index;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.cursor != 0;
        }

        @Override // java.util.ListIterator
        public E previous() {
            checkForComodification();
            try {
                int i10 = this.cursor - 1;
                E e2 = (E) AbstractList.this.get(i10);
                this.cursor = i10;
                this.lastRet = i10;
                return e2;
            } catch (IndexOutOfBoundsException e10) {
                checkForComodification();
                throw new NoSuchElementException(e10);
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

        @Override // java.util.ListIterator
        public void set(E e2) {
            if (this.lastRet < 0) {
                throw new IllegalStateException();
            }
            checkForComodification();
            try {
                AbstractList.this.set(this.lastRet, e2);
                this.expectedModCount = AbstractList.this.modCount;
            } catch (IndexOutOfBoundsException e10) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator
        public void add(E e2) {
            checkForComodification();
            try {
                int i10 = this.cursor;
                AbstractList.this.add(i10, e2);
                this.lastRet = -1;
                this.cursor = i10 + 1;
                this.expectedModCount = AbstractList.this.modCount;
            } catch (IndexOutOfBoundsException e10) {
                throw new ConcurrentModificationException();
            }
        }
    }

    public List<E> subList(int fromIndex, int toIndex) {
        subListRangeCheck(fromIndex, toIndex, size());
        if (this instanceof RandomAccess) {
            return new RandomAccessSubList(this, fromIndex, toIndex);
        }
        return new SubList(this, fromIndex, toIndex);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void subListRangeCheck(int fromIndex, int toIndex, int size) {
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

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object o10) {
        if (o10 == this) {
            return true;
        }
        if (!(o10 instanceof List)) {
            return false;
        }
        ListIterator<E> e12 = listIterator();
        ListIterator<E> listIterator = ((List) o10).listIterator();
        while (e12.hasNext() && listIterator.hasNext()) {
            E o12 = e12.next();
            Object o22 = listIterator.next();
            if (o12 == null) {
                if (o22 != null) {
                    return false;
                }
            } else if (!o12.equals(o22)) {
                return false;
            }
        }
        return (e12.hasNext() || listIterator.hasNext()) ? false : true;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int hashCode = 1;
        Iterator<E> iterator2 = iterator2();
        while (iterator2.hasNext()) {
            E e2 = iterator2.next();
            hashCode = (hashCode * 31) + (e2 == null ? 0 : e2.hashCode());
        }
        return hashCode;
    }

    protected void removeRange(int fromIndex, int toIndex) {
        ListIterator<E> it = listIterator(fromIndex);
        int n10 = toIndex - fromIndex;
        for (int i10 = 0; i10 < n10; i10++) {
            it.next();
            it.remove();
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class RandomAccessSpliterator<E> implements Spliterator<E> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AbstractList<E> alist;
        private int expectedModCount;
        private int fence;
        private int index;
        private final List<E> list;

        /* JADX INFO: Access modifiers changed from: package-private */
        public RandomAccessSpliterator(List<E> list) {
            this.list = list;
            this.index = 0;
            this.fence = -1;
            AbstractList<E> abstractList = list instanceof AbstractList ? (AbstractList) list : null;
            this.alist = abstractList;
            this.expectedModCount = abstractList != null ? abstractList.modCount : 0;
        }

        private RandomAccessSpliterator(RandomAccessSpliterator<E> parent, int origin, int fence) {
            this.list = parent.list;
            this.index = origin;
            this.fence = fence;
            this.alist = parent.alist;
            this.expectedModCount = parent.expectedModCount;
        }

        private int getFence() {
            List<E> lst = this.list;
            int hi = this.fence;
            if (hi >= 0) {
                return hi;
            }
            AbstractList<E> abstractList = this.alist;
            if (abstractList != null) {
                this.expectedModCount = abstractList.modCount;
            }
            int hi2 = lst.size();
            this.fence = hi2;
            return hi2;
        }

        @Override // java.util.Spliterator
        public Spliterator<E> trySplit() {
            int hi = getFence();
            int lo = this.index;
            int mid = (lo + hi) >>> 1;
            if (lo >= mid) {
                return null;
            }
            this.index = mid;
            return new RandomAccessSpliterator(this, lo, mid);
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super E> consumer) {
            if (consumer == null) {
                throw new NullPointerException();
            }
            int fence = getFence();
            int i10 = this.index;
            if (i10 < fence) {
                this.index = i10 + 1;
                consumer.accept((Object) get(this.list, i10));
                checkAbstractListModCount(this.alist, this.expectedModCount);
                return true;
            }
            return false;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super E> consumer) {
            Objects.requireNonNull(consumer);
            List<E> list = this.list;
            int fence = getFence();
            this.index = fence;
            for (int i10 = this.index; i10 < fence; i10++) {
                consumer.accept((Object) get(list, i10));
            }
            checkAbstractListModCount(this.alist, this.expectedModCount);
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return getFence() - this.index;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 16464;
        }

        private static <E> E get(List<E> list, int i10) {
            try {
                return list.get(i10);
            } catch (IndexOutOfBoundsException e2) {
                throw new ConcurrentModificationException();
            }
        }

        static void checkAbstractListModCount(AbstractList<?> alist, int expectedModCount) {
            if (alist != null && alist.modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class SubList<E> extends AbstractList<E> {
        private final int offset;
        private final SubList<E> parent;
        private final AbstractList<E> root;
        protected int size;

        public SubList(AbstractList<E> root, int fromIndex, int toIndex) {
            this.root = root;
            this.parent = null;
            this.offset = fromIndex;
            this.size = toIndex - fromIndex;
            this.modCount = root.modCount;
        }

        protected SubList(SubList<E> parent, int fromIndex, int toIndex) {
            AbstractList<E> abstractList = parent.root;
            this.root = abstractList;
            this.parent = parent;
            this.offset = parent.offset + fromIndex;
            this.size = toIndex - fromIndex;
            this.modCount = abstractList.modCount;
        }

        @Override // java.util.AbstractList, java.util.List
        public E set(int index, E element) {
            Objects.checkIndex(index, this.size);
            checkForComodification();
            return this.root.set(this.offset + index, element);
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int index) {
            Objects.checkIndex(index, this.size);
            checkForComodification();
            return this.root.get(this.offset + index);
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
            AbstractList<E> abstractList = this.root;
            int i10 = this.offset;
            abstractList.removeRange(i10 + fromIndex, i10 + toIndex);
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

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<E> iterator2() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator(int index) {
            checkForComodification();
            rangeCheckForAdd(index);
            return new ListIterator<E>(index) { // from class: java.util.AbstractList.SubList.1

                /* renamed from: i, reason: collision with root package name */
                private final ListIterator<E> f50422i;
                final /* synthetic */ int val$index;

                {
                    this.val$index = index;
                    this.f50422i = SubList.this.root.listIterator(SubList.this.offset + index);
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public boolean hasNext() {
                    return nextIndex() < SubList.this.size;
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public E next() {
                    if (hasNext()) {
                        return this.f50422i.next();
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
                        return this.f50422i.previous();
                    }
                    throw new NoSuchElementException();
                }

                @Override // java.util.ListIterator
                public int nextIndex() {
                    return this.f50422i.nextIndex() - SubList.this.offset;
                }

                @Override // java.util.ListIterator
                public int previousIndex() {
                    return this.f50422i.previousIndex() - SubList.this.offset;
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public void remove() {
                    this.f50422i.remove();
                    SubList.this.updateSizeAndModCount(-1);
                }

                @Override // java.util.ListIterator
                public void set(E e2) {
                    this.f50422i.set(e2);
                }

                @Override // java.util.ListIterator
                public void add(E e2) {
                    this.f50422i.add(e2);
                    SubList.this.updateSizeAndModCount(1);
                }
            };
        }

        @Override // java.util.AbstractList, java.util.List
        public List<E> subList(int fromIndex, int toIndex) {
            subListRangeCheck(fromIndex, toIndex, this.size);
            return new SubList((SubList) this, fromIndex, toIndex);
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

        /* JADX INFO: Access modifiers changed from: private */
        public void updateSizeAndModCount(int sizeChange) {
            SubList<E> slist = this;
            do {
                slist.size += sizeChange;
                slist.modCount = this.root.modCount;
                slist = slist.parent;
            } while (slist != null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class RandomAccessSubList<E> extends SubList<E> implements RandomAccess {
        RandomAccessSubList(AbstractList<E> root, int fromIndex, int toIndex) {
            super(root, fromIndex, toIndex);
        }

        RandomAccessSubList(RandomAccessSubList<E> parent, int fromIndex, int toIndex) {
            super((SubList) parent, fromIndex, toIndex);
        }

        @Override // java.util.AbstractList.SubList, java.util.AbstractList, java.util.List
        public List<E> subList(int fromIndex, int toIndex) {
            subListRangeCheck(fromIndex, toIndex, this.size);
            return new RandomAccessSubList((RandomAccessSubList) this, fromIndex, toIndex);
        }
    }
}
