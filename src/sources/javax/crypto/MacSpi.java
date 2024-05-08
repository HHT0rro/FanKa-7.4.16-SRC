package javax.crypto;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class MacSpi {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract byte[] engineDoFinal();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int engineGetMacLength();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineReset();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineUpdate(byte b4);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineUpdate(byte[] bArr, int i10, int i11);

    /* JADX INFO: Access modifiers changed from: protected */
    public void engineUpdate(ByteBuffer input) {
        if (!input.hasRemaining()) {
            return;
        }
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
        byte[] b10 = new byte[CipherSpi.getTempArraySize(len)];
        while (len > 0) {
            int chunk = Math.min(len, b10.length);
            input.get(b10, 0, chunk);
            engineUpdate(b10, 0, chunk);
            len -= chunk;
        }
    }

    public Object clone() throws CloneNotSupportedException {
        if (this instanceof Cloneable) {
            return super.clone();
        }
        throw new CloneNotSupportedException();
    }
}
