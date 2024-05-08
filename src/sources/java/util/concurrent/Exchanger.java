package java.util.concurrent;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.concurrent.locks.LockSupport;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Exchanger<V> {
    private static final VarHandle AA;
    private static final int ASHIFT = 5;
    private static final VarHandle BOUND;
    static final int FULL;
    private static final VarHandle MATCH;
    private static final int MMASK = 255;
    private static final int NCPU;
    private static final Object NULL_ITEM;
    private static final int SEQ = 256;
    private static final VarHandle SLOT;
    private static final int SPINS = 1024;
    private static final Object TIMED_OUT;
    private volatile Node[] arena;
    private volatile int bound;
    private final Participant participant = new Participant();
    private volatile Node slot;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        NCPU = availableProcessors;
        FULL = availableProcessors >= 510 ? 255 : availableProcessors >>> 1;
        NULL_ITEM = new Object();
        TIMED_OUT = new Object();
        try {
            MethodHandles.Lookup l10 = MethodHandles.lookup();
            BOUND = l10.findVarHandle(Exchanger.class, "bound", Integer.TYPE);
            SLOT = l10.findVarHandle(Exchanger.class, "slot", Node.class);
            MATCH = l10.findVarHandle(Node.class, "match", Object.class);
            AA = MethodHandles.arrayElementVarHandle(Node[].class);
        } catch (ReflectiveOperationException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class Node {
        int bound;
        int collides;
        int hash;
        int index;
        Object item;
        volatile Object match;
        volatile Thread parked;

        Node() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class Participant extends ThreadLocal<Node> {
        Participant() {
        }

        @Override // java.lang.ThreadLocal
        public Node initialValue() {
            return new Node();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c9, code lost:
    
        if (r19 > 0) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Object arenaExchange(java.lang.Object r24, boolean r25, long r26) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.Exchanger.arenaExchange(java.lang.Object, boolean, long):java.lang.Object");
    }

    private final Object slotExchange(Object item, boolean timed, long ns) {
        Object v2;
        Void r52;
        Node p10 = this.participant.get();
        Thread t2 = Thread.currentThread();
        if (t2.isInterrupted()) {
            return null;
        }
        while (true) {
            Node q10 = this.slot;
            if (q10 != null) {
                if ((boolean) SLOT.compareAndSet(this, q10, null)) {
                    Object v10 = q10.item;
                    q10.match = item;
                    Thread w3 = q10.parked;
                    if (w3 != null) {
                        LockSupport.unpark(w3);
                    }
                    return v10;
                }
                if (NCPU > 1 && this.bound == 0 && (boolean) BOUND.compareAndSet(this, 0, 256)) {
                    this.arena = new Node[(FULL + 2) << 5];
                }
            } else {
                if (this.arena != null) {
                    return null;
                }
                p10.item = item;
                if (!(boolean) SLOT.compareAndSet(this, null, p10)) {
                    p10.item = null;
                } else {
                    int h10 = p10.hash;
                    long end = timed ? System.nanoTime() + ns : 0L;
                    int spins = NCPU > 1 ? 1024 : 1;
                    long ns2 = ns;
                    while (true) {
                        Object obj = p10.match;
                        v2 = obj;
                        if (obj != null) {
                            break;
                        }
                        if (spins > 0) {
                            int h11 = h10 ^ (h10 << 1);
                            int h12 = h11 ^ (h11 >>> 3);
                            h10 = h12 ^ (h12 << 10);
                            if (h10 == 0) {
                                h10 = ((int) t2.getId()) | 1024;
                                ns2 = ns2;
                            } else {
                                long ns3 = ns2;
                                if (h10 < 0) {
                                    spins--;
                                    if ((spins & 511) == 0) {
                                        Thread.yield();
                                    }
                                    ns2 = ns3;
                                } else {
                                    ns2 = ns3;
                                }
                            }
                        } else {
                            long ns4 = ns2;
                            if (this.slot != p10) {
                                spins = 1024;
                                ns2 = ns4;
                            } else {
                                if (t2.isInterrupted() || this.arena != null) {
                                    r52 = null;
                                    ns2 = ns4;
                                } else {
                                    if (!timed) {
                                        ns2 = ns4;
                                    } else {
                                        long ns5 = end - System.nanoTime();
                                        ns2 = ns5;
                                        if (ns5 <= 0) {
                                            r52 = null;
                                        }
                                    }
                                    p10.parked = t2;
                                    if (this.slot == p10) {
                                        if (ns2 == 0) {
                                            LockSupport.park(this);
                                        } else {
                                            LockSupport.parkNanos(this, ns2);
                                        }
                                    }
                                    p10.parked = null;
                                }
                                if ((boolean) SLOT.compareAndSet(this, p10, r52)) {
                                    v2 = (!timed || ns2 > 0 || t2.isInterrupted()) ? null : TIMED_OUT;
                                }
                            }
                        }
                    }
                    (void) MATCH.setRelease(p10, null);
                    p10.item = null;
                    p10.hash = h10;
                    return v2;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
    
        return (V) r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0020, code lost:
    
        if (r1 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0013, code lost:
    
        if (r1 == null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0024, code lost:
    
        if (r6 != java.util.concurrent.Exchanger.NULL_ITEM) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public V exchange(V r8) throws java.lang.InterruptedException {
        /*
            r7 = this;
            if (r8 != 0) goto L5
            java.lang.Object r0 = java.util.concurrent.Exchanger.NULL_ITEM
            goto L6
        L5:
            r0 = r8
        L6:
            java.util.concurrent.Exchanger$Node[] r1 = r7.arena
            r2 = r1
            r3 = 0
            r5 = 0
            if (r1 != 0) goto L15
            java.lang.Object r1 = r7.slotExchange(r0, r5, r3)
            r6 = r1
            if (r1 != 0) goto L22
        L15:
            boolean r1 = java.lang.Thread.interrupted()
            if (r1 != 0) goto L2a
            java.lang.Object r1 = r7.arenaExchange(r0, r5, r3)
            r6 = r1
            if (r1 == 0) goto L2a
        L22:
            java.lang.Object r1 = java.util.concurrent.Exchanger.NULL_ITEM
            if (r6 != r1) goto L28
            r1 = 0
            goto L29
        L28:
            r1 = r6
        L29:
            return r1
        L2a:
            java.lang.InterruptedException r1 = new java.lang.InterruptedException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.Exchanger.exchange(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0029, code lost:
    
        if (r5 != java.util.concurrent.Exchanger.NULL_ITEM) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002b, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
    
        return (V) r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
    
        throw new java.util.concurrent.TimeoutException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0021, code lost:
    
        if (r3 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0014, code lost:
    
        if (r3 == null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0025, code lost:
    
        if (r5 == java.util.concurrent.Exchanger.TIMED_OUT) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public V exchange(V r7, long r8, java.util.concurrent.TimeUnit r10) throws java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        /*
            r6 = this;
            if (r7 != 0) goto L5
            java.lang.Object r0 = java.util.concurrent.Exchanger.NULL_ITEM
            goto L6
        L5:
            r0 = r7
        L6:
            long r1 = r10.toNanos(r8)
            java.util.concurrent.Exchanger$Node[] r3 = r6.arena
            r4 = 1
            if (r3 != 0) goto L16
            java.lang.Object r3 = r6.slotExchange(r0, r4, r1)
            r5 = r3
            if (r3 != 0) goto L23
        L16:
            boolean r3 = java.lang.Thread.interrupted()
            if (r3 != 0) goto L35
            java.lang.Object r3 = r6.arenaExchange(r0, r4, r1)
            r5 = r3
            if (r3 == 0) goto L35
        L23:
            java.lang.Object r3 = java.util.concurrent.Exchanger.TIMED_OUT
            if (r5 == r3) goto L2f
            java.lang.Object r3 = java.util.concurrent.Exchanger.NULL_ITEM
            if (r5 != r3) goto L2d
            r3 = 0
            goto L2e
        L2d:
            r3 = r5
        L2e:
            return r3
        L2f:
            java.util.concurrent.TimeoutException r3 = new java.util.concurrent.TimeoutException
            r3.<init>()
            throw r3
        L35:
            java.lang.InterruptedException r3 = new java.lang.InterruptedException
            r3.<init>()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.Exchanger.exchange(java.lang.Object, long, java.util.concurrent.TimeUnit):java.lang.Object");
    }
}
