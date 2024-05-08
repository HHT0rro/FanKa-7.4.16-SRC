package javax.crypto.spec;

import java.security.InvalidKeyException;
import java.security.spec.KeySpec;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DESedeKeySpec implements KeySpec {
    public static final int DES_EDE_KEY_LEN = 24;
    private byte[] key;

    public DESedeKeySpec(byte[] key) throws InvalidKeyException {
        this(key, 0);
    }

    public DESedeKeySpec(byte[] key, int offset) throws InvalidKeyException {
        if (key.length - offset < 24) {
            throw new InvalidKeyException("Wrong key size");
        }
        byte[] bArr = new byte[24];
        this.key = bArr;
        System.arraycopy((Object) key, offset, (Object) bArr, 0, 24);
    }

    public byte[] getKey() {
        return (byte[]) this.key.clone();
    }

    public static boolean isParityAdjusted(byte[] key, int offset) throws InvalidKeyException {
        if (key.length - offset < 24) {
            throw new InvalidKeyException("Wrong key size");
        }
        if (!DESKeySpec.isParityAdjusted(key, offset) || !DESKeySpec.isParityAdjusted(key, offset + 8) || !DESKeySpec.isParityAdjusted(key, offset + 16)) {
            return false;
        }
        return true;
    }
}
