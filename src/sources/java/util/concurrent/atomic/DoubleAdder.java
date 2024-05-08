package java.util.concurrent.atomic;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.Striped64;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DoubleAdder extends Striped64 implements Serializable {
    private static final long serialVersionUID = 7249069246863182397L;

    public void add(double x10) {
        int m10;
        Striped64.Cell c4;
        Striped64.Cell[] cs = this.cells;
        if (cs == null) {
            long b4 = this.base;
            if (casBase(b4, Double.doubleToRawLongBits(Double.longBitsToDouble(b4) + x10))) {
                return;
            }
        }
        int index = getProbe();
        boolean uncontended = true;
        if (cs != null && cs.length - 1 >= 0 && (c4 = cs[index & m10]) != null) {
            long v2 = c4.value;
            boolean cas = c4.cas(v2, Double.doubleToRawLongBits(Double.longBitsToDouble(v2) + x10));
            uncontended = cas;
            if (cas) {
                return;
            }
        }
        doubleAccumulate(x10, null, uncontended, index);
    }

    public double sum() {
        Striped64.Cell[] cs = this.cells;
        double sum = Double.longBitsToDouble(this.base);
        if (cs != null) {
            for (Striped64.Cell c4 : cs) {
                if (c4 != null) {
                    sum += Double.longBitsToDouble(c4.value);
                }
            }
        }
        return sum;
    }

    public void reset() {
        Striped64.Cell[] cs = this.cells;
        this.base = 0L;
        if (cs != null) {
            for (Striped64.Cell c4 : cs) {
                if (c4 != null) {
                    c4.reset();
                }
            }
        }
    }

    public double sumThenReset() {
        Striped64.Cell[] cs = this.cells;
        double sum = Double.longBitsToDouble(getAndSetBase(0L));
        if (cs != null) {
            for (Striped64.Cell c4 : cs) {
                if (c4 != null) {
                    sum += Double.longBitsToDouble(c4.getAndSet(0L));
                }
            }
        }
        return sum;
    }

    public String toString() {
        return Double.toString(sum());
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return sum();
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) sum();
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) sum();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) sum();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class SerializationProxy implements Serializable {
        private static final long serialVersionUID = 7249069246863182397L;
        private final double value;

        SerializationProxy(DoubleAdder a10) {
            this.value = a10.sum();
        }

        private Object readResolve() {
            DoubleAdder a10 = new DoubleAdder();
            a10.base = Double.doubleToRawLongBits(this.value);
            return a10;
        }
    }

    private Object writeReplace() {
        return new SerializationProxy(this);
    }

    private void readObject(ObjectInputStream s2) throws InvalidObjectException {
        throw new InvalidObjectException("Proxy required");
    }
}
