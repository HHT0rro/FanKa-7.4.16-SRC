package com.android.internal.org.bouncycastle.asn1;

import com.android.internal.org.bouncycastle.util.Arrays;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DERBMPString extends ASN1Primitive implements ASN1String {
    private final char[] string;

    public static DERBMPString getInstance(Object obj) {
        if (obj == null || (obj instanceof DERBMPString)) {
            return (DERBMPString) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (DERBMPString) fromByteArray((byte[]) obj);
            } catch (Exception e2) {
                throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
            }
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static DERBMPString getInstance(ASN1TaggedObject obj, boolean explicit) {
        ASN1Primitive o10 = obj.getObject();
        if (explicit || (o10 instanceof DERBMPString)) {
            return getInstance(o10);
        }
        return new DERBMPString(ASN1OctetString.getInstance(o10).getOctets());
    }

    DERBMPString(byte[] string) {
        if (string == null) {
            throw new NullPointerException("'string' cannot be null");
        }
        int byteLen = string.length;
        if ((byteLen & 1) != 0) {
            throw new IllegalArgumentException("malformed BMPString encoding encountered");
        }
        int charLen = byteLen / 2;
        char[] cs = new char[charLen];
        for (int i10 = 0; i10 != charLen; i10++) {
            cs[i10] = (char) ((string[i10 * 2] << 8) | (string[(i10 * 2) + 1] & 255));
        }
        this.string = cs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DERBMPString(char[] string) {
        if (string == null) {
            throw new NullPointerException("'string' cannot be null");
        }
        this.string = string;
    }

    public DERBMPString(String string) {
        if (string == null) {
            throw new NullPointerException("'string' cannot be null");
        }
        this.string = string.toCharArray();
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1String
    public String getString() {
        return new String(this.string);
    }

    public String toString() {
        return getString();
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive, com.android.internal.org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return Arrays.hashCode(this.string);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive o10) {
        if (!(o10 instanceof DERBMPString)) {
            return false;
        }
        DERBMPString s2 = (DERBMPString) o10;
        return Arrays.areEqual(this.string, s2.string);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength() {
        return StreamUtil.calculateBodyLength(this.string.length * 2) + 1 + (this.string.length * 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream out, boolean withTag) throws IOException {
        int count = this.string.length;
        if (withTag) {
            out.write(30);
        }
        out.writeLength(count * 2);
        byte[] buf = new byte[8];
        int i10 = 0;
        int limit = count & (-4);
        while (i10 < limit) {
            char[] cArr = this.string;
            char c02 = cArr[i10];
            char c12 = cArr[i10 + 1];
            char c22 = cArr[i10 + 2];
            char c32 = cArr[i10 + 3];
            i10 += 4;
            buf[0] = (byte) (c02 >> '\b');
            buf[1] = (byte) c02;
            buf[2] = (byte) (c12 >> '\b');
            buf[3] = (byte) c12;
            buf[4] = (byte) (c22 >> '\b');
            buf[5] = (byte) c22;
            buf[6] = (byte) (c32 >> '\b');
            buf[7] = (byte) c32;
            out.write(buf, 0, 8);
        }
        if (i10 < count) {
            int bufPos = 0;
            do {
                char c03 = this.string[i10];
                i10++;
                int bufPos2 = bufPos + 1;
                buf[bufPos] = (byte) (c03 >> '\b');
                bufPos = bufPos2 + 1;
                buf[bufPos2] = (byte) c03;
            } while (i10 < count);
            out.write(buf, 0, bufPos);
        }
    }
}
