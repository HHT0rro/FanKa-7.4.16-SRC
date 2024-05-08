package javax.crypto.spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class RC5ParameterSpec implements AlgorithmParameterSpec {
    private byte[] iv;
    private int rounds;
    private int version;
    private int wordSize;

    public RC5ParameterSpec(int version, int rounds, int wordSize) {
        this.iv = null;
        this.version = version;
        this.rounds = rounds;
        this.wordSize = wordSize;
    }

    public RC5ParameterSpec(int version, int rounds, int wordSize, byte[] iv) {
        this(version, rounds, wordSize, iv, 0);
    }

    public RC5ParameterSpec(int version, int rounds, int wordSize, byte[] iv, int offset) {
        this.iv = null;
        this.version = version;
        this.rounds = rounds;
        this.wordSize = wordSize;
        if (iv == null) {
            throw new IllegalArgumentException("IV missing");
        }
        int blockSize = (wordSize / 8) * 2;
        if (iv.length - offset < blockSize) {
            throw new IllegalArgumentException("IV too short");
        }
        byte[] bArr = new byte[blockSize];
        this.iv = bArr;
        System.arraycopy((Object) iv, offset, (Object) bArr, 0, blockSize);
    }

    public int getVersion() {
        return this.version;
    }

    public int getRounds() {
        return this.rounds;
    }

    public int getWordSize() {
        return this.wordSize;
    }

    public byte[] getIV() {
        byte[] bArr = this.iv;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RC5ParameterSpec)) {
            return false;
        }
        RC5ParameterSpec other = (RC5ParameterSpec) obj;
        return this.version == other.version && this.rounds == other.rounds && this.wordSize == other.wordSize && Arrays.equals(this.iv, other.iv);
    }

    public int hashCode() {
        int retval = 0;
        if (this.iv != null) {
            int i10 = 1;
            while (true) {
                byte[] bArr = this.iv;
                if (i10 >= bArr.length) {
                    break;
                }
                retval += bArr[i10] * i10;
                i10++;
            }
        }
        int i11 = this.version;
        return retval + i11 + this.rounds + this.wordSize;
    }
}
