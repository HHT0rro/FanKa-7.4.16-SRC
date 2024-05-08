package java.security.spec;

import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class XECPrivateKeySpec implements KeySpec {
    private final AlgorithmParameterSpec params;
    private final byte[] scalar;

    public XECPrivateKeySpec(AlgorithmParameterSpec params, byte[] scalar) {
        Objects.requireNonNull(params, "params must not be null");
        Objects.requireNonNull(scalar, "scalar must not be null");
        this.params = params;
        this.scalar = (byte[]) scalar.clone();
    }

    public AlgorithmParameterSpec getParams() {
        return this.params;
    }

    public byte[] getScalar() {
        return (byte[]) this.scalar.clone();
    }
}
