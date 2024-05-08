package com.android.internal.org.bouncycastle.math.ec;

import com.android.internal.org.bouncycastle.math.ec.ECCurve;
import com.android.internal.org.bouncycastle.math.ec.endo.ECEndomorphism;
import com.android.internal.org.bouncycastle.math.ec.endo.EndoUtil;
import com.android.internal.org.bouncycastle.math.ec.endo.GLVEndomorphism;
import com.android.internal.org.bouncycastle.math.field.FiniteField;
import com.android.internal.org.bouncycastle.math.field.PolynomialExtensionField;
import com.android.internal.org.bouncycastle.math.raw.Nat;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ECAlgorithms {
    public static boolean isF2mCurve(ECCurve c4) {
        return isF2mField(c4.getField());
    }

    public static boolean isF2mField(FiniteField field) {
        return field.getDimension() > 1 && field.getCharacteristic().equals(ECConstants.TWO) && (field instanceof PolynomialExtensionField);
    }

    public static boolean isFpCurve(ECCurve c4) {
        return isFpField(c4.getField());
    }

    public static boolean isFpField(FiniteField field) {
        return field.getDimension() == 1;
    }

    public static ECPoint sumOfMultiplies(ECPoint[] ps, BigInteger[] ks) {
        if (ps == null || ks == null || ps.length != ks.length || ps.length < 1) {
            throw new IllegalArgumentException("point and scalar arrays should be non-null, and of equal, non-zero, length");
        }
        int count = ps.length;
        switch (count) {
            case 1:
                return ps[0].multiply(ks[0]);
            case 2:
                return sumOfTwoMultiplies(ps[0], ks[0], ps[1], ks[1]);
            default:
                ECPoint p10 = ps[0];
                ECCurve c4 = p10.getCurve();
                ECPoint[] imported = new ECPoint[count];
                imported[0] = p10;
                for (int i10 = 1; i10 < count; i10++) {
                    imported[i10] = importPoint(c4, ps[i10]);
                }
                ECEndomorphism endomorphism = c4.getEndomorphism();
                if (endomorphism instanceof GLVEndomorphism) {
                    return implCheckResult(implSumOfMultipliesGLV(imported, ks, (GLVEndomorphism) endomorphism));
                }
                return implCheckResult(implSumOfMultiplies(imported, ks));
        }
    }

    public static ECPoint sumOfTwoMultiplies(ECPoint P, BigInteger a10, ECPoint Q, BigInteger b4) {
        ECCurve cp = P.getCurve();
        ECPoint Q2 = importPoint(cp, Q);
        if (cp instanceof ECCurve.AbstractF2m) {
            ECCurve.AbstractF2m f2mCurve = (ECCurve.AbstractF2m) cp;
            if (f2mCurve.isKoblitz()) {
                return implCheckResult(P.multiply(a10).add(Q2.multiply(b4)));
            }
        }
        ECEndomorphism endomorphism = cp.getEndomorphism();
        if (endomorphism instanceof GLVEndomorphism) {
            return implCheckResult(implSumOfMultipliesGLV(new ECPoint[]{P, Q2}, new BigInteger[]{a10, b4}, (GLVEndomorphism) endomorphism));
        }
        return implCheckResult(implShamirsTrickWNaf(P, a10, Q2, b4));
    }

    public static ECPoint shamirsTrick(ECPoint P, BigInteger k10, ECPoint Q, BigInteger l10) {
        ECCurve cp = P.getCurve();
        return implCheckResult(implShamirsTrickJsf(P, k10, importPoint(cp, Q), l10));
    }

    public static ECPoint importPoint(ECCurve c4, ECPoint p10) {
        ECCurve cp = p10.getCurve();
        if (!c4.equals(cp)) {
            throw new IllegalArgumentException("Point must be on the same curve");
        }
        return c4.importPoint(p10);
    }

    public static void montgomeryTrick(ECFieldElement[] zs, int off, int len) {
        montgomeryTrick(zs, off, len, null);
    }

    public static void montgomeryTrick(ECFieldElement[] zs, int off, int len, ECFieldElement scale) {
        ECFieldElement[] c4 = new ECFieldElement[len];
        c4[0] = zs[off];
        int i10 = 0;
        while (true) {
            i10++;
            if (i10 >= len) {
                break;
            } else {
                c4[i10] = c4[i10 - 1].multiply(zs[off + i10]);
            }
        }
        int j10 = i10 - 1;
        if (scale != null) {
            c4[j10] = c4[j10].multiply(scale);
        }
        ECFieldElement u10 = c4[j10].invert();
        while (j10 > 0) {
            int i11 = j10 - 1;
            int j11 = j10 + off;
            ECFieldElement tmp = zs[j11];
            zs[j11] = c4[i11].multiply(u10);
            u10 = u10.multiply(tmp);
            j10 = i11;
        }
        zs[off] = u10;
    }

    public static ECPoint referenceMultiply(ECPoint p10, BigInteger k10) {
        BigInteger x10 = k10.abs();
        ECPoint q10 = p10.getCurve().getInfinity();
        int t2 = x10.bitLength();
        if (t2 > 0) {
            if (x10.testBit(0)) {
                q10 = p10;
            }
            for (int i10 = 1; i10 < t2; i10++) {
                p10 = p10.twice();
                if (x10.testBit(i10)) {
                    q10 = q10.add(p10);
                }
            }
        }
        int i11 = k10.signum();
        return i11 < 0 ? q10.negate() : q10;
    }

    public static ECPoint validatePoint(ECPoint p10) {
        if (!p10.isValid()) {
            throw new IllegalStateException("Invalid point");
        }
        return p10;
    }

    public static ECPoint cleanPoint(ECCurve c4, ECPoint p10) {
        ECCurve cp = p10.getCurve();
        if (!c4.equals(cp)) {
            throw new IllegalArgumentException("Point must be on the same curve");
        }
        return c4.decodePoint(p10.getEncoded(false));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ECPoint implCheckResult(ECPoint p10) {
        if (!p10.isValidPartial()) {
            throw new IllegalStateException("Invalid result");
        }
        return p10;
    }

    static ECPoint implShamirsTrickJsf(ECPoint P, BigInteger k10, ECPoint Q, BigInteger l10) {
        ECCurve curve = P.getCurve();
        ECPoint infinity = curve.getInfinity();
        ECPoint PaddQ = P.add(Q);
        ECPoint PsubQ = P.subtract(Q);
        ECPoint[] points = {Q, PsubQ, P, PaddQ};
        curve.normalizeAll(points);
        ECPoint R = infinity;
        ECPoint[] table = {points[3].negate(), points[2].negate(), points[1].negate(), points[0].negate(), R, points[0], points[1], points[2], points[3]};
        byte[] jsf = WNafUtil.generateJSF(k10, l10);
        int i10 = jsf.length;
        while (true) {
            i10--;
            if (i10 >= 0) {
                int jsfi = jsf[i10];
                int kDigit = (jsfi << 24) >> 28;
                int lDigit = (jsfi << 28) >> 28;
                int index = (kDigit * 3) + 4 + lDigit;
                R = R.twicePlus(table[index]);
            } else {
                return R;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ECPoint implShamirsTrickWNaf(ECPoint P, BigInteger k10, ECPoint Q, BigInteger l10) {
        boolean negK = k10.signum() < 0;
        boolean negL = l10.signum() < 0;
        BigInteger kAbs = k10.abs();
        BigInteger lAbs = l10.abs();
        int minWidthP = WNafUtil.getWindowSize(kAbs.bitLength(), 8);
        int minWidthQ = WNafUtil.getWindowSize(lAbs.bitLength(), 8);
        WNafPreCompInfo infoP = WNafUtil.precompute(P, minWidthP, true);
        WNafPreCompInfo infoQ = WNafUtil.precompute(Q, minWidthQ, true);
        ECCurve c4 = P.getCurve();
        int combSize = FixedPointUtil.getCombSize(c4);
        if (!negK && !negL && k10.bitLength() <= combSize && l10.bitLength() <= combSize && infoP.isPromoted() && infoQ.isPromoted()) {
            return implShamirsTrickFixedPoint(P, k10, Q, l10);
        }
        int widthP = Math.min(8, infoP.getWidth());
        int widthQ = Math.min(8, infoQ.getWidth());
        ECPoint[] preCompP = negK ? infoP.getPreCompNeg() : infoP.getPreComp();
        ECPoint[] preCompQ = negL ? infoQ.getPreCompNeg() : infoQ.getPreComp();
        ECPoint[] preCompNegP = negK ? infoP.getPreComp() : infoP.getPreCompNeg();
        ECPoint[] preCompNegQ = negL ? infoQ.getPreComp() : infoQ.getPreCompNeg();
        byte[] wnafP = WNafUtil.generateWindowNaf(widthP, kAbs);
        byte[] wnafQ = WNafUtil.generateWindowNaf(widthQ, lAbs);
        return implShamirsTrickWNaf(preCompP, preCompNegP, wnafP, preCompQ, preCompNegQ, wnafQ);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ECPoint implShamirsTrickWNaf(ECEndomorphism endomorphism, ECPoint P, BigInteger k10, BigInteger l10) {
        boolean negK = k10.signum() < 0;
        boolean negL = l10.signum() < 0;
        BigInteger k11 = k10.abs();
        BigInteger l11 = l10.abs();
        int minWidth = WNafUtil.getWindowSize(Math.max(k11.bitLength(), l11.bitLength()), 8);
        WNafPreCompInfo infoP = WNafUtil.precompute(P, minWidth, true);
        ECPoint Q = EndoUtil.mapPoint(endomorphism, P);
        WNafPreCompInfo infoQ = WNafUtil.precomputeWithPointMap(Q, endomorphism.getPointMap(), infoP, true);
        int widthP = Math.min(8, infoP.getWidth());
        int widthQ = Math.min(8, infoQ.getWidth());
        ECPoint[] preCompP = negK ? infoP.getPreCompNeg() : infoP.getPreComp();
        ECPoint[] preCompQ = negL ? infoQ.getPreCompNeg() : infoQ.getPreComp();
        ECPoint[] preCompNegP = negK ? infoP.getPreComp() : infoP.getPreCompNeg();
        ECPoint[] preCompNegQ = negL ? infoQ.getPreComp() : infoQ.getPreCompNeg();
        byte[] wnafP = WNafUtil.generateWindowNaf(widthP, k11);
        byte[] wnafQ = WNafUtil.generateWindowNaf(widthQ, l11);
        return implShamirsTrickWNaf(preCompP, preCompNegP, wnafP, preCompQ, preCompNegQ, wnafQ);
    }

    private static ECPoint implShamirsTrickWNaf(ECPoint[] preCompP, ECPoint[] preCompNegP, byte[] wnafP, ECPoint[] preCompQ, ECPoint[] preCompNegQ, byte[] wnafQ) {
        int wiP;
        int len = Math.max(wnafP.length, wnafQ.length);
        ECCurve curve = preCompP[0].getCurve();
        ECPoint infinity = curve.getInfinity();
        ECPoint R = infinity;
        int zeroes = 0;
        int i10 = len - 1;
        while (i10 >= 0) {
            if (i10 < wnafP.length) {
                wiP = wnafP[i10];
            } else {
                wiP = 0;
            }
            int wiQ = i10 < wnafQ.length ? wnafQ[i10] : 0;
            if ((wiP | wiQ) == 0) {
                zeroes++;
            } else {
                ECPoint r10 = infinity;
                if (wiP != 0) {
                    int nP = Math.abs(wiP);
                    ECPoint[] tableP = wiP < 0 ? preCompNegP : preCompP;
                    r10 = r10.add(tableP[nP >>> 1]);
                }
                if (wiQ != 0) {
                    int nQ = Math.abs(wiQ);
                    ECPoint[] tableQ = wiQ < 0 ? preCompNegQ : preCompQ;
                    r10 = r10.add(tableQ[nQ >>> 1]);
                }
                if (zeroes > 0) {
                    R = R.timesPow2(zeroes);
                    zeroes = 0;
                }
                R = R.twicePlus(r10);
            }
            i10--;
        }
        if (zeroes > 0) {
            return R.timesPow2(zeroes);
        }
        return R;
    }

    static ECPoint implSumOfMultiplies(ECPoint[] ps, BigInteger[] ks) {
        int count = ps.length;
        boolean[] negs = new boolean[count];
        WNafPreCompInfo[] infos = new WNafPreCompInfo[count];
        byte[][] wnafs = new byte[count];
        for (int i10 = 0; i10 < count; i10++) {
            BigInteger ki = ks[i10];
            negs[i10] = ki.signum() < 0;
            BigInteger ki2 = ki.abs();
            int minWidth = WNafUtil.getWindowSize(ki2.bitLength(), 8);
            WNafPreCompInfo info = WNafUtil.precompute(ps[i10], minWidth, true);
            int width = Math.min(8, info.getWidth());
            infos[i10] = info;
            wnafs[i10] = WNafUtil.generateWindowNaf(width, ki2);
        }
        return implSumOfMultiplies(negs, infos, wnafs);
    }

    static ECPoint implSumOfMultipliesGLV(ECPoint[] ps, BigInteger[] ks, GLVEndomorphism glvEndomorphism) {
        BigInteger n10 = ps[0].getCurve().getOrder();
        int len = ps.length;
        BigInteger[] abs = new BigInteger[len << 1];
        int j10 = 0;
        for (int i10 = 0; i10 < len; i10++) {
            BigInteger[] ab2 = glvEndomorphism.decomposeScalar(ks[i10].mod(n10));
            int j11 = j10 + 1;
            abs[j10] = ab2[0];
            j10 = j11 + 1;
            abs[j11] = ab2[1];
        }
        if (glvEndomorphism.hasEfficientPointMap()) {
            return implSumOfMultiplies(glvEndomorphism, ps, abs);
        }
        ECPoint[] pqs = new ECPoint[len << 1];
        int j12 = 0;
        for (ECPoint p10 : ps) {
            ECPoint q10 = EndoUtil.mapPoint(glvEndomorphism, p10);
            int j13 = j12 + 1;
            pqs[j12] = p10;
            j12 = j13 + 1;
            pqs[j13] = q10;
        }
        return implSumOfMultiplies(pqs, abs);
    }

    static ECPoint implSumOfMultiplies(ECEndomorphism endomorphism, ECPoint[] ps, BigInteger[] ks) {
        ECPoint[] eCPointArr = ps;
        int halfCount = eCPointArr.length;
        int fullCount = halfCount << 1;
        boolean[] negs = new boolean[fullCount];
        WNafPreCompInfo[] infos = new WNafPreCompInfo[fullCount];
        byte[][] wnafs = new byte[fullCount];
        ECPointMap pointMap = endomorphism.getPointMap();
        int i10 = 0;
        while (i10 < halfCount) {
            int j02 = i10 << 1;
            int j12 = j02 + 1;
            BigInteger kj0 = ks[j02];
            boolean z10 = false;
            negs[j02] = kj0.signum() < 0;
            BigInteger kj02 = kj0.abs();
            BigInteger kj1 = ks[j12];
            if (kj1.signum() < 0) {
                z10 = true;
            }
            negs[j12] = z10;
            BigInteger kj12 = kj1.abs();
            int minWidth = WNafUtil.getWindowSize(Math.max(kj02.bitLength(), kj12.bitLength()), 8);
            ECPoint P = eCPointArr[i10];
            WNafPreCompInfo infoP = WNafUtil.precompute(P, minWidth, true);
            ECPoint Q = EndoUtil.mapPoint(endomorphism, P);
            int halfCount2 = halfCount;
            WNafPreCompInfo infoQ = WNafUtil.precomputeWithPointMap(Q, pointMap, infoP, true);
            int fullCount2 = fullCount;
            int widthP = Math.min(8, infoP.getWidth());
            int widthQ = Math.min(8, infoQ.getWidth());
            infos[j02] = infoP;
            infos[j12] = infoQ;
            wnafs[j02] = WNafUtil.generateWindowNaf(widthP, kj02);
            wnafs[j12] = WNafUtil.generateWindowNaf(widthQ, kj12);
            i10++;
            eCPointArr = ps;
            pointMap = pointMap;
            halfCount = halfCount2;
            fullCount = fullCount2;
        }
        return implSumOfMultiplies(negs, infos, wnafs);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2, types: [int] */
    /* JADX WARN: Type inference failed for: r12v4 */
    private static ECPoint implSumOfMultiplies(boolean[] zArr, WNafPreCompInfo[] wNafPreCompInfoArr, byte[][] bArr) {
        int i10 = 0;
        int length = bArr.length;
        for (byte[] bArr2 : bArr) {
            i10 = Math.max(i10, bArr2.length);
        }
        boolean z10 = false;
        ECPoint infinity = wNafPreCompInfoArr[0].getPreComp()[0].getCurve().getInfinity();
        ECPoint eCPoint = infinity;
        int i11 = 0;
        int i12 = i10 - 1;
        while (i12 >= 0) {
            ECPoint eCPoint2 = infinity;
            int i13 = 0;
            while (i13 < length) {
                byte[] bArr3 = bArr[i13];
                ?? r12 = i12 < bArr3.length ? bArr3[i12] : z10;
                if (r12 != 0) {
                    int abs = Math.abs((int) r12);
                    WNafPreCompInfo wNafPreCompInfo = wNafPreCompInfoArr[i13];
                    eCPoint2 = eCPoint2.add(((r12 < 0 ? true : z10) == zArr[i13] ? wNafPreCompInfo.getPreComp() : wNafPreCompInfo.getPreCompNeg())[abs >>> 1]);
                }
                i13++;
                z10 = false;
            }
            if (eCPoint2 == infinity) {
                i11++;
            } else {
                if (i11 > 0) {
                    eCPoint = eCPoint.timesPow2(i11);
                    i11 = 0;
                }
                eCPoint = eCPoint.twicePlus(eCPoint2);
            }
            i12--;
            z10 = false;
        }
        if (i11 > 0) {
            return eCPoint.timesPow2(i11);
        }
        return eCPoint;
    }

    private static ECPoint implShamirsTrickFixedPoint(ECPoint p10, BigInteger k10, ECPoint q10, BigInteger l10) {
        ECCurve c4 = p10.getCurve();
        int combSize = FixedPointUtil.getCombSize(c4);
        if (k10.bitLength() > combSize || l10.bitLength() > combSize) {
            throw new IllegalStateException("fixed-point comb doesn't support scalars larger than the curve order");
        }
        FixedPointPreCompInfo infoP = FixedPointUtil.precompute(p10);
        FixedPointPreCompInfo infoQ = FixedPointUtil.precompute(q10);
        ECLookupTable lookupTableP = infoP.getLookupTable();
        ECLookupTable lookupTableQ = infoQ.getLookupTable();
        int widthP = infoP.getWidth();
        int widthQ = infoQ.getWidth();
        if (widthP != widthQ) {
            FixedPointCombMultiplier m10 = new FixedPointCombMultiplier();
            ECPoint r12 = m10.multiply(p10, k10);
            ECPoint r22 = m10.multiply(q10, l10);
            return r12.add(r22);
        }
        int d10 = ((combSize + widthP) - 1) / widthP;
        ECPoint R = c4.getInfinity();
        int fullComb = d10 * widthP;
        int[] K = Nat.fromBigInteger(fullComb, k10);
        int[] L = Nat.fromBigInteger(fullComb, l10);
        int top = fullComb - 1;
        int i10 = 0;
        while (i10 < d10) {
            int secretIndexK = 0;
            ECCurve c10 = c4;
            int secretIndexL = 0;
            for (int j10 = top - i10; j10 >= 0; j10 -= d10) {
                int secretBitK = K[j10 >>> 5] >>> (j10 & 31);
                secretIndexK = ((secretIndexK ^ (secretBitK >>> 1)) << 1) ^ secretBitK;
                int secretBitL = L[j10 >>> 5] >>> (j10 & 31);
                secretIndexL = ((secretIndexL ^ (secretBitL >>> 1)) << 1) ^ secretBitL;
            }
            int combSize2 = combSize;
            ECPoint addP = lookupTableP.lookupVar(secretIndexK);
            ECPoint addQ = lookupTableQ.lookupVar(secretIndexL);
            ECPoint T = addP.add(addQ);
            R = R.twicePlus(T);
            i10++;
            c4 = c10;
            combSize = combSize2;
        }
        return R.add(infoP.getOffset()).add(infoQ.getOffset());
    }
}
