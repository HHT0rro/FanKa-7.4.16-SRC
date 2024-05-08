package javax.crypto.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DHParameterSpec implements AlgorithmParameterSpec {

    /* renamed from: g, reason: collision with root package name */
    private BigInteger f50541g;

    /* renamed from: l, reason: collision with root package name */
    private int f50542l;

    /* renamed from: p, reason: collision with root package name */
    private BigInteger f50543p;

    public DHParameterSpec(BigInteger p10, BigInteger g3) {
        this.f50543p = p10;
        this.f50541g = g3;
        this.f50542l = 0;
    }

    public DHParameterSpec(BigInteger p10, BigInteger g3, int l10) {
        this.f50543p = p10;
        this.f50541g = g3;
        this.f50542l = l10;
    }

    public BigInteger getP() {
        return this.f50543p;
    }

    public BigInteger getG() {
        return this.f50541g;
    }

    public int getL() {
        return this.f50542l;
    }
}
