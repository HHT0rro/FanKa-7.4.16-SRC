package com.android.internal.org.bouncycastle.crypto.params;

import com.android.internal.org.bouncycastle.crypto.CipherParameters;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DSAParameters implements CipherParameters {

    /* renamed from: g, reason: collision with root package name */
    private BigInteger f9220g;

    /* renamed from: p, reason: collision with root package name */
    private BigInteger f9221p;

    /* renamed from: q, reason: collision with root package name */
    private BigInteger f9222q;
    private DSAValidationParameters validation;

    public DSAParameters(BigInteger p10, BigInteger q10, BigInteger g3) {
        this.f9220g = g3;
        this.f9221p = p10;
        this.f9222q = q10;
    }

    public DSAParameters(BigInteger p10, BigInteger q10, BigInteger g3, DSAValidationParameters params) {
        this.f9220g = g3;
        this.f9221p = p10;
        this.f9222q = q10;
        this.validation = params;
    }

    public BigInteger getP() {
        return this.f9221p;
    }

    public BigInteger getQ() {
        return this.f9222q;
    }

    public BigInteger getG() {
        return this.f9220g;
    }

    public DSAValidationParameters getValidationParameters() {
        return this.validation;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DSAParameters)) {
            return false;
        }
        DSAParameters pm = (DSAParameters) obj;
        return pm.getP().equals(this.f9221p) && pm.getQ().equals(this.f9222q) && pm.getG().equals(this.f9220g);
    }

    public int hashCode() {
        return (getP().hashCode() ^ getQ().hashCode()) ^ getG().hashCode();
    }
}
