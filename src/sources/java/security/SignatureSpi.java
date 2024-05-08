package java.security;

import java.nio.ByteBuffer;
import java.security.spec.AlgorithmParameterSpec;
import sun.security.jca.JCAUtil;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class SignatureSpi {
    protected SecureRandom appRandom = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public abstract Object engineGetParameter(String str) throws InvalidParameterException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInitSign(PrivateKey privateKey) throws InvalidKeyException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInitVerify(PublicKey publicKey) throws InvalidKeyException;

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public abstract void engineSetParameter(String str, Object obj) throws InvalidParameterException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract byte[] engineSign() throws SignatureException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineUpdate(byte b4) throws SignatureException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineUpdate(byte[] bArr, int i10, int i11) throws SignatureException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean engineVerify(byte[] bArr) throws SignatureException;

    /* JADX INFO: Access modifiers changed from: protected */
    public void engineInitSign(PrivateKey privateKey, SecureRandom random) throws InvalidKeyException {
        this.appRandom = random;
        engineInitSign(privateKey);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void engineUpdate(ByteBuffer input) {
        if (!input.hasRemaining()) {
            return;
        }
        try {
            if (input.hasArray()) {
                byte[] b4 = input.array();
                int ofs = input.arrayOffset();
                int pos = input.position();
                int lim = input.limit();
                engineUpdate(b4, ofs + pos, lim - pos);
                input.position(lim);
                return;
            }
            int len = input.remaining();
            byte[] b10 = new byte[JCAUtil.getTempArraySize(len)];
            while (len > 0) {
                int chunk = Math.min(len, b10.length);
                input.get(b10, 0, chunk);
                engineUpdate(b10, 0, chunk);
                len -= chunk;
            }
        } catch (SignatureException e2) {
            throw new ProviderException("update() failed", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int engineSign(byte[] outbuf, int offset, int len) throws SignatureException {
        byte[] sig = engineSign();
        if (len < sig.length) {
            throw new SignatureException("partial signatures not returned");
        }
        if (outbuf.length - offset < sig.length) {
            throw new SignatureException("insufficient space in the output buffer to store the signature");
        }
        System.arraycopy((Object) sig, 0, (Object) outbuf, offset, sig.length);
        return sig.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean engineVerify(byte[] sigBytes, int offset, int length) throws SignatureException {
        byte[] sigBytesCopy = new byte[length];
        System.arraycopy((Object) sigBytes, offset, (Object) sigBytesCopy, 0, length);
        return engineVerify(sigBytesCopy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void engineSetParameter(AlgorithmParameterSpec params) throws InvalidAlgorithmParameterException {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AlgorithmParameters engineGetParameters() {
        throw new UnsupportedOperationException();
    }

    public Object clone() throws CloneNotSupportedException {
        if (this instanceof Cloneable) {
            return super.clone();
        }
        throw new CloneNotSupportedException();
    }
}
