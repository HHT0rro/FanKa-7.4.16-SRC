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
public class SecP192K1FieldElement extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFEE37"));

    /* renamed from: x, reason: collision with root package name */
    protected int[] f9281x;

    public SecP192K1FieldElement(BigInteger x10) {
        if (x10 == null || x10.signum() < 0 || x10.compareTo(Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP192K1FieldElement");
        }
        this.f9281x = SecP192K1Field.fromBigInteger(x10);
    }

    public SecP192K1FieldElement() {
        this.f9281x = Nat192.create();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SecP192K1FieldElement(int[] x10) {
        this.f9281x = x10;
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat192.isZero(this.f9281x);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat192.isOne(this.f9281x);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        return Nat192.getBit(this.f9281x, 0) == 1;
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat192.toBigInteger(this.f9281x);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public String getFieldName() {
        return "SecP192K1Field";
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return Q.bitLength();
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement b4) {
        int[] z10 = Nat192.create();
        SecP192K1Field.add(this.f9281x, ((SecP192K1FieldElement) b4).f9281x, z10);
        return new SecP192K1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] z10 = Nat192.create();
        SecP192K1Field.addOne(this.f9281x, z10);
        return new SecP192K1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement b4) {
        int[] z10 = Nat192.create();
        SecP192K1Field.subtract(this.f9281x, ((SecP192K1FieldElement) b4).f9281x, z10);
        return new SecP192K1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement b4) {
        int[] z10 = Nat192.create();
        SecP192K1Field.multiply(this.f9281x, ((SecP192K1FieldElement) b4).f9281x, z10);
        return new SecP192K1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement b4) {
        int[] z10 = Nat192.create();
        SecP192K1Field.inv(((SecP192K1FieldElement) b4).f9281x, z10);
        SecP192K1Field.multiply(z10, this.f9281x, z10);
        return new SecP192K1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] z10 = Nat192.create();
        SecP192K1Field.negate(this.f9281x, z10);
        return new SecP192K1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] z10 = Nat192.create();
        SecP192K1Field.square(this.f9281x, z10);
        return new SecP192K1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        int[] z10 = Nat192.create();
        SecP192K1Field.inv(this.f9281x, z10);
        return new SecP192K1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] x12 = this.f9281x;
        if (Nat192.isZero(x12) || Nat192.isOne(x12)) {
            return this;
        }
        int[] x22 = Nat192.create();
        SecP192K1Field.square(x12, x22);
        SecP192K1Field.multiply(x22, x12, x22);
        int[] x32 = Nat192.create();
        SecP192K1Field.square(x22, x32);
        SecP192K1Field.multiply(x32, x12, x32);
        int[] x62 = Nat192.create();
        SecP192K1Field.squareN(x32, 3, x62);
        SecP192K1Field.multiply(x62, x32, x62);
        SecP192K1Field.squareN(x62, 2, x62);
        SecP192K1Field.multiply(x62, x22, x62);
        SecP192K1Field.squareN(x62, 8, x22);
        SecP192K1Field.multiply(x22, x62, x22);
        SecP192K1Field.squareN(x22, 3, x62);
        SecP192K1Field.multiply(x62, x32, x62);
        int[] x35 = Nat192.create();
        SecP192K1Field.squareN(x62, 16, x35);
        SecP192K1Field.multiply(x35, x22, x35);
        SecP192K1Field.squareN(x35, 35, x22);
        SecP192K1Field.multiply(x22, x35, x22);
        SecP192K1Field.squareN(x22, 70, x35);
        SecP192K1Field.multiply(x35, x22, x35);
        SecP192K1Field.squareN(x35, 19, x22);
        SecP192K1Field.multiply(x22, x62, x22);
        SecP192K1Field.squareN(x22, 20, x22);
        SecP192K1Field.multiply(x22, x62, x22);
        SecP192K1Field.squareN(x22, 4, x22);
        SecP192K1Field.multiply(x22, x32, x22);
        SecP192K1Field.squareN(x22, 6, x22);
        SecP192K1Field.multiply(x22, x32, x22);
        SecP192K1Field.square(x22, x22);
        SecP192K1Field.square(x22, x32);
        if (Nat192.eq(x12, x32)) {
            return new SecP192K1FieldElement(x22);
        }
        return null;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SecP192K1FieldElement)) {
            return false;
        }
        SecP192K1FieldElement o10 = (SecP192K1FieldElement) other;
        return Nat192.eq(this.f9281x, o10.f9281x);
    }

    public int hashCode() {
        return Q.hashCode() ^ Arrays.hashCode(this.f9281x, 0, 6);
    }
}
