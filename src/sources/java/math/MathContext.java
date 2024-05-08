package java.math;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class MathContext implements Serializable {
    private static final int DEFAULT_DIGITS = 9;
    private static final int MIN_DIGITS = 0;
    private static final long serialVersionUID = 5579720004786848255L;
    final int precision;
    final RoundingMode roundingMode;
    private static final RoundingMode DEFAULT_ROUNDINGMODE = RoundingMode.HALF_UP;
    public static final MathContext UNLIMITED = new MathContext(0, RoundingMode.HALF_UP);
    public static final MathContext DECIMAL32 = new MathContext(7, RoundingMode.HALF_EVEN);
    public static final MathContext DECIMAL64 = new MathContext(16, RoundingMode.HALF_EVEN);
    public static final MathContext DECIMAL128 = new MathContext(34, RoundingMode.HALF_EVEN);

    public MathContext(int setPrecision) {
        this(setPrecision, DEFAULT_ROUNDINGMODE);
    }

    public MathContext(int setPrecision, RoundingMode setRoundingMode) {
        if (setPrecision < 0) {
            throw new IllegalArgumentException("Digits < 0");
        }
        if (setRoundingMode == null) {
            throw new NullPointerException("null RoundingMode");
        }
        this.precision = setPrecision;
        this.roundingMode = setRoundingMode;
    }

    public MathContext(String val) {
        if (val == null) {
            throw new NullPointerException("null String");
        }
        try {
            if (!val.startsWith("precision=")) {
                throw new RuntimeException();
            }
            int fence = val.indexOf(32);
            int setPrecision = Integer.parseInt(val.substring(10, fence));
            if (!val.startsWith("roundingMode=", fence + 1)) {
                throw new RuntimeException();
            }
            int off = fence + 1 + 13;
            int off2 = val.length();
            String str = val.substring(off, off2);
            this.roundingMode = RoundingMode.valueOf(str);
            if (setPrecision < 0) {
                throw new IllegalArgumentException("Digits < 0");
            }
            this.precision = setPrecision;
        } catch (RuntimeException e2) {
            throw new IllegalArgumentException("bad string format");
        }
    }

    public int getPrecision() {
        return this.precision;
    }

    public RoundingMode getRoundingMode() {
        return this.roundingMode;
    }

    public boolean equals(Object x10) {
        if (!(x10 instanceof MathContext)) {
            return false;
        }
        MathContext mc2 = (MathContext) x10;
        return mc2.precision == this.precision && mc2.roundingMode == this.roundingMode;
    }

    public int hashCode() {
        return this.precision + (this.roundingMode.hashCode() * 59);
    }

    public String toString() {
        return "precision=" + this.precision + " roundingMode=" + this.roundingMode.toString();
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        s2.defaultReadObject();
        if (this.precision < 0) {
            throw new StreamCorruptedException("MathContext: invalid digits in stream");
        }
        if (this.roundingMode == null) {
            throw new StreamCorruptedException("MathContext: null roundingMode in stream");
        }
    }
}
