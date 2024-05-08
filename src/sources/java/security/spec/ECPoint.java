package java.security.spec;

import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ECPoint {
    public static final ECPoint POINT_INFINITY = new ECPoint();

    /* renamed from: x, reason: collision with root package name */
    private final BigInteger f50410x;

    /* renamed from: y, reason: collision with root package name */
    private final BigInteger f50411y;

    private ECPoint() {
        this.f50410x = null;
        this.f50411y = null;
    }

    public ECPoint(BigInteger x10, BigInteger y10) {
        if (x10 == null || y10 == null) {
            throw new NullPointerException("affine coordinate x or y is null");
        }
        this.f50410x = x10;
        this.f50411y = y10;
    }

    public BigInteger getAffineX() {
        return this.f50410x;
    }

    public BigInteger getAffineY() {
        return this.f50411y;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this != POINT_INFINITY && (obj instanceof ECPoint)) {
            return this.f50410x.equals(((ECPoint) obj).f50410x) && this.f50411y.equals(((ECPoint) obj).f50411y);
        }
        return false;
    }

    public int hashCode() {
        if (this == POINT_INFINITY) {
            return 0;
        }
        return this.f50410x.hashCode() << (this.f50411y.hashCode() + 5);
    }
}
