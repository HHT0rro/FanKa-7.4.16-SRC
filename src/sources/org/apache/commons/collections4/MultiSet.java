package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface MultiSet<E> extends Collection<E> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface Entry<E> {
        boolean equals(Object obj);

        int getCount();

        E getElement();

        int hashCode();
    }

    int add(E e2, int i10);

    @Override // java.util.Collection, java.util.Set
    boolean add(E e2);

    @Override // java.util.Collection, java.util.Set
    boolean containsAll(Collection<?> collection);

    Set<Entry<E>> entrySet();

    @Override // java.util.Collection, java.util.Set
    boolean equals(Object obj);

    int getCount(Object obj);

    @Override // java.util.Collection, java.util.Set
    int hashCode();

    @Override // java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    Iterator<E> iterator2();

    int remove(Object obj, int i10);

    @Override // java.util.Collection, java.util.Set
    boolean remove(Object obj);

    @Override // java.util.Collection, java.util.Set
    boolean removeAll(Collection<?> collection);

    @Override // java.util.Collection, java.util.Set
    boolean retainAll(Collection<?> collection);

    int setCount(E e2, int i10);

    @Override // java.util.Collection, java.util.Set
    int size();

    Set<E> uniqueSet();
}
