package com.google.common.collect;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
final class LexicographicalOrdering<T> extends Ordering<Iterable<T>> implements Serializable {
    private static final long serialVersionUID = 0;
    public final Comparator<? super T> elementOrder;

    public LexicographicalOrdering(Comparator<? super T> comparator) {
        this.elementOrder = comparator;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LexicographicalOrdering) {
            return this.elementOrder.equals(((LexicographicalOrdering) obj).elementOrder);
        }
        return false;
    }

    public int hashCode() {
        return this.elementOrder.hashCode() ^ 2075626741;
    }

    public String toString() {
        String valueOf = String.valueOf(this.elementOrder);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 18);
        sb2.append(valueOf);
        sb2.append(".lexicographical()");
        return sb2.toString();
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Iterable<T> iterable, Iterable<T> iterable2) {
        Iterator<T> iterator2 = iterable.iterator2();
        Iterator<T> iterator22 = iterable2.iterator2();
        while (iterator2.hasNext()) {
            if (!iterator22.hasNext()) {
                return 1;
            }
            int compare = this.elementOrder.compare(iterator2.next(), iterator22.next());
            if (compare != 0) {
                return compare;
            }
        }
        return iterator22.hasNext() ? -1 : 0;
    }
}
