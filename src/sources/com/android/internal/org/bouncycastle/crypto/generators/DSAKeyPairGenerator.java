package com.android.internal.org.bouncycastle.crypto.generators;

import com.android.internal.org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import com.android.internal.org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import com.android.internal.org.bouncycastle.crypto.KeyGenerationParameters;
import com.android.internal.org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.android.internal.org.bouncycastle.crypto.params.DSAKeyGenerationParameters;
import com.android.internal.org.bouncycastle.crypto.params.DSAParameters;
import com.android.internal.org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import com.android.internal.org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import com.android.internal.org.bouncycastle.math.ec.WNafUtil;
import com.android.internal.org.bouncycastle.util.BigIntegers;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DSAKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private DSAKeyGenerationParameters param;

    @Override // com.android.internal.org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters param) {
        this.param = (DSAKeyGenerationParameters) param;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        DSAParameters dsaParams = this.param.getParameters();
        BigInteger x10 = generatePrivateKey(dsaParams.getQ(), this.param.getRandom());
        BigInteger y10 = calculatePublicKey(dsaParams.getP(), dsaParams.getG(), x10);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new DSAPublicKeyParameters(y10, dsaParams), (AsymmetricKeyParameter) new DSAPrivateKeyParameters(x10, dsaParams));
    }

    private static BigInteger generatePrivateKey(BigInteger q10, SecureRandom random) {
        BigInteger x10;
        int minWeight = q10.bitLength() >>> 2;
        do {
            BigInteger bigInteger = ONE;
            x10 = BigIntegers.createRandomInRange(bigInteger, q10.subtract(bigInteger), random);
        } while (WNafUtil.getNafWeight(x10) < minWeight);
        return x10;
    }

    private static BigInteger calculatePublicKey(BigInteger p10, BigInteger g3, BigInteger x10) {
        return g3.modPow(x10, p10);
    }
}
