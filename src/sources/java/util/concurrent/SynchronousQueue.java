package java.util.concurrent;

import com.android.ims.ImsConfig;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SynchronousQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>, Serializable {
    static final long SPIN_FOR_TIMEOUT_THRESHOLD = 1023;
    private static final long serialVersionUID = -3223113410248163686L;
    private ReentrantLock qlock;
    private volatile transient Transferer<E> transferer;
    private WaitQueue waitingConsumers;
    private WaitQueue waitingProducers;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class Transferer<E> {
        abstract E transfer(E e2, boolean z10, long j10);

        Transferer() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class TransferStack<E> extends Transferer<E> {
        static final int DATA = 1;
        static final int FULFILLING = 2;
        static final int REQUEST = 0;
        private static final VarHandle SHEAD;
        volatile SNode head;

        TransferStack() {
        }

        static boolean isFulfilling(int m10) {
            return (m10 & 2) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static final class SNode implements ForkJoinPool.ManagedBlocker {
            private static final VarHandle SMATCH;
            private static final VarHandle SNEXT;
            private static final VarHandle SWAITER;
            Object item;
            volatile SNode match;
            int mode;
            volatile SNode next;
            volatile Thread waiter;

            SNode(Object item) {
                this.item = item;
            }

            boolean casNext(SNode cmp, SNode val) {
                return cmp == this.next && (boolean) SNEXT.compareAndSet(this, cmp, val);
            }

            boolean tryMatch(SNode s2) {
                SNode sNode = this.match;
                SNode m10 = sNode;
                if (sNode == null) {
                    if ((boolean) SMATCH.compareAndSet(this, null, s2)) {
                        Thread w3 = this.waiter;
                        if (w3 != null) {
                            LockSupport.unpark(w3);
                        }
                        return true;
                    }
                    m10 = this.match;
                }
                return m10 == s2;
            }

            boolean tryCancel() {
                return (boolean) SMATCH.compareAndSet(this, null, this);
            }

            boolean isCancelled() {
                return this.match == this;
            }

            @Override // java.util.concurrent.ForkJoinPool.ManagedBlocker
            public final boolean isReleasable() {
                return this.match != null || Thread.currentThread().isInterrupted();
            }

            @Override // java.util.concurrent.ForkJoinPool.ManagedBlocker
            public final boolean block() {
                while (!isReleasable()) {
                    LockSupport.park();
                }
                return true;
            }

            void forgetWaiter() {
                (void) SWAITER.setOpaque(this, null);
            }

            static {
                try {
                    MethodHandles.Lookup l10 = MethodHandles.lookup();
                    SMATCH = l10.findVarHandle(SNode.class, "match", SNode.class);
                    SNEXT = l10.findVarHandle(SNode.class, "next", SNode.class);
                    SWAITER = l10.findVarHandle(SNode.class, "waiter", Thread.class);
                } catch (ReflectiveOperationException e2) {
                    throw new ExceptionInInitializerError(e2);
                }
            }
        }

        boolean casHead(SNode h10, SNode nh) {
            return h10 == this.head && (boolean) SHEAD.compareAndSet(this, h10, nh);
        }

        static SNode snode(SNode s2, Object e2, SNode next, int mode) {
            if (s2 == null) {
                s2 = new SNode(e2);
            }
            s2.mode = mode;
            s2.next = next;
            return s2;
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x00c8 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00a8 A[SYNTHETIC] */
        @Override // java.util.concurrent.SynchronousQueue.Transferer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        E transfer(E r20, boolean r21, long r22) {
            /*
                Method dump skipped, instructions count: 286
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.SynchronousQueue.TransferStack.transfer(java.lang.Object, boolean, long):java.lang.Object");
        }

        void clean(SNode s2) {
            SNode p10;
            s2.item = null;
            s2.forgetWaiter();
            SNode past = s2.next;
            if (past != null && past.isCancelled()) {
                past = past.next;
            }
            while (true) {
                SNode sNode = this.head;
                p10 = sNode;
                if (sNode == null || p10 == past || !p10.isCancelled()) {
                    break;
                } else {
                    casHead(p10, p10.next);
                }
            }
            while (p10 != null && p10 != past) {
                SNode n10 = p10.next;
                if (n10 != null && n10.isCancelled()) {
                    p10.casNext(n10, n10.next);
                } else {
                    p10 = n10;
                }
            }
        }

        static {
            try {
                MethodHandles.Lookup l10 = MethodHandles.lookup();
                SHEAD = l10.findVarHandle(TransferStack.class, "head", SNode.class);
            } catch (ReflectiveOperationException e2) {
                throw new ExceptionInInitializerError(e2);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class TransferQueue<E> extends Transferer<E> {
        private static final VarHandle QCLEANME;
        private static final VarHandle QHEAD;
        private static final VarHandle QTAIL;
        volatile transient QNode cleanMe;
        volatile transient QNode head;
        volatile transient QNode tail;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static final class QNode implements ForkJoinPool.ManagedBlocker {
            private static final VarHandle QITEM;
            private static final VarHandle QNEXT;
            private static final VarHandle QWAITER;
            final boolean isData;
            volatile Object item;
            volatile QNode next;
            volatile Thread waiter;

            QNode(Object item, boolean isData) {
                this.item = item;
                this.isData = isData;
            }

            boolean casNext(QNode cmp, QNode val) {
                return this.next == cmp && (boolean) QNEXT.compareAndSet(this, cmp, val);
            }

            boolean casItem(Object cmp, Object val) {
                return this.item == cmp && (boolean) QITEM.compareAndSet(this, cmp, val);
            }

            boolean tryCancel(Object cmp) {
                return (boolean) QITEM.compareAndSet(this, cmp, this);
            }

            boolean isCancelled() {
                return this.item == this;
            }

            boolean isOffList() {
                return this.next == this;
            }

            void forgetWaiter() {
                (void) QWAITER.setOpaque(this, null);
            }

            boolean isFulfilled() {
                boolean z10 = this.isData;
                Object x10 = this.item;
                return z10 == (x10 == null) || x10 == this;
            }

            @Override // java.util.concurrent.ForkJoinPool.ManagedBlocker
            public final boolean isReleasable() {
                boolean z10 = this.isData;
                Object x10 = this.item;
                return z10 == (x10 == null) || x10 == this || Thread.currentThread().isInterrupted();
            }

            @Override // java.util.concurrent.ForkJoinPool.ManagedBlocker
            public final boolean block() {
                while (!isReleasable()) {
                    LockSupport.park();
                }
                return true;
            }

            static {
                try {
                    MethodHandles.Lookup l10 = MethodHandles.lookup();
                    QITEM = l10.findVarHandle(QNode.class, ImsConfig.EXTRA_CHANGED_ITEM, Object.class);
                    QNEXT = l10.findVarHandle(QNode.class, "next", QNode.class);
                    QWAITER = l10.findVarHandle(QNode.class, "waiter", Thread.class);
                } catch (ReflectiveOperationException e2) {
                    throw new ExceptionInInitializerError(e2);
                }
            }
        }

        TransferQueue() {
            QNode h10 = new QNode(null, false);
            this.head = h10;
            this.tail = h10;
        }

        void advanceHead(QNode h10, QNode nh) {
            if (h10 == this.head && (boolean) QHEAD.compareAndSet(this, h10, nh)) {
                h10.next = h10;
            }
        }

        void advanceTail(QNode t2, QNode nt) {
            if (this.tail == t2) {
                (boolean) QTAIL.compareAndSet(this, t2, nt);
            }
        }

        boolean casCleanMe(QNode cmp, QNode val) {
            return this.cleanMe == cmp && (boolean) QCLEANME.compareAndSet(this, cmp, val);
        }

        /* JADX WARN: Code restructure failed: missing block: B:100:0x0119, code lost:
        
            r12.item = r12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:101:0x011b, code lost:
        
            if (r17 == null) goto L109;
         */
        /* JADX WARN: Code restructure failed: missing block: B:103:?, code lost:
        
            return (E) r17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:105:0x0121, code lost:
        
            return r22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x0109, code lost:
        
            if (r4 != 1) goto L102;
         */
        /* JADX WARN: Code restructure failed: missing block: B:95:0x010b, code lost:
        
            r12.forgetWaiter();
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x0112, code lost:
        
            if (r12.isOffList() != false) goto L107;
         */
        /* JADX WARN: Code restructure failed: missing block: B:98:0x0114, code lost:
        
            advanceHead(r6, r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:99:0x0117, code lost:
        
            if (r17 == null) goto L107;
         */
        /* JADX WARN: Removed duplicated region for block: B:54:0x00c4  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x00c0 A[SYNTHETIC] */
        @Override // java.util.concurrent.SynchronousQueue.Transferer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        E transfer(E r22, boolean r23, long r24) {
            /*
                Method dump skipped, instructions count: 296
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.SynchronousQueue.TransferQueue.transfer(java.lang.Object, boolean, long):java.lang.Object");
        }

        void clean(QNode pred, QNode s2) {
            QNode dn;
            QNode sn;
            s2.forgetWaiter();
            while (pred.next == s2) {
                QNode h10 = this.head;
                QNode hn = h10.next;
                if (hn != null && hn.isCancelled()) {
                    advanceHead(h10, hn);
                } else {
                    QNode t2 = this.tail;
                    if (t2 == h10) {
                        return;
                    }
                    QNode tn = t2.next;
                    if (t2 != this.tail) {
                        continue;
                    } else if (tn != null) {
                        advanceTail(t2, tn);
                    } else {
                        if (s2 != t2 && ((sn = s2.next) == s2 || pred.casNext(s2, sn))) {
                            return;
                        }
                        QNode sn2 = this.cleanMe;
                        if (sn2 != null) {
                            QNode d10 = sn2.next;
                            if (d10 == null || d10 == sn2 || !d10.isCancelled() || (d10 != t2 && (dn = d10.next) != null && dn != d10 && sn2.casNext(d10, dn))) {
                                casCleanMe(sn2, null);
                            }
                            if (sn2 == pred) {
                                return;
                            }
                        } else if (casCleanMe(null, pred)) {
                            return;
                        }
                    }
                }
            }
        }

        static {
            try {
                MethodHandles.Lookup l10 = MethodHandles.lookup();
                QHEAD = l10.findVarHandle(TransferQueue.class, "head", QNode.class);
                QTAIL = l10.findVarHandle(TransferQueue.class, "tail", QNode.class);
                QCLEANME = l10.findVarHandle(TransferQueue.class, "cleanMe", QNode.class);
            } catch (ReflectiveOperationException e2) {
                throw new ExceptionInInitializerError(e2);
            }
        }
    }

    public SynchronousQueue() {
        this(false);
    }

    public SynchronousQueue(boolean fair) {
        this.transferer = fair ? new TransferQueue<>() : new TransferStack<>();
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e2) throws InterruptedException {
        if (e2 == null) {
            throw new NullPointerException();
        }
        if (this.transferer.transfer(e2, false, 0L) == null) {
            Thread.interrupted();
            throw new InterruptedException();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e2, long timeout, TimeUnit unit) throws InterruptedException {
        if (e2 == null) {
            throw new NullPointerException();
        }
        if (this.transferer.transfer(e2, true, unit.toNanos(timeout)) != null) {
            return true;
        }
        if (!Thread.interrupted()) {
            return false;
        }
        throw new InterruptedException();
    }

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e2) {
        if (e2 != null) {
            return this.transferer.transfer(e2, true, 0L) != null;
        }
        throw new NullPointerException();
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        E e2 = this.transferer.transfer(null, false, 0L);
        if (e2 != null) {
            return e2;
        }
        Thread.interrupted();
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.BlockingQueue
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        E e2 = this.transferer.transfer(null, true, unit.toNanos(timeout));
        if (e2 != null || !Thread.interrupted()) {
            return e2;
        }
        throw new InterruptedException();
    }

    @Override // java.util.Queue
    public E poll() {
        return this.transferer.transfer(null, true, 0L);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 0;
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return 0;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object o10) {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object o10) {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> c4) {
        return c4.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> c4) {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> c4) {
        return false;
    }

    @Override // java.util.Queue
    public E peek() {
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return Collections.emptyIterator();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return Spliterators.emptySpliterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return new Object[0];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] a10) {
        if (a10.length > 0) {
            a10[0] = null;
        }
        return a10;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return "[]";
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> c4) {
        Objects.requireNonNull(c4);
        if (c4 == this) {
            throw new IllegalArgumentException();
        }
        int n10 = 0;
        while (true) {
            E e2 = poll();
            if (e2 != null) {
                c4.add(e2);
                n10++;
            } else {
                return n10;
            }
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> c4, int maxElements) {
        Objects.requireNonNull(c4);
        if (c4 == this) {
            throw new IllegalArgumentException();
        }
        int n10 = 0;
        while (n10 < maxElements) {
            E e2 = poll();
            if (e2 == null) {
                break;
            }
            c4.add(e2);
            n10++;
        }
        return n10;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class WaitQueue implements Serializable {
        WaitQueue() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class LifoWaitQueue extends WaitQueue {
        private static final long serialVersionUID = -3633113410248163686L;

        LifoWaitQueue() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class FifoWaitQueue extends WaitQueue {
        private static final long serialVersionUID = -3623113410248163686L;

        FifoWaitQueue() {
        }
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        boolean fair = this.transferer instanceof TransferQueue;
        if (fair) {
            this.qlock = new ReentrantLock(true);
            this.waitingProducers = new FifoWaitQueue();
            this.waitingConsumers = new FifoWaitQueue();
        } else {
            this.qlock = new ReentrantLock();
            this.waitingProducers = new LifoWaitQueue();
            this.waitingConsumers = new LifoWaitQueue();
        }
        s2.defaultWriteObject();
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        s2.defaultReadObject();
        if (this.waitingProducers instanceof FifoWaitQueue) {
            this.transferer = new TransferQueue();
        } else {
            this.transferer = new TransferStack();
        }
    }
}
