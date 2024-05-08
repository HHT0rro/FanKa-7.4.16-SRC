package org.apache.commons.collections4.comparators;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;
import org.apache.commons.collections4.ComparatorUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class NullComparator<E> implements Comparator<E>, Serializable {
    private static final long serialVersionUID = -5820772575483504339L;
    private final Comparator<? super E> nonNullComparator;
    private final boolean nullsAreHigh;

    public NullComparator() {
        this(ComparatorUtils.NATURAL_COMPARATOR, true);
    }

    @Override // java.util.Comparator
    public int compare(E e2, E e10) {
        if (e2 == e10) {
            return 0;
        }
        if (e2 == null) {
            return this.nullsAreHigh ? 1 : -1;
        }
        if (e10 == null) {
            return this.nullsAreHigh ? -1 : 1;
        }
        return this.nonNullComparator.compare(e2, e10);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!obj.getClass().equals(getClass())) {
            return false;
        }
        NullComparator nullComparator = (NullComparator) obj;
        return this.nullsAreHigh == nullComparator.nullsAreHigh && this.nonNullComparator.equals(nullComparator.nonNullComparator);
    }

    public int hashCode() {
        return (this.nullsAreHigh ? -1 : 1) * this.nonNullComparator.hashCode();
    }

    public NullComparator(Comparator<? super E> comparator) {
        this(comparator, true);
    }

    public NullComparator(boolean z10) {
        this(ComparatorUtils.NATURAL_COMPARATOR, z10);
    }

    public NullComparator(Comparator<? super E> comparator, boolean z10) {
        this.nonNullComparator = comparator;
        this.nullsAreHigh = z10;
        Objects.requireNonNull(comparator, "null nonNullComparator");
    }
}
