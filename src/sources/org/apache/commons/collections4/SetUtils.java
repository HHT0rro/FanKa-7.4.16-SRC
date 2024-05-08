package org.apache.commons.collections4;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.commons.collections4.set.ListOrderedSet;
import org.apache.commons.collections4.set.PredicatedNavigableSet;
import org.apache.commons.collections4.set.PredicatedSet;
import org.apache.commons.collections4.set.PredicatedSortedSet;
import org.apache.commons.collections4.set.TransformedNavigableSet;
import org.apache.commons.collections4.set.TransformedSet;
import org.apache.commons.collections4.set.TransformedSortedSet;
import org.apache.commons.collections4.set.UnmodifiableNavigableSet;
import org.apache.commons.collections4.set.UnmodifiableSet;
import org.apache.commons.collections4.set.UnmodifiableSortedSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class SetUtils {
    public static final SortedSet EMPTY_SORTED_SET = UnmodifiableSortedSet.unmodifiableSortedSet(new TreeSet());

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class SetView<E> extends AbstractSet<E> {
        public <S extends Set<E>> void copyInto(S s2) {
            CollectionUtils.addAll(s2, this);
        }

        public abstract Iterator<E> createIterator();

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<E> iterator2() {
            return IteratorUtils.unmodifiableIterator(createIterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return IteratorUtils.size(iterator2());
        }

        public Set<E> toSet() {
            HashSet hashSet = new HashSet(size());
            copyInto(hashSet);
            return hashSet;
        }
    }

    private SetUtils() {
    }

    public static <E> SetView<E> difference(final Set<? extends E> set, final Set<? extends E> set2) {
        if (set != null && set2 != null) {
            final Predicate<E> predicate = new Predicate<E>() { // from class: org.apache.commons.collections4.SetUtils.1
                @Override // org.apache.commons.collections4.Predicate
                public boolean evaluate(E e2) {
                    return !Set.this.contains(e2);
                }
            };
            return new SetView<E>() { // from class: org.apache.commons.collections4.SetUtils.2
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object obj) {
                    return Set.this.contains(obj) && !set2.contains(obj);
                }

                @Override // org.apache.commons.collections4.SetUtils.SetView
                public Iterator<E> createIterator() {
                    return IteratorUtils.filteredIterator(Set.this.iterator2(), predicate);
                }
            };
        }
        throw new NullPointerException("Sets must not be null.");
    }

    public static <E> SetView<E> disjunction(final Set<? extends E> set, final Set<? extends E> set2) {
        if (set != null && set2 != null) {
            final SetView difference = difference(set, set2);
            final SetView difference2 = difference(set2, set);
            return new SetView<E>() { // from class: org.apache.commons.collections4.SetUtils.3
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object obj) {
                    return set2.contains(obj) ^ Set.this.contains(obj);
                }

                @Override // org.apache.commons.collections4.SetUtils.SetView
                public Iterator<E> createIterator() {
                    return IteratorUtils.chainedIterator(difference.iterator2(), difference2.iterator2());
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean isEmpty() {
                    return difference.isEmpty() && difference2.isEmpty();
                }

                @Override // org.apache.commons.collections4.SetUtils.SetView, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return difference.size() + difference2.size();
                }
            };
        }
        throw new NullPointerException("Sets must not be null.");
    }

    public static <T> Set<T> emptyIfNull(Set<T> set) {
        return set == null ? Collections.emptySet() : set;
    }

    public static <E> Set<E> emptySet() {
        return Collections.emptySet();
    }

    public static <E> SortedSet<E> emptySortedSet() {
        return EMPTY_SORTED_SET;
    }

    public static <T> int hashCodeForSet(Collection<T> collection) {
        int i10 = 0;
        if (collection == null) {
            return 0;
        }
        for (T t2 : collection) {
            if (t2 != null) {
                i10 += t2.hashCode();
            }
        }
        return i10;
    }

    public static <E> HashSet<E> hashSet(E... eArr) {
        if (eArr == null) {
            return null;
        }
        return new HashSet<>(Arrays.asList(eArr));
    }

    public static <E> SetView<E> intersection(final Set<? extends E> set, final Set<? extends E> set2) {
        if (set != null && set2 != null) {
            final Predicate<E> predicate = new Predicate<E>() { // from class: org.apache.commons.collections4.SetUtils.4
                @Override // org.apache.commons.collections4.Predicate
                public boolean evaluate(E e2) {
                    return Set.this.contains(e2);
                }
            };
            return new SetView<E>() { // from class: org.apache.commons.collections4.SetUtils.5
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object obj) {
                    return Set.this.contains(obj) && set2.contains(obj);
                }

                @Override // org.apache.commons.collections4.SetUtils.SetView
                public Iterator<E> createIterator() {
                    return IteratorUtils.filteredIterator(Set.this.iterator2(), predicate);
                }
            };
        }
        throw new NullPointerException("Sets must not be null.");
    }

    public static boolean isEqualSet(Collection<?> collection, Collection<?> collection2) {
        if (collection == collection2) {
            return true;
        }
        if (collection == null || collection2 == null || collection.size() != collection2.size()) {
            return false;
        }
        return collection.containsAll(collection2);
    }

    public static <E> Set<E> newIdentityHashSet() {
        return Collections.newSetFromMap(new IdentityHashMap());
    }

    public static <E> Set<E> orderedSet(Set<E> set) {
        return ListOrderedSet.listOrderedSet(set);
    }

    public static <E> SortedSet<E> predicatedNavigableSet(NavigableSet<E> navigableSet, Predicate<? super E> predicate) {
        return PredicatedNavigableSet.predicatedNavigableSet(navigableSet, predicate);
    }

    public static <E> Set<E> predicatedSet(Set<E> set, Predicate<? super E> predicate) {
        return PredicatedSet.predicatedSet(set, predicate);
    }

    public static <E> SortedSet<E> predicatedSortedSet(SortedSet<E> sortedSet, Predicate<? super E> predicate) {
        return PredicatedSortedSet.predicatedSortedSet(sortedSet, predicate);
    }

    public static <E> Set<E> synchronizedSet(Set<E> set) {
        return Collections.synchronizedSet(set);
    }

    public static <E> SortedSet<E> synchronizedSortedSet(SortedSet<E> sortedSet) {
        return Collections.synchronizedSortedSet(sortedSet);
    }

    public static <E> SortedSet<E> transformedNavigableSet(NavigableSet<E> navigableSet, Transformer<? super E, ? extends E> transformer) {
        return TransformedNavigableSet.transformingNavigableSet(navigableSet, transformer);
    }

    public static <E> Set<E> transformedSet(Set<E> set, Transformer<? super E, ? extends E> transformer) {
        return TransformedSet.transformingSet(set, transformer);
    }

    public static <E> SortedSet<E> transformedSortedSet(SortedSet<E> sortedSet, Transformer<? super E, ? extends E> transformer) {
        return TransformedSortedSet.transformingSortedSet(sortedSet, transformer);
    }

    public static <E> SetView<E> union(final Set<? extends E> set, final Set<? extends E> set2) {
        if (set != null && set2 != null) {
            final SetView difference = difference(set2, set);
            return new SetView<E>() { // from class: org.apache.commons.collections4.SetUtils.6
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object obj) {
                    return Set.this.contains(obj) || set2.contains(obj);
                }

                @Override // org.apache.commons.collections4.SetUtils.SetView
                public Iterator<E> createIterator() {
                    return IteratorUtils.chainedIterator(Set.this.iterator2(), difference.iterator2());
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean isEmpty() {
                    return Set.this.isEmpty() && set2.isEmpty();
                }

                @Override // org.apache.commons.collections4.SetUtils.SetView, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return Set.this.size() + difference.size();
                }
            };
        }
        throw new NullPointerException("Sets must not be null.");
    }

    public static <E> SortedSet<E> unmodifiableNavigableSet(NavigableSet<E> navigableSet) {
        return UnmodifiableNavigableSet.unmodifiableNavigableSet(navigableSet);
    }

    public static <E> Set<E> unmodifiableSet(E... eArr) {
        if (eArr == null) {
            return null;
        }
        return UnmodifiableSet.unmodifiableSet(hashSet(eArr));
    }

    public static <E> SortedSet<E> unmodifiableSortedSet(SortedSet<E> sortedSet) {
        return UnmodifiableSortedSet.unmodifiableSortedSet(sortedSet);
    }

    public static <E> Set<E> unmodifiableSet(Set<? extends E> set) {
        return UnmodifiableSet.unmodifiableSet(set);
    }
}
