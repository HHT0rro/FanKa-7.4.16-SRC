package com.android.internal.org.bouncycastle.math.ec;

import com.android.internal.org.bouncycastle.math.ec.ECCurve;
import com.android.internal.org.bouncycastle.math.ec.ECPoint;
import java.math.BigInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class Tnaf {
    private static final BigInteger MINUS_ONE;
    private static final BigInteger MINUS_THREE;
    private static final BigInteger MINUS_TWO;
    public static final byte POW_2_WIDTH = 16;
    public static final byte WIDTH = 4;
    public static final ZTauElement[] alpha0;
    public static final byte[][] alpha0Tnaf;
    public static final ZTauElement[] alpha1;
    public static final byte[][] alpha1Tnaf;

    Tnaf() {
    }

    static {
        BigInteger negate = ECConstants.ONE.negate();
        MINUS_ONE = negate;
        MINUS_TWO = ECConstants.TWO.negate();
        BigInteger negate2 = ECConstants.THREE.negate();
        MINUS_THREE = negate2;
        alpha0 = new ZTauElement[]{null, new ZTauElement(ECConstants.ONE, ECConstants.ZERO), null, new ZTauElement(negate2, negate), null, new ZTauElement(negate, negate), null, new ZTauElement(ECConstants.ONE, negate), null};
        alpha0Tnaf = new byte[][]{null, new byte[]{1}, null, new byte[]{-1, 0, 1}, null, new byte[]{1, 0, 1}, null, new byte[]{-1, 0, 0, 1}};
        alpha1 = new ZTauElement[]{null, new ZTauElement(ECConstants.ONE, ECConstants.ZERO), null, new ZTauElement(negate2, ECConstants.ONE), null, new ZTauElement(negate, ECConstants.ONE), null, new ZTauElement(ECConstants.ONE, ECConstants.ONE), null};
        alpha1Tnaf = new byte[][]{null, new byte[]{1}, null, new byte[]{-1, 0, 1}, null, new byte[]{1, 0, 1}, null, new byte[]{-1, 0, 0, -1}};
    }

    public static BigInteger norm(byte mu, ZTauElement lambda) {
        BigInteger s12 = lambda.f9278u.multiply(lambda.f9278u);
        BigInteger s2 = lambda.f9278u.multiply(lambda.f9279v);
        BigInteger s32 = lambda.f9279v.multiply(lambda.f9279v).shiftLeft(1);
        if (mu == 1) {
            BigInteger norm = s12.add(s2).add(s32);
            return norm;
        }
        if (mu == -1) {
            BigInteger norm2 = s12.subtract(s2).add(s32);
            return norm2;
        }
        throw new IllegalArgumentException("mu must be 1 or -1");
    }

    public static SimpleBigDecimal norm(byte mu, SimpleBigDecimal u10, SimpleBigDecimal v2) {
        SimpleBigDecimal s12 = u10.multiply(u10);
        SimpleBigDecimal s2 = u10.multiply(v2);
        SimpleBigDecimal s32 = v2.multiply(v2).shiftLeft(1);
        if (mu == 1) {
            SimpleBigDecimal norm = s12.add(s2).add(s32);
            return norm;
        }
        if (mu == -1) {
            SimpleBigDecimal norm2 = s12.subtract(s2).add(s32);
            return norm2;
        }
        throw new IllegalArgumentException("mu must be 1 or -1");
    }

    public static ZTauElement round(SimpleBigDecimal lambda0, SimpleBigDecimal lambda1, byte mu) {
        SimpleBigDecimal eta;
        SimpleBigDecimal check1;
        SimpleBigDecimal check2;
        int scale = lambda0.getScale();
        if (lambda1.getScale() != scale) {
            throw new IllegalArgumentException("lambda0 and lambda1 do not have same scale");
        }
        if (mu != 1 && mu != -1) {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
        BigInteger f02 = lambda0.round();
        BigInteger f12 = lambda1.round();
        SimpleBigDecimal eta0 = lambda0.subtract(f02);
        SimpleBigDecimal eta1 = lambda1.subtract(f12);
        SimpleBigDecimal eta2 = eta0.add(eta0);
        if (mu == 1) {
            eta = eta2.add(eta1);
        } else {
            eta = eta2.subtract(eta1);
        }
        SimpleBigDecimal threeEta1 = eta1.add(eta1).add(eta1);
        SimpleBigDecimal fourEta1 = threeEta1.add(eta1);
        if (mu == 1) {
            check1 = eta0.subtract(threeEta1);
            check2 = eta0.add(fourEta1);
        } else {
            check1 = eta0.add(threeEta1);
            check2 = eta0.subtract(fourEta1);
        }
        byte h02 = 0;
        byte h12 = 0;
        if (eta.compareTo(ECConstants.ONE) >= 0) {
            if (check1.compareTo(MINUS_ONE) < 0) {
                h12 = mu;
            } else {
                h02 = 1;
            }
        } else if (check2.compareTo(ECConstants.TWO) >= 0) {
            h12 = mu;
        }
        if (eta.compareTo(MINUS_ONE) < 0) {
            if (check1.compareTo(ECConstants.ONE) >= 0) {
                h12 = (byte) (-mu);
            } else {
                h02 = -1;
            }
        } else if (check2.compareTo(MINUS_TWO) < 0) {
            h12 = (byte) (-mu);
        }
        BigInteger q02 = f02.add(BigInteger.valueOf(h02));
        BigInteger q12 = f12.add(BigInteger.valueOf(h12));
        return new ZTauElement(q02, q12);
    }

    public static SimpleBigDecimal approximateDivisionByN(BigInteger k10, BigInteger s2, BigInteger vm, byte a10, int m10, int c4) {
        int _k = ((m10 + 5) / 2) + c4;
        BigInteger ns = k10.shiftRight(((m10 - _k) - 2) + a10);
        BigInteger gs = s2.multiply(ns);
        BigInteger hs = gs.shiftRight(m10);
        BigInteger js = vm.multiply(hs);
        BigInteger gsPlusJs = gs.add(js);
        BigInteger ls = gsPlusJs.shiftRight(_k - c4);
        if (gsPlusJs.testBit((_k - c4) - 1)) {
            ls = ls.add(ECConstants.ONE);
        }
        return new SimpleBigDecimal(ls, c4);
    }

    public static byte[] tauAdicNaf(byte mu, ZTauElement lambda) {
        if (mu != 1 && mu != -1) {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
        BigInteger norm = norm(mu, lambda);
        int log2Norm = norm.bitLength();
        int maxLength = log2Norm > 30 ? log2Norm + 4 : 34;
        byte[] u10 = new byte[maxLength];
        int i10 = 0;
        int length = 0;
        BigInteger r02 = lambda.f9278u;
        BigInteger r12 = lambda.f9279v;
        while (true) {
            if (!r02.equals(ECConstants.ZERO) || !r12.equals(ECConstants.ZERO)) {
                if (r02.testBit(0)) {
                    u10[i10] = (byte) ECConstants.TWO.subtract(r02.subtract(r12.shiftLeft(1)).mod(ECConstants.FOUR)).intValue();
                    if (u10[i10] == 1) {
                        r02 = r02.clearBit(0);
                    } else {
                        r02 = r02.add(ECConstants.ONE);
                    }
                    length = i10;
                } else {
                    u10[i10] = 0;
                }
                BigInteger t2 = r02;
                BigInteger s2 = r02.shiftRight(1);
                if (mu == 1) {
                    r02 = r12.add(s2);
                } else {
                    r02 = r12.subtract(s2);
                }
                r12 = t2.shiftRight(1).negate();
                i10++;
            } else {
                int length2 = length + 1;
                byte[] tnaf = new byte[length2];
                System.arraycopy((Object) u10, 0, (Object) tnaf, 0, length2);
                return tnaf;
            }
        }
    }

    public static ECPoint.AbstractF2m tau(ECPoint.AbstractF2m p10) {
        return p10.tau();
    }

    public static byte getMu(ECCurve.AbstractF2m curve) {
        if (!curve.isKoblitz()) {
            throw new IllegalArgumentException("No Koblitz curve (ABC), TNAF multiplication not possible");
        }
        if (curve.getA().isZero()) {
            return (byte) -1;
        }
        return (byte) 1;
    }

    public static byte getMu(ECFieldElement curveA) {
        return (byte) (curveA.isZero() ? -1 : 1);
    }

    public static byte getMu(int curveA) {
        return (byte) (curveA == 0 ? -1 : 1);
    }

    public static BigInteger[] getLucas(byte mu, int k10, boolean doV) {
        BigInteger u02;
        BigInteger u12;
        BigInteger s2;
        if (mu != 1 && mu != -1) {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
        if (doV) {
            u02 = ECConstants.TWO;
            u12 = BigInteger.valueOf(mu);
        } else {
            u02 = ECConstants.ZERO;
            u12 = ECConstants.ONE;
        }
        for (int i10 = 1; i10 < k10; i10++) {
            if (mu == 1) {
                s2 = u12;
            } else {
                s2 = u12.negate();
            }
            BigInteger u22 = s2.subtract(u02.shiftLeft(1));
            u02 = u12;
            u12 = u22;
        }
        BigInteger[] retVal = {u02, u12};
        return retVal;
    }

    public static BigInteger getTw(byte mu, int w3) {
        if (w3 == 4) {
            if (mu == 1) {
                return BigInteger.valueOf(6L);
            }
            return BigInteger.valueOf(10L);
        }
        BigInteger[] us = getLucas(mu, w3, false);
        BigInteger twoToW = ECConstants.ZERO.setBit(w3);
        BigInteger u1invert = us[1].modInverse(twoToW);
        BigInteger tw = ECConstants.TWO.multiply(us[0]).multiply(u1invert).mod(twoToW);
        return tw;
    }

    public static BigInteger[] getSi(ECCurve.AbstractF2m curve) {
        if (!curve.isKoblitz()) {
            throw new IllegalArgumentException("si is defined for Koblitz curves only");
        }
        int m10 = curve.getFieldSize();
        int a10 = curve.getA().toBigInteger().intValue();
        byte mu = getMu(a10);
        int shifts = getShiftsForCofactor(curve.getCofactor());
        int index = (m10 + 3) - a10;
        BigInteger[] ui = getLucas(mu, index, false);
        if (mu == 1) {
            ui[0] = ui[0].negate();
            ui[1] = ui[1].negate();
        }
        BigInteger dividend0 = ECConstants.ONE.add(ui[1]).shiftRight(shifts);
        BigInteger dividend1 = ECConstants.ONE.add(ui[0]).shiftRight(shifts).negate();
        return new BigInteger[]{dividend0, dividend1};
    }

    public static BigInteger[] getSi(int fieldSize, int curveA, BigInteger cofactor) {
        byte mu = getMu(curveA);
        int shifts = getShiftsForCofactor(cofactor);
        int index = (fieldSize + 3) - curveA;
        BigInteger[] ui = getLucas(mu, index, false);
        if (mu == 1) {
            ui[0] = ui[0].negate();
            ui[1] = ui[1].negate();
        }
        BigInteger dividend0 = ECConstants.ONE.add(ui[1]).shiftRight(shifts);
        BigInteger dividend1 = ECConstants.ONE.add(ui[0]).shiftRight(shifts).negate();
        return new BigInteger[]{dividend0, dividend1};
    }

    protected static int getShiftsForCofactor(BigInteger h10) {
        if (h10 != null) {
            if (h10.equals(ECConstants.TWO)) {
                return 1;
            }
            if (h10.equals(ECConstants.FOUR)) {
                return 2;
            }
        }
        throw new IllegalArgumentException("h (Cofactor) must be 2 or 4");
    }

    public static ZTauElement partModReduction(BigInteger k10, int m10, byte a10, BigInteger[] s2, byte mu, byte c4) {
        BigInteger d02;
        if (mu == 1) {
            d02 = s2[0].add(s2[1]);
        } else {
            BigInteger d03 = s2[0];
            d02 = d03.subtract(s2[1]);
        }
        BigInteger[] v2 = getLucas(mu, m10, true);
        BigInteger vm = v2[1];
        SimpleBigDecimal lambda0 = approximateDivisionByN(k10, s2[0], vm, a10, m10, c4);
        SimpleBigDecimal lambda1 = approximateDivisionByN(k10, s2[1], vm, a10, m10, c4);
        ZTauElement q10 = round(lambda0, lambda1, mu);
        BigInteger r02 = k10.subtract(d02.multiply(q10.f9278u)).subtract(BigInteger.valueOf(2L).multiply(s2[1]).multiply(q10.f9279v));
        BigInteger r12 = s2[1].multiply(q10.f9278u).subtract(s2[0].multiply(q10.f9279v));
        return new ZTauElement(r02, r12);
    }

    public static ECPoint.AbstractF2m multiplyRTnaf(ECPoint.AbstractF2m p10, BigInteger k10) {
        ECCurve.AbstractF2m curve = (ECCurve.AbstractF2m) p10.getCurve();
        int m10 = curve.getFieldSize();
        int a10 = curve.getA().toBigInteger().intValue();
        byte mu = getMu(a10);
        BigInteger[] s2 = curve.getSi();
        ZTauElement rho = partModReduction(k10, m10, (byte) a10, s2, mu, (byte) 10);
        return multiplyTnaf(p10, rho);
    }

    public static ECPoint.AbstractF2m multiplyTnaf(ECPoint.AbstractF2m p10, ZTauElement lambda) {
        ECCurve.AbstractF2m curve = (ECCurve.AbstractF2m) p10.getCurve();
        byte mu = getMu(curve.getA());
        byte[] u10 = tauAdicNaf(mu, lambda);
        ECPoint.AbstractF2m q10 = multiplyFromTnaf(p10, u10);
        return q10;
    }

    public static ECPoint.AbstractF2m multiplyFromTnaf(ECPoint.AbstractF2m p10, byte[] u10) {
        ECCurve curve = p10.getCurve();
        ECPoint.AbstractF2m q10 = (ECPoint.AbstractF2m) curve.getInfinity();
        ECPoint pNeg = (ECPoint.AbstractF2m) p10.negate();
        int tauCount = 0;
        for (int i10 = u10.length - 1; i10 >= 0; i10--) {
            tauCount++;
            byte ui = u10[i10];
            if (ui != 0) {
                ECPoint.AbstractF2m q11 = q10.tauPow(tauCount);
                tauCount = 0;
                ECPoint x10 = ui > 0 ? p10 : pNeg;
                q10 = (ECPoint.AbstractF2m) q11.add(x10);
            }
        }
        if (tauCount > 0) {
            return q10.tauPow(tauCount);
        }
        return q10;
    }

    public static byte[] tauAdicWNaf(byte mu, ZTauElement lambda, byte width, BigInteger pow2w, BigInteger tw, ZTauElement[] alpha) {
        byte uLocal;
        if (mu != 1 && mu != -1) {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
        BigInteger norm = norm(mu, lambda);
        int log2Norm = norm.bitLength();
        int maxLength = log2Norm > 30 ? log2Norm + 4 + width : width + 34;
        byte[] u10 = new byte[maxLength];
        BigInteger pow2wMin1 = pow2w.shiftRight(1);
        BigInteger r02 = lambda.f9278u;
        BigInteger r12 = lambda.f9279v;
        int i10 = 0;
        while (true) {
            if (!r02.equals(ECConstants.ZERO) || !r12.equals(ECConstants.ZERO)) {
                if (!r02.testBit(0)) {
                    u10[i10] = 0;
                } else {
                    BigInteger uUnMod = r02.add(r12.multiply(tw)).mod(pow2w);
                    if (uUnMod.compareTo(pow2wMin1) >= 0) {
                        uLocal = (byte) uUnMod.subtract(pow2w).intValue();
                    } else {
                        uLocal = (byte) uUnMod.intValue();
                    }
                    u10[i10] = uLocal;
                    boolean s2 = true;
                    if (uLocal < 0) {
                        s2 = false;
                        uLocal = (byte) (-uLocal);
                    }
                    if (s2) {
                        BigInteger r03 = r02.subtract(alpha[uLocal].f9278u);
                        r12 = r12.subtract(alpha[uLocal].f9279v);
                        r02 = r03;
                    } else {
                        BigInteger r04 = r02.add(alpha[uLocal].f9278u);
                        r12 = r12.add(alpha[uLocal].f9279v);
                        r02 = r04;
                    }
                }
                BigInteger t2 = r02;
                if (mu == 1) {
                    r02 = r12.add(r02.shiftRight(1));
                } else {
                    r02 = r12.subtract(r02.shiftRight(1));
                }
                r12 = t2.shiftRight(1).negate();
                i10++;
            } else {
                return u10;
            }
        }
    }

    public static ECPoint.AbstractF2m[] getPreComp(ECPoint.AbstractF2m p10, byte a10) {
        byte[][] alphaTnaf = a10 == 0 ? alpha0Tnaf : alpha1Tnaf;
        ECPoint.AbstractF2m[] pu = new ECPoint.AbstractF2m[(alphaTnaf.length + 1) >>> 1];
        pu[0] = p10;
        int precompLen = alphaTnaf.length;
        for (int i10 = 3; i10 < precompLen; i10 += 2) {
            pu[i10 >>> 1] = multiplyFromTnaf(p10, alphaTnaf[i10]);
        }
        p10.getCurve().normalizeAll(pu);
        return pu;
    }
}
