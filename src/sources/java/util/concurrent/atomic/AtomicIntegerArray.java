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
public class AtomicIntegerArray implements Serializable {
    private static final VarHandle AA = MethodHandles.arrayElementVarHandle(int[].class);
    private static final long serialVersionUID = 2862133569453604235L;
    private final int[] array;

    public AtomicIntegerArray(int length) {
        this.array = new int[length];
    }

    public AtomicIntegerArray(int[] array) {
        this.array = (int[]) array.clone();
    }

    public final int length() {
        return this.array.length;
    }

    public final int get(int i10) {
        return (int) AA.getVolatile(this.array, i10);
    }

    public final void set(int i10, int newValue) {
        (void) AA.setVolatile(this.array, i10, newValue);
    }

    public final void lazySet(int i10, int newValue) {
        (void) AA.setRelease(this.array, i10, newValue);
    }

    public final int getAndSet(int i10, int newValue) {
        return (int) AA.getAndSet(this.array, i10, newValue);
    }

    public final boolean compareAndSet(int i10, int expectedValue, int newValue) {
        return (boolean) AA.compareAndSet(this.array, i10, expectedValue, newValue);
    }

    @Deprecated(since = "9")
    public final boolean weakCompareAndSet(int i10, int expectedValue, int newValue) {
        return (boolean) AA.weakCompareAndSetPlain(this.array, i10, expectedValue, newValue);
    }

    public final boolean weakCompareAndSetPlain(int i10, int expectedValue, int newValue) {
        return (boolean) AA.weakCompareAndSetPlain(this.array, i10, expectedValue, newValue);
    }

    public final int getAndIncrement(int i10) {
        return (int) AA.getAndAdd(this.array, i10, 1);
    }

    public final int getAndDecrement(int i10) {
        return (int) AA.getAndAdd(this.array, i10, -1);
    }

    public final int getAndAdd(int i10, int delta) {
        return (int) AA.getAndAdd(this.array, i10, delta);
    }

    public final int incrementAndGet(int i10) {
        return (int) AA.getAndAdd(this.array, i10, 1) + 1;
    }

    public final int decrementAndGet(int i10) {
        return (int) AA.getAndAdd(this.array, i10, -1) - 1;
    }

    public final int addAndGet(int i10, int delta) {
        return (int) AA.getAndAdd(this.array, i10, delta) + delta;
    }

    public final int getAndUpdate(int i10, IntUnaryOperator updateFunction) {
        int prev = get(i10);
        int next = 0;
        boolean haveNext = false;
        while (true) {
            if (!haveNext) {
                next = updateFunction.applyAsInt(prev);
            }
            if (weakCompareAndSetVolatile(i10, prev, next)) {
                return prev;
            }
            int prev2 = get(i10);
            haveNext = prev == prev2;
            prev = prev2;
        }
    }

    public final int updateAndGet(int i10, IntUnaryOperator updateFunction) {
        int prev = get(i10);
        int next = 0;
        boolean haveNext = false;
        while (true) {
            if (!haveNext) {
                next = updateFunction.applyAsInt(prev);
            }
            if (weakCompareAndSetVolatile(i10, prev, next)) {
                return next;
            }
            int prev2 = get(i10);
            haveNext = prev == prev2;
            prev = prev2;
        }
    }

    public final int getAndAccumulate(int i10, int x10, IntBinaryOperator accumulatorFunction) {
        int prev = get(i10);
        int next = 0;
        boolean haveNext = false;
        while (true) {
            if (!haveNext) {
                next = accumulatorFunction.applyAsInt(prev, x10);
            }
            if (weakCompareAndSetVolatile(i10, prev, next)) {
                return prev;
            }
            int prev2 = get(i10);
            haveNext = prev == prev2;
            prev = prev2;
        }
    }

    public final int accumulateAndGet(int i10, int x10, IntBinaryOperator accumulatorFunction) {
        int prev = get(i10);
        int next = 0;
        boolean haveNext = false;
        while (true) {
            if (!haveNext) {
                next = accumulatorFunction.applyAsInt(prev, x10);
            }
            if (weakCompareAndSetVolatile(i10, prev, next)) {
                return next;
            }
            int prev2 = get(i10);
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

    public final int getPlain(int i10) {
        return (int) AA.get(this.array, i10);
    }

    public final void setPlain(int i10, int newValue) {
        (void) AA.set(this.array, i10, newValue);
    }

    public final int getOpaque(int i10) {
        return (int) AA.getOpaque(this.array, i10);
    }

    public final void setOpaque(int i10, int newValue) {
        (void) AA.setOpaque(this.array, i10, newValue);
    }

    public final int getAcquire(int i10) {
        return (int) AA.getAcquire(this.array, i10);
    }

    public final void setRelease(int i10, int newValue) {
        (void) AA.setRelease(this.array, i10, newValue);
    }

    public final int compareAndExchange(int i10, int expectedValue, int newValue) {
        return (int) AA.compareAndExchange(this.array, i10, expectedValue, newValue);
    }

    public final int compareAndExchangeAcquire(int i10, int expectedValue, int newValue) {
        return (int) AA.compareAndExchangeAcquire(this.array, i10, expectedValue, newValue);
    }

    public final int compareAndExchangeRelease(int i10, int expectedValue, int newValue) {
        return (int) AA.compareAndExchangeRelease(this.array, i10, expectedValue, newValue);
    }

    public final boolean weakCompareAndSetVolatile(int i10, int expectedValue, int newValue) {
        return (boolean) AA.weakCompareAndSet(this.array, i10, expectedValue, newValue);
    }

    public final boolean weakCompareAndSetAcquire(int i10, int expectedValue, int newValue) {
        return (boolean) AA.weakCompareAndSetAcquire(this.array, i10, expectedValue, newValue);
    }

    public final boolean weakCompareAndSetRelease(int i10, int expectedValue, int newValue) {
        return (boolean) AA.weakCompareAndSetRelease(this.array, i10, expectedValue, newValue);
    }
}
