package java.security.spec;

import java.math.BigInteger;
import java.security.interfaces.DSAParams;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DSAParameterSpec implements AlgorithmParameterSpec, DSAParams {

    /* renamed from: g, reason: collision with root package name */
    BigInteger f50394g;

    /* renamed from: p, reason: collision with root package name */
    BigInteger f50395p;

    /* renamed from: q, reason: collision with root package name */
    BigInteger f50396q;

    public DSAParameterSpec(BigInteger p10, BigInteger q10, BigInteger g3) {
        this.f50395p = p10;
        this.f50396q = q10;
        this.f50394g = g3;
    }

    @Override // java.security.interfaces.DSAParams
    public BigInteger getP() {
        return this.f50395p;
    }

    @Override // java.security.interfaces.DSAParams
    public BigInteger getQ() {
        return this.f50396q;
    }

    @Override // java.security.interfaces.DSAParams
    public BigInteger getG() {
        return this.f50394g;
    }
}
