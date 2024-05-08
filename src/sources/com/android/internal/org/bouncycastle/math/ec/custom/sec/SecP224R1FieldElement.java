package com.android.internal.org.bouncycastle.math.ec.custom.sec;

import com.android.internal.org.bouncycastle.math.ec.ECFieldElement;
import com.android.internal.org.bouncycastle.math.raw.Mod;
import com.android.internal.org.bouncycastle.math.raw.Nat;
import com.android.internal.org.bouncycastle.math.raw.Nat224;
import com.android.internal.org.bouncycastle.util.Arrays;
import com.android.internal.org.bouncycastle.util.encoders.Hex;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SecP224R1FieldElement extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF000000000000000000000001"));

    /* renamed from: x, reason: collision with root package name */
    protected int[] f9287x;

    public SecP224R1FieldElement(BigInteger x10) {
        if (x10 == null || x10.signum() < 0 || x10.compareTo(Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP224R1FieldElement");
        }
        this.f9287x = SecP224R1Field.fromBigInteger(x10);
    }

    public SecP224R1FieldElement() {
        this.f9287x = Nat224.create();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SecP224R1FieldElement(int[] x10) {
        this.f9287x = x10;
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat224.isZero(this.f9287x);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat224.isOne(this.f9287x);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        return Nat224.getBit(this.f9287x, 0) == 1;
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat224.toBigInteger(this.f9287x);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public String getFieldName() {
        return "SecP224R1Field";
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return Q.bitLength();
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement b4) {
        int[] z10 = Nat224.create();
        SecP224R1Field.add(this.f9287x, ((SecP224R1FieldElement) b4).f9287x, z10);
        return new SecP224R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] z10 = Nat224.create();
        SecP224R1Field.addOne(this.f9287x, z10);
        return new SecP224R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement b4) {
        int[] z10 = Nat224.create();
        SecP224R1Field.subtract(this.f9287x, ((SecP224R1FieldElement) b4).f9287x, z10);
        return new SecP224R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement b4) {
        int[] z10 = Nat224.create();
        SecP224R1Field.multiply(this.f9287x, ((SecP224R1FieldElement) b4).f9287x, z10);
        return new SecP224R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement b4) {
        int[] z10 = Nat224.create();
        SecP224R1Field.inv(((SecP224R1FieldElement) b4).f9287x, z10);
        SecP224R1Field.multiply(z10, this.f9287x, z10);
        return new SecP224R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] z10 = Nat224.create();
        SecP224R1Field.negate(this.f9287x, z10);
        return new SecP224R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] z10 = Nat224.create();
        SecP224R1Field.square(this.f9287x, z10);
        return new SecP224R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        int[] z10 = Nat224.create();
        SecP224R1Field.inv(this.f9287x, z10);
        return new SecP224R1FieldElement(z10);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] c4 = this.f9287x;
        if (Nat224.isZero(c4) || Nat224.isOne(c4)) {
            return this;
        }
        int[] nc2 = Nat224.create();
        SecP224R1Field.negate(c4, nc2);
        int[] r10 = Mod.random(SecP224R1Field.P);
        int[] t2 = Nat224.create();
        if (!isSquare(c4)) {
            return null;
        }
        while (!trySqrt(nc2, r10, t2)) {
            SecP224R1Field.addOne(r10, r10);
        }
        SecP224R1Field.square(t2, r10);
        if (Nat224.eq(c4, r10)) {
            return new SecP224R1FieldElement(t2);
        }
        return null;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SecP224R1FieldElement)) {
            return false;
        }
        SecP224R1FieldElement o10 = (SecP224R1FieldElement) other;
        return Nat224.eq(this.f9287x, o10.f9287x);
    }

    public int hashCode() {
        return Q.hashCode() ^ Arrays.hashCode(this.f9287x, 0, 7);
    }

    private static boolean isSquare(int[] x10) {
        int[] t12 = Nat224.create();
        int[] t2 = Nat224.create();
        Nat224.copy(x10, t12);
        for (int i10 = 0; i10 < 7; i10++) {
            Nat224.copy(t12, t2);
            SecP224R1Field.squareN(t12, 1 << i10, t12);
            SecP224R1Field.multiply(t12, t2, t12);
        }
        SecP224R1Field.squareN(t12, 95, t12);
        return Nat224.isOne(t12);
    }

    private static void RM(int[] nc2, int[] d02, int[] e02, int[] d12, int[] e12, int[] f12, int[] t2) {
        SecP224R1Field.multiply(e12, e02, t2);
        SecP224R1Field.multiply(t2, nc2, t2);
        SecP224R1Field.multiply(d12, d02, f12);
        SecP224R1Field.add(f12, t2, f12);
        SecP224R1Field.multiply(d12, e02, t2);
        Nat224.copy(f12, d12);
        SecP224R1Field.multiply(e12, d02, e12);
        SecP224R1Field.add(e12, t2, e12);
        SecP224R1Field.square(e12, f12);
        SecP224R1Field.multiply(f12, nc2, f12);
    }

    private static void RP(int[] nc2, int[] d12, int[] e12, int[] f12, int[] t2) {
        Nat224.copy(nc2, f12);
        int[] d02 = Nat224.create();
        int[] e02 = Nat224.create();
        for (int i10 = 0; i10 < 7; i10++) {
            Nat224.copy(d12, d02);
            Nat224.copy(e12, e02);
            int j10 = 1 << i10;
            while (true) {
                int j11 = j10 - 1;
                if (j11 >= 0) {
                    RS(d12, e12, f12, t2);
                    j10 = j11;
                }
            }
            RM(nc2, d02, e02, d12, e12, f12, t2);
        }
    }

    private static void RS(int[] d10, int[] e2, int[] f10, int[] t2) {
        SecP224R1Field.multiply(e2, d10, e2);
        SecP224R1Field.twice(e2, e2);
        SecP224R1Field.square(d10, t2);
        SecP224R1Field.add(f10, t2, d10);
        SecP224R1Field.multiply(f10, t2, f10);
        int c4 = Nat.shiftUpBits(7, f10, 2, 0);
        SecP224R1Field.reduce32(c4, f10);
    }

    private static boolean trySqrt(int[] nc2, int[] r10, int[] t2) {
        int[] d12 = Nat224.create();
        Nat224.copy(r10, d12);
        int[] e12 = Nat224.create();
        e12[0] = 1;
        int[] f12 = Nat224.create();
        RP(nc2, d12, e12, f12, t2);
        int[] d02 = Nat224.create();
        int[] e02 = Nat224.create();
        for (int k10 = 1; k10 < 96; k10++) {
            Nat224.copy(d12, d02);
            Nat224.copy(e12, e02);
            RS(d12, e12, f12, t2);
            if (Nat224.isZero(d12)) {
                SecP224R1Field.inv(e02, t2);
                SecP224R1Field.multiply(t2, d02, t2);
                return true;
            }
        }
        return false;
    }
}
