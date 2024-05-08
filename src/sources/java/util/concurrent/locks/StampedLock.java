package java.util.concurrent.locks;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import jdk.internal.misc.Unsafe;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class StampedLock implements Serializable {
    private static final long ABITS = 255;
    static final int CANCELLED = Integer.MIN_VALUE;
    private static final long HEAD;
    private static final long INTERRUPTED = 1;
    private static final int LG_READERS = 7;
    private static final long ORIGIN = 256;
    private static final long RBITS = 127;
    private static final long RFULL = 126;
    private static final long RSAFE = -193;
    private static final long RUNIT = 1;
    private static final long SBITS = -128;
    private static final long STATE;
    private static final long TAIL;
    private static final Unsafe U;
    static final int WAITING = 1;
    private static final long WBIT = 128;
    private static final long serialVersionUID = -6001602636862214147L;
    private volatile transient Node head;
    transient ReadLockView readLockView;
    transient ReadWriteLockView readWriteLockView;
    private transient int readerOverflow;
    private volatile transient long state = 256;
    private volatile transient Node tail;
    transient WriteLockView writeLockView;

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
        private static final long STATUS = StampedLock.U.objectFieldOffset(Node.class, "status");
        private static final long NEXT = StampedLock.U.objectFieldOffset(Node.class, "next");
        private static final long PREV = StampedLock.U.objectFieldOffset(Node.class, "prev");

        Node() {
        }

        final boolean casPrev(Node c4, Node v2) {
            return StampedLock.U.weakCompareAndSetReference(this, PREV, c4, v2);
        }

        final boolean casNext(Node c4, Node v2) {
            return StampedLock.U.weakCompareAndSetReference(this, NEXT, c4, v2);
        }

        final int getAndUnsetStatus(int v2) {
            return StampedLock.U.getAndBitwiseAndInt(this, STATUS, ~v2);
        }

        final void setPrevRelaxed(Node p10) {
            StampedLock.U.putReference(this, PREV, p10);
        }

        final void setStatusRelaxed(int s2) {
            StampedLock.U.putInt(this, STATUS, s2);
        }

        final void clearStatus() {
            StampedLock.U.putIntOpaque(this, STATUS, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class WriterNode extends Node {
        WriterNode() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class ReaderNode extends Node {
        private static final long COWAITERS = StampedLock.U.objectFieldOffset(ReaderNode.class, "cowaiters");
        volatile ReaderNode cowaiters;

        ReaderNode() {
        }

        final boolean casCowaiters(ReaderNode c4, ReaderNode v2) {
            return StampedLock.U.weakCompareAndSetReference(this, COWAITERS, c4, v2);
        }

        final void setCowaitersRelaxed(ReaderNode p10) {
            StampedLock.U.putReference(this, COWAITERS, p10);
        }
    }

    private boolean casState(long expect, long update) {
        return U.compareAndSetLong(this, STATE, expect, update);
    }

    private long tryAcquireWrite() {
        long s2 = this.state;
        if ((s2 & ABITS) == 0) {
            long nextState = 128 | s2;
            if (casState(s2, nextState)) {
                U.storeStoreFence();
                return nextState;
            }
        }
        return 0L;
    }

    private long tryAcquireRead() {
        while (true) {
            long s2 = this.state;
            long m10 = s2 & ABITS;
            if (m10 < RFULL) {
                long nextState = 1 + s2;
                if (casState(s2, nextState)) {
                    return nextState;
                }
            } else {
                if (m10 == 128) {
                    return 0L;
                }
                long nextState2 = tryIncReaderOverflow(s2);
                if (nextState2 != 0) {
                    return nextState2;
                }
            }
        }
    }

    private static long unlockWriteState(long s2) {
        long s10 = 128 + s2;
        if (s10 == 0) {
            return 256L;
        }
        return s10;
    }

    private long releaseWrite(long s2) {
        long nextState = unlockWriteState(s2);
        this.state = nextState;
        signalNext(this.head);
        return nextState;
    }

    public long writeLock() {
        Unsafe unsafe = U;
        long s2 = unsafe.getLongOpaque(this, STATE) & (-256);
        long nextState = 128 | s2;
        if (casState(s2, nextState)) {
            unsafe.storeStoreFence();
            return nextState;
        }
        return acquireWrite(false, false, 0L);
    }

    public long tryWriteLock() {
        return tryAcquireWrite();
    }

    public long tryWriteLock(long time, TimeUnit unit) throws InterruptedException {
        long nanos = unit.toNanos(time);
        if (!Thread.interrupted()) {
            long nextState = tryAcquireWrite();
            if (nextState != 0) {
                return nextState;
            }
            if (nanos <= 0) {
                return 0L;
            }
            long nextState2 = acquireWrite(true, true, System.nanoTime() + nanos);
            if (nextState2 != 1) {
                return nextState2;
            }
        }
        throw new InterruptedException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001c, code lost:
    
        if (r0 != 1) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long writeLockInterruptibly() throws java.lang.InterruptedException {
        /*
            r6 = this;
            boolean r0 = java.lang.Thread.interrupted()
            if (r0 != 0) goto L1f
            long r0 = r6.tryAcquireWrite()
            r2 = r0
            r4 = 0
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 != 0) goto L1e
            r0 = 1
            r1 = 0
            long r0 = r6.acquireWrite(r0, r1, r4)
            r2 = r0
            r4 = 1
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 == 0) goto L1f
        L1e:
            return r2
        L1f:
            java.lang.InterruptedException r0 = new java.lang.InterruptedException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.locks.StampedLock.writeLockInterruptibly():long");
    }

    public long readLock() {
        long s2 = U.getLongOpaque(this, STATE) & RSAFE;
        long nextState = 1 + s2;
        return casState(s2, nextState) ? nextState : acquireRead(false, false, 0L);
    }

    public long tryReadLock() {
        return tryAcquireRead();
    }

    public long tryReadLock(long time, TimeUnit unit) throws InterruptedException {
        long nanos = unit.toNanos(time);
        if (!Thread.interrupted()) {
            if (this.tail == this.head) {
                long nextState = tryAcquireRead();
                if (nextState != 0) {
                    return nextState;
                }
            }
            if (nanos <= 0) {
                return 0L;
            }
            long nextState2 = acquireRead(true, true, System.nanoTime() + nanos);
            if (nextState2 != 1) {
                return nextState2;
            }
        }
        throw new InterruptedException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001c, code lost:
    
        if (r0 != 1) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readLockInterruptibly() throws java.lang.InterruptedException {
        /*
            r6 = this;
            boolean r0 = java.lang.Thread.interrupted()
            if (r0 != 0) goto L1f
            long r0 = r6.tryAcquireRead()
            r2 = r0
            r4 = 0
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 != 0) goto L1e
            r0 = 1
            r1 = 0
            long r0 = r6.acquireRead(r0, r1, r4)
            r2 = r0
            r4 = 1
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 == 0) goto L1f
        L1e:
            return r2
        L1f:
            java.lang.InterruptedException r0 = new java.lang.InterruptedException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.locks.StampedLock.readLockInterruptibly():long");
    }

    public long tryOptimisticRead() {
        long s2 = this.state;
        if ((s2 & 128) == 0) {
            return s2 & SBITS;
        }
        return 0L;
    }

    public boolean validate(long stamp) {
        U.loadFence();
        return (stamp & SBITS) == (SBITS & this.state);
    }

    public void unlockWrite(long stamp) {
        if (this.state != stamp || (128 & stamp) == 0) {
            throw new IllegalMonitorStateException();
        }
        releaseWrite(stamp);
    }

    public void unlockRead(long stamp) {
        if ((stamp & RBITS) != 0) {
            while (true) {
                long s2 = this.state;
                if ((s2 & SBITS) != (SBITS & stamp)) {
                    break;
                }
                long m10 = s2 & RBITS;
                if (m10 == 0) {
                    break;
                }
                if (m10 < RFULL) {
                    if (casState(s2, s2 - 1)) {
                        if (m10 == 1) {
                            signalNext(this.head);
                            return;
                        }
                        return;
                    }
                } else if (tryDecReaderOverflow(s2) != 0) {
                    return;
                }
            }
        }
        throw new IllegalMonitorStateException();
    }

    public void unlock(long stamp) {
        if ((128 & stamp) != 0) {
            unlockWrite(stamp);
        } else {
            unlockRead(stamp);
        }
    }

    public long tryConvertToWriteLock(long stamp) {
        long a10 = stamp & ABITS;
        while (true) {
            long s2 = this.state;
            if ((s2 & SBITS) != (stamp & SBITS)) {
                break;
            }
            long m10 = s2 & ABITS;
            if (m10 != 0) {
                if (m10 != 128) {
                    if (m10 != 1 || a10 == 0) {
                        break;
                    }
                    long nextState = (s2 - 1) + 128;
                    if (casState(s2, nextState)) {
                        return nextState;
                    }
                } else {
                    if (a10 != m10) {
                        break;
                    }
                    return stamp;
                }
            } else {
                if (a10 != 0) {
                    break;
                }
                long nextState2 = s2 | 128;
                if (casState(s2, nextState2)) {
                    U.storeStoreFence();
                    return nextState2;
                }
            }
        }
        return 0L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0052, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long tryConvertToReadLock(long r13) {
        /*
            r12 = this;
        L1:
            long r0 = r12.state
            r2 = r0
            r4 = -128(0xffffffffffffff80, double:NaN)
            long r0 = r0 & r4
            long r4 = r4 & r13
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            r4 = 0
            if (r0 != 0) goto L52
            r0 = 255(0xff, double:1.26E-321)
            long r6 = r13 & r0
            r8 = r6
            r10 = 128(0x80, double:6.32E-322)
            int r6 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            r10 = 1
            if (r6 < 0) goto L2d
            int r0 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r0 == 0) goto L20
            goto L52
        L20:
            long r0 = unlockWriteState(r2)
            long r0 = r0 + r10
            r12.state = r0
            java.util.concurrent.locks.StampedLock$Node r4 = r12.head
            signalNext(r4)
            return r0
        L2d:
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 != 0) goto L4b
            long r0 = r0 & r2
            r6 = 126(0x7e, double:6.23E-322)
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 >= 0) goto L41
            long r10 = r10 + r2
            r0 = r10
            boolean r4 = r12.casState(r2, r10)
            if (r4 == 0) goto L1
            return r0
        L41:
            long r0 = r12.tryIncReaderOverflow(r2)
            r6 = r0
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 == 0) goto L1
            return r6
        L4b:
            long r0 = r0 & r2
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 != 0) goto L51
            goto L52
        L51:
            return r13
        L52:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.locks.StampedLock.tryConvertToReadLock(long):long");
    }

    public long tryConvertToOptimisticRead(long stamp) {
        U.loadFence();
        while (true) {
            long s2 = this.state;
            if ((s2 & SBITS) != (stamp & SBITS)) {
                break;
            }
            long a10 = stamp & ABITS;
            if (a10 >= 128) {
                if (s2 == stamp) {
                    return releaseWrite(s2);
                }
            } else {
                if (a10 == 0) {
                    return stamp;
                }
                long m10 = ABITS & s2;
                if (m10 == 0) {
                    break;
                }
                if (m10 < RFULL) {
                    long nextState = s2 - 1;
                    if (casState(s2, nextState)) {
                        if (m10 == 1) {
                            signalNext(this.head);
                        }
                        return nextState & SBITS;
                    }
                } else {
                    long nextState2 = tryDecReaderOverflow(s2);
                    if (nextState2 != 0) {
                        return nextState2 & SBITS;
                    }
                }
            }
        }
        return 0L;
    }

    public boolean tryUnlockWrite() {
        long s2 = this.state;
        if ((s2 & 128) != 0) {
            releaseWrite(s2);
            return true;
        }
        return false;
    }

    public boolean tryUnlockRead() {
        while (true) {
            long s2 = this.state;
            long m10 = s2 & ABITS;
            if (m10 == 0 || m10 >= 128) {
                return false;
            }
            if (m10 < RFULL) {
                if (casState(s2, s2 - 1)) {
                    if (m10 == 1) {
                        signalNext(this.head);
                    }
                    return true;
                }
            } else if (tryDecReaderOverflow(s2) != 0) {
                return true;
            }
        }
    }

    private int getReadLockCount(long s2) {
        long j10 = RBITS & s2;
        long readers = j10;
        if (j10 >= RFULL) {
            readers = this.readerOverflow + RFULL;
        }
        return (int) readers;
    }

    public boolean isWriteLocked() {
        return (this.state & 128) != 0;
    }

    public boolean isReadLocked() {
        return (this.state & RBITS) != 0;
    }

    public static boolean isWriteLockStamp(long stamp) {
        return (ABITS & stamp) == 128;
    }

    public static boolean isReadLockStamp(long stamp) {
        return (RBITS & stamp) != 0;
    }

    public static boolean isLockStamp(long stamp) {
        return (ABITS & stamp) != 0;
    }

    public static boolean isOptimisticReadStamp(long stamp) {
        return (ABITS & stamp) == 0 && stamp != 0;
    }

    public int getReadLockCount() {
        return getReadLockCount(this.state);
    }

    public String toString() {
        String str;
        long s2 = this.state;
        StringBuilder append = new StringBuilder().append(super.toString());
        if ((ABITS & s2) == 0) {
            str = "[Unlocked]";
        } else {
            str = (128 & s2) != 0 ? "[Write-locked]" : "[Read-locks:" + getReadLockCount(s2) + "]";
        }
        return append.append(str).toString();
    }

    public Lock asReadLock() {
        ReadLockView v2 = this.readLockView;
        if (v2 != null) {
            return v2;
        }
        ReadLockView readLockView = new ReadLockView();
        this.readLockView = readLockView;
        return readLockView;
    }

    public Lock asWriteLock() {
        WriteLockView v2 = this.writeLockView;
        if (v2 != null) {
            return v2;
        }
        WriteLockView writeLockView = new WriteLockView();
        this.writeLockView = writeLockView;
        return writeLockView;
    }

    public ReadWriteLock asReadWriteLock() {
        ReadWriteLockView v2 = this.readWriteLockView;
        if (v2 != null) {
            return v2;
        }
        ReadWriteLockView readWriteLockView = new ReadWriteLockView();
        this.readWriteLockView = readWriteLockView;
        return readWriteLockView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public final class ReadLockView implements Lock {
        ReadLockView() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lock() {
            StampedLock.this.readLock();
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            StampedLock.this.readLockInterruptibly();
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return StampedLock.this.tryReadLock() != 0;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
            return StampedLock.this.tryReadLock(time, unit) != 0;
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
            StampedLock.this.unstampedUnlockRead();
        }

        @Override // java.util.concurrent.locks.Lock
        public Condition newCondition() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public final class WriteLockView implements Lock {
        WriteLockView() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lock() {
            StampedLock.this.writeLock();
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            StampedLock.this.writeLockInterruptibly();
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return StampedLock.this.tryWriteLock() != 0;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
            return StampedLock.this.tryWriteLock(time, unit) != 0;
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
            StampedLock.this.unstampedUnlockWrite();
        }

        @Override // java.util.concurrent.locks.Lock
        public Condition newCondition() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    final class ReadWriteLockView implements ReadWriteLock {
        ReadWriteLockView() {
        }

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock readLock() {
            return StampedLock.this.asReadLock();
        }

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock writeLock() {
            return StampedLock.this.asWriteLock();
        }
    }

    final void unstampedUnlockWrite() {
        long s2 = this.state;
        if ((s2 & 128) == 0) {
            throw new IllegalMonitorStateException();
        }
        releaseWrite(s2);
    }

    final void unstampedUnlockRead() {
        while (true) {
            long s2 = this.state;
            long m10 = s2 & RBITS;
            if (m10 <= 0) {
                throw new IllegalMonitorStateException();
            }
            if (m10 < RFULL) {
                if (casState(s2, s2 - 1)) {
                    if (m10 == 1) {
                        signalNext(this.head);
                        return;
                    }
                    return;
                }
            } else if (tryDecReaderOverflow(s2) != 0) {
                return;
            }
        }
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        s2.defaultReadObject();
        this.state = 256L;
    }

    private long tryIncReaderOverflow(long s2) {
        if ((ABITS & s2) != RFULL) {
            Thread.onSpinWait();
            return 0L;
        }
        if (casState(s2, RBITS | s2)) {
            this.readerOverflow++;
            this.state = s2;
            return s2;
        }
        return 0L;
    }

    private long tryDecReaderOverflow(long s2) {
        long nextState;
        if ((ABITS & s2) != RFULL) {
            Thread.onSpinWait();
            return 0L;
        }
        if (casState(s2, RBITS | s2)) {
            int r10 = this.readerOverflow;
            if (r10 > 0) {
                this.readerOverflow = r10 - 1;
                nextState = s2;
            } else {
                nextState = s2 - 1;
            }
            this.state = nextState;
            return nextState;
        }
        return 0L;
    }

    static final void signalNext(Node h10) {
        Node s2;
        if (h10 != null && (s2 = h10.next) != null && s2.status > 0) {
            s2.getAndUnsetStatus(1);
            LockSupport.unpark(s2.waiter);
        }
    }

    private static void signalCowaiters(ReaderNode node) {
        if (node == null) {
            return;
        }
        while (true) {
            ReaderNode c4 = node.cowaiters;
            if (c4 != null) {
                if (node.casCowaiters(c4, c4.cowaiters)) {
                    LockSupport.unpark(c4.waiter);
                }
            } else {
                return;
            }
        }
    }

    private boolean casTail(Node c4, Node v2) {
        return U.compareAndSetReference(this, TAIL, c4, v2);
    }

    private void tryInitializeHead() {
        Node h10 = new WriterNode();
        if (U.compareAndSetReference(this, HEAD, null, h10)) {
            this.tail = h10;
        }
    }

    private long acquireWrite(boolean interruptible, boolean timed, long time) {
        byte spins = 0;
        byte postSpins = 0;
        boolean interrupted = false;
        boolean first = false;
        WriterNode node = null;
        Node pred = null;
        while (true) {
            if (!first) {
                Node node2 = node == null ? null : node.prev;
                pred = node2;
                if (node2 != null) {
                    boolean z10 = this.head == pred;
                    first = z10;
                    if (!z10) {
                        if (pred.status < 0) {
                            cleanQueue();
                        } else if (pred.prev == null) {
                            Thread.onSpinWait();
                        }
                    }
                }
            }
            if (first || pred == null) {
                long s2 = this.state;
                if ((s2 & ABITS) == 0) {
                    long nextState = 128 | s2;
                    if (casState(s2, nextState)) {
                        U.storeStoreFence();
                        if (first) {
                            node.prev = null;
                            this.head = node;
                            pred.next = null;
                            node.waiter = null;
                            if (interrupted) {
                                Thread.currentThread().interrupt();
                            }
                        }
                        return nextState;
                    }
                }
            }
            if (node == null) {
                node = new WriterNode();
            } else if (pred == null) {
                Node t2 = this.tail;
                node.setPrevRelaxed(t2);
                if (t2 == null) {
                    tryInitializeHead();
                } else if (!casTail(t2, node)) {
                    node.setPrevRelaxed(null);
                } else {
                    t2.next = node;
                }
            } else if (first && spins != 0) {
                spins = (byte) (spins - 1);
                Thread.onSpinWait();
            } else if (node.status != 0) {
                byte b4 = (byte) (1 | (postSpins << 1));
                postSpins = b4;
                spins = b4;
                if (!timed) {
                    LockSupport.park(this);
                } else {
                    long nanos = time - System.nanoTime();
                    if (nanos <= 0) {
                        break;
                    }
                    LockSupport.parkNanos(this, nanos);
                }
                node.clearStatus();
                boolean interrupted2 = Thread.interrupted() | interrupted;
                interrupted = interrupted2;
                if (interrupted2 && interruptible) {
                    break;
                }
            } else {
                if (node.waiter == null) {
                    node.waiter = Thread.currentThread();
                }
                node.status = 1;
            }
        }
        return cancelAcquire(node, interrupted);
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0151, code lost:
    
        return cancelAcquire(r2, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000d, code lost:
    
        if (r7 == null) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private long acquireRead(boolean r16, boolean r17, long r18) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.locks.StampedLock.acquireRead(boolean, boolean, long):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0020 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0033 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0001 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void cleanQueue() {
        /*
            r5 = this;
        L1:
            java.util.concurrent.locks.StampedLock$Node r0 = r5.tail
            r1 = 0
        L4:
            if (r0 == 0) goto L5d
            java.util.concurrent.locks.StampedLock$Node r2 = r0.prev
            r3 = r2
            if (r2 != 0) goto Lc
            goto L5d
        Lc:
            if (r1 != 0) goto L13
            java.util.concurrent.locks.StampedLock$Node r2 = r5.tail
            if (r2 == r0) goto L1c
            goto L5c
        L13:
            java.util.concurrent.locks.StampedLock$Node r2 = r1.prev
            if (r2 != r0) goto L5c
            int r2 = r1.status
            if (r2 >= 0) goto L1c
            goto L5c
        L1c:
            int r2 = r0.status
            if (r2 >= 0) goto L3e
            if (r1 != 0) goto L29
            boolean r2 = r5.casTail(r0, r3)
            if (r2 == 0) goto L5c
            goto L2f
        L29:
            boolean r2 = r1.casPrev(r0, r3)
            if (r2 == 0) goto L5c
        L2f:
            java.util.concurrent.locks.StampedLock$Node r2 = r0.prev
            if (r2 != r3) goto L5c
            r3.casNext(r0, r1)
            java.util.concurrent.locks.StampedLock$Node r2 = r3.prev
            if (r2 != 0) goto L5c
            signalNext(r3)
            goto L5c
        L3e:
            java.util.concurrent.locks.StampedLock$Node r2 = r3.next
            r4 = r2
            if (r2 == r0) goto L58
            if (r4 == 0) goto L5c
            java.util.concurrent.locks.StampedLock$Node r2 = r0.prev
            if (r2 != r3) goto L5c
            int r2 = r0.status
            if (r2 < 0) goto L5c
            r3.casNext(r4, r0)
            java.util.concurrent.locks.StampedLock$Node r2 = r3.prev
            if (r2 != 0) goto L5c
            signalNext(r3)
            goto L5c
        L58:
            r1 = r0
            java.util.concurrent.locks.StampedLock$Node r0 = r0.prev
            goto L4
        L5c:
            goto L1
        L5d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.locks.StampedLock.cleanQueue():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0013, code lost:
    
        r0.casCowaiters(r1, r1.cowaiters);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void unlinkCowaiter(java.util.concurrent.locks.StampedLock.ReaderNode r4, java.util.concurrent.locks.StampedLock.ReaderNode r5) {
        /*
            r3 = this;
            if (r5 == 0) goto L1c
        L2:
            java.util.concurrent.locks.StampedLock$Node r0 = r5.prev
            if (r0 == 0) goto L1c
            int r0 = r5.status
            if (r0 < 0) goto L1c
            r0 = r5
        Lb:
            java.util.concurrent.locks.StampedLock$ReaderNode r1 = r0.cowaiters
            r2 = r1
            if (r1 != 0) goto L11
            return
        L11:
            if (r2 != r4) goto L1a
            java.util.concurrent.locks.StampedLock$ReaderNode r1 = r2.cowaiters
            r0.casCowaiters(r2, r1)
            goto L2
        L1a:
            r0 = r2
            goto Lb
        L1c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.locks.StampedLock.unlinkCowaiter(java.util.concurrent.locks.StampedLock$ReaderNode, java.util.concurrent.locks.StampedLock$ReaderNode):void");
    }

    private long cancelAcquire(Node node, boolean interrupted) {
        if (node != null) {
            node.waiter = null;
            node.status = Integer.MIN_VALUE;
            cleanQueue();
            if (node instanceof ReaderNode) {
                signalCowaiters((ReaderNode) node);
            }
        }
        return (interrupted || Thread.interrupted()) ? 1L : 0L;
    }

    private long cancelCowaiter(ReaderNode node, ReaderNode leader, boolean interrupted) {
        if (node != null) {
            node.waiter = null;
            node.status = Integer.MIN_VALUE;
            unlinkCowaiter(node, leader);
        }
        return (interrupted || Thread.interrupted()) ? 1L : 0L;
    }

    static {
        Unsafe unsafe = Unsafe.getUnsafe();
        U = unsafe;
        STATE = unsafe.objectFieldOffset(StampedLock.class, "state");
        HEAD = unsafe.objectFieldOffset(StampedLock.class, "head");
        TAIL = unsafe.objectFieldOffset(StampedLock.class, "tail");
    }
}
