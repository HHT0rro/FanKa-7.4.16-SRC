package java.util.concurrent;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Phaser {
    private static final long COUNTS_MASK = 4294967295L;
    private static final int EMPTY = 1;
    private static final int MAX_PARTIES = 65535;
    private static final int MAX_PHASE = Integer.MAX_VALUE;
    private static final int NCPU;
    private static final int ONE_ARRIVAL = 1;
    private static final int ONE_DEREGISTER = 65537;
    private static final int ONE_PARTY = 65536;
    private static final long PARTIES_MASK = 4294901760L;
    private static final int PARTIES_SHIFT = 16;
    private static final int PHASE_SHIFT = 32;
    static final int SPINS_PER_ARRIVAL;
    private static final VarHandle STATE;
    private static final long TERMINATION_BIT = Long.MIN_VALUE;
    private static final int UNARRIVED_MASK = 65535;
    private final AtomicReference<QNode> evenQ;
    private final AtomicReference<QNode> oddQ;
    private final Phaser parent;
    private final Phaser root;
    private volatile long state;

    private static int unarrivedOf(long s2) {
        int counts = (int) s2;
        if (counts == 1) {
            return 0;
        }
        return 65535 & counts;
    }

    private static int partiesOf(long s2) {
        return ((int) s2) >>> 16;
    }

    private static int phaseOf(long s2) {
        return (int) (s2 >>> 32);
    }

    private static int arrivedOf(long s2) {
        int counts = (int) s2;
        if (counts == 1) {
            return 0;
        }
        return (counts >>> 16) - (65535 & counts);
    }

    private String badArrive(long s2) {
        return "Attempted arrival of unregistered party for " + stateToString(s2);
    }

    private String badRegister(long s2) {
        return "Attempt to register more than 65535 parties for " + stateToString(s2);
    }

    private int doArrive(int adjust) {
        long s2;
        int phase;
        int unarrived;
        VarHandle varHandle;
        long s10;
        long n10;
        Phaser root = this.root;
        do {
            s2 = root == this ? this.state : reconcileState();
            phase = (int) (s2 >>> 32);
            if (phase < 0) {
                return phase;
            }
            int counts = (int) s2;
            unarrived = counts == 1 ? 0 : 65535 & counts;
            if (unarrived <= 0) {
                throw new IllegalStateException(badArrive(s2));
            }
            varHandle = STATE;
            s10 = s2 - adjust;
        } while (!(boolean) varHandle.compareAndSet(this, s2, s10));
        if (unarrived == 1) {
            long n11 = s10 & PARTIES_MASK;
            int nextUnarrived = ((int) n11) >>> 16;
            if (root == this) {
                if (onAdvance(phase, nextUnarrived)) {
                    n10 = Long.MIN_VALUE | n11;
                } else if (nextUnarrived == 0) {
                    n10 = 1 | n11;
                } else {
                    n10 = nextUnarrived | n11;
                }
                int nextPhase = (phase + 1) & Integer.MAX_VALUE;
                (boolean) varHandle.compareAndSet(this, s10, n10 | (nextPhase << 32));
                releaseWaiters(phase);
                return phase;
            }
            if (nextUnarrived != 0) {
                return this.parent.doArrive(1);
            }
            int phase2 = this.parent.doArrive(ONE_DEREGISTER);
            (boolean) varHandle.compareAndSet(this, s10, s10 | 1);
            return phase2;
        }
        return phase;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:?, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007a, code lost:
    
        r1 = r11.doRegister(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007f, code lost:
    
        if (r1 >= 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:?, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0083, code lost:
    
        r8 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0092, code lost:
    
        if ((boolean) java.util.concurrent.Phaser.STATE.weakCompareAndSet(r19, r12, (r8 << 32) | r9) != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0094, code lost:
    
        r12 = r19.state;
        r8 = (int) (r19.root.state >>> 32);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a0, code lost:
    
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int doRegister(int r20) {
        /*
            Method dump skipped, instructions count: 182
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.Phaser.doRegister(int):int");
    }

    private long reconcileState() {
        long j10;
        Phaser root = this.root;
        long s2 = this.state;
        if (root == this) {
            return s2;
        }
        long s10 = s2;
        while (true) {
            int phase = (int) (root.state >>> 32);
            if (phase == ((int) (s10 >>> 32))) {
                return s10;
            }
            VarHandle varHandle = STATE;
            long j11 = phase << 32;
            if (phase < 0) {
                j10 = 4294967295L & s10;
            } else {
                int p10 = ((int) s10) >>> 16;
                j10 = p10 == 0 ? 1L : (PARTIES_MASK & s10) | p10;
            }
            long s11 = j10 | j11;
            if ((boolean) varHandle.weakCompareAndSet(this, s10, s11)) {
                return s11;
            }
            s10 = this.state;
        }
    }

    public Phaser() {
        this(null, 0);
    }

    public Phaser(int parties) {
        this(null, parties);
    }

    public Phaser(Phaser parent) {
        this(parent, 0);
    }

    public Phaser(Phaser parent, int parties) {
        if ((parties >>> 16) != 0) {
            throw new IllegalArgumentException("Illegal number of parties");
        }
        int phase = 0;
        this.parent = parent;
        if (parent != null) {
            Phaser root = parent.root;
            this.root = root;
            this.evenQ = root.evenQ;
            this.oddQ = root.oddQ;
            if (parties != 0) {
                phase = parent.doRegister(1);
            }
        } else {
            this.root = this;
            this.evenQ = new AtomicReference<>();
            this.oddQ = new AtomicReference<>();
        }
        this.state = parties == 0 ? 1L : (phase << 32) | (parties << 16) | parties;
    }

    public int register() {
        return doRegister(1);
    }

    public int bulkRegister(int parties) {
        if (parties < 0) {
            throw new IllegalArgumentException();
        }
        if (parties == 0) {
            return getPhase();
        }
        return doRegister(parties);
    }

    public int arrive() {
        return doArrive(1);
    }

    public int arriveAndDeregister() {
        return doArrive(ONE_DEREGISTER);
    }

    public int arriveAndAwaitAdvance() {
        long s2;
        int phase;
        int unarrived;
        VarHandle varHandle;
        long s10;
        long n10;
        Phaser root = this.root;
        do {
            s2 = root == this ? this.state : reconcileState();
            phase = (int) (s2 >>> 32);
            if (phase < 0) {
                return phase;
            }
            int counts = (int) s2;
            unarrived = counts == 1 ? 0 : 65535 & counts;
            if (unarrived <= 0) {
                throw new IllegalStateException(badArrive(s2));
            }
            varHandle = STATE;
            s10 = s2 - 1;
        } while (!(boolean) varHandle.compareAndSet(this, s2, s10));
        if (unarrived > 1) {
            return root.internalAwaitAdvance(phase, null);
        }
        if (root != this) {
            return this.parent.arriveAndAwaitAdvance();
        }
        long n11 = s10 & PARTIES_MASK;
        int nextUnarrived = ((int) n11) >>> 16;
        if (onAdvance(phase, nextUnarrived)) {
            n10 = n11 | Long.MIN_VALUE;
        } else if (nextUnarrived == 0) {
            n10 = n11 | 1;
        } else {
            n10 = n11 | nextUnarrived;
        }
        int nextPhase = (phase + 1) & Integer.MAX_VALUE;
        if (!(boolean) varHandle.compareAndSet(this, s10, n10 | (nextPhase << 32))) {
            return (int) (this.state >>> 32);
        }
        releaseWaiters(phase);
        return nextPhase;
    }

    public int awaitAdvance(int phase) {
        Phaser root = this.root;
        long s2 = root == this ? this.state : reconcileState();
        int p10 = (int) (s2 >>> 32);
        if (phase < 0) {
            return phase;
        }
        if (p10 == phase) {
            return root.internalAwaitAdvance(phase, null);
        }
        return p10;
    }

    public int awaitAdvanceInterruptibly(int phase) throws InterruptedException {
        Phaser root = this.root;
        long s2 = root == this ? this.state : reconcileState();
        int p10 = (int) (s2 >>> 32);
        if (phase < 0) {
            return phase;
        }
        if (p10 == phase) {
            QNode node = new QNode(this, phase, true, false, 0L);
            p10 = root.internalAwaitAdvance(phase, node);
            if (node.wasInterrupted) {
                throw new InterruptedException();
            }
        }
        return p10;
    }

    public int awaitAdvanceInterruptibly(int phase, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
        long nanos = unit.toNanos(timeout);
        Phaser root = this.root;
        long s2 = root == this ? this.state : reconcileState();
        int p10 = (int) (s2 >>> 32);
        if (phase < 0) {
            return phase;
        }
        if (p10 == phase) {
            QNode node = new QNode(this, phase, true, true, nanos);
            p10 = root.internalAwaitAdvance(phase, node);
            if (node.wasInterrupted) {
                throw new InterruptedException();
            }
            if (p10 == phase) {
                throw new TimeoutException();
            }
        }
        return p10;
    }

    public void forceTermination() {
        long s2;
        Phaser root = this.root;
        do {
            s2 = root.state;
            if (s2 < 0) {
                return;
            }
        } while (!(boolean) STATE.compareAndSet(root, s2, s2 | Long.MIN_VALUE));
        releaseWaiters(0);
        releaseWaiters(1);
    }

    public final int getPhase() {
        return (int) (this.root.state >>> 32);
    }

    public int getRegisteredParties() {
        return partiesOf(this.state);
    }

    public int getArrivedParties() {
        return arrivedOf(reconcileState());
    }

    public int getUnarrivedParties() {
        return unarrivedOf(reconcileState());
    }

    public Phaser getParent() {
        return this.parent;
    }

    public Phaser getRoot() {
        return this.root;
    }

    public boolean isTerminated() {
        return this.root.state < 0;
    }

    protected boolean onAdvance(int phase, int registeredParties) {
        return registeredParties == 0;
    }

    public String toString() {
        return stateToString(reconcileState());
    }

    private String stateToString(long s2) {
        return super.toString() + "[phase = " + phaseOf(s2) + " parties = " + partiesOf(s2) + " arrived = " + arrivedOf(s2) + "]";
    }

    private void releaseWaiters(int phase) {
        Thread t2;
        AtomicReference<QNode> head = (phase & 1) == 0 ? this.evenQ : this.oddQ;
        while (true) {
            QNode q10 = head.get();
            if (q10 != null && q10.phase != ((int) (this.root.state >>> 32))) {
                if (head.compareAndSet(q10, q10.next) && (t2 = q10.thread) != null) {
                    q10.thread = null;
                    LockSupport.unpark(t2);
                }
            } else {
                return;
            }
        }
    }

    private int abortWait(int phase) {
        int p10;
        Thread t2;
        AtomicReference<QNode> head = (phase & 1) == 0 ? this.evenQ : this.oddQ;
        while (true) {
            QNode q10 = head.get();
            p10 = (int) (this.root.state >>> 32);
            if (q10 == null || ((t2 = q10.thread) != null && q10.phase == p10)) {
                break;
            }
            if (head.compareAndSet(q10, q10.next) && t2 != null) {
                q10.thread = null;
                LockSupport.unpark(t2);
            }
        }
        return p10;
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        NCPU = availableProcessors;
        SPINS_PER_ARRIVAL = availableProcessors < 2 ? 1 : 256;
        try {
            MethodHandles.Lookup l10 = MethodHandles.lookup();
            STATE = l10.findVarHandle(Phaser.class, "state", Long.TYPE);
        } catch (ReflectiveOperationException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    private int internalAwaitAdvance(int phase, QNode node) {
        int p10;
        int lastUnarrived;
        boolean interrupted;
        releaseWaiters(phase - 1);
        int lastUnarrived2 = 0;
        int spins = SPINS_PER_ARRIVAL;
        QNode node2 = node;
        boolean queued = false;
        while (true) {
            long s2 = this.state;
            int i10 = (int) (s2 >>> 32);
            p10 = i10;
            if (i10 != phase) {
                break;
            }
            if (node2 == null) {
                int unarrived = ((int) s2) & 65535;
                if (unarrived != lastUnarrived2) {
                    lastUnarrived2 = unarrived;
                    if (unarrived < NCPU) {
                        spins += SPINS_PER_ARRIVAL;
                        lastUnarrived = lastUnarrived2;
                        interrupted = Thread.interrupted();
                        if (!interrupted || spins - 1 < 0) {
                            QNode node3 = new QNode(this, phase, false, false, 0L);
                            node3.wasInterrupted = interrupted;
                            node2 = node3;
                            spins = spins;
                        }
                        lastUnarrived2 = lastUnarrived;
                    }
                }
                lastUnarrived = lastUnarrived2;
                interrupted = Thread.interrupted();
                if (!interrupted) {
                }
                QNode node32 = new QNode(this, phase, false, false, 0L);
                node32.wasInterrupted = interrupted;
                node2 = node32;
                spins = spins;
                lastUnarrived2 = lastUnarrived;
            } else {
                if (node2.isReleasable()) {
                    break;
                }
                if (!queued) {
                    AtomicReference<QNode> head = (phase & 1) == 0 ? this.evenQ : this.oddQ;
                    QNode q10 = head.get();
                    node2.next = q10;
                    if (q10 == null || q10.phase == phase) {
                        if (((int) (this.state >>> 32)) == phase) {
                            queued = head.compareAndSet(q10, node2);
                        }
                    }
                } else {
                    try {
                        ForkJoinPool.managedBlock(node2);
                    } catch (InterruptedException e2) {
                        node2.wasInterrupted = true;
                    }
                }
            }
        }
        if (node2 != null) {
            if (node2.thread != null) {
                node2.thread = null;
            }
            if (node2.wasInterrupted && !node2.interruptible) {
                Thread.currentThread().interrupt();
            }
            if (p10 == phase) {
                int i11 = (int) (this.state >>> 32);
                p10 = i11;
                if (i11 == phase) {
                    return abortWait(phase);
                }
            }
        }
        releaseWaiters(phase);
        return p10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class QNode implements ForkJoinPool.ManagedBlocker {
        final long deadline;
        final boolean interruptible;
        long nanos;
        QNode next;
        final int phase;
        final Phaser phaser;
        volatile Thread thread;
        final boolean timed;
        boolean wasInterrupted;

        QNode(Phaser phaser, int phase, boolean interruptible, boolean timed, long nanos) {
            this.phaser = phaser;
            this.phase = phase;
            this.interruptible = interruptible;
            this.nanos = nanos;
            this.timed = timed;
            this.deadline = timed ? System.nanoTime() + nanos : 0L;
            this.thread = Thread.currentThread();
        }

        @Override // java.util.concurrent.ForkJoinPool.ManagedBlocker
        public boolean isReleasable() {
            if (this.thread == null) {
                return true;
            }
            if (this.phaser.getPhase() != this.phase) {
                this.thread = null;
                return true;
            }
            if (Thread.interrupted()) {
                this.wasInterrupted = true;
            }
            if (this.wasInterrupted && this.interruptible) {
                this.thread = null;
                return true;
            }
            if (this.timed) {
                if (this.nanos > 0) {
                    long nanoTime = this.deadline - System.nanoTime();
                    this.nanos = nanoTime;
                    if (nanoTime > 0) {
                        return false;
                    }
                }
                this.thread = null;
                return true;
            }
            return false;
        }

        @Override // java.util.concurrent.ForkJoinPool.ManagedBlocker
        public boolean block() {
            while (!isReleasable()) {
                if (this.timed) {
                    LockSupport.parkNanos(this, this.nanos);
                } else {
                    LockSupport.park(this);
                }
            }
            return true;
        }
    }
}
