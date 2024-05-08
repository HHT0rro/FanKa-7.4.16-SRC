package com.android.internal.org.bouncycastle.crypto.params;

import com.android.internal.org.bouncycastle.crypto.CipherParameters;
import com.android.internal.org.bouncycastle.util.Properties;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DHParameters implements CipherParameters {
    private static final int DEFAULT_MINIMUM_LENGTH = 160;

    /* renamed from: g, reason: collision with root package name */
    private BigInteger f9210g;

    /* renamed from: j, reason: collision with root package name */
    private BigInteger f9211j;

    /* renamed from: l, reason: collision with root package name */
    private int f9212l;

    /* renamed from: m, reason: collision with root package name */
    private int f9213m;

    /* renamed from: p, reason: collision with root package name */
    private BigInteger f9214p;

    /* renamed from: q, reason: collision with root package name */
    private BigInteger f9215q;
    private DHValidationParameters validation;

    private static int getDefaultMParam(int lParam) {
        if (lParam != 0 && lParam < 160) {
            return lParam;
        }
        return 160;
    }

    public DHParameters(BigInteger p10, BigInteger g3) {
        this(p10, g3, null, 0);
    }

    public DHParameters(BigInteger p10, BigInteger g3, BigInteger q10) {
        this(p10, g3, q10, 0);
    }

    public DHParameters(BigInteger p10, BigInteger g3, BigInteger q10, int l10) {
        this(p10, g3, q10, getDefaultMParam(l10), l10, null, null);
    }

    public DHParameters(BigInteger p10, BigInteger g3, BigInteger q10, int m10, int l10) {
        this(p10, g3, q10, m10, l10, null, null);
    }

    public DHParameters(BigInteger p10, BigInteger g3, BigInteger q10, BigInteger j10, DHValidationParameters validation) {
        this(p10, g3, q10, 160, 0, j10, validation);
    }

    public DHParameters(BigInteger p10, BigInteger g3, BigInteger q10, int m10, int l10, BigInteger j10, DHValidationParameters validation) {
        if (l10 != 0) {
            if (l10 > p10.bitLength()) {
                throw new IllegalArgumentException("when l value specified, it must satisfy 2^(l-1) <= p");
            }
            if (l10 < m10) {
                throw new IllegalArgumentException("when l value specified, it may not be less than m value");
            }
        }
        if (m10 > p10.bitLength() && !Properties.isOverrideSet("com.android.internal.org.bouncycastle.dh.allow_unsafe_p_value")) {
            throw new IllegalArgumentException("unsafe p value so small specific l required");
        }
        this.f9210g = g3;
        this.f9214p = p10;
        this.f9215q = q10;
        this.f9213m = m10;
        this.f9212l = l10;
        this.f9211j = j10;
        this.validation = validation;
    }

    public BigInteger getP() {
        return this.f9214p;
    }

    public BigInteger getG() {
        return this.f9210g;
    }

    public BigInteger getQ() {
        return this.f9215q;
    }

    public BigInteger getJ() {
        return this.f9211j;
    }

    public int getM() {
        return this.f9213m;
    }

    public int getL() {
        return this.f9212l;
    }

    public DHValidationParameters getValidationParameters() {
        return this.validation;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DHParameters)) {
            return false;
        }
        DHParameters pm = (DHParameters) obj;
        if (getQ() != null) {
            if (!getQ().equals(pm.getQ())) {
                return false;
            }
        } else if (pm.getQ() != null) {
            return false;
        }
        return pm.getP().equals(this.f9214p) && pm.getG().equals(this.f9210g);
    }

    public int hashCode() {
        return (getP().hashCode() ^ getG().hashCode()) ^ (getQ() != null ? getQ().hashCode() : 0);
    }
}
