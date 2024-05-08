package com.android.internal.org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class RSAPrivateCrtKeyParameters extends RSAKeyParameters {
    private BigInteger dP;
    private BigInteger dQ;

    /* renamed from: e, reason: collision with root package name */
    private BigInteger f9230e;

    /* renamed from: p, reason: collision with root package name */
    private BigInteger f9231p;

    /* renamed from: q, reason: collision with root package name */
    private BigInteger f9232q;
    private BigInteger qInv;

    public RSAPrivateCrtKeyParameters(BigInteger modulus, BigInteger publicExponent, BigInteger privateExponent, BigInteger p10, BigInteger q10, BigInteger dP, BigInteger dQ, BigInteger qInv) {
        super(true, modulus, privateExponent);
        this.f9230e = publicExponent;
        this.f9231p = p10;
        this.f9232q = q10;
        this.dP = dP;
        this.dQ = dQ;
        this.qInv = qInv;
    }

    public BigInteger getPublicExponent() {
        return this.f9230e;
    }

    public BigInteger getP() {
        return this.f9231p;
    }

    public BigInteger getQ() {
        return this.f9232q;
    }

    public BigInteger getDP() {
        return this.dP;
    }

    public BigInteger getDQ() {
        return this.dQ;
    }

    public BigInteger getQInv() {
        return this.qInv;
    }
}
