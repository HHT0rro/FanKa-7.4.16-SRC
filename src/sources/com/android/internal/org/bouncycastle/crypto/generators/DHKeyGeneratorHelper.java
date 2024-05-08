package com.android.internal.org.bouncycastle.crypto.generators;

import com.android.internal.org.bouncycastle.crypto.params.DHParameters;
import com.android.internal.org.bouncycastle.math.ec.WNafUtil;
import com.android.internal.org.bouncycastle.util.BigIntegers;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
class DHKeyGeneratorHelper {
    static final DHKeyGeneratorHelper INSTANCE = new DHKeyGeneratorHelper();
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);

    private DHKeyGeneratorHelper() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BigInteger calculatePrivate(DHParameters dhParams, SecureRandom random) {
        BigInteger x10;
        BigInteger x11;
        int limit = dhParams.getL();
        if (limit != 0) {
            int minWeight = limit >>> 2;
            do {
                x11 = BigIntegers.createRandomBigInteger(limit, random).setBit(limit - 1);
            } while (WNafUtil.getNafWeight(x11) < minWeight);
            return x11;
        }
        BigInteger min = TWO;
        int m10 = dhParams.getM();
        if (m10 != 0) {
            min = ONE.shiftLeft(m10 - 1);
        }
        BigInteger q10 = dhParams.getQ();
        if (q10 == null) {
            q10 = dhParams.getP();
        }
        BigInteger max = q10.subtract(TWO);
        int minWeight2 = max.bitLength() >>> 2;
        do {
            x10 = BigIntegers.createRandomInRange(min, max, random);
        } while (WNafUtil.getNafWeight(x10) < minWeight2);
        return x10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BigInteger calculatePublic(DHParameters dhParams, BigInteger x10) {
        return dhParams.getG().modPow(x10, dhParams.getP());
    }
}
