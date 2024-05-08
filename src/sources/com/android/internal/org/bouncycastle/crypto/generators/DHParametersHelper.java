package com.android.internal.org.bouncycastle.crypto.generators;

import com.android.internal.org.bouncycastle.math.ec.WNafUtil;
import com.android.internal.org.bouncycastle.util.BigIntegers;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.logging.Logger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
class DHParametersHelper {
    private static final Logger logger = Logger.getLogger(DHParametersHelper.class.getName());
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);

    DHParametersHelper() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BigInteger[] generateSafePrimes(int size, int certainty, SecureRandom random) {
        logger.info("Generating safe primes. This may take a long time.");
        long start = System.currentTimeMillis();
        int tries = 0;
        int qLength = size - 1;
        int minWeight = size >>> 2;
        while (true) {
            tries++;
            BigInteger q10 = BigIntegers.createRandomPrime(qLength, 2, random);
            BigInteger p10 = q10.shiftLeft(1).add(ONE);
            if (p10.isProbablePrime(certainty) && (certainty <= 2 || q10.isProbablePrime(certainty - 2))) {
                if (WNafUtil.getNafWeight(p10) >= minWeight) {
                    long end = System.currentTimeMillis();
                    long duration = end - start;
                    logger.info("Generated safe primes: " + tries + " tries took " + duration + "ms");
                    return new BigInteger[]{p10, q10};
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BigInteger selectGenerator(BigInteger p10, BigInteger q10, SecureRandom random) {
        BigInteger g3;
        BigInteger h10;
        BigInteger pMinusTwo = p10.subtract(TWO);
        do {
            BigInteger bigInteger = TWO;
            BigInteger h11 = BigIntegers.createRandomInRange(bigInteger, pMinusTwo, random);
            g3 = h11.modPow(bigInteger, p10);
            h10 = ONE;
        } while (g3.equals(h10));
        return g3;
    }
}
