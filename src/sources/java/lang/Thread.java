package java.lang;

import dalvik.annotation.optimization.FastNative;
import dalvik.system.VMStack;
import java.lang.ThreadLocal;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import libcore.util.EmptyArray;
import sun.nio.ch.Interruptible;
import sun.reflect.CallerSensitive;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Thread implements Runnable {
    public static final int MAX_PRIORITY = 10;
    public static final int MIN_PRIORITY = 1;
    public static final int NORM_PRIORITY = 5;
    private static volatile UncaughtExceptionHandler defaultUncaughtExceptionHandler;
    private static int threadInitNumber;
    private static long threadSeqNumber;
    private static volatile UncaughtExceptionHandler uncaughtExceptionPreHandler;
    private volatile Interruptible blocker;
    private final Object blockerLock;
    private ClassLoader contextClassLoader;
    private boolean daemon;
    private long eetop;
    private ThreadGroup group;
    ThreadLocal.ThreadLocalMap inheritableThreadLocals;
    private AccessControlContext inheritedAccessControlContext;
    private final Object lock;
    private volatile String name;
    private volatile long nativePeer;
    volatile Object parkBlocker;
    private int priority;
    private boolean single_step;
    private final long stackSize;
    boolean started;
    private boolean stillborn;
    private boolean systemDaemon;
    private Runnable target;
    int threadLocalRandomProbe;
    int threadLocalRandomSecondarySeed;
    long threadLocalRandomSeed;
    ThreadLocal.ThreadLocalMap threadLocals;
    private final long tid;
    private volatile UncaughtExceptionHandler uncaughtExceptionHandler;
    private boolean unparkedBeforeStart;
    private static final StackTraceElement[] EMPTY_STACK_TRACE = new StackTraceElement[0];
    private static final RuntimePermission SUBCLASS_IMPLEMENTATION_PERMISSION = new RuntimePermission("enableContextClassLoaderOverride");

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum State {
        NEW,
        RUNNABLE,
        BLOCKED,
        WAITING,
        TIMED_WAITING,
        TERMINATED
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    @FunctionalInterface
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface UncaughtExceptionHandler {
        void uncaughtException(Thread thread, Throwable th);
    }

    @FastNative
    public static native Thread currentThread();

    public static native boolean holdsLock(Object obj);

    @FastNative
    private native void interrupt0();

    @FastNative
    public static native boolean interrupted();

    private static native void nativeCreate(Thread thread, long j10, boolean z10);

    private native int nativeGetStatus(boolean z10);

    private native void setNativeName(String str);

    private native void setPriority0(int i10);

    @FastNative
    private static native void sleep(Object obj, long j10, int i10) throws InterruptedException;

    public static native void yield();

    @FastNative
    public native int getNativeTidFutex();

    @FastNative
    public native boolean isInterrupted();

    @FastNative
    public native void setBlockOwner(Thread thread);

    private static synchronized int nextThreadNum() {
        int i10;
        synchronized (Thread.class) {
            i10 = threadInitNumber;
            threadInitNumber = i10 + 1;
        }
        return i10;
    }

    private static synchronized long nextThreadID() {
        long j10;
        synchronized (Thread.class) {
            j10 = threadSeqNumber + 1;
            threadSeqNumber = j10;
        }
        return j10;
    }

    public void blockedOn(Interruptible b4) {
        synchronized (this.blockerLock) {
            this.blocker = b4;
        }
    }

    public static void sleep(long millis) throws InterruptedException {
        sleep(millis, 0);
    }

    public static void sleep(long millis, int nanos) throws InterruptedException {
        long durationNanos;
        long durationNanos2;
        if (millis < 0) {
            throw new IllegalArgumentException("millis < 0: " + millis);
        }
        if (nanos < 0) {
            throw new IllegalArgumentException("nanos < 0: " + nanos);
        }
        if (nanos > 999999) {
            throw new IllegalArgumentException("nanos > 999999: " + nanos);
        }
        if (millis == 0 && nanos == 0) {
            if (interrupted()) {
                throw new InterruptedException();
            }
            return;
        }
        if (millis >= 9223372036853L) {
            durationNanos = Long.MAX_VALUE;
        } else {
            long durationNanos3 = millis * 1000000;
            durationNanos = durationNanos3 + nanos;
        }
        long startNanos = System.nanoTime();
        Object lock = currentThread().lock;
        synchronized (lock) {
            long elapsed = 0;
            while (elapsed < durationNanos) {
                long remaining = durationNanos - elapsed;
                try {
                    durationNanos2 = durationNanos;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    long durationNanos4 = remaining % 1000000;
                    sleep(lock, remaining / 1000000, (int) durationNanos4);
                    elapsed = System.nanoTime() - startNanos;
                    durationNanos = durationNanos2;
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            }
        }
    }

    public static void onSpinWait() {
    }

    private Thread(ThreadGroup g3, Runnable target, String name, long stackSize, AccessControlContext acc, boolean inheritThreadLocals) {
        this.lock = new Object();
        this.daemon = false;
        this.stillborn = false;
        this.threadLocals = null;
        this.inheritableThreadLocals = null;
        this.systemDaemon = false;
        this.started = false;
        this.blockerLock = new Object();
        if (name == null) {
            throw new NullPointerException("name cannot be null");
        }
        this.name = name;
        Thread parent = currentThread();
        g3 = g3 == null ? parent.getThreadGroup() : g3;
        g3.addUnstarted();
        this.group = g3;
        this.daemon = parent.isDaemon();
        this.priority = parent.getPriority();
        this.target = target;
        init2(parent, inheritThreadLocals);
        this.stackSize = stackSize;
        this.tid = nextThreadID();
    }

    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public Thread() {
        this((ThreadGroup) null, (Runnable) null, "Thread-" + nextThreadNum(), 0L);
    }

    public Thread(Runnable target) {
        this((ThreadGroup) null, target, "Thread-" + nextThreadNum(), 0L);
    }

    Thread(Runnable target, AccessControlContext acc) {
        this(null, target, "Thread-" + nextThreadNum(), 0L, acc, false);
    }

    public Thread(ThreadGroup group, Runnable target) {
        this(group, target, "Thread-" + nextThreadNum(), 0L);
    }

    public Thread(String name) {
        this((ThreadGroup) null, (Runnable) null, name, 0L);
    }

    public Thread(ThreadGroup group, String name) {
        this(group, (Runnable) null, name, 0L);
    }

    Thread(ThreadGroup group, String name, int priority, boolean daemon) {
        this.lock = new Object();
        this.daemon = false;
        this.stillborn = false;
        this.threadLocals = null;
        this.inheritableThreadLocals = null;
        this.systemDaemon = false;
        this.started = false;
        this.blockerLock = new Object();
        this.group = group;
        group.addUnstarted();
        this.name = name == null ? "Thread-" + nextThreadNum() : name;
        this.priority = priority;
        this.daemon = daemon;
        init2(currentThread(), true);
        this.stackSize = 0L;
        this.tid = nextThreadID();
    }

    private void init2(Thread parent, boolean inheritThreadLocals) {
        ThreadLocal.ThreadLocalMap threadLocalMap;
        this.contextClassLoader = parent.getContextClassLoader();
        this.inheritedAccessControlContext = AccessController.getContext();
        if (inheritThreadLocals && (threadLocalMap = parent.inheritableThreadLocals) != null) {
            this.inheritableThreadLocals = ThreadLocal.createInheritedMap(threadLocalMap);
        }
    }

    public Thread(Runnable target, String name) {
        this((ThreadGroup) null, target, name, 0L);
    }

    public Thread(ThreadGroup group, Runnable target, String name) {
        this(group, target, name, 0L);
    }

    public Thread(ThreadGroup group, Runnable target, String name, long stackSize) {
        this(group, target, name, stackSize, null, true);
    }

    public Thread(ThreadGroup group, Runnable target, String name, long stackSize, boolean inheritThreadLocals) {
        this(group, target, name, stackSize, null, inheritThreadLocals);
    }

    public synchronized void start() {
        if (this.started) {
            throw new IllegalThreadStateException();
        }
        this.group.add(this);
        this.started = false;
        try {
            nativeCreate(this, this.stackSize, this.daemon);
            this.started = true;
        } catch (Throwable th) {
            try {
                if (!this.started) {
                    this.group.threadStartFailed(this);
                }
            } catch (Throwable th2) {
            }
            throw th;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.target;
        if (runnable != null) {
            runnable.run();
        }
    }

    private void exit() {
        ThreadGroup threadGroup = this.group;
        if (threadGroup != null) {
            threadGroup.threadTerminated(this);
            this.group = null;
        }
        this.target = null;
        this.threadLocals = null;
        this.inheritableThreadLocals = null;
        this.inheritedAccessControlContext = null;
        this.blocker = null;
        this.uncaughtExceptionHandler = null;
    }

    @Deprecated(since = "1.2")
    public final void stop() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final synchronized void stop(Throwable obj) {
        throw new UnsupportedOperationException();
    }

    public void interrupt() {
        if (this != currentThread()) {
            checkAccess();
            synchronized (this.blockerLock) {
                Interruptible b4 = this.blocker;
                if (b4 != null) {
                    interrupt0();
                    b4.interrupt(this);
                    return;
                }
            }
        }
        interrupt0();
    }

    @Deprecated
    public void destroy() {
        throw new UnsupportedOperationException();
    }

    public final boolean isAlive() {
        return this.nativePeer != 0;
    }

    @Deprecated(since = "1.2")
    public final void suspend() {
        throw new UnsupportedOperationException();
    }

    @Deprecated(since = "1.2")
    public final void resume() {
        throw new UnsupportedOperationException();
    }

    public final void setPriority(int newPriority) {
        int newPriority2;
        checkAccess();
        if (newPriority > 10 || newPriority < 1) {
            throw new IllegalArgumentException("Priority out of range: " + newPriority);
        }
        ThreadGroup g3 = getThreadGroup();
        if (g3 != null) {
            if (newPriority <= g3.getMaxPriority()) {
                newPriority2 = newPriority;
            } else {
                newPriority2 = g3.getMaxPriority();
            }
            synchronized (this) {
                this.priority = newPriority2;
                if (isAlive()) {
                    setPriority0(newPriority2);
                }
            }
        }
    }

    public final int getPriority() {
        return this.priority;
    }

    public final synchronized void setName(String name) {
        checkAccess();
        if (name == null) {
            throw new NullPointerException("name cannot be null");
        }
        this.name = name;
        if (isAlive()) {
            setNativeName(name);
        }
    }

    public final String getName() {
        return this.name;
    }

    public final ThreadGroup getThreadGroup() {
        if (getState() == State.TERMINATED) {
            return null;
        }
        return this.group;
    }

    public static int activeCount() {
        return currentThread().getThreadGroup().activeCount();
    }

    public static int enumerate(Thread[] tarray) {
        return currentThread().getThreadGroup().enumerate(tarray);
    }

    @Deprecated(forRemoval = true, since = "1.2")
    public int countStackFrames() {
        return getStackTrace().length;
    }

    public final void join(long millis) throws InterruptedException {
        synchronized (this.lock) {
            long base = System.currentTimeMillis();
            long now = 0;
            if (millis < 0) {
                throw new IllegalArgumentException("timeout value is negative");
            }
            if (millis == 0) {
                while (isAlive()) {
                    this.lock.wait(0L);
                }
            } else {
                while (isAlive()) {
                    long delay = millis - now;
                    if (delay <= 0) {
                        break;
                    }
                    this.lock.wait(delay);
                    now = System.currentTimeMillis() - base;
                }
            }
        }
    }

    public final void join(long millis, int nanos) throws InterruptedException {
        synchronized (this.lock) {
            if (millis < 0) {
                throw new IllegalArgumentException("timeout value is negative");
            }
            if (nanos < 0 || nanos > 999999) {
                throw new IllegalArgumentException("nanosecond timeout value out of range");
            }
            if (nanos >= 500000 || (nanos != 0 && millis == 0)) {
                millis++;
            }
            join(millis);
        }
    }

    public final void join() throws InterruptedException {
        join(0L);
    }

    public static void dumpStack() {
        new Exception("Stack trace").printStackTrace();
    }

    public final void setDaemon(boolean on) {
        checkAccess();
        if (isAlive()) {
            throw new IllegalThreadStateException();
        }
        this.daemon = on;
    }

    public final boolean isDaemon() {
        return this.daemon;
    }

    public final void checkAccess() {
    }

    public String toString() {
        ThreadGroup group = getThreadGroup();
        if (group == null) {
            return "Thread[" + getName() + "," + getPriority() + ",]";
        }
        return "Thread[" + getName() + "," + getPriority() + "," + group.getName() + "]";
    }

    @CallerSensitive
    public ClassLoader getContextClassLoader() {
        return this.contextClassLoader;
    }

    public void setContextClassLoader(ClassLoader cl) {
        this.contextClassLoader = cl;
    }

    public StackTraceElement[] getStackTrace() {
        StackTraceElement[] ste = VMStack.getThreadStackTrace(this);
        return ste != null ? ste : EmptyArray.STACK_TRACE_ELEMENT;
    }

    public static Map<Thread, StackTraceElement[]> getAllStackTraces() {
        int count = ThreadGroup.systemThreadGroup.activeCount();
        Thread[] threads = new Thread[(count / 2) + count];
        int count2 = ThreadGroup.systemThreadGroup.enumerate(threads);
        Map<Thread, StackTraceElement[]> m10 = new HashMap<>();
        for (int i10 = 0; i10 < count2; i10++) {
            StackTraceElement[] stackTrace = threads[i10].getStackTrace();
            m10.put(threads[i10], stackTrace);
        }
        return m10;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class Caches {
        static final ConcurrentMap<WeakClassKey, Boolean> subclassAudits = new ConcurrentHashMap();
        static final ReferenceQueue<Class<?>> subclassAuditsQueue = new ReferenceQueue<>();

        private Caches() {
        }
    }

    private static boolean isCCLOverridden(Class<?> cl) {
        if (cl == Thread.class) {
            return false;
        }
        processQueue(Caches.subclassAuditsQueue, Caches.subclassAudits);
        WeakClassKey key = new WeakClassKey(cl, Caches.subclassAuditsQueue);
        Boolean result = Caches.subclassAudits.get(key);
        if (result == null) {
            result = Boolean.valueOf(auditSubclass(cl));
            Caches.subclassAudits.putIfAbsent(key, result);
        }
        return result.booleanValue();
    }

    private static boolean auditSubclass(final Class<?> subcl) {
        Boolean result = (Boolean) AccessController.doPrivileged(new PrivilegedAction<Boolean>() { // from class: java.lang.Thread.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public Boolean run() {
                for (Class<?> cl = Class.this; cl != Thread.class; cl = cl.getSuperclass()) {
                    try {
                        cl.getDeclaredMethod("getContextClassLoader", new Class[0]);
                        return Boolean.TRUE;
                    } catch (NoSuchMethodException e2) {
                        try {
                            Class<?>[] params = {ClassLoader.class};
                            cl.getDeclaredMethod("setContextClassLoader", params);
                            return Boolean.TRUE;
                        } catch (NoSuchMethodException e10) {
                        }
                    }
                }
                return Boolean.FALSE;
            }
        });
        return result.booleanValue();
    }

    public long getId() {
        return this.tid;
    }

    public State getState() {
        return State.values()[nativeGetStatus(this.started)];
    }

    public static void setDefaultUncaughtExceptionHandler(UncaughtExceptionHandler eh) {
        defaultUncaughtExceptionHandler = eh;
    }

    public static UncaughtExceptionHandler getDefaultUncaughtExceptionHandler() {
        return defaultUncaughtExceptionHandler;
    }

    public static void setUncaughtExceptionPreHandler(UncaughtExceptionHandler eh) {
        uncaughtExceptionPreHandler = eh;
    }

    public static UncaughtExceptionHandler getUncaughtExceptionPreHandler() {
        return uncaughtExceptionPreHandler;
    }

    public UncaughtExceptionHandler getUncaughtExceptionHandler() {
        return this.uncaughtExceptionHandler != null ? this.uncaughtExceptionHandler : this.group;
    }

    public void setUncaughtExceptionHandler(UncaughtExceptionHandler eh) {
        checkAccess();
        this.uncaughtExceptionHandler = eh;
    }

    public final void dispatchUncaughtException(Throwable e2) {
        UncaughtExceptionHandler initialUeh = getUncaughtExceptionPreHandler();
        if (initialUeh != null) {
            try {
                initialUeh.uncaughtException(this, e2);
            } catch (Error | RuntimeException e10) {
            }
        }
        getUncaughtExceptionHandler().uncaughtException(this, e2);
    }

    final void setSystemDaemon(boolean on) {
        checkAccess();
        if (isAlive() || !isDaemon()) {
            throw new IllegalThreadStateException();
        }
        this.systemDaemon = on;
    }

    static void processQueue(ReferenceQueue<Class<?>> queue, ConcurrentMap<? extends WeakReference<Class<?>>, ?> map) {
        while (true) {
            Reference<? extends Class<?>> ref = queue.poll();
            if (ref != null) {
                map.remove(ref);
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class WeakClassKey extends WeakReference<Class<?>> {
        private final int hash;

        WeakClassKey(Class<?> cl, ReferenceQueue<Class<?>> refQueue) {
            super(cl, refQueue);
            this.hash = System.identityHashCode(cl);
        }

        public int hashCode() {
            return this.hash;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof WeakClassKey)) {
                return false;
            }
            Object referent = get();
            return referent != null && referent == ((WeakClassKey) obj).get();
        }
    }
}
