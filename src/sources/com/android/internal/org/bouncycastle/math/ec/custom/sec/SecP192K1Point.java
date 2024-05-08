package com.android.internal.org.bouncycastle.math.ec.custom.sec;

import com.android.internal.org.bouncycastle.math.ec.ECCurve;
import com.android.internal.org.bouncycastle.math.ec.ECFieldElement;
import com.android.internal.org.bouncycastle.math.ec.ECPoint;
import com.android.internal.org.bouncycastle.math.raw.Nat;
import com.android.internal.org.bouncycastle.math.raw.Nat192;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SecP192K1Point extends ECPoint.AbstractFp {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SecP192K1Point(ECCurve curve, ECFieldElement x10, ECFieldElement y10) {
        super(curve, x10, y10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SecP192K1Point(ECCurve curve, ECFieldElement x10, ECFieldElement y10, ECFieldElement[] zs) {
        super(curve, x10, y10, zs);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
    protected ECPoint detach() {
        return new SecP192K1Point(null, getAffineXCoord(), getAffineYCoord());
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
        SecP192K1FieldElement X1 = (SecP192K1FieldElement) this.f9276x;
        SecP192K1FieldElement Y1 = (SecP192K1FieldElement) this.f9277y;
        SecP192K1FieldElement X2 = (SecP192K1FieldElement) b4.getXCoord();
        SecP192K1FieldElement Y2 = (SecP192K1FieldElement) b4.getYCoord();
        SecP192K1FieldElement Z1 = (SecP192K1FieldElement) this.zs[0];
        SecP192K1FieldElement Z2 = (SecP192K1FieldElement) b4.getZCoord(0);
        int[] tt1 = Nat192.createExt();
        int[] t2 = Nat192.create();
        int[] t32 = Nat192.create();
        int[] t42 = Nat192.create();
        boolean Z1IsOne = Z1.isOne();
        if (Z1IsOne) {
            U2 = X2.f9281x;
            S2 = Y2.f9281x;
        } else {
            S2 = t32;
            SecP192K1Field.square(Z1.f9281x, S2);
            U2 = t2;
            SecP192K1Field.multiply(S2, X2.f9281x, U2);
            SecP192K1Field.multiply(S2, Z1.f9281x, S2);
            SecP192K1Field.multiply(S2, Y2.f9281x, S2);
        }
        boolean Z2IsOne = Z2.isOne();
        if (Z2IsOne) {
            int[] U1 = X1.f9281x;
            int[] U12 = Y1.f9281x;
            S1 = U12;
            S12 = U1;
        } else {
            SecP192K1Field.square(Z2.f9281x, t42);
            SecP192K1Field.multiply(t42, X1.f9281x, tt1);
            SecP192K1Field.multiply(t42, Z2.f9281x, t42);
            SecP192K1Field.multiply(t42, Y1.f9281x, t42);
            S1 = t42;
            S12 = tt1;
        }
        int[] H = Nat192.create();
        SecP192K1Field.subtract(S12, U2, H);
        SecP192K1Field.subtract(S1, S2, t2);
        if (Nat192.isZero(H)) {
            if (Nat192.isZero(t2)) {
                return twice();
            }
            return curve.getInfinity();
        }
        SecP192K1Field.square(H, t32);
        int[] G = Nat192.create();
        SecP192K1Field.multiply(t32, H, G);
        SecP192K1Field.multiply(t32, S12, t32);
        SecP192K1Field.negate(G, G);
        Nat192.mul(S1, G, tt1);
        int c4 = Nat192.addBothTo(t32, t32, G);
        SecP192K1Field.reduce32(c4, G);
        SecP192K1FieldElement X3 = new SecP192K1FieldElement(t42);
        int[] HSquared = X3.f9281x;
        SecP192K1Field.square(t2, HSquared);
        int[] iArr = X3.f9281x;
        int[] S13 = X3.f9281x;
        SecP192K1Field.subtract(iArr, G, S13);
        SecP192K1FieldElement Y3 = new SecP192K1FieldElement(G);
        SecP192K1Field.subtract(t32, X3.f9281x, Y3.f9281x);
        SecP192K1Field.multiplyAddToExt(Y3.f9281x, t2, tt1);
        SecP192K1Field.reduce(tt1, Y3.f9281x);
        SecP192K1FieldElement Z3 = new SecP192K1FieldElement(H);
        if (!Z1IsOne) {
            int[] iArr2 = Z3.f9281x;
            int[] R = Z1.f9281x;
            SecP192K1Field.multiply(iArr2, R, Z3.f9281x);
        }
        if (!Z2IsOne) {
            SecP192K1Field.multiply(Z3.f9281x, Z2.f9281x, Z3.f9281x);
        }
        ECFieldElement[] zs = {Z3};
        return new SecP192K1Point(curve, X3, Y3, zs);
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
    public ECPoint twice() {
        if (isInfinity()) {
            return this;
        }
        ECCurve curve = getCurve();
        SecP192K1FieldElement Y1 = (SecP192K1FieldElement) this.f9277y;
        if (Y1.isZero()) {
            return curve.getInfinity();
        }
        SecP192K1FieldElement X1 = (SecP192K1FieldElement) this.f9276x;
        SecP192K1FieldElement Z1 = (SecP192K1FieldElement) this.zs[0];
        int[] Y1Squared = Nat192.create();
        SecP192K1Field.square(Y1.f9281x, Y1Squared);
        int[] T = Nat192.create();
        SecP192K1Field.square(Y1Squared, T);
        int[] M = Nat192.create();
        SecP192K1Field.square(X1.f9281x, M);
        int c4 = Nat192.addBothTo(M, M, M);
        SecP192K1Field.reduce32(c4, M);
        SecP192K1Field.multiply(Y1Squared, X1.f9281x, Y1Squared);
        int c10 = Nat.shiftUpBits(6, Y1Squared, 2, 0);
        SecP192K1Field.reduce32(c10, Y1Squared);
        int[] t12 = Nat192.create();
        int c11 = Nat.shiftUpBits(6, T, 3, 0, t12);
        SecP192K1Field.reduce32(c11, t12);
        SecP192K1FieldElement X3 = new SecP192K1FieldElement(T);
        SecP192K1Field.square(M, X3.f9281x);
        SecP192K1Field.subtract(X3.f9281x, Y1Squared, X3.f9281x);
        SecP192K1Field.subtract(X3.f9281x, Y1Squared, X3.f9281x);
        SecP192K1FieldElement Y3 = new SecP192K1FieldElement(Y1Squared);
        SecP192K1Field.subtract(Y1Squared, X3.f9281x, Y3.f9281x);
        SecP192K1Field.multiply(Y3.f9281x, M, Y3.f9281x);
        SecP192K1Field.subtract(Y3.f9281x, t12, Y3.f9281x);
        SecP192K1FieldElement Z3 = new SecP192K1FieldElement(M);
        SecP192K1Field.twice(Y1.f9281x, Z3.f9281x);
        if (!Z1.isOne()) {
            SecP192K1Field.multiply(Z3.f9281x, Z1.f9281x, Z3.f9281x);
        }
        return new SecP192K1Point(curve, X3, Y3, new ECFieldElement[]{Z3});
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
        return new SecP192K1Point(this.curve, this.f9276x, this.f9277y.negate(), this.zs);
    }
}
