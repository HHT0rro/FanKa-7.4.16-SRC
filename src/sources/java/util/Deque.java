package java.util;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface Deque<E> extends Queue<E> {
    @Override // java.util.Queue, java.util.Collection, java.util.Set
    boolean add(E e2);

    @Override // java.util.Collection, java.util.Set
    boolean addAll(Collection<? extends E> collection);

    void addFirst(E e2);

    void addLast(E e2);

    @Override // java.util.Collection, java.util.Set
    boolean contains(Object obj);

    Iterator<E> descendingIterator();

    @Override // java.util.Queue
    E element();

    E getFirst();

    E getLast();

    @Override // java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    Iterator<E> iterator2();

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    boolean offer(E e2);

    boolean offerFirst(E e2);

    boolean offerLast(E e2);

    @Override // java.util.Queue
    E peek();

    E peekFirst();

    E peekLast();

    @Override // java.util.Queue
    E poll();

    E pollFirst();

    E pollLast();

    E pop();

    void push(E e2);

    @Override // java.util.Queue
    E remove();

    @Override // java.util.Collection, java.util.Set
    boolean remove(Object obj);

    E removeFirst();

    boolean removeFirstOccurrence(Object obj);

    E removeLast();

    boolean removeLastOccurrence(Object obj);

    @Override // java.util.Collection, java.util.Set
    int size();
}
