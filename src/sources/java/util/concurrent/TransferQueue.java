package java.util.concurrent;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface TransferQueue<E> extends BlockingQueue<E> {
    int getWaitingConsumerCount();

    boolean hasWaitingConsumer();

    void transfer(E e2) throws InterruptedException;

    boolean tryTransfer(E e2);

    boolean tryTransfer(E e2, long j10, TimeUnit timeUnit) throws InterruptedException;
}
