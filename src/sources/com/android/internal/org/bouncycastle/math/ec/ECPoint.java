package com.android.internal.org.bouncycastle.math.ec;

import com.android.internal.org.bouncycastle.crypto.CryptoServicesRegistrar;
import com.android.internal.org.bouncycastle.math.ec.ECCurve;
import com.android.internal.org.bouncycastle.math.ec.ECFieldElement;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Hashtable;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class ECPoint {
    protected static final ECFieldElement[] EMPTY_ZS = new ECFieldElement[0];
    protected ECCurve curve;
    protected Hashtable preCompTable;

    /* renamed from: x, reason: collision with root package name */
    protected ECFieldElement f9276x;

    /* renamed from: y, reason: collision with root package name */
    protected ECFieldElement f9277y;
    protected ECFieldElement[] zs;

    public abstract ECPoint add(ECPoint eCPoint);

    protected abstract ECPoint detach();

    protected abstract boolean getCompressionYTilde();

    public abstract ECPoint negate();

    protected abstract boolean satisfiesCurveEquation();

    public abstract ECPoint subtract(ECPoint eCPoint);

    public abstract ECPoint twice();

    protected static ECFieldElement[] getInitialZCoords(ECCurve curve) {
        int coord = curve == null ? 0 : curve.getCoordinateSystem();
        switch (coord) {
            case 0:
            case 5:
                return EMPTY_ZS;
            default:
                ECFieldElement one = curve.fromBigInteger(ECConstants.ONE);
                switch (coord) {
                    case 1:
                    case 2:
                    case 6:
                        return new ECFieldElement[]{one};
                    case 3:
                        return new ECFieldElement[]{one, one, one};
                    case 4:
                        return new ECFieldElement[]{one, curve.getA()};
                    case 5:
                    default:
                        throw new IllegalArgumentException("unknown coordinate system");
                }
        }
    }

    protected ECPoint(ECCurve curve, ECFieldElement x10, ECFieldElement y10) {
        this(curve, x10, y10, getInitialZCoords(curve));
    }

    protected ECPoint(ECCurve curve, ECFieldElement x10, ECFieldElement y10, ECFieldElement[] zs) {
        this.preCompTable = null;
        this.curve = curve;
        this.f9276x = x10;
        this.f9277y = y10;
        this.zs = zs;
    }

    protected boolean satisfiesOrder() {
        BigInteger n10;
        return ECConstants.ONE.equals(this.curve.getCofactor()) || (n10 = this.curve.getOrder()) == null || ECAlgorithms.referenceMultiply(this, n10).isInfinity();
    }

    public final ECPoint getDetachedPoint() {
        return normalize().detach();
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    protected int getCurveCoordinateSystem() {
        ECCurve eCCurve = this.curve;
        if (eCCurve == null) {
            return 0;
        }
        return eCCurve.getCoordinateSystem();
    }

    public ECFieldElement getAffineXCoord() {
        checkNormalized();
        return getXCoord();
    }

    public ECFieldElement getAffineYCoord() {
        checkNormalized();
        return getYCoord();
    }

    public ECFieldElement getXCoord() {
        return this.f9276x;
    }

    public ECFieldElement getYCoord() {
        return this.f9277y;
    }

    public ECFieldElement getZCoord(int index) {
        if (index >= 0) {
            ECFieldElement[] eCFieldElementArr = this.zs;
            if (index < eCFieldElementArr.length) {
                return eCFieldElementArr[index];
            }
        }
        return null;
    }

    public ECFieldElement[] getZCoords() {
        ECFieldElement[] eCFieldElementArr = this.zs;
        int zsLen = eCFieldElementArr.length;
        if (zsLen == 0) {
            return EMPTY_ZS;
        }
        ECFieldElement[] copy = new ECFieldElement[zsLen];
        System.arraycopy(eCFieldElementArr, 0, copy, 0, zsLen);
        return copy;
    }

    public final ECFieldElement getRawXCoord() {
        return this.f9276x;
    }

    public final ECFieldElement getRawYCoord() {
        return this.f9277y;
    }

    protected final ECFieldElement[] getRawZCoords() {
        return this.zs;
    }

    protected void checkNormalized() {
        if (!isNormalized()) {
            throw new IllegalStateException("point not in normal form");
        }
    }

    public boolean isNormalized() {
        int coord = getCurveCoordinateSystem();
        return coord == 0 || coord == 5 || isInfinity() || this.zs[0].isOne();
    }

    public ECPoint normalize() {
        if (isInfinity()) {
            return this;
        }
        switch (getCurveCoordinateSystem()) {
            case 0:
            case 5:
                return this;
            default:
                ECFieldElement z10 = getZCoord(0);
                if (z10.isOne()) {
                    return this;
                }
                if (this.curve == null) {
                    throw new IllegalStateException("Detached points must be in affine coordinates");
                }
                SecureRandom r10 = CryptoServicesRegistrar.getSecureRandom();
                ECFieldElement b4 = this.curve.randomFieldElementMult(r10);
                ECFieldElement zInv = z10.multiply(b4).invert().multiply(b4);
                return normalize(zInv);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECPoint normalize(ECFieldElement zInv) {
        switch (getCurveCoordinateSystem()) {
            case 1:
            case 6:
                return createScaledPoint(zInv, zInv);
            case 2:
            case 3:
            case 4:
                ECFieldElement zInv2 = zInv.square();
                ECFieldElement zInv3 = zInv2.multiply(zInv);
                return createScaledPoint(zInv2, zInv3);
            case 5:
            default:
                throw new IllegalStateException("not a projective coordinate system");
        }
    }

    protected ECPoint createScaledPoint(ECFieldElement sx, ECFieldElement sy) {
        return getCurve().createRawPoint(getRawXCoord().multiply(sx), getRawYCoord().multiply(sy));
    }

    public boolean isInfinity() {
        if (this.f9276x != null && this.f9277y != null) {
            ECFieldElement[] eCFieldElementArr = this.zs;
            if (eCFieldElementArr.length <= 0 || !eCFieldElementArr[0].isZero()) {
                return false;
            }
        }
        return true;
    }

    public boolean isValid() {
        return implIsValid(false, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isValidPartial() {
        return implIsValid(false, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean implIsValid(final boolean decompressed, final boolean checkOrder) {
        if (isInfinity()) {
            return true;
        }
        ValidityPrecompInfo validity = (ValidityPrecompInfo) getCurve().precompute(this, "bc_validity", new PreCompCallback() { // from class: com.android.internal.org.bouncycastle.math.ec.ECPoint.1
            @Override // com.android.internal.org.bouncycastle.math.ec.PreCompCallback
            public PreCompInfo precompute(PreCompInfo existing) {
                ValidityPrecompInfo info = existing instanceof ValidityPrecompInfo ? (ValidityPrecompInfo) existing : null;
                if (info == null) {
                    info = new ValidityPrecompInfo();
                }
                if (info.hasFailed()) {
                    return info;
                }
                if (!info.hasCurveEquationPassed()) {
                    if (!decompressed && !ECPoint.this.satisfiesCurveEquation()) {
                        info.reportFailed();
                        return info;
                    }
                    info.reportCurveEquationPassed();
                }
                if (checkOrder && !info.hasOrderPassed()) {
                    if (!ECPoint.this.satisfiesOrder()) {
                        info.reportFailed();
                        return info;
                    }
                    info.reportOrderPassed();
                }
                return info;
            }
        });
        return true ^ validity.hasFailed();
    }

    public ECPoint scaleX(ECFieldElement scale) {
        if (isInfinity()) {
            return this;
        }
        return getCurve().createRawPoint(getRawXCoord().multiply(scale), getRawYCoord(), getRawZCoords());
    }

    public ECPoint scaleXNegateY(ECFieldElement scale) {
        if (isInfinity()) {
            return this;
        }
        return getCurve().createRawPoint(getRawXCoord().multiply(scale), getRawYCoord().negate(), getRawZCoords());
    }

    public ECPoint scaleY(ECFieldElement scale) {
        if (isInfinity()) {
            return this;
        }
        return getCurve().createRawPoint(getRawXCoord(), getRawYCoord().multiply(scale), getRawZCoords());
    }

    public ECPoint scaleYNegateX(ECFieldElement scale) {
        if (isInfinity()) {
            return this;
        }
        return getCurve().createRawPoint(getRawXCoord().negate(), getRawYCoord().multiply(scale), getRawZCoords());
    }

    public boolean equals(ECPoint other) {
        boolean n12;
        boolean n22;
        if (other == null) {
            return false;
        }
        ECCurve c12 = getCurve();
        ECCurve c22 = other.getCurve();
        if (c12 != null) {
            n12 = false;
        } else {
            n12 = true;
        }
        if (c22 != null) {
            n22 = false;
        } else {
            n22 = true;
        }
        boolean i12 = isInfinity();
        boolean i22 = other.isInfinity();
        if (i12 || i22) {
            if (!i12 || !i22) {
                return false;
            }
            if (!n12 && !n22 && !c12.equals(c22)) {
                return false;
            }
            return true;
        }
        ECPoint p12 = this;
        ECPoint p22 = other;
        if (!n12 || !n22) {
            if (n12) {
                p22 = p22.normalize();
            } else if (n22) {
                p12 = p12.normalize();
            } else {
                if (!c12.equals(c22)) {
                    return false;
                }
                ECPoint[] points = {this, c12.importPoint(p22)};
                c12.normalizeAll(points);
                p12 = points[0];
                p22 = points[1];
            }
        }
        if (!p12.getXCoord().equals(p22.getXCoord()) || !p12.getYCoord().equals(p22.getYCoord())) {
            return false;
        }
        return true;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ECPoint)) {
            return false;
        }
        return equals((ECPoint) other);
    }

    public int hashCode() {
        ECCurve c4 = getCurve();
        int hc2 = c4 == null ? 0 : ~c4.hashCode();
        if (!isInfinity()) {
            ECPoint p10 = normalize();
            return (hc2 ^ (p10.getXCoord().hashCode() * 17)) ^ (p10.getYCoord().hashCode() * 257);
        }
        return hc2;
    }

    public String toString() {
        if (isInfinity()) {
            return "INF";
        }
        StringBuffer sb2 = new StringBuffer();
        sb2.append('(');
        sb2.append((Object) getRawXCoord());
        sb2.append(',');
        sb2.append((Object) getRawYCoord());
        for (int i10 = 0; i10 < this.zs.length; i10++) {
            sb2.append(',');
            sb2.append((Object) this.zs[i10]);
        }
        sb2.append(')');
        return sb2.toString();
    }

    public byte[] getEncoded(boolean compressed) {
        if (isInfinity()) {
            return new byte[1];
        }
        ECPoint normed = normalize();
        byte[] X = normed.getXCoord().getEncoded();
        if (compressed) {
            byte[] PO = new byte[X.length + 1];
            PO[0] = (byte) (normed.getCompressionYTilde() ? 3 : 2);
            System.arraycopy((Object) X, 0, (Object) PO, 1, X.length);
            return PO;
        }
        byte[] Y = normed.getYCoord().getEncoded();
        byte[] PO2 = new byte[X.length + Y.length + 1];
        PO2[0] = 4;
        System.arraycopy((Object) X, 0, (Object) PO2, 1, X.length);
        System.arraycopy((Object) Y, 0, (Object) PO2, X.length + 1, Y.length);
        return PO2;
    }

    public ECPoint timesPow2(int e2) {
        if (e2 < 0) {
            throw new IllegalArgumentException("'e' cannot be negative");
        }
        ECPoint p10 = this;
        while (true) {
            e2--;
            if (e2 >= 0) {
                p10 = p10.twice();
            } else {
                return p10;
            }
        }
    }

    public ECPoint twicePlus(ECPoint b4) {
        return twice().add(b4);
    }

    public ECPoint threeTimes() {
        return twicePlus(this);
    }

    public ECPoint multiply(BigInteger k10) {
        return getCurve().getMultiplier().multiply(this, k10);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static abstract class AbstractFp extends ECPoint {
        /* JADX INFO: Access modifiers changed from: protected */
        public AbstractFp(ECCurve curve, ECFieldElement x10, ECFieldElement y10) {
            super(curve, x10, y10);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public AbstractFp(ECCurve curve, ECFieldElement x10, ECFieldElement y10, ECFieldElement[] zs) {
            super(curve, x10, y10, zs);
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
        protected boolean getCompressionYTilde() {
            return getAffineYCoord().testBitZero();
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
        protected boolean satisfiesCurveEquation() {
            ECFieldElement X = this.f9276x;
            ECFieldElement Y = this.f9277y;
            ECFieldElement A = this.curve.getA();
            ECFieldElement B = this.curve.getB();
            ECFieldElement lhs = Y.square();
            switch (getCurveCoordinateSystem()) {
                case 0:
                    break;
                case 1:
                    ECFieldElement Z = this.zs[0];
                    if (!Z.isOne()) {
                        ECFieldElement Z2 = Z.square();
                        ECFieldElement Z3 = Z.multiply(Z2);
                        lhs = lhs.multiply(Z);
                        A = A.multiply(Z2);
                        B = B.multiply(Z3);
                        break;
                    }
                    break;
                case 2:
                case 3:
                case 4:
                    ECFieldElement Z4 = this.zs[0];
                    if (!Z4.isOne()) {
                        ECFieldElement Z22 = Z4.square();
                        ECFieldElement Z42 = Z22.square();
                        ECFieldElement Z6 = Z22.multiply(Z42);
                        A = A.multiply(Z42);
                        B = B.multiply(Z6);
                        break;
                    }
                    break;
                default:
                    throw new IllegalStateException("unsupported coordinate system");
            }
            ECFieldElement rhs = X.square().add(A).multiply(X).add(B);
            return lhs.equals(rhs);
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
        public ECPoint subtract(ECPoint b4) {
            if (b4.isInfinity()) {
                return this;
            }
            return add(b4.negate());
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Fp extends AbstractFp {
        /* JADX INFO: Access modifiers changed from: package-private */
        public Fp(ECCurve curve, ECFieldElement x10, ECFieldElement y10) {
            super(curve, x10, y10);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Fp(ECCurve curve, ECFieldElement x10, ECFieldElement y10, ECFieldElement[] zs) {
            super(curve, x10, y10, zs);
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
        protected ECPoint detach() {
            return new Fp(null, getAffineXCoord(), getAffineYCoord());
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
        public ECFieldElement getZCoord(int index) {
            if (index == 1 && 4 == getCurveCoordinateSystem()) {
                return getJacobianModifiedW();
            }
            return super.getZCoord(index);
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
        public ECPoint add(ECPoint b4) {
            ECFieldElement Z1Squared;
            ECFieldElement U2;
            ECFieldElement Z1Cubed;
            ECFieldElement Z2Squared;
            ECFieldElement U1;
            ECFieldElement Z1Squared2;
            ECFieldElement Y1;
            ECFieldElement Y3;
            ECFieldElement Z3;
            ECFieldElement Y32;
            ECFieldElement[] zs;
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
            int coord = curve.getCoordinateSystem();
            ECFieldElement X1 = this.f9276x;
            ECFieldElement Y12 = this.f9277y;
            ECFieldElement X2 = b4.f9276x;
            ECFieldElement Y2 = b4.f9277y;
            switch (coord) {
                case 0:
                    ECFieldElement dx = X2.subtract(X1);
                    ECFieldElement dy = Y2.subtract(Y12);
                    if (dx.isZero()) {
                        if (dy.isZero()) {
                            return twice();
                        }
                        return curve.getInfinity();
                    }
                    ECFieldElement gamma = dy.divide(dx);
                    ECFieldElement X3 = gamma.square().subtract(X1).subtract(X2);
                    ECFieldElement Y33 = gamma.multiply(X1.subtract(X3)).subtract(Y12);
                    return new Fp(curve, X3, Y33);
                case 1:
                    ECFieldElement Z1 = this.zs[0];
                    ECFieldElement Z2 = b4.zs[0];
                    boolean Z1IsOne = Z1.isOne();
                    boolean Z2IsOne = Z2.isOne();
                    ECFieldElement u12 = Z1IsOne ? Y2 : Y2.multiply(Z1);
                    ECFieldElement u22 = Z2IsOne ? Y12 : Y12.multiply(Z2);
                    ECFieldElement u10 = u12.subtract(u22);
                    ECFieldElement v12 = Z1IsOne ? X2 : X2.multiply(Z1);
                    ECFieldElement v2 = Z2IsOne ? X1 : X1.multiply(Z2);
                    ECFieldElement v10 = v12.subtract(v2);
                    if (v10.isZero()) {
                        if (u10.isZero()) {
                            return twice();
                        }
                        return curve.getInfinity();
                    }
                    ECFieldElement w3 = Z1IsOne ? Z2 : Z2IsOne ? Z1 : Z1.multiply(Z2);
                    ECFieldElement vSquared = v10.square();
                    ECFieldElement vCubed = vSquared.multiply(v10);
                    ECFieldElement vSquaredV2 = vSquared.multiply(v2);
                    ECFieldElement A = u10.square().multiply(w3).subtract(vCubed).subtract(two(vSquaredV2));
                    ECFieldElement X32 = v10.multiply(A);
                    ECFieldElement Y34 = vSquaredV2.subtract(A).multiplyMinusProduct(u10, u22, vCubed);
                    ECFieldElement Z32 = vCubed.multiply(w3);
                    return new Fp(curve, X32, Y34, new ECFieldElement[]{Z32});
                case 2:
                case 4:
                    ECFieldElement Z12 = this.zs[0];
                    ECFieldElement Z22 = b4.zs[0];
                    boolean Z1IsOne2 = Z12.isOne();
                    if (!Z1IsOne2 && Z12.equals(Z22)) {
                        ECFieldElement dx2 = X1.subtract(X2);
                        ECFieldElement dy2 = Y12.subtract(Y2);
                        if (dx2.isZero()) {
                            if (dy2.isZero()) {
                                return twice();
                            }
                            return curve.getInfinity();
                        }
                        ECFieldElement C = dx2.square();
                        ECFieldElement W1 = X1.multiply(C);
                        ECFieldElement W2 = X2.multiply(C);
                        ECFieldElement A1 = W1.subtract(W2).multiply(Y12);
                        ECFieldElement X33 = dy2.square().subtract(W1).subtract(W2);
                        ECFieldElement Y35 = W1.subtract(X33).multiply(dy2).subtract(A1);
                        Z3 = dx2.multiply(Z12);
                        Y3 = Y35;
                        Y32 = null;
                        Y1 = X33;
                    } else {
                        if (Z1IsOne2) {
                            Z1Squared = Z12;
                            U2 = X2;
                            Z1Cubed = Y2;
                        } else {
                            Z1Squared = Z12.square();
                            U2 = Z1Squared.multiply(X2);
                            ECFieldElement Z1Cubed2 = Z1Squared.multiply(Z12);
                            Z1Cubed = Z1Cubed2.multiply(Y2);
                        }
                        boolean Z2IsOne2 = Z22.isOne();
                        if (Z2IsOne2) {
                            Z2Squared = Z22;
                            U1 = X1;
                            Z1Squared2 = Y12;
                        } else {
                            Z2Squared = Z22.square();
                            U1 = Z2Squared.multiply(X1);
                            ECFieldElement Z2Cubed = Z2Squared.multiply(Z22);
                            Z1Squared2 = Z2Cubed.multiply(Y12);
                        }
                        ECFieldElement H = U1.subtract(U2);
                        ECFieldElement R = Z1Squared2.subtract(Z1Cubed);
                        if (!H.isZero()) {
                            ECFieldElement HSquared = H.square();
                            ECFieldElement G = HSquared.multiply(H);
                            ECFieldElement V = HSquared.multiply(U1);
                            ECFieldElement U12 = R.square();
                            Y1 = U12.add(G).subtract(two(V));
                            Y3 = V.subtract(Y1).multiplyMinusProduct(R, G, Z1Squared2);
                            if (!Z1IsOne2) {
                                ECFieldElement Z33 = H.multiply(Z12);
                                Z3 = Z33;
                            } else {
                                Z3 = H;
                            }
                            if (!Z2IsOne2) {
                                Z3 = Z3.multiply(Z22);
                            }
                            if (Z3 != H) {
                                Y32 = null;
                            } else {
                                Y32 = HSquared;
                            }
                        } else {
                            if (R.isZero()) {
                                return twice();
                            }
                            return curve.getInfinity();
                        }
                    }
                    if (coord == 4) {
                        ECFieldElement W3 = calculateJacobianModifiedW(Z3, Y32);
                        zs = new ECFieldElement[]{Z3, W3};
                    } else {
                        zs = new ECFieldElement[]{Z3};
                    }
                    return new Fp(curve, Y1, Y3, zs);
                case 3:
                default:
                    throw new IllegalStateException("unsupported coordinate system");
            }
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
        public ECPoint twice() {
            ECFieldElement M;
            ECFieldElement Z1Squared;
            if (isInfinity()) {
                return this;
            }
            ECCurve curve = getCurve();
            ECFieldElement Y1 = this.f9277y;
            if (Y1.isZero()) {
                return curve.getInfinity();
            }
            int coord = curve.getCoordinateSystem();
            ECFieldElement X1 = this.f9276x;
            switch (coord) {
                case 0:
                    ECFieldElement X1Squared = X1.square();
                    ECFieldElement gamma = three(X1Squared).add(getCurve().getA()).divide(two(Y1));
                    ECFieldElement X3 = gamma.square().subtract(two(X1));
                    ECFieldElement Y3 = gamma.multiply(X1.subtract(X3)).subtract(Y1);
                    return new Fp(curve, X3, Y3);
                case 1:
                    ECFieldElement Z1 = this.zs[0];
                    boolean Z1IsOne = Z1.isOne();
                    ECFieldElement w3 = curve.getA();
                    if (!w3.isZero() && !Z1IsOne) {
                        w3 = w3.multiply(Z1.square());
                    }
                    ECFieldElement w10 = w3.add(three(X1.square()));
                    ECFieldElement s2 = Z1IsOne ? Y1 : Y1.multiply(Z1);
                    ECFieldElement t2 = Z1IsOne ? Y1.square() : s2.multiply(Y1);
                    ECFieldElement B = X1.multiply(t2);
                    ECFieldElement _4B = four(B);
                    ECFieldElement h10 = w10.square().subtract(two(_4B));
                    ECFieldElement _2s = two(s2);
                    ECFieldElement X32 = h10.multiply(_2s);
                    ECFieldElement _2t = two(t2);
                    ECFieldElement Y32 = _4B.subtract(h10).multiply(w10).subtract(two(_2t.square()));
                    ECFieldElement _4sSquared = Z1IsOne ? two(_2t) : _2s.square();
                    return new Fp(curve, X32, Y32, new ECFieldElement[]{two(_4sSquared).multiply(s2)});
                case 2:
                    ECFieldElement Z12 = this.zs[0];
                    boolean Z1IsOne2 = Z12.isOne();
                    ECFieldElement Y1Squared = Y1.square();
                    ECFieldElement T = Y1Squared.square();
                    ECFieldElement a42 = curve.getA();
                    ECFieldElement a4Neg = a42.negate();
                    if (a4Neg.toBigInteger().equals(BigInteger.valueOf(3L))) {
                        ECFieldElement Z1Squared2 = Z1IsOne2 ? Z12 : Z12.square();
                        M = three(X1.add(Z1Squared2).multiply(X1.subtract(Z1Squared2)));
                        Z1Squared = four(Y1Squared.multiply(X1));
                    } else {
                        ECFieldElement X1Squared2 = X1.square();
                        M = three(X1Squared2);
                        if (Z1IsOne2) {
                            M = M.add(a42);
                        } else if (!a42.isZero()) {
                            ECFieldElement Z1Squared3 = Z12.square();
                            ECFieldElement Z1Pow4 = Z1Squared3.square();
                            int bitLength = a4Neg.bitLength();
                            int coord2 = a42.bitLength();
                            if (bitLength < coord2) {
                                M = M.subtract(Z1Pow4.multiply(a4Neg));
                            } else {
                                M = M.add(Z1Pow4.multiply(a42));
                            }
                        }
                        Z1Squared = four(X1.multiply(Y1Squared));
                    }
                    ECFieldElement X33 = M.square().subtract(two(Z1Squared));
                    ECFieldElement Y33 = Z1Squared.subtract(X33).multiply(M).subtract(eight(T));
                    ECFieldElement Z3 = two(Y1);
                    if (!Z1IsOne2) {
                        Z3 = Z3.multiply(Z12);
                    }
                    return new Fp(curve, X33, Y33, new ECFieldElement[]{Z3});
                case 3:
                default:
                    throw new IllegalStateException("unsupported coordinate system");
                case 4:
                    return twiceJacobianModified(true);
            }
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
            ECCurve curve = getCurve();
            int coord = curve.getCoordinateSystem();
            switch (coord) {
                case 0:
                    ECFieldElement X1 = this.f9276x;
                    ECFieldElement X2 = b4.f9276x;
                    ECFieldElement Y2 = b4.f9277y;
                    ECFieldElement dx = X2.subtract(X1);
                    ECFieldElement dy = Y2.subtract(Y1);
                    if (dx.isZero()) {
                        if (!dy.isZero()) {
                            return this;
                        }
                        return threeTimes();
                    }
                    ECFieldElement X = dx.square();
                    ECFieldElement Y = dy.square();
                    ECFieldElement d10 = X.multiply(two(X1).add(X2)).subtract(Y);
                    if (d10.isZero()) {
                        return curve.getInfinity();
                    }
                    ECFieldElement D = d10.multiply(dx);
                    ECFieldElement I = D.invert();
                    ECFieldElement L1 = d10.multiply(I).multiply(dy);
                    ECFieldElement L2 = two(Y1).multiply(X).multiply(dx).multiply(I).subtract(L1);
                    ECFieldElement subtract = L2.subtract(L1);
                    ECFieldElement Y22 = L1.add(L2);
                    ECFieldElement X4 = subtract.multiply(Y22).add(X2);
                    ECFieldElement Y4 = X1.subtract(X4).multiply(L2).subtract(Y1);
                    return new Fp(curve, X4, Y4);
                case 4:
                    return twiceJacobianModified(false).add(b4);
                default:
                    return twice().add(b4);
            }
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
        public ECPoint threeTimes() {
            if (isInfinity()) {
                return this;
            }
            ECFieldElement Y1 = this.f9277y;
            if (Y1.isZero()) {
                return this;
            }
            ECCurve curve = getCurve();
            int coord = curve.getCoordinateSystem();
            switch (coord) {
                case 0:
                    ECFieldElement X1 = this.f9276x;
                    ECFieldElement _2Y1 = two(Y1);
                    ECFieldElement X = _2Y1.square();
                    ECFieldElement Z = three(X1.square()).add(getCurve().getA());
                    ECFieldElement Y = Z.square();
                    ECFieldElement d10 = three(X1).multiply(X).subtract(Y);
                    if (d10.isZero()) {
                        return getCurve().getInfinity();
                    }
                    ECFieldElement D = d10.multiply(_2Y1);
                    ECFieldElement I = D.invert();
                    ECFieldElement L1 = d10.multiply(I).multiply(Z);
                    ECFieldElement L2 = X.square().multiply(I).subtract(L1);
                    ECFieldElement X4 = L2.subtract(L1).multiply(L1.add(L2)).add(X1);
                    ECFieldElement Y4 = X1.subtract(X4).multiply(L2).subtract(Y1);
                    return new Fp(curve, X4, Y4);
                case 4:
                    return twiceJacobianModified(false).add(this);
                default:
                    return twice().add(this);
            }
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
        public ECPoint timesPow2(int e2) {
            int i10 = e2;
            if (i10 < 0) {
                throw new IllegalArgumentException("'e' cannot be negative");
            }
            if (i10 == 0 || isInfinity()) {
                return this;
            }
            if (i10 == 1) {
                return twice();
            }
            ECCurve curve = getCurve();
            ECFieldElement Y1 = this.f9277y;
            if (Y1.isZero()) {
                return curve.getInfinity();
            }
            int coord = curve.getCoordinateSystem();
            ECFieldElement W1 = curve.getA();
            ECFieldElement X1 = this.f9276x;
            ECFieldElement Z1 = this.zs.length < 1 ? curve.fromBigInteger(ECConstants.ONE) : this.zs[0];
            if (!Z1.isOne()) {
                switch (coord) {
                    case 0:
                        break;
                    case 1:
                        ECFieldElement Z1Sq = Z1.square();
                        X1 = X1.multiply(Z1);
                        Y1 = Y1.multiply(Z1Sq);
                        W1 = calculateJacobianModifiedW(Z1, Z1Sq);
                        break;
                    case 2:
                        W1 = calculateJacobianModifiedW(Z1, null);
                        break;
                    case 3:
                    default:
                        throw new IllegalStateException("unsupported coordinate system");
                    case 4:
                        W1 = getJacobianModifiedW();
                        break;
                }
            }
            int i11 = 0;
            while (i11 < i10) {
                if (Y1.isZero()) {
                    return curve.getInfinity();
                }
                ECFieldElement X1Squared = X1.square();
                ECFieldElement M = three(X1Squared);
                ECFieldElement _2Y1 = two(Y1);
                ECFieldElement _2Y1Squared = _2Y1.multiply(Y1);
                ECFieldElement S = two(X1.multiply(_2Y1Squared));
                ECFieldElement _4T = _2Y1Squared.square();
                ECFieldElement _8T = two(_4T);
                if (!W1.isZero()) {
                    M = M.add(W1);
                    ECFieldElement X1Squared2 = _8T.multiply(W1);
                    W1 = two(X1Squared2);
                }
                ECFieldElement X1Squared3 = M.square();
                ECFieldElement W12 = W1;
                X1 = X1Squared3.subtract(two(S));
                Y1 = M.multiply(S.subtract(X1)).subtract(_8T);
                Z1 = Z1.isOne() ? _2Y1 : _2Y1.multiply(Z1);
                i11++;
                i10 = e2;
                W1 = W12;
            }
            switch (coord) {
                case 0:
                    ECFieldElement zInv = Z1.invert();
                    ECFieldElement zInv2 = zInv.square();
                    ECFieldElement zInv3 = zInv2.multiply(zInv);
                    return new Fp(curve, X1.multiply(zInv2), Y1.multiply(zInv3));
                case 1:
                    return new Fp(curve, X1.multiply(Z1), Y1, new ECFieldElement[]{Z1.multiply(Z1.square())});
                case 2:
                    return new Fp(curve, X1, Y1, new ECFieldElement[]{Z1});
                case 3:
                default:
                    throw new IllegalStateException("unsupported coordinate system");
                case 4:
                    return new Fp(curve, X1, Y1, new ECFieldElement[]{Z1, W1});
            }
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
            ECCurve curve = getCurve();
            int coord = curve.getCoordinateSystem();
            if (coord != 0) {
                return new Fp(curve, this.f9276x, this.f9277y.negate(), this.zs);
            }
            return new Fp(curve, this.f9276x, this.f9277y.negate());
        }

        protected ECFieldElement calculateJacobianModifiedW(ECFieldElement Z, ECFieldElement ZSquared) {
            ECFieldElement a42 = getCurve().getA();
            if (a42.isZero() || Z.isOne()) {
                return a42;
            }
            if (ZSquared == null) {
                ZSquared = Z.square();
            }
            ECFieldElement W = ZSquared.square();
            ECFieldElement a4Neg = a42.negate();
            if (a4Neg.bitLength() < a42.bitLength()) {
                return W.multiply(a4Neg).negate();
            }
            return W.multiply(a42);
        }

        protected ECFieldElement getJacobianModifiedW() {
            ECFieldElement W = this.zs[1];
            if (W == null) {
                ECFieldElement[] eCFieldElementArr = this.zs;
                ECFieldElement W2 = calculateJacobianModifiedW(this.zs[0], null);
                eCFieldElementArr[1] = W2;
                return W2;
            }
            return W;
        }

        protected Fp twiceJacobianModified(boolean calculateW) {
            ECFieldElement X1 = this.f9276x;
            ECFieldElement Y1 = this.f9277y;
            ECFieldElement Z1 = this.zs[0];
            ECFieldElement W1 = getJacobianModifiedW();
            ECFieldElement X1Squared = X1.square();
            ECFieldElement M = three(X1Squared).add(W1);
            ECFieldElement _2Y1 = two(Y1);
            ECFieldElement _2Y1Squared = _2Y1.multiply(Y1);
            ECFieldElement S = two(X1.multiply(_2Y1Squared));
            ECFieldElement X3 = M.square().subtract(two(S));
            ECFieldElement _4T = _2Y1Squared.square();
            ECFieldElement _8T = two(_4T);
            ECFieldElement Y3 = M.multiply(S.subtract(X3)).subtract(_8T);
            ECFieldElement W3 = calculateW ? two(_8T.multiply(W1)) : null;
            ECFieldElement Z3 = Z1.isOne() ? _2Y1 : _2Y1.multiply(Z1);
            return new Fp(getCurve(), X3, Y3, new ECFieldElement[]{Z3, W3});
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static abstract class AbstractF2m extends ECPoint {
        protected AbstractF2m(ECCurve curve, ECFieldElement x10, ECFieldElement y10) {
            super(curve, x10, y10);
        }

        protected AbstractF2m(ECCurve curve, ECFieldElement x10, ECFieldElement y10, ECFieldElement[] zs) {
            super(curve, x10, y10, zs);
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
        protected boolean satisfiesCurveEquation() {
            ECFieldElement Z2;
            ECFieldElement Z4;
            ECCurve curve = getCurve();
            ECFieldElement X = this.f9276x;
            ECFieldElement A = curve.getA();
            ECFieldElement B = curve.getB();
            int coord = curve.getCoordinateSystem();
            if (coord == 6) {
                ECFieldElement Z = this.zs[0];
                boolean ZIsOne = Z.isOne();
                if (X.isZero()) {
                    ECFieldElement lhs = this.f9277y.square();
                    ECFieldElement rhs = B;
                    if (!ZIsOne) {
                        rhs = rhs.multiply(Z.square());
                    }
                    return lhs.equals(rhs);
                }
                ECFieldElement Y = this.f9277y;
                ECFieldElement X2 = X.square();
                if (ZIsOne) {
                    Z2 = Y.square().add(Y).add(A);
                    Z4 = X2.square().add(B);
                } else {
                    ECFieldElement Z22 = Z.square();
                    ECFieldElement Z42 = Z22.square();
                    Z2 = Y.add(Z).multiplyPlusProduct(Y, A, Z22);
                    Z4 = X2.squarePlusProduct(B, Z42);
                }
                return Z2.multiply(X2).equals(Z4);
            }
            ECFieldElement Z3 = this.f9277y;
            ECFieldElement lhs2 = Z3.add(X).multiply(Z3);
            switch (coord) {
                case 0:
                    break;
                case 1:
                    ECFieldElement Z5 = this.zs[0];
                    if (!Z5.isOne()) {
                        ECFieldElement Z32 = Z5.multiply(Z5.square());
                        lhs2 = lhs2.multiply(Z5);
                        A = A.multiply(Z5);
                        B = B.multiply(Z32);
                        break;
                    }
                    break;
                default:
                    throw new IllegalStateException("unsupported coordinate system");
            }
            return lhs2.equals(X.add(A).multiply(X.square()).add(B));
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
        protected boolean satisfiesOrder() {
            BigInteger cofactor = this.curve.getCofactor();
            if (ECConstants.TWO.equals(cofactor)) {
                return ((ECFieldElement.AbstractF2m) normalize().getAffineXCoord()).trace() != 0;
            }
            if (ECConstants.FOUR.equals(cofactor)) {
                ECPoint N = normalize();
                ECFieldElement X = N.getAffineXCoord();
                ECFieldElement L = ((ECCurve.AbstractF2m) this.curve).solveQuadraticEquation(X.add(this.curve.getA()));
                if (L == null) {
                    return false;
                }
                ECFieldElement Y = N.getAffineYCoord();
                ECFieldElement T = X.multiply(L).add(Y);
                return ((ECFieldElement.AbstractF2m) T).trace() == 0;
            }
            return super.satisfiesOrder();
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
        public ECPoint scaleX(ECFieldElement scale) {
            if (isInfinity()) {
                return this;
            }
            int coord = getCurveCoordinateSystem();
            switch (coord) {
                case 5:
                    ECFieldElement X = getRawXCoord();
                    ECFieldElement L = getRawYCoord();
                    ECFieldElement L2 = L.add(X).divide(scale).add(X.multiply(scale));
                    return getCurve().createRawPoint(X, L2, getRawZCoords());
                case 6:
                    ECFieldElement X2 = getRawXCoord();
                    ECFieldElement L3 = getRawYCoord();
                    ECFieldElement Z = getRawZCoords()[0];
                    ECFieldElement X22 = X2.multiply(scale.square());
                    ECFieldElement L22 = L3.add(X2).add(X22);
                    ECFieldElement Z2 = Z.multiply(scale);
                    return getCurve().createRawPoint(X22, L22, new ECFieldElement[]{Z2});
                default:
                    return super.scaleX(scale);
            }
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
        public ECPoint scaleXNegateY(ECFieldElement scale) {
            return scaleX(scale);
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
        public ECPoint scaleY(ECFieldElement scale) {
            if (isInfinity()) {
                return this;
            }
            int coord = getCurveCoordinateSystem();
            switch (coord) {
                case 5:
                case 6:
                    ECFieldElement X = getRawXCoord();
                    ECFieldElement L = getRawYCoord();
                    ECFieldElement L2 = L.add(X).multiply(scale).add(X);
                    return getCurve().createRawPoint(X, L2, getRawZCoords());
                default:
                    return super.scaleY(scale);
            }
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
        public ECPoint scaleYNegateX(ECFieldElement scale) {
            return scaleY(scale);
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
        public ECPoint subtract(ECPoint b4) {
            if (b4.isInfinity()) {
                return this;
            }
            return add(b4.negate());
        }

        public AbstractF2m tau() {
            if (isInfinity()) {
                return this;
            }
            ECCurve curve = getCurve();
            int coord = curve.getCoordinateSystem();
            ECFieldElement X1 = this.f9276x;
            switch (coord) {
                case 0:
                case 5:
                    ECFieldElement Y1 = this.f9277y;
                    return (AbstractF2m) curve.createRawPoint(X1.square(), Y1.square());
                case 1:
                case 6:
                    ECFieldElement Y12 = this.f9277y;
                    ECFieldElement Z1 = this.zs[0];
                    return (AbstractF2m) curve.createRawPoint(X1.square(), Y12.square(), new ECFieldElement[]{Z1.square()});
                case 2:
                case 3:
                case 4:
                default:
                    throw new IllegalStateException("unsupported coordinate system");
            }
        }

        public AbstractF2m tauPow(int pow) {
            if (isInfinity()) {
                return this;
            }
            ECCurve curve = getCurve();
            int coord = curve.getCoordinateSystem();
            ECFieldElement X1 = this.f9276x;
            switch (coord) {
                case 0:
                case 5:
                    ECFieldElement Y1 = this.f9277y;
                    return (AbstractF2m) curve.createRawPoint(X1.squarePow(pow), Y1.squarePow(pow));
                case 1:
                case 6:
                    ECFieldElement Y12 = this.f9277y;
                    ECFieldElement Z1 = this.zs[0];
                    return (AbstractF2m) curve.createRawPoint(X1.squarePow(pow), Y12.squarePow(pow), new ECFieldElement[]{Z1.squarePow(pow)});
                case 2:
                case 3:
                case 4:
                default:
                    throw new IllegalStateException("unsupported coordinate system");
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class F2m extends AbstractF2m {
        /* JADX INFO: Access modifiers changed from: package-private */
        public F2m(ECCurve curve, ECFieldElement x10, ECFieldElement y10) {
            super(curve, x10, y10);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public F2m(ECCurve curve, ECFieldElement x10, ECFieldElement y10, ECFieldElement[] zs) {
            super(curve, x10, y10, zs);
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
        protected ECPoint detach() {
            return new F2m(null, getAffineXCoord(), getAffineYCoord());
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
        public ECFieldElement getYCoord() {
            int coord = getCurveCoordinateSystem();
            switch (coord) {
                case 5:
                case 6:
                    ECFieldElement X = this.f9276x;
                    ECFieldElement L = this.f9277y;
                    if (isInfinity() || X.isZero()) {
                        return L;
                    }
                    ECFieldElement Y = L.add(X).multiply(X);
                    if (6 == coord) {
                        ECFieldElement Z = this.zs[0];
                        if (!Z.isOne()) {
                            return Y.divide(Z);
                        }
                        return Y;
                    }
                    return Y;
                default:
                    return this.f9277y;
            }
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
        protected boolean getCompressionYTilde() {
            ECFieldElement X = getRawXCoord();
            if (X.isZero()) {
                return false;
            }
            ECFieldElement Y = getRawYCoord();
            switch (getCurveCoordinateSystem()) {
                case 5:
                case 6:
                    return Y.testBitZero() != X.testBitZero();
                default:
                    return Y.divide(X).testBitZero();
            }
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
        public ECPoint add(ECPoint b4) {
            ECFieldElement AU2;
            ECFieldElement X3;
            ECFieldElement L3;
            if (isInfinity()) {
                return b4;
            }
            if (b4.isInfinity()) {
                return this;
            }
            ECCurve curve = getCurve();
            int coord = curve.getCoordinateSystem();
            ECFieldElement X1 = this.f9276x;
            ECFieldElement X2 = b4.f9276x;
            switch (coord) {
                case 0:
                    ECFieldElement Y1 = this.f9277y;
                    ECFieldElement Y2 = b4.f9277y;
                    ECFieldElement dx = X1.add(X2);
                    ECFieldElement dy = Y1.add(Y2);
                    if (dx.isZero()) {
                        if (dy.isZero()) {
                            return twice();
                        }
                        return curve.getInfinity();
                    }
                    ECFieldElement L = dy.divide(dx);
                    ECFieldElement X32 = L.square().add(L).add(dx).add(curve.getA());
                    ECFieldElement Y3 = L.multiply(X1.add(X32)).add(X32).add(Y1);
                    return new F2m(curve, X32, Y3);
                case 1:
                    ECFieldElement Y12 = this.f9277y;
                    ECFieldElement Z1 = this.zs[0];
                    ECFieldElement Y22 = b4.f9277y;
                    ECFieldElement Z2 = b4.zs[0];
                    boolean Z2IsOne = Z2.isOne();
                    ECFieldElement U1 = Z1.multiply(Y22);
                    ECFieldElement U2 = Z2IsOne ? Y12 : Y12.multiply(Z2);
                    ECFieldElement U = U1.add(U2);
                    ECFieldElement V1 = Z1.multiply(X2);
                    ECFieldElement V2 = Z2IsOne ? X1 : X1.multiply(Z2);
                    ECFieldElement V = V1.add(V2);
                    if (V.isZero()) {
                        if (U.isZero()) {
                            return twice();
                        }
                        return curve.getInfinity();
                    }
                    ECFieldElement VSq = V.square();
                    ECFieldElement VCu = VSq.multiply(V);
                    ECFieldElement W = Z2IsOne ? Z1 : Z1.multiply(Z2);
                    ECFieldElement uv = U.add(V);
                    ECFieldElement U22 = curve.getA();
                    ECFieldElement A = uv.multiplyPlusProduct(U, VSq, U22).multiply(W).add(VCu);
                    ECFieldElement X33 = V.multiply(A);
                    ECFieldElement VSqZ2 = Z2IsOne ? VSq : VSq.multiply(Z2);
                    ECFieldElement Y32 = U.multiplyPlusProduct(X1, V, Y12).multiplyPlusProduct(VSqZ2, uv, A);
                    return new F2m(curve, X33, Y32, new ECFieldElement[]{VCu.multiply(W)});
                case 6:
                    if (X1.isZero()) {
                        if (X2.isZero()) {
                            return curve.getInfinity();
                        }
                        return b4.add(this);
                    }
                    ECFieldElement L1 = this.f9277y;
                    ECFieldElement Z12 = this.zs[0];
                    ECFieldElement L2 = b4.f9277y;
                    ECFieldElement Z22 = b4.zs[0];
                    boolean Z1IsOne = Z12.isOne();
                    ECFieldElement U23 = X2;
                    ECFieldElement S2 = L2;
                    if (!Z1IsOne) {
                        U23 = U23.multiply(Z12);
                        S2 = S2.multiply(Z12);
                    }
                    boolean Z2IsOne2 = Z22.isOne();
                    ECFieldElement U12 = X1;
                    ECFieldElement S1 = L1;
                    if (!Z2IsOne2) {
                        U12 = U12.multiply(Z22);
                        S1 = S1.multiply(Z22);
                    }
                    ECFieldElement A2 = S1.add(S2);
                    ECFieldElement B = U12.add(U23);
                    if (B.isZero()) {
                        if (A2.isZero()) {
                            return twice();
                        }
                        return curve.getInfinity();
                    }
                    if (X2.isZero()) {
                        ECPoint p10 = normalize();
                        ECFieldElement X12 = p10.getXCoord();
                        ECFieldElement Y13 = p10.getYCoord();
                        ECFieldElement L4 = Y13.add(L2).divide(X12);
                        ECFieldElement Y23 = L4.square();
                        X3 = Y23.add(L4).add(X12).add(curve.getA());
                        if (X3.isZero()) {
                            return new F2m(curve, X3, curve.getB().sqrt());
                        }
                        ECFieldElement Y33 = L4.multiply(X12.add(X3)).add(X3).add(Y13);
                        AU2 = Y33.divide(X3).add(X3);
                        L3 = curve.fromBigInteger(ECConstants.ONE);
                    } else {
                        ECFieldElement B2 = B.square();
                        ECFieldElement AU1 = A2.multiply(U12);
                        ECFieldElement AU22 = A2.multiply(U23);
                        ECFieldElement X34 = AU1.multiply(AU22);
                        if (X34.isZero()) {
                            ECFieldElement AU12 = curve.getB().sqrt();
                            return new F2m(curve, X34, AU12);
                        }
                        ECFieldElement ABZ2 = A2.multiply(B2);
                        if (!Z2IsOne2) {
                            ABZ2 = ABZ2.multiply(Z22);
                        }
                        ECFieldElement L32 = AU22.add(B2).squarePlusProduct(ABZ2, L1.add(Z12));
                        ECFieldElement Z3 = ABZ2;
                        if (Z1IsOne) {
                            AU2 = L32;
                            X3 = X34;
                            L3 = Z3;
                        } else {
                            AU2 = L32;
                            X3 = X34;
                            L3 = Z3.multiply(Z12);
                        }
                    }
                    return new F2m(curve, X3, AU2, new ECFieldElement[]{L3});
                default:
                    throw new IllegalStateException("unsupported coordinate system");
            }
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
        public ECPoint twice() {
            ECFieldElement L3;
            ECFieldElement t2;
            if (isInfinity()) {
                return this;
            }
            ECCurve curve = getCurve();
            ECFieldElement X1 = this.f9276x;
            if (X1.isZero()) {
                return curve.getInfinity();
            }
            int coord = curve.getCoordinateSystem();
            switch (coord) {
                case 0:
                    ECFieldElement L1 = this.f9277y.divide(X1).add(X1);
                    ECFieldElement X3 = L1.square().add(L1).add(curve.getA());
                    ECFieldElement Y3 = X1.squarePlusProduct(X3, L1.addOne());
                    return new F2m(curve, X3, Y3);
                case 1:
                    ECFieldElement Y1 = this.f9277y;
                    ECFieldElement Z1 = this.zs[0];
                    boolean Z1IsOne = Z1.isOne();
                    ECFieldElement X1Z1 = Z1IsOne ? X1 : X1.multiply(Z1);
                    ECFieldElement Y1Z1 = Z1IsOne ? Y1 : Y1.multiply(Z1);
                    ECFieldElement X1Sq = X1.square();
                    ECFieldElement S = X1Sq.add(Y1Z1);
                    ECFieldElement V = X1Z1;
                    ECFieldElement vSquared = V.square();
                    ECFieldElement sv = S.add(V);
                    ECFieldElement h10 = sv.multiplyPlusProduct(S, vSquared, curve.getA());
                    ECFieldElement X32 = V.multiply(h10);
                    ECFieldElement Y32 = X1Sq.square().multiplyPlusProduct(V, h10, sv);
                    return new F2m(curve, X32, Y32, new ECFieldElement[]{V.multiply(vSquared)});
                case 6:
                    ECFieldElement L12 = this.f9277y;
                    ECFieldElement Z12 = this.zs[0];
                    boolean Z1IsOne2 = Z12.isOne();
                    ECFieldElement L1Z1 = Z1IsOne2 ? L12 : L12.multiply(Z12);
                    ECFieldElement Z1Sq = Z1IsOne2 ? Z12 : Z12.square();
                    ECFieldElement a10 = curve.getA();
                    ECFieldElement aZ1Sq = Z1IsOne2 ? a10 : a10.multiply(Z1Sq);
                    ECFieldElement T = L12.square().add(L1Z1).add(aZ1Sq);
                    if (T.isZero()) {
                        return new F2m(curve, T, curve.getB().sqrt());
                    }
                    ECFieldElement X33 = T.square();
                    ECFieldElement Z3 = Z1IsOne2 ? T : T.multiply(Z1Sq);
                    ECFieldElement b4 = curve.getB();
                    int bitLength = b4.bitLength();
                    int coord2 = curve.getFieldSize() >> 1;
                    if (bitLength < coord2) {
                        ECFieldElement t12 = L12.add(X1).square();
                        if (b4.isOne()) {
                            t2 = aZ1Sq.add(Z1Sq).square();
                        } else {
                            ECFieldElement t22 = Z1Sq.square();
                            t2 = aZ1Sq.squarePlusProduct(b4, t22);
                        }
                        L3 = t12.add(T).add(Z1Sq).multiply(t12).add(t2).add(X33);
                        if (a10.isZero()) {
                            L3 = L3.add(Z3);
                        } else if (!a10.isOne()) {
                            L3 = L3.add(a10.addOne().multiply(Z3));
                        }
                    } else {
                        ECFieldElement X1Z12 = Z1IsOne2 ? X1 : X1.multiply(Z12);
                        L3 = X1Z12.squarePlusProduct(T, L1Z1).add(X33).add(Z3);
                    }
                    return new F2m(curve, X33, L3, new ECFieldElement[]{Z3});
                default:
                    throw new IllegalStateException("unsupported coordinate system");
            }
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
        public ECPoint twicePlus(ECPoint b4) {
            if (isInfinity()) {
                return b4;
            }
            if (b4.isInfinity()) {
                return twice();
            }
            ECCurve curve = getCurve();
            ECFieldElement X1 = this.f9276x;
            if (X1.isZero()) {
                return b4;
            }
            int coord = curve.getCoordinateSystem();
            switch (coord) {
                case 6:
                    ECFieldElement X2 = b4.f9276x;
                    ECFieldElement Z2 = b4.zs[0];
                    if (!X2.isZero() && Z2.isOne()) {
                        ECFieldElement L1 = this.f9277y;
                        ECFieldElement Z1 = this.zs[0];
                        ECFieldElement L2 = b4.f9277y;
                        ECFieldElement X1Sq = X1.square();
                        ECFieldElement L1Sq = L1.square();
                        ECFieldElement Z1Sq = Z1.square();
                        ECFieldElement L1Z1 = L1.multiply(Z1);
                        ECFieldElement T = curve.getA().multiply(Z1Sq).add(L1Sq).add(L1Z1);
                        ECFieldElement L2plus1 = L2.addOne();
                        ECFieldElement A = curve.getA().add(L2plus1).multiply(Z1Sq).add(L1Sq).multiplyPlusProduct(T, X1Sq, Z1Sq);
                        ECFieldElement X2Z1Sq = X2.multiply(Z1Sq);
                        ECFieldElement B = X2Z1Sq.add(T).square();
                        if (B.isZero()) {
                            if (A.isZero()) {
                                return b4.twice();
                            }
                            return curve.getInfinity();
                        }
                        if (A.isZero()) {
                            ECFieldElement Z22 = curve.getB().sqrt();
                            return new F2m(curve, A, Z22);
                        }
                        ECFieldElement X3 = A.square().multiply(X2Z1Sq);
                        ECFieldElement Z3 = A.multiply(B).multiply(Z1Sq);
                        ECFieldElement L3 = A.add(B).square().multiplyPlusProduct(T, L2plus1, Z3);
                        return new F2m(curve, X3, L3, new ECFieldElement[]{Z3});
                    }
                    return twice().add(b4);
                default:
                    return twice().add(b4);
            }
        }

        @Override // com.android.internal.org.bouncycastle.math.ec.ECPoint
        public ECPoint negate() {
            if (isInfinity()) {
                return this;
            }
            ECFieldElement X = this.f9276x;
            if (X.isZero()) {
                return this;
            }
            switch (getCurveCoordinateSystem()) {
                case 0:
                    ECFieldElement Y = this.f9277y;
                    return new F2m(this.curve, X, Y.add(X));
                case 1:
                    ECFieldElement L = this.f9277y;
                    return new F2m(this.curve, X, L.add(X), new ECFieldElement[]{this.zs[0]});
                case 2:
                case 3:
                case 4:
                default:
                    throw new IllegalStateException("unsupported coordinate system");
                case 5:
                    ECFieldElement L2 = this.f9277y;
                    return new F2m(this.curve, X, L2.addOne());
                case 6:
                    ECFieldElement L3 = this.f9277y;
                    ECFieldElement Z = this.zs[0];
                    return new F2m(this.curve, X, L3.add(Z), new ECFieldElement[]{Z});
            }
        }
    }
}
