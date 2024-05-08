package javax.crypto;

import java.nio.ByteBuffer;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.ProviderException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class CipherSpi {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int engineDoFinal(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract byte[] engineDoFinal(byte[] bArr, int i10, int i11) throws IllegalBlockSizeException, BadPaddingException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int engineGetBlockSize();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract byte[] engineGetIV();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int engineGetOutputSize(int i10);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract AlgorithmParameters engineGetParameters();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(int i10, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(int i10, Key key, SecureRandom secureRandom) throws InvalidKeyException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(int i10, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineSetMode(String str) throws NoSuchAlgorithmException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineSetPadding(String str) throws NoSuchPaddingException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int engineUpdate(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws ShortBufferException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract byte[] engineUpdate(byte[] bArr, int i10, int i11);

    /* JADX INFO: Access modifiers changed from: protected */
    public int engineUpdate(ByteBuffer input, ByteBuffer output) throws ShortBufferException {
        try {
            return bufferCrypt(input, output, true);
        } catch (BadPaddingException e2) {
            throw new ProviderException("Internal error in update()");
        } catch (IllegalBlockSizeException e10) {
            throw new ProviderException("Internal error in update()");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int engineDoFinal(ByteBuffer input, ByteBuffer output) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        return bufferCrypt(input, output, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getTempArraySize(int totalSize) {
        return Math.min(4096, totalSize);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:(1:42)(1:86)|43|(1:85)(1:47)|(1:(1:50)(7:78|79|80|54|(4:56|57|58|59)(1:74)|60|(3:63|(1:65)|66)(1:62)))(1:84)|51|52|53|54|(0)(0)|60|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x017d, code lost:
    
        r4 = engineGetOutputSize(r1);
        r18 = true;
        r16 = r4;
        r4 = new byte[r4];
        r2 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01a4, code lost:
    
        throw ((java.security.ProviderException) new java.security.ProviderException("Could not determine buffer size").initCause(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0174, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0175, code lost:
    
        r1 = r20;
        r5 = r22;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d3 A[LOOP:0: B:23:0x008d->B:32:0x00d3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0193 A[LOOP:1: B:41:0x00fd->B:62:0x0193, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x018d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0197 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x016e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int bufferCrypt(java.nio.ByteBuffer r25, java.nio.ByteBuffer r26, boolean r27) throws javax.crypto.ShortBufferException, javax.crypto.IllegalBlockSizeException, javax.crypto.BadPaddingException {
        /*
            Method dump skipped, instructions count: 460
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.crypto.CipherSpi.bufferCrypt(java.nio.ByteBuffer, java.nio.ByteBuffer, boolean):int");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Key engineUnwrap(byte[] wrappedKey, String wrappedKeyAlgorithm, int wrappedKeyType) throws InvalidKeyException, NoSuchAlgorithmException {
        throw new UnsupportedOperationException();
    }

    protected int engineGetKeySize(Key key) throws InvalidKeyException {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void engineUpdateAAD(byte[] src, int offset, int len) {
        throw new UnsupportedOperationException("The underlying Cipher implementation does not support this method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void engineUpdateAAD(ByteBuffer src) {
        throw new UnsupportedOperationException("The underlying Cipher implementation does not support this method");
    }
}
