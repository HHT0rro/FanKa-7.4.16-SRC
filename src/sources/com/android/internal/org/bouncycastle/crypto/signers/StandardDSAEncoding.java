package com.android.internal.org.bouncycastle.crypto.signers;

import com.android.internal.org.bouncycastle.asn1.ASN1EncodableVector;
import com.android.internal.org.bouncycastle.asn1.ASN1Encoding;
import com.android.internal.org.bouncycastle.asn1.ASN1Integer;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.DERSequence;
import com.android.internal.org.bouncycastle.util.Arrays;
import java.io.IOException;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class StandardDSAEncoding implements DSAEncoding {
    public static final StandardDSAEncoding INSTANCE = new StandardDSAEncoding();

    @Override // com.android.internal.org.bouncycastle.crypto.signers.DSAEncoding
    public byte[] encode(BigInteger n10, BigInteger r10, BigInteger s2) throws IOException {
        ASN1EncodableVector v2 = new ASN1EncodableVector();
        encodeValue(n10, v2, r10);
        encodeValue(n10, v2, s2);
        return new DERSequence(v2).getEncoded(ASN1Encoding.DER);
    }

    @Override // com.android.internal.org.bouncycastle.crypto.signers.DSAEncoding
    public BigInteger[] decode(BigInteger n10, byte[] encoding) throws IOException {
        ASN1Sequence seq = (ASN1Sequence) ASN1Primitive.fromByteArray(encoding);
        if (seq.size() == 2) {
            BigInteger r10 = decodeValue(n10, seq, 0);
            BigInteger s2 = decodeValue(n10, seq, 1);
            byte[] expectedEncoding = encode(n10, r10, s2);
            if (Arrays.areEqual(expectedEncoding, encoding)) {
                return new BigInteger[]{r10, s2};
            }
        }
        throw new IllegalArgumentException("Malformed signature");
    }

    protected BigInteger checkValue(BigInteger n10, BigInteger x10) {
        if (x10.signum() < 0 || (n10 != null && x10.compareTo(n10) >= 0)) {
            throw new IllegalArgumentException("Value out of range");
        }
        return x10;
    }

    protected BigInteger decodeValue(BigInteger n10, ASN1Sequence s2, int pos) {
        return checkValue(n10, ((ASN1Integer) s2.getObjectAt(pos)).getValue());
    }

    protected void encodeValue(BigInteger n10, ASN1EncodableVector v2, BigInteger x10) {
        v2.add(new ASN1Integer(checkValue(n10, x10)));
    }
}
