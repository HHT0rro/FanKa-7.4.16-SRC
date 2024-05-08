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
public class AtomicLong extends Number implements Serializable {
    private static final VarHandle VALUE;
    static final boolean VM_SUPPORTS_LONG_CAS = VMSupportsCS8();
    private static final long serialVersionUID = 1927816293512124184L;
    private volatile long value;

    private static native boolean VMSupportsCS8();

    static {
        try {
            MethodHandles.Lookup l10 = MethodHandles.lookup();
            VALUE = l10.findVarHandle(AtomicLong.class, "value", Long.TYPE);
        } catch (ReflectiveOperationException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public AtomicLong(long initialValue) {
        this.value = initialValue;
    }

    public AtomicLong() {
    }

    public final long get() {
        return this.value;
    }

    public final void set(long newValue) {
        (void) VALUE.setVolatile(this, newValue);
    }

    public final void lazySet(long newValue) {
        (void) VALUE.setRelease(this, newValue);
    }

    public final long getAndSet(long newValue) {
        return (long) VALUE.getAndSet(this, newValue);
    }

    public final boolean compareAndSet(long expectedValue, long newValue) {
        return (boolean) VALUE.compareAndSet(this, expectedValue, newValue);
    }

    @Deprecated(since = "9")
    public final boolean weakCompareAndSet(long expectedValue, long newValue) {
        return (boolean) VALUE.weakCompareAndSetPlain(this, expectedValue, newValue);
    }

    public final boolean weakCompareAndSetPlain(long expectedValue, long newValue) {
        return (boolean) VALUE.weakCompareAndSetPlain(this, expectedValue, newValue);
    }

    public final long getAndIncrement() {
        return (long) VALUE.getAndAdd(this, 1L);
    }

    public final long getAndDecrement() {
        return (long) VALUE.getAndAdd(this, -1L);
    }

    public final long getAndAdd(long delta) {
        return (long) VALUE.getAndAdd(this, delta);
    }

    public final long incrementAndGet() {
        return (long) VALUE.getAndAdd(this, 1L) + 1;
    }

    public final long decrementAndGet() {
        return (long) VALUE.getAndAdd(this, -1L) - 1;
    }

    public final long addAndGet(long delta) {
        return (long) VALUE.getAndAdd(this, delta) + delta;
    }

    public final long getAndUpdate(LongUnaryOperator updateFunction) {
        long prev = get();
        long next = 0;
        boolean haveNext = false;
        while (true) {
            if (!haveNext) {
                next = updateFunction.applyAsLong(prev);
            }
            if (weakCompareAndSetVolatile(prev, next)) {
                return prev;
            }
            long prev2 = get();
            haveNext = prev == prev2;
            prev = prev2;
        }
    }

    public final long updateAndGet(LongUnaryOperator updateFunction) {
        long prev = get();
        long next = 0;
        boolean haveNext = false;
        while (true) {
            if (!haveNext) {
                next = updateFunction.applyAsLong(prev);
            }
            if (weakCompareAndSetVolatile(prev, next)) {
                return next;
            }
            long prev2 = get();
            haveNext = prev == prev2;
            prev = prev2;
        }
    }

    public final long getAndAccumulate(long x10, LongBinaryOperator accumulatorFunction) {
        long prev = get();
        long next = 0;
        boolean haveNext = false;
        while (true) {
            if (!haveNext) {
                next = accumulatorFunction.applyAsLong(prev, x10);
            }
            if (weakCompareAndSetVolatile(prev, next)) {
                return prev;
            }
            long prev2 = get();
            haveNext = prev == prev2;
            prev = prev2;
        }
    }

    public final long accumulateAndGet(long x10, LongBinaryOperator accumulatorFunction) {
        long prev = get();
        long next = 0;
        boolean haveNext = false;
        while (true) {
            if (!haveNext) {
                next = accumulatorFunction.applyAsLong(prev, x10);
            }
            if (weakCompareAndSetVolatile(prev, next)) {
                return next;
            }
            long prev2 = get();
            haveNext = prev == prev2;
            prev = prev2;
        }
    }

    public String toString() {
        return Long.toString(get());
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) get();
    }

    @Override // java.lang.Number
    public long longValue() {
        return get();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) get();
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return get();
    }

    public final long getPlain() {
        return (long) VALUE.get(this);
    }

    public final void setPlain(long newValue) {
        (void) VALUE.set(this, newValue);
    }

    public final long getOpaque() {
        return (long) VALUE.getOpaque(this);
    }

    public final void setOpaque(long newValue) {
        (void) VALUE.setOpaque(this, newValue);
    }

    public final long getAcquire() {
        return (long) VALUE.getAcquire(this);
    }

    public final void setRelease(long newValue) {
        (void) VALUE.setRelease(this, newValue);
    }

    public final long compareAndExchange(long expectedValue, long newValue) {
        return (long) VALUE.compareAndExchange(this, expectedValue, newValue);
    }

    public final long compareAndExchangeAcquire(long expectedValue, long newValue) {
        return (long) VALUE.compareAndExchangeAcquire(this, expectedValue, newValue);
    }

    public final long compareAndExchangeRelease(long expectedValue, long newValue) {
        return (long) VALUE.compareAndExchangeRelease(this, expectedValue, newValue);
    }

    public final boolean weakCompareAndSetVolatile(long expectedValue, long newValue) {
        return (boolean) VALUE.weakCompareAndSet(this, expectedValue, newValue);
    }

    public final boolean weakCompareAndSetAcquire(long expectedValue, long newValue) {
        return (boolean) VALUE.weakCompareAndSetAcquire(this, expectedValue, newValue);
    }

    public final boolean weakCompareAndSetRelease(long expectedValue, long newValue) {
        return (boolean) VALUE.weakCompareAndSetRelease(this, expectedValue, newValue);
    }
}
