package com.android.internal.org.bouncycastle.asn1.sec;

import com.android.internal.org.bouncycastle.asn1.ASN1Encodable;
import com.android.internal.org.bouncycastle.asn1.ASN1EncodableVector;
import com.android.internal.org.bouncycastle.asn1.ASN1Integer;
import com.android.internal.org.bouncycastle.asn1.ASN1Object;
import com.android.internal.org.bouncycastle.asn1.ASN1OctetString;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.ASN1TaggedObject;
import com.android.internal.org.bouncycastle.asn1.DERBitString;
import com.android.internal.org.bouncycastle.asn1.DEROctetString;
import com.android.internal.org.bouncycastle.asn1.DERSequence;
import com.android.internal.org.bouncycastle.asn1.DERTaggedObject;
import com.android.internal.org.bouncycastle.util.BigIntegers;
import java.math.BigInteger;
import java.util.Enumeration;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ECPrivateKeyStructure extends ASN1Object {
    private ASN1Sequence seq;

    public ECPrivateKeyStructure(ASN1Sequence seq) {
        this.seq = seq;
    }

    public ECPrivateKeyStructure(BigInteger key) {
        byte[] bytes = BigIntegers.asUnsignedByteArray(key);
        ASN1EncodableVector v2 = new ASN1EncodableVector(2);
        v2.add(new ASN1Integer(1L));
        v2.add(new DEROctetString(bytes));
        this.seq = new DERSequence(v2);
    }

    public ECPrivateKeyStructure(BigInteger key, ASN1Encodable parameters) {
        this(key, null, parameters);
    }

    public ECPrivateKeyStructure(BigInteger key, DERBitString publicKey, ASN1Encodable parameters) {
        byte[] bytes = BigIntegers.asUnsignedByteArray(key);
        ASN1EncodableVector v2 = new ASN1EncodableVector(4);
        v2.add(new ASN1Integer(1L));
        v2.add(new DEROctetString(bytes));
        if (parameters != null) {
            v2.add(new DERTaggedObject(true, 0, parameters));
        }
        if (publicKey != null) {
            v2.add(new DERTaggedObject(true, 1, publicKey));
        }
        this.seq = new DERSequence(v2);
    }

    public BigInteger getKey() {
        ASN1OctetString octs = (ASN1OctetString) this.seq.getObjectAt(1);
        return new BigInteger(1, octs.getOctets());
    }

    public DERBitString getPublicKey() {
        return (DERBitString) getObjectInTag(1);
    }

    public ASN1Primitive getParameters() {
        return getObjectInTag(0);
    }

    private ASN1Primitive getObjectInTag(int tagNo) {
        Enumeration e2 = this.seq.getObjects();
        while (e2.hasMoreElements()) {
            ASN1Encodable obj = (ASN1Encodable) e2.nextElement();
            if (obj instanceof ASN1TaggedObject) {
                ASN1TaggedObject tag = (ASN1TaggedObject) obj;
                if (tag.getTagNo() == tagNo) {
                    return tag.getObject().toASN1Primitive();
                }
            }
        }
        return null;
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Object, com.android.internal.org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.seq;
    }
}