package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import org.apache.commons.collections4.comparators.BooleanComparator;
import org.apache.commons.collections4.comparators.ComparableComparator;
import org.apache.commons.collections4.comparators.ComparatorChain;
import org.apache.commons.collections4.comparators.NullComparator;
import org.apache.commons.collections4.comparators.ReverseComparator;
import org.apache.commons.collections4.comparators.TransformingComparator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ComparatorUtils {
    public static final Comparator NATURAL_COMPARATOR = ComparableComparator.comparableComparator();

    private ComparatorUtils() {
    }

    public static Comparator<Boolean> booleanComparator(boolean z10) {
        return BooleanComparator.booleanComparator(z10);
    }

    public static <E> Comparator<E> chainedComparator(Comparator<E>... comparatorArr) {
        ComparatorChain comparatorChain = new ComparatorChain();
        for (Comparator<E> comparator : comparatorArr) {
            Objects.requireNonNull(comparator, "Comparator cannot be null");
            comparatorChain.addComparator(comparator);
        }
        return comparatorChain;
    }

    public static <E> E max(E e2, E e10, Comparator<E> comparator) {
        if (comparator == null) {
            comparator = NATURAL_COMPARATOR;
        }
        return comparator.compare(e2, e10) > 0 ? e2 : e10;
    }

    public static <E> E min(E e2, E e10, Comparator<E> comparator) {
        if (comparator == null) {
            comparator = NATURAL_COMPARATOR;
        }
        return comparator.compare(e2, e10) < 0 ? e2 : e10;
    }

    public static <E extends Comparable<? super E>> Comparator<E> naturalComparator() {
        return NATURAL_COMPARATOR;
    }

    public static <E> Comparator<E> nullHighComparator(Comparator<E> comparator) {
        if (comparator == null) {
            comparator = NATURAL_COMPARATOR;
        }
        return new NullComparator(comparator, true);
    }

    public static <E> Comparator<E> nullLowComparator(Comparator<E> comparator) {
        if (comparator == null) {
            comparator = NATURAL_COMPARATOR;
        }
        return new NullComparator(comparator, false);
    }

    public static <E> Comparator<E> reversedComparator(Comparator<E> comparator) {
        return new ReverseComparator(comparator);
    }

    public static <I, O> Comparator<I> transformedComparator(Comparator<O> comparator, Transformer<? super I, ? extends O> transformer) {
        if (comparator == null) {
            comparator = NATURAL_COMPARATOR;
        }
        return new TransformingComparator(transformer, comparator);
    }

    public static <E> Comparator<E> chainedComparator(Collection<Comparator<E>> collection) {
        return chainedComparator((Comparator[]) collection.toArray(new Comparator[collection.size()]));
    }
}
