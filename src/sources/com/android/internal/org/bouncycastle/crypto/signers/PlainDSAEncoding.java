package com.android.internal.org.bouncycastle.crypto.signers;

import com.android.internal.org.bouncycastle.util.Arrays;
import com.android.internal.org.bouncycastle.util.BigIntegers;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class PlainDSAEncoding implements DSAEncoding {
    public static final PlainDSAEncoding INSTANCE = new PlainDSAEncoding();

    @Override // com.android.internal.org.bouncycastle.crypto.signers.DSAEncoding
    public byte[] encode(BigInteger n10, BigInteger r10, BigInteger s2) {
        int valueLength = BigIntegers.getUnsignedByteLength(n10);
        byte[] result = new byte[valueLength * 2];
        encodeValue(n10, r10, result, 0, valueLength);
        encodeValue(n10, s2, result, valueLength, valueLength);
        return result;
    }

    @Override // com.android.internal.org.bouncycastle.crypto.signers.DSAEncoding
    public BigInteger[] decode(BigInteger n10, byte[] encoding) {
        int valueLength = BigIntegers.getUnsignedByteLength(n10);
        if (encoding.length != valueLength * 2) {
            throw new IllegalArgumentException("Encoding has incorrect length");
        }
        return new BigInteger[]{decodeValue(n10, encoding, 0, valueLength), decodeValue(n10, encoding, valueLength, valueLength)};
    }

    protected BigInteger checkValue(BigInteger n10, BigInteger x10) {
        if (x10.signum() < 0 || x10.compareTo(n10) >= 0) {
            throw new IllegalArgumentException("Value out of range");
        }
        return x10;
    }

    protected BigInteger decodeValue(BigInteger n10, byte[] buf, int off, int len) {
        byte[] bs = Arrays.copyOfRange(buf, off, off + len);
        return checkValue(n10, new BigInteger(1, bs));
    }

    private void encodeValue(BigInteger n10, BigInteger x10, byte[] buf, int off, int len) {
        byte[] bs = checkValue(n10, x10).toByteArray();
        int bsOff = Math.max(0, bs.length - len);
        int bsLen = bs.length - bsOff;
        int pos = len - bsLen;
        Arrays.fill(buf, off, off + pos, (byte) 0);
        System.arraycopy((Object) bs, bsOff, (Object) buf, off + pos, bsLen);
    }
}
