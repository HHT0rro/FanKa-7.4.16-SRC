package com.android.internal.org.bouncycastle.crypto.params;

import com.android.internal.org.bouncycastle.asn1.x9.X9ECParameters;
import com.android.internal.org.bouncycastle.math.ec.ECAlgorithms;
import com.android.internal.org.bouncycastle.math.ec.ECConstants;
import com.android.internal.org.bouncycastle.math.ec.ECCurve;
import com.android.internal.org.bouncycastle.math.ec.ECPoint;
import com.android.internal.org.bouncycastle.util.Arrays;
import com.android.internal.org.bouncycastle.util.BigIntegers;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ECDomainParameters implements ECConstants {
    private final ECPoint G;
    private final ECCurve curve;

    /* renamed from: h, reason: collision with root package name */
    private final BigInteger f9225h;
    private BigInteger hInv;

    /* renamed from: n, reason: collision with root package name */
    private final BigInteger f9226n;
    private final byte[] seed;

    public ECDomainParameters(X9ECParameters x92) {
        this(x92.getCurve(), x92.getG(), x92.getN(), x92.getH(), x92.getSeed());
    }

    public ECDomainParameters(ECCurve curve, ECPoint G, BigInteger n10) {
        this(curve, G, n10, ONE, null);
    }

    public ECDomainParameters(ECCurve curve, ECPoint G, BigInteger n10, BigInteger h10) {
        this(curve, G, n10, h10, null);
    }

    public ECDomainParameters(ECCurve curve, ECPoint G, BigInteger n10, BigInteger h10, byte[] seed) {
        this.hInv = null;
        if (curve == null) {
            throw new NullPointerException("curve");
        }
        if (n10 == null) {
            throw new NullPointerException("n");
        }
        this.curve = curve;
        this.G = validatePublicPoint(curve, G);
        this.f9226n = n10;
        this.f9225h = h10;
        this.seed = Arrays.clone(seed);
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public ECPoint getG() {
        return this.G;
    }

    public BigInteger getN() {
        return this.f9226n;
    }

    public BigInteger getH() {
        return this.f9225h;
    }

    public synchronized BigInteger getHInv() {
        if (this.hInv == null) {
            this.hInv = BigIntegers.modOddInverseVar(this.f9226n, this.f9225h);
        }
        return this.hInv;
    }

    public byte[] getSeed() {
        return Arrays.clone(this.seed);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ECDomainParameters)) {
            return false;
        }
        ECDomainParameters other = (ECDomainParameters) obj;
        return this.curve.equals(other.curve) && this.G.equals(other.G) && this.f9226n.equals(other.f9226n);
    }

    public int hashCode() {
        int hc2 = 4 * 257;
        return ((((hc2 ^ this.curve.hashCode()) * 257) ^ this.G.hashCode()) * 257) ^ this.f9226n.hashCode();
    }

    public BigInteger validatePrivateScalar(BigInteger d10) {
        if (d10 == null) {
            throw new NullPointerException("Scalar cannot be null");
        }
        if (d10.compareTo(ECConstants.ONE) < 0 || d10.compareTo(getN()) >= 0) {
            throw new IllegalArgumentException("Scalar is not in the interval [1, n - 1]");
        }
        return d10;
    }

    public ECPoint validatePublicPoint(ECPoint q10) {
        return validatePublicPoint(getCurve(), q10);
    }

    static ECPoint validatePublicPoint(ECCurve c4, ECPoint q10) {
        if (q10 == null) {
            throw new NullPointerException("Point cannot be null");
        }
        ECPoint q11 = ECAlgorithms.importPoint(c4, q10).normalize();
        if (q11.isInfinity()) {
            throw new IllegalArgumentException("Point at infinity");
        }
        if (!q11.isValid()) {
            throw new IllegalArgumentException("Point not on curve");
        }
        return q11;
    }
}
