package java.util.concurrent;

import java.util.Collection;
import java.util.Queue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface BlockingQueue<E> extends Queue<E> {
    @Override // java.util.Queue, java.util.Collection, java.util.Set
    boolean add(E e2);

    @Override // java.util.Collection, java.util.Set
    boolean contains(Object obj);

    int drainTo(Collection<? super E> collection);

    int drainTo(Collection<? super E> collection, int i10);

    boolean offer(E e2);

    boolean offer(E e2, long j10, TimeUnit timeUnit) throws InterruptedException;

    E poll(long j10, TimeUnit timeUnit) throws InterruptedException;

    void put(E e2) throws InterruptedException;

    int remainingCapacity();

    @Override // java.util.Collection, java.util.Set
    boolean remove(Object obj);

    E take() throws InterruptedException;
}
