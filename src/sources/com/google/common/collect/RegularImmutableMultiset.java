package com.google.common.collect;

import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.k0;
import com.google.common.primitives.Ints;
import java.io.Serializable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {
    public static final RegularImmutableMultiset<Object> EMPTY = new RegularImmutableMultiset<>(n0.b());
    public final transient n0<E> contents;
    private transient ImmutableSet<E> elementSet;
    private final transient int size;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class ElementSet extends IndexedImmutableSet<E> {
        private ElementSet() {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return RegularImmutableMultiset.this.contains(obj);
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public E get(int i10) {
            return RegularImmutableMultiset.this.contents.i(i10);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return RegularImmutableMultiset.this.contents.C();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        public final int[] counts;
        public final Object[] elements;

        public SerializedForm(k0<? extends Object> k0Var) {
            int size = k0Var.entrySet().size();
            this.elements = new Object[size];
            this.counts = new int[size];
            int i10 = 0;
            for (k0.a<? extends Object> aVar : k0Var.entrySet()) {
                this.elements[i10] = aVar.getElement();
                this.counts[i10] = aVar.getCount();
                i10++;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Object readResolve() {
            ImmutableMultiset.b bVar = new ImmutableMultiset.b(this.elements.length);
            int i10 = 0;
            while (true) {
                Object[] objArr = this.elements;
                if (i10 < objArr.length) {
                    bVar.j(objArr[i10], this.counts[i10]);
                    i10++;
                } else {
                    return bVar.k();
                }
            }
        }
    }

    public RegularImmutableMultiset(n0<E> n0Var) {
        this.contents = n0Var;
        long j10 = 0;
        for (int i10 = 0; i10 < n0Var.C(); i10++) {
            j10 += n0Var.k(i10);
        }
        this.size = Ints.l(j10);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.k0
    public int count(Object obj) {
        return this.contents.f(obj);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public k0.a<E> getEntry(int i10) {
        return this.contents.g(i10);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.k0
    public ImmutableSet<E> elementSet() {
        ImmutableSet<E> immutableSet = this.elementSet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ElementSet elementSet = new ElementSet();
        this.elementSet = elementSet;
        return elementSet;
    }
}
