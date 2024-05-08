package java.security.spec;

import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ECPrivateKeySpec implements KeySpec {
    private ECParameterSpec params;

    /* renamed from: s, reason: collision with root package name */
    private BigInteger f50412s;

    public ECPrivateKeySpec(BigInteger s2, ECParameterSpec params) {
        if (s2 == null) {
            throw new NullPointerException("s is null");
        }
        if (params == null) {
            throw new NullPointerException("params is null");
        }
        this.f50412s = s2;
        this.params = params;
    }

    public BigInteger getS() {
        return this.f50412s;
    }

    public ECParameterSpec getParams() {
        return this.params;
    }
}
