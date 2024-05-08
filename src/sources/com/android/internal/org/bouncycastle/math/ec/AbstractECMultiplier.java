package com.android.internal.org.bouncycastle.math.ec;

import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class AbstractECMultiplier implements ECMultiplier {
    protected abstract ECPoint multiplyPositive(ECPoint eCPoint, BigInteger bigInteger);

    @Override // com.android.internal.org.bouncycastle.math.ec.ECMultiplier
    public ECPoint multiply(ECPoint p10, BigInteger k10) {
        int sign = k10.signum();
        if (sign == 0 || p10.isInfinity()) {
            return p10.getCurve().getInfinity();
        }
        ECPoint positive = multiplyPositive(p10, k10.abs());
        ECPoint result = sign > 0 ? positive : positive.negate();
        return checkResult(result);
    }

    protected ECPoint checkResult(ECPoint p10) {
        return ECAlgorithms.implCheckResult(p10);
    }
}
