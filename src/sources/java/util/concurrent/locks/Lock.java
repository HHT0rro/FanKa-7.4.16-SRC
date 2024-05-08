package java.util.concurrent.locks;

import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface Lock {
    void lock();

    void lockInterruptibly() throws InterruptedException;

    Condition newCondition();

    boolean tryLock();

    boolean tryLock(long j10, TimeUnit timeUnit) throws InterruptedException;

    void unlock();
}
