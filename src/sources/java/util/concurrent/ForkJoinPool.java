package java.util.concurrent;

import java.lang.Thread;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.Permission;
import java.security.Permissions;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.ForkJoinWorkerThread;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ForkJoinPool extends AbstractExecutorService {
    private static final long ADD_WORKER = 140737488355328L;
    private static final int COMMON_MAX_SPARES;
    static final int COMMON_PARALLELISM;
    private static final VarHandle CTL;
    private static final int DEFAULT_COMMON_MAX_SPARES = 256;
    private static final long DEFAULT_KEEPALIVE = 60000;
    static final int FIFO = 65536;
    static final int INITIAL_QUEUE_CAPACITY = 256;
    static final int INNOCUOUS = 262144;
    static final int MAX_CAP = 32767;
    private static final VarHandle MODE;
    private static final VarHandle POOLIDS;
    static final int QUIET = 524288;
    private static final long RC_MASK = -281474976710656L;
    private static final int RC_SHIFT = 48;
    private static final long RC_UNIT = 281474976710656L;
    static final int SHUTDOWN = 16777216;
    static final int SMASK = 65535;
    private static final long SP_MASK = 4294967295L;
    static final int SRC = 131072;
    static final int SS_SEQ = 65536;
    static final int STOP = Integer.MIN_VALUE;
    static final int SWIDTH = 16;
    private static final long TC_MASK = 281470681743360L;
    private static final int TC_SHIFT = 32;
    private static final long TC_UNIT = 4294967296L;
    static final int TERMINATED = 33554432;
    private static final VarHandle THREADIDS;
    private static final long TIMEOUT_SLOP = 20;
    private static final long UC_MASK = -4294967296L;
    static final int UNCOMPENSATE = 65536;
    static final int UNSIGNALLED = Integer.MIN_VALUE;
    static final ForkJoinPool common;
    public static final ForkJoinWorkerThreadFactory defaultForkJoinWorkerThreadFactory;
    static final RuntimePermission modifyThreadPermission;
    private static volatile int poolIds;
    final int bounds;
    volatile long ctl;
    final ForkJoinWorkerThreadFactory factory;
    final long keepAlive;
    volatile int mode;
    WorkQueue[] queues;
    final ReentrantLock registrationLock;
    final Predicate<? super ForkJoinPool> saturate;
    int scanRover;
    volatile long stealCount;
    Condition termination;
    volatile int threadIds;
    final Thread.UncaughtExceptionHandler ueh;
    final String workerNamePrefix;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface ForkJoinWorkerThreadFactory {
        ForkJoinWorkerThread newThread(ForkJoinPool forkJoinPool);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface ManagedBlocker {
        boolean block() throws InterruptedException;

        boolean isReleasable();
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public /* bridge */ /* synthetic */ Future submit(Runnable runnable, Object obj) {
        return submit(runnable, (Runnable) obj);
    }

    private static void checkPermission() {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkPermission(modifyThreadPermission);
        }
    }

    static AccessControlContext contextWithPermissions(Permission... perms) {
        Permissions permissions = new Permissions();
        for (Permission perm : perms) {
            permissions.add(perm);
        }
        return new AccessControlContext(new ProtectionDomain[]{new ProtectionDomain(null, permissions)});
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class DefaultForkJoinWorkerThreadFactory implements ForkJoinWorkerThreadFactory {
        private static final AccessControlContext ACC = ForkJoinPool.contextWithPermissions(new RuntimePermission("getClassLoader"), new RuntimePermission("setContextClassLoader"));

        DefaultForkJoinWorkerThreadFactory() {
        }

        @Override // java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory
        public final ForkJoinWorkerThread newThread(final ForkJoinPool pool) {
            return (ForkJoinWorkerThread) AccessController.doPrivileged(new PrivilegedAction<ForkJoinWorkerThread>() { // from class: java.util.concurrent.ForkJoinPool.DefaultForkJoinWorkerThreadFactory.1
                @Override // java.security.PrivilegedAction
                public ForkJoinWorkerThread run() {
                    return new ForkJoinWorkerThread(null, pool, true, false);
                }
            }, ACC);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class DefaultCommonPoolForkJoinWorkerThreadFactory implements ForkJoinWorkerThreadFactory {
        private static final AccessControlContext ACC = ForkJoinPool.contextWithPermissions(ForkJoinPool.modifyThreadPermission, new RuntimePermission("enableContextClassLoaderOverride"), new RuntimePermission("modifyThreadGroup"), new RuntimePermission("getClassLoader"), new RuntimePermission("setContextClassLoader"));

        DefaultCommonPoolForkJoinWorkerThreadFactory() {
        }

        @Override // java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory
        public final ForkJoinWorkerThread newThread(final ForkJoinPool pool) {
            return (ForkJoinWorkerThread) AccessController.doPrivileged(new PrivilegedAction<ForkJoinWorkerThread>() { // from class: java.util.concurrent.ForkJoinPool.DefaultCommonPoolForkJoinWorkerThreadFactory.1
                @Override // java.security.PrivilegedAction
                public ForkJoinWorkerThread run() {
                    if (System.getSecurityManager() == null) {
                        return new ForkJoinWorkerThread(null, pool, true, true);
                    }
                    return new ForkJoinWorkerThread.InnocuousForkJoinWorkerThread(pool);
                }
            }, ACC);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class WorkQueue {
        private static final VarHandle BASE;
        private static AccessControlContext INNOCUOUS_ACC;
        private static final VarHandle QA;
        private static final VarHandle SOURCE;
        ForkJoinTask<?>[] array;
        int base;
        int config;
        int nsteals;
        final ForkJoinWorkerThread owner;
        volatile int phase;
        volatile int source;
        int stackPred;
        int top;

        static final ForkJoinTask<?> getSlot(ForkJoinTask<?>[] a10, int i10) {
            return (ForkJoinTask) QA.getAcquire(a10, i10);
        }

        static final ForkJoinTask<?> getAndClearSlot(ForkJoinTask<?>[] a10, int i10) {
            return (ForkJoinTask) QA.getAndSet(a10, i10, null);
        }

        static final void setSlotVolatile(ForkJoinTask<?>[] a10, int i10, ForkJoinTask<?> v2) {
            (void) QA.setVolatile(a10, i10, v2);
        }

        static final boolean casSlotToNull(ForkJoinTask<?>[] a10, int i10, ForkJoinTask<?> c4) {
            return (boolean) QA.compareAndSet(a10, i10, c4, null);
        }

        final boolean tryLock() {
            return (boolean) SOURCE.compareAndSet(this, 0, 1);
        }

        final void setBaseOpaque(int b4) {
            (void) BASE.setOpaque(this, b4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public WorkQueue(ForkJoinWorkerThread owner, boolean isInnocuous) {
            this.config = isInnocuous ? 262144 : 0;
            this.owner = owner;
        }

        WorkQueue(int config) {
            this.array = new ForkJoinTask[256];
            this.config = config;
            this.owner = null;
            this.phase = -1;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final int getPoolIndex() {
            return (this.config & 65535) >>> 1;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final int queueSize() {
            VarHandle.acquireFence();
            int n10 = this.top - this.base;
            if (n10 < 0) {
                return 0;
            }
            return n10;
        }

        final boolean isEmpty() {
            return (this.source == 0 || this.owner != null) && this.top - this.base <= 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void push(ForkJoinTask<?> task, ForkJoinPool pool) {
            int cap;
            ForkJoinTask<?>[] a10 = this.array;
            int s2 = this.top;
            this.top = s2 + 1;
            int d10 = s2 - this.base;
            if (a10 != null && pool != null && (cap = a10.length) > 0) {
                int m10 = cap - 1;
                setSlotVolatile(a10, m10 & s2, task);
                if (d10 == m10) {
                    growArray();
                }
                if (d10 == m10 || a10[(s2 - 1) & m10] == null) {
                    pool.signalWork();
                }
            }
        }

        final boolean lockedPush(ForkJoinTask<?> task) {
            int cap;
            ForkJoinTask<?>[] a10 = this.array;
            int s2 = this.top;
            this.top = s2 + 1;
            int d10 = s2 - this.base;
            if (a10 != null && (cap = a10.length) > 0) {
                int m10 = cap - 1;
                a10[m10 & s2] = task;
                if (d10 == m10) {
                    growArray();
                }
                this.source = 0;
                if (d10 == m10 || a10[(s2 - 1) & m10] == null) {
                    return true;
                }
            }
            return false;
        }

        final void growArray() {
            int oldCap;
            int newCap;
            ForkJoinTask<?>[] oldArray = this.array;
            int s2 = this.top - 1;
            if (oldArray != null && (oldCap = oldArray.length) > 0 && (newCap = oldCap << 1) > 0) {
                try {
                    ForkJoinTask<?>[] newArray = new ForkJoinTask[newCap];
                    int newMask = newCap - 1;
                    int oldMask = oldCap - 1;
                    int k10 = oldCap;
                    while (k10 > 0) {
                        ForkJoinTask<?> x10 = getAndClearSlot(oldArray, s2 & oldMask);
                        if (x10 == null) {
                            break;
                        }
                        newArray[s2 & newMask] = x10;
                        k10--;
                        s2--;
                    }
                    VarHandle.releaseFence();
                    this.array = newArray;
                } catch (Throwable th) {
                    this.top = s2;
                    if (this.owner == null) {
                        this.source = 0;
                    }
                    throw new RejectedExecutionException("Queue capacity exceeded");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ForkJoinTask<?> pop() {
            int cap;
            ForkJoinTask<?> t2 = null;
            int s2 = this.top;
            ForkJoinTask<?>[] a10 = this.array;
            if (a10 != null && (cap = a10.length) > 0) {
                int s10 = s2 - 1;
                if (this.base != s2) {
                    ForkJoinTask<?> andClearSlot = getAndClearSlot(a10, (cap - 1) & s10);
                    t2 = andClearSlot;
                    if (andClearSlot != null) {
                        this.top = s10;
                    }
                }
            }
            return t2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean tryUnpush(ForkJoinTask<?> task) {
            int cap;
            int s2 = this.top;
            ForkJoinTask<?>[] a10 = this.array;
            if (a10 == null || (cap = a10.length) <= 0) {
                return false;
            }
            int s10 = s2 - 1;
            if (this.base == s2 || !casSlotToNull(a10, (cap - 1) & s10, task)) {
                return false;
            }
            this.top = s10;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean externalTryUnpush(ForkJoinTask<?> task) {
            int cap;
            boolean taken = false;
            while (true) {
                int s2 = this.top;
                ForkJoinTask<?>[] a10 = this.array;
                if (a10 == null || (cap = a10.length) <= 0) {
                    break;
                }
                int k10 = (cap - 1) & (s2 - 1);
                if (a10[k10] != task) {
                    break;
                }
                if (tryLock()) {
                    if (this.top == s2 && this.array == a10) {
                        boolean casSlotToNull = casSlotToNull(a10, k10, task);
                        taken = casSlotToNull;
                        if (casSlotToNull) {
                            this.top = s2 - 1;
                            this.source = 0;
                            break;
                        }
                    }
                    this.source = 0;
                }
                Thread.yield();
            }
            return taken;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean tryRemove(ForkJoinTask<?> task, boolean owned) {
            int cap;
            boolean taken = false;
            int p10 = this.top;
            ForkJoinTask<?>[] a10 = this.array;
            if (a10 != null && task != null && (cap = a10.length) > 0) {
                int m10 = cap - 1;
                int s2 = p10 - 1;
                int d10 = p10 - this.base;
                int i10 = s2;
                while (true) {
                    if (d10 <= 0) {
                        break;
                    }
                    int k10 = i10 & m10;
                    ForkJoinTask<?> t2 = a10[k10];
                    if (t2 != task) {
                        i10--;
                        d10--;
                    } else if (owned || tryLock()) {
                        if (owned || (this.array == a10 && this.top == p10)) {
                            boolean casSlotToNull = casSlotToNull(a10, k10, t2);
                            taken = casSlotToNull;
                            if (casSlotToNull) {
                                int j10 = i10;
                                while (j10 != s2) {
                                    int i11 = j10 & m10;
                                    j10++;
                                    a10[i11] = getAndClearSlot(a10, j10 & m10);
                                }
                                this.top = s2;
                            }
                        }
                        if (!owned) {
                            this.source = 0;
                        }
                    }
                }
            }
            return taken;
        }

        final ForkJoinTask<?> tryPoll() {
            int cap;
            ForkJoinTask<?>[] a10 = this.array;
            if (a10 != null && (cap = a10.length) > 0) {
                int b4 = this.base;
                int k10 = (cap - 1) & b4;
                ForkJoinTask<?> t2 = getSlot(a10, k10);
                int b10 = b4 + 1;
                if (this.base == b4 && t2 != null && casSlotToNull(a10, k10, t2)) {
                    setBaseOpaque(b10);
                    return t2;
                }
                return null;
            }
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
        
            if ((65536 & r9) != 0) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
        
            r2 = r2 + 1;
            r5 = getAndClearSlot(r2, r2 & (r2 - 1));
            r0 = r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
        
            if (r5 == null) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
        
            setBaseOpaque(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
        
            r1 = r1 - 1;
            r2 = getAndClearSlot(r2, (r2 - 1) & r1);
            r0 = r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
        
            if (r2 == null) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
        
            r8.top = r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
        
            if (r2 > 0) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
        
            r2 = r8.base;
            r2 = r1 - r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
        
            if (r2 > 0) goto L9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0016, code lost:
        
            if (r2 == 1) goto L22;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final java.util.concurrent.ForkJoinTask<?> nextLocalTask(int r9) {
            /*
                r8 = this;
                r0 = 0
                int r1 = r8.top
                java.util.concurrent.ForkJoinTask<?>[] r2 = r8.array
                r3 = r2
                if (r2 == 0) goto L3c
                int r2 = r3.length
                r4 = r2
                if (r2 <= 0) goto L3c
            Lc:
                int r2 = r8.base
                r5 = r2
                int r2 = r1 - r2
                r6 = r2
                if (r2 > 0) goto L15
                goto L3c
            L15:
                r2 = 1
                if (r6 == r2) goto L2e
                r2 = 65536(0x10000, float:9.18355E-41)
                r2 = r2 & r9
                if (r2 != 0) goto L1e
                goto L2e
            L1e:
                int r2 = r5 + 1
                int r7 = r4 + (-1)
                r5 = r5 & r7
                java.util.concurrent.ForkJoinTask r5 = getAndClearSlot(r3, r5)
                r0 = r5
                if (r5 == 0) goto Lc
                r8.setBaseOpaque(r2)
                goto L3c
            L2e:
                int r1 = r1 + (-1)
                int r2 = r4 + (-1)
                r2 = r2 & r1
                java.util.concurrent.ForkJoinTask r2 = getAndClearSlot(r3, r2)
                r0 = r2
                if (r2 == 0) goto L3c
                r8.top = r1
            L3c:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ForkJoinPool.WorkQueue.nextLocalTask(int):java.util.concurrent.ForkJoinTask");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final ForkJoinTask<?> nextLocalTask() {
            return nextLocalTask(this.config);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final ForkJoinTask<?> peek() {
            int cap;
            VarHandle.acquireFence();
            ForkJoinTask<?>[] a10 = this.array;
            if (a10 == null || (cap = a10.length) <= 0) {
                return null;
            }
            return a10[(cap - 1) & ((this.config & 65536) != 0 ? this.base : this.top - 1)];
        }

        final void topLevelExec(ForkJoinTask<?> task, WorkQueue q10) {
            int cfg = this.config;
            int nstolen = 1;
            while (task != null) {
                task.doExec();
                ForkJoinTask<?> nextLocalTask = nextLocalTask(cfg);
                task = nextLocalTask;
                if (nextLocalTask == null && q10 != null) {
                    ForkJoinTask<?> tryPoll = q10.tryPoll();
                    task = tryPoll;
                    if (tryPoll != null) {
                        nstolen++;
                    }
                }
            }
            this.nsteals += nstolen;
            this.source = 0;
            if ((262144 & cfg) != 0) {
                ThreadLocalRandom.eraseThreadLocals(Thread.currentThread());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final int helpComplete(ForkJoinTask<?> task, boolean owned, int limit) {
            ForkJoinTask<?>[] a10;
            int cap;
            int status = 0;
            while (task != null) {
                int i10 = task.status;
                status = i10;
                if (i10 < 0 || (a10 = this.array) == null || (cap = a10.length) <= 0) {
                    break;
                }
                int p10 = this.top;
                int s2 = p10 - 1;
                int k10 = (cap - 1) & s2;
                ForkJoinTask<?> t2 = a10[k10];
                if (!(t2 instanceof CountedCompleter)) {
                    break;
                }
                CountedCompleter<?> f10 = (CountedCompleter) t2;
                boolean taken = false;
                while (true) {
                    if (f10 == task) {
                        if (owned) {
                            boolean casSlotToNull = casSlotToNull(a10, k10, t2);
                            taken = casSlotToNull;
                            if (casSlotToNull) {
                                this.top = s2;
                            }
                        } else if (tryLock()) {
                            if (this.top == p10 && this.array == a10) {
                                boolean casSlotToNull2 = casSlotToNull(a10, k10, t2);
                                taken = casSlotToNull2;
                                if (casSlotToNull2) {
                                    this.top = s2;
                                }
                            }
                            this.source = 0;
                        }
                        if (taken) {
                            t2.doExec();
                        } else if (!owned) {
                            Thread.yield();
                        }
                    } else {
                        CountedCompleter<?> countedCompleter = f10.completer;
                        f10 = countedCompleter;
                        if (countedCompleter == null) {
                            break;
                        }
                    }
                }
                if (taken && limit != 0 && limit - 1 == 0) {
                    break;
                }
            }
            return status;
        }

        final void helpAsyncBlocker(ManagedBlocker blocker) {
            ForkJoinTask<?>[] a10;
            int cap;
            while (blocker != null) {
                int i10 = this.top;
                int b4 = this.base;
                int d10 = i10 - b4;
                if (d10 > 0 && (a10 = this.array) != null && (cap = a10.length) > 0) {
                    int k10 = (cap - 1) & b4;
                    ForkJoinTask<?> t2 = getSlot(a10, k10);
                    if (((t2 == null && d10 > 1) || (t2 instanceof CompletableFuture.AsynchronousCompletionTask)) && !blocker.isReleasable()) {
                        if (t2 != null) {
                            int b10 = b4 + 1;
                            if (this.base == b4 && casSlotToNull(a10, k10, t2)) {
                                setBaseOpaque(b10);
                                t2.doExec();
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        final void initializeInnocuousWorker() {
            AccessControlContext accessControlContext = INNOCUOUS_ACC;
            AccessControlContext acc = accessControlContext;
            if (accessControlContext == null) {
                AccessControlContext accessControlContext2 = new AccessControlContext(new ProtectionDomain[]{new ProtectionDomain(null, null)});
                acc = accessControlContext2;
                INNOCUOUS_ACC = accessControlContext2;
            }
            Thread t2 = Thread.currentThread();
            ThreadLocalRandom.setInheritedAccessControlContext(t2, acc);
            ThreadLocalRandom.eraseThreadLocals(t2);
        }

        final boolean isApparentlyUnblocked() {
            Thread.State s2;
            Thread wt = this.owner;
            return (wt == null || (s2 = wt.getState()) == Thread.State.BLOCKED || s2 == Thread.State.WAITING || s2 == Thread.State.TIMED_WAITING) ? false : true;
        }

        static {
            try {
                QA = MethodHandles.arrayElementVarHandle(ForkJoinTask[].class);
                MethodHandles.Lookup l10 = MethodHandles.lookup();
                SOURCE = l10.findVarHandle(WorkQueue.class, "source", Integer.TYPE);
                BASE = l10.findVarHandle(WorkQueue.class, "base", Integer.TYPE);
            } catch (ReflectiveOperationException e2) {
                throw new ExceptionInInitializerError(e2);
            }
        }
    }

    private boolean compareAndSetCtl(long c4, long v2) {
        return (boolean) CTL.compareAndSet(this, c4, v2);
    }

    private long compareAndExchangeCtl(long c4, long v2) {
        return (long) CTL.compareAndExchange(this, c4, v2);
    }

    private long getAndAddCtl(long v2) {
        return (long) CTL.getAndAdd(this, v2);
    }

    private int getAndBitwiseOrMode(int v2) {
        return (int) MODE.getAndBitwiseOr(this, v2);
    }

    private int getAndAddThreadIds(int x10) {
        return (int) THREADIDS.getAndAdd(this, x10);
    }

    private static int getAndAddPoolIds(int x10) {
        return (int) POOLIDS.getAndAdd(x10);
    }

    private boolean createWorker() {
        ForkJoinWorkerThreadFactory fac = this.factory;
        Throwable ex = null;
        ForkJoinWorkerThread wt = null;
        if (fac != null) {
            try {
                ForkJoinWorkerThread newThread = fac.newThread(this);
                wt = newThread;
                if (newThread != null) {
                    wt.start();
                    return true;
                }
            } catch (Throwable rex) {
                ex = rex;
            }
        }
        deregisterWorker(wt, ex);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String nextWorkerThreadName() {
        String prefix = this.workerNamePrefix;
        int tid = getAndAddThreadIds(1) + 1;
        if (prefix == null) {
            prefix = "ForkJoinPool.commonPool-worker-";
        }
        return prefix.concat(Integer.toString(tid));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void registerWorker(WorkQueue w3) {
        int n10;
        int id2;
        ReentrantLock lock = this.registrationLock;
        ThreadLocalRandom.localInit();
        int seed = ThreadLocalRandom.getProbe();
        if (w3 != null && lock != null) {
            int modebits = (this.mode & 65536) | w3.config;
            w3.array = new ForkJoinTask[256];
            w3.stackPred = seed;
            if ((262144 & modebits) != 0) {
                w3.initializeInnocuousWorker();
            }
            int id3 = (seed << 1) | 1;
            lock.lock();
            try {
                WorkQueue[] qs = this.queues;
                if (qs != null && (n10 = qs.length) > 0) {
                    int k10 = n10;
                    int m10 = n10 - 1;
                    while (true) {
                        int i10 = id3 & m10;
                        id2 = i10;
                        if (qs[i10] == null || k10 <= 0) {
                            break;
                        }
                        id3 = id2 - 2;
                        k10 -= 2;
                    }
                    if (k10 == 0) {
                        id2 = n10 | 1;
                    }
                    int i11 = id2 | modebits;
                    w3.config = i11;
                    w3.phase = i11;
                    if (id2 < n10) {
                        qs[id2] = w3;
                    } else {
                        int an = n10 << 1;
                        int am = an - 1;
                        WorkQueue[] as = new WorkQueue[an];
                        as[id2 & am] = w3;
                        for (int j10 = 1; j10 < n10; j10 += 2) {
                            as[j10] = qs[j10];
                        }
                        for (int j11 = 0; j11 < n10; j11 += 2) {
                            WorkQueue q10 = qs[j11];
                            if (q10 != null) {
                                as[q10.config & am] = q10;
                            }
                        }
                        VarHandle.releaseFence();
                        this.queues = as;
                    }
                }
            } finally {
                lock.unlock();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0071 A[LOOP:1: B:19:0x006a->B:21:0x0071, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0075 A[EDGE_INSN: B:22:0x0075->B:27:0x0075 BREAK  A[LOOP:1: B:19:0x006a->B:21:0x0071], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void deregisterWorker(java.util.concurrent.ForkJoinWorkerThread r20, java.lang.Throwable r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            java.util.concurrent.locks.ReentrantLock r2 = r0.registrationLock
            r3 = 0
            r4 = 0
            if (r1 == 0) goto L75
            java.util.concurrent.ForkJoinPool$WorkQueue r5 = r1.workQueue
            r3 = r5
            if (r5 == 0) goto L75
            if (r2 == 0) goto L75
            int r4 = r3.config
            int r5 = r3.nsteals
            long r5 = (long) r5
            r7 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r5 = r5 & r7
            r2.lock()
            java.util.concurrent.ForkJoinPool$WorkQueue[] r9 = r0.queues
            r10 = r9
            if (r9 == 0) goto L33
            int r9 = r10.length
            r11 = r9
            if (r9 <= 0) goto L33
            int r9 = r11 + (-1)
            r9 = r9 & r4
            r12 = r9
            r9 = r10[r9]
            if (r9 != r3) goto L33
            r9 = 0
            r10[r12] = r9
        L33:
            long r11 = r0.stealCount
            long r11 = r11 + r5
            r0.stealCount = r11
            r2.unlock()
            long r11 = r0.ctl
            r9 = 524288(0x80000, float:7.34684E-40)
            r9 = r9 & r4
            if (r9 != 0) goto L66
        L42:
            r13 = 281474976710656(0x1000000000000, double:1.390671161567E-309)
            long r13 = r11 - r13
            r15 = -281474976710656(0xffff000000000000, double:NaN)
            long r13 = r13 & r15
            r15 = 4294967296(0x100000000, double:2.121995791E-314)
            long r15 = r11 - r15
            r17 = 281470681743360(0xffff00000000, double:1.39064994160909E-309)
            long r15 = r15 & r17
            long r13 = r13 | r15
            long r15 = r11 & r7
            long r13 = r13 | r15
            long r13 = r0.compareAndExchangeCtl(r11, r13)
            r15 = r13
            int r9 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            r11 = r15
            if (r9 != 0) goto L42
            goto L6a
        L66:
            int r7 = (int) r11
            if (r7 != 0) goto L6a
            r4 = 0
        L6a:
            java.util.concurrent.ForkJoinTask r7 = java.util.concurrent.ForkJoinPool.WorkQueue.m3438$$Nest$mpop(r3)
            r8 = r7
            if (r7 == 0) goto L75
            java.util.concurrent.ForkJoinTask.cancelIgnoringExceptions(r8)
            goto L6a
        L75:
            r5 = 0
            boolean r5 = r0.tryTerminate(r5, r5)
            if (r5 != 0) goto L86
            if (r3 == 0) goto L86
            r5 = 131072(0x20000, float:1.83671E-40)
            r5 = r5 & r4
            if (r5 == 0) goto L86
            r19.signalWork()
        L86:
            if (r21 == 0) goto L8b
            java.util.concurrent.ForkJoinTask.rethrow(r21)
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ForkJoinPool.deregisterWorker(java.util.concurrent.ForkJoinWorkerThread, java.lang.Throwable):void");
    }

    final void signalWork() {
        int i10;
        WorkQueue v2;
        long c4 = this.ctl;
        while (c4 < 0) {
            int sp = ((int) c4) & Integer.MAX_VALUE;
            if (sp != 0) {
                WorkQueue[] qs = this.queues;
                if (qs != null && qs.length > (i10 = 65535 & sp) && (v2 = qs[i10]) != null) {
                    long nc2 = ((RC_UNIT + c4) & UC_MASK) | (v2.stackPred & 4294967295L);
                    Thread vt = v2.owner;
                    long c10 = compareAndExchangeCtl(c4, nc2);
                    if (c4 != c10) {
                        c4 = c10;
                    } else {
                        v2.phase = sp;
                        LockSupport.unpark(vt);
                        return;
                    }
                } else {
                    return;
                }
            } else if ((ADD_WORKER & c4) != 0) {
                long c11 = compareAndExchangeCtl(c4, (RC_MASK & (RC_UNIT + c4)) | ((4294967296L + c4) & TC_MASK));
                if (c4 != c11) {
                    c4 = c11;
                } else {
                    createWorker();
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void runWorker(WorkQueue w3) {
        if (this.mode >= 0 && w3 != null) {
            w3.config |= 131072;
            int r10 = w3.stackPred;
            int src = 0;
            while (true) {
                int r11 = r10 ^ (r10 << 13);
                int r12 = r11 ^ (r11 >>> 17);
                r10 = r12 ^ (r12 << 5);
                int scan = scan(w3, src, r10);
                src = scan;
                if (scan < 0) {
                    int awaitWork = awaitWork(w3);
                    src = awaitWork;
                    if (awaitWork != 0) {
                        return;
                    }
                }
            }
        }
    }

    private int scan(WorkQueue w3, int prevSrc, int r10) {
        int n10;
        WorkQueue[] qs = this.queues;
        int n11 = (w3 == null || qs == null) ? 0 : qs.length;
        int step = (r10 >>> 16) | 1;
        int i10 = n11;
        int r11 = r10;
        while (i10 > 0) {
            int j10 = (n11 - 1) & r11;
            WorkQueue q10 = qs[j10];
            if (q10 != null) {
                ForkJoinTask<?>[] a10 = q10.array;
                if (a10 != null) {
                    int cap = a10.length;
                    if (cap <= 0) {
                        n10 = n11;
                    } else {
                        int b4 = q10.base;
                        int k10 = (cap - 1) & b4;
                        int nextBase = b4 + 1;
                        int nextIndex = (cap - 1) & nextBase;
                        n10 = n11;
                        int n12 = j10 | 131072;
                        ForkJoinTask<?> t2 = WorkQueue.getSlot(a10, k10);
                        if (q10.base != b4) {
                            return prevSrc;
                        }
                        if (t2 != null && WorkQueue.casSlotToNull(a10, k10, t2)) {
                            q10.base = nextBase;
                            ForkJoinTask<?> next = a10[nextIndex];
                            w3.source = n12;
                            if (n12 != prevSrc && next != null) {
                                signalWork();
                            }
                            w3.topLevelExec(t2, q10);
                            return n12;
                        }
                        ForkJoinTask<?> next2 = a10[nextIndex];
                        if (next2 != null) {
                            return prevSrc;
                        }
                    }
                } else {
                    n10 = n11;
                }
            } else {
                n10 = n11;
            }
            i10--;
            r11 += step;
            n11 = n10;
        }
        if (this.queues != qs) {
            return prevSrc;
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b6, code lost:
    
        if (compareAndSetCtl(r6, r10) == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b8, code lost:
    
        r33.phase = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ba, code lost:
    
        r13 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int awaitWork(java.util.concurrent.ForkJoinPool.WorkQueue r33) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ForkJoinPool.awaitWork(java.util.concurrent.ForkJoinPool$WorkQueue):int");
    }

    final boolean canStop() {
        int i10;
        ForkJoinTask<?>[] a10;
        int cap;
        long oldSum = 0;
        loop0: while (true) {
            WorkQueue[] qs = this.queues;
            if (qs != null) {
                int i11 = this.mode;
                int md2 = i11;
                i10 = Integer.MIN_VALUE;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    return true;
                }
                long c4 = this.ctl;
                if ((65535 & md2) + ((int) (c4 >> 48)) > 0) {
                    break;
                }
                long checkSum = c4;
                int i12 = 1;
                while (i12 < qs.length) {
                    int s2 = 0;
                    WorkQueue q10 = qs[i12];
                    if (q10 != null && (a10 = q10.array) != null && (cap = a10.length) > 0) {
                        int i13 = q10.top;
                        s2 = i13;
                        if (i13 != q10.base || a10[(cap - 1) & s2] != null || q10.source != 0) {
                            break loop0;
                        }
                    }
                    long j10 = s2 ^ (i12 << 32);
                    i12 += 2;
                    i10 = Integer.MIN_VALUE;
                    md2 = md2;
                    checkSum = j10 + checkSum;
                }
                long checkSum2 = checkSum;
                if (oldSum == checkSum2 && this.queues == qs) {
                    return true;
                }
                oldSum = checkSum2;
            } else {
                return true;
            }
        }
        return (this.mode & i10) != 0;
    }

    private int tryCompensate(long c4) {
        int i10;
        int n10;
        WorkQueue v2;
        int md2 = this.mode;
        int b4 = this.bounds;
        int minActive = (short) (b4 & 65535);
        int maxTotal = b4 >>> 16;
        int active = (int) (c4 >> 48);
        int total = (short) (c4 >>> 32);
        int sp = ((int) c4) & Integer.MAX_VALUE;
        if ((65535 & md2) == 0) {
            return 0;
        }
        if (total < 0) {
            i10 = 65536;
        } else {
            if (sp != 0) {
                WorkQueue[] qs = this.queues;
                if (qs != null && (n10 = qs.length) > 0 && (v2 = qs[(n10 - 1) & sp]) != null) {
                    Thread vt = v2.owner;
                    long nc2 = (v2.stackPred & 4294967295L) | (c4 & UC_MASK);
                    if (compareAndSetCtl(c4, nc2)) {
                        v2.phase = sp;
                        LockSupport.unpark(vt);
                        return 65536;
                    }
                    return -1;
                }
                return -1;
            }
            i10 = 65536;
            if (active > minActive) {
                long nc3 = ((c4 - RC_UNIT) & RC_MASK) | (c4 & 281474976710655L);
                return compareAndSetCtl(c4, nc3) ? 65536 : -1;
            }
        }
        if (total < maxTotal) {
            long nc4 = ((4294967296L + c4) & TC_MASK) | (c4 & (-281470681743361L));
            if (!compareAndSetCtl(c4, nc4)) {
                return -1;
            }
            if (createWorker()) {
                return i10;
            }
            return 0;
        }
        if (!compareAndSetCtl(c4, c4)) {
            return -1;
        }
        Predicate<? super ForkJoinPool> sat = this.saturate;
        if (sat == null || !sat.test(this)) {
            throw new RejectedExecutionException("Thread limit exceeded replacing blocked worker");
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void uncompensate() {
        getAndAddCtl(RC_UNIT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b4, code lost:
    
        if ((r4.source & 65535) != r5) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int helpJoin(java.util.concurrent.ForkJoinTask<?> r31, java.util.concurrent.ForkJoinPool.WorkQueue r32, boolean r33) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ForkJoinPool.helpJoin(java.util.concurrent.ForkJoinTask, java.util.concurrent.ForkJoinPool$WorkQueue, boolean):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int helpComplete(ForkJoinTask<?> task, WorkQueue w3, boolean owned) {
        long c4;
        int s2;
        boolean locals;
        CountedCompleter<?> countedCompleter;
        ForkJoinPool forkJoinPool = this;
        WorkQueue workQueue = w3;
        if (task == null || workQueue == null) {
            return 0;
        }
        int r10 = workQueue.config;
        boolean scan = true;
        boolean locals2 = true;
        long c10 = 0;
        while (true) {
            if (locals2) {
                int s10 = workQueue.helpComplete(task, owned, 0);
                if (s10 < 0) {
                    return s10;
                }
                locals2 = false;
            } else {
                int i10 = task.status;
                int nextBase = i10;
                if (i10 >= 0) {
                    boolean z10 = !scan;
                    scan = z10;
                    if (z10) {
                        long c11 = forkJoinPool.ctl;
                        if (c10 != c11) {
                            c10 = c11;
                        } else {
                            return nextBase;
                        }
                    } else {
                        WorkQueue[] qs = forkJoinPool.queues;
                        int n10 = qs == null ? 0 : qs.length;
                        int i11 = n10;
                        while (true) {
                            if (i11 <= 0) {
                                c4 = c10;
                                break;
                            }
                            boolean eligible = false;
                            WorkQueue q10 = qs[r10 & (n10 - 1)];
                            if (q10 != null) {
                                ForkJoinTask<?>[] a10 = q10.array;
                                if (a10 != null) {
                                    int cap = a10.length;
                                    if (cap <= 0) {
                                        s2 = nextBase;
                                        locals = locals2;
                                        c4 = c10;
                                    } else {
                                        int b4 = q10.base;
                                        int k10 = (cap - 1) & b4;
                                        int s11 = b4 + 1;
                                        locals = locals2;
                                        ForkJoinTask<?> t2 = WorkQueue.getSlot(a10, k10);
                                        c4 = c10;
                                        if (t2 instanceof CountedCompleter) {
                                            CountedCompleter<?> f10 = (CountedCompleter) t2;
                                            do {
                                                boolean z11 = f10 == task;
                                                eligible = z11;
                                                if (z11) {
                                                    break;
                                                }
                                                countedCompleter = f10.completer;
                                                f10 = countedCompleter;
                                            } while (countedCompleter != null);
                                        }
                                        int s12 = task.status;
                                        if (s12 < 0) {
                                            return s12;
                                        }
                                        if (q10.base != b4) {
                                            scan = true;
                                            nextBase = s12;
                                        } else if (t2 == null) {
                                            scan |= (a10[(cap + (-1)) & s11] == null && q10.top == b4) ? false : true;
                                            nextBase = s12;
                                        } else if (!eligible) {
                                            nextBase = s12;
                                        } else {
                                            if (WorkQueue.casSlotToNull(a10, k10, t2)) {
                                                q10.setBaseOpaque(s11);
                                                t2.doExec();
                                                locals = true;
                                            }
                                            scan = true;
                                            locals2 = locals;
                                        }
                                        i11--;
                                        r10++;
                                        locals2 = locals;
                                        c10 = c4;
                                    }
                                } else {
                                    s2 = nextBase;
                                    locals = locals2;
                                    c4 = c10;
                                }
                            } else {
                                s2 = nextBase;
                                locals = locals2;
                                c4 = c10;
                            }
                            nextBase = s2;
                            i11--;
                            r10++;
                            locals2 = locals;
                            c10 = c4;
                        }
                        forkJoinPool = this;
                        workQueue = w3;
                        c10 = c4;
                    }
                } else {
                    return nextBase;
                }
            }
        }
    }

    private ForkJoinTask<?> pollScan(boolean submissionsOnly) {
        int n10;
        ForkJoinTask<?>[] a10;
        int cap;
        VarHandle.acquireFence();
        int r10 = this.scanRover + 1640531527;
        this.scanRover = r10;
        if (submissionsOnly) {
            r10 &= -2;
        }
        int step = submissionsOnly ? 2 : 1;
        while (true) {
            WorkQueue[] qs = this.queues;
            if (qs != null && (n10 = qs.length) > 0) {
                boolean scan = false;
                for (int i10 = 0; i10 < n10; i10 += step) {
                    WorkQueue q10 = qs[(n10 - 1) & (r10 + i10)];
                    if (q10 != null && (a10 = q10.array) != null && (cap = a10.length) > 0) {
                        int b4 = q10.base;
                        int k10 = (cap - 1) & b4;
                        int nextBase = b4 + 1;
                        ForkJoinTask<?> t2 = WorkQueue.getSlot(a10, k10);
                        if (q10.base != b4) {
                            scan = true;
                        } else if (t2 == null) {
                            scan = ((q10.top == b4 && a10[(cap + (-1)) & nextBase] == null) ? false : true) | scan;
                        } else {
                            boolean scan2 = WorkQueue.casSlotToNull(a10, k10, t2);
                            if (!scan2) {
                                scan = true;
                            } else {
                                q10.setBaseOpaque(nextBase);
                                return t2;
                            }
                        }
                    }
                }
                if (!scan && this.queues == qs) {
                    return null;
                }
            } else {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int helpQuiescePool(WorkQueue w3, long nanos, boolean interruptible) {
        int cfg;
        long startTime;
        long parkTime;
        boolean interrupted;
        int n10;
        boolean locals;
        boolean scan;
        boolean scan2;
        int n11 = 0;
        if (w3 == null) {
            return 0;
        }
        long startTime2 = System.nanoTime();
        long parkTime2 = 0;
        int prevSrc = w3.source;
        int wsrc = prevSrc;
        int cfg2 = w3.config;
        int r10 = cfg2 + 1;
        boolean active = true;
        boolean locals2 = true;
        while (true) {
            boolean busy = false;
            boolean scan3 = false;
            if (locals2) {
                locals2 = false;
                while (true) {
                    ForkJoinTask<?> u10 = w3.nextLocalTask(cfg2);
                    if (u10 == null) {
                        break;
                    }
                    u10.doExec();
                }
            }
            WorkQueue[] qs = this.queues;
            if (qs != null) {
                n11 = qs.length;
            }
            int i10 = n11;
            while (true) {
                int wsrc2 = wsrc;
                cfg = cfg2;
                if (i10 <= 0) {
                    startTime = startTime2;
                    parkTime = parkTime2;
                    wsrc = wsrc2;
                    break;
                }
                int j10 = (n11 - 1) & r10;
                WorkQueue q10 = qs[j10];
                if (q10 == null) {
                    n10 = n11;
                    startTime = startTime2;
                    parkTime = parkTime2;
                    locals = locals2;
                    scan = scan3;
                } else if (q10 != w3) {
                    ForkJoinTask<?>[] a10 = q10.array;
                    if (a10 != null) {
                        n10 = n11;
                        int n12 = a10.length;
                        if (n12 <= 0) {
                            startTime = startTime2;
                            parkTime = parkTime2;
                            locals = locals2;
                            scan = scan3;
                        } else {
                            locals = locals2;
                            int b4 = q10.base;
                            int k10 = (n12 - 1) & b4;
                            scan = scan3;
                            int nextBase = b4 + 1;
                            startTime = startTime2;
                            int src = j10 | 131072;
                            ForkJoinTask<?> t2 = WorkQueue.getSlot(a10, k10);
                            parkTime = parkTime2;
                            if (q10.base != b4) {
                                busy = true;
                                scan3 = true;
                            } else if (t2 != null) {
                                busy = true;
                                if (active) {
                                    scan2 = true;
                                } else {
                                    active = true;
                                    scan2 = true;
                                    getAndAddCtl(RC_UNIT);
                                }
                                if (!WorkQueue.casSlotToNull(a10, k10, t2)) {
                                    wsrc = wsrc2;
                                    locals2 = locals;
                                    scan3 = scan2;
                                } else {
                                    q10.base = nextBase;
                                    w3.source = src;
                                    t2.doExec();
                                    w3.source = prevSrc;
                                    wsrc = prevSrc;
                                    locals2 = true;
                                    scan3 = scan2;
                                }
                            } else if (!busy) {
                                if (q10.top != b4 || a10[(n12 - 1) & nextBase] != null) {
                                    busy = true;
                                    scan3 = true;
                                } else if (q10.source != 524288 && q10.phase >= 0) {
                                    busy = true;
                                    scan3 = scan;
                                }
                            }
                            i10--;
                            r10++;
                            cfg2 = cfg;
                            wsrc = wsrc2;
                            n11 = n10;
                            locals2 = locals;
                            startTime2 = startTime;
                            parkTime2 = parkTime;
                        }
                    } else {
                        startTime = startTime2;
                        parkTime = parkTime2;
                        locals = locals2;
                        scan = scan3;
                        n10 = n11;
                    }
                } else {
                    n10 = n11;
                    startTime = startTime2;
                    parkTime = parkTime2;
                    locals = locals2;
                    scan = scan3;
                }
                scan3 = scan;
                i10--;
                r10++;
                cfg2 = cfg;
                wsrc = wsrc2;
                n11 = n10;
                locals2 = locals;
                startTime2 = startTime;
                parkTime2 = parkTime;
            }
            VarHandle.acquireFence();
            if (scan3 || this.queues != qs) {
                parkTime2 = parkTime;
            } else {
                if (!busy) {
                    w3.source = prevSrc;
                    if (!active) {
                        getAndAddCtl(RC_UNIT);
                        return 1;
                    }
                    return 1;
                }
                if (wsrc != 524288) {
                    wsrc = 524288;
                    w3.source = 524288;
                }
                if (active) {
                    getAndAddCtl(RC_MASK);
                    active = false;
                    parkTime2 = 0;
                } else if (parkTime == 0) {
                    Thread.yield();
                    parkTime2 = 1024;
                } else {
                    boolean z10 = interruptible && Thread.interrupted();
                    interrupted = z10;
                    if (!z10 && System.nanoTime() - startTime <= nanos) {
                        parkTime2 = parkTime;
                        LockSupport.parkNanos(this, parkTime2);
                        if (parkTime2 < (nanos >>> 8) && parkTime2 < 1048576) {
                            parkTime2 <<= 1;
                        }
                    }
                }
            }
            cfg2 = cfg;
            startTime2 = startTime;
            n11 = 0;
        }
        getAndAddCtl(RC_UNIT);
        return interrupted ? -1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int externalHelpQuiescePool(long nanos, boolean interruptible) {
        long startTime = System.nanoTime();
        long parkTime = 0;
        while (true) {
            ForkJoinTask<?> t2 = pollScan(false);
            if (t2 != null) {
                t2.doExec();
                parkTime = 0;
            } else {
                if (canStop()) {
                    return 1;
                }
                if (parkTime == 0) {
                    parkTime = 1024;
                    Thread.yield();
                } else {
                    if (System.nanoTime() - startTime > nanos) {
                        return 0;
                    }
                    if (interruptible && Thread.interrupted()) {
                        return -1;
                    }
                    LockSupport.parkNanos(this, parkTime);
                    if (parkTime < (nanos >>> 8) && parkTime < 1048576) {
                        parkTime <<= 1;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ForkJoinTask<?> nextTaskFor(WorkQueue w3) {
        ForkJoinTask<?> t2;
        return (w3 == null || (t2 = w3.nextLocalTask(w3.config)) == null) ? pollScan(false) : t2;
    }

    final WorkQueue submissionQueue() {
        int n10;
        int probe = ThreadLocalRandom.getProbe();
        int r10 = probe;
        if (probe == 0) {
            ThreadLocalRandom.localInit();
            r10 = ThreadLocalRandom.getProbe();
        }
        int id2 = r10 << 1;
        while (true) {
            int md2 = this.mode;
            WorkQueue[] qs = this.queues;
            if ((16777216 & md2) != 0 || qs == null || (n10 = qs.length) <= 0) {
                return null;
            }
            int i10 = (n10 - 1) & id2;
            WorkQueue q10 = qs[i10];
            if (q10 == null) {
                ReentrantLock lock = this.registrationLock;
                if (lock != null) {
                    WorkQueue w3 = new WorkQueue(131072 | id2);
                    lock.lock();
                    if (qs[i10] == null) {
                        qs[i10] = w3;
                    }
                    lock.unlock();
                }
            } else {
                if (q10.tryLock()) {
                    return q10;
                }
                int advanceProbe = ThreadLocalRandom.advanceProbe(r10);
                r10 = advanceProbe;
                id2 = advanceProbe << 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void externalPush(ForkJoinTask<?> task) {
        WorkQueue q10 = submissionQueue();
        if (q10 == null) {
            throw new RejectedExecutionException();
        }
        if (q10.lockedPush(task)) {
            signalWork();
        }
    }

    private <T> ForkJoinTask<T> externalSubmit(ForkJoinTask<T> task) {
        ForkJoinWorkerThread wt;
        WorkQueue q10;
        if (task == null) {
            throw new NullPointerException();
        }
        Thread t2 = Thread.currentThread();
        if ((t2 instanceof ForkJoinWorkerThread) && (q10 = (wt = (ForkJoinWorkerThread) t2).workQueue) != null && wt.pool == this) {
            q10.push(task, this);
        } else {
            externalPush(task);
        }
        return task;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WorkQueue commonQueue() {
        WorkQueue[] qs;
        int n10;
        int r10 = ThreadLocalRandom.getProbe();
        ForkJoinPool p10 = common;
        if (p10 == null || (qs = p10.queues) == null || (n10 = qs.length) <= 0 || r10 == 0) {
            return null;
        }
        return qs[(n10 - 1) & (r10 << 1)];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final WorkQueue externalQueue() {
        int n10;
        int r10 = ThreadLocalRandom.getProbe();
        WorkQueue[] qs = this.queues;
        if (qs == null || (n10 = qs.length) <= 0 || r10 == 0) {
            return null;
        }
        return qs[(n10 - 1) & (r10 << 1)];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void helpAsyncBlocker(Executor e2, ManagedBlocker blocker) {
        WorkQueue w3 = null;
        Thread t2 = Thread.currentThread();
        if (t2 instanceof ForkJoinWorkerThread) {
            ForkJoinWorkerThread wt = (ForkJoinWorkerThread) t2;
            if (wt.pool == e2) {
                w3 = wt.workQueue;
            }
        } else if (e2 instanceof ForkJoinPool) {
            w3 = ((ForkJoinPool) e2).externalQueue();
        }
        if (w3 != null) {
            w3.helpAsyncBlocker(blocker);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getSurplusQueuedTaskCount() {
        ForkJoinWorkerThread wt;
        ForkJoinPool pool;
        WorkQueue q10;
        Thread t2 = Thread.currentThread();
        int i10 = 0;
        if (!(t2 instanceof ForkJoinWorkerThread) || (pool = (wt = (ForkJoinWorkerThread) t2).pool) == null || (q10 = wt.workQueue) == null) {
            return 0;
        }
        int p10 = pool.mode & 65535;
        int a10 = ((int) (pool.ctl >> 48)) + p10;
        int n10 = q10.top - q10.base;
        int p11 = p10 >>> 1;
        if (a10 <= p11) {
            int p12 = p11 >>> 1;
            if (a10 > p12) {
                i10 = 1;
            } else {
                int p13 = p12 >>> 1;
                if (a10 > p13) {
                    i10 = 2;
                } else {
                    i10 = a10 > (p13 >>> 1) ? 4 : 8;
                }
            }
        }
        return n10 - i10;
    }

    private boolean tryTerminate(boolean now, boolean enable) {
        ReentrantLock lock;
        int n10;
        Thread thread;
        int i10 = this.mode;
        int md2 = i10;
        if ((i10 & 16777216) == 0) {
            if (!enable) {
                return false;
            }
            md2 = getAndBitwiseOrMode(16777216);
        }
        if ((md2 & Integer.MIN_VALUE) == 0) {
            if (!now && !canStop()) {
                return false;
            }
            getAndBitwiseOrMode(Integer.MIN_VALUE);
        }
        boolean rescan = true;
        while (true) {
            boolean changed = false;
            while (true) {
                ForkJoinTask<?> t2 = pollScan(false);
                if (t2 == null) {
                    break;
                }
                changed = true;
                ForkJoinTask.cancelIgnoringExceptions(t2);
            }
            WorkQueue[] qs = this.queues;
            if (qs != null && (n10 = qs.length) > 0) {
                for (int j10 = 1; j10 < n10; j10 += 2) {
                    WorkQueue q10 = qs[j10];
                    if (q10 != null && (thread = q10.owner) != null && !thread.isInterrupted()) {
                        changed = true;
                        try {
                            thread.interrupt();
                        } catch (Throwable th) {
                        }
                    }
                }
            }
            int j11 = this.mode;
            if ((j11 & 33554432) == 0 && (65535 & j11) + ((short) (this.ctl >>> 32)) <= 0 && (getAndBitwiseOrMode(33554432) & 33554432) == 0 && (lock = this.registrationLock) != null) {
                lock.lock();
                Condition cond = this.termination;
                if (cond != null) {
                    cond.signalAll();
                }
                lock.unlock();
            }
            if (changed) {
                rescan = true;
            } else if (rescan) {
                rescan = false;
            } else {
                return true;
            }
        }
    }

    public ForkJoinPool() {
        this(Math.min(MAX_CAP, Runtime.getRuntime().availableProcessors()), defaultForkJoinWorkerThreadFactory, null, false, 0, MAX_CAP, 1, null, 60000L, TimeUnit.MILLISECONDS);
    }

    public ForkJoinPool(int parallelism) {
        this(parallelism, defaultForkJoinWorkerThreadFactory, null, false, 0, MAX_CAP, 1, null, 60000L, TimeUnit.MILLISECONDS);
    }

    public ForkJoinPool(int parallelism, ForkJoinWorkerThreadFactory factory, Thread.UncaughtExceptionHandler handler, boolean asyncMode) {
        this(parallelism, factory, handler, asyncMode, 0, MAX_CAP, 1, null, 60000L, TimeUnit.MILLISECONDS);
    }

    public ForkJoinPool(int parallelism, ForkJoinWorkerThreadFactory factory, Thread.UncaughtExceptionHandler handler, boolean asyncMode, int corePoolSize, int maximumPoolSize, int minimumRunnable, Predicate<? super ForkJoinPool> saturate, long keepAliveTime, TimeUnit unit) {
        checkPermission();
        if (parallelism <= 0 || parallelism > MAX_CAP || parallelism > maximumPoolSize || keepAliveTime <= 0) {
            throw new IllegalArgumentException();
        }
        if (factory == null || unit == null) {
            throw new NullPointerException();
        }
        this.factory = factory;
        this.ueh = handler;
        this.saturate = saturate;
        this.keepAlive = Math.max(unit.toMillis(keepAliveTime), TIMEOUT_SLOP);
        int size = 1 << (33 - Integer.numberOfLeadingZeros(parallelism - 1));
        int corep = Math.min(Math.max(corePoolSize, parallelism), MAX_CAP);
        int maxSpares = Math.min(maximumPoolSize, MAX_CAP) - parallelism;
        int minAvail = Math.min(Math.max(minimumRunnable, 0), MAX_CAP);
        this.bounds = ((minAvail - parallelism) & 65535) | (maxSpares << 16);
        this.mode = parallelism | (asyncMode ? 65536 : 0);
        this.ctl = (((-corep) << 32) & TC_MASK) | (((-parallelism) << 48) & RC_MASK);
        this.registrationLock = new ReentrantLock();
        this.queues = new WorkQueue[size];
        String pid = Integer.toString(getAndAddPoolIds(1) + 1);
        this.workerNamePrefix = "ForkJoinPool-" + pid + "-worker-";
    }

    private static Object newInstanceFromSystemProperty(String property) throws ReflectiveOperationException {
        String className = System.getProperty(property);
        if (className == null) {
            return null;
        }
        return ClassLoader.getSystemClassLoader().loadClass(className).getConstructor(new Class[0]).newInstance(new Object[0]);
    }

    private ForkJoinPool(byte forCommonPoolOnly) {
        int size;
        int parallelism = Math.max(1, Runtime.getRuntime().availableProcessors() - 1);
        ForkJoinWorkerThreadFactory fac = null;
        Thread.UncaughtExceptionHandler handler = null;
        try {
            fac = (ForkJoinWorkerThreadFactory) newInstanceFromSystemProperty("java.util.concurrent.ForkJoinPool.common.threadFactory");
            handler = (Thread.UncaughtExceptionHandler) newInstanceFromSystemProperty("java.util.concurrent.ForkJoinPool.common.exceptionHandler");
            String pp = System.getProperty("java.util.concurrent.ForkJoinPool.common.parallelism");
            if (pp != null) {
                parallelism = Integer.parseInt(pp);
            }
        } catch (Exception e2) {
        }
        this.ueh = handler;
        this.keepAlive = 60000L;
        this.saturate = null;
        this.workerNamePrefix = null;
        int p10 = Math.min(Math.max(parallelism, 0), MAX_CAP);
        this.mode = p10;
        if (p10 > 0) {
            size = 1 << (33 - Integer.numberOfLeadingZeros(p10 - 1));
            this.bounds = ((1 - p10) & 65535) | (COMMON_MAX_SPARES << 16);
            this.ctl = (((-p10) << 32) & TC_MASK) | (((-p10) << 48) & RC_MASK);
        } else {
            size = 1;
            this.bounds = 0;
            this.ctl = 0L;
        }
        this.factory = fac != null ? fac : new DefaultCommonPoolForkJoinWorkerThreadFactory();
        this.queues = new WorkQueue[size];
        this.registrationLock = new ReentrantLock();
    }

    public static ForkJoinPool commonPool() {
        return common;
    }

    public <T> T invoke(ForkJoinTask<T> task) {
        externalSubmit(task);
        return task.joinForPoolInvoke(this);
    }

    public void execute(ForkJoinTask<?> task) {
        externalSubmit(task);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        Future runnableExecuteAction;
        if (runnable instanceof ForkJoinTask) {
            runnableExecuteAction = (ForkJoinTask) runnable;
        } else {
            runnableExecuteAction = new ForkJoinTask.RunnableExecuteAction(runnable);
        }
        externalSubmit(runnableExecuteAction);
    }

    public <T> ForkJoinTask<T> submit(ForkJoinTask<T> task) {
        return externalSubmit(task);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> ForkJoinTask<T> submit(Callable<T> task) {
        return externalSubmit(new ForkJoinTask.AdaptedCallable(task));
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> ForkJoinTask<T> submit(Runnable task, T result) {
        return externalSubmit(new ForkJoinTask.AdaptedRunnable(task, result));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public ForkJoinTask<?> submit(Runnable runnable) {
        Future adaptedRunnableAction;
        if (runnable instanceof ForkJoinTask) {
            adaptedRunnableAction = (ForkJoinTask) runnable;
        } else {
            adaptedRunnableAction = new ForkJoinTask.AdaptedRunnableAction(runnable);
        }
        return externalSubmit(adaptedRunnableAction);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) {
        ArrayList<Future<T>> futures = new ArrayList<>(tasks.size());
        try {
            for (Callable<T> t2 : tasks) {
                ForkJoinTask.AdaptedInterruptibleCallable adaptedInterruptibleCallable = new ForkJoinTask.AdaptedInterruptibleCallable(t2);
                futures.add(adaptedInterruptibleCallable);
                externalSubmit(adaptedInterruptibleCallable);
            }
            for (int i10 = futures.size() - 1; i10 >= 0; i10--) {
                ((ForkJoinTask) futures.get(i10)).awaitPoolInvoke(this);
            }
            return futures;
        } catch (Throwable t10) {
            Iterator<Future<T>> iterator2 = futures.iterator2();
            while (iterator2.hasNext()) {
                Future<T> e2 = iterator2.next();
                ForkJoinTask.cancelIgnoringExceptions(e2);
            }
            throw t10;
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        long j10;
        long nanos = unit.toNanos(timeout);
        ArrayList<Future<T>> futures = new ArrayList<>(tasks.size());
        try {
            for (Callable<T> t2 : tasks) {
                ForkJoinTask.AdaptedInterruptibleCallable adaptedInterruptibleCallable = new ForkJoinTask.AdaptedInterruptibleCallable(t2);
                futures.add(adaptedInterruptibleCallable);
                externalSubmit(adaptedInterruptibleCallable);
            }
            long startTime = System.nanoTime();
            long ns = nanos;
            long j11 = 0;
            boolean timedOut = ns < 0;
            int i10 = futures.size() - 1;
            while (i10 >= 0) {
                Future<T> f10 = futures.get(i10);
                if (f10.isDone()) {
                    j10 = j11;
                } else if (!timedOut) {
                    ((ForkJoinTask) f10).awaitPoolInvoke(this, ns);
                    long nanoTime = nanos - (System.nanoTime() - startTime);
                    ns = nanoTime;
                    j10 = 0;
                    if (nanoTime < 0) {
                        timedOut = true;
                    }
                } else {
                    ForkJoinTask.cancelIgnoringExceptions(f10);
                    j10 = j11;
                }
                i10--;
                j11 = j10;
            }
            return futures;
        } catch (Throwable t10) {
            Iterator<Future<T>> iterator2 = futures.iterator2();
            while (iterator2.hasNext()) {
                Future<T> e2 = iterator2.next();
                ForkJoinTask.cancelIgnoringExceptions(e2);
            }
            throw t10;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class InvokeAnyRoot<E> extends ForkJoinTask<E> {
        private static final long serialVersionUID = 2838392045355241008L;
        final AtomicInteger count;
        final ForkJoinPool pool;
        volatile E result;

        InvokeAnyRoot(int n10, ForkJoinPool p10) {
            this.pool = p10;
            this.count = new AtomicInteger(n10);
        }

        final void tryComplete(Callable<E> c4) {
            boolean failed;
            ForkJoinPool forkJoinPool;
            Throwable ex = null;
            if (c4 == null || Thread.interrupted() || ((forkJoinPool = this.pool) != null && forkJoinPool.mode < 0)) {
                failed = true;
            } else if (isDone()) {
                failed = false;
            } else {
                try {
                    complete(c4.call());
                    failed = false;
                } catch (Throwable tx) {
                    ex = tx;
                    failed = true;
                }
            }
            ForkJoinPool forkJoinPool2 = this.pool;
            if ((forkJoinPool2 != null && forkJoinPool2.mode < 0) || (failed && this.count.getAndDecrement() <= 1)) {
                trySetThrown(ex != null ? ex : new CancellationException());
            }
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final boolean exec() {
            return false;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final E getRawResult() {
            return this.result;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final void setRawResult(E v2) {
            this.result = v2;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class InvokeAnyTask<E> extends ForkJoinTask<E> {
        private static final long serialVersionUID = 2838392045355241008L;
        final Callable<E> callable;
        final InvokeAnyRoot<E> root;
        volatile transient Thread runner;

        InvokeAnyTask(InvokeAnyRoot<E> root, Callable<E> callable) {
            this.root = root;
            this.callable = callable;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final boolean exec() {
            Thread.interrupted();
            this.runner = Thread.currentThread();
            this.root.tryComplete(this.callable);
            this.runner = null;
            Thread.interrupted();
            return true;
        }

        @Override // java.util.concurrent.ForkJoinTask, java.util.concurrent.Future
        public final boolean cancel(boolean mayInterruptIfRunning) {
            Thread t2;
            boolean stat = super.cancel(false);
            if (mayInterruptIfRunning && (t2 = this.runner) != null) {
                try {
                    t2.interrupt();
                } catch (Throwable th) {
                }
            }
            return stat;
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final void setRawResult(E v2) {
        }

        @Override // java.util.concurrent.ForkJoinTask
        public final E getRawResult() {
            return null;
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        int size = collection.size();
        if (size <= 0) {
            throw new IllegalArgumentException();
        }
        InvokeAnyRoot invokeAnyRoot = new InvokeAnyRoot(size, this);
        ArrayList arrayList = new ArrayList(size);
        try {
            for (Callable<T> callable : collection) {
                if (callable == null) {
                    throw new NullPointerException();
                }
                InvokeAnyTask invokeAnyTask = new InvokeAnyTask(invokeAnyRoot, callable);
                arrayList.add(invokeAnyTask);
                externalSubmit(invokeAnyTask);
                if (invokeAnyRoot.isDone()) {
                    break;
                }
            }
            return (T) invokeAnyRoot.getForPoolInvoke(this);
        } finally {
            Iterator iterator2 = arrayList.iterator2();
            while (iterator2.hasNext()) {
                ForkJoinTask.cancelIgnoringExceptions((InvokeAnyTask) iterator2.next());
            }
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        long nanos = timeUnit.toNanos(j10);
        int size = collection.size();
        if (size <= 0) {
            throw new IllegalArgumentException();
        }
        InvokeAnyRoot invokeAnyRoot = new InvokeAnyRoot(size, this);
        ArrayList arrayList = new ArrayList(size);
        try {
            for (Callable<T> callable : collection) {
                if (callable == null) {
                    throw new NullPointerException();
                }
                InvokeAnyTask invokeAnyTask = new InvokeAnyTask(invokeAnyRoot, callable);
                arrayList.add(invokeAnyTask);
                externalSubmit(invokeAnyTask);
                if (invokeAnyRoot.isDone()) {
                    break;
                }
            }
            return (T) invokeAnyRoot.getForPoolInvoke(this, nanos);
        } finally {
            Iterator iterator2 = arrayList.iterator2();
            while (iterator2.hasNext()) {
                ForkJoinTask.cancelIgnoringExceptions((InvokeAnyTask) iterator2.next());
            }
        }
    }

    public ForkJoinWorkerThreadFactory getFactory() {
        return this.factory;
    }

    public Thread.UncaughtExceptionHandler getUncaughtExceptionHandler() {
        return this.ueh;
    }

    public int getParallelism() {
        int par = this.mode & 65535;
        if (par > 0) {
            return par;
        }
        return 1;
    }

    public static int getCommonPoolParallelism() {
        return COMMON_PARALLELISM;
    }

    public int getPoolSize() {
        return (this.mode & 65535) + ((short) (this.ctl >>> 32));
    }

    public boolean getAsyncMode() {
        return (this.mode & 65536) != 0;
    }

    public int getRunningThreadCount() {
        VarHandle.acquireFence();
        int rc2 = 0;
        WorkQueue[] qs = this.queues;
        if (qs != null) {
            for (int i10 = 1; i10 < qs.length; i10 += 2) {
                WorkQueue q10 = qs[i10];
                if (q10 != null && q10.isApparentlyUnblocked()) {
                    rc2++;
                }
            }
        }
        return rc2;
    }

    public int getActiveThreadCount() {
        int r10 = (this.mode & 65535) + ((int) (this.ctl >> 48));
        if (r10 <= 0) {
            return 0;
        }
        return r10;
    }

    public boolean isQuiescent() {
        return canStop();
    }

    public long getStealCount() {
        long count = this.stealCount;
        WorkQueue[] qs = this.queues;
        if (qs != null) {
            for (int i10 = 1; i10 < qs.length; i10 += 2) {
                WorkQueue q10 = qs[i10];
                if (q10 != null) {
                    count += q10.nsteals & 4294967295L;
                }
            }
        }
        return count;
    }

    public long getQueuedTaskCount() {
        VarHandle.acquireFence();
        int count = 0;
        WorkQueue[] qs = this.queues;
        if (qs != null) {
            for (int i10 = 1; i10 < qs.length; i10 += 2) {
                WorkQueue q10 = qs[i10];
                if (q10 != null) {
                    count += q10.queueSize();
                }
            }
        }
        return count;
    }

    public int getQueuedSubmissionCount() {
        VarHandle.acquireFence();
        int count = 0;
        WorkQueue[] qs = this.queues;
        if (qs != null) {
            for (int i10 = 0; i10 < qs.length; i10 += 2) {
                WorkQueue q10 = qs[i10];
                if (q10 != null) {
                    count += q10.queueSize();
                }
            }
        }
        return count;
    }

    public boolean hasQueuedSubmissions() {
        VarHandle.acquireFence();
        WorkQueue[] qs = this.queues;
        if (qs != null) {
            for (int i10 = 0; i10 < qs.length; i10 += 2) {
                WorkQueue q10 = qs[i10];
                if (q10 != null && !q10.isEmpty()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ForkJoinTask<?> pollSubmission() {
        return pollScan(true);
    }

    protected int drainTasksTo(Collection<? super ForkJoinTask<?>> c4) {
        int count = 0;
        while (true) {
            ForkJoinTask<?> t2 = pollScan(false);
            if (t2 != null) {
                c4.add(t2);
                count++;
            } else {
                return count;
            }
        }
    }

    public String toString() {
        long c4;
        String level;
        long c10;
        int md2 = this.mode;
        long c11 = this.ctl;
        long st = this.stealCount;
        long qt = 0;
        long ss = 0;
        int rc2 = 0;
        WorkQueue[] qs = this.queues;
        if (qs == null) {
            c4 = c11;
        } else {
            int i10 = 0;
            while (i10 < qs.length) {
                WorkQueue q10 = qs[i10];
                if (q10 == null) {
                    c10 = c11;
                } else {
                    int size = q10.queueSize();
                    if ((i10 & 1) == 0) {
                        c10 = c11;
                        ss += size;
                    } else {
                        c10 = c11;
                        qt += size;
                        st += q10.nsteals & 4294967295L;
                        if (q10.isApparentlyUnblocked()) {
                            rc2++;
                        }
                    }
                }
                i10++;
                c11 = c10;
            }
            c4 = c11;
        }
        int pc2 = 65535 & md2;
        int tc2 = ((short) (c4 >>> 32)) + pc2;
        int ac2 = ((int) (c4 >> 48)) + pc2;
        if (ac2 < 0) {
            ac2 = 0;
        }
        if ((33554432 & md2) != 0) {
            level = "Terminated";
        } else if ((Integer.MIN_VALUE & md2) != 0) {
            level = "Terminating";
        } else {
            level = (16777216 & md2) != 0 ? "Shutting down" : "Running";
        }
        return super.toString() + "[" + level + ", parallelism = " + pc2 + ", size = " + tc2 + ", active = " + ac2 + ", running = " + rc2 + ", steals = " + st + ", tasks = " + qt + ", submissions = " + ss + "]";
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        checkPermission();
        if (this != common) {
            tryTerminate(false, true);
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        checkPermission();
        if (this != common) {
            tryTerminate(true, true);
        }
        return Collections.emptyList();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return (this.mode & 33554432) != 0;
    }

    public boolean isTerminating() {
        return (this.mode & (-2113929216)) == Integer.MIN_VALUE;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return (this.mode & 16777216) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    @Override // java.util.concurrent.ExecutorService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean awaitTermination(long r12, java.util.concurrent.TimeUnit r14) throws java.lang.InterruptedException {
        /*
            r11 = this;
            long r0 = r14.toNanos(r12)
            r2 = 0
            java.util.concurrent.ForkJoinPool r3 = java.util.concurrent.ForkJoinPool.common
            r4 = 1
            if (r11 != r3) goto L2f
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            r5 = r3
            boolean r3 = r3 instanceof java.util.concurrent.ForkJoinWorkerThread
            if (r3 == 0) goto L22
            r3 = r5
            java.util.concurrent.ForkJoinWorkerThread r3 = (java.util.concurrent.ForkJoinWorkerThread) r3
            r6 = r3
            java.util.concurrent.ForkJoinPool r3 = r3.pool
            if (r3 != r11) goto L22
            java.util.concurrent.ForkJoinPool$WorkQueue r3 = r6.workQueue
            int r3 = r11.helpQuiescePool(r3, r0, r4)
            goto L26
        L22:
            int r3 = r11.externalHelpQuiescePool(r0, r4)
        L26:
            if (r3 < 0) goto L29
            goto L71
        L29:
            java.lang.InterruptedException r4 = new java.lang.InterruptedException
            r4.<init>()
            throw r4
        L2f:
            int r3 = r11.mode
            r5 = 33554432(0x2000000, float:9.403955E-38)
            r3 = r3 & r5
            r6 = 0
            if (r3 == 0) goto L39
            r3 = r4
            goto L3a
        L39:
            r3 = r6
        L3a:
            r2 = r3
            if (r3 != 0) goto L71
            java.util.concurrent.locks.ReentrantLock r3 = r11.registrationLock
            r7 = r3
            if (r3 == 0) goto L71
            r7.lock()
            java.util.concurrent.locks.Condition r3 = r11.termination     // Catch: java.lang.Throwable -> L6c
            r8 = r3
            if (r3 != 0) goto L51
            java.util.concurrent.locks.Condition r3 = r7.newCondition()     // Catch: java.lang.Throwable -> L6c
            r8 = r3
            r11.termination = r3     // Catch: java.lang.Throwable -> L6c
        L51:
            int r3 = r11.mode     // Catch: java.lang.Throwable -> L6c
            r3 = r3 & r5
            if (r3 == 0) goto L58
            r3 = r4
            goto L59
        L58:
            r3 = r6
        L59:
            r2 = r3
            if (r3 != 0) goto L68
            r9 = 0
            int r3 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r3 <= 0) goto L68
            long r9 = r8.awaitNanos(r0)     // Catch: java.lang.Throwable -> L6c
            r0 = r9
            goto L51
        L68:
            r7.unlock()
            goto L71
        L6c:
            r3 = move-exception
            r7.unlock()
            throw r3
        L71:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ForkJoinPool.awaitTermination(long, java.util.concurrent.TimeUnit):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0023 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean awaitQuiescence(long r7, java.util.concurrent.TimeUnit r9) {
        /*
            r6 = this;
            long r0 = r9.toNanos(r7)
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            r3 = r2
            boolean r2 = r2 instanceof java.util.concurrent.ForkJoinWorkerThread
            r4 = 0
            if (r2 == 0) goto L1d
            r2 = r3
            java.util.concurrent.ForkJoinWorkerThread r2 = (java.util.concurrent.ForkJoinWorkerThread) r2
            r5 = r2
            java.util.concurrent.ForkJoinPool r2 = r2.pool
            if (r2 != r6) goto L1d
            java.util.concurrent.ForkJoinPool$WorkQueue r2 = r5.workQueue
            int r2 = r6.helpQuiescePool(r2, r0, r4)
            goto L21
        L1d:
            int r2 = r6.externalHelpQuiescePool(r0, r4)
        L21:
            if (r2 <= 0) goto L24
            r4 = 1
        L24:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.ForkJoinPool.awaitQuiescence(long, java.util.concurrent.TimeUnit):boolean");
    }

    public static void managedBlock(ManagedBlocker blocker) throws InterruptedException {
        ForkJoinPool p10;
        Thread t2 = Thread.currentThread();
        if ((t2 instanceof ForkJoinWorkerThread) && (p10 = ((ForkJoinWorkerThread) t2).pool) != null) {
            p10.compensatedBlock(blocker);
        } else {
            unmanagedBlock(blocker);
        }
    }

    private void compensatedBlock(ManagedBlocker blocker) throws InterruptedException {
        if (blocker == null) {
            throw new NullPointerException();
        }
        while (true) {
            long c4 = this.ctl;
            if (!blocker.isReleasable()) {
                int comp = tryCompensate(c4);
                if (comp >= 0) {
                    long post = comp == 0 ? 0L : RC_UNIT;
                    try {
                        boolean done = blocker.block();
                        if (done) {
                            return;
                        }
                    } finally {
                        getAndAddCtl(post);
                    }
                }
            } else {
                return;
            }
        }
    }

    private static void unmanagedBlock(ManagedBlocker blocker) throws InterruptedException {
        if (blocker == null) {
            throw new NullPointerException();
        }
        while (!blocker.isReleasable() && !blocker.block()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
        return new ForkJoinTask.AdaptedRunnable(runnable, value);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new ForkJoinTask.AdaptedCallable(callable);
    }

    static {
        try {
            MethodHandles.Lookup l10 = MethodHandles.lookup();
            CTL = l10.findVarHandle(ForkJoinPool.class, "ctl", Long.TYPE);
            MODE = l10.findVarHandle(ForkJoinPool.class, "mode", Integer.TYPE);
            THREADIDS = l10.findVarHandle(ForkJoinPool.class, "threadIds", Integer.TYPE);
            POOLIDS = l10.findStaticVarHandle(ForkJoinPool.class, "poolIds", Integer.TYPE);
            int commonMaxSpares = 256;
            try {
                String p10 = System.getProperty("java.util.concurrent.ForkJoinPool.common.maximumSpares");
                if (p10 != null) {
                    commonMaxSpares = Integer.parseInt(p10);
                }
            } catch (Exception e2) {
            }
            COMMON_MAX_SPARES = commonMaxSpares;
            defaultForkJoinWorkerThreadFactory = new DefaultForkJoinWorkerThreadFactory();
            modifyThreadPermission = new RuntimePermission("modifyThread");
            ForkJoinPool tmp = (ForkJoinPool) AccessController.doPrivileged(new PrivilegedAction<ForkJoinPool>() { // from class: java.util.concurrent.ForkJoinPool.1
                @Override // java.security.PrivilegedAction
                public ForkJoinPool run() {
                    return new ForkJoinPool((byte) 0);
                }
            });
            common = tmp;
            COMMON_PARALLELISM = Math.max(tmp.mode & 65535, 1);
        } catch (ReflectiveOperationException e10) {
            throw new ExceptionInInitializerError(e10);
        }
    }
}
