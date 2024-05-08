package java.security.spec;

import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DSAPublicKeySpec implements KeySpec {

    /* renamed from: g, reason: collision with root package name */
    private BigInteger f50401g;

    /* renamed from: p, reason: collision with root package name */
    private BigInteger f50402p;

    /* renamed from: q, reason: collision with root package name */
    private BigInteger f50403q;

    /* renamed from: y, reason: collision with root package name */
    private BigInteger f50404y;

    public DSAPublicKeySpec(BigInteger y10, BigInteger p10, BigInteger q10, BigInteger g3) {
        this.f50404y = y10;
        this.f50402p = p10;
        this.f50403q = q10;
        this.f50401g = g3;
    }

    public BigInteger getY() {
        return this.f50404y;
    }

    public BigInteger getP() {
        return this.f50402p;
    }

    public BigInteger getQ() {
        return this.f50403q;
    }

    public BigInteger getG() {
        return this.f50401g;
    }
}
