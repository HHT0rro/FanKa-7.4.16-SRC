package javax.crypto.spec;

import java.security.spec.AlgorithmParameterSpec;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class GCMParameterSpec implements AlgorithmParameterSpec {
    private byte[] iv;
    private int tLen;

    public GCMParameterSpec(int tLen, byte[] src) {
        if (src == null) {
            throw new IllegalArgumentException("src array is null");
        }
        init(tLen, src, 0, src.length);
    }

    public GCMParameterSpec(int tLen, byte[] src, int offset, int len) {
        init(tLen, src, offset, len);
    }

    private void init(int tLen, byte[] src, int offset, int len) {
        if (tLen < 0) {
            throw new IllegalArgumentException("Length argument is negative");
        }
        this.tLen = tLen;
        if (src == null || len < 0 || offset < 0 || len > src.length - offset) {
            throw new IllegalArgumentException("Invalid buffer arguments");
        }
        byte[] bArr = new byte[len];
        this.iv = bArr;
        System.arraycopy((Object) src, offset, (Object) bArr, 0, len);
    }

    public int getTLen() {
        return this.tLen;
    }

    public byte[] getIV() {
        return (byte[]) this.iv.clone();
    }
}
