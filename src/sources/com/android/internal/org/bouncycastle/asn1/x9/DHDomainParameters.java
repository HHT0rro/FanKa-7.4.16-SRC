package com.android.internal.org.bouncycastle.asn1.x9;

import com.android.internal.org.bouncycastle.asn1.ASN1Encodable;
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
public class DHDomainParameters extends ASN1Object {

    /* renamed from: g, reason: collision with root package name */
    private ASN1Integer f9174g;

    /* renamed from: j, reason: collision with root package name */
    private ASN1Integer f9175j;

    /* renamed from: p, reason: collision with root package name */
    private ASN1Integer f9176p;

    /* renamed from: q, reason: collision with root package name */
    private ASN1Integer f9177q;
    private DHValidationParms validationParms;

    public static DHDomainParameters getInstance(ASN1TaggedObject obj, boolean explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    public static DHDomainParameters getInstance(Object obj) {
        if (obj == null || (obj instanceof DHDomainParameters)) {
            return (DHDomainParameters) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new DHDomainParameters((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid DHDomainParameters: " + obj.getClass().getName());
    }

    public DHDomainParameters(BigInteger p10, BigInteger g3, BigInteger q10, BigInteger j10, DHValidationParms validationParms) {
        if (p10 == null) {
            throw new IllegalArgumentException("'p' cannot be null");
        }
        if (g3 == null) {
            throw new IllegalArgumentException("'g' cannot be null");
        }
        if (q10 == null) {
            throw new IllegalArgumentException("'q' cannot be null");
        }
        this.f9176p = new ASN1Integer(p10);
        this.f9174g = new ASN1Integer(g3);
        this.f9177q = new ASN1Integer(q10);
        this.f9175j = new ASN1Integer(j10);
        this.validationParms = validationParms;
    }

    public DHDomainParameters(ASN1Integer p10, ASN1Integer g3, ASN1Integer q10, ASN1Integer j10, DHValidationParms validationParms) {
        if (p10 == null) {
            throw new IllegalArgumentException("'p' cannot be null");
        }
        if (g3 == null) {
            throw new IllegalArgumentException("'g' cannot be null");
        }
        if (q10 == null) {
            throw new IllegalArgumentException("'q' cannot be null");
        }
        this.f9176p = p10;
        this.f9174g = g3;
        this.f9177q = q10;
        this.f9175j = j10;
        this.validationParms = validationParms;
    }

    private DHDomainParameters(ASN1Sequence seq) {
        if (seq.size() < 3 || seq.size() > 5) {
            throw new IllegalArgumentException("Bad sequence size: " + seq.size());
        }
        Enumeration e2 = seq.getObjects();
        this.f9176p = ASN1Integer.getInstance(e2.nextElement());
        this.f9174g = ASN1Integer.getInstance(e2.nextElement());
        this.f9177q = ASN1Integer.getInstance(e2.nextElement());
        ASN1Encodable next = getNext(e2);
        if (next != null && (next instanceof ASN1Integer)) {
            this.f9175j = ASN1Integer.getInstance(next);
            next = getNext(e2);
        }
        if (next != null) {
            this.validationParms = DHValidationParms.getInstance(next.toASN1Primitive());
        }
    }

    private static ASN1Encodable getNext(Enumeration e2) {
        if (e2.hasMoreElements()) {
            return (ASN1Encodable) e2.nextElement();
        }
        return null;
    }

    public ASN1Integer getP() {
        return this.f9176p;
    }

    public ASN1Integer getG() {
        return this.f9174g;
    }

    public ASN1Integer getQ() {
        return this.f9177q;
    }

    public ASN1Integer getJ() {
        return this.f9175j;
    }

    public DHValidationParms getValidationParms() {
        return this.validationParms;
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Object, com.android.internal.org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v2 = new ASN1EncodableVector(5);
        v2.add(this.f9176p);
        v2.add(this.f9174g);
        v2.add(this.f9177q);
        ASN1Integer aSN1Integer = this.f9175j;
        if (aSN1Integer != null) {
            v2.add(aSN1Integer);
        }
        DHValidationParms dHValidationParms = this.validationParms;
        if (dHValidationParms != null) {
            v2.add(dHValidationParms);
        }
        return new DERSequence(v2);
    }
}
