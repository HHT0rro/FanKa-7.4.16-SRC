package com.google.common.collect;

import java.util.NoSuchElementException;
import java.util.Queue;

/* compiled from: ForwardingQueue.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class a0<E> extends s<E> implements Queue<E> {
    @Override // com.google.common.collect.s, com.google.common.collect.z
    public abstract Queue<E> delegate();

    @Override // java.util.Queue
    public E element() {
        return delegate().element();
    }

    public boolean offer(E e2) {
        return delegate().offer(e2);
    }

    @Override // java.util.Queue
    public E peek() {
        return delegate().peek();
    }

    @Override // java.util.Queue
    public E poll() {
        return delegate().poll();
    }

    @Override // java.util.Queue
    public E remove() {
        return delegate().remove();
    }

    public boolean standardOffer(E e2) {
        try {
            return add(e2);
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    public E standardPeek() {
        try {
            return element();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    public E standardPoll() {
        try {
            return remove();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }
}
