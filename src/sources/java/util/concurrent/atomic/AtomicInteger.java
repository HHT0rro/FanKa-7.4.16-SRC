package java.util.concurrent.atomic;

import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class AtomicInteger extends Number implements Serializable {
    private static final VarHandle VALUE;
    private static final long serialVersionUID = 6214790243416807050L;
    private volatile int value;

    static {
        try {
            MethodHandles.Lookup l10 = MethodHandles.lookup();
            VALUE = l10.findVarHandle(AtomicInteger.class, "value", Integer.TYPE);
        } catch (ReflectiveOperationException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public AtomicInteger(int initialValue) {
        this.value = initialValue;
    }

    public AtomicInteger() {
    }

    public final int get() {
        return this.value;
    }

    public final void set(int newValue) {
        this.value = newValue;
    }

    public final void lazySet(int newValue) {
        (void) VALUE.setRelease(this, newValue);
    }

    public final int getAndSet(int newValue) {
        return (int) VALUE.getAndSet(this, newValue);
    }

    public final boolean compareAndSet(int expectedValue, int newValue) {
        return (boolean) VALUE.compareAndSet(this, expectedValue, newValue);
    }

    @Deprecated(since = "9")
    public final boolean weakCompareAndSet(int expectedValue, int newValue) {
        return (boolean) VALUE.weakCompareAndSetPlain(this, expectedValue, newValue);
    }

    public final boolean weakCompareAndSetPlain(int expectedValue, int newValue) {
        return (boolean) VALUE.weakCompareAndSetPlain(this, expectedValue, newValue);
    }

    public final int getAndIncrement() {
        return (int) VALUE.getAndAdd(this, 1);
    }

    public final int getAndDecrement() {
        return (int) VALUE.getAndAdd(this, -1);
    }

    public final int getAndAdd(int delta) {
        return (int) VALUE.getAndAdd(this, delta);
    }

    public final int incrementAndGet() {
        return (int) VALUE.getAndAdd(this, 1) + 1;
    }

    public final int decrementAndGet() {
        return (int) VALUE.getAndAdd(this, -1) - 1;
    }

    public final int addAndGet(int delta) {
        return (int) VALUE.getAndAdd(this, delta) + delta;
    }

    public final int getAndUpdate(IntUnaryOperator updateFunction) {
        int prev = get();
        int next = 0;
        boolean haveNext = false;
        while (true) {
            if (!haveNext) {
                next = updateFunction.applyAsInt(prev);
            }
            if (weakCompareAndSetVolatile(prev, next)) {
                return prev;
            }
            int prev2 = get();
            haveNext = prev == prev2;
            prev = prev2;
        }
    }

    public final int updateAndGet(IntUnaryOperator updateFunction) {
        int prev = get();
        int next = 0;
        boolean haveNext = false;
        while (true) {
            if (!haveNext) {
                next = updateFunction.applyAsInt(prev);
            }
            if (weakCompareAndSetVolatile(prev, next)) {
                return next;
            }
            int prev2 = get();
            haveNext = prev == prev2;
            prev = prev2;
        }
    }

    public final int getAndAccumulate(int x10, IntBinaryOperator accumulatorFunction) {
        int prev = get();
        int next = 0;
        boolean haveNext = false;
        while (true) {
            if (!haveNext) {
                next = accumulatorFunction.applyAsInt(prev, x10);
            }
            if (weakCompareAndSetVolatile(prev, next)) {
                return prev;
            }
            int prev2 = get();
            haveNext = prev == prev2;
            prev = prev2;
        }
    }

    public final int accumulateAndGet(int x10, IntBinaryOperator accumulatorFunction) {
        int prev = get();
        int next = 0;
        boolean haveNext = false;
        while (true) {
            if (!haveNext) {
                next = accumulatorFunction.applyAsInt(prev, x10);
            }
            if (weakCompareAndSetVolatile(prev, next)) {
                return next;
            }
            int prev2 = get();
            haveNext = prev == prev2;
            prev = prev2;
        }
    }

    public String toString() {
        return Integer.toString(get());
    }

    @Override // java.lang.Number
    public int intValue() {
        return get();
    }

    @Override // java.lang.Number
    public long longValue() {
        return get();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return get();
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return get();
    }

    public final int getPlain() {
        return (int) VALUE.get(this);
    }

    public final void setPlain(int newValue) {
        (void) VALUE.set(this, newValue);
    }

    public final int getOpaque() {
        return (int) VALUE.getOpaque(this);
    }

    public final void setOpaque(int newValue) {
        (void) VALUE.setOpaque(this, newValue);
    }

    public final int getAcquire() {
        return (int) VALUE.getAcquire(this);
    }

    public final void setRelease(int newValue) {
        (void) VALUE.setRelease(this, newValue);
    }

    public final int compareAndExchange(int expectedValue, int newValue) {
        return (int) VALUE.compareAndExchange(this, expectedValue, newValue);
    }

    public final int compareAndExchangeAcquire(int expectedValue, int newValue) {
        return (int) VALUE.compareAndExchangeAcquire(this, expectedValue, newValue);
    }

    public final int compareAndExchangeRelease(int expectedValue, int newValue) {
        return (int) VALUE.compareAndExchangeRelease(this, expectedValue, newValue);
    }

    public final boolean weakCompareAndSetVolatile(int expectedValue, int newValue) {
        return (boolean) VALUE.weakCompareAndSet(this, expectedValue, newValue);
    }

    public final boolean weakCompareAndSetAcquire(int expectedValue, int newValue) {
        return (boolean) VALUE.weakCompareAndSetAcquire(this, expectedValue, newValue);
    }

    public final boolean weakCompareAndSetRelease(int expectedValue, int newValue) {
        return (boolean) VALUE.weakCompareAndSetRelease(this, expectedValue, newValue);
    }
}
