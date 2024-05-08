package com.google.common.collect;

import com.google.common.collect.Multisets;
import com.google.common.collect.k0;
import java.util.Comparator;
import java.util.NavigableSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class UnmodifiableSortedMultiset<E> extends Multisets.UnmodifiableMultiset<E> implements a1<E> {
    private static final long serialVersionUID = 0;
    private transient UnmodifiableSortedMultiset<E> descendingMultiset;

    public UnmodifiableSortedMultiset(a1<E> a1Var) {
        super(a1Var);
    }

    @Override // com.google.common.collect.a1, com.google.common.collect.y0
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    @Override // com.google.common.collect.a1
    public a1<E> descendingMultiset() {
        UnmodifiableSortedMultiset<E> unmodifiableSortedMultiset = this.descendingMultiset;
        if (unmodifiableSortedMultiset != null) {
            return unmodifiableSortedMultiset;
        }
        UnmodifiableSortedMultiset<E> unmodifiableSortedMultiset2 = new UnmodifiableSortedMultiset<>(delegate().descendingMultiset());
        unmodifiableSortedMultiset2.descendingMultiset = this;
        this.descendingMultiset = unmodifiableSortedMultiset2;
        return unmodifiableSortedMultiset2;
    }

    @Override // com.google.common.collect.a1
    public k0.a<E> firstEntry() {
        return delegate().firstEntry();
    }

    @Override // com.google.common.collect.a1
    public a1<E> headMultiset(E e2, BoundType boundType) {
        return Multisets.p(delegate().headMultiset(e2, boundType));
    }

    @Override // com.google.common.collect.a1
    public k0.a<E> lastEntry() {
        return delegate().lastEntry();
    }

    @Override // com.google.common.collect.a1
    public k0.a<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.a1
    public k0.a<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.a1
    public a1<E> subMultiset(E e2, BoundType boundType, E e10, BoundType boundType2) {
        return Multisets.p(delegate().subMultiset(e2, boundType, e10, boundType2));
    }

    @Override // com.google.common.collect.a1
    public a1<E> tailMultiset(E e2, BoundType boundType) {
        return Multisets.p(delegate().tailMultiset(e2, boundType));
    }

    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset
    public NavigableSet<E> createElementSet() {
        return Sets.j(delegate().elementSet());
    }

    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset, com.google.common.collect.y, com.google.common.collect.k0
    public NavigableSet<E> elementSet() {
        return (NavigableSet) super.elementSet();
    }

    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset, com.google.common.collect.y, com.google.common.collect.s, com.google.common.collect.z
    public a1<E> delegate() {
        return (a1) super.delegate();
    }
}
