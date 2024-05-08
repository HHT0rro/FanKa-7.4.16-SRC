package com.android.internal.org.bouncycastle.asn1;

import com.android.internal.org.bouncycastle.util.Arrays;
import com.android.internal.org.bouncycastle.util.io.Streams;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class ASN1BitString extends ASN1Primitive implements ASN1String {
    private static final char[] table = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    protected final byte[] data;
    protected final int padBits;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public abstract void encode(ASN1OutputStream aSN1OutputStream, boolean z10) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public static int getPadBits(int bitString) {
        int val = 0;
        int i10 = 3;
        while (true) {
            if (i10 < 0) {
                break;
            }
            if (i10 != 0) {
                if ((bitString >> (i10 * 8)) == 0) {
                    i10--;
                } else {
                    val = (bitString >> (i10 * 8)) & 255;
                    break;
                }
            } else if (bitString == 0) {
                i10--;
            } else {
                val = bitString & 255;
                break;
            }
        }
        if (val == 0) {
            return 0;
        }
        int bits = 1;
        while (true) {
            int i11 = val << 1;
            val = i11;
            if ((i11 & 255) != 0) {
                bits++;
            } else {
                return 8 - bits;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static byte[] getBytes(int bitString) {
        if (bitString == 0) {
            return new byte[0];
        }
        int bytes = 4;
        for (int i10 = 3; i10 >= 1 && ((255 << (i10 * 8)) & bitString) == 0; i10--) {
            bytes--;
        }
        byte[] result = new byte[bytes];
        for (int i11 = 0; i11 < bytes; i11++) {
            result[i11] = (byte) ((bitString >> (i11 * 8)) & 255);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ASN1BitString(byte data, int padBits) {
        if (padBits > 7 || padBits < 0) {
            throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
        }
        this.data = new byte[]{data};
        this.padBits = padBits;
    }

    public ASN1BitString(byte[] data, int padBits) {
        if (data == null) {
            throw new NullPointerException("'data' cannot be null");
        }
        if (data.length == 0 && padBits != 0) {
            throw new IllegalArgumentException("zero length data with non-zero pad bits");
        }
        if (padBits > 7 || padBits < 0) {
            throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
        }
        this.data = Arrays.clone(data);
        this.padBits = padBits;
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1String
    public String getString() {
        StringBuffer buf = new StringBuffer("#");
        try {
            byte[] string = getEncoded();
            for (int i10 = 0; i10 != string.length; i10++) {
                char[] cArr = table;
                buf.append(cArr[(string[i10] >>> 4) & 15]);
                buf.append(cArr[string[i10] & 15]);
            }
            return buf.toString();
        } catch (IOException e2) {
            throw new ASN1ParsingException("Internal error encoding BitString: " + e2.getMessage(), e2);
        }
    }

    public int intValue() {
        int value = 0;
        int end = Math.min(4, this.data.length - 1);
        for (int i10 = 0; i10 < end; i10++) {
            value |= (255 & this.data[i10]) << (i10 * 8);
        }
        if (end >= 0 && end < 4) {
            byte der = (byte) (this.data[end] & (255 << this.padBits));
            return value | ((der & 255) << (end * 8));
        }
        return value;
    }

    public byte[] getOctets() {
        if (this.padBits != 0) {
            throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");
        }
        return Arrays.clone(this.data);
    }

    public byte[] getBytes() {
        byte[] bArr = this.data;
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] rv = Arrays.clone(bArr);
        int length = this.data.length - 1;
        rv[length] = (byte) (rv[length] & (255 << this.padBits));
        return rv;
    }

    public int getPadBits() {
        return this.padBits;
    }

    public String toString() {
        return getString();
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive, com.android.internal.org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        byte[] bArr = this.data;
        int end = bArr.length - 1;
        if (end < 0) {
            return 1;
        }
        byte der = (byte) (bArr[end] & (255 << this.padBits));
        int hc2 = Arrays.hashCode(bArr, 0, end);
        return this.padBits ^ ((hc2 * 257) ^ der);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive o10) {
        if (!(o10 instanceof ASN1BitString)) {
            return false;
        }
        ASN1BitString other = (ASN1BitString) o10;
        if (this.padBits != other.padBits) {
            return false;
        }
        byte[] a10 = this.data;
        byte[] b4 = other.data;
        int end = a10.length;
        if (end != b4.length) {
            return false;
        }
        int end2 = end - 1;
        if (end2 < 0) {
            return true;
        }
        for (int i10 = 0; i10 < end2; i10++) {
            if (a10[i10] != b4[i10]) {
                return false;
            }
        }
        int i11 = a10[end2];
        int i12 = this.padBits;
        byte derA = (byte) (i11 & (255 << i12));
        byte derB = (byte) ((255 << i12) & b4[end2]);
        return derA == derB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ASN1BitString fromInputStream(int length, InputStream stream) throws IOException {
        if (length < 1) {
            throw new IllegalArgumentException("truncated BIT STRING detected");
        }
        int padBits = stream.read();
        byte[] data = new byte[length - 1];
        if (data.length != 0) {
            if (Streams.readFully(stream, data) != data.length) {
                throw new EOFException("EOF encountered in middle of BIT STRING");
            }
            if (padBits > 0 && padBits < 8 && data[data.length - 1] != ((byte) (data[data.length - 1] & (255 << padBits)))) {
                return new DLBitString(data, padBits);
            }
        }
        return new DERBitString(data, padBits);
    }

    public ASN1Primitive getLoadedObject() {
        return toASN1Primitive();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        return new DERBitString(this.data, this.padBits);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return new DLBitString(this.data, this.padBits);
    }
}
