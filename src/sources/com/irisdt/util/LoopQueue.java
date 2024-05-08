package com.irisdt.util;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class LoopQueue {
    private AtomicInteger capacity;
    private Object[] queue;
    private AtomicInteger head = new AtomicInteger(0);
    private AtomicInteger tail = new AtomicInteger(0);

    public LoopQueue(int i10) {
        this.capacity = new AtomicInteger(i10);
        this.queue = new Object[i10];
    }

    public boolean isEmpty() {
        boolean z10;
        synchronized (this.queue) {
            z10 = this.head.get() == this.tail.get();
        }
        return z10;
    }

    public Object pop() {
        synchronized (this.queue) {
            if (isEmpty()) {
                return null;
            }
            Object obj = this.queue[this.head.get()];
            this.queue[this.head.get()] = null;
            AtomicInteger atomicInteger = this.head;
            atomicInteger.set((atomicInteger.get() + 1) % this.capacity.get());
            return obj;
        }
    }

    public void push(Object obj) {
        synchronized (this.queue) {
            this.queue[this.tail.get()] = obj;
            AtomicInteger atomicInteger = this.tail;
            atomicInteger.set((atomicInteger.get() + 1) % this.capacity.get());
        }
    }

    public int size() {
        int i10;
        synchronized (this.queue) {
            i10 = ((this.tail.get() - this.head.get()) + this.capacity.get()) % this.capacity.get();
        }
        return i10;
    }

    public Object[] pop(int i10) {
        synchronized (this.queue) {
            if (isEmpty()) {
                return null;
            }
            int size = size();
            if (i10 >= size) {
                i10 = size;
            }
            Object[] objArr = new Object[i10];
            int i11 = (this.head.get() + i10) % this.capacity.get();
            if (i11 < this.head.get()) {
                int i12 = this.capacity.get() - this.head.get();
                System.arraycopy(this.queue, this.head.get(), objArr, 0, i12);
                System.arraycopy(this.queue, 0, objArr, i12, i10 - i12);
            } else {
                System.arraycopy(this.queue, this.head.get(), objArr, 0, i11 - this.head.get());
            }
            for (int i13 = 0; i13 < i10; i13++) {
                this.queue[(this.head.get() + i13) % this.capacity.get()] = null;
            }
            AtomicInteger atomicInteger = this.head;
            atomicInteger.set((atomicInteger.get() + i10) % this.capacity.get());
            return objArr;
        }
    }
}
