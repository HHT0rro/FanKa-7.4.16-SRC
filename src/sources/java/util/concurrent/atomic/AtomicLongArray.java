package java.util.concurrent.atomic;

import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.function.LongBinaryOperator;
import java.util.function.LongUnaryOperator;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class AtomicLongArray implements Serializable {
    private static final VarHandle AA = MethodHandles.arrayElementVarHandle(long[].class);
    private static final long serialVersionUID = -2308431214976778248L;
    private final long[] array;

    public AtomicLongArray(int length) {
        this.array = new long[length];
    }

    public AtomicLongArray(long[] array) {
        this.array = (long[]) array.clone();
    }

    public final int length() {
        return this.array.length;
    }

    public final long get(int i10) {
        return (long) AA.getVolatile(this.array, i10);
    }

    public final void set(int i10, long newValue) {
        (void) AA.setVolatile(this.array, i10, newValue);
    }

    public final void lazySet(int i10, long newValue) {
        (void) AA.setRelease(this.array, i10, newValue);
    }

    public final long getAndSet(int i10, long newValue) {
        return (long) AA.getAndSet(this.array, i10, newValue);
    }

    public final boolean compareAndSet(int i10, long expectedValue, long newValue) {
        return (boolean) AA.compareAndSet(this.array, i10, expectedValue, newValue);
    }

    @Deprecated(since = "9")
    public final boolean weakCompareAndSet(int i10, long expectedValue, long newValue) {
        return (boolean) AA.weakCompareAndSetPlain(this.array, i10, expectedValue, newValue);
    }

    public final boolean weakCompareAndSetPlain(int i10, long expectedValue, long newValue) {
        return (boolean) AA.weakCompareAndSetPlain(this.array, i10, expectedValue, newValue);
    }

    public final long getAndIncrement(int i10) {
        return (long) AA.getAndAdd(this.array, i10, 1L);
    }

    public final long getAndDecrement(int i10) {
        return (long) AA.getAndAdd(this.array, i10, -1L);
    }

    public final long getAndAdd(int i10, long delta) {
        return (long) AA.getAndAdd(this.array, i10, delta);
    }

    public final long incrementAndGet(int i10) {
        return (long) AA.getAndAdd(this.array, i10, 1L) + 1;
    }

    public final long decrementAndGet(int i10) {
        return (long) AA.getAndAdd(this.array, i10, -1L) - 1;
    }

    public long addAndGet(int i10, long delta) {
        return (long) AA.getAndAdd(this.array, i10, delta) + delta;
    }

    public final long getAndUpdate(int i10, LongUnaryOperator updateFunction) {
        long prev = get(i10);
        long next = 0;
        boolean haveNext = false;
        while (true) {
            if (!haveNext) {
                next = updateFunction.applyAsLong(prev);
            }
            if (weakCompareAndSetVolatile(i10, prev, next)) {
                return prev;
            }
            long prev2 = get(i10);
            haveNext = prev == prev2;
            prev = prev2;
        }
    }

    public final long updateAndGet(int i10, LongUnaryOperator updateFunction) {
        long prev = get(i10);
        long next = 0;
        boolean haveNext = false;
        while (true) {
            if (!haveNext) {
                next = updateFunction.applyAsLong(prev);
            }
            if (weakCompareAndSetVolatile(i10, prev, next)) {
                return next;
            }
            long prev2 = get(i10);
            haveNext = prev == prev2;
            prev = prev2;
        }
    }

    public final long getAndAccumulate(int i10, long x10, LongBinaryOperator accumulatorFunction) {
        long prev = get(i10);
        long next = 0;
        boolean haveNext = false;
        while (true) {
            if (!haveNext) {
                next = accumulatorFunction.applyAsLong(prev, x10);
            }
            if (weakCompareAndSetVolatile(i10, prev, next)) {
                return prev;
            }
            long prev2 = get(i10);
            haveNext = prev == prev2;
            prev = prev2;
        }
    }

    public final long accumulateAndGet(int i10, long x10, LongBinaryOperator accumulatorFunction) {
        long prev = get(i10);
        long next = 0;
        boolean haveNext = false;
        while (true) {
            if (!haveNext) {
                next = accumulatorFunction.applyAsLong(prev, x10);
            }
            if (weakCompareAndSetVolatile(i10, prev, next)) {
                return next;
            }
            long prev2 = get(i10);
            haveNext = prev == prev2;
            prev = prev2;
        }
    }

    public String toString() {
        int iMax = this.array.length - 1;
        if (iMax == -1) {
            return "[]";
        }
        StringBuilder b4 = new StringBuilder();
        b4.append('[');
        int i10 = 0;
        while (true) {
            b4.append(get(i10));
            if (i10 == iMax) {
                return b4.append(']').toString();
            }
            b4.append(',').append(' ');
            i10++;
        }
    }

    public final long getPlain(int i10) {
        return (long) AA.get(this.array, i10);
    }

    public final void setPlain(int i10, long newValue) {
        (void) AA.set(this.array, i10, newValue);
    }

    public final long getOpaque(int i10) {
        return (long) AA.getOpaque(this.array, i10);
    }

    public final void setOpaque(int i10, long newValue) {
        (void) AA.setOpaque(this.array, i10, newValue);
    }

    public final long getAcquire(int i10) {
        return (long) AA.getAcquire(this.array, i10);
    }

    public final void setRelease(int i10, long newValue) {
        (void) AA.setRelease(this.array, i10, newValue);
    }

    public final long compareAndExchange(int i10, long expectedValue, long newValue) {
        return (long) AA.compareAndExchange(this.array, i10, expectedValue, newValue);
    }

    public final long compareAndExchangeAcquire(int i10, long expectedValue, long newValue) {
        return (long) AA.compareAndExchangeAcquire(this.array, i10, expectedValue, newValue);
    }

    public final long compareAndExchangeRelease(int i10, long expectedValue, long newValue) {
        return (long) AA.compareAndExchangeRelease(this.array, i10, expectedValue, newValue);
    }

    public final boolean weakCompareAndSetVolatile(int i10, long expectedValue, long newValue) {
        return (boolean) AA.weakCompareAndSet(this.array, i10, expectedValue, newValue);
    }

    public final boolean weakCompareAndSetAcquire(int i10, long expectedValue, long newValue) {
        return (boolean) AA.weakCompareAndSetAcquire(this.array, i10, expectedValue, newValue);
    }

    public final boolean weakCompareAndSetRelease(int i10, long expectedValue, long newValue) {
        return (boolean) AA.weakCompareAndSetRelease(this.array, i10, expectedValue, newValue);
    }
}
