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
public class DomainParameters extends ASN1Object {

    /* renamed from: g, reason: collision with root package name */
    private final ASN1Integer f9179g;

    /* renamed from: j, reason: collision with root package name */
    private final ASN1Integer f9180j;

    /* renamed from: p, reason: collision with root package name */
    private final ASN1Integer f9181p;

    /* renamed from: q, reason: collision with root package name */
    private final ASN1Integer f9182q;
    private final ValidationParams validationParams;

    public static DomainParameters getInstance(ASN1TaggedObject obj, boolean explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    public static DomainParameters getInstance(Object obj) {
        if (obj instanceof DomainParameters) {
            return (DomainParameters) obj;
        }
        if (obj != null) {
            return new DomainParameters(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public DomainParameters(BigInteger p10, BigInteger g3, BigInteger q10, BigInteger j10, ValidationParams validationParams) {
        if (p10 == null) {
            throw new IllegalArgumentException("'p' cannot be null");
        }
        if (g3 == null) {
            throw new IllegalArgumentException("'g' cannot be null");
        }
        if (q10 == null) {
            throw new IllegalArgumentException("'q' cannot be null");
        }
        this.f9181p = new ASN1Integer(p10);
        this.f9179g = new ASN1Integer(g3);
        this.f9182q = new ASN1Integer(q10);
        if (j10 != null) {
            this.f9180j = new ASN1Integer(j10);
        } else {
            this.f9180j = null;
        }
        this.validationParams = validationParams;
    }

    private DomainParameters(ASN1Sequence seq) {
        if (seq.size() < 3 || seq.size() > 5) {
            throw new IllegalArgumentException("Bad sequence size: " + seq.size());
        }
        Enumeration e2 = seq.getObjects();
        this.f9181p = ASN1Integer.getInstance(e2.nextElement());
        this.f9179g = ASN1Integer.getInstance(e2.nextElement());
        this.f9182q = ASN1Integer.getInstance(e2.nextElement());
        ASN1Encodable next = getNext(e2);
        if (next != null && (next instanceof ASN1Integer)) {
            this.f9180j = ASN1Integer.getInstance(next);
            next = getNext(e2);
        } else {
            this.f9180j = null;
        }
        if (next != null) {
            this.validationParams = ValidationParams.getInstance(next.toASN1Primitive());
        } else {
            this.validationParams = null;
        }
    }

    private static ASN1Encodable getNext(Enumeration e2) {
        if (e2.hasMoreElements()) {
            return (ASN1Encodable) e2.nextElement();
        }
        return null;
    }

    public BigInteger getP() {
        return this.f9181p.getPositiveValue();
    }

    public BigInteger getG() {
        return this.f9179g.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.f9182q.getPositiveValue();
    }

    public BigInteger getJ() {
        ASN1Integer aSN1Integer = this.f9180j;
        if (aSN1Integer == null) {
            return null;
        }
        return aSN1Integer.getPositiveValue();
    }

    public ValidationParams getValidationParams() {
        return this.validationParams;
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Object, com.android.internal.org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v2 = new ASN1EncodableVector(5);
        v2.add(this.f9181p);
        v2.add(this.f9179g);
        v2.add(this.f9182q);
        ASN1Integer aSN1Integer = this.f9180j;
        if (aSN1Integer != null) {
            v2.add(aSN1Integer);
        }
        ValidationParams validationParams = this.validationParams;
        if (validationParams != null) {
            v2.add(validationParams);
        }
        return new DERSequence(v2);
    }
}
