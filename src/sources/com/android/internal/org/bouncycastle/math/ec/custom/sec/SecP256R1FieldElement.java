package com.android.internal.org.bouncycastle.math.ec.custom.sec;

import com.android.internal.org.bouncycastle.math.ec.ECFieldElement;
import com.android.internal.org.bouncycastle.math.raw.Nat256;
import com.android.internal.org.bouncycastle.util.Arrays;
import com.android.internal.org.bouncycastle.util.encoders.Hex;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SecP256R1FieldElement extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFF"));

    /* renamed from: x, reason: collision with root package name */
    protected int[] f9291x;

    public SecP256R1FieldElement(BigInteger x10) {
        if (x10 == null || x10.signum() < 0 || x10.compareTo(Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP256R1FieldElement");
        }
        this.f9291x = SecP256R1Field.fromBigInteger(x10);
    }

    public SecP256R1FieldElement() {
        this.f9291x = Nat256.create();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SecP256R1FieldElement(int[] x10) {
        this.f9291x = x10;
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat256.isZero(this.f9291x);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat256.isOne(this.f9291x);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        return Nat256.getBit(this.f9291x, 0) == 1;
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat256.toBigInteger(this.f9291x);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public String getFieldName() {
        return "SecP256R1Field";
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return Q.bitLength();
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement b4) {
        int[] z10 = Nat256.create();
        SecP256R1Field.add(this.f9291x, ((SecP256R1FieldElement) b4).f9291x, z10);
        return new SecP256R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] z10 = Nat256.create();
        SecP256R1Field.addOne(this.f9291x, z10);
        return new SecP256R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement b4) {
        int[] z10 = Nat256.create();
        SecP256R1Field.subtract(this.f9291x, ((SecP256R1FieldElement) b4).f9291x, z10);
        return new SecP256R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement b4) {
        int[] z10 = Nat256.create();
        SecP256R1Field.multiply(this.f9291x, ((SecP256R1FieldElement) b4).f9291x, z10);
        return new SecP256R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement b4) {
        int[] z10 = Nat256.create();
        SecP256R1Field.inv(((SecP256R1FieldElement) b4).f9291x, z10);
        SecP256R1Field.multiply(z10, this.f9291x, z10);
        return new SecP256R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] z10 = Nat256.create();
        SecP256R1Field.negate(this.f9291x, z10);
        return new SecP256R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] z10 = Nat256.create();
        SecP256R1Field.square(this.f9291x, z10);
        return new SecP256R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        int[] z10 = Nat256.create();
        SecP256R1Field.inv(this.f9291x, z10);
        return new SecP256R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] x12 = this.f9291x;
        if (Nat256.isZero(x12) || Nat256.isOne(x12)) {
            return this;
        }
        int[] t12 = Nat256.create();
        int[] t2 = Nat256.create();
        SecP256R1Field.square(x12, t12);
        SecP256R1Field.multiply(t12, x12, t12);
        SecP256R1Field.squareN(t12, 2, t2);
        SecP256R1Field.multiply(t2, t12, t2);
        SecP256R1Field.squareN(t2, 4, t12);
        SecP256R1Field.multiply(t12, t2, t12);
        SecP256R1Field.squareN(t12, 8, t2);
        SecP256R1Field.multiply(t2, t12, t2);
        SecP256R1Field.squareN(t2, 16, t12);
        SecP256R1Field.multiply(t12, t2, t12);
        SecP256R1Field.squareN(t12, 32, t12);
        SecP256R1Field.multiply(t12, x12, t12);
        SecP256R1Field.squareN(t12, 96, t12);
        SecP256R1Field.multiply(t12, x12, t12);
        SecP256R1Field.squareN(t12, 94, t12);
        SecP256R1Field.square(t12, t2);
        if (Nat256.eq(x12, t2)) {
            return new SecP256R1FieldElement(t12);
        }
        return null;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SecP256R1FieldElement)) {
            return false;
        }
        SecP256R1FieldElement o10 = (SecP256R1FieldElement) other;
        return Nat256.eq(this.f9291x, o10.f9291x);
    }

    public int hashCode() {
        return Q.hashCode() ^ Arrays.hashCode(this.f9291x, 0, 8);
    }
}
