package com.android.internal.org.bouncycastle.math.ec.endo;

import com.android.internal.org.bouncycastle.math.ec.ECConstants;
import com.android.internal.org.bouncycastle.math.ec.ECCurve;
import com.android.internal.org.bouncycastle.math.ec.ECPoint;
import com.android.internal.org.bouncycastle.math.ec.PreCompCallback;
import com.android.internal.org.bouncycastle.math.ec.PreCompInfo;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class EndoUtil {
    public static final String PRECOMP_NAME = "bc_endo";

    public static BigInteger[] decomposeScalar(ScalarSplitParameters p10, BigInteger k10) {
        int bits = p10.getBits();
        BigInteger b12 = calculateB(k10, p10.getG1(), bits);
        BigInteger b22 = calculateB(k10, p10.getG2(), bits);
        BigInteger a10 = k10.subtract(b12.multiply(p10.getV1A()).add(b22.multiply(p10.getV2A())));
        BigInteger b4 = b12.multiply(p10.getV1B()).add(b22.multiply(p10.getV2B())).negate();
        return new BigInteger[]{a10, b4};
    }

    public static ECPoint mapPoint(final ECEndomorphism endomorphism, final ECPoint p10) {
        ECCurve c4 = p10.getCurve();
        EndoPreCompInfo precomp = (EndoPreCompInfo) c4.precompute(p10, PRECOMP_NAME, new PreCompCallback() { // from class: com.android.internal.org.bouncycastle.math.ec.endo.EndoUtil.1
            @Override // com.android.internal.org.bouncycastle.math.ec.PreCompCallback
            public PreCompInfo precompute(PreCompInfo existing) {
                EndoPreCompInfo existingEndo = existing instanceof EndoPreCompInfo ? (EndoPreCompInfo) existing : null;
                if (checkExisting(existingEndo, ECEndomorphism.this)) {
                    return existingEndo;
                }
                ECPoint mappedPoint = ECEndomorphism.this.getPointMap().map(p10);
                EndoPreCompInfo result = new EndoPreCompInfo();
                result.setEndomorphism(ECEndomorphism.this);
                result.setMappedPoint(mappedPoint);
                return result;
            }

            private boolean checkExisting(EndoPreCompInfo existingEndo, ECEndomorphism endomorphism2) {
                return (existingEndo == null || existingEndo.getEndomorphism() != endomorphism2 || existingEndo.getMappedPoint() == null) ? false : true;
            }
        });
        return precomp.getMappedPoint();
    }

    private static BigInteger calculateB(BigInteger k10, BigInteger g3, int t2) {
        boolean negative = g3.signum() < 0;
        BigInteger b4 = k10.multiply(g3.abs());
        boolean extra = b4.testBit(t2 - 1);
        BigInteger b10 = b4.shiftRight(t2);
        if (extra) {
            b10 = b10.add(ECConstants.ONE);
        }
        return negative ? b10.negate() : b10;
    }
}
