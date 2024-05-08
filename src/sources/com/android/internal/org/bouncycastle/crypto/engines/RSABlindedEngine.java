package com.android.internal.org.bouncycastle.crypto.engines;

import com.android.internal.org.bouncycastle.crypto.AsymmetricBlockCipher;
import com.android.internal.org.bouncycastle.crypto.CipherParameters;
import com.android.internal.org.bouncycastle.crypto.CryptoServicesRegistrar;
import com.android.internal.org.bouncycastle.crypto.params.ParametersWithRandom;
import com.android.internal.org.bouncycastle.crypto.params.RSAKeyParameters;
import com.android.internal.org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import com.android.internal.org.bouncycastle.util.BigIntegers;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class RSABlindedEngine implements AsymmetricBlockCipher {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private RSACoreEngine core = new RSACoreEngine();
    private RSAKeyParameters key;
    private SecureRandom random;

    @Override // com.android.internal.org.bouncycastle.crypto.AsymmetricBlockCipher
    public void init(boolean forEncryption, CipherParameters param) {
        this.core.init(forEncryption, param);
        if (param instanceof ParametersWithRandom) {
            ParametersWithRandom rParam = (ParametersWithRandom) param;
            RSAKeyParameters rSAKeyParameters = (RSAKeyParameters) rParam.getParameters();
            this.key = rSAKeyParameters;
            if (rSAKeyParameters instanceof RSAPrivateCrtKeyParameters) {
                this.random = rParam.getRandom();
                return;
            } else {
                this.random = null;
                return;
            }
        }
        RSAKeyParameters rSAKeyParameters2 = (RSAKeyParameters) param;
        this.key = rSAKeyParameters2;
        if (rSAKeyParameters2 instanceof RSAPrivateCrtKeyParameters) {
            this.random = CryptoServicesRegistrar.getSecureRandom();
        } else {
            this.random = null;
        }
    }

    @Override // com.android.internal.org.bouncycastle.crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        return this.core.getInputBlockSize();
    }

    @Override // com.android.internal.org.bouncycastle.crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        return this.core.getOutputBlockSize();
    }

    @Override // com.android.internal.org.bouncycastle.crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] in, int inOff, int inLen) {
        BigInteger result;
        if (this.key == null) {
            throw new IllegalStateException("RSA engine not initialised");
        }
        BigInteger input = this.core.convertInput(in, inOff, inLen);
        RSAKeyParameters rSAKeyParameters = this.key;
        if (rSAKeyParameters instanceof RSAPrivateCrtKeyParameters) {
            RSAPrivateCrtKeyParameters k10 = (RSAPrivateCrtKeyParameters) rSAKeyParameters;
            BigInteger e2 = k10.getPublicExponent();
            if (e2 != null) {
                BigInteger m10 = k10.getModulus();
                BigInteger bigInteger = ONE;
                BigInteger r10 = BigIntegers.createRandomInRange(bigInteger, m10.subtract(bigInteger), this.random);
                BigInteger blindedInput = r10.modPow(e2, m10).multiply(input).mod(m10);
                BigInteger blindedResult = this.core.processBlock(blindedInput);
                BigInteger rInv = BigIntegers.modOddInverse(m10, r10);
                result = blindedResult.multiply(rInv).mod(m10);
                if (!input.equals(result.modPow(e2, m10))) {
                    throw new IllegalStateException("RSA engine faulty decryption/signing detected");
                }
            } else {
                result = this.core.processBlock(input);
            }
        } else {
            result = this.core.processBlock(input);
        }
        return this.core.convertOutput(result);
    }
}
