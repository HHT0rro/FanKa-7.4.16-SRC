package java.security.spec;

import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class EdECPrivateKeySpec implements KeySpec {
    private final byte[] bytes;
    private final NamedParameterSpec params;

    public EdECPrivateKeySpec(NamedParameterSpec params, byte[] bytes) {
        Objects.requireNonNull(params, "params must not be null");
        Objects.requireNonNull(bytes, "bytes must not be null");
        this.params = params;
        this.bytes = (byte[]) bytes.clone();
    }

    public NamedParameterSpec getParams() {
        return this.params;
    }

    public byte[] getBytes() {
        return (byte[]) this.bytes.clone();
    }
}
