package java.util.concurrent;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CopyOnWriteArraySet<E> extends AbstractSet<E> implements Serializable {
    private static final long serialVersionUID = 5457747651344034263L;
    private final CopyOnWriteArrayList<E> al;

    public CopyOnWriteArraySet() {
        this.al = new CopyOnWriteArrayList<>();
    }

    public CopyOnWriteArraySet(Collection<? extends E> c4) {
        if (c4.getClass() == CopyOnWriteArraySet.class) {
            CopyOnWriteArraySet<E> cc2 = (CopyOnWriteArraySet) c4;
            this.al = new CopyOnWriteArrayList<>(cc2.al);
        } else {
            CopyOnWriteArrayList<E> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.al = copyOnWriteArrayList;
            copyOnWriteArrayList.addAllAbsent(c4);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.al.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.al.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object o10) {
        return this.al.contains(o10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return this.al.toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.al.toArray(tArr);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.al.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object o10) {
        return this.al.remove(o10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        return this.al.addIfAbsent(e2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> c4) {
        if (c4 instanceof Set) {
            return compareSets(this.al.getArray(), (Set) c4) >= 0;
        }
        return this.al.containsAll(c4);
    }

    private static int compareSets(Object[] snapshot, Set<?> set) {
        int len = snapshot.length;
        boolean[] matched = new boolean[len];
        int j10 = 0;
        for (Object x10 : set) {
            for (int i10 = j10; i10 < len; i10++) {
                if (!matched[i10] && Objects.equals(x10, snapshot[i10])) {
                    matched[i10] = true;
                    if (i10 == j10) {
                        do {
                            j10++;
                            if (j10 < len) {
                            }
                        } while (matched[j10]);
                    }
                }
            }
            return -1;
        }
        return j10 == len ? 0 : 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> c4) {
        return this.al.addAllAbsent(c4) > 0;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> c4) {
        return this.al.removeAll(c4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> c4) {
        return this.al.retainAll(c4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return this.al.iterator2();
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public boolean equals(Object o10) {
        return o10 == this || ((o10 instanceof Set) && compareSets(this.al.getArray(), (Set) o10) == 0);
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super E> filter) {
        return this.al.removeIf(filter);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> action) {
        this.al.forEach(action);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(this.al.getArray(), 1025);
    }
}
