package java.util.concurrent.atomic;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.DoubleBinaryOperator;
import java.util.function.LongBinaryOperator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class Striped64 extends Number {
    private static final VarHandle BASE;
    private static final VarHandle CELLSBUSY;
    static final int NCPU = Runtime.getRuntime().availableProcessors();
    private static final VarHandle THREAD_PROBE;
    volatile transient long base;
    volatile transient Cell[] cells;
    volatile transient int cellsBusy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class Cell {
        private static final VarHandle VALUE;
        volatile long value;

        Cell(long x10) {
            this.value = x10;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean cas(long cmp, long val) {
            return (boolean) VALUE.weakCompareAndSetRelease(this, cmp, val);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void reset() {
            (void) VALUE.setVolatile(this, 0L);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void reset(long identity) {
            (void) VALUE.setVolatile(this, identity);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final long getAndSet(long val) {
            return (long) VALUE.getAndSet(this, val);
        }

        static {
            try {
                MethodHandles.Lookup l10 = MethodHandles.lookup();
                VALUE = l10.findVarHandle(Cell.class, "value", Long.TYPE);
            } catch (ReflectiveOperationException e2) {
                throw new ExceptionInInitializerError(e2);
            }
        }
    }

    static {
        try {
            MethodHandles.Lookup l10 = MethodHandles.lookup();
            BASE = l10.findVarHandle(Striped64.class, "base", Long.TYPE);
            CELLSBUSY = l10.findVarHandle(Striped64.class, "cellsBusy", Integer.TYPE);
            THREAD_PROBE = ((MethodHandles.Lookup) AccessController.doPrivileged(new PrivilegedAction<MethodHandles.Lookup>() { // from class: java.util.concurrent.atomic.Striped64.1
                @Override // java.security.PrivilegedAction
                public MethodHandles.Lookup run() {
                    try {
                        return MethodHandles.privateLookupIn(Thread.class, MethodHandles.lookup());
                    } catch (ReflectiveOperationException e2) {
                        throw new ExceptionInInitializerError(e2);
                    }
                }
            })).findVarHandle(Thread.class, "threadLocalRandomProbe", Integer.TYPE);
        } catch (ReflectiveOperationException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean casBase(long cmp, long val) {
        return (boolean) BASE.weakCompareAndSetRelease(this, cmp, val);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long getAndSetBase(long val) {
        return (long) BASE.getAndSet(this, val);
    }

    final boolean casCellsBusy() {
        return (boolean) CELLSBUSY.compareAndSet(this, 0, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int getProbe() {
        return (int) THREAD_PROBE.get(Thread.currentThread());
    }

    static final int advanceProbe(int probe) {
        int probe2 = probe ^ (probe << 13);
        int probe3 = probe2 ^ (probe2 >>> 17);
        int probe4 = probe3 ^ (probe3 << 5);
        (void) THREAD_PROBE.set(Thread.currentThread(), probe4);
        return probe4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void longAccumulate(long x10, LongBinaryOperator fn, boolean wasUncontended, int index) {
        boolean wasUncontended2;
        int index2;
        int n10;
        int m10;
        if (index != 0) {
            wasUncontended2 = wasUncontended;
            index2 = index;
        } else {
            ThreadLocalRandom.current();
            index2 = getProbe();
            wasUncontended2 = true;
        }
        boolean collide = false;
        boolean wasUncontended3 = wasUncontended2;
        int index3 = index2;
        while (true) {
            Cell[] cs = this.cells;
            if (cs != null && (n10 = cs.length) > 0) {
                Cell c4 = cs[(n10 - 1) & index3];
                if (c4 == null) {
                    if (this.cellsBusy == 0) {
                        Cell r10 = new Cell(x10);
                        if (this.cellsBusy == 0 && casCellsBusy()) {
                            try {
                                Cell[] rs = this.cells;
                                if (rs != null && (m10 = rs.length) > 0) {
                                    int j10 = (m10 - 1) & index3;
                                    if (rs[j10] == null) {
                                        rs[j10] = r10;
                                        return;
                                    }
                                }
                            } finally {
                                this.cellsBusy = 0;
                            }
                        }
                    }
                    collide = false;
                    index3 = advanceProbe(index3);
                } else {
                    if (!wasUncontended3) {
                        wasUncontended3 = true;
                    } else {
                        long v2 = c4.value;
                        if (!c4.cas(v2, fn == null ? v2 + x10 : fn.applyAsLong(v2, x10))) {
                            if (n10 >= NCPU || this.cells != cs) {
                                collide = false;
                            } else if (!collide) {
                                collide = true;
                            } else if (this.cellsBusy == 0 && casCellsBusy()) {
                                try {
                                    if (this.cells == cs) {
                                        this.cells = (Cell[]) Arrays.copyOf(cs, n10 << 1);
                                    }
                                    this.cellsBusy = 0;
                                    collide = false;
                                } finally {
                                }
                            }
                        } else {
                            return;
                        }
                    }
                    index3 = advanceProbe(index3);
                }
            }
            if (this.cellsBusy == 0 && this.cells == cs && casCellsBusy()) {
                try {
                    if (this.cells == cs) {
                        Cell[] rs2 = new Cell[2];
                        rs2[index3 & 1] = new Cell(x10);
                        this.cells = rs2;
                        return;
                    }
                } finally {
                }
            } else {
                long v10 = this.base;
                if (casBase(v10, fn == null ? v10 + x10 : fn.applyAsLong(v10, x10))) {
                    return;
                }
            }
        }
    }

    private static long apply(DoubleBinaryOperator fn, long v2, double x10) {
        double d10 = Double.longBitsToDouble(v2);
        return Double.doubleToRawLongBits(fn == null ? d10 + x10 : fn.applyAsDouble(d10, x10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void doubleAccumulate(double x10, DoubleBinaryOperator fn, boolean wasUncontended, int index) {
        boolean wasUncontended2;
        int index2;
        int n10;
        int m10;
        if (index != 0) {
            wasUncontended2 = wasUncontended;
            index2 = index;
        } else {
            ThreadLocalRandom.current();
            index2 = getProbe();
            wasUncontended2 = true;
        }
        boolean collide = false;
        boolean wasUncontended3 = wasUncontended2;
        int index3 = index2;
        while (true) {
            Cell[] cs = this.cells;
            if (cs != null && (n10 = cs.length) > 0) {
                Cell c4 = cs[(n10 - 1) & index3];
                if (c4 == null) {
                    if (this.cellsBusy == 0) {
                        Cell r10 = new Cell(Double.doubleToRawLongBits(x10));
                        if (this.cellsBusy == 0 && casCellsBusy()) {
                            try {
                                Cell[] rs = this.cells;
                                if (rs != null && (m10 = rs.length) > 0) {
                                    int j10 = (m10 - 1) & index3;
                                    if (rs[j10] == null) {
                                        rs[j10] = r10;
                                        return;
                                    }
                                }
                            } finally {
                                this.cellsBusy = 0;
                            }
                        }
                    }
                    collide = false;
                    index3 = advanceProbe(index3);
                } else {
                    if (!wasUncontended3) {
                        wasUncontended3 = true;
                    } else {
                        long v2 = c4.value;
                        if (!c4.cas(v2, apply(fn, v2, x10))) {
                            if (n10 >= NCPU || this.cells != cs) {
                                collide = false;
                            } else if (!collide) {
                                collide = true;
                            } else if (this.cellsBusy == 0 && casCellsBusy()) {
                                try {
                                    if (this.cells == cs) {
                                        this.cells = (Cell[]) Arrays.copyOf(cs, n10 << 1);
                                    }
                                    this.cellsBusy = 0;
                                    collide = false;
                                } finally {
                                }
                            }
                        } else {
                            return;
                        }
                    }
                    index3 = advanceProbe(index3);
                }
            }
            if (this.cellsBusy == 0 && this.cells == cs && casCellsBusy()) {
                try {
                    if (this.cells == cs) {
                        Cell[] rs2 = new Cell[2];
                        rs2[index3 & 1] = new Cell(Double.doubleToRawLongBits(x10));
                        this.cells = rs2;
                        return;
                    }
                } finally {
                }
            } else {
                long v10 = this.base;
                if (casBase(v10, apply(fn, v10, x10))) {
                    return;
                }
            }
        }
    }
}
