package javax.crypto;

import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class NullCipherSpi extends CipherSpi {
    @Override // javax.crypto.CipherSpi
    public void engineSetMode(String mode) {
    }

    @Override // javax.crypto.CipherSpi
    public void engineSetPadding(String padding) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public int engineGetOutputSize(int inputLen) {
        return inputLen;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        byte[] x10 = new byte[8];
        return x10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public void engineInit(int mode, Key key, SecureRandom random) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public void engineInit(int mode, Key key, AlgorithmParameterSpec params, SecureRandom random) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public void engineInit(int mode, Key key, AlgorithmParameters params, SecureRandom random) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] input, int inputOffset, int inputLen) {
        if (input == null) {
            return null;
        }
        byte[] x10 = new byte[inputLen];
        System.arraycopy((Object) input, inputOffset, (Object) x10, 0, inputLen);
        return x10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public int engineUpdate(byte[] input, int inputOffset, int inputLen, byte[] output, int outputOffset) {
        if (input == null) {
            return 0;
        }
        System.arraycopy((Object) input, inputOffset, (Object) output, outputOffset, inputLen);
        return inputLen;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] input, int inputOffset, int inputLen) {
        return engineUpdate(input, inputOffset, inputLen);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.crypto.CipherSpi
    public int engineDoFinal(byte[] input, int inputOffset, int inputLen, byte[] output, int outputOffset) {
        return engineUpdate(input, inputOffset, inputLen, output, outputOffset);
    }

    @Override // javax.crypto.CipherSpi
    protected int engineGetKeySize(Key key) {
        return 0;
    }
}
