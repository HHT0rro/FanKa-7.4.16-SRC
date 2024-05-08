package com.android.internal.org.bouncycastle.math.ec.custom.sec;

import com.android.internal.org.bouncycastle.math.ec.ECFieldElement;
import com.android.internal.org.bouncycastle.math.raw.Nat192;
import com.android.internal.org.bouncycastle.util.Arrays;
import com.android.internal.org.bouncycastle.util.encoders.Hex;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SecP192R1FieldElement extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFF"));

    /* renamed from: x, reason: collision with root package name */
    protected int[] f9283x;

    public SecP192R1FieldElement(BigInteger x10) {
        if (x10 == null || x10.signum() < 0 || x10.compareTo(Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP192R1FieldElement");
        }
        this.f9283x = SecP192R1Field.fromBigInteger(x10);
    }

    public SecP192R1FieldElement() {
        this.f9283x = Nat192.create();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SecP192R1FieldElement(int[] x10) {
        this.f9283x = x10;
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat192.isZero(this.f9283x);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat192.isOne(this.f9283x);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        return Nat192.getBit(this.f9283x, 0) == 1;
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat192.toBigInteger(this.f9283x);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public String getFieldName() {
        return "SecP192R1Field";
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return Q.bitLength();
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement b4) {
        int[] z10 = Nat192.create();
        SecP192R1Field.add(this.f9283x, ((SecP192R1FieldElement) b4).f9283x, z10);
        return new SecP192R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] z10 = Nat192.create();
        SecP192R1Field.addOne(this.f9283x, z10);
        return new SecP192R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement b4) {
        int[] z10 = Nat192.create();
        SecP192R1Field.subtract(this.f9283x, ((SecP192R1FieldElement) b4).f9283x, z10);
        return new SecP192R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement b4) {
        int[] z10 = Nat192.create();
        SecP192R1Field.multiply(this.f9283x, ((SecP192R1FieldElement) b4).f9283x, z10);
        return new SecP192R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement b4) {
        int[] z10 = Nat192.create();
        SecP192R1Field.inv(((SecP192R1FieldElement) b4).f9283x, z10);
        SecP192R1Field.multiply(z10, this.f9283x, z10);
        return new SecP192R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] z10 = Nat192.create();
        SecP192R1Field.negate(this.f9283x, z10);
        return new SecP192R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] z10 = Nat192.create();
        SecP192R1Field.square(this.f9283x, z10);
        return new SecP192R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        int[] z10 = Nat192.create();
        SecP192R1Field.inv(this.f9283x, z10);
        return new SecP192R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] x12 = this.f9283x;
        if (Nat192.isZero(x12) || Nat192.isOne(x12)) {
            return this;
        }
        int[] t12 = Nat192.create();
        int[] t2 = Nat192.create();
        SecP192R1Field.square(x12, t12);
        SecP192R1Field.multiply(t12, x12, t12);
        SecP192R1Field.squareN(t12, 2, t2);
        SecP192R1Field.multiply(t2, t12, t2);
        SecP192R1Field.squareN(t2, 4, t12);
        SecP192R1Field.multiply(t12, t2, t12);
        SecP192R1Field.squareN(t12, 8, t2);
        SecP192R1Field.multiply(t2, t12, t2);
        SecP192R1Field.squareN(t2, 16, t12);
        SecP192R1Field.multiply(t12, t2, t12);
        SecP192R1Field.squareN(t12, 32, t2);
        SecP192R1Field.multiply(t2, t12, t2);
        SecP192R1Field.squareN(t2, 64, t12);
        SecP192R1Field.multiply(t12, t2, t12);
        SecP192R1Field.squareN(t12, 62, t12);
        SecP192R1Field.square(t12, t2);
        if (Nat192.eq(x12, t2)) {
            return new SecP192R1FieldElement(t12);
        }
        return null;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SecP192R1FieldElement)) {
            return false;
        }
        SecP192R1FieldElement o10 = (SecP192R1FieldElement) other;
        return Nat192.eq(this.f9283x, o10.f9283x);
    }

    public int hashCode() {
        return Q.hashCode() ^ Arrays.hashCode(this.f9283x, 0, 6);
    }
}
