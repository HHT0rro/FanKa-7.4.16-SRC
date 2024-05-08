package com.android.internal.org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DLApplicationSpecific extends ASN1ApplicationSpecific {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DLApplicationSpecific(boolean isConstructed, int tag, byte[] octets) {
        super(isConstructed, tag, octets);
    }

    public DLApplicationSpecific(int tag, byte[] octets) {
        this(false, tag, octets);
    }

    public DLApplicationSpecific(int tag, ASN1Encodable object) throws IOException {
        this(true, tag, object);
    }

    public DLApplicationSpecific(boolean constructed, int tag, ASN1Encodable object) throws IOException {
        super(constructed || object.toASN1Primitive().isConstructed(), tag, getEncoding(constructed, object));
    }

    private static byte[] getEncoding(boolean explicit, ASN1Encodable object) throws IOException {
        byte[] data = object.toASN1Primitive().getEncoded(ASN1Encoding.DL);
        if (explicit) {
            return data;
        }
        int lenBytes = getLengthOfHeader(data);
        byte[] tmp = new byte[data.length - lenBytes];
        System.arraycopy((Object) data, lenBytes, (Object) tmp, 0, tmp.length);
        return tmp;
    }

    public DLApplicationSpecific(int tagNo, ASN1EncodableVector vec) {
        super(true, tagNo, getEncodedVector(vec));
    }

    private static byte[] getEncodedVector(ASN1EncodableVector vec) {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        for (int i10 = 0; i10 != vec.size(); i10++) {
            try {
                bOut.write(((ASN1Object) vec.get(i10)).getEncoded(ASN1Encoding.DL));
            } catch (IOException e2) {
                throw new ASN1ParsingException("malformed object: " + ((Object) e2), e2);
            }
        }
        return bOut.toByteArray();
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1ApplicationSpecific, com.android.internal.org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream out, boolean withTag) throws IOException {
        int flags = 64;
        if (this.isConstructed) {
            flags = 64 | 32;
        }
        out.writeEncoded(withTag, flags, this.tag, this.octets);
    }
}
