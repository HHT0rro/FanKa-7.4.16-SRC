package java.util;

import java.lang.Enum;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class JumboEnumSet<E extends Enum<E>> extends EnumSet<E> {
    private static final long serialVersionUID = 334349849919042784L;
    private long[] elements;
    private int size;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JumboEnumSet(Class<E> elementType, Enum<?>[] universe) {
        super(elementType, universe);
        this.size = 0;
        this.elements = new long[(universe.length + 63) >>> 6];
    }

    @Override // java.util.EnumSet
    void addRange(E from, E to) {
        int fromIndex = from.ordinal() >>> 6;
        int toIndex = to.ordinal() >>> 6;
        if (fromIndex != toIndex) {
            this.elements[fromIndex] = (-1) << from.ordinal();
            for (int i10 = fromIndex + 1; i10 < toIndex; i10++) {
                this.elements[i10] = -1;
            }
            this.elements[toIndex] = (-1) >>> (63 - to.ordinal());
        } else {
            this.elements[fromIndex] = ((-1) >>> ((from.ordinal() - to.ordinal()) - 1)) << from.ordinal();
        }
        this.size = (to.ordinal() - from.ordinal()) + 1;
    }

    @Override // java.util.EnumSet
    void addAll() {
        int i10 = 0;
        while (true) {
            long[] jArr = this.elements;
            if (i10 < jArr.length) {
                jArr[i10] = -1;
                i10++;
            } else {
                int i11 = jArr.length;
                int i12 = i11 - 1;
                jArr[i12] = jArr[i12] >>> (-this.universe.length);
                this.size = this.universe.length;
                return;
            }
        }
    }

    @Override // java.util.EnumSet
    void complement() {
        int i10 = 0;
        while (true) {
            long[] jArr = this.elements;
            if (i10 < jArr.length) {
                jArr[i10] = ~jArr[i10];
                i10++;
            } else {
                int i11 = jArr.length;
                int i12 = i11 - 1;
                jArr[i12] = jArr[i12] & ((-1) >>> (-this.universe.length));
                this.size = this.universe.length - this.size;
                return;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return new EnumSetIterator();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class EnumSetIterator<E extends Enum<E>> implements Iterator<E> {
        long unseen;
        int unseenIndex = 0;
        long lastReturned = 0;
        int lastReturnedIndex = 0;

        EnumSetIterator() {
            this.unseen = JumboEnumSet.this.elements[0];
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (this.unseen == 0 && this.unseenIndex < JumboEnumSet.this.elements.length - 1) {
                long[] jArr = JumboEnumSet.this.elements;
                int i10 = this.unseenIndex + 1;
                this.unseenIndex = i10;
                this.unseen = jArr[i10];
            }
            return this.unseen != 0;
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            long j10 = this.unseen;
            long j11 = (-j10) & j10;
            this.lastReturned = j11;
            this.lastReturnedIndex = this.unseenIndex;
            this.unseen = j10 - j11;
            return (E) JumboEnumSet.this.universe[(this.lastReturnedIndex << 6) + Long.numberOfTrailingZeros(this.lastReturned)];
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.lastReturned == 0) {
                throw new IllegalStateException();
            }
            long oldElements = JumboEnumSet.this.elements[this.lastReturnedIndex];
            long[] jArr = JumboEnumSet.this.elements;
            int i10 = this.lastReturnedIndex;
            jArr[i10] = jArr[i10] & (~this.lastReturned);
            if (oldElements != JumboEnumSet.this.elements[this.lastReturnedIndex]) {
                JumboEnumSet jumboEnumSet = JumboEnumSet.this;
                jumboEnumSet.size--;
            }
            this.lastReturned = 0L;
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
    public boolean contains(Object e2) {
        if (e2 == null) {
            return false;
        }
        Class<?> eClass = e2.getClass();
        if (eClass != this.elementType && eClass.getSuperclass() != this.elementType) {
            return false;
        }
        int eOrdinal = ((Enum) e2).ordinal();
        return (this.elements[eOrdinal >>> 6] & (1 << eOrdinal)) != 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        typeCheck(e2);
        int eOrdinal = e2.ordinal();
        int eWordNum = eOrdinal >>> 6;
        long[] jArr = this.elements;
        long oldElements = jArr[eWordNum];
        long j10 = jArr[eWordNum] | (1 << eOrdinal);
        jArr[eWordNum] = j10;
        boolean result = j10 != oldElements;
        if (result) {
            this.size++;
        }
        return result;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object e2) {
        if (e2 == null) {
            return false;
        }
        Class<?> eClass = e2.getClass();
        if (eClass != this.elementType && eClass.getSuperclass() != this.elementType) {
            return false;
        }
        int eOrdinal = ((Enum) e2).ordinal();
        int eWordNum = eOrdinal >>> 6;
        long[] jArr = this.elements;
        long oldElements = jArr[eWordNum];
        long j10 = jArr[eWordNum] & (~(1 << eOrdinal));
        jArr[eWordNum] = j10;
        boolean result = j10 != oldElements;
        if (result) {
            this.size--;
        }
        return result;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> c4) {
        if (!(c4 instanceof JumboEnumSet)) {
            return super.containsAll(c4);
        }
        JumboEnumSet<?> es = (JumboEnumSet) c4;
        if (es.elementType != this.elementType) {
            return es.isEmpty();
        }
        int i10 = 0;
        while (true) {
            long[] jArr = this.elements;
            if (i10 >= jArr.length) {
                return true;
            }
            if ((es.elements[i10] & (~jArr[i10])) == 0) {
                i10++;
            } else {
                return false;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> c4) {
        if (!(c4 instanceof JumboEnumSet)) {
            return super.addAll(c4);
        }
        JumboEnumSet<?> es = (JumboEnumSet) c4;
        if (es.elementType != this.elementType) {
            if (es.isEmpty()) {
                return false;
            }
            throw new ClassCastException(((Object) es.elementType) + " != " + ((Object) this.elementType));
        }
        int i10 = 0;
        while (true) {
            long[] jArr = this.elements;
            if (i10 < jArr.length) {
                jArr[i10] = jArr[i10] | es.elements[i10];
                i10++;
            } else {
                return recalculateSize();
            }
        }
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> c4) {
        if (!(c4 instanceof JumboEnumSet)) {
            return super.removeAll(c4);
        }
        JumboEnumSet<?> es = (JumboEnumSet) c4;
        if (es.elementType != this.elementType) {
            return false;
        }
        int i10 = 0;
        while (true) {
            long[] jArr = this.elements;
            if (i10 < jArr.length) {
                jArr[i10] = jArr[i10] & (~es.elements[i10]);
                i10++;
            } else {
                return recalculateSize();
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> c4) {
        if (!(c4 instanceof JumboEnumSet)) {
            return super.retainAll(c4);
        }
        JumboEnumSet<?> es = (JumboEnumSet) c4;
        if (es.elementType != this.elementType) {
            boolean changed = this.size != 0;
            clear();
            return changed;
        }
        int i10 = 0;
        while (true) {
            long[] jArr = this.elements;
            if (i10 < jArr.length) {
                jArr[i10] = jArr[i10] & es.elements[i10];
                i10++;
            } else {
                return recalculateSize();
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        Arrays.fill(this.elements, 0L);
        this.size = 0;
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public boolean equals(Object o10) {
        if (!(o10 instanceof JumboEnumSet)) {
            return super.equals(o10);
        }
        JumboEnumSet<?> es = (JumboEnumSet) o10;
        if (es.elementType != this.elementType) {
            return this.size == 0 && es.size == 0;
        }
        return Arrays.equals(es.elements, this.elements);
    }

    private boolean recalculateSize() {
        int oldSize = this.size;
        this.size = 0;
        for (long elt : this.elements) {
            this.size += Long.bitCount(elt);
        }
        return this.size != oldSize;
    }

    @Override // java.util.EnumSet
    public EnumSet<E> clone() {
        JumboEnumSet<E> result = (JumboEnumSet) super.clone();
        result.elements = (long[]) result.elements.clone();
        return result;
    }
}
