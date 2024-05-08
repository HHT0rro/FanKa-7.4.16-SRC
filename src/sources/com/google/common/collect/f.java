package com.google.common.collect;

import java.lang.Comparable;
import java.util.Iterator;

/* compiled from: AbstractRangeSet.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class f<C extends Comparable> implements s0<C> {
    public void add(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    public void addAll(s0<C> s0Var) {
        addAll(s0Var.asRanges());
    }

    public void clear() {
        remove(Range.all());
    }

    public boolean contains(C c4) {
        return rangeContaining(c4) != null;
    }

    @Override // com.google.common.collect.s0
    public abstract boolean encloses(Range<C> range);

    public boolean enclosesAll(s0<C> s0Var) {
        return enclosesAll(s0Var.asRanges());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof s0) {
            return asRanges().equals(((s0) obj).asRanges());
        }
        return false;
    }

    public final int hashCode() {
        return asRanges().hashCode();
    }

    public boolean intersects(Range<C> range) {
        return !subRangeSet(range).isEmpty();
    }

    @Override // com.google.common.collect.s0
    public boolean isEmpty() {
        return asRanges().isEmpty();
    }

    public abstract Range<C> rangeContaining(C c4);

    public void remove(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.s0
    public void removeAll(s0<C> s0Var) {
        removeAll(s0Var.asRanges());
    }

    public final String toString() {
        return asRanges().toString();
    }

    public void addAll(Iterable<Range<C>> iterable) {
        Iterator<Range<C>> iterator2 = iterable.iterator2();
        while (iterator2.hasNext()) {
            add(iterator2.next());
        }
    }

    public boolean enclosesAll(Iterable<Range<C>> iterable) {
        Iterator<Range<C>> iterator2 = iterable.iterator2();
        while (iterator2.hasNext()) {
            if (!encloses(iterator2.next())) {
                return false;
            }
        }
        return true;
    }

    public void removeAll(Iterable<Range<C>> iterable) {
        Iterator<Range<C>> iterator2 = iterable.iterator2();
        while (iterator2.hasNext()) {
            remove(iterator2.next());
        }
    }
}
