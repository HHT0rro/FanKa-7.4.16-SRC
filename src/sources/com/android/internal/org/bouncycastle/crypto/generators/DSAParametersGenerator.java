package com.android.internal.org.bouncycastle.crypto.generators;

import com.android.internal.org.bouncycastle.crypto.Digest;
import com.android.internal.org.bouncycastle.crypto.digests.AndroidDigestFactory;
import com.android.internal.org.bouncycastle.crypto.params.DSAParameterGenerationParameters;
import com.android.internal.org.bouncycastle.crypto.params.DSAParameters;
import com.android.internal.org.bouncycastle.crypto.params.DSAValidationParameters;
import com.android.internal.org.bouncycastle.util.Arrays;
import com.android.internal.org.bouncycastle.util.BigIntegers;
import com.android.internal.org.bouncycastle.util.encoders.Hex;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DSAParametersGenerator {
    private int L;
    private int N;
    private int certainty;
    private Digest digest;
    private int iterations;
    private SecureRandom random;
    private int usageIndex;
    private boolean use186_3;
    private static final BigInteger ZERO = BigInteger.valueOf(0);
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);

    public DSAParametersGenerator() {
        this(AndroidDigestFactory.getSHA1());
    }

    public DSAParametersGenerator(Digest digest) {
        this.digest = digest;
    }

    public void init(int size, int certainty, SecureRandom random) {
        this.L = size;
        this.N = getDefaultN(size);
        this.certainty = certainty;
        this.iterations = Math.max(getMinimumIterations(this.L), (certainty + 1) / 2);
        this.random = random;
        this.use186_3 = false;
        this.usageIndex = -1;
    }

    public void init(DSAParameterGenerationParameters params) {
        int L = params.getL();
        int N = params.getN();
        if (L < 1024 || L > 3072 || L % 1024 != 0) {
            throw new IllegalArgumentException("L values must be between 1024 and 3072 and a multiple of 1024");
        }
        if (L == 1024 && N != 160) {
            throw new IllegalArgumentException("N must be 160 for L = 1024");
        }
        if (L == 2048 && N != 224 && N != 256) {
            throw new IllegalArgumentException("N must be 224 or 256 for L = 2048");
        }
        if (L == 3072 && N != 256) {
            throw new IllegalArgumentException("N must be 256 for L = 3072");
        }
        if (this.digest.getDigestSize() * 8 < N) {
            throw new IllegalStateException("Digest output size too small for value of N");
        }
        this.L = L;
        this.N = N;
        this.certainty = params.getCertainty();
        this.iterations = Math.max(getMinimumIterations(L), (this.certainty + 1) / 2);
        this.random = params.getRandom();
        this.use186_3 = true;
        this.usageIndex = params.getUsageIndex();
    }

    public DSAParameters generateParameters() {
        if (this.use186_3) {
            return generateParameters_FIPS186_3();
        }
        return generateParameters_FIPS186_2();
    }

    private DSAParameters generateParameters_FIPS186_2() {
        byte[] seed = new byte[20];
        byte[] part1 = new byte[20];
        byte[] part2 = new byte[20];
        byte[] u10 = new byte[20];
        int i10 = this.L;
        int n10 = (i10 - 1) / 160;
        byte[] w3 = new byte[i10 / 8];
        if (!this.digest.getAlgorithmName().equals("SHA-1")) {
            throw new IllegalStateException("can only use SHA-1 for generating FIPS 186-2 parameters");
        }
        while (true) {
            this.random.nextBytes(seed);
            int i11 = 0;
            hash(this.digest, seed, part1, 0);
            System.arraycopy((Object) seed, 0, (Object) part2, 0, seed.length);
            inc(part2);
            hash(this.digest, part2, part2, 0);
            for (int i12 = 0; i12 != u10.length; i12++) {
                u10[i12] = (byte) (part1[i12] ^ part2[i12]);
            }
            int i13 = u10[0];
            u10[0] = (byte) (i13 | (-128));
            u10[19] = (byte) (u10[19] | 1);
            BigInteger q10 = new BigInteger(1, u10);
            if (isProbablePrime(q10)) {
                byte[] offset = Arrays.clone(seed);
                inc(offset);
                int counter = 0;
                while (counter < 4096) {
                    for (int k10 = 1; k10 <= n10; k10++) {
                        inc(offset);
                        hash(this.digest, offset, w3, w3.length - (part1.length * k10));
                    }
                    int k11 = w3.length;
                    int remaining = k11 - (part1.length * n10);
                    inc(offset);
                    hash(this.digest, offset, part1, i11);
                    System.arraycopy((Object) part1, part1.length - remaining, (Object) w3, i11, remaining);
                    w3[i11] = (byte) (w3[i11] | Byte.MIN_VALUE);
                    BigInteger x10 = new BigInteger(1, w3);
                    BigInteger c4 = x10.mod(q10.shiftLeft(1));
                    BigInteger p10 = x10.subtract(c4.subtract(ONE));
                    if (p10.bitLength() != this.L || !isProbablePrime(p10)) {
                        counter++;
                        i11 = 0;
                    } else {
                        BigInteger g3 = calculateGenerator_FIPS186_2(p10, q10, this.random);
                        return new DSAParameters(p10, q10, g3, new DSAValidationParameters(seed, counter));
                    }
                }
            }
        }
    }

    private static BigInteger calculateGenerator_FIPS186_2(BigInteger p10, BigInteger q10, SecureRandom r10) {
        BigInteger g3;
        BigInteger e2 = p10.subtract(ONE).divide(q10);
        BigInteger pSub2 = p10.subtract(TWO);
        do {
            BigInteger h10 = BigIntegers.createRandomInRange(TWO, pSub2, r10);
            g3 = h10.modPow(e2, p10);
        } while (g3.bitLength() <= 1);
        return g3;
    }

    private DSAParameters generateParameters_FIPS186_3() {
        BigInteger q10;
        int counter;
        BigInteger p10;
        BigInteger g3;
        Digest d10 = this.digest;
        int outlen = d10.getDigestSize() * 8;
        int seedlen = this.N;
        byte[] seed = new byte[seedlen / 8];
        int i10 = this.L;
        int n10 = (i10 - 1) / outlen;
        int i11 = (i10 - 1) % outlen;
        byte[] w3 = new byte[i10 / 8];
        byte[] output = new byte[d10.getDigestSize()];
        loop0: while (true) {
            this.random.nextBytes(seed);
            hash(d10, seed, output, 0);
            BigInteger U = new BigInteger(1, output).mod(ONE.shiftLeft(this.N - 1));
            q10 = U.setBit(0).setBit(this.N - 1);
            if (isProbablePrime(q10)) {
                byte[] offset = Arrays.clone(seed);
                int counterLimit = this.L * 4;
                counter = 0;
                while (counter < counterLimit) {
                    int j10 = 1;
                    while (j10 <= n10) {
                        inc(offset);
                        hash(d10, offset, w3, w3.length - (output.length * j10));
                        j10++;
                        outlen = outlen;
                    }
                    int outlen2 = outlen;
                    int remaining = w3.length - (output.length * n10);
                    inc(offset);
                    hash(d10, offset, output, 0);
                    System.arraycopy((Object) output, output.length - remaining, (Object) w3, 0, remaining);
                    w3[0] = (byte) (w3[0] | Byte.MIN_VALUE);
                    BigInteger X = new BigInteger(1, w3);
                    BigInteger c4 = X.mod(q10.shiftLeft(1));
                    p10 = X.subtract(c4.subtract(ONE));
                    int seedlen2 = seedlen;
                    if (p10.bitLength() == this.L && isProbablePrime(p10)) {
                        break loop0;
                    }
                    counter++;
                    outlen = outlen2;
                    seedlen = seedlen2;
                    d10 = d10;
                    w3 = w3;
                }
            }
        }
        int i12 = this.usageIndex;
        if (i12 >= 0 && (g3 = calculateGenerator_FIPS186_3_Verifiable(d10, p10, q10, seed, i12)) != null) {
            return new DSAParameters(p10, q10, g3, new DSAValidationParameters(seed, counter, this.usageIndex));
        }
        return new DSAParameters(p10, q10, calculateGenerator_FIPS186_3_Unverifiable(p10, q10, this.random), new DSAValidationParameters(seed, counter));
    }

    private boolean isProbablePrime(BigInteger x10) {
        return x10.isProbablePrime(this.certainty);
    }

    private static BigInteger calculateGenerator_FIPS186_3_Unverifiable(BigInteger p10, BigInteger q10, SecureRandom r10) {
        return calculateGenerator_FIPS186_2(p10, q10, r10);
    }

    private static BigInteger calculateGenerator_FIPS186_3_Verifiable(Digest d10, BigInteger p10, BigInteger q10, byte[] seed, int index) {
        BigInteger e2 = p10.subtract(ONE).divide(q10);
        byte[] ggen = Hex.decodeStrict("6767656E");
        byte[] U = new byte[seed.length + ggen.length + 1 + 2];
        System.arraycopy((Object) seed, 0, (Object) U, 0, seed.length);
        System.arraycopy((Object) ggen, 0, (Object) U, seed.length, ggen.length);
        U[U.length - 3] = (byte) index;
        byte[] w3 = new byte[d10.getDigestSize()];
        for (int count = 1; count < 65536; count++) {
            inc(U);
            hash(d10, U, w3, 0);
            BigInteger W = new BigInteger(1, w3);
            BigInteger g3 = W.modPow(e2, p10);
            if (g3.compareTo(TWO) >= 0) {
                return g3;
            }
        }
        return null;
    }

    private static void hash(Digest d10, byte[] input, byte[] output, int outputPos) {
        d10.update(input, 0, input.length);
        d10.doFinal(output, outputPos);
    }

    private static int getDefaultN(int L) {
        return L > 1024 ? 256 : 160;
    }

    private static int getMinimumIterations(int L) {
        if (L <= 1024) {
            return 40;
        }
        return (((L - 1) / 1024) * 8) + 48;
    }

    private static void inc(byte[] buf) {
        for (int i10 = buf.length - 1; i10 >= 0; i10--) {
            byte b4 = (byte) ((buf[i10] + 1) & 255);
            buf[i10] = b4;
            if (b4 != 0) {
                return;
            }
        }
    }
}
