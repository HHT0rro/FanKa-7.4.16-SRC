package java.util;

import java.lang.Enum;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class RegularEnumSet<E extends Enum<E>> extends EnumSet<E> {
    private static final long serialVersionUID = 3411599620347842686L;
    private long elements;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegularEnumSet(Class<E> elementType, Enum<?>[] universe) {
        super(elementType, universe);
        this.elements = 0L;
    }

    @Override // java.util.EnumSet
    void addRange(E from, E to) {
        this.elements = ((-1) >>> ((from.ordinal() - to.ordinal()) - 1)) << from.ordinal();
    }

    @Override // java.util.EnumSet
    void addAll() {
        if (this.universe.length != 0) {
            this.elements = (-1) >>> (-this.universe.length);
        }
    }

    @Override // java.util.EnumSet
    void complement() {
        if (this.universe.length != 0) {
            long j10 = ~this.elements;
            this.elements = j10;
            this.elements = j10 & ((-1) >>> (-this.universe.length));
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
        long lastReturned = 0;
        long unseen;

        EnumSetIterator() {
            this.unseen = RegularEnumSet.this.elements;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.unseen != 0;
        }

        @Override // java.util.Iterator
        public E next() {
            long j10 = this.unseen;
            if (j10 == 0) {
                throw new NoSuchElementException();
            }
            long j11 = (-j10) & j10;
            this.lastReturned = j11;
            this.unseen = j10 - j11;
            return (E) RegularEnumSet.this.universe[Long.numberOfTrailingZeros(this.lastReturned)];
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.lastReturned == 0) {
                throw new IllegalStateException();
            }
            RegularEnumSet.this.elements &= ~this.lastReturned;
            this.lastReturned = 0L;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return Long.bitCount(this.elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.elements == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object e2) {
        if (e2 == null) {
            return false;
        }
        Class<?> eClass = e2.getClass();
        return (eClass == this.elementType || eClass.getSuperclass() == this.elementType) && (this.elements & (1 << ((Enum) e2).ordinal())) != 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        typeCheck(e2);
        long oldElements = this.elements;
        long ordinal = this.elements | (1 << e2.ordinal());
        this.elements = ordinal;
        return ordinal != oldElements;
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
        long oldElements = this.elements;
        long j10 = this.elements & (~(1 << ((Enum) e2).ordinal()));
        this.elements = j10;
        return j10 != oldElements;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> c4) {
        if (!(c4 instanceof RegularEnumSet)) {
            return super.containsAll(c4);
        }
        RegularEnumSet<?> es = (RegularEnumSet) c4;
        if (es.elementType != this.elementType) {
            return es.isEmpty();
        }
        return (es.elements & (~this.elements)) == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> c4) {
        if (!(c4 instanceof RegularEnumSet)) {
            return super.addAll(c4);
        }
        RegularEnumSet<?> es = (RegularEnumSet) c4;
        if (es.elementType != this.elementType) {
            if (es.isEmpty()) {
                return false;
            }
            throw new ClassCastException(((Object) es.elementType) + " != " + ((Object) this.elementType));
        }
        long oldElements = this.elements;
        long j10 = this.elements | es.elements;
        this.elements = j10;
        return j10 != oldElements;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> c4) {
        if (!(c4 instanceof RegularEnumSet)) {
            return super.removeAll(c4);
        }
        RegularEnumSet<?> es = (RegularEnumSet) c4;
        if (es.elementType != this.elementType) {
            return false;
        }
        long oldElements = this.elements;
        long j10 = this.elements & (~es.elements);
        this.elements = j10;
        return j10 != oldElements;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> c4) {
        if (!(c4 instanceof RegularEnumSet)) {
            return super.retainAll(c4);
        }
        RegularEnumSet<?> es = (RegularEnumSet) c4;
        if (es.elementType != this.elementType) {
            boolean changed = this.elements != 0;
            this.elements = 0L;
            return changed;
        }
        long oldElements = this.elements;
        long j10 = this.elements & es.elements;
        this.elements = j10;
        return j10 != oldElements;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.elements = 0L;
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public boolean equals(Object o10) {
        if (!(o10 instanceof RegularEnumSet)) {
            return super.equals(o10);
        }
        RegularEnumSet<?> es = (RegularEnumSet) o10;
        return es.elementType != this.elementType ? this.elements == 0 && es.elements == 0 : es.elements == this.elements;
    }
}
