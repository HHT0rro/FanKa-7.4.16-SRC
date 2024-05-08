package com.android.internal.org.bouncycastle.math.ec.custom.sec;

import com.android.internal.org.bouncycastle.math.ec.ECCurve;
import com.android.internal.org.bouncycastle.math.ec.ECFieldElement;
import com.android.internal.org.bouncycastle.math.ec.ECPoint;
import com.android.internal.org.bouncycastle.math.raw.Nat;
import com.android.internal.org.bouncycastle.math.raw.Nat256;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SecP256R1Point extends ECPoint.AbstractFp {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SecP256R1Point(ECCurve curve, ECFieldElement x10, ECFieldElement y10) {
        super(curve, x10, y10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SecP256R1Point(ECCurve curve, ECFieldElement x10, ECFieldElement y10, ECFieldElement[] zs) {
        super(curve, x10, y10, zs);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
    protected ECPoint detach() {
        return new SecP256R1Point(null, getAffineXCoord(), getAffineYCoord());
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
        SecP256R1FieldElement X1 = (SecP256R1FieldElement) this.f9276x;
        SecP256R1FieldElement Y1 = (SecP256R1FieldElement) this.f9277y;
        SecP256R1FieldElement X2 = (SecP256R1FieldElement) b4.getXCoord();
        SecP256R1FieldElement Y2 = (SecP256R1FieldElement) b4.getYCoord();
        SecP256R1FieldElement Z1 = (SecP256R1FieldElement) this.zs[0];
        SecP256R1FieldElement Z2 = (SecP256R1FieldElement) b4.getZCoord(0);
        int[] tt1 = Nat256.createExt();
        int[] t2 = Nat256.create();
        int[] t32 = Nat256.create();
        int[] t42 = Nat256.create();
        boolean Z1IsOne = Z1.isOne();
        if (Z1IsOne) {
            U2 = X2.f9291x;
            S2 = Y2.f9291x;
        } else {
            S2 = t32;
            SecP256R1Field.square(Z1.f9291x, S2);
            U2 = t2;
            SecP256R1Field.multiply(S2, X2.f9291x, U2);
            SecP256R1Field.multiply(S2, Z1.f9291x, S2);
            SecP256R1Field.multiply(S2, Y2.f9291x, S2);
        }
        boolean Z2IsOne = Z2.isOne();
        if (Z2IsOne) {
            int[] U1 = X1.f9291x;
            int[] U12 = Y1.f9291x;
            S1 = U12;
            S12 = U1;
        } else {
            SecP256R1Field.square(Z2.f9291x, t42);
            SecP256R1Field.multiply(t42, X1.f9291x, tt1);
            SecP256R1Field.multiply(t42, Z2.f9291x, t42);
            SecP256R1Field.multiply(t42, Y1.f9291x, t42);
            S1 = t42;
            S12 = tt1;
        }
        int[] H = Nat256.create();
        SecP256R1Field.subtract(S12, U2, H);
        SecP256R1Field.subtract(S1, S2, t2);
        if (Nat256.isZero(H)) {
            if (Nat256.isZero(t2)) {
                return twice();
            }
            return curve.getInfinity();
        }
        SecP256R1Field.square(H, t32);
        int[] G = Nat256.create();
        SecP256R1Field.multiply(t32, H, G);
        SecP256R1Field.multiply(t32, S12, t32);
        SecP256R1Field.negate(G, G);
        Nat256.mul(S1, G, tt1);
        int c4 = Nat256.addBothTo(t32, t32, G);
        SecP256R1Field.reduce32(c4, G);
        SecP256R1FieldElement X3 = new SecP256R1FieldElement(t42);
        int[] HSquared = X3.f9291x;
        SecP256R1Field.square(t2, HSquared);
        int[] iArr = X3.f9291x;
        int[] S13 = X3.f9291x;
        SecP256R1Field.subtract(iArr, G, S13);
        SecP256R1FieldElement Y3 = new SecP256R1FieldElement(G);
        SecP256R1Field.subtract(t32, X3.f9291x, Y3.f9291x);
        SecP256R1Field.multiplyAddToExt(Y3.f9291x, t2, tt1);
        SecP256R1Field.reduce(tt1, Y3.f9291x);
        SecP256R1FieldElement Z3 = new SecP256R1FieldElement(H);
        if (!Z1IsOne) {
            int[] iArr2 = Z3.f9291x;
            int[] R = Z1.f9291x;
            SecP256R1Field.multiply(iArr2, R, Z3.f9291x);
        }
        if (!Z2IsOne) {
            SecP256R1Field.multiply(Z3.f9291x, Z2.f9291x, Z3.f9291x);
        }
        ECFieldElement[] zs = {Z3};
        return new SecP256R1Point(curve, X3, Y3, zs);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
    public ECPoint twice() {
        if (isInfinity()) {
            return this;
        }
        ECCurve curve = getCurve();
        SecP256R1FieldElement Y1 = (SecP256R1FieldElement) this.f9277y;
        if (Y1.isZero()) {
            return curve.getInfinity();
        }
        SecP256R1FieldElement X1 = (SecP256R1FieldElement) this.f9276x;
        SecP256R1FieldElement Z1 = (SecP256R1FieldElement) this.zs[0];
        int[] t12 = Nat256.create();
        int[] t2 = Nat256.create();
        int[] Y1Squared = Nat256.create();
        SecP256R1Field.square(Y1.f9291x, Y1Squared);
        int[] T = Nat256.create();
        SecP256R1Field.square(Y1Squared, T);
        boolean Z1IsOne = Z1.isOne();
        int[] Z1Squared = Z1.f9291x;
        if (!Z1IsOne) {
            Z1Squared = t2;
            SecP256R1Field.square(Z1.f9291x, Z1Squared);
        }
        SecP256R1Field.subtract(X1.f9291x, Z1Squared, t12);
        SecP256R1Field.add(X1.f9291x, Z1Squared, t2);
        SecP256R1Field.multiply(t2, t12, t2);
        int c4 = Nat256.addBothTo(t2, t2, t2);
        SecP256R1Field.reduce32(c4, t2);
        SecP256R1Field.multiply(Y1Squared, X1.f9291x, Y1Squared);
        int c10 = Nat.shiftUpBits(8, Y1Squared, 2, 0);
        SecP256R1Field.reduce32(c10, Y1Squared);
        int c11 = Nat.shiftUpBits(8, T, 3, 0, t12);
        SecP256R1Field.reduce32(c11, t12);
        SecP256R1FieldElement X3 = new SecP256R1FieldElement(T);
        SecP256R1Field.square(t2, X3.f9291x);
        SecP256R1Field.subtract(X3.f9291x, Y1Squared, X3.f9291x);
        SecP256R1Field.subtract(X3.f9291x, Y1Squared, X3.f9291x);
        SecP256R1FieldElement Y3 = new SecP256R1FieldElement(Y1Squared);
        SecP256R1Field.subtract(Y1Squared, X3.f9291x, Y3.f9291x);
        SecP256R1Field.multiply(Y3.f9291x, t2, Y3.f9291x);
        SecP256R1Field.subtract(Y3.f9291x, t12, Y3.f9291x);
        SecP256R1FieldElement Z3 = new SecP256R1FieldElement(t2);
        SecP256R1Field.twice(Y1.f9291x, Z3.f9291x);
        if (!Z1IsOne) {
            SecP256R1Field.multiply(Z3.f9291x, Z1.f9291x, Z3.f9291x);
        }
        return new SecP256R1Point(curve, X3, Y3, new ECFieldElement[]{Z3});
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
        return new SecP256R1Point(this.curve, this.f9276x, this.f9277y.negate(), this.zs);
    }
}
