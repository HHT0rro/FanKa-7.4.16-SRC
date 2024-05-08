package com.google.common.base;

import java.io.Serializable;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
final class PairwiseEquivalence<E, T extends E> extends Equivalence<Iterable<T>> implements Serializable {
    private static final long serialVersionUID = 1;
    public final Equivalence<E> elementEquivalence;

    public PairwiseEquivalence(Equivalence<E> equivalence) {
        this.elementEquivalence = (Equivalence) o.r(equivalence);
    }

    public boolean equals(Object obj) {
        if (obj instanceof PairwiseEquivalence) {
            return this.elementEquivalence.equals(((PairwiseEquivalence) obj).elementEquivalence);
        }
        return false;
    }

    public int hashCode() {
        return this.elementEquivalence.hashCode() ^ 1185147655;
    }

    public String toString() {
        String valueOf = String.valueOf(this.elementEquivalence);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 11);
        sb2.append(valueOf);
        sb2.append(".pairwise()");
        return sb2.toString();
    }

    @Override // com.google.common.base.Equivalence
    public boolean doEquivalent(Iterable<T> iterable, Iterable<T> iterable2) {
        Iterator<T> iterator2 = iterable.iterator2();
        Iterator<T> iterator22 = iterable2.iterator2();
        while (iterator2.hasNext() && iterator22.hasNext()) {
            if (!this.elementEquivalence.equivalent(iterator2.next(), iterator22.next())) {
                return false;
            }
        }
        return (iterator2.hasNext() || iterator22.hasNext()) ? false : true;
    }

    @Override // com.google.common.base.Equivalence
    public int doHash(Iterable<T> iterable) {
        Iterator<T> iterator2 = iterable.iterator2();
        int i10 = 78721;
        while (iterator2.hasNext()) {
            i10 = (i10 * 24943) + this.elementEquivalence.hash(iterator2.next());
        }
        return i10;
    }
}
