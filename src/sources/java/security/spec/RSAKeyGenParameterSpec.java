package java.security.spec;

import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class RSAKeyGenParameterSpec implements AlgorithmParameterSpec {
    public static final BigInteger F0 = BigInteger.valueOf(3);
    public static final BigInteger F4 = BigInteger.valueOf(65537);
    private int keysize;
    private BigInteger publicExponent;

    public RSAKeyGenParameterSpec(int keysize, BigInteger publicExponent) {
        this.keysize = keysize;
        this.publicExponent = publicExponent;
    }

    public int getKeysize() {
        return this.keysize;
    }

    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }
}
