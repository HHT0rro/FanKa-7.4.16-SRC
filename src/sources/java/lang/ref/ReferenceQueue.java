package java.lang.ref;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ReferenceQueue<T> {
    private static final Reference sQueueNextUnenqueued = new PhantomReference(null, null);
    private static Object currentTarget = null;
    public static Reference<?> unenqueued = null;
    private Reference<? extends T> head = null;
    private Reference<? extends T> tail = null;
    private final Object lock = new Object();

    private boolean enqueueLocked(Reference<? extends T> r10) {
        if (r10.queueNext != null) {
            return false;
        }
        if (r10 instanceof sun.misc.Cleaner) {
            sun.misc.Cleaner cl = (sun.misc.Cleaner) r10;
            cl.clean();
            r10.queueNext = sQueueNextUnenqueued;
            return true;
        }
        Reference<? extends T> reference = this.tail;
        if (reference == null) {
            this.head = r10;
        } else {
            reference.queueNext = r10;
        }
        this.tail = r10;
        r10.queueNext = r10;
        return true;
    }

    public static Object getCurrentTarget() {
        Object obj = currentTarget;
        if (obj instanceof sun.misc.Cleaner) {
            sun.misc.Cleaner cleaner = (sun.misc.Cleaner) obj;
            return cleaner.getThunk();
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isEnqueued(Reference<? extends T> reference) {
        boolean z10;
        synchronized (this.lock) {
            z10 = (reference.queueNext == null || reference.queueNext == sQueueNextUnenqueued) ? false : true;
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean enqueue(Reference<? extends T> reference) {
        synchronized (this.lock) {
            if (!enqueueLocked(reference)) {
                return false;
            }
            this.lock.notifyAll();
            return true;
        }
    }

    private Reference<? extends T> reallyPollLocked() {
        Reference<? extends T> reference = this.head;
        if (reference == null) {
            return null;
        }
        Reference<? extends T> r10 = this.head;
        if (reference == this.tail) {
            this.tail = null;
            this.head = null;
        } else {
            this.head = reference.queueNext;
        }
        r10.queueNext = sQueueNextUnenqueued;
        return r10;
    }

    public Reference<? extends T> poll() {
        synchronized (this.lock) {
            if (this.head == null) {
                return null;
            }
            return reallyPollLocked();
        }
    }

    public Reference<? extends T> remove(long timeout) throws IllegalArgumentException, InterruptedException {
        if (timeout < 0) {
            throw new IllegalArgumentException("Negative timeout value");
        }
        synchronized (this.lock) {
            Reference<? extends T> r10 = reallyPollLocked();
            if (r10 != null) {
                return r10;
            }
            long start = timeout == 0 ? 0L : System.nanoTime();
            while (true) {
                this.lock.wait(timeout);
                Reference<? extends T> r11 = reallyPollLocked();
                if (r11 != null) {
                    return r11;
                }
                if (timeout != 0) {
                    long end = System.nanoTime();
                    timeout -= (end - start) / 1000000;
                    if (timeout <= 0) {
                        return null;
                    }
                    start = end;
                }
            }
        }
    }

    public Reference<? extends T> remove() throws InterruptedException {
        return remove(0L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void enqueuePending(Reference<?> list, AtomicInteger progressCounter) {
        do {
            ReferenceQueue<? super Object> referenceQueue = list.queue;
            if (referenceQueue == 0 || sun.misc.Cleaner.isCleanerQueue(referenceQueue)) {
                Reference<?> next = list.pendingNext;
                list.pendingNext = list;
                if (referenceQueue != 0) {
                    sun.misc.Cleaner cl = (sun.misc.Cleaner) list;
                    currentTarget = cl;
                    cl.clean();
                    list.queueNext = sQueueNextUnenqueued;
                }
                list = next;
            } else {
                currentTarget = referenceQueue;
                int i10 = 0;
                synchronized (((ReferenceQueue) referenceQueue).lock) {
                    do {
                        Reference<?> next2 = list.pendingNext;
                        list.pendingNext = list;
                        referenceQueue.enqueueLocked(list);
                        list = next2;
                        if (list == list || list.queue != referenceQueue) {
                            break;
                        } else {
                            i10++;
                        }
                    } while (i10 <= 100);
                    ((ReferenceQueue) referenceQueue).lock.notifyAll();
                }
            }
            progressCounter.incrementAndGet();
        } while (list != list);
        currentTarget = null;
    }

    static void add(Reference<?> list) {
        synchronized (ReferenceQueue.class) {
            Reference<?> last = unenqueued;
            if (last == null) {
                unenqueued = list;
            } else {
                while (last.pendingNext != unenqueued) {
                    last = last.pendingNext;
                }
                last.pendingNext = list;
                Reference<?> last2 = list;
                while (last2.pendingNext != list) {
                    last2 = last2.pendingNext;
                }
                last2.pendingNext = unenqueued;
            }
            ReferenceQueue.class.notifyAll();
        }
    }
}
