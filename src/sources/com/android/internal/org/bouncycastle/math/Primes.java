package com.android.internal.org.bouncycastle.math;

import com.android.internal.org.bouncycastle.crypto.Digest;
import com.android.internal.org.bouncycastle.util.Arrays;
import com.android.internal.org.bouncycastle.util.BigIntegers;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class Primes {
    public static final int SMALL_FACTOR_LIMIT = 211;
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static final BigInteger THREE = BigInteger.valueOf(3);

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class MROutput {
        private BigInteger factor;
        private boolean provablyComposite;

        /* renamed from: -$$Nest$smprobablyPrime, reason: not valid java name */
        static /* bridge */ /* synthetic */ MROutput m2348$$Nest$smprobablyPrime() {
            return probablyPrime();
        }

        /* renamed from: -$$Nest$smprovablyCompositeNotPrimePower, reason: not valid java name */
        static /* bridge */ /* synthetic */ MROutput m2349$$Nest$smprovablyCompositeNotPrimePower() {
            return provablyCompositeNotPrimePower();
        }

        private static MROutput probablyPrime() {
            return new MROutput(false, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static MROutput provablyCompositeWithFactor(BigInteger factor) {
            return new MROutput(true, factor);
        }

        private static MROutput provablyCompositeNotPrimePower() {
            return new MROutput(true, null);
        }

        private MROutput(boolean provablyComposite, BigInteger factor) {
            this.provablyComposite = provablyComposite;
            this.factor = factor;
        }

        public BigInteger getFactor() {
            return this.factor;
        }

        public boolean isProvablyComposite() {
            return this.provablyComposite;
        }

        public boolean isNotPrimePower() {
            return this.provablyComposite && this.factor == null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class STOutput {
        private BigInteger prime;
        private int primeGenCounter;
        private byte[] primeSeed;

        private STOutput(BigInteger prime, byte[] primeSeed, int primeGenCounter) {
            this.prime = prime;
            this.primeSeed = primeSeed;
            this.primeGenCounter = primeGenCounter;
        }

        public BigInteger getPrime() {
            return this.prime;
        }

        public byte[] getPrimeSeed() {
            return this.primeSeed;
        }

        public int getPrimeGenCounter() {
            return this.primeGenCounter;
        }
    }

    public static STOutput generateSTRandomPrime(Digest hash, int length, byte[] inputSeed) {
        if (hash == null) {
            throw new IllegalArgumentException("'hash' cannot be null");
        }
        if (length < 2) {
            throw new IllegalArgumentException("'length' must be >= 2");
        }
        if (inputSeed == null || inputSeed.length == 0) {
            throw new IllegalArgumentException("'inputSeed' cannot be null or empty");
        }
        return implSTRandomPrime(hash, length, Arrays.clone(inputSeed));
    }

    public static MROutput enhancedMRProbablePrimeTest(BigInteger candidate, SecureRandom random, int iterations) {
        checkCandidate(candidate, "candidate");
        if (random == null) {
            throw new IllegalArgumentException("'random' cannot be null");
        }
        if (iterations < 1) {
            throw new IllegalArgumentException("'iterations' must be > 0");
        }
        if (candidate.bitLength() == 2) {
            return MROutput.m2348$$Nest$smprobablyPrime();
        }
        if (!candidate.testBit(0)) {
            return MROutput.provablyCompositeWithFactor(TWO);
        }
        BigInteger wSubOne = candidate.subtract(ONE);
        BigInteger wSubTwo = candidate.subtract(TWO);
        int a10 = wSubOne.getLowestSetBit();
        BigInteger m10 = wSubOne.shiftRight(a10);
        for (int i10 = 0; i10 < iterations; i10++) {
            BigInteger b4 = BigIntegers.createRandomInRange(TWO, wSubTwo, random);
            BigInteger g3 = b4.gcd(candidate);
            BigInteger bigInteger = ONE;
            if (g3.compareTo(bigInteger) > 0) {
                return MROutput.provablyCompositeWithFactor(g3);
            }
            BigInteger z10 = b4.modPow(m10, candidate);
            if (!z10.equals(bigInteger) && !z10.equals(wSubOne)) {
                boolean primeToBase = false;
                BigInteger x10 = z10;
                int j10 = 1;
                while (true) {
                    if (j10 >= a10) {
                        break;
                    }
                    z10 = z10.modPow(TWO, candidate);
                    if (z10.equals(wSubOne)) {
                        primeToBase = true;
                        break;
                    }
                    if (z10.equals(ONE)) {
                        break;
                    }
                    x10 = z10;
                    j10++;
                }
                if (!primeToBase) {
                    BigInteger bigInteger2 = ONE;
                    if (!z10.equals(bigInteger2)) {
                        x10 = z10;
                        BigInteger z11 = z10.modPow(TWO, candidate);
                        if (!z11.equals(bigInteger2)) {
                            x10 = z11;
                        }
                    }
                    BigInteger g10 = x10.subtract(bigInteger2).gcd(candidate);
                    if (g10.compareTo(bigInteger2) > 0) {
                        return MROutput.provablyCompositeWithFactor(g10);
                    }
                    return MROutput.m2349$$Nest$smprovablyCompositeNotPrimePower();
                }
            }
        }
        return MROutput.m2348$$Nest$smprobablyPrime();
    }

    public static boolean hasAnySmallFactors(BigInteger candidate) {
        checkCandidate(candidate, "candidate");
        return implHasAnySmallFactors(candidate);
    }

    public static boolean isMRProbablePrime(BigInteger candidate, SecureRandom random, int iterations) {
        checkCandidate(candidate, "candidate");
        if (random == null) {
            throw new IllegalArgumentException("'random' cannot be null");
        }
        if (iterations < 1) {
            throw new IllegalArgumentException("'iterations' must be > 0");
        }
        if (candidate.bitLength() == 2) {
            return true;
        }
        if (!candidate.testBit(0)) {
            return false;
        }
        BigInteger wSubOne = candidate.subtract(ONE);
        BigInteger wSubTwo = candidate.subtract(TWO);
        int a10 = wSubOne.getLowestSetBit();
        BigInteger m10 = wSubOne.shiftRight(a10);
        for (int i10 = 0; i10 < iterations; i10++) {
            BigInteger b4 = BigIntegers.createRandomInRange(TWO, wSubTwo, random);
            if (!implMRProbablePrimeToBase(candidate, wSubOne, m10, a10, b4)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isMRProbablePrimeToBase(BigInteger candidate, BigInteger base) {
        checkCandidate(candidate, "candidate");
        checkCandidate(base, "base");
        BigInteger bigInteger = ONE;
        if (base.compareTo(candidate.subtract(bigInteger)) >= 0) {
            throw new IllegalArgumentException("'base' must be < ('candidate' - 1)");
        }
        if (candidate.bitLength() == 2) {
            return true;
        }
        BigInteger wSubOne = candidate.subtract(bigInteger);
        int a10 = wSubOne.getLowestSetBit();
        BigInteger m10 = wSubOne.shiftRight(a10);
        return implMRProbablePrimeToBase(candidate, wSubOne, m10, a10, base);
    }

    private static void checkCandidate(BigInteger n10, String name) {
        if (n10 == null || n10.signum() < 1 || n10.bitLength() < 2) {
            throw new IllegalArgumentException("'" + name + "' must be non-null and >= 2");
        }
    }

    private static boolean implHasAnySmallFactors(BigInteger x10) {
        int r10 = x10.mod(BigInteger.valueOf(223092870)).intValue();
        if (r10 % 2 == 0 || r10 % 3 == 0 || r10 % 5 == 0 || r10 % 7 == 0 || r10 % 11 == 0 || r10 % 13 == 0 || r10 % 17 == 0 || r10 % 19 == 0 || r10 % 23 == 0) {
            return true;
        }
        int r11 = x10.mod(BigInteger.valueOf(58642669)).intValue();
        if (r11 % 29 == 0 || r11 % 31 == 0 || r11 % 37 == 0 || r11 % 41 == 0 || r11 % 43 == 0) {
            return true;
        }
        int r12 = x10.mod(BigInteger.valueOf(600662303)).intValue();
        if (r12 % 47 == 0 || r12 % 53 == 0 || r12 % 59 == 0 || r12 % 61 == 0 || r12 % 67 == 0) {
            return true;
        }
        int r13 = x10.mod(BigInteger.valueOf(33984931)).intValue();
        if (r13 % 71 == 0 || r13 % 73 == 0 || r13 % 79 == 0 || r13 % 83 == 0) {
            return true;
        }
        int r14 = x10.mod(BigInteger.valueOf(89809099)).intValue();
        if (r14 % 89 == 0 || r14 % 97 == 0 || r14 % 101 == 0 || r14 % 103 == 0) {
            return true;
        }
        int r15 = x10.mod(BigInteger.valueOf(167375713)).intValue();
        if (r15 % 107 == 0 || r15 % 109 == 0 || r15 % 113 == 0 || r15 % 127 == 0) {
            return true;
        }
        int r16 = x10.mod(BigInteger.valueOf(371700317)).intValue();
        if (r16 % 131 == 0 || r16 % 137 == 0 || r16 % 139 == 0 || r16 % 149 == 0) {
            return true;
        }
        int r17 = x10.mod(BigInteger.valueOf(645328247)).intValue();
        if (r17 % 151 == 0 || r17 % 157 == 0 || r17 % 163 == 0 || r17 % 167 == 0) {
            return true;
        }
        int r18 = x10.mod(BigInteger.valueOf(1070560157)).intValue();
        if (r18 % 173 == 0 || r18 % 179 == 0 || r18 % 181 == 0 || r18 % 191 == 0) {
            return true;
        }
        int r19 = x10.mod(BigInteger.valueOf(1596463769)).intValue();
        return r19 % 193 == 0 || r19 % 197 == 0 || r19 % 199 == 0 || r19 % 211 == 0;
    }

    private static boolean implMRProbablePrimeToBase(BigInteger w3, BigInteger wSubOne, BigInteger m10, int a10, BigInteger b4) {
        BigInteger z10 = b4.modPow(m10, w3);
        if (z10.equals(ONE) || z10.equals(wSubOne)) {
            return true;
        }
        for (int j10 = 1; j10 < a10; j10++) {
            z10 = z10.modPow(TWO, w3);
            if (z10.equals(wSubOne)) {
                return true;
            }
            if (z10.equals(ONE)) {
                return false;
            }
        }
        return false;
    }

    private static STOutput implSTRandomPrime(Digest d10, int length, byte[] primeSeed) {
        STOutput rec;
        BigInteger x10;
        int i10;
        String str;
        Digest digest = d10;
        int dLen = d10.getDigestSize();
        String str2 = "Too many iterations in Shawe-Taylor Random_Prime Routine";
        if (length < 33) {
            int primeGenCounter = 0;
            byte[] c02 = new byte[dLen];
            byte[] c12 = new byte[dLen];
            do {
                hash(digest, primeSeed, c02, 0);
                inc(primeSeed, 1);
                hash(digest, primeSeed, c12, 0);
                inc(primeSeed, 1);
                int c4 = extract32(c02) ^ extract32(c12);
                primeGenCounter++;
                long c64 = ((c4 & ((-1) >>> (32 - length))) | (1 << (length - 1)) | 1) & 4294967295L;
                if (isPrime32(c64)) {
                    return new STOutput(BigInteger.valueOf(c64), primeSeed, primeGenCounter);
                }
            } while (primeGenCounter <= length * 4);
            throw new IllegalStateException("Too many iterations in Shawe-Taylor Random_Prime Routine");
        }
        STOutput rec2 = implSTRandomPrime(digest, (length + 3) / 2, primeSeed);
        BigInteger c03 = rec2.getPrime();
        byte[] primeSeed2 = rec2.getPrimeSeed();
        int primeGenCounter2 = rec2.getPrimeGenCounter();
        int outlen = dLen * 8;
        int iterations = (length - 1) / outlen;
        BigInteger x11 = hashGen(digest, primeSeed2, iterations + 1);
        BigInteger bigInteger = ONE;
        BigInteger x12 = x11.mod(bigInteger.shiftLeft(length - 1)).setBit(length - 1);
        BigInteger c0x2 = c03.shiftLeft(1);
        BigInteger tx2 = x12.subtract(bigInteger).divide(c0x2).add(bigInteger).shiftLeft(1);
        BigInteger c10 = tx2.multiply(c03).add(bigInteger);
        int dt = 0;
        while (true) {
            int dt2 = dLen;
            if (c10.bitLength() <= length) {
                rec = rec2;
                x10 = x12;
                i10 = 1;
            } else {
                BigInteger bigInteger2 = ONE;
                rec = rec2;
                x10 = x12;
                i10 = 1;
                tx2 = bigInteger2.shiftLeft(length - 1).subtract(bigInteger2).divide(c0x2).add(bigInteger2).shiftLeft(1);
                c10 = tx2.multiply(c03).add(bigInteger2);
            }
            primeGenCounter2 += i10;
            if (!implHasAnySmallFactors(c10)) {
                BigInteger a10 = hashGen(digest, primeSeed2, iterations + 1);
                BigInteger a11 = a10.mod(c10.subtract(THREE)).add(TWO);
                str = str2;
                BigInteger tx22 = tx2.add(BigInteger.valueOf(dt));
                dt = 0;
                BigInteger z10 = a11.modPow(tx22, c10);
                BigInteger bigInteger3 = ONE;
                if (c10.gcd(z10.subtract(bigInteger3)).equals(bigInteger3) && z10.modPow(c03, c10).equals(bigInteger3)) {
                    return new STOutput(c10, primeSeed2, primeGenCounter2);
                }
                tx2 = tx22;
            } else {
                str = str2;
                inc(primeSeed2, iterations + 1);
            }
            if (primeGenCounter2 >= (length * 4) + primeGenCounter2) {
                throw new IllegalStateException(str);
            }
            dt += 2;
            c10 = c10.add(c0x2);
            digest = d10;
            str2 = str;
            dLen = dt2;
            rec2 = rec;
            x12 = x10;
        }
    }

    private static int extract32(byte[] bs) {
        int result = 0;
        int count = Math.min(4, bs.length);
        for (int i10 = 0; i10 < count; i10++) {
            int b4 = bs[bs.length - (i10 + 1)] & 255;
            result |= b4 << (i10 * 8);
        }
        return result;
    }

    private static void hash(Digest d10, byte[] input, byte[] output, int outPos) {
        d10.update(input, 0, input.length);
        d10.doFinal(output, outPos);
    }

    private static BigInteger hashGen(Digest d10, byte[] seed, int count) {
        int dLen = d10.getDigestSize();
        int pos = count * dLen;
        byte[] buf = new byte[pos];
        for (int i10 = 0; i10 < count; i10++) {
            pos -= dLen;
            hash(d10, seed, buf, pos);
            inc(seed, 1);
        }
        return new BigInteger(1, buf);
    }

    private static void inc(byte[] seed, int c4) {
        int pos = seed.length;
        while (c4 > 0) {
            pos--;
            if (pos >= 0) {
                int c10 = c4 + (seed[pos] & 255);
                seed[pos] = (byte) c10;
                c4 = c10 >>> 8;
            } else {
                return;
            }
        }
    }

    private static boolean isPrime32(long x10) {
        if ((x10 >>> 32) != 0) {
            throw new IllegalArgumentException("Size limit exceeded");
        }
        if (x10 <= 5) {
            return x10 == 2 || x10 == 3 || x10 == 5;
        }
        if ((1 & x10) == 0 || x10 % 3 == 0 || x10 % 5 == 0) {
            return false;
        }
        long[] ds = {1, 7, 11, 13, 17, 19, 23, 29};
        long base = 0;
        int pos = 1;
        while (true) {
            if (pos < ds.length) {
                long d10 = ds[pos] + base;
                if (x10 % d10 == 0) {
                    return x10 < 30;
                }
                pos++;
            } else {
                base += 30;
                if (base * base >= x10) {
                    return true;
                }
                pos = 0;
            }
        }
    }
}
