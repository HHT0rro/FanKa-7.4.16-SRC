package com.android.internal.org.bouncycastle.crypto.signers;

import com.android.internal.org.bouncycastle.crypto.CipherParameters;
import com.android.internal.org.bouncycastle.crypto.CryptoServicesRegistrar;
import com.android.internal.org.bouncycastle.crypto.DSAExt;
import com.android.internal.org.bouncycastle.crypto.params.DSAKeyParameters;
import com.android.internal.org.bouncycastle.crypto.params.DSAParameters;
import com.android.internal.org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import com.android.internal.org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import com.android.internal.org.bouncycastle.crypto.params.ParametersWithRandom;
import com.android.internal.org.bouncycastle.util.BigIntegers;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DSASigner implements DSAExt {
    private final DSAKCalculator kCalculator;
    private DSAKeyParameters key;
    private SecureRandom random;

    public DSASigner() {
        this.kCalculator = new RandomDSAKCalculator();
    }

    public DSASigner(DSAKCalculator kCalculator) {
        this.kCalculator = kCalculator;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.DSA
    public void init(boolean forSigning, CipherParameters param) {
        SecureRandom providedRandom = null;
        if (forSigning) {
            if (param instanceof ParametersWithRandom) {
                ParametersWithRandom rParam = (ParametersWithRandom) param;
                this.key = (DSAPrivateKeyParameters) rParam.getParameters();
                providedRandom = rParam.getRandom();
            } else {
                this.key = (DSAPrivateKeyParameters) param;
            }
        } else {
            this.key = (DSAPublicKeyParameters) param;
        }
        this.random = initSecureRandom(forSigning && !this.kCalculator.isDeterministic(), providedRandom);
    }

    @Override // com.android.internal.org.bouncycastle.crypto.DSAExt
    public BigInteger getOrder() {
        return this.key.getParameters().getQ();
    }

    @Override // com.android.internal.org.bouncycastle.crypto.DSA
    public BigInteger[] generateSignature(byte[] message) {
        DSAParameters params = this.key.getParameters();
        BigInteger q10 = params.getQ();
        BigInteger m10 = calculateE(q10, message);
        BigInteger x10 = ((DSAPrivateKeyParameters) this.key).getX();
        if (this.kCalculator.isDeterministic()) {
            this.kCalculator.init(q10, x10, message);
        } else {
            this.kCalculator.init(q10, this.random);
        }
        BigInteger k10 = this.kCalculator.nextK();
        BigInteger r10 = params.getG().modPow(k10.add(getRandomizer(q10, this.random)), params.getP()).mod(q10);
        BigInteger s2 = BigIntegers.modOddInverse(q10, k10).multiply(m10.add(x10.multiply(r10))).mod(q10);
        return new BigInteger[]{r10, s2};
    }

    @Override // com.android.internal.org.bouncycastle.crypto.DSA
    public boolean verifySignature(byte[] message, BigInteger r10, BigInteger s2) {
        DSAParameters params = this.key.getParameters();
        BigInteger q10 = params.getQ();
        BigInteger m10 = calculateE(q10, message);
        BigInteger zero = BigInteger.valueOf(0L);
        if (zero.compareTo(r10) >= 0 || q10.compareTo(r10) <= 0 || zero.compareTo(s2) >= 0 || q10.compareTo(s2) <= 0) {
            return false;
        }
        BigInteger w3 = BigIntegers.modOddInverseVar(q10, s2);
        BigInteger u12 = m10.multiply(w3).mod(q10);
        BigInteger u22 = r10.multiply(w3).mod(q10);
        BigInteger p10 = params.getP();
        BigInteger v2 = params.getG().modPow(u12, p10).multiply(((DSAPublicKeyParameters) this.key).getY().modPow(u22, p10)).mod(p10).mod(q10);
        return v2.equals(r10);
    }

    private BigInteger calculateE(BigInteger n10, byte[] message) {
        if (n10.bitLength() >= message.length * 8) {
            return new BigInteger(1, message);
        }
        byte[] trunc = new byte[n10.bitLength() / 8];
        System.arraycopy((Object) message, 0, (Object) trunc, 0, trunc.length);
        return new BigInteger(1, trunc);
    }

    protected SecureRandom initSecureRandom(boolean needed, SecureRandom provided) {
        if (needed) {
            return CryptoServicesRegistrar.getSecureRandom(provided);
        }
        return null;
    }

    private BigInteger getRandomizer(BigInteger q10, SecureRandom provided) {
        return BigIntegers.createRandomBigInteger(7, CryptoServicesRegistrar.getSecureRandom(provided)).add(BigInteger.valueOf(128L)).multiply(q10);
    }
}
