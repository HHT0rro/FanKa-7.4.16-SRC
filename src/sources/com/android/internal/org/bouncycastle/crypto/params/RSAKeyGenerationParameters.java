package com.android.internal.org.bouncycastle.crypto.params;

import com.android.internal.org.bouncycastle.crypto.KeyGenerationParameters;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class RSAKeyGenerationParameters extends KeyGenerationParameters {
    private int certainty;
    private BigInteger publicExponent;

    public RSAKeyGenerationParameters(BigInteger publicExponent, SecureRandom random, int strength, int certainty) {
        super(random, strength);
        if (strength < 12) {
            throw new IllegalArgumentException("key strength too small");
        }
        if (!publicExponent.testBit(0)) {
            throw new IllegalArgumentException("public exponent cannot be even");
        }
        this.publicExponent = publicExponent;
        this.certainty = certainty;
    }

    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }

    public int getCertainty() {
        return this.certainty;
    }
}
