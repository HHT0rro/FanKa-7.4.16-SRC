package com.android.internal.org.bouncycastle.asn1.x9;

import com.android.internal.org.bouncycastle.asn1.ASN1EncodableVector;
import com.android.internal.org.bouncycastle.asn1.ASN1Integer;
import com.android.internal.org.bouncycastle.asn1.ASN1Object;
import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.DERSequence;
import java.math.BigInteger;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class X9FieldID extends ASN1Object implements X9ObjectIdentifiers {

    /* renamed from: id, reason: collision with root package name */
    private ASN1ObjectIdentifier f9189id;
    private ASN1Primitive parameters;

    public X9FieldID(BigInteger primeP) {
        this.f9189id = prime_field;
        this.parameters = new ASN1Integer(primeP);
    }

    public X9FieldID(int m10, int k12) {
        this(m10, k12, 0, 0);
    }

    public X9FieldID(int m10, int k12, int k22, int k32) {
        this.f9189id = characteristic_two_field;
        ASN1EncodableVector fieldIdParams = new ASN1EncodableVector(3);
        fieldIdParams.add(new ASN1Integer(m10));
        if (k22 == 0) {
            if (k32 != 0) {
                throw new IllegalArgumentException("inconsistent k values");
            }
            fieldIdParams.add(tpBasis);
            fieldIdParams.add(new ASN1Integer(k12));
        } else {
            if (k22 <= k12 || k32 <= k22) {
                throw new IllegalArgumentException("inconsistent k values");
            }
            fieldIdParams.add(ppBasis);
            ASN1EncodableVector pentanomialParams = new ASN1EncodableVector(3);
            pentanomialParams.add(new ASN1Integer(k12));
            pentanomialParams.add(new ASN1Integer(k22));
            pentanomialParams.add(new ASN1Integer(k32));
            fieldIdParams.add(new DERSequence(pentanomialParams));
        }
        this.parameters = new DERSequence(fieldIdParams);
    }

    private X9FieldID(ASN1Sequence seq) {
        this.f9189id = ASN1ObjectIdentifier.getInstance(seq.getObjectAt(0));
        this.parameters = seq.getObjectAt(1).toASN1Primitive();
    }

    public static X9FieldID getInstance(Object obj) {
        if (obj instanceof X9FieldID) {
            return (X9FieldID) obj;
        }
        if (obj != null) {
            return new X9FieldID(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1ObjectIdentifier getIdentifier() {
        return this.f9189id;
    }

    public ASN1Primitive getParameters() {
        return this.parameters;
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Object, com.android.internal.org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v2 = new ASN1EncodableVector(2);
        v2.add(this.f9189id);
        v2.add(this.parameters);
        return new DERSequence(v2);
    }
}
