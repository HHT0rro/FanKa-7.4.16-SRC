package java.util.concurrent;

import com.android.ims.ImsConfig;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.locks.LockSupport;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class LinkedTransferQueue<E> extends AbstractQueue<E> implements TransferQueue<E>, Serializable {
    private static final int ASYNC = 1;
    private static final VarHandle HEAD;
    static final VarHandle ITEM;
    private static final int MAX_HOPS = 8;
    static final VarHandle NEXT;
    private static final int NOW = 0;
    static final long SPIN_FOR_TIMEOUT_THRESHOLD = 1023;
    static final int SWEEP_THRESHOLD = 32;
    private static final int SYNC = 2;
    private static final VarHandle TAIL;
    private static final int TIMED = 3;
    static final VarHandle WAITER;
    private static final long serialVersionUID = -3223113410248163686L;
    volatile transient Node head;
    private volatile transient boolean needSweep;
    private volatile transient Node tail;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class Node implements ForkJoinPool.ManagedBlocker {
        private static final long serialVersionUID = -3375979862319811754L;
        final boolean isData;
        volatile Object item;
        volatile Node next;
        volatile Thread waiter;

        Node(Object item) {
            (void) LinkedTransferQueue.ITEM.set(this, item);
            this.isData = item != null;
        }

        Node() {
            this.isData = true;
        }

        final boolean casNext(Node cmp, Node val) {
            return (boolean) LinkedTransferQueue.NEXT.compareAndSet(this, cmp, val);
        }

        final boolean casItem(Object cmp, Object val) {
            return (boolean) LinkedTransferQueue.ITEM.compareAndSet(this, cmp, val);
        }

        final void selfLink() {
            (void) LinkedTransferQueue.NEXT.setRelease(this, this);
        }

        final void appendRelaxed(Node next) {
            (void) LinkedTransferQueue.NEXT.setOpaque(this, next);
        }

        final boolean isMatched() {
            return this.isData == (this.item == null);
        }

        final boolean tryMatch(Object cmp, Object val) {
            if (casItem(cmp, val)) {
                LockSupport.unpark(this.waiter);
                return true;
            }
            return false;
        }

        final boolean cannotPrecede(boolean haveData) {
            boolean d10 = this.isData;
            if (d10 != haveData) {
                return d10 != (this.item == null);
            }
            return false;
        }

        @Override // java.util.concurrent.ForkJoinPool.ManagedBlocker
        public final boolean isReleasable() {
            return this.isData == (this.item == null) || Thread.currentThread().isInterrupted();
        }

        @Override // java.util.concurrent.ForkJoinPool.ManagedBlocker
        public final boolean block() {
            while (!isReleasable()) {
                LockSupport.park();
            }
            return true;
        }
    }

    private boolean casTail(Node cmp, Node val) {
        return (boolean) TAIL.compareAndSet(this, cmp, val);
    }

    private boolean casHead(Node cmp, Node val) {
        return (boolean) HEAD.compareAndSet(this, cmp, val);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tryCasSuccessor(Node pred, Node c4, Node p10) {
        if (pred != null) {
            return pred.casNext(c4, p10);
        }
        if (casHead(c4, p10)) {
            c4.selfLink();
            return true;
        }
        return false;
    }

    private Node skipDeadNodes(Node pred, Node c4, Node p10, Node q10) {
        if (q10 == null) {
            if (c4 == p10) {
                return pred;
            }
            q10 = p10;
        }
        return (!tryCasSuccessor(pred, c4, q10) || (pred != null && pred.isMatched())) ? p10 : pred;
    }

    private void skipDeadNodesNearHead(Node h10, Node p10) {
        while (true) {
            Node q10 = p10.next;
            if (q10 == null) {
                break;
            }
            if (!q10.isMatched()) {
                p10 = q10;
                break;
            } else if (p10 == q10) {
                return;
            } else {
                p10 = q10;
            }
        }
        if (casHead(h10, p10)) {
            h10.selfLink();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x004d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private E xfer(E r17, boolean r18, int r19, long r20) {
        /*
            r16 = this;
            r7 = r16
            r8 = r17
            r9 = r18
            r10 = r19
            if (r9 == 0) goto L13
            if (r8 == 0) goto Ld
            goto L13
        Ld:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>()
            throw r0
        L13:
            r0 = 0
            r1 = 0
            r2 = 0
        L16:
            java.util.concurrent.LinkedTransferQueue$Node r3 = r7.tail
            r11 = r3
            if (r1 == r3) goto L21
            boolean r1 = r11.isData
            if (r1 != r9) goto L21
            r1 = r11
            goto L24
        L21:
            java.util.concurrent.LinkedTransferQueue$Node r1 = r7.head
            r2 = r1
        L24:
            r12 = r1
        L25:
            boolean r1 = r12.isData
            r3 = 0
            r4 = 1
            if (r1 == r9) goto L47
            java.lang.Object r1 = r12.item
            r5 = r1
            if (r1 != 0) goto L32
            r1 = r4
            goto L33
        L32:
            r1 = r3
        L33:
            if (r9 != r1) goto L47
            if (r2 != 0) goto L39
            java.util.concurrent.LinkedTransferQueue$Node r2 = r7.head
        L39:
            boolean r1 = r12.tryMatch(r5, r8)
            if (r1 == 0) goto L45
            if (r2 == r12) goto L44
            r7.skipDeadNodesNearHead(r2, r12)
        L44:
            return r5
        L45:
            r13 = r2
            goto L48
        L47:
            r13 = r2
        L48:
            java.util.concurrent.LinkedTransferQueue$Node r1 = r12.next
            r14 = r1
            if (r1 != 0) goto L7d
            if (r10 != 0) goto L50
            return r8
        L50:
            if (r0 != 0) goto L58
            java.util.concurrent.LinkedTransferQueue$Node r1 = new java.util.concurrent.LinkedTransferQueue$Node
            r1.<init>(r8)
            r0 = r1
        L58:
            r15 = r0
            r0 = 0
            boolean r0 = r12.casNext(r0, r15)
            if (r0 != 0) goto L63
            r2 = r13
            r0 = r15
            goto L25
        L63:
            if (r12 == r11) goto L68
            r7.casTail(r11, r15)
        L68:
            if (r10 != r4) goto L6b
            return r8
        L6b:
            r0 = 3
            if (r10 != r0) goto L6f
            goto L70
        L6f:
            r4 = r3
        L70:
            r0 = r16
            r1 = r15
            r2 = r12
            r3 = r17
            r5 = r20
            java.lang.Object r0 = r0.awaitMatch(r1, r2, r3, r4, r5)
            return r0
        L7d:
            r1 = r14
            if (r12 != r14) goto L83
            r1 = r11
            r2 = r13
            goto L16
        L83:
            r12 = r1
            r2 = r13
            goto L25
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.LinkedTransferQueue.xfer(java.lang.Object, boolean, int, long):java.lang.Object");
    }

    private E awaitMatch(Node node, Node node2, E e2, boolean z10, long j10) {
        E e10;
        boolean z11 = node.isData;
        long nanoTime = z10 ? System.nanoTime() + j10 : 0L;
        Thread currentThread = Thread.currentThread();
        long j11 = j10;
        int i10 = -1;
        while (true) {
            Object obj = node.item;
            e10 = (E) obj;
            if (obj != e2) {
                break;
            }
            if (this.needSweep) {
                sweep();
            } else if ((z10 && j11 <= 0) || currentThread.isInterrupted()) {
                if (node.casItem(e2, e2 == null ? node : null)) {
                    unsplice(node2, node);
                    return e2;
                }
            } else if (i10 <= 0) {
                if (node2 != null && node2.next == node) {
                    if (i10 < 0 && (node2.isData != z11 || node2.isMatched())) {
                        i10 = 0;
                        Thread.yield();
                    } else {
                        i10 = 1;
                        node.waiter = currentThread;
                    }
                }
            } else {
                Object obj2 = node.item;
                e10 = (E) obj2;
                if (obj2 != e2) {
                    break;
                }
                if (!z10) {
                    LockSupport.setCurrentBlocker(this);
                    try {
                        ForkJoinPool.managedBlock(node);
                    } catch (InterruptedException e11) {
                    }
                    LockSupport.setCurrentBlocker(null);
                } else {
                    j11 = nanoTime - System.nanoTime();
                    if (j11 > SPIN_FOR_TIMEOUT_THRESHOLD) {
                        LockSupport.parkNanos(this, j11);
                    }
                }
            }
        }
        if (i10 == 1) {
            (void) WAITER.set(node, null);
        }
        if (!z11) {
            (void) ITEM.set(node, node);
        }
        return e10;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0021 A[EDGE_INSN: B:14:0x0021->B:15:0x0021 BREAK  A[LOOP:0: B:2:0x0001->B:13:?, LOOP_LABEL: LOOP:0: B:2:0x0001->B:13:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final java.util.concurrent.LinkedTransferQueue.Node firstDataNode() {
        /*
            r5 = this;
            r0 = 0
        L1:
            java.util.concurrent.LinkedTransferQueue$Node r1 = r5.head
            r2 = r1
        L4:
            if (r2 == 0) goto L21
            java.lang.Object r3 = r2.item
            if (r3 == 0) goto L10
            boolean r3 = r2.isData
            if (r3 == 0) goto L15
            r0 = r2
            goto L21
        L10:
            boolean r3 = r2.isData
            if (r3 != 0) goto L15
            goto L21
        L15:
            java.util.concurrent.LinkedTransferQueue$Node r3 = r2.next
            r4 = r3
            if (r3 != 0) goto L1b
            goto L21
        L1b:
            r3 = r4
            if (r2 != r4) goto L1f
            goto L1
        L1f:
            r2 = r3
            goto L4
        L21:
            if (r2 == r1) goto L2c
            boolean r3 = r5.casHead(r1, r2)
            if (r3 == 0) goto L2c
            r1.selfLink()
        L2c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.LinkedTransferQueue.firstDataNode():java.util.concurrent.LinkedTransferQueue$Node");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int countOfMode(boolean r5) {
        /*
            r4 = this;
        L1:
            r0 = 0
            java.util.concurrent.LinkedTransferQueue$Node r1 = r4.head
        L4:
            if (r1 == 0) goto L22
            boolean r2 = r1.isMatched()
            if (r2 != 0) goto L1a
            boolean r2 = r1.isData
            if (r2 == r5) goto L12
            r2 = 0
            return r2
        L12:
            int r0 = r0 + 1
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r0 != r2) goto L1a
            goto L22
        L1a:
            java.util.concurrent.LinkedTransferQueue$Node r2 = r1.next
            r3 = r2
            if (r1 != r2) goto L20
            goto L1
        L20:
            r1 = r3
            goto L4
        L22:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.LinkedTransferQueue.countOfMode(boolean):int");
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        int charLength;
        int size;
        String[] a10 = null;
        loop0: while (true) {
            charLength = 0;
            size = 0;
            Node p10 = this.head;
            while (p10 != null) {
                Object item = p10.item;
                if (p10.isData) {
                    if (item != null) {
                        if (a10 == null) {
                            a10 = new String[4];
                        } else if (size == a10.length) {
                            a10 = (String[]) Arrays.copyOf(a10, size * 2);
                        }
                        String s2 = item.toString();
                        a10[size] = s2;
                        charLength += s2.length();
                        size++;
                    }
                } else if (item == null) {
                    break loop0;
                }
                Node p11 = p10.next;
                if (p10 == p11) {
                    break;
                }
                p10 = p11;
            }
        }
        if (size == 0) {
            return "[]";
        }
        return Helpers.toString(a10, size, charLength);
    }

    private Object[] toArrayInternal(Object[] a10) {
        int size;
        Object[] x10 = a10;
        loop0: while (true) {
            size = 0;
            Node p10 = this.head;
            while (p10 != null) {
                Object item = p10.item;
                if (p10.isData) {
                    if (item != null) {
                        if (x10 == null) {
                            x10 = new Object[4];
                        } else if (size == x10.length) {
                            x10 = Arrays.copyOf(x10, (size + 4) * 2);
                        }
                        x10[size] = item;
                        size++;
                    }
                } else if (item == null) {
                    break loop0;
                }
                Node p11 = p10.next;
                if (p10 == p11) {
                    break;
                }
                p10 = p11;
            }
        }
        if (x10 == null) {
            return new Object[0];
        }
        if (a10 == null || size > a10.length) {
            return size == x10.length ? x10 : Arrays.copyOf(x10, size);
        }
        if (a10 != x10) {
            System.arraycopy(x10, 0, a10, 0, size);
        }
        if (size < a10.length) {
            a10[size] = null;
        }
        return a10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return toArrayInternal(null);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        Objects.requireNonNull(tArr);
        return (T[]) toArrayInternal(tArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public final class Itr implements Iterator<E> {
        private Node ancestor;
        private Node lastRet;
        private E nextItem;
        private Node nextNode;

        private void advance(Node node) {
            Node node2 = node == null ? LinkedTransferQueue.this.head : node.next;
            Node node3 = node2;
            while (node2 != null) {
                E e2 = (E) node2.item;
                if (e2 != null && node2.isData) {
                    this.nextNode = node2;
                    this.nextItem = e2;
                    if (node3 != node2) {
                        LinkedTransferQueue.this.tryCasSuccessor(node, node3, node2);
                        return;
                    }
                    return;
                }
                if (!node2.isData && e2 == null) {
                    break;
                }
                if (node3 != node2) {
                    Node node4 = node2;
                    if (LinkedTransferQueue.this.tryCasSuccessor(node, node3, node2)) {
                        node3 = node4;
                    } else {
                        node = node2;
                        node3 = node2.next;
                        node2 = node3;
                    }
                }
                Node node5 = node2.next;
                if (node2 != node5) {
                    node2 = node5;
                } else {
                    node = null;
                    node2 = LinkedTransferQueue.this.head;
                    node3 = node2;
                }
            }
            this.nextItem = null;
            this.nextNode = null;
        }

        Itr() {
            advance(null);
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.nextNode != null;
        }

        @Override // java.util.Iterator
        public final E next() {
            Node p10 = this.nextNode;
            if (p10 == null) {
                throw new NoSuchElementException();
            }
            E e2 = this.nextItem;
            this.lastRet = p10;
            advance(p10);
            return e2;
        }

        @Override // java.util.Iterator
        public void forEachRemaining(Consumer<? super E> consumer) {
            Objects.requireNonNull(consumer);
            Node node = null;
            while (true) {
                Node node2 = this.nextNode;
                if (node2 == null) {
                    break;
                }
                consumer.accept(this.nextItem);
                node = node2;
                advance(node2);
            }
            if (node != null) {
                this.lastRet = node;
            }
        }

        @Override // java.util.Iterator
        public final void remove() {
            Node lastRet = this.lastRet;
            if (lastRet == null) {
                throw new IllegalStateException();
            }
            this.lastRet = null;
            if (lastRet.item == null) {
                return;
            }
            Node pred = this.ancestor;
            Node p10 = pred == null ? LinkedTransferQueue.this.head : pred.next;
            Node c4 = p10;
            while (p10 != null) {
                if (p10 == lastRet) {
                    Object item = p10.item;
                    if (item != null) {
                        p10.tryMatch(item, null);
                    }
                    Node node = p10.next;
                    Node q10 = node;
                    if (node == null) {
                        q10 = p10;
                    }
                    if (c4 != q10) {
                        LinkedTransferQueue.this.tryCasSuccessor(pred, c4, q10);
                    }
                    this.ancestor = pred;
                    return;
                }
                Object item2 = p10.item;
                boolean z10 = item2 != null && p10.isData;
                boolean pAlive = z10;
                if (z10 || p10.isData || item2 != null) {
                    if (c4 != p10) {
                        Node c10 = p10;
                        if (LinkedTransferQueue.this.tryCasSuccessor(pred, c4, p10)) {
                            c4 = c10;
                        } else {
                            pred = p10;
                            c4 = p10.next;
                            p10 = c4;
                        }
                    }
                    if (pAlive) {
                        pred = p10;
                        c4 = p10.next;
                        p10 = c4;
                    } else {
                        Node p11 = p10.next;
                        if (p10 != p11) {
                            p10 = p11;
                        } else {
                            pred = null;
                            p10 = LinkedTransferQueue.this.head;
                            c4 = p10;
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    final class LTQSpliterator implements Spliterator<E> {
        static final int MAX_BATCH = 33554432;
        int batch;
        Node current;
        boolean exhausted;

        LTQSpliterator() {
        }

        @Override // java.util.Spliterator
        public Spliterator<E> trySplit() {
            Node current = current();
            Node p10 = current;
            if (current != null) {
                Node node = p10.next;
                Node q10 = node;
                if (node != null) {
                    int i10 = 0;
                    int n10 = Math.min(this.batch + 1, 33554432);
                    this.batch = n10;
                    Object[] a10 = null;
                    while (true) {
                        Object item = p10.item;
                        if (p10.isData) {
                            if (item != null) {
                                if (a10 == null) {
                                    a10 = new Object[n10];
                                }
                                a10[i10] = item;
                                i10++;
                            }
                        } else if (item == null) {
                            p10 = null;
                            break;
                        }
                        Node p11 = q10;
                        if (p10 != q10) {
                            p10 = p11;
                        } else {
                            p10 = LinkedTransferQueue.this.firstDataNode();
                        }
                        if (p10 == null) {
                            break;
                        }
                        Node node2 = p10.next;
                        q10 = node2;
                        if (node2 == null || i10 >= n10) {
                            break;
                        }
                    }
                    setCurrent(p10);
                    if (i10 == 0) {
                        return null;
                    }
                    return Spliterators.spliterator(a10, 0, i10, 4368);
                }
            }
            return null;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super E> action) {
            Objects.requireNonNull(action);
            Node p10 = current();
            if (p10 != null) {
                this.current = null;
                this.exhausted = true;
                LinkedTransferQueue.this.forEachFrom(action, p10);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0026 A[EDGE_INSN: B:12:0x0026->B:13:0x0026 BREAK  A[LOOP:0: B:4:0x000b->B:19:?], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:19:? A[LOOP:0: B:4:0x000b->B:19:?, LOOP_END, SYNTHETIC] */
        @Override // java.util.Spliterator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean tryAdvance(java.util.function.Consumer<? super E> r7) {
            /*
                r6 = this;
                java.util.Objects.requireNonNull(r7)
                java.util.concurrent.LinkedTransferQueue$Node r0 = r6.current()
                r1 = r0
                if (r0 == 0) goto L30
                r0 = 0
            Lb:
                java.lang.Object r2 = r1.item
                boolean r3 = r1.isData
                java.util.concurrent.LinkedTransferQueue$Node r4 = r1.next
                r5 = r4
                if (r1 != r4) goto L18
                java.util.concurrent.LinkedTransferQueue r1 = java.util.concurrent.LinkedTransferQueue.this
                java.util.concurrent.LinkedTransferQueue$Node r5 = r1.head
            L18:
                if (r3 == 0) goto L1f
                if (r2 == 0) goto L23
                r0 = r2
                r1 = r5
                goto L26
            L1f:
                if (r2 != 0) goto L23
                r1 = 0
                goto L24
            L23:
                r1 = r5
            L24:
                if (r1 != 0) goto Lb
            L26:
                r6.setCurrent(r1)
                if (r0 == 0) goto L30
                r7.accept(r0)
                r2 = 1
                return r2
            L30:
                r0 = 0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.LinkedTransferQueue.LTQSpliterator.tryAdvance(java.util.function.Consumer):boolean");
        }

        private void setCurrent(Node p10) {
            this.current = p10;
            if (p10 == null) {
                this.exhausted = true;
            }
        }

        private Node current() {
            Node p10 = this.current;
            if (p10 != null || this.exhausted) {
                return p10;
            }
            Node p11 = LinkedTransferQueue.this.firstDataNode();
            setCurrent(p11);
            return p11;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return Long.MAX_VALUE;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 4368;
        }
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return new LTQSpliterator();
    }

    final void unsplice(Node pred, Node s2) {
        s2.waiter = null;
        if (pred != null && pred.next == s2) {
            Node n10 = s2.next;
            if (n10 != null && (n10 == s2 || !pred.casNext(s2, n10) || !pred.isMatched())) {
                return;
            }
            while (true) {
                Node h10 = this.head;
                if (h10 == pred || h10 == s2) {
                    return;
                }
                if (h10.isMatched()) {
                    Node hn = h10.next;
                    if (hn == null) {
                        return;
                    }
                    if (hn != h10 && casHead(h10, hn)) {
                        h10.selfLink();
                    }
                } else {
                    if (pred.next != pred && s2.next != s2) {
                        this.needSweep = true;
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void sweep() {
        this.needSweep = false;
        Node p10 = this.head;
        while (p10 != null) {
            Node s2 = p10.next;
            if (s2 != null) {
                if (!s2.isMatched()) {
                    p10 = s2;
                } else {
                    Node n10 = s2.next;
                    if (n10 != null) {
                        if (s2 == n10) {
                            p10 = this.head;
                        } else {
                            p10.casNext(s2, n10);
                        }
                    } else {
                        return;
                    }
                }
            } else {
                return;
            }
        }
    }

    public LinkedTransferQueue() {
        Node node = new Node();
        this.tail = node;
        this.head = node;
    }

    public LinkedTransferQueue(Collection<? extends E> c4) {
        Node h10 = null;
        Node t2 = null;
        for (E e2 : c4) {
            Node newNode = new Node(Objects.requireNonNull(e2));
            if (h10 == null) {
                t2 = newNode;
                h10 = newNode;
            } else {
                t2.appendRelaxed(newNode);
                t2 = newNode;
            }
        }
        if (h10 == null) {
            Node node = new Node();
            t2 = node;
            h10 = node;
        }
        this.head = h10;
        this.tail = t2;
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e2) {
        xfer(e2, true, 1, 0L);
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e2, long timeout, TimeUnit unit) {
        xfer(e2, true, 1, 0L);
        return true;
    }

    @Override // java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e2) {
        xfer(e2, true, 1, 0L);
        return true;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        xfer(e2, true, 1, 0L);
        return true;
    }

    @Override // java.util.concurrent.TransferQueue
    public boolean tryTransfer(E e2) {
        return xfer(e2, true, 0, 0L) == null;
    }

    @Override // java.util.concurrent.TransferQueue
    public void transfer(E e2) throws InterruptedException {
        if (xfer(e2, true, 2, 0L) != null) {
            Thread.interrupted();
            throw new InterruptedException();
        }
    }

    @Override // java.util.concurrent.TransferQueue
    public boolean tryTransfer(E e2, long timeout, TimeUnit unit) throws InterruptedException {
        if (xfer(e2, true, 3, unit.toNanos(timeout)) == null) {
            return true;
        }
        if (!Thread.interrupted()) {
            return false;
        }
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        E e2 = xfer(null, false, 2, 0L);
        if (e2 != null) {
            return e2;
        }
        Thread.interrupted();
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.BlockingQueue
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        E e2 = xfer(null, false, 3, unit.toNanos(timeout));
        if (e2 != null || !Thread.interrupted()) {
            return e2;
        }
        throw new InterruptedException();
    }

    @Override // java.util.Queue
    public E poll() {
        return xfer(null, false, 0, 0L);
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

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return new Itr();
    }

    @Override // java.util.Queue
    public E peek() {
        while (true) {
            Node node = this.head;
            while (node != null) {
                E e2 = (E) node.item;
                if (node.isData) {
                    if (e2 != null) {
                        return e2;
                    }
                } else if (e2 == null) {
                    return null;
                }
                Node node2 = node.next;
                if (node == node2) {
                    break;
                }
                node = node2;
            }
            return null;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return firstDataNode() == null;
    }

    @Override // java.util.concurrent.TransferQueue
    public boolean hasWaitingConsumer() {
        while (true) {
            Node p10 = this.head;
            while (p10 != null) {
                Object item = p10.item;
                if (p10.isData) {
                    if (item != null) {
                        return false;
                    }
                } else if (item == null) {
                    return true;
                }
                Node p11 = p10.next;
                if (p10 == p11) {
                    break;
                }
                p10 = p11;
            }
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return countOfMode(true);
    }

    @Override // java.util.concurrent.TransferQueue
    public int getWaitingConsumerCount() {
        return countOfMode(false);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object o10) {
        if (o10 == null) {
            return false;
        }
        loop0: while (true) {
            Node p10 = this.head;
            Node pred = null;
            while (p10 != null) {
                Node q10 = p10.next;
                Object item = p10.item;
                if (item != null) {
                    if (p10.isData) {
                        if (o10.equals(item) && p10.tryMatch(item, null)) {
                            skipDeadNodes(pred, p10, p10, q10);
                            return true;
                        }
                        pred = p10;
                        p10 = q10;
                    }
                } else if (!p10.isData) {
                    break loop0;
                }
                Node c4 = p10;
                while (q10 != null && q10.isMatched()) {
                    Node p11 = q10;
                    if (p10 == q10) {
                        break;
                    }
                    q10 = p11.next;
                    p10 = p11;
                }
                pred = skipDeadNodes(pred, c4, p10, q10);
                p10 = q10;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object o10) {
        if (o10 == null) {
            return false;
        }
        loop0: while (true) {
            Node p10 = this.head;
            Node pred = null;
            while (p10 != null) {
                Node q10 = p10.next;
                Object item = p10.item;
                if (item != null) {
                    if (p10.isData) {
                        if (o10.equals(item)) {
                            return true;
                        }
                        pred = p10;
                        p10 = q10;
                    }
                } else if (!p10.isData) {
                    break loop0;
                }
                Node c4 = p10;
                while (q10 != null && q10.isMatched()) {
                    Node p11 = q10;
                    if (p10 == q10) {
                        break;
                    }
                    q10 = p11.next;
                    p10 = p11;
                }
                pred = skipDeadNodes(pred, c4, p10, q10);
                p10 = q10;
            }
        }
        return false;
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return Integer.MAX_VALUE;
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        s2.defaultWriteObject();
        Iterator<E> iterator2 = iterator2();
        while (iterator2.hasNext()) {
            E e2 = iterator2.next();
            s2.writeObject(e2);
        }
        s2.writeObject(null);
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        Node h10 = null;
        Node t2 = null;
        while (true) {
            Object item = s2.readObject();
            if (item == null) {
                break;
            }
            Node newNode = new Node(item);
            if (h10 == null) {
                t2 = newNode;
                h10 = newNode;
            } else {
                t2.appendRelaxed(newNode);
                t2 = newNode;
            }
        }
        if (h10 == null) {
            Node node = new Node();
            t2 = node;
            h10 = node;
        }
        this.head = h10;
        this.tail = t2;
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super E> filter) {
        Objects.requireNonNull(filter);
        return bulkRemove(filter);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(final Collection<?> c4) {
        Objects.requireNonNull(c4);
        return bulkRemove(new Predicate() { // from class: java.util.concurrent.LinkedTransferQueue$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean contains;
                contains = Collection.this.contains(obj);
                return contains;
            }
        });
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(final Collection<?> c4) {
        Objects.requireNonNull(c4);
        return bulkRemove(new Predicate() { // from class: java.util.concurrent.LinkedTransferQueue$$ExternalSyntheticLambda2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return LinkedTransferQueue.lambda$retainAll$1(Collection.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$retainAll$1(Collection c4, Object e2) {
        return !c4.contains(e2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$clear$2(Object e2) {
        return true;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        bulkRemove(new Predicate() { // from class: java.util.concurrent.LinkedTransferQueue$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return LinkedTransferQueue.lambda$clear$2(obj);
            }
        });
    }

    private boolean bulkRemove(Predicate<? super E> filter) {
        boolean removed = false;
        loop0: while (true) {
            int hops = 8;
            Node p10 = this.head;
            Node c4 = p10;
            Node pred = null;
            while (p10 != null) {
                Node q10 = p10.next;
                Object item = p10.item;
                boolean z10 = item != null && p10.isData;
                boolean pAlive = z10;
                if (z10) {
                    if (filter.test(item)) {
                        if (p10.tryMatch(item, null)) {
                            removed = true;
                        }
                        pAlive = false;
                    }
                } else if (!p10.isData && item == null) {
                    break loop0;
                }
                if (pAlive || q10 == null || hops - 1 == 0) {
                    if (c4 != p10) {
                        Node c10 = p10;
                        if (tryCasSuccessor(pred, c4, p10)) {
                            c4 = c10;
                        }
                        hops = 8;
                        Node pred2 = p10;
                        pred = pred2;
                        c4 = q10;
                    }
                    if (pAlive) {
                        hops = 8;
                        Node pred22 = p10;
                        pred = pred22;
                        c4 = q10;
                    }
                } else if (p10 == q10) {
                    break;
                }
                p10 = q10;
            }
        }
        return removed;
    }

    void forEachFrom(Consumer<? super E> action, Node p10) {
        Node pred = null;
        while (p10 != null) {
            Node q10 = p10.next;
            Object item = p10.item;
            if (item != null) {
                if (p10.isData) {
                    action.accept(item);
                    pred = p10;
                    p10 = q10;
                }
            } else if (!p10.isData) {
                return;
            }
            Node c4 = p10;
            while (q10 != null && q10.isMatched()) {
                Node p11 = q10;
                if (p10 == q10) {
                    Node pred2 = this.head;
                    pred = null;
                    p10 = pred2;
                    break;
                }
                q10 = p11.next;
                p10 = p11;
            }
            pred = skipDeadNodes(pred, c4, p10, q10);
            p10 = q10;
        }
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        forEachFrom(action, this.head);
    }

    static {
        try {
            MethodHandles.Lookup l10 = MethodHandles.lookup();
            HEAD = l10.findVarHandle(LinkedTransferQueue.class, "head", Node.class);
            TAIL = l10.findVarHandle(LinkedTransferQueue.class, "tail", Node.class);
            ITEM = l10.findVarHandle(Node.class, ImsConfig.EXTRA_CHANGED_ITEM, Object.class);
            NEXT = l10.findVarHandle(Node.class, "next", Node.class);
            WAITER = l10.findVarHandle(Node.class, "waiter", Thread.class);
        } catch (ReflectiveOperationException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }
}
