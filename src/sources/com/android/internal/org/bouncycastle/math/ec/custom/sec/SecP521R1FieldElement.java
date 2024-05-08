package com.android.internal.org.bouncycastle.math.ec.custom.sec;

import com.android.internal.logging.nano.MetricsProto;
import com.android.internal.org.bouncycastle.math.ec.ECFieldElement;
import com.android.internal.org.bouncycastle.math.raw.Nat;
import com.android.internal.org.bouncycastle.util.Arrays;
import com.android.internal.org.bouncycastle.util.encoders.Hex;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SecP521R1FieldElement extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = new BigInteger(1, Hex.decodeStrict("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF"));

    /* renamed from: x, reason: collision with root package name */
    protected int[] f9295x;

    public SecP521R1FieldElement(BigInteger x10) {
        if (x10 == null || x10.signum() < 0 || x10.compareTo(Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP521R1FieldElement");
        }
        this.f9295x = SecP521R1Field.fromBigInteger(x10);
    }

    public SecP521R1FieldElement() {
        this.f9295x = Nat.create(17);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SecP521R1FieldElement(int[] x10) {
        this.f9295x = x10;
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat.isZero(17, this.f9295x);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat.isOne(17, this.f9295x);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        return Nat.getBit(this.f9295x, 0) == 1;
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat.toBigInteger(17, this.f9295x);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public String getFieldName() {
        return "SecP521R1Field";
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return Q.bitLength();
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement b4) {
        int[] z10 = Nat.create(17);
        SecP521R1Field.add(this.f9295x, ((SecP521R1FieldElement) b4).f9295x, z10);
        return new SecP521R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] z10 = Nat.create(17);
        SecP521R1Field.addOne(this.f9295x, z10);
        return new SecP521R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement b4) {
        int[] z10 = Nat.create(17);
        SecP521R1Field.subtract(this.f9295x, ((SecP521R1FieldElement) b4).f9295x, z10);
        return new SecP521R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement b4) {
        int[] z10 = Nat.create(17);
        SecP521R1Field.multiply(this.f9295x, ((SecP521R1FieldElement) b4).f9295x, z10);
        return new SecP521R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement b4) {
        int[] z10 = Nat.create(17);
        SecP521R1Field.inv(((SecP521R1FieldElement) b4).f9295x, z10);
        SecP521R1Field.multiply(z10, this.f9295x, z10);
        return new SecP521R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] z10 = Nat.create(17);
        SecP521R1Field.negate(this.f9295x, z10);
        return new SecP521R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] z10 = Nat.create(17);
        SecP521R1Field.square(this.f9295x, z10);
        return new SecP521R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        int[] z10 = Nat.create(17);
        SecP521R1Field.inv(this.f9295x, z10);
        return new SecP521R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] x12 = this.f9295x;
        if (Nat.isZero(17, x12) || Nat.isOne(17, x12)) {
            return this;
        }
        int[] t12 = Nat.create(17);
        int[] t2 = Nat.create(17);
        SecP521R1Field.squareN(x12, MetricsProto.MetricsEvent.PROVISIONING_PROVISIONING_ACTIVITY_TIME_MS, t12);
        SecP521R1Field.square(t12, t2);
        if (Nat.eq(17, x12, t2)) {
            return new SecP521R1FieldElement(t12);
        }
        return null;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SecP521R1FieldElement)) {
            return false;
        }
        SecP521R1FieldElement o10 = (SecP521R1FieldElement) other;
        return Nat.eq(17, this.f9295x, o10.f9295x);
    }

    public int hashCode() {
        return Q.hashCode() ^ Arrays.hashCode(this.f9295x, 0, 17);
    }
}
