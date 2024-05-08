package com.android.internal.org.bouncycastle.math.ec;

import java.math.BigInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SimpleBigDecimal {
    private static final long serialVersionUID = 1;
    private final BigInteger bigInt;
    private final int scale;

    public static SimpleBigDecimal getInstance(BigInteger value, int scale) {
        return new SimpleBigDecimal(value.shiftLeft(scale), scale);
    }

    public SimpleBigDecimal(BigInteger bigInt, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("scale may not be negative");
        }
        this.bigInt = bigInt;
        this.scale = scale;
    }

    private void checkScale(SimpleBigDecimal b4) {
        if (this.scale != b4.scale) {
            throw new IllegalArgumentException("Only SimpleBigDecimal of same scale allowed in arithmetic operations");
        }
    }

    public SimpleBigDecimal adjustScale(int newScale) {
        if (newScale < 0) {
            throw new IllegalArgumentException("scale may not be negative");
        }
        int i10 = this.scale;
        if (newScale == i10) {
            return this;
        }
        return new SimpleBigDecimal(this.bigInt.shiftLeft(newScale - i10), newScale);
    }

    public SimpleBigDecimal add(SimpleBigDecimal b4) {
        checkScale(b4);
        return new SimpleBigDecimal(this.bigInt.add(b4.bigInt), this.scale);
    }

    public SimpleBigDecimal add(BigInteger b4) {
        return new SimpleBigDecimal(this.bigInt.add(b4.shiftLeft(this.scale)), this.scale);
    }

    public SimpleBigDecimal negate() {
        return new SimpleBigDecimal(this.bigInt.negate(), this.scale);
    }

    public SimpleBigDecimal subtract(SimpleBigDecimal b4) {
        return add(b4.negate());
    }

    public SimpleBigDecimal subtract(BigInteger b4) {
        return new SimpleBigDecimal(this.bigInt.subtract(b4.shiftLeft(this.scale)), this.scale);
    }

    public SimpleBigDecimal multiply(SimpleBigDecimal b4) {
        checkScale(b4);
        BigInteger multiply = this.bigInt.multiply(b4.bigInt);
        int i10 = this.scale;
        return new SimpleBigDecimal(multiply, i10 + i10);
    }

    public SimpleBigDecimal multiply(BigInteger b4) {
        return new SimpleBigDecimal(this.bigInt.multiply(b4), this.scale);
    }

    public SimpleBigDecimal divide(SimpleBigDecimal b4) {
        checkScale(b4);
        BigInteger dividend = this.bigInt.shiftLeft(this.scale);
        return new SimpleBigDecimal(dividend.divide(b4.bigInt), this.scale);
    }

    public SimpleBigDecimal divide(BigInteger b4) {
        return new SimpleBigDecimal(this.bigInt.divide(b4), this.scale);
    }

    public SimpleBigDecimal shiftLeft(int n10) {
        return new SimpleBigDecimal(this.bigInt.shiftLeft(n10), this.scale);
    }

    public int compareTo(SimpleBigDecimal val) {
        checkScale(val);
        return this.bigInt.compareTo(val.bigInt);
    }

    public int compareTo(BigInteger val) {
        return this.bigInt.compareTo(val.shiftLeft(this.scale));
    }

    public BigInteger floor() {
        return this.bigInt.shiftRight(this.scale);
    }

    public BigInteger round() {
        SimpleBigDecimal oneHalf = new SimpleBigDecimal(ECConstants.ONE, 1);
        return add(oneHalf.adjustScale(this.scale)).floor();
    }

    public int intValue() {
        return floor().intValue();
    }

    public long longValue() {
        return floor().longValue();
    }

    public int getScale() {
        return this.scale;
    }

    public String toString() {
        if (this.scale == 0) {
            return this.bigInt.toString();
        }
        BigInteger floorBigInt = floor();
        BigInteger fract = this.bigInt.subtract(floorBigInt.shiftLeft(this.scale));
        if (this.bigInt.signum() == -1) {
            fract = ECConstants.ONE.shiftLeft(this.scale).subtract(fract);
        }
        if (floorBigInt.signum() == -1 && !fract.equals(ECConstants.ZERO)) {
            floorBigInt = floorBigInt.add(ECConstants.ONE);
        }
        String leftOfPoint = floorBigInt.toString();
        char[] fractCharArr = new char[this.scale];
        String fractStr = fract.toString(2);
        int fractLen = fractStr.length();
        int zeroes = this.scale - fractLen;
        for (int i10 = 0; i10 < zeroes; i10++) {
            fractCharArr[i10] = '0';
        }
        for (int j10 = 0; j10 < fractLen; j10++) {
            fractCharArr[zeroes + j10] = fractStr.charAt(j10);
        }
        String rightOfPoint = new String(fractCharArr);
        StringBuffer sb2 = new StringBuffer(leftOfPoint);
        sb2.append(".");
        sb2.append(rightOfPoint);
        return sb2.toString();
    }

    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (!(o10 instanceof SimpleBigDecimal)) {
            return false;
        }
        SimpleBigDecimal other = (SimpleBigDecimal) o10;
        return this.bigInt.equals(other.bigInt) && this.scale == other.scale;
    }

    public int hashCode() {
        return this.bigInt.hashCode() ^ this.scale;
    }
}
