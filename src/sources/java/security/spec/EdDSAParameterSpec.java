package java.security.spec;

import java.security.InvalidParameterException;
import java.util.Objects;
import java.util.Optional;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class EdDSAParameterSpec implements AlgorithmParameterSpec {
    private final byte[] context;
    private final boolean prehash;

    public EdDSAParameterSpec(boolean prehash) {
        this.prehash = prehash;
        this.context = null;
    }

    public EdDSAParameterSpec(boolean prehash, byte[] context) {
        Objects.requireNonNull(context, "context may not be null");
        if (context.length > 255) {
            throw new InvalidParameterException("context length cannot be greater than 255");
        }
        this.prehash = prehash;
        this.context = (byte[]) context.clone();
    }

    public boolean isPrehash() {
        return this.prehash;
    }

    public Optional<byte[]> getContext() {
        byte[] bArr = this.context;
        if (bArr == null) {
            return Optional.empty();
        }
        return Optional.of((byte[]) bArr.clone());
    }
}
