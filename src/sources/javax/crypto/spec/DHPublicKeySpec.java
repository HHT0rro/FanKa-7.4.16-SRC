package javax.crypto.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DHPublicKeySpec implements KeySpec {

    /* renamed from: g, reason: collision with root package name */
    private BigInteger f50547g;

    /* renamed from: p, reason: collision with root package name */
    private BigInteger f50548p;

    /* renamed from: y, reason: collision with root package name */
    private BigInteger f50549y;

    public DHPublicKeySpec(BigInteger y10, BigInteger p10, BigInteger g3) {
        this.f50549y = y10;
        this.f50548p = p10;
        this.f50547g = g3;
    }

    public BigInteger getY() {
        return this.f50549y;
    }

    public BigInteger getP() {
        return this.f50548p;
    }

    public BigInteger getG() {
        return this.f50547g;
    }
}
