package com.android.internal.org.bouncycastle.math.ec;

import com.android.internal.org.bouncycastle.util.Integers;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class WNafL2RMultiplier extends AbstractECMultiplier {
    @Override // com.android.internal.org.bouncycastle.math.ec.AbstractECMultiplier
    protected ECPoint multiplyPositive(ECPoint p10, BigInteger k10) {
        ECPoint R;
        int minWidth = WNafUtil.getWindowSize(k10.bitLength());
        WNafPreCompInfo info = WNafUtil.precompute(p10, minWidth, true);
        ECPoint[] preComp = info.getPreComp();
        ECPoint[] preCompNeg = info.getPreCompNeg();
        int width = info.getWidth();
        int[] wnaf = WNafUtil.generateCompactWindowNaf(width, k10);
        ECPoint R2 = p10.getCurve().getInfinity();
        int i10 = wnaf.length;
        if (i10 > 1) {
            i10--;
            int wi = wnaf[i10];
            int digit = wi >> 16;
            int zeroes = wi & 65535;
            int n10 = Math.abs(digit);
            ECPoint[] table = digit < 0 ? preCompNeg : preComp;
            int minWidth2 = 1 << width;
            if ((n10 << 2) < minWidth2) {
                int highest = 32 - Integers.numberOfLeadingZeros(n10);
                int scale = width - highest;
                int lowBits = n10 ^ (1 << (highest - 1));
                int i12 = (1 << (width - 1)) - 1;
                int i22 = (lowBits << scale) + 1;
                R = table[i12 >>> 1].add(table[i22 >>> 1]);
                zeroes -= scale;
            } else {
                R = table[n10 >>> 1];
            }
            R2 = R.timesPow2(zeroes);
        }
        while (i10 > 0) {
            i10--;
            int wi2 = wnaf[i10];
            int digit2 = wi2 >> 16;
            int zeroes2 = wi2 & 65535;
            ECPoint r10 = (digit2 < 0 ? preCompNeg : preComp)[Math.abs(digit2) >>> 1];
            R2 = R2.twicePlus(r10).timesPow2(zeroes2);
        }
        return R2;
    }
}
