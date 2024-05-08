package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import org.apache.commons.collections4.functors.UniquePredicate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class UniqueFilterIterator<E> extends FilterIterator<E> {
    public UniqueFilterIterator(Iterator<? extends E> it) {
        super(it, UniquePredicate.uniquePredicate());
    }
}
