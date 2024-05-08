package javax.crypto.spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class ChaCha20ParameterSpec implements AlgorithmParameterSpec {
    private static final int NONCE_LENGTH = 12;
    private final int counter;
    private final byte[] nonce;

    public ChaCha20ParameterSpec(byte[] nonce, int counter) {
        this.counter = counter;
        Objects.requireNonNull(nonce, "Nonce must be non-null");
        byte[] bArr = (byte[]) nonce.clone();
        this.nonce = bArr;
        if (bArr.length != 12) {
            throw new IllegalArgumentException("Nonce must be 12-bytes in length");
        }
    }

    public byte[] getNonce() {
        return (byte[]) this.nonce.clone();
    }

    public int getCounter() {
        return this.counter;
    }
}
