package java.security.spec;

import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ECParameterSpec implements AlgorithmParameterSpec {
    private final EllipticCurve curve;
    private String curveName;

    /* renamed from: g, reason: collision with root package name */
    private final ECPoint f50407g;

    /* renamed from: h, reason: collision with root package name */
    private final int f50408h;

    /* renamed from: n, reason: collision with root package name */
    private final BigInteger f50409n;

    public ECParameterSpec(EllipticCurve curve, ECPoint g3, BigInteger n10, int h10) {
        if (curve == null) {
            throw new NullPointerException("curve is null");
        }
        if (g3 == null) {
            throw new NullPointerException("g is null");
        }
        if (n10 == null) {
            throw new NullPointerException("n is null");
        }
        if (n10.signum() != 1) {
            throw new IllegalArgumentException("n is not positive");
        }
        if (h10 <= 0) {
            throw new IllegalArgumentException("h is not positive");
        }
        this.curve = curve;
        this.f50407g = g3;
        this.f50409n = n10;
        this.f50408h = h10;
    }

    public EllipticCurve getCurve() {
        return this.curve;
    }

    public ECPoint getGenerator() {
        return this.f50407g;
    }

    public BigInteger getOrder() {
        return this.f50409n;
    }

    public int getCofactor() {
        return this.f50408h;
    }

    public void setCurveName(String curveName) {
        this.curveName = curveName;
    }

    public String getCurveName() {
        return this.curveName;
    }
}
