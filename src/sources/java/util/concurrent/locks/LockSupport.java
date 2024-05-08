package java.util.concurrent.locks;

import jdk.internal.misc.Unsafe;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class LockSupport {
    private static final long PARKBLOCKER;
    private static final long TID;
    private static final Unsafe U;

    private LockSupport() {
    }

    private static void setBlocker(Thread t2, Object arg) {
        U.putReferenceOpaque(t2, PARKBLOCKER, arg);
    }

    public static void setCurrentBlocker(Object blocker) {
        U.putReferenceOpaque(Thread.currentThread(), PARKBLOCKER, blocker);
    }

    public static void unpark(Thread thread) {
        if (thread != null) {
            U.unpark(thread);
        }
    }

    public static void park(Object blocker) {
        Thread t2 = Thread.currentThread();
        setBlocker(t2, blocker);
        U.park(false, 0L);
        setBlocker(t2, null);
    }

    public static void parkNanos(Object blocker, long nanos) {
        if (nanos > 0) {
            Thread t2 = Thread.currentThread();
            setBlocker(t2, blocker);
            U.park(false, nanos);
            setBlocker(t2, null);
        }
    }

    public static void parkUntil(Object blocker, long deadline) {
        Thread t2 = Thread.currentThread();
        setBlocker(t2, blocker);
        U.park(true, deadline);
        setBlocker(t2, null);
    }

    public static Object getBlocker(Thread t2) {
        if (t2 == null) {
            throw new NullPointerException();
        }
        return U.getReferenceOpaque(t2, PARKBLOCKER);
    }

    public static void park() {
        U.park(false, 0L);
    }

    public static void parkNanos(long nanos) {
        if (nanos > 0) {
            U.park(false, nanos);
        }
    }

    public static void parkUntil(long deadline) {
        U.park(true, deadline);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final long getThreadId(Thread thread) {
        return U.getLong(thread, TID);
    }

    static {
        Unsafe unsafe = Unsafe.getUnsafe();
        U = unsafe;
        PARKBLOCKER = unsafe.objectFieldOffset(Thread.class, "parkBlocker");
        TID = unsafe.objectFieldOffset(Thread.class, "tid");
    }

    public static void park(Object blocker, int ownerTid) {
        Thread t2 = Thread.currentThread();
        setBlocker(t2, blocker);
        U.park(false, 0L, ownerTid);
        setBlocker(t2, null);
    }

    public static void parkNanos(Object blocker, long nanos, int ownerTid) {
        if (nanos > 0) {
            Thread t2 = Thread.currentThread();
            setBlocker(t2, blocker);
            U.park(false, nanos, ownerTid);
            setBlocker(t2, null);
        }
    }

    public static void parkUntil(Object blocker, long deadline, int ownerTid) {
        Thread t2 = Thread.currentThread();
        setBlocker(t2, blocker);
        U.park(true, deadline, ownerTid);
        setBlocker(t2, null);
    }

    public static void park(int ownerTid) {
        U.park(false, 0L, ownerTid);
    }

    public static void parkNanos(long nanos, int ownerTid) {
        if (nanos > 0) {
            U.park(false, nanos, ownerTid);
        }
    }

    public static void parkUntil(long deadline, int ownerTid) {
        U.park(true, deadline, ownerTid);
    }
}
