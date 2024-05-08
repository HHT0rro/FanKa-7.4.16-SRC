package java.util.concurrent.atomic;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.Striped64;
import java.util.function.LongBinaryOperator;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class LongAccumulator extends Striped64 implements Serializable {
    private static final long serialVersionUID = 7249069246863182397L;
    private final LongBinaryOperator function;
    private final long identity;

    public LongAccumulator(LongBinaryOperator accumulatorFunction, long identity) {
        this.function = accumulatorFunction;
        this.identity = identity;
        this.base = identity;
    }

    public void accumulate(long x10) {
        boolean uncontended;
        Striped64.Cell c4;
        Striped64.Cell[] cs = this.cells;
        if (cs == null) {
            LongBinaryOperator longBinaryOperator = this.function;
            long b4 = this.base;
            long r10 = longBinaryOperator.applyAsLong(b4, x10);
            if (r10 == b4 || casBase(b4, r10)) {
                return;
            }
        }
        int index = getProbe();
        if (cs != null) {
            boolean z10 = true;
            int m10 = cs.length - 1;
            if (m10 >= 0 && (c4 = cs[index & m10]) != null) {
                LongBinaryOperator longBinaryOperator2 = this.function;
                long v2 = c4.value;
                long r11 = longBinaryOperator2.applyAsLong(v2, x10);
                if (r11 != v2 && !c4.cas(v2, r11)) {
                    z10 = false;
                }
                boolean uncontended2 = z10;
                if (!z10) {
                    uncontended = uncontended2;
                    longAccumulate(x10, this.function, uncontended, index);
                }
                return;
            }
        }
        uncontended = true;
        longAccumulate(x10, this.function, uncontended, index);
    }

    public long get() {
        Striped64.Cell[] cs = this.cells;
        long result = this.base;
        if (cs != null) {
            for (Striped64.Cell c4 : cs) {
                if (c4 != null) {
                    result = this.function.applyAsLong(result, c4.value);
                }
            }
        }
        return result;
    }

    public void reset() {
        Striped64.Cell[] cs = this.cells;
        this.base = this.identity;
        if (cs != null) {
            for (Striped64.Cell c4 : cs) {
                if (c4 != null) {
                    c4.reset(this.identity);
                }
            }
        }
    }

    public long getThenReset() {
        Striped64.Cell[] cs = this.cells;
        long result = getAndSetBase(this.identity);
        if (cs != null) {
            for (Striped64.Cell c4 : cs) {
                if (c4 != null) {
                    long v2 = c4.getAndSet(this.identity);
                    result = this.function.applyAsLong(result, v2);
                }
            }
        }
        return result;
    }

    public String toString() {
        return Long.toString(get());
    }

    @Override // java.lang.Number
    public long longValue() {
        return get();
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) get();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) get();
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return get();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class SerializationProxy implements Serializable {
        private static final long serialVersionUID = 7249069246863182397L;
        private final LongBinaryOperator function;
        private final long identity;
        private final long value;

        SerializationProxy(long value, LongBinaryOperator function, long identity) {
            this.value = value;
            this.function = function;
            this.identity = identity;
        }

        private Object readResolve() {
            LongAccumulator a10 = new LongAccumulator(this.function, this.identity);
            a10.base = this.value;
            return a10;
        }
    }

    private Object writeReplace() {
        return new SerializationProxy(get(), this.function, this.identity);
    }

    private void readObject(ObjectInputStream s2) throws InvalidObjectException {
        throw new InvalidObjectException("Proxy required");
    }
}
