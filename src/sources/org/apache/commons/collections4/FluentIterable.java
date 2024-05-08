package org.apache.commons.collections4;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.apache.commons.collections4.iterators.SingletonIterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class FluentIterable<E> implements Iterable<E> {
    private final Iterable<E> iterable;

    public FluentIterable() {
        this.iterable = this;
    }

    public static <T> FluentIterable<T> empty() {
        return IterableUtils.EMPTY_ITERABLE;
    }

    public static <T> FluentIterable<T> of(T t2) {
        return of(IteratorUtils.asIterable(new SingletonIterator(t2, false)));
    }

    public boolean allMatch(Predicate<? super E> predicate) {
        return IterableUtils.matchesAll(this.iterable, predicate);
    }

    public boolean anyMatch(Predicate<? super E> predicate) {
        return IterableUtils.matchesAny(this.iterable, predicate);
    }

    public FluentIterable<E> append(E... eArr) {
        return append(Arrays.asList(eArr));
    }

    public Enumeration<E> asEnumeration() {
        return IteratorUtils.asEnumeration(iterator2());
    }

    public FluentIterable<E> collate(Iterable<? extends E> iterable) {
        return of(IterableUtils.collatedIterable(this.iterable, iterable));
    }

    public boolean contains(Object obj) {
        return IterableUtils.contains(this.iterable, obj);
    }

    public void copyInto(Collection<? super E> collection) {
        Objects.requireNonNull(collection, "Collection must not be null");
        CollectionUtils.addAll(collection, this.iterable);
    }

    public FluentIterable<E> eval() {
        return of((Iterable) toList());
    }

    public FluentIterable<E> filter(Predicate<? super E> predicate) {
        return of(IterableUtils.filteredIterable(this.iterable, predicate));
    }

    public void forEach(Closure<? super E> closure) {
        IterableUtils.forEach(this.iterable, closure);
    }

    public E get(int i10) {
        return (E) IterableUtils.get(this.iterable, i10);
    }

    public boolean isEmpty() {
        return IterableUtils.isEmpty(this.iterable);
    }

    @Override // java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return this.iterable.iterator2();
    }

    public FluentIterable<E> limit(long j10) {
        return of(IterableUtils.boundedIterable(this.iterable, j10));
    }

    public FluentIterable<E> loop() {
        return of(IterableUtils.loopingIterable(this.iterable));
    }

    public FluentIterable<E> reverse() {
        return of(IterableUtils.reversedIterable(this.iterable));
    }

    public int size() {
        return IterableUtils.size(this.iterable);
    }

    public FluentIterable<E> skip(long j10) {
        return of(IterableUtils.skippingIterable(this.iterable, j10));
    }

    public E[] toArray(Class<E> cls) {
        return (E[]) IteratorUtils.toArray(iterator2(), cls);
    }

    public List<E> toList() {
        return IterableUtils.toList(this.iterable);
    }

    public String toString() {
        return IterableUtils.toString(this.iterable);
    }

    public <O> FluentIterable<O> transform(Transformer<? super E, ? extends O> transformer) {
        return of(IterableUtils.transformedIterable(this.iterable, transformer));
    }

    public FluentIterable<E> unique() {
        return of(IterableUtils.uniqueIterable(this.iterable));
    }

    public FluentIterable<E> unmodifiable() {
        return of(IterableUtils.unmodifiableIterable(this.iterable));
    }

    public FluentIterable<E> zip(Iterable<? extends E> iterable) {
        return of(IterableUtils.zippingIterable(this.iterable, iterable));
    }

    public static <T> FluentIterable<T> of(T... tArr) {
        return of((Iterable) Arrays.asList(tArr));
    }

    public FluentIterable<E> append(Iterable<? extends E> iterable) {
        return of(IterableUtils.chainedIterable(this.iterable, iterable));
    }

    public FluentIterable<E> collate(Iterable<? extends E> iterable, Comparator<? super E> comparator) {
        return of(IterableUtils.collatedIterable(comparator, this.iterable, iterable));
    }

    public FluentIterable<E> zip(Iterable<? extends E>... iterableArr) {
        return of(IterableUtils.zippingIterable(this.iterable, iterableArr));
    }

    private FluentIterable(Iterable<E> iterable) {
        this.iterable = iterable;
    }

    public static <T> FluentIterable<T> of(Iterable<T> iterable) {
        IterableUtils.checkNotNull((Iterable<?>) iterable);
        if (iterable instanceof FluentIterable) {
            return (FluentIterable) iterable;
        }
        return new FluentIterable<>(iterable);
    }
}
