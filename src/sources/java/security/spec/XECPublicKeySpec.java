package java.security.spec;

import java.math.BigInteger;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class XECPublicKeySpec implements KeySpec {
    private final AlgorithmParameterSpec params;

    /* renamed from: u, reason: collision with root package name */
    private final BigInteger f50417u;

    public XECPublicKeySpec(AlgorithmParameterSpec params, BigInteger u10) {
        Objects.requireNonNull(params, "params must not be null");
        Objects.requireNonNull(u10, "u must not be null");
        this.params = params;
        this.f50417u = u10;
    }

    public AlgorithmParameterSpec getParams() {
        return this.params;
    }

    public BigInteger getU() {
        return this.f50417u;
    }
}
