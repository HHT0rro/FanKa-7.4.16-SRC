package javax.crypto.spec;

import java.security.spec.AlgorithmParameterSpec;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PBEParameterSpec implements AlgorithmParameterSpec {
    private int iterationCount;
    private AlgorithmParameterSpec paramSpec;
    private byte[] salt;

    public PBEParameterSpec(byte[] salt, int iterationCount) {
        this.paramSpec = null;
        this.salt = (byte[]) salt.clone();
        this.iterationCount = iterationCount;
    }

    public PBEParameterSpec(byte[] salt, int iterationCount, AlgorithmParameterSpec paramSpec) {
        this.paramSpec = null;
        this.salt = (byte[]) salt.clone();
        this.iterationCount = iterationCount;
        this.paramSpec = paramSpec;
    }

    public byte[] getSalt() {
        return (byte[]) this.salt.clone();
    }

    public int getIterationCount() {
        return this.iterationCount;
    }

    public AlgorithmParameterSpec getParameterSpec() {
        return this.paramSpec;
    }
}
