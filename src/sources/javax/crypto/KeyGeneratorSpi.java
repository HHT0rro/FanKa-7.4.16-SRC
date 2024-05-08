package javax.crypto;

import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class KeyGeneratorSpi {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract SecretKey engineGenerateKey();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(int i10, SecureRandom secureRandom);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(SecureRandom secureRandom);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException;
}
