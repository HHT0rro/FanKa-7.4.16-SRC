package com.android.internal.org.bouncycastle.asn1.pkcs;

import com.android.internal.org.bouncycastle.asn1.ASN1EncodableVector;
import com.android.internal.org.bouncycastle.asn1.ASN1Integer;
import com.android.internal.org.bouncycastle.asn1.ASN1Object;
import com.android.internal.org.bouncycastle.asn1.ASN1Primitive;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.DERSequence;
import java.math.BigInteger;
import java.util.Enumeration;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DHParameter extends ASN1Object {

    /* renamed from: g, reason: collision with root package name */
    ASN1Integer f9162g;

    /* renamed from: l, reason: collision with root package name */
    ASN1Integer f9163l;

    /* renamed from: p, reason: collision with root package name */
    ASN1Integer f9164p;

    public DHParameter(BigInteger p10, BigInteger g3, int l10) {
        this.f9164p = new ASN1Integer(p10);
        this.f9162g = new ASN1Integer(g3);
        if (l10 != 0) {
            this.f9163l = new ASN1Integer(l10);
        } else {
            this.f9163l = null;
        }
    }

    public static DHParameter getInstance(Object obj) {
        if (obj instanceof DHParameter) {
            return (DHParameter) obj;
        }
        if (obj != null) {
            return new DHParameter(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    private DHParameter(ASN1Sequence seq) {
        Enumeration e2 = seq.getObjects();
        this.f9164p = ASN1Integer.getInstance(e2.nextElement());
        this.f9162g = ASN1Integer.getInstance(e2.nextElement());
        if (e2.hasMoreElements()) {
            this.f9163l = (ASN1Integer) e2.nextElement();
        } else {
            this.f9163l = null;
        }
    }

    public BigInteger getP() {
        return this.f9164p.getPositiveValue();
    }

    public BigInteger getG() {
        return this.f9162g.getPositiveValue();
    }

    public BigInteger getL() {
        ASN1Integer aSN1Integer = this.f9163l;
        if (aSN1Integer == null) {
            return null;
        }
        return aSN1Integer.getPositiveValue();
    }

    @Override // com.android.internal.org.bouncycastle.asn1.ASN1Object, com.android.internal.org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector v2 = new ASN1EncodableVector(3);
        v2.add(this.f9164p);
        v2.add(this.f9162g);
        if (getL() != null) {
            v2.add(this.f9163l);
        }
        return new DERSequence(v2);
    }
}
