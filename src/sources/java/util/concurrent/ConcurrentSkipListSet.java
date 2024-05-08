package java.util.concurrent;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ConcurrentSkipListSet<E> extends AbstractSet<E> implements NavigableSet<E>, Cloneable, Serializable {
    private static final long serialVersionUID = -2479143111061671589L;

    /* renamed from: m, reason: collision with root package name */
    private final ConcurrentNavigableMap<E, Object> f50497m;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public /* bridge */ /* synthetic */ SortedSet headSet(Object obj) {
        return headSet((ConcurrentSkipListSet<E>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public /* bridge */ /* synthetic */ SortedSet tailSet(Object obj) {
        return tailSet((ConcurrentSkipListSet<E>) obj);
    }

    public ConcurrentSkipListSet() {
        this.f50497m = new ConcurrentSkipListMap();
    }

    public ConcurrentSkipListSet(Comparator<? super E> comparator) {
        this.f50497m = new ConcurrentSkipListMap(comparator);
    }

    public ConcurrentSkipListSet(Collection<? extends E> c4) {
        this.f50497m = new ConcurrentSkipListMap();
        addAll(c4);
    }

    public ConcurrentSkipListSet(SortedSet<E> s2) {
        this.f50497m = new ConcurrentSkipListMap(s2.comparator());
        addAll(s2);
    }

    ConcurrentSkipListSet(ConcurrentNavigableMap<E, Object> m10) {
        this.f50497m = m10;
    }

    public ConcurrentSkipListSet<E> clone() {
        try {
            ConcurrentSkipListSet<E> clone = (ConcurrentSkipListSet) super.clone();
            clone.setMap(new ConcurrentSkipListMap((SortedMap) this.f50497m));
            return clone;
        } catch (CloneNotSupportedException e2) {
            throw new InternalError();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f50497m.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f50497m.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object o10) {
        return this.f50497m.containsKey(o10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        return this.f50497m.putIfAbsent(e2, Boolean.TRUE) == null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object o10) {
        return this.f50497m.remove(o10, Boolean.TRUE);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f50497m.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return this.f50497m.navigableKeySet().iterator2();
    }

    @Override // java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return this.f50497m.descendingKeySet().iterator2();
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public boolean equals(Object o10) {
        if (o10 == this) {
            return true;
        }
        if (!(o10 instanceof Set)) {
            return false;
        }
        Collection<?> c4 = (Collection) o10;
        try {
            if (containsAll(c4)) {
                if (c4.containsAll(this)) {
                    return true;
                }
            }
            return false;
        } catch (ClassCastException | NullPointerException e2) {
            return false;
        }
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> c4) {
        boolean modified = false;
        for (Object e2 : c4) {
            if (remove(e2)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override // java.util.NavigableSet
    public E lower(E e2) {
        return this.f50497m.lowerKey(e2);
    }

    @Override // java.util.NavigableSet
    public E floor(E e2) {
        return this.f50497m.floorKey(e2);
    }

    @Override // java.util.NavigableSet
    public E ceiling(E e2) {
        return this.f50497m.ceilingKey(e2);
    }

    @Override // java.util.NavigableSet
    public E higher(E e2) {
        return this.f50497m.higherKey(e2);
    }

    @Override // java.util.NavigableSet
    public E pollFirst() {
        Map.Entry<E, Object> e2 = this.f50497m.pollFirstEntry();
        if (e2 == null) {
            return null;
        }
        return e2.getKey();
    }

    @Override // java.util.NavigableSet
    public E pollLast() {
        Map.Entry<E, Object> e2 = this.f50497m.pollLastEntry();
        if (e2 == null) {
            return null;
        }
        return e2.getKey();
    }

    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        return this.f50497m.comparator();
    }

    @Override // java.util.SortedSet
    public E first() {
        return this.f50497m.firstKey();
    }

    @Override // java.util.SortedSet
    public E last() {
        return this.f50497m.lastKey();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
        return new ConcurrentSkipListSet(this.f50497m.subMap((boolean) fromElement, fromInclusive, (boolean) toElement, toInclusive));
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(E toElement, boolean inclusive) {
        return new ConcurrentSkipListSet(this.f50497m.headMap((ConcurrentNavigableMap<E, Object>) toElement, inclusive));
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
        return new ConcurrentSkipListSet(this.f50497m.tailMap((ConcurrentNavigableMap<E, Object>) fromElement, inclusive));
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> subSet(E fromElement, E toElement) {
        return subSet(fromElement, true, toElement, false);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(E toElement) {
        return headSet(toElement, false);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(E fromElement) {
        return tailSet(fromElement, true);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        return new ConcurrentSkipListSet(this.f50497m.descendingMap());
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        ConcurrentNavigableMap<E, Object> concurrentNavigableMap = this.f50497m;
        if (concurrentNavigableMap instanceof ConcurrentSkipListMap) {
            return ((ConcurrentSkipListMap) concurrentNavigableMap).keySpliterator();
        }
        ConcurrentSkipListMap.SubMap subMap = (ConcurrentSkipListMap.SubMap) concurrentNavigableMap;
        Objects.requireNonNull(subMap);
        return new ConcurrentSkipListMap.SubMap.SubMapKeyIterator();
    }

    private void setMap(ConcurrentNavigableMap<E, Object> map) {
        Field mapField = (Field) AccessController.doPrivileged(new PrivilegedAction() { // from class: java.util.concurrent.ConcurrentSkipListSet$$ExternalSyntheticLambda0
            @Override // java.security.PrivilegedAction
            public final Object run() {
                return ConcurrentSkipListSet.lambda$setMap$0();
            }
        });
        try {
            mapField.set(this, map);
        } catch (IllegalAccessException e2) {
            throw new Error(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Field lambda$setMap$0() {
        try {
            Field f10 = ConcurrentSkipListSet.class.getDeclaredField("m");
            f10.setAccessible(true);
            return f10;
        } catch (ReflectiveOperationException e2) {
            throw new Error(e2);
        }
    }
}
