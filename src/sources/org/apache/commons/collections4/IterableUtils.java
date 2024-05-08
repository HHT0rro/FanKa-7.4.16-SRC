package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.iterators.LazyIteratorChain;
import org.apache.commons.collections4.iterators.ReverseListIterator;
import org.apache.commons.collections4.iterators.UniqueFilterIterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class IterableUtils {
    public static final FluentIterable EMPTY_ITERABLE = new FluentIterable<Object>() { // from class: org.apache.commons.collections4.IterableUtils.1
        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<Object> iterator2() {
            return IteratorUtils.emptyIterator();
        }
    };

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class UnmodifiableIterable<E> extends FluentIterable<E> {
        private final Iterable<E> unmodifiable;

        public UnmodifiableIterable(Iterable<E> iterable) {
            this.unmodifiable = iterable;
        }

        @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<E> iterator2() {
            return IteratorUtils.unmodifiableIterator(this.unmodifiable.iterator2());
        }
    }

    public static <E> Iterable<E> boundedIterable(final Iterable<E> iterable, final long j10) {
        checkNotNull((Iterable<?>) iterable);
        if (j10 >= 0) {
            return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.6
                @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
                /* renamed from: iterator */
                public Iterator<E> iterator2() {
                    return IteratorUtils.boundedIterator(Iterable.this.iterator2(), j10);
                }
            };
        }
        throw new IllegalArgumentException("MaxSize parameter must not be negative.");
    }

    public static <E> Iterable<E> chainedIterable(Iterable<? extends E> iterable, Iterable<? extends E> iterable2) {
        return chainedIterable(iterable, iterable2);
    }

    public static void checkNotNull(Iterable<?> iterable) {
        Objects.requireNonNull(iterable, "Iterable must not be null.");
    }

    public static <E> Iterable<E> collatedIterable(final Iterable<? extends E> iterable, final Iterable<? extends E> iterable2) {
        checkNotNull((Iterable<?>[]) new Iterable[]{iterable, iterable2});
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.3
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            /* renamed from: iterator */
            public Iterator<E> iterator2() {
                return IteratorUtils.collatedIterator(null, Iterable.this.iterator2(), iterable2.iterator2());
            }
        };
    }

    public static <E> boolean contains(Iterable<E> iterable, Object obj) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(obj);
        }
        return IteratorUtils.contains(emptyIteratorIfNull(iterable), obj);
    }

    public static <E> long countMatches(Iterable<E> iterable, Predicate<? super E> predicate) {
        Objects.requireNonNull(predicate, "Predicate must not be null.");
        return size(filteredIterable(emptyIfNull(iterable), predicate));
    }

    public static <E> Iterable<E> emptyIfNull(Iterable<E> iterable) {
        return iterable == null ? emptyIterable() : iterable;
    }

    public static <E> Iterable<E> emptyIterable() {
        return EMPTY_ITERABLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Iterator<E> emptyIteratorIfNull(Iterable<E> iterable) {
        return iterable != null ? iterable.iterator2() : IteratorUtils.emptyIterator();
    }

    public static <E> Iterable<E> filteredIterable(final Iterable<E> iterable, final Predicate<? super E> predicate) {
        checkNotNull((Iterable<?>) iterable);
        Objects.requireNonNull(predicate, "Predicate must not be null.");
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.5
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            /* renamed from: iterator */
            public Iterator<E> iterator2() {
                return IteratorUtils.filteredIterator(IterableUtils.emptyIteratorIfNull(Iterable.this), predicate);
            }
        };
    }

    public static <E> E find(Iterable<E> iterable, Predicate<? super E> predicate) {
        return (E) IteratorUtils.find(emptyIteratorIfNull(iterable), predicate);
    }

    public static <T> T first(Iterable<T> iterable) {
        return (T) get(iterable, 0);
    }

    public static <E> void forEach(Iterable<E> iterable, Closure<? super E> closure) {
        IteratorUtils.forEach(emptyIteratorIfNull(iterable), closure);
    }

    public static <E> E forEachButLast(Iterable<E> iterable, Closure<? super E> closure) {
        return (E) IteratorUtils.forEachButLast(emptyIteratorIfNull(iterable), closure);
    }

    public static <E, T extends E> int frequency(Iterable<E> iterable, T t2) {
        if (iterable instanceof Set) {
            return ((Set) iterable).contains(t2) ? 1 : 0;
        }
        if (iterable instanceof Bag) {
            return ((Bag) iterable).getCount(t2);
        }
        return size(filteredIterable(emptyIfNull(iterable), EqualPredicate.equalPredicate(t2)));
    }

    public static <T> T get(Iterable<T> iterable, int i10) {
        CollectionUtils.checkIndexBounds(i10);
        if (iterable instanceof List) {
            return (T) ((List) iterable).get(i10);
        }
        return (T) IteratorUtils.get(emptyIteratorIfNull(iterable), i10);
    }

    public static <E> int indexOf(Iterable<E> iterable, Predicate<? super E> predicate) {
        return IteratorUtils.indexOf(emptyIteratorIfNull(iterable), predicate);
    }

    public static boolean isEmpty(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).isEmpty();
        }
        return IteratorUtils.isEmpty(emptyIteratorIfNull(iterable));
    }

    public static <E> Iterable<E> loopingIterable(final Iterable<E> iterable) {
        checkNotNull((Iterable<?>) iterable);
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.7
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            /* renamed from: iterator */
            public Iterator<E> iterator2() {
                return new LazyIteratorChain<E>() { // from class: org.apache.commons.collections4.IterableUtils.7.1
                    @Override // org.apache.commons.collections4.iterators.LazyIteratorChain
                    public Iterator<? extends E> nextIterator(int i10) {
                        if (IterableUtils.isEmpty(Iterable.this)) {
                            return null;
                        }
                        return Iterable.this.iterator2();
                    }
                };
            }
        };
    }

    public static <E> boolean matchesAll(Iterable<E> iterable, Predicate<? super E> predicate) {
        return IteratorUtils.matchesAll(emptyIteratorIfNull(iterable), predicate);
    }

    public static <E> boolean matchesAny(Iterable<E> iterable, Predicate<? super E> predicate) {
        return IteratorUtils.matchesAny(emptyIteratorIfNull(iterable), predicate);
    }

    public static <O> List<List<O>> partition(Iterable<? extends O> iterable, Predicate<? super O> predicate) {
        Objects.requireNonNull(predicate, "Predicate must not be null.");
        return partition(iterable, FactoryUtils.instantiateFactory(ArrayList.class), predicate);
    }

    public static <E> Iterable<E> reversedIterable(final Iterable<E> iterable) {
        checkNotNull((Iterable<?>) iterable);
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.8
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            /* renamed from: iterator */
            public Iterator<E> iterator2() {
                Iterable iterable2 = Iterable.this;
                return new ReverseListIterator(iterable2 instanceof List ? (List) iterable2 : IteratorUtils.toList(iterable2.iterator2()));
            }
        };
    }

    public static int size(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return IteratorUtils.size(emptyIteratorIfNull(iterable));
    }

    public static <E> Iterable<E> skippingIterable(final Iterable<E> iterable, final long j10) {
        checkNotNull((Iterable<?>) iterable);
        if (j10 >= 0) {
            return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.9
                @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
                /* renamed from: iterator */
                public Iterator<E> iterator2() {
                    return IteratorUtils.skippingIterator(Iterable.this.iterator2(), j10);
                }
            };
        }
        throw new IllegalArgumentException("ElementsToSkip parameter must not be negative.");
    }

    public static <E> List<E> toList(Iterable<E> iterable) {
        return IteratorUtils.toList(emptyIteratorIfNull(iterable));
    }

    public static <E> String toString(Iterable<E> iterable) {
        return IteratorUtils.toString(emptyIteratorIfNull(iterable));
    }

    public static <I, O> Iterable<O> transformedIterable(final Iterable<I> iterable, final Transformer<? super I, ? extends O> transformer) {
        checkNotNull((Iterable<?>) iterable);
        Objects.requireNonNull(transformer, "Transformer must not be null.");
        return new FluentIterable<O>() { // from class: org.apache.commons.collections4.IterableUtils.10
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            /* renamed from: iterator */
            public Iterator<O> iterator2() {
                return IteratorUtils.transformedIterator(Iterable.this.iterator2(), transformer);
            }
        };
    }

    public static <E> Iterable<E> uniqueIterable(final Iterable<E> iterable) {
        checkNotNull((Iterable<?>) iterable);
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.11
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            /* renamed from: iterator */
            public Iterator<E> iterator2() {
                return new UniqueFilterIterator(Iterable.this.iterator2());
            }
        };
    }

    public static <E> Iterable<E> unmodifiableIterable(Iterable<E> iterable) {
        checkNotNull((Iterable<?>) iterable);
        return iterable instanceof UnmodifiableIterable ? iterable : new UnmodifiableIterable(iterable);
    }

    public static <E> Iterable<E> zippingIterable(final Iterable<? extends E> iterable, final Iterable<? extends E> iterable2) {
        checkNotNull(iterable);
        checkNotNull(iterable2);
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.12
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            /* renamed from: iterator */
            public Iterator<E> iterator2() {
                return IteratorUtils.zippingIterator(Iterable.this.iterator2(), iterable2.iterator2());
            }
        };
    }

    public static <E> Iterable<E> chainedIterable(Iterable<? extends E> iterable, Iterable<? extends E> iterable2, Iterable<? extends E> iterable3) {
        return chainedIterable(iterable, iterable2, iterable3);
    }

    public static void checkNotNull(Iterable<?>... iterableArr) {
        Objects.requireNonNull(iterableArr, "Iterables must not be null.");
        for (Iterable<?> iterable : iterableArr) {
            checkNotNull(iterable);
        }
    }

    public static <E> String toString(Iterable<E> iterable, Transformer<? super E, String> transformer) {
        Objects.requireNonNull(transformer, "Transformer must not be null.");
        return IteratorUtils.toString(emptyIteratorIfNull(iterable), transformer);
    }

    public static <E> Iterable<E> chainedIterable(Iterable<? extends E> iterable, Iterable<? extends E> iterable2, Iterable<? extends E> iterable3, Iterable<? extends E> iterable4) {
        return chainedIterable(iterable, iterable2, iterable3, iterable4);
    }

    public static <E> Iterable<E> collatedIterable(final Comparator<? super E> comparator, final Iterable<? extends E> iterable, final Iterable<? extends E> iterable2) {
        checkNotNull((Iterable<?>[]) new Iterable[]{iterable, iterable2});
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.4
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            /* renamed from: iterator */
            public Iterator<E> iterator2() {
                return IteratorUtils.collatedIterator(Comparator.this, iterable.iterator2(), iterable2.iterator2());
            }
        };
    }

    public static <E> Iterable<E> chainedIterable(final Iterable<? extends E>... iterableArr) {
        checkNotNull(iterableArr);
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.2
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            /* renamed from: iterator */
            public Iterator<E> iterator2() {
                return new LazyIteratorChain<E>() { // from class: org.apache.commons.collections4.IterableUtils.2.1
                    @Override // org.apache.commons.collections4.iterators.LazyIteratorChain
                    public Iterator<? extends E> nextIterator(int i10) {
                        Iterable[] iterableArr2 = iterableArr;
                        if (i10 > iterableArr2.length) {
                            return null;
                        }
                        return iterableArr2[i10 - 1].iterator2();
                    }
                };
            }
        };
    }

    public static <E> boolean contains(Iterable<? extends E> iterable, E e2, Equator<? super E> equator) {
        Objects.requireNonNull(equator, "Equator must not be null.");
        return matchesAny(iterable, EqualPredicate.equalPredicate(e2, equator));
    }

    public static <O> List<List<O>> partition(Iterable<? extends O> iterable, Predicate<? super O>... predicateArr) {
        return partition(iterable, FactoryUtils.instantiateFactory(ArrayList.class), predicateArr);
    }

    public static <E> String toString(Iterable<E> iterable, Transformer<? super E, String> transformer, String str, String str2, String str3) {
        return IteratorUtils.toString(emptyIteratorIfNull(iterable), transformer, str, str2, str3);
    }

    public static <E> Iterable<E> zippingIterable(final Iterable<? extends E> iterable, final Iterable<? extends E>... iterableArr) {
        checkNotNull(iterable);
        checkNotNull(iterableArr);
        return new FluentIterable<E>() { // from class: org.apache.commons.collections4.IterableUtils.13
            @Override // org.apache.commons.collections4.FluentIterable, java.lang.Iterable
            /* renamed from: iterator */
            public Iterator<E> iterator2() {
                Iterator[] itArr = new Iterator[iterableArr.length + 1];
                int i10 = 0;
                itArr[0] = iterable.iterator2();
                while (true) {
                    Iterable[] iterableArr2 = iterableArr;
                    if (i10 < iterableArr2.length) {
                        int i11 = i10 + 1;
                        itArr[i11] = iterableArr2[i10].iterator2();
                        i10 = i11;
                    } else {
                        return IteratorUtils.zippingIterator(itArr);
                    }
                }
            }
        };
    }

    public static <O, R extends Collection<O>> List<R> partition(Iterable<? extends O> iterable, Factory<R> factory, Predicate<? super O>... predicateArr) {
        boolean z10;
        if (iterable == null) {
            return partition(emptyIterable(), factory, predicateArr);
        }
        Objects.requireNonNull(predicateArr, "Predicates must not be null.");
        for (Predicate<? super O> predicate : predicateArr) {
            Objects.requireNonNull(predicate, "Predicate must not be null.");
        }
        if (predicateArr.length < 1) {
            R create = factory.create();
            CollectionUtils.addAll(create, iterable);
            return Collections.singletonList(create);
        }
        int length = predicateArr.length;
        int i10 = length + 1;
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            arrayList.add(factory.create());
        }
        for (O o10 : iterable) {
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    z10 = false;
                    break;
                }
                if (predicateArr[i12].evaluate(o10)) {
                    ((Collection) arrayList.get(i12)).add(o10);
                    z10 = true;
                    break;
                }
                i12++;
            }
            if (!z10) {
                ((Collection) arrayList.get(length)).add(o10);
            }
        }
        return arrayList;
    }
}
