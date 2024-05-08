package com.android.internal.org.bouncycastle.math.ec;

import com.android.internal.org.bouncycastle.math.raw.Nat;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class FixedPointCombMultiplier extends AbstractECMultiplier {
    @Override // com.android.internal.org.bouncycastle.math.ec.AbstractECMultiplier
    protected ECPoint multiplyPositive(ECPoint p10, BigInteger k10) {
        ECCurve c4 = p10.getCurve();
        int size = FixedPointUtil.getCombSize(c4);
        if (k10.bitLength() > size) {
            throw new IllegalStateException("fixed-point comb doesn't support scalars larger than the curve order");
        }
        FixedPointPreCompInfo info = FixedPointUtil.precompute(p10);
        ECLookupTable lookupTable = info.getLookupTable();
        int width = info.getWidth();
        int d10 = ((size + width) - 1) / width;
        ECPoint R = c4.getInfinity();
        int fullComb = d10 * width;
        int[] K = Nat.fromBigInteger(fullComb, k10);
        int top = fullComb - 1;
        for (int i10 = 0; i10 < d10; i10++) {
            int secretIndex = 0;
            for (int j10 = top - i10; j10 >= 0; j10 -= d10) {
                int secretBit = K[j10 >>> 5] >>> (j10 & 31);
                secretIndex = ((secretIndex ^ (secretBit >>> 1)) << 1) ^ secretBit;
            }
            ECPoint add = lookupTable.lookup(secretIndex);
            R = R.twicePlus(add);
        }
        return R.add(info.getOffset());
    }
}
