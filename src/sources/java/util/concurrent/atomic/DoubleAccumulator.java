package java.util.concurrent.atomic;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.Striped64;
import java.util.function.DoubleBinaryOperator;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DoubleAccumulator extends Striped64 implements Serializable {
    private static final long serialVersionUID = 7249069246863182397L;
    private final DoubleBinaryOperator function;
    private final long identity;

    public DoubleAccumulator(DoubleBinaryOperator accumulatorFunction, double identity) {
        this.function = accumulatorFunction;
        long doubleToRawLongBits = Double.doubleToRawLongBits(identity);
        this.identity = doubleToRawLongBits;
        this.base = doubleToRawLongBits;
    }

    public void accumulate(double x10) {
        boolean uncontended;
        Striped64.Cell c4;
        Striped64.Cell[] cs = this.cells;
        if (cs == null) {
            DoubleBinaryOperator doubleBinaryOperator = this.function;
            long b4 = this.base;
            long r10 = Double.doubleToRawLongBits(doubleBinaryOperator.applyAsDouble(Double.longBitsToDouble(b4), x10));
            if (r10 == b4 || casBase(b4, r10)) {
                return;
            }
        }
        int index = getProbe();
        if (cs != null) {
            boolean z10 = true;
            int m10 = cs.length - 1;
            if (m10 >= 0 && (c4 = cs[index & m10]) != null) {
                DoubleBinaryOperator doubleBinaryOperator2 = this.function;
                long v2 = c4.value;
                long r11 = Double.doubleToRawLongBits(doubleBinaryOperator2.applyAsDouble(Double.longBitsToDouble(v2), x10));
                if (r11 != v2 && !c4.cas(v2, r11)) {
                    z10 = false;
                }
                boolean uncontended2 = z10;
                if (!z10) {
                    uncontended = uncontended2;
                    doubleAccumulate(x10, this.function, uncontended, index);
                }
                return;
            }
        }
        uncontended = true;
        doubleAccumulate(x10, this.function, uncontended, index);
    }

    public double get() {
        Striped64.Cell[] cs = this.cells;
        double result = Double.longBitsToDouble(this.base);
        if (cs != null) {
            for (Striped64.Cell c4 : cs) {
                if (c4 != null) {
                    result = this.function.applyAsDouble(result, Double.longBitsToDouble(c4.value));
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

    public double getThenReset() {
        Striped64.Cell[] cs = this.cells;
        double result = Double.longBitsToDouble(getAndSetBase(this.identity));
        if (cs != null) {
            for (Striped64.Cell c4 : cs) {
                if (c4 != null) {
                    double v2 = Double.longBitsToDouble(c4.getAndSet(this.identity));
                    result = this.function.applyAsDouble(result, v2);
                }
            }
        }
        return result;
    }

    public String toString() {
        return Double.toString(get());
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return get();
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) get();
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) get();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) get();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class SerializationProxy implements Serializable {
        private static final long serialVersionUID = 7249069246863182397L;
        private final DoubleBinaryOperator function;
        private final long identity;
        private final double value;

        SerializationProxy(double value, DoubleBinaryOperator function, long identity) {
            this.value = value;
            this.function = function;
            this.identity = identity;
        }

        private Object readResolve() {
            double d10 = Double.longBitsToDouble(this.identity);
            DoubleAccumulator a10 = new DoubleAccumulator(this.function, d10);
            a10.base = Double.doubleToRawLongBits(this.value);
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
