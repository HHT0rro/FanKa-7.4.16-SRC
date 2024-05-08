package com.android.internal.org.bouncycastle.util;

import com.android.internal.org.bouncycastle.crypto.Digest;
import com.android.internal.org.bouncycastle.crypto.digests.AndroidDigestFactory;
import com.huawei.openalliance.ad.constant.u;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class Fingerprint {
    private static char[] encodingTable = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private final byte[] fingerprint;

    public Fingerprint(byte[] source) {
        this(source, 160);
    }

    public Fingerprint(byte[] source, int bitLength) {
        this.fingerprint = calculateFingerprint(source, bitLength);
    }

    public byte[] getFingerprint() {
        return Arrays.clone(this.fingerprint);
    }

    public String toString() {
        StringBuffer sb2 = new StringBuffer();
        for (int i10 = 0; i10 != this.fingerprint.length; i10++) {
            if (i10 > 0) {
                sb2.append(u.bD);
            }
            sb2.append(encodingTable[(this.fingerprint[i10] >>> 4) & 15]);
            sb2.append(encodingTable[this.fingerprint[i10] & 15]);
        }
        return sb2.toString();
    }

    public boolean equals(Object o10) {
        if (o10 == this) {
            return true;
        }
        if (o10 instanceof Fingerprint) {
            return Arrays.areEqual(((Fingerprint) o10).fingerprint, this.fingerprint);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.fingerprint);
    }

    public static byte[] calculateFingerprint(byte[] input) {
        return calculateFingerprint(input, 160);
    }

    public static byte[] calculateFingerprint(byte[] input, int bitLength) {
        if (bitLength % 8 != 0) {
            throw new IllegalArgumentException("bitLength must be a multiple of 8");
        }
        Digest digest = AndroidDigestFactory.getSHA256();
        digest.update(input, 0, input.length);
        byte[] rv = new byte[bitLength / 8];
        byte[] untruncated = new byte[32];
        digest.doFinal(untruncated, 0);
        if (bitLength / 8 >= 32) {
            return untruncated;
        }
        System.arraycopy((Object) untruncated, 0, (Object) rv, 0, rv.length);
        return rv;
    }
}
