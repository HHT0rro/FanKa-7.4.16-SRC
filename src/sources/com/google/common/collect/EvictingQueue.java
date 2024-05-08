package com.google.common.collect;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class EvictingQueue<E> extends a0<E> implements Serializable {
    private static final long serialVersionUID = 0;
    private final Queue<E> delegate;
    public final int maxSize;

    private EvictingQueue(int i10) {
        com.google.common.base.o.h(i10 >= 0, "maxSize (%s) must >= 0", i10);
        this.delegate = new ArrayDeque(i10);
        this.maxSize = i10;
    }

    public static <E> EvictingQueue<E> create(int i10) {
        return new EvictingQueue<>(i10);
    }

    @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        com.google.common.base.o.r(e2);
        if (this.maxSize == 0) {
            return true;
        }
        if (size() == this.maxSize) {
            this.delegate.remove();
        }
        this.delegate.add(e2);
        return true;
    }

    @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        int size = collection.size();
        if (size >= this.maxSize) {
            clear();
            return g0.a(this, g0.k(collection, size - this.maxSize));
        }
        return standardAddAll(collection);
    }

    @Override // com.google.common.collect.a0, java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e2) {
        return add(e2);
    }

    public int remainingCapacity() {
        return this.maxSize - size();
    }

    @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return super.toArray();
    }

    @Override // com.google.common.collect.a0, com.google.common.collect.s, com.google.common.collect.z
    public Queue<E> delegate() {
        return this.delegate;
    }
}
