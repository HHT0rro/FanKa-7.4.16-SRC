package com.android.internal.org.bouncycastle.math.ec;

import com.android.internal.org.bouncycastle.math.ec.endo.EndoUtil;
import com.android.internal.org.bouncycastle.math.ec.endo.GLVEndomorphism;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class GLVMultiplier extends AbstractECMultiplier {
    protected final ECCurve curve;
    protected final GLVEndomorphism glvEndomorphism;

    public GLVMultiplier(ECCurve curve, GLVEndomorphism glvEndomorphism) {
        if (curve == null || curve.getOrder() == null) {
            throw new IllegalArgumentException("Need curve with known group order");
        }
        this.curve = curve;
        this.glvEndomorphism = glvEndomorphism;
    }

    @Override // com.android.internal.org.bouncycastle.math.ec.AbstractECMultiplier
    protected ECPoint multiplyPositive(ECPoint p10, BigInteger k10) {
        if (!this.curve.equals(p10.getCurve())) {
            throw new IllegalStateException();
        }
        BigInteger n10 = p10.getCurve().getOrder();
        BigInteger[] ab2 = this.glvEndomorphism.decomposeScalar(k10.mod(n10));
        BigInteger a10 = ab2[0];
        BigInteger b4 = ab2[1];
        if (this.glvEndomorphism.hasEfficientPointMap()) {
            return ECAlgorithms.implShamirsTrickWNaf(this.glvEndomorphism, p10, a10, b4);
        }
        ECPoint q10 = EndoUtil.mapPoint(this.glvEndomorphism, p10);
        return ECAlgorithms.implShamirsTrickWNaf(p10, a10, q10, b4);
    }
}
