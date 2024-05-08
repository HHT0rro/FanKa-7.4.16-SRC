package java.security;

import java.nio.ByteBuffer;
import sun.security.jca.JCAUtil;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class MessageDigestSpi {
    private byte[] tempArray;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract byte[] engineDigest();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineReset();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineUpdate(byte b4);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void engineUpdate(byte[] bArr, int i10, int i11);

    /* JADX INFO: Access modifiers changed from: protected */
    public int engineGetDigestLength() {
        return 0;
    }

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
        int n10 = JCAUtil.getTempArraySize(len);
        byte[] bArr = this.tempArray;
        if (bArr == null || n10 > bArr.length) {
            this.tempArray = new byte[n10];
        }
        while (len > 0) {
            int chunk = Math.min(len, this.tempArray.length);
            input.get(this.tempArray, 0, chunk);
            engineUpdate(this.tempArray, 0, chunk);
            len -= chunk;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int engineDigest(byte[] buf, int offset, int len) throws DigestException {
        byte[] digest = engineDigest();
        if (len < digest.length) {
            throw new DigestException("partial digests not returned");
        }
        if (buf.length - offset < digest.length) {
            throw new DigestException("insufficient space in the output buffer to store the digest");
        }
        System.arraycopy((Object) digest, 0, (Object) buf, offset, digest.length);
        return digest.length;
    }

    public Object clone() throws CloneNotSupportedException {
        if (this instanceof Cloneable) {
            return super.clone();
        }
        throw new CloneNotSupportedException();
    }
}
