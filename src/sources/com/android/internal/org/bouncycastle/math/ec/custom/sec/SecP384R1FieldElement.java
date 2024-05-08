package com.android.internal.org.bouncycastle.math.ec.custom.sec;

import com.android.internal.org.bouncycastle.math.ec.ECFieldElement;
import com.android.internal.org.bouncycastle.math.raw.Nat;
import com.android.internal.org.bouncycastle.util.Arrays;
import com.android.internal.org.bouncycastle.util.encoders.Hex;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SecP384R1FieldElement extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFF"));

    /* renamed from: x, reason: collision with root package name */
    protected int[] f9293x;

    public SecP384R1FieldElement(BigInteger x10) {
        if (x10 == null || x10.signum() < 0 || x10.compareTo(Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP384R1FieldElement");
        }
        this.f9293x = SecP384R1Field.fromBigInteger(x10);
    }

    public SecP384R1FieldElement() {
        this.f9293x = Nat.create(12);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SecP384R1FieldElement(int[] x10) {
        this.f9293x = x10;
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat.isZero(12, this.f9293x);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat.isOne(12, this.f9293x);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        return Nat.getBit(this.f9293x, 0) == 1;
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat.toBigInteger(12, this.f9293x);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public String getFieldName() {
        return "SecP384R1Field";
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return Q.bitLength();
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement b4) {
        int[] z10 = Nat.create(12);
        SecP384R1Field.add(this.f9293x, ((SecP384R1FieldElement) b4).f9293x, z10);
        return new SecP384R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] z10 = Nat.create(12);
        SecP384R1Field.addOne(this.f9293x, z10);
        return new SecP384R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement b4) {
        int[] z10 = Nat.create(12);
        SecP384R1Field.subtract(this.f9293x, ((SecP384R1FieldElement) b4).f9293x, z10);
        return new SecP384R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement b4) {
        int[] z10 = Nat.create(12);
        SecP384R1Field.multiply(this.f9293x, ((SecP384R1FieldElement) b4).f9293x, z10);
        return new SecP384R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement b4) {
        int[] z10 = Nat.create(12);
        SecP384R1Field.inv(((SecP384R1FieldElement) b4).f9293x, z10);
        SecP384R1Field.multiply(z10, this.f9293x, z10);
        return new SecP384R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] z10 = Nat.create(12);
        SecP384R1Field.negate(this.f9293x, z10);
        return new SecP384R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] z10 = Nat.create(12);
        SecP384R1Field.square(this.f9293x, z10);
        return new SecP384R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        int[] z10 = Nat.create(12);
        SecP384R1Field.inv(this.f9293x, z10);
        return new SecP384R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] x12 = this.f9293x;
        if (Nat.isZero(12, x12) || Nat.isOne(12, x12)) {
            return this;
        }
        int[] t12 = Nat.create(12);
        int[] t2 = Nat.create(12);
        int[] t32 = Nat.create(12);
        int[] t42 = Nat.create(12);
        SecP384R1Field.square(x12, t12);
        SecP384R1Field.multiply(t12, x12, t12);
        SecP384R1Field.squareN(t12, 2, t2);
        SecP384R1Field.multiply(t2, t12, t2);
        SecP384R1Field.square(t2, t2);
        SecP384R1Field.multiply(t2, x12, t2);
        SecP384R1Field.squareN(t2, 5, t32);
        SecP384R1Field.multiply(t32, t2, t32);
        SecP384R1Field.squareN(t32, 5, t42);
        SecP384R1Field.multiply(t42, t2, t42);
        SecP384R1Field.squareN(t42, 15, t2);
        SecP384R1Field.multiply(t2, t42, t2);
        SecP384R1Field.squareN(t2, 2, t32);
        SecP384R1Field.multiply(t12, t32, t12);
        SecP384R1Field.squareN(t32, 28, t32);
        SecP384R1Field.multiply(t2, t32, t2);
        SecP384R1Field.squareN(t2, 60, t32);
        SecP384R1Field.multiply(t32, t2, t32);
        SecP384R1Field.squareN(t32, 120, t2);
        SecP384R1Field.multiply(t2, t32, t2);
        SecP384R1Field.squareN(t2, 15, t2);
        SecP384R1Field.multiply(t2, t42, t2);
        SecP384R1Field.squareN(t2, 33, t2);
        SecP384R1Field.multiply(t2, t12, t2);
        SecP384R1Field.squareN(t2, 64, t2);
        SecP384R1Field.multiply(t2, x12, t2);
        SecP384R1Field.squareN(t2, 30, t12);
        SecP384R1Field.square(t12, t2);
        if (Nat.eq(12, x12, t2)) {
            return new SecP384R1FieldElement(t12);
        }
        return null;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SecP384R1FieldElement)) {
            return false;
        }
        SecP384R1FieldElement o10 = (SecP384R1FieldElement) other;
        return Nat.eq(12, this.f9293x, o10.f9293x);
    }

    public int hashCode() {
        return Q.hashCode() ^ Arrays.hashCode(this.f9293x, 0, 12);
    }
}
