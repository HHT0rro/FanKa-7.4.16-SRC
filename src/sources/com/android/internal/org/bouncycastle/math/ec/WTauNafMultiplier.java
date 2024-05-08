package com.android.internal.org.bouncycastle.math.ec;

import com.android.internal.org.bouncycastle.math.ec.ECCurve;
import com.android.internal.org.bouncycastle.math.ec.ECPoint;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class WTauNafMultiplier extends AbstractECMultiplier {
    static final String PRECOMP_NAME = "bc_wtnaf";

    @Override // com.android.internal.org.bouncycastle.math.ec.AbstractECMultiplier
    protected ECPoint multiplyPositive(ECPoint point, BigInteger k10) {
        if (!(point instanceof ECPoint.AbstractF2m)) {
            throw new IllegalArgumentException("Only ECPoint.AbstractF2m can be used in WTauNafMultiplier");
        }
        ECPoint.AbstractF2m p10 = (ECPoint.AbstractF2m) point;
        ECCurve.AbstractF2m curve = (ECCurve.AbstractF2m) p10.getCurve();
        int m10 = curve.getFieldSize();
        byte a10 = curve.getA().toBigInteger().byteValue();
        byte mu = Tnaf.getMu(a10);
        BigInteger[] s2 = curve.getSi();
        ZTauElement rho = Tnaf.partModReduction(k10, m10, a10, s2, mu, (byte) 10);
        return multiplyWTnaf(p10, rho, a10, mu);
    }

    private ECPoint.AbstractF2m multiplyWTnaf(ECPoint.AbstractF2m p10, ZTauElement lambda, byte a10, byte mu) {
        ZTauElement[] alpha = a10 == 0 ? Tnaf.alpha0 : Tnaf.alpha1;
        BigInteger tw = Tnaf.getTw(mu, 4);
        byte[] u10 = Tnaf.tauAdicWNaf(mu, lambda, (byte) 4, BigInteger.valueOf(16L), tw, alpha);
        return multiplyFromWTnaf(p10, u10);
    }

    private static ECPoint.AbstractF2m multiplyFromWTnaf(final ECPoint.AbstractF2m p10, byte[] u10) {
        ECCurve.AbstractF2m curve = (ECCurve.AbstractF2m) p10.getCurve();
        final byte a10 = curve.getA().toBigInteger().byteValue();
        WTauNafPreCompInfo preCompInfo = (WTauNafPreCompInfo) curve.precompute(p10, PRECOMP_NAME, new PreCompCallback() { // from class: com.android.internal.org.bouncycastle.math.ec.WTauNafMultiplier.1
            @Override // com.android.internal.org.bouncycastle.math.ec.PreCompCallback
            public PreCompInfo precompute(PreCompInfo existing) {
                if (existing instanceof WTauNafPreCompInfo) {
                    return existing;
                }
                WTauNafPreCompInfo result = new WTauNafPreCompInfo();
                result.setPreComp(Tnaf.getPreComp(ECPoint.AbstractF2m.this, a10));
                return result;
            }
        });
        ECPoint[] pu = preCompInfo.getPreComp();
        ECPoint[] puNeg = new ECPoint.AbstractF2m[pu.length];
        for (int i10 = 0; i10 < pu.length; i10++) {
            puNeg[i10] = (ECPoint.AbstractF2m) pu[i10].negate();
        }
        ECPoint.AbstractF2m q10 = (ECPoint.AbstractF2m) p10.getCurve().getInfinity();
        int tauCount = 0;
        for (int i11 = u10.length - 1; i11 >= 0; i11--) {
            tauCount++;
            int ui = u10[i11];
            if (ui != 0) {
                ECPoint.AbstractF2m q11 = q10.tauPow(tauCount);
                tauCount = 0;
                ECPoint x10 = ui > 0 ? pu[ui >>> 1] : puNeg[(-ui) >>> 1];
                q10 = (ECPoint.AbstractF2m) q11.add(x10);
            }
        }
        if (tauCount > 0) {
            return q10.tauPow(tauCount);
        }
        return q10;
    }
}
