package com.android.internal.org.bouncycastle.math.ec.custom.sec;

import com.android.internal.org.bouncycastle.math.ec.ECCurve;
import com.android.internal.org.bouncycastle.math.ec.ECFieldElement;
import com.android.internal.org.bouncycastle.math.ec.ECPoint;
import com.android.internal.org.bouncycastle.math.raw.Nat;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SecP521R1Point extends ECPoint.AbstractFp {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SecP521R1Point(ECCurve curve, ECFieldElement x10, ECFieldElement y10) {
        super(curve, x10, y10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SecP521R1Point(ECCurve curve, ECFieldElement x10, ECFieldElement y10, ECFieldElement[] zs) {
        super(curve, x10, y10, zs);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
    protected ECPoint detach() {
        return new SecP521R1Point(null, getAffineXCoord(), getAffineYCoord());
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
        SecP521R1FieldElement X1 = (SecP521R1FieldElement) this.f9276x;
        SecP521R1FieldElement Y1 = (SecP521R1FieldElement) this.f9277y;
        SecP521R1FieldElement X2 = (SecP521R1FieldElement) b4.getXCoord();
        SecP521R1FieldElement Y2 = (SecP521R1FieldElement) b4.getYCoord();
        SecP521R1FieldElement Z1 = (SecP521R1FieldElement) this.zs[0];
        SecP521R1FieldElement Z2 = (SecP521R1FieldElement) b4.getZCoord(0);
        int[] t12 = Nat.create(17);
        int[] t2 = Nat.create(17);
        int[] t32 = Nat.create(17);
        int[] t42 = Nat.create(17);
        boolean Z1IsOne = Z1.isOne();
        if (Z1IsOne) {
            U2 = X2.f9295x;
            S2 = Y2.f9295x;
        } else {
            S2 = t32;
            SecP521R1Field.square(Z1.f9295x, S2);
            U2 = t2;
            SecP521R1Field.multiply(S2, X2.f9295x, U2);
            SecP521R1Field.multiply(S2, Z1.f9295x, S2);
            SecP521R1Field.multiply(S2, Y2.f9295x, S2);
        }
        boolean Z2IsOne = Z2.isOne();
        if (Z2IsOne) {
            int[] U1 = X1.f9295x;
            int[] U12 = Y1.f9295x;
            S1 = U12;
            S12 = U1;
        } else {
            SecP521R1Field.square(Z2.f9295x, t42);
            SecP521R1Field.multiply(t42, X1.f9295x, t12);
            SecP521R1Field.multiply(t42, Z2.f9295x, t42);
            SecP521R1Field.multiply(t42, Y1.f9295x, t42);
            S1 = t42;
            S12 = t12;
        }
        int[] H = Nat.create(17);
        SecP521R1Field.subtract(S12, U2, H);
        SecP521R1Field.subtract(S1, S2, t2);
        if (Nat.isZero(17, H)) {
            if (Nat.isZero(17, t2)) {
                return twice();
            }
            return curve.getInfinity();
        }
        SecP521R1Field.square(H, t32);
        int[] G = Nat.create(17);
        SecP521R1Field.multiply(t32, H, G);
        SecP521R1Field.multiply(t32, S12, t32);
        SecP521R1Field.multiply(S1, G, t12);
        SecP521R1FieldElement X3 = new SecP521R1FieldElement(t42);
        int[] HSquared = X3.f9295x;
        SecP521R1Field.square(t2, HSquared);
        int[] iArr = X3.f9295x;
        int[] S13 = X3.f9295x;
        SecP521R1Field.add(iArr, G, S13);
        SecP521R1Field.subtract(X3.f9295x, t32, X3.f9295x);
        SecP521R1Field.subtract(X3.f9295x, t32, X3.f9295x);
        SecP521R1FieldElement Y3 = new SecP521R1FieldElement(G);
        SecP521R1Field.subtract(t32, X3.f9295x, Y3.f9295x);
        SecP521R1Field.multiply(Y3.f9295x, t2, t2);
        SecP521R1Field.subtract(t2, t12, Y3.f9295x);
        SecP521R1FieldElement Z3 = new SecP521R1FieldElement(H);
        if (!Z1IsOne) {
            int[] iArr2 = Z3.f9295x;
            int[] H2 = Z1.f9295x;
            int[] R = Z3.f9295x;
            SecP521R1Field.multiply(iArr2, H2, R);
        }
        if (!Z2IsOne) {
            SecP521R1Field.multiply(Z3.f9295x, Z2.f9295x, Z3.f9295x);
        }
        ECFieldElement[] zs = {Z3};
        return new SecP521R1Point(curve, X3, Y3, zs);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
    public ECPoint twice() {
        if (isInfinity()) {
            return this;
        }
        ECCurve curve = getCurve();
        SecP521R1FieldElement Y1 = (SecP521R1FieldElement) this.f9277y;
        if (Y1.isZero()) {
            return curve.getInfinity();
        }
        SecP521R1FieldElement X1 = (SecP521R1FieldElement) this.f9276x;
        SecP521R1FieldElement Z1 = (SecP521R1FieldElement) this.zs[0];
        int[] t12 = Nat.create(17);
        int[] t2 = Nat.create(17);
        int[] Y1Squared = Nat.create(17);
        SecP521R1Field.square(Y1.f9295x, Y1Squared);
        int[] T = Nat.create(17);
        SecP521R1Field.square(Y1Squared, T);
        boolean Z1IsOne = Z1.isOne();
        int[] Z1Squared = Z1.f9295x;
        if (!Z1IsOne) {
            Z1Squared = t2;
            SecP521R1Field.square(Z1.f9295x, Z1Squared);
        }
        SecP521R1Field.subtract(X1.f9295x, Z1Squared, t12);
        SecP521R1Field.add(X1.f9295x, Z1Squared, t2);
        SecP521R1Field.multiply(t2, t12, t2);
        Nat.addBothTo(17, t2, t2, t2);
        SecP521R1Field.reduce23(t2);
        SecP521R1Field.multiply(Y1Squared, X1.f9295x, Y1Squared);
        Nat.shiftUpBits(17, Y1Squared, 2, 0);
        SecP521R1Field.reduce23(Y1Squared);
        Nat.shiftUpBits(17, T, 3, 0, t12);
        SecP521R1Field.reduce23(t12);
        SecP521R1FieldElement X3 = new SecP521R1FieldElement(T);
        SecP521R1Field.square(t2, X3.f9295x);
        SecP521R1Field.subtract(X3.f9295x, Y1Squared, X3.f9295x);
        SecP521R1Field.subtract(X3.f9295x, Y1Squared, X3.f9295x);
        SecP521R1FieldElement Y3 = new SecP521R1FieldElement(Y1Squared);
        SecP521R1Field.subtract(Y1Squared, X3.f9295x, Y3.f9295x);
        SecP521R1Field.multiply(Y3.f9295x, t2, Y3.f9295x);
        SecP521R1Field.subtract(Y3.f9295x, t12, Y3.f9295x);
        SecP521R1FieldElement Z3 = new SecP521R1FieldElement(t2);
        SecP521R1Field.twice(Y1.f9295x, Z3.f9295x);
        if (!Z1IsOne) {
            SecP521R1Field.multiply(Z3.f9295x, Z1.f9295x, Z3.f9295x);
        }
        return new SecP521R1Point(curve, X3, Y3, new ECFieldElement[]{Z3});
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

    protected ECFieldElement two(ECFieldElement x10) {
        return x10.add(x10);
    }

    protected ECFieldElement three(ECFieldElement x10) {
        return two(x10).add(x10);
    }

    protected ECFieldElement four(ECFieldElement x10) {
        return two(two(x10));
    }

    protected ECFieldElement eight(ECFieldElement x10) {
        return four(two(x10));
    }

    protected ECFieldElement doubleProductFromSquares(ECFieldElement a10, ECFieldElement b4, ECFieldElement aSquared, ECFieldElement bSquared) {
        return a10.add(b4).square().subtract(aSquared).subtract(bSquared);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
    public ECPoint negate() {
        if (isInfinity()) {
            return this;
        }
        return new SecP521R1Point(this.curve, this.f9276x, this.f9277y.negate(), this.zs);
    }
}
