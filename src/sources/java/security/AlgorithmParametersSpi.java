package java.security;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AlgorithmParametersSpi {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract byte[] engineGetEncoded() throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract byte[] engineGetEncoded(String str) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract <T extends AlgorithmParameterSpec> T engineGetParameterSpec(Class<T> cls) throws InvalidParameterSpecException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(byte[] bArr) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(byte[] bArr, String str) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String engineToString();
}
