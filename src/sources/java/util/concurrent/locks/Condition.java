package java.util.concurrent.locks;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface Condition {
    void await() throws InterruptedException;

    boolean await(long j10, TimeUnit timeUnit) throws InterruptedException;

    long awaitNanos(long j10) throws InterruptedException;

    void awaitUninterruptibly();

    boolean awaitUntil(Date date) throws InterruptedException;

    void signal();

    void signalAll();
}
