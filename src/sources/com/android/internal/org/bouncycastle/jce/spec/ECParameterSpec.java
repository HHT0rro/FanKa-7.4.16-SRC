package com.android.internal.org.bouncycastle.jce.spec;

import com.android.internal.org.bouncycastle.math.ec.ECCurve;
import com.android.internal.org.bouncycastle.math.ec.ECPoint;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ECParameterSpec implements AlgorithmParameterSpec {
    private ECPoint G;
    private ECCurve curve;

    /* renamed from: h, reason: collision with root package name */
    private BigInteger f9259h;

    /* renamed from: n, reason: collision with root package name */
    private BigInteger f9260n;
    private byte[] seed;

    public ECParameterSpec(ECCurve curve, ECPoint G, BigInteger n10) {
        this.curve = curve;
        this.G = G.normalize();
        this.f9260n = n10;
        this.f9259h = BigInteger.valueOf(1L);
        this.seed = null;
    }

    public ECParameterSpec(ECCurve curve, ECPoint G, BigInteger n10, BigInteger h10) {
        this.curve = curve;
        this.G = G.normalize();
        this.f9260n = n10;
        this.f9259h = h10;
        this.seed = null;
    }

    public ECParameterSpec(ECCurve curve, ECPoint G, BigInteger n10, BigInteger h10, byte[] seed) {
        this.curve = curve;
        this.G = G.normalize();
        this.f9260n = n10;
        this.f9259h = h10;
        this.seed = seed;
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public ECPoint getG() {
        return this.G;
    }

    public BigInteger getN() {
        return this.f9260n;
    }

    public BigInteger getH() {
        return this.f9259h;
    }

    public byte[] getSeed() {
        return this.seed;
    }

    public boolean equals(Object o10) {
        if (!(o10 instanceof ECParameterSpec)) {
            return false;
        }
        ECParameterSpec other = (ECParameterSpec) o10;
        return getCurve().equals(other.getCurve()) && getG().equals(other.getG());
    }

    public int hashCode() {
        return getCurve().hashCode() ^ getG().hashCode();
    }
}
