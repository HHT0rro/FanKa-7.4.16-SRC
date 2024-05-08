package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* compiled from: Multiset.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface k0<E> extends Collection<E> {

    /* compiled from: Multiset.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface a<E> {
        int getCount();

        E getElement();

        String toString();
    }

    int add(E e2, int i10);

    @Override // java.util.Collection, java.util.Set
    boolean contains(Object obj);

    @Override // java.util.Collection, java.util.Set
    boolean containsAll(Collection<?> collection);

    int count(Object obj);

    Set<E> elementSet();

    Set<a<E>> entrySet();

    @Override // java.util.Collection, java.util.Set
    boolean equals(Object obj);

    @Override // java.util.Collection, java.util.Set
    int hashCode();

    @Override // java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    Iterator<E> iterator2();

    int remove(Object obj, int i10);

    @Override // java.util.Collection, java.util.Set
    boolean remove(Object obj);

    int setCount(E e2, int i10);

    boolean setCount(E e2, int i10, int i11);

    @Override // java.util.Collection, java.util.Set
    int size();
}
