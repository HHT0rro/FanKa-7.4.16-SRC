package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface Bag<E> extends Collection<E> {
    @Override // java.util.Collection, java.util.Set
    boolean add(E e2);

    boolean add(E e2, int i10);

    @Override // java.util.Collection, java.util.Set
    boolean containsAll(Collection<?> collection);

    int getCount(Object obj);

    @Override // java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    Iterator<E> iterator2();

    @Override // java.util.Collection, java.util.Set
    boolean remove(Object obj);

    boolean remove(Object obj, int i10);

    @Override // java.util.Collection, java.util.Set
    boolean removeAll(Collection<?> collection);

    @Override // java.util.Collection, java.util.Set
    boolean retainAll(Collection<?> collection);

    @Override // java.util.Collection, java.util.Set
    int size();

    Set<E> uniqueSet();
}
