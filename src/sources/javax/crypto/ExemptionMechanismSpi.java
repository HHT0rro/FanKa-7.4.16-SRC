package javax.crypto;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class ExemptionMechanismSpi {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int engineGenExemptionBlob(byte[] bArr, int i10) throws ShortBufferException, ExemptionMechanismException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract byte[] engineGenExemptionBlob() throws ExemptionMechanismException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int engineGetOutputSize(int i10);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(Key key) throws InvalidKeyException, ExemptionMechanismException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(Key key, AlgorithmParameters algorithmParameters) throws InvalidKeyException, InvalidAlgorithmParameterException, ExemptionMechanismException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException, ExemptionMechanismException;
}
