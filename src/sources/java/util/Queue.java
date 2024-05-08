package java.util;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface Queue<E> extends Collection<E> {
    @Override // java.util.Collection, java.util.Set
    boolean add(E e2);

    E element();

    boolean offer(E e2);

    E peek();

    E poll();

    E remove();
}
