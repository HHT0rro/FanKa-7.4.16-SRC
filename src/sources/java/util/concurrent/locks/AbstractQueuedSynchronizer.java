package java.util.concurrent.locks;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import jdk.internal.misc.Unsafe;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AbstractQueuedSynchronizer extends AbstractOwnableSynchronizer implements Serializable {
    static final int CANCELLED = Integer.MIN_VALUE;
    static final int COND = 2;
    private static final long HEAD;
    private static final long STATE;
    private static final long TAIL;
    private static final Unsafe U;
    static final int WAITING = 1;
    private static final long serialVersionUID = 7373984972572414691L;
    private volatile transient Node head;
    private volatile int state;
    private volatile transient Node tail;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class Node {
        volatile Node next;
        volatile Node prev;
        volatile int status;
        Thread waiter;
        private static final long STATUS = AbstractQueuedSynchronizer.U.objectFieldOffset(Node.class, "status");
        private static final long NEXT = AbstractQueuedSynchronizer.U.objectFieldOffset(Node.class, "next");
        private static final long PREV = AbstractQueuedSynchronizer.U.objectFieldOffset(Node.class, "prev");

        Node() {
        }

        final boolean casPrev(Node c4, Node v2) {
            return AbstractQueuedSynchronizer.U.weakCompareAndSetReference(this, PREV, c4, v2);
        }

        final boolean casNext(Node c4, Node v2) {
            return AbstractQueuedSynchronizer.U.weakCompareAndSetReference(this, NEXT, c4, v2);
        }

        final int getAndUnsetStatus(int v2) {
            return AbstractQueuedSynchronizer.U.getAndBitwiseAndInt(this, STATUS, ~v2);
        }

        final void setPrevRelaxed(Node p10) {
            AbstractQueuedSynchronizer.U.putReference(this, PREV, p10);
        }

        final void setStatusRelaxed(int s2) {
            AbstractQueuedSynchronizer.U.putInt(this, STATUS, s2);
        }

        final void clearStatus() {
            AbstractQueuedSynchronizer.U.putIntOpaque(this, STATUS, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class ExclusiveNode extends Node {
        ExclusiveNode() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class SharedNode extends Node {
        SharedNode() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class ConditionNode extends Node implements ForkJoinPool.ManagedBlocker {
        ConditionNode nextWaiter;

        ConditionNode() {
        }

        @Override // java.util.concurrent.ForkJoinPool.ManagedBlocker
        public final boolean isReleasable() {
            return this.status <= 1 || Thread.currentThread().isInterrupted();
        }

        @Override // java.util.concurrent.ForkJoinPool.ManagedBlocker
        public final boolean block() {
            while (!isReleasable()) {
                LockSupport.park();
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getState() {
        return this.state;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setState(int newState) {
        this.state = newState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean compareAndSetState(int expect, int update) {
        return U.compareAndSetInt(this, STATE, expect, update);
    }

    private boolean casTail(Node c4, Node v2) {
        return U.compareAndSetReference(this, TAIL, c4, v2);
    }

    private void tryInitializeHead() {
        Node h10 = new ExclusiveNode();
        if (U.compareAndSetReference(this, HEAD, null, h10)) {
            this.tail = h10;
        }
    }

    final void enqueue(Node node) {
        Node t2;
        if (node != null) {
            while (true) {
                t2 = this.tail;
                node.setPrevRelaxed(t2);
                if (t2 == null) {
                    tryInitializeHead();
                } else if (casTail(t2, node)) {
                    break;
                }
            }
            t2.next = node;
            if (t2.status < 0) {
                LockSupport.unpark(node.waiter);
            }
        }
    }

    final boolean isEnqueued(Node node) {
        for (Node t2 = this.tail; t2 != null; t2 = t2.prev) {
            if (t2 == node) {
                return true;
            }
        }
        return false;
    }

    private static void signalNext(Node h10) {
        Node s2;
        if (h10 != null && (s2 = h10.next) != null && s2.status != 0) {
            s2.getAndUnsetStatus(1);
            LockSupport.unpark(s2.waiter);
        }
    }

    private static void signalNextIfShared(Node h10) {
        Node s2;
        if (h10 != null && (s2 = h10.next) != null && (s2 instanceof SharedNode) && s2.status != 0) {
            s2.getAndUnsetStatus(1);
            LockSupport.unpark(s2.waiter);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0070 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0052 A[Catch: all -> 0x0103, TRY_LEAVE, TryCatch #0 {all -> 0x0103, blocks: (B:86:0x0049, B:75:0x0052), top: B:85:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0049 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int acquire(java.util.concurrent.locks.AbstractQueuedSynchronizer.Node r19, int r20, boolean r21, boolean r22, boolean r23, long r24) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.locks.AbstractQueuedSynchronizer.acquire(java.util.concurrent.locks.AbstractQueuedSynchronizer$Node, int, boolean, boolean, boolean, long):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0020 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0033 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0001 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void cleanQueue() {
        /*
            r5 = this;
        L1:
            java.util.concurrent.locks.AbstractQueuedSynchronizer$Node r0 = r5.tail
            r1 = 0
        L4:
            if (r0 == 0) goto L59
            java.util.concurrent.locks.AbstractQueuedSynchronizer$Node r2 = r0.prev
            r3 = r2
            if (r2 != 0) goto Lc
            goto L59
        Lc:
            if (r1 != 0) goto L13
            java.util.concurrent.locks.AbstractQueuedSynchronizer$Node r2 = r5.tail
            if (r2 == r0) goto L1c
            goto L58
        L13:
            java.util.concurrent.locks.AbstractQueuedSynchronizer$Node r2 = r1.prev
            if (r2 != r0) goto L58
            int r2 = r1.status
            if (r2 >= 0) goto L1c
            goto L58
        L1c:
            int r2 = r0.status
            if (r2 >= 0) goto L3e
            if (r1 != 0) goto L29
            boolean r2 = r5.casTail(r0, r3)
            if (r2 == 0) goto L58
            goto L2f
        L29:
            boolean r2 = r1.casPrev(r0, r3)
            if (r2 == 0) goto L58
        L2f:
            java.util.concurrent.locks.AbstractQueuedSynchronizer$Node r2 = r0.prev
            if (r2 != r3) goto L58
            r3.casNext(r0, r1)
            java.util.concurrent.locks.AbstractQueuedSynchronizer$Node r2 = r3.prev
            if (r2 != 0) goto L58
            signalNext(r3)
            goto L58
        L3e:
            java.util.concurrent.locks.AbstractQueuedSynchronizer$Node r2 = r3.next
            r4 = r2
            if (r2 == r0) goto L54
            if (r4 == 0) goto L58
            java.util.concurrent.locks.AbstractQueuedSynchronizer$Node r2 = r0.prev
            if (r2 != r3) goto L58
            r3.casNext(r4, r0)
            java.util.concurrent.locks.AbstractQueuedSynchronizer$Node r2 = r3.prev
            if (r2 != 0) goto L58
            signalNext(r3)
            goto L58
        L54:
            r1 = r0
            java.util.concurrent.locks.AbstractQueuedSynchronizer$Node r0 = r0.prev
            goto L4
        L58:
            goto L1
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.locks.AbstractQueuedSynchronizer.cleanQueue():void");
    }

    private int cancelAcquire(Node node, boolean interrupted, boolean interruptible) {
        if (node != null) {
            node.waiter = null;
            node.status = Integer.MIN_VALUE;
            if (node.prev != null) {
                cleanQueue();
            }
        }
        if (interrupted) {
            if (interruptible) {
                return Integer.MIN_VALUE;
            }
            Thread.currentThread().interrupt();
            return 0;
        }
        return 0;
    }

    protected boolean tryAcquire(int arg) {
        throw new UnsupportedOperationException();
    }

    protected boolean tryRelease(int arg) {
        throw new UnsupportedOperationException();
    }

    protected int tryAcquireShared(int arg) {
        throw new UnsupportedOperationException();
    }

    protected boolean tryReleaseShared(int arg) {
        throw new UnsupportedOperationException();
    }

    protected boolean isHeldExclusively() {
        throw new UnsupportedOperationException();
    }

    public final void acquire(int arg) {
        if (!tryAcquire(arg)) {
            acquire(null, arg, false, false, false, 0L);
        }
    }

    public final void acquireInterruptibly(int arg) throws InterruptedException {
        if (Thread.interrupted() || (!tryAcquire(arg) && acquire(null, arg, false, true, false, 0L) < 0)) {
            throw new InterruptedException();
        }
    }

    public final boolean tryAcquireNanos(int arg, long nanosTimeout) throws InterruptedException {
        if (!Thread.interrupted()) {
            if (tryAcquire(arg)) {
                return true;
            }
            if (nanosTimeout <= 0) {
                return false;
            }
            int stat = acquire(null, arg, false, true, true, System.nanoTime() + nanosTimeout);
            if (stat > 0) {
                return true;
            }
            if (stat == 0) {
                return false;
            }
        }
        throw new InterruptedException();
    }

    public final boolean release(int arg) {
        if (tryRelease(arg)) {
            signalNext(this.head);
            return true;
        }
        return false;
    }

    public final void acquireShared(int arg) {
        if (tryAcquireShared(arg) < 0) {
            acquire(null, arg, true, false, false, 0L);
        }
    }

    public final void acquireSharedInterruptibly(int arg) throws InterruptedException {
        if (Thread.interrupted() || (tryAcquireShared(arg) < 0 && acquire(null, arg, true, true, false, 0L) < 0)) {
            throw new InterruptedException();
        }
    }

    public final boolean tryAcquireSharedNanos(int arg, long nanosTimeout) throws InterruptedException {
        if (!Thread.interrupted()) {
            if (tryAcquireShared(arg) >= 0) {
                return true;
            }
            if (nanosTimeout <= 0) {
                return false;
            }
            int stat = acquire(null, arg, true, true, true, System.nanoTime() + nanosTimeout);
            if (stat > 0) {
                return true;
            }
            if (stat == 0) {
                return false;
            }
        }
        throw new InterruptedException();
    }

    public final boolean releaseShared(int arg) {
        if (tryReleaseShared(arg)) {
            signalNext(this.head);
            return true;
        }
        return false;
    }

    public final boolean hasQueuedThreads() {
        Node h10 = this.head;
        for (Node p10 = this.tail; p10 != h10 && p10 != null; p10 = p10.prev) {
            if (p10.status >= 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean hasContended() {
        return this.head != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
    
        if (r1.prev != null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Thread getFirstQueuedThread() {
        /*
            r7 = this;
            r0 = 0
            java.util.concurrent.locks.AbstractQueuedSynchronizer$Node r1 = r7.head
            r2 = r1
            if (r1 == 0) goto L25
            java.util.concurrent.locks.AbstractQueuedSynchronizer$Node r1 = r2.next
            r3 = r1
            if (r1 == 0) goto L14
            java.lang.Thread r1 = r3.waiter
            r0 = r1
            if (r1 == 0) goto L14
            java.util.concurrent.locks.AbstractQueuedSynchronizer$Node r1 = r3.prev
            if (r1 != 0) goto L25
        L14:
            java.util.concurrent.locks.AbstractQueuedSynchronizer$Node r1 = r7.tail
        L16:
            if (r1 == 0) goto L25
            java.util.concurrent.locks.AbstractQueuedSynchronizer$Node r4 = r1.prev
            r5 = r4
            if (r4 == 0) goto L25
            java.lang.Thread r4 = r1.waiter
            r6 = r4
            if (r4 == 0) goto L23
            r0 = r6
        L23:
            r1 = r5
            goto L16
        L25:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.locks.AbstractQueuedSynchronizer.getFirstQueuedThread():java.lang.Thread");
    }

    public final boolean isQueued(Thread thread) {
        if (thread == null) {
            throw new NullPointerException();
        }
        for (Node p10 = this.tail; p10 != null; p10 = p10.prev) {
            if (p10.waiter == thread) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean apparentlyFirstQueuedIsExclusive() {
        Node s2;
        Node h10 = this.head;
        return (h10 == null || (s2 = h10.next) == null || (s2 instanceof SharedNode) || s2.waiter == null) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
    
        if (r1.prev != null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean hasQueuedPredecessors() {
        /*
            r4 = this;
            r0 = 0
            java.util.concurrent.locks.AbstractQueuedSynchronizer$Node r1 = r4.head
            r2 = r1
            if (r1 == 0) goto L18
            java.util.concurrent.locks.AbstractQueuedSynchronizer$Node r1 = r2.next
            r3 = r1
            if (r1 == 0) goto L14
            java.lang.Thread r1 = r3.waiter
            r0 = r1
            if (r1 == 0) goto L14
            java.util.concurrent.locks.AbstractQueuedSynchronizer$Node r1 = r3.prev
            if (r1 != 0) goto L18
        L14:
            java.lang.Thread r0 = r4.getFirstQueuedThread()
        L18:
            if (r0 == 0) goto L22
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            if (r0 == r1) goto L22
            r1 = 1
            goto L23
        L22:
            r1 = 0
        L23:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.locks.AbstractQueuedSynchronizer.hasQueuedPredecessors():boolean");
    }

    public final int getQueueLength() {
        int n10 = 0;
        for (Node p10 = this.tail; p10 != null; p10 = p10.prev) {
            if (p10.waiter != null) {
                n10++;
            }
        }
        return n10;
    }

    public final Collection<Thread> getQueuedThreads() {
        ArrayList<Thread> list = new ArrayList<>();
        for (Node p10 = this.tail; p10 != null; p10 = p10.prev) {
            Thread t2 = p10.waiter;
            if (t2 != null) {
                list.add(t2);
            }
        }
        return list;
    }

    public final Collection<Thread> getExclusiveQueuedThreads() {
        Thread t2;
        ArrayList<Thread> list = new ArrayList<>();
        for (Node p10 = this.tail; p10 != null; p10 = p10.prev) {
            if (!(p10 instanceof SharedNode) && (t2 = p10.waiter) != null) {
                list.add(t2);
            }
        }
        return list;
    }

    public final Collection<Thread> getSharedQueuedThreads() {
        Thread t2;
        ArrayList<Thread> list = new ArrayList<>();
        for (Node p10 = this.tail; p10 != null; p10 = p10.prev) {
            if ((p10 instanceof SharedNode) && (t2 = p10.waiter) != null) {
                list.add(t2);
            }
        }
        return list;
    }

    public String toString() {
        return super.toString() + "[State = " + getState() + ", " + (hasQueuedThreads() ? "non" : "") + "empty queue]";
    }

    public final boolean owns(ConditionObject condition) {
        return condition.isOwnedBy(this);
    }

    public final boolean hasWaiters(ConditionObject condition) {
        if (!owns(condition)) {
            throw new IllegalArgumentException("Not owner");
        }
        return condition.hasWaiters();
    }

    public final int getWaitQueueLength(ConditionObject condition) {
        if (!owns(condition)) {
            throw new IllegalArgumentException("Not owner");
        }
        return condition.getWaitQueueLength();
    }

    public final Collection<Thread> getWaitingThreads(ConditionObject condition) {
        if (!owns(condition)) {
            throw new IllegalArgumentException("Not owner");
        }
        return condition.getWaitingThreads();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class ConditionObject implements Condition, Serializable {
        private static final long serialVersionUID = 1173984872572414699L;
        private transient ConditionNode firstWaiter;
        private transient ConditionNode lastWaiter;

        public ConditionObject() {
        }

        private void doSignal(ConditionNode first, boolean all) {
            while (first != null) {
                ConditionNode next = first.nextWaiter;
                this.firstWaiter = next;
                if (next == null) {
                    this.lastWaiter = null;
                }
                if ((2 & first.getAndUnsetStatus(2)) != 0) {
                    AbstractQueuedSynchronizer.this.enqueue(first);
                    if (!all) {
                        return;
                    }
                }
                first = next;
            }
        }

        @Override // java.util.concurrent.locks.Condition
        public final void signal() {
            ConditionNode first = this.firstWaiter;
            if (!AbstractQueuedSynchronizer.this.isHeldExclusively()) {
                throw new IllegalMonitorStateException();
            }
            if (first != null) {
                doSignal(first, false);
            }
        }

        @Override // java.util.concurrent.locks.Condition
        public final void signalAll() {
            ConditionNode first = this.firstWaiter;
            if (!AbstractQueuedSynchronizer.this.isHeldExclusively()) {
                throw new IllegalMonitorStateException();
            }
            if (first != null) {
                doSignal(first, true);
            }
        }

        private int enableWait(ConditionNode node) {
            if (AbstractQueuedSynchronizer.this.isHeldExclusively()) {
                node.waiter = Thread.currentThread();
                node.setStatusRelaxed(3);
                ConditionNode last = this.lastWaiter;
                if (last == null) {
                    this.firstWaiter = node;
                } else {
                    last.nextWaiter = node;
                }
                this.lastWaiter = node;
                int savedState = AbstractQueuedSynchronizer.this.getState();
                if (AbstractQueuedSynchronizer.this.release(savedState)) {
                    return savedState;
                }
            }
            node.status = Integer.MIN_VALUE;
            throw new IllegalMonitorStateException();
        }

        private boolean canReacquire(ConditionNode node) {
            return (node == null || node.prev == null || !AbstractQueuedSynchronizer.this.isEnqueued(node)) ? false : true;
        }

        private void unlinkCancelledWaiters(ConditionNode node) {
            if (node == null || node.nextWaiter != null || node == this.lastWaiter) {
                ConditionNode w3 = this.firstWaiter;
                ConditionNode trail = null;
                while (w3 != null) {
                    ConditionNode next = w3.nextWaiter;
                    if ((w3.status & 2) == 0) {
                        w3.nextWaiter = null;
                        if (trail == null) {
                            this.firstWaiter = next;
                        } else {
                            trail.nextWaiter = next;
                        }
                        if (next == null) {
                            this.lastWaiter = trail;
                        }
                    } else {
                        trail = w3;
                    }
                    w3 = next;
                }
            }
        }

        /* JADX WARN: Incorrect condition in loop: B:3:0x0014 */
        @Override // java.util.concurrent.locks.Condition
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void awaitUninterruptibly() {
            /*
                r12 = this;
                java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionNode r0 = new java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionNode
                r0.<init>()
                int r9 = r12.enableWait(r0)
                java.util.concurrent.locks.LockSupport.setCurrentBlocker(r12)
                r1 = 0
                r2 = 0
                r10 = r1
                r11 = r2
            L10:
                boolean r1 = r12.canReacquire(r0)
                if (r1 != 0) goto L38
                boolean r1 = java.lang.Thread.interrupted()
                if (r1 == 0) goto L1e
                r10 = 1
                goto L10
            L1e:
                int r1 = r0.status
                r1 = r1 & 2
                if (r1 == 0) goto L34
                if (r11 == 0) goto L2a
                r0.block()     // Catch: java.lang.InterruptedException -> L2e java.util.concurrent.RejectedExecutionException -> L31
                goto L33
            L2a:
                java.util.concurrent.ForkJoinPool.managedBlock(r0)     // Catch: java.lang.InterruptedException -> L2e java.util.concurrent.RejectedExecutionException -> L31
                goto L33
            L2e:
                r1 = move-exception
                r10 = 1
                goto L33
            L31:
                r1 = move-exception
                r11 = 1
            L33:
                goto L10
            L34:
                java.lang.Thread.onSpinWait()
                goto L10
            L38:
                r1 = 0
                java.util.concurrent.locks.LockSupport.setCurrentBlocker(r1)
                r0.clearStatus()
                java.util.concurrent.locks.AbstractQueuedSynchronizer r1 = java.util.concurrent.locks.AbstractQueuedSynchronizer.this
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r2 = r0
                r3 = r9
                r1.acquire(r2, r3, r4, r5, r6, r7)
                if (r10 == 0) goto L54
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                r1.interrupt()
            L54:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.locks.AbstractQueuedSynchronizer.ConditionObject.awaitUninterruptibly():void");
        }

        @Override // java.util.concurrent.locks.Condition
        public final void await() throws InterruptedException {
            boolean interrupted;
            boolean cancelled;
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            ConditionNode node = new ConditionNode();
            int savedState = enableWait(node);
            LockSupport.setCurrentBlocker(this);
            boolean interrupted2 = false;
            boolean cancelled2 = false;
            boolean rejected = false;
            while (true) {
                if (canReacquire(node)) {
                    interrupted = interrupted2;
                    cancelled = cancelled2;
                    break;
                }
                boolean interrupted3 = Thread.interrupted() | interrupted2;
                interrupted2 = interrupted3;
                if (interrupted3) {
                    boolean z10 = (node.getAndUnsetStatus(2) & 2) != 0;
                    cancelled2 = z10;
                    if (z10) {
                        interrupted = interrupted2;
                        cancelled = cancelled2;
                        break;
                    }
                } else if ((node.status & 2) != 0) {
                    if (rejected) {
                        try {
                            node.block();
                        } catch (InterruptedException e2) {
                            interrupted2 = true;
                        } catch (RejectedExecutionException e10) {
                            rejected = true;
                        }
                    } else {
                        ForkJoinPool.managedBlock(node);
                    }
                } else {
                    Thread.onSpinWait();
                }
            }
            LockSupport.setCurrentBlocker(null);
            node.clearStatus();
            AbstractQueuedSynchronizer.this.acquire(node, savedState, false, false, false, 0L);
            if (interrupted) {
                if (cancelled) {
                    unlinkCancelledWaiters(node);
                    throw new InterruptedException();
                }
                Thread.currentThread().interrupt();
            }
        }

        @Override // java.util.concurrent.locks.Condition
        public final long awaitNanos(long nanosTimeout) throws InterruptedException {
            boolean cancelled;
            boolean interrupted;
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            ConditionNode node = new ConditionNode();
            int savedState = enableWait(node);
            long nanos = nanosTimeout < 0 ? 0L : nanosTimeout;
            long deadline = System.nanoTime() + nanos;
            boolean cancelled2 = false;
            boolean interrupted2 = false;
            while (true) {
                if (canReacquire(node)) {
                    cancelled = cancelled2;
                    interrupted = interrupted2;
                    break;
                }
                boolean interrupted3 = Thread.interrupted() | interrupted2;
                interrupted2 = interrupted3;
                if (!interrupted3) {
                    long nanoTime = deadline - System.nanoTime();
                    nanos = nanoTime;
                    if (nanoTime > 0) {
                        LockSupport.parkNanos(this, nanos);
                    }
                }
                boolean z10 = (2 & node.getAndUnsetStatus(2)) != 0;
                cancelled2 = z10;
                if (z10) {
                    cancelled = cancelled2;
                    interrupted = interrupted2;
                    break;
                }
            }
            node.clearStatus();
            AbstractQueuedSynchronizer.this.acquire(node, savedState, false, false, false, 0L);
            if (cancelled) {
                unlinkCancelledWaiters(node);
                if (interrupted) {
                    throw new InterruptedException();
                }
            } else if (interrupted) {
                Thread.currentThread().interrupt();
            }
            long remaining = deadline - System.nanoTime();
            if (remaining <= nanosTimeout) {
                return remaining;
            }
            return Long.MIN_VALUE;
        }

        @Override // java.util.concurrent.locks.Condition
        public final boolean awaitUntil(Date deadline) throws InterruptedException {
            boolean cancelled;
            boolean interrupted;
            long abstime = deadline.getTime();
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            ConditionNode node = new ConditionNode();
            int savedState = enableWait(node);
            boolean cancelled2 = false;
            boolean interrupted2 = false;
            while (true) {
                if (canReacquire(node)) {
                    cancelled = cancelled2;
                    interrupted = interrupted2;
                    break;
                }
                boolean interrupted3 = Thread.interrupted() | interrupted2;
                interrupted2 = interrupted3;
                if (interrupted3 || System.currentTimeMillis() >= abstime) {
                    boolean z10 = (2 & node.getAndUnsetStatus(2)) != 0;
                    cancelled2 = z10;
                    if (z10) {
                        cancelled = cancelled2;
                        interrupted = interrupted2;
                        break;
                    }
                } else {
                    LockSupport.parkUntil(this, abstime);
                }
            }
            node.clearStatus();
            AbstractQueuedSynchronizer.this.acquire(node, savedState, false, false, false, 0L);
            if (cancelled) {
                unlinkCancelledWaiters(node);
                if (interrupted) {
                    throw new InterruptedException();
                }
            } else if (interrupted) {
                Thread.currentThread().interrupt();
            }
            return !cancelled;
        }

        @Override // java.util.concurrent.locks.Condition
        public final boolean await(long time, TimeUnit unit) throws InterruptedException {
            boolean cancelled;
            boolean interrupted;
            long nanosTimeout = unit.toNanos(time);
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            ConditionNode node = new ConditionNode();
            int savedState = enableWait(node);
            long nanos = nanosTimeout < 0 ? 0L : nanosTimeout;
            long deadline = System.nanoTime() + nanos;
            boolean cancelled2 = false;
            boolean interrupted2 = false;
            while (true) {
                if (canReacquire(node)) {
                    cancelled = cancelled2;
                    interrupted = interrupted2;
                    break;
                }
                boolean interrupted3 = Thread.interrupted() | interrupted2;
                interrupted2 = interrupted3;
                if (!interrupted3) {
                    long nanoTime = deadline - System.nanoTime();
                    nanos = nanoTime;
                    if (nanoTime > 0) {
                        LockSupport.parkNanos(this, nanos);
                    }
                }
                boolean z10 = (2 & node.getAndUnsetStatus(2)) != 0;
                cancelled2 = z10;
                if (z10) {
                    cancelled = cancelled2;
                    interrupted = interrupted2;
                    break;
                }
            }
            node.clearStatus();
            AbstractQueuedSynchronizer.this.acquire(node, savedState, false, false, false, 0L);
            if (cancelled) {
                unlinkCancelledWaiters(node);
                if (interrupted) {
                    throw new InterruptedException();
                }
            } else if (interrupted) {
                Thread.currentThread().interrupt();
            }
            return !cancelled;
        }

        final boolean isOwnedBy(AbstractQueuedSynchronizer sync) {
            return sync == AbstractQueuedSynchronizer.this;
        }

        protected final boolean hasWaiters() {
            if (!AbstractQueuedSynchronizer.this.isHeldExclusively()) {
                throw new IllegalMonitorStateException();
            }
            for (ConditionNode w3 = this.firstWaiter; w3 != null; w3 = w3.nextWaiter) {
                if ((w3.status & 2) != 0) {
                    return true;
                }
            }
            return false;
        }

        protected final int getWaitQueueLength() {
            if (!AbstractQueuedSynchronizer.this.isHeldExclusively()) {
                throw new IllegalMonitorStateException();
            }
            int n10 = 0;
            for (ConditionNode w3 = this.firstWaiter; w3 != null; w3 = w3.nextWaiter) {
                if ((w3.status & 2) != 0) {
                    n10++;
                }
            }
            return n10;
        }

        protected final Collection<Thread> getWaitingThreads() {
            Thread t2;
            if (!AbstractQueuedSynchronizer.this.isHeldExclusively()) {
                throw new IllegalMonitorStateException();
            }
            ArrayList<Thread> list = new ArrayList<>();
            for (ConditionNode w3 = this.firstWaiter; w3 != null; w3 = w3.nextWaiter) {
                if ((w3.status & 2) != 0 && (t2 = w3.waiter) != null) {
                    list.add(t2);
                }
            }
            return list;
        }
    }

    static {
        Unsafe unsafe = Unsafe.getUnsafe();
        U = unsafe;
        STATE = unsafe.objectFieldOffset(AbstractQueuedSynchronizer.class, "state");
        HEAD = unsafe.objectFieldOffset(AbstractQueuedSynchronizer.class, "head");
        TAIL = unsafe.objectFieldOffset(AbstractQueuedSynchronizer.class, "tail");
    }
}
