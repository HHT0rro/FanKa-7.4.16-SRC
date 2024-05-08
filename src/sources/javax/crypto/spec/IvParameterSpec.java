package javax.crypto.spec;

import java.security.spec.AlgorithmParameterSpec;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class IvParameterSpec implements AlgorithmParameterSpec {
    private byte[] iv;

    public IvParameterSpec(byte[] iv) {
        this(iv, 0, iv.length);
    }

    public IvParameterSpec(byte[] iv, int offset, int len) {
        if (iv == null) {
            throw new IllegalArgumentException("IV missing");
        }
        if (offset < 0) {
            throw new ArrayIndexOutOfBoundsException("offset is negative");
        }
        if (len < 0) {
            throw new ArrayIndexOutOfBoundsException("len is negative");
        }
        if (iv.length - offset < len) {
            throw new IllegalArgumentException("IV buffer too short for given offset/length combination");
        }
        byte[] bArr = new byte[len];
        this.iv = bArr;
        System.arraycopy((Object) iv, offset, (Object) bArr, 0, len);
    }

    public byte[] getIV() {
        return (byte[]) this.iv.clone();
    }
}
