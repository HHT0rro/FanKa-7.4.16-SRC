package com.android.internal.org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DSAPublicKeyParameters extends DSAKeyParameters {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);

    /* renamed from: y, reason: collision with root package name */
    private BigInteger f9224y;

    public DSAPublicKeyParameters(BigInteger y10, DSAParameters params) {
        super(false, params);
        this.f9224y = validate(y10, params);
    }

    private BigInteger validate(BigInteger y10, DSAParameters params) {
        if (params != null) {
            BigInteger bigInteger = TWO;
            if (bigInteger.compareTo(y10) <= 0 && params.getP().subtract(bigInteger).compareTo(y10) >= 0 && ONE.equals(y10.modPow(params.getQ(), params.getP()))) {
                return y10;
            }
            throw new IllegalArgumentException("y value does not appear to be in correct group");
        }
        return y10;
    }

    public BigInteger getY() {
        return this.f9224y;
    }
}
