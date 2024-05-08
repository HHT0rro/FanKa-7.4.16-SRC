package com.android.internal.org.bouncycastle.crypto.generators;

import com.android.internal.org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.android.internal.org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import com.android.internal.org.bouncycastle.crypto.KeyGenerationParameters;
import com.android.internal.org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.android.internal.org.bouncycastle.crypto.params.RSAKeyGenerationParameters;
import com.android.internal.org.bouncycastle.crypto.params.RSAKeyParameters;
import com.android.internal.org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import com.android.internal.org.bouncycastle.math.Primes;
import com.android.internal.org.bouncycastle.math.ec.WNafUtil;
import com.android.internal.org.bouncycastle.util.BigIntegers;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class RSAKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private RSAKeyGenerationParameters param;

    @Override // com.android.internal.org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters param) {
        this.param = (RSAKeyGenerationParameters) param;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        BigInteger q10;
        BigInteger n10;
        boolean done;
        BigInteger gcd;
        BigInteger q11;
        RSAKeyPairGenerator rSAKeyPairGenerator = this;
        AsymmetricCipherKeyPair result = null;
        boolean done2 = false;
        int strength = rSAKeyPairGenerator.param.getStrength();
        int pbitlength = (strength + 1) / 2;
        int qbitlength = strength - pbitlength;
        int mindiffbits = (strength / 2) - 100;
        if (mindiffbits < strength / 3) {
            mindiffbits = strength / 3;
        }
        int minWeight = strength >> 2;
        BigInteger dLowerBound = BigInteger.valueOf(2L).pow(strength / 2);
        BigInteger bigInteger = ONE;
        BigInteger squaredBound = bigInteger.shiftLeft(strength - 1);
        BigInteger minDiff = bigInteger.shiftLeft(mindiffbits);
        while (!done2) {
            BigInteger e2 = rSAKeyPairGenerator.param.getPublicExponent();
            BigInteger p10 = rSAKeyPairGenerator.chooseRandomPrime(pbitlength, e2, squaredBound);
            while (true) {
                q10 = rSAKeyPairGenerator.chooseRandomPrime(qbitlength, e2, squaredBound);
                BigInteger diff = q10.subtract(p10).abs();
                if (diff.bitLength() < mindiffbits || diff.compareTo(minDiff) <= 0) {
                    rSAKeyPairGenerator = this;
                    done2 = done2;
                    strength = strength;
                    pbitlength = pbitlength;
                    qbitlength = qbitlength;
                } else {
                    n10 = p10.multiply(q10);
                    done = done2;
                    if (n10.bitLength() != strength) {
                        p10 = p10.max(q10);
                        done2 = done;
                    } else {
                        if (WNafUtil.getNafWeight(n10) >= minWeight) {
                            break;
                        }
                        p10 = rSAKeyPairGenerator.chooseRandomPrime(pbitlength, e2, squaredBound);
                        done2 = done;
                    }
                }
            }
            if (p10.compareTo(q10) >= 0) {
                gcd = p10;
                q11 = q10;
            } else {
                BigInteger gcd2 = p10;
                gcd = q10;
                q11 = gcd2;
            }
            BigInteger p11 = ONE;
            BigInteger pSub1 = gcd.subtract(p11);
            BigInteger qSub1 = q11.subtract(p11);
            BigInteger gcd3 = pSub1.gcd(qSub1);
            int strength2 = strength;
            BigInteger lcm = pSub1.divide(gcd3).multiply(qSub1);
            BigInteger d10 = e2.modInverse(lcm);
            if (d10.compareTo(dLowerBound) <= 0) {
                rSAKeyPairGenerator = this;
                done2 = done;
                strength = strength2;
            } else {
                BigInteger dP = d10.remainder(pSub1);
                BigInteger dQ = d10.remainder(qSub1);
                BigInteger qInv = BigIntegers.modOddInverse(gcd, q11);
                result = new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new RSAKeyParameters(false, n10, e2), (AsymmetricKeyParameter) new RSAPrivateCrtKeyParameters(n10, e2, d10, gcd, q11, dP, dQ, qInv));
                rSAKeyPairGenerator = this;
                strength = strength2;
                done2 = true;
                pbitlength = pbitlength;
                qbitlength = qbitlength;
            }
        }
        return result;
    }

    protected BigInteger chooseRandomPrime(int bitlength, BigInteger e2, BigInteger sqrdBound) {
        for (int i10 = 0; i10 != bitlength * 5; i10++) {
            BigInteger p10 = BigIntegers.createRandomPrime(bitlength, 1, this.param.getRandom());
            BigInteger mod = p10.mod(e2);
            BigInteger bigInteger = ONE;
            if (!mod.equals(bigInteger) && p10.multiply(p10).compareTo(sqrdBound) >= 0 && isProbablePrime(p10) && e2.gcd(p10.subtract(bigInteger)).equals(bigInteger)) {
                return p10;
            }
        }
        throw new IllegalStateException("unable to generate prime number for RSA key");
    }

    protected boolean isProbablePrime(BigInteger x10) {
        int iterations = getNumberOfIterations(x10.bitLength(), this.param.getCertainty());
        return !Primes.hasAnySmallFactors(x10) && Primes.isMRProbablePrime(x10, this.param.getRandom(), iterations);
    }

    private static int getNumberOfIterations(int bits, int certainty) {
        if (bits >= 1536) {
            if (certainty <= 100) {
                return 3;
            }
            if (certainty <= 128) {
                return 4;
            }
            return 4 + (((certainty - 128) + 1) / 2);
        }
        if (bits >= 1024) {
            if (certainty <= 100) {
                return 4;
            }
            if (certainty <= 112) {
                return 5;
            }
            return (((certainty - 112) + 1) / 2) + 5;
        }
        if (bits < 512) {
            if (certainty <= 80) {
                return 40;
            }
            return 40 + (((certainty - 80) + 1) / 2);
        }
        if (certainty <= 80) {
            return 5;
        }
        if (certainty <= 100) {
            return 7;
        }
        return 7 + (((certainty - 100) + 1) / 2);
    }
}
