package javax.crypto.spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class RC2ParameterSpec implements AlgorithmParameterSpec {
    private int effectiveKeyBits;
    private byte[] iv;

    public RC2ParameterSpec(int effectiveKeyBits) {
        this.iv = null;
        this.effectiveKeyBits = effectiveKeyBits;
    }

    public RC2ParameterSpec(int effectiveKeyBits, byte[] iv) {
        this(effectiveKeyBits, iv, 0);
    }

    public RC2ParameterSpec(int effectiveKeyBits, byte[] iv, int offset) {
        this.iv = null;
        this.effectiveKeyBits = effectiveKeyBits;
        if (iv == null) {
            throw new IllegalArgumentException("IV missing");
        }
        if (iv.length - offset < 8) {
            throw new IllegalArgumentException("IV too short");
        }
        byte[] bArr = new byte[8];
        this.iv = bArr;
        System.arraycopy((Object) iv, offset, (Object) bArr, 0, 8);
    }

    public int getEffectiveKeyBits() {
        return this.effectiveKeyBits;
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
        if (!(obj instanceof RC2ParameterSpec)) {
            return false;
        }
        RC2ParameterSpec other = (RC2ParameterSpec) obj;
        return this.effectiveKeyBits == other.effectiveKeyBits && Arrays.equals(this.iv, other.iv);
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
        int i11 = this.effectiveKeyBits;
        return i11 + retval;
    }
}
