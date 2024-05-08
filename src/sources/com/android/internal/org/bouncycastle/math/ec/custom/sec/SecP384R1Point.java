package com.android.internal.org.bouncycastle.math.ec.custom.sec;

import com.android.internal.org.bouncycastle.math.ec.ECCurve;
import com.android.internal.org.bouncycastle.math.ec.ECFieldElement;
import com.android.internal.org.bouncycastle.math.ec.ECPoint;
import com.android.internal.org.bouncycastle.math.raw.Nat;
import com.android.internal.org.bouncycastle.math.raw.Nat384;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SecP384R1Point extends ECPoint.AbstractFp {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SecP384R1Point(ECCurve curve, ECFieldElement x10, ECFieldElement y10) {
        super(curve, x10, y10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SecP384R1Point(ECCurve curve, ECFieldElement x10, ECFieldElement y10, ECFieldElement[] zs) {
        super(curve, x10, y10, zs);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
    protected ECPoint detach() {
        return new SecP384R1Point(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
    public ECPoint add(ECPoint b4) {
        int[] S2;
        int[] U2;
        int[] S1;
        int[] S12;
        if (isInfinity()) {
            return b4;
        }
        if (b4.isInfinity()) {
            return this;
        }
        if (this == b4) {
            return twice();
        }
        ECCurve curve = getCurve();
        SecP384R1FieldElement X1 = (SecP384R1FieldElement) this.f9276x;
        SecP384R1FieldElement Y1 = (SecP384R1FieldElement) this.f9277y;
        SecP384R1FieldElement X2 = (SecP384R1FieldElement) b4.getXCoord();
        SecP384R1FieldElement Y2 = (SecP384R1FieldElement) b4.getYCoord();
        SecP384R1FieldElement Z1 = (SecP384R1FieldElement) this.zs[0];
        SecP384R1FieldElement Z2 = (SecP384R1FieldElement) b4.getZCoord(0);
        int[] tt1 = Nat.create(24);
        int[] tt2 = Nat.create(24);
        int[] t32 = Nat.create(12);
        int[] t42 = Nat.create(12);
        boolean Z1IsOne = Z1.isOne();
        if (Z1IsOne) {
            U2 = X2.f9293x;
            S2 = Y2.f9293x;
        } else {
            S2 = t32;
            SecP384R1Field.square(Z1.f9293x, S2);
            U2 = tt2;
            SecP384R1Field.multiply(S2, X2.f9293x, U2);
            SecP384R1Field.multiply(S2, Z1.f9293x, S2);
            SecP384R1Field.multiply(S2, Y2.f9293x, S2);
        }
        boolean Z2IsOne = Z2.isOne();
        if (Z2IsOne) {
            int[] U1 = X1.f9293x;
            int[] U12 = Y1.f9293x;
            S1 = U12;
            S12 = U1;
        } else {
            SecP384R1Field.square(Z2.f9293x, t42);
            SecP384R1Field.multiply(t42, X1.f9293x, tt1);
            SecP384R1Field.multiply(t42, Z2.f9293x, t42);
            SecP384R1Field.multiply(t42, Y1.f9293x, t42);
            S1 = t42;
            S12 = tt1;
        }
        int[] H = Nat.create(12);
        SecP384R1Field.subtract(S12, U2, H);
        int[] R = Nat.create(12);
        SecP384R1Field.subtract(S1, S2, R);
        if (Nat.isZero(12, H)) {
            if (Nat.isZero(12, R)) {
                return twice();
            }
            return curve.getInfinity();
        }
        SecP384R1Field.square(H, t32);
        int[] G = Nat.create(12);
        SecP384R1Field.multiply(t32, H, G);
        SecP384R1Field.multiply(t32, S12, t32);
        SecP384R1Field.negate(G, G);
        Nat384.mul(S1, G, tt1);
        int c4 = Nat.addBothTo(12, t32, t32, G);
        SecP384R1Field.reduce32(c4, G);
        SecP384R1FieldElement X3 = new SecP384R1FieldElement(t42);
        int[] S13 = X3.f9293x;
        SecP384R1Field.square(R, S13);
        int[] iArr = X3.f9293x;
        int[] HSquared = X3.f9293x;
        SecP384R1Field.subtract(iArr, G, HSquared);
        SecP384R1FieldElement Y3 = new SecP384R1FieldElement(G);
        SecP384R1Field.subtract(t32, X3.f9293x, Y3.f9293x);
        Nat384.mul(Y3.f9293x, R, tt2);
        SecP384R1Field.addExt(tt1, tt2, tt1);
        SecP384R1Field.reduce(tt1, Y3.f9293x);
        SecP384R1FieldElement Z3 = new SecP384R1FieldElement(H);
        if (!Z1IsOne) {
            SecP384R1Field.multiply(Z3.f9293x, Z1.f9293x, Z3.f9293x);
        }
        if (!Z2IsOne) {
            SecP384R1Field.multiply(Z3.f9293x, Z2.f9293x, Z3.f9293x);
        }
        ECFieldElement[] zs = {Z3};
        return new SecP384R1Point(curve, X3, Y3, zs);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
    public ECPoint twice() {
        if (isInfinity()) {
            return this;
        }
        ECCurve curve = getCurve();
        SecP384R1FieldElement Y1 = (SecP384R1FieldElement) this.f9277y;
        if (Y1.isZero()) {
            return curve.getInfinity();
        }
        SecP384R1FieldElement X1 = (SecP384R1FieldElement) this.f9276x;
        SecP384R1FieldElement Z1 = (SecP384R1FieldElement) this.zs[0];
        int[] t12 = Nat.create(12);
        int[] t2 = Nat.create(12);
        int[] Y1Squared = Nat.create(12);
        SecP384R1Field.square(Y1.f9293x, Y1Squared);
        int[] T = Nat.create(12);
        SecP384R1Field.square(Y1Squared, T);
        boolean Z1IsOne = Z1.isOne();
        int[] Z1Squared = Z1.f9293x;
        if (!Z1IsOne) {
            Z1Squared = t2;
            SecP384R1Field.square(Z1.f9293x, Z1Squared);
        }
        SecP384R1Field.subtract(X1.f9293x, Z1Squared, t12);
        SecP384R1Field.add(X1.f9293x, Z1Squared, t2);
        SecP384R1Field.multiply(t2, t12, t2);
        int c4 = Nat.addBothTo(12, t2, t2, t2);
        SecP384R1Field.reduce32(c4, t2);
        SecP384R1Field.multiply(Y1Squared, X1.f9293x, Y1Squared);
        int c10 = Nat.shiftUpBits(12, Y1Squared, 2, 0);
        SecP384R1Field.reduce32(c10, Y1Squared);
        int c11 = Nat.shiftUpBits(12, T, 3, 0, t12);
        SecP384R1Field.reduce32(c11, t12);
        SecP384R1FieldElement X3 = new SecP384R1FieldElement(T);
        SecP384R1Field.square(t2, X3.f9293x);
        SecP384R1Field.subtract(X3.f9293x, Y1Squared, X3.f9293x);
        SecP384R1Field.subtract(X3.f9293x, Y1Squared, X3.f9293x);
        SecP384R1FieldElement Y3 = new SecP384R1FieldElement(Y1Squared);
        SecP384R1Field.subtract(Y1Squared, X3.f9293x, Y3.f9293x);
        SecP384R1Field.multiply(Y3.f9293x, t2, Y3.f9293x);
        SecP384R1Field.subtract(Y3.f9293x, t12, Y3.f9293x);
        SecP384R1FieldElement Z3 = new SecP384R1FieldElement(t2);
        SecP384R1Field.twice(Y1.f9293x, Z3.f9293x);
        if (!Z1IsOne) {
            SecP384R1Field.multiply(Z3.f9293x, Z1.f9293x, Z3.f9293x);
        }
        return new SecP384R1Point(curve, X3, Y3, new ECFieldElement[]{Z3});
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
    public ECPoint twicePlus(ECPoint b4) {
        if (this == b4) {
            return threeTimes();
        }
        if (isInfinity()) {
            return b4;
        }
        if (b4.isInfinity()) {
            return twice();
        }
        ECFieldElement Y1 = this.f9277y;
        if (Y1.isZero()) {
            return b4;
        }
        return twice().add(b4);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
    public ECPoint threeTimes() {
        if (isInfinity() || this.f9277y.isZero()) {
            return this;
        }
        return twice().add(this);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
    public ECPoint negate() {
        if (isInfinity()) {
            return this;
        }
        return new SecP384R1Point(this.curve, this.f9276x, this.f9277y.negate(), this.zs);
    }
}
