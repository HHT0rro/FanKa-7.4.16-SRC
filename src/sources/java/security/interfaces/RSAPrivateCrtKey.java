package java.security.interfaces;

import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface RSAPrivateCrtKey extends RSAPrivateKey {
    public static final long serialVersionUID = -5682214253527700368L;

    BigInteger getCrtCoefficient();

    BigInteger getPrimeExponentP();

    BigInteger getPrimeExponentQ();

    BigInteger getPrimeP();

    BigInteger getPrimeQ();

    BigInteger getPublicExponent();
}
