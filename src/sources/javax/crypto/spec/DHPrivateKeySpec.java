package javax.crypto.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DHPrivateKeySpec implements KeySpec {

    /* renamed from: g, reason: collision with root package name */
    private BigInteger f50544g;

    /* renamed from: p, reason: collision with root package name */
    private BigInteger f50545p;

    /* renamed from: x, reason: collision with root package name */
    private BigInteger f50546x;

    public DHPrivateKeySpec(BigInteger x10, BigInteger p10, BigInteger g3) {
        this.f50546x = x10;
        this.f50545p = p10;
        this.f50544g = g3;
    }

    public BigInteger getX() {
        return this.f50546x;
    }

    public BigInteger getP() {
        return this.f50545p;
    }

    public BigInteger getG() {
        return this.f50544g;
    }
}
