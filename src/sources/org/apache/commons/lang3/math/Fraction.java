package org.apache.commons.lang3.math;

import com.android.internal.logging.nano.MetricsProto;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.math.BigInteger;
import java.util.zip.ZipUtils;
import org.apache.commons.lang3.Validate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Fraction extends Number implements Comparable<Fraction> {
    private static final long serialVersionUID = 65382027393090L;
    private final int denominator;
    private final int numerator;
    public static final Fraction ZERO = new Fraction(0, 1);
    public static final Fraction ONE = new Fraction(1, 1);
    public static final Fraction ONE_HALF = new Fraction(1, 2);
    public static final Fraction ONE_THIRD = new Fraction(1, 3);
    public static final Fraction TWO_THIRDS = new Fraction(2, 3);
    public static final Fraction ONE_QUARTER = new Fraction(1, 4);
    public static final Fraction TWO_QUARTERS = new Fraction(2, 4);
    public static final Fraction THREE_QUARTERS = new Fraction(3, 4);
    public static final Fraction ONE_FIFTH = new Fraction(1, 5);
    public static final Fraction TWO_FIFTHS = new Fraction(2, 5);
    public static final Fraction THREE_FIFTHS = new Fraction(3, 5);
    public static final Fraction FOUR_FIFTHS = new Fraction(4, 5);
    private transient int hashCode = 0;
    private transient String toString = null;
    private transient String toProperString = null;

    private Fraction(int i10, int i11) {
        this.numerator = i10;
        this.denominator = i11;
    }

    private static int addAndCheck(int i10, int i11) {
        long j10 = i10 + i11;
        if (j10 < -2147483648L || j10 > ZipUtils.UPPER_UNIXTIME_BOUND) {
            throw new ArithmeticException("overflow: add");
        }
        return (int) j10;
    }

    private Fraction addSub(Fraction fraction, boolean z10) {
        Validate.isTrue(fraction != null, "The fraction must not be null", new Object[0]);
        if (this.numerator == 0) {
            return z10 ? fraction : fraction.negate();
        }
        if (fraction.numerator == 0) {
            return this;
        }
        int greatestCommonDivisor = greatestCommonDivisor(this.denominator, fraction.denominator);
        if (greatestCommonDivisor == 1) {
            int mulAndCheck = mulAndCheck(this.numerator, fraction.denominator);
            int mulAndCheck2 = mulAndCheck(fraction.numerator, this.denominator);
            return new Fraction(z10 ? addAndCheck(mulAndCheck, mulAndCheck2) : subAndCheck(mulAndCheck, mulAndCheck2), mulPosAndCheck(this.denominator, fraction.denominator));
        }
        BigInteger multiply = BigInteger.valueOf(this.numerator).multiply(BigInteger.valueOf(fraction.denominator / greatestCommonDivisor));
        BigInteger multiply2 = BigInteger.valueOf(fraction.numerator).multiply(BigInteger.valueOf(this.denominator / greatestCommonDivisor));
        BigInteger add = z10 ? multiply.add(multiply2) : multiply.subtract(multiply2);
        int intValue = add.mod(BigInteger.valueOf(greatestCommonDivisor)).intValue();
        int greatestCommonDivisor2 = intValue == 0 ? greatestCommonDivisor : greatestCommonDivisor(intValue, greatestCommonDivisor);
        BigInteger divide = add.divide(BigInteger.valueOf(greatestCommonDivisor2));
        if (divide.bitLength() <= 31) {
            return new Fraction(divide.intValue(), mulPosAndCheck(this.denominator / greatestCommonDivisor, fraction.denominator / greatestCommonDivisor2));
        }
        throw new ArithmeticException("overflow: numerator too large after multiply");
    }

    public static Fraction getFraction(int i10, int i11) {
        if (i11 != 0) {
            if (i11 < 0) {
                if (i10 == Integer.MIN_VALUE || i11 == Integer.MIN_VALUE) {
                    throw new ArithmeticException("overflow: can't negate");
                }
                i10 = -i10;
                i11 = -i11;
            }
            return new Fraction(i10, i11);
        }
        throw new ArithmeticException("The denominator must not be zero");
    }

    public static Fraction getReducedFraction(int i10, int i11) {
        if (i11 == 0) {
            throw new ArithmeticException("The denominator must not be zero");
        }
        if (i10 == 0) {
            return ZERO;
        }
        if (i11 == Integer.MIN_VALUE && (i10 & 1) == 0) {
            i10 /= 2;
            i11 /= 2;
        }
        if (i11 < 0) {
            if (i10 == Integer.MIN_VALUE || i11 == Integer.MIN_VALUE) {
                throw new ArithmeticException("overflow: can't negate");
            }
            i10 = -i10;
            i11 = -i11;
        }
        int greatestCommonDivisor = greatestCommonDivisor(i10, i11);
        return new Fraction(i10 / greatestCommonDivisor, i11 / greatestCommonDivisor);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0031, code lost:
    
        if (r3 != 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0033, code lost:
    
        r0 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003a, code lost:
    
        if ((r0 & 1) != 0) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003f, code lost:
    
        if (r0 <= 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0041, code lost:
    
        r6 = -r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0044, code lost:
    
        r0 = (r7 - r6) / 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0048, code lost:
    
        if (r0 != 0) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004f, code lost:
    
        return (-r6) * (1 << r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0043, code lost:
    
        r7 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x003c, code lost:
    
        r0 = r0 / 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0035, code lost:
    
        r0 = -(r6 / 2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int greatestCommonDivisor(int r6, int r7) {
        /*
            java.lang.String r0 = "overflow: gcd is 2^31"
            if (r6 == 0) goto L57
            if (r7 != 0) goto L7
            goto L57
        L7:
            int r1 = java.lang.Math.abs(r6)
            r2 = 1
            if (r1 == r2) goto L56
            int r1 = java.lang.Math.abs(r7)
            if (r1 != r2) goto L15
            goto L56
        L15:
            if (r6 <= 0) goto L18
            int r6 = -r6
        L18:
            if (r7 <= 0) goto L1b
            int r7 = -r7
        L1b:
            r1 = 0
        L1c:
            r3 = r6 & 1
            r4 = 31
            if (r3 != 0) goto L2f
            r5 = r7 & 1
            if (r5 != 0) goto L2f
            if (r1 >= r4) goto L2f
            int r6 = r6 / 2
            int r7 = r7 / 2
            int r1 = r1 + 1
            goto L1c
        L2f:
            if (r1 == r4) goto L50
            if (r3 != r2) goto L35
            r0 = r7
            goto L38
        L35:
            int r0 = r6 / 2
            int r0 = -r0
        L38:
            r3 = r0 & 1
            if (r3 != 0) goto L3f
            int r0 = r0 / 2
            goto L38
        L3f:
            if (r0 <= 0) goto L43
            int r6 = -r0
            goto L44
        L43:
            r7 = r0
        L44:
            int r0 = r7 - r6
            int r0 = r0 / 2
            if (r0 != 0) goto L38
            int r6 = -r6
            int r7 = r2 << r1
            int r6 = r6 * r7
            return r6
        L50:
            java.lang.ArithmeticException r6 = new java.lang.ArithmeticException
            r6.<init>(r0)
            throw r6
        L56:
            return r2
        L57:
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r6 == r1) goto L67
            if (r7 == r1) goto L67
            int r6 = java.lang.Math.abs(r6)
            int r7 = java.lang.Math.abs(r7)
            int r6 = r6 + r7
            return r6
        L67:
            java.lang.ArithmeticException r6 = new java.lang.ArithmeticException
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.math.Fraction.greatestCommonDivisor(int, int):int");
    }

    private static int mulAndCheck(int i10, int i11) {
        long j10 = i10 * i11;
        if (j10 < -2147483648L || j10 > ZipUtils.UPPER_UNIXTIME_BOUND) {
            throw new ArithmeticException("overflow: mul");
        }
        return (int) j10;
    }

    private static int mulPosAndCheck(int i10, int i11) {
        long j10 = i10 * i11;
        if (j10 <= ZipUtils.UPPER_UNIXTIME_BOUND) {
            return (int) j10;
        }
        throw new ArithmeticException("overflow: mulPos");
    }

    private static int subAndCheck(int i10, int i11) {
        long j10 = i10 - i11;
        if (j10 < -2147483648L || j10 > ZipUtils.UPPER_UNIXTIME_BOUND) {
            throw new ArithmeticException("overflow: add");
        }
        return (int) j10;
    }

    public Fraction abs() {
        return this.numerator >= 0 ? this : negate();
    }

    public Fraction add(Fraction fraction) {
        return addSub(fraction, true);
    }

    public Fraction divideBy(Fraction fraction) {
        Validate.isTrue(fraction != null, "The fraction must not be null", new Object[0]);
        if (fraction.numerator != 0) {
            return multiplyBy(fraction.invert());
        }
        throw new ArithmeticException("The fraction to divide by must not be zero");
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.numerator / this.denominator;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Fraction)) {
            return false;
        }
        Fraction fraction = (Fraction) obj;
        return getNumerator() == fraction.getNumerator() && getDenominator() == fraction.getDenominator();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.numerator / this.denominator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getProperNumerator() {
        return Math.abs(this.numerator % this.denominator);
    }

    public int getProperWhole() {
        return this.numerator / this.denominator;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = ((getNumerator() + MetricsProto.MetricsEvent.TEXT_LONGPRESS) * 37) + getDenominator();
        }
        return this.hashCode;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.numerator / this.denominator;
    }

    public Fraction invert() {
        int i10 = this.numerator;
        if (i10 == 0) {
            throw new ArithmeticException("Unable to invert zero.");
        }
        if (i10 == Integer.MIN_VALUE) {
            throw new ArithmeticException("overflow: can't negate numerator");
        }
        if (i10 < 0) {
            return new Fraction(-this.denominator, -i10);
        }
        return new Fraction(this.denominator, i10);
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.numerator / this.denominator;
    }

    public Fraction multiplyBy(Fraction fraction) {
        Validate.isTrue(fraction != null, "The fraction must not be null", new Object[0]);
        int i10 = this.numerator;
        if (i10 != 0 && fraction.numerator != 0) {
            int greatestCommonDivisor = greatestCommonDivisor(i10, fraction.denominator);
            int greatestCommonDivisor2 = greatestCommonDivisor(fraction.numerator, this.denominator);
            return getReducedFraction(mulAndCheck(this.numerator / greatestCommonDivisor, fraction.numerator / greatestCommonDivisor2), mulPosAndCheck(this.denominator / greatestCommonDivisor2, fraction.denominator / greatestCommonDivisor));
        }
        return ZERO;
    }

    public Fraction negate() {
        int i10 = this.numerator;
        if (i10 != Integer.MIN_VALUE) {
            return new Fraction(-i10, this.denominator);
        }
        throw new ArithmeticException("overflow: too large to negate");
    }

    public Fraction pow(int i10) {
        if (i10 == 1) {
            return this;
        }
        if (i10 == 0) {
            return ONE;
        }
        if (i10 < 0) {
            if (i10 == Integer.MIN_VALUE) {
                return invert().pow(2).pow(-(i10 / 2));
            }
            return invert().pow(-i10);
        }
        Fraction multiplyBy = multiplyBy(this);
        if (i10 % 2 == 0) {
            return multiplyBy.pow(i10 / 2);
        }
        return multiplyBy.pow(i10 / 2).multiplyBy(this);
    }

    public Fraction reduce() {
        int i10 = this.numerator;
        if (i10 == 0) {
            Fraction fraction = ZERO;
            return equals(fraction) ? this : fraction;
        }
        int greatestCommonDivisor = greatestCommonDivisor(Math.abs(i10), this.denominator);
        return greatestCommonDivisor == 1 ? this : getFraction(this.numerator / greatestCommonDivisor, this.denominator / greatestCommonDivisor);
    }

    public Fraction subtract(Fraction fraction) {
        return addSub(fraction, false);
    }

    public String toProperString() {
        if (this.toProperString == null) {
            int i10 = this.numerator;
            if (i10 == 0) {
                this.toProperString = "0";
            } else {
                int i11 = this.denominator;
                if (i10 == i11) {
                    this.toProperString = "1";
                } else if (i10 == i11 * (-1)) {
                    this.toProperString = "-1";
                } else {
                    if (i10 > 0) {
                        i10 = -i10;
                    }
                    if (i10 < (-i11)) {
                        int properNumerator = getProperNumerator();
                        if (properNumerator == 0) {
                            this.toProperString = Integer.toString(getProperWhole());
                        } else {
                            this.toProperString = getProperWhole() + " " + properNumerator + "/" + getDenominator();
                        }
                    } else {
                        this.toProperString = getNumerator() + "/" + getDenominator();
                    }
                }
            }
        }
        return this.toProperString;
    }

    public String toString() {
        if (this.toString == null) {
            this.toString = getNumerator() + "/" + getDenominator();
        }
        return this.toString;
    }

    @Override // java.lang.Comparable
    public int compareTo(Fraction fraction) {
        if (this == fraction) {
            return 0;
        }
        int i10 = this.numerator;
        int i11 = fraction.numerator;
        if (i10 == i11 && this.denominator == fraction.denominator) {
            return 0;
        }
        return Long.compare(i10 * fraction.denominator, i11 * this.denominator);
    }

    public static Fraction getFraction(int i10, int i11, int i12) {
        if (i12 == 0) {
            throw new ArithmeticException("The denominator must not be zero");
        }
        if (i12 < 0) {
            throw new ArithmeticException("The denominator must not be negative");
        }
        if (i11 < 0) {
            throw new ArithmeticException("The numerator must not be negative");
        }
        long j10 = i10 < 0 ? (i10 * i12) - i11 : (i10 * i12) + i11;
        if (j10 >= -2147483648L && j10 <= ZipUtils.UPPER_UNIXTIME_BOUND) {
            return new Fraction((int) j10, i12);
        }
        throw new ArithmeticException("Numerator too large to represent as an Integer.");
    }

    public static Fraction getFraction(double d10) {
        int i10;
        int i11;
        int i12 = d10 < ShadowDrawableWrapper.COS_45 ? -1 : 1;
        double abs = Math.abs(d10);
        if (abs > 2.147483647E9d || Double.isNaN(abs)) {
            throw new ArithmeticException("The value must not be greater than Integer.MAX_VALUE or NaN");
        }
        int i13 = (int) abs;
        double d11 = abs - i13;
        int i14 = (int) d11;
        double d12 = 1.0d;
        double d13 = d11 - i14;
        double d14 = Double.MAX_VALUE;
        int i15 = i12;
        int i16 = 1;
        int i17 = 0;
        int i18 = 0;
        int i19 = 1;
        int i20 = 1;
        while (true) {
            int i21 = (int) (d12 / d13);
            double d15 = d14;
            double d16 = d12 - (i21 * d13);
            int i22 = (i14 * i16) + i17;
            int i23 = (i14 * i18) + i19;
            d14 = Math.abs(d11 - (i22 / i23));
            i10 = i20 + 1;
            if (d15 <= d14 || i23 > 10000 || i23 <= 0) {
                break;
            }
            i11 = 25;
            if (i10 >= 25) {
                break;
            }
            i20 = i10;
            int i24 = i18;
            i18 = i23;
            i14 = i21;
            i17 = i16;
            i16 = i22;
            i19 = i24;
            d12 = d13;
            d13 = d16;
        }
        if (i10 != i11) {
            return getReducedFraction((i16 + (i13 * i18)) * i15, i18);
        }
        throw new ArithmeticException("Unable to convert double to fraction");
    }

    public static Fraction getFraction(String str) {
        Validate.isTrue(str != null, "The string must not be null", new Object[0]);
        if (str.indexOf(46) >= 0) {
            return getFraction(Double.parseDouble(str));
        }
        int indexOf = str.indexOf(32);
        if (indexOf > 0) {
            int parseInt = Integer.parseInt(str.substring(0, indexOf));
            String substring = str.substring(indexOf + 1);
            int indexOf2 = substring.indexOf(47);
            if (indexOf2 >= 0) {
                return getFraction(parseInt, Integer.parseInt(substring.substring(0, indexOf2)), Integer.parseInt(substring.substring(indexOf2 + 1)));
            }
            throw new NumberFormatException("The fraction could not be parsed as the format X Y/Z");
        }
        int indexOf3 = str.indexOf(47);
        if (indexOf3 < 0) {
            return getFraction(Integer.parseInt(str), 1);
        }
        return getFraction(Integer.parseInt(str.substring(0, indexOf3)), Integer.parseInt(str.substring(indexOf3 + 1)));
    }
}
