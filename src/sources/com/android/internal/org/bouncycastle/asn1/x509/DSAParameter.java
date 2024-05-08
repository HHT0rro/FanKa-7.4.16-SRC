package com.android.internal.org.bouncycastle.asn1.x509;

import com.android.internal.org.bouncycastle.asn1.ASN1EncodableVector;
import com.android.internal.org.bouncycastle.asn1.ASN1Integer;
import com.android.internal.org.bouncycastle.asn1.ASN1Object;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.ASN1TaggedObject;
import com.android.internal.org.bouncycastle.asn1.DERSequence;
import java.math.BigInteger;
import java.util.Enumeration;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DSAParameter extends ASN1Object {

    /* renamed from: g, reason: collision with root package name */
    ASN1Integer f9170g;

    /* renamed from: p, reason: collision with root package name */
    ASN1Integer f9171p;

    /* renamed from: q, reason: collision with root package name */
    ASN1Integer f9172q;

    public static DSAParameter getInstance(ASN1TaggedObject obj, boolean explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    public static DSAParameter getInstance(Object obj) {
        if (obj instanceof DSAParameter) {
            return (DSAParameter) obj;
        }
        if (obj != null) {
            return new DSAParameter(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public DSAParameter(BigInteger p10, BigInteger q10, BigInteger g3) {
        this.f9171p = new ASN1Integer(p10);
        this.f9172q = new ASN1Integer(q10);
        this.f9170g = new ASN1Integer(g3);
    }

    private DSAParameter(ASN1Sequence seq) {
        if (seq.size() != 3) {
            throw new IllegalArgumentException("Bad sequence size: " + seq.size());
        }
        Enumeration e2 = seq.getObjects();
        this.f9171p = ASN1Integer.getInstance(e2.nextElement());
        this.f9172q = ASN1Integer.getInstance(e2.nextElement());
        this.f9170g = ASN1Integer.getInstance(e2.nextElement());
    }

    public BigInteger getP() {
        return this.f9171p.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.f9172q.getPositiveValue();
    }

    public BigInteger getG() {
        return this.f9170g.getPositiveValue();
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Object, com.android.internal.org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v2 = new ASN1EncodableVector(3);
        v2.add(this.f9171p);
        v2.add(this.f9172q);
        v2.add(this.f9170g);
        return new DERSequence(v2);
    }
}
