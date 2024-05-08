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
public class SecP256K1FieldElement extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F"));

    /* renamed from: x, reason: collision with root package name */
    protected int[] f9289x;

    public SecP256K1FieldElement(BigInteger x10) {
        if (x10 == null || x10.signum() < 0 || x10.compareTo(Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP256K1FieldElement");
        }
        this.f9289x = SecP256K1Field.fromBigInteger(x10);
    }

    public SecP256K1FieldElement() {
        this.f9289x = Nat256.create();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SecP256K1FieldElement(int[] x10) {
        this.f9289x = x10;
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat256.isZero(this.f9289x);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat256.isOne(this.f9289x);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        return Nat256.getBit(this.f9289x, 0) == 1;
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat256.toBigInteger(this.f9289x);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public String getFieldName() {
        return "SecP256K1Field";
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return Q.bitLength();
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement b4) {
        int[] z10 = Nat256.create();
        SecP256K1Field.add(this.f9289x, ((SecP256K1FieldElement) b4).f9289x, z10);
        return new SecP256K1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] z10 = Nat256.create();
        SecP256K1Field.addOne(this.f9289x, z10);
        return new SecP256K1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement b4) {
        int[] z10 = Nat256.create();
        SecP256K1Field.subtract(this.f9289x, ((SecP256K1FieldElement) b4).f9289x, z10);
        return new SecP256K1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement b4) {
        int[] z10 = Nat256.create();
        SecP256K1Field.multiply(this.f9289x, ((SecP256K1FieldElement) b4).f9289x, z10);
        return new SecP256K1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement b4) {
        int[] z10 = Nat256.create();
        SecP256K1Field.inv(((SecP256K1FieldElement) b4).f9289x, z10);
        SecP256K1Field.multiply(z10, this.f9289x, z10);
        return new SecP256K1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] z10 = Nat256.create();
        SecP256K1Field.negate(this.f9289x, z10);
        return new SecP256K1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] z10 = Nat256.create();
        SecP256K1Field.square(this.f9289x, z10);
        return new SecP256K1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        int[] z10 = Nat256.create();
        SecP256K1Field.inv(this.f9289x, z10);
        return new SecP256K1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] x12 = this.f9289x;
        if (Nat256.isZero(x12) || Nat256.isOne(x12)) {
            return this;
        }
        int[] x22 = Nat256.create();
        SecP256K1Field.square(x12, x22);
        SecP256K1Field.multiply(x22, x12, x22);
        int[] x32 = Nat256.create();
        SecP256K1Field.square(x22, x32);
        SecP256K1Field.multiply(x32, x12, x32);
        int[] x62 = Nat256.create();
        SecP256K1Field.squareN(x32, 3, x62);
        SecP256K1Field.multiply(x62, x32, x62);
        SecP256K1Field.squareN(x62, 3, x62);
        SecP256K1Field.multiply(x62, x32, x62);
        SecP256K1Field.squareN(x62, 2, x62);
        SecP256K1Field.multiply(x62, x22, x62);
        int[] x222 = Nat256.create();
        SecP256K1Field.squareN(x62, 11, x222);
        SecP256K1Field.multiply(x222, x62, x222);
        SecP256K1Field.squareN(x222, 22, x62);
        SecP256K1Field.multiply(x62, x222, x62);
        int[] x88 = Nat256.create();
        SecP256K1Field.squareN(x62, 44, x88);
        SecP256K1Field.multiply(x88, x62, x88);
        int[] x176 = Nat256.create();
        SecP256K1Field.squareN(x88, 88, x176);
        SecP256K1Field.multiply(x176, x88, x176);
        SecP256K1Field.squareN(x176, 44, x88);
        SecP256K1Field.multiply(x88, x62, x88);
        SecP256K1Field.squareN(x88, 3, x62);
        SecP256K1Field.multiply(x62, x32, x62);
        SecP256K1Field.squareN(x62, 23, x62);
        SecP256K1Field.multiply(x62, x222, x62);
        SecP256K1Field.squareN(x62, 6, x62);
        SecP256K1Field.multiply(x62, x22, x62);
        SecP256K1Field.squareN(x62, 2, x62);
        SecP256K1Field.square(x62, x22);
        if (Nat256.eq(x12, x22)) {
            return new SecP256K1FieldElement(x62);
        }
        return null;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SecP256K1FieldElement)) {
            return false;
        }
        SecP256K1FieldElement o10 = (SecP256K1FieldElement) other;
        return Nat256.eq(this.f9289x, o10.f9289x);
    }

    public int hashCode() {
        return Q.hashCode() ^ Arrays.hashCode(this.f9289x, 0, 8);
    }
}
