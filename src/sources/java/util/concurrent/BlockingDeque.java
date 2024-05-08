package java.util.concurrent;

import java.util.Deque;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface BlockingDeque<E> extends BlockingQueue<E>, Deque<E> {
    @Override // java.util.concurrent.BlockingQueue, java.util.Queue, java.util.Collection, java.util.Set
    boolean add(E e2);

    @Override // java.util.Deque
    void addFirst(E e2);

    @Override // java.util.Deque
    void addLast(E e2);

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection, java.util.Set
    boolean contains(Object obj);

    @Override // java.util.Queue
    E element();

    @Override // java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    Iterator<E> iterator2();

    @Override // java.util.concurrent.BlockingQueue
    boolean offer(E e2);

    @Override // java.util.concurrent.BlockingQueue
    boolean offer(E e2, long j10, TimeUnit timeUnit) throws InterruptedException;

    @Override // java.util.Deque
    boolean offerFirst(E e2);

    boolean offerFirst(E e2, long j10, TimeUnit timeUnit) throws InterruptedException;

    @Override // java.util.Deque
    boolean offerLast(E e2);

    boolean offerLast(E e2, long j10, TimeUnit timeUnit) throws InterruptedException;

    @Override // java.util.Queue
    E peek();

    @Override // java.util.Queue
    E poll();

    @Override // java.util.concurrent.BlockingQueue
    E poll(long j10, TimeUnit timeUnit) throws InterruptedException;

    E pollFirst(long j10, TimeUnit timeUnit) throws InterruptedException;

    E pollLast(long j10, TimeUnit timeUnit) throws InterruptedException;

    @Override // java.util.Deque
    void push(E e2);

    @Override // java.util.concurrent.BlockingQueue
    void put(E e2) throws InterruptedException;

    void putFirst(E e2) throws InterruptedException;

    void putLast(E e2) throws InterruptedException;

    @Override // java.util.Queue
    E remove();

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection, java.util.Set
    boolean remove(Object obj);

    @Override // java.util.Deque
    boolean removeFirstOccurrence(Object obj);

    @Override // java.util.Deque
    boolean removeLastOccurrence(Object obj);

    @Override // java.util.Collection, java.util.Set
    int size();

    @Override // java.util.concurrent.BlockingQueue
    E take() throws InterruptedException;

    E takeFirst() throws InterruptedException;

    E takeLast() throws InterruptedException;
}
