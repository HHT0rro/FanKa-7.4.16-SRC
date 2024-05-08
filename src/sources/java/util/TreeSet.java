package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class TreeSet<E> extends AbstractSet<E> implements NavigableSet<E>, Cloneable, Serializable {
    private static final Object PRESENT = new Object();
    private static final long serialVersionUID = -2479143000061671589L;

    /* renamed from: m, reason: collision with root package name */
    private transient NavigableMap<E, Object> f50487m;

    TreeSet(NavigableMap<E, Object> m10) {
        this.f50487m = m10;
    }

    public TreeSet() {
        this(new TreeMap());
    }

    public TreeSet(Comparator<? super E> comparator) {
        this(new TreeMap(comparator));
    }

    public TreeSet(Collection<? extends E> c4) {
        this();
        addAll(c4);
    }

    public TreeSet(SortedSet<E> s2) {
        this(s2.comparator());
        addAll(s2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return this.f50487m.navigableKeySet().iterator2();
    }

    @Override // java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return this.f50487m.descendingKeySet().iterator2();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        return new TreeSet(this.f50487m.descendingMap());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f50487m.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f50487m.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object o10) {
        return this.f50487m.containsKey(o10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        return this.f50487m.put(e2, PRESENT) == null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object o10) {
        return this.f50487m.remove(o10) == PRESENT;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f50487m.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> c4) {
        if (this.f50487m.size() == 0 && c4.size() > 0 && (c4 instanceof SortedSet)) {
            NavigableMap<E, Object> navigableMap = this.f50487m;
            if (navigableMap instanceof TreeMap) {
                TreeMap<E, Object> map = (TreeMap) navigableMap;
                SortedSet<? extends E> set = (SortedSet) c4;
                if (Objects.equals(set.comparator(), map.comparator())) {
                    map.addAllForTreeSet(set, PRESENT);
                    return true;
                }
            }
        }
        return super.addAll(c4);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
        return new TreeSet(this.f50487m.subMap(fromElement, fromInclusive, toElement, toInclusive));
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(E toElement, boolean inclusive) {
        return new TreeSet(this.f50487m.headMap(toElement, inclusive));
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
        return new TreeSet(this.f50487m.tailMap(fromElement, inclusive));
    }

    @Override // java.util.NavigableSet
    public SortedSet<E> subSet(E fromElement, E toElement) {
        return subSet(fromElement, true, toElement, false);
    }

    @Override // java.util.NavigableSet
    public SortedSet<E> headSet(E toElement) {
        return headSet(toElement, false);
    }

    @Override // java.util.NavigableSet
    public SortedSet<E> tailSet(E fromElement) {
        return tailSet(fromElement, true);
    }

    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        return this.f50487m.comparator();
    }

    @Override // java.util.SortedSet
    public E first() {
        return this.f50487m.firstKey();
    }

    @Override // java.util.SortedSet
    public E last() {
        return this.f50487m.lastKey();
    }

    @Override // java.util.NavigableSet
    public E lower(E e2) {
        return this.f50487m.lowerKey(e2);
    }

    @Override // java.util.NavigableSet
    public E floor(E e2) {
        return this.f50487m.floorKey(e2);
    }

    @Override // java.util.NavigableSet
    public E ceiling(E e2) {
        return this.f50487m.ceilingKey(e2);
    }

    @Override // java.util.NavigableSet
    public E higher(E e2) {
        return this.f50487m.higherKey(e2);
    }

    @Override // java.util.NavigableSet
    public E pollFirst() {
        Map.Entry<E, ?> e2 = this.f50487m.pollFirstEntry();
        if (e2 == null) {
            return null;
        }
        return e2.getKey();
    }

    @Override // java.util.NavigableSet
    public E pollLast() {
        Map.Entry<E, ?> e2 = this.f50487m.pollLastEntry();
        if (e2 == null) {
            return null;
        }
        return e2.getKey();
    }

    public Object clone() {
        try {
            TreeSet<E> clone = (TreeSet) super.clone();
            clone.f50487m = new TreeMap((SortedMap) this.f50487m);
            return clone;
        } catch (CloneNotSupportedException e2) {
            throw new InternalError(e2);
        }
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        s2.defaultWriteObject();
        s2.writeObject(this.f50487m.comparator());
        s2.writeInt(this.f50487m.size());
        for (E e2 : this.f50487m.h()) {
            s2.writeObject(e2);
        }
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        s2.defaultReadObject();
        Comparator<? super E> c4 = (Comparator) s2.readObject();
        TreeMap<E, Object> tm = new TreeMap<>(c4);
        this.f50487m = tm;
        int size = s2.readInt();
        tm.readTreeSet(size, s2, PRESENT);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return TreeMap.keySpliteratorFor(this.f50487m);
    }
}
