package java.security.spec;

import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DSAPrivateKeySpec implements KeySpec {

    /* renamed from: g, reason: collision with root package name */
    private BigInteger f50397g;

    /* renamed from: p, reason: collision with root package name */
    private BigInteger f50398p;

    /* renamed from: q, reason: collision with root package name */
    private BigInteger f50399q;

    /* renamed from: x, reason: collision with root package name */
    private BigInteger f50400x;

    public DSAPrivateKeySpec(BigInteger x10, BigInteger p10, BigInteger q10, BigInteger g3) {
        this.f50400x = x10;
        this.f50398p = p10;
        this.f50399q = q10;
        this.f50397g = g3;
    }

    public BigInteger getX() {
        return this.f50400x;
    }

    public BigInteger getP() {
        return this.f50398p;
    }

    public BigInteger getQ() {
        return this.f50399q;
    }

    public BigInteger getG() {
        return this.f50397g;
    }
}
