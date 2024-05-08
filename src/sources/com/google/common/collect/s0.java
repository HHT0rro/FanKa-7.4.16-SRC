package com.google.common.collect;

import java.lang.Comparable;
import java.util.Set;

/* compiled from: RangeSet.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface s0<C extends Comparable> {
    Set<Range<C>> asRanges();

    s0<C> complement();

    boolean encloses(Range<C> range);

    boolean isEmpty();

    void removeAll(s0<C> s0Var);

    s0<C> subRangeSet(Range<C> range);
}
