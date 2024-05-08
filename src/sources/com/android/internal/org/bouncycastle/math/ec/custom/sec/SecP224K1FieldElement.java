package com.android.internal.org.bouncycastle.math.ec.custom.sec;

import com.android.internal.org.bouncycastle.math.ec.ECFieldElement;
import com.android.internal.org.bouncycastle.math.raw.Nat224;
import com.android.internal.org.bouncycastle.util.Arrays;
import com.android.internal.org.bouncycastle.util.encoders.Hex;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SecP224K1FieldElement extends ECFieldElement.AbstractFp {

    /* renamed from: x, reason: collision with root package name */
    protected int[] f9285x;
    public static final BigInteger Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFE56D"));
    private static final int[] PRECOMP_POW2 = {868209154, -587542221, 579297866, -1014948952, -1470801668, 514782679, -1897982644};

    public SecP224K1FieldElement(BigInteger x10) {
        if (x10 == null || x10.signum() < 0 || x10.compareTo(Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP224K1FieldElement");
        }
        this.f9285x = SecP224K1Field.fromBigInteger(x10);
    }

    public SecP224K1FieldElement() {
        this.f9285x = Nat224.create();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SecP224K1FieldElement(int[] x10) {
        this.f9285x = x10;
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat224.isZero(this.f9285x);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat224.isOne(this.f9285x);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        return Nat224.getBit(this.f9285x, 0) == 1;
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat224.toBigInteger(this.f9285x);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public String getFieldName() {
        return "SecP224K1Field";
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return Q.bitLength();
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement b4) {
        int[] z10 = Nat224.create();
        SecP224K1Field.add(this.f9285x, ((SecP224K1FieldElement) b4).f9285x, z10);
        return new SecP224K1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] z10 = Nat224.create();
        SecP224K1Field.addOne(this.f9285x, z10);
        return new SecP224K1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement b4) {
        int[] z10 = Nat224.create();
        SecP224K1Field.subtract(this.f9285x, ((SecP224K1FieldElement) b4).f9285x, z10);
        return new SecP224K1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement b4) {
        int[] z10 = Nat224.create();
        SecP224K1Field.multiply(this.f9285x, ((SecP224K1FieldElement) b4).f9285x, z10);
        return new SecP224K1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement b4) {
        int[] z10 = Nat224.create();
        SecP224K1Field.inv(((SecP224K1FieldElement) b4).f9285x, z10);
        SecP224K1Field.multiply(z10, this.f9285x, z10);
        return new SecP224K1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] z10 = Nat224.create();
        SecP224K1Field.negate(this.f9285x, z10);
        return new SecP224K1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] z10 = Nat224.create();
        SecP224K1Field.square(this.f9285x, z10);
        return new SecP224K1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        int[] z10 = Nat224.create();
        SecP224K1Field.inv(this.f9285x, z10);
        return new SecP224K1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] x12 = this.f9285x;
        if (Nat224.isZero(x12) || Nat224.isOne(x12)) {
            return this;
        }
        int[] x22 = Nat224.create();
        SecP224K1Field.square(x12, x22);
        SecP224K1Field.multiply(x22, x12, x22);
        SecP224K1Field.square(x22, x22);
        SecP224K1Field.multiply(x22, x12, x22);
        int[] x42 = Nat224.create();
        SecP224K1Field.square(x22, x42);
        SecP224K1Field.multiply(x42, x12, x42);
        int[] x82 = Nat224.create();
        SecP224K1Field.squareN(x42, 4, x82);
        SecP224K1Field.multiply(x82, x42, x82);
        int[] x11 = Nat224.create();
        SecP224K1Field.squareN(x82, 3, x11);
        SecP224K1Field.multiply(x11, x22, x11);
        SecP224K1Field.squareN(x11, 8, x11);
        SecP224K1Field.multiply(x11, x82, x11);
        SecP224K1Field.squareN(x11, 4, x82);
        SecP224K1Field.multiply(x82, x42, x82);
        SecP224K1Field.squareN(x82, 19, x42);
        SecP224K1Field.multiply(x42, x11, x42);
        int[] x84 = Nat224.create();
        SecP224K1Field.squareN(x42, 42, x84);
        SecP224K1Field.multiply(x84, x42, x84);
        SecP224K1Field.squareN(x84, 23, x42);
        SecP224K1Field.multiply(x42, x82, x42);
        SecP224K1Field.squareN(x42, 84, x82);
        SecP224K1Field.multiply(x82, x84, x82);
        SecP224K1Field.squareN(x82, 20, x82);
        SecP224K1Field.multiply(x82, x11, x82);
        SecP224K1Field.squareN(x82, 3, x82);
        SecP224K1Field.multiply(x82, x12, x82);
        SecP224K1Field.squareN(x82, 2, x82);
        SecP224K1Field.multiply(x82, x12, x82);
        SecP224K1Field.squareN(x82, 4, x82);
        SecP224K1Field.multiply(x82, x22, x82);
        SecP224K1Field.square(x82, x82);
        SecP224K1Field.square(x82, x84);
        if (Nat224.eq(x12, x84)) {
            return new SecP224K1FieldElement(x82);
        }
        SecP224K1Field.multiply(x82, PRECOMP_POW2, x82);
        SecP224K1Field.square(x82, x84);
        if (Nat224.eq(x12, x84)) {
            return new SecP224K1FieldElement(x82);
        }
        return null;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SecP224K1FieldElement)) {
            return false;
        }
        SecP224K1FieldElement o10 = (SecP224K1FieldElement) other;
        return Nat224.eq(this.f9285x, o10.f9285x);
    }

    public int hashCode() {
        return Q.hashCode() ^ Arrays.hashCode(this.f9285x, 0, 7);
    }
}
